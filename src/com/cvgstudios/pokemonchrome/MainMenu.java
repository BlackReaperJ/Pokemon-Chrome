package com.cvgstudios.pokemonchrome;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import com.cvgstudios.pokemonchrome.images.Images;
import com.cvgstudios.pokemonchrome.maps.Exitium;
import com.cvgstudios.pokemonchrome.maps.Route1;
import com.cvgstudios.pokemonchrome.music.MP3MusicPlayer;
import com.cvgstudios.pokemonchrome.music.MP3MusicPlayer;

public class MainMenu extends JFrame implements ActionListener {
	MyDrawPanel dPnl1;

	Image imgBG, imgDialog, imgTitleScreen, imgProfessor, imgPokeball,
			imgTykepol, imgArrow, imgFriendGirl, imgFriendBoy, imgBoy, imgGirl,
			imgMainMenu, imgProfessorFlip, imgMenuAll, imgMenuContinue,
			imgMenuSelect, imgMenuAllSelect, imgPlayerMale, imgPlayerFemale,
			imgGender, imgCredits;
	static int screenCount = 1;
	String map = "";
	int mapChange = 0;
	int gender = 1, startScreen = 1, finalPlayerGender, selected = 1;
	String playerGenderString[] = { "Male", "Female" };
	JTextField inputName = new JTextField("Ash");
	JButton btnNameInput = new JButton("Enter Name");
	String playerBadges = "0", playerTime = "0:00", playerGender = "";
	Boolean saveFileAvailable = true;
	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(10f), f3 = dFont
			.deriveFont(50f);
	Timer tm = new Timer(10, this);
	Timer music = new Timer(80000, this);
	int y = 0, velY = 2;// For Credit Scrolling

	public static void main(String[] args) throws Exception {
		boolean musicPlaying = false;// Code for the music
		boolean musicPlaying2 = false;
		MainMenu mainMenu = new MainMenu();
		MP3MusicPlayer creditMusic = new MP3MusicPlayer("Music/Credits.mp3");
		MP3MusicPlayer introMusic = new MP3MusicPlayer("Music/PokemonHGSS.mp3");

		while (true) {
			if (musicPlaying2 && (screenCount == 13 || screenCount == 14)) {
				musicPlaying2 = false;
				introMusic.stop();
				introMusic = new MP3MusicPlayer("Music/PokemonHGSS.mp3");
			}

			if (screenCount >= 1 && screenCount < 13 && !musicPlaying2) {
				if (!musicPlaying2) {
					musicPlaying2 = true;
					introMusic.play();
				}
			}
			if (screenCount != 14 && musicPlaying) {
				musicPlaying = false;
				creditMusic.stop();
				creditMusic = new MP3MusicPlayer("Music/Credits.mp3");
			}
			if (screenCount == 14) {
				if (!musicPlaying) {
					musicPlaying = true;
					creditMusic.play();
				}
			}
			if (screenCount == 13) {
				GameFile.saveFile();
				Exitium.pleaseRenameTheseMethodsJulius();
				mainMenu.setVisible(false);
				break;
			}
			// if(GameFile.iBattle >=1 && GameFile.iLocation >=2 &&
			// !(GameFile.strPlayerName.equals("null"))){
			// FakeBattle go = new FakeBattle();
			// }s
			if (screenCount == 15) {
				if (GameFile.iLocation >= 0 && GameFile.iLocation <= 2
						&& GameFile.iaGameVars[3] < 12) {
					Exitium go = new Exitium();
				} else if (GameFile.iLocation == 3) {
					Route1 go = new Route1();
				} else if (GameFile.iBattle >= 1) {
					FriendsRivals.renameThisMethodJuliusUsingAltShiftR();
				}
				GameFile.loadFile();
				mainMenu.setVisible(false);
				break;
			}

			Thread.sleep(15);
		}
	}

