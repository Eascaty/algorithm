package class01;

/**
 * @author: Zhaoxl
 * @date: 2024/5/2 16:06
 * @description:冒泡排序
 */
public class BubbleSort {

        public static void bubbleSort(int[] arr){
                if(arr == null || arr.length < 2 ){
                        return;
                }
                for (int e = arr.length - 1; e > 0 ; e-- ){
                        for( int i = 0 ;  i < e ; i ++ ){
                                if(arr[i] > arr[i + 1]){
                                        swap(arr,i,i+1);
                                }

                        }

                }
        }

        private static void swap(int[] arr, int i, int j) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
//                异或运算  相同为0 不同为1  无进位相加
        }
}