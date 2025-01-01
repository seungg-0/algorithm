import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arrays = new int[15][15];
        
        for(int i=0; i<15; i++){
            arrays[0][i] = i; // 0층 i호는 i명
            arrays[i][1] = 1; // 1호는 항상 1명
        }
        
        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                arrays[i][j] = arrays[i-1][j] + arrays[i][j-1]; //점화식
            }
         }
        
        for(int t=0; t<T; t++){
            int k = sc.nextInt(); //층
            int n = sc.nextInt(); //호
            System.out.println(arrays[k][n]);
        }
    }
}