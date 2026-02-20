import java.util.*;
import java.io.*;

public class Main{
    static int N, M, K, result;
    static int[][] map, cals;
    static boolean[] visited;
    static ArrayList<Integer> orders;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cals = new int[K][3];
        visited = new boolean[K];
        
        orders = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int r, c, s;
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            cals[i][0] = r;
            cals[i][1] = c;
            cals[i][2] = s;
        }
        
        result = Integer.MAX_VALUE;
        DFS(0); 
        System.out.println(result);
    }
    
    static void DFS(int cnt){
        // 종료조건
        if(cnt==K){ // 연산 하나가 완성되면
            // 맵 복사해서 연산 수행하고, A 구하기
            int tmp = countA(rotateAll(clone(map), orders));
            result = Math.min(result, tmp);
            return; // [필수!!!]
        }
        
        for(int i=0; i<K; i++){
            if(visited[i]) continue;
            visited[i] = true;
            orders.add(i);
            DFS(cnt+1);
            // 백트래킹
            visited[i] = false; 
            orders.remove(orders.size()-1); // ArrayList remove() 는 인덱스로 삭제 !! 
        }
    }
    
    // (1) 회전하는 함수
    static int[][] rotateAll(int[][] m, ArrayList<Integer> orders){
        // 가로/세로 중 짧은거 나누기 2 해서 그만큼 for문 돌려야 함.
        // 가로 : 2*s / 세로 : 2*s
        
        int r, c, s;
        for(int order : orders){
            r = cals[order][0];
            c = cals[order][1];
            s = cals[order][2];
            int layers = s;
            
            // [암기] 구조 함기 !!!!
            int top, left, bottom, right;
            for(int layer = 0; layer<layers; layer++){
                // [중요] 인덱스 잘 모르겠을땐 양 끝값 임의로 넣어보기 
                top = r-s+layer-1;
                left = c-s+layer-1;
                bottom = r+s-layer-1;
                right = c+s-layer-1;
                // top, left, right, bottom
                // 여기서 -1 빼주기 때문에 아래에서 인덱스 오류 안남
                rotate(m, top, left, bottom, right);
            }  
        }
        return m;
    }
    
    // A값을 찾는 함수
    static int countA(int[][] m){
        int sum = Integer.MAX_VALUE;
        int tmp;
        for(int i=0; i<N; i++){
            tmp = 0;
            for(int j=0; j<M; j++){
                tmp += m[i][j];
            }
            sum = Math.min(tmp, sum);
        }
        return sum;
    }
    
    static int[][] clone(int[][] map){
        int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++){
            tmp[i] = map[i].clone();
        }
        return tmp;
    }
    
    // (2) 한 껍데기 회전시키는 함수
    // [암기] 구조 함기 !!!! 
    static void rotate(int[][] m, int top, int left, int bottom, int right){
        int temp = m[top][left]; // (0, 0) 초기값 저장해둬야 함
        
        // [중요] 왼쪽 아래 오른쪽 위 순서대로 돌려야 함 !!!
        
        // 왼쪽
        for(int i=top; i<bottom; i++){
            m[i][left] = m[i+1][left];
        }
        // 아래쪽
        for(int i=left; i<right; i++){
            m[bottom][i] = m[bottom][i+1];
        }
        // 오른쪽
        for(int i=bottom; i>top; i--){
            m[i][right] = m[i-1][right];
        }
        
        // 위쪽
        for(int i=right; i>left+1; i--){
            m[top][i] = m[top][i-1];
        }
        m[top][left+1] = temp; // (0, 1) 은 초기값으로 넣어줘야 함. 덮어씌워져서
    }
}
