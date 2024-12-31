import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        String result = "";
        for(int i=0; i<input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))){
                result += Character.toLowerCase(input.charAt(i));
            }
            else{
                result += Character.toUpperCase(input.charAt(i));
            }
        }
        System.out.println(result);
    }
}