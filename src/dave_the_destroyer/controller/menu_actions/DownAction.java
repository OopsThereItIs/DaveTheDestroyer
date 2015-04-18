package dave_the_destroyer.controller.menu_actions;

import dave_the_destroyer.controller.GameAction;
import dave_the_destroyer.model.menu.GameMenu;

import java.awt.event.ActionEvent;

public class DownAction extends GameAction{
    GameMenu gameMenu;

    public DownAction(GameMenu m) {
        gameMenu = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("down action");
        gameMenu.down();
    }
}
