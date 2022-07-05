
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
/**
 * 
 * @author James
 * Class opens up a file chooser window to pick a file from file explorer.
 * loadfile modified from original guide 
 * BillStackHouse, U. -., 2010. CodeRanch Writing RTF files from Java Swing DefaultStyledDocuments. [Online] 
Available at: https://coderanch.com/t/493469/java/Writing-RTF-files-Java-Swing
[Accessed 12 11 2021].
 */
public class LoadFileDialog extends JDialog {
	private JFrame frame = new JFrame();
	private JTextPane text;
	private File file = null;
	private String filepath = null;
	private String filename = null;
	private DefaultStyledDocument document;
	/**
	 * Constructor method creates file chooser and checks for the file chosen.
	 */
	public LoadFileDialog() {
				JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showOpenDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION){
	            	file = fileChooser.getSelectedFile();
	            	filepath = file.getAbsolutePath();
	            	filename = file.getName();
	            	loadFile();
	            	
	            }
	}
	               
	            
	   
	   /**
	    * file path is used to by a file reader and buffered reader to read the raw data and
	    * uses rtf editor kit to parse this data into a readable doc.
	    */
	private  void loadFile() 
    {
		document = new DefaultStyledDocument();
		try {
		RTFEditorKit Editorkit = new RTFEditorKit();
		FileReader reader = new FileReader(filepath);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = "";
		String lines = "";
		while((line = bufferedReader.readLine()) != null)
		{
		    lines = lines + line;
		}
		reader.close();
		ByteArrayInputStream ins = new ByteArrayInputStream(lines.getBytes());
		BufferedInputStream bins = new BufferedInputStream(ins);
		Editorkit.read(bins,document , 0);
		bins.close();
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public String getFilename() {
		return this.filename;
	}
	public DefaultStyledDocument getDoc() {
		return document;
	}
}
	


