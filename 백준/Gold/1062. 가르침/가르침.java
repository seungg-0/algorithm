import java.util.*;
import java.io.*;

// 되도록이면 많은 단어를 읽을 수 있도록 

public class Main{
    static int N, K, result = Integer.MIN_VALUE;
    static boolean[] alphabet = new boolean[26]; // 배운 알파벳 확인 배열
    static ArrayList<String> word = new ArrayList<>(); // 입력되는 단어 저장 리스트
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alphabetInit(); // 'a' 'c', 'i', 'm', 't' 배웠다고 초기화 해야 함
        if(K<5){
            System.out.println(0); // 배울 수 있는 글자 5개 미만
        } else if(K==26){
            System.out.println(N); // 배울 수 있는 글자가 26개일 때
        } else{
            for(int i=0; i<N; i++){
                String temp = br.readLine();
                temp.replace("anta", "");
                temp.replace("tica", "");
                word.add(temp); // 입력받은 단어들
            }
            cal(1, 5); // 모든 경우의 수에서 읽을 수 있는 단어 최대 수 구하기
            // 5개는 이미 읽을 수 있음, b부터 탐색 (a는 이미 배움)
            System.out.println(result);
        }
    }
    static void cal(int alpha, int cur){
        if(cur==K){ // 배울 수 있는 최대 수랑 똑같아지면 배울 수 있는 단어 수 세기
            wordCheck();
            return;
        }
        for(int i=alpha; i<26; i++){
            if(alphabet[i]){
                continue;
            }
            alphabet[i] = true;
            cal(i, cur+1);
            alphabet[i] = false;
        }
        return;
    }
    
    // 배운 알파벳으로 단어 몇 개 읽을 수 있는지 확인하기
    static void wordCheck(){
        int count = 0;
        for(int i=0; i<word.size(); i++){ // 입력받은 단어들 확인
            String temp = word.get(i); // 단어 하나 꺼내기
            boolean ck = false;
            if(!temp.equals("")){
                int size = temp.length();
                for(int j=0; j<size; j++){
                    if(!alphabet[temp.charAt(j)-97]){
                        ck = true;
                        break;
                    }
                }
            }
            if(!ck){
                count++;
            }
        }
        result = Math.max(result, count);
            return;
    }
    
    static void alphabetInit(){
        // 남극언어의 모든 단어는 "anta"로 시작하고, "tica"로 끝남 
        alphabet[0] = alphabet[2] = alphabet[8] = alphabet[13] = alphabet[19] = true;
        return;
    }
}