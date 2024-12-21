import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] scoreArray = new double[N];
        
        for(int i=0; i<N; i++){
            scoreArray[i] = sc.nextDouble();
        }
        double max = Arrays.stream(scoreArray).max().getAsDouble();
        
        double sum = 0;
        for(int i=0; i<N; i++){
            sum += (scoreArray[i]/max)*100;
        }
        System.out.println(sum/N);
    }
}