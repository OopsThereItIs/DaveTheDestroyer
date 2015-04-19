package dave_the_destroyer;


import dave_the_destroyer.model.MainModel;
import dave_the_destroyer.model.map.Map;
import dave_the_destroyer.model.menu.AvatarCreationMenu;
import dave_the_destroyer.model.menu.GameMenu;
import dave_the_destroyer.model.menu.MainMenu;
import dave_the_destroyer.util.Loader;
import dave_the_destroyer.view.MapView;
import dave_the_destroyer.view.menu_view.MenuView;

import javax.swing.*;

public class Game {

    private MainModel model;
    private JFrame frame;
    private JComponent view;


    public Game (){
        initializeJFrame(new JFrame("Dave The Destroyer"));
        initializeLoaderAndSaver();
    }

    public void start(){ //main Game loop
        mainMenu();
        Boolean running = true;
        while (running) {
            update();
            render();
            try {
                Thread.sleep(60);
            } catch ( InterruptedException e){
                running = false;

            }
        }
    }

    public void mainMenu(){
        MainMenu m = new MainMenu( this );
        updateView( m );
    }

    public void newGame(){
        AvatarCreationMenu m = new AvatarCreationMenu( this );
        updateView( m );

    }
    public void startGame(){
        Map m = new Map( this );
        updateView( m );
    }

    public void pauseGame(){
        // TODO
    }

    public void loadGame(){
        // TODO
    }

    public void saveGame(){
        // TODO
    }

    public void controls(){
        // TODO
    }


    private ComponentInputMap loadInputMap( JComponent view ){



        return loader.load;
    }

    private void update(){
        view.setActionMap( model.updateValidActions() );
    }

    private void render(){
        frame.repaint();
    }


    private void updateView( GameMenu m){
        setModel( m );
        setView(new MenuView(m));
    }

    private void updateView( Map m){
        setModel(m);
        setView(new MapView(m));
    }





    private void setView(JComponent v) {
        if (view != null)
            frame.remove(view);
        this.view = v;
        view.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, loadInputMap(v));
        frame.add(view);
        frame.revalidate();
    }

    private void setModel(MainModel model) {
        this.model = model;
    }
    private void initializeLoaderAndSaver(){
        loader = new Loader()[]
    }

    private void initializeJFrame(JFrame f) {
        this.frame = frame;
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
