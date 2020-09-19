package algo.dp;

import common.ArrayUtils;

public class p790 {
    public static void main(String[] args) {
        p790 p = new p790();
        int N = 50;
        System.out.println(p.numTilings(N));

    }

    public int numTilings(int N) {
        if (N == 0) { return 1; }
        long[] res = new long[N+1];
        res[0] = 1;
        if (N >= 1) { res[1] = 1; }
        if (N >= 2) { res[2] = 2; }
        if (N >= 3) { res[3] = 5; }
        for (int i = 4; i <= N; i++) {
            res[i] = res[i-2] + res[i-1];
            for(int j = i-3; j >= 0; j--) {
                res[i] += res[j] * 2;
            }
            res[i] = res[i] % 1_000_000_007;
        }

        System.out.println(ArrayUtils.dumpArray(res));
        return (int) res[N];
    }
}
