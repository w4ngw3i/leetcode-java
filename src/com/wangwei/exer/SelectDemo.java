package com.wangwei.exer;

/**
 * @Author wangwei
 * @Date 2020/12/1 下午5:38
 * @Version 1.0
 * 二分查找变形实现， 查找第一个值等于给定的值的元素
 * 二分查找变形实现， 查找最后一个值值等于给定的值的元素
 * 二分查找变形实现， 查找第一个大于等于给定的值的元素
 * 二分查找变形实现， 查找最后一个小于等于给定的值的元素
 */
public class SelectDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 7, 8, 8, 8, 11, 18};
        System.out.println(halfSearch2(arr, 8));
        System.out.println(bsearchLast(arr, 8));
        int[] arr2 = {3, 4, 6, 7, 10};
        System.out.println(bsearchBig(arr2, 6));
        System.out.println(bsearchBig(arr2, 7));
    }

    // 简单实现 不适合 重复数据按指定位置的查询
    public static int halfSearch(int[] arr, int x){
        int min = 0;
        int max = arr.length-1;
        int mid;
        while (min <= max){
            mid = min + max >> 1;
            if (arr[mid] < x)
                min = mid + 1;
            else if (arr[mid] > x)
                max = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    // 二分查找变形实现， 查找第一个值等于给定的值的元素 {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    public static int bsearchFirst(int[] arr, int x){
        int low = 0;
        int hight = arr.length - 1;
        int mid;
        while (low <= hight){
            mid = low + ((hight - low) >> 1);
            if (arr[mid] > x){
                hight = mid - 1;
            }else if (arr[mid] < x){
                low = mid + 1;
            }else {
                // 匹配到对应的值并判断是否为第一个
                if (mid == 0 || arr[mid-1] != x) return mid;
                else hight = mid - 1;
            }
        }
        return -1;
    }

    // 二分查找变形实现， 查找最后一个值等于给定的值的元素 {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    public static int bsearchLast(int[] arr, int x){
        int low = 0;
        int hight = arr.length - 1;
        int mid;
        while (low <= hight){
            mid = low + ((hight - low) >> 1);
            if (arr[mid] > x){
                hight = mid - 1;
            }else if (arr[mid] < x){
                low = mid + 1;
            }else {
                if (mid == arr.length - 1 || arr[mid+1] != x) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找变形实现， 查找第一个值大于给定的值的元素 {3, 4, 6, 7, 10};
    public static int bsearchBig(int[] arr, int x){
        int low = 0;
        int hight = arr.length - 1;
        int mid;
        while (low <= hight){
            mid = low + ((hight - low) >> 1);
            if (arr[mid] >= x){
                if (mid == 0 || arr[mid-1] < x ) return mid;
                else hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    // 二分查找变形实现， 查找最后一个小于等于给定的值的元素 {3, 4, 6, 7, 10};
    public static int bsearchSmall(int[] arr, int x){
        int low = 0;
        int hight = arr.length - 1;
        int mid;
        while (low <= hight){
            mid = low + ((hight - low) >> 1);
            if (arr[mid] <= x){
                if (mid == arr.length - 1 || arr[mid+1] > x ) return mid;
                else low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }




    public static int halfSearch2(int[] arr, int x){
        int min = 0;
        int max = arr.length-1;
        int mid = max + min >> 1;
        while (arr[mid] != x){
            if (arr[mid] < x)
                min = mid + 1;
            else if (arr[mid] > x)
                max = mid - 1;
            if (min > max){
                return -1;
            }
            mid = max + min >> 1;
        }
        return mid;
    }
}
