package SSAFY;

public class sol2 {
	 public static String lastLetters(String word) {
		 String res = "";
		 char c1 = word.charAt(word.length()-1);
		 char c2 = word.charAt(word.length()-2);
		 
		 res = c2+" "+c1;
		 return res;
	 }
	public static void main(String[] args) {
		
	}
}
