package dpiaware;

import java.awt.*;

/**
 * DPI aware implementation of Font
 */
public class DPIFont extends Font {
    public DPIFont(String name, int style, int size) {
        super(name, style, DPIController.scaleToDPI(size));
    }
}
