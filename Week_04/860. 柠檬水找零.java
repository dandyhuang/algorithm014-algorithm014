class Solution {
    public boolean lemonadeChange(int[] bills) {
        int numFive = 0;
        int numTen = 0;
        for(int bill : bills) {
            if(bill == 5) {
                numFive++;
            } else if(bill == 10) {
                if(numFive > 0) {
                    numFive--;
                    numTen++;
                } else {
                    return false;
                }
            } else {
                if(numTen > 0 && numFive > 0) {
                    numTen--;
                    numFive--;
                } else if(numFive >= 3) {
                    numFive = numFive - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}