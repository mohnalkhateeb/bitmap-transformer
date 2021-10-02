package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bitmap {
    private String inputFilePath;
    private String outputFilePath;
    private String newFileName;
    private BufferedImage image = null;
    public Bitmap(String inputFilePath, String outputFilePath, String newFileName) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.newFileName = newFileName;
    }

    public boolean readFile() {
        try {
            File file = new File(this.inputFilePath);
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveFile() {
        try {
            File outputFile = new File(this.outputFilePath + this.newFileName);
            ImageIO.write(this.image, "bmp", outputFile);
        } catch (IOException e) {
            System.out.println("File not found");
            return false;
        }
        return true;
    }

    public int imageInvert() {
        int lastRGBVal = 0;
        Color black = new Color(255,255,255);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        for (int h = 1; h < height; h++) {
            for (int w = 1; w < width; w++) {
                this.image.setRGB(w, h, black.getRGB()- this.image.getRGB(w,h));
                lastRGBVal = this.image.getRGB(w,h);
            }
        }
        return lastRGBVal;
    }

    public int horizontalFliper() {
        int lastRGBVal = 0;
        int height = this.image.getHeight();
        int width = this.image.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.image.setRGB((width - 1) - x, y, this.image.getRGB(x, y));
                lastRGBVal = this.image.getRGB(width - 1 - x, y);
            }
        }
        return lastRGBVal;
    }

    public int verticalFliper() {
        int lastRGBVal = 0;
        int height = this.image.getHeight();
        int width = this.image.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.image.setRGB(x, (height - 1) - y, this.image.getRGB(x, y));
                lastRGBVal = this.image.getRGB(x, height - 1 - y);
            }
        }
        return lastRGBVal;
    }
    public int imageRotate() {
        System.out.println("what is dimension  of your rotate , please chose x or y only ?");
         Scanner rota = new Scanner(System.in);
         String degree = rota.nextLine();
        int lastRGBVal = 0;
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        if(degree.equals("y") || degree.equals("Y")) {
            for (int y = 0; y < height / 2; y++) {
                for (int x = 0; x < width; x++) {
                    int changeRGB1 = this.image.getRGB(x, y);
                    int changeRGB2 = this.image.getRGB(x, height - 1 - y);
                    this.image.setRGB(x, y, changeRGB2);
                    this.image.setRGB(x, height - 1 - y, changeRGB1);

                    lastRGBVal = this.image.getRGB(x, height - 1 - y);
                }
            }
        }
        else if (degree.equals("x") || degree.equals("X")){
            for (int y = 0; y < height ; y++) {
                for (int x = 0; x < width/2; x++) {
                    int changeRGB1 = this.image.getRGB(x, y);
                    int changeRGB2 = this.image.getRGB(width-1-x,  y);
                    this.image.setRGB(x, y, changeRGB2);
                    this.image.setRGB(width-1-x, y, changeRGB1);

                    lastRGBVal = this.image.getRGB(width-1-x,  y);
                }
            }
        }
        else
        {
            System.out.println("we can not help you to rotate with your degree");
        }
        return lastRGBVal;
    }
}
