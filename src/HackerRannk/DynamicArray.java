import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DynamicArray {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        int lastAnswer = 0;
        // int[][] query = new int[Q][3];
        int[][] query = {{1,0,5},{1,1,7},{1,0,3},{2,1,0},{2,1,1}};
        // int[][] S = new int[N][N];
        ArrayList<Integer>[] S = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            S[i] = t;
        }

        // for (int i = 0; i < Q; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         query[i][j] = in.nextInt();    
        //     }
        // }

        int seq = 0;
        int index = 0;

        for (int i = 0; i < Q; i++) {
            if (query[i][0] == 1) {
                seq = (query[i][1] ^ lastAnswer) % N;
                System.out.printf("Query %d: \nLastAnser = %d \n", i, lastAnswer);
                S[seq].add(query[i][2]);
                System.out.printf("seq[%d]:  ", seq);
                printA(S[seq]);
            }
            if (query[i][0] == 2) {
                seq = (query[i][1] ^ lastAnswer) % N;
                index = query[i][2] % S[seq].size();
                lastAnswer = S[seq].get(index);
                System.out.printf("Query %d: \nLastAnser = %d \n", i, lastAnswer);
                System.out.printf("seq[%d]:  " , seq);
                printA(S[seq]);
                System.out.printf("\nsize of seq[%d]: %d \n", seq, S[seq].size());
            } 
            System.out.printf("\n-----------\n");
        }
    }

    public static void printA(ArrayList<Integer> t) {
        Iterator itr2= t.iterator();  
        while(itr2.hasNext()){  
            System.out.printf(" %d  ",itr2.next());  
        }
    }
}












/*   ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t2.add(3);
        t2.add(4);
        t.add(t2);
        ArrayList<Integer> t3 = new ArrayList<Integer>();
        t3.add(2);
        t3.add(1);
        t.add(t3);
        Iterator itr=t.iterator();  
        while(itr.hasNext()){  
            System.out.println(itr.next());  
        }


        ArrayList<Integer>[] S2 = new ArrayList[N];
        S2[0] = t2;
        S2[1] = t3;
        
        S2[0].add(44);
        System.out.println(S2[0].size());
        for(int i = 0; i < N; i++) {
            
            Iterator itr2= S2[i].iterator();  
            while(itr2.hasNext()){  
                System.out.println(itr2.next());  
            }
            System.out.println();
        }
        
        */