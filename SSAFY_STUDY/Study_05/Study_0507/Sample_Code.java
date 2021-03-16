package Study_0507;

import java.net.*;
import java.io.*;
import java.util.*;

public class Sample_Code {

	static final String NICKNAME = "Java Player";
	static final String HOST = "127.0.0.1";
	static final int PORT = 1447; // Do not modify

	// predefined variables(Do not modify these values)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.");
			int cnt = 0;
			while (socket != null) {
				cnt++;
				bytes = new byte[1024];

				int readByteCount = is.read(bytes);
				recv_data = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				String[] split_data = recv_data.split("/");
				if (split_data[0].equals("9909"))
					break;

				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = new byte[1024];
					balls = new int[NUMBER_OF_BALLS][2];
					bytes = "9902/9902".getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}
				int ballc = 0;
				for (int i = 1; i < NUMBER_OF_BALLS; i++) { // 현재남은 당구공중에 가장 인덱스가 낮은 것.
					if (balls[i][0] != -1) {
						ballc = i;
						break;
					}
				}
				
				System.out.println(balls[ballc][0] + " ," +balls[ballc][1] );

				double power = 0;
				double angle = 0;
				double xgap =  balls[ballc][0] - balls[0][0];
				double ygap =  balls[ballc][1] - balls[0][1];

				
				double length = Math.sqrt(Math.pow(xgap, 2) + Math.pow(ygap, 2));

				angle = (360 + (Math.atan2(xgap, ygap) * 180) / Math.PI) + 1.3;
				if (angle > 360)
					angle -= 360;
				
				power = length / 2.0;

				if (length < 30)
					power += 20;

				String merged_data = angle + "/" + power;
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
