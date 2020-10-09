package cn.codesheep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Binary tree
 * @description: 快速查找《二叉树算法》
 * @author: Mr.Teddy
 * @create: 2020年09月23日14:57:38
 **/
public class Test {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 2, 2, 6, 9, 23};
        int key = 2;
        Arrays.sort(a);

        List<Integer> ranks = rank(key, a);
        if (ranks.size() == 0) {
            System.out.println("没有你要查找的数据. ");
        } else {
            System.out.println("你要匹配的数据集如下：");
        }

        ranks.forEach(System.out::println);

    }

    private static List<Integer> rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        List<Integer> list = new ArrayList<>(a.length);

        while (lo <= hi) {

            int mind = (lo + hi) / 2;   // 寻找计算出中标

            if (a[mind] == key) {

                // 直接命中目标，防止有重复数据
                // 先往中标左边全部排查，找到的直接放入list
                int temp = mind - 1;
                while (temp >= 0 && a[temp] == key) { // 当移动的temp比0还要小时候证明已经排查完了，在往左边就没有了数值   那就直接返回了

                    list.add(a[temp]);

                    temp -= 1;  // 左移（依次向左缩短）
                }

                list.add(a[mind]); // 插入第一次就命中的数据到list

                // 再往中标右边全部排查，找到的直接放入list
                temp = mind + 1;
                while (temp <= a.length - 1 && a[temp] == key) { // 当移动的temp比a数组长度还要大时候，证明已经排查完了，在往右面就没有了数值   那就直接返回了

                    list.add(a[temp]);

                    temp += 1;  // 右移（依次向右缩短）
                }

                return list;
            } else if (a[mind] > key) {

                hi = mind - 1;  // 向左找
            } else {

                lo = mind + 1;// 向右找
            }
        }
        return new ArrayList<>(0);
    }
}