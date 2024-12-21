import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        String sNum = br.readLine();
        char[] cNum = sNum.toCharArray();
        
        long sum = 0L;
        for(int i=0; i<L; i++){
            sum += (cNum[i]-'a'+1) * Math.pow(31, i);
        }
        System.out.println(sum);
    }
}