import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[][] tree;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        tree = new int[26][2]; // 노드 최대 26개, tree[i][0]:왼쪽자식, tree[i][1]:오른쪽자식
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int node = st.nextToken().charAt(0)-'A'; // index(숫자형태0)로 변환하기 위해 A 문자 빼기
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left=='.'){
                tree[node][0] = -1; // 자식 없을 경우 -1 저장
            } else if(left!='.'){
                tree[node][0] = left-'A';
            }
            if(right=='.'){
                tree[node][1] = -1; // 자식 없을 경우 -1 저장
            } else if(right!='.'){
                tree[node][1] = right-'A';
            }
        }
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        System.out.println(sb);
    }

    static void preOrder(int node){ // 전위 순회
        if(node==-1){
            return;
        }
        // 1. 현재 노드
        sb.append((char) (node+'A')); // 숫자로 바꿔줬던거 다시 문자로 바꾸기
        // 2. 왼쪽 노드
        preOrder(tree[node][0]);
        // 3. 오른쪽 노드
        preOrder(tree[node][1]);
    }
    
    static void inOrder(int node){ // 중위 순회
        if(node==-1){
            return;
        }
        // 1. 왼쪽 노드
        inOrder(tree[node][0]);
        // 2. 현재 노드
        sb.append((char) (node+'A'));
        // 3. 오른쪽 노드
        inOrder(tree[node][1]);
    }
    
    static void postOrder(int node){ // 후위 순회
        if(node==-1){
            return;
        }
        // 1. 왼쪽 노드
        postOrder(tree[node][0]);
        // 2. 오른쪽 노드
        postOrder(tree[node][1]);
        // 3. 현재 노드
        sb.append((char) (node+'A'));
    }
    
}