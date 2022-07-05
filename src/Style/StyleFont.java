package Style;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
/**
 * Sets style of text to font.
 * @author James
 *
 */
public class StyleFont implements StyleInterface {
	@Override
	public void setStyle(JTextPane textPane,String fontname) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, fontname);
		textPane.setCharacterAttributes(attr, false);
		
	}

}
