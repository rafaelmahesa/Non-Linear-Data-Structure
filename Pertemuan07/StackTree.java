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
public class StackTree {
    private ListTree stackListTree;
    
    public StackTree(){
        stackListTree = new ListTree();
    }
    public void push(TreeNode node){
        stackListTree.insertAtFront(node);
    }
    public TreeNode pop(){
        return stackListTree.removeFromFront();
    }
    public boolean IsEmpty(){
        return stackListTree.isEmpty();
    }
    public void print(){
        stackListTree.print();
    }
}
