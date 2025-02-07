import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //재료의 개수
        int N = Integer.parseInt(br.readLine());
        //갑옷을 만드는 데 필요한 수
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        //재료들의 고유한 번호
        int [] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //시간 단축을 위해 값을 정렬한다.
        Arrays.sort(nums);

        //투포인터를 활용하여 번호의 합을 구한다.
        /*
        자꾸 배열을 단순 반복하여 활용하려는 습관이 있다.
        고치도록하자.
         */
        int start = 0;
        int end = N-1;

        //경우의 수
        int count = 0;
        while(start < end){
            if(nums[start] + nums[end] < M){
                start++;
            }else if(nums[start] + nums[end] > M){
                end--;
            }else{
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
        br.close();
    }
}