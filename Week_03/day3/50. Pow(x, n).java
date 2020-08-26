class Solution {
    public double myPow(double x, int n) {

        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        double ans = 1.0;
        double x_contribute = x;
        while (n != 0) {
            if ((int) (n & 1) != 0) {
                ans *= x_contribute;
            }
            n = n >>> 1;
            x_contribute = x_contribute * x_contribute;
        }
        return ans;
    }
}