package entities;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {
    Entity eventMaster;

    public NPC_OldMan(GamePanel gp){
  
        super(gp);
        type = 1;
        direction = "up";
        speed = 1;

        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;
        
        dialogueSet = -1;
        getImage();
        setDialogue();

    }
    public void getImage(){

        up0 = setUp("npc/oldman_up_1",gp.tileSize, gp.tileSize);
        up1 = setUp("npc/oldman_up_2",gp.tileSize, gp.tileSize);

        down0 = setUp("npc/oldman_down_1",gp.tileSize, gp.tileSize);
        down1 = setUp("npc/oldman_down_2",gp.tileSize, gp.tileSize);

        left0 = setUp("npc/oldman_left_1",gp.tileSize, gp.tileSize);
        left1 = setUp("npc/oldman_left_2",gp.tileSize, gp.tileSize);

        right0 = setUp("npc/oldman_right_1",gp.tileSize, gp.tileSize);
        right1 = setUp("npc/oldman_right_2",gp.tileSize, gp.tileSize);

    }
    
    public void setDialogue() {
        dialogues[0][0] = "Hello, traveler! Welcome to nowhere!";
        dialogues[0][1] = "Sadly, it's nowhere. There is nothing to do";
        dialogues[0][2] = "Oh I know what to do, I'll follow you";
        dialogues[0][3] = "You can run but you can't hide, you can never hide...";
        dialogues[1][0] = " Hello world!";
        dialogues[1][1] = " No code no life";

    }
    public void setAction() {
        if (onPath == true) {
            int goalCol = (gp.player.worldX + gp.player.solidArea.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y) / gp.tileSize;
            //int goalCol = 20;
            //int goalRow = 25;
            searchPath(goalCol,goalRow);
        }
        else {
            actionLockCounter++;
            
            if(actionLockCounter == 120){
                Random random = new Random();
                int i = random.nextInt(100)+1; //Random from 1 to 100

                if(i<=25){
                    direction = "up";
                }
                if(i>25 && i<= 50){
                    direction = "down";
                }
                if(i>50 && i<=75){
                    direction = "left";
                }
                if(i>75 && i<=100){
                    direction = "right";
                }

                actionLockCounter = 0;
            } 
        }
        
    }
    public void speak() {
        facePlayer();
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if (dialogues[dialogueSet][0] == null ) {
            dialogueSet--;
        }
    }
   
}

