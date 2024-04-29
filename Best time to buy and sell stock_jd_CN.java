/*
Problem statement
You are given an array of integers 'prices' of size 'n', where ‘prices[i]’ is the price of a given stock on an ‘i’-th day. You want to maximize the profit by choosing a single day to buy one stock and a different day to sell that stock.



Please note that you can’t sell a stock before you buy one.



Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= 'n' <= 10 ^ 5
1 <= ‘prices[i]’<= 10 ^ 9

Time Limit: 1 sec
Sample Input 1:
6
7 1 5 4 3 6


Sample Output 1 :
5


Explanation Of Sample Input 1:
Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6. Profit = 6 - 1 = 5.


Sample Input 2:
5
5 4 3 2 1


Sample Output 2 :
0

*/

import java.math.*;
 class Solution {
    public static int bestTimeToBuyAndSellStock(int []prices) {
        // Write your code here.
        int maxPro=0;
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxPro=Math.max(maxPro,prices[i]  - minPrice);

        }
        return maxPro;
    }
}
