package kt.dnd.magic;

public enum Spell {
    BLIND(SpellSchool.ARCANE, 1, 3, 0, 0),
    CAT_FORM(SpellSchool.NATURE, 1, 8, 0, 0),
    CHARM(SpellSchool.ARCANE, 1, 2, 0, 0),
    FIREBALL(SpellSchool.FIRE, 1, 3, 2*1, 2*8),
    SPARKS(SpellSchool.AIR, 1, 3, 2*1, 2*6),
    REGROWTH(SpellSchool.NATURE, 1, 2, -2*1, -2*10);

    Spell(SpellSchool school, int level, int manaCost, int minDamage, int maxDamage) {}
}
