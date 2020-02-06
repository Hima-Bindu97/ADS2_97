import java.util.ArrayList;
import edu.princeton.cs.algs4.Digraph;
public class BoggleSolver{
    private Tries tries;
    private Digraph digraph;
    public BoggleSolver(String[] tries){
        if(tries==null){
            throw new IllegalArgumentException();
        }
        this.tries=new Tries();
        for(String s:tries){
            this.tries.put(s);
        }
    }
    public Iterable<String> getAllValidWords(BoggleBoard board){
        ArrayList<String> allValidWords=new ArrayList<String>();
        boolean[][] visited=new boolean[board.rows()][board.cols()];
        for(int row=0;row<board.rows();row++){
            for(int col=0;col<board.cols();col++){
                StringBuilder sb=new StringBuilder();
                check(sb,allValidWords,board,visited,row,col);
                visited[row][col]=false;
            }
        }
        return allValidWords;
    }
    private void check(StringBuilder sb,ArrayList<String> al,BoggleBoard board,boolean[][] visited,int row,int col){
        visited[row][col]=true;
        sb.append(board.getLetter(row,col));
        if(board.getLetter(row,col)=='Q'){
            sb.append("U");
        }
        if(tries.contains(sb.toString())){
            if(!al.contains(sb.toString()) && sb.length()>2){
                al.add(sb.toString());
            }
        }
        else if(!tries.isPrefix(sb.toString())){
            return;
        }
        if(row>0){
            if(!visited[row-1][col]){
                check(sb,al,board,visited,row-1,col);
                sb.deleteCharAt(sb.length()-1);
                visited[row-1][col]=false;
            }
            if(col>0){
                if(!visited[row-1][col-1]){
                    check(sb,al,board,visited,row-1,col-1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[row-1][col-1]=false;
                }
            }
            if(col<board.cols()-1){
                if(!visited[row-1][col+1]){
                    check(sb,al,board,visited,row-1,col+1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[row-1][col+1]=false;
                }
            }
        }
        if(col<board.cols()-1){
            if(!visited[row][col+1]){
                check(sb,al,board,visited,row,col+1);
                sb.deleteCharAt(sb.length()-1);
                visited[row][col+1]=false;
            }
        }
        if(row<board.rows()-1){
            if(!visited[row+1][col]){
                check(sb,al,board,visited,row+1,col);
                sb.deleteCharAt(sb.length()-1);
                visited[row+1][col]=false;
            }
            if(col>0){
                if(!visited[row+1][col-1]){
                    check(sb,al,board,visited,row+1,col-1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[row+1][col-1]=false;
                }
            }
            if(col<board.cols()-1){
                if(!visited[row+1][col+1]){
                    check(sb,al,board,visited,row+1,col+1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[row+1][col+1]=false;
                }
            }
        }
        if(col>0){
            if(!visited[row][col-1]){
                check(sb,al,board,visited,row,col-1);
                sb.deleteCharAt(sb.length()-1);
                visited[row][col-1]=false;
            }
        }
    }
    public int scoreOf(String word){
        if(word==null){
            throw new IllegalArgumentException();
        }
        if(tries.contains(word)){
            switch(word.length()){
                case 0:return 0;
                case 1:return 0;
                case 2:return 0;
                case 3:return 1;
                case 4:return 1;
                case 5:return 2;
                case 6:return 3;
                case 7:return 5;
                default:return 11;
            }
        }
        return 0;
    }
}