package entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandle;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandle keyH;

    public Player(GamePanel gp, KeyHandle keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        x= 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            //idle animation
            idleUp = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_back_0.png"));
            idleDown = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_font_0.png"));
            idleRight = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_right_0.png"));
            idleLeft = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_left_0.png")); 

            //up
            up0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_8.png"));
            up9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_9.png"));

            //down
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_8.png"));
            down9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_9.png"));

            //left
            left0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_0.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_8.png"));
            left9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_9.png"));

            //right
            right0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_8.png"));
            right9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_9.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        //System.out.println("Update method called");
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
            //System.out.println("Up pressed: " + playerX + ", " + playerY);
            }
            else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
                //System.out.println("Down pressed: " + playerX + ", " + playerY);

            }
            else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
                //System.out.println("Left pressed: " + playerX + ", " + playerY);

            }
            else if ( keyH.rightPressed == true) {
                direction = "right";
                x+= speed;
                //System.out.println("Right pressed: " + playerX + ", " + playerY);
            }

            //player image changes every 6 frames
            spriteCounter++;
            if (spriteCounter >  6) {
                if (spriteNum == 0) {
                    spriteNum =1;
                }
                else if (spriteNum == 1) {
                    spriteNum =2;
                }
                else if (spriteNum == 2) {
                    spriteNum =3;
                }
                else if (spriteNum == 3) {
                    spriteNum =4;
                }
                else if (spriteNum == 4) {
                    spriteNum =5;
                }
                else if (spriteNum == 5) {
                    spriteNum =6;
                }
                else if (spriteNum == 6) {
                    spriteNum =7;
                }
                else if (spriteNum == 7) {
                    spriteNum =8;
                }
                else if (spriteNum == 8) {
                    spriteNum =9;
                }
                else if (spriteNum == 9) {
                    spriteNum =0;
                }
                spriteCounter =0;
            }
        } 
     

        
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white); // set color to use for drawing objects
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            switch (direction) {
                case "up":
                    if (spriteNum == 0) {
                        image = up0;
                    }
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    if (spriteNum == 3) {
                        image = up3;
                    }
                    if (spriteNum == 4) {
                        image = up4;
                    }
                    if (spriteNum == 5) {
                        image = up5;
                    }
                    if (spriteNum == 6) {
                        image = up6;
                    }
                    if (spriteNum == 7) {
                        image = up7;
                    }
                    if (spriteNum == 8) {
                        image = up8;
                    }
                    if (spriteNum == 9) {
                        image = up9;
                    }
                    break;
                case "down":
                    if (spriteNum == 0) {
                        image = down0;
                    }
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                    if (spriteNum == 5) {
                        image = down5;
                    }
                    if (spriteNum == 6) {
                        image = down6;
                    }
                    if (spriteNum == 7) {
                        image = down7;
                    }
                    if (spriteNum == 8) {
                        image = down8;
                    }
                    if (spriteNum == 9) {
                        image = down9;
                    }
                    break;
                case "left":
                    if (spriteNum == 0) {
                        image = left0;
                    }
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                    if (spriteNum == 5) {
                        image = left5;
                    }
                    if (spriteNum == 6) {
                        image = left6;
                    }
                    if (spriteNum == 7) {
                        image = left7;
                    }
                    if (spriteNum == 8) {
                        image = left8;
                    }
                    if (spriteNum == 9) {
                        image = left9;
                    }
                    break;
                case "right":
                    if (spriteNum == 0) {
                        image = right0;
                    }
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                    if (spriteNum == 5) {
                        image = right5;
                    }
                    if (spriteNum == 6) {
                        image = right6;
                    }
                    if (spriteNum == 7) {
                        image = right7;
                    }
                    if (spriteNum == 8) {
                        image = right8;
                    }
                    if (spriteNum == 9) {
                        image = right9;
                    }
                    break;
            }
        }
        else {
            // Character is idle
            switch (direction) {
                case "up":
                    image = idleUp;
                    break;
                case "down":
                    image = idleDown;
                    break;
                case "left":
                    image = idleLeft;
                    break;
                case "right":
                    image = idleRight;
                    break;
        }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
