import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Everything the player can see extends from this
public abstract class Boundary {
    
    public int x1, y1, x2, y2;
    
    public Boundary(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public abstract void draw(Graphics2D g2d);
    public abstract void isHitByRay();
    
}
