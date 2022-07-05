package Util;

import javax.swing.undo.UndoableEdit;
/**
 * Utillity class to add and remove items from an array stack
 * @author James
 *
 */
public class ArrayManage {
	/**
	 * adds Undoable edit to new max array position
	 * @param array
	 * @param item
	 * @return
	 */
	public static UndoableEdit[] addToArrayUndoableEdit(UndoableEdit[] array, UndoableEdit item) {
		UndoableEdit[] temparray = new UndoableEdit[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			temparray[i] = array[i];
		}
		temparray[array.length] = item;
		return temparray;
	}
	/**
	 * remove last item from an array
	 * @param array
	 * @return
	 */
	public static UndoableEdit[] removefromArrayUndoableEdit(UndoableEdit[] array) {
		UndoableEdit[] temparray = new UndoableEdit[array.length - 1];
		for (int i = 0; i < temparray.length; i++) {
			temparray[i] = array[i];
		}
		return temparray;
	}
	}
