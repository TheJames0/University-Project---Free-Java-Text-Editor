import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author 24542768
 *This class allows fonts to be displayed within the combination box which relies on an implementation of
 *ListCellRenderer interface and JLabel class to override.
 * 
 *Some source code has been provided from java2s however this has been heavily 
 *modified for different purposes.
 *Java2S, n.d. Java 2s ComboBoxRenderer. [Online] 
Available at: http://www.java2s.com/Tutorial/Java/0240__Swing/Comboboxcellrenderer.htm
[Accessed 22 11 2021].

 */
public class FontBoxDisplay extends JFrame {
   private String fontName[];
   /**
    * 
    * @param fontBox
    * Constructor method
    * Pulls all fonts from available graphics environment into an array
    * calls the implementation of getListCellRendererComponent
    */
   public FontBoxDisplay(JComboBox fontBox) {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      fontName = ge.getAvailableFontFamilyNames();
      FontBoxRenderer fontrenderer = new FontBoxRenderer();
      fontBox.setRenderer(fontrenderer);
      
   }
   /**
    * 
    * @author 24542768
    *Only purpose of class is extend JLabel to act as a platform to render components within a combination box
    *overriding the default combo box renderer.
    */
   private class FontBoxRenderer extends JLabel implements ListCellRenderer {
	   /**
	    * This method overrides the default combobox renderer and sets font to its respective font using a string array.
	    */
	   @Override
      public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    	 try {
    		 String name = fontName[index];
             setText(name);
             setFont(new Font(name,Font.PLAIN,20));
    	 }
    	 catch( Exception e){
    		 
    	 }
         
         return this;
      }
   }
}