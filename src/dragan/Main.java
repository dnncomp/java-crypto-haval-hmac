package dragan;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.EventListener;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static dragan.HavalAttributes.HAVAL_128_BIT;
import static dragan.HavalAttributes.HAVAL_160_BIT;
import static dragan.HavalAttributes.HAVAL_256_BIT;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class Main extends JFrame implements EventListener{
	private static final long serialVersionUID = -7892748107951478338L;
	private JTextField txtMessage;
	private JTextField txtHAVAL;
	private JTextField txtKey;
	private JTextField txtHMAC;
	private JTextField txtRound;
	public Main() {
		setTitle("Dragan. 2016. Crypto.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 13, 523, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(12, 13, 108, 16);
		panel.add(lblMessage);
		
		txtMessage = new JTextField();
		txtMessage.setForeground(Color.BLACK);
		txtMessage.setText("The quick brown fox jumps over the lazy dog");
		txtMessage.setBounds(12, 39, 382, 22);
		panel.add(txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMessage.setText(null);
				txtHAVAL.setText(null);
				txtHMAC.setText(null);
				txtKey.setText(null);
								
			}
		});
		btnClear.setBounds(406, 38, 101, 25);
		panel.add(btnClear);
		
		JPanel panel_Haval = new JPanel();
		panel_Haval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Haval.setBounds(12, 106, 523, 142);
		getContentPane().add(panel_Haval);
		panel_Haval.setLayout(null);
		
		JLabel lblHaval = new JLabel("HAVAL (one-way Hashing Algorithm with VAriable Length of output)");
		lblHaval.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHaval.setBounds(12, 13, 504, 25);
		panel_Haval.add(lblHaval);
		
		JButton btnHAVAL_128_BIT = new JButton("HAVAL 128 bit");
		btnHAVAL_128_BIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHAVAL.setText(Haval.hash(txtMessage.getText().getBytes(),HAVAL_128_BIT,Integer.parseInt(txtRound.getText()) ));
				
			}
		});
		btnHAVAL_128_BIT.setBounds(12, 69, 158, 25);
		panel_Haval.add(btnHAVAL_128_BIT);
		
		txtHAVAL = new JTextField();
		txtHAVAL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHAVAL.setForeground(Color.RED);
		txtHAVAL.setBounds(12, 107, 498, 22);
		panel_Haval.add(txtHAVAL);
		txtHAVAL.setColumns(10);
		
		JButton btnHAVAL_160_BIT = new JButton("HAVAL 160 bit");
		btnHAVAL_160_BIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHAVAL.setText(Haval.hash(txtMessage.getText().getBytes(), HAVAL_160_BIT,Integer.parseInt(txtRound.getText())  ));
			}
		});
		btnHAVAL_160_BIT.setBounds(182, 69, 158, 25);
		panel_Haval.add(btnHAVAL_160_BIT);
		
		JButton btnHAVAL_256_BIT = new JButton("HAVAL 256 bit");
		btnHAVAL_256_BIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHAVAL.setText(Haval.hash(txtMessage.getText().getBytes(), HAVAL_256_BIT,Integer.parseInt(txtRound.getText())  ));
			}
		});
		btnHAVAL_256_BIT.setBounds(352, 69, 158, 25);
		panel_Haval.add(btnHAVAL_256_BIT);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtn3_ROUND = new JRadioButton("3 rounds");
		rdbtn3_ROUND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRound.setText("3");
			}
		});
		rdbtn3_ROUND.setSelected(true);
		rdbtn3_ROUND.setBounds(237, 35, 89, 25);
		panel_Haval.add(rdbtn3_ROUND);
		group.add(rdbtn3_ROUND);
		
		JRadioButton rdbtn4_ROUND = new JRadioButton("4 rounds");
		rdbtn4_ROUND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRound.setText("4");
			}
		});
		rdbtn4_ROUND.setBounds(330, 35, 89, 25);
		panel_Haval.add(rdbtn4_ROUND);
		group.add(rdbtn4_ROUND);
		
		JRadioButton rdbtn5_ROUND = new JRadioButton("5 rounds");
		rdbtn5_ROUND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRound.setText("5");
			}
		});
		rdbtn5_ROUND.setBounds(423, 35, 89, 25);
		panel_Haval.add(rdbtn5_ROUND);
		group.add(rdbtn5_ROUND);
		
		
		
		
		
		txtRound = new JTextField();
		txtRound.setEnabled(false);
		txtRound.setEditable(false);
		txtRound.setVisible(false);
		txtRound.setText("3");
		txtRound.setBounds(466, 15, 37, 22);
		panel_Haval.add(txtRound);
		txtRound.setColumns(10);
		
		JLabel lblWith = new JLabel("and with variable number of rounds:");
		lblWith.setBounds(12, 40, 229, 16);
		panel_Haval.add(lblWith);
		
		JPanel panel_Hmac = new JPanel();
		panel_Hmac.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Hmac.setBounds(12, 261, 523, 116);
		getContentPane().add(panel_Hmac);
		panel_Hmac.setLayout(null);
		
		JLabel lblHmac = new JLabel("HMAC (keyed-Hash based Message Authentication Code)");
		lblHmac.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHmac.setBounds(12, 13, 434, 16);
		panel_Hmac.add(lblHmac);
		
		txtKey = new JTextField();
		txtKey.setForeground(Color.BLUE);
		txtKey.setText("Secret");
		txtKey.setBounds(45, 38, 209, 22);
		panel_Hmac.add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setBounds(12, 42, 45, 16);
		panel_Hmac.add(lblKey);
		
		JButton btnHmacMD5 = new JButton("HMAC MD5");
		btnHmacMD5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtHMAC.setText(Hmac.calculateHMACMD5(txtMessage.getText(), txtKey.getText()));
				}catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					//System.out.println("Key is Empty");
					txtHMAC.setText("Error! Empty Key!");
				}catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Key is Empty");
				} catch (SignatureException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHmacMD5.setBounds(266, 37, 119, 25);
		panel_Hmac.add(btnHmacMD5);
		
		txtHMAC = new JTextField();
		txtHMAC.setForeground(Color.RED);
		txtHMAC.setBounds(12, 74, 499, 22);
		panel_Hmac.add(txtHMAC);
		txtHMAC.setColumns(10);
		
		JButton btnHmacSHA1 = new JButton("HMAC SHA1");
		btnHmacSHA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtHMAC.setText(Hmac.calculateHMACSHA1(txtMessage.getText(), txtKey.getText()));
				}catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					//System.out.println("Key is Empty");
					txtHMAC.setText("Error! Empty Key!");
				} catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SignatureException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHmacSHA1.setBounds(397, 37, 114, 25);
		panel_Hmac.add(btnHmacSHA1);
	}

	public static void main(String[] args) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
		Main f1 = new Main();
		f1.setSize(555, 425);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		
//		String s1 = "dnncomp";
//		byte[] b1 = s1.getBytes();
//		long timeout= System.currentTimeMillis();
//		String hash_b = Haval.hash(b1);
//		timeout = System.currentTimeMillis() - timeout;
//		System.out.println(hash_b);
//		String s2 = "Микола";
//		byte[] b2 = s2.getBytes();
//		
//		System.out.println(Haval.hash(b2, 24, 3));
//		
//		
//		String hmac= Hmac.calculateHMACSHA1("data", "key");
//		System.out.println(hmac);
//		//assert hmac.equals("104152c5bfdca07bc633eebd46199f0255c9f49d");
//
//		
//		String hmac2 = Hmac.calculateHMACMD5("data", "key");
//		System.out.println(hmac2);
//		timeout = System.currentTimeMillis() - timeout;
//		//System.out.println(timeout);
	}
}
