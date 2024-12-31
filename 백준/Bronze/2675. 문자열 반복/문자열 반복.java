import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            String text = sc.next();
            
            String result = "";
            for(int j=0; j<text.length(); j++){
                result += (text.charAt(j)+"").repeat(N);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}