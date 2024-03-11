package net.zffu.crystal.minestom.utils;

import net.minestom.server.coordinate.Pos;
import net.zffu.crystal.utils.Position;

/**
 * Utilities for working with minestom and crystal.
 */
public class MinestomUtils {

    /**
     * Converts the {@link Position} into {@link Pos}.
     * @param position the original position.
     * @return the converted position.
     */
    public static Pos convertPosition(Position position) {
        return new Pos(position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getPitch());
    }

}
