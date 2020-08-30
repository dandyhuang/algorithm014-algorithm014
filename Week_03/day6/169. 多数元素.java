class Solution {
    public int majorityElement(int[] nums) {
        
        //Boyer-Moore 投票算法
        int res = 0;
        int count = 0;
        for(int num : nums) {
            if(count == 0){
                res = num;
                count++;
            } else {
                if(num == res) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}