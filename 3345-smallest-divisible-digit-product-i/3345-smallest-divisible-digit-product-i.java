class Solution {
    private int getProduct(int n) {
        int product = 1;

        while (n > 0) {
            product *= n % 10;
            n /= 10;
        }

        return product;
    }
    
    public int smallestNumber(int n, int t) {
        for (int i = n; i < n + 10; i++) {
            int product = getProduct(i);
            
            if (product % t == 0) {
                return i;
            }
        }
        return -1;
    }
}