package com.yahav.tictactoe.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class OnePlayer extends JFrame implements ActionListener{

	private MainScreen mainScreen;
	private JPanel contentPane;
	private JTextField scoreTextField;
	private JButton[] buttons;
	private JPanel titlePanel;
	private JLabel lblScore;
	private JPanel btnPanel;
	private JPanel btmPanel;
	private JButton btnBack;
	private boolean turn;
	private Random rand;
	private int boxCount;
	private JButton restart;
	private boolean check_flag;
	

	/**
	 * Create the frame.
	 */
	public OnePlayer(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
		boxCount = 0;
		rand = new Random();
		check_flag = false;
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		titlePanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) titlePanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		titlePanel.setBackground(Color.BLACK);
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		lblScore = new JLabel("Score:");
		lblScore.setBackground(Color.BLACK);
		lblScore.setFont(new Font("Phosphate", Font.PLAIN, 24));
		lblScore.setForeground(Color.GREEN);
		titlePanel.add(lblScore);
		
		scoreTextField = new JTextField();
		scoreTextField.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTextField.setEditable(false);
		scoreTextField.setForeground(Color.GREEN);
		scoreTextField.setBackground(Color.BLACK);
		scoreTextField.setFont(new Font("Phosphate", Font.PLAIN, 16));
		titlePanel.add(scoreTextField);
		scoreTextField.setColumns(32);
		
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.BLACK);
		contentPane.add(btnPanel, BorderLayout.CENTER);
		btnPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		buttons = new JButton[9];
		addButtons();
		
		btmPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btmPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		btmPanel.setBackground(Color.BLACK);
		contentPane.add(btmPanel, BorderLayout.SOUTH);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setFont(new Font("Phosphate", Font.PLAIN, 24));
		btnBack.setForeground(Color.GREEN);
		btmPanel.add(btnBack);
		setVisible(true);
		firstTurn();
	}
	
	private void firstTurn() {
		if(rand.nextInt(2) == 0) {
			turn = true;
			scoreTextField.setText("X TURN");
		}else {
			turn = false;
			scoreTextField.setText("O TURN");
			compTurn();
		}
	}
	
	private void compTurn() {
		int box = rand.nextInt(9);
		while(buttons[box].getText()!="") {
			box = rand.nextInt(9);
		}
		buttons[box].setForeground(Color.BLACK);
		buttons[box].setText("O");
		boxCount++;
		turn = true;
		scoreTextField.setText("X TURN");
		check();
	}
	
	private void addButtons() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(true);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setFont(new Font("Phosphate", Font.PLAIN, 60));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			btnPanel.add(buttons[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack) goBackToMainScreen();
		for(int i = 0; i < buttons.length; i++) {
			if(e.getSource() == buttons[i]) {
				if(turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(Color.GREEN);
						buttons[i].setText("X");
						boxCount++;
						turn = false;
						scoreTextField.setText("O TURN");
						check();
						if(!check_flag) {
							compTurn();
						}
					}
				}
			}
		}
	}
	
	private void check() {
		if(boxCount < 9) {
			// check if X wins
			if(buttons[0].getText()=="X" && 
					buttons[1].getText()=="X" &&
					buttons[2].getText()=="X") {
				check_flag = true;
				isWinner("X", 0, 1, 2);
			}else if(buttons[3].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[5].getText()=="X") {
				check_flag = true;
				isWinner("X", 3, 4, 5);
			}else if(buttons[6].getText()=="X" &&
						buttons[7].getText()=="X" &&
						buttons[8].getText()=="X"){
				check_flag = true;
				isWinner("X", 6, 7, 8);
			}else if(buttons[0].getText()=="X" &&
						buttons[3].getText()=="X" &&
						buttons[6].getText()=="X") {
				check_flag = true;
				isWinner("X", 0, 3, 6);
			}else if(buttons[1].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[7].getText()=="X") {
				check_flag = true;
				isWinner("X", 1, 4, 7);
			}else if(buttons[2].getText()=="X" &&
						buttons[5].getText()=="X" &&
						buttons[8].getText()=="X") {
				check_flag = true;
				isWinner("X", 2, 5, 8);
			}else if(buttons[0].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[8].getText()=="X") {
				check_flag = true;
				isWinner("X", 0, 4, 8);
			}else if(buttons[2].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[6].getText()=="X") {
				check_flag = true;
				isWinner("X", 2, 4, 6);
			}
			
			// check if O wins
			if(buttons[0].getText()=="O" && 
					buttons[1].getText()=="O" &&
					buttons[2].getText()=="O") {
				check_flag = true;
				isWinner("O", 0, 1, 2);
			}else if(buttons[3].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[5].getText()=="O") {
				check_flag = true;
				isWinner("O", 3, 4, 5);
			}else if(buttons[6].getText()=="O" &&
						buttons[7].getText()=="O" &&
						buttons[8].getText()=="O"){
				check_flag = true;
				isWinner("O", 6, 7, 8);
			}else if(buttons[0].getText()=="O" &&
						buttons[3].getText()=="O" &&
						buttons[6].getText()=="O") {
				check_flag = true;
				isWinner("O", 0, 3, 6);
			}else if(buttons[1].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[7].getText()=="O") {
				check_flag = true;
				isWinner("O", 1, 4, 7);
			}else if(buttons[2].getText()=="O" &&
						buttons[5].getText()=="O" &&
						buttons[8].getText()=="O") {
				check_flag = true;
				isWinner("O", 2, 5, 8);
			}else if(buttons[0].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[8].getText()=="O") {
				check_flag = true;
				isWinner("O", 0, 4, 8);
			}else if(buttons[2].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[6].getText()=="O") {
				check_flag = true;
				isWinner("O", 2, 4, 6);
			}
		}else {
			// check if X wins
			if(buttons[0].getText()=="X" && 
					buttons[1].getText()=="X" &&
					buttons[2].getText()=="X") {
				isWinner("X", 0, 1, 2);
			}else if(buttons[3].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[5].getText()=="X") {
				isWinner("X", 3, 4, 5);
			}else if(buttons[6].getText()=="X" &&
						buttons[7].getText()=="X" &&
						buttons[8].getText()=="X"){
				isWinner("X", 6, 7, 8);
			}else if(buttons[0].getText()=="X" &&
						buttons[3].getText()=="X" &&
						buttons[6].getText()=="X") {
				isWinner("X", 0, 3, 6);
			}else if(buttons[1].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[7].getText()=="X") {
				isWinner("X", 1, 4, 7);
			}else if(buttons[2].getText()=="X" &&
						buttons[5].getText()=="X" &&
						buttons[8].getText()=="X") {
				isWinner("X", 2, 5, 8);
			}else if(buttons[0].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[8].getText()=="X") {
				isWinner("X", 0, 4, 8);
			}else if(buttons[2].getText()=="X" &&
						buttons[4].getText()=="X" &&
						buttons[6].getText()=="X") {
				isWinner("X", 2, 4, 6);
			}
			
			// check if O wins
			if(buttons[0].getText()=="O" && 
					buttons[1].getText()=="O" &&
					buttons[2].getText()=="O") {
				isWinner("O", 0, 1, 2);
			}else if(buttons[3].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[5].getText()=="O") {
				isWinner("O", 3, 4, 5);
			}else if(buttons[6].getText()=="O" &&
						buttons[7].getText()=="O" &&
						buttons[8].getText()=="O"){
				isWinner("O", 6, 7, 8);
			}else if(buttons[0].getText()=="O" &&
						buttons[3].getText()=="O" &&
						buttons[6].getText()=="O") {
				isWinner("O", 0, 3, 6);
			}else if(buttons[1].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[7].getText()=="O") {
				isWinner("O", 1, 4, 7);
			}else if(buttons[2].getText()=="O" &&
						buttons[5].getText()=="O" &&
						buttons[8].getText()=="O") {
				isWinner("O", 2, 5, 8);
			}else if(buttons[0].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[8].getText()=="O") {
				isWinner("O", 0, 4, 8);
			}else if(buttons[2].getText()=="O" &&
						buttons[4].getText()=="O" &&
						buttons[6].getText()=="O") {
				isWinner("O", 2, 4, 6);
			}else {
				noWinner();
			}
		}
	}
	
	private void isWinner(String winner, int a, int b, int c) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
			buttons[i].setBackground(Color.GRAY);
		}
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		scoreTextField.setText(winner + " is the winner!");
		restartButton();
	}
	
	private void noWinner() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
			buttons[i].setBackground(Color.GRAY);
		}
		scoreTextField.setText("No Winner");
		restartButton();
	}
	
	private void restartButton() {
		restart = new JButton("Restart");
		restart.setFont(new Font("Phosphate", Font.PLAIN, 24));
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btmPanel.add(restart);
	}
	
	private void newGame() {
		this.dispose();
		mainScreen.initializeOnePlayerMode();
	}
	
	private void goBackToMainScreen() {
		setVisible(false);
		mainScreen.setVisible(true);
	}

}
