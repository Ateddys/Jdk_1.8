package cn.codesheep.test.admin;

/**
 * @program: javaSourceLearn
 * @description: 自增变量
 * @author: Mr.Teddy
 * @create: 2020-09-18 16:45
 **/
public class Test1 {

    public static void main(String[] args) {
        int i = 1;  // 初始化 i=1

        i = i++;    // i = 1

        int j = i++; // i = 2    j = 1

        int k = i + ++i * i++;  // i = 4    j = 1   k = 11

        System.out.println("i=======" + i);
        System.out.println("j=======" + j);
        System.out.println("k=======" + k);
    }
}
