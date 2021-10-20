package week7;

import java.util.Scanner;

public class threeCardPoker {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String SPADES = "S";
   private static final String CLUBS = "C";
   private static final int NUM_CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String KING = "K";
   private static final String QUEEN = "Q";

   public static void main(String[] args) {
      int wallet = 500;

      Scanner in = new Scanner(System.in);
      // int bet = getWager(in, 50, 100, wallet);

      String playerHand = ""; // = "5D AC KS";
      playerHand = getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      System.out.println(playerHand);

      playerHand = discard(in, playerHand);
      System.out.println(playerHand);

   }

   private static String discard(Scanner in, String playerHand) {
      boolean validInput = false;
      int numReplace = 0;
      String newHand = "";
      while (!validInput){
          System.out.print("How many cards would you like to replace [0], [1], [2] or [3]: ");
          try{
              numReplace = Integer.parseInt(in.nextLine());
                  if (numReplace == 1 || numReplace == 2){
                      System.out.print("Which card[s] would you like to replace? ");
                      String replaceCard = in.nextLine();
                      if (numReplace == 1){
                        newHand += playerHand.replace(replaceCard, getCard(playerHand));
                      } else {
                          String firstCardReplace = replaceCard.substring(0, replaceCard.indexOf(" "));
                          newHand = playerHand.replace(firstCardReplace, getCard(playerHand));
                          String secondCardReplace = replaceCard.substring(replaceCard.indexOf(" ") + 1);
                          newHand = newHand.replace(secondCardReplace, getCard(playerHand + firstCardReplace));
                      }

                  }else if (numReplace == 0)
                      return playerHand;
                  else {
                     newHand += getCard(playerHand) + " ";
                     newHand += getCard(newHand + playerHand) + " ";
                     newHand += getCard(newHand + playerHand) + " ";
                  }
                  validInput = true;

          }catch (Exception ex){
              System.out.println("Invalid Input!");
          }
      }
      return newHand;
  }

   private static String getCard(String usedCards) {
      String card = getFace() + getSuit();

      while (usedCards.indexOf(card) >= 0) {
         card = getFace() + getSuit();
      }
      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * NUM_SUITS);

      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return DIAMONDS;
      else if (suit == 2)
         return SPADES;
      else
         return CLUBS;
   }

   private static String getFace() {
      int face = (int) (Math.random() * NUM_CARDS_PER_SUIT) + 1;

      if (face >= 2 && face <= 10)
         return "" + face;
      else if (face == 1)
         return ACE;
      else if (face == 11)
         return JACK;
      else if (face == 12)
         return QUEEN;
      else
         return KING;

   }

   private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
      boolean validInput = false;
      int bet = 0;

      while (!validInput) {
         System.out.print("Please enter a bet [$" + minBet + " - $" + maxBet + "]: ");
         try {
            bet = Integer.parseInt(in.nextLine());

            if (bet > wallet)
               System.out.println("You only have $" + wallet);
            else if (bet > maxBet || bet < minBet)
               System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]");
            else
               validInput = true;
         } catch (Exception ex) {
            System.out.println("Invalid Input!");
         }
      }

      return bet;
   }
}