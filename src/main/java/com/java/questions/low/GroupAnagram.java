package com.java.questions.low;

import java.util.*;


/*


static void setOfAnagrams(String inputString) {

   String[] words = inputString.split(" ");
   Map<String, List<String>> map = new HashMap<>();

   for (String word : words) {
   char[] chars = word.toCharArray();

   Arrays.sort(chars);
   String sortedStr = new String(chars);

   if (!map.containsKey(sortedStr)) {
      map.put(sortedStr, new ArrayList<>());
   }

   map.get(sortedStr).add(word);
}
   for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      entry.getValue().forEach(val -> System.out.print(val + " "));
}
  }

 */

public class GroupAnagram {

    static String setOfAnagrams(String inputString){

       Map<String, List<String>> stringsmap = new HashMap<>();

       String[] splitted = inputString.split(" ");
       String temp = "";

       for (String s : splitted){

           char[] array = s.toCharArray();
           Arrays.sort(array);
           String key = new String(array);

           if (stringsmap.get(key) == null){

               stringsmap.put(key, new ArrayList<>());

           }

           stringsmap.get(key).add(s);


       }

       String finalString = "";
       for (String key : stringsmap.keySet()){
            for (String s : stringsmap.get(key)){
                finalString += s + " ";
            }
       }

       return finalString.trim();

    }

    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";

        System.out.println(setOfAnagrams(input));

    }

}

