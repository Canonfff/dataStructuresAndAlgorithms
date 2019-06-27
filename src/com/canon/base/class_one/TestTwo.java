package com.canon.base.class_one;

public class TestTwo {
    public static void main(String[] args) throws Exception {
        String a = "测试-𥖄𥖄𥖄";
        byte[] bytes = a.getBytes("unicode");
        StringBuffer out = new StringBuffer("");
        //然后将其byte转换成对应的16进制表示即可
        for (int i = 0; i < bytes.length - 1; i += 2) {
            out.append("\\u");
            String str = Integer.toHexString(bytes[i + 1] & 0xff);
            for (int j = str.length(); j < 2; j++) {
                out.append("0");
            }
            String str1 = Integer.toHexString(bytes[i] & 0xff);
            out.append(str1);
            out.append(str);
        }
        System.out.println(out.toString());
        System.out.println(decodeUnicode(out.toString()));
    }
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
