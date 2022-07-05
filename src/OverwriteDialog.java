import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
/**
 * 
 * @author James
 *Dialog called in the event that the file has been changed since previous save
 */
public class OverwriteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Creates the overwrite dialog.
	 * @param newfile 
	 */
	public OverwriteDialog(TextFile newfile, Document doc) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("Do you wish to overwrite \r\ncurrent file");
			lblNewLabel.setBounds(48, -77, 376, 243);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setForeground(Color.GREEN);
			contentPanel.add(lblNewLabel);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setForeground(UIManager.getColor("Button.darkShadow"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("ok click");
						try {
							System.out.println(newfile.getFilePath());
							File previoussave = new File(newfile.getFilePath() + ".rtf");
							if(previoussave.exists())
								previoussave.delete();
							SaveFileDialog.saveTextFile( newfile.getFilePath(), doc);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						newfile.setDochaschanged(false);
						dispose();
					}
				});
				okButton.setBackground(new Color(102, 255, 0));
				okButton.setForeground(new Color(0, 0, 0));
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
				cancelButton.setBackground(new Color(102, 255, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		}
	}

}
