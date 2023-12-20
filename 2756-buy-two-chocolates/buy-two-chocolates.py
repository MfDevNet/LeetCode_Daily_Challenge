class Solution(object):
    def buyChoco(self, prices, money):
        min_price = float('inf')

        for i, price in enumerate(prices):
            for j in range(i + 1, len(prices)):
                if price + prices[j] < min_price and price + prices[j] <= money:
                    min_price = price + prices[j]

        if min_price == float('inf'):
            return money
        else:
            return money - min_price