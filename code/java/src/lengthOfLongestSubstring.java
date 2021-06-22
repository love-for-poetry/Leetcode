/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

/**
 * 解题思路：
 * 1.暴力破解，依次循环每个字符，以此为起始点，二次循环找到该字符无重复的最长子串长度
 * 2.每次找到的字符串对应最长子串结束位置可以作为下个字符循环寻找的开始点，可以减少重头再次循环
 */
public int lengthOfLongestSubstring(String s) {
    HashSet<Character> hashSet = new HashSet<>();
    //"zxcvza"
    int maxNum = 0;
    int n = s.length();
    int right = 0;
    for(int i = 0;i < n;i++){
        if(i != 0){
            hashSet.remove(s.charAt(i-1));
        }
        while(right < n && !hashSet.contains(s.charAt(right))){
            hashSet.add(s.charAt(right));
            right++;
        }
        maxNum = Math.max(right-i,maxNum);
    }

    return maxNum;
}

