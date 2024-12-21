import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long T = Long.parseLong(br.readLine());
        
        for(int i=0; i<T; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            bw.write(String.valueOf(a+b));
            bw.newLine();
        }
        bw.flush();
    }
}