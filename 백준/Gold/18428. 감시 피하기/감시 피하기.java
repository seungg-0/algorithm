// 장애물의 위치 3곳 순서 상관 없음 -> 순열이 아닌 조합 이용 

import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Node> student = new ArrayList<>();
    static int n;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j]=='S'){
                    student.add(new Node(i, j));
                }
            }
        }
        dfs(0);
        System.out.println("NO");
        
    }
    
    static void dfs(int wall){
        if(wall == 3){
            bfs(); // 가림막 세개 다 세우면 YES or NO 검사
            return;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]=='X'){
                    map[i][j] = 'O'; // 빈칸이면 가림막 세우기
                    dfs(wall+1);
                    map[i][j] = 'X'; // 백트래킹
                }
            }
        }
    }
    
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        char[][] copyMap = new char[n][n];
        boolean[][] check = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            copyMap[i] = map[i].clone();
        }
        
        // 선생님 위치 저장하기 (큐에 다 넣음)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(copyMap[i][j]=='T'){ // 선생님이면 학생 볼 수 있는지 검사해야함
                    q.add(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }
        
        // 모든 선생님 학생 볼 수 있는지 검사
        while(!q.isEmpty()){
            Node now = q.poll(); // 선생님 꺼내기
            int x=now.x;
            int y=now.y;
            
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                // [핵심] if가 아니라 while로 상하좌우 끝까지 확인 !!!!!
                while(0<=nx && nx<n && 0<=ny && ny<n){
                    if(copyMap[nx][ny]!='O'){ // 가림막 만나기 전까지
                        check[nx][ny] = true;
                        nx += dx[k];
                        ny += dy[k];
                    }else{
                        break;
                    }
                }
            }

        }
        
        if(catchStudent(check)){
            System.out.println("YES");
            System.exit(0);
        }
    }
    
    static boolean catchStudent(boolean[][] check){
        for(Node node : student){ // 학생 하나씩 꺼내서 확인
            if(check[node.x][node.y]==true){
                return false; // 감시 피하기 실패
            }
        }
        return true; // 감시 피하기 성공
    }
    
    static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}