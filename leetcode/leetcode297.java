public class Codec {

    StringBuilder sb;
   
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        add(root);
        return sb.toString();
    }

    void add(TreeNode root) {
        if(root != null) {
            sb.appendCodePoint(root.val + 1000);
            add(root.left);
            add(root.right);
        } else {
            sb.appendCodePoint(2048);
        }
    }

    String data;
    int i;
    public TreeNode deserialize(String data) {
        // print(data);
        this.data = data;
        this.i = 0;
        return read();
    }
    
    TreeNode read() {
        if(i >= data.length())
            return null;
        final int cp = data.codePointAt(i++);
        if(cp == 2048)
            return null;

        final TreeNode node = new TreeNode(cp - 1000);
        node.left = read();
        node.right = read();
        return node;
    }
}
