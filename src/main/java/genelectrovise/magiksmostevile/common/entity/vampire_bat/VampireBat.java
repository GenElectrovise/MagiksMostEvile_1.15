package genelectrovise.magiksmostevile.common.entity.vampire_bat;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.world.World;

public class VampireBat extends FlyingEntity implements IFlyingAnimal {

	protected VampireBat(EntityType<? extends FlyingEntity> type, World world) {
		super(type, world);
	}

	public VampireBat() {
		new VampireBat();
	}
	
}