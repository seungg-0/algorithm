import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        String sNum = br.readLine();
        char[] cNum = sNum.toCharArray();
        
        long sum = 0L;
        long M = 1234567891;
        long pow = 1L;
        for(int i=0; i<L; i++){
            sum += (cNum[i]-'a'+1)*pow;
            // pow는 31를 매번 곱해주고, 곱해줄떄마다 1234567891를 나눠주면 long을 넘지 않음. 
            pow = (pow * 31)%1234567891; 
        }
        System.out.println(sum%M);
    }
}