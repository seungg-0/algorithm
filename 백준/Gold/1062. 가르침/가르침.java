import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<String> words = new ArrayList<>();
    static int N, K;
    static boolean[] alphabet = new boolean[26];
    static int result = 0;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        alphaInit();
        
        if(K<5){
            System.out.println(0); // "anta", "tica" 읽을 수 없으면 읽을 수 있는 단어의 수 0
        } else if(K==26){ // 모든 알파벳 읽을 수 있으면 전체 단어 읽을 수 있음
            System.out.println(N);
        } else{
            for(int i=0; i<N; i++){
                String tmp = br.readLine(); // 단어 하나씩 읽어들이기
                tmp = tmp.replace("anta", ""); // 모든 단어 anta로 시작 -> 잘라버리기
                tmp = tmp.replace("tica", ""); // 모든 단어 tica로 끝 -> 잘라버리기
                words.add(tmp); // 단어 목록에 놓기
                // System.out.println(words);
            }
            DFS(1, 5); // 기본적으로 anta tica의 5단어는 알고 시작, b부터 탐색
            // DFS로 탐색하며 result 계산하기
            System.out.println(result);
        }
    }
    static void DFS(int n, int cnt){
        // 종료조건 (배운 글자가 K개가 되면 종료하고 읽을 수 있는 단어의 수 세어야 함)
        if(cnt==K){
            counting();
            return;
        }
        
        // 26가지 단어 중 조합을 만들어 줘야 함 (깊이우선 탐색)
        for(int i=n; i<26; i++){
            if(!alphabet[i]){ // 모르는 단어면
                alphabet[i] = true; // 하나 배우기
                DFS(i, cnt+1);
                alphabet[i] = false;
            }
        }
        return;
    }
    
    static void counting(){
        String word;
        int size = 0;
        int cnt = 0;
        for(int i=0; i<N; i++){ // 단어 하나씩 순회하며 읽을 수 있는 단어 갯수 세기
            word = words.get(i); // 단어 하나 꺼내기
            //System.out.println(word);
            //System.out.println(Arrays.toString(alphabet));
            size = word.length(); // String 길이는 length() 로 구함 !! 
            boolean readable = true;
            for(int j=0; j<size; j++){
                if(!alphabet[word.charAt(j)-97]){ // 아는 단어가 아니면 (97 외우기_char 형태 a=1로 변환)
                    readable = false;
                    break;
                }
            }
            if(readable){
                cnt++;
            }
        }
        result = Math.max(result, cnt); // result 업데이트 해주기
        return;
    }
    
    // a n t i c 0 12 19 8 2
    static void alphaInit(){
        alphabet[0] = alphabet[13] = alphabet[19] = alphabet[8] = alphabet[2] = true;
        return;
    }
}