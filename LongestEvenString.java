package src.amzao;

public class LongestEvenString {


    public static void main(String[] args) {

        System.out.println(longestEvenWord("Pyara pudri babu"));

    }
    public static String longestEvenWord(String sentence) {
        if(sentence.length() == 0) return "";
        String[] SentenceArr = sentence.split(" ");
        int maxLen = Integer.MIN_VALUE;
        String maxLenStr = "";

        for(String s: SentenceArr) {
            int sLen = s.length();
            if(sLen%2 == 0 && sLen > maxLen ){
                maxLenStr = s;
                maxLen = sLen;
            }
        }
        return maxLenStr.equals("") ? "00" : maxLenStr;  // Capturing the boundary conditions
    }
}
