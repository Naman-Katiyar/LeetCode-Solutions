/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    int[] arr = new int[10];
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        arr[root.val]++;

        int cnt = 0;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    cnt++;
                }
            }

            if (cnt <= 1) {
                ans++;
            }
        }

        dfs(root.left);
        dfs(root.right);

        arr[root.val]--;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return ans;
    }
}