class Solution {
    public boolean wordPattern(String pattern, String str) {
        // corner case:
        char[] pc = pattern.toCharArray();
        String[] sc = str.split("\\s+");
        if(sc.length != pc.length) return false;


        // map is for pc, map2 is for sc
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pc.length; i++) {
            // pc to sc 走一遍 put in map
            if(map.containsKey(pc[i]) && !map.get(pc[i]).equals(sc[i])) return false;
            map.put(pc[i], sc[i]);
            // sc to pc 走一遍 put in map2
            if(map2.containsKey(sc[i]) && !map2.get(sc[i]).equals(pc[i])) return false;
            map2.put(sc[i], pc[i]);
        }
        return true;
    }
}