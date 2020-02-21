import java.util.Arrays;

public class 十种基本排序 {

    /**
     * 冒泡排序
     * 1. 比较两个相邻元素，如果前一个比后一个大就交换他们
     * 2. 针对每一对相邻元素做同样的事情，从开始第一对到结尾的最后一对，这样最后的元素应该是最大的数
     * 3. 针对所有元素重复以上步骤，除了最后一个
     * 重复1-3直到排序完成
     * @param array 整形数组
     * @return
     */
    public static int[] 冒泡排序(int[] array) {
        // 不占用内存，所以不重新申请空间，直接返回array
        if (array.length >0) {
            // 针对所有元素重复以上步骤
            for (int i = 0; i < array.length; i++) {
                boolean isSorted = true;
                // 针对每一对相邻元素做同样的事情，从开始第一对，到结尾的最后一对
                // 最后一位不进行比较，所以需要减去1
                // 随着元素的遍历，最后一位也在前移，所以要减去i，第一轮不用减，所以i从0开始
                for (int j = 0; j < array.length -1 -i; j++) {
                    // 比较两个相邻元素，如果前一个比后一个大，就交换他们
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                        isSorted = false;
                    }
                }
                // 当第一次循环没有进入交换顺序的时候，就直接返回，所以最佳时间复杂度是O(n)
                if (isSorted) {
                    return array;
                }
            }
        }
        return array;
        /**
         * 算法分析：
         * 一般情况下默认的时间复杂度都是是O(n2)
         * 但是在没有进行交换也就是本来就是排序好的情况下的时间复杂度可以是O(n）需要修改代码在第一次循环之后，直接返回
         */
    }

    /**
     * 选择排序
     * 最好最坏都是O(n2)
     * @param arrays
     * @return
     */
    public static int[] 选择排序(int[] arrays) {
        if (arrays.length >0) {
            for (int i = 0; i <arrays.length; i++) {
                // 默认最小有序的下标是i
                int minIndex = i;
                // 从i开始循环到最后进行比较,记录下坐标
                for (int j = i; j < arrays.length; j++) {
                    if (arrays[j] < arrays[minIndex] ) {
                        minIndex = j;
                    }
                }
                // 不相等就进行交换
                if (minIndex != i) {
                    int temp = arrays[minIndex];
                    arrays[i] = arrays[minIndex];
                    arrays[minIndex] = temp;
                }
            }
        }
        return arrays;
    }
    
    public static int[] 插入排序(int[] arrays) {
        if (arrays.length > 0) {
            // 直接从第二个开始，第一个没有比较性
            for (int i = 0; i < arrays.length - 1; i++) {
                int current = arrays[i + 1]; // 不会超出边界，最多是最后一个
                int preIndex = i;
                while(preIndex >= 0 && current < arrays[preIndex]) {
                    arrays[preIndex + 1] = arrays[preIndex];
                    preIndex --;
                }
                arrays[preIndex + 1] = current;
            }
        }
        return arrays;
    }


    public static int[] 希尔排序(int[] arrays) {
        return arrays;
    }


    public static void main(String[] args) {
        int[] 排序数组 = {11,1,2,3,4,5,6,7,8,9,10};
//        System.out.println("冒泡排序结果: " + Arrays.toString(十种基本排序.冒泡排序(排序数组)));
//        System.out.println("选择排序结果: " + Arrays.toString(十种基本排序.选择排序(排序数组)));
//        System.out.println("插入排序结果: " + Arrays.toString(十种基本排序.插入排序(排序数组)));
    }
}
