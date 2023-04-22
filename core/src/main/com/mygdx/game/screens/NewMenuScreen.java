package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class NewMenuScreen implements Screen {
    Texture playButton;
    Texture options;
    Texture quit;
    //Texture logo;

    SpriteBatch batch;
//New
    ScreenViewport viewport;

    public NewMenuScreen (){


        batch = new SpriteBatch();
        playButton = new Texture("textures/MenuScreenPlay.png");
        options = new Texture("textures/MenuScreenOptions.png");
        quit = new Texture("textures/MenuScreenQuit.png");

        viewport = new ScreenViewport();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        float centerX = viewport.getWorldWidth() /2;
        float centerY = viewport.getWorldHeight() /2;

        float buttonWidth = playButton.getWidth();
        float buttonHeight = playButton.getHeight();


//test
        batch.begin();
        batch.draw(playButton, centerX - buttonWidth / 2, centerY-buttonHeight / 2 +100);
        batch.draw(options,centerX - buttonWidth / 2, centerY-buttonHeight / 2);
        batch.draw(quit,centerX - buttonWidth / 2, (centerY-buttonHeight / 2) -1000);
        batch.end();

    }
//test
    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
