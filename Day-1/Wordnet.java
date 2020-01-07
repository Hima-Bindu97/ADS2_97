import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Wordnet {
    public static void main(String[] args) throws IOException {
        File f=new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Day-1\\synsets.txt");
        Scanner sc=new Scanner(f);
        while(sc.hasNextLine()){
            String[] a=sc.nextLine().split(",");
            System.out.println(a[0]);
            System.out.println(a[1]);
        }
    }
}