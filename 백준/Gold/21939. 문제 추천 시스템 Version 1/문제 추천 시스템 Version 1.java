import java.util.*;
import java.io.*;

/* recommend x   1 : 추천 문제 리스트에서 가장 어려운 문제 번호 출력 (문제 번호 큰거)
                -1 : 추천 문제 리스트에서 가장 쉬운 문제 번호 출력 (문제 번호 작은거)
   add PL : 난이도 L인 문제 P 추가
   solved P : 문제 번호 P 제거 
                
*/

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 문제번호, 난이도 (문제번호 오름차순 정렬)
        HashMap<Integer, Integer> problemLevel = new HashMap<>();
        
        // 난이도, 문제번호들 (난이도 오름차순, 문제번호 오름차순 정렬)
        TreeMap<Integer, TreeSet<Integer>> levelProblems = new TreeMap<>();
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            levelProblems.putIfAbsent(l, new TreeSet<>());
            levelProblems.get(l).add(p);
            
            problemLevel.put(p, l);
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String comment = st.nextToken();
            
            if(comment.equals("recommend")){
                int n = Integer.parseInt(st.nextToken());
                if(n==1){ // 추천 문제 리스트에서 가장 어려운 문제 번호 출력 (문제 번호 큰거)
                    int l = levelProblems.lastKey();
                    int p = levelProblems.get(l).last();
                    sb.append(p).append("\n");
                } else{ // 추천 문제 리스트에서 가장 쉬운 문제 번호 출력 (문제 번호 작은거)
                    int l = levelProblems.firstKey();
                    int p = levelProblems.get(l).first();
                    sb.append(p).append("\n");
                }
            } else if(comment.equals("add")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                levelProblems.putIfAbsent(l, new TreeSet<>());
                levelProblems.get(l).add(p);
                problemLevel.put(p, l);
            } else if(comment.equals("solved")){
                int p = Integer.parseInt(st.nextToken());
                int l = problemLevel.get(p);
                levelProblems.get(l).remove(p);
                
                // problems 다 삭제되면, key 삭제해주기
                if(levelProblems.get(l).isEmpty()){
                    levelProblems.remove(l);
                }
                problemLevel.remove(p);
            }
        }
        System.out.println(sb);
    }
}