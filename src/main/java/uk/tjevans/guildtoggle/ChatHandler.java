package uk.tjevans.guildtoggle;

public class ChatHandler {
  
      @EventHandler
      public void checkChat(ClientChatReceivedEvent e){
          if(e.type!=0){
              return;
          }
          String chat = e.message.getFormattedText().replaceAll("\u00A7.", "");
          if(!chat.startsWith("Guild > ")){
              return;
          }
          if (GuildToggle.x==false){
              e.setCanceled(true);
          }
      }

}
