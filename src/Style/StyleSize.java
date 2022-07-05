package Style;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
/**
 * Applies size styling to selected font.
 * @author James
 *
 */
public class StyleSize implements StyleInterface{
@Override
public void setStyle(JTextPane textPane, String size) {
	SimpleAttributeSet attr = new SimpleAttributeSet();
	StyleConstants.setFontSize(attr, Integer.valueOf(size));
	textPane.setCharacterAttributes(attr, false);
}
}
