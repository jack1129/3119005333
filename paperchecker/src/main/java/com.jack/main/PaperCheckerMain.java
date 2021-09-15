package com.jack.main;

import com.jack.utils.HammingUtils;
import com.jack.utils.SimHashUtils;
import com.jack.utils.TxtIO;

public class PaperCheckerMain {

    public static void main(String[] args) {
//        开始未通过io流，直接控制台手动输入绝对路径来测试代码可行性
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入一个文件路径：");
//        String s = scanner.nextLine();
//        args = s.split(" ");

        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = TxtIO.readTxt(args[0]);  // 读取原文的绝对路径
        String str1 = TxtIO.readTxt(args[1]);  // 读取抄袭版论文的绝对路径
        String resultFileName = args[2];  // 输出答案文件的绝对路径
        // 由字符串得出对应的 simHash值
        String simHash0 = SimHashUtils.getSimHash(str0);
        String simHash1 = SimHashUtils.getSimHash(str1);
        // 由 simHash值求出相似度
        double similarity = HammingUtils.getSimilarity(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
        TxtIO.writeTxt(similarity, resultFileName);
        System.out.println("相似度录入文件成功！");
        // 退出程序
        System.exit(0);
    }

}

