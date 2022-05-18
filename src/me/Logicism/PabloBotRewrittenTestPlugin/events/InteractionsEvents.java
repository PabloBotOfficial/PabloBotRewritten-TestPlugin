package me.Logicism.PabloBotRewrittenTestPlugin.events;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InteractionsEvents extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getComponentId().equals("testplugin_button1")) {
            event.reply("You clicked on a primary button!").queue();
        } else if (event.getComponentId().equals("testplugin_button2")) {
            event.reply("You clicked on a secondary button!").queue();
        } else if (event.getComponentId().equals("testplugin_button3")) {
            event.reply("You clicked on a danger button!").queue();
        } else if (event.getComponentId().equals("testplugin_button4")) {
            event.reply("You clicked on a success button!").queue();
        }
    }

    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        if (event.getComponentId().equals("testplugin_selectionmenu")) {
            SelectMenu.Builder sm = SelectMenu.fromData(event.getSelectMenu().toData()).setDefaultValues(event.getValues());
            SelectOption option = event.getSelectedOptions().get(0);

            if (option.getValue().equals("testselection1")) {
                event.editMessage("You clicked on the first selection!").setActionRow(sm.build()).queue();
            } else if (option.getValue().equals("testselection2")) {
                event.editMessage("You clicked on the second selection!").setActionRow(sm.build()).queue();
            } else if (option.getValue().equals("testselection3")) {
                event.editMessage("You clicked on the third selection!").setActionRow(sm.build()).queue();
            }
        } else if (event.getComponentId().equals("testplugin_multiselectionmenu")) {
            SelectMenu.Builder sm = SelectMenu.fromData(event.getSelectMenu().toData()).setDefaultValues(event.getValues());
            List<String> selectedOptions = new ArrayList<>();
            for (SelectOption option : event.getSelectedOptions()) {
                selectedOptions.add(option.getLabel());
            }

            event.editMessage("You selected on: " + StringUtils.join(selectedOptions, ", ")).setActionRow(sm.build()).queue();
        }
    }
}
