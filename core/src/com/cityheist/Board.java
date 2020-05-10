package com.cityheist;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cityheist.State.*;

import java.util.ArrayList;

public class Board extends ApplicationAdapter {
	public final static int boxSize = 50;
	public final static int xSquares = 10;
	public final static int ySquares = 13;
	public static int width = xSquares * boxSize;
	public static int height = ySquares * boxSize + 40;
	public final static int totalSquares = xSquares * ySquares;

	//INSTIANTIATE

	private GameStateManager gsm;
	private SpriteBatch batch;


	public void create()
	{
		System.out.println("create");
		gsm = new GameStateManager();
		gsm.push(new MainMenuState(gsm));
		batch = new SpriteBatch();

		/*
		//FRAME
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
		frame.setResizable(false);
		frame.setLayout(gameLayout);
		*/


		/*
		this.readLevelLayout();
		this.configureAdjacentTiles();
		// INFO PANEL
		infoPanel.setLayout(new GridLayout(0,3));
		infoPanel.setBackground(Color.YELLOW);

		//JLabel turnTrackerIcon;

		JLabel turnTrackerLabel = new JLabel("TEST1");
		infoPanel.add(turnTrackerLabel);

		//JLabel turnTrackerIcon;

		JLabel copObjectiveLabel = new JLabel("TEST2");
		infoPanel.add(copObjectiveLabel);

		//JLabel turnTrackerIcon;

		JLabel robberObjectiveLabel = new JLabel("TEST3");
		infoPanel.add(robberObjectiveLabel);

		gr.setLabels(turnTrackerLabel,copObjectiveLabel,robberObjectiveLabel);

		// THE REST //

		mainGame.setLayout(new BorderLayout());
		mainGame.add(gamePanel, BorderLayout.CENTER);
		mainGame.add(infoPanel, BorderLayout.NORTH);

		JLabel robberWinText = new JLabel(new ImageIcon("art/robberWinImage.png"));
		robberWinScreen.add(robberWinText,BorderLayout.CENTER);

		JLabel copWinText = new JLabel(new ImageIcon("art/copWinImage.png"));
		copWinScreen.add(copWinText,BorderLayout.CENTER);


		frame.setContentPane(mainGame);
		frame.setVisible(true);//making the frame visible
		 */
	}

	public void render()
	{
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	public void dispose()
	{
		gsm.dispose();
		batch.dispose();
	}
}