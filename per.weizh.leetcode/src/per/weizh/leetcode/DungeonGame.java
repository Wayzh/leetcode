package per.weizh.leetcode;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
    	int m = dungeon.length;
    	int n = dungeon[0].length;
    	int [][] val = new int[m][n];
    	for(int i=m-1 ; i>=0 ; i--){
    		for(int k = n-1 ; k >=0 ; k--){
    			if(i==m-1&& k ==n-1){
    				val[i][k] = (dungeon[i][k]>0?0:dungeon[i][k]);
    			}else if(i==m-1){
    				val[i][k]=(dungeon[i][k]+val[i][k+1]>0?0:dungeon[i][k]+val[i][k+1]);
    			}else if(k == n-1){
    				val[i][k] =(dungeon[i][k]+val[i+1][k]>0?0:dungeon[i][k]+val[i+1][k]);
    			}else{
    				if(dungeon[i][k]+val[i][k+1]>dungeon[i][k]+val[i+1][k])
    					val[i][k] = (dungeon[i][k]+val[i][k+1]>0?0:dungeon[i][k]+val[i][k+1]);
    				else
    					val[i][k]=(dungeon[i][k]+val[i+1][k]>0?0:dungeon[i][k]+val[i+1][k]);
    			}
    		}
    	}
		return 1-val[0][0];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon ={
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
		};
		DungeonGame a = new DungeonGame();
		System.out.println(a.calculateMinimumHP(dungeon));

	}

}
