package comm;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info implements Command {
    private Locale currentLocale;

    public Info(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    @Override
    public void execute(Locale locale, ResourceBundle messages) {
        displayLocaleInfo(currentLocale, messages);
    }

    private void displayLocaleInfo(Locale locale, ResourceBundle messages) {
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] weekdays = dfs.getWeekdays();
        String[] months = dfs.getMonths();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);

        System.out.println(messages.getString("info").replace("{0}", locale.getDisplayName(locale)));
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        System.out.print("Week Days: ");
        for (int i = 1; i < weekdays.length; i++) {
            System.out.print(weekdays[i] + (i < weekdays.length - 1 ? ", " : ""));
        }
        System.out.println();
        System.out.print("Months: ");
        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i] + (i < months.length - 1 ? ", " : ""));
        }
        System.out.println();
        System.out.println("Today: " + dateFormat.format(new Date()));
    }
}
