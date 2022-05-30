package me.Logicism.PabloBotRewrittenTestPlugin.context;

import me.Logicism.PabloBotRewritten.api.command.UserContextAction;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class TestUserContextItem implements UserContextAction {

    @Override
    public void execute(Member member, User user, Member memberAuthor, User userAuthor, InteractionHook hook, String s) {
        hook.sendMessage("The user you executed this action to is " + user.getAsTag() + " and you are " + userAuthor.getAsTag()).queue();
    }

}
