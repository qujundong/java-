package item37;

import Entity.Plant;
import item34.Planet;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 * @author: qujundong
 * @date: 2020/12/6 上午9:03
 * @description:
 */
public class EnumMapTest {
    public static void enumMapArrayTest(List<Plant> garden){

        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();
        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
// Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    public static void enumMapTest(List<Plant> garden){
        // Using an EnumMap to associate data with an enum

        Map<Plant.LifeCycle, Set<Plant>>  plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);
    }
    public static void enumMapLambdaTest(List<Plant> garden){
        EnumMap<Plant.LifeCycle, Set<Plant>> collect = garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        List<Plant> garden = new ArrayList<>();
        garden.add(new Plant("1", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("1", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("2", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("2", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("3", Plant.LifeCycle.BIENNIAL));
        garden.add(new Plant("3", Plant.LifeCycle.BIENNIAL));
        enumMapArrayTest(garden);
        enumMapTest(garden);
        enumMapLambdaTest(garden);

    }
}
