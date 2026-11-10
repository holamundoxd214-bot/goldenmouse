package org.bouncycastle.asn1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.util.Longs;

public class LocaleUtil {
    public static Locale EN_Locale;
    private static final Map localeCache;

    static {
        LocaleUtil.localeCache = new HashMap();
        LocaleUtil.EN_Locale = LocaleUtil.forEN();
    }

    public LocaleUtil() {
        super();
    }

    static Date epochAdjust(Date arg7) throws ParseException {
        Locale v0 = Locale.getDefault();
        if(v0 == null) {
            return arg7;
        }

        Map v1 = LocaleUtil.localeCache;
        __monitor_enter(v1);
        try {
            Object v2 = v1.get(v0);
            if(v2 == null) {
                Long v2_1 = LocaleUtil.longValueOf(new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime());
                v1.put(v0, v2_1);
            }

            if(((Long)v2).longValue() != 0) {
                __monitor_exit(v1);
                return new Date(arg7.getTime() - ((Long)v2).longValue());
            }

            __monitor_exit(v1);
            return arg7;
        label_28:
            __monitor_exit(v1);
        }
        catch(Throwable v7) {
            goto label_28;
        }

        throw v7;
    }

    private static Locale forEN() {
        String v1 = "en";
        if(v1.equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }

        Locale[] v0 = Locale.getAvailableLocales();
        int v2;
        for(v2 = 0; v2 != v0.length; ++v2) {
            if(v1.equalsIgnoreCase(v0[v2].getLanguage())) {
                return v0[v2];
            }
        }

        return Locale.getDefault();
    }

    private static Long longValueOf(long arg0) {
        return Longs.valueOf(arg0);
    }
}

