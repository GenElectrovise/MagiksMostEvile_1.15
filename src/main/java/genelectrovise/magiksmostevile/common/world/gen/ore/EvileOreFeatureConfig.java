package genelectrovise.magiksmostevile.common.world.gen.ore;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EvileOreFeatureConfig extends OreFeatureConfig {
	
	//public static final FillerBlockType FILLER_BLOCK_END_STONE = FillerBlockType.create("filler_block_end_stone", Blocks.END_STONE, new Predicate<BlockState>(Blocks.END_STONE.getDefaultState()));

	public EvileOreFeatureConfig(FillerBlockType target, BlockState state, int size) {
		super(target, state, size);
	}
	
}
