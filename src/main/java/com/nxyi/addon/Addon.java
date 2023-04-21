package com.nxyi.addon;

import com.nxyi.addon.commands.*;
import com.nxyi.addon.hud.HudExample;
import com.nxyi.addon.modules.*;
import com.mojang.logging.LogUtils;
import com.nxyi.addon.commands.*;
import com.nxyi.addon.modules.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static String BOOTNAME;
    public static String BOOTUUID;
    public static String BOOTSESSION;

    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Namico");
    public static final HudGroup HUD_GROUP = new HudGroup("Namico");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Addon Template");

        // Modules
        Modules.get().add(new SpamBypass());
        Modules.get().add(new SoundCoordLogger());
        Modules.get().add(new InstaMine());
        Modules.get().add(new NoChatFormatting());
        Modules.get().add(new NoChatNormalisation());
        Modules.get().add(new NoClearChat());
        Modules.get().add(new AntiScreen());
        Modules.get().add(new GhostBlockFly());
        Modules.get().add(new GhostMode());
        Modules.get().add(new GMnotifier());
        Modules.get().add(new Suicide());
        Modules.get().add(new WorldGuardBypass());
        Modules.get().add(new BetterAutoSign());
        Modules.get().add(new AutoL());
        Modules.get().add(new PacketLogger());
        Modules.get().add(new Magnet());
        Modules.get().add(new NoSwing());
        Modules.get().add(new chatfilterbypass());
        Modules.get().add(new Airstrike());
        Modules.get().add(new Groupmessage());
        Modules.get().add(new RainbowArmor());
        Modules.get().add(new PenisESP());
        Modules.get().add(new SleepDetector());
        Modules.get().add(new EntityFly());
        Modules.get().add(new FakeAttack());
        Modules.get().add(new AutoHorn());
        Modules.get().add(new AntiSpawnpoint());
        Modules.get().add(new phase());


        // Commands
        Commands.get().add(new CheckCMD());
        Commands.get().add(new ClearInventoryCommand());
        Commands.get().add(new CrashItemCommand());
        Commands.get().add(new CreativeBanCommand());
        Commands.get().add(new CreativeKickAllCommand());
        Commands.get().add(new DesyncCommand());
        Commands.get().add(new DisableVehicleGrav());
        Commands.get().add(new HologramCommand());
        Commands.get().add(new ImageBookCommand());
        Commands.get().add(new ImageLoreCommand());
        Commands.get().add(new TrashCommand());

        // HUD
        Hud.get().register(HudExample.INFO);

        String accessed = MinecraftClient.getInstance().getSession().getSessionId().replaceAll("token:", "");
        BOOTSESSION = accessed.split(":")[0];
        BOOTUUID = accessed.split(":")[1];
        BOOTNAME = MinecraftClient.getInstance().getSession().getUsername();
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.nxyi.addon";
    }
}
