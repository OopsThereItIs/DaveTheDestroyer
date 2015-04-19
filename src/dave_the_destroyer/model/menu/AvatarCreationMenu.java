package dave_the_destroyer.model.menu;

import dave_the_destroyer.Game;
import dave_the_destroyer.model.Map;


public class AvatarCreationMenu extends GameMenu {

    String[] options;

    public AvatarCreationMenu(Game g){
        super(g);
        options = new String[]{ "Start Game", "Back"};
        super.setOptions(options);

    }

    @Override
    public void select() {

        switch(getSelectedIndex()){
            case 0:

                break;
            case 1:
                getGame().mainMenu();
                break;
        }
    }
}
