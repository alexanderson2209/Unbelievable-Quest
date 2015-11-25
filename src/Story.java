import java.util.Scanner;

public class Story {

   static int textSpeed = 4000;
   static Scanner input = new Scanner(System.in);
   static Player player1 = new Player();
   static int gameOverCounter = -1;
   
   public static void main(String[] args) {
      //if GameOver, User can choose whether to restart the mainMethodLoop() or not
      //see mainMethodLoop() for main method
      int controlMainMethodLoop = 1;
      while (controlMainMethodLoop == 1) {
         controlMainMethodLoop = mainMethodLoop();
      }
      System.out.println("Credits for ascii art goes to: RetroJunkie.com's Zeus and RetroJunkies.com's NDT.");
   }
   
   //Way to implement restart of Main Method if GAME OVER
   public static int mainMethodLoop() {
      String characterName;
      
      //Start Screen
      gameOverCounter++;
      player1.resetHealth();
      player1.resetMana();
      player1.setIsDeadToFalse();
      gameLogo();
      System.out.println();
      if (gameOverCounter == 0)
         startOrOptions();
          
      introductionPart1();
            
      if (gameOverCounter == 0) {
         System.out.println("\nHe blankly stares at you and asks for your name.");
         delayPrint(textSpeed);
         System.out.print("Enter character name: ");
         characterName = input.next();
         player1.setName(characterName);
         introductionPart2();
      }
      else {
         System.out.println("You find that all the traps have been reset.");
         delayPrint(textSpeed);
         System.out.println("It is like your last time through had never happened.");
         delayPrint(textSpeed);
         System.out.println("The door is still locked.");
         delayPrint(textSpeed);
      }
                  

      firstRiddle();
      EnemyFighter[] enemies = new EnemyFighter[3];
      enemies[0] = new EnemyFighter("Orc", 3);
      enemies[1] = new EnemyFighter("Giant spider", 4);
      enemies[2] = new EnemyFighter("Alfred the Unbelievable", 1);
      
      //first battle with Orcegg
      Battle battle1 = new Battle(player1, enemies[0]);      
      player1 = battle1.engage();
      if (player1.getIsDead()) {
         return gameOver();
      }
      
      secondRiddle();
      if (player1.getIsDead()) {
         return gameOver();
      }
      
      //second battle with Giant Spider
      Battle battle2 = new Battle(player1, enemies[1]);
      player1 = battle2.engage();
      if (player1.getIsDead()) {
         return gameOver();
      }
      
      thirdRiddle();
      if (player1.getIsDead()) {
         return gameOver();
      }
      
      //third battle with Alfred the Unbelievable
      Battle battle3 = new Battle(player1, enemies[2]);
      player1 = battle3.engage();
      if (player1.getIsDead()) {
         return gameOver();
      }
      
      endingToGame();
      System.exit(0);
      return 0;
   }

   public static void gameLogo() {
      System.out.println(" _   _         _            _  _                      _      _         _____                    _    _ ");
      System.out.println("| | | |       | |          | |(_)                    | |    | |       |  _  |                  | |  | |");
      System.out.println("| | | | _ __  | |__    ___ | | _   ___ __   __  __ _ | |__  | |  ___  | | | | _   _   ___  ___ | |_ | |");
      System.out.println("| | | || '_ \\ | '_ \\  / _ \\| || | / _ \\\\ \\ / / / _` || '_ \\ | | / _ \\ | | | || | | | / _ \\/ __|| __|| |");
      System.out.println("| |_| || | | || |_) ||  __/| || ||  __/ \\ V / | (_| || |_) || ||  __/ \\ \\/' /| |_| ||  __/\\__ \\| |_ |_|");
      System.out.println(" \\___/ |_| |_||_.__/  \\___||_||_| \\___|  \\_/   \\__,_||_.__/ |_| \\___|  \\_/\\_\\ \\__,_| \\___||___/ \\__|(_)");
   }
   
   //Method that starts the game or sets text speed
   public static void startOrOptions() {
      
      String optionChoice;
         do {
            System.out.println("Type \"Start\" to start the game. Type \"Options\" to select text speed");
            optionChoice = input.nextLine();
            if (optionChoice.equalsIgnoreCase("options")) {
               System.out.print("Please select text speed.(Measured in Miliseconds): ");
               textSpeed = input.nextInt();
            }
            if (!optionChoice.equalsIgnoreCase("options") && !optionChoice.equalsIgnoreCase("start"))
               System.out.println("Please enter a valid choice\n");
         } while (!optionChoice.equalsIgnoreCase("options") && !optionChoice.equalsIgnoreCase("start"));
   }
   
   //intro part 1
   public static void introductionPart1() {
      if (gameOverCounter == 0) {
         System.out.println("\nYou wake to find the past 24 hours of your life have vanished from your memory.");
         delayPrint(textSpeed);
         System.out.println("The last thing that you remember is that you were walking with your love, the princess,");
         delayPrint(textSpeed);
         System.out.println("through The Forest of Unimaginable Torment and Overall Scariness.");
         delayPrint(textSpeed);
         System.out.println("It seemed like a good idea at the time to be waltzing through that specific part of the world.");
         delayPrint(textSpeed);
         System.out.println("You remember being ambushed by something dark and twisted and falling unconscious. ");
         delayPrint(textSpeed);
         System.out.println("Not really surprising considering you were walking through The Forest of Unimaginable Torment and Overall Scariness.");
         delayPrint(textSpeed);
         System.out.println();
         
         delayPrint(textSpeed + 1000);
         
         System.out.println("\"What a great way to spend your birthday\" you sarcastically mutter.");
         delayPrint(textSpeed);
         System.out.println("You look around and it appears that you are in some sort of cell.");
         delayPrint(textSpeed);
         System.out.println("No shackles or anything of that sort, just metal bars and a nice heavy door preventing you from freedom.");
         delayPrint(textSpeed);
         System.out.println("You see an old man laying beside you, his life appears to be trickling away.");
         delayPrint(textSpeed);
         System.out.println("He appears to have several deep gaping wounds.");
         delayPrint(textSpeed);
         System.out.println("After you finish vomiting, you ask if the man needs any assistance.");
         delayPrint(textSpeed);
      }
      else {
         System.out.println("You awaken to find you are not really dead.");
         delayPrint(textSpeed);
         System.out.println("The spirit of Monte-Hew Kingsbury has saved your soul.");
         delayPrint(textSpeed);
         System.out.println("It is tragic that he is dead, but at least he was of some use to you...");
         delayPrint(textSpeed);
      }
   }
   
   //intro part 2
   public static void introductionPart2() {
      delayPrint(textSpeed);
      System.out.println("You ask him again if he needs any assistance.\n");
      System.out.println("The man lets some words spill out of his mouth. \"My name is Monte-Hew Kingsbury.\"\n");
      delayPrint(textSpeed);
      System.out.println("You are worried about this man, but he seems fairly unconcerned with his present condition.\n");
      delayPrint(textSpeed);
      System.out.println("You ask him what this place is called. He whispers \"It is called a dungeon my dear child.\"\n");
      delayPrint(textSpeed);
      System.out.println("\"There is something that you must do to save the princess.\"\n");
      delayPrint(textSpeed);
      System.out.println("You ask \"How did you know that I was looking for a princess?\"\n");
      delayPrint(textSpeed);
      System.out.println("The old man simply shrugs.\n");
      delayPrint(textSpeed);
      System.out.println("\"This is a dangerous place\", the man mutters.\n");
      delayPrint(textSpeed);
      System.out.println("\"This is a test of your abilities\"\n");
      delayPrint(textSpeed);
      System.out.println("\"In order to save her, you must fight your way through a few enemies and a couple of puzzles.\"\n");
      delayPrint(textSpeed);
      System.out.println("\"Well that doesn't seem so hard\" You cheerfully reply.\n");
      delayPrint(textSpeed);
      System.out.println("\"Oh no, its incredibly dangerous. You are probably going to die.\" mumbled Monte-Hew.\n");
      delayPrint(textSpeed);
      System.out.println("\"Comforting...Just tell me how to get out of here.\" you sarcastically reply.\n");
      delayPrint(textSpeed);
      System.out.println("Monte-Hew Kingsbury points to the locked door of the cell.\n");
      delayPrint(textSpeed);
      System.out.println("You ask Monte-Hew \"Any idea where the key is at?\"\n");
      delayPrint(textSpeed);
      System.out.println("No answer. Monte-Hew is dead.\n");
      delayPrint(textSpeed); 
      System.out.println("Your quest begins here.");
      delayPrint(textSpeed);
   }
   
   public static void firstRiddle() {
      int choice;
      do {
         System.out.println("\nYou need to find a key to unlock the cell. there are four places where the key could be hidden. Choose a hiding place.");
         System.out.println("1. Under the dead man.\n2. In the dead man's pockets.\n3. In the cell door's keyhole.\n4. In your own pockets.\n");
         System.out.print("Your choice: ");
         choice = input.nextInt();
         switch (choice) {
            case 1:  System.out.println("There is nothing there. Choose again.");
                     delayPrint(textSpeed);
                     break;
            case 2:  System.out.println("Eureka! You have found 15 keys in the mans pocket.\n"
                        + "But alas, you try all of them and they all fail to open the door.\n"
                        + "choose again.");
                     delayPrint(textSpeed);
                     break;
            case 3:  System.out.println("To your astonishment, it is right there in the keyhole.");
                     delayPrint(textSpeed);
                     break;
            case 4:  System.out.println("Why would the key be in your own pockets? choose again.");
                     delayPrint(textSpeed);
                     break;
            default: System.out.println("Incorrect answer. Choose again.");
                     delayPrint(textSpeed);
                     break;
         }
      } while (choice != 3);
      
      System.out.println("You open the door to find an orc standing guard just outside the door.");
      delayPrint(textSpeed);
      System.out.println("You come from behind and attack him!");  
      delayPrint(textSpeed);
   }
   
   public static void secondRiddle() {
      System.out.println("In the middle of this room is a masked man standing on a pedestal."); 
      delayPrint(textSpeed);
      System.out.println("On one side of the room there is a door. On the other side, also a door.\n");
      delayPrint(textSpeed);
      System.out.println("He screams \"My name is Alfred the Unbelievable.\"");
      delayPrint(textSpeed);
      System.out.println("\"If you solve my riddle correctly, I will tell you which door won't kill you.\"\n");
      delayPrint(textSpeed);
      
      System.out.println("You throw away the outside and cook the inside.\n"
         + "Then you eat the outside and throw away the inside. What did you eat?");

         System.out.println("Enter an answer...");
         String answerToRiddle2 = input.next();
         if (answerToRiddle2.equalsIgnoreCase("chicken") || answerToRiddle2.equalsIgnoreCase("a chicken") || 
               answerToRiddle2.equalsIgnoreCase("corn") || answerToRiddle2.equalsIgnoreCase("an ear of corn") ||
               answerToRiddle2.equalsIgnoreCase("ear of corn")) {
            System.out.println("The door to your left is your path to freeing the princess.");
            delayPrint(textSpeed);
            System.out.println("Thank you for playing. Hurry before I eat your soul.\n");
            delayPrint(textSpeed);
            
            System.out.println("You scamper through the door to your left feeling quite pleased with yourself.");
            delayPrint(textSpeed);
            System.out.println("You are so happy that you solved the riddle. Then you run into a HUGE spider, like way huge dude!");
            delayPrint(textSpeed);
            System.out.println("You scream \" I will smite thee, heathen of the night!\"");
            delayPrint(textSpeed);
         }
         else {
            System.out.println("The door to your right is your path to freeing the princess.");
            delayPrint(textSpeed);
            System.out.println("Thank you for playing. Hurry before I eat your soul.\n");
            delayPrint(textSpeed);
            
            System.out.println("You open the door and fall perilously into the abyss below.");
            delayPrint(textSpeed);
            System.out.println("Your screams grow fainter and fainter the further down you fall.");
            delayPrint(textSpeed);
            System.out.println("Some say in that dungeon, faint screams can still be heard of our young hero.");
            delayPrint(textSpeed);
            player1.setIsDeadToTrue();
         }
            
   }
   
   public static void thirdRiddle() {
      System.out.println("Suddenly, Alfred the Unbelievable explodes his way out of the spiders abdomen!\n");
      delayPrint(textSpeed);
      System.out.println("Unbelievable!!\n");
      delayPrint(textSpeed);
      System.out.println("When you wake up, you find Alfred hovering over you, literally 1 inch from your face.");
      delayPrint(textSpeed);
      System.out.println("Your head is still swooning from being scared unconscious by Alfred the Unbelievable.");
      delayPrint(textSpeed);
      System.out.println("He screeches \"hello again my friend, would you like to solve another riddle?");
      delayPrint(textSpeed);
      System.out.println("If you choose correctly, I will escort you to the princess!\"");
      delayPrint(textSpeed);
      System.out.println("\"I guess... if I must\" you say with as little enthusiasm as possible\n");
      delayPrint(textSpeed);
      
      System.out.println("\"Pronounced as one letter but written with three, only two different letters are used to make me.");
      delayPrint(textSpeed);
      System.out.println("I'm double, I'm single I'm black, blue, and gray. I'm read from both ends and the same either way.");
      delayPrint(textSpeed);
      System.out.println("What am I?\"\n");
      delayPrint(textSpeed);
      
      System.out.print("Enter your answer: ");
      String answerToRiddle3 = input.next();
      if (!answerToRiddle3.equalsIgnoreCase("eye")) {
         System.out.printf("\"Oh i’m terribly sorry, %s is not the correct answer. The correct answer was \"eye\".\n", answerToRiddle3);
         delayPrint(textSpeed);
         System.out.println("Now since you apparently don't know anything about eyes, considering you couldn't even solve this remedial riddle.");
         delayPrint(textSpeed);
         System.out.println("I will be confiscating your eyes. You can have them back when you have learned your lesson.\"");
         delayPrint(textSpeed);
         System.out.println("Alfred the Unbelievable confiscates your eyes.");
         delayPrint(textSpeed);
         System.out.println("You die shortly after");
         delayPrint(textSpeed);
         player1.setIsDeadToTrue();
      }
      else {
         System.out.println("\"CORRECT\" screams Alfred the Unbelievable in an extreme and unbelievable decibel level.");
         delayPrint(textSpeed);
         System.out.println("\"I will take you to your princess...After just one more riddle!\" howled Alfred the Unbelievable.");
         delayPrint(textSpeed);
         System.out.println("\"No more riddles!\" you shout!");
         delayPrint(textSpeed);
         System.out.println("You lunge for Alfred the Unbelievable with all your might.");
         delayPrint(textSpeed);
      }
   }
   
   public static void endingToGame() {
      System.out.println("You have defeated Alfred the Unbelievable. As he lay on the ground, at the cusp of death, he kisses you gently.");
      delayPrint(textSpeed);
      System.out.println("\"I thought this might be fun\" Alfred hoarsely whispered. Odd considering the volume of his voice previously.");
      delayPrint(textSpeed);
      System.out.println("\"Happy birthday my love\" whispers Alfred the Unbelievable.\n");
      delayPrint(textSpeed);
      System.out.println("He dies with a gasp.\n");
      delayPrint(textSpeed);
      System.out.println("You are confused beyond reason. Why had Alfred said those things before his death.");
      delayPrint(textSpeed);
      System.out.println("You remove his mask to find the princess' face. She was wearing a twisted smile.\n\n");
      delayPrint(textSpeed + 4000);
      System.out.println("Unbelievable...");
      delayPrint(textSpeed + 4000);
      if (gameOverCounter == 1) {
         System.out.printf("%nYou died %d time.", gameOverCounter);
         delayPrint(textSpeed);
      }
      else {
         System.out.printf("%nYou died %d times.", gameOverCounter);
         delayPrint(textSpeed);
      }      
   }
   
   //this is the method that makes the Text slower for easier readability
   public static void delayPrint(int timer) {
      try {
         Thread.sleep(timer);
      } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
      }
   }
   
   public static int gameOver() {
      System.out.println("GAME OVER");
      System.out.println("Restart Game? Y/N: ");
      String restartGameChoice = input.next();
      if (restartGameChoice.equalsIgnoreCase("Y")) {
         return 1;
      } else
         return 0;
   }
   
   public static int getTextSpeed() {
      return textSpeed;
   }
   

}