package dave_the_destroyer.model.menu;

import dave_the_destroyer.Game;
import dave_the_destroyer.model.Map;

public class MainMenu extends GameMenu {

    String[] options;

    public MainMenu(Game g){
        super(g);
        options = new String[]{ "New Game", "Load Game", "Settings"};
        super.setOptions(options);

    }

    @Override
    public void select() {

        switch(getSelectedIndex()){
            case 0:
                getGame().updateModel( new Map( getGame() ));
                break;
            case 1:

                break;
            case 2:

                break;
        }
    }
}
