package net.zffu.crystal.wrappers;

public interface IWrapper<O, T> {

    /**
     * Wraps the original element of type O into an new element.
     * @param origin
     * @return converted
     */
    T wrap(O origin);

}
