package com.cityheist.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cityheist.Board;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "CityHeist Game";
		config.height = Board.height;
		config.width = Board.width;

		new LwjglApplication(new Board(), config);
	}
}
