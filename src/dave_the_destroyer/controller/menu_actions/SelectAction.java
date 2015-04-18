package dave_the_destroyer.controller.menu_actions;

import dave_the_destroyer.controller.GameAction;
import dave_the_destroyer.model.menu.GameMenu;

import java.awt.event.ActionEvent;

public class SelectAction extends GameAction{

    GameMenu gameMenu;

    public SelectAction(GameMenu m) {
        gameMenu = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("select action");
        gameMenu.select();
    }
}
