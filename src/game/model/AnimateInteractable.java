package game.model;

import game.model.entity.Avatar;
import game.model.entity.Entity;
import game.model.entity.Mount;
import game.model.item.MapItem;

public interface AnimateInteractable{
    String interactWith( AnimateInteractable i);
    String interactWith( InanimateInteractable i);
    String interactWith( Entity e);
    String interactWith( Avatar a);
    String interactWith( Mount m);
    String interactWith( MapItem i);
}
