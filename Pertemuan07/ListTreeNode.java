/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan07;

/**
 *
 * @author Rafael Mahesa
 */
public class ListTreeNode {
    TreeNode data;
    ListTreeNode nextNode;

    ListTreeNode(TreeNode treeNode) {
        this(treeNode, null);
    }

    ListTreeNode(TreeNode treeNode, ListTreeNode node) {
        data = treeNode;
        nextNode = node;
    }

    TreeNode getTreeNode() {
        return data;
    }

    ListTreeNode getNext() {
        return nextNode;
    }
}
