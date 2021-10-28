package Chapter6;

import java.util.HashSet;
import java.util.Set;

public class PlantMain {
    public static void main(String[] args) {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[])new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        Plant[] garden = new Plant[3];
        garden[0] = new Plant("1", Plant.LifeCycle.ANNUAL);
        garden[1] = new Plant("2", Plant.LifeCycle.PERENNIAL);
        garden[2] = new Plant("3", Plant.LifeCycle.BIENNIAL);

        for(Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        // 결과 출력
        for(int i =0; i < plantsByLifeCycle.length; i++){
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}
