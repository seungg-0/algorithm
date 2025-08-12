import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static boolean[] isKnowPerson;
    static int[] par;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " "); // 거짓말 아는 사람 수, 아는 사람 번호들 입력
        int knows = Integer.parseInt(st.nextToken());
        isKnowPerson = new boolean[N+1]; // [주의] 인덱스 에러 항상 유의 !! 
        ArrayList<ArrayList<Integer>> party = new ArrayList<>(); // 같은 파티에 참여하는 사람들
        for(int i=0; i<M; i++){
            party.add(new ArrayList<>());
        }
        
        for(int i=0; i<knows; i++){ // 거짓말인지 아는 사람 정보 저장하기
            isKnowPerson[Integer.parseInt(st.nextToken())] = true;
        }
        
        par = new int[N+1]; // [주의] 인덱스 에러 항상 유의 !! 
        for(int i=0; i<=N; i++){ // 부모 노드 초기값 저장
            par[i] = i; // 초기 부모는 자기자신
        }
        
        int participants;
        int result = 0;
        for(int i=0; i<M; i++){ // 파티에 정보 입력받기 
            st = new StringTokenizer(br.readLine(), " ");
            participants = Integer.parseInt(st.nextToken()); // 해당 파티 참여자 수 입력받기
            int num1, num2, tmp;
            num1 = Integer.parseInt(st.nextToken());
            party.get(i).add(num1);
            for(int j=1; j<participants; j++){
                num2 = Integer.parseInt(st.nextToken());
                party.get(i).add(num2);
                union(num1, num2);
                num1 = num2;
            }
        }
        
        for(int i=0; i<M; i++){
            boolean flag = true;
            for(int p : party.get(i)){
                if(isKnowPerson[find(p)]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result++;
            }
        }
        
        System.out.println(result);
        
    }
    
    public static int find(int a){
        if(par[a]==a){
            return a;
        } else{
            return find(par[a]);
        }
    }
        
    
    public static void union(int a, int b){ // 합치기
        // 부모 노드 찾기
        int aPar = find(a);
        int bPar = find(b);
        if(isKnowPerson[bPar]){ // b쪽 루트가 진실을 알고있으면, a에 b를 붙이는데, 이 경우는 a를 b에 붙여야하므로 값 교환
            int tmp = aPar;
            aPar = bPar;
            bPar = tmp; 
        }
        par[bPar] = aPar; // b쪽 루트가 진실을 아는 경우 aPar 의 루트값을 바꿔주게 됨
 
    } 
}