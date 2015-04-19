package dave_the_destroyer.util;

import javax.swing.*;

public class Loader {

    public Loader(){

    }
    public ComponentInputMap loadDefaultMenuInputMap(JComponent view ){
        ComponentInputMap inputMap = new ComponentInputMap( view );
        inputMap.put(KeyStroke.getKeyStroke("W"), "N");
        inputMap.put(KeyStroke.getKeyStroke("X"), "S");
        inputMap.put(KeyStroke.getKeyStroke("S"), "select");
        return inputMap;
    }
}
