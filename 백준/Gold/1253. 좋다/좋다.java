import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int answer = 0;
        
        if(N==1){
            System.out.println(0);
        } else{
            for(int i=0; i<N; i++){
                int target = nums[i];
                // 투포인터
                int left = 0;
                int right = N-1; // 투포인터는 항상 left=0, right=N-1로 시작해야 함.
                while(left < right){
                    int sum = nums[left] + nums[right];
                    if(sum == target){
                        if(left!=i && right!=i){
                            answer++;
                            break;
                        }else if (left==i){ // 이렇게 값이 아닌 인덱스값으로 해줘야 다른 자리 같은 값일때 같은 위치의 값이라고 착각하는 경우가 없음 
                            left++;
                        }else if (right==i){
                            right--;
                        }
                    } else if (sum < target){
                        left++;
                    } else{
                        right--;
                    }
                }
            }
            System.out.println(answer);
        }   
    }
}