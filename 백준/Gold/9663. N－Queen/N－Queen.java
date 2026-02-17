// 백트래킹의 핵심 : 완성하고 검사가 아니라, 검사하고 가능하면 추가하기 ! 
// 한 행에 퀸 하나만 놓을 수 있음 

import java.util.*;
import java.io.*;

public class Main{
    static int N, result;
    static boolean[] col, diag1, diag2; // 좌하향 : r+c 이 같음, 후하향 :r-c 이 같음
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        result = 0;
        col = new boolean[N];
        diag1 = new boolean[2*N];
        diag2 = new boolean[2*N];
        DFS(0); // 첫 번째 행부터 시작 ! 
        System.out.println(result);
    }
    
    static void DFS(int row){
        // 종료조건 (퀸을 놓을 수 있는 케이스 (이미 검증 됨))
        if(row==N){
            result++;
            return;
        }
        
        for(int c=0; c<N; c++){
            if(col[c] || diag1[row+c] || diag2[row-c+N]){ // 세로나 대각선 방향으로 공격 가능하면
                continue;
            }
            // 공격 가능하지 않으면, 퀸 놓기
            col[c] = true;
            diag1[row+c] = true;
            diag2[row-c+N] = true;
            DFS(row+1);
            // 백트래킹
            col[c] = false;
            diag1[row+c] = false;
            diag2[row-c+N] = false;
        }
    }
}