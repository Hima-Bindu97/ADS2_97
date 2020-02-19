import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class BurrowsWheeler{
    public static void transform(){
        String str=BinaryStdIn.readString();
        char[] ch=str.toCharArray();
        CircularSuffixArray csa=new CircularSuffixArray(str);
        for(int i=0;i<str.length();i++){
            if(csa.index(i)==0){
                BinaryStdOut.write(i);
            }
        }
        int a=str.length();
        for(int i=0;i<str.length();i++){
            int index=csa.index(i);
            BinaryStdOut.write(ch[(index-1+a)%a]);
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }
    public static void inverseTransform(){
        int first=BinaryStdIn.readInt();
        String str=BinaryStdIn.readString();
        char[] t=str.toCharArray();
        char[] fcol=str.toCharArray();
        int n=t.length;
        int[] next=new int[n];
        sort(fcol,next);
        for(int i=0;i<n;i++){
            BinaryStdOut.write(fcol[first]);
            first=next[first];
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }
    private static void sort(char[] arr,int[] next){
        int r=256;
        int n=arr.length;
        char[] aux=new char[n];
        int[] count=new int[r+1];
        for(int i=0;i<n;i++){
            count[arr[i]+1]++;
        }
        for(int j=0;j<r;j++){
            count[j+1]+=count[j];
        }
        for(int i=0;i<n;i++){
            next[count[arr[i]]]=i;
            aux[count[arr[i]]++]=arr[i];

        }
        for(int i=0;i<n;i++){
            arr[i]=aux[i];
        }
    }
    public static void main(String[] args) {
        if(args[0].equals("-")){
            BurrowsWheeler.transform();
        }
        else if(args[0].equals("+")){
            BurrowsWheeler.inverseTransform();
        }
    }
}