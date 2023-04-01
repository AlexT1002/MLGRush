package de.Alex1002.MLGRush.GameStates;

import de.Alex1002.MLGRush.MLGRush;

public class GameStateManager {
    private MLGRush plugin;

    private static GameStates currentState = null;

    public GameStateManager(MLGRush plugin){
        this.plugin = plugin;
    }

    public void startState(GameStates gameStates){
        if(hasState()){
            getState().stop();
            currentState = gameStates;
            currentState.start();
        }
        currentState = gameStates;
        currentState.start();
    }
    public void stopState(){
        if(hasState()){
            getState().stop();
        }
    }
    private static GameStates getState(){
        if(hasState()){
            return currentState;
        }
        return null;
    }
    private static boolean hasState(){
        if(currentState == null){
            return false;
        }
        return true;
    }
}
