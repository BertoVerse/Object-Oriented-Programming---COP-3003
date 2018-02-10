import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Random;

// I will be developing a class, called JEightPuzzleFrame, which extends
// JFrame. Its constructor has two parameters: 1) title of window, 2) the path
// to an image. (My program does not need to verify that the image is really a
// square.)
public class JEightPuzzleFrame extends JFrame implements ActionListener {

    private int height;
    private int width;
    private int position[][];
    private int count[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // keep track of where
    private JPanel centerPanel;
    private JButton[][] listOfBtn = new JButton[3][3];
    private String Path;
    private String Title;

    private JEightPuzzleFrame(String Title, String Path) {
        this.Path = Path;
        this.Title = Title;

        set();

    }

    private Image getIcon(int i, int j) {
        // Read the image from folder, this is why the image file needs to be
        // in the same folder as the .java docs.
        BufferedImage image = null;
        try {
            image = ImageIO.read( new File( Path ) );
        } catch (IOException e) {
            System.err.println( "Image not found" );
            System.exit( 1 );
        }
        // get the height and width of/from the png file in order to take
        // said dimensions into consideration.
        // The size of the window is decided by the image size
        width = image.getWidth();
        height = image.getHeight();
        Image source = image;
        return createImage( new FilteredImageSource( source.getSource(),
                new CropImageFilter( j * width / 3, i * height / 3,
                        (width / 3) + 1, height / 3 ) ) );
    }

    private void set() {
        position = new int[][]{ // Assigns position to each square.
                {0, 1, 2},      // -1 base index as directed on class
                {3, 4, 5},      // instructions. That is the reason why you
                {6, 7, 8}};     // you technically start with zero.

        centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout( 3, 3, 0, 0 ) ); // 3x3 grid as
        // directed
        add( centerPanel, BorderLayout.CENTER );

        // reads the image into a BufferedImage object from the folder
        BufferedImage image = null;
        //Try catch statement ahead found in IconButtonFrame.java class provided
        try {
            image = ImageIO.read( new File( Path ) );
        } catch (IOException e) {
            System.err.println( "Image not found" );
            System.exit( 1 );
        }
        // get the height and width of the image for the window size.
        // The size of the window is decided by the image size
        width = image.getWidth();
        height = image.getHeight();

        // Set up for initial Game, a segment of code for each button
        // Each button is loaded with a part of the image. When the puzzle
        // is solved, these parts will make up the original image, missing
        // the right-bottom corner

        //  for button 1
        listOfBtn[0][0] = new JButton();
        centerPanel.add( listOfBtn[0][0] );
        count[0] = 9;
        // for button 2
        listOfBtn[0][1] = new JButton();
        listOfBtn[0][1].addActionListener( this );
        centerPanel.add( listOfBtn[0][1] );
        listOfBtn[0][1].setIcon( new ImageIcon( getIcon( 0, 0 ) ) );
        listOfBtn[0][1].setVisible( true );
        count[1] = 1;
        //  for button 3
        listOfBtn[0][2] = new JButton();
        listOfBtn[0][2].addActionListener( this );
        centerPanel.add( listOfBtn[0][2] );
        listOfBtn[0][2].setIcon( new ImageIcon( getIcon( 0, 1 ) ) );
        listOfBtn[0][2].setVisible( true );
        count[2] = 2;
        //  for button 4
        listOfBtn[1][0] = new JButton();
        listOfBtn[1][0].addActionListener( this );
        centerPanel.add( listOfBtn[1][0] );
        listOfBtn[1][0].setIcon( new ImageIcon( getIcon( 1, 1 ) ) );
        listOfBtn[1][0].setVisible( true );
        count[3] = 5;
        //    for button 5
        listOfBtn[1][1] = new JButton();
        listOfBtn[1][1].addActionListener( this );
        centerPanel.add( listOfBtn[1][1] );
        listOfBtn[1][1].setIcon( new ImageIcon( getIcon( 1, 2 ) ) );
        listOfBtn[1][1].setVisible( true );
        count[4] = 6;
        //    for button 6
        listOfBtn[1][2] = new JButton();
        listOfBtn[1][2].addActionListener( this );
        centerPanel.add( listOfBtn[1][2] );
        listOfBtn[1][2].setIcon( new ImageIcon( getIcon( 0, 2 ) ) );
        listOfBtn[1][2].setVisible( true );
        count[5] = 3;
        //   for button 7
        listOfBtn[2][0] = new JButton();
        listOfBtn[2][0].addActionListener( this );
        centerPanel.add( listOfBtn[2][0] );
        listOfBtn[2][0].setIcon( new ImageIcon( getIcon( 1, 0 ) ) );
        listOfBtn[2][0].setVisible( true );
        count[6] = 4;
        //    for button 8
        listOfBtn[2][1] = new JButton();
        listOfBtn[2][1].addActionListener( this );
        centerPanel.add( listOfBtn[2][1] );
        listOfBtn[2][1].setIcon( new ImageIcon( getIcon( 2, 0 ) ) );
        listOfBtn[2][1].setVisible( true );
        count[7] = 7;
        //   for button 9
        listOfBtn[2][2] = new JButton();
        listOfBtn[2][2].addActionListener( this );
        centerPanel.add( listOfBtn[2][2] );
        listOfBtn[2][2].setIcon( new ImageIcon( getIcon( 2, 1 ) ) );
        listOfBtn[2][2].setVisible( true );
        count[8] = 8;

        validate();
        setSize( width, height );
        setTitle( Title );
        setResizable( false ); // enhances the capability of the puzzle to be
        // resizable but it affects the way in which the image file is
        // presented.
        setLocationRelativeTo( null ); // center the image
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setVisible( true );
    }

