import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
public class Digraph interface Bag{
    int V;
    int count=0;
    Bag<Integer>[] adj;
    public void Digraph(int V){
        this.V=V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>();
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public int size(){
        return adj.length;
    }
}