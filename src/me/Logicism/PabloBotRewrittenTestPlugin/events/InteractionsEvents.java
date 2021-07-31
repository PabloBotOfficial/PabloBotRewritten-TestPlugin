package me.Logicism.PabloBotRewrittenTestPlugin.events;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InteractionsEvents extends ListenerAdapter {

    @Override
    public void onButtonClick(@NotNull ButtonClickEvent event) {
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
    public void onSelectionMenu(@NotNull SelectionMenuEvent event) {
        SelectionMenu.Builder sm = SelectionMenu.fromData(event.getSelectionMenu().toData()).setDefaultValues(event.getValues());
        if (event.getComponentId().equals("testplugin_selectionmenu")) {
            SelectOption option = event.getSelectedOptions().get(0);

            if (option.getValue().equals("testselection1")) {
                event.editMessage("You clicked on the first selection!").setActionRow(sm.build()).queue();
            } else if (option.getValue().equals("testselection2")) {
                event.editMessage("You clicked on the second selection!").setActionRow(sm.build()).queue();
            } else if (option.getValue().equals("testselection3")) {
                event.editMessage("You clicked on the third selection!").setActionRow(sm.build()).queue();
            }
        } else if (event.getComponentId().equals("testplugin_multiselectionmenu")) {
            List<String> selectedOptions = new ArrayList<>();
            for (SelectOption option : event.getSelectedOptions()) {
                selectedOptions.add(option.getLabel());
            }

            event.editMessage("You selected on: " + StringUtils.join(selectedOptions, ", ")).setActionRow(sm.build()).queue();
        }
    }
}
