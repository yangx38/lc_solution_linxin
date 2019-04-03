class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);
    
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
    
        int res = 0;
        while (!pq.isEmpty()) {
            int interval = n+1;
            Queue<Map.Entry<Character, Integer>> tempQueue = new LinkedList<>();
    
            while (interval > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> temp = pq.poll();
                temp.setValue(temp.getValue()-1);
                if(temp.getValue() > 0) tempQueue.offer(temp); // don't want task that already finished
                interval--;
                res++;
            }
            pq.addAll(tempQueue);
            if (pq.isEmpty()) break; // job done
            res += interval; //剩下的interval - means idle
        }
    
        return res;
    }
}