import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SparseArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = in.next();
        }
        int Q = in.nextInt();
        String[] key = new String[Q];
        for (int i = 0; i < Q; i++) {
            key[i] = in.next();
        }
        for (int i = 0; i < Q; i++) {
            System.out.printf(" %s ",key[i]);
            check(str,key[i]);
        }
    }
    
    public static void check(String[] str, String key) {
        int count = 0;
        for (int i = 0;i < str.length; i++) {
            if (key.equals(str[i]))
                count++;
        }
        System.out.println(count);
    }
}