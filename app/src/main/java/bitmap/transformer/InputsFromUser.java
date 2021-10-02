package bitmap.transformer;

import java.util.Scanner;

public class InputsFromUser {
    private static final int EXIT = 0;
    private static int transformerChoice;
    private static String inputImageFile;
    private static String outFileName;

    private static Scanner scan = new Scanner(System.in);


    static void inputFromUser() {
        System.out.println("Enter a Bitmap file to manipulate or 0 to exit , the file extension should be (.bmp): ");
        inputImageFile = scan.nextLine();
        if (inputImageFile.equals("0")) return;
        System.out.println("Enter a name for your new file without a file extension): ");
        outFileName = scan.nextLine();
        do {
            System.out.println("Transformation Choice: \n" +
                    "---------------------------------\n" +
                    "0 : Exit\n" +
                    "1 : Invert\n" +
                    "2 :  Horizontal Flip\n" +
                    "3 :  Vertical Flip\n" +
                    "4 :  Rotate\n");

            System.out.println("Enter the number of  transformation type  ");
            try {
                transformerChoice = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("You did not enter a number, please try again\n");
            }
        } while (true);
        System.out.println();
        bitMapManipulate();
    }

    private static void bitMapManipulate() {
        if (transformerChoice == EXIT) return;
        else {
            if (transformerChoice == 1 || transformerChoice == 2 || transformerChoice == 3 || transformerChoice == 4) {
                bitMapSetting();
            }
            else System.out.println("\nNot a correct option\n");
        }
        inputFromUser();
    }

    private static void bitMapSetting() {
        String imageFilePath = "./app/src/main/resources/" + inputImageFile;
        String outFilePath = "./app/src/main/resources/";
        String outFile = outFileName + ".bmp";

        Bitmap bitImage = new Bitmap(imageFilePath, outFilePath, outFile);
        bitImage.readFile();

        if (transformerChoice == 1) {
            bitImage.imageInvert();
        } else if (transformerChoice == 2) {
            bitImage.horizontalFliper();
        } else if (transformerChoice == 3){
            bitImage.verticalFliper();
        }
        else
        {
            bitImage.imageRotate();
        }

        bitImage.saveFile();
        System.out.println(String.format("%s created, viewable upon exit\n", outFileName));
    }
}
