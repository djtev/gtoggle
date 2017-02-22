package guildtoggle;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatHandler {
  
      @SubscribeEvent
      public void checkChat(ClientChatReceivedEvent e){
          if(e.type!=0){
              return;
          }
          String chat = e.message.getFormattedText().replaceAll("\u00A7.", "");
          if(!chat.startsWith("Guild > ")){
              return;
          }
          if (!GuildToggle.x){
              e.setCanceled(true);
          }
      }

}
