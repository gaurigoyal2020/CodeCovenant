class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxV = Integer.MIN_VALUE;
        int left = 0, right = height.length -1;

        while(left<right){
            int vol = (right-left)*Math.min(height[left], height[right]);
            if(vol > maxV)
                maxV = vol;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxV;
    }
}
