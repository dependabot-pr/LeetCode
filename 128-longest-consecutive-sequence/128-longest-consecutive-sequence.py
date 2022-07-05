class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        nums_set=set(nums)
        max_consecutive_length=0
        nums=list(nums_set)
        for i in range(len(nums)):
            if nums[i]-1 in nums_set:
                continue
            current_length=1
            temp=nums[i]
            while(temp+1 in nums_set):
                current_length+=1
                temp+=1
            max_consecutive_length=max(max_consecutive_length,current_length)
        return max_consecutive_length