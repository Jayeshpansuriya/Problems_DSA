/*
lgorithm / Intuition
We will try to build intuition for this approach using the following observations.


Here, we can observe that the numbers marked in red are added to the previous number to build the current number. In each step, the numerator is multiplied by the previous consecutive element, and the denominator is multiplied by the next consecutive element.

We will replicate this in our algorithm. First, we will mark the indices of the column starting from 0. Then we will simply multiply the numerator by (n-index) and the denominator by the index itself.

From column no. 1 the formula will be the following:

Current element = prevElement * (rowNumber - colIndex) / colIndex
Approach:
The steps are as follows:

First, we will print the 1st element i.e. 1 manually.
After that, we will use a loop(say i) that runs from 1 to n-1. It will print the rest of the elements.
Inside the loop, we will use the above-said formula to print the element. We will multiply the previous answer by (n-i) and then divide it by i itself.
Thus, the entire row will be printed.
*/


import java.util.*;

public class tUf {

    static void pascalTriangle(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
}
/
/*
Complexity Analysis
Time Complexity: O(N) where N = given row number. Here we are using only a single loop.

Space Complexity: O(1) as we not using any extra space.
  */
