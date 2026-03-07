// 문제번호(key), 난이도(value)
// recommend 1 : 가장 어려운 문제 번호 출력 (복수 : 문제 번호 큰거) 
//          -1 : 가장 쉬운 문제 번호 출력 (복수 : 문제 번호 작은거)

// 문제의 핵심 : 난이도, 문제 대소비교, 정렬 필요
// 해쉬맵은 정렬 기능이 없기 때문에, TreeMap, HashMap 사용해줘야 함.

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // TreeMap<난이도, TreeSet<문제번호>> : 난이도 기준 정렬
        // TreeSet<문제번호> : 같은 난이도에서 문제번호 정렬 
        // HashMap<문제번호, 난이도> : solved할 때 난이도 찾기
        
        // 난이도 -> 문제번호들
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        
        // 문제번호 -> 난이도
        HashMap<Integer, Integer> problemLevel = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        // 초기 문제 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            map.putIfAbsent(L, new TreeSet<>()); // [형태 암기] key값 없으면 TreeSet 새로 생성
            map.get(L).add(P); // 난이도 key의 TreeSet에 문제번호 넣기
            problemLevel.put(P, L); // 문제번호, 난이도 넣기
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            // recommend
            if(cmd.equals("recommend")){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    int level = map.lastKey(); // 가장 큰 key 반환(어려운 문제)
                    int problem = map.get(level).last(); // 같은 문제 중 문제번호 가장 큰거 반환
                    sb.append(problem).append("\n");
                } else{ // -1 일때
                    int level = map.firstKey(); // 가장 작은 key 반환(쉬운 문제)
                    int problem = map.get(level).first(); // 같은 문제 중 문제번호 가장 작은거 반환
                    sb.append(problem).append("\n");
                }
            }
            
            // add
            else if(cmd.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                
                map.putIfAbsent(L, new TreeSet<>()); // key중 레벨 없으면 추가
                map.get(L).add(P); // 해당 레벨 Key값에 문제번호 추가
                problemLevel.put(P, L); // 문제번호, 레벨 추가
            }
            
            // solved
            else if(cmd.equals("solved")){
                int P = Integer.parseInt(st.nextToken());
                // 푼 문제 map 이랑 problemLevel 에서 제거해줘야 함
                int L = problemLevel.get(P);
                
                map.get(L).remove(P); // map의 문제들 treeSet 에서 삭제
                if(map.get(L).isEmpty()){
                    map.remove(L); // value값 다 비면 key 삭제해주기
                }
                
                problemLevel.remove(P);
            }
        }
        
        System.out.println(sb);
    }
}