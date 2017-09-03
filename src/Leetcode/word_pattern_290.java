import java.util.*;
class word_pattern_290 {
    public static boolean wordPattern(String pattern, String str) {
        
        String[] tokens = pattern.split(" ", -1);
        int n = tokens.length;

        String[] tk = str.split("");

        if (tokens.length != tk.length)
            return false;
        if ( (tokens.length % 2) != (tk.length % 2) )
            return false;

        LinkedHashMap<String,String> first = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> keyHM = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> valueHM = new LinkedHashMap<String,String>();
        for (int i = 0 ; i < n; i++) {
            first.put(tk[i]+tokens[i], tk[i]+tokens[i]);
            keyHM.put(tk[i],tokens[i]);
            valueHM.put(tokens[i],tk[i]);
        }

        System.out.println("Size first:  " + first.size());
        System.out.println("Size Key:  " + keyHM.size());
        System.out.println("Size Value:  " + valueHM.size());
        Set set = first.entrySet();
        Iterator iK = set.iterator();
        while(iK.hasNext()) {
            Map.Entry me = (Map.Entry)iK.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        if((first.size()== keyHM.size()) && (keyHM.size() == valueHM.size())) 
            return true;
        else 
            return false;
    }

    public static void main(String[] arg) {
        String pattern = "dog cat cat dog";
        String str = "aaaa";



        if (wordPattern(pattern, str)) {
            System.out.println("true");
        } else 
            System.out.println("false");
    }
}


/*

        LinkedHashMap<String,String> keyHM = new LinkedHashMap<String,String>();
        for (int i = 0 ; i < n; i++) {
            keyHM.put(tk[i],tokens[i]);
        }

        LinkedHashMap<String,String> valueHM = new LinkedHashMap<String,String>();
        for (int i = 0 ; i < n; i++) {
            valueHM.put(tokens[i],tk[i]);
        }



        System.out.println("Size Key:  " + keyHM.size());
        Set set = keyHM.entrySet();
        Iterator iK = set.iterator();
        while(iK.hasNext()) {
            Map.Entry me = (Map.Entry)iK.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println("Size Value: " + valueHM.size());
        Set set2 = valueHM.entrySet();
        Iterator i2 = set2.iterator();
        while(i2.hasNext()) {
            Map.Entry me = (Map.Entry)i2.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        if ( (keyHM.size() - valueHM.size() ) != 0 )  {
            return false;
        } else 
            return true;

*/