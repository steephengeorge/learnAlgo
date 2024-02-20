from typing import List, Dict


class Solution:
    def two_sum(self, nums: List[int], target: int) -> List[int]:
        hashMap: dict[int, int] = {}
        for i in range(len(nums)):
            remainder = target - nums[i]
            if remainder in hashMap:
                return [i, hashMap[remainder]]
            hashMap[nums[i]] = i
