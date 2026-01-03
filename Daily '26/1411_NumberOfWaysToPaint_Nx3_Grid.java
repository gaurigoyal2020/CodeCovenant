class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        int dp[][][][] = new int [n][4][4][4]; // 4 is for 0,1,2,3 -> 0 for no color and 1,2, for actual colors
        for(int i=0; i<n; i++) {
            for(int j=0; j<4; j++) {
                for(int k=0; k<4;k++){
                    for(int l=0; l<4;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return solve(0, n, 0, 0, 0, MOD, dp);
        //there is no row before the 0 row so we an try all combos in row 0.
    }

    private int solve(int i, int n, int prev1, int prev2, int prev3, int MOD, int[][][][] dp) {
        if(i==n)
            return 1;

        if(dp[i][prev1][prev2][prev3] != -1) {
            return dp[i][prev1][prev2][prev3];
        }

        int ans = 0;
        for(int col1 = 1; col1<=3; col1++) {
            if(col1 == prev1) 
                continue;
            for(int col2 = 1; col2 <= 3; col2++) {
                if(col2 == prev2 || col2 == col1)
                    continue;
                for(int col3=1; col3<=3; col3++){
                    if(col3==prev3 || col3 == col2)
                        continue;
                    ans = (ans + solve(i+1, n, col1, col2, col3, MOD, dp)) % MOD;
                }
            }
        }
        return dp[i][prev1][prev2][prev3] = ans; // the assignment happens first (ans = dp) and then return ans
    }
}

/*class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6;
        
        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }
        
        return (int) ((A + B) % MOD);
    }
}*/


/*NOTE
  We are painting a grid row by row, where each row has 3 cells and 3 possible colors.

At any row, the only thing that matters for future rows is:

What colors were used in the previous row’s 3 columns
→ so we keep (prev1, prev2, prev3) as state.

For the current row:

We try all valid color triples (col1, col2, col3) such that:

No column repeats its previous row color
col1 ≠ prev1, col2 ≠ prev2, col3 ≠ prev3

No two adjacent columns in the same row have the same color
col1 ≠ col2 and col2 ≠ col3

For every valid triple, we move to the next row and add its ways.

So:

State = (row index, previous row’s 3 colors)

Transition = try all valid color combinations for this row

Base case = when all rows are painted, that is one valid way

Memoization avoids recomputing the same (i, prev1, prev2, prev3) again and again.

Approach
State Definition
Use DP where the state is defined by:

Current row index i

Colors of the three columns in the previous row (prev1, prev2, prev3)

DP Meaning
dp[i][prev1][prev2][prev3] = number of valid ways to paint rows from i to n-1 given the previous row’s colors.

Transition
For the current row, try all color triples (col1, col2, col3) from {1,2,3} such that:

col1 ≠ prev1, col2 ≠ prev2, col3 ≠ prev3

col1 ≠ col2 and col2 ≠ col3

For each valid triple, add:

dp[i+1][col1][col2][col3]

Base Case
When i == n, return 1 (a complete valid coloring is formed).

Memoization
Store results of each state to avoid recomputation.

Final Answer
Start from row 0 with (0,0,0) as previous colors and return dp[0][0][0][0].
*/
