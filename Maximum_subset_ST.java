package src.amzao;

import java.util.ArrayList;
import java.util.List;

public class Maximum_subset_ST {
    static public List<Integer> Countanagrams(String s, String t) {

        ArrayList<Integer> soln = new ArrayList<Integer>();
        //Condition checking
        if(s.length() ==0 || t.length() == 0 || s.length() < t.length() ) {
            return new ArrayList<Integer>() ;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Countanagrams("abcdcba", "abc"));
    }
}

