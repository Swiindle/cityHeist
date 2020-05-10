package com.cityheist.State;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * A State class represents the current state of the game.
 * For example, showing the main menu, game itself and game over scenes, all are states.
 */
public abstract class State
{
    protected OrthographicCamera camera;
    protected Vector2 mouse;
    protected GameStateManager gsm;
    protected ArrayList<Texture> componentList = new ArrayList<>();

    public State(GameStateManager gsm)
    {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector2();
    }

    public abstract void handleInput();
    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);

    public void dispose()
    {
        for(Texture t : componentList)
        {
            t.dispose();
        }
    }
}
