class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(char c : s.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(char i : hashmap.keySet()){
            pq.add(new Pair(i,hashmap.get(i)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair<Character,Integer> pair = pq.poll();
            for(int i=0;i<pair.getValue();i++){
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }
}