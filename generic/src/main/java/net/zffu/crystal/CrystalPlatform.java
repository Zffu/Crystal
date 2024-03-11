package net.zffu.crystal;

import lombok.Getter;

/**
 * Crystal Platforms
 * Used for compatibility.
 */
@Getter
public enum CrystalPlatform {

    MINESTOM("net.zffu.crystal.minestom.MinestomCrystalAdapter");

    private String adapaterClass;

    private CrystalPlatform(String adapaterClass) {
        this.adapaterClass = adapaterClass;
    }

}
