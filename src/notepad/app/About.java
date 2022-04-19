
package notepad.app;
import java.awt.Font;
import javax.swing.*;

public class About extends JFrame{
    About(){
        setBounds(100,100,500,400); //left top width heigth
        setTitle("About Notepad Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.jpg"));
        setIconImage(icon.getImage()); //set image in notepad app
        
        JLabel iconlabel = new JLabel(new ImageIcon(getClass().getResource("notepad1.jpg")));
        iconlabel.setBounds(100,50,80,80);
        add(iconlabel);
        //to add text underimage label
        JLabel textlabel = new JLabel("<html>Welcome to Notepad <br> Notepad is a simple text editor for microsoft windows and a basic texting program which enables computer users to create documents<br> @kalash tyagi</html>");
        //can use html tags to align text.
        textlabel.setBounds(100,50,350,300);
        textlabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16)); //3 parameters of font - font-family,text,size.
        add(textlabel);
    }
    public static void main(String[] args){
        //initialize object of About class
        new About().setVisible(true);
    }
    
}
