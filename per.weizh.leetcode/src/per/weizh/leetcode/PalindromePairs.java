package per.weizh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Map<String,Integer> smap = new HashMap<String,Integer>();
    	for(int i = 0 ; i < words.length ; i++){
    		smap.put(words[i], i);
    	}
    	
    	
    	for(int i = 0 ; i < words.length ; i++){
    		int length = words[i].length();
    		for(int j = 0 ; j <= words[i].length() ; j++){
    			if(words[i].equals(""))
    				continue;
    			String leftStr = words[i].substring(0, j);
    			String rightStr = words[i].substring(j,length);
    			if(leftStr.length()>0 && isPal(leftStr)){
    				String tmp = reverse(rightStr);
    				if(smap.containsKey(tmp)){
    					result.add(Arrays.asList(smap.get(tmp),i));
    				}
    			}
    			if(isPal(rightStr)){
    				String tmp = reverse(leftStr);
    				if( smap.containsKey(tmp) && smap.get(tmp) != i){
    					result.add(Arrays.asList(i,smap.get(tmp)));
    				}	
    			}
    			
    		}
    	}
		return result;
        
    }
    public String reverse(String str){
    	StringBuilder sb= new StringBuilder(str);
	    return sb.reverse().toString();
    }
	public boolean isPal(String str){
		int i = str.length()-1,j = 0;
		while(i>j && str.charAt(i)==str.charAt(j)){
			i--;
			j++;
		}
		return j >= i;
	}
	public void printArrayList(List<List<Integer>> r){
		for(int i = 0 ; i < r.size() ; i++){
			for(int j = 0 ; j < r.get(i).size() ; j++){
				System.out.print(r.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words ={"abcd", "dcba", "lls", "s", "sssll"};
		PalindromePairs a = new PalindromePairs();
		List<List<Integer>> test = a.palindromePairs(words);
		a.printArrayList(test);
	}

}
