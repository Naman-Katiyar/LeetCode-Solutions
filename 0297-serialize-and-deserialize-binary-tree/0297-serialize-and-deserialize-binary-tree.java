/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx = 0;

    //preorder traversal - for serialize()
    private void preOrder(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null,");
            return;
        }

        s.append(root.val).append(",");

        preOrder(root.left, s);
        preOrder(root.right, s);
    }

    //build tree - for deserialize()
    private TreeNode build(String[] nodes) {
         if (nodes[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;

        root.left = build(nodes);
        root.right = build(nodes);

        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        preOrder(root, s);

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        return build(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));