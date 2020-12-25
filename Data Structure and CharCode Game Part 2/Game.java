package project12;

/************ E X E R C I S E S *****************

 Getting a random army of players instead of just one player.

 similarly getting an opponent army to fight with.

 Using random emoji for players and opponents.

 Enforcing fight method

*************************************************/

abstract class Character {
  String charCode;
  void showChar() {
      System.out.print(charCode);
  }

  abstract void setChar();
}

class Player extends Character{
  String charArray[] = {"&#128034;", "&#128037", "&#128039;","&#128060;", "&#128130;", "&#129373;"};
  void setChar(){
      double num = Math.random()* charArray.length;
      int randomNum = (int) num;
      charCode = charArray[randomNum];
  }
}
class Opponent extends Character{
  String charArray[] = {"&#127875", "&#128128;", "&#128127;", "&#128050;", "&#128121;", "&#128122;"};
  void setChar(){
      double num = Math.random() * charArray.length;
      int randomNum = (int) num;
      charCode = charArray[randomNum];
  }
}

interface Fighting{
  void fight();
}

public class Game implements Fighting {
  Player players[] = new Player[50];
  Opponent opponents[] = new Opponent[50];
  int playerCount = 0;
  int opponentCount = 0;
  String title = "Fight Game";

  Game() {
      title = "Untitled";
  }

  void setTitle(String title) {
      this.title = title;
  }

  String getTitle() {
      return title;
  }

  void addPlayer(Player p) {
      players[playerCount] = p;
      playerCount++;
  }

  void addOpponent(Opponent o) {
      opponents[opponentCount] = o;
      opponentCount++;
  }

  public void fight(){
      if(playerCount > opponentCount){
          System.out.println("\nYou win");
      }else if(playerCount < opponentCount){
          System.out.println("\nYou lose");
      }else{
          System.out.println("\nIts a draw");
      }
  }

  public static void main(String args[]) {
      Game myGame = new Game();
      double num = Math.random() * 10;
      int randomNum1 = (int) num;

      myGame.setTitle("Fight Game");
      System.out.println(myGame.getTitle());

      for(int i = 0; i < randomNum1; i++){
          Player myPlayer = new Player();
          myPlayer.setChar();
          myGame.addPlayer(myPlayer);
          myGame.players[i].showChar();
      }

      System.out.println("");
      double num2 = Math.random() * 10;
      int randomNum2 = (int) num2;
      for(int i = 0; i < randomNum2; i++){
          Opponent myEnemy = new Opponent();
          myEnemy.setChar();
          myGame.addOpponent(myEnemy);
          myGame.opponents[i].showChar();

          
      }  
      myGame.fight();
  }
}


