//Mark's and Alex's 
// Group A10 project


import java.util.Random;
import java.util.Scanner;

public class Battle
{
   Random rand = new Random();
   Player myPlayer;
   EnemyFighter star;
       //turn titan into hero
   //  public void hero()
//     {
//       titan.setHealthBar(titan.getHealthBar() * 2 + titan.getLevel());
//       titan.setAttack(titan.getAttack() * 3 + titan.getLevel());
//       titan.setMagDam(titan.getMagDam() * 2 + titan.getLevel());
//     }
   
   //ctor
   public Battle(Player myPlayer, EnemyFighter star) {
      this.myPlayer = myPlayer;
      this.star = star;
   }
   
   
   public Player engage()
   {

   
      //creating instances
      Scanner input = new Scanner(System.in);      
      //starting battle
      
      System.out.println("Battle Starts");
      Story.delayPrint(Story.getTextSpeed());
      do{
         star.data();
         System.out.println();
         myPlayer.data();         
         System.out.println();
         playersChoices();
         int choice = input.nextInt();
         int damage = chooseAtk(choice);
         int damage2 = star.randomAtk(rand.nextInt(2));
         star.setHealthBar(star.getHealthBar() - damage);
         System.out.println("\n");
         System.out.println(star.getName() + " did " + damage2 + " damage");
         Story.delayPrint(Story.getTextSpeed());
         myPlayer.modifyHealth(damage2);
         if(damage == -1) {
            System.out.println(myPlayer.getPlayerName() + " used a HP potion.");
            Story.delayPrint(Story.getTextSpeed());
            System.out.println("You recovered " + myPlayer.getHpPotionAmount() + " health");
            Story.delayPrint(Story.getTextSpeed());
            System.out.println("You have " + myPlayer.getHealthPotion() + " left");
            Story.delayPrint(Story.getTextSpeed());
         }
         else if( damage == 0) {
            System.out.println(myPlayer.getPlayerName() + " used a Mana potion.");
            Story.delayPrint(Story.getTextSpeed());
            System.out.println("You recovered " + myPlayer.getManaPotionAmount() + " mana");
            Story.delayPrint(Story.getTextSpeed());
            System.out.println("You have " + myPlayer.getManaPotion() + " left");
            Story.delayPrint(Story.getTextSpeed());
         }
         else
            System.out.println(myPlayer.getPlayerName() + " did " + damage + " damage");
            Story.delayPrint(Story.getTextSpeed());
         System.out.println();
         
                  
      }while (myPlayer.getHealth() > 0 && star.getHealthBar() > 0);
      
      if(star.getHealthBar() > myPlayer.getHealth())
      {
         star.data();
         System.out.print(myPlayer.getPlayerName() + " was Defeated!!!!");
         Story.delayPrint(Story.getTextSpeed());
      }
      else
      {
         myPlayer.data();
         System.out.println(star.getName() + " was Defeated");
         Story.delayPrint(Story.getTextSpeed());
      }
      for(int i = 1; i <= star.getLevel(); i++)
      {
         myPlayer.addToExp(star.getXp());
      }
      System.out.println("XP: " + myPlayer.getExp());
      System.out.println("\n");
      Story.delayPrint(Story.getTextSpeed()); 
      return myPlayer;                 
   }
   
   //hero's attack choice
    public int chooseAtk(int choice)
   {
      switch (choice)
      {
         case 0: choice = myPlayer.getDamage();
            break;
         case 1: myPlayer.drinkHpPotion();
                  choice = -1;
            break;
         case 2: myPlayer.drinkManaPotion();
                  choice = 0;
            break;
         case 3: choice = myPlayer.firebolt();
            break;
         case 4: choice = myPlayer.meteor();
            break;   
         default : choice = myPlayer.getDamage();
      }
      return choice;
   }
            
   public void playersChoices()
   {
      System.out.println("0: Attack\n1: HP Potion\n2: Mana Potion");
      if(myPlayer.getLevel() >= 2)
      {
         System.out.println("3: Firebolt");
         if(myPlayer.getLevel() >= 3)
         {
            System.out.println("4: Meteor");
         }
      }
   }
  
}