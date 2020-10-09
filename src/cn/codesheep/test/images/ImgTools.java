package cn.codesheep.test.images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: javaSourceLearn
 * @description: 图片压缩
 * @author: Mr.Teddy
 * @create: 2020-09-23 09:35
 **/
public class ImgTools {

    /**
     * 按照 宽高 比例压缩
     *
     * @param img     原图
     * @param width   想要的宽度
     * @param height  想要的高度
     * @param imgType 原图片类型
     * @param out     新图片写到哪里？
     */
    public static void thumbnail_w_h(File img, int width, int height, String imgType, OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        double srcWidth = bi.getWidth(); // 源图宽度
        double srcHeight = bi.getHeight(); // 源图高度

        double scale;

        if (width > 0 && height > 0) {
            scale = height / srcHeight < width / srcWidth ? height / srcHeight : width / srcWidth;
        } else if (width > 0) {
            scale = width / srcWidth;
        } else if (height > 0) {
            scale = height / srcHeight;
        } else {
            scale = 1;
        }

        thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), imgType, out);

    }

    /**
     * 按照固定宽高原图压缩
     */
    private static void thumbnail(File img, int width, int height, String imgType, OutputStream out) throws IOException {
        BufferedImage BI = ImageIO.read(img);
        Image image = BI.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();
        ImageIO.write(tag, imgType, out);
    }

    /**
     * 按照宽高裁剪
     */
    public static void cut_w_h(File srcImageFile, int destWidth, int destHeight, OutputStream out) {
        cut_w_h(srcImageFile, 0, 0, destWidth, destHeight, out);
    }

    private static void cut_w_h(File srcImageFile, int x, int y, int destWidth, int destHeight, OutputStream out) {
        try {
            Image img;
            ImageFilter cropFilter;
            // 读取源图像
            BufferedImage bi = ImageIO.read(srcImageFile);
            int srcWidth = bi.getWidth(); // 源图宽度
            int srcHeight = bi.getHeight(); // 源图高度

            if (srcWidth >= destWidth && srcHeight >= destHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,
                        Image.SCALE_DEFAULT);

                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(destWidth, destHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null); // 绘制截取后的图
                g.dispose();
                // 输出为文件
                ImageIO.write(tag, "JPEG", out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
