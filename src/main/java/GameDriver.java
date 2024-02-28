public class GameDriver {
    public static void main(String[] args) {
        Move move1 = new Move("Thundershock", "Thunder", 45, 1.0f);
        Move move2 = new Move("Tackle", "Normal", 50, 1.0f);
        Move move3 = new Move("Bubble", "Water", 90, 0.85f);
        Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f);

        Monster monster = new Monster("Bulbasaur", "Grass",240, 45, 49, 49, move1, move2, move3, move4);
    
        Player player = new HumanPlayer(monster);
        move1 = new Move("Scratch", "Normal", 40, 1.0f);
        move2 = new Move("Ember", "Fire", 40, 1.0f);
        move3 = new Move("Peck", "Flying", 35, 1.0f);
        move4 = new Move("Fire Spin", "Fire", 35, 0.85f);

        monster = new Monster("Torchic", "Fire", 240, 45, 60, 40, move1, move2, move3, move4);
   
        Player enemy = new CPUPlayer(monster);

        while ((!player.hasLost()) && (!enemy.hasLost())) {
            
            // print both monsters' HP
            System.out.println("");
            System.out.printf("%s has %d HP\n",
            player.getMonster().getName(),
            player.getMonster().getHP());
            System.out.printf("%s has %d HP\n",
            enemy.getMonster().getName(),
            enemy.getMonster().getHP());
   
            // decide the next move
            int playerMove = player.chooseMove();
            int enemyMove = enemy.chooseMove(); 

            // execute the next move
            if (player.isFasterThan(enemy)) {
                player.attack(enemy, playerMove);
                if (!enemy.hasLost()) {
                    enemy.attack(player, enemyMove);
                }
            } 
            else {
                enemy.attack(player, enemyMove);
                if (!player.hasLost()) {
                    player.attack(enemy, playerMove);
                }
            }
        }
   
        if (player.hasLost()) {
            System.out.printf("You and %s have lost the battle.\n",
            player.getMonster().getName());
        } 
        else {
            System.out.printf("You and %s are victorious!\n",
            player.getMonster().getName());
        }
    }
}
   