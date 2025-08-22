package world.maryt.exuslashblade.se;

import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;

public class SELoader {
	public static ISpecialEffect Newbie;
    public static ISpecialEffect SoulDevourer;

	public SELoader() {
		Newbie = SpecialEffects.register(new Newbie());
        SoulDevourer = SpecialEffects.register(new SoulDevourer());
	}
}
