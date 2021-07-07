/**
 * Main
 */
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        //测试静态方法
//        //格式化生成
//        System.out.println(String.format("%d", 1));
//        //valueof 用于基本数据类型
//        System.out.println(String.valueOf(1));
//        //valueof 用于对象
//        System.out.println(String.valueOf(new Integer(1)));
//        //copyValueOf
//        char[] a={'a','b','c'};
//        System.out.println(String.copyValueOf(a));
//        //copyValueOf 子串
//        System.out.println(String.copyValueOf(a, 1, 2));
//        //实例化对象
//        String test=new String();
    	Map<String,String> m=new HashMap<String,String>();
    	m.put("qwerr", "12345");
    	Scanner input=new Scanner(System.in);
        
    	String msg=m.get(input.nextLine());
    	System.out.println(msg);
    	
    }
    
}