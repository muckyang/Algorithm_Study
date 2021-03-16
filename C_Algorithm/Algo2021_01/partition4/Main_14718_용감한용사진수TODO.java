package partition4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14718_용감한용사진수TODO {
	static LinkedList<Power> HLink;
	static LinkedList<Power> ALink;
	static LinkedList<Power> ILink;
	static int N, target;
	static int point[][];

	public static class Power {
		int h, a, i;

		public Power(int h, int a, int i) {
			this.h = h;
			this.a = a;
			this.i = i;
		}

	}

	static Comparator<Power> cp1 = new Comparator<Power>() {
		@Override
		public int compare(Power o1, Power o2) {
			if (o1.a == o2.a) {
				if (o1.h == o2.h) {
					return o1.i - o2.i;
				}
				return o1.h - o2.h;
			}
			return o1.a - o2.a;
		}
	};
	static Comparator<Power> cp2 = new Comparator<Power>() {

		@Override
		public int compare(Power o1, Power o2) {
			if (o1.h == o2.h) {
				if (o1.i == o2.i) {
					return o1.a - o2.a;
				}
				return o1.i - o2.i;
			}
			return o1.h - o2.h;
		}
	};
	static Comparator<Power> cp3 = new Comparator<Power>() {

		public int compare(Power o1, Power o2) {
			if (o1.i == o2.i) {
				if (o1.a == o2.a) {
					return o1.h - o2.h;
				}
				return o1.a - o2.a;
			}
			return o1.i - o2.i;
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		point = new int[3][N];

		HLink = new LinkedList<>();
		ALink = new LinkedList<>();
		ILink = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			Power power = new Power(H, A, I);
			HLink.add(power);
			ALink.add(power);
			ILink.add(power);
		}
		Collections.sort(HLink, cp2);
		Collections.sort(ALink, cp1);
		Collections.sort(ILink, cp3);
		int minsum = Integer.MAX_VALUE;
		int hm = Integer.MIN_VALUE;
		int ha = Integer.MIN_VALUE;
		int hi = Integer.MIN_VALUE;
		int cnt = 0;
		for (Power p : HLink) {
			if (cnt == target)
				break;
			hm = Math.max(hm, p.h);
			ha = Math.max(ha, p.a);
			hi = Math.max(hi, p.i);
			cnt++;
		}
		minsum = Math.min(minsum, hm + ha + hi);

		cnt = 0;
		hm = ha = hi = Integer.MIN_VALUE;
		for (Power p : ALink) {
			if (cnt == target)
				break;
			hm = Math.max(hm, p.h);
			ha = Math.max(ha, p.a);
			hi = Math.max(hi, p.i);
			cnt++;
		}
		minsum = Math.min(minsum, hm + ha + hi);
		hm = ha = hi = Integer.MIN_VALUE;
		cnt = 0;
		for (Power p : ILink) {
			if (cnt == target)
				break;
			hm = Math.max(hm, p.h);
			ha = Math.max(ha, p.a);
			hi = Math.max(hi, p.i);
			cnt++;
		}
		minsum = Math.min(minsum, hm + ha + hi);
		System.out.println(minsum);
	}

}
