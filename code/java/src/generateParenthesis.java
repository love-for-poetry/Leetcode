/***
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 **/

/**
 * 暴力法
 */
class Solution1 {
    public List<String> generateParenthesis(int n) {
        char[] brackets = new char[n*2];
        List<String> arr = new ArrayList<>();
        gener(brackets,0,arr);

        return arr;
    }

    public void gener(char[] brackets, int hight, List<String> arr){
        if(hight == brackets.length){//递归到底的情况
            String s = new String(brackets);
            if (isValid(s)){
                arr.add(s);
            }
        }else{//非递归到底情况
            brackets[hight] = '(';
            gener(brackets,hight + 1,arr);

            if(hight > 0){
                brackets[hight] = ')';
                gener(brackets,hight + 1,arr);
            }
        }
    }

    /**
     * 判断字符串是否为有效括号
     * @param s
     * @return
     */
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
            }else if (stack.empty() || (s.charAt(i) == '}' && stack.pop() != '{') ||
                        (s.charAt(i) == ')' && stack.pop() != '(') ||
                        (s.charAt(i) == ']' && stack.pop() != '[')){
                    return false;
            }
        }

        if(!stack.empty()){
            return false;
        }

        return true;
    }
}

/**
 * 回溯法
 */
class Solution2 {
    public List<String> generateParenthesis(int n){
        List<String> stringList = new ArrayList<>();
        char[] str = new char[n*2];
        generAll(stringList,str,0,0,0);
        return stringList;
    }

    public void generAll(List<String> strList,char[] str,int h,int left,int right){
        if (h == str.length){
            strList.add(new String(str));
            return;
        }

        if (left < str.length / 2){
            str[h] = '(';
            generAll(strList,str,h+1,left+1,right);
        }

        if (right < left){
            str[h] = ')';
            generAll(strList,str,h+1,left,right+1);
        }
    }
}