class Solution {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> temp = pq.poll();
            
            if(sb.length() == 0 || temp.getKey() != sb.charAt(sb.length()-1)) {
                sb.append(temp.getKey());
                temp.setValue(temp.getValue()-1);
                if(temp.getValue() != 0) pq.offer(temp);
            }
            else {
                Map.Entry<Character, Integer> temp2 = pq.poll();
                if(temp2 == null) return "";
                sb.append(temp2.getKey());
                temp2.setValue(temp2.getValue()-1);
                if(temp2.getValue() != 0) pq.offer(temp2);
                pq.offer(temp);
                
            }
        }
        return sb.toString();
    }
}