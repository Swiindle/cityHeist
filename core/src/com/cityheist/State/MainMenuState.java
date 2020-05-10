package com.cityheist.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cityheist.Board;

public class MainMenuState extends State
{
    private Texture button;

    public MainMenuState(GameStateManager gsm)
    {
        super(gsm);
        componentList.add(button = new Texture("core/assets/robberWinImage.png"));
    }

    @Override
    public void handleInput()
    {
        if(Gdx.input.isTouched())
        {
            System.out.println("hello");
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float delta)
    {
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(1,1,1,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(button, Board.width/2,Board.height/2);
        batch.end();
    }
}
