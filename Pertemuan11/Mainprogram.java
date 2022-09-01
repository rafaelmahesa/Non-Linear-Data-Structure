/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan11;

/**
 *
 * @author Rafael Mahesa
 */
import java.util.ArrayList;
public class Mainprogram {
    public static void main(String[]args){
        Graph graf = new Graph();
        int beban = 0;
        
        graf.addVertex('A');
        graf.addVertex('B');
        graf.addVertex('C');
        graf.addVertex('D');
        graf.addVertex('E');
        graf.addVertex('F');
        graf.addVertex('G');
        graf.addVertex('H');
        graf.addVertex('I');
        graf.addVertex('J');
        
        graf.addEdge('A', 'B', 5);
        graf.addEdge('A', 'C', 5);
        graf.addEdge('B', 'D', 4);
        graf.addEdge('B', 'E', 9);
        graf.addEdge('C', 'D', 4);
        graf.addEdge('C', 'F', 7);
        graf.addEdge('D', 'E', 8);
        graf.addEdge('D', 'F', 6);
        graf.addEdge('E', 'F', 10);
        graf.addEdge('E', 'G', 10);
        graf.addEdge('E', 'H', 8);
        graf.addEdge('E', 'I', 9);
        graf.addEdge('F', 'G', 3);
        graf.addEdge('G', 'H', 6);
        graf.addEdge('G', 'J', 7);
        graf.addEdge('H', 'I', 4);
        graf.addEdge('H', 'J', 6);
        graf.addEdge('I', 'J', 7);
        
        graf.show();
        ArrayList<Edge> mst = graf.getPrimEdges();
        for(int i=0; i<mst.size(); i++){
            System.out.println(mst.get(i).toString());
            beban+=mst.get(i).getWeight();
        }
        System.out.println("Maka berat Minimum Spanning Tree tersebut = "+beban);
    }
}
