package dave_the_destroyer.model;

import dave_the_destroyer.Game;

import javax.swing.*;

public class Map extends MainModel {

    Terrain[][] terrains;

    Entity entity;

    public Map( Game g){
        super(g);

        terrains = new Terrain[10][10];
        entity = new Entity( 5,5);

    }

    @Override
    public ActionMap updateValidActions() {
        return null;
    }
}
