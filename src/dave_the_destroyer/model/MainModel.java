package dave_the_destroyer.model;

import dave_the_destroyer.Game;

import javax.swing.*;

public abstract class MainModel{

    Game game;

    public MainModel( Game g){
        game = g;
    }

    public Game getGame(){
        return game;
    }

    public abstract ActionMap updateValidActions();
}
