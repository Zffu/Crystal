package net.zffu.crystal.minestom;

import lombok.Getter;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.SharedInstance;
import net.minestom.server.item.Material;
import net.minestom.server.timer.TaskSchedule;
import net.zffu.crystal.AbstractCrystalAdapter;
import net.zffu.crystal.holograms.AnimatedHologram;
import net.zffu.crystal.minestom.holograms.MinestomAnimatedHologram;
import net.zffu.crystal.utils.Position;
import net.zffu.crystal.wrappers.task.WrappedRunnable;

/**
 * Adapter for Minestom.
 */
@Getter
public class MinestomCrystalAdapter extends AbstractCrystalAdapter {

    private SharedInstance instance;

    public MinestomCrystalAdapter(SharedInstance instance) {
        this.instance = instance;
    }

    @Override
    public Object adaptMaterial(String registryName) {
        return Material.fromNamespaceId(registryName);
    }

    @Override
    public void scheduleTask(WrappedRunnable runnable, int ticks) {
        MinecraftServer.getSchedulerManager().submitTask(() -> {
            runnable.run();
            return TaskSchedule.tick(ticks);
        });
    }

    @Override
    public AnimatedHologram constructHologram(Position position, Object material) {
        return new MinestomAnimatedHologram(position, material);
    }


}
