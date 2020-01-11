import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution{
    Digraph g;
    ArrayList<String> a1=new ArrayList<String>();
    ArrayList<String> a2=new ArrayList<String>();
    ArrayList<String> a3=new ArrayList<String>();
    public Solution(){
        this.email(f);
        this.logs(f1);
        int c=0;
        for(int i=0;i<g.size();i++){
            c=c+g.adj[i].size();
        }
        System.out.println(c);
    }
    static File f=new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Exam\\ADS - 2 Exam - 1\\emails.txt");
    public void email(File f) throws FileNotFoundException {
        Scanner s=new Scanner(f);
        while(s.hasNextLine()){
            String[] a=s.nextLine().split(";");
            a2.add(a[0]);
            int c=0;
            for(int i=0;i<a.length;i++){
                g.addEdge(Integer.parseInt(a[c]),Integer.parseInt(a[i]));
                a3.add(a[1]);
            }
        }
    }
    static File f1=new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Exam\\ADS - 2 Exam - 1\\email-logs.txt");
    public void logs(File f1) throws FileNotFoundException { 
        Scanner s1=new Scanner(f1);
        while(s1.hasNextLine()){
            String[] b=s1.nextLine().split(";");
            a1.add(b[0]);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        {
            Solution so=new Solution();
            so.email(f);
            so.logs(f1);
        }
    }
}