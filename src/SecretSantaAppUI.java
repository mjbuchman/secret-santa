import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class SecretSantaAppUI {

	private JFrame frame;
	private BufferedImage image;
	private JTextField addedNameField;
	private JTextField addedEmailField;
	private Participant newParticipant;
	private ParticipantList participants = new ParticipantList();

	public int nextStartPoint = 150;
	public int buttonPosition = 391;
	public static LinkedList<JTextField> boxes = new LinkedList<>();
	public static JButton btnSend, btnAddLine, btnDeleteLine;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("Unsupported Look and Feel");
		} catch (ClassNotFoundException e) {
			System.out.println("Look and Feel Class Not Found");
		} catch (InstantiationException e) {
			System.out.println("Instantiation Exception Thrown");
		} catch (IllegalAccessException e) {
			System.out.println("Illegal Access Exception Thrown");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretSantaAppUI window = new SecretSantaAppUI();
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
	public SecretSantaAppUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Secret Santa Tool");
		
		frame.getContentPane().setBackground(new Color(33, 230, 136));
		try {                
			image = ImageIO.read(new File("images/SecretSantaHeader.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(image));
			picLabel.setBounds(0, 0, 600, 120);
			frame.getContentPane().add(picLabel);
		} catch (IOException ex) {
			System.out.println("Image could not be loaded");
		}
		
		frame.setBounds(100, 100, 600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSend = new JButton("Send Emails");
		btnSend.setBackground(Color.LIGHT_GRAY);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < boxes.size();i++) {
					if(boxes.get(i).getText().equals("")) {
						JFrame popup = new JFrame();
						JOptionPane error = new JOptionPane();
						error.showMessageDialog(popup, "Please do not leave any boxes blank");
						return;
					}
				}
				
				for(int j = 0; j < boxes.size(); j+=2) {
					newParticipant = new Participant(boxes.get(j).getText(), boxes.get(j+1).getText());
					participants.add(newParticipant);
				}
				
				participants.assignParticipants();
				participants.printResults();
				
				for(int k = 0; k < participants.size(); k++) {
					EmailSender test = new EmailSender(participants.get(k).getEmail(), participants.get(participants.get(k).getTarget()).getName());
					
					try {
			            test.sendHtmlEmail();
			            System.out.println("Email sent.");
			        } catch (Exception ex) {
			            System.out.println("Failed to send email.");
			        }
				}
			}
		});
		btnSend.setBounds(396, buttonPosition, 110, 28);
		frame.getContentPane().add(btnSend);
		
		for(int i = 0; i < 6; i++) {
			addedNameField = new JTextField();
			addedNameField.setColumns(10);
			addedNameField.setBounds(83, nextStartPoint, 190, 28);
			frame.getContentPane().add(addedNameField);
			boxes.add(addedNameField);
			
			addedEmailField = new JTextField();
			addedEmailField.setColumns(10);
			addedEmailField.setBounds(316, nextStartPoint, 190, 28);
			frame.getContentPane().add(addedEmailField);
			boxes.add(addedEmailField);
			
			nextStartPoint += 40;
		}
		
		btnAddLine = new JButton("+");
		btnAddLine.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddLine.setBackground(Color.LIGHT_GRAY);
		btnAddLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveButtonsDown();
				
				addedNameField = new JTextField();
				addedNameField.setColumns(10);
				addedNameField.setBounds(83, nextStartPoint, 190, 28);
				frame.getContentPane().add(addedNameField);
				boxes.add(addedNameField);
				
				addedEmailField = new JTextField();
				addedEmailField.setColumns(10);
				addedEmailField.setBounds(316, nextStartPoint, 190, 28);
				frame.getContentPane().add(addedEmailField);
				boxes.add(addedEmailField);
				
				nextStartPoint += 40;
			}
		});
		btnAddLine.setBounds(83, buttonPosition, 40, 28);
		frame.getContentPane().add(btnAddLine);
		
		btnDeleteLine = new JButton("-");
		btnDeleteLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxes.size() > 6) {
					frame.getContentPane().remove(boxes.get(boxes.size()-1));
					boxes.removeLast();
					frame.getContentPane().remove(boxes.get(boxes.size()-1));
					boxes.removeLast();
					
					moveButtonsUp();
					nextStartPoint -= 40;
				}
			}
		});
		btnDeleteLine.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDeleteLine.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteLine.setBackground(Color.LIGHT_GRAY);
		btnDeleteLine.setBounds(131, buttonPosition, 40, 28);
		frame.getContentPane().add(btnDeleteLine);
	}
	
	public void moveButtonsDown() {
		buttonPosition += 40;
		btnAddLine.setBounds(83, buttonPosition, 40, 28);
		btnDeleteLine.setBounds(131, buttonPosition, 40, 28);
		btnSend.setBounds(396, buttonPosition, 110, 28);
	}
	
	public void moveButtonsUp() {
		buttonPosition -= 40;
		btnAddLine.setBounds(83, buttonPosition, 40, 28);
		btnDeleteLine.setBounds(131, buttonPosition, 40, 28);
		btnSend.setBounds(396, buttonPosition, 110, 28);
	}
}
