package scratch;

import java.util.*;

public class p1663_Smallest_String_With_A_Given_Numeric_Value {
    public static void main(String[] args) {
        p1663_Smallest_String_With_A_Given_Numeric_Value p =  new p1663_Smallest_String_With_A_Given_Numeric_Value();

        // int n = 3, k = 27;
        int n = 5, k = 73;
        System.out.println(p.getSmallestString(n,k));
    }

    public String getSmallestString(int n, int k) {
        char[] chs = new char[n];
        for(int i = n; i >= 1; i--) {
            for(int j = 26; j >= 1; j--) {
                if (k - j >= i - 1) {
                    chs[i-1] = Character.valueOf((char)('a' + j -1));
                    k = k-j;
                    break;
                }
            }
        }

        return new String(chs);
    }

    public String getSmallestString2(int n, int k) {
        Map<String, String> mem = new HashMap<>();
        return dfs(n, k , mem);
    }

    private String dfs(int n, int k, Map<String, String> mem) {
        String key = String.format(n + "," + k);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        if (n * 26 < k || k < 1) {
            return null;
        }

        if (n == 1) {
            String ret = Character.valueOf((char)('a' + k -1)).toString();
            mem.put(key, ret);
            return ret;
        }

        for(int i = 1; i <= 26; i++) {
            String sub = dfs(n-1, k - i, mem);
            if (sub != null) {
                String ret = Character.valueOf((char)('a' + i -1)).toString() + sub;
                mem.put(key, ret);
                return ret;
            }
        }

        return null;
    }
}
