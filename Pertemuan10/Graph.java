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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
                    adjacencyMatrix[i][j] = 0;
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
        System.out.println();
    }
    public void bfs(){
        int seed=0;
        Queue queue = new LinkedList();
        queue.add(seed);
        System.out.print("Hasil Output BFS: ");
        while(queue.isEmpty()==false){
            int bantu = (int)queue.remove();
            if(vertexList[bantu].flagVisited!=true){
                System.out.print(vertexList[bantu].label+" ");
                vertexList[bantu].flagVisited=true;
                for(int i=0; i<countVertex; i++){
                    if(adjacencyMatrix[bantu][i]>=1 && vertexList[i].flagVisited==false){
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println("\n");
        for(int j=0; j<countVertex; j++){
            vertexList[j].flagVisited=false;
        }
    }
    public void dfs(){
        int seed=0;
        Stack stack = new Stack();
        stack.push(seed);
        System.out.print("Hasil Output DFS: ");
        while(stack.isEmpty()==false){
            int bantu = (int)stack.pop();
            if(vertexList[bantu].flagVisited!=true){
                System.out.print(vertexList[bantu].label+" ");
                vertexList[bantu].flagVisited=true;
                for(int i=countVertex-1; i>=0; i--){
                    if(adjacencyMatrix[bantu][i]>=1 && vertexList[i].flagVisited==false){
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println("\n");
        for(int j=0; j<countVertex; j++){
            vertexList[j].flagVisited=false;
        }
    }
    @Override
    public String toString(){
        for(int i=0; i<countVertex; i++){
            for(int j=0; j<countVertex; j++){
                System.out.print(adjacencyMatrix[i][j]+"\t");
                }
            System.out.println();
            }
        return "";
     }
}
