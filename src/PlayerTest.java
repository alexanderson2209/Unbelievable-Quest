//mark and Alex

public class PlayerTest {
   public static void main(String[] args) {
      Player player1 = new Player("Jeffery");
      player1.portrait();
      player1.drinkManaPotion();
      System.out.println("Player 1 level: " + player1.getLevel());
      System.out.println("player 1 drinks a mana potion");
      System.out.println("Mana Potion Amount: " + player1.getManaPotion());
      System.out.println("Player 1 Mana: " + player1.getMana());
      
      Player player2 = new Player("Frank");
      player2.addToExp(100);
      System.out.println("player 2 level: " + player2.getLevel());
      System.out.println("Player 2 casts meteor");
      player1.modifyHealth(player2.meteor());
      System.out.println("Player 1 health: " + player1.getHealth());
      System.out.println("Is player one dead? " + player1.getIsDead());
      
   }
}