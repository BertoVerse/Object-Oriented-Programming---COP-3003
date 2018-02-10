
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This class demonstrates how to build icon from an existing image. There
 * are four constants in the class. (leftTopX, leftTopY) defines where
 * to start extracting in the image. (width, height) defines the the size
 * of the icon, hence how many pixels to copy from the image.
 *
 * At last, this icon is loaded on a button.
 * 
 * Make sure the image file FGCU_logo.png is stored in the same directory.
 *
 * @author Dahai Guo
 *
 */
public class IconButtonFrame extends JFrame{
	private JButton button;

	// where to start extracting the icon in the image
	private static final int leftTopX = 20;
	private static final int leftTopY = 20;

	// the size of the icon
	private static final int width = 100;
	private static final int height = 100;

	/**
	 * To build icon from an existing image.
	 *
	 * @param path the path of the image
	 * @return
	 */
	private  Icon extractIcon(String path){
		// reads the image into a BufferedImage object
		BufferedImage image=null;
		try{
			image = ImageIO.read(new File(path));
		}catch(IOException e){
			System.err.println("Image not found");
			System.exit(1);
		}

		// allocates another BufferedImage object whose size is
		// the same as the one of the wanted icon
		BufferedImage part = new BufferedImage(
				width, height, BufferedImage.TYPE_4BYTE_ABGR
		);

		// copies the data from "image" to "part"
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				part.setRGB(x,y, image.getRGB(x+leftTopX, y+leftTopY));
			}
		}

		// creates an icon whose content is already in "part"
		ImageIcon icon = new ImageIcon();
		icon.setImage(part);

		// returns to the caller
		return icon;
	}

	/**
	 * This constuctor requires the path to an existing image file.
	 *
	 * @param imagePath  path to the image file
	 */
	public IconButtonFrame(String imagePath){
		super( "Icon from image" ); // set the title
		setLayout( new FlowLayout() ); // set frame layout

		Icon icon = extractIcon(imagePath); // finds the icon
		button = new JButton(icon); // creates a button with the icon
		add(button); // adds the button to the frame
	}


	public static void main( String args[] ){
	   IconButtonFrame buttonFrame = new IconButtonFrame("fgcu_logo.png");
	   buttonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   buttonFrame.setSize( 275, 150 ); // set frame size
	   buttonFrame.setVisible( true ); // display frame
	}
}
