package doudizhu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerDemo2 {
    public static void main(String[] args) {
        //key is the index, value is the card
        HashMap<Integer,String> hm=new HashMap<>();

        //use arraylist to store the number
        ArrayList<Integer> array=new ArrayList<>();

        //create suites array and numbers array
        String [] suites={"♥","♦","♠","♣"};
        String [] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        //store the index from 0 to HashMap, and store corresponding card.
        //store the index to ArrayList at the same time
        int index=0;
        for (String number:numbers){
            for (String suite:suites){
                hm.put(index,suite+number);
                array.add(index);
                index++;
            }
        }
        hm.put(index,"black joker");
        array.add(index);
        index++;
        hm.put(index,"red joker");
        array.add(index);

        //shuffle the cards by shuffling the index
        Collections.shuffle(array);

        /*
        deal the cards to players
        to make sure the cards are viewed in order, I use TreeSet to store the cards(index)
         */
        TreeSet<Integer> player1=new TreeSet<>();
        TreeSet<Integer> player2=new TreeSet<>();
        TreeSet<Integer> player3=new TreeSet<>();
        TreeSet<Integer> holeCards=new TreeSet<>();

        for (int i=0;i<array.size();i++){
            int x=array.get(i);
            if (i>=array.size()-3){
                holeCards.add(x);
            }else if (i%3==0){
                player1.add(x);
            }else if (i%3==1){
                player2.add(x);
            }else{
                player3.add(x);
            }
        }
        //players check cards
        lookPoker("Player1",player1,hm);
        lookPoker("Player2",player2,hm);
        lookPoker("Player3",player3,hm);
        lookPoker("HoleCards",holeCards,hm);



    }

    //method for checking cards on hand
    public static void lookPoker(String player,TreeSet<Integer> ts,HashMap<Integer,String>hm){
        System.out.print(player+"'s cards are: ");
        for (Integer key:ts){
            String poker = hm.get(key);
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
