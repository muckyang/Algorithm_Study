package Study_0507;

import java.net.*;
import java.io.*;
import java.util.*;

public class Sample_Code2 {
	 // User and Game Server Information
    static final String NICKNAME = "Java Player";
    static final String HOST = "127.0.0.1";
    static final int PORT = 1447; // Do not modify
    
    // predefined variables(Do not modify these values)
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 5;
    static final int[][] HOLES = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};
    
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
          
          while (socket != null) {
             
             bytes = new byte[1024];
             
             int readByteCount = is.read(bytes);
             recv_data = new String(bytes, 0, readByteCount, "UTF-8");
             System.out.println("Data Received: " + recv_data);
             
             String[] split_data = recv_data.split("/");
             if (split_data[0].equals("9909")) break;
             
             int idx = 0;
             try {
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                   for (int j = 0; j < 2; j++) {
                      balls[i][j] = Integer.parseInt(split_data[idx++]);
                   }
                }
             }
             catch (Exception e) {
                bytes = new byte[1024];
                balls = new int[NUMBER_OF_BALLS][2];
                bytes = "9902/9902".getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Received Data has been currupted, Resend Requested.");
                continue;
             }
             
             double angle = 0;
             double power = 0;
             
             
             int target = 0;
             for (int i = 1; i < NUMBER_OF_BALLS; i++) {
                if(balls[i][0] != -1 && balls[i][1] != -1) {
                   target = i;
                   break;
                }
             }
             int XGap_WT =balls[target][0] - balls[0][0] ;
             int YGap_WT = balls[target][1] - balls[0][1];
             double length_WT = Math.sqrt(Math.pow(XGap_WT, 2)+Math.pow(YGap_WT, 2));
             double tan_WT = 360 + (Math.atan2(XGap_WT, YGap_WT) * 180 / Math.PI) + 1.8;
             if(tan_WT > 360)
                tan_WT -= 360;
             angle = tan_WT;
//             int finx = balls[target][0];
//             int finy = balls[target][1];
             
             power = length_WT/3*2;
             if(length_WT < 30)
                power = length_WT + 45;
             
             
             
             
             ////////////////////////////////////////////////////////////////////
             // 주석을 지우고, 이 곳에 주어진 정보를 바탕으로 게임 로직을 구현하여 자동으로 플레이할 수 있도록 구현합니다.
              // 필요한 결괏값은 방향(angle)과 세기(power)로 두 변수의 값이 이 부분에서 결정되도록 만들어야 합니다.
             //////////////////////////////////////////////////////////////////
             
             String merged_data = angle + "/" + power;
             bytes = merged_data.getBytes("UTF-8");
             os.write(bytes);
             os.flush();
             System.out.println("Data Sent: " + merged_data);
          }
          os.close();
          is.close();
       }
       catch (Exception e) {
          e.printStackTrace();
       }
    }

}
