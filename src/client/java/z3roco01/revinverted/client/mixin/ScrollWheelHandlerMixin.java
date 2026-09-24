package z3roco01.revinverted.client.mixin;

import net.minecraft.client.ScrollWheelHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScrollWheelHandler.class)
public abstract class ScrollWheelHandlerMixin {
    @Inject(method = "getNextScrollWheelSelection", at = @At("RETURN"))
    private static void getNextScrollWheelSelection(double wheel, int currentSelected, int limit, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(cir.getReturnValueI() * -1);
    }
}
