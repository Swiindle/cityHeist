package com.cityheist.State;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * The Game State Manager handles all the posssible game states it has. It uses a stack to implement this.
 */
public class GameStateManager
{
    private Stack<State> stateStack = new Stack<>();

    public void pop()
    {
        stateStack.pop();
    }

    public void push(State state)
    {
        stateStack.push(state);
    }

    public void set(State state)
    {
        stateStack.pop();
        stateStack.push(state);
    }

    public void update(float delta)
    {
        stateStack.peek().update(delta);
    }

    public void render(SpriteBatch batch)
    {
        stateStack.peek().render(batch);
    }

    public void dispose()
    {
        stateStack.peek().dispose();
    }
}
