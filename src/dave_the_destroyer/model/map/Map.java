package dave_the_destroyer.model.map;

import dave_the_destroyer.Game;
import dave_the_destroyer.model.MainModel;
import dave_the_destroyer.model.entity.Entity;

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
