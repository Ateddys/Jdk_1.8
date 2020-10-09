package cn.codesheep.test.hashMap;


import java.util.HashSet;
import java.util.Set;

/**
 * @program: javaSourceLearn
 * @description: 测试jdk源码环境
 * @author: Mr.Teddy
 * @create: 2020-09-16 11:23
 **/
public class Test {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("s");
        set.add("d");
        set.add("k");

        boolean empty = set.isEmpty();
        System.out.println(empty + "   大小   " + set.size());


        set.remove(0);

        System.out.println();
    }
}
