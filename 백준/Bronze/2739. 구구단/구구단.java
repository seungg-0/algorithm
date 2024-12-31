import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10; i++){
            sb.append(N).append(" ").append("*").append(" ").append(i).append(" ").append("=").append(" ").append(N*i).append("\n");
        }
        System.out.println(sb);
    }
}