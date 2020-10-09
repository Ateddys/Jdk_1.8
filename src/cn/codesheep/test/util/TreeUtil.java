package cn.codesheep.test.util;

/**
 * @program: javaSourceLearn
 * @description: 数值校验工具类
 * @author: Mr.Teddy
 * @create: 2020-09-22 16:54
 **/
public class TreeUtil {

    /**
     * 求绝对值(整数）
     * @param $1 数值
     */
    public static int abs(int $1) {
        return ($1 < 0) ? -$1 : $1;
    }

    /**
     * 求绝对值(long）
     * @param $1 数值
     */
    public static long abs(long $1) {
        return ($1 < 0) ? - $1 : $1;
    }

    /**
     * 求绝对值(float）
     * @param $1 数值
     */
    public static float abs(float $1) {
        return ($1 <= 0.0F) ? 0.0F - $1 : $1;
    }

    /**
     * 求绝对值(浮点数）
     * @param $1 数值
     */
    public static double abs(double $1) {
        return (0.0D >= $1) ? 0.0D - $1 : $1;
    }

    /**
     * 判断一个数是否是素数
     * @param $1 数值
     */
    public static boolean isPrime(int $1) {
        if (2 > $1) return false;
        for (int i = 2; i * i <= $1; i++) {
            if (0 == ($1 % i)) return false;
        }
        return true;
    }

    /**
     * 计算平方根 （牛顿迭代法）
     * @param $1 参数1
     */
    public static double sqrt(double $1) {
        if (0 > $1) return Double.NaN;
        double err = 1e-15;
        double $2 = $1;
        while (TreeUtil.abs($2 - ($1 / $2)) > (err * $2)){
            $2 = (($1 / $2) + $2) / 2.0;
        }
        return $2;
    }

    /**
     * 计算一个数的n次方
     * @param $1 数值
     * @param $2 n次方
     */
    public static double hy(double $1, int $2) {
        if (2 < $2) return $1;
        for (int i = 0; i < $2; i++) {
            $1 *= $1;
        }
        return $1;
    }

    /**
     * 计算直角三角形的斜边
     * @param $1 参数1
     * @param $2 参数2
     */
    public static double hypotenuse(double $1, double $2) {
        return TreeUtil.sqrt(TreeUtil.hy($1, 2) + TreeUtil.hy($2, 2));
    }

}
