package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20293_연료가부족해 {
	static int R, C;
	static int N;
	static LinkedList<Car>[] list;
	static Car[] arr;

	public static class Car {
		int y, x, fuel, min;

		public Car(int y, int x, int fuel, int min) {
			this.y = y;
			this.x = x;
			this.fuel = fuel;
			this.min = min;
		}

		@Override
		public String toString() {
			return "Car [y=" + y + ", x=" + x + ", fuel=" + fuel + ", min=" + min + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		list = new LinkedList[N + 2];
		for (int i = 0; i <= N + 1; i++)
			list[i] = new LinkedList<>();

		arr = new Car[N + 2];
		arr[0] = new Car(0, 0, 0, 0);

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int fuel = Integer.parseInt(st.nextToken());
			arr[i] = new Car(y, x, fuel, 0);
		}
		arr[N + 1] = new Car(R - 1, C - 1, 0, 0);
		for(int i = 0 ; i <  N+2;i++)
			System.out.println(arr[i].toString());
		for (int i = 0; i < N + 1; i++) {
			for (int j = 1; j < N + 2; j++) {
				if (j == i)
					continue;
				if (!(arr[i].x < arr[j].x && arr[i].y < arr[j].y)) {
					continue;
				}
				Car temp = new Car(arr[j].y,arr[j].x,arr[j].fuel,0);
				temp.min = (arr[j].x - arr[i].x) + (arr[j].y - arr[i].y);
				System.out.println(temp.toString());
				list[i].add(temp);
			}
		}
		for (int i = 0; i < N + 2; i++) {
			System.out.println(i);
			for (Car c : list[i]) {
				System.out.println(c.y + " , " + c.x + " fuel : " + c.fuel + "   min :" + c.min);
			}
			System.out.println();
		}
	}
}
