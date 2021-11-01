package week7;

import java.util.Scanner;

public class crazyEights {

    // initializes the constant varriables for the the suits and non number cards

    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final int NUM_CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    /** 
     * Creates the main method
     * Creates a scanner that gets user input
     * it will keep repeating games until gameover(when someone reaches 100 points)
     * it will substring the results of playround to distinguish how many points each player earned 
     * after the game ends it prints total points and says who won
    */
    public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
        int playerPoints = 0;
        int c1Points = 0;
        int c2Points = 0;
        while (!gameOver(playerPoints, c1Points, c2Points)) {
           String result = playRound(in);
           int firstDash = result.indexOf("-");
           int secondDash = result.lastIndexOf("-");
           playerPoints += Integer.parseInt(result.substring(0, firstDash));
           c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
           c2Points += Integer.parseInt(result.substring(secondDash + 1));
           
        } 
        
        System.out.println("Points \n Player: " + playerPoints + "  Computer 1: " + c1Points + " Computer 2: " + c2Points);
        if(playerPoints < c1Points && playerPoints < c2Points){
           System.out.println("You Win!");
        }
        else if(c1Points < playerPoints && c1Points < c2Points){
         System.out.println("Computer 1 Wins");
        }
        else if(c2Points < playerPoints && c2Points < c1Points){
         System.out.println("Computer 2 Wins");
        }
        else if(playerPoints == c1Points && playerPoints < c2Points){
           System.out.println("You and Computer 1 Tie");
        }
        else if(playerPoints == c2Points && playerPoints < c1Points){
         System.out.println("You and Computer 2 Tie");
         }
         else if(c1Points == c2Points && c1Points < playerPoints){
            System.out.println("Computer 1 and Computer 2 Tie");
         }

     }
  
     /**
      * where the game is played
      * initializes the hands and the top cards
      */
     private static String playRound(Scanner in) {
       
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";
        String topCard = "";

        
        //makes sure the top card isn't 8 
        Boolean isEight = true;
        while(isEight){
         topCard = getCard();
           if(topCard.indexOf("8")==-1){
              isEight = false;
           }
        }
      //gives players 5 cards
        playerHand += getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " ";
        c1Hand += getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " ";
        c2Hand += getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " ";
       

        String playerTurn;
        String c1Turn;
        String c2Turn;

        //while people have cards
        /**
         * plays the round
         * displays the amount of cards the computers have
         * player will go first
         * c1 will go second and c2 will go third
         * in between each round
         * it will say how many cards c1 and c2 have
         * it will also say what cards the computers played
         */
        while(playerHand.length() != 0 && c1Hand.length() != 0 && c2Hand.length() != 0 ){
         System.out.println("Computer 1: " + getCardAmount(c1Hand));
         System.out.println("Computer 2: " + getCardAmount(c2Hand));
          playerTurn = processPlayer(playerHand, topCard, in);
          playerHand = playerTurn.substring(playerTurn.indexOf("|") + 1);
          topCard = playerTurn.substring(0, playerTurn.indexOf("|"));
          //if the player wins it will exit the loop
          if(playerHand.length()==0){
             break;
          }

          c1Turn = processComputer(c1Hand, topCard, playerHand, c2Hand);
          c1Hand = c1Turn.substring(c1Turn.indexOf("|") + 1);
          topCard = c1Turn.substring(0, c1Turn.indexOf("|"));
          System.out.println("Computer 1 played: " + topCard);
          System.out.println("Computer 1: " + getCardAmount(c1Hand));
          System.out.println("Computer 2: " + getCardAmount(c2Hand));
          //if c1 wins it will exit the loop
          if(c1Hand.length()==0){
            break;
         }

          c2Turn = processComputer(c2Hand, topCard, c1Hand, playerHand);
          c2Hand = c2Turn.substring(c2Turn.indexOf("|") + 1);
          topCard = c2Turn.substring(0, c2Turn.indexOf("|")); 
          System.out.println("Computer 2 Played: " + topCard);

        }
        
        String winner = "";
        //it determines the winner of the round
        if(playerHand.length() == 0){
           winner = "Player";
        }
        if(c1Hand.length() == 0){
           winner = "Computer 1";
        }
        if(c2Hand.length() == 0){
           winner = "Computer 2";
        }
       
        System.out.println("This Rounds Points Are: Player: " + getPoints(playerHand) + " Computer 1: " + getPoints(c1Hand) + " Computer 2: " + getPoints(c2Hand));
        System.out.println("The Winner of this round is: " + winner);
        return getPoints(playerHand) + "-" + getPoints(c1Hand) + "-" + getPoints(c2Hand);  
     }
  
     /**
      * finds the amount of cards someone has by counting the amount of spaces
      * (4A 8D )
      * each card is represented by an x
      */
     private static String getCardAmount(String hand){
      String str = "";
      for(int i = 0; i < hand.length(); i++){
         if(hand.substring(i, i + 1).equals(" ")){
            str +="x ";
         }
      }
      return str;
   
   }

/**
 * gets the amount of points a player would have
 * it does this by checking if the hand has the specific charachter of the card
 * and it will add the points accordingly
 * this is in a while loop so that it can find multiple instances a rank
 * it will substring out the card after it has been counted to avoid counting a card multiple times
 */
   private static String getPoints(String hand){
      int points = 0;
      String str = "";
      while(hand.length() > 0){
         if(hand.indexOf("A") >= 0){
            points += 1;
            hand = hand.substring(0, hand.indexOf("A")) +  hand.substring(hand.indexOf("A") + 3);
         }
         if(hand.indexOf("2") >= 0){
            points += 2;
            hand = hand.substring(0, hand.indexOf("2")) +  hand.substring(hand.indexOf("2") + 3);
         }
         if(hand.indexOf("3") >= 0){
            points += 3;
            hand = hand.substring(0, hand.indexOf("3")) +  hand.substring(hand.indexOf("3") + 3);
         }
         if(hand.indexOf("4") >= 0){
            points += 4;
            hand = hand.substring(0, hand.indexOf("4")) +  hand.substring(hand.indexOf("4") + 3);
         }
         if(hand.indexOf("5") >= 0){
            points += 5;
            hand = hand.substring(0, hand.indexOf("5")) +  hand.substring(hand.indexOf("5") + 3);
         }
         if(hand.indexOf("6") >= 0){
            points += 6;
            hand = hand.substring(0, hand.indexOf("6")) +  hand.substring(hand.indexOf("6") + 3);
         }
         if(hand.indexOf("7") >= 0){
            points += 7;
            hand = hand.substring(0, hand.indexOf("7")) +  hand.substring(hand.indexOf("7") + 3);
         }
         if(hand.indexOf("8") >= 0){
            points += 50;
            hand = hand.substring(0, hand.indexOf("8")) +  hand.substring(hand.indexOf("8") + 3);
         }
         if(hand.indexOf("9") >= 0){
            points += 9;
            hand = hand.substring(0, hand.indexOf("9")) +  hand.substring(hand.indexOf("9") + 3);
         }
         if(hand.indexOf("10") >= 0){
            points += 10;
            hand = hand.substring(0, hand.indexOf("10")) +  hand.substring(hand.indexOf("10") + 4);
         }
         if(hand.indexOf("J") >= 0){
            points += 10;
            hand = hand.substring(0, hand.indexOf("J")) +  hand.substring(hand.indexOf("J") + 3);
         }
         if(hand.indexOf("Q") >= 0){
            points += 10;
            hand = hand.substring(0, hand.indexOf("Q")) +  hand.substring(hand.indexOf("Q") + 3);
         }
         if(hand.indexOf("K") >= 0){
            points += 10;
            hand = hand.substring(0, hand.indexOf("K")) +  hand.substring(hand.indexOf("K") + 3);
         }
      }
      return str + points;
   }


   /**
    * 
    * @param myHand it takes in the myHand it will be deciding what to play based on this hand
    * @param topCard needs the top hand to see what cards it can play
    * @param oppHand1 in order to see if the other players have 1 card left
    * @param oppHand2 in order to see if the other players have 1 card left
    * @return
    * 
    */
   private static String processComputer(String myHand, String topCard, String oppHand1, String oppHand2) {
      
      String topNum = topCard.substring(0, topCard.length()-1); //gets the rank of the top card
      String topSuit = topCard.substring(topCard.length()-1);  //gets the suit of the top card
      String cardPlayed = "";
      int count = 0;
      int index = 0;
      String card = "";
      Boolean pickup = true;
      
      /**
       * sees if you cant play
       * if you can't play it will add a card
       * it is a while loop so if can't play again it will keep adding cards until you have picked up 5 cards 
       */
      
      while(pickup && count <5){
         Boolean canPlay = (myHand.indexOf(topCard.substring(topCard.length()-1)) >=0) || (myHand.indexOf(topCard.substring(0,1))>=0)|| (myHand.indexOf(topCard.substring(0,2))>=0) || (myHand.indexOf("8")>=0);
         if(canPlay){
            pickup = false;
         }
         else{
            myHand += getCard() + " ";
            count++;
         }
      }
      if(count == 5){
         System.out.println("Turn was skipped");
         return topCard + "|" + myHand;
      }


         if(oppHand1.length() <= 4 || oppHand2.length() <= 4){ // it will be either 3 or 4 if the player has 1 card [AD ] / [10D ] if there are 2 cards left it would be 6+ [AD AD ]
            /**
             * checks if you can change the suit by having a card of that rank
             * will check each index in your hand
             */
            
            while(myHand.indexOf(topNum, index) >= 0){
               index = myHand.indexOf(topNum, index);
               card = myHand.substring(index, myHand.indexOf(" ", index));
               //will a card of the same rank if it doesnt have the same suit. 
               if(!card.equals(topCard)){
                  String cardReplace = card + " ";
                  return card + "|" +  myHand.replace(cardReplace, "");
               }
               index ++;   
            }

            /**
             * checks to see if the player has an 8
             */
            if(myHand.indexOf("8") >= 0){
               myHand = myHand.substring(0, myHand.indexOf("8")) + myHand.substring(myHand.indexOf("8") + 3); //removes the 8 from the player hand
               /**
                * checks to see if the player has a suit and it is not the suit of the top card
                */
               if(myHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
                  return "8H" + "|" + myHand;
               }
               if(myHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
                  return "8C" + "|" + myHand;
               }
               if(myHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
                  return "8D" + "|" + myHand;
               }
               if(myHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
                  return "8S" + "|" + myHand;
               }
                  return "8" + topSuit + "|" + myHand; //will return the same suit only if the player doesnt have any other suit 9(because you dont want to change the suit to something you dont have)
            }
            
            
       }
      /**
       * checks to see if you have a card with the same suit as the topcard
       * will remove the card from the hand
       * and return the card that has been played as the top card
       */
        if (myHand.indexOf(topSuit) >= 0){ 
           if(!myHand.substring(myHand.indexOf(topSuit) -1, myHand.indexOf(topSuit)).equals("8")){
              if(myHand.substring(myHand.indexOf(topSuit) - 1, myHand.indexOf(topSuit)).equals("0")){ //will be 10 because the only time 0 will be before the suit is 10
                 cardPlayed = myHand.substring(myHand.indexOf("10"), myHand.indexOf("10") + 3);
                 myHand = myHand.substring(0, myHand.indexOf("10")) + myHand.substring(myHand.indexOf("10") + 4);
                 return cardPlayed + "|" + myHand;
              }
               cardPlayed = myHand.substring(myHand.indexOf(topSuit)-1, myHand.indexOf(topSuit)+1);
               myHand = myHand.substring(0, myHand.indexOf(cardPlayed)) + myHand.substring(myHand.indexOf(cardPlayed) + 3);
               return cardPlayed + "|" + myHand;
          }
         }

      /**
       * checks to see if you have a card with the same rank as the topcard
       * will remove the card from the hand
       * and return the card that has been played as the top card
       */
         if(myHand.indexOf(topNum)>= 0){
            if(topNum.equals("10")){
              cardPlayed = myHand.substring(myHand.indexOf("10"), myHand.indexOf("10")+3);
              myHand = myHand.substring(0, myHand.indexOf("10")) + myHand.substring(myHand.indexOf("10") + 4);
              return cardPlayed + "|" + myHand;
           }

            if (!myHand.substring(myHand.indexOf(topNum), myHand.indexOf(topNum) + 1).equals("8")){
             cardPlayed = myHand.substring(myHand.indexOf(topNum), myHand.indexOf(topNum) + 2);
             myHand = myHand.substring(0, myHand.indexOf(cardPlayed)) + myHand.substring(myHand.indexOf(cardPlayed) + 3);
             return cardPlayed + "|" + myHand;
           }

        }
        //works the same as the method above for changing the suit with an 8
        if(myHand.indexOf("8") >= 0){
         myHand = myHand.substring(0, myHand.indexOf("8")) + myHand.substring(myHand.indexOf("8") + 3);
         if(myHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
            return "8H" + "|" + myHand;
         }
         if(myHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
            return "8C" + "|" + myHand;
         }
         if(myHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
            return "8D" + "|" + myHand;
         }
         if(myHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
            return "8S" + "|" + myHand;
         }
            return "8" + topSuit + "|" + myHand;
      }
      

   return topCard + "|" + myHand; 

}


   /**
    * 
    * @param playerHand //takes in the hand
    * @param topCard //takes in the top card
    * @param in //takes in the scanner to have player input
    * @return
    */
     private static String processPlayer(String playerHand, String topCard, Scanner in) {
      String cardPlayed = "";
      Boolean pickup = true;
      Boolean playable = false;
      int count = 0;

       /**
       * sees if you cant play
       * if you can't play it will add a card
       * it is a while loop so if can't play again it will keep adding cards until you have picked up 5 cards 
       * it will say your turn has been skipped if you still cant play after 5 turns. 
       */
         while(pickup && count <5){
            Boolean canPlay = (playerHand.indexOf(topCard.substring(topCard.length()-1)) >=0) || (playerHand.indexOf(topCard.substring(0,1))>=0)|| (playerHand.indexOf(topCard.substring(0,2))>=0) || (playerHand.indexOf("8")>=0);
            if(canPlay){
               pickup = false;
            }
            else{
               playerHand += getCard() + " ";
               count++;
               System.out.println("Top Card: " + topCard); 
               System.out.println("You couldn't play, you picked up a card.");
               System.out.println("Your Hand: " + playerHand);
            }
         }

         if (count == 5){
            System.out.println("Your turn was skipped");
            return topCard + "|" + playerHand;
         }
         /**
          * will loop if there is an invalid input
          */
      while(!playable){
         /**
          * prompts user
          * tells them the top card and their hand
          */
         System.out.println("Please play a card");
         System.out.println("Top Card: " + topCard); 
         System.out.println("Your Hand: " + playerHand);

         cardPlayed = in.nextLine().toUpperCase(); //gets the input of the card and changes it to upper case
         if(playerHand.indexOf(cardPlayed)>=0 && cardPlayed.length() <= 3 && cardPlayed.length() >= 2){ //checks to see if the player has that card and that it is only 1 card and if it is the length of a card.
 
            /**
             * if the cardplayed is an 8
             * it will remove the 8 from the hand
             * will make sure they change the suit to either D C H OR S
             * returns the new topcard and the new hand
             */
            if(cardPlayed.substring(0,1).equals("8")){ 
               playerHand = playerHand.substring(0, playerHand.indexOf(cardPlayed)) + playerHand.substring(playerHand.indexOf(cardPlayed)+3); 
               Boolean canChange = false;
               while(!canChange){
               System.out.println("Which suit do you want to switch to? (D, C, H, S)");
               String suitChange = in.nextLine().toUpperCase();
               Boolean changable = suitChange.indexOf("D")>= 0 || suitChange.indexOf("C") >= 0 || suitChange.indexOf("H") >= 0 || suitChange.indexOf("S") >= 0;

               if(changable){
                  cardPlayed = "8" + suitChange;
                  canChange = true;
               }
               else{
                  System.out.println("Invalid Input!");
               }
            }
            return cardPlayed + "|" + playerHand;
         }
            /**
             * checks to see if the card inputted has either the same suit or rank
             * it will set that to the new topcard and remove that card from the hand
             */
            if(cardPlayed.indexOf(topCard.substring(topCard.length()-1)) >= 0 || cardPlayed.indexOf(topCard.substring(0,topCard.length()-1)) >=0){
               if(cardPlayed.indexOf("10") >= 0){
                  playerHand = playerHand.substring(0, playerHand.indexOf(cardPlayed)) + playerHand.substring(playerHand.indexOf(cardPlayed)+4);
                     return cardPlayed + "|" + playerHand;
               }
               else{
                  playerHand = playerHand.substring(0, playerHand.indexOf(cardPlayed)) + playerHand.substring(playerHand.indexOf(cardPlayed)+3);
                  return cardPlayed + "|" + playerHand;
               }
            }
            System.out.println("You cannot play that card"); //if the card doesnt meet any of the prior conditions it cant be played and it will go back to the top of the loop
            }
      

         
         else{ //if they enter a card they don't have
            System.out.println("Invalid Input");
         }
      }
      return topCard + "|" + playerHand; 

     }

     //checks to see if any player has reached 100 points
     private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
     }

     //gets a random card from an infinite deck
     private static String getCard() {
        String card = getFace() + getSuit();
        return card;
     }

     //gets a random suit using a random number generator (using the number of suits previously declared)
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
  
     //gets a random rank unsing a random number generator 

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
   }
