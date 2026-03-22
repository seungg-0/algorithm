import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] table = new int[N];
        for(int i=0;i<N;i++){
            table[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d+1];
        int kind = 0;

        // 초기 윈도우
        for(int i=0;i<k;i++){
            if(count[table[i]]++ == 0) kind++;
        }

        int answer = kind + (count[c]==0 ? 1 : 0);
        int left = 0;

        for(int right=k; right<N+k; right++){
            int r = table[right%N];
            if(count[r]++ == 0) kind++;

            int l = table[left];
            if(--count[l] == 0) kind--;
            left = (left+1)%N;

            answer = Math.max(answer,
                kind + (count[c]==0 ? 1 : 0));
        }

        System.out.println(answer);
    }
}