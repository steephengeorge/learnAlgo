from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        if len(B) < len(A):
            A, B = B, A

        total = len(A) + len(B)
        half = total // 2

        l, r = 0, len(A) - 1

        while True:
            i = l + r // 2
            j = half - i - 2

            aleft = A[i] if i >= 0 else float("-infinity")
            aright = A[i + 1] if i + 1 < len(A) else float("infinity")
            bleft = B[j] if j >= 0 else float("-infinity")
            bright = B[j + 1] if j + 1 < len(B) else float("infinity")

            if aleft <= bright and bleft <= aright:
                if total % 2:
                    return min(aright, bright)
                else:
                    return (max(aleft, bleft) + min(aright, bright)) / 2.0
            elif aleft > bright:
                r = i - 1
            else:
                r = i + 1

if __name__ == '__main__':
    nums1 = [1, 2]
    nums2 = [3, 4]
    print(Solution().findMedianSortedArrays(nums1, nums2))