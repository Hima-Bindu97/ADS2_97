import java.util.*;
public class Queue<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }
    public Queue(){
        first=null;
        last=null;
        n=0;
    }
    public boolean isempty() {
        return first==null;
    }
    public int size(){
        return n;
    }
    public Item peek(){
        if(isempty()){
            System.out.println("queue underflow");
        }
        return first.item;
    }
    public void enque(Item item){
        Node<Item> oldlast=last;
        last=new Node<Item>();
        last.item=item;
        last.next=null;
        if(isempty()){
            first=last;
        }
        else{
            oldlast.next=last;
        }
        n++;
    }
    public Item deque(){
        if(isempty()){
            System.out.println("queue is underflow");
        }
        Item item=first.item;
        first=first.next;
        n--;
        if(isempty()){
            last=null;
        }
        return item;
    }
}