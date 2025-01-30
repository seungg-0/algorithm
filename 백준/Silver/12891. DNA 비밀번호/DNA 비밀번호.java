import java.util.*;
import java.io.*;

public class Main{
    static int[] minCounts = new int[4]; // A, C, G, T 최소 개수
    static int[] curCounts = new int[4]; // 현재 슬라이딩 윈도우 내 개수
    static int validCount = 0; // 조건을 만족하는 경우의 수
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 연속된 부분 문자열(슬라이딩 윈도우) 길이
        char[] dna = br.readLine().toCharArray(); // dna 입력받기
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){ // minCounts 입력받기
            minCounts[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<P; i++){ // curCounts 입력받기 (슬라이딩 윈도우 초기값)
            addChar(dna[i]);
        }
        
        if(checkValid(curCounts)) validCount++; // 초기 윈도우 조건 만족하는지 확인
        // 슬라이딩 윈도우
        for(int i=P; i<S; i++){
            addChar(dna[i]);
            removeChar(dna[i-P]);
            if(checkValid(curCounts)) validCount++;
        }
        
        System.out.println(validCount++);
    }
    
    static void addChar(char c){
        if(c == 'A') curCounts[0]++;
        else if(c == 'C') curCounts[1]++;
        else if(c == 'G') curCounts[2]++;
        else curCounts[3]++;
    }
    static void removeChar(char c){
        if(c == 'A') curCounts[0]--;
        else if(c == 'C') curCounts[1]--;
        else if(c == 'G') curCounts[2]--;
        else curCounts[3]--;
    }
    static boolean checkValid(int[] window){
        for(int i=0; i<4; i++){
            if(curCounts[i]<minCounts[i]) return false;
        }
        return true;
    }                                            
}
