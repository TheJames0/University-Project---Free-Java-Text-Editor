import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.JLabel;
/**
 * Creates a dialog with buttons for each text template, allows user to press a button and 
 * the respective text template is inserted into the document.
 * @author James
 *
 */
public class TextTemplateChooser extends JFrame {

	private JPanel contentPane;
	private TextTemplate[] Texttemplates;
	private JTextPane textPane;
	/**
	 * sets an array of text templates with data
	 */
	public void setTexttemplates() {
		Texttemplates = new TextTemplate[5];
		Texttemplates[0] = new TextTemplate("Formal template 1", "Dear [RECIPIENT], I am writing to you ", ", yours sincerely [YOURNAME]");
		Texttemplates[1] = new TextTemplate("Formal template 2", "To whom it may concern, ", ", yours sincerely [YOURNAME]");
		Texttemplates[2] = new TextTemplate("Formal template 3", "Hello [RECIPIENT] ,", ", yours sincerely [YOURNAME]");
		Texttemplates[3] = new TextTemplate("Informal template 1", "Hey [RECIPIENT], How are you doing? Im writing to you because ", " , yours truly [YOURNAME]");
		Texttemplates[4] = new TextTemplate("Informal template 2", "Hi [RECIPIENT], can you help me with ", " Thanks again, [YOURNAME]");
	}
	/**
	 * inserts text into the template using .insertString with respective positions. ie first
	 * string at the beginning of the document and second string at the end.
	 * @param firststring
	 * @param secondstring
	 * @param doc
	 */
	public void insertText(String firststring, String secondstring,DefaultStyledDocument doc) {
		try {
			doc.insertString(0, firststring, null);
			doc.insertString(doc.getLength(), secondstring, null);
		 } catch (Exception ex) {
			  throw new RuntimeException(ex);
			 }
		textPane.setEditable(true);
		textPane.revalidate();
		textPane.repaint();
		textPane.requestFocusInWindow();
	}
	/**
	 * searches for the text template matching the button name.
	 * @param name
	 * @return
	 */
	public TextTemplate findTemplate(String name) {
		int match = 0;
		for (int i = 0; i < Texttemplates.length;i++) {
			if (name == Texttemplates[i].texttemplatename) {
				return Texttemplates[i];
			}
		}
		return null;
		
		
	}
	/**
	 * Constructor method adds i amount of buttons for each text template and adds listeners
	 * that find the text template and insert the template into the document
	 * @param doc
	 * @param textPane
	 */
	public TextTemplateChooser(DefaultStyledDocument doc, JTextPane textPane) {
		this.textPane = textPane;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3,3));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose a template\r\n");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		setTexttemplates();
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for(int i = 0; i < Texttemplates.length; i++) {
			buttons.add(new JButton(Texttemplates[i].getName()));
			buttons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton) e.getSource();
					TextTemplate template = findTemplate(button.getText());
					insertText(template.firsttext,template.secondtext,doc);
				}
				
			});
		    contentPane.add(buttons.get(i));
		    
		}
	}
}
