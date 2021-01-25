/** 
	https://leetcode.com/problems/binary-tree-right-side-view/
**/

/** Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int level = -1;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // if (root == null) {
        //     return null;
        // }
        find_list(root, 0);
        return ans;
    }
    
    void find_list(TreeNode node, int lev) {
        if(node != null)
            System.out.println(" Node.val-- "+node.val);
        if (node != null) {
            System.out.println("Adding - "+node.val);
            if(lev > level) {
                ans.add(node.val);
                level = lev;
            } 
            find_list(node.right, lev+1);
            find_list(node.left, lev+1);
        }
    }
}