package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class NewMenuScreen implements Screen {
    Texture playButton;
    Texture options;
    Texture quit;
    //Texture logo;

public NewMenuScreen (){

    playButton = new Texture("MenuScreenPlay.png");
    options = new Texture("MenuScreenOptions.png");
    quit = new Texture("MenuScreenQuit.png");
}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
