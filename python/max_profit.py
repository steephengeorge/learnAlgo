class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        least_price = prices[0]
        for price in prices:
            current_profit = price - least_price
            if price < least_price:
                least_price = price
            if max_profit < current_profit:
                max_profit = current_profit
        return max_profit