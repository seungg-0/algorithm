import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> cards = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=N; i++){ // 1234 형태로 저장 
            cards.add(i);
        }
        
        int card;
        while(cards.size()!=1){ // 카드가 한장만 남을 때까지 반복
            cards.remove(); // 맨 윗쪽 카드 치우기
            card = cards.remove();
            cards.add(card);
        }
        System.out.println(cards.remove());
    }
}