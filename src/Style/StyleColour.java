package Style;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
/**
 * Styles font to colour.
 * @author James
 *
 */
public class StyleColour implements StyleInterface {
	@Override
	public void setStyle(JTextPane textPane,String colourstring) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		switch (colourstring) {
		case "red":
			StyleConstants.setForeground(attr, Color.red);
			break;
		case "black":
			StyleConstants.setForeground(attr, Color.black);
			break;
		case "grey":
			StyleConstants.setForeground(attr, Color.gray);
			break;
		case "yellow":
			StyleConstants.setForeground(attr , Color.yellow);
			break;
		case "pink":
			StyleConstants.setForeground(attr, Color.pink);
			break;
		case "green":
			StyleConstants.setForeground(attr, Color.green);
			break;
		case "blue":
			StyleConstants.setForeground(attr, Color.blue);
			break;
		}
		textPane.setCharacterAttributes(attr, false);
	}

}
