package net.citizensnpcs.npc.entity;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.CitizensMobNPC;
import net.citizensnpcs.npc.CitizensNPCManager;
import net.citizensnpcs.npc.ai.NPCHandle;
import net.minecraft.server.EntityCreeper;
import net.minecraft.server.EntityWeatherLighting;
import net.minecraft.server.PathfinderGoalSelector;
import net.minecraft.server.World;

import org.bukkit.entity.Creeper;

public class CitizensCreeperNPC extends CitizensMobNPC {

    public CitizensCreeperNPC(CitizensNPCManager manager, int id, String name) {
        super(manager, id, name, EntityCreeperNPC.class);
    }

    @Override
    public Creeper getBukkitEntity() {
        return (Creeper) getHandle().getBukkitEntity();
    }

    public static class EntityCreeperNPC extends EntityCreeper implements NPCHandle {
        private final NPC npc;

        @Override
        public NPC getNPC() {
            return this.npc;
        }

        public EntityCreeperNPC(World world, NPC npc) {
            super(world);
            this.npc = npc;
            goalSelector = new PathfinderGoalSelector();
            targetSelector = new PathfinderGoalSelector();
        }

        @Override
        public void d_() {
        }

        @Override
        public void a(EntityWeatherLighting entityweatherlighting) {
        }
    }
}