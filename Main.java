/*
 * @Author Braeden Bertz
 */
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main (String args[]){
        Main start = new Main();
    }

    /*
     * @Method: Create every runnable and assign each to an individual thread--Each runnable has its own timer so a different thread
     * is needed to maintain the timings.
     * Start each thread
     */
    private Main() {
        final MouseManipulation mouse = new MouseManipulation();
        final WindowManipulation window = new WindowManipulation();
        final ScreenManipulation screen = new ScreenManipulation();
        final SoundManipulation soundM = new SoundManipulation();

        JOptionPane.showMessageDialog(null, "*Maniacal Laughing*");

        Runnable jitter = () -> {
            while (true) {
                mouse.moveMouseRandomly(3);
                sleep(50, "MILLISECONDS");
            }
        };

        Runnable invertScreenColors = () -> {
            while (true) {
                screen.invertColors();
                sleep(1, "SECONDS");
            }
        };

        Runnable PopUp = () -> {
            while (true) {
                popUp();
                sleep(5, "SECONDS");
            }
        };

        Runnable OpenBrowser = () -> {
            while (true){
                window.openWindow();
                sleep(30, "SECONDS");
            }
        };

        Runnable inverseMouseMovement = () -> {
            while (true) {
                mouse.invertMouse();
                sleep(50, "NANOSECONDS");
            }
        };

        Runnable ChangeMouseCursor = () -> {
            while (true){
                mouse.changeMouseCursor();
                sleep(5, "SECONDS");
            }
        };

        Runnable End = () -> {
            sleep(1, "MINUTES");
            System.exit(0);
        };

        Runnable errorIcons = () -> {
            sleep(20, "MILLISECONDS");
        };

        Runnable sound= ()->{
            String path = "C:\\Wav files\\File0";
            String extension = ".wav";
            String[] wavFilePaths = {path+"052"+extension,path+"056"+extension,path+"057"+extension,path+"058"+extension,path+"059"+extension,
                    path+"060"+extension,path+"062"+extension,path+"063"+extension,path+"064"+extension,
                    path+"086"+extension,path+"123"+extension, path+"187"+extension,path+"188"+extension,
                    path+"189"+extension,path+"206"+extension,path+"207"+extension,path+"213"+extension,
                    path+"214"+extension, path+"215"+extension, path+"216"+extension,path+"217"+extension,
                    path+"218"+extension,"C:\\Users\\Larry\\Desktop\\Wav files\\Megalovania"+extension};

            Random rand = new Random();

            while (true) {
                soundM.setPath(wavFilePaths[rand.nextInt(23)]);
                try {
                    soundM.playSound();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                sleep(3, "SECONDS");
            }
        };

        Runnable Tunnel = () -> {
            for (int i = 0; i < 5; i++) {
                screen.tunnelEffect();
                sleep(2, "SECONDS");
            }
        };

        Runnable ScreenGlitch = () -> {
            for (int i = 0; i < 5; i++) {
                screen.screenGlitch();
                sleep(3, "SECONDS");
            }
        };

        Runnable printFile = () -> {
            for (int i = 0; i < 5; i++) {
                window.printFile();
                sleep(1, "MINUTES");
            }
        };

        //Assign each thread its runnable
        Thread errors = new Thread(errorIcons);
        Thread print = new Thread(printFile);
        Thread mouseJitter = new Thread(jitter);
        Thread inverseScreenColor = new Thread(invertScreenColors);
        Thread PopUpMenus = new Thread(PopUp);
        Thread browser = new Thread(OpenBrowser);
        Thread IMM = new Thread(inverseMouseMovement);
        Thread CMC = new Thread(ChangeMouseCursor);
        Thread EndProgram = new Thread(End);
        Thread Sound = new Thread(sound);
        Thread tunnel = new Thread(Tunnel);
        Thread SG = new Thread(ScreenGlitch);

        //Start each thread
        errors.start();
        print.start();
        SG.start();
        tunnel.start();
        Sound.start();
        CMC.start();
        IMM.start();
        PopUpMenus.start();
        mouseJitter.start();
        inverseScreenColor.start();
        browser.start();
        EndProgram.start();
    }

    /**
     * @param sleepTime How long you would like the Thread to sleep for
     * @param Unit The time unit you would like to use
     */
    private void sleep(int sleepTime, String Unit) {
        switch (Unit) {
            case "SECONDS":
                try {
                    TimeUnit.SECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "MILLISECONDS":
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "MINUTES":
                try {
                    TimeUnit.MINUTES.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "NANOSECONDS":
                try {
                    TimeUnit.NANOSECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    TimeUnit.HOURS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    /*
     * @Method: Create a Dialogue box at a random point
     */
    private void popUp(){
        Point popUpSpot = new Point();
        Random random = new Random();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        popUpSpot.setLocation(random.nextInt(screenSize.width), random.nextInt(screenSize.height));
        JOptionPane pane = new JOptionPane("Still Using this computer?");
        JDialog d = pane.createDialog(null, "LOL");
        d.setLocation(popUpSpot);
        d.setVisible(true);
    }

    /*
     * @Method: Shutdown the computer for Windows and Linux
     */
    public static void shutdown() throws RuntimeException, IOException {
        String shutdownCommand;
        String operatingSystem = System.getProperty("os.name");

        if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
            shutdownCommand = "shutdown -h now";
        }
        else if ("Windows".equals(operatingSystem)) {
            shutdownCommand = "shutdown.exe -s -t 0";
        }
        else {
            throw new RuntimeException("Unsupported operating system.");
        }

        Runtime.getRuntime().exec(shutdownCommand);
        System.exit(0);
    }
}
