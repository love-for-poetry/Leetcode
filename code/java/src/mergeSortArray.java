/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        for (int j = 0; j < nums1.length; j++) {
            if (p1 < m && p2 >= n){
                nums1[j] = arr[p1++];
            }else if(p1 >= m && p2 < n){
                nums1[j] = nums2[p2++];
            }else{

                nums1[j] = Math.min(arr[p1],nums2[p2]);
                if(nums1[j] == arr[p1]){
                    p1++;
                }else{
                    p2++;
                }
            }
        }
    }
}
