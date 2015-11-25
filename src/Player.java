public class Player
{
   //fields
   private static String name;
   private int health;
   private boolean isDead;
   private int maxHealth;
   private int mana;
   private int maxMana;
   private int exp;
   private int level;
   private int damage;
   private int numberOfHpPotions;
   private int numberOfManaPotions;
   private boolean fireboltCheck;
   private boolean meteorCheck;
   private int hpPotionAmount;
   private int manaPotionAmount;
   
   //ctors
   public Player() {
      numberOfHpPotions = 5;
      numberOfManaPotions = 5;
      damage = 15;
      level = 1;
      health = 100;
      mana = 100;
      maxHealth = 100;
      maxMana = 100;
      hpPotionAmount = 51;
      manaPotionAmount = 51;
      isDead = false;
   }
   
   //methods
   //name
   public void setName(String name) {
      this.name = name;
   }
   
   //level getter
   public int getLevel() {
      return level;
   }
   
   //getter/setter for EXP
   public int getExp() {
      return exp;
   }
   
   public void addToExp(int experience) {
      exp += experience;
      while (exp >=100 * level) {
         exp -= (100 * level);
         level++;
         damage = damage + (2 * level);
         maxHealth = maxHealth * level;
         maxMana = maxMana * level;
         health = maxHealth;
         mana = maxMana;
      }
      if (level >= 2)
         fireboltCheck = true;
      if (level >= 3)
         meteorCheck = true;
   }   
   
   //getter/resetter for health
   public int getHealth() {
      return health;
   }
   public void resetHealth() {
      health = maxHealth;
   }
   
   public boolean getIsDead() {
   return isDead;
   }
   
   public void setIsDeadToTrue() {
      isDead = true;
   }
   
   public void setIsDeadToFalse() {
      isDead = false;
   }
   
   public void modifyHealth(int healthMod) {
      health -= healthMod;
      if (health <= 0)
         isDead = true;
   }   
   
   //getter/resetter for mana
   public int getMana() {
      return mana;
   }
   public void resetMana() {
      mana = maxMana;
   }
   
   public void modifyMana(int manaMod) {
      mana -= manaMod;
   }   
   
   //getter for name
   public String getPlayerName() {
      return name;
   }
   
   //getter for damage
   public int getDamage() {
      return damage;
   }
   
   //getter/setter for HP potions
   public int getHealthPotion() {
      return numberOfHpPotions;
   }
   public void setHealthPotion(int healthPotion) {
      numberOfHpPotions += healthPotion;
   }
   public int getHpPotionAmount() {
      return hpPotionAmount;
   }
   
   //getter/setter for MP potions
   public int getManaPotion() {
      return numberOfManaPotions;
   }
   public void setManaPotion(int manaPotion) {
      numberOfManaPotions += manaPotion;
   }
   public int getManaPotionAmount() {
      return manaPotionAmount;
   }
   
   //spell methods
   public int firebolt() {
      if (fireboltCheck && mana >= 25) {
         mana -= 25;
         return 25 * level;
      }
      else
         return 0;
   }
   public int meteor() {
      if (meteorCheck && mana >= 50) {
         mana -= 50;
         return 50 * level;
      }
      else
         return 0;
   }
   
   //potion drink methods
   public void drinkHpPotion() {
      if (numberOfHpPotions > 0) {
         numberOfHpPotions--;
         health += hpPotionAmount;
      }
      if (health > maxHealth)
         health = maxHealth;
   }
   
   public void drinkManaPotion() {
      if (numberOfManaPotions > 0) {
         numberOfManaPotions--;
         mana += manaPotionAmount;
      }
      if (mana > maxMana)
         mana = maxMana;
   }
   
   public void portrait() {
      System.out.println("      #####                 ");
      System.out.println("    #### _\\_  ________      ");
      System.out.println("    ##=-[.].]| \\      \\     ");
      System.out.println("    #(    _\\ |  |------|    ");
      System.out.println("     #   __| |  ||||||||    ");
      System.out.println("      \\  _/  |  ||||||||    ");
      System.out.println("   .--'--'-. |  | ____ |    ");
      System.out.println("  / __      `|__|[o__o]|    ");
      System.out.println("_(____nm_______ /____\\____  ");
   }
   public void data() {
      portrait();
      System.out.printf("%s:\t Lv: %d%nHP: %d\tMana: %d%nAtk: %d%n", getPlayerName(), getLevel(), getHealth(), 
         getMana(), getDamage());
   
   }
}