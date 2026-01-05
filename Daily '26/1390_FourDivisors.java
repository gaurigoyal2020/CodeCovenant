class Solution {

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int n : nums) {
            int divisorSum = sumIfExactlyFourDivisors(n);
            if (divisorSum != -1) {
                totalSum += divisorSum;
            }
        }

        return totalSum;
    }

    private int sumIfExactlyFourDivisors(int n) {
        int cubeRoot = (int) Math.round(Math.cbrt(n));

        if ((long) cubeRoot * cubeRoot * cubeRoot == n && isPrime(cubeRoot)) {
            return 1
                    + cubeRoot
                    + cubeRoot * cubeRoot
                    + cubeRoot * cubeRoot * cubeRoot;
        }

        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                int factorA = d;
                int factorB = n / d;

                if (factorA != factorB && isPrime(factorA) && isPrime(factorB)) {
                    return 1 + factorA + factorB + n;
                }

                return -1;
            }
        }

        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;

        for (int d = 2; d * d <= x; d++) {
            if (x % d == 0) return false;
        }

        return true;
    }
}
