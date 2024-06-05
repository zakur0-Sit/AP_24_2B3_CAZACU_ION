package app;


import comm.Command;
import comm.DisplayLocales;
import comm.Info;
import comm.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    private static Locale currentLocale = Locale.getDefault();
    private static ResourceBundle messages = ResourceBundle.getBundle("res.Messages", currentLocale);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info(currentLocale);

        while (true) {
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine();

            if (command.equals("display-locales")) {
                displayLocales.execute(currentLocale, messages);
            } else if (command.equals("set-locale")) {
                setLocale.execute(currentLocale, messages);
                currentLocale = setLocale.getCurrentLocale();
                messages = ResourceBundle.getBundle("res.Messages", currentLocale);
                info = new Info(currentLocale);
            } else if (command.equals("info")) {
                info.execute(currentLocale, messages);
            } else if (command.equals("exit")) {
                System.out.println("Se inchide aplicatia...");
                break;
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
        scanner.close();
    }
}
