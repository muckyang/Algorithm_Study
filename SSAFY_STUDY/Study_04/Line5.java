import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Line5 {
	static PriorityQueue<Point> pq;
	
	static class Point implements Comparable<Point>{
		String name;
		int value;
		public Point(String name , int value) {
			this.name = name;
			this.value =value;
		}
		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}
	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t2", "t3" };
		pq = new PriorityQueue<>();
		
	}

}
