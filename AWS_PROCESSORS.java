package src.amzao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AWS_PROCESSORS {

      /*public static void main(String[] args) {
        long res = findTotalExecutionTime(execution);
        System.out.println(res);
    } */

    public static long findTotalExecutionTime(List<Integer> execution) {
        Map<Integer, List<Integer>> groups = new HashMap<>();  //Hash map in random order -groups

        for(int i=0; i< execution.size(); i++) {
            int time = execution.get(i);  //Storing the key time in the
            if(!groups.containsKey(time)) {
                groups.put(time, new ArrayList<>());
            }
            groups.get(time).add(i);  //get the value for the "time" key mapped and add the value to
        }
        long totalTime =0;

        for(int k:groups.keySet()) {
            long currTime = k;
            for(int t:groups.get(k)) {
                totalTime += currTime;
                currTime =(long)Math.round(Math.ceil(currTime/2.0));
            }
        }
        return totalTime;
    }
}