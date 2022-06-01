package doudizhu;

import java.util.ArrayList;
import java.util.Collections;
/*
   Fight the Landlord (Dou Di Zhu) is a climbing game primarily for three players
   In this demo, I use arraylist to store the cards
   And I use three arraylists to store player's cards
 */

public class PokerDemo {
    public static void main(String[] args) {
        //use arraylist to store a deck of cards
        ArrayList<String> array=new ArrayList<>();

        //add all the cards
        String [] suites={"♥","♦","♠","♣"};
        String [] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String suit:suites){
            for (String number:numbers){
                array.add(suit+number);
            }
        }
        array.add("Red Joker");
        array.add("Black Joker");

        //shuffle the cards
        Collections.shuffle(array);

        //deal the cards to three players, and leave 3 cards face down for the landlord
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> holeCards=new ArrayList<>();

        for (int i=0;i<array.size();i++){
            String poker= array.get(i);

            if(i>=array.size()-3){
                holeCards.add(poker);
            }else if(i%3==0){
                player1.add(poker);
            }else if(i%3==1){
                player2.add(poker);
            }else if(i%3==2){
                player3.add(poker);
            }
        }

        //players check cards
        lookPoker("playerOne",player1);
        lookPoker("playerTwo",player2);
        lookPoker("playerThree",player3);
        lookPoker("holeCards",holeCards);
    }

    //method for checking cards on hand
    public static void lookPoker(String player,ArrayList<String> array){
        System.out.print(player+"'s cards are: ");
        for (String poker:array){
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