    public static void main(String[] args) {
        new JEightPuzzleFrame( "Puzzle", "/Users/aotanob/IdeaProjects/HW-1" +
                "/src/FGCU_logo.png" ); // Make sure the image file FGCU_logo
        // .png is stored in the same directory
        System.out.println();
    }

    //Action performed to be implemented
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        Dimension size = button.getSize();

        int emptyX = listOfBtn[0][0].getX();
        int emptyY = listOfBtn[0][0].getY();

        int buttonX = button.getX();
        int buttonY = button.getY();
        int buttonPosX = buttonX / size.width;
        int buttonPosY = buttonY / size.height;
        int buttonIndex = position[buttonPosY][buttonPosX];

        if (emptyX == buttonX && (emptyY - buttonY) == size.height) {

            int labelIndex = buttonIndex + 3;

            centerPanel.remove( buttonIndex );
            centerPanel.add( listOfBtn[0][0], buttonIndex );
            centerPanel.add( button, labelIndex );
            centerPanel.validate();

            int a = count[buttonIndex];
            count[buttonIndex] = count[labelIndex];
            count[labelIndex] = a;
        }

        if (emptyX == buttonX && (emptyY - buttonY) == -size.height) {

            int labelIndex = buttonIndex - 3;
            centerPanel.remove( labelIndex );
            centerPanel.add( button, labelIndex );
            centerPanel.add( listOfBtn[0][0], buttonIndex );

            centerPanel.validate();
            int a = count[buttonIndex];
            count[buttonIndex] = count[labelIndex];
            count[labelIndex] = a;
        }

        if (emptyY == buttonY && (emptyX - buttonX) == size.width) {

            int labelIndex = buttonIndex + 1;
            centerPanel.remove( buttonIndex );
            centerPanel.add( listOfBtn[0][0], buttonIndex );
            centerPanel.add( button, labelIndex );
            centerPanel.validate();
            int a = count[buttonIndex];
            count[buttonIndex] = count[labelIndex];
            count[labelIndex] = a;
        }

        if (emptyY == buttonY && (emptyX - buttonX) == -size.width) {
            //Center Panel being utilized
            int labelIndex = buttonIndex - 1;
            centerPanel.remove( buttonIndex );
            centerPanel.add( listOfBtn[0][0], labelIndex );
            centerPanel.add( button, labelIndex );
            centerPanel.validate();

            int a = count[buttonIndex];
            count[buttonIndex] = count[labelIndex];
            count[labelIndex] = a;
        }
        if (isPuzzleSolved()) { //refer to the boolean method on line 256.

            JOptionPane.showMessageDialog( centerPanel, "Winner Winner, " +
                    "Chicken Dinner! Click OK to play again" ); // When a game is
            // solved, a pop up window will congratulate the user. Such pop-up
            // window will not go away until the user clicks “ok”.

            //Following segment of code was completed with the assistance and
            // counseling of Dr. Dahai Guo on 10/30/17.
            // The purpose of this segment is to display the puzzle after
            // being solved for the first time, only that this time it will
            // be random instead of a set initial layout.
            // When the pop-up window goes away, the buttons should be randomly
            // shuffled so that the user can begin with another game
            for (JButton[] row : listOfBtn) {
                for (JButton each : row) {
                    centerPanel.remove( each );
                }
            }

            for (int i = 0; i < count.length; i++) {
                int rand = (new Random()).nextInt( 9 );
                int temp = count[i];
                count[i] = count[rand];
                count[rand] = temp;
            }

            for (int each : this.count) {
                centerPanel.add( listOfBtn[(each - 1) / 3][(each - 1) % 3] );

            }
            this.centerPanel.validate();
        }

    }

    //This segment of code helps the source code being more readable. And
    // makes the if-statement in line 221 more organized and easier to follow
    private boolean isPuzzleSolved() {
        return  count[0] == 1 &&
                count[1] == 2 &&
                count[2] == 3 &&
                count[3] == 4 &&
                count[4] == 5 &&
                count[5] == 6 &&
                count[6] == 7 &&
                count[7] == 8 &&
                count[8] == 9;
    }
}