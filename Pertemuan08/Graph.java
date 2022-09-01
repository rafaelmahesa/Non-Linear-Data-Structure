/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan08;

/**
 *
 * @author Rafael Mahesa
 */
public class Graph {
    private int maxVertex = 10;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int countVertex = 0;
    
    public Graph(){
        vertexList = new Vertex[maxVertex];
        adjacencyMatrix = new int[maxVertex][maxVertex];
        for(int i=0; i<maxVertex; i++){
            for(int j=0; j<maxVertex; j++){
                if(i==j){
                    adjacencyMatrix[i][j] = 0;
                }
                else{
                    adjacencyMatrix[i][j] = -1;
                }
            }
        }
        countVertex=0;
    }
    public void addVertex(char data){
        if(countVertex<maxVertex){
            vertexList[countVertex]=new Vertex(data);
            countVertex++;
        }
    }
    public void addEdge(int a, int b, int c){
        adjacencyMatrix[a][b]=c;
        adjacencyMatrix[b][a]=c;
    }
    public void addEdge(char a, char b, int c){
        addEdge(indexVertex(a), indexVertex(b), c);
    }
    public int indexVertex(char index){
        for(int i=0; i<countVertex; i++){
            if(vertexList[i].label==index){
                return i;
            }
        }
        return -1;
    }
    public void show(){
        for(int i=0; i<countVertex; i++){
            for(int j=0; j<countVertex; j++){
                if(adjacencyMatrix[i][j]>0){
                    System.out.print(vertexList[i].label+" terhubung ke "+vertexList[j]
                            .label+" dengan beban "+adjacencyMatrix[i][j]+"\n");
                }
            }
        }
    }
    public static void main(String[]args){
        Graph graph = new Graph();
        
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('e');
        graph.addVertex('f');
        
        graph.addEdge('a', 'b', 4);
        graph.addEdge('a', 'f', 5);
        graph.addEdge('b', 'c', 5);
        graph.addEdge('b', 'f', 2);
        graph.addEdge('b', 'e', 4);
        graph.addEdge('c', 'f', 3);
        graph.addEdge('c', 'e', 2);
        graph.addEdge('e', 'f', 10);
        
        graph.show();
    }
}
