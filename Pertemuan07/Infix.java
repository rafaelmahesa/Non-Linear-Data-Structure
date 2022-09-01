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
public class Infix {
    char ung[];
    KonstantaInfix karInfix = new KonstantaInfix();
    StackTree opr;
    StackTree opd;

    public Infix(char ung_in[]) {
        ung = ung_in;
    }

    public int valensi(char data_in) {
        if (data_in == '^') {
            return 3;
        } else if ((data_in == '*') || (data_in == '/')) {
            return 2;
        } else if ((data_in == '+') || (data_in == '-')) {
            return 1;
        } else if (data_in == '(') {
            return 0;
        } else {
            return -1;
        }
    }

    public TreeNode gabung() {
        TreeNode phn = opr.pop();
        phn.rightNode = opd.pop();
        phn.leftNode = opd.pop();
        return phn;
    }

    public TreeNode buatPohon() {
        char kar;
        TreeNode treeKar;
        TreeNode cek;
        opr = new StackTree();
        opd = new StackTree();

        for (int i = 0; i < ung.length; i++) {
            kar = ung[i];
            karInfix.setData(kar);
            if (kar != ' ') {
                treeKar = new TreeNode(kar);
                if (kar == '(') {
                    opr.push(treeKar);
                } else if (kar == ')') {
                    cek = opr.pop();
                    opr.push(cek);
                    while (cek.data != '(') {
                        opd.push(gabung());
                        cek = opr.pop();
                        opr.push(cek);
                    }
                    opr.pop();
                } else if (karInfix.isOperator()) {
                    cek = opr.pop();
                    opr.push(cek);
                    while ((cek != null) && (valensi(kar) <= valensi(cek.data))) {
                        opd.push(gabung());
                        cek = opr.pop();
                        opr.push(cek);
                    }
                    opr.push(treeKar);
                } else if (karInfix.isOperand()) {
                    opd.push(treeKar);
                } else {
                    return null;
                }
            }
        }
        cek = opr.pop();
        opr.push(cek);
        while (cek != null) {
            opd.push(gabung());
            cek = opr.pop();
            opr.push(cek);
        }
        cek = opd.pop();
        opr = null;
        opd = null;
        return cek;
    }
}
