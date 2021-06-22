/**
 647. 回文子串
 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 示例 1：

 输入："abc"
 输出：3
 解释：三个回文子串: "a", "b", "c"
 示例 2：

 输入："aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


 提示：

 输入的字符串长度不会超过 1000 。
 **/

class Solution {
    /**
     * 动态规划（标记已经是回文串的前一个，不用多次循环）
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int num = s.length();
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int right=0;right < s.length();right++){
            for (int left = 0;left < right;left++){
                if(s.charAt(left) == s.charAt(right) && ((right - left < 3) || flag[left+1][right - 1])){
                    //System.out.println("left="+left+",right="+right);
                    flag[left][right] = true;
                    num++;
                }
            }
        }

        return num;
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        int num = s.length();
        for (int i=0;i < s.length();i++){
            for (int right=i + 1;right < s.length();right++){
                if (isSubString(s.substring(i,right))){
                    num++;
                }
            }
        }

        return num;
    }

    public boolean isSubString(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}