package com.cvgstudios.pokemonchrome.font;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class PokeFont extends Font {

	Font dFont;
	static Font font = new Font("Verdana", Font.BOLD, 12);;

	public PokeFont() {
		super(font);
		File f = new File("res/Font/PokemonFont.ttf");
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			dFont = Font.createFont(Font.TRUETYPE_FONT, in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		font = setSize(20);
	}
	
	public Font getFont(){
		return font;
	}
	

	public Font setSize(float size) {
		Font f = dFont.deriveFont(size);
		return f;

	}
}
