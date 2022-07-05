import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public interface EditorFunctionInterface {
	/**
	 * This interface describes methods to be implemented within GUIMenu and these methods
	 * are not intended to be implemented within another class.
	 */
public void newFile();
public void saveFile(TextFile text, Document doc);
public void loadFile(Document doc);
public void performUndo(UndoRedo undoredo);
public void performRedo(UndoRedo undoredo);
public void openTemplate(DefaultStyledDocument doc);
public void documentChangeUpdate();

}
