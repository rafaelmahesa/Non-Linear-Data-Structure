/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan05;

/**
 *
 * @author Rafael Mahesa
 */
public class Tree2 {

    private TreeNode root;

    Tree2() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insertNode(int data) {
        if (getRoot() == null) {
            setRoot(new TreeNode(data));
        } else {
            getRoot().insert(data);
        }
    }

    public TreeNode search(int data) {
        TreeNode bantu = root;
        if (root == null) {
            return null;
        } else {
            while (bantu != null) {
                if (data == bantu.getData()) {
                    return bantu;
                } else {
                    if (data > bantu.getData()) {
                        bantu = bantu.getRightNode();
                    } else {
                        bantu = bantu.getLeftNode();
                    }
                }
            }
        }
        return null;
    }

    public void preorderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(TreeNode localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            preOrderHelper(localRoot.getLeftNode());
            preOrderHelper(localRoot.getRightNode());
        }
    }

    public void inorderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(TreeNode localRoot) {
        if (localRoot != null) {
            inOrderHelper(localRoot.getLeftNode());
            System.out.print(localRoot.getData() + " ");
            inOrderHelper(localRoot.getRightNode());
        }
    }

    public void postorderTraversal() {
        postOrderHelper(root);
    }

    private void postOrderHelper(TreeNode localRoot) {
        if (localRoot != null) {
            postOrderHelper(localRoot.getLeftNode());
            postOrderHelper(localRoot.getRightNode());
            System.out.print(localRoot.getData() + " ");
        }
    }

    public TreeNode leaf(TreeNode data) {
        TreeNode bantu = search(data.getData());
        if (bantu.getLeftNode() == null
                && bantu.getRightNode() == null) {
            return bantu;
        } else {
            return null;
        }
    }

    public boolean delete(int data) {
        TreeNode bantu = getCurrent(data);
        TreeNode parent = getParent(data);
        if (bantu == null) {
            return false;
        } else if (bantu == root) {
            if (bantu == leaf(bantu)) {
                bantu = null;
            } else {
                if (bantu.getLeftNode() == null) {
                    root = bantu.getRightNode();
                } else if (bantu.getRightNode() == null) {
                    root = bantu.getLeftNode();
                }
            }
            return true;
        } else {
            if (bantu == leaf(bantu)) {
                if (bantu.getData() > parent.getData()) {
                    parent.setRightNode(null);
                } else {
                    parent.setLeftNode(null);
                }
            } else {
                if (bantu.getLeftNode() == null) {
                    if (bantu.getRightNode().getData() > parent.getData()) {
                        parent.setRightNode(bantu.getLeftNode());
                    } else {
                        parent.setLeftNode(bantu.getRightNode());
                    }
                } else if (bantu.getRightNode() == null) {
                    if (bantu.getLeftNode().getData() > parent.getData()) {
                        parent.setRightNode(bantu.getRightNode());
                    } else {
                        parent.setLeftNode(bantu.getLeftNode());
                    }
                }
            }
            return true;
        }
    }

    public TreeNode getCurrent(int data) {
        return search(data);
    }

    public TreeNode getParent(int data) {
        TreeNode bantu = root;
        TreeNode parent = null;
        while (bantu != null) {
            if (bantu.getData() == data) {
                return parent;
            } else if (bantu.getData() > data) {
                parent = bantu;
                bantu = bantu.getLeftNode();
            } else {
                parent = bantu;
                bantu = bantu.getRightNode();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Tree2 obj = new Tree2();
        obj.insertNode(42);
        obj.insertNode(21);
        obj.insertNode(38);
        obj.insertNode(27);
        obj.insertNode(71);
        obj.insertNode(82);
        obj.insertNode(55);
        obj.insertNode(63);
        obj.insertNode(6);
        obj.insertNode(2);
        obj.insertNode(40);
        obj.insertNode(12);

        System.out.println("Root: " + obj.root.getData());
        System.out.println(" Data sebelum dihapus");
        System.out.println("--> Inorder");
        obj.inorderTraversal();
        System.out.println("");

        obj.delete(12);
        obj.delete(27);
        obj.delete(6);
        obj.delete(55);

        System.out.println("\n");
        System.out.println("Data sesudah dihapus");
        System.out.println("");
        System.out.println("--> Inorder");
        obj.inorderTraversal();
        System.out.println("");
    }
}
