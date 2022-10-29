package src.amzao;
import java.util.HashMap;
import java.util.Map;

public class LotteryCoupons {
    public static int getWinnerCount(int n) {

        int finalCount = 0;
        Map<Integer, Integer> couponMap = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            couponMap.put(sum, couponMap.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(maxCount, couponMap.get(sum));
        }
        for (int entryValue : couponMap.values()) {
            if (entryValue == maxCount) {
                finalCount++;
            }
        }
        return finalCount;
    }

    static private int getDigitSum(int n) {
        int digit, sum = 0;
        while (n > 0) {
            System.out.println("The value of n1 is :" +n);
            digit = n % 10;
            //System.out.println("The value of digit is :" +digit);
            sum = sum + digit;
            //System.out.println("The value of sum is :" +sum);
            n = n / 10;
            System.out.println("The value of n2 is :" +n);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getWinnerCount(22));
    }
}

