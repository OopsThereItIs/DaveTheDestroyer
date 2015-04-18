package dave_the_destroyer.controller.menu_actions;

import dave_the_destroyer.controller.GameAction;
import dave_the_destroyer.model.menu.GameMenu;

import java.awt.event.ActionEvent;


public class UpAction extends GameAction {
    GameMenu gameMenu;

    public UpAction(GameMenu m) {
        gameMenu = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("up action");
        gameMenu.up();
    }
}
