import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
public class SAP{
    private Digraph g;
    public SAP(Digraph g){
        this.g=new Digraph(g);
    }
    public int length(int v,int w){
            BreadthFirstDirectedPaths b1=new BreadthFirstDirectedPaths(g,v);
            BreadthFirstDirectedPaths b2=new BreadthFirstDirectedPaths(g,w);
            int shor=-1;
			for(int a=0;a<g.V();++a){
                if(b1.hasPathTo(a) && b2.hasPathTo(a)){
                    int dis=b1.distTo(a)+b2.distTo(a);
                    if(shor==-1 || dis<shor){
                        shor=dis;
                    }
                }
            }
            return shor;
    }
    public int ancestor(int v,int w){
        BreadthFirstDirectedPaths b1=new BreadthFirstDirectedPaths(g,v);
        BreadthFirstDirectedPaths b2=new BreadthFirstDirectedPaths(g,w);
        int ancestor=-1;
        int shor=Integer.MAX_VALUE;
        for(int a=0;a<g.V();++a){
            if(b1.hasPathTo(a) && b2.hasPathTo(a)){
                int dis=b1.distTo(a)+b2.distTo(a);
                if(dis<shor){
                    shor=dis;
                    ancestor=a;
                }
            }
        }
        return ancestor;
    }
    public int length(Iterable<Integer> v,Iterable<Integer> w){
        BreadthFirstDirectedPaths b1=new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths b2=new BreadthFirstDirectedPaths(g,w);
        int shor=-1;
        for(int a=0;a<g.V();++a){
            if(b1.hasPathTo(a) && b2.hasPathTo(a)){
                int dis=b1.distTo(a)+b2.distTo(a);
                if(shor==-1 || dis<shor){
                    shor=dis;
                }
            }
        }        
        return shor;
    }
    public int ancestor(Iterable<Integer> v,Iterable<Integer> w){
        BreadthFirstDirectedPaths b1=new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths b2=new BreadthFirstDirectedPaths(g,w);
        int shor=Integer.MAX_VALUE;
        int ancestor=-1;
        for(int a=0;a<g.V();++a){
            if(b1.hasPathTo(a) && b2.hasPathTo(a)){
                int dis=b1.distTo(a)+b2.distTo(a);
                if(dis<shor){
                    shor=dis;
                    ancestor=a;
                }
            }
        }
        return ancestor;
    }
}