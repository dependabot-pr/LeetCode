class Solution {
        public int candy(int[] nums) {
            
            int ans = 0;
            int n = nums.length;
            int[] candy = new int[n];
            
            for(int i=nums.length-1;i>0;i--){
                if(nums[i-1]>nums[i]){
                    candy[i-1] = candy[i]+1;
                }
            }
            
            for(int i=0;i<nums.length-1;i++)
            {
                if(nums[i]<nums[i+1] && candy[i]>=candy[i+1])
                {
                    candy[i+1] = candy[i]+1;
                }
                ans+=candy[i];
            }
            
            return n+ans+candy[n-1];
        }
}