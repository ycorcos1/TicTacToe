package com.yahav.tictactoe.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private OnePlayer onePlayer;
	private TwoPlayer twoPlayer;
	private JPanel titlePanel;
	private JLabel lblTitle;
	private JPanel btnPanel;
	private JButton btnOnePlayer;
	private JButton btnTwoPlayer;

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setResizable(false);
		setBackground(Color.BLACK);
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setFont(new Font("Phosphate", Font.PLAIN, 48));
		titlePanel.add(lblTitle);
		
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.BLACK);
		contentPane.add(btnPanel, BorderLayout.CENTER);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
		
		btnOnePlayer = new JButton("1-Player");
		btnOnePlayer.setFocusable(false);
		btnOnePlayer.setOpaque(true);
		btnOnePlayer.setFont(new Font("Phosphate", Font.PLAIN, 24));
		btnOnePlayer.setForeground(Color.GREEN);
		btnOnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initializeOnePlayerMode();
			}
		});
		btnOnePlayer.setBackground(Color.GREEN);
		btnPanel.add(btnOnePlayer);
		
		btnTwoPlayer = new JButton("2-Player");
		btnTwoPlayer.setFocusable(false);
		btnTwoPlayer.setOpaque(true);
		btnTwoPlayer.setFont(new Font("Phosphate", Font.PLAIN, 24));
		btnTwoPlayer.setForeground(Color.GREEN);
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeTwoPlayerMode();
			}
		});
		btnTwoPlayer.setBackground(Color.GREEN);
		btnPanel.add(btnTwoPlayer);
		setVisible(true);
	}
	
	public void initializeOnePlayerMode() {
		onePlayer = new OnePlayer(this);
		setVisible(false);
	}
	
	public void initializeTwoPlayerMode() {
		twoPlayer = new TwoPlayer(this);
		setVisible(false);
	}

}
