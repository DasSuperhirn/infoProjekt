import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ray {

    float x, y;
    double direction;
    KeyHandler keyH = new KeyHandler();
    
    public Ray(float x, float y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public void update(float x, float y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public float[] cast(Boundary[] boundaries, Graphics2D g2d, boolean drawRay) {
        float[] allResults = new float[4];
        float distance = 1000;

        allResults[0] = -1;
        allResults[1] = -1;
        allResults[2] = -1;
        allResults[3] = -1;
        

        float closestDistance = distance;

        for(int i = 0; i < boundaries.length; i++){
            if(boundaries[i] != null){
                float x1 = boundaries[i].x1;
                float y1 = boundaries[i].y1;
                float x2 = boundaries[i].x2;
                float y2 = boundaries[i].y2;
                float x3 = x;
                float y3 = y;
                float x4 = x + (float)Math.cos(direction) * distance*-1;
                float y4 = y + (float)Math.sin(direction) * distance*-1;

                //Explain: http://stackoverflow.com/questions/563198/how-do-you-detect-where-two-line-segments-intersect
                float denom = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
                float t = ((x1-x3)*(y3-y4) - (y1-y3)*(x3-x4)) / denom;
                float u = ((x1-x2)*(y1-y3) - (y1-y2)*(x1-x3)) / denom;

                if(t > 0 && t < 1 && u > 0){
                    float ix = x1 + t*(x2-x1);
                    float iy = y1 + t*(y2-y1);
                    float distanceToWall = (float)Math.abs((ix-x)/Math.cos(direction));
                    if(distanceToWall < closestDistance){
                        allResults[0] = distanceToWall;
                        allResults[1] = ix;
                        allResults[2] = iy;
                        allResults[3] = i;
                        closestDistance = distanceToWall;
                    }            
                }
            }
        }

        //draw the ray in minimap form
        g2d.setPaint(Color.WHITE);
            if(drawRay){
                if(closestDistance != distance){
                    g2d.drawLine((int)x/6, (int)y/6, (int)allResults[1]/6, (int)allResults[2]/6);
                }
                else{
                    g2d.drawLine((int)x/6, (int)y/6, (int) ((int)x + (float)Math.cos(direction) * distance)/6, (int) ((int)y + (float)Math.sin(direction) * distance)/6);
                }
            }

        //allResults[0] = result;

        return allResults;
    }

}
