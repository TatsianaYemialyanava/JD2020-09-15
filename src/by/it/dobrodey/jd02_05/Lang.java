package by.it.dobrodey.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    INSTANCE;

    private static final String KEYWORDS = "by.it.dobrodey.jd02_05.resources.keywords";
    private Locale locale;
    private ResourceBundle resourceBundle;

    Lang() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        this.locale=locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);

    }

    public String get(String key){
        return resourceBundle.getString(key);
    }


}
