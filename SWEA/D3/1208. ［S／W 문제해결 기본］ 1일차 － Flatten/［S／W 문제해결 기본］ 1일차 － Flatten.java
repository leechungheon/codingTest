import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[10];

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            // input
            int dumpTime = sc.nextInt();
            List<Integer> heights= new ArrayList<>();
            for(int i=0; i<100; i++){
                heights.add(sc.nextInt());
            }

            //logic
            int max = 0;
            int min = 0;
            for(int i=0; i<dumpTime; i++){
                heights.sort(Comparator.naturalOrder());

                max = heights.get(heights.size()-1);
                heights.remove(heights.size()-1);
                heights.add(max-1);

                min = heights.get(0);
                heights.remove(0);
                heights.add(0, min+1);

                heights.sort(Comparator.naturalOrder());
                max = heights.get(heights.size()-1);
                min = heights.get(0);
                if(max-min <= 1)break;
            }
            answers[test_case-1]=max-min;
        }
        // output
        for(int i=0; i<10; i++){
            System.out.println("#"+(i+1)+" "+answers[i]);
        }
    }


}