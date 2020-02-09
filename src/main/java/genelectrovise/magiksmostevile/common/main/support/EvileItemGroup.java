package genelectrovise.magiksmostevile.common.main.support;

import genelectrovise.magiksmostevile.common.main.EvileRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EvileItemGroup {
	public static final ItemGroup ITEMGROUP_EVILE = new ItemGroup("itemgroup_evile") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(EvileRegistry.AMETHYST.get());
		}
	};
}
