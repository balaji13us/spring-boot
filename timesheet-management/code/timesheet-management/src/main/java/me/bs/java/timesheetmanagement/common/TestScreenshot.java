package me.bs.java.timesheetmanagement.common;



//Java Program to Capture full 
//Image of Screen 
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.UUID;

import javax.imageio.ImageIO; 

public class TestScreenshot { 
	public static final long serialVersionUID = 1L; 
	public static void main(String[] args) 
	{
		
		
		
		SavePrintScreenImagetoFile();
		
	}
	public static void testDate() {
		LocalDate startDayOfWeek = getFirstDateofWeek();
		
		LocalDate endDayOfWeek = getLastDateofWeek();
		
		System.out.println("Start of Week " + startDayOfWeek);

		System.out.println("End of Week " +endDayOfWeek);
	}
	
	public static LocalDate getFirstDateofWeek()
	{
		LocalDate ld =  LocalDate.now();
		
		LocalDate startDayOfWeek = ld.with(WeekFields.of(Locale.US).dayOfWeek(), 1L);
		return startDayOfWeek;
	}
	
	public static LocalDate getLastDateofWeek()
	{
		LocalDate ld =  LocalDate.now();
		
		LocalDate endDayOfWeek = ld.with(WeekFields.of(Locale.US).dayOfWeek(), 7L);
		return endDayOfWeek;
	}
	
	public static void SavePrintScreenImagetoFile()
	{
		
		Image image = getImageFromClipboard();
		
		if(image!=null) {
			LocalDate localDate = LocalDate.now();
			
			writeImageintoFile(toBufferedImage(image), 
					"ScreenShot-" 
					+ getFirstDateofWeek() + " - " + getLastDateofWeek() 
					+ ".jpg");
			//UUID.randomUUID().toString()
		}
		
		
	}
	
	public static void writeImageintoFile(BufferedImage img, String path) {
		
		try {
			ImageIO.write(img, "jpg", new File(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public static void getImageFromLiveScreen()
	{ 
		try { 
			Thread.sleep(120); 
			Robot r = new Robot(); 

			// It saves screenshot to desired path 
			String path = "Shot.jpg"; 

			// Used to get ScreenSize and capture image 
			Rectangle capture = 
			new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
			BufferedImage Image = r.createScreenCapture(capture); 
			ImageIO.write(Image, "jpg", new File(path)); 
			System.out.println("Screenshot saved"); 
		} 
		catch (AWTException | IOException | InterruptedException ex) { 
			System.out.println(ex); 
		} 
	} 
	
	
	/**
	 * Get an image off the system clipboard.
	 * 
	 * @return Returns an Image if successful; otherwise returns null.
	 */
	public static Image getImageFromClipboard()
	{
	  Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
	  if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
	  {
	    try
	    {
	      return (Image) transferable.getTransferData(DataFlavor.imageFlavor);
	    }
	    catch (UnsupportedFlavorException e)
	    {
	      // handle this as desired
	      e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	      // handle this as desired
	      e.printStackTrace();
	    }
	  }
	  else
	  {
	    System.err.println("getImageFromClipboard: There was not image in Clipboard!");
	  }
	  return null;
	}	
	
	/**
	 * Converts a given Image into a BufferedImage
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
} 