	public MainMenu() throws Exception {
		GameFile.loadFile();// Loads game file
		// Match image variable name to imageURL
		imgBG = Images.WelcomeBG.getImage();
		imgDialog = Images.DialogBox.getImage();
		imgTitleScreen = Images.TitleScreen.getImage();
		imgProfessor = Images.Professor.getImage();
		imgPokeball = Images.Pokeball.getImage();
		imgTykepol = Images.Tykepol.getImage();
		imgArrow = Images.Arrow.getImage();
		imgFriendGirl = Images.FriendGirl.getImage();
		imgFriendBoy = Images.FriendBoy.getImage();
		imgBoy = Images.PlayerBoy.getImage();
		imgGirl = Images.PlayerGirl.getImage();
		imgMainMenu = Images.PokemonTitleMenuBG.getImage();
		imgProfessorFlip = Images.ProfessorFlip.getImage();
		imgMenuAll = Images.PokemonMenuAll.getImage();
		imgMenuContinue = Images.PokemonMenuContinue.getImage();
		imgMenuSelect = Images.PokemonMenuContinueSelected.getImage();
		imgMenuAllSelect = Images.PokemonMenuAllSelected.getImage();
		imgPlayerMale = Images.Male.getImage();
		imgPlayerFemale = Images.Female.getImage();
		imgCredits = Images.Credits.getImage();
		imgGender = Images.Gender.getImage();

		dPnl1 = new MyDrawPanel();
		dPnl1.setLayout(null);

		inputName.setBounds(300, 500, 200, 30);
		inputName.setOpaque(false);
		inputName.addActionListener(this);
		inputName.setVisible(false);
		inputName.setForeground(Color.black);
		inputName.setFont(f1);
		dPnl1.add(inputName);

		btnNameInput.setBounds(300, 530, 200, 30);
		btnNameInput.setOpaque(false);
		btnNameInput.addActionListener(this);
		btnNameInput.setVisible(false);
		btnNameInput.setForeground(Color.black);
		btnNameInput.setFont(f1);
		dPnl1.add(btnNameInput);

		this.add(dPnl1);
		this.addKeyListener(new AL());
		this.setFocusable(true);
		this.setSize(600, 600);
		;
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(200, 200);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this)
			this.setFocusable(true);
		else if (e.getSource() == btnNameInput) {
			GameFile.strPlayerName = inputName.getText();
			inputName.setVisible(false);
			btnNameInput.setVisible(false);
			screenCount += 1;
			repaint();
			this.setFocusable(true);
		}
		y = y + velY;
		if (y == 3350) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (y >= 3750) {
			screenCount = 2;
			y = 0;
		}
		repaint();
	}

	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			if (GameFile.iLocation >= 0 && GameFile.iLocation <= 2) {
				map = "Exitium Town";
			} else if (GameFile.iLocation == 3) {
				map = "Route 1";
			} else if (GameFile.iLocation == 4) {
				map = "MapleLodge Town";
			}
			g.setColor(Color.WHITE);
			if (screenCount >= 1) {
				if (screenCount == 1)
					g.drawImage(imgTitleScreen, 0, 0, 600, 600, this);
				if (screenCount == 2) {
					g.drawImage(imgMainMenu, 0, 0, 600, 600, 0, 0, 252, 192,
							this);
					if (selected == 1) {
						g.drawImage(imgMenuSelect, 75, 50, 525, 325, 0, 0, 443,
								241, this);
						g.drawImage(imgMenuAll, 75, 350, 525, 425, 0, 0, 443,
								66, this);
						g.drawImage(imgMenuAll, 75, 450, 525, 525, 0, 0, 443,
								66, this);
					}
					if (selected == 2) {
						g.drawImage(imgMenuContinue, 75, 50, 525, 325, 0, 0,
								443, 241, this);
						g.drawImage(imgMenuAllSelect, 75, 350, 525, 425, 0, 0,
								443, 66, this);
						g.drawImage(imgMenuAll, 75, 450, 525, 525, 0, 0, 443,
								66, this);
					}
					if (selected == 3) {
						g.drawImage(imgMenuContinue, 75, 50, 525, 325, 0, 0,
								443, 241, this);
						g.drawImage(imgMenuAll, 75, 350, 525, 425, 0, 0, 443,
								66, this);
						g.drawImage(imgMenuAllSelect, 75, 450, 525, 525, 0, 0,
								443, 66, this);
					}
					g.setFont(f1);
					g.drawString("Continue", 100, 100);
					g.drawString("New Game", 100, 400);
					g.drawString("About", 100, 500);

					g.setColor(Color.CYAN);
					g.drawString(GameFile.strPlayerName, 225, 150);
					g.setColor(Color.WHITE);
					g.drawString(map, 225, 200);
					g.drawString("Badges: " + playerBadges, 100, 250);
					g.drawString("Time: " + playerTime, 100, 300);
					if (gender == 1)
						g.drawImage(imgPlayerMale, 125, 113, 200, 212, 0, 0,
								75, 100, this);
					if (gender == 2)
						g.drawImage(imgPlayerFemale, 125, 113, 200, 212, 0, 0,
								75, 100, this);
				}
				if (screenCount >= 3 && screenCount <= 12) {
					g.setColor(Color.BLACK);
					g.setFont(f1);
					g.drawImage(imgBG, 0, 0, this);
					if (screenCount >= 3) {
						if ((screenCount >= 3) && (screenCount <= 12))
							g.drawImage(imgDialog, 0, 475, this);
						if (screenCount == 3) {
							GameFile.newGame();
							g.drawImage(imgProfessor, 150, 0, this);
							g.drawString("Hello, My Name is Professor Shinwa",
									25, 525);
							g.drawString("And this is the Orpheus Region!", 25,
									565);
							g.drawImage(imgPokeball, 150, 100, this);
						} else if (screenCount == 4) {
							g.drawImage(imgProfessorFlip, 150, 0, this);
							g.drawString("This creature is known as a Pokemon",
									25, 525);
							g.drawString("Its name is Tykepol!", 25, 565);
							g.drawImage(imgTykepol, 400, 335, this);
						} else if (screenCount == 5) {
							g.drawImage(imgProfessorFlip, 150, 0, this);
							g.drawString("Movin on.....", 25, 525);
							g.drawString("Your name is?", 25, 565);
							inputName.setVisible(true);
							btnNameInput.setVisible(true);
						} else if (screenCount == 6) {
							g.drawImage(imgProfessorFlip, 150, 0, this);
							g.drawString("So, your name is "
									+ GameFile.strPlayerName, 25, 525);
							g.drawString("Well " + GameFile.strPlayerName
									+ "........", 25, 565);
						} else if (screenCount == 7) {
							g.drawImage(imgGender, 0, 0, this);
							g.drawString("Are you a Boy or a Girl?", 25, 525);
						} else if (screenCount == 8) {
							g.drawString("Are you a Boy or a Girl?", 25, 525);
							g.drawString("Please choose.", 25, 565);
							g.drawString("Male", 375, 525);
							g.drawString("Female", 375, 565);
							if (gender == 1) {
								g.drawImage(imgArrow, 475, 500, this);
								g.drawImage(imgBoy, 0, 0, this);
							} else if (gender == 2) {
								g.drawImage(imgArrow, 475, 540, this);
								g.drawImage(imgGirl, 0, 0, this);
							}
							System.out.println(screenCount);
						} else if (screenCount == 9) {
							g.drawImage(imgProfessor, 150, 0, this);
							g.drawString("So, you're a "
									+ playerGenderString[finalPlayerGender],
									25, 525);
							GameFile.strPlayerGender = playerGender;
						} else if (screenCount == 10) {
							g.drawImage(imgProfessor, 250, 0, this);
							g.drawImage(imgFriendGirl, 0, 0, this);
							g.drawString("This is your friend Natalie", 25, 525);
							g.drawString(
									"She is a spoiled rich girl who visits you",
									25, 565);
						} else if (screenCount == 11) {
							g.drawImage(imgProfessorFlip, 150, 0, this);
							g.drawImage(imgFriendBoy, 400, 0, this);
							g.drawString("And this is your other friend Jayce",
									25, 525);
							g.drawString(
									"He is a sarcastic douchebag of a friend!",
									25, 565);
						} else if (screenCount == 12) {
							g.drawImage(imgProfessor, 150, 0, this);
							g.drawString("Lets Start Your Adventure Now!", 25,
									525);
							g.drawString(
									"To Become an Orpheus Pokemon Master!", 25,
									565);
						}
					}
				}
				if (screenCount == 14) {
					g.setColor(Color.BLUE);
					g.setFont(f1);
					tm.start();
					g.drawImage(imgCredits, 0, 200 - y, this);
					g.drawString("Pokemon Chrome Credits", 150, 700 - y);
					g.drawImage(imgTykepol, 100, 700 - y, this);
					g.drawString("Project Manager", 250, 800 - y);
					g.setColor(Color.WHITE);
					g.drawString("Julius D'Silva", 215, 850 - y);
					g.setColor(Color.BLUE);
					g.drawString("Art Director", 225, 950 - y);
					g.setColor(Color.WHITE);
					g.drawString("Niko Katerelos", 215, 1000 - y);
					g.setColor(Color.BLUE);
					g.drawString("Story Director", 220, 1100 - y);
					g.setColor(Color.WHITE);
					g.drawString("Arvin Zaldivar", 225, 1150 - y);
					g.setColor(Color.BLUE);
					g.drawString("Program Director", 205, 1250 - y);
					g.setColor(Color.WHITE);
					g.drawString("Julius D'Silva", 215, 1300 - y);
					g.setColor(Color.BLUE);
					g.drawString("Pokemon Character Design", 160, 1400 - y);
					g.setColor(Color.WHITE);
					g.drawString("Tommy Huynh", 210, 1450 - y);
					g.drawString("Niko Katerelos", 210, 1500 - y);
					g.setColor(Color.BLUE);
					g.drawString("2-D Map Graphics", 205, 1600 - y);
					g.setColor(Color.WHITE);
					g.drawString("Rofel Ganado", 215, 1650 - y);
					g.drawString("Julius D'Silva", 215, 1700 - y);
					g.setColor(Color.BLUE);
					g.drawString("User-Interface and Battle Programmer", 70,
							1800 - y);
					g.setColor(Color.WHITE);
					g.drawString("Julius D'Silva", 215, 1850 - y);
					g.drawString("Dixon D'Ccuhna", 215, 1900 - y);
					g.setColor(Color.BLUE);
					g.drawString("Music", 250, 2000 - y);
					g.setColor(Color.WHITE);
					g.drawString("Arvin Zaldivar", 205, 2050 - y);
					g.drawString("Rofel Ganado", 205, 2100 - y);
					g.setColor(Color.BLUE);
					g.drawString("Sprites Design", 210, 2200 - y);
					g.setColor(Color.WHITE);
					g.drawString("Niko Katerelos", 210, 2250 - y);
					g.drawString("Tommy Huynh", 210, 2300 - y);
					g.setColor(Color.BLUE);
					g.drawString("Graphic Animator", 210, 2400 - y);
					g.setColor(Color.WHITE);
					g.drawString("Mark Bouchkevitch", 200, 2450 - y);
					g.drawString("Julius D'Silva", 210, 2500 - y);
					g.setColor(Color.BLUE);
					g.drawString("Special Thanks", 210, 2650 - y);
					g.setColor(Color.WHITE);
					g.drawString("Justin Baradi(Programmer)", 100, 2700 - y);
					g.drawString("Mudassir Mohammad(Pokemon Designer)", 95,
							2750 - y);
					g.drawString("Gabriel Ramos(Graphic Helper)", 100, 2800 - y);
					g.drawString("Nidrax(Maple Trees)", 100, 2850 - y);
					g.drawString("XDinky(Fountain)", 100, 2900 - y);
					g.drawString("LotusKing(PokemonCenter)", 100, 2950 - y);
					g.drawString("chimcharsfireworkd(PokemonLab)", 100,
							3000 - y);
					g.drawString("Eli-eli76(Battle Backgrounds)", 100, 3050 - y);

					g.setColor(Color.BLUE);
					g.drawString("In Conjunction With", 210, 3150 - y);
					g.setColor(Color.WHITE);
					g.drawString("Xid Studios", 100, 3200 - y);
					g.drawString("Dixon D'Cunha(Programmer)", 100, 3250 - y);

					// TODO fade it out
					g.drawString("Pokemon Chrome Version", 170, 3550 - y);
					g.setColor(Color.BLUE);
					g.drawString("Developed By", 220, 3600 - y);
					g.setColor(Color.WHITE);
					g.drawString("CVG Studios.", 220, 3650 - y);
					repaint();
				}
			}
			// Graphics2D g2 = (Graphics2D)g;
			// for(int x=0;x<=600;x+=25){
			// g2.drawLine(x,0,x,600);
			// g2.drawString(""+x,x,20);
			// }
			// for(int y=0;y<=600;y+=25){
			// g2.drawLine(0,y,600,y);
			// g2.drawString(""+y,0,y+20);
			// }
		}
	}

	public static void superMakeFightingTimeNow() throws Exception {
		FriendsRivals.renameThisMethodJuliusUsingAltShiftR();
		while (!FriendsRivals.battleDone) {
			Thread.sleep(1000);
		}
		FriendsRivals.tearItDoooooooooooown();
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get key preseed
			if (keyCode == e.VK_S) {
				if ((screenCount < 5) || (screenCount >= 6)) {
					if (screenCount == 7)
						finalPlayerGender = gender - 1;
					System.out.println(finalPlayerGender);
					if (screenCount == 2 && selected == 1) {
						screenCount = 15;
					} else if (screenCount == 2 && selected == 3) {
						screenCount = 14;
					} else if (screenCount == 14) {
						screenCount = 2;
						y = 0;
					} else if (screenCount < 13) {
						screenCount += 1;
						repaint();
					}
				}
			}
			if (keyCode == e.VK_DOWN) {
				if (screenCount == 2) {
					if (selected < 3) {
						selected = selected + 1;
						repaint();
					}
				}
				if (screenCount == 8) {
					gender = 2;
				} else if (screenCount == 2)
					startScreen = 2;
			}
			repaint();
			{
				if (keyCode == e.VK_UP) {
					if (screenCount == 2) {
						if (selected > 1) {
							selected = selected - 1;
							repaint();
						}
					}
					if (screenCount == 8) {
						gender = 1;
					} else if (screenCount == 2)
						startScreen = 1;
				}
				repaint();
			}
		}
	}
}