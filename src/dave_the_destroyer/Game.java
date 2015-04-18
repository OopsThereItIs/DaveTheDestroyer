package dave_the_destroyer;


import dave_the_destroyer.model.*;
import dave_the_destroyer.model.menu.AvatarCreationMenu;
import dave_the_destroyer.model.menu.GameMenu;
import dave_the_destroyer.model.menu.MainMenu;
import dave_the_destroyer.model.Map;
import dave_the_destroyer.view.MapView;
import dave_the_destroyer.view.menu_view.MenuView;

import javax.swing.*;

public class Game {

    MainModel model;
    JFrame frame;
    JComponent view;
    ActionMap actionMap;
    ComponentInputMap inputMap;


    public Game (){
        initialize();
        initializeActions();
        updateView();
        configureJFrame();

    }



    private void initialize(){
        setFrame(new JFrame("Dave The Destroyer"));
        setActionMap(new ActionMap());
    }

    private void initializeActions(){
        inputMap.put(KeyStroke.getKeyStroke("W"), "N");
        inputMap.put(KeyStroke.getKeyStroke("X"), "S");
        inputMap.put(KeyStroke.getKeyStroke("S"), "select");
        actionMap = model.updateValidActions();

    }

    private void updateView(){
        view.setActionMap(actionMap);
        view.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
    }


    public void start(){ //main Game loop
        MainMenu m = new MainMenu( this );
        updateModel(m);

        Boolean running = true;
        while (running) {
            view.repaint();
            try {
                Thread.sleep(60);
            } catch ( InterruptedException e){
                running = false;

            }
        }
    }

    public void newGame(){
        AvatarCreationMenu m = new AvatarCreationMenu( this );
        updateModel(m);
        initializeActions();
        updateView();


    }

    public void loadGame(){
        AvatarCreationMenu m = new AvatarCreationMenu( this );
        updateModel( m );
        initializeActions();
        updateView();
    }

    public void updateModel( Map m){
        setModel(m);
        updateView( m );
    }

    public void updateModel( GameMenu m){

        updateView( m );

    }

    private void updateView( GameMenu m){
        setModel( m );
        setView( new MenuView( m ) );
    }

    private void updateView( Map m){
        setModel( m );
        setView( new MapView( m ) );
    }


    private void configureJFrame() {
        frame.add(view);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setModel(MainModel model) {
        this.model = model;
    }

    private void setView(JComponent view) {
        this.view = view;
        updateFrame( view );
    }

    private void updateFrame(JComponent j){
        if (view != null)
            frame.remove(view);
        frame.add(view);
        frame.revalidate();
    }

    private void setActionMap(ActionMap actionMap) {
        this.actionMap = actionMap;
    }

    private void setInputMap(ComponentInputMap inputMap) {
        this.inputMap = inputMap;
    }

    private void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
