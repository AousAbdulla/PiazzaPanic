package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;

public class Config {
    public static int unitHeightInPixels = 22;
    public static int unitWidthInPixels = 32;

    public static int defaultTexIngredientStartX = 8;
    public static int defaultTexIngredientStartY = 13;
    public static int defaultTexStartX = 0;
    public static int defaultTexStartY = 0;

    public static boolean defaultInteractableCollisions = true;
    public static int loggingLevel = 2;

    public static boolean debugRendering = true;
    // currently only changed on startup


    //
    // Below should be available in options menu
    //

    public static float volumeMaster = 1;
    public static float volumeMusic = 1;
    public static float volumeEffects = 1;

    // keybinds
    public static int KBUp = Keys.W;
    public static int KBDown = Keys.S;
    public static int KBLeft = Keys.A;
    public static int KBRight = Keys.D;

    public static int KBDoAction = Keys.SPACE;
    public static int KBDoCombination = Keys.SHIFT_LEFT;
    public static int KBSwapChefs = Keys.TAB;

    public static int scaling = 4;
    public static int fpsLimit = 60;
    public static int resolutionHeight = 480;
    public static int resolutionWidth = 640;
    private Config() {}

    public static void loadConfig() {

    }

    public static void saveConfig() {

    }
}
