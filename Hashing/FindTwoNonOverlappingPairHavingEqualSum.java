package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTwoNonOverlappingPairHavingEqualSum {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        int arr[] = {8,4,7,8,4};
        HashMap<Integer,List<Pair>> hashmap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i] + arr[j];
                if(hashmap.containsKey(sum)){
                    for(Pair pair : hashmap.get(sum)){
                        int x = pair.first;
                        int y = pair.second;
                        if((x!=i && x!=j) && (y!=i && y!=j)){
                            System.out.println("First -> " +arr[x] +" -> " +arr[y]);
                            System.out.println("Second -> "+arr[i]+" -> "+arr[j]);
                            return;
                        }
                    }
                }
                hashmap.putIfAbsent(sum, new ArrayList<>());
                hashmap.get(sum).add(new Pair(i, j));

            }
        }
    }
}
