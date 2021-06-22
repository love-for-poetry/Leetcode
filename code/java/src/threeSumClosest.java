import java.util.Arrays;

/**
 16. 最接近的三数之和
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 示例：

 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

 提示：
 3 <= nums.length <= 10^3
 -10^3 <= nums[i] <= 10^3
 -10^4 <= target <= 10^4
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //判断特殊情况
        int n = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[n-1];;
        for (int i=0;i < n-2;i++){
            int left = i + 1;
            int right = n - 1;
            int iNum = 0;
            while (left < right){
                iNum = nums[i] + nums[left] + nums[right];
                if(Math.abs(iNum-target) < Math.abs(closest - target)){
                    closest = iNum;
                }

                if(iNum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,0,5,-5,3,3,0,-4,-5};
        //[-5,-5,-4,0,0,3,3,4,5]
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums,-2));
    }
}