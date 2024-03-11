package net.zffu.crystal.holograms;

import net.zffu.crystal.utils.Position;

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
    Object getMaterial();

    /**
     * Is the hologram animated.
     */
    boolean isAnimated();

    /**
     * Summons the hologram.
     */
    void summon();

    /**
     * Sets the hologram position.
     * @param hologramPosition the new position of the hologram.
     */
    void setHologramPosition(Position hologramPosition);

    /**
     * Sets the new material of the Hologram.
     * @param material the new material.
     */
    void setMaterial(Object material);

    /**
     * Sets if the hologram is animated or not.
     * @param animated
     */
    void setAnimated(boolean animated);

    /**
     * Should the hologram rotate up and down (vertically).
     * @return
     */
    boolean isRotatingUpAndDown();

    /**
     * Should the hologram rotate to the sides.
     * @return
     */
    boolean isRotatingToSides();

    /**
     * Sets the hologram should rotate up and down.
     * @param rotatingUpAndDown
     */
    void setRotatingUpAndDown(boolean rotatingUpAndDown);

    /**
     * Sets if the hologram should rotate to the sides.
     * @param rotatingToSides
     */
    void setRotatingToSides(boolean rotatingToSides);

}
