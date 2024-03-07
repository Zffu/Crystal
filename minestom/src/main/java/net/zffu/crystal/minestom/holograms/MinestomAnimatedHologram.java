package net.zffu.crystal.minestom.holograms;

import lombok.Getter;
import lombok.Setter;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.LivingEntity;
import net.minestom.server.entity.metadata.other.ArmorStandMeta;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.zffu.crystal.holograms.AnimatedHologram;
import net.zffu.crystal.utils.Position;
import net.zffu.crystal.wrappers.WrappedMaterial;
import org.jetbrains.annotations.NotNull;

/**
 * Implementation of a Minestom Animated Hologram.
 */
@Getter
@Setter
public class MinestomAnimatedHologram extends LivingEntity implements AnimatedHologram {

    private Position hologramPosition;
    private WrappedMaterial<Material> material;

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

    public MinestomAnimatedHologram(Position hologramPosition, WrappedMaterial<Material> material) {
        super(EntityType.ARMOR_STAND);
        this.hologramPosition = hologramPosition;
        this.material = material;

        ArmorStandMeta meta = (ArmorStandMeta) this.getEntityMeta();
        meta.setNotifyAboutChanges(false);
        meta.setInvisible(true);
        meta.setSmall(true);
        meta.setHasNoGravity(true);
        meta.setNotifyAboutChanges(true);

        this.setHelmet(ItemStack.of(material.get()));
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

                this.teleport(new Pos(this.hologramPosition.getX(), this.hologramPosition.getY(), this.hologramPosition.getZ(), this.hologramPosition.getYaw(), this.hologramPosition.getPitch()));
            }
        }
    }
}
