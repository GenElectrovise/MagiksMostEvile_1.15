package genelectrovise.magiksmostevile.common.main;

import java.util.function.Supplier;

import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.AmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.OverPoweredAmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.PoweredAmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingAxe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingHoe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingItem;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingPickaxe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingShovel;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingSword;
import genelectrovise.magiksmostevile.common.main.support.EnumEvileArmorMaterial;
import genelectrovise.magiksmostevile.common.main.support.EnumEvileItemTier;
import genelectrovise.magiksmostevile.common.main.support.EvileItemGroup;
import genelectrovise.magiksmostevile.common.world.gen.ore.EvileOreFeature;
import genelectrovise.magiksmostevile.common.world.gen.ore.EvileOreFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EvileRegistry {
	private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MODID);
	private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MODID);
	private static final DeferredRegister<Feature<?>> ORE_GEN = new DeferredRegister<>(ForgeRegistries.FEATURES,
			Main.MODID);

	// =========BLOCKS======================================================================================================================
	public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block",
			() -> new Block(Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS)
					.lightValue(5 / 16).hardnessAndResistance(3F, 3F)));
	public static final RegistryObject<Block> AMETHYST_ORE_OVERWORLD = BLOCKS.register("amethyst_ore_overworld",
			() -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL)
					.hardnessAndResistance(5F, 5F)));
	public static final RegistryObject<Block> AMETHYST_ORE_NETHER = BLOCKS.register("amethyst_ore_nether",
			() -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL)
					.hardnessAndResistance(5F, 5F)));
	public static final RegistryObject<Block> AMETHYST_ORE_END = BLOCKS.register("amethyst_ore_end",
			() -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL)
					.hardnessAndResistance(5F, 5F)));

//=========BLOCK_ITEMS=================================================================================================================
	public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block",
			() -> new BlockItem(AMETHYST_BLOCK.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_OVERWORLD_ITEM = ITEMS.register("amethyst_ore_overworld",
			() -> new BlockItem(AMETHYST_ORE_OVERWORLD.get(),
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_NETHER_ITEM = ITEMS.register("amethyst_ore_nether",
			() -> new BlockItem(AMETHYST_ORE_NETHER.get(),
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_END_ITEM = ITEMS.register("amethyst_ore_end",
			() -> new BlockItem(AMETHYST_ORE_END.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========ITEMS=======================================================================================================================
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
			() -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST = ITEMS.register("powered_amethyst",
			() -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST = ITEMS.register("over_powered_amethyst",
			() -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> LESSER_POWER_STONE = ITEMS.register("lesser_power_stone",
			() -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> GREATER_POWER_STONE = ITEMS.register("greater_power_stone",
			() -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> GOING_TO_THE_BALL = ITEMS.register("going_to_the_ball",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INTRO_BOOK = ITEMS.register("intro_book",
			() -> new WrittenBookItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========TOOLS=======================================================================================================================
	public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
			() -> new SwordItem(EnumEvileItemTier.AMETHYST, 1, -0.5F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
			() -> new AxeItem(EnumEvileItemTier.AMETHYST, 1, -0.5F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
			() -> new PickaxeItem(EnumEvileItemTier.AMETHYST, 1, -0.5F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
			() -> new ShovelItem(EnumEvileItemTier.AMETHYST, 1, -0.5F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
			() -> new HoeItem(EnumEvileItemTier.AMETHYST, -0.5F,
					//
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_SWORD = ITEMS.register("powered_amethyst_sword",
			() -> new GlowingSword(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_AXE = ITEMS.register("powered_amethyst_axe",
			() -> new GlowingAxe(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_PICKAXE = ITEMS.register("powered_amethyst_pickaxe",
			() -> new GlowingPickaxe(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_SHOVEL = ITEMS.register("powered_amethyst_shovel",
			() -> new GlowingShovel(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_HOE = ITEMS.register("powered_amethyst_hoe",
			() -> new GlowingHoe(EnumEvileItemTier.POWERED_AMETHYST, -0.25F,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========TOMES======================================================================================================================
	public static final RegistryObject<Item> TOME_CONVERT_AMETHYST = ITEMS.register("tome_convert_amethyst",
			() -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========ARMOR======================================================================================================================
	public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
			() -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.HEAD,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
			() -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.CHEST,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
			() -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.LEGS,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
			() -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.FEET,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	//
	public static final RegistryObject<Item> POWERED_AMETHYST_HELMET = ITEMS.register("powered_amethyst_helmet",
			() -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.HEAD,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_CHESTPLATE = ITEMS.register("powered_amethyst_chestplate",
			() -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.CHEST,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_LEGGINGS = ITEMS.register("powered_amethyst_leggings",
			() -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.LEGS,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_BOOTS = ITEMS.register("powered_amethyst_boots",
			() -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.FEET,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	//
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_HELMET = ITEMS.register(
			"over_powered_amethyst_helmet",
			() -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.HEAD,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_CHESTPLATE = ITEMS.register(
			"over_powered_amethyst_chestplate",
			() -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST,
					EquipmentSlotType.CHEST, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_LEGGINGS = ITEMS.register(
			"over_powered_amethyst_leggings",
			() -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.LEGS,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_BOOTS = ITEMS.register("over_powered_amethyst_boots",
			() -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.FEET,
					new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========FOOD========================================================================================================================
	public static final RegistryObject<Item> AMETHYST_POTATO = ITEMS.register("amethyst_potato",
			() -> new Item(new Item.Properties()
					.food((new Food.Builder()).hunger(3).saturation(0.8F)
							.effect(new EffectInstance(Effects.SPEED, 400, 1), 1.0F).fastToEat().build())
					.group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========GENERATION==================================================================================================================
	public static final RegistryObject<EvileOreFeature> AMETHYST_ORE_OVERWORLD_GEN = ORE_GEN
			.register("amethyst_ore_overworld_gen", () -> new EvileOreFeature(EvileOreFeatureConfig::deserialize));

//=========CONSTRUCTOR=================================================================================================================

	public EvileRegistry() {
		Main.LOGGER.debug("Constructing EvileRegistry!");
		Main.LOGGER.debug("Log Key 182727012020 : FMLJavaModLoadingContext = " + FMLJavaModLoadingContext.get());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
