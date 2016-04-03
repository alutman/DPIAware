package dpiaware;

import java.awt.*;

/**
 * DPI aware implementation of Dimension
 */
public class DPIDimension extends Dimension {
    public DPIDimension(int width, int height) {
        super(DPIController.scaleToDPI(width), DPIController.scaleToDPI(height));
    }

    public DPIDimension(Dimension d) {
        super(DPIController.scaleToDPI(d));
    }
}
