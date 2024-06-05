package comm;

import java.util.Locale;
import java.util.ResourceBundle;

public interface Command {
    void execute(Locale locale, ResourceBundle messages);
}
