import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

public class Solution {
    private static int jobId = 0;
    private static Map<String, HashSet<Integer>> keyMap = new HashMap<String, HashSet<Integer>>();
    private static Map<Integer, String> storeMap = new HashMap<Integer, String>();
    
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        JSONObject allDoc = getJsonObjectFile();
        
        while (sc.hasNextLine()){
            String jsonLine = sc.nextLine();
            String p[] = jsonLine.split(" ", 2);
            Object jsonObj = parser.parse(p[1]);
            
            if (jsonObj instanceof JSONArray) { 
                JSONArray jsonArray = (JSONArray) jsonObj;
                System.out.println(jsonArray);
            } else if (jsonObj instanceof JSONObject) {  
                JSONObject jsonOb = (JSONObject) jsonObj;
                if (p[0].equals("add")) {
                    jobId++;
                    allDoc.put(jobId, jsonOb);
                    storeMap.put(jobId, p[1]);
                    addKeyMap(jsonOb, keyMap, jobId);
                } else {
                    writeJson(allDoc);
                    allDoc = getJsonObjectFile(); 
                    if (p[0].equals("get")) {
                        getQueryJson(jsonOb, allDoc);
                    } else if (p[0].equals("delete")) {
                        deleteQueryJson(jsonOb, allDoc);
                    }
                }
            }
        }
    }
    private static void writeJson(JSONObject allDoc) {
        //Write JSON file
        try (FileWriter file = new FileWriter("quantcast.json")) {
            file.write(allDoc.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("quantcast.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject list = (JSONObject) obj;
            System.out.println(list); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static JSONObject getJsonObjectFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("quantcast.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject list = (JSONObject) obj;
            return list;
        } catch (FileNotFoundException e) {
            return new JSONObject();
        } catch (IOException e) {
            return new JSONObject();
        } catch (ParseException e) {
            return new JSONObject();
        }
    }
    
    //  GET query function
    private static void getQueryJson(JSONObject jsonObj, JSONObject allDoc) {
        
        if (jsonObj.toString().equals("{}")) {
            System.out.println(allDoc);
        } else {
            ArrayList<String> list = new ArrayList<String>(jsonObj.keySet());
            HashSet<Integer> setDocId = getSetDocId(list);    
            for (Integer docId : setDocId) {
                JSONObject docValAllDoc = (JSONObject)allDoc.get(Integer.toString(docId));
                if (compare(jsonObj, docValAllDoc)) {
                    System.out.println(storeMap.get(docId));
                }
            }
        }
    }        

    // Compare to Object Json ob2 include value and property of ob1
    private static boolean compare(JSONObject jOb1, JSONObject jOb2) {
        ArrayList<String> list = new ArrayList<String>(jOb1.keySet());
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            String keyStr = list.get(i);
            Object key1 = jOb1.get(keyStr);
            Object key2 = jOb2.get(keyStr);

            if (key1 instanceof JSONObject) {
                if (key2 instanceof JSONObject) {
                    JSONObject ob1 = (JSONObject) key1;
                    JSONObject ob2 = (JSONObject) key2;
                    if(!compare(ob1, ob2))
                        check = false;
                } else {
                    check = false;
                }
            } else if (key1 instanceof JSONArray) { 
                if (key2 instanceof JSONArray) {

                } else {
                }
            } else if (key1 instanceof String) {
                String kV1 = (String)key1;
                if (key1 instanceof String) {
                    String kV2 = (String)key2;
                    if (!kV1.equals(kV2)) {
                        check = false;
                    }
                } else 
                    check = false;
                
            } else if (key1 instanceof Integer) {
                Integer kV1 = (Integer)key1;
                if (key1 instanceof Integer) {
                    Integer kV2 = (Integer)key2;
                    if (kV1 != kV2)
                        check = false;
                } else 
                    check = false;
            } else if (key1 instanceof Long) {
                Long kV1 = (Long)key1;
                if (key1 instanceof Long) {
                    Long kV2 = (Long)key2;
                    if (kV1 != kV2)
                        check = false;
                } else 
                    check = false;
            } 
            else if (key1 instanceof Boolean) {
                boolean kV1 = ((Boolean) key1).booleanValue();
                if (key1 instanceof Boolean) {
                    boolean kV2 = ((Boolean) key2).booleanValue();
                    if ( !(kV1 && kV2))
                        check = false;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }
    
    // Check on KeyMap Dictionary to find set of Document Object 
    private static HashSet<Integer> getSetDocId(ArrayList<String> list) {
        if (list.size() > 0 && keyMap.containsKey(list.get(0))) {
            HashSet<Integer> set0 = keyMap.get(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                String keyStr = list.get(i);
                HashSet<Integer> seti = keyMap.get(list.get(i));
                set0.retainAll(seti);
            }
            return set0;
        } else {
            return new HashSet<Integer>(Arrays.asList());
        }
    }
    
    //  DELETE query function
    private static void deleteQueryJson(JSONObject jsonObj, JSONObject allDoc) {
        Map<String, JSONObject> allDocMap = convertToMap(allDoc);
        
        ArrayList<String> list = new ArrayList<String>(jsonObj.keySet());
        HashSet<Integer> setDocId = getSetDocId(list);    
        for (Integer docId : setDocId) {
            JSONObject docValAllDoc = (JSONObject)allDoc.get(Integer.toString(docId));
            if (compare(jsonObj, docValAllDoc)) {
                allDocMap.remove(Integer.toString(docId));
            }
        }
        
        JSONObject allDocNew = convertToJObject(allDocMap);
        writeJson(allDocNew);
        System.out.println("After Delete");
        readJson();
    }
    // Convert JSONObject to Map
    private static Map<String, JSONObject> convertToMap(JSONObject allDoc){
        Map<String, JSONObject> allDocMap = new HashMap<String,JSONObject>();
        ArrayList<String> listAll = new ArrayList<String>(allDoc.keySet());
        for (String id : listAll) {
            allDocMap.put(id, (JSONObject)allDoc.get(id));
        }
        return allDocMap;
    }
    // Convert Map  to JSONObject 
    private static JSONObject convertToJObject(Map<String, JSONObject> allDocMap) {
        JSONObject allDoc = new JSONObject();
        
        Iterator<Map.Entry<String, JSONObject>> iterator = allDocMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, JSONObject> entry = iterator.next();
            allDoc.put(entry.getKey(), entry.getValue());
        }
        return allDoc;
    }
    
    
    
    // Create a hash map store all object name and relevant object id
    private static void addKeyMap(JSONObject jsonObj, Map<String, HashSet<Integer>> keyMap, int Id) {
        for (Object key : jsonObj.keySet()) {
            String keyStr = (String)key;
            Object keyvalue = jsonObj.get(keyStr);
            // Add object name and id document to keyMap
            if (!keyMap.containsKey(keyStr)) {
                keyMap.put(keyStr, new HashSet<Integer>(Arrays.asList(Id)));
            } else {
                HashSet<Integer> l = keyMap.get(keyStr);
                l.add(Id);
                keyMap.put(keyStr, l);
            }
        }
    }
}
