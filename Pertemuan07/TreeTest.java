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
public class TreeTest {
    public static void main(String[]args){
        String s1 = "(A+B)";
        String s2 = "(A+B)*((B-C)+D)";
        String s3 = "(A+B*C)^((P+Q)*R)";
        char notasi[] = new char[s1.length()];
        s1.getChars(0, s1.length(), notasi, 0);
        char notasi2[] = new char[s2.length()];
        s2.getChars(0, s2.length(), notasi2, 0);
        char notasi3[] = new char[s3.length()];
        s3.getChars(0, s3.length(), notasi3, 0);
        
        Tree tree = new Tree();
        Infix infix = new Infix(notasi);
        Tree tree2 = new Tree();
        Infix infix2 = new Infix(notasi2);
        Tree tree3 = new Tree();
        Infix infix3 = new Infix(notasi3);
        
        tree.setRootTree(infix.buatPohon());
        tree2.setRootTree(infix2.buatPohon());
        tree3.setRootTree(infix3.buatPohon());
        
        System.out.print("Prefix: ");
        tree.preorderTraversal();
        System.out.println("");
        System.out.print("Infix: ");
        tree.inorderTraversal();
        System.out.println("");
        System.out.print("Postfix: ");
        tree.postorderTraversal();
        System.out.println("\n");
        System.out.print("Prefix: ");
        tree2.preorderTraversal();
        System.out.println("");
        System.out.print("Infix: ");
        tree2.inorderTraversal();
        System.out.println("");
        System.out.print("Postfix: ");
        tree2.postorderTraversal();
        System.out.println("\n");
        System.out.print("Prefix: ");
        tree3.preorderTraversal();
        System.out.println("");
        System.out.print("Infix: ");
        tree3.inorderTraversal();
        System.out.println("");
        System.out.print("Postfix: ");
        tree3.postorderTraversal();
        System.out.println("");
    }
}
