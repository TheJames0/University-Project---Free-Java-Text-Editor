import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.DefaultEditorKit.*;
import javax.swing.text.StyledEditorKit.*;

public class GUIMenu extends JFrame {
/**
 * Initial Constructors
 */
	private JFrame frmJamesEdit;
	TextFile NewFile = new TextFile();
	JLabel charcounter = new JLabel("Characters: " + NewFile.getCharacters());
	JLabel wordcounter = new JLabel("Words: " + NewFile.getWords());
	JTextPane textPane;
	DefaultStyledDocument doc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu window = new GUIMenu();
					window.frmJamesEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public GUIMenu() {
		initialize();
	}

	private void initialize() {
		
		/**
		 * GUI Constructor --------------------------------------------------------
		 */
		
		
		textPane = new JTextPane();
		textPane.setDocument(new DefaultStyledDocument());
		frmJamesEdit = new JFrame();
		JScrollPane sp = new JScrollPane( textPane );
		SpringLayout springLayout = new SpringLayout();
		JPanel panel = new JPanel();
		JButton newBtn = new JButton("New");
		JButton saveBtn = new JButton("Save");
		JButton loadBtn = new JButton("Load");
		JPanel panel_1 = new JPanel();
		JComboBox fontBox = new JComboBox();
		JComboBox sizeBox = new JComboBox();
		JComboBox colourBox = new JComboBox();
		/**
		 * GUI styling code
		 */
		setGUIProperties(springLayout, panel, newBtn, saveBtn, loadBtn, panel_1, fontBox, sizeBox, colourBox);
		/**
		 * Action Listeners -----------------------------------------------------------------------------------------------------
		 */
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (NewFile.checkSave() == false) {
						
					
					SaveFileDialog dialog = new SaveFileDialog();
					dialog.SetFile(NewFile);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					}
					else {
						NewFile.saveTextFile(NewFile.getFileName());
					}
				
			}
		});
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		colourBox.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet attr = new SimpleAttributeSet();
				if (colourBox.getSelectedItem().toString() == "red")
				StyleConstants.setForeground(attr, Color.red);
				if (colourBox.getSelectedItem().toString() == "blue")
					StyleConstants.setForeground(attr, Color.blue);
				textPane.setCharacterAttributes(attr, false);
				
				
			}
		});
		fontBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		sizeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadFileDialog loadwindow = new LoadFileDialog();
				NewFile = new TextFile();
				NewFile.setFileName(loadwindow.getFilename());
				textPane.setText(loadwindow.getWorddata());
			}
		});
		textPane.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e) {
                   
            	
               }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
			}

			

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				NewFile.setText(textPane.getText());
				NewFile.countCharacters();
				charcounter.setText("Characters: " + NewFile.getCharacters());
				
				NewFile.countWords();
				wordcounter.setText("Words: " + NewFile.getWords());
				
				
				//
			}
		});
	}

	
	@SuppressWarnings("unchecked")
	public void setGUIProperties(SpringLayout springLayout,JPanel panel,JButton newBtn,JButton saveBtn,JButton loadBtn,JPanel panel_1,JComboBox fontBox,JComboBox sizeBox,JComboBox colourBox) {
		frmJamesEdit.setTitle("James Edit");
		frmJamesEdit.setBounds(100, 100, 1002, 999);
		frmJamesEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJamesEdit.getContentPane().setLayout(springLayout);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 34, SpringLayout.NORTH, frmJamesEdit.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmJamesEdit.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmJamesEdit.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 986, SpringLayout.WEST, frmJamesEdit.getContentPane());
		panel.setBackground(Color.DARK_GRAY);
		frmJamesEdit.getContentPane().add(panel);
		panel.setLayout(null);
		newBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		newBtn.setFocusPainted(false);
		newBtn.setBackground(new Color(102, 255, 0));
		newBtn.setBounds(0, 0, 113, 32);
		panel.add(newBtn);
		saveBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		saveBtn.setBackground(new Color(102, 255, 0));
		saveBtn.setFocusPainted(false);
		saveBtn.setBounds(123, -1, 113, 34);
		panel.add(saveBtn);
		loadBtn.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
		loadBtn.setBackground(new Color(102, 255, 0));
		loadBtn.setFocusPainted(false);
		loadBtn.setBounds(246, -1, 113, 34);
		panel.add(loadBtn);
		panel_1.setBackground(new Color(51, 51, 51));
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frmJamesEdit.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -24, SpringLayout.SOUTH, frmJamesEdit.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		fontBox.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 13));
		fontBox.setModel(new DefaultComboBoxModel(new String[] {"Font Selection", "Arial", "Bookman Old Style", "Copperplate Gothic", "Impact", "Helvetica", "MS LineDraw", "Times New Roman", ""}));
		fontBox.setToolTipText("Font Selection");
		fontBox.setBackground(new Color(102, 255, 0));
		fontBox.setBounds(369, 0, 163, 34);
		panel.add(fontBox);
		fontBox.setFocusable(false);
		frmJamesEdit.getContentPane().add(panel_1);
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
		sizeBox.setBounds(542, 1, 96, 34);
		panel.add(sizeBox);
		panel.add(colourBox);
		colourBox.setModel(new DefaultComboBoxModel(new String[] {"black","red","green","yellow","blue","pink"}));
		colourBox.setToolTipText("Font Selection");
		colourBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		colourBox.setFocusable(false);
		colourBox.setBackground(new Color(102, 255, 0));
		colourBox.setBounds(648, 0, 96, 34);
	}
	public void colourStyling(JComboBox colourBox) {
		
	}
	
	public TextFile getTextFile() {
		return this.NewFile;
	}
}


 
