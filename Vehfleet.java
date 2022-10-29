package src.amzao;
import java.util.Arrays;

public class Vehfleet {
    static int[] getFleetVehicleArray(int[] vehicle) {
        int[] possiblefleet = new int[vehicle.length];

        for(int i=0;i<vehicle.length; i++) {
            int maxwheel = vehicle[i];
            if(maxwheel%2 != 0) { possiblefleet[i]=0; }
            else {
                possiblefleet[i] = maxwheel % 4 + 1;
            }
        }
        return possiblefleet;
    }
    public static void main(String[] args) {
        System.out.println(getFleetVehicleArray(new int[] {4,5,6}));

    }
}
