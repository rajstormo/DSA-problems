
/*
Question: given a sorted array. find freq of all the elements in the array 
e.g: arr = [10,10,10,25,30,30]
10 - 3
25 - 1
30 - 2  
*/

import java.util.*;
public class FrequencySortedArr {
  
  private static void findFreq(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[i] != -1 && arr[i] == arr[j]) {
          count++;
          if (i != j)
            arr[j] = -1;
        }
      }
      if (arr[i] != -1)
        System.out.println(arr[i] + "-> " + count);
    }
  }

  //using hash map in O(n)
  private static void findFreq2(int arr[]) {
    HashMap<Integer,Integer> m = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!m.containsKey(arr[i]))
        m.put(arr[i],1);
      else  
        m.put(arr[i], m.get(arr[i])+1);
    }
    //iterate over the map and print the count of the keys
    Set<Integer> keys = m.keySet();
    for (Integer k : keys) {
      System.out.println(k + " " + m.get(k));
    }
  }

  public static void main(String[] args) {
    int arr[] = {10,10,10,25,30,30};
    // int arr[] = {10,10,10,10};
    // findFreq(arr);
    findFreq2(arr);
  }
}
