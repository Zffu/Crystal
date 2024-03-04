package net.zffu.crystal.sequences;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.zffu.crystal.wrappers.WrappedPosition;
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
    private WrappedPosition lastPosition;

    /**
     * Starts playing the current {@link Sequence} instance.
     * @param position
     */
    public final void start(WrappedPosition position) {
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
        //todo: add core task wrapper
    }

    /**
     * Stops the {@link Sequence} instance.
     */
    public void stopSequence() {}

}
