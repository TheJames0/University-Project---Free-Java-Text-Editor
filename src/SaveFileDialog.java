import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 
 * @author James
 *Dialog that is opened on save button click where the file has not
 *been previously saved
 *
 *saveTextFile method modified from original guide -
 *BillStackHouse, U. -., 2010. CodeRanch Writing RTF files from Java Swing DefaultStyledDocuments. [Online] 
Available at: https://coderanch.com/t/493469/java/Writing-RTF-files-Java-Swing
[Accessed 12 11 2021].
 */
public class SaveFileDialog extends JDialog  {
	JFrame frame = new JFrame();
	Document doc;

	/**
	 * Constructor method creates a filechooser window which reads file name inputed 
	 * and retrieves viewed folder path.
	 */
	public SaveFileDialog(TextFile textfile,Document doc) {
		this.doc = doc;
	JFileChooser fileChooser = new JFileChooser();
	int option = fileChooser.showSaveDialog(frame);
	File saveFile = fileChooser.getSelectedFile();
	
    if(option == JFileChooser.APPROVE_OPTION){
    	try {
			saveTextFile(saveFile.getAbsolutePath(),doc);
			textfile.setFilename(saveFile.getName());
			textfile.setFilePath(saveFile.getAbsolutePath());
			textfile.setDochaschanged(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
						  
				
	}
	/**
	 * 
	 * @param filepath
	 * @param doc
	 * @throws IOException
	 * @throws BadLocationException
	 * Saves textfile using filepath and document parameters to save the document to 
	 * the location
	 */
	public static void saveTextFile(String filepath, Document doc) throws IOException, BadLocationException{
		RTFEditorKit Editorkit = new RTFEditorKit();
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		Editorkit.write(output,doc,doc.getStartPosition().getOffset(),doc.getLength());
		output.close();
		File file = new File(filepath  + ".rtf");
		FileOutputStream fileoutput = new FileOutputStream(file);
		fileoutput.write(output.toString().getBytes());
		fileoutput.close();
		
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
}
