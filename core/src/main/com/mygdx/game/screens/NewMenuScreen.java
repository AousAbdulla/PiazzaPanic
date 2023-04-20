package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NewMenuScreen implements Screen {
    Texture playButton;
    Texture options;
    Texture quit;
    //Texture logo;

    SpriteBatch batch;


    public NewMenuScreen (){


        batch = new SpriteBatch();
        playButton = new Texture("MenuScreenPlay.png");
        options = new Texture("MenuScreenOptions.png");
        quit = new Texture("MenuScreenQuit.png");
    }

    @Override
    public void show() {
//test
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(playButton,0f ,0f);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {

    }
}
