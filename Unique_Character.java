package src.amzao;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result{
    /*
     * Complete the 'getUniqueCharacter' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getUniqueCharacter(String s) {
        if(s == null || s.length() == 0) {return -1;}

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) { return i+1;}
        }

// for(Map.Entry<Character, Integer> c: map.entrySet())
//     { c.getKey() ;
//       c.getValue() ;
//     }
        return -1 ;
    }
}

public class Unique_Character {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.getUniqueCharacter(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
