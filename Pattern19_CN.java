/*         // Upper half of the pattern
        for (int i = 0; i < N; i++) {
            // Print leading stars
            for (int j = 0; j < N - i; j++) {
                System.out.print("* ");
            }
            // Print spaces
            for (int j = 0; j < 2 * i; j++) {
                System.out.print("  ");
            }
            // Print trailing stars
            for (int j = 0; j < N - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half of the pattern
        for (int i = 1; i < N; i++) {
            // Print leading stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            // Print spaces
            for (int j = 0; j < 2 * (N - 1 - i); j++) {
                System.out.print("  ");
            }
            // Print trailing stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
 */
=================================================================================================================================================================================
  ===============================================================================================================================================================================
  public class Solution {
    public static void symmetry(int n) {
        // Write your code here
               // Upper half of the pattern
        for (int i = 0; i <=n; i++) {
            // Print leading stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            // Print spaces
            for (int j = 0; j <2 * i; j++) {
                System.out.print("  ");
            }
            // Print trailing stars
            for (int j = 0; j <n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half of the pattern
        for (int i = 1; i <= n; i++) {
            // Print leading stars
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            // Print spaces
            for (int j = 0; j < 2 * (n - 1 - i); j++) {
                System.out.print("  ");
            }
            // Print trailing stars
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    
    }
}
