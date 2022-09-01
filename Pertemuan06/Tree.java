/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan06;

/**
 *
 * @author Rafael Mahesa
 */
public class Tree {
    private TreeNode root;
    StringBuffer cetak = new StringBuffer();

    public Tree(){
        this.root = null;
    }
    public Tree(TreeNode root){
        this.root = root;
    }
    public void insert(int key){
        TreeNode temp = new TreeNode(key);
        if(root == null){
            root = temp;
            System.out.println("Berhasil menambahkan "+key+" sebagai root");
        }
        else{
            root.insert(key);
        }
    }

    public TreeNode search(int val){
        TreeNode temp = root;
        if(root == null){
            return null;
        }
        else{
            while(temp != null){
                if(val == temp.getData()){
                    return temp;
                }
                else{
                    if(val <= temp.getData()){
                        temp = temp.getLeftNode();
                    }
                    else{
                        temp = temp.getRightNode();
                    }
                }
            }
        }
        return null;
    }
    
    public void setRoot(TreeNode root){
        this.root = root;
    }
    public TreeNode getRoot(){
        return root;
    }
    
    public boolean delete(int data){
        if(root == null){
            return false;
        }
        else{
            TreeNode temp = getCurrent(data);
            TreeNode parent = getParent(data);
            if(temp == null) return false;
            else if (temp == root) {
                if(temp == cekLeaf(temp)) temp = null;
                else{
                    if(temp.getLeftNode() == null) root = temp.getRightNode();
                    else if(temp.getRightNode() == null) root = temp.getLeftNode();         
                }
                return true;
            }
            else{
                if(temp == cekLeaf(temp)){
                    if(temp.getData() <= parent.getData()) parent.setLeftNode(null);
                    else parent.setRightNode(null);
                }
                else if(temp.getLeftNode()!=null && temp.getRightNode()!=null){
                    TreeNode pre = getPredecessor(temp);
                    TreeNode preParent = getParent(pre.getData());
                    temp.setData(pre.getData());
                    if(preParent.getLeftNode().getData()==pre.getData()){
                        preParent.setLeftNode(null);
                    }
                    else{
                        preParent.setRightNode(null);
                    }
                }
                else{
                    if(temp.getRightNode() == null){
                        if (temp.getLeftNode().getData() > parent.getData())
                            parent.setRightNode(temp.getRightNode());
                        else parent.setLeftNode(temp.getLeftNode());
                    }
                    else if(temp.getLeftNode() == null){
                        if (temp.getRightNode().getData() > parent.getData())
                            parent.setRightNode(temp.getLeftNode());
                        else parent.setLeftNode(temp.getRightNode());
                    }
                }
                return true;
            }
        }
    }
    public TreeNode getCurrent(int dat) {
        return search(dat);
    }
    public TreeNode getParent(int dat) {
        TreeNode temp = root;
        TreeNode parent = null;
        while (temp != null) {
            if (dat == temp.getData()){
                return parent;
            }
            else if(dat <= temp.getData()){
                parent = temp;
                temp = temp.getLeftNode();
            }
            else{
                parent = temp;
                temp = temp.getRightNode();
            }
        }
        return null;
    }
    public TreeNode cekLeaf(TreeNode node){
        TreeNode temp = search(node.getData());
        if(temp.getLeftNode() == null && temp.getRightNode() == null){
            return temp;
        }
        else{
            return null;
        }
    }
    public TreeNode getPredecessor(TreeNode node){
        TreeNode temp =node.getLeftNode();
        TreeNode suc = node;
        while(temp.getRightNode() != null){
            suc = temp.getRightNode();
            temp = temp.getRightNode();
        }
        return suc;
    }
    public String print() {        
        getPredecessor(root);     
        StringBuffer temp = new StringBuffer();
        temp.append(cetak);
        cetak.setLength(0);
        return temp.toString();
    }
    
    public void preorderTraversal(){
        if(root != null){
            System.out.print("Pre-Order: ");
            System.out.print(root.getData()+ " ");
            preorderHelper(root.getLeftNode());
            preorderHelper(root.getRightNode());
        }
    }
    public void inorderTraversal(){
        if(root != null){
            System.out.print("In-Order : ");
            inorderHelper(root.getLeftNode());
            System.out.print(root.getData()+ " ");
            inorderHelper(root.getRightNode());
        }
    }
    public void preorderHelper(TreeNode localRoot){
        if(localRoot != null){
            System.out.print(localRoot.getData()+ " ");
            preorderHelper(localRoot.getLeftNode());
            preorderHelper(localRoot.getRightNode());
        }
    }
    public void inorderHelper(TreeNode localRoot){
        if(localRoot != null){
            inorderHelper(localRoot.getLeftNode());
            System.out.print(localRoot.getData()+ " ");
            inorderHelper(localRoot.getRightNode());
        }
    }
    
    public static void main(String[] args) {
        Tree pohon = new Tree();
        pohon.insert(42);
        pohon.insert(21);
        pohon.insert(38);
        pohon.insert(27);
        pohon.insert(71);
        pohon.insert(82);
        pohon.insert(55);
        pohon.insert(63);
        pohon.insert(6);
        pohon.insert(2);
        pohon.insert(40);
        pohon.insert(12);
        
        System.out.println("\nUrutan Pre-Order dan In-Order sebelum maenghapus node");
        pohon.preorderTraversal();
        System.out.println("");
        pohon.inorderTraversal();
        System.out.println("");
        System.out.println("\nMenghapus 21");
        pohon.delete(21);
        pohon.preorderTraversal();
        System.out.println("");
        pohon.inorderTraversal();
        System.out.println("");
        pohon.print();
    }
}
