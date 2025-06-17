import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // N 입력받기 
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 노드 부모 입력받기 
        int[] parents = new int[N];
        for(int i=0; i<N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
        }
        
        int del = Integer.parseInt(br.readLine().trim()); // [암기] trim() -> 앞뒤 공백 제거 
        
        // idx - 부모 / 값 - 자식
        ArrayList<Integer>[] tree = new ArrayList[N+1]; // [암기]
        for(int i=0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N; i++){
            if(parents[i]!=-1){ // 루트 노드가 아니면
                tree[parents[i]].add(i); // 부모 자식 연결관계 저장
            }
        }
        
        // 노드 지우기 (BFS)
        queue.add(del); // 지울 노드 넣기
        boolean[] isDeleted = new boolean[N];
        while(!queue.isEmpty()){
            int par = queue.poll();
            isDeleted[par] = true;
            for(int chil : tree[par]){
                isDeleted[chil] = true;
                queue.add(chil);
            }
        }
        
        // System.out.println(Arrays.deepToString(tree)); [암기] 디버깅
        // System.out.println(Arrays.toString(isDeleted)); [암기] 디버깅
        
        // 리프노드 세기
        int answer = 0;
        for(int i=0; i<N; i++){
            if (isDeleted[i]) continue;
            boolean isLeaf = true;
            for(int n : tree[i]){
                if(!isDeleted[n]){
                    isLeaf = false;
                    break;
                }
            }
            if(isLeaf){
                answer++;
            } 
        }
        
        System.out.println(answer);

    }
}