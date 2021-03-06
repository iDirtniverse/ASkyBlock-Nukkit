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

import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import larryTheCoder.ASkyBlock;

/**
 * @author larryTheCoder
 */
public class CreateSubCommand extends SubCommand{

    public CreateSubCommand(ASkyBlock plugin) {
        super(plugin);
    }

    @Override
    public boolean canUse(CommandSender sender) {
        return sender.hasPermission("is.create") && sender.isPlayer();
    }

    @Override
    public String getUsage() {
        String concat = "";
        if(getPlugin().cfg.getInt("maxHomes") != 0){
            concat = "[1 - " + getPlugin().cfg.getInt("maxHomes") + "]";
        }
        return concat;
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "Create a new Fresh island!";
    }

    @Override
    public String[] getAliases() {
        return new String[]{};
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(TextFormat.GRAY + "This command isnt available yet");
        return true;
    }

}
