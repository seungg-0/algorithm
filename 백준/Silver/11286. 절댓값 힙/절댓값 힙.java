import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> PminHeap = new PriorityQueue<>(); // 양수 저장
        PriorityQueue<Integer> NminHeap = new PriorityQueue<>(); // 음수 저장
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int calc = Integer.parseInt(br.readLine());
            if(calc!=0){
                if(calc<0){
                    NminHeap.add(calc*(-1)); 
                }// 음수 요소 추가
                else{
                    PminHeap.add(calc);
                }// 양수 요소 추가
            } else { // 0일때
                if ((PminHeap.size()+NminHeap.size())==0){
                    sb.append(0).append("\n");
                } else{
                    if(PminHeap.size()==0){
                        sb.append(NminHeap.poll()*(-1)).append("\n");
                    } else if(NminHeap.size()==0){
                        sb.append(PminHeap.poll()).append("\n");
                    } else{
                        int n = NminHeap.peek(); // 음수 중 우선순위 가장 높은 값 (아직 제거X)
                        int p = PminHeap.peek(); // 양수 중 우선순위 가장 높은 값 (아직 제거X)
                        if(n==p){
                            sb.append(NminHeap.poll()*(-1)).append("\n"); // 음수 중 우선순위 가장 높은 값 출력, 제거
                      } else {
                         if(n>p){ // 음수의 절댓값이 더 크면
                            sb.append(PminHeap.poll()).append("\n"); // 양수 중 우선순위 가장 높으 값 출력, 제거
                         } else{ // 양수의 절댓값이 더 크면
                            sb.append(NminHeap.poll()*(-1)).append("\n"); // 음수 중 우선순위 가장 높으 값 출력, 제거
                           }
                        } 
                      }   
                } 
            }
        }
        System.out.println(sb);
    }
}