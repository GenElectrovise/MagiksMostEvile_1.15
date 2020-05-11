package genelectrovise.magiksmostevile.common.world.gen.shrine;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ResourceLocationException;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

public class ShrineFeature extends Feature<IFeatureConfig> {

	private static final ResourceLocation SHRINE_TEMPLATE = new ResourceLocation("magiksmostevile",
			"structure/shrine/shrine_template.nbt");

	public ShrineFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, IFeatureConfig config) {

		if (!worldIn.isRemote()) {
			ServerWorld serverWorld = (ServerWorld) worldIn;
			TemplateManager manager = serverWorld.getStructureTemplateManager();

			Template template;
			try {
				template = manager.getTemplate(SHRINE_TEMPLATE);
			} catch (ResourceLocationException r) {
				System.err.println("The resource " + SHRINE_TEMPLATE + " does not exist!");
				return false;
			}

			return build(template, worldIn, pos, rand);

		}
		return false;
	}

	private boolean build(Template template, IWorld worldIn, BlockPos pos, Random rand) {

		try {
			PlacementSettings placement = new PlacementSettings();

			switch (rand.nextInt(4)) {
			case (0):
				placement.setRotation(Rotation.NONE);
				break;
			case (1):
				placement.setRotation(Rotation.CLOCKWISE_90);
				break;
			case (2):
				placement.setRotation(Rotation.CLOCKWISE_180);
				break;
			case (3):
				placement.setRotation(Rotation.COUNTERCLOCKWISE_90);
				break;
			}

			template.addBlocksToWorld(worldIn, pos, placement);
		} catch (Exception e) {
			System.err.println("Error generating ShrineFeature!");
			System.err.println("Template : " + template.toString());
			System.err.println("World : " + worldIn);
			System.err.println("BlockPos : " + pos);
			System.err.println("Random : " + rand);
			e.printStackTrace();
		}
		return true;
	}

}
