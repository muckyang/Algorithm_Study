package partition3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {

	public static void main(String[] args) {
//		int len = 100;
//		int wei = 100;
//		int[] truck = { 10,10,10,10,10,10,10,10,10,10 };
		int len = 2;
		int wei = 10;
		int[] truck = { 7, 4, 5, 6 };
//		int len = 5;
//		int wei = 5;
//		int[] truck = { 2, 2, 2, 2, 1, 1, 1, 1, 1 };
		System.out.println(solution(len, wei, truck));
	}

	public static class Truck {
		int endtime;
		int weight;

		public Truck(int endtime, int weight) {
			this.endtime = endtime;
			this.weight = weight;
		}
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> qlist = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			qlist.add(new Truck(0, truck_weights[i]));
		}
		Queue<Truck> q = new LinkedList<>();
		int now = 0;
		int time = 0;
		while (!qlist.isEmpty() || !q.isEmpty()) {
			time++;
			Truck t;
			if (!q.isEmpty() && time == q.peek().endtime) {
				t = q.poll();
				time = t.endtime;
				now -= t.weight;
			}
			if (!qlist.isEmpty() && qlist.peek().weight + now <= weight) {
				t = qlist.poll();
				now += t.weight;
				q.add(new Truck(time + bridge_length, t.weight));
			}
		}
		return time;
	}
}
