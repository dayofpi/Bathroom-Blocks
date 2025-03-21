package su.bathroom.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import su.bathroom.entity.BouncyBallEntity;

public class BouncyBallItem extends Item {
    public BouncyBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.5f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient()) {
            BouncyBallEntity bouncyBall = new BouncyBallEntity(world, user);
            bouncyBall.setItem(itemStack);
            bouncyBall.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.8f, 1.0f);
            world.spawnEntity(bouncyBall);
        }

        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
