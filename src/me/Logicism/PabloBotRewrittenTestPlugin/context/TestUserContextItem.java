package me.Logicism.PabloBotRewrittenTestPlugin.context;

import me.Logicism.PabloBotRewritten.api.context.UserContextAction;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class TestUserContextItem implements UserContextAction {

    @Override
    public void execute(Member member, User user, Member memberAuthor, User userAuthor, MessageChannel channel, String s) {
        channel.sendMessage("The user you executed this action to is " + user.getAsTag() + " and you are " + userAuthor.getAsTag()).queue();
    }

}
