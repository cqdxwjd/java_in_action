package tiku.likou;

import tiku.likou.bean.ListNode;

import java.util.*;

public class Solution {
    //    public int[] twoSum(int[] nums, int target) {
//        int[] copyOf = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(nums);
//        int first = 0;
//        int second = 0;
//        for (int i = 0; i < nums.length; i++) {
//            first = i;
//            second = Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]);
//            if (second >= 0 && first != second) {
//                break;
//            }
//        }
//        for (int i = 0; i < copyOf.length; i++) {
//            if (copyOf[i] == nums[first]) {
//                first = i;
//                break;
//            }
//        }
//        for (int i = 0; i < copyOf.length; i++) {
//            if (copyOf[i] == nums[second] && i != first) {
//                second = i;
//                break;
//            }
//        }
//        return (first < second) ? new int[]{first, second} : new int[]{second, first};
//    }
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];
//    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        int num = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            num = sum % 10;
            if (head == null) {
                head = tail = new ListNode(num);
            } else {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {
        if (s.length() >= 1 && s.trim().length() == 0) {
            return 1;
        }
        int max = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                map.remove(s.charAt(i - 1));
            }
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 0);
                j++;
            }
            max = Math.max(max, map.size());
        }
        return max;
    }

    /**
     * 归并排序算法
     */
    public int[] mergeSort(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int m = 0;
        while (i < nums1.length && j < nums2.length) {
            result[m++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < nums1.length) {
            result[m++] = nums1[i++];
        }
        while (j < nums2.length) {
            result[m++] = nums2[j++];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        double result = 0;
        //分别进行奇数偶数处理
        if (length % 2 != 0) {
            result = getNum(nums1, nums2, length / 2);
        } else {
            result = getNum(nums1, nums2, length / 2 - 1) / 2 + getNum(nums1, nums2, length / 2) / 2;
        }
        return result;
    }

    public double getNum(int[] nums1, int[] nums2, int k) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int cur = 0;
        while (i < nums1.length && j < nums2.length && cur <= k) {
            if (nums1[i] < nums2[j]) result[cur++] = nums1[i++];
            else result[cur++] = nums2[j++];
        }
        while (i < nums1.length && cur <= k) result[cur++] = nums1[i++];
        while (j < nums2.length && cur <= k) result[cur++] = nums2[j++];
        return result[cur - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 2, 9}));
    }
}