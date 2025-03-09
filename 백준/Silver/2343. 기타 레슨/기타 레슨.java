// 이분 탐색의 조건 : 정렬된 자료구조에서 사용 가능 (오름차순 혹은 내림차순)
// 중간 값 비교 : 배열의 중간 값을 선택하고, 찾고자 하는 값과 비교하여 왼쪽 절반 또는 오른쪽 절반으로 범위를 좁혀나감 -> 시간복잡도 O(log(sum))

import java.util.*;
import java.io.*;

public class Main{
    static long start, end, mid;
    static int N, M;
    static long[] lectures;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lectures = new long[N];
        
        long Max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            lectures[i] = Long.parseLong(st.nextToken());
            Max = Math.max(Max, lectures[i]);
            end += lectures[i];
        }
        start = Max;
        
        long answer = 0;
        // 이분탐색 시작 
        while(start<=end){
            mid = (start + end) / 2;
            if(isPossible(mid)){
                answer = mid;
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
    static boolean isPossible(long capacity){
        int counts = 1;
        long lectureSum = 0;
        for(long lecture : lectures){
            if(lectureSum + lecture>capacity){
                counts++;
                lectureSum = lecture;
            } else{
                lectureSum += lecture;
            }
        }
        return counts <= M;
    }
}