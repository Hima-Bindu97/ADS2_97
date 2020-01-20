/*
    Author:bindu
*/
import java.util.ArrayList;
import java.util.HashMap;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
public class WordNet {
    private Digraph vertex;
    private SAP sap;
    private HashMap<Integer,String> wmap;
    private HashMap<String,ArrayList<Integer>> imap;
    public WordNet(String Synset,String Hypernyms){
        wmap=new HashMap<Integer,String>();
        imap=new HashMap<String,ArrayList<Integer>>();
        this.synsets(Synset);
        vertex=new Digraph(wmap.size());
        this.hypernyms(Hypernyms);
        sap=new SAP(vertex);
    }
    private void synsets(String f)  {
        In sc=new In(f);
        while(sc.hasNextLine()){
            String[] a=sc.readLine().split(",");
            String[] b=a[1].split(" ");
            for(String str:b){
                wmap.put(Integer.parseInt(a[0]),a[1]);
                if(!imap.containsKey(str)){
                    imap.put(str,new ArrayList<Integer>());
                }
            }
        }
    }
    private void hypernyms(String f1) {
        In sc1=new In(f1);
        while (sc1.hasNextLine()) {
            String[] b=sc1.readLine().split(",");
            for(int i=1;i<b.length;i++){
                vertex.addEdge(Integer.parseInt(b[0]),Integer.parseInt(b[i]));
            }
        }
    }
    public Iterable<String> nouns(){
        return imap.keySet();
    }
    public int distance(String nounA,String nounB){
        if(!isNoun(nounA) || !isNoun(nounB)){
            throw new IllegalArgumentException();
        }
        else{
            return sap.length(imap.get(nounA),imap.get(nounB));
        }
    }
    public String sap(String nounA,String nounB){
        return wmap.get(sap.ancestor(imap.get(nounA),imap.get(nounB)));
    }
    public boolean isNoun(String word){
        return imap.containsKey(word);
    }
}