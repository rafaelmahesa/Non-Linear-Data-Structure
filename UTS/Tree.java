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
public class Tree {
    private TreeNode root;
    int internalCount;

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
            TreeNode bantu = root;
            while(true){
                if(key <= bantu.getData()){
                    if(bantu.getLeftNode() == null){
                        bantu.setLeftNode(temp);
                        System.out.println("Berhasil menambahkan " + key);
                        break;
                    }
                    else{
                        bantu = bantu.getLeftNode();
                    }
                }
                else{
                    if(bantu.getRightNode() == null){
                        bantu.setRightNode(temp);
                        System.out.println("Berhasil menambahkan " + key);
                        break;
                    }
                    else{
                        bantu = bantu.getRightNode();
                    }
                }
            }
        }
    }

    public TreeNode search(int val){
        TreeNode temp = root;
        if (root == null){
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
            System.out.print("In-Order: ");
            inorderHelper(root.getLeftNode());
            System.out.print(root.getData()+ " ");
            inorderHelper(root.getRightNode());
        }
    }
    public void postorderTraversal(){
        if(root != null){
            System.out.print("Post-Order: ");
            postorderHelper(root.getLeftNode());
            postorderHelper(root.getRightNode());
            System.out.print(root.getData()+ " ");
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
    public void postorderHelper(TreeNode localRoot){
        if(localRoot != null){
            postorderHelper(localRoot.getLeftNode());
            postorderHelper(localRoot.getRightNode());
            System.out.print(localRoot.getData()+ " ");
        }
    }
    
    public void getInternal(){
        if(root != null){
            System.out.print("Internal Node yang ada di dalam Tree: ");
            internalHelper(root);
            System.out.println("\nSebanyak "+internalCount+" node");
        }
    }
    public void internalHelper(TreeNode localroot){
        if(localroot!=null){
            if(localroot.isInternal()==true){
                System.out.print(localroot.getData()+" ");
                internalCount++;
            }
            internalHelper(localroot.getLeftNode());
            internalHelper(localroot.getRightNode());
        }
    }
    
    public static void main(String[] args) {
        Tree pohon = new Tree();
        pohon.insert(40);
        pohon.insert(91);
        pohon.insert(75);
        pohon.insert(74);
        pohon.insert(53);
        pohon.insert(44);
        pohon.insert(20);
        pohon.insert(84);
        
        System.out.println();
        pohon.preorderTraversal();
        System.out.println();
        pohon.inorderTraversal();
        System.out.println();
        pohon.postorderTraversal();
        System.out.println();
        
        System.out.println();
        pohon.getInternal();
    }
}
