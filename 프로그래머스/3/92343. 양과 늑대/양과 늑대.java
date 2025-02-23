// 다시 부모쪽으로 타고 올라갈 수 있어야 함 -> 양방향 연결
// 방문한 곳 다시 방문할 수 있어야 함 -> 방문처리 안하면 무한방문 -> 양, 늑대 각 몇 가지고 있는지에 따라 방문여부 결정
// -> visited[A][B][C] 3차원으로, A노드에 B마리의 양과 C마리의 늑대를 가지고 방문한 적이 있는지 확인
// 각 노드가 비었으면 -1로 표기 (빈 노드 방문했는지 확인하기 위함) -> 재귀 호출 후 방문처리 원복해주는 것처럼 이것도 원복해줘야 함 
import java.util.*;

class Solution {
    static ArrayList<Integer>[] linkedInfo = new ArrayList[18]; // 최대 노드 수 17 (0~17)
    static boolean[][][] visited = new boolean[18][18][18];
    static int[] isWolf = new int[18];
    static int maxSheep = Integer.MIN_VALUE;
    static int numNode;
    
    public int solution(int[] info, int[][] edges) {
        numNode = info.length;
        
        for(int i=0; i<numNode; i++){
            linkedInfo[i] = new ArrayList<>();
        }
        
        for(int i=0; i<numNode; i++){ // info 값 isWolf에 복사 (dfs함수에서 활용하기 위함)
            isWolf[i] = info[i];
        }
        
        for(int[] edge : edges){ // 부모노드-자식노드 양방향 연결 
            int parent = edge[0];
            int child = edge[1];
            linkedInfo[parent].add(child);
            linkedInfo[child].add(parent);
        }
        
        // 루트노드 (항상 양) 방문
        isWolf[0] = -1;
        visited[0][1][0] = true;
        dfs(0, 1, 0);
        
        return maxSheep;
    }
    
    static void dfs(int node, int sheeps, int wolfs){
        maxSheep = Math.max(maxSheep, sheeps); // 양 개수 업데이트 
        
        
        for(int nextNode : linkedInfo[node]){
            // 1. 다음 블록이 양일 경우 
            if(isWolf[nextNode]==0 && !visited[nextNode][sheeps+1][wolfs]){
                int original = isWolf[nextNode];
                isWolf[nextNode] = -1;
                visited[nextNode][sheeps][wolfs] = true;
                dfs(nextNode, sheeps + 1, wolfs); // 늘린 sheeps 수도 원복시켜줘야 함
                isWolf[nextNode] = original;
                visited[nextNode][sheeps][wolfs] = false;
            }
        
            // 2. 다음 블록이 늑대일 경우 (* 여기선 늑대+1이 양 수보다 작을 경우에만 이동)
            if(isWolf[nextNode]==1){
                if((sheeps>(wolfs+1)) && !visited[nextNode][sheeps][wolfs+1]){
                    int original = isWolf[nextNode];
                    isWolf[nextNode] = -1;
                    visited[nextNode][sheeps][wolfs] = true;
                    dfs(nextNode, sheeps, wolfs + 1); // 늘린 늑대 수도 원복시켜줘야 함
                    isWolf[nextNode] = original;
                    visited[nextNode][sheeps][wolfs] = false;
                }
            }
        
            // 3. 다음 블록이 비어있는 경우
            if(isWolf[nextNode]==-1 && !visited[nextNode][sheeps][wolfs]){
                visited[nextNode][sheeps][wolfs] = true;
                dfs(nextNode, sheeps, wolfs);
                visited[nextNode][sheeps][wolfs] = false;
            }
        }  
    }
}