import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = br.readLine();
            if(input.equals("0")) break;
            char[] cNum = input.toCharArray();
            
            boolean isPalinedrome = true;
            for(int i=0; i<cNum.length/2; i++){
                if(cNum[i] != cNum[cNum.length-i-1]){ 
                    isPalinedrome = false;
                    break;
                }
            }
            if(isPalinedrome == true){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}