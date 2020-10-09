package cn.codesheep.test.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

/**
 * @program: javaSourceLearn
 * @description: 将照片用字符方式打印出来
 * @author: Mr.Teddy
 * @create: 2020-09-23 08:54
 **/
public class MakeImagesTest {
    static final int bi = 500;  // 切点
    static final String base = "@#&$%*o!;.";   // 字符串由复杂到简单

    public static void main(String[] args) {
        try {
            File img = new File("/Users/ty/Desktop/Kat_1600832918475.jpg");
            BufferedImage image = ImageIO.read(img);

            if (image.getHeight() > bi || image.getWidth() > bi) {

                String[] split = img.getName().split("\\.");

                String imgType = split[split.length - 1]; // 图片类型

                String url = img.getParent() + "/" + split[0] + "_" + new Date().getTime() + "." + imgType;

                FileOutputStream out = new FileOutputStream(url);

                ImgTools.thumbnail_w_h(img, bi, bi, imgType, out);

                image = ImageIO.read(new File(url));
            }

            createAsciiPic(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAsciiPic(final BufferedImage image) {
        try {
            for (int y = 0; y < image.getHeight(); y += 8) {
                for (int x = 0; x < image.getWidth(); x += 4) {
                    final int pixel = image.getRGB(x, y);

                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;

                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;

                    final int index = Math.round(gray * (base.length() + 1) / 255);

                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
