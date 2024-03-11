package net.zffu.crystal;

import net.zffu.crystal.holograms.AnimatedHologram;
import net.zffu.crystal.utils.Position;
import net.zffu.crystal.wrappers.task.WrappedRunnable;

/**
 * Abstract Crystal's Adapter.
 * Used for multi software compatibility.
 */
public abstract class AbstractCrystalAdapter {

    /**
     * Adapts the Material's registry name into an actual material.
     * @param registryName the registry name of the material.
     * @return the material.
     */
    public abstract Object adaptMaterial(String registryName);

    /**
     * Schedules the {@link WrappedRunnable} into the platform's scheduler.
     * @param runnable the runnable.
     * @param ticks the amount of ticks.
     */
    public abstract void scheduleTask(WrappedRunnable runnable, int ticks);

    /**
     * Constructs an {@link AnimatedHologram}.
     * @param position the position.
     * @param material the material.
     * @return the built {@link AnimatedHologram}.
     */
    public abstract AnimatedHologram constructHologram(Position position, Object material);

}
