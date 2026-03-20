package denizen.easytrashcan.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import denizen.easytrashcan.block.furniture.StumpBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FaceAttachedHorizontalDirectionalBlock.class)
public class FaceAttachedHorizontalDirectionalBlockMixin {
    @WrapOperation(method = "canAttach", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;isFaceSturdy(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z"))
    private static boolean allowButtonsOnStumps(BlockState instance, BlockGetter blockGetter, BlockPos pos, Direction direction, Operation<Boolean> original) {
        if (instance.getBlock() instanceof StumpBlock) {
            return instance.getValue(StumpBlock.FACING).getAxis() == direction.getAxis();
        }

        return original.call(instance, blockGetter, pos, direction);
    }
}
