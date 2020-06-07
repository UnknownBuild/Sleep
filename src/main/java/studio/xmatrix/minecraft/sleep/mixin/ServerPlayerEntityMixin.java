package studio.xmatrix.minecraft.sleep.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;


@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "sleep", at = @At(value = "RETURN"))
    private void onSleep(CallbackInfo ci) {
        ServerPlayerEntity self = (ServerPlayerEntity) (Object) this;
        MinecraftServer minecraftServer = self.getServer();
        MutableText text = new LiteralText(self.getName().asString())
                .formatted(Formatting.YELLOW)
                .append(new LiteralText(" 喊你睡觉觉啦").formatted(Formatting.AQUA));
        Objects.requireNonNull(minecraftServer).getPlayerManager().sendToAll(text);
    }
}
