import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // 알파벳 26 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        int[] results = new int[26];
        
        char letter = 'a';
        for(int i = 0; i<26; i++){
            for(int j = 0; j<S.length(); j++){
                if(S.charAt(j) == letter){
                    results[i] = j;
                    letter++; // Java 알파벳 +1씩 해주면 다음 알파벳
                    break;
                }else if(!S.contains(letter+"")){
                    results[i] = -1;
                    letter++;
                    break;
                }
            }
        }
        for(int result : results){
            System.out.print(result+" ");
        }
    }
}