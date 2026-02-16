// 한 행에는 하나의 퀸만 놓을 수 있음
// DFS

import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int result;
    static boolean[] col, diag1, diag2; // 아래 좌우 대각선 (위에서부터 DFS 내려오기 때문에, 위쪽 대각선은 신경 안써도 됨)
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        col = new boolean[N];
        diag1 = new boolean[2*N];
        diag2 = new boolean[2*N];
        DFS(0);
        System.out.println(result);
    }
    

    static void DFS(int row){
        // 종료조건
        if(row == N){ // N개의 퀸을 놓았을 때 (N-1개까지 고려하고 +1했을 때 비교하는거니까 row+1이 아니라 row가 맞음 (0부터 카운팅 했다고 해도))
            result++;
            return;
        }
        
        for(int c=0; c<N; c++){
            if(col[c] || diag1[row+c] || diag2[row-c+N]){ // 공격이 가넝한 경우
                continue;
            }    
            // 퀸 배치
            col[c] = true;
            diag1[row+c] = true;
            diag2[row-c+N] = true;
            
            DFS(row+1); // 다음 행으로
            
            // 백트래킹
            col[c] = false;
            diag1[row+c] = false;
            diag2[row-c+N] = false;
        }
    }
}


/*

(0,0) (0,1) (0,2) (0,3) (0,4)
(1,0) (1,1) (1,2) (1,3) (1,4)
(2,0) (2,1) (2,2) (2,3) (2,4)
(3,0) (3,1) (3,2) (3,3) (3,4)
(4,0) (4,1) (4,2) (4,3) (4,4)

-> 아래쪽 우측 대각선의 경우
(0,1)
(1,2)
(2,3)
(3,4)
(좌측-우측) 뺀 값이 같음. 그래서 diag1[col-row] = true 해주면 대각선 쭉 true 처리 해주는 것

-> 아래쪽 죄측 대각선의 경우
(0,3)
(1,2)
(2,1)
(3,0)
(죄측+우측) 합한 값이 같음. 그래서 diag2[col+row] = true 해주면 대각선 쭉 true 처리 해주는 것
*/