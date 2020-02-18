package genelectrovise.magiksmostevile.common.entity.vampire_bat;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

public class VampireBat extends MonsterEntity {

	public VampireBat(EntityType<? extends VampireBat> type, World world) {
		super(type, world);
		this.setNoGravity(true);
		this.setPathPriority(PathNodeType.STICKY_HONEY, 0.1F);
	}

}