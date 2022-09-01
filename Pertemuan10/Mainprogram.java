/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan10;

/**
 *
 * @author Rafael Mahesa
 */
public class Mainprogram {
    public static void main(String[]args){
        Graph graf = new Graph();
        
        graf.addVertex('A');
        graf.addVertex('B');
        graf.addVertex('C');
        graf.addVertex('D');
        graf.addVertex('F');
        graf.addVertex('G');
        graf.addVertex('H');
        
        graf.addEdge('A', 'B', 5);
        graf.addEdge('A', 'D', 7);
        graf.addEdge('A', 'F', 4);
        graf.addEdge('B', 'C', 7);
        graf.addEdge('B', 'D', 6);
        graf.addEdge('C', 'D', 6);
        graf.addEdge('C', 'G', 9);
        graf.addEdge('C', 'H', 15);
        graf.addEdge('D', 'G', 5);
        graf.addEdge('F', 'G', 9);
        graf.addEdge('G', 'H', 9);
        
        graf.bfs();
        graf.dfs();
        graf.show();
        graf.toString();
    }
}
