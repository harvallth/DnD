package kt.dnd;

import kt.dnd.character.*;
import kt.dnd.character.Character;
import kt.dnd.commands.*;
import kt.dnd.items.Gold;
import kt.dnd.items.armory.*;
import kt.dnd.magic.Skill;
import kt.dnd.magic.Spell;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
@ComponentScan
public class DnD {
    private static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kt.dnd");

    private static Character harv;
    private static Character nyria;
    private static Character yuuko;
    private static Character elli;
    private static Character amanda;
    private static Character julian;
    private static Character eldric;
    private static Character marcus;
    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

    static {
        harv = Character.createCharacter("Harv", Stat.of(7, 1, 8, 4, 7, 4));
        harv.addPerk(Perk.LIMP, Perk.LIMP, Perk.LIMP);
        harv.addSkill(Skill.SHIELD_BASH);
        harv.addItem(Gold.of(52));
        harv.addItem(new Weapon("Ciezki miedziany buzdygan", "K6 + 3"));
        harv.addItem(new Shield("Lekki pawęż", "K6 + 1"));
        harv.addItem(new Armor("Miedziana kolcza kamizelka", Armor.Type.CHAINMAIL, BodyPart.CHEST, 3));
        harv.addItem(new Armor("Miedziane kolcze spodnie", Armor.Type.CHAINMAIL, BodyPart.LEGS, 2));
        harv.addItem(new Armor("Miedziane kolcze rekawice", Armor.Type.CHAINMAIL, BodyPart.HANDS, 2));
        harv.addItem(new Armor("Miedziane kolcze buty", Armor.Type.CHAINMAIL, BodyPart.FEET, 2));
        harv.addItem(new Armor("Miedziane kolcze naramienniki", Armor.Type.CHAINMAIL, BodyPart.SHOULDERS, 2));

        nyria = Character.createCharacter("Nyria", Stat.of(6, 10, 6, 4, 7, 3));
        nyria.addPerk(Perk.AGILE, Perk.EAGLE_EYE, Perk.BRAWLER, Perk.HERMIT, Perk.THROWING_PROFICIENCY, Perk.GROUND_FIGHTING);
        nyria.addItem(Gold.of(59));
        nyria.addItem(new Weapon("Sztylet", "K6"));
        nyria.addItem(new Weapon("Wlocznia", "K8 + 2"));
        nyria.addItem(new Weapon("Noze do rzucania (5)", "K4 + 2"));
        nyria.addItem(new Armor("Leather chest", Armor.Type.LEATHER, BodyPart.CHEST, 2));
        nyria.addItem(new Armor("Leather pants", Armor.Type.LEATHER, BodyPart.LEGS, 2));
        nyria.addItem(new Armor("Leather gloves", Armor.Type.LEATHER, BodyPart.HANDS, 1));
        nyria.addItem(new Armor("Leather boots", Armor.Type.LEATHER, BodyPart.FEET, 1));

        yuuko = Character.createCharacter("Yuuko", Stat.of(3, 5, 1, 8, 6, 8));
        yuuko.addPerk(Perk.PYROPHOBIA, Perk.INNER_FIRE, Perk.WANTED, Perk.POSSESSED, Perk.CHARISMATIC, Perk.SIXTH_SENSE, Perk.ARCANE_MASTERY);
        yuuko.addSpell(Spell.FIREBALL, Spell.SPARKS, Spell.BLIND, Spell.CHARM);
        yuuko.addItem(Gold.of(40));
        yuuko.addItem(new Armor("Robe", Armor.Type.CLOTH, BodyPart.CHEST, 1));

        elli = Character.createCharacter("Elli", Stat.of(6, 10, 6, 4, 7, 3));
        elli.addPerk(Perk.KNIGHT_IN_SHINING_ARMOR, Perk.SWORDSMAN, Perk.SHY);
        elli.addSkill(Skill.CHARGE);
        elli.addItem(Gold.of(55));
        elli.addItem(new Weapon("Ten Jedyny", "K10"));
        elli.addItem(new Armor("chest", Armor.Type.LEATHER, BodyPart.CHEST, 2));
        elli.addItem(new Armor("legi", Armor.Type.LEATHER, BodyPart.LEGS, 2));
        elli.addItem(new Armor("buty", Armor.Type.LEATHER, BodyPart.FEET, 1));
        elli.addItem(new Armor("naramienniki", Armor.Type.LEATHER, BodyPart.SHOULDERS, 1));

        amanda = Character.createCharacter("Amanada", Stat.of(1, 4, 4, 10, 7, 6));
        amanda.addPerk(Perk.CALL_OF_THE_WOODS, Perk.CHARLATAN, Perk.DISTRACTED);
        amanda.addSpell(Spell.REGROWTH, Spell.CAT_FORM);
        amanda.addSkill(Skill.CAT_FORM_BITE, Skill.CAT_FORM_SCRATCH);
        amanda.addItem(Gold.of(57));
        amanda.addItem(new Weapon("Macka jakas", "K6 + 1"));
        amanda.addItem(new Armor("Robe", Armor.Type.CLOTH, BodyPart.CHEST, 1));

        julian = Character.createCharacter("Julian 'Menda' Otis", Stat.of(2, 4, 1, 10, 6, 7));
        marcus = Character.createCharacter("Marcus", Stat.of(6, 10, 4, 2, 7, 1));
        eldric = Character.createCharacter("Eldric", Stat.of(0, 0, 0, 0, 0, 0));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            System.out.print("> ");
            input = reader.readLine().toUpperCase(Locale.ROOT);
            try {
                System.out.println(LocalDateTime.now().format(formatter) + "\t::\t" + input);
                processCommands(input);
            } catch (IllegalArgumentException e) {
                System.out.println("\t??? -> " + e.getMessage());
            }
        } while (!input.equals("BREAK"));
    }

    private static void processCommands(String input) {
        determineCommands(input).execute();
//        CommandHandler.process(determineCommands(input));
        //TODO: move determine to commandHalnder (facade class)
    }

    private static RootCommand determineCommands(String input) {
        List<String> inputSplitted = Arrays.asList(input.split(" "));
        RootCommand rootCommand = RootCommand.of(inputSplitted.get(0));
        rootCommand.attachParams(inputSplitted.subList(1, inputSplitted.size()));

        switch (rootCommand.getValue()) {
            case "PLAYER":
                bindCommands(rootCommand, applicationContext.getBean(PlayerCommand.class));
            case "ENEMY":
                bindCommands(rootCommand, applicationContext.getBean(EnemyCommand.class));
            case "NPC":
                bindCommands(rootCommand, applicationContext.getBean(NpcCommand.class));
            case "LOOT":
                bindCommands(rootCommand, applicationContext.getBean(LootCommand.class));
            case "COMBAT":
                bindCommands(rootCommand, applicationContext.getBean(CombatCommand.class));
            default:
                break;
        }

        return rootCommand;
    }

    private static void bindCommands(Command parent, Command child) {
        parent.addChild(child);
        child.addParent(parent);
    }
}
