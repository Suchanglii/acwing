package 算法;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int q[] = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(q, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        for (; i < j; i++) {
            while (j >= 0 && numbers[i] + numbers[j] > target) j--;
            if (numbers[i] + numbers[j] == target) {return new int[]{i, j};}
        }
        return null;
    }
}
