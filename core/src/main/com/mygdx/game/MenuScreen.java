package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.PiazzaPanic;

public class MenuScreen implements Screen {
    Texture playButton;
    Texture options;
    Texture quit;

    SpriteBatch batch;

    ScreenViewport viewport;

    public MenuScreen (PiazzaPanic piazzaPanic) {
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

        batch.begin();
        batch.draw(playButton, 0f, 0f);
        batch.draw(options, 50f, 0f);
        batch.draw(quit, 100f, 0f);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
