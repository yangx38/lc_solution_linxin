class Solution {
    public String rearrangeString(String s, int k) {
        if(s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
    
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
    
        StringBuilder sb = new StringBuilder();
        // tempQueue 控制是否进行k次循环
        Queue<Map.Entry<Character, Integer>> tempQueue = new LinkedList<>();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> temp = pq.poll();
    
            sb.append(temp.getKey());
            temp.setValue(temp.getValue()-1);
            tempQueue.offer(temp);
    
            if(tempQueue.size() < k) continue;
            Map.Entry<Character, Integer> front = tempQueue.poll();
            if(front.getValue() > 0) pq.offer(front);
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}