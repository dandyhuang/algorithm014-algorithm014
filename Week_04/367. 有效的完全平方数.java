class Solution {
    public boolean isPerfectSquare(int num) {
        
        long n = 1;
        while(n * n < num) {
            n++;
        }
        if(n * n == num) {
            return true;
        }
        return false;

    }
}