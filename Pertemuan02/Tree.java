/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan02;

/**
 *
 * @author Rafael Mahesa
 */
public class Tree {
    private TreeNode root;

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

        TreeNode cari1, cari2;
        cari1 = pohon.search(71);
        cari2 = pohon.search(13);

        System.out.println();
        System.out.println("Cari 71 di Tree");
        if (cari1 == null) {
            System.out.println("Data tidak ada di Tree");
        } else {
            System.out.println("Data ada di Tree");
        }
        System.out.println();
        System.out.println("Cari 13 di Tree");
        if (cari2 == null) {
            System.out.println("Data tidak ada di Tree");
        } else {
            System.out.println("Data ada di Tree");
        }
    }
}
