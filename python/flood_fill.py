from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        initial_color = image[sr][sc]
        if initial_color != color:
            self.dfs(image, sr, sc, color, initial_color)
        return image

    def dfs(self, image: List[List[int]], sr: int, sc: int, color: int, initial_color: int):
        if image[sr][sc] == initial_color:
            image[sr][sc] = color
            if sr >= 1:
                self.dfs(image, sr - 1, sc, color, initial_color)
            if sc >= 1:
                self.dfs(image, sr, sc - 1, color, initial_color)
            if sr + 1 < len(image):
                self.dfs(image, sr + 1, sc, color, initial_color)
            if sc + 1 < len(image[0]):
                self.dfs(image, sr, sc + 1, color, initial_color)
