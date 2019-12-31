/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 *
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (42.60%)
 * Likes:    770
 * Dislikes: 207
 * Total Accepted:    43.9K
 * Total Submissions: 102.8K
 * Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts.  Two accounts definitely belong
 * to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to
 * different people as people could have the same name.  A person can have any
 * number of accounts initially, but all of their accounts definitely have the
 * same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order.  The accounts themselves can be returned in any
 * order.
 * 
 * Example 1:
 * 
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email
 * "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email
 * addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 * 
 * 
 * 
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; ++i) {
            int l = accounts.get(i).size();
            for (int j = 1; j < l; ++j) {
                String email = accounts.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                }else {
                    uf.union(map.get(email), i);
                }
            }
        }
        
        Map<Integer, List<String>> acs = new HashMap<>();
        for (String email: map.keySet()) {
            int root = uf.find(map.get(email));
            acs.putIfAbsent(root, new ArrayList<>());
            acs.get(root).add(email);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Integer root: acs.keySet()) {
            List<String> emails = acs.get(root);
            Collections.sort(emails);
            String accName = accounts.get(root).get(0);
            List<String> account = new ArrayList<>();
            account.add(accName);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }
}

class UnionFind{
    int[] f;
    int[] sz;
    public UnionFind(int n) {
        f = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
            sz[i] = 1;
        }
    }
    
    public void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA != rootB) {
            if (sz[rootA] <= sz[rootB]) {
                f[rootA] = rootB;
                sz[rootB] += sz[rootA];
            }else {
                f[rootB] = rootA;
                sz[rootA] += sz[rootB];
            }
        }
    }
    
    public int find(int x) {
        int r = x;
        while (f[r] != r) {
            r = f[r];
        }
        while (x != r) {
            int t = f[x];
            f[x] = r;
            x = t;
        }
        return r;
    }
}

