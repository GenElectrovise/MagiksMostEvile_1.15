package genelectrovise.magiksmostevile.common.entity.evileAI.tasks;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import genelectrovise.magiksmostevile.common.entity.vampire_bat.VampireBat;
import genelectrovise.magiksmostevile.common.main.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class WanderFlying extends Goal {
	private FlyingEntity flyingEntity;
	private Random rand = new Random();

	WanderFlying(FlyingEntity entityIn) {
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		this.flyingEntity = entityIn;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		return flyingEntity.getNavigator().noPath() && rand.nextInt(10) == 0;
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting() {
		return flyingEntity.getNavigator().func_226337_n_();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		/*
		Vec3d vec3d = this.genBiasedRandomPos();
		if (vec3d != null) {
			flyingEntity.getNavigator().setPath(flyingEntity.getNavigator().getPathToPos(new BlockPos(vec3d), 1), 1.0D);
		}
		*/
		Main.LOGGER.debug("start execution!");

	}
	
	/*
	private List<VampireBat> getNearbyVampireBats(){
		List<VampireBat> vampireBats;
		List<? extends Entity> nearby = flyingEntity.world.getEntitiesWithinAABB(VampireBat.class,
				new AxisAlignedBB(
						new BlockPos(flyingEntity.getPosition().getX() + 25, flyingEntity.getPosition().getY() + 25,
								flyingEntity.getPosition().getZ() + 25),
						new BlockPos(flyingEntity.getPosition().getX() - 25, flyingEntity.getPosition().getY() - 25,
								flyingEntity.getPosition().getZ() - 25)));
		for(Entity e : nearby) {
			if (e instanceof VampireBat) {
				vampireBats.add((VampireBat) e);
			}
		}
		
		return vampireBats;
	}

	private Vec3d genBiasedRandomPos() {
		
	}

	@Nullable
	private Vec3d func_226509_g_() {
		Vec3d vec3d;
		if (flyingEntity.this.func_226422_eP_()
				&& !flyingEntity.this.func_226401_b_(flyingEntity.this.field_226369_bI_, 40)) {
			Vec3d vec3d1 = new Vec3d(flyingEntity.field_226369_bI_);
			vec3d = vec3d1.subtract(flyingEntity.this.getPositionVec()).normalize();
		} else {
			vec3d = flyingEntity.this.getLook(0.0F);
		}

		int i = 8;
		Vec3d vec3d2 = RandomPositionGenerator.func_226340_a_(flyingEntity.this, 8, 7, vec3d, ((float) Math.PI / 2F), 2,
				1);
		return vec3d2 != null ? vec3d2
				: RandomPositionGenerator.func_226338_a_(flyingEntity.this, 8, 4, -2, vec3d,
						(double) ((float) Math.PI / 2F));
	}
	*/

}
