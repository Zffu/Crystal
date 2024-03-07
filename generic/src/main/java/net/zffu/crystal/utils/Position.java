package net.zffu.crystal.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * Position class for working with Crystal.
 * @author Zffu
 */

@Getter
@Setter
public class Position {

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    /**
     * Constructs a {@link Position} with the x, y, and z coordinates.
     * @param x
     * @param y
     * @param z
     */
    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a {@link Position} with the x, y, and z coordinates and with the yaw and pitch.
     * @param x
     * @param y
     * @param z
     * @param yaw
     * @param pitch
     */
    public Position(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Multiplies the coordinates with the provided multipliers.
     * @param xMul the multiplier of the coordinate x.
     * @param yMul the multiplier of the coordinate y.
     * @param zMul the multiplier of the coordinate z.
     */
    public void multiply(double xMul, double yMul, double zMul) {
        this.x *= xMul;
        this.y *= yMul;
        this.z *= zMul;
    }

    /**
     * Multipliers the coordinates with the provided multiplier.
     * @param mul the multiplier for the x, y and z coordinates.
     */
    public void multiply(double mul) {
        this.multiply(mul, mul, mul);
    }

    /**
     * Adds the provided coordinates to the current ones.
     * @param x
     * @param y
     * @param z
     */
    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }


}
