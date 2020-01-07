import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Word {
    static File f = new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Day-1\\synsets.txt");
    public void synsets(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String[] a = sc.nextLine().split(",");
            System.out.println(a[0]);
            System.out.println(a[1]);
        }
    }
    static File f1 = new File("C:\\Users\\DELL\\Desktop\\ADS_97\\ADS2_97\\Day-1\\hypernyms.txt");
    public void hypernyms(File f1) throws FileNotFoundException {
        Scanner sc1 = new Scanner(f1);
        while (sc1.hasNextLine()) {
            String[] b = sc1.nextLine().split(",");
            System.out.println(b[0]);
        }
    }
    public static void main(String[] args) throws IOException {
        Word w = new Word();
        w.synsets(f);
        w.hypernyms(f1);
    }
}