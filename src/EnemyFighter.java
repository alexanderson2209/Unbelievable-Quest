import java.util.Random;

public class EnemyFighter
{
   //fields
   private String name;
   
   private int level;
   
   private int attack;
   
   private int healthBar;
   
   private int manaBar;
   
   private int xp;
   
   private int magDam;
   
   //ctors
   public EnemyFighter(String name1, int lv)
   {
      setLevel(lv);
      name = name1;
      setAttack(lv * 2 + 5);
      setMagDam(lv * 6 + 3);
      setHealthBar((level + 5) * 10);
      setManaBar((level + 5) * 10);
      makeBoss();
      xp = 25;
   }
   
   //methods
   //Attacks
   public int getAttack()
   { 
      Random rand = new Random();
      if(rand.nextInt(7) % 2 == 0)
      {
         return attack + 2;
      }
      else
         return attack - 2;
   }
   public void setAttack(int atk1)
   {
      attack = atk1;
   }
   
   //Magic
   public int getMagDam()
   {  
      Random rand = new Random();
      
      if( manaBar >= 50)
      {
         setManaBar(manaBar - 50);
         if(rand.nextInt(7) % 2 == 0)
         {
            return magDam + 2;
         }
         else 
            return magDam - 2;
      }
      else
      {   
         return 0;
      }
   }
   
   public void setMagDam(int mag)
   {
      magDam = mag;
   }
   
   public int randomAtk(int damage)
   {
      switch(damage)
      {
         case 0 : damage = getAttack();
            break;
         case 1 : damage = getMagDam();
            break;
      }
      return damage;
   }
   
   //level
   public void setLevel(int lv)
   {
      level = lv;
   }
   
   public int getLevel()
   {
      return level;
   }
   
   //health
   public int getHealthBar()
   {
      return healthBar;
   }
   
   public void setHealthBar(int hpUp)
   {
      healthBar = hpUp;
   }
   
   //mana
   public int getManaBar()
   {
      return manaBar;
   }
   
   public void setManaBar(int manaUp)
   {
      manaBar = manaUp;   
   }
   
   //exp
   public int getXp()
   {
      return xp;
   }
   
   public void setXp(int xpUp)
   {
      if(xp >= 10)
      {
         setLevel(getLevel() + 1);
      }
      xp = xpUp;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void data()
   {
      portrait();
      System.out.printf("%s: \tLv: %d%nHP: %d\tMana: %d%nAtk: %d\tMagdam: %d%n", name, level, healthBar, manaBar, attack, magDam);
   
   }
   
   public void portrait() {
      if (name.equals("Orc")) {
         System.out.println("               _,.---''```````'-.");
         System.out.println("           ,-'`                  `-._");
         System.out.println("        ,-`                   __,-``,\\ ");
         System.out.println("       /             _       /,'  ,|/ \\ ");
         System.out.println("     ,'         ,''-<_`'.    |  ,' |   \\ ");
         System.out.println("    /          / _    `  `.  | / \\ |\\  |");
         System.out.println("    |         (  |`'-,---, `'  \\_|/ |  |");
         System.out.println("    |         |`  \\  \\|  /  __,    _ \\ |");
         System.out.println("    |         |    `._\\,'  '    ,-`_\\ \\|");
         System.out.println("    |         |        ,----      /|   )");
         System.out.println("    \\         \\       / --.      {/   /|");
         System.out.println("     \\         | |       `.\\         / |");
         System.out.println("      \\        / `-.                 | /");
         System.out.println("       `.     |     `-        _,--V`)\\/  ");      
         System.out.println("         `,   |           /``V_,.--`  \\.  ");
         System.out.println("           `--'`._        `-'`         )");
         System.out.println("                 `-.            _,.-'`");
         System.out.println("                     `-.____,.-'`");
      }
      
      if (name.equals("Giant spider")) {
         System.out.println("             ||");
         System.out.println("             ||");
         System.out.println("             ||");
         System.out.println("       _ /\\  ||  /\\ _");
         System.out.println("      / X  \\.--./  X \\");
         System.out.println("     /_/ \\/`    `\\/ \\_\\");
         System.out.println("    /|(`-/\\_/)(\\_/\\-`)|\\");
         System.out.println("   ( |` (_(.oOOo.)_) `| )");
         System.out.println("     |  `//\\(  )/\\\\`  | `");
         System.out.println("     (  // ()\\/() \\\\  )");
         System.out.println("      ` (   \\   /   ) `");
         System.out.println("         \\         /        Eeek!");
         System.out.println("          `       `       ");
      }
   }
   
   public void makeBoss()
   {
      if (name.equalsIgnoreCase("Alfred the Unbelievable"))
      {
         setAttack(attack * 4);
         setMagDam(magDam * 4);
         setHealthBar(healthBar * 6);
         setManaBar(150);
      }
   }
}