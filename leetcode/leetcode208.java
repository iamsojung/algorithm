class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean flag = false;
        
        public Node() { 
        } 
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        
        Node curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new Node();
            }
            
            curr = curr.children[ch-'a'];
        }
        
        curr.flag = true;
        
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a']==null){
                return false;
            }
            
            curr = curr.children[ch-'a'];
        }
        
        if(curr.flag)
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            
            if(curr.children[ch-'a']==null){
                return false;
            }
            
            curr = curr.children[ch-'a'];
        }
        
        
        return true;
    }
}
