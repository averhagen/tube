package com.amverhagen.tube.game;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Fonts {

	// public HashMap<String, BitmapFont> fontMap;
	public HashMap<ColorSize, BitmapFont> fontsMap;
	private FreeTypeFontGenerator ftfg;

	public Fonts() {
		// fontMap = new HashMap<String, BitmapFont>();
		fontsMap = new HashMap<ColorSize, BitmapFont>();
		ftfg = new FreeTypeFontGenerator(Gdx.files.internal("fonts/whitrabt.ttf"));
		// FreeTypeFontParameter parameter = new FreeTypeFontParameter();

		// parameter.color = Colors.TUBE_WHITE;
		//
		// parameter.size = 24;
		// fontMap.put("white24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("white48", ftfg.generateFont(parameter));
		// parameter.size = 60;
		// fontMap.put("white60", ftfg.generateFont(parameter));
		makeFont(new ColorSize(Colors.TUBE_WHITE, 24), false);
		makeFont(new ColorSize(Colors.TUBE_WHITE, 48), false);
		makeFont(new ColorSize(Colors.TUBE_WHITE, 60), false);

		makeFont(new ColorSize(Colors.TUBE_BLUE, 24), true);
		makeFont(new ColorSize(Colors.TUBE_BLUE, 48), true);
		makeFont(new ColorSize(Colors.TUBE_BLUE, 60), true);

		makeFont(new ColorSize(Colors.TUBE_BLACK, 24), true);
		makeFont(new ColorSize(Colors.TUBE_BLACK, 48), true);
		makeFont(new ColorSize(Colors.TUBE_BLACK, 60), true);

		makeFont(new ColorSize(Colors.TUBE_PINK, 24), true);
		makeFont(new ColorSize(Colors.TUBE_PINK, 48), true);
		makeFont(new ColorSize(Colors.TUBE_PINK, 60), true);

		makeFont(new ColorSize(Colors.TUBE_GREEN, 24), true);
		makeFont(new ColorSize(Colors.TUBE_GREEN, 48), true);
		makeFont(new ColorSize(Colors.TUBE_GREEN, 60), true);

		makeFont(new ColorSize(Colors.TUBE_PURPLE, 24), true);
		makeFont(new ColorSize(Colors.TUBE_PURPLE, 48), true);
		makeFont(new ColorSize(Colors.TUBE_PURPLE, 60), true);

		makeFont(new ColorSize(Colors.TUBE_RED, 24), true);
		makeFont(new ColorSize(Colors.TUBE_RED, 48), true);
		makeFont(new ColorSize(Colors.TUBE_RED, 60), true);

		// parameter.borderWidth = 3;
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_BLUE;
		// fontMap.put("blue24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("blue48", ftfg.generateFont(parameter));
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_BLACK;
		// fontMap.put("black24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("black48", ftfg.generateFont(parameter));
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_PINK;
		// fontMap.put("pink24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("pink48", ftfg.generateFont(parameter));
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_GREEN;
		// fontMap.put("green24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("green48", ftfg.generateFont(parameter));
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_PURPLE;
		// fontMap.put("purple24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("purple48", ftfg.generateFont(parameter));
		//
		// parameter.size = 24;
		// parameter.borderColor = Colors.TUBE_RED;
		// fontMap.put("red24", ftfg.generateFont(parameter));
		// parameter.size = 48;
		// fontMap.put("red48", ftfg.generateFont(parameter));

		ftfg.dispose();
	}

	public void makeFont(ColorSize colorSize, boolean border) {
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = colorSize.fontSize;
		parameter.color = Colors.TUBE_WHITE;
		parameter.borderColor = colorSize.color;
		if (border)
			parameter.borderWidth = 3;
		fontsMap.put(colorSize, ftfg.generateFont(parameter));
	}

	public BitmapFont getFont(Color c, int size) {
		return fontsMap.get(new ColorSize(c, size));
	}

	public class ColorSize {
		int fontSize;
		Color color;

		public ColorSize(Color color, int size) {
			this.fontSize = size;
			this.color = color;
		}

		@Override
		public int hashCode() {
			return color.hashCode() + fontSize;
		};

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof ColorSize))
				return false;
			ColorSize incoming = (ColorSize) obj;
			if (this.color.equals(incoming.color) && this.fontSize == incoming.fontSize)
				return true;
			return false;
		}
	}
}