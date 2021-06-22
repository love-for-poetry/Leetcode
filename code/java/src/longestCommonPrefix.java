/**
 14. 最长公共前缀
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。



 示例 1：

 输入：strs = ["flower","flow","flight"]
 输出："fl"
 示例 2：

 输入：strs = ["dog","racecar","car"]
 输出：""
 解释：输入不存在公共前缀。


 提示：

 0 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] 仅由小写英文字母组成
 **/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        StringBuilder reStr = new StringBuilder();
        int cap = strs.length;
        flag:for(int n=0;;n++){
            for (int i=0;i < cap;i++){

                if(n == strs[i].length()){
                    break flag;
                }

                if (strs[i].equals("")){
                    return "";
                }

                if (i > 0 && strs[i].charAt(n) != strs[i-1].charAt(n)){
                    break flag;
                }else if(i == cap - 1 && strs[i].charAt(n) == strs[i-1].charAt(n)){
                    reStr.append(strs[i].charAt(n));
                }
            }
        }

        return reStr.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cir","car"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}