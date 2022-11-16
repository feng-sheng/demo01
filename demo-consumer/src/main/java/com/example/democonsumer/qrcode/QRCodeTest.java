package com.example.democonsumer.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @Author: lifengsheng
 * @Date: 2022/10/27 20:23
 * @Desc:
 */
public class QRCodeTest {
    public static void main(String[] args) throws Exception {
        String content = "https://des.sit.ihomefnt.org/#/solution-customer-add";
        String QRCodePath = "demo-consumer/src/main/resources/print/QRCode.png";
        String logoPath = "demo-consumer/src/main/resources/print/logo.png";
        String resultPath = "demo-consumer/src/main/resources/print/logo-QRCode.png";
        generateQRCode(content, 150, 150, QRCodePath);
        addLogoQRCode(new File(QRCodePath), new File(logoPath), new LogoConfig(), resultPath);
    }

    /**
     * 生成二维码图片
     *
     * @param content content
     * @param height height
     * @param weight weight
     * @param picturePath picturePath
     */
    public static void generateQRCode(String content, int height, int weight, String picturePath) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix;
        try {
            // 解决中文乱码
            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.MARGIN, 0);
            // 误差校正等级，不设置时，默认为L等级，等级不一样，生成的图案不同，但扫描的结果是一样的
             hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, weight, height, hints);
        } catch (WriterException e) {
            throw new RuntimeException("生成二维码错误");
        }
        System.out.println(new File(picturePath).exists());
        Path path = FileSystems.getDefault().getPath(picturePath);
        System.out.println("path is: " + path);
        try {
            // 生成的二维码图片默认背景为白色,前景为黑色,但是在加入logo图像后会导致logo也变为黑白色,
            // 所以这里对其第一个参数黑色将ZXing默认的前景色0xFF000000稍微改了一下0xFF000001,最终效果也是白色背景黑色前景的二维码,且logo颜色保持原有不变
            // 这里要显式指定MatrixToImageConfig,否则还会按照默认处理将logo图像也变为黑白色(如果打算加logo的话,反之则不须传MatrixToImageConfig参数)
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path, config);
        } catch (IOException e) {
            throw new RuntimeException("二维码写入错误");
        }
    }

    /**
     * 给二维码图片添加Logo
     *
     * @param qrPic qrPic
     * @param logoPic logoPic
     */
    public static void addLogoQRCode(File qrPic, File logoPic, LogoConfig logoConfig, String resultPath)
    {
        try {
            if (!qrPic.isFile() || !logoPic.isFile()) {
                System.out.print("file not find !");
                System.exit(0);
            }

            // 读取二维码图片，并构建绘图对象
            BufferedImage image = ImageIO.read(qrPic);
            Graphics2D g = image.createGraphics();

            // 读取Logo图片
            BufferedImage logo = ImageIO.read(logoPic);

            int widthLogo = image.getWidth()/logoConfig.getLogoPart();
            // int heightLogo = image.getHeight()/logoConfig.getLogoPart();
            int heightLogo = image.getWidth()/logoConfig.getLogoPart(); //保持二维码是正方形的

            // 计算图片放置位置
            int x = (image.getWidth() - widthLogo) / 2;
            int y = (image.getHeight() - heightLogo) / 2;

            //开始绘制图片
            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
            g.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
            g.setStroke(new BasicStroke(logoConfig.getBorder()));
            g.setColor(logoConfig.getBorderColor());
            g.drawRect(x, y, widthLogo, heightLogo);
            g.dispose();

            ImageIO.write(image, "png", new File(resultPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage addNote(BufferedImage image,String note) {
        Image src = image.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        BufferedImage tag;
        //生成新图片的大小
        tag = new BufferedImage(270, 270, BufferedImage.TYPE_INT_RGB);
        //设置低栏白边
        Graphics g1 = tag.getGraphics();
        //设置文字
        Graphics2D g2 = tag.createGraphics();
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        //下面这个26要和tag = new BufferedImage(330, 356,BufferedImage.TYPE_INT_RGB);356-330=26对上
        g1.fillRect(250, 250, 20, 20);
        //文字在图片上的位置
        g2.drawString(note,/*QRCODE_SIZE/2-note.length()*8-14*/20, 250 + font.getSize());
        g1.drawImage(src, 0, 0, null);
        g1.dispose();
        g2.dispose();
        image = tag;
        image.flush();
        return image;
    }

}
