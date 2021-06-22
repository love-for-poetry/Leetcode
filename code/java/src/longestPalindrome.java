/**
 5. 最长回文子串
 给你一个字符串 s，找到 s 中最长的回文子串。

 示例 1：
 输入：s = "babad"
 输出："bab"
 解释："aba" 同样是符合题意的答案。

 示例 2：
 输入：s = "cbbd"
 输出："bb"

 示例 3：
 输入：s = "a"
 输出："a"

 示例 4：
 输入：s = "ac"
 输出："a"

 提示：
   1 <= s.length <= 1000
   s 仅由数字和英文字母（大写和/或小写）组成
 */

public String longestPalindrome(String s) {

    int n = s.length();
    int maxLength = 1;
    String ans = s.substring(0,1);
    for(int i=0;i < n;i++){
        for (int j=i;j < n;j++){
            if (this.isPalindrome(s.substring(i,j+1)) && j-i+1 > maxLength){
                maxLength = j-i+1;
                ans = s.substring(i,j+1);
            }
        }
    }
    return ans;
}

public boolean isPalindrome(String s){
    int n = s.length();
    int mid;
    if(n%2==0){
        mid = n / 2;
    }else{
        mid = (n - 1)/2;
    }

    for (int i=0;i < mid;i++){
        if(s.charAt(i) != s.charAt(n-i-1)){
            return false;
        }
    }

    return true;
}
