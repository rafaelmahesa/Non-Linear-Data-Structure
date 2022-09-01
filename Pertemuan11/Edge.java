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
public class Edge {
    private int vertexA, vertexB, weight;

    public Edge(int vertexA, int vertexB, int weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    public void setVertexA(int vertexA) {
        this.vertexA = vertexA;
    }

    public void setVertexB(int vertexB) {
        this.vertexB = vertexB;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVertexA() {
        return vertexA;
    }

    public int getVertexB() {
        return vertexB;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        char[] alphabet={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char verA=alphabet[vertexA], verB=alphabet[vertexB];
        return verA+ " ---> "+verB+" = "+weight;
    }
}
