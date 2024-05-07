package leetcode.editor.cn;//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public static  int[] searchRange(int[] nums, int target) {

        if(nums.length<1){
            return  new int[]{-1,-1};
        }
        int left= 0; int right = nums.length-1;
        if (nums[right] < target ){
            return new int[]{-1,-1};
        }
        while (left <= right){
            int middle = left + ((right-left) >>1);
            if (target <nums[middle] ){
                right = middle -1;
            }
            if (target > nums[middle] ){
                left = middle +1;
            }
            if(target == nums[middle]){

                for (left = middle ; left >=0; left--) {

                    if (nums[left] < target){
                        left = left +1 ;
                        break;
                    }
                }
                for (right = middle ; right< nums.length; right++) {
                    if (nums[right] > target){
                        right = right -1 ;
                        break;
                    }

                }
                if(right > nums.length-1)right--;
                if(left == -1) left++;
                return new int []{left,right};

            }


        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int [] arr = {1,4};
        int target = 4;
        int[] ints = searchRange(arr, target);
    }




    /*//方法一
//先找到一个mid，然后移动下标找范围，这种条件下时间复杂度在类似[1,1,1,1] target = 1的case中会退化为O(N)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[] {-1,-1};
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid -1;
            } else if(nums[mid] == target) {
                result[0] = mid;
                int i = mid;
                while(i-1 >= 0 && nums[i-1] == target) {
                    i--;
                }
                result[0] = i;
                int j=mid;
                while(j+1 <= nums.length-1 && nums[j+1] == target){
                    j++;
                }
                result[1] = j;
                return result;
            }
        }
        return result;
    }
}

//方法二
//单纯的做两次二分查找，为了减少代码量用一个flag合并重复代码
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[] {-1,-1};
        int minIndex = findIndex(nums, target, left, right, true);
        if(minIndex == -1) {
            return result;
        }
        int maxIndex = findIndex(nums, target, left, right, false);
        result = new int[]{minIndex, maxIndex};
        return result;
    }

    private int findIndex(int[] nums, int target, int left, int right, boolean lower) {
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid -1;
            } else if(nums[mid] == target && lower) {
                result = mid;
                right = mid -1;
            } else if(nums[mid] == target) {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }
}
*/
}
//leetcode submit region end(Prohibit modification and deletion)
