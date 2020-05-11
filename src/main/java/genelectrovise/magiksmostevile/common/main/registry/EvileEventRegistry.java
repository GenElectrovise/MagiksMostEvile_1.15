package genelectrovise.magiksmostevile.common.main.registry;

import java.util.Iterator;

import genelectrovise.magiksmostevile.common.main.Main;
import genelectrovise.magiksmostevile.common.main.reference.StructureReference;
import genelectrovise.magiksmostevile.common.world.gen.shrine2.Shrine2;
import genelectrovise.magiksmostevile.common.world.gen.shrine2.ShrinePiece;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber
public class EvileEventRegistry {

	// Shrine

	@ObjectHolder(Main.MODID + ":shrine")
	public static Structure<NoFeatureConfig> SHRINE_CENTRE;

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void addShrineToBiomes(FMLCommonSetupEvent event) {
		System.out.println("Adding shrines to biomes...");
		DeferredWorkQueue.runLater(() -> {
			Iterator<Biome> iterator = ForgeRegistries.BIOMES.iterator();
			iterator.forEachRemaining((biome) -> {
				biome.addStructure(SHRINE_CENTRE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, SHRINE_CENTRE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			});
		});
	}

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		System.out.println("Registering features");
		Shrine2.CENTRE_PIECE = Registry.register(Registry.STRUCTURE_PIECE, StructureReference.SHRINE_LOC, ShrinePiece.Piece::new);
		event.getRegistry().register(new Shrine2(NoFeatureConfig::deserialize).setRegistryName(StructureReference.SHRINE_LOC));
	}

}
