package Gamble;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FontUIResource;


public class Blackjack implements ActionListener{

	// BlackjackPanel cards = new BlackjackPanel();
	
	static JFrame frame = new JFrame();
	
	thePit table = new thePit();
	
	boolean gameOver = false;
	
	int buttonCounter = 0;
	
	int playerScore = 0;
	int dealerScore = 0;
	
	//Below helps to input the x positions of the card image
	
	int playerPos = 300;
	int dealerPos = 300;
	
	//initial value of players money and number of bets
	
	int playerMoney = 500;
	int betAmount = 0;
	
	//Below helps to create a jpanel so we can input buttons and jlabels
	
	JPanel south = new JPanel();
	JLabel playerScoreText = new JLabel("Player Score: " + playerScore);
	JLabel dealerScoreText = new JLabel("Dealer Score: " + dealerScore);
	JLabel dealerCards = new JLabel("Dealer's Cards");
	JLabel playerCards = new JLabel("Player's Cards");
	JLabel balance = new JLabel("Balance: " + playerMoney);
	JLabel mainTitle = new JLabel("Blackjack");
	JLabel betbox = new JLabel();
	JButton bet = new JButton("Chip");
	JButton hit = new JButton("Hit");
	JButton stand = new JButton("Stand");
	JButton newRound = new JButton("New Game");
	String randomDealerCard;
	String randomPlayerCard;
	String dealerHiddenCard;
	
	//Create arraylist to store the whole 52 cards in the deck, while also storing the dealers and players card 
	
	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> dealerHand = new ArrayList<String>();
	ArrayList<String> playerHand = new ArrayList<String>();
	ArrayList<JButton> usedCards = new ArrayList<JButton>();	
	
	static int dealerValue = 0;
	String dealerString;
	static int playerValue = 0;
	String playerString;
	
	//Creating all the icons below
	
	Icon dealer1;
	Icon dealer2;
	Icon dealer3;
	Icon dealer4;
	Icon dealer5;
	Icon dealer6;
	Icon dealer7;
	Icon dealer8;
	Icon dealer9;
	Icon dealer10;
	Icon dealer11; 
	
	Icon player1;
	Icon player2;
	Icon player3;
	Icon player4;
	Icon player5;
	Icon player6;
	Icon player7;
	Icon player8;
	Icon player9;
	Icon player10;
	Icon player11; 
	
	//We can use these arrays of the buttons and imageicons in order to iterate through them
	
	JButton[] buttons = new JButton[22];
	ImageIcon[] playerIcons = new ImageIcon[11];
	ImageIcon[] dealerIcons = new ImageIcon[11]; 
	
	JButton card1;
	JButton card2;
	JButton card3;
	JButton card4;
	JButton card5;
	JButton card6;
	JButton card7;
	JButton card8;
	JButton card9;
	JButton card10;
	JButton card11; 
	JButton card12;
	JButton card13;
	JButton card14;
	JButton card15;
	JButton card16;
	JButton card17;
	JButton card18;
	JButton card19;
	JButton card20;
	JButton card21;
	JButton card22; 
	
	static Color gray = new Color(35, 35, 35);
	Color darkGray = new Color(15, 15, 14);
	
	private ImageIcon image1;
	private JLabel label1;
	
	//public blakcjack helps to store the interface above 
	
	public Blackjack() {
		
		//Add all the different card names to the arraylist which holds all 52 cards
		
		array.add("1c");
		array.add("1d");
		array.add("1h");
		array.add("1s");
		array.add("2c");
		array.add("2d");
		array.add("2h");
		array.add("2s");
		array.add("3c");
		array.add("3d");
		array.add("3h");
		array.add("3s");
		array.add("4c");
		array.add("4d");
		array.add("4h");
		array.add("4s");
		array.add("5c");
		array.add("5d");
		array.add("5h");
		array.add("5s");
		array.add("6c");
		array.add("6d");
		array.add("6h");
		array.add("6s");
		array.add("7c");
		array.add("7d");
		array.add("7h");
		array.add("7s");
		array.add("8c");
		array.add("8d");
		array.add("8h");
		array.add("8s");
		array.add("9c");
		array.add("9d");
		array.add("9h");
		array.add("9s");
		array.add("10c");
		array.add("10d");
		array.add("10h");
		array.add("10s");
		array.add("11c");
		array.add("11d");
		array.add("11h");
		array.add("11s");
		array.add("12c");
		array.add("12d");
		array.add("12h");
		array.add("12s");
		array.add("13c");
		array.add("13d");
		array.add("13h");
		array.add("13s");
		
		Collections.shuffle(array);
		
		//Set the first two card images of dealer and player 
		
		randomDealerCard = setRandomCard(array, dealerHand);
		dealerHiddenCard = randomDealerCard;
		dealer1 = new ImageIcon("backofcard.jpg");
		randomDealerCard = setRandomCard(array, dealerHand);
		dealer2 = new ImageIcon(randomDealerCard + ".jpg");
		randomPlayerCard = setRandomCard(array, playerHand);
		player1 = new ImageIcon(randomPlayerCard + ".jpg");
		randomPlayerCard = setRandomCard(array, playerHand);
		player2 = new ImageIcon(randomPlayerCard + ".jpg");		
		
		//Dealers cards
		
		card1 = new JButton (dealer1);
		card2 = new JButton (dealer2);
		
		//Players Cards
		
		card12 = new JButton (player1);
		card13 = new JButton (player2);	
		
		UIManager.put("OptionPane.minimumSize", new Dimension(500,500));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
		JOptionPane.showMessageDialog(Blackjack.frame,  "Hey Player! Welcome to Blackjack! Here is the premise of the game:\n"
		+ "You want to have a value as close to 21 than the dealer, while not going over 21.\n"
		+ "The Dealer will provide you with two cards, and if you are content with your value\n"
		+ "feel free to stand. If not, feel free to hit allowing you to gain another card.\n"
		+ "But be careful! If both of your cards add up to 16 for example, the odds of going over 21 are quite high!\n"
		+ "After players are satisified with their hands, the dealer will turn over their card\n"
		+ "that's faced down, and the fun begins : )"); 
		
		
		//Creating the whole frame below
		
		frame.setSize(1200,1038);
		frame.add(table);
		
		table.setLayout(null);
		
		//set the color of the table background
		
		table.setBackground(new Color(50, 100, 70));
		
		//set the text font, boundary, and colors of dealercard text
		
		table.add(dealerCards);
		dealerCards.setBounds(250, 40, 700, 200);
		dealerCards.setHorizontalAlignment(SwingConstants.CENTER);
		dealerCards.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
		dealerCards.setForeground(Color.white);
		
		//set the text font, boundary, and colors of playercard text
		
		table.add(playerCards);
		playerCards.setBounds(250, 400, 700, 200);
		playerCards.setHorizontalAlignment(SwingConstants.CENTER);
		playerCards.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
		playerCards.setForeground(Color.white);
		
		//set the text font, boundary, and colors of dbalance text
		
		table.add(balance);
		balance.setBounds(650, 40, 700, 200);
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
		balance.setForeground(Color.white);
		
		
		//Dealers button cards below
		
		table.add(card1);
		card1.setBounds(100, 250, 100, 150);
		card1.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.add(card2);
		card2.setBounds(200, 250, 100, 150);
		card2.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Player's button cards below
		
		table.add(card12);
		card12.setBounds(100, 600, 100, 150);
		card12.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.add(card13);
		card13.setBounds(200, 600, 100, 150);
		card13.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Creating the layout of the main title as well as the border colors
		
		table.add(mainTitle);
		mainTitle.setBounds(250, 0, 700, 100);
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(
		BorderFactory.createMatteBorder(2,2, 2, 2, Color.white),
		BorderFactory.createMatteBorder(5, 5, 5, 5, gray)),
		BorderFactory.createMatteBorder(0,0, 0, 0, Color.black)));
		mainTitle.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 70));
		mainTitle.setForeground(Color.white);
		mainTitle.setBackground(gray);
		mainTitle.setOpaque(true);
		
		//Adding all the different buttons below, whether font, size color etc...
		
		table.add(south);
		south.setBounds(0, 800, 1200, 200);
		south.setLayout(new GridLayout(2,3));
		south.add(dealerScoreText);
		dealerScoreText.setHorizontalAlignment(SwingConstants.CENTER);
		dealerScoreText.setBorder(BorderFactory.createLineBorder(Color.black));
		dealerScoreText.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		dealerScoreText.setForeground(Color.WHITE);
		dealerScoreText.setBackground(Color.black);
		dealerScoreText.setOpaque(true);
		south.add(playerScoreText);
		playerScoreText.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreText.setBorder(BorderFactory.createLineBorder(Color.black));
		playerScoreText.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		playerScoreText.setForeground(Color.WHITE);
		playerScoreText.setBackground(Color.black);
		playerScoreText.setOpaque(true);
		south.add(newRound);
		newRound.addActionListener(this);
		newRound.setBorder(BorderFactory.createLineBorder(Color.black));
		newRound.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		newRound.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		newRound.setForeground(Color.white);
		newRound.setBackground(Color.black);
		
		south.add(hit);
		hit.addActionListener(this);
		hit.setBorder(BorderFactory.createLineBorder(Color.black));
		hit.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		hit.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		hit.setForeground(Color.white);
		hit.setBackground(Color.black);
		hit.setEnabled(false);
		
		south.add(stand);
		stand.addActionListener(this);
		stand.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		stand.setBorder(BorderFactory.createLineBorder(Color.black));
		stand.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		stand.setBackground(Color.black);
		stand.setForeground(Color.white);
		stand.setEnabled(false);
		south.add(bet);
		bet.addActionListener(this);
		bet.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		bet.setBorder(BorderFactory.createLineBorder(Color.black));
		bet.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		bet.setBackground(Color.black);
		bet.setForeground(Color.white);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		dealerValue = calculateTotal(dealerHand);
		playerValue = calculateTotal(playerHand);
	}
	
	//Below helps us to keep track of special occurences: Ties, dealer natural, player natural 
	public boolean checkSpecialOccurrence() {
		if(playerValue == 21 && dealerValue == 21) {
			dealer1 = new ImageIcon(dealerHiddenCard + ".jpg");
			frame.repaint();
			UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
			JOptionPane.showMessageDialog(Blackjack.frame,  "Tie! Player's bet is returned. "
					+ "Please select a new game.");
			return true;
		} else if(playerValue != 21 && dealerValue == 21) {
			dealer1 = new ImageIcon(dealerHiddenCard + ".jpg");
			frame.repaint();
			UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
			JOptionPane.showMessageDialog(Blackjack.frame,  "Player lost - dealer has a natural! "
					+ "Please select a new game.");
			dealerScore++;
			dealerScoreText.setText("Dealer Score: "  + dealerScore);
			return true;
		} else if(playerValue == 21 && dealerValue != 21) {
			dealer1 = new ImageIcon(dealerHiddenCard + ".jpg");
			frame.repaint();
			UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
			JOptionPane.showMessageDialog(Blackjack.frame,  "Dealer lost - player has a natural! "
					+ "Please select a new game.");
			playerScore++;
			playerScoreText.setText("Dealer Score: "  + playerScore);
			return true;
		}
		return false;
	}
	
	//method for setting a random card, giving the user a random card
	
	public String setRandomCard(ArrayList array, ArrayList arr) {
		String card = (String)array.get(0);
		array.remove(card);
		arr.add(card);
		return card;
	}
	
	//Helps to look at the players hand and calculate their total value 
	
	public int calculateTotal(ArrayList arr) {
	    int total = 0;
	    int counter = 0;
	
	    for (int i = 0; i < arr.size(); i++) {
	        String card = (String)arr.get(i);
	        if(card.length() == 2 && card.charAt(0) == '1') {
	            counter++;
	        } else {
	            if(card.charAt(1) > 57) {
	                total += (card.charAt(0))-48;
	            } else {
	                total += 10;
	            }
	        }
	    }
	    if(total < 11 && counter == 1) { 
	        total += 11;
	    } else {
	        total += counter;
	    }
	    return total;
	}
	
	public static void main(String[] args) {
		new Blackjack();
	}
	
	public void endRound() {
		System.out.println(dealerHand);
		System.out.println(playerHand);
		for (int i = 0; i < usedCards.size(); i++) {
			JButton removedCard = usedCards.get(i);
			table.remove(removedCard);
		} 
		
        hit.setEnabled(false);
        stand.setEnabled(false);
        bet.setEnabled(true);
        
        dealerPos = 300;
        playerPos = 300;
        
        dealerValue = 0;
        playerValue = 0;
        betAmount = 0;
        gameOver = false;
        
        for (int i = 0; i < dealerHand.size(); i++) {
            String resetCard = dealerHand.get(i);
            array.add(resetCard);
        }
        for (int i = 0; i <playerHand.size(); i++) {
            String resetCard = playerHand.get(i);
            array.add(resetCard);
        }       
        
        Collections.shuffle(array);
        
        usedCards.clear();
        dealerHand.clear();
        playerHand.clear();
        
        table.remove(card2);
        table.remove(card12);
        table.remove(card13);

        
        randomDealerCard = setRandomCard(array, dealerHand);
		dealerHiddenCard = randomDealerCard;
		dealer1 = new ImageIcon("backofcard.jpg");
		randomDealerCard = setRandomCard(array, dealerHand);
		dealer2 = new ImageIcon(randomDealerCard + ".jpg");
		randomPlayerCard = setRandomCard(array, playerHand);
		player1 = new ImageIcon(randomPlayerCard + ".jpg");
		randomPlayerCard = setRandomCard(array, playerHand);
		player2 = new ImageIcon(randomPlayerCard + ".jpg");
		
		card1 = new JButton (dealer1);
		card2 = new JButton (dealer2);
		card12 = new JButton (player1);
		card13 = new JButton (player2);	
		
		table.add(card1);
		card1.setBounds(100, 250, 100, 150);
		card1.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.add(card2);
		card2.setBounds(200, 250, 100, 150);
		card2.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.add(card12);
		card12.setBounds(100, 600, 100, 150);
		card12.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.add(card13);
		card13.setBounds(200, 600, 100, 150);
		card13.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.repaint();
		
		System.out.println(dealerHand);
		System.out.println(playerHand);
    }
	
	//When user clicks a certain button actions will be performed
	//If user clicks on bet, their balance will be decreased by 100 for each bet
	//If user hits, a new card will appear on the screen
	
	public void actionPerformed(ActionEvent e) {
		dealerValue = calculateTotal(dealerHand);
		playerValue = calculateTotal(playerHand);
		
		if(e.getSource() == newRound) {
			endRound();
		}
		
		if(e.getSource() == bet) {
			hit.setEnabled(true);
			stand.setEnabled(true);
			if(playerMoney < 100) {
				UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
				JOptionPane.showMessageDialog(Blackjack.frame,  "You need at least 100 credits to bet.");
				bet.setEnabled(false);
			} else {
				playerMoney -= 100;
				balance.setText("Balance: " + playerMoney);
				betAmount++;
			}
			
		}

		// If user hits and a special occurrence hasn't occurred, a new card image will appear 
		
		if(e.getSource() == hit) {
			
			if(!checkSpecialOccurrence()) {
				bet.setEnabled(false);
				String randomPlayerCard = setRandomCard(array, playerHand);
				ImageIcon newCard = new ImageIcon(randomPlayerCard + ".jpg");
				JButton cardButton = new JButton (newCard);
				table.add(cardButton);
				cardButton.setBounds(playerPos, 600, 100, 150);
				cardButton.setHorizontalAlignment(SwingConstants.CENTER);
				cardButton.setVisible(true);
				usedCards.add(cardButton);
				cardButton.setName("button" + buttonCounter);
				buttonCounter++;
				playerValue = calculateTotal(playerHand);
				playerPos += 100;
				playerValue = calculateTotal(playerHand);
				
				if(playerValue > 21) {
					UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(Blackjack.frame,  "Player has busted!");
					dealerScore++;
					dealerScoreText.setText("Dealer Score: "  + dealerScore);
					dealerValue = 0;
					playerValue = 0;
					betAmount = 0;
				}
			} 
		}
		
		//If user stands then perform certain actions, which helps to create card images for the dealer
		
		if(e.getSource() == stand) {
			bet.setEnabled(false);
			int tieMoney = betAmount*100;
			String dealerHiddenCard = dealerHand.get(0);
			ImageIcon dealerFirstCardImg = new ImageIcon(dealerHiddenCard + ".jpg");
			JButton dealerFirstCard = new JButton(dealerFirstCardImg);
			table.add(dealerFirstCard);
			dealerFirstCard.setBounds(100, 250, 100, 150);
			dealerFirstCard.setHorizontalAlignment(SwingConstants.CENTER);
			dealerFirstCard.setVisible(true);
			while(dealerValue < 17) {
				String randomDealerCard = setRandomCard(array, dealerHand);
				ImageIcon newCard = new ImageIcon(randomDealerCard + ".jpg");
				JButton cardButton = new JButton (newCard);
				table.add(cardButton);
				cardButton.setBounds(dealerPos, 250, 100, 150);
				cardButton.setHorizontalAlignment(SwingConstants.CENTER);
				cardButton.setVisible(true);
				usedCards.add(cardButton);
				cardButton.setName("button" + buttonCounter);
				buttonCounter++;
				dealerPos += 100;
				dealerValue = calculateTotal(dealerHand);
				if(dealerValue > 21) {
					UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(Blackjack.frame,  "Dealer has busted!");
					playerMoney += betAmount*200;
					balance.setText("Balance: " + playerMoney);
					playerScore++;
					playerScoreText.setText("Player Score: " + playerScore);
					dealerValue += 30;
					gameOver = true;
				}
			}
			if(gameOver == false) {
				if(dealerValue > playerValue) {
					UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(Blackjack.frame,  "Dealer has won!");
					dealerScore++;
					dealerScoreText.setText("Dealer Score: " + dealerScore);
					dealerValue = 0;
					playerValue = 0;
					betAmount = 0;
				} else if(dealerValue < playerValue) {
					UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(Blackjack.frame,  "Player has won!");
					playerMoney += betAmount*200;
					balance.setText("Balance: " + playerMoney);
					playerScore++;
					playerScoreText.setText("Player Score: " + playerScore);
					dealerValue = 0;
					playerValue = 0;
					betAmount = 0;
				} else {
					UIManager.put("OptionPane.minimumSize", new Dimension(100,100));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(Blackjack.frame,  "Tie!");
					balance.setText("Balance: " + (playerMoney + tieMoney));
					dealerValue = 0;
					playerValue = 0;
					betAmount = 0;
				}
			}
		}
	}
}