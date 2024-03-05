package net.zffu.crystal.wrappers;

/**
 * Wrapped Material class for compatibility.
 * @param <K> the output material class.
 */
public abstract class WrappedMaterial<K> {

    /**
     * The Material's id.
     */
    private String id;

    /**
     * Constructs a WrappedMaterial containing the given id.
     * @param id
     */
    public WrappedMaterial(String id) {
        this.id = id;
    }

    /**
     * Gets the Material equivalent in the K class.
     * @return the Material.
     */
    public abstract K get();

}
