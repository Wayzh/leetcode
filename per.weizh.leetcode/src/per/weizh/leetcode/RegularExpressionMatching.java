package per.weizh.leetcode;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p){
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        return isMatch(s,0,p,0);
	}
    public boolean isMatch(String s , int ptr1, String p ,int ptr2){
    	if(s.length() == ptr1 && p.length() == ptr2) return true;
    	if(p.length() == ptr2) return false;
    	//if()
    	
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching a = new RegularExpressionMatching();
		System.out.println(a.isMatch("aa","a"));
		System.out.println(a.isMatch("aa","aa"));
		System.out.println(a.isMatch("aaa","aa"));
		System.out.println(a.isMatch("aa", "a*"));
		System.out.println(a.isMatch("aa", ".*"));
		System.out.println(a.isMatch("ab", ".*"));
		System.out.println(a.isMatch("aab", "c*a*b"));
		System.out.println(a.isMatch("a","a*"));
		

	}

}
