package net.zffu.crystal.holograms;

import net.zffu.crystal.utils.Position;
import net.zffu.crystal.wrappers.WrappedMaterial;

/**
 * Represents a basic hologram that was not converted by any software-adapters.
 */
public interface AnimatedHologram {

    /**
     * The position of the hologram.
     */
    Position getHologramPosition();


    /**
     * Material of the hologram.
     */
    WrappedMaterial<?> getMaterial();

    /**
     * Is the hologram animated.
     */
    boolean isAnimated();

}
