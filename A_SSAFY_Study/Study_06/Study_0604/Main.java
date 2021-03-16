package Study_0604;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N ;
    static String []slist;
    static String []clist;
    static PriorityQueue<Point> pq;
    public static class Point implements Comparable<Point>{
        String ss;
        String rs;
        public Point(String ss , String rs){
            this.ss =ss;
            this.rs =rs;
        }
        public int compareTo(Point p){
            return this.rs.compareTo(p.rs);
        }
    }
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        slist= new String[N];
        clist= new String[N];
        pq=new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            clist[i] = "";
            slist[i] = s;
            while(!s.equals("")){
                if(s.startsWith("ng")){
                    clist[i] += "o";
                    s = s.substring(2);
                }else{
                    if(s.charAt(0)=='k'){
                        clist[i]+="c";
                    }else if(s.charAt(0)-'a' >=14){
                        char add = (char) (s.charAt(0)+1);
                        clist[i]+=""+add;
                    }else{
                       clist[i]+=""+s.charAt(0);
                    }
                    s = s.substring(1);
                }
            }
            pq.add(new Point(slist[i], clist[i]));
        }
        for(int i =0 ; i < N ; i++){
            System.out.println(pq.poll().ss);
        }
    }
}