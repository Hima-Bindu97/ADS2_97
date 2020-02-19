// import java.io.*;
// import java.util.*;
// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.PriorityQueue;

// public class Solution {    
//     public class Edge implements Comparable<Edge>{
//         public int v;
//         public int w;
//         public double weight;
//         public Edge(int v,int w,double weight){
//             this.v=v;
//             this.w=w;
//             ths.weight=weight;
//         }
//         public int either(){
//             return v;
//         }
//         public int other(int vertex){
//             if(vertex==v){
//                 return w;
//             }
//             else{
//                 return v;
//             }
//         }
//         public int compareTo(Edge that){
//             if(this.weight<that.weight){
//                 return -1;
//             }
//             else if(this.weight>that.weight){
//                 return 1;
//             }
//             else{
//                 return 0;
//             }
//         }
//     }
//     public static void main(String[] args) {
//         Edge edge=new Edge();
//         Scanner sc=new Scanner(System.in);
//         while(sc.hasNextLine()){
//             int N=sc.nextInt();
//             if(N==0){
//                 break;
//             }
//             int arr[][]=new int[N][N];
//             for(int i=0;i<N;i++){
//                 for(int j=0;j<N;j++){
//                     arr[i][j]=Integer.MAX_VALUE;
//                 }
//             }
//             int source=sc.nextInt()-1;
//             int dest=sc.nextInt()-1;
//             int dis=new int[N];
//             Arrays.fill(dis,Integer.MAX_VALUE;
//             dis[source]=0;
//             PriorityQueue<Edge> pq=new PriorityQueue<>();
//             while(!queue.isEmpty()){
//                 edge=queue.poll();
//                 if(edge.dest=dest){
//                     break;
//                 }
//                 for(int i=0;i<N;i++){
//                     if(dis[i]>weight){
//                         dis[i]=weight;
//                     }
//                 }
//             }
            
//         }
        
//         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//     }
// }