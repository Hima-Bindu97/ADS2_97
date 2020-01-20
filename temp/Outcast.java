public class Outcast{
    private WordNet word;
    public Outcast(WordNet word){
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
}