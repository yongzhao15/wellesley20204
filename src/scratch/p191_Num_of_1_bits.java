package scratch;

public class p191_Num_of_1_bits {
    public static void main(String[] args) {
        p191_Num_of_1_bits p =  new p191_Num_of_1_bits();
        int n = -2147483645; // Integer.parseInt("01111111111111111111111111111101", 2);
        System.out.println(n);
        System.out.println(p.hammingWeight(n));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0, m = n;
        while(m != 0) {
            res++;
            m &= (m-1);
        }
        return res;
    }
}
