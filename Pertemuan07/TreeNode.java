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
public class TreeNode {
    TreeNode leftNode;
    char data;
    TreeNode rightNode;

    public TreeNode(char nodeData) {
        data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(char insertValue) {
        if (insertValue < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue);
            } else {
                leftNode.insert(insertValue);
            }
        } else if (insertValue > data) {
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }
}
