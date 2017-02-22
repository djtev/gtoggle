package guildtoggle;

import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "guildtoggle";
    public static final String VERSION = "0.1";
    
    public void preinit(FMLPreInitializationEvent event){
     }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	System.out.println("Guild Toggle Enabled");
        MinecraftForge.EVENT_BUS.register(new ChatHandler());
    	ClientCommandHandler.instance.registerCommand((ICommand)new GuildToggle());
    }
    
    public void postInit(FMLPostInitializationEvent e) {
    }
}
