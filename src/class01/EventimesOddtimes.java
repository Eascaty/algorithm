package class01;

/**
 * @author: Zhaoxl
 * @date: 2024/5/3 12:05
 * @description:  位运算例题
 */
public class EventimesOddtimes {

//        一个数组中，一种数出现过奇数次，其他都是偶数次。时间复杂度O(N) 空间复杂度O(1)
    public static void printOddtimesNum1(int[] arr){
//        位运算的 结合律，交换律，以及相同项异或为0
        int ero = 0 ;
        for (int cur : arr) {
            ero ^= cur;
        }
        System.out.println(ero);
    }

//    一个数组中，两种数出现过奇数次，其他都是偶数次。
    public static void  printOddTimesNum2(int[] arr){
        int eor  = 0 ;
        for (int curNum : arr){
            eor ^= curNum;
        }
//        一个数(与运算 符号为&   两个数同时为一结果才为一)上他的取反加一，就可以得出他最右侧的一
        int rightone  =  eor & (~eor + 1);

        int onlyOne = 0 ; // 他就相当于~eor
        for (int cur :
                arr) {
            if((cur & rightone) ==0){
                onlyOne  ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    public static void main(String[] args) {
        int []arr = new int[] {5,5,5,6,6};
        printOddtimesNum1(arr);
        int [] arr2 = {5,6,6,6,4,4};
        printOddTimesNum2(arr2);

    }

}