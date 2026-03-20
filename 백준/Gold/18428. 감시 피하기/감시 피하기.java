// 3개 장애물을 설치하여 모든 학생들을 감시로부터 피할 수 있는지 여부 출력 
// 상하좌우 한 칸씩이 아니라 쭉 탐색해야 함 (while)
// 빈 자리 탐색하며 3개 설치시 검사하는 방식

import java.util.*;
import java.io.*;

public class Main{
    static char[][] map;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean found = false;
    static ArrayList<Node> teachers = new ArrayList<>();
    static ArrayList<Node> emptys = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N]; // 초기화 잊지 말기 [중요]
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                char tmp = st.nextToken().charAt(0);
                if(tmp=='T'){
                    teachers.add(new Node(i, j));
                } else if (tmp=='X'){
                    emptys.add(new Node(i, j));
                }
                map[i][j] = tmp;
            }
        }
        
        dfs(0);
        System.out.println(found ? "YES" : "NO"); // 감시 피할 수 있는 방법 찾았는지
        
    }
    
    static void dfs(int WALL_COUNT){
        // 종료조건
        if(WALL_COUNT==3){
            if(avoid()){ // 감시 피할 수 있는 방법 있는지 확인
                found = true;
                return;
            }; 
            return;
        }
        
        // 순열이 아닌 조합으로 가림막 3개 설치
        for(Node empty : emptys){
            int i=empty.x;
            int j=empty.y;
            if(map[i][j]=='X'){ // 빈 곳일 경우 가림막 설치
                map[i][j] = 'O';
                dfs(WALL_COUNT+1);
                map[i][j] = 'X'; // 백트래킹
            }
        }
    }
    static boolean avoid(){ // 감시 가능한지 확인
        for(Node teacher : teachers){
            int nx = teacher.x;
            int ny = teacher.y;
            for(int k=0; k<4; k++){ // 상하좌우 확인
                nx = teacher.x;
                ny = teacher.y;
                while(true){ // 상하좌우 끝까지 확인
                    nx += dx[k]; // 좌표 갱신 += 로 해야 함. [주의]
                    ny += dy[k];
                    if(nx<0 || nx>=N || ny<0 || ny>=N){
                         break;
                    }
                    if(map[nx][ny]=='O') {
                        break;
                    }
                    if(map[nx][ny]=='S'){ // 학생 감시 가능
                        return false;
                    }
                }
            }
        }
        return true; 
    }
    
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}