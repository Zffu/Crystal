package net.zffu.crystal.wrappers;

/**
 * Wrapped class to store the location.
 */
public interface WrappedPosition {

    /**
     * Gets the Position's X value.
     * @return the value.
     */
    double getX();

    /**
     * Gets the Position's Y value.
     * @return the value.
     */
    double getY();

    /**
     * Gets the Position's Z value.
     * @return the value.
     */
    double getZ();

    /**
     * Ges the Position's Yaw
     * @return the yaw
     */
    float getYaw();

    /**
     * Gets the Position's Pitch
     * @return the pitch.
     */
    float getPitch();

}
