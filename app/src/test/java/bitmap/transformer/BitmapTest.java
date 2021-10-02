package bitmap.transformer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitmapTest {
    String inputFilePath = "./src/main/resources/Coffee.bmp";
    String outputFilePath = "./src/main/resources/";
    String purpleFileName = "NewCoffeePurple.bmp";
    Bitmap testFile = new Bitmap(inputFilePath,outputFilePath, purpleFileName);

    @Test
    public void testReadFile() {
        assertEquals(true, testFile.readFile(),"File not found");
    }

    @Test
    public void testSaveFile() {
        testFile.readFile();
        assertEquals(true, testFile.saveFile(),"File not saved");
    }

    @Test
    public void testInvertImage() {
        testFile.readFile();
        assertEquals(-13623977, testFile.imageInvert(),"Return: RGB(48, 29, 87)");
    }

    @Test
    public void testImageFlipHorizontal() {
        testFile.readFile();
        int lastRGBVal = -13762560;
        assertEquals(lastRGBVal, testFile.horizontalFliper(),"File not flipped horizontally");
    }

    @Test
    public void testImageFlipVertical() {
        testFile.readFile();
        int lastRGBVal = -16777216;
        assertEquals(lastRGBVal, testFile.verticalFliper(),"File not flipped vertically");
    }
    @Test
    public void testImageRotate() {
        testFile.readFile();
        int lastRGBVal = -16777216;
        assertEquals(lastRGBVal, testFile.imageRotate(),"File not rotated");
    }

}
