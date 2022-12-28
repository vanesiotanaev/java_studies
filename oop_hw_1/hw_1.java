package oop_hw_1;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class hw_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("oop_hw_1/input.txt"));
        String str;
        String res = "";
        while ((str = br.readLine()) != null) {
            str = str.replace(" ", "");
            str = str.substring(2);
            res += str + " ";
        }
        br.close();
        String[] res2 = res.split(" ");
        int x1 = Integer.parseInt(res2[0]);
        int x2 = Integer.parseInt(res2[1]);
        int res_num = 0;
        double res_num2 = 0;
        String res_num3 = "";
        if (x1 != 0 && x2 >= 0) {
            res_num = (int)Math.pow(x1, x2);
            res_num3 += res_num;
        }
        if (x1 == 0 && x2 > 0){
            res_num = 0;
            res_num3 += res_num;
        }
        if (x1 == 0 && x2 < 0){
            res_num3 += "На ноль делить нельзя";
        }
        if (x2 < 0) {
            x2 = (-1) * x2;
            res_num2 = 1 / (double)Math.pow(x1, x2);
            res_num3 += res_num2;
        }
        if (x1 == 0 && x2 == 0) {
            res_num3 += "Неопределено";
        }

        try (FileWriter fw = new FileWriter("oop_hw_1/output.txt", false)) {
           
            fw.write("result: " + res_num3);
            fw.flush();               

                     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}