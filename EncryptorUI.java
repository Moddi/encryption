import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class EncryptorUI extends JFrame {
	private Encryptor encryptor;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EncryptorUI() {
		encryptor = new Encryptor();
		Map<String, EncryptStrategy>encryptionMap;
		encryptionMap = new HashMap<String, EncryptStrategy>();
		
		encryptionMap.put("Copy", new CopyEncryptor());
		encryptionMap.put("Reverse", new ReverseEncryptor());
		
		JTextArea text1 = new JTextArea(5, 25);
		JTextArea text2 = new JTextArea(5, 25);
		JPanel panel = new JPanel();
		JButton button1 = new JButton("Encrypt");
		JButton button2 = new JButton("Decrypt");
		JComboBox comboBox = new JComboBox(encryptionMap.keySet().toArray());
		
		text1.setBorder(new TitledBorder("Original"));
		text2.setBorder(new TitledBorder("Encrypted"));
		text2.setEditable(false);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(comboBox);
		
		Box box = Box.createVerticalBox();
		box.add(text1);
		box.add(text2);
		box.add(panel);
		add(box);
		pack();
		
		/*
		 * Wenn die EncryptStrategy erst mit einem ActionListener der ComboBox eingelesen wuerde, gabs einen Fehler, beim
		 * starten des Programms, da bei start noch keine Strategie ausgewält ist. Eine Abfrage der einzelnen Buttons
		 * erscheint mir da sinnvoller.
		 */
		button1.addActionListener(
				e -> {
					Object selectedStrategy = comboBox.getSelectedItem();
					EncryptStrategy strategy = encryptionMap.get(selectedStrategy);
					encryptor.setEncryptionStrategy(strategy);
					
					text2.setText(encryptor.encrypt(text1.getText()));
				}
			);
		
		button2.addActionListener(
				e -> {
					Object selectedStrategy = comboBox.getSelectedItem();
					EncryptStrategy strategy = encryptionMap.get(selectedStrategy);
					encryptor.setEncryptionStrategy(strategy);
					
					text2.setText(encryptor.decrypt(text2.getText()));
				}
			);
	}
	
	public static void main(String[] args) {
		EncryptorUI frame = new EncryptorUI();
		frame.setTitle("Encryptor");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
