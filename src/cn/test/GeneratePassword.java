package cn.test;

import java.util.ArrayList;
import java.util.List;

public class GeneratePassword {

    public static void main(String[] args) {
        for(int i =0 ;i< 10 ;i++){
            name(10);
        }
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    // 生成复杂码函数
    public static void name(int lenght) {

//        String[] pswdStr = { "qwertyuiopasdfghjklzxcvbnm",
//                "QWERTYUIOPASDFGHJKLZXCVBNM", "0123456789",
//                "~!@#$%^&*()_+{}|<>?:{}" };
        String[] pswdStr = { "qwertyuiopasdfghjklzxcvbnm",
                "QWERTYUIOPASDFGHJKLZXCVBNM", "0123456789",
                "~!@#$%^&*()_+{}|<>?:{}" };
        int pswdLen = lenght;
        String pswd = " ";
        char[] chs = new char[pswdLen];
        for (int i = 0; i < pswdStr.length; i++) {

            int idx = (int) (Math.random() * pswdStr[i].length());
            chs[i] = pswdStr[i].charAt(idx);

        }

        for (int i = pswdStr.length; i < pswdLen; i++) {

            int arrIdx = (int) (Math.random() * pswdStr.length);
            int strIdx = (int) (Math.random() * pswdStr[arrIdx].length());

            chs[i] = pswdStr[arrIdx].charAt(strIdx);
        }

        for (int i = 0; i < 1000; i++) {
            int idx1 = (int) (Math.random() * chs.length);
            int idx2 = (int) (Math.random() * chs.length);

            if (idx1 == idx2) {
                continue;
            }

            char tempChar = chs[idx1];
            chs[idx1] = chs[idx2];
            chs[idx2] = tempChar;
        }

        pswd = new String(chs);
        System.out.println(pswd);
    }

}
