package com.example.examplemod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class GuildToggle implements ICommand {

	public String x;

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "toggleguild";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/guildtoggle";
	}

	@Override
	public List getAliases() {
		List <String> commandAliases = new ArrayList();
		commandAliases.add("gt");
		return commandAliases;
	}
	
	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		try{
			if (args.length == 0) {
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "No arguments supplied"));
			}
			else if (args[0].equalsIgnoreCase("off")){
				x = "false";
				sender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "Guild Chat Disabled "));
			}
			else if (args[0].equalsIgnoreCase("on")){
				x = "true";
				sender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + "Guild Chat Enabled "));
			}
			else {sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "What on earth was that??"));
		}}
			catch (Exception e){
				e.printStackTrace();
			}
		}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public void checkChat(ClientChatReceivedEvent e, String x){
        if(e.type!=0){
            return;
        }
        String chat = e.message.getFormattedText().replaceAll("\u00A7.", "");
        if(chat.contains(":") || !chat.contains("Guild > ")){
            return;
        }
        if (x=="false"){
        if (chat.contains("Guild > ")){
           e.setCanceled(true);
        }
        else {
        	return;
        }
        }
	}
}
