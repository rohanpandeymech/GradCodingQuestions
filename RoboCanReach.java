package src.amzao;

public class RoboCanReach {

    public static String canReach(int c, int x1, int y1, int x2, int y2) {

        // base conditions
        if(x1>x2 || y1>y2) {
            return "No";
        }
        // if destination is same as start point
        if(x1==x2 && y2==y1) {
            return "Yes";
        }
        // condition provided
        if(x1==x2 && y2>y1) {
            return "Yes";
        }
        // condition provided
        if(y1==y2 && x2>x1) {
            return "Yes";
        }
        boolean flag = perfectSq(x1+y1);
        if(flag) {
            return "No";
        }
        String val1 = canReach(c,x1+y1,y1,x2,y2);
        String val2 = canReach(c,x1,y1+x1,x2,y2);
        String val3 = canReach(c,x1+c,y1+c,x2,y2);

        if(val1.equals("Yes") || val2.equals("Yes") || val3.equals("Yes"))
        {return "Yes";}

        return "No";
    }

    public static boolean perfectSq(int x) {
        if(x==1) return true;
        if(x>=0) {
            int sr = (int) Math.sqrt(x);
            if ((sr * sr) == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(1, 1, 4, 7, 6));
    }
}

