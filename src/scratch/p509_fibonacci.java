package scratch;

public class p509_fibonacci {
    public static void main(String[] args) {
        p509_fibonacci p = new p509_fibonacci();
        int N = 4;
        System.out.println(p.fib(N));
    }
    public int fib(int N) {
        if (N <= 1) { return  N; }
        int[] f = new int[1+N];
        f[0] = 0; f[1] = 1;
        for(int n = 2; n <= N; n++) {
            f[n] = f[n-1] + f[n-2];
        }
        return f[N];
    }
}
