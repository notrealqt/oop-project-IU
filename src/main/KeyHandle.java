package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandle implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed,rightPressed,interPressed,enterPressed;
    //Debug
    boolean checkDrawtime = false;

   

    // Constructor to initialize the boolean variables
    public KeyHandle(GamePanel gp) {
        this.gp = gp;
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("Key pressed: " + code);

        //Title state
        if(gp.gameState == gp.titleState) {
            titleState(code);
        }

        //Play state
        else if(gp.gameState == gp.playState) { //stop player swing when start the game with "else"
            playState(code);
        } 
        
        //Pause state
        else if (gp.gameState == gp.pauseState) {
            pauseState(code);
        }

        //Dialogue state
        else if(gp.gameState == gp.dialogueState) {
            dialogueState(code);
        }

        //Character State
        else if(gp.gameState ==gp.characterState){
            characterState(code);
        }

        //Menu state
        else if(gp.gameState == gp.optionState) {
            menuState(code);
        }
    }

    public void titleState(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(1);
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                gp.playSE(1);
                if(gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1) {
                    //Add later
                }
                if(gp.ui.commandNum == 2) {
                    //Add later
                }
                if(gp.ui.commandNum == 3) {
                    System.exit(0);
                }
            }
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W) {
            upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_C){
                gp.gameState = gp.characterState;
            }
            if (code == KeyEvent.VK_F) {
                interPressed = true;
            }
            // Menu
              if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState= gp.optionState;
            }

            //Debug
            if (code == KeyEvent.VK_T) {
                if(checkDrawtime == false){
                    checkDrawtime = true;
                }
                else if(checkDrawtime == true){
                    checkDrawtime = false;
                }
            }
    }
    public void pauseState(int code){
        if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
    }
    public void dialogueState(int code){
        if(code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
    }
    public void characterState(int code){
        if(code == KeyEvent.VK_C) {
                gp.gameState = gp.playState;
            }
    }
    public void menuState(int code){
                    if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }

            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            int maxCommandNum = 0;
            switch(gp.ui.SubState){
                case 0: maxCommandNum = 4; break;
                case 2: maxCommandNum = 2; break;
                case 4: maxCommandNum = 1;break;
                case 5: maxCommandNum = 1;break;
            }

             if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(1);
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = maxCommandNum;
                }
                
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                gp.playSE(1);
                if(gp.ui.commandNum > maxCommandNum ) {
                    gp.ui.commandNum = 0;
                }
               
            }
            if (code == KeyEvent.VK_A){
                if(gp.ui.SubState == 2){
                    if(gp.ui.commandNum == 0 && gp.music.volumeScale > 0){
                        gp.music.volumeScale--;
                        gp.music.CheckVolume();
                        gp.playSE(1);
                    }
                     if(gp.ui.commandNum == 1 && gp.se.volumeScale > 0){
                        gp.se.volumeScale--;
                        gp.playSE(1);
                    }
                }
            }
            if (code == KeyEvent.VK_D){
                if(gp.ui.SubState == 2){
                    if(gp.ui.commandNum == 0 && gp.music.volumeScale < 5){
                        gp.music.volumeScale++;
                        gp.music.CheckVolume();
                        gp.playSE(1);
                    }
                    if(gp.ui.commandNum == 1 && gp.se.volumeScale < 5){
                        gp.se.volumeScale++;
                        gp.playSE(1);
                    }
                }
            }
    }
    @Override
    public void keyReleased (KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("Key released: " + code);

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
