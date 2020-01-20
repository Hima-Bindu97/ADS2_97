import jdk.internal.util.xml.impl.Input;

public class Outcast{
    private Word word;
    public Outcast(Word word){
        this.word=word;
    }
    public String outcast(String[] nouns){
        String outcast=null;
        int maxDistance=0;
        for(int i=0;i<nouns.length;i++){
            int distance=0;
            for(int j=0;j<nouns.length;j++){
                if(!nouns[i].equals(nouns[i])){
                    distance=distance+word.distance(nouns[i],nouns[j]);
                }
            }
            if(distance>maxDistance){
                maxDistance=distance;
                outcast=nouns[i];
            }
        }
        return outcast;
    }
    public static void main(String[] args) {
        String[] a={"input/synsets.txt","input/hypernyms.txt","input/outcast5.txt","input/outcast8.txt","input/outcast11.txt"};
        Word word=new Word(a[0],a[1]);
        Outcast outcast=new Outcast(=word);
        for(int k=2;k<args.length;k++){
            In in=new In(args[k]);
            String[] nouns=in.readAllStrings();
            System.out.println(args[k]+":" +outcast.outcast(nouns));
        }
    }
}