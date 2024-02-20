# https://leetcode.com/problems/binary-search/
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.binary_search(nums, 0, len(nums) - 1, target)

    def binary_search(self, nums: List[int], start: int, end:int, target:int)->int:
        while start <= end :
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                return self.binary_search(nums, mid + 1, end, target)
            else:
                return self.binary_search(nums, start, mid - 1, target)
        return -1