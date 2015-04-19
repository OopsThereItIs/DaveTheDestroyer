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

    private MainModel model;
    private JFrame frame;
    private JComponent view;


    public Game (){
        configureJFrame(new JFrame("Dave The Destroyer"));
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

    public void loadGame(){
        // TODO
    }

    public void settings(){
        // TODO
    }

    public void pauseGame(){
        // TODO
    }


    private ComponentInputMap loadInputMap( JComponent view ){
        ComponentInputMap inputMap =  null; //will be changed to try loading saved input map
        if ( inputMap == null ) {
            inputMap =  new ComponentInputMap( view );
            inputMap.put(KeyStroke.getKeyStroke("W"), "N");
            inputMap.put(KeyStroke.getKeyStroke("X"), "S");
            inputMap.put(KeyStroke.getKeyStroke("S"), "select");
        }
        return inputMap;
    }

    private void update(){
        view.setActionMap( model.updateValidActions() );
    }

    private void render(){
        frame.repaint();
    }


    private void updateView( GameMenu m){
        setModel( m );
        setView(new MenuView( m ));
    }

    private void updateView( Map m){
        setModel( m );
        setView( new MapView( m ) );
    }


    private void configureJFrame(JFrame f) {
        setFrame( f );
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setModel(MainModel model) {
        this.model = model;
    }

    private void setView(JComponent v) {
        if (view != null)
            frame.remove(view);
        this.view = v;
        view.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, loadInputMap( v ));
        frame.add(view);
        frame.revalidate();
        System.out.println("New Game");
    }

    private void updateFrame(){


    }

    private void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
