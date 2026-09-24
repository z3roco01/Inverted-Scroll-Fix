package z3roco01.revinverted.client.mixin;

import net.minecraft.client.ScrollWheelHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScrollWheelHandler.class)
public abstract class ScrollWheelHandlerMixin {
    @Inject(method = "getNextScrollWheelSelection", at = @At("HEAD"), cancellable = true)
    private static void getNextScrollWheelSelection(double wheel, int currentSelected, int limit, CallbackInfoReturnable<Integer> cir) {
        int step = (int)Math.signum(wheel);
        currentSelected += step;
        currentSelected = Math.max(-1, currentSelected);

        while (currentSelected < 0) {
            currentSelected += limit;
        }

        while (currentSelected >= limit) {
            currentSelected -= limit;
        }

        cir.setReturnValue(currentSelected);
        cir.cancel();
    }
}
