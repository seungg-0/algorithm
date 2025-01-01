//버블정렬을 통해 작성해본다.
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int [N];
        
        //숫자 목록
        for(int i = 0 ; i < N ; i++){
            A[i] = sc.nextInt();
        }
        
        //현재 A 배열 갑소가 한칸 오른쪽 배열의 값 비교
        for(int i = 0; i < N-1 ; i++){
            for(int j = 0; j < N-1-i ; j++){
                if(A[j]>A[j+1]){
                    int temp = A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
            }
        }
        for(int i = 0; i<N ; i ++){
            System.out.println(A[i]);
        }
    }
}