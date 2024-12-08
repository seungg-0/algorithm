import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        
        String nowTime = sdf.format(now);
        System.out.println(nowTime);
    }
}