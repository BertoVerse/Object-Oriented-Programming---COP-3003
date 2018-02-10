// Test application to display a DrawFrame
import javax.swing.JFrame;
import java.awt.*;

public class Painter
{
   public static void main(String[] args)
   {
      DrawFrame application = new DrawFrame();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.setSize(500, 500);
      application.setVisible(true);
      application.setLocationRelativeTo(null);


   } // end main
} // end class Painter