package src.amzao;

public class Factorial {
    static int getFactorial(int n) {
        int result=1;
        for(int i=2;i<=n;i++) {
            result = result * i;
        }
      return result;
    }
    public static void main(String[] args){
        System.out.println(getFactorial(8));
    }
}

