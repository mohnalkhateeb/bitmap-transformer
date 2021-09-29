package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    private String inputFilePath;
    private BufferedImage image;
    private String outputFilePath;
    private String newFileName;

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
}
