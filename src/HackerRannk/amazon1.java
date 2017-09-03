import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Not Correct version*/
public class ArrayManipulation {

    public static void main(String[] args) {
        

        List<List<Integer>> allLocations  = 



        List<Integer[]> mylist = new ArrayList<Integer[]>(m);
        
        long max = Long.MIN_VALUE;
        long sum;
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            Integer[] vl = {a,b,k};
            mylist.add(vl);
        }

        Collections.sort(mylist,new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return a[0].compareTo(b[0]);
            }
        });

        for (int i = 0; i < m; i++)
            System.out.printf("%3d %3d %3d\n",mylist.get(i)[0],mylist.get(i)[1],mylist.get(i)[2]);
        System.out.println();


        for (int i = m-1; i >= 0; i-- ) {
            sum = findS(mylist, i);
            if (max < sum)
                max = sum;
        }

        System.out.println(max);
        in.close();
       
    }

    public static long findS(List<Integer[]> l, int index) {
        long sum = l.get(index)[2];
        System.out.printf("%3d %3d %3d\n",l.get(index)[0],l.get(index)[1],l.get(index)[2]);
        if (index == 0)
            return sum;

        for (int i = index-1; i >= 0; i--) {
            if ( l.get(index)[0] <= l.get(i)[1] && l.get(index)[0] >= l.get(i)[0] ) {
                sum += l.get(i)[2];
                System.out.printf("%3d %3d %3d\n",l.get(i)[0],l.get(i)[1],l.get(i)[2]);

            } else {
                System.out.printf("\n--------\n");
                return sum;
            }
        }
        System.out.printf("\n--------\n");

        return sum;
    }
}


