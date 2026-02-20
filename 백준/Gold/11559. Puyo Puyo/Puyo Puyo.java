// 테트리스처럼 떨어짐.
// 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 없어짐 
// -> BFS 덩어리 확인해서 같은색 뿌요 4개 이상이면 없앰
// 아래로 다시 떨어뜨리기 (함수)
// 위 동작이 1연쇄 
// 입력값에서 몇연쇄가 일어나는지 구하기

// 행 : 12 열 : 6 

import java.util.*;
import java.io.*;

public class Main{
    static int[][] map; // 숫자 문자로 바꿔서 입력하기 . 이면 0
    static int r, c, result;
    static boolean exploded;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        r = 12;
        c = 6;
        result = 0;
        
        map = new int[12][6];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                char tmp = str.charAt(j);
                if(tmp=='.'){
                    map[i][j] = 0;
                } else{
                    map[i][j] = tmp - 'A' + 1; // 알파벳 숫자로 바꿔 저장(A이면 1)
                }
            }
        }
        
        while(true){
            visited = new boolean[12][6];
            exploded = false;
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(map[i][j]!=0 && !visited[i][j]){
                        if(BFS(i, j, map[i][j])){
                            exploded = true;
                        }; // 한덩이씩 탐색
                    }
                }
            }
            if(!exploded){
                break;
            }
            moveDown();
            result++;
        }
        System.out.println(result);
    }

    // BFS (시작한 색상과 동일한 인접뿌요 3마리 이상 있는지 확인)
    static boolean BFS(int a, int b, int c){
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> tmp = new ArrayList<>();
        queue.add(new int[] {a, b});
        tmp.add(new int[] {a, b});
        visited[a][b] = true;
        int colorCnt = 1;
        int x, y;
        
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            x = xy[0];
            y = xy[1];
            
            int nx, ny;
            for(int i=0; i<4; i++){
                nx = x+dx[i];
                ny = y+dy[i];
                if(0<=nx && nx<12 && 0<=ny && ny<6 && !visited[nx][ny] && map[nx][ny]==c){
                    visited[nx][ny] = true;
                    colorCnt++;
                    tmp.add(new int[] {nx, ny});
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        if(colorCnt>=4){
            for(int[] xy : tmp){
                map[xy[0]][xy[1]] = 0; // 뿌요 삭제
            }
            return true;
        }
        return false;
    }

    // 아래로 하강시키는 함수 (플래그 필요. 이동 없으면 끝내야 함)
    static void moveDown(){
        // 아래서부터 탐색하면서 0이면 행 하나씩 내려가면서 줍기
        // [암기] 아래로 하강시키는 로직 !!!!! 
        for(int i=0; i<6; i++){
            int idx = 11; // 아래부터 채울 위치
            for(int j=11; j>=0; j--){
                if(map[j][i]!=0){
                    map[idx][i] = map[j][i];
                    if(idx!=j){
                        map[j][i] = 0;
                    }
                    idx--;
                }
            }
        }
    }
}

