import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 18. 四数之和
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：答案中不可以包含重复的四元组。

 示例 1：
 输入：nums = [1,0,-1,0,-2,2], target = 0
 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

 示例 2：
 输入：nums = [], target = 0
 输出：[]

 提示：

 0 <= nums.length <= 200
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length < 4){
            return lists;
        }
        //先给数组从小到大排序
        Arrays.sort(nums);
        for (int i=0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> arr = new ArrayList<List<Integer>>();
            arr = this.threeSum(nums,i+1,target - nums[i]);
            for (List<Integer> item : arr){
                item.add(nums[i]);
                lists.add(item);
            }
        }

        return lists;
    }

    public List<List<Integer>> threeSum(int[] nums,int index,int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        int n = nums.length;
        for (int i=index;i < n - 2;i++){
            if(i > index && nums[i] == nums[i-1]){
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

                if(nums[i] + nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right--;
                    left++;
                }

                if(nums[i] + nums[left] + nums[right] > target){
                    right--;
                }

                if(nums[i] + nums[left] + nums[right] < target){
                    left++;
                }
            }
        }


        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,-1,-1,1,1,2,2};
        solution.fourSum(nums,0);
    }
}