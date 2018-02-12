package ashley.main.counter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.Font;

public class Counter {

	private JFrame frame;
	private JTextField textField;
	private int vowelCount;
	private int constCount;
	private JTextField textFieldVowel;
	private JTextField textFieldConst;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter window = new Counter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Counter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//Creates frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 779, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates text fields
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(151, 86, 457, 74);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
			//Listener for when anything is typed/removed from the text box
			@Override
			public void insertUpdate(DocumentEvent e) {
				Typed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Typed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Typed();
			}
		});
		
		//Creates vowel counter text field
		textFieldVowel = new JTextField();
		textFieldVowel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldVowel.setText("Vowels: 0");
		textFieldVowel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVowel.setEditable(false);
		textFieldVowel.setBounds(151, 255, 220, 24);
		frame.getContentPane().add(textFieldVowel);
		textFieldVowel.setColumns(10);
		
		//Creates consonant counter text field
		textFieldConst = new JTextField();
		textFieldConst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldConst.setText("Consonant: 0");
		textFieldConst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldConst.setEditable(false);
		textFieldConst.setColumns(10);
		textFieldConst.setBounds(388, 255, 220, 24);
		frame.getContentPane().add(textFieldConst);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(621, 119, 86, 41);
		frame.getContentPane().add(btnClear);
	}
	
	//When key is pressed this is called
	public void Typed()
	{
		//Gets the types string and removes all non letters
		String text = textField.getText();
		text = text.toLowerCase();
		text = text.replaceAll("\\p{P}", "").replaceAll(" ", "").replaceAll("[0-9]", "");
		
		vowelCount = 0;
		constCount = 0;
		
		//Checks each letter if it is a vowel
		if(text.length() > 0)
		{
			for(int i = 0; i < text.length(); i++)
			{
				if(CheckVowel(text.charAt(i)))
				{
					vowelCount ++;
				}
				else
				{
					constCount ++;
				}
			}
		}
			
		//Sets labels
		textFieldVowel.setText("Vowels: " + String.valueOf(vowelCount));
		textFieldConst.setText("Consonant: " + String.valueOf(constCount));
	}
	
	//Clears text box
	public void Clear()
	{
		textField.setText("");
	}
	
	//Checks letter passed in if it is a vowel
	public boolean CheckVowel(char character)
	{
		if(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
