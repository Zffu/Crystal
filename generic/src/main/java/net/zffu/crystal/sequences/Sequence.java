package net.zffu.crystal.sequences;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.HashMap;

/**
 * Represents a simple animation sequence. A Sequence is an animation series of stuff happening on the player's view.
 */
public class Sequence {

    /**
     * Time (in ticks) before triggering the next frame.
     */
    @Setter(AccessLevel.PROTECTED)
    private int ticksPerFrame = 20;



}
