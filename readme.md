DPIAware
========

Java utility classes for scaling Fonts and Dimensions for high DPI displays.

Default Swing apps are not DPI aware and will appear small on high DPI displays.
This provides methods for scaling the size of AWT components and Fonts to the ratio
between the common DPI used (96) and the system reported DPI.

96 is the most common DPI and AWT apps look correct on 96 DPI displays, hence
it being used to scale applications.


Usage
-----
All your Fonts and component dimensions will need to be modified to use the DPIAware
methods or classes.

#### Creation ####
Creating a new DPI aware font instance. All the following are equivalent

* `new DPIFont("monospace", Font.PLAIN, 12)`
* `new Font("monospace", Font.PLAIN, DPIContoller.scaleToDPI(12))`
* `DPIController.scaleToDPI(new Font("monospace", Font.PLAIN, 12))`

Creating a new DPI aware Dimension instance. All the following are equivalent

* `new DPIDimension(500,500)`
* `new Dimension(DPIController.scaleToDPI(500), DPIController.scaleToDPI(500))`
* `DPIController.scaleToDPI(new Dimension(500,500))`


#### Scale global AWT fonts ####
If you use default fonts for any of your components (i.e. did not specify the font)
you'll need to run the following before _any_ of your AWT components are loaded.

`DPIController.scaleFontsToDPI()`


#### Setting DPI to scale against manually ####
The system reported DPI and the DPI to scale against are both set initially
to whatever the system reports and 96 respectively.

These can be changed as desired but any modifications to the DPI values must be
done before calling any of the other utility methods. Use the following methods
to modify these values.

* `DPIController.setDPI(int dpi)`
* `DPIController.setDefaultDPI(int dpi)`