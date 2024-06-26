package dev.darkar.cog_works.block;

import dev.darkar.cog_works.block.entity.TransmissionShaftBlockEntity;
import dev.darkar.cog_works.block.property.BuildMaterialProperty;
import dev.darkar.cog_works.utils.enums.BuildMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class TransmissionShaftBlock extends Block implements EntityBlock {
	
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BuildMaterialProperty SHAFT_MATERIAL = BuildMaterialProperty.create("shaft_material");
	
	private static final Properties blockProperties = Properties.of()
		.strength(2.0F)
		.requiresCorrectToolForDrops()
		.lightLevel(state -> 7)
		.sound(SoundType.METAL)
		.noOcclusion();
	
	public TransmissionShaftBlock() {
		super(blockProperties);
		
		registerDefaultState(stateDefinition.any()
		                                    .setValue(FACING, Direction.NORTH)
		                                    .setValue(SHAFT_MATERIAL, BuildMaterial.STONE)
		                    );
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new TransmissionShaftBlockEntity(pPos, pState);
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
		builder.add(SHAFT_MATERIAL);
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}
}
