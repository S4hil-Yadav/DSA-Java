import java.util.*;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] splitted = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            System.out.println(pattern.charAt(i) + " : " + splitted[i]);
            if(map.containsKey(pattern.charAt(i))) {
                if(splitted[i] != map.get(pattern.charAt(i))) {
                    System.out.println(map.get(pattern.charAt(i)) + " == " + splitted[i]);
                    return false;
                }
            } else {
                if(map.containsValue(splitted[i])) {
                    System.out.println("2");
                    return false;
                }
                map.put(pattern.charAt(i), splitted[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Set<Integer[]> s1 = new HashSet<Integer[]>();
        Set<String> s2 = new HashSet<>();

        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {1, 2};

        String str1 = new String("Sah");
        String str2 = new String("Sah");

        s1.add(arr1);
        s2.add(str1);
        s2.add(2 + "," + 3);
        
        System.out.println(s2.contains(new String(2 + "," + 3)));
    }
}