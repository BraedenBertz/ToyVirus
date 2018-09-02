/*
 * @Author Braeden Bertz
 */
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.W32APIOptions;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ScreenManipulation {
    private boolean AlreadyDone = false;

    ScreenManipulation(){}

    /*
     * @Method: If this method has already been called, then call invert. Otherwise it will call openMagnifier which will open the windowsMagnifier then call invert.
     * This ensures that there is not waster attempts to open then close the windowsMagnifier
     */
    void invertColors() {
        if (!AlreadyDone) {
            openMagnifier();
            try {Thread.sleep(1000);}
            catch (InterruptedException c) {c.printStackTrace();}
            invert();
            AlreadyDone = true;
        }
        else {invert();}
    }
    /*
     * @Method: Open the windowsMagnifier using a Robot and pressing the window's shortcut's keys
     */
    private void openMagnifier(){
        try {
            Robot keyPresser = new Robot();
            keyPresser.keyPress(524);//Windows Key
            keyPresser.keyPress(107);//Add Key
            try {Thread.sleep(1);}
            catch (InterruptedException c) {c.printStackTrace();}
            keyPresser.keyRelease(524);
            keyPresser.keyRelease(107);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /*
     * @Method: Invert the desktop's screen's color using a Robot and pressing the window's shortcut's keys
     */
    private void invert() {
        try {
            Robot keyPresser = new Robot();
            keyPresser.keyPress(17);//Ctrl key
            keyPresser.keyPress(18);//Alt Key
            keyPresser.keyPress(73);//I Key
            try {Thread.sleep(1);}
            catch (InterruptedException c) {c.printStackTrace();}
            keyPresser.keyRelease(17);
            keyPresser.keyRelease(18);
            keyPresser.keyRelease(73);
        }
        catch (AWTException e){
            e.printStackTrace();
        }
    }

    /*
     * @JavaMethod: Call the C library code at libScreenManipulation using JNI
     * @CMethod: Resize a screenshot of the current desktop to one inset by x & y using StretchBLT
     */
    void tunnelEffect(){
        new ScreenManipulation().CTunnelEffect();
    }

    /*
     * @JavaMethod: Call the C library code at libScreenManipulation using JNI
     * @CMethod: Take a screenshot of the desktop at RanX & RanY & RanWidth & RanHeight and set that screenshot to show at RanX & RanY using bitBLT
     */
    void screenGlitch(){
        new ScreenManipulation().CScreenGlitch();
    }

    /*
     * @Method: Take a picture of the current screen using a Robot and save the BufferedImage to an absolute path
     * Call SystemParametersInfo using JNA and send it the absolute path to the BufferedImage
     */
    void changeDesktopWallpaper() throws AWTException{
        Robot screenshot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        BufferedImage bi = screenshot.createScreenCapture(new Rectangle(0, 0, width, height));
        File outputFile = new File("C:\\WindowsNewBackground.png");

        try {ImageIO.write(bi, "png", outputFile);}
        catch (IOException e){e.printStackTrace();}

        User32.INSTANCE.SystemParametersInfo(0x0014, 0, "C:\\WindowsNewBackground.png" , 1);
    }

    private native void CTunnelEffect();

    private native void CScreenGlitch();

    public interface User32 extends com.sun.jna.Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo (int uiAction, int uiParam, String pvParam, int fWinIni);
    }

    //Load native library (C)
    static {
        System.loadLibrary("libScreenManipulation");
    }
}