import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Main
 */
public class Main {


    static final int N=5;

    static void maxProfit()
    {
        int a[]=new int[]{1,5,3,8,0,3};
        // int max=0;
        int min=2147483647;
        int result=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<min)
            {
                min=a[i];
            }
            else
            {
                if(a[i]-min>result)
                {
                    result=a[i]-min;
                }
            }
        }
        System.out.println();
        System.out.println(result);
    }

    static List<Integer> p = new ArrayList<>();
    public static int findCircleNum(int[][] M) {

        int n = M.length;
        int res = n;
    
        for(int i = 0; i < n; i++){
            p.add(i);
        }
    
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(M[i][j] == 1) {
                    if(find(i) != find(j)) {
                        res --;
                        p.set(find(i), find(j));
                    }
                }
            }
        }
        return res;
    }
    
    public static int find(int x) {
        if(x != p.get(x)){
            p.set(x, find(p.get(x)));
        }
        return p.get(x);
    }
    

    public static boolean isMatch(String s, String p){
        if (p.length() <= 0) return s.length() <= 0;
        boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        restore(s, 4, "", res);
        return res;
    }
	
	public static void restore(String s,int k,String out,List<String> res) {
		if(k==0) {
			if(s.isEmpty())
				res.add(out);
		}else {
			for (int i = 1; i <= 3; ++i) {
				if(s.length() >= i && isValid(s.substring(0,i))) {
					if(k==1)
						restore(s.substring(i), k-1, out+s.substring(0,i), res);
					else 
						restore(s.substring(i), k-1, out+s.substring(0,i)+".", res);
				}
			}
		}
	}

	//校验函数：主要验证 每段数字是否为 001 022 等这样0开头的数字
	public static boolean isValid(String s) {
		if(s.isEmpty() || s.length()>3 || (s.length()>1 && s.charAt(0)=='0')){
			return false;
		}else {
			int resInt = Integer.parseInt(s);
			return resInt<=255 && resInt>=0;
		}
    }


    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        if(res.equals("")) return "/";
        return res;  
    }
    
    public static void main(String[] args) {
        
        //1
        maxProfit();
        //2
        String a="qwee";
        String b="qwe*"; 
        System.out.println(isMatch(a, b));
        //3
        int[][] aq=new int[3][3];
        System.out.println(findCircleNum(aq));
        //4
        String ip="349077225";
        System.out.println(restoreIpAddresses(ip));
        //5
        String test="/a/er/e/../";
        System.out.println(simplifyPath(test));
    }
} 