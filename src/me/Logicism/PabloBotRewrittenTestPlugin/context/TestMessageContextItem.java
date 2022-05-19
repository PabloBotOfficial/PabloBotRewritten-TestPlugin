package me.Logicism.PabloBotRewrittenTestPlugin.context;

import me.Logicism.PabloBotRewritten.api.context.MessageContextAction;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class TestMessageContextItem implements MessageContextAction {

    @Override
    public void execute(Message message, Member member, User user, InteractionHook hook, String s) {
        hook.sendMessage("The messaged you executed this action to is `" + message.getContentRaw() + "` and you are " + user.getAsTag()).queue();
    }

}
