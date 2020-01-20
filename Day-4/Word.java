/*
    Author:bindu
*/
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Word {
    private Digraph vertex;
    private SAP s;
    ArrayList<String> arr1=new ArrayList<String>();
    ArrayList<String> arr2=new ArrayList<String>();
    ArrayList<String> arr3=new ArrayList<String>();
    ArrayList<String> arr4=new ArrayList<String>();
    HashMap<Integer,Bag<String>> wmap=new HashMap<>();;
    HashMap<Integer,Bag<Integer>> imap=new HashMap<>();;
    public Word() throws FileNotFoundException {
        this.synsets(f);
        vertex=new Digraph(arr1.size());
        this.hypernyms(f1);
        System.out.println(vertex.size());
        int c=0;
        for(int i=0;i<vertex.size();i++){
            c=c+vertex.adj[i].size();
        }
        System.out.println(c);
        s = new SAP(vertex);//short path
    }
    static File f=new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Day-1\\synsets.txt");
    public void synsets(File f) throws FileNotFoundException {
        Scanner sc=new Scanner(f);
        while(sc.hasNextLine()){
            String[] a=sc.nextLine().split(",");
            arr1.add(a[0]);
        }
    }
    static File f1=new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Day-1\\hypernyms.txt");
    public void hypernyms(File f1) throws FileNotFoundException {
        Scanner sc1=new Scanner(f1);
        while (sc1.hasNextLine()) {
            String[] b=sc1.nextLine().split(",");
            arr3.add(b[0]);
            int c=0;
            for(int i=1;i<b.length;i++){
                vertex.addEdge(Integer.parseInt(b[c]),Integer.parseInt(b[i]));
            }
            for(int i=1;i<b.length;i++){
                arr4.add(b[i]);
            }
        }
    }
    public Iterable<String> nouns(){
        return wmap.key();
    }
    public int distance(String nounA,String nounB){
        isNoun(nounA);
        isNoun(nounB);
        return s.length(imap.get(nounA),imap.get(nounB));
    }
    public String sap(String nounA,String nounB){
        if(nounA==null || nounB==null){
            throw new java.lang.IllegalArgumentException();
        }
        if(isNoun(nounA) || isNoun(nounB)){
            throw new java.lang.IllegalArgumentException();
        }
        ArrayList<Integer> A=
    }
    public boolean isNoun(String word){
        return imap.containsKey(word);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Word w=new Word();
        w.synsets(f);
        w.hypernyms(f1);
    }
}