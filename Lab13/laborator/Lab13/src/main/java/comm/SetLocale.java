package comm;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale implements Command {
    private Locale currentLocale;

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    @Override
    public void execute(Locale locale, ResourceBundle messages) {
        System.out.print(messages.getString("prompt"));
        String languageTag = new java.util.Scanner(System.in).nextLine();
        currentLocale = Locale.forLanguageTag(languageTag);
        System.out.println(messages.getString("locale.set").replace("{0}", currentLocale.getDisplayName(currentLocale)));
    }
}
