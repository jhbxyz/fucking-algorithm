package com.aboback.binary_tree.day2;

import com.aboback.binary_tree.TreeNode;

/**
 * 力扣第 105 题
 * 通过前序和中序遍历结果构造二叉树
 *
 * @author jhb
 * @date 2020/12/08
 */
public class Demo2 {


    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 若前序遍历数组为 preorder[preStart..preEnd]，
     * 后续遍历数组为 postorder[postStart..postEnd]，
     * 构造二叉树，返回该二叉树的根节点
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];

        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, index, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

}
