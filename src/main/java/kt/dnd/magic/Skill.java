package kt.dnd.magic;

public enum Skill {
    CAT_FORM_BITE (1, 2, 2, 7),
    CAT_FORM_SCRATCH (1, 2, 2, 8),
    CHARGE (1, 5, 0, 0),
    SHIELD_BASH (1, 5, 1, 0), /** effect: taunt for 2T, cooldown 2T */
    SPRINT(1, 3, 0, 0);

    Skill(int level, int energyCost, int minDmage, int maxDmage) {}
}
