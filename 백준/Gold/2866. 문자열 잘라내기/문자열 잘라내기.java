// 아래서부터 한줄씩 확인하면서 containsKey해서 있으면 위로 올라가기 

import java.util.*;
import java.io.*;

public class Main{
    static int R, C;
    static char[][] map;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            for(int j=0;j<C; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        
        // 문자열 만들어 놓기
        StringBuilder sb;
        for(int i=0; i<C; i++){
            sb = new StringBuilder(); // 자바에서는 슬라이싱 문법이 없다. 
            for(int j=0; j<R; j++){
                sb.append(map[j][i]); 
            }
            String str = sb.toString();
            set.add(str);
        }
        
        int answer = -1;
        for(int i=1; i<R; i++){
            if(!isUnique(i)){ // 값들이 유니크 하지 않으면
                answer = i-1;
                break;
            }
        }
        if(answer==-1){
            answer = R-1;
        }
        System.out.println(answer);
    }
    
    static boolean isUnique(int startRow){
        HashSet<String> tmpSet = new HashSet<>();
        for(String s : set){ // set에 있는 문자 하나씩 꺼내서 확인
            String tmp = s.substring(startRow, R); // 잘라서 확인
            if(tmpSet.contains(tmp)){
                return false;
            }else{
                tmpSet.add(tmp);
            }
        }
        return true;
    }
}