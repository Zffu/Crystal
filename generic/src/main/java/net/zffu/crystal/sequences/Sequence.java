package net.zffu.crystal.sequences;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.zffu.crystal.Crystal;
import net.zffu.crystal.CrystalPlatform;
import net.zffu.crystal.holograms.AnimatedHologram;
import net.zffu.crystal.utils.Position;
import net.zffu.crystal.wrappers.task.WrappedRunnable;

/**
 * Represents a simple animation sequence. A Sequence is an animation series of stuff happening on the player's view.
 */
public abstract class Sequence {

    /**
     * Time (in ticks) before triggering the next frame.
     */
    @Setter(AccessLevel.PROTECTED)
    private int ticksPerFrame = 20;

    /**
     * Last position that was used in the {@link Sequence}.
     */
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private Position lastPosition;

    /**
     * Starts playing the current {@link Sequence} instance.
     * @param position
     */
    public final void start(Position position) {
        this.lastPosition = position;
    }

    /**
     * Called automatically on sequence start, you should start your animation in that function.
     */
    protected abstract void onStart();

    /**
     * Starts the next sequence based on a {@link WrappedRunnable} for the execution.
     * @param runnable
     */
    protected final void startNextSequence(WrappedRunnable runnable) {
        Crystal.getAdapter().scheduleTask(runnable, this.ticksPerFrame);
    }

    /**
     * Stops the {@link Sequence} instance.
     */
    public void stopSequence() {}

    /**
     * Constructs a basic {@link AnimatedHologram}.
     * @param pos the position.
     * @param material the material.
     * @return the built hologram.
     */
    private AnimatedHologram fabricHologram(Position pos, Object material) {
        return Crystal.getAdapter().constructHologram(pos, material);
    }

    /**
     * Makes a basic hologram and spawns it
     * @param position the position
     * @param material the material.
     */
    public void makeAnimatedHologram(Position position, Object material) {
        fabricHologram(position, material).summon();
    }

    /**
     * Makes a basic hologram and spawns it
     * @param material the material.
     */
    public void makeAnimatedHologram(Object material) {
        fabricHologram(this.lastPosition, material).summon();
    }

    /**
     * Makes an advanced hologram and spawns it
     * @param material the material.
     * @param animated is the hologram animated or not
     * @param animateSides should the hologram animate to sides
     * @param animateUpAndDown should the hologram animate up and down.
     */
    public void makeAnimatedHologram(Object material, boolean animated, boolean animateSides, boolean animateUpAndDown) {
        AnimatedHologram hologram = fabricHologram(this.lastPosition, material);
        hologram.setAnimated(animated);
        hologram.setRotatingToSides(animateSides);
        hologram.setRotatingUpAndDown(animateUpAndDown);
        hologram.summon();
    }

}
