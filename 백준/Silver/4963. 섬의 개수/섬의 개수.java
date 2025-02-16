import java.util.*;
import java.io.*;

public class Main{
    static int[][] island;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int w;
    static int h;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken()); // 열 (너비)
            h = Integer.parseInt(st.nextToken()); // 행 (높이)
            if(w==0&&h==0){ // 0 0 이 입력되면 종료
                break;
            }
            
            island = new int[h][w]; // 섬 정보 입력받기
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<w; j++){
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int numLands = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(island[i][j]==1){ // 땅이면
                        DFS(i, j, island);
                        numLands++;
                    }
                }
            }
            sb.append(numLands).append("\n");
        }
        System.out.println(sb);
    }
    
    static void DFS(int i, int j, int[][] island){
        // 종료조건 (땅 모두 방문하면 자동종료)

        // 수행조건
        for(int n=0; n<8; n++){
            int nx = i+dx[n];
            int ny = j+dy[n];
            if((0<=nx&&nx<h)&&(0<=ny&&ny<w)&&island[nx][ny]==1){
                island[nx][ny] = -1; // 방문처리
                DFS(nx, ny, island);
            }
        } 
    }
}