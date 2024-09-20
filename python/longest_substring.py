class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        end = 0
        maxLength = 0
        map = {}
        while end < len(s):
            char = s[end]
            if char in map and map[char] > start:
                start = map[char] + 1
            map[char] = end
            maxLength = max(maxLength, end - start + 1)
            end += 1
        return maxLength

if __name__ == '__main__':
    # s = "abcabcbb"
    # print(Solution().lengthOfLongestSubstring(s))
    s1= "abba"
    print(Solution().lengthOfLongestSubstring(s1))