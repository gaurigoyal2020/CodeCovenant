class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1)) == 0;
    }
    //If n is a power of 2, it contains exactly one bit set to 1:
    //4=100 8=1000 16=10000
    //If we perform n-1, it will flip the n:
    //3=011 7=0111 15=01111

    //n  | 8: 1 0 0 0
    //n-1| 7: 0 1 1 1
    //----------------
    // & |    0 0 0 0
}
