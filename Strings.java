import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Strings {

	public static String subStr(String str, int si, int ei) {
		// return str.substring(si, ei);
		StringBuilder subStr = new StringBuilder("");
		for(int i=si; i<ei; i++) {
			subStr.append(str.charAt(i));
		}
		return subStr.toString();
	}

	public static boolean isPalindrome(String text) {
		int n = text.length();
		for(int i=0; i<n/2; i++) {
			if(text.charAt(i) != text.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}

	public static float shortestDistance(String directions) {
		int x = 0;
		int y = 0;
		for(int i=0; i<directions.length(); i++) {
			if(directions.charAt(i) == 'E') {
				x++;
			}
			else if(directions.charAt(i) == 'N') {
				y++;
			}
			else if(directions.charAt(i) == 'W') {
				x--;
			}
			else if(directions.charAt(i) == 'S') {
				y--;
			}
			else {
				System.out.println("Invalid direction!!!\nAborting!!!");
				return -1;
			}
		}
		float sdSq = x*x + y*y;
		float sd = (float) Math.sqrt(sdSq);
		return sd;
	}

	public static String largestStr(String[] words) {
		String largestStr = "";
		for(int i=0; i<words.length; i++) {
			if(words[i].compareToIgnoreCase(largestStr) > 0) {
				largestStr = words[i];
			}
		}
		return largestStr;
	}

	public static String firstLettersToUppercase(String sentence) {
        StringBuilder uppercase = new StringBuilder("");
        uppercase = uppercase.append(Character.toUpperCase(sentence.charAt(0)));
        for(int i=1; i<sentence.length(); i++) {
            if(sentence.charAt(i-1) == ' ') {
                uppercase.append(Character.toUpperCase(sentence.charAt(i)));
            }
            else {
                uppercase.append(sentence.charAt(i));
            }
        }
        return uppercase.toString();
    }

	public static String compressedStr(String str) {
		StringBuilder compressedStr = new StringBuilder("");
		for(int i=0; i<str.length(); i++) {
			int repetition = 1;
			while(i < str.length()-1 && str.charAt(i+1) == str.charAt(i)) {
				repetition++;
				i++;
			}
			compressedStr.append(str.charAt(i));
			if(repetition > 1) {
				compressedStr.append(repetition);
			}
		}
		return compressedStr.toString();
	}

	public static void main(String[] args) {
	}

}
