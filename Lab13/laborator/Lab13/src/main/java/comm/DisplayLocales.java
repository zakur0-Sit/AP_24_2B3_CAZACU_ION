package comm;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales implements Command {
    @Override
    public void execute(Locale locale, ResourceBundle messages) {
        System.out.println(messages.getString("locales"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale loc : locales) {
            System.out.println(loc.getDisplayName(locale));
        }
    }
}
