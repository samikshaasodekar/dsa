class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Recursive call
        return n * factorial(n - 1);
    }
}

