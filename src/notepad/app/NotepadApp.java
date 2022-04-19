
package notepad.app;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;


public class NotepadApp extends JFrame implements ActionListener{
    
    JMenuBar menubar = new JMenuBar(); //initialize obj menu of JMenuBar class
    //create menu in menuBar
    JMenu file =  new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    //create menuitem for file
    JMenuItem newfile = new JMenuItem("New");
    JMenuItem openfile = new JMenuItem("Open");
    JMenuItem savefile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");
    
    //create menuitem for edit
    
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    
    //create menuitem for help
    JMenuItem about = new JMenuItem("About");
    //create textarea object to write on your notepad application.
    JTextArea textarea = new JTextArea();
    
    
    
    //initialize constructor
    NotepadApp(){
        setTitle("My Notepad"); //title of our application
        setBounds(100,100,800,600); //bound from left top width heigth
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close tool
        //initialize object icon of ImageIcon class 
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.jpg"));
        setIconImage(icon.getImage()); //set image in notepad app
        //add menu in menuBar using object
        
         menubar.add(file);
         menubar.add(edit);
         menubar.add(help);
         setJMenuBar(menubar); //to add icon on top
         
         //add file item on file menu
         file.add(newfile);
         file.add(openfile);
         file.add(savefile);
         file.add(print);
         file.add(exit);
         
         //add edit item on edit menu
         edit.add(cut);
         edit.add(copy);
         edit.add(paste);
         edit.add(selectall);
         
         //add help item on help menu
        help.add(about);
        
        //add textarea inside your frame with the help of JScroll pane
        JScrollPane scrollpane = new JScrollPane(textarea);
        add(scrollpane);
        //remove scroller from bottom
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //add vertical scroll bar instead of horizontal bar
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //remove border between menubar and textarea
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        //set font of our text in textarea
        textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        //text doesn't across border i.e start from next line
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        //add actionlistener with all 10 menu
        newfile.addActionListener(this); //this keyword is bcoz actionlistener is implement in same class
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
        //method to create shortcut of all menu items
        newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK)); //use ctrl N shorcut for new file
        openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
   
        
        
    
    }

    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        //actionperformed method responsible for all eventhandling actions
        if(e.getActionCommand().equalsIgnoreCase("New")){
            textarea.setText(null); //set text null when we click on new  file
            
        }else if(e.getActionCommand().equalsIgnoreCase("Open")){
            
            
            JFileChooser filechooser = new JFileChooser(); //create object to choose a location where we have to save
            FileNameExtensionFilter textfilter = new FileNameExtensionFilter("Only text file(.txt)","txt");
            //choose only txt file
            filechooser.setAcceptAllFileFilterUsed(false); //doesn't accept any file
            filechooser.addChoosableFileFilter(textfilter); //choose only text type of file
            
            int action = filechooser.showOpenDialog(null); //show open dialog to user
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }else{
                try{
                    //use buffer reader to open our file to read
                BufferedReader reader = new BufferedReader(new FileReader(filechooser.getSelectedFile()));
                textarea.read(reader,null); //write textarea object inside writer object
           }catch(IOException ex){
               ex.printStackTrace();
           }
                
            }
        
            
            
            
        
        
        
        
        }else if(e.getActionCommand().equalsIgnoreCase("Save")){
            JFileChooser filechooser = new JFileChooser(); //create object to choose a location where we have to save
            FileNameExtensionFilter textfilter = new FileNameExtensionFilter("Only text file(.txt)","txt");
            //choose only txt file
            filechooser.setAcceptAllFileFilterUsed(false); //doen't accept any file
            filechooser.addChoosableFileFilter(textfilter); //choose only text type of file
           int action = filechooser.showSaveDialog(null); //action performed when we want to save any file or cancel
           if(action!=JFileChooser.APPROVE_OPTION){ //IF CLICK TO CANCEL NOT ON SAVE
               return;
               
           }else{
               String fileName = filechooser.getSelectedFile().getAbsolutePath().toString();//which filename user has chosen
               if(fileName.contains(".txt"))
                   fileName = fileName + ".txt"; //add .txt if user forget to add 
               //to save textarea content inside our filename
               try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                textarea.write(writer); //write textarea object inside writer object
           }catch(IOException ex){
               ex.printStackTrace();
           }
               
           }
           
            
        }else if(e.getActionCommand().equalsIgnoreCase("Print")){
            
            
            try {
                textarea.print();   //give exception if printer is not attached thats why we used exception handling
            } catch (PrinterException ex) {
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getActionCommand().equalsIgnoreCase("Exit")){
            
            System.exit(0); //method to exit from window
            
        }else if(e.getActionCommand().equalsIgnoreCase("Cut")){ //function of edit menu
            textarea.cut();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textarea.copy();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textarea.paste();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Select All")){
            textarea.selectAll();
            
        }else if(e.getActionCommand().equalsIgnoreCase("About")){
            new About().setVisible(true);  //created obj of about and set it visible
            
        }
    }
        
        
      public static void main(String[] args) throws Exception {
          //change look and feel of our notepad
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApp().setVisible(true); //coz it's hidden by default 
        
    }

}
