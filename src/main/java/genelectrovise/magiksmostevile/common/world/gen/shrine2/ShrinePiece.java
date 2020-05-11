package genelectrovise.magiksmostevile.common.world.gen.shrine2;

import java.util.Random;

import genelectrovise.magiksmostevile.common.main.reference.StructureReference;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class ShrinePiece {

	public static class Piece extends TemplateStructurePiece {

		public Piece(TemplateManager templateManager, CompoundNBT nbt) {
			super(Shrine2.CENTRE_PIECE, nbt);
			this.setupTemplate(templateManager);
		}

		public Piece(TemplateManager templateMgr, ResourceLocation resLoc, BlockPos blockPos, Rotation rot, int offsetY) {
			super(Shrine2.CENTRE_PIECE, 0);
			this.templatePosition = new BlockPos(blockPos.getX(), blockPos.getY() - offsetY, blockPos.getZ());
			this.setupTemplate(templateMgr);
		}

		private void setupTemplate(TemplateManager templateManager) {
			Template template = templateManager.getTemplateDefaulted(StructureReference.SHRINE_LOC);
			PlacementSettings settings = (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE).setCenterOffset(BlockPos.ZERO).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
			this.setup(template, this.templatePosition, settings);
		}

		@Override
		public boolean func_225577_a_(IWorld worldIn, ChunkGenerator<?> generator, Random rand, MutableBoundingBox mutableBB, ChunkPos pos) {
			PlacementSettings placementSettings = (new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setCenterOffset(BlockPos.ZERO).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK));
			BlockPos blockpos1 = this.templatePosition.add(Template.transformedBlockPos(placementSettings, new BlockPos(3, 0, 0)));
			int structHeight = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
			this.templatePosition = this.templatePosition.add(0, structHeight, 0);
			boolean superReturn = super.func_225577_a_(worldIn, generator, rand, mutableBB, pos);
			return superReturn;
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
			System.out.println("Unnecessary method, but must implement!");
		}

	}

}
