
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class LoadFileDialog {
	JFrame frame = new JFrame();
	
	File file = null;
	String filepath = null;
	String Worddata = null;
	String filename = null;
	public static void main(String[] args) {
		
	}
	
	public LoadFileDialog() {
				JFileChooser fileChooser = new JFileChooser();
		 		
	            int option = fileChooser.showOpenDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION){
	            	file = fileChooser.getSelectedFile();
	            	filepath = file.getAbsolutePath();
	            	Worddata = Fileinput(filepath);
	            	filename = file.getName();
	            }
	}
	               
	            
	   
	   
	private String Fileinput(String filePath) 
    {
        StringBuilder inputString = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> inputString.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return inputString.toString();
    }
	public String getFilename() {
		return this.filename;
	}
	public String getWorddata() {
		return this.Worddata;
	}
}
	


