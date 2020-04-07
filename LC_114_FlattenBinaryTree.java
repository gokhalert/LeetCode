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
    public void flatten(TreeNode root) {
        if(root != null)
            getFlatten(root);
    }
    
    public Pair<TreeNode,TreeNode> getFlatten(TreeNode cnode)
    {
        if(cnode.left == null && cnode.right == null)
            return new Pair<TreeNode,TreeNode>(cnode,cnode);
        
        Pair<TreeNode,TreeNode> lres = null;
        Pair<TreeNode,TreeNode> rres = null;
        Pair<TreeNode,TreeNode> res = null;
        
        if(cnode.left != null)
            lres = getFlatten(cnode.left);
        
        if(cnode.right != null)
            rres = getFlatten(cnode.right);
        
        if(lres != null)
        {
            cnode.right = lres.getKey();
            if(rres != null)
            {
                lres.getValue().right = rres.getKey();
                res = new Pair<TreeNode,TreeNode>(cnode,rres.getValue());
            }
            else
            {
                res = new Pair<TreeNode,TreeNode>(cnode,lres.getValue());
            }
            cnode.left = null;
        }
        else
        {
            if(rres != null)
            {
                cnode.right = rres.getKey();
                 res = new Pair<TreeNode,TreeNode>(cnode,rres.getValue());
            }
            else
            {
                 res = new Pair<TreeNode,TreeNode>(cnode,cnode);
            }
        }
        return res;
    }
}
