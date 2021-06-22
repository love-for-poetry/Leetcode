import java.util.ArrayList;
import java.util.List;

/**
 17. 电话号码的字母组合
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 2(abc)  3(def) 4(ghi) 5(jkl) 6(mno) 7(pqrs) 8(tuv) 9(wxyz)
 示例 1：
 输入：digits = "23"
 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 示例 2：

 输入：digits = ""
 输出：[]
 示例 3：

 输入：digits = "2"
 输出：["a","b","c"]

 提示：
 0 <= digits.length <= 4
 digits[i] 是范围 ['2', '9'] 的一个数字。
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> reArr = new ArrayList<>();
        if(digits.length() < 1){
            return reArr;
        }
        String[] arr = new String[]{"abc","edf","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<StringBuilder> queues = new ArrayList<StringBuilder>();
        queues.add(new StringBuilder());
        for (int i=0;i < digits.length();i++){
            int key = Integer.parseInt(String.valueOf(digits.charAt(i))) - 2;
            List<StringBuilder> tmp = new ArrayList<StringBuilder>();

            while (!queues.isEmpty()){
                StringBuilder str = queues.remove(0);
                for (int j=0;j < arr[key].length();j++){
                    StringBuilder iStr = new StringBuilder();
                    iStr.append(str);
                    tmp.add(iStr.append(arr[key].charAt(j)));
                }
            }
            for (StringBuilder s : tmp){
                queues.add(s);
            }
        }

        for (StringBuilder stringBuilder : queues){
            reArr.add(stringBuilder.toString());
        }
//System.out.println(reArr.toString());
        return reArr;
    }
}