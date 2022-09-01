/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan03;

/**
 *
 * @author Rafael Mahesa
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode, rightNode;

    public TreeNode(int data){
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    
    public void setLeftNode(TreeNode leftNode){
        this.leftNode = leftNode;
    }
    public TreeNode getLeftNode(){
        return leftNode;
    }
    
    public void setRightNode(TreeNode rightNode){
        this.rightNode = rightNode;
    }
    public TreeNode getRightNode(){
        return rightNode;
    }
}
