import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int minSticks = 0;

        while(X>=2){
            if(X%2 == 1){
                minSticks+=1;
            }
            X/=2;
        }
        if(X==1)minSticks+=1;

        System.out.println(minSticks);

        scanner.close();
    }
}