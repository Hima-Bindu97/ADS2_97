import java.util.ArrayList;
import java.util.HashMap;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class MoveToFront{
    private static class Node{
        public char key;
        public Node next;
        public Node(char key,Node next){
            this.key=key;
            this.next=next;
        }
    }
    public static void encode(){
        Node head=new Node((char)0,null);
        for(int i=255;i>=0;i--){
            Node node=new Node((char)i,head.next);
            head.next=node;
        }
        char[] ch=BinaryStdIn.readString().toCharArray();
        int index=0;
        while(index<ch.length){
            char c=ch[index++];
            Node node=head.next;
            Node pre=head;
            int count=0;
            while(node!=null && node.key!=c){
                count++;
                pre=node;
                node=node.next;
            }
            BinaryStdOut.write(count,8);
            if(pre!=head){
                pre.next=node.next;
                node.next=head.next;
                head.next=node;
            }
        }
        BinaryStdOut.flush();
		BinaryStdOut.close();
    }
    public static void decode(){
        Node head=new Node((char)0,null);
        for(int i=255;i>=0;i--){
            Node node=new Node((char)i,head.next);
            head.next=node;
        }
        char[] in=BinaryStdIn.readString().toCharArray();
        int index=0;
        while(index<in.length){
            int c=(int)in[index++];
            Node node=head.next;
            Node pre=head;
            int i=0;
            while(i<c){
                i++;
                pre=node;
                node=node.next;
            }
            BinaryStdOut.write(node.key);
            if(pre!=head){
                pre.next=node.next;
                node.next=head.next;
                head.next=node;
            }
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }
    public static void main(String[] args) {
        if(args[0].equals("-")){
            MoveToFront.encode();
        }
        else if(args[0].equals("+")){
            MoveToFront.decode();
        }
    }
}