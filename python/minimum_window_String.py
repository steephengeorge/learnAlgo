import collections
import math


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        map = collections.Counter(t)
        counter = len(t)
        start = 0
        end = 0
        minLength = math.inf
        minStart = 0
        while end < len(s):
            char = s[end]
            if map[char] > 0:
                counter -= 1
            map[char] -= 1
            end += 1

            while counter == 0:
                if minLength > end - start:
                    minLength = end - start
                    minStart = start
                schar = s[start]
                map[schar] += 1
                start += 1
                if map[schar] > 0:
                    counter += 1

        if minLength == math.inf:
            return ""
        else:
            return s[minStart: minStart + minLength]

if __name__ == '__main__':
    s = "ADOBECODEBANC"
    t = "ABC"
    print(Solution().minWindow(s, t))