package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonValue.ValueType;
import com.mygdx.game.Ingredient;
import com.mygdx.game.actors.Customer.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {
    List<Customer> members = new ArrayList<>();

    boolean active = true;

    public Group(List<Profile> memberProfiles) {
        this();
        for (Profile memberProfile: memberProfiles) {
            members.add(new Customer(
                  memberProfile,
                  this
            ));
        }
    }

    private Group() {}

    public void update(float delta) {
        if (active) {
            for (Customer member: members) {
                member.update(delta);
            }
        }
    }

    public void render(Batch batch) {
        if (active) {
            for (Customer member: members) {
                member.render(batch);
            }
        }
    }

    public boolean everyoneHasTheFood() {
        for (Customer member: members) {
            if (!(member.state == State.WAITING_FOR_GROUP_FOOD || member.state == State.EATING )) {
                return false;
            }
        }
        return true;
    }

    public void takeOrders() {
        for (Customer member: members) {
            member.state = State.ORDERING;
        }
    }

    public boolean readyToLeave() {
        for (Customer member: members) {
            if (member.state != State.LEAVING || member.posX != member.spot.posX || member.posY != member.spot.posY) {
                return false;
            }
        }
        return true;
    }

    public JsonValue saveGame() {
        JsonValue saveData = new JsonValue(ValueType.object);

        saveData.addChild("active", new JsonValue(active));

        JsonValue memberSaveData = new JsonValue(ValueType.array);
        for (Customer member: members) {
            memberSaveData.addChild(member.saveGame());
        }


        return saveData;
    }
    public static Group loadGame(
          JsonValue groupSaveData,
          JsonValue jsonProfiles,
          HashMap<String, Ingredient> ingredientHashMap,
          HashMap<String, Spot> spotHashMap,
          List<Spot> eatingSpots
    ) {
        Group group = new Group();

        group.active = groupSaveData.getBoolean("active");

        for (JsonValue memberSaveData: groupSaveData) {
            group.members.add(Customer.loadGame(
                  memberSaveData,
                  group,
                  jsonProfiles,
                  ingredientHashMap,
                  spotHashMap,
                  eatingSpots
            ));
        }

        return group;
    }
}
