package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_JEAriim {

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, K;
	static LinkedList<Ball>[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<Ball>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1].add(new Ball(r - 1, c - 1, w, v, d));

		}
		int cycle = 0;
		while (K != cycle) {
			move();
			cycle++;
		}
		int ans = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					ans += map[i][j].get(k).weight;
				}
			}
		}
		System.out.println(ans);
	}

	public static void move() {
		LinkedList<Ball>[][] newMap = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = new LinkedList<Ball>();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 1) {
					int store = map[i][j].size();
					int idx = 0;
					while (store != 0) {
						if (map[i][j].get(idx).y == i && map[i][j].get(idx).x == j) {
							Ball b = map[i][j].remove(idx);
							int ny = i + dy[b.direction] * (b.velocity % N);
							int nx = j + dx[b.direction] * (b.velocity % N);
							ny = checkBoundary(ny);
							nx = checkBoundary(nx);
							newMap[ny][nx].add(new Ball(ny, nx, b.weight, b.velocity, b.direction));
							store--;
						} else {
							idx++;
						}
					}
				}

			}
		}
		cal(newMap);
	}

	public static void cal(LinkedList<Ball>[][] secondMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (secondMap[i][j].size() >= 2) {
					int totSize = 0;
					int totVel = 0;
					//이전코드 
//					int totDir = 0;
					int totDir = -1;// -1로 초기화
					int tmpSize = secondMap[i][j].size();
					int cnt = 0;
					LinkedList<Integer> tmplst = new LinkedList<>();
					for (int k = 0; k < secondMap[i][j].size(); k++) {
						if (secondMap[i][j].get(k).y == i && secondMap[i][j].get(k).x == j) {
							Ball b = secondMap[i][j].get(k);
							tmplst.add(k);
							totSize += b.weight;
							totVel += b.velocity;

							// 방향을 누적합으로 계산하면 대각선만 모였는지 섞여 모였는지 알 수가 없다!
							// ex) 1, 3, 7 일때, 합이 11로 홀수로 판단 => 아래코드에서 같은방향이 모인 것으로 알 수 없음!   
							
							//이전코드
//							totDir += b.direction;
							
							if (totDir == -1) {
								// 첫번째 공은 % 연산 해서 정방향(0),대각선(1) 판단 
								totDir = b.direction % 2;
							} else {// 두번째 공 부터는 이전 공과 방향이 같은 부류인지 확인, 다른 방향이면 2를 넣어줌(섞인경우)
								if (totDir != b.direction % 2) {
									totDir = 2;//섞인 경우 2라고 판단
								}
							}
						}
					}
					// 결과적으로 for문을 빠져나온 후
					// totDir이 0이면 상하좌우 방향만 모인 집합,
					// 1이면 대각선만 모인 집합,
					// 2이면 섞인 집합이라고 판단할 수 있다.

					int idx = 0;
					int S = secondMap[i][j].size();
					while (idx != S) {
						if (secondMap[i][j].get(idx).y == i && secondMap[i][j].get(idx).x == j) {
							secondMap[i][j].remove(idx);
							S--;
						} else {
							idx++;
						}
					}

					if (totSize / 5 != 0) {
						for (int k = 0; k < 4; k++) {
//                         이전코드
//							if (totDir % 2 == 0) {
//							secondMap[i][j].add(new Ball(i, j, totSize / 5, totVel / tmpSize, 2 * k));
//						} else {
//							secondMap[i][j].add(new Ball(i, j, totSize / 5, totVel / tmpSize, 2 * k + 1));
//						}
							if (totDir== 2) {
								secondMap[i][j].add(new Ball(i, j, totSize / 5, totVel / tmpSize, 2 * k));
							} else {
								secondMap[i][j].add(new Ball(i, j, totSize / 5, totVel / tmpSize, 2 * k + 1));
							}

						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(secondMap[i], N);
		}
	}

	private static int checkBoundary(int i) {
		if (i < 0)
			i += N;
		if (i >= N)
			i -= N;
		return i;
	}

	static class Ball {
		int y;
		int x;
		int weight;
		int velocity;
		int direction;
		public Ball(int y, int x, int weight, int velocity, int direction) {
			this.y = y;
			this.x = x;
			this.weight = weight;
			this.velocity = velocity;
			this.direction = direction;
		}

	}

	/* 메모리 & 시간 단축
	 * 
	 * 1. Ball객체 배열로 변환
	 * 		맵을 Ball [][] map = new Ball[N][N];으로 만들고 104번 라인처럼 누적하고
	 * 		size 변수를 추가해서 한 지점에 몇개의 공이 모였는지 판단.
	 * 
	 * 2. Queue에 넣어서 돌려서 반복 수 줄이기(공이 없는지점 반복x)
	 * 		1) 인풋 Queue 넣기 
	 * 		2) Queue를 poll하면서 Ball이동 후 위치를 map에 누적
	 *   	3) map에 존재하는 것을 Queue에 넣음 (2개이상 모인곳은 쪼개서 Queue에 넣음)   
	 *      4) (2~3 반복)
	 */
}
