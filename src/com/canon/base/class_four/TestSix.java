package com.canon.base.class_four;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @Author Canon
 * @Date:Created in 22:32 2020/4/18
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class TestSix {


    static int binarySearch(int[] arr, int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] > n) {
                right = mid;
            }
            if (arr[mid] < n) {
                left = mid + 1;
            }
        }
        return -1;
    }


//    public static void main(String[] args) {
//        int[] ints = RandomUtils.randomArray(10, 20);
//        int n = ints[0];
//        System.out.println("排序前" + Arrays.toString(ints));
//        buleSort(ints);
//        System.out.println(n);
//        System.out.println("排序后" + Arrays.toString(ints));
//        System.out.println(binarySearch(ints, n));
//    }

    /**
     * 简单写一下冒泡吧
     *
     * @param arr
     * @return
     */
    static int[] buleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Trade><Head><Version>1.0</Version><TimeStamp>20200813155703156</TimeStamp><SequenceId>001</SequenceId><DeviceNo>AZJ001</DeviceNo><TransactionCode>V_HEART_BEAT</TransactionCode></Head><Body><Body><NodeName>master</NodeName></Body></Body></Trade>";
        String result = "";
        for (char c : str.toCharArray()) {
            result += Integer.toBinaryString(c);
        }
        // System.out.println(result);
        int length = str.getBytes("UTF-8").length;
//        System.out.println();
//        System.out.println("155 hex " + Integer.toHexString(4 + length));  // 9b   000000f6

        byte[] bytes = int2ByteArray(length);
//        System.out.println(Arrays.toString(str.getBytes("UTF-8")));
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Integer.toHexString(length));
        String prefix = prefix(length);
        System.out.println(prefix);
        System.out.println(prefix + byteToHex(str.getBytes("UTF-8")));
    }

    public static String prefix(int i) {
        // String string = Integer.toHexString(i);
        return String.format("%08x", i);
    }


    public static byte[] int2ByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }


    public static String byteToHex(byte[] bytes){
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }
}
