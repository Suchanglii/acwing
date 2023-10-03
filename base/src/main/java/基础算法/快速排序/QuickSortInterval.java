package 基础算法.快速排序;

import java.util.Arrays;

/**
 * 区间左值按照从小到大,区间右值按照从大到小,排序
 */
public class QuickSortInterval {

    public static void main(String[] args) {
        int[][] intervals = {{2, 5}, {1, 5}, {2, 3}, {2, 4}};
        sortIntervals(intervals, 0, intervals.length - 1);
        System.out.println(Arrays.deepToString(intervals));
    }

    // 排序区间数组的方法
    private static void sortIntervals(int[][] intervals, int left, int right) {
        if (left < right) {
            // 将区间数组分割为两部分，并返回枢纽点的索引
            int pivot = partition(intervals, left, right);
            // 递归对左半部分进行排序
            sortIntervals(intervals, left, pivot - 1);
            // 递归对右半部分进行排序
            sortIntervals(intervals, pivot + 1, right);
        }
    }

    // 将区间数组分割为两部分的方法
    private static int partition(int[][] intervals, int left, int right) {
        // 选择最右边的区间作为枢纽点
        int[] pivot = intervals[right];
        // 初始化较小元素的索引
        int i = left - 1;

        for (int j = left; j < right; j++) {
            // 如果当前区间的左值小于枢纽点的左值，
            // 或者当前区间的左值等于枢纽点的左值但右值大于枢纽点的右值，
            // 则将当前区间移到较小元素区域
            if (intervals[j][0] < pivot[0] || (intervals[j][0] == pivot[0] && intervals[j][1] > pivot[1])) {
                i++;
                swap(intervals, i, j);
            }
        }

        // 将枢纽点放置在正确的位置上
        swap(intervals, i + 1, right);
        // 返回枢纽点的索引
        return i + 1;
    }

    // 交换两个区间的位置
    private static void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }
}
