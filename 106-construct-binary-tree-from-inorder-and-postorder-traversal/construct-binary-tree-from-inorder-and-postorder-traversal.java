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
    public TreeNode build(int inStart , int inEnd , int pStart , int pEnd , int[] inorder , int[] postorder){
        if(inStart > inEnd || pStart > pEnd) return null;

        int rval = postorder[pEnd];
        TreeNode rootNode = new TreeNode(rval);
        int rI = -1;
        for(int i = inStart ; i <= inEnd ; i++){
            if(rval == inorder[i]){
                rI = i;
                break;
            }
        }

        int left_size = rI - inStart;

        rootNode.left = build(inStart , rI - 1 , pStart, pStart + left_size - 1, inorder , postorder);
        rootNode.right = build(rI + 1 , inEnd  , pStart + left_size , pEnd - 1 , inorder , postorder);



        return rootNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;

        return build(0 , inorder.length - 1 , 0 , postorder.length - 1, inorder , postorder );
    }
}