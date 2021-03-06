/*
 * Copyright (C) 2016 larryTheHarry 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package larryTheCoder.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import larryTheCoder.ASkyBlock;
import larryTheCoder.IslandData;

/**
 * @author larryTheCoder
 */
public class ToggleSubCommand extends SubCommand{

    public ToggleSubCommand(ASkyBlock plugin) {
        super(plugin);
    }

    @Override
    public boolean canUse(CommandSender sender) {
        return sender.isPlayer() && sender.hasPermission("is.command.toggle");
    }

    @Override
    public String getUsage() {
        return "<help>";
    }

    @Override
    public String getName() {
        return "toggle";
    }

    @Override
    public String getDescription() {
        return "Toggle every actions on your island";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"tgg"};
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = sender.getServer().getPlayer(sender.getName());
        if(args.length == 2){
            sender.sendMessage(TextFormat.GRAY + "Too few parameters Use: /is tgg help");
            return true;
        }
        switch(args[2]){
            case "help":
                sender.sendMessage(getMsg("toggle_help"));
                break;
            case "teleport":
                if(args.length != 3){
                    sender.sendMessage(TextFormat.GRAY + "Too few parameters Usesae: /is tgg teleport <boolean>");
                    break;
                }
                if(!args[3].equalsIgnoreCase("true") || !args[3].equalsIgnoreCase("false")){
                    sender.sendMessage(TextFormat.GRAY + "Your parameters is not a boolean");
                    break;
                }
                IslandData pd = getPlugin().getDatabase().getIsland(sender.getName());
                pd.locked = args[3].toLowerCase();
        }
        return true;
    }

}
