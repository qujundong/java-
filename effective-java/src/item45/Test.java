package item45;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: qujundong
 * @date: 2020/12/10 下午7:59
 * @description:
 */
public class Test {
    public static class Card{
        private Integer a,b;
        Card(Integer a, Integer b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void commonDicard(List<Integer> list){
        List<Card> cardList = new ArrayList<>();
        for(Integer i : list)
            for(Integer j : list)
                cardList.add(new Card(i, j));
    }

    public static void flatStreamDicard(List<Integer> list){
        List<Card> cards = list.stream().flatMap(i -> list.stream().map(j -> new Card(i, j))).collect(Collectors.toList());
    }

    public static void streamDiscard(List<Integer> list){
        Objects.requireNonNull()
        List<Stream<Card>> cards = list.stream().map(i -> list.stream().map(j -> new Card(i, j))).collect(Collectors.toList());
    }
}
