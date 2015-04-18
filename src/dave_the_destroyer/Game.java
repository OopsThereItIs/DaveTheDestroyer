package dave_the_destroyer;


import dave_the_destroyer.controller.menu_actions.DownAction;
import dave_the_destroyer.controller.menu_actions.UpAction;
import dave_the_destroyer.model.*;
import dave_the_destroyer.model.menu.GameMenu;
import dave_the_destroyer.model.menu.MainMenu;
import dave_the_destroyer.model.menu.Map;
import dave_the_destroyer.view.MapView;
import dave_the_destroyer.view.menu_view.MenuView;

import javax.swing.*;

public class Game {

    MainModel model;
    JComponent view;
    ActionMap actionMap;
    ComponentInputMap inputMap;
    JFrame frame;

    public Game (){
        initialize();
        initializeActions();
        updateModel();
        updateView();
        configureJFrame();

    }

    private void initialize(){
        frame = new JFrame("Dave The Destroyer");
        actionMap = new ActionMap();
        inputMap = new ComponentInputMap(view);
    }

    private void initializeActions(){
        inputMap.put(KeyStroke.getKeyStroke("W"), "N");
        inputMap.put(KeyStroke.getKeyStroke("X"), "S");
        inputMap.put(KeyStroke.getKeyStroke("Q"), "NW");
        inputMap.put(KeyStroke.getKeyStroke("E"), "NE");
        inputMap.put(KeyStroke.getKeyStroke("Z"), "SW");
        inputMap.put(KeyStroke.getKeyStroke("V"), "SE");
        inputMap.put(KeyStroke.getKeyStroke("S"), "select");
        actionMap = model.updateValidActions();

    }

    private void updateView(){
        view.setActionMap(actionMap);
        view.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
    }

    public  void updateModel(){
        updateModel( new MainMenu( this ));
    }

    public void updateModel( Map m){
        model = m;
        if (view != null)
            frame.remove(view);
        view  = new MapView( m );
        frame.add(view);
        frame.revalidate();
    }

    public void updateModel( GameMenu m){
        model = m;
        if (view != null)
            frame.remove(view);
        view = new MenuView( m );
        frame.add(view);
        frame.revalidate();



    }

    private void configureJFrame() {

        frame.add(view);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void start(){ //main dave_the_destroyer.Game loop
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
}
