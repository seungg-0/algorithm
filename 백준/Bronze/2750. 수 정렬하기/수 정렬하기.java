import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arrays = new int[N];
        
        for(int i=0; i<N; i++){
            arrays[i] = sc.nextInt();
        }
        Arrays.sort(arrays);
        for(int i=0; i<N; i++){
            System.out.println(arrays[i]);
        }
    }
}