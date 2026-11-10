package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.text.DateFormat$HourCycle;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build$VERSION;
import android.text.format.DateFormat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale$Category;
import java.util.Locale;

public final class LocalePreferences {
    class androidx.core.text.util.LocalePreferences$1 {
        static {
            int[] v0 = new int[DateFormat$HourCycle.values().length];
            androidx.core.text.util.LocalePreferences$1.$SwitchMap$android$icu$text$DateFormat$HourCycle = v0;
            try {
                v0[DateFormat$HourCycle.HOUR_CYCLE_11.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.core.text.util.LocalePreferences$1.$SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat$HourCycle.HOUR_CYCLE_12.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.core.text.util.LocalePreferences$1.$SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat$HourCycle.HOUR_CYCLE_23.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.core.text.util.LocalePreferences$1.$SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat$HourCycle.HOUR_CYCLE_24.ordinal()] = 4;
                            return;
                        }
                        catch(NoSuchFieldError ) {
                            return;
                        }
                    }
                }
            }
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static String getCalendarType(Locale arg0) {
            return Calendar.getInstance(arg0).getType();
        }

        static Locale getDefaultLocale() {
            return Locale.getDefault(Locale$Category.FORMAT);
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static String getHourCycle(Locale arg0) {
            return Api33Impl.getHourCycleType(DateTimePatternGenerator.getInstance(arg0).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat$HourCycle arg1) {
            int v1 = androidx.core.text.util.LocalePreferences$1.$SwitchMap$android$icu$text$DateFormat$HourCycle[arg1.ordinal()];
            if(v1 != 1) {
                if(v1 != 2) {
                    if(v1 != 3) {
                        if(v1 != 4) {
                            return "";
                        }

                        return "h24";
                    }

                    return "h23";
                }

                return "h12";
            }

            return "h11";
        }

        static String getResolvedTemperatureUnit(Locale arg2) {
            String v2 = NumberFormatter.with().usage("weather").unit(MeasureUnit.CELSIUS).locale(arg2).format(1).getOutputUnit().getIdentifier();
            String v0 = "fahrenhe";
            if(v2.startsWith(v0)) {
                return v0;
            }

            return v2;
        }
    }

    public class CalendarType {
        @Retention(value=RetentionPolicy.SOURCE) @public interface CalendarTypes {
        }

        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";

        private CalendarType() {
            super();
        }
    }

    public class FirstDayOfWeek {
        @Retention(value=RetentionPolicy.SOURCE) @public interface Days {
        }

        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";

        private FirstDayOfWeek() {
            super();
        }
    }

    public class HourCycle {
        @Retention(value=RetentionPolicy.SOURCE) @public interface HourCycleTypes {
        }

        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";

        private HourCycle() {
            super();
        }
    }

    public class TemperatureUnit {
        @Retention(value=RetentionPolicy.SOURCE) @public interface TemperatureUnits {
        }

        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";

        private TemperatureUnit() {
            super();
        }
    }

    private static final String TAG = "LocalePreferences";
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES;

    static {
        LocalePreferences.WEATHER_FAHRENHEIT_COUNTRIES = new String[]{"BS", "BZ", "KY", "PR", "PW", "US"};
    }

    private LocalePreferences() {
        super();
    }

    private static String getBaseFirstDayOfWeek(Locale arg0) {
        return LocalePreferences.getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(arg0).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(Locale arg1) {
        if(DateFormat.getBestDateTimePattern(arg1, "jm").contains("H")) {
            return "h23";
        }

        return "h12";
    }

    public static String getCalendarType() {
        return LocalePreferences.getCalendarType(true);
    }

    public static String getCalendarType(boolean arg1) {
        return LocalePreferences.getCalendarType(Api24Impl.getDefaultLocale(), arg1);
    }

    public static String getCalendarType(Locale arg1) {
        return LocalePreferences.getCalendarType(arg1, true);
    }

    public static String getCalendarType(Locale arg2, boolean arg3) {
        String v3 = LocalePreferences.getUnicodeLocaleType("ca", "", arg2, arg3);
        if(v3 != null) {
            return v3;
        }

        return Api24Impl.getCalendarType(arg2);
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    public static String getFirstDayOfWeek() {
        return LocalePreferences.getFirstDayOfWeek(true);
    }

    public static String getFirstDayOfWeek(boolean arg1) {
        return LocalePreferences.getFirstDayOfWeek(Api24Impl.getDefaultLocale(), arg1);
    }

    public static String getFirstDayOfWeek(Locale arg1) {
        return LocalePreferences.getFirstDayOfWeek(arg1, true);
    }

    public static String getFirstDayOfWeek(Locale arg2, boolean arg3) {
        String v3 = LocalePreferences.getUnicodeLocaleType("fw", "", arg2, arg3);
        if(v3 != null) {
            return v3;
        }

        return LocalePreferences.getBaseFirstDayOfWeek(arg2);
    }

    public static String getHourCycle() {
        return LocalePreferences.getHourCycle(true);
    }

    public static String getHourCycle(boolean arg1) {
        return LocalePreferences.getHourCycle(Api24Impl.getDefaultLocale(), arg1);
    }

    public static String getHourCycle(Locale arg1) {
        return LocalePreferences.getHourCycle(arg1, true);
    }

    public static String getHourCycle(Locale arg2, boolean arg3) {
        String v3 = LocalePreferences.getUnicodeLocaleType("hc", "", arg2, arg3);
        if(v3 != null) {
            return v3;
        }

        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getHourCycle(arg2);
        }

        return LocalePreferences.getBaseHourCycle(arg2);
    }

    private static String getStringOfFirstDayOfWeek(int arg5) {
        int v0 = 7;
        String[] v1 = new String[v0];
        v1[0] = "sun";
        v1[1] = "mon";
        v1[2] = "tue";
        v1[3] = "wed";
        v1[4] = "thu";
        v1[5] = "fri";
        v1[6] = "sat";
        if(arg5 >= 1 && arg5 <= v0) {
            return v1[arg5 - 1];
        }

        return "";
    }

    private static String getTemperatureHardCoded(Locale arg1) {
        if(Arrays.binarySearch(LocalePreferences.WEATHER_FAHRENHEIT_COUNTRIES, arg1.getCountry()) >= 0) {
            return "fahrenhe";
        }

        return "celsius";
    }

    public static String getTemperatureUnit() {
        return LocalePreferences.getTemperatureUnit(true);
    }

    public static String getTemperatureUnit(boolean arg1) {
        return LocalePreferences.getTemperatureUnit(Api24Impl.getDefaultLocale(), arg1);
    }

    public static String getTemperatureUnit(Locale arg1) {
        return LocalePreferences.getTemperatureUnit(arg1, true);
    }

    public static String getTemperatureUnit(Locale arg2, boolean arg3) {
        String v3 = LocalePreferences.getUnicodeLocaleType("mu", "", arg2, arg3);
        if(v3 != null) {
            return v3;
        }

        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getResolvedTemperatureUnit(arg2);
        }

        return LocalePreferences.getTemperatureHardCoded(arg2);
    }

    private static String getUnicodeLocaleType(String arg0, String arg1, Locale arg2, boolean arg3) {
        arg0 = arg2.getUnicodeLocaleType(arg0);
        if(arg0 != null) {
            return arg0;
        }

        if(!arg3) {
            return arg1;
        }

        return null;
    }
}

