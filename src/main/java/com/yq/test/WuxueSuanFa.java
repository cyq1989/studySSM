package com.yq.test;

public class WuxueSuanFa {

    public static void main(String[] args) {
        int numa = 2;
        int numb = 3;

        StringBuilder resultBuilder = new StringBuilder("0.");
        resultBuilder.append((numa * 10) / numb);
        int tem = (numa * 10) % numb;
        while (tem != 0) {
            int aa = (tem * 10) / numb;
            resultBuilder.append(aa);
            tem = (tem * 10) % numb;
            if (resultBuilder.length() == 28) {
                break;
            }
        }
        //需要补零
        while (resultBuilder.length() != 28) {
            resultBuilder.append(0);
        }

        String result = "";

        //四舍五入操作
        if (Integer.valueOf(resultBuilder.substring(resultBuilder.length() - 1)) > 5) {
            //将resultBuff分解成string数组
            String[] stringArray = resultBuilder.toString().split("");
            //获取倒数第一个不为9的数
            int index = 0;
            for (int i = stringArray.length - 2; i >= 0; i--) {
                if (!(".").equals(stringArray[i]) && !"9".equals(stringArray[i])) {
                    index = i;
                    break;
                }
            }
            //将倒数第一个不为9的数加1
            stringArray[index] =  String.valueOf(Integer.valueOf(stringArray[index]) + 1);
            //将倒数第一个不为9的数以后的数全部变成0
            for (int a = index + 1; a < stringArray.length; a++) {
                if (!".".equals(stringArray[a])) {
                    stringArray[a] = "0";
                }
            }
            //获取最后的结果
            StringBuilder resultaa = new StringBuilder();
            for (int aa = 0; aa < stringArray.length - 1; aa++) {
                resultaa.append(stringArray[aa]);
            }
            result = resultaa.toString();
        } else {
            result = resultBuilder.substring(0, resultBuilder.length() - 1);
        }

        System.out.println(result);
        System.out.println(result.length());
    }

}
