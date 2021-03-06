package bot.commands.everyone;

import bot.Privat;
import bot.commands.Command;
import bot.stuff.FileManager;
import bot.stuff.Messages;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Coded by Oskar#7402
 * At 30.05.2018
 * github.com/oskardevkappa/
 */

public class YoMamma implements Command {

    private static final String path = "src/main/files/YoMamma.txt";

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) {

        if (event.getMessage().getMentionedMembers().size() < 1){
            Messages.sendError("0009", event.getChannel());
            return;
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int line = random.nextInt(1, FileManager.lineCount(path));

        String joke = FileManager.getLine(path, line);

        Member m = event.getMessage().getMentionedMembers().get(0);

        event.getChannel().sendMessage(joke .replaceAll("(?)Yo", "<@" + m.getUser().getId() + ">")).queue();
    }

    @Override
    public String help() {
        return Privat.Prefix + name() + " <@user>";
    }

    @Override
    public String description() {
        return "Insult someones mama";
    }

    @Override
    public String[] alias() {
        return new String[]{"insult", "mum", "mom"};
    }

    @Override
    public String name() {
        return "mama";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
