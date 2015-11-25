public class TestBattle
{
   public static void main(String[] args)
   {
      Player Player1 = new Player("HIRO");
      EnemyFighter[] enemies = new EnemyFighter[3];
      enemies[0] = new EnemyFighter("Orc", 5);
      enemies[1] = new EnemyFighter("Spider", 7);
      enemies[2] = new EnemyFighter("Alfred the Unbelievable", 7);
      Battle myBattle = new Battle(Player1, enemies[0]);
      myBattle.engage();
      Battle myBattle1 = new Battle(Player1, enemies[1]);
      myBattle1.engage();
      Battle myBattle2 = new Battle(Player1, enemies[2]);
      myBattle2.engage();

   }
}