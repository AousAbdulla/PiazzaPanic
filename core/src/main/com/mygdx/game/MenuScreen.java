package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen implements Screen {
    Sprite playButton;
    Sprite options;
    Sprite quit;


    SpriteBatch batch;

    ScreenViewport viewport;

    public MenuScreen (){
        batch = new SpriteBatch();
        playButton = new Sprite(new Texture("textures/MenuScreenPlay.png"));
        options = new Sprite(new Texture("textures/MenuScreenOptions.png"));
        quit = new Sprite(new Texture("textures/MenuScreenQuit.png"));

        playButton.setCenter(0,0);
        options.setCenter(0,-100);
        quit.setCenter(0,-200);
        viewport = new ScreenViewport();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        //float buttonWidth = playButton.getWidth();
        //float buttonHeight = playButton.getHeight();


        //IF BUTTON SIZES ARE DIFFERENT (OBV CHANGE FLOAT NAMES)
        //float buttonWidth = options.getWidth();
        //float buttonHeight = options.getHeight();

        //float buttonWidth = quit.getWidth();
        //float buttonHeight = quit.getHeight();

        batch.begin();
        playButton.draw(batch);
        options.draw(batch);
        quit.draw(batch);

        // Check if the left mouse button is pressed
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            // Get the coordinates of the mouse click
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            // show viewport coordinate system
            Vector3 position = viewport.unproject(new Vector3(x, y, 0));

            // Check if mouse pressed
            if (playButton.getBoundingRectangle().contains(position.x, position.y)) {
                // Code to be executed when the button is pressed
                System.out.println("The play button was pressed");
            }
            if (options.getBoundingRectangle().contains(position.x, position.y)) {
                // Code to be executed when the button is pressed
                System.out.println("The options button was pressed");
            }
            if (quit.getBoundingRectangle().contains(position.x, position.y)) {
                // Code to be executed when the button is pressed
                System.out.println("The quit button was pressed");
            }
        }

        batch.end();
    }









    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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
