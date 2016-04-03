package dpiaware;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * Methods for scaling values to the DPI
 */
public class DPIController {

    /* Standard DPI for most displays */
    private static int  DEFAULT_DPI = 96;

    /* What the OS says the DPI is. This won't reflect real screen DPI but it should be set properly if the
     * system is running at it's recommended resolution */
    private static int DPI = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();

    /**
     * Get the current DEFAULT_DPI. Defaulted to 96
     * @return DEFAULT_DPI
     */
    public static int getDefaultDPI() {
        return DEFAULT_DPI;
    }

    /**
     * Set the DEFAULT_DPI. This will modify how much scaling is done
     * @param dpi the new DPI value
     */
    public static void setDefaultDPI(int dpi) {
        DEFAULT_DPI = dpi;
    }

    /**
     * Get the system's reported DPI
     * @return system DPI
     */
    public static int getDpi() {
        return DPI;
    }

    /**
     * Set the DPI
     * @return system DPI
     */
    public static void setDPI(int dpi) {
         DPI = dpi;
    }

    /**
     * Scale an int value according to the ratio between the DEFAULT_DPI and the actual DPI
     * @param input int value to scale
     * @return scaled int value
     */
    public static int scaleToDPI(int input) {

        int factor =  DPI / DEFAULT_DPI;

        return factor * input;
    }

    /**
     * Scale a Dimension value according to the ratio between the DEFAULT_DPI and the actual DPI
     * @param input Dimension value to scale
     * @return scaled Dimension value
     */
    public static Dimension scaleToDPI(Dimension input) {

        return new Dimension(scaleToDPI(input.width), scaleToDPI(input.height));
    }

    /**
     * Scale a Font size value according to the ratio between the DEFAULT_DPI and the actual DPI
     * @param input Font to scale
     * @return scaled Font
     */
    public static Font scaleToDPI(Font input) {

        return input.deriveFont(scaleToDPI(input.getSize())*1f);
    }


    /**
     * Go through all the default Fonts in UIManager.getDefaults() and scale the font sizes
     * according to the ratio between the DEFAULT_DPI and actual DPI
     */
    public static void scaleFontsToDPI() {

        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                Font f = ((FontUIResource) value);
                UIManager.put(key, scaleToDPI(f));
            }
        }
    }
}
