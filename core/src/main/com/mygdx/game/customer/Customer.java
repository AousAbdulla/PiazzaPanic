package com.mygdx.game.customer;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Ingredient;
import com.mygdx.game.interact.Interactable;

/**
 * @author Thomas McCarthy
 *
 * A customer is given an order, and brings it to the designated counter.
 */
public class Customer {

    float posX;
    float posY;
    float speed = 50f;

    // Float determining how far from the counter the customer stands.
    float counterOffset;
    boolean atCounter = false;
    boolean orderComplete = false;

    Interactable counter;
    Ingredient requiredIngredient;


    //==========================================================\\
    //                      CONSTRUCTOR                         \\
    //==========================================================\\
    public Customer(Interactable counter, Ingredient requiredIngredient)
    {
        this.counter = counter;
        this.requiredIngredient = requiredIngredient;

        posX = -15f;
        posY = counter.getYPos();

        counterOffset = 70f;
    }


    //==========================================================\\
    //                       ANIMATION                          \\
    //==========================================================\\

    public void update()
    {
        if(orderComplete && getDistanceFromCounter() < 200f)
        {
            posX -= (speed * Gdx.graphics.getDeltaTime());
        }
        else if(orderComplete)
        {
            CustomerEngine.removeCustomer(this);
        }
        else if(!atCounter)
        {
            posX += (speed * Gdx.graphics.getDeltaTime());
            if(getDistanceFromCounter() <= counterOffset)
            {
                // counter.placeOrder(this, requiredIngredient);
                atCounter = true;
            }
        }
    }


    //==========================================================\\
    //                    GETTERS & SETTERS                     \\
    //==========================================================\\

    public float getXPos() { return posX; }

    public float getYPos() { return posY; }

    public float getDistanceFromCounter() { return Math.abs(counter.getXPos() - posX); }

    public void completeOrder()
    {
        orderComplete = true;
    }

}
