import java.util.*;
import java.io.*;

public class Main{
    static int[] par;
    static boolean[] isknowPerson;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // num of people
        int M = Integer.parseInt(st.nextToken()); // num of party
        st = new StringTokenizer(br.readLine());
        int knows = Integer.parseInt(st.nextToken()); // num of people who know that is false
        
        par = new int[N+1]; // 대표 노드 저장
        for(int i=0; i<=N; i++){
            par[i] = i; // 초기 루트노드는 자기자신
        }
        
        int result = 0;
        
        isknowPerson = new boolean[N+1]; // 진실을 아는 사람들
        ArrayList<ArrayList<Integer>> party = new ArrayList<>(); // 같은 파티에 참여하는 사람들
        for(int i=0; i<M; i++){
            party.add(new ArrayList<>());
        }
        
        if(knows==0){
            System.out.println(M);
            System.exit(0);
        } else{
            for(int i=0; i<knows; i++){
                isknowPerson[Integer.parseInt(st.nextToken())] = true;
            }
            
            for(int i=0; i<M; i++){ // 파티별 탐색 
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 파티 참가인원
                int first = Integer.parseInt(st.nextToken()); // 파티에 참여하는 첫번째 사람
                party.get(i).add(first); // 파티에 저장 
                
                for(int j = 1; j<n; j++){
                    int next = Integer.parseInt(st.nextToken());

                    union(first, next); // 첫 번째 사람을 기준으로 union
                    party.get(i).add(next); // 참여인원들 파티에 저장
                }
            }
            
            for(int i=0; i<M; i++){
                boolean check = true; // 거짓말 가능한 파티인가?
                
                for(int p : party.get(i)){
                    if(isknowPerson[find(p)]){ // true : 진실을 아는 사람
                        check = false;
                        break; // 탐색종료
                    }
                }
                if(check){
                    result++; // 거짓말 칠 수 있는 파티 +1
                }
            }
            System.out.println(result);
        }
    }
    
    public static int find(int x){ // 루트 노드 찾기
        if(par[x] == x){
            return x;
        } else{
            return find(par[x]);
        }
    }
    
    public static void union(int a, int b){ // 합치기
        // 두 사람이 참여한 파티의 루트노드
        int pa = find(a);
        int pb = find(b);
        
        if(isknowPerson[pb]){ // b쪽 루트가 진실을 알고 있다면
            int tmp = pa;
            pa = pb;
            pb = tmp;
        } // 둘이 자리 바꾸기
        
        par[pb] = pa; // 루트 노드 등록
    }
}