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
public class ListTree {
    private ListTreeNode firstNode;
    private ListTreeNode lastNode;
    private String name;

    public ListTree() {
        this("list");
    }

    public ListTree(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void insertAtFront(TreeNode insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListTreeNode(insertItem);
        } else {
            firstNode = new ListTreeNode(insertItem, firstNode);
        }
    }

    public void insertAtBack(TreeNode insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListTreeNode(insertItem);
        } else {
            lastNode = lastNode.nextNode = new ListTreeNode(insertItem, firstNode);
        }
    }

    public TreeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        TreeNode removeItem = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }
        return removeItem;
    }

    public TreeNode removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        TreeNode removeItem = lastNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListTreeNode current = firstNode;
            while (current.nextNode != lastNode) {
                current = current.nextNode;
            }
            lastNode = current;
            current.nextNode = null;
        }
        return removeItem;
    }

    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty " + name);
        }
        System.out.println("The " + name + " is: ");
        ListTreeNode current = firstNode;
        while (current != null) {
            System.out.print(current.data.toString() + " ");
            current = current.nextNode;
        }
        System.out.println("\n");
    }
}
