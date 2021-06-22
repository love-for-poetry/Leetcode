import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。

 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        //先给数组从小到大排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i < n - 2;i++){
            if (nums[i] > 0){ //若当前值大于0，后面的值都大于0，必然没有满足值
                return lists;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right){
                if (left > i + 1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }

                if (right < n - 1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }

                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right--;
                    left++;
                }
            }
        }


        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        //[-1,-1,0,1,2,-4]
        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }
}