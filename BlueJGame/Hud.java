import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;

public class Hud {
    private int munition, health;

    Image img1 = Toolkit.getDefaultToolkit().getImage("Heart.png");
    Image img2 = Toolkit.getDefaultToolkit().getImage("Muni.png");
    Image img3 = Toolkit.getDefaultToolkit().getImage("Cross.png");
    Image img4 = Toolkit.getDefaultToolkit().getImage("Heart2.png");
    Image img5 = Toolkit.getDefaultToolkit().getImage("Gun.png");
    Image img6 = Toolkit.getDefaultToolkit().getImage("MachineGun.png");
    public void draw(Graphics2D g2d, Player player) {
        if (player.weaponType == 1) {
            munition = MachineGun.magazine;
            g2d.drawImage(img6, 135, 275, null);
        } else if (player.weaponType == 2) {
            munition = Rifle.magazine;
            g2d.drawImage(img5, 135, 400, null);
        }    
            
            health = Player.health;
            int j = 0;
            int k = 0;
            for (int i = 0; i < health; i++) {
                g2d.drawImage(img1, 620 + 25 * i, 790, null);
            }
            for (int i = 0; i < 10; i++) {
                g2d.drawImage(img4, 620 + 25 * i, 790, null);
            }
            for (int i = 0; i < munition; i++) {
                if (i < 10) {
                    k = i;
                } else if (i >= 10 && i < 20) {
                    j = 10;
                    k = i - 10;
                } else if (i >= 20) {
                    j = 20;
                    k = i - 20;

                }

                g2d.drawImage(img2, 50 + 15 * k, 800 + j, null);

            }
            g2d.drawImage(img3, 405, 430, null);
            
        }
    }


