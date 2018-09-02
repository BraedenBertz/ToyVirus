/*
 * @Author Braeden Bertz
 */
import java.awt.*;
import java.util.concurrent.TimeUnit;

class MouseManipulation {
    private Robot r;

    //Create a new instance of MouseManipulation and assign it Robot r
    MouseManipulation() {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param volatility A value of how far you want the cursor to be moved from the current position: the higher the more the curosr will violently jump
     */
    /*
    * @Method: Get the current mouse position then move the mouse to a new position within the volatility constraints relative to the original mouse position (additive instead of absolute)
    */
    void moveMouseRandomly(int volatility) {
        Point mouseLocal = MouseInfo.getPointerInfo().getLocation();
        if (mouseLocal != null) {
            //move the mouse to a random point within the volatility around the extant cursor position
            Comparator comparator = Comparator.AssignSign;
            int movementAmtX = comparator.e(volatility);
            int movementAmtY = comparator.e(volatility);
            r.mouseMove((int) mouseLocal.getX() + movementAmtX, (int) mouseLocal.getY() + movementAmtY);
        }
    }

    /*
    * @Method: Take note of mouse position two time, first is the relative, second is the changed amount. Take how far the mouse is away from the first position and move the mouse the negative amount of the change
    * relative to the original position (additive instead of absolute) * 2, because the mouse has already moved and must backtrack before it can go where it needs to be.
    */
    void invertMouse() {
        Point mouseLocalPrior = MouseInfo.getPointerInfo().getLocation();

        try {
            TimeUnit.NANOSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Point mouseLocalLatter = MouseInfo.getPointerInfo().getLocation();

        if (mouseLocalPrior != null && mouseLocalLatter != null) {
            double changeX = (mouseLocalLatter.getX() - mouseLocalPrior.getX()) * 2;
            double changeY = (mouseLocalLatter.getY() - mouseLocalPrior.getY()) * 2;
            r.mouseMove((int) mouseLocalPrior.getX() - (int) changeX, (int) mouseLocalPrior.getY() - (int) changeY);
        }
    }

    /*
    * @JavaMethod: Call the C library code at libChangeSystemCursor using JNI
    * @CMethod: Set each of the system cursor handles to a new cursor
    */
    void changeMouseCursor() {
        new MouseManipulation().CChangeMouseCursor();
    }

    /*
    * @JavaMethod: Call the C library code at libErrorIcons using JNI
    * @CMethod: Draw error icons at the mouse's position
    */
    void errorSigns(){
        new MouseManipulation().CerrorSigns();
    }

    //Declare native methods (C)
    private native void CChangeMouseCursor();

    private native void CerrorSigns();

    //Load native libraries (C)
    static {
        System.loadLibrary("libChangeSystemCursor");
    }

    static {
        System.loadLibrary("libErrorIcons");
    }
}
