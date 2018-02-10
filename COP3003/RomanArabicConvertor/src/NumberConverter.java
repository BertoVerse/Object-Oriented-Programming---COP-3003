import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NumberConverter extends JFrame {

    private JLabel arabicLabel = new JLabel( "    Arabic Numeral" );
    private JLabel romanLabel = new JLabel( "    Roman Numeral" );
    private JTextField arabicValue = new JTextField();
    private JTextField romanValue = new JTextField();
    private String validityCheck = "[0-9]+";
    private String validityCheck2 = "(?i)(^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X" +
            "{0,3})(IX|IV|V?I{0,3})$)";
    private String newInfo;
    private int valueConverter;

    public static void main(String[] args) {
        new NumberConverter().setVisible( true );
    }

    // Constructor

    private NumberConverter() {
        super( "Roman<-->Arabic" );
        setLocationRelativeTo( null );
        setSize( 350, 100 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout( new FlowLayout() );
        arabicValue.addKeyListener( inputListener );
        romanValue.addKeyListener( inputHandler );
        add( arabicLabel );
        add( arabicValue );
        add( romanLabel );
        add( romanValue );
        setVisible( true );
        setLayout( new GridLayout( 2, 2, 0, 0 ) );


    }


    KeyListener inputListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            newInfo = arabicValue.getText();

            if (newInfo.matches( "" )) {
                romanValue.setText( "" );
            }
            if (newInfo.matches( validityCheck ) && Integer.parseInt( newInfo )
                    < 4000 && Integer.parseInt( newInfo ) > 0) {
                valueConverter = Integer.parseInt( newInfo );
                romanValue.setText( ArabicToRomanNumeral( Integer.parseInt
                        ( String.valueOf( valueConverter ) ) ) );
            } else {
                romanValue.setText( "" );
                arabicValue.setText( "" );
            }


        }
    };

    KeyListener inputHandler = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {

            romanValue.setText( romanValue.getText().toUpperCase() );
            newInfo = romanValue.getText();

            if (newInfo.matches( "" )) {
                arabicValue.setText( "" );
            }
            if (newInfo.matches( validityCheck2 ) && Integer.parseInt( newInfo )
                    < 4000 && Integer.parseInt( newInfo ) > 0) {
                valueConverter = Integer.parseInt( newInfo );
                romanValue.setText( ArabicToRomanNumeral( Integer.parseInt
                        ( String.valueOf( valueConverter ) ) ) );

            } else {
                arabicValue.setText( "" );
                romanValue.setText( "" );
            }


        }


    };


    public static String ArabicToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }


    private static int[] x = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
            4, 1};
    private static String[] l = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"};

    private int getValue(String c, boolean th) {
        for (int i = 0; i < l.length; i++)
            if (l[i].equals( c ))
                return x[i];
        if (th)
            throw new IllegalArgumentException( "Invalid Roman numeral" );
        else
            return 0;
    }

    private int getValue(Character c) {
        return getValue( c.toString(), false );
    }

    public int RomanToArabicNumeral(String n) {
        int r = 0;
        int i = 0;
        int nEquals = 0;
        while (i < n.length()) {
            if (i > 0 && n.charAt( i ) == n.charAt( i - 1 )) {
                nEquals++;
                if (nEquals == 3)
                    throw new IllegalArgumentException("Invalid Roman numeral");
            } else
                nEquals = 0;
            if (i + 1 < n.length() && getValue( n.charAt( i ) ) <
                    getValue( n.charAt( i + 1 ) )) {
                r += getValue( n.substring( i, i + 2 ), true );
                i += 2;
            } else {
                r += getValue( n.charAt( i ) );
                i++;
            }
        }
        return r;
    }
}

