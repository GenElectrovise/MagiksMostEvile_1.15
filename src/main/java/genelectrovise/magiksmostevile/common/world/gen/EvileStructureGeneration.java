package genelectrovise.magiksmostevile.common.world.gen;

import genelectrovise.magiksmostevile.common.main.registry.EvileDeferredRegistry;
import genelectrovise.magiksmostevile.common.world.gen.shrine.ShrineFeatureConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.registries.ForgeRegistries;

public class EvileStructureGeneration {

	public static void addShrines() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			//biome.addFeature(Decoration.SURFACE_STRUCTURES, EvileDeferredRegistry.SHRINE_FEATURE.get().func_225566_b_(ShrineFeatureConfig::deserialize));
			//biome.addFeature(Decoration.SURFACE_STRUCTURES, EvileDeferredRegistry.SHRINE_FEATURE.get().func_225566_b_(new ShrineFeatureConfig(biome)));
		}
		
	}

}
