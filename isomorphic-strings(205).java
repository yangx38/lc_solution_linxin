class Solution {
    public boolean isIsomorphic(String s, String t) {
        // corner case:
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length != tc.length) return false;

        // map is for pc, map2 is for sc
        int[] map = new int[256];  
        int[] map2 = new int[256]; 

        for(int i = 0; i < sc.length; i++) {
            // tc to sc 走一遍 put in map
            if(map[sc[i]] != 0 && map[sc[i]] != tc[i]) return false;
            map[sc[i]] = tc[i];
            // sc to tc 走一遍 put in map2
            if(map2[tc[i]] != 0 && map2[tc[i]] != sc[i]) return false;
            map2[tc[i]] = sc[i];
        }
        return true;
    }
}
