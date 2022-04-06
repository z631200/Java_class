import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

public class EXE5_2_extra {
    public static void main(String [] args){
        Random r = new Random();
        String name [][] = {{"張仲賢","曾煥傑","蔡舒庭","黃多佳"},
                            {"曾筱媛","何怡璇","王盛禾","詹定學","吳詩彥","黃胤元","林秋香","程子芸","王釋緯","王聖倫"},
                            {"陳明萱","朱巽葦","何孟修","朱芮儀","黃柏翰","黃宇帆","簡宏諭","陳品睿","李倬安","陳芊宇"},
                            {"陳冠銓","黃蘭榛","林翊佳","趙子安","張綺容","吳禹辰","林俊仰","李奕蓁","林楷軒","顏嘉緯"},
                            {"黃道永","張祈安","徐珮馨","魏慈萱","葉鑫旻","劉育嘉","廖紹洋","林均翰","劉浩倫","柯翔閔"},
                            {"陳永軒","林李慶冰","陳升嶸","周宥呈","張宸瑜","陳睿弘","王述函","林冠廷","盧亮澐","朱博脩"},
                            {"郎文伶","謝蕎安","丁予柔","黃冠蓁","李舲熏","周科均","游晴穎","謝維倫","林晉宇","陳莉豐"}};
        int pick [][] = new int [7][10];
        int response = JOptionPane.showConfirmDialog(null,"開始點名");

        while(response == 0){         
            int call_r = r.nextInt(name.length);
            int call_c = r.nextInt(name[call_r].length);
            pick[call_r][call_c] += 1;            
            response = JOptionPane.showConfirmDialog(null, "點到了 " + name[call_r][call_c] + "\n繼續點名嗎？");
            if(pick[call_r][call_c] > 1){
                JOptionPane.showMessageDialog(null, name[call_r][call_c] + "已點到" + pick[call_r][call_c] + "次");
            }          
        }
        System.exit(0);
    }
}
