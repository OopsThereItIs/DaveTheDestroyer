package dave_the_destroyer.view;


import dave_the_destroyer.model.Map;

import javax.swing.*;
import java.awt.*;

public class MapView  extends JComponent {
    Map map;

    public MapView (Map m){
        map = m;
    }

    @Override
    public void paint( Graphics g){


        super.paint(g);

        drawBackground(g);

        int w = getWidth()/2;
        int h = getHeight()/2;

        drawHexagon(g, w, h, 30);

    }

    private void drawBackground( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

    }

    public void drawHexagon( Graphics g, int x, int y, int r){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.WHITE);
        g2d.fillRect(x, y, 160, 40);

        Polygon polygon = new Polygon();

        for(int i=0; i<6; i++) {
            polygon.addPoint(
                    (int)( x + r * Math.cos(2 * Math.PI/6)),
                    (int)( y + r * Math.sin(2 * Math.PI/6))
            );
        }
        g.setColor( Color.GREEN );
        g2d.drawPolygon(polygon);
        g.setColor( Color.GREEN );
        g2d.fillPolygon(polygon);
    }
}
