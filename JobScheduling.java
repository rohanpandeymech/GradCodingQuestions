package src.amzao;
import java.util.*;

public class JobScheduling {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Specify the number of process:");
        int n = sc.nextInt();

        // Creating variables for entering data
        int process[] = new int[n];

        int WaitingTime[] = new int[n];
        int BurstTime[] = new int[n];
        int ArrivalTime[] = new int[n];


        int Flag[] = new int[n];
        int startTime=0;
        int Total=0;
        float Wt_avg =0,Comp_avg=0,TAT_avg=0;

        int TurnAroundTime[] = new int[n];
        int CompletionTime[] = new int[n];
        //Completion Time = Start Time + Burst Time
        //Turn Around Time = Completion Time – Arrival Time
        //Waiting Time = Turn Around Time – Burst Time

        for(int j=0;j<n;j++)
        {
            System.out.println ("Enter arrival time for process " + (j+1));
            ArrivalTime[j] = sc.nextInt();
            System.out.println ("Enter burst time for process" + (j+1));
            BurstTime[j] = sc.nextInt();
            process[j] = j+1;
            Flag[j] = 0;
        }
        boolean a = true;
        while(true)
        {
            int temp=n, Minimum=900;
            if (Total == n) // total no of process = completed process loop will be terminated
                break;
            for (int i=0; i<n; i++)
            {
                if ((ArrivalTime[i] <= startTime) && (Flag[i] == 0) && (BurstTime[i]<Minimum))
                {
                    Minimum=BurstTime[i];
                    temp=i; //If arrival time of any i process <= system time and flag=0 and burst<min then 1st that process will get executed
                }
            }

            if (temp==n)
                startTime++;
                //If temp ==n means temp value can not updated further because there will be no process whose arrival time< system time hence we will increase the system time.
            else
            {
                CompletionTime[temp]=startTime+BurstTime[temp];
                startTime+=BurstTime[temp];
                TurnAroundTime[temp]=CompletionTime[temp]-ArrivalTime[temp];
                WaitingTime[temp]=TurnAroundTime[temp]-BurstTime[temp];
                Flag[temp]=1;
                Total++;
            }
        }
        System.out.println("\nProcess  Arrival Burst Completion TurnAround Waiting");
        for(int k=0;k<n;k++)
        {
            Comp_avg+= CompletionTime[k];
            Wt_avg += WaitingTime[k];
            TAT_avg+= TurnAroundTime[k];
            System.out.println(process[k]+"\t\t\t"+ArrivalTime[k]+"\t\t\t"+BurstTime[k]+"\t\t\t"+CompletionTime[k]+"\t\t\t"+TurnAroundTime[k]+"\t\t\t"+WaitingTime[k]);
        }
        System.out.println ("Completion time is "+ (float)(Comp_avg /n));
        System.out.println ("\naverage Turn around time is "+ (float)(TAT_avg/n));
        System.out.println ("average wait time is "+ (float)(Wt_avg /n));

        sc.close();
    }
}
