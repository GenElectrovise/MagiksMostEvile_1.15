package genelectrovise.magiksmostevile.common.world.gen;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;

public class EvileOreFeatureConfig {

	public final EvileOreFeatureConfig.EvileOreFillerBlockType target;
	public final int size;
	public final BlockState state;

	public EvileOreFeatureConfig(EvileOreFeatureConfig.EvileOreFillerBlockType target, BlockState state, int size) {
		this.size = size;
		this.state = state;
		this.target = target;
	}

	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return new Dynamic<>(ops,
				ops.createMap(ImmutableMap.of(ops.createString("size"), ops.createInt(this.size),
						ops.createString("target"), ops.createString(this.target.func_214737_a()),
						ops.createString("state"), BlockState.serialize(ops, this.state).getValue())));
	}

	public static EvileOreFeatureConfig deserialize(Dynamic<?> p_214641_0_) {
		int i = p_214641_0_.get("size").asInt(0);
		EvileOreFeatureConfig.EvileOreFillerBlockType orefeatureconfig$fillerblocktype = EvileOreFeatureConfig.EvileOreFillerBlockType
				.func_214736_a(p_214641_0_.get("target").asString(""));
		BlockState blockstate = p_214641_0_.get("state").map(BlockState::deserialize)
				.orElse(Blocks.AIR.getDefaultState());
		return new EvileOreFeatureConfig(orefeatureconfig$fillerblocktype, blockstate, i);
	}

	public static enum EvileOreFillerBlockType implements net.minecraftforge.common.IExtensibleEnum {
		NATURAL_STONE("natural_stone", (p_214739_0_) -> {
			if (p_214739_0_ == null) {
				return false;
			} else {
				Block block = p_214739_0_.getBlock();
				return block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE
						|| block == Blocks.ANDESITE;
			}
		}), NETHERRACK("netherrack", new BlockMatcher(Blocks.NETHERRACK));

		private static final Map<String, EvileOreFeatureConfig.EvileOreFillerBlockType> field_214741_c = Arrays
				.stream(values()).collect(Collectors.toMap(EvileOreFeatureConfig.EvileOreFillerBlockType::func_214737_a,
						(p_214740_0_) -> {
							return p_214740_0_;
						}));
		private final String field_214742_d;
		private final Predicate<BlockState> field_214743_e;

		private EvileOreFillerBlockType(String p_i50618_3_, Predicate<BlockState> p_i50618_4_) {
			this.field_214742_d = p_i50618_3_;
			this.field_214743_e = p_i50618_4_;
		}

		public String func_214737_a() {
			return this.field_214742_d;
		}

		public static EvileOreFeatureConfig.EvileOreFillerBlockType func_214736_a(String p_214736_0_) {
			return field_214741_c.get(p_214736_0_);
		}

		public Predicate<BlockState> func_214738_b() {
			return this.field_214743_e;
		}

		public static EvileOreFillerBlockType create(String enumName, String p_i50618_3_,
				Predicate<BlockState> p_i50618_4_) {
			throw new IllegalStateException("Enum not extended");
		}

		@Override
		@Deprecated
		public void init() {
			field_214741_c.put(func_214737_a(), this);
		}

	}
}