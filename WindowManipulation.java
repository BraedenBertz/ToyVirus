/*
 * @Author Braeden Bertz
 */
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

class WindowManipulation {

    /*
    * @Method: Attempt to print a text file
    */
    void printFile() {
        try {
            Desktop desktop = Desktop.getDesktop();
            File txtFile = new File("C:\\Users\\txtFile.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile));
            writer.write("You've been infected!");
            writer.close();
            desktop.print(txtFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * @Method: Open the computer's default browser and open a defined page randomly from the list below
    */
    void openWindow() {
        Random random = new Random();
        Desktop desktop = Desktop.getDesktop();
        int temp = random.nextInt(8);
        switch (temp) {
            case 0:
                try {
                    desktop.browse(new URI("https://www.clubpenguinisland.com/"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 1:
                try {
                    desktop.browse(new URI("https://www.google.com/search?q=hOw+To+ReMoVe+ViRuS&rlz=1C1CHBF_enUS737US737&oq=hOw+To+ReMoVe+ViRuS&aqs=chrome..69i57j0l5.15275j1j7&sourceid=chrome&ie=UTF-8"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 2:
                try {
                    desktop.browse(new URI("https://www.malwarebytes.com/"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 3:
                try {
                    desktop.browse(new URI("https://www.avast.com/en-us/index"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 4:
                try {
                    desktop.browse(new URI("https://braedenbertz.wordpress.com/"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 5:
                try {
                    desktop.browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 6:
                try {
                    desktop.browse(new URI("https://www.wizard101.com/"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            case 7:
                try {
                    desktop.browse(new URI("https://www.google.com/search?q=WhY+iS+mY+cOmPuTeR+FUnkY&rlz=1C1CHBF_enUS737US737&oq=WhY+iS+mY+cOmPuTeR+FUnkY&aqs=chrome..69i57.20355j1j7&sourceid=chrome&ie=UTF-8"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
                break;
            default:
                try {
                    desktop.browse(new URI("https://en.wikipedia.org/wiki/HTTP_404"));
                } catch (URISyntaxException e) {
                    System.out.println(e.getReason());
                } catch (IOException l) {
                    l.printStackTrace();
                }
        }
    }
}
