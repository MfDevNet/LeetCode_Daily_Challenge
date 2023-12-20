class Solution(object):
    def myPow(self,x, n):
        if n == 0:
            return 1
    
        if n < 0:
            x = 1 / x
            n = abs(n)
        
        result = 1
        while n > 0:
            if n % 2 == 1:
                result *= x
            x *= x
            n //= 2
        
        return result        