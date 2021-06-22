/**
 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。


 示例 1：

 输入：s = "()"
 输出：true
 示例 2：

 输入：s = "()[]{}"
 输出：true
 示例 3：

 输入：s = "(]"
 输出：false
 示例 4：

 输入：s = "([)]"
 输出：false
 示例 5：

 输入：s = "{[]}"
 输出：true


 提示：

 1 <= s.length <= 104
 s 仅由括号 '()[]{}' 组成
 **/

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1 || s.charAt(0) == '}' ||
                s.charAt(0) == ')' || s.charAt(0) == ']' ||
                s.charAt(n-1) == '{' || s.charAt(n-1) == '(' ||
                s.charAt(n-1) == '['
        ){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i=0;i < n;i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if (stack.empty() || (s.charAt(i) == '}' && stack.pop() != '{') ||
                        (s.charAt(i) == ')' && stack.pop() != '(') ||
                        (s.charAt(i) == ']' && stack.pop() != '[')){
                    return false;
                }
            }
        }

        if(!stack.empty()){
            return false;
        }

        return true;
    }
}
