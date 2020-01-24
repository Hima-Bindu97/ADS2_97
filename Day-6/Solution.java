import java.io.*;
import java.util.*;
public class Solution {
    public static int values(int num) {
        int count = 1;
        // if (num == 1) {
        //     System.out.println(num);
        //     return count;
        // } 
        while(num!=1) {
            if (num % 2 == 0) {
                num = num / 2;
                System.out.println(num);
                count += 1;
            } 
            else {
                num = (3 * num) + 1;
                System.out.println(num);
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(values(6));
    }
}