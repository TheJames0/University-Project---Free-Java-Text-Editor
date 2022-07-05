import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import Style.StyleColour;
import Style.StyleFont;
import Style.StyleInterface;
import Style.StyleSize;


import javax.swing.text.StyledEditorKit;
/**
 * 
 * @author 24542768
 *Main GUI class contains all the event listeners to implement other classes.
 */
public class GUIMenu extends JFrame implements EditorFunctionInterface   {
/**
 * Class variables
 */
	private JFrame guiframe;
	private TextFile newfile = new TextFile();
	private JLabel charcounter = new JLabel("Characters: " + newfile.getCharacters());
	private JLabel wordcounter = new JLabel("Words: " + newfile.getWords());
	private JTextPane textPane;
	private DefaultStyledDocument doc;
	private JPanel guipanel;
	private UndoRedo undoredo;
	private StyleInterface styling;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu window = new GUIMenu();
					window.guiframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public GUIMenu() {
		initialize();
	}
/**
 * Main code for GUI sets up event listener code and gui properties.
 */
	private void initialize() {
		
		/**
		 * GUI Constructor --------------------------------------------------------
		 */
		 
		textPane = new JTextPane();
		textPane.setDocument(doc = new DefaultStyledDocument());
		guiframe = new JFrame();
		JScrollPane sp = new JScrollPane( textPane );
		SpringLayout springLayout = new SpringLayout();
		guipanel = new JPanel();
		JButton btnTextTemplate = new JButton("Templates\r\n");
		JButton newBtn = new JButton("New");
		JButton saveBtn = new JButton("Save");
		JButton loadBtn = new JButton("Load");
		JPanel panel_1 = new JPanel();
		JComboBox fontBox = new JComboBox();
		JComboBox sizeBox = new JComboBox();
		JComboBox colourBox = new JComboBox();
		JButton btnUnderline = new JButton("U");
		
		JButton btnBold = new JButton("B");

		JButton btnItalics = new JButton("I");
		JButton btnRedo = new JButton(">");
		JButton btnUndo = new JButton("<");
		undoredo = new UndoRedo();
		
		/**
		 * GUI styling code-----------------------------------------------------------------------
		 */
		setGUIProperties(springLayout, guipanel, newBtn, saveBtn, loadBtn, panel_1,
				fontBox, sizeBox, colourBox,btnUnderline,btnBold,btnItalics,btnUndo,btnRedo, btnTextTemplate);
		

		
		/**
		 * Action Listeners ----------------------------------------------------------------------
		 */
		doc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}
			
		});
		/**
		 * Listener to create dialog upon pressing close.
		 */
		guiframe.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent we) {
		    	if (newfile.getDochaschanged() == true || newfile.isAlreadySaved() == false) {
		        if (JOptionPane.showConfirmDialog(guiframe, 
		            "The document has not been saved or has been modified are you sure you wish to procede", "Unsaved Document", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    	}
		    	else {
		    		System.exit(0);
		    	}
		    }
		});
		
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performUndo(undoredo);
			}
		});
		
		
		btnTextTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openTemplate(doc);
			}
		});
		
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performRedo(undoredo);
			}
		});
		
		doc.addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoredo.addAction(e);
			}
			
		});
		btnItalics.addActionListener(new StyledEditorKit.ItalicAction());
		btnBold.addActionListener(new StyledEditorKit.BoldAction());
		btnUnderline.addActionListener(new StyledEditorKit.UnderlineAction());
		
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					saveFile(newfile, doc);
			}
		});
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile();
				
				
			}
		});
	
		colourBox.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				styling = new StyleColour();
				styling.setStyle(textPane,colourBox.getSelectedItem().toString());
				
			}
		});
		fontBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				styling = new StyleFont();
				styling.setStyle(textPane,fontBox.getSelectedItem().toString());
			}
		});
		
		sizeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				styling = new StyleSize();
				styling.setStyle(textPane,sizeBox.getSelectedItem().toString());
			}
		});
		
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFile(doc);
			}
		});
		
	}
	
	
	@SuppressWarnings("unchecked")
	private void setGUIProperties(SpringLayout springLayout,JPanel panel,JButton newBtn,JButton saveBtn,JButton loadBtn,JPanel panel_1,JComboBox fontBox,JComboBox sizeBox,JComboBox colourBox, JButton btnUnderline, JButton btnBold, JButton btnItalics, JButton btnUndo, JButton btnRedo, JButton btnTextTemplate) {
		guiframe.setTitle("James Edit");
		guiframe.setBounds(100, 100, 1002, 999);
		guiframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		guiframe.getContentPane().setLayout(springLayout);
		panel.setBackground(Color.DARK_GRAY);
		guiframe.getContentPane().add(panel);
		guipanel.setLayout(null);
		
		
		btnTextTemplate.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		btnTextTemplate.setFocusPainted(false);
		btnTextTemplate.setBackground(new Color(102, 255, 0));
		btnTextTemplate.setBounds(0, 32, 149, 26);
		guipanel.add(btnTextTemplate);
		newBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		newBtn.setFocusPainted(false);
		newBtn.setBackground(new Color(102, 255, 0));
		panel.add(newBtn);
		newBtn.setBounds(0, 0, 113, 32);
		saveBtn.setBounds(123, -1, 113, 34);
		loadBtn.setBounds(246, -1, 113, 34);
		fontBox.setBounds(369, 0, 163, 34);
		sizeBox.setBounds(542, 1, 96, 34);
		colourBox.setBounds(648, 0, 96, 34);
		btnRedo.setBounds(913, 0, 44, 32);
		guipanel.add(btnRedo);
		btnUndo.setBounds(868, 0, 44, 32);
		guipanel.add(btnUndo);
		saveBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		saveBtn.setBackground(new Color(102, 255, 0));
		saveBtn.setFocusPainted(false);
		panel.add(saveBtn);
		loadBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		loadBtn.setBackground(new Color(102, 255, 0));
		loadBtn.setFocusPainted(false);
		panel.add(loadBtn);
		panel_1.setBackground(new Color(51, 51, 51));
		fontBox.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 13));
		fontBox.setModel(new DefaultComboBoxModel(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
		fontBox.setToolTipText("Font Selection");
		fontBox.setBackground(new Color(102, 255, 0));
		panel.add(fontBox);
		fontBox.setFocusable(false);
		FontBoxDisplay renderfontbox = new FontBoxDisplay(fontBox);
		guiframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 919, 863);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(textPane);
		wordcounter.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		wordcounter.setForeground(Color.GREEN);
		wordcounter.setBackground(Color.DARK_GRAY);
		wordcounter.setBounds(429, 871, 131, 25);
		panel_1.add(wordcounter);
		charcounter.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		charcounter.setForeground(Color.GREEN);
		charcounter.setBounds(618, 871, 187, 25);
		panel_1.add(charcounter);
		sizeBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38",
				"39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", 
				"54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", 
				"69", "70", "71", "72"}));
		sizeBox.setToolTipText("Font Selection");
		sizeBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		sizeBox.setFocusable(false);
		sizeBox.setBackground(new Color(102, 255, 0));
		panel.add(sizeBox);
		panel.add(colourBox);
		colourBox.setModel(new DefaultComboBoxModel(new String[] {"black","red","green","yellow","blue","pink"}));
		colourBox.setToolTipText("Font Selection");
		colourBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		colourBox.setFocusable(false);
		colourBox.setBackground(new Color(102, 255, 0));
		btnItalics.setBounds(754, 0, 37, 32);
		guipanel.add(btnItalics);
		btnBold.setBounds(788, 0, 44, 32);
		guipanel.add(btnBold);
		btnUnderline.setBounds(830, 0, 39, 32);
		guipanel.add(btnUnderline);
		btnUnderline.setBackground(new Color(102, 255, 0));
		btnBold.setBackground(new Color(102, 255, 0));
		btnItalics.setBackground(new Color(102, 255, 0));
		btnRedo.setBackground(new Color(102, 255, 0));
		btnUndo.setBackground(new Color(102, 255, 0));
		springLayout.putConstraint(SpringLayout.NORTH, guipanel, 0, SpringLayout.NORTH, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, guipanel, 0, SpringLayout.WEST, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, guipanel, 58, SpringLayout.NORTH, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, guipanel, 986, SpringLayout.WEST, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 58, SpringLayout.NORTH, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -24, SpringLayout.SOUTH, guiframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, guiframe.getContentPane());

	}
	/**
	 * On document update this sets the text counters,
	 *  identifies that there is a change in the document and saves the new text.
	 */
	@Override
	public void documentChangeUpdate() {
		newfile.setDochaschanged(true);
		newfile.setText(textPane.getText());
		charcounter.setText("Characters: " + newfile.getCharacters());
		wordcounter.setText("Words: " + newfile.getWords());
	}
/**
 * Called on hitting the New button, this erases the document by instantiating new objects of TextFile and Default styled document.
 * It erases the undo redo stack and recreates the undo listener as the document it was previously attatched to does not exist.
 */
	@Override
	public void newFile() {
		newfile = new TextFile( );
		textPane.setDocument(doc = new DefaultStyledDocument());
		undoredo = new UndoRedo();
		doc.addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoredo.addAction(e);
			}
			
		});
	}
/**
 * Check for if file is already saved if not
 * Creates a new save file dialog class and passes required parameters to save.
 * If it saved already and name is recognised then the overwrite dialog is called which asks user if they wish to overwrite file
 * and if so writes file automatically to saved file path and name.
 */
	@Override
	public void saveFile(TextFile text, Document doc) {
		if (newfile.isAlreadySaved() == false) {
			
			
			SaveFileDialog dialog = new SaveFileDialog(text, doc);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			}
			else {
				OverwriteDialog dialog = new OverwriteDialog(text,doc);
			}
				
	}
/**
 * Creates a new load dialog window that allows a file to be chosen and the current document will be set to this
 * additionally requires reattatchment of document change listeners due to a new document being set.
 */
	@Override
	public void loadFile(Document doc) {
		LoadFileDialog loadwindow = new LoadFileDialog();
		newfile = new TextFile();
		newfile.setFilename(loadwindow.getFilename());
		doc = loadwindow.getDoc();
		textPane.setDocument(doc);
		doc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				documentChangeUpdate();
			}
			
			
		});
	}
/**
 * Calls the perform undo method which reverts an action from a stack
 */
	@Override
	public void performUndo(UndoRedo undoredo) {
		undoredo.performUndo();
	}
/**
 * Calls the perform undo method which reverts an undo action from a stack
 */
	@Override
	public void performRedo(UndoRedo undoredo) {
		// TODO Auto-generated method stub
		undoredo.performRedo();
	}
	/**
	 * Opens dialog for text template chooser.
	 */
	@Override
	public void openTemplate(DefaultStyledDocument doc) {
		TextTemplateChooser dialog = new TextTemplateChooser(doc,textPane);
		dialog.setVisible(true);
	}
}



 
