import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveFileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private TextFile textfile;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	
	}

	/**
	 * Create the dialog.
	 */
	public SaveFileDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GREEN);
			panel.setBounds(125, 11, 185, 45);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Enter file name");
				lblNewLabel.setBounds(0, 0, 185, 28);
				panel.add(lblNewLabel);
				lblNewLabel.setForeground(Color.BLACK);
				lblNewLabel.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
				lblNewLabel.setBackground(Color.GREEN);
			}
		}
		
		textField = new JTextField();
		textField.setBounds(125, 85, 185, 45);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textfile.saveTextFile(textField.getText());
						  
					}
				});
				okButton.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
				okButton.setBackground(Color.GREEN);
				okButton.setForeground(Color.BLACK);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Year supply of fairy cakes", Font.PLAIN, 16));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.GREEN);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public void SetFile(TextFile file) {
		this.textfile = file;
	}
}
