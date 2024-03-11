package net.zffu.crystal;

import lombok.Getter;
import net.zffu.crystal.sequences.Sequence;

import java.lang.reflect.Constructor;
import java.util.LinkedList;

/**
 * The main class of the Crystal lib.
 * @author Zffu
 */
@Getter
public class Crystal {

    @Getter
    private static AbstractCrystalAdapter adapter;
    private static CrystalPlatform runningPlatform;

    private static LinkedList<Sequence> runningSequences = new LinkedList<>();

    /**
     * Inits the {@link Crystal} LIB Adapter.
     * @param platform the platform Crystal is currently running on.
     * @throws Exception throws if the reflection fails for some reason.
     */
    public static void init(CrystalPlatform platform) throws Exception {
        runningPlatform = platform;

        // todo: fix this if its not working
        Class<? extends AbstractCrystalAdapter> clazz = (Class<? extends AbstractCrystalAdapter>) Class.forName(platform.getAdapaterClass());
        adapter = clazz.newInstance();
    }

    /**
     * Inits {@link Crystal} LIB Adapter with the provided arguments.
     * @param platform the platform Crystal is running on.
     * @param args the arguments to pass to the adapater.
     * @throws Exception throws if the reflection fails.
     */
    public static void init(CrystalPlatform platform, Object... args) throws Exception {
        runningPlatform = platform;

        // todo: fix this if its not working
        Class<? extends AbstractCrystalAdapter> clazz = (Class<? extends AbstractCrystalAdapter>) Class.forName(platform.getAdapaterClass());
        Constructor<?> constructor = clazz.getConstructor(Object[].class);
        adapter = (AbstractCrystalAdapter) constructor.newInstance(args);
    }

    /**
     * Disables every running sequence.
     */
    public static void disable() {
        for(Sequence sequence : runningSequences) {
            sequence.stopSequence();
        }
    }

}
