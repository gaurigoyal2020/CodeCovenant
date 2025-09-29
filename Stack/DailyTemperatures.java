//MONOTONIC INC STACK
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n= temp.length;
        int answer[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
                answer[stack.peek()] = i - stack.pop();
            }
            //future days retroactively answer the question for past days
            stack.push(i);
        }
        return answer;
    }
}

//MONOTONIC DEC STACK
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int ans[] = new int[temps.length];

        for(int i=temps.length-1; i>=0; i--) {
            while(!dq.isEmpty() && temps[dq.peek()] <= temps[i])
                dq.pop();
            
            if(!dq.isEmpty()) {
                ans[i] = dq.peek() - i;
            }

            dq.push(i);
        }
        return ans;
    }
}
