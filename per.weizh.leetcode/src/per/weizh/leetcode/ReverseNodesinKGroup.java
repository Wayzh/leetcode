package per.weizh.leetcode;

 //Definition for singly-linked list.

 
public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode p = head;
    	ListNode phead = null;
    	//tail 用来记录上一条链的尾巴
    	ListNode tail = null;
    	//tmp_tail 用来记录下一条链的尾巴
    	ListNode tmp_tail = null;
    	
    	//before记录反转的上一节点
    	ListNode before = null;
    	ListNode a = head;
    	int size = 0,flag = 0,count = 0;
    	while( a != null){
    		size++;
    		a = a.next;
    	}	
    	if(k > size || k <= 1)
    		return head;
    	while(p.next != null){
    		count++;
    		if(count%k == 0){
    			if(flag == 0 ){
    				phead = p;
    				p = p.next;
    				phead.next = before;
    				tail = head;
    				
    			}else{
    				
    				tail.next = p;
    				p = p.next;
    				tail.next.next = before;
    				tail = tmp_tail ;
    				
    			}
    			flag++;
    			before = null;
    			tmp_tail = p;
    			if(size - count < k ){
    				tail.next = p;
    				return phead;
    			}
    			continue;
    		}
    		ListNode tmp = p;
    		p = p.next;
    		tmp.next = before;
    		before = tmp;
    	}
    	if(flag == 0){
    		phead=p;
    		phead.next = before;
    	}else{
        	tail.next = p;
        	tail.next.next = before;
        	tmp_tail.next = null;
    	}

		return phead;
        
    }
    public static void main(String[] args) {
		
    	
    	System.out.println("test");
//		ListNode a = new ListNode(5);
//		ListNode b = new ListNode(4,a);
//		ListNode c = new ListNode(3,b);
//		ListNode d = new ListNode(2,c);
		ListNode e = new ListNode(1);
		ListNode head = new ListNode(0,e);
		ReverseNodesinKGroup test = new ReverseNodesinKGroup();
		ListNode tmp = test.reverseKGroup(head, 2);
		while(tmp != null){
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
		
		System.out.println("end");
		
	}
}
