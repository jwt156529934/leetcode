package com.jwt.algorithm;

import java.util.Arrays;

/**
 * @author jwt
 * @date 2019/10/31
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr={2,4,1,5,7};
        try {
            int[] sort = sort(arr);
            for (int i : sort) {
                System.out.print(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }
}
