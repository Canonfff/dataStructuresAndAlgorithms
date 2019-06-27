package com.canon.base.class_one;

import java.io.*;

public class TestThree {
    public static void main(String[] args)throws Exception{
        String str = "测试-𥖄𥖄𥖄";
        write(str);

    }
    static void write(String str)throws Exception{
        File f = new File("D:/a.txt");
        FileOutputStream out = new FileOutputStream(f.getPath());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // FileWriter fw = new FileWriter(f);
        // BufferedWriter bw = new BufferedWriter(fw);
        if (!f.exists()){
            f.createNewFile();
        }
        // bw.write(str,0,str.length()-1);
        // bw.close();
        out.write(str.getBytes());
    }
}
