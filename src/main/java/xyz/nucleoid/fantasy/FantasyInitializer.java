package xyz.nucleoid.fantasy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import xyz.nucleoid.fantasy.test.FantasyMod;
import xyz.nucleoid.fantasy.util.VoidChunkGenerator;

import java.util.Objects;

@Mod(Fantasy.ID)
public final class FantasyInitializer {
    public FantasyInitializer() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);

        if (!FMLEnvironment.production) {
            new FantasyMod(); // Development Tests YAY!
        }
    }

    @SubscribeEvent
    public void onRegister(RegisterEvent event) {
        if (Objects.equals(event.getVanillaRegistry(), Registries.CHUNK_GENERATOR)) {
            Registry.register(Registries.CHUNK_GENERATOR, new Identifier(Fantasy.ID, "void"), VoidChunkGenerator.CODEC);
        }
    }
}
