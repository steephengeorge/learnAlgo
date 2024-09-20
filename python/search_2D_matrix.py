from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        kmin = -1
        for i in range(rows):
            if target <= matrix[i][cols - 1]:
                kmin = i
                break

        if kmin == -1:
            return False

        for j in range(cols):
            if matrix[kmin][j] == target:
                return True
            return False

if __name__ == '__main__':
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    target = 3
    Solution().searchMatrix(matrix, target)