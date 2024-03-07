package net.zffu.crystal;

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

}
