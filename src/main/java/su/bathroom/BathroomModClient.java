package su.bathroom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import su.bathroom.entity.PigCreeperEntityRenderer;

@Environment(EnvType.CLIENT)
public class BathroomModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(BathroomMod.PIG_CREEPER_ENTITY, PigCreeperEntityRenderer::new);
		EntityRendererRegistry.register(BathroomMod.BOUNCY_BALL_ENTITY, FlyingItemEntityRenderer::new);
	}
}
