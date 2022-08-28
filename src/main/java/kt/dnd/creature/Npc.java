package kt.dnd.creature;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Npc extends Creature {

    @Autowired
    private static NpcBasket npcBasket;

    private Boolean sex; // TRUE for male
    private Nature nature;
    private Behavior behavior;
    private String appearance;

    public Npc(String name, boolean isMale) {
        super(name);
        this.sex = Boolean.TRUE.equals(isMale);
        this.nature = Nature.getRandom();
        this.behavior = Behavior.getRandom();
        this.appearance = generateAppearance();
        System.out.println(this);
    }

    private String generateAppearance() {
        Random random = new Random();
        String aspects = "";

        List<String> cialo = Arrays.asList("szczupla", "regularna", "atletyczna", "masywna");
        aspects = aspects.concat("budowa ciala "+ cialo.get(random.nextInt(cialo.size())) + ", ");

        List<String> wzrost = Arrays.asList("niski", "wysoki");
        aspects = aspects.concat("wzrost "+ wzrost.get(random.nextInt(wzrost.size())) + ", ");

        List<String> wlosy = Arrays.asList("jasny blond", "ciemny blond", "jasno brazowe", "ciemno brazowe", "rude", "czarne");
        aspects = aspects.concat("wlosy "+ wlosy.get(random.nextInt(wlosy.size())) + ", ");

        if (sex) {
            List<String> zarost = Arrays.asList("gładko ogolony", "kilkudniowy zarost", "nosi wąsy", "ma wąsy i brodę", "nosi długą brodę");
            aspects = aspects.concat(zarost.get(random.nextInt(zarost.size())) + ", ");
        }

        switch (random.nextInt(10)) {
            case 1: aspects = aspects.concat("ma piegi"); break;
            case 2: aspects = aspects.concat("blizna na skroni"); break;
            case 3: aspects = aspects.concat("na przedramieniu widoczny tatuaz"); break;
            case 4:
            case 5: aspects = aspects.concat("nosi okulary"); break;
            default: aspects = aspects.concat("brak cech szczególnych");
        }

        List<String> ubranie1 = Arrays.asList("T-shirt", "koszula", "bluza");
        List<String> ubranie2 = Arrays.asList("jeansy", "szorty");
        aspects = aspects.concat(". Ubranie: "+ ubranie1.get(random.nextInt(ubranie1.size())) + " i ");
        aspects = aspects.concat(ubranie2.get(random.nextInt(ubranie2.size())));

        return aspects;
    }

    @Override
    public String toString() {
        return this.name + " ("+(sex ? "M" : "F")+") - " +
                "Charakter: " + nature + ". Zachowanie: " + behavior + ". Wyglad: " + appearance;
    }
}
