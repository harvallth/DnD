package kt.dnd.magic;

public enum Spell {
    BLIND(SpellSchool.ARCANE, 1, 3, 0),
    CAT_FORM(SpellSchool.NATURE, 1, 8, 0),
    CHARM(SpellSchool.ARCANE, 1, 2, 0),
    FIREBALL(SpellSchool.FIRE, 1, 3, 2*8),
    SPARKS(SpellSchool.AIR, 1, 3, 2*6),
    REGROWTH(SpellSchool.NATURE, 1, 2, 0);

    Spell(SpellSchool school, int level, int manaCost, int damage) {}
}
