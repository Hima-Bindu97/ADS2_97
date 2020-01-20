class SAP{
    static final int INFINITY=Integer.MAX_VALUE;
    Digraph g;
    int integer=Integer.MAX_VALUE;
    public SAP(Digraph g){
        this.g=g;
    }
    public int length(int v,int w){
        if(v>g.V()-1 || v<0 || w>g.V()-1 ||w<0) throw new IndexOutOfBoundsException();
        return bfsMethod(v,w)[1];
    }
    public int ancestor(int v,int w){
        if(v>g.V()-1 || v<0 || w>g.V()-1 || w<0) throw new IndexOutOfBoundsException();
        return bfsMethod(v,w)[0];
    }
    private int[] bfsMethod(int v, int w) {
        int[] bfsMethod=new int[2];
        int dis=INFINITY;
        int ancestor=-1;
        BreadthFirstDirectedPaths b1=new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths b2=new BreadthFirstDirectedPaths(g,w);
        for(int vertex=0;vertex<g.V();vertex++){
            if(b1.hasPathTo(vertex) && b2.hasPathTo(vertex)){
                if(b1.distTo(vertex)+b2.distTo(vertex)<dis){
                    dis=b1.distTo(vertex)+b2.distTo(vertex);
                    ancestor=vertex;
                }
            }
        }
        bfsMethod[0]=ancestor;
        bfsMethod[1]=(dis==INFINITY? -1:dis);
        return bfsMethod;
        }
    public int length(Iterable<Integer> v,Iterable<Integer> w){
        if(v==null || w==null){
            throw new NullPointerException();
        }
		return bfsMethod(v,w)[1]; 
    }
    public int ancestor(Iterable<Integer> v,Iterable<Integer> w){
        if(v==null || w==null){
            throw new NullPointerException();
        }
        return integer;
    }
    
    int[] bfsMethod(Iterable<Integer> v, Iterable<Integer> w) {
        return null;
    }
}