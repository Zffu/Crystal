package net.zffu.crystal.minestom.holograms;

import lombok.Getter;
import lombok.Setter;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.LivingEntity;
import net.minestom.server.entity.metadata.other.ArmorStandMeta;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.zffu.crystal.Crystal;
import net.zffu.crystal.holograms.AnimatedHologram;
import net.zffu.crystal.minestom.MinestomCrystalAdapter;
import net.zffu.crystal.minestom.utils.MinestomUtils;
import net.zffu.crystal.utils.Position;

/**
 * Implementation of a Minestom Animated Hologram.
 */
@Getter
@Setter
public class MinestomAnimatedHologram extends LivingEntity implements AnimatedHologram {

    private Position hologramPosition;
    private Object material;

    private double lastY;

    /**
     * The Maximum threshold for animation
     */
    private double threshold = 0.25;

    /**
     * Is the Hologram Animated?
     */
    private boolean animated = true;

    /**
     * Is the Hologram going down?
     */
    private boolean motionDown = true;

    /**
     * Is the hologram rotating up and down
     */
    private boolean rotatingUpAndDown = true;

    /**
     * Is the hologram rotating to sides.
     */
    private boolean rotatingToSides = true;

    /**
     * Display name of the armor stand
     */
    private String displayName = "";

    public MinestomAnimatedHologram(Position hologramPosition, Object material) {
        super(EntityType.ARMOR_STAND);
        this.hologramPosition = hologramPosition;
        this.material = material;

        ArmorStandMeta meta = (ArmorStandMeta) this.getEntityMeta();
        meta.setNotifyAboutChanges(false);
        meta.setInvisible(true);
        meta.setSmall(true);
        meta.setHasNoGravity(true);
        meta.setNotifyAboutChanges(true);

        this.setHelmet(ItemStack.of((Material) material));
    }

    @Override
    public void update(long time) {
        if(this.animated) {
            if(this.rotatingUpAndDown) {
                double y = this.position.y();

                if(y < lastY - this.threshold) {
                    this.motionDown = false;
                }

                if(y > lastY + this.threshold) {
                    this.motionDown = true;
                }

                this.hologramPosition.substract(0,0.01 * (this.isMotionDown() ? -1 : 1),0);

                if(this.rotatingToSides) {
                    this.hologramPosition.setYaw(this.hologramPosition.getYaw() + 7 * (this.motionDown ? -1 : 1));
                }

                this.teleport(MinestomUtils.convertPosition(this.hologramPosition));
            }
        }
    }

    @Override
    public void summon() {
        this.setInstance(((MinestomCrystalAdapter) Crystal.getAdapter()).getInstance(), MinestomUtils.convertPosition(this.hologramPosition));
    }
}
