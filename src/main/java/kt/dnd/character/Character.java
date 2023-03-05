package kt.dnd.character;

import kt.dnd.items.Gold;
import kt.dnd.items.Item;
import kt.dnd.magic.Skill;
import kt.dnd.magic.Spell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Character {
    public String name;
    public Race race;
    private Stat STR;
    private Stat DEX;
    private Stat CON;
    private Stat WIS;
    private Stat PER;
    private Stat CHA;

    private List<Trait> traits = new ArrayList<>();
    private List<Perk> perks = new ArrayList<>();
    private List<Spell> spells = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Item> equipment = new ArrayList<>();

    public Character(String name, Race race, List<Stat> stats) {
        this.name = name;
        this.race = race;
        this.STR = stats.get(0);
        this.DEX = stats.get(1);
        this.CON = stats.get(2);
        this.WIS = stats.get(3);
        this.PER = stats.get(4);
        this.CHA = stats.get(5);
    }

    public static Character createRandomCharacter() {
        String name = "Random";
        List<Stat> stats = Stat.random();

        Race race = (Race.values()[new Random().nextInt(Race.values().length)]);

        Character character = createCharacter(name, race, stats);

        int index = new Random().nextInt(Perk.values().length);
        character.addPerk(Perk.values()[index]);

        index = new Random().nextInt(Trait.values().length);
        character.addTrait(Trait.values()[index]);

        if (character.getWIS().getValue() > 7) {
            for (int i=0; i<4; i++) {
                index = new Random().nextInt(Spell.values().length);
                character.addSpell(Spell.values()[index]);
            }
        }

        character.addItem(Gold.of(20));

        return character;
    }

    public String getName() {
        return name;
    }

    public Stat getSTR() {
        return STR;
    }

    public Stat getDEX() {
        return DEX;
    }
    public Stat getCON() {
        return CON;
    }
    public Stat getWIS() {
        return WIS;
    }
    public Stat getPER() {
        return PER;
    }
    public Stat getCHA() {
        return CHA;
    }

    private int getHealth() {
        return 5*CON.getValue() + 5;
    }

    private int getMana() {
        return 3*WIS.getValue() + 10;
    }

    private int getEnergy() {
        return 3*CON.getValue() + 5;
    }

    public int getDodgeChance() {
        int modifier = 0;
        if (perks.contains(Perk.AGILE))
            modifier += 1;
        if (perks.contains(Perk.SIXTH_SENSE))
            modifier += 1;
        return (int) (Math.ceil(DEX.getValue() / 3) + modifier);
    }

    public int getParryChance() {
        return (int) (Math.ceil(STR.getValue() / 3));
    }

    public int getBlockChance() {
        return (int) (Math.ceil(STR.getValue() / 2));
    }

    public int getBlockBonus() {
        return (int) (Math.ceil(STR.getValue() / 4));
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public List<Perk> getPerks() {
        return perks;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public List<Item> getEquipment() {
        return equipment;
    }

    public void addTrait(Trait... traits) {
        for (Trait trait : traits) {
            if (!this.traits.contains(trait)) {
                this.traits.add(trait);
            }
        }
    }

    public void addPerk(Perk... perks) {
        for (Perk perk : perks) {
            if (!this.perks.contains(perk)) {
                this.perks.add(perk);
            }
        }
    }

    public void addSpell(Spell... spells) {
        for (Spell spell :spells) {
            if (!this.spells.contains(spell)) {
                this.spells.add(spell);
            }
        }
    }

    public void addSkill(Skill... skills) {
        for (Skill skill :skills) {
            if (!this.skills.contains(skill)) {
                this.skills.add(skill);
            }
        }
    }

    public void addItem(Item item) {
        equipment.add(item);
    }

    public static Character createCharacter(String name, Race race, List<Stat> stats) {
        Character character;

        if (stats.size() == 9) {
            Stat min = stats.stream().min(Comparator.comparing(Stat::getValue)).get();
            stats.remove(min);
            System.out.println("removed: " + min.getValue());

            min = stats.stream().min(Comparator.comparing(Stat::getValue)).get();
            stats.remove(min);
            System.out.println("removed: " + min.getValue());

            Stat max = stats.stream().max(Comparator.comparing(Stat::getValue)).get();
            stats.remove(max);
            System.out.println("removed: " + max.getValue());

        }

        character = new Character(name, race, stats);
        System.out.println("created character "+ character.getName() +" with race " + character.race + " and stats: " + character.getSTR().getValue() + " " + character.getDEX().getValue() + " " +
                character.getCON().getValue() + " " + character.getWIS().getValue() + " " + character.getPER().getValue() + " " + character.getCHA().getValue());

        character.addSkill(Skill.SPRINT);

        return character;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", STR=" + STR.getValue() +
                ", DEX=" + DEX.getValue() +
                ", CON=" + CON.getValue() +
                ", WIS=" + WIS.getValue() +
                ", PER=" + PER.getValue() +
                ", CHA=" + CHA.getValue() +
                ", traits=" + traits +
                ", perks=" + perks +
                ", spells=" + spells +
                ", equipment=" + equipment +
                '}';
    }
}
