import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		title_panel.add(textField);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150)); // colored it just so that i can see it added to the frame
		
		for(int i= 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		frame.add(title_panel,BorderLayout.NORTH); // because we are using border layout, it automatically fills the whole frame. so i specify i only want it in the north of the frame
		frame.add(button_panel);
		
		firstTurn();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 9; i++) {
			if(e.getSource()== buttons[i]) {
				
				// check whos turn it is
				if (player1_turn) { // dont need to say == true since it is already a boolean value
					if(buttons[i].getText()=="") { // check if box is empty
						buttons[i].setForeground(new Color(255,0,0)); // red
						buttons[i].setText("X");
						player1_turn = false; // change turn
						textField.setText("O turn");
						
						check();
					}
					
				}
				else {
					if(buttons[i].getText()=="") { // check if box is empty
						buttons[i].setForeground(new Color(0,0,255)); // blue
						buttons[i].setText("O");
						player1_turn = true; // change turn
						textField.setText("X turn");
						
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn() { // to see who will start
		
		try { // making it say whos turn it is in the textField after 2 seconds
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textField.setText("X turn");
		}
		else {
			player1_turn = false;
			textField.setText("O turn");
		}
	}
	
	public void check() { // see who wins, x or o
		
		// check x win conditions
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) { // top row is all x
			
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) { // mid row is all x
			
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) { // bottom row is all x
			
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) { // left col is all x
			
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) { // mid col is all x
			
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) { // right col is all x
			
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) { // left to right diagonal
			
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) { // right to left diagonal
			
			xWins(2,4,6);
		}
		
		
		
		// check o win conditions
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) { // top row is all x
			
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) { // mid row is all x
			
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) { // bottom row is all x
			
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) { // left col is all x
			
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) { // mid col is all x
			
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) { // right col is all x
			
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) { // left to right diagonal
			
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) { // right to left diagonal
			
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		// so they cant keep playing after there is a winner 
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X wins");
		
	}
	
	public void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		// so they cant keep playing after there is a winner 
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("O wins");
		
	}
	
	
	

} // end class 
