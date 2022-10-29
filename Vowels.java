package src.amzao;

public class Vowels {
    static List<Integer> hasVowels(List<String> strArr,List<String> query) {

        Char[] Vowels= {a,e,i,o,u};
        int lower= query(0);
        int upper = query(1);
        int[] count= new int[strArr.length];

        StringBuilder sb = new StringBuilder();

        for(int i=lower;i<= upper;i++) {
            sb.append(strArr(i));
            for(int j=0; j<sb.length();j++) {
                char[] ch = new char[sb.length()];
                ch = sb.charAt(j);
                if( (ch[0] == 'a' || ch[0] == 'e'||ch[0] == 'i'||ch[0] == 'o'||ch[0] == 'u' ) && (ch[sb.length()-1] == 'a' || ch[sb.length()-1] == 'e'||ch[sb.length()-1] == 'i'||ch[sb.length()-1] == 'o'||ch[sb.length()-1] == 'u' ) )
                    return count[i]++;
            }
        }

        return count[];


    }

    public static void main(String[] args) {

    }




}
