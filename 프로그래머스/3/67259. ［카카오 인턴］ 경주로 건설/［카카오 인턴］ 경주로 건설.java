import java.util.*;

class Solution {
    // 상하좌우 이동 (0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] board) {
        int n = board.length;
        int INF = Integer.MAX_VALUE;
        // cost[x][y][dir] : (x,y) 칸에 dir 방향으로 도착했을 때의 최소 비용
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], INF);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        // 시작점 (0,0)은 아직 이동 방향이 없으므로, -1로 시작합니다.
        queue.add(new int[] {0, 0, -1});
        
        // 시작점은 비용 0
        // (0,0)에서 인접한 칸으로 이동할 때 비용을 계산하게 됨.
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int x = cur[0], y = cur[1], prevDir = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 및 장애물 검사
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1)
                    continue;
                
                // 비용 계산:
                // 초기 이동이거나 이전 방향과 같으면 100원, 아니면 코너(600원: 500+100)
                int newCost = (prevDir == -1) ? 100 
                              : (prevDir == i ? cost[x][y][prevDir] + 100 : cost[x][y][prevDir] + 600);
                
                // 새로운 경로의 비용이 기존 기록보다 작으면 갱신 후 큐에 추가
                if (newCost < cost[nx][ny][i]) {
                    cost[nx][ny][i] = newCost;
                    queue.add(new int[] {nx, ny, i});
                }
            }
        }
        
        // 도착점 (n-1, n-1)으로 도착하는 모든 방향 중 최소 비용 선택
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n-1][n-1][i]);
        }
        return answer;
    }
}
