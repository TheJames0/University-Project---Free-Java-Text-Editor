import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoableEdit;

import Util.ArrayManage;
/**
 * Manages undo and redo functions by managing two stacks that hold action data.
 * @author James
 *
 */
public class UndoRedo  {
	private UndoableEdit[] undostack;
	private UndoableEdit[] redostack;
	/**
	 * On document action performed add undoableedit object to undostack
	 * @param e
	 */
	public void addAction(UndoableEditEvent e) {
	undostack = ArrayManage.addToArrayUndoableEdit(undostack, e.getEdit());
	}
	/**
	 * Remove undoable item from undostack add it to redostack and perform undo  to document.
	 */
	public void performUndo() {
		if (undostack.length != 0) {
		 UndoableEdit item = undostack[undostack.length - 1];
		 undostack = ArrayManage.removefromArrayUndoableEdit(undostack);
		 redostack = ArrayManage.addToArrayUndoableEdit(redostack, item);
		 item.undo();
		}
	}
	/**
	 * Remove undoable object from redostack add to undostack and perform redo to document.
	 */
	public void performRedo(){
		if (redostack.length != 0) {
		UndoableEdit item = redostack[redostack.length - 1];
		 redostack = ArrayManage.removefromArrayUndoableEdit(redostack);
		 undostack = ArrayManage.addToArrayUndoableEdit(undostack, item);
		 item.redo();
		}
	}
	/**
	 * Constructor instantiates both arrays.
	 */
	public UndoRedo() {
	undostack = new UndoableEdit[0];
	redostack = new UndoableEdit[0];
	}

}
