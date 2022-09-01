/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan04;

/**
 *
 * @author Rafael Mahesa
 */
public class Tree {
    private TreeNode root;
    int height = -1;

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
    public void depth(int key){
        TreeNode temp = root;
        int depth = 0;
        if(root == null){
            depth = 0;
        }
        else{
            while (temp != null){
                if (key == temp.getData()){
                    System.out.println("Depth dari node "+key+" adalah "+depth);
                    break;
                }
                else{
                    if (key <= temp.getData()){
                        temp = temp.getLeftNode();
                        depth++;
                    }
                    else{
                        temp = temp.getRightNode();
                        depth++;
                    }
                }
            }
        }
    }
    public void height(int key){
        heightHelper(root, key);
        System.out.println("Height dari node "+key+" adalah "+height);
    }
    public int heightHelper(TreeNode localroot, int key){
        if(localroot == null){
            return -1;
        }
        int leftHeight = heightHelper(localroot.getLeftNode(), key);
        int rightHeight = heightHelper(localroot.getRightNode(), key);
        int answer = Math.max(leftHeight, rightHeight) + 1;
        if (localroot.getData() == key){
            height = answer;
        }
        return answer;
    }
    public void leaf(){
        System.out.println("Jumlah node leaf yang ada di pohon: "+leafCount(root));
    }
    public int leafCount(TreeNode node){
        if (node == null)
            return 0;
        if (node.getLeftNode() == null && node.getRightNode() == null)
            return 1;
        else
            return leafCount(node.getLeftNode()) + leafCount(node.getRightNode());
    }
    public void descendant(int key){
        if (search(key) == null){
            System.out.println("Data tidak ditemukan pada Tree");
        }
        else{
            System.out.print("Descendant dari node "+key+" adalah: ");
            TreeNode temp = search(key);
            preorderHelper(temp.getLeftNode());
            preorderHelper(temp.getRightNode());
            System.out.println("");
        }
    }
    public void preorderHelper(TreeNode localRoot){
        if(localRoot != null){
            System.out.print(localRoot.getData()+ " ");
            preorderHelper(localRoot.getLeftNode());
            preorderHelper(localRoot.getRightNode());
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
        
        int cari = 38;
        pohon.leaf();
        pohon.depth(cari);
        pohon.height(cari);
        pohon.descendant(cari);
    }
}
