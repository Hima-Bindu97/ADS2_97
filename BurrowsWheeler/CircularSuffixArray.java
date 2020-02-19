import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class CircularSuffixArray{
    private int n;
    private suffixArray x;
    public CircularSuffixArray(String s){
        if(s==null){
            throw new IllegalArgumentException();
        }
        n=s.length();
        x=new suffixArray(s);
    }
    public int length(){
        return n;
    }
    public int index(int i){
        if(i>n-1){
            throw new IllegalArgumentException();
        }
        return x.index(i);
    }
    private class suffixArray{
        private final char[] text;
        private final int[] index;
        private final int n;
        public suffixArray(String text){
            n=text.length();
            this.text=text.toCharArray();
            this.index=new int[n];
            for(int i=0;i<n;i++){
                index[i]=i;
            }
            sort(0,n-1,0);
        }
        private void sort(int low,int high,int d){
            if(high<=low){
                return;
            }
            if(d>=n){
                return;
            }
            int i=low,j=high;
            char v=text[(index[low]+d)%n];
            int k=low+1;
            while(k<=j){
                char t=text[(index[i]+d)%n];
                if(t<v){
                    exch(i++,k++);
                }
                else if(t>v){
                    exch(k,j--);
                }
                else{
                    k++;
                }
            }
            sort(low,i-1,d);
            if(v>=0){
                sort(i,j,d+1);
            }
            sort(j+1,high,d);
        }
        private void exch(int i,int j){
            int temp=index[i];
            index[i]=index[j];
            index[j]=temp;
        }
        private int index(int i){
            if(i<0 || i>=n){
                throw new IllegalArgumentException();
            }
            return index[i];
        }
    }
    public static void main(String[] args) {
        String str="";
        CircularSuffixArray csa=new CircularSuffixArray(str);
        for(int i=0;i<str.length();i++){
            System.out.println(csa.index(i));
        }
    }
}