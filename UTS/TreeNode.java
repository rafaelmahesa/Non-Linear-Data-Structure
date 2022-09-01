/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

/**
 *
 * @author Rafael Mahesa
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode, rightNode, parent;

    public TreeNode(int data){
        this.data = data;
        leftNode = null;
        rightNode = null;
    }
    
    public void insert(int dat){
        if(dat<=getData()){
            if(getLeftNode()==null){
                setLeftNode(new TreeNode(dat));
                System.out.println("Berhasil menambahkan " + dat);
            }
            else{
                getLeftNode().insert(dat);
            }
        }
        else{
            if(getRightNode()==null){
                setRightNode(new TreeNode(dat));
                System.out.println("Berhasil menambahkan " + dat);
            }
            else{
                getRightNode().insert(dat);
            }
        }
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
    
    public void setParent(TreeNode parent){
        this.parent = parent;
    }
    public TreeNode getParent(){
        return parent;
    }
    public boolean isInternal(){
        if(leftNode==null&&rightNode==null) return false;
        else return true;
    }
}
