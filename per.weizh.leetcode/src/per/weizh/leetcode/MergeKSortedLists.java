package per.weizh.leetcode;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class MergeKSortedLists {
	public ListNode merge(ListNode a,ListNode b){

		ListNode ptr = new ListNode(0);
		ListNode tmp = ptr;
		ListNode aPtr = a, bPtr = b;
		while(aPtr != null || bPtr != null){
			if(aPtr == null){
				ptr.next = bPtr;
				ptr = ptr.next;
				bPtr = bPtr.next;
			} else if(bPtr == null){
				ptr.next = aPtr;
				ptr = ptr.next;
				aPtr = aPtr.next;
			} else if(aPtr.val  <= bPtr.val){
				ptr.next = aPtr;
				ptr = ptr.next;
				aPtr = aPtr.next;
			} else {
				ptr.next = bPtr;
				ptr = ptr.next;
				bPtr = bPtr.next;
			}
		}
//		ListNode t = tmp.next;
//		while(t != null){
//			
//			System.out.println(t.val);
//			t= t.next;
//		}
		return tmp.next;
		
	}
	public ListNode mergeSort(ListNode[]lists,int start,int end){
		if(start==end)
			return lists[end];
		if(start > end) return null;
		ListNode a = mergeSort(lists,start,(start+end)/2);
		ListNode b = mergeSort(lists,(start+end)/2+1,end);
		ListNode r = merge(a,b);
		return r;
		
	}
    public ListNode mergeKLists(ListNode[] lists) {
    	if( lists.length == 1)
    		return lists[0];
    	if( lists.length == 0)
    		return null;
    	ListNode r = mergeSort(lists,0,lists.length-1);
		return r;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode[4];
		lists[0] = new ListNode(4);
		lists[1] = new ListNode(4);
		System.out.println(lists[0].val);
		
		lists[2]= new ListNode(5);
		lists[2].next = new ListNode(7);
		MergeKSortedLists a = new MergeKSortedLists();
		ListNode t = a.mergeKLists(lists);
		while(t!=null){
			System.out.println(t.val);
			t = t.next;
		}
//		System.out.println("test");
//		ListNode test1 = null;
//		ListNode test2 = new ListNode(1);
//		ListNode test3 = a.merge(test1, test2);
//		while(test3!=null){
//			System.out.println(test3.val);
//			test3 = test3.next;
//		}
	}

}
