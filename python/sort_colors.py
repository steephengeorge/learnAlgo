from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = 0
        right = len(nums) - 1
        i = 0
        while i <= right:
            if nums[i] == 0:
                tmp = nums[left]
                nums[left] = nums[i]
                nums[i] = tmp
                left += 1
                i += 1
            elif nums[i] == 2:
                temp = nums[right]
                nums[right] = nums[i]
                nums[i] = temp
                right -= 1
            else:
                i += 1

if __name__ == '__main__':
    colors = [2, 0, 2, 1, 1, 0]
    Solution().sortColors(colors)
    print(colors)