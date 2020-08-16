class Solution {
    //由于字符串中只有数字，使用数组来记录猜测数字中与秘密数字之间不同的数字的数量
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] countArr = new int[10];
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < len; i++) {
            char secretC = secret.charAt(i);
            char guessC = guess.charAt(i);
            if (secretC == guessC) {
                aCount++;
                continue;
            }
            countArr[guessC - '0']++;
            countArr[secretC - '0']--;
        }
        int bNum = 0;
        for (int i = 0; i < 10; i++) {
            bNum += countArr[i] > 0 ? countArr[i] : 0;
        }

        return aCount + "A" + (len - bNum - aCount) + "B";
    }
}