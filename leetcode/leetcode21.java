class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {        
        
        ListNode ret = null;
        ListNode cur = null;
        
        while(l1!=null || l2 !=null){ //l1이나 l2에 값이 있을 때 루프 돌아야함
            
            //리스트 두개가 있는데 2개중 어떤 값을 취할지 해줘야함
            
            if(l2 == null || (l1!=null && l1.val<l2.val)){ //l1에서 고르는 조건
                //l2가 null이고, l1은 null이 아닐 때 둘다 값이 있을땐 l2값이 클때
                
                if(ret==null){//리턴 처음 취하는 경우 
                    ret = l1;
                    cur = l1;
                    l1 = l1.next;
                    
                }else{                    
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                }                
            }else{
                //l2에서 고르는 조건                
                if(ret==null){//리턴 처음 취하는 경우 
                    ret = l2;
                    cur = l2;
                    l2 = l2.next;
                    
                }else{                   
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            }
        }        
        return ret;        
    }
}
