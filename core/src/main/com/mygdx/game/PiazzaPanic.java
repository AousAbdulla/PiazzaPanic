package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.interact.Action;
import com.mygdx.game.interact.Combination;
import com.mygdx.game.interact.InteractableType;
import com.mygdx.game.levels.LevelType;
import com.mygdx.game.screens.EndScreen;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.OptionScreen;
import com.mygdx.game.screens.EndlessScreen;
import com.mygdx.game.screens.ModeScreen;
import com.mygdx.game.screens.ScenarioScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PiazzaPanic extends Game {

	public static Random random = new Random();

	// Screens
	GameScreen gameScreen;
	EndScreen endScreen;
	MenuScreen menuScreen;
	EndlessScreen endlessScreen;

	ModeScreen modeScreen;

	ScenarioScreen scenarioScreen;

	OptionScreen optionScreen;

	HashMap<String, Ingredient> ingredientHashMap;
	HashMap<String, InteractableType> interactableTypeHashMap;
	HashMap<InteractableType, ArrayList<Combination>> combinationsHashmap;
	HashMap<InteractableType, HashMap<Ingredient, Action>> actionHashmap;
	HashMap<String, LevelType> levelTypeHashMap;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Config.loggingLevel);
		loadJson();
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void startGame(String levelName, int difficulty)
	{
		System.out.println("GAME STARTED");
		gameScreen = new GameScreen(
				this,
				ingredientHashMap,
				interactableTypeHashMap,
				combinationsHashmap,
				actionHashmap,
				levelTypeHashMap.get(levelName).instantiate(difficulty)
		);


		setScreen(gameScreen);
	}
	public void OptionScreen1(){
		optionScreen = new OptionScreen(this);
		setScreen(optionScreen);
	}

	public void ModeScreen1(){
		modeScreen = new ModeScreen(this);
		setScreen(modeScreen);
	}

	public void ScenarioScreen1(){
		scenarioScreen = new ScenarioScreen(this);
		setScreen(scenarioScreen);
	}

	public void EndlessScreen1(){
		endlessScreen = new EndlessScreen(this);
		setScreen(endlessScreen);
	}

	public void endGame(String displayDetails)
	{
		System.out.println("GAME ENDED");
		endScreen = new EndScreen(this, displayDetails);
		setScreen(endScreen);
	}

	public void goToMenu()
	{
		System.out.println("RETURNED TO MAIN MENU");
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	private void loadJson() {
		JsonReader jsonReader = new JsonReader();
		JsonValue jsonRoot = jsonReader.parse(Gdx.files.internal("data/base.json"));
		ingredientHashMap = Ingredient.loadFromJson1(
			jsonRoot.get("ingredients")
		);
		interactableTypeHashMap = InteractableType.loadFromJson2(
			jsonRoot.get("interactables")
		);
		Ingredient.loadFromJson3(
			jsonRoot.get("ingredients"),
			ingredientHashMap,
			interactableTypeHashMap
		);
		combinationsHashmap = Combination.loadFromJson(
			jsonRoot.get("combinations"),
			jsonRoot.get("interactables"),
			jsonRoot.get("profiles"),
			ingredientHashMap,
			interactableTypeHashMap
		);
		actionHashmap = Action.	loadFromJson(
			jsonRoot.get("actions"),
			ingredientHashMap,
			interactableTypeHashMap);

		// profiles only exist at the json root for convenience.
		// a new Profile is created each time it is used in a level and are therefore generated here.
		levelTypeHashMap = LevelType.loadFromJson(
			jsonRoot.get("levels"),
			interactableTypeHashMap,
			combinationsHashmap,
			actionHashmap,
			jsonRoot.get("profiles"),
			ingredientHashMap
		);
	}
}
