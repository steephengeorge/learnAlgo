# https://leetcode.com/problems/valid-parentheses/description/
class Solution:
    def isValid(self, s: str) -> bool:
        map: dict[str, str] ={")":"(", "}":"{", "]":"["}
        stack:list[str] = []
        for char in s:
            if char in map:
                lastChar = stack.pop() if stack else "#"
                if lastChar != map[char]:
                    return False
            else:
                stack.append(char)
        return not stack
