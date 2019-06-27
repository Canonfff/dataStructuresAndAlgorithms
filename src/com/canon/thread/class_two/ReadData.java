package com.canon.thread.class_two;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/25 14:08
 * @Description:
 */
public class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read  :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
