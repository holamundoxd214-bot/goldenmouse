package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build$VERSION;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static CharSequence getBestNameForService(Context arg5, ServiceInfo arg6) {
            Set v0 = arg6.getNamedContentLocales();
            CharSequence v2 = null;
            if(v0.isEmpty()) {
                return v2;
            }

            String[] v0_1 = new String[v0.size()];
            Iterator v1 = arg6.getNamedContentLocales().iterator();
            int v3;
            for(v3 = 0; v1.hasNext(); ++v3) {
                v0_1[v3] = v1.next().toLanguageTag();
            }

            Locale v5 = arg5.getResources().getConfiguration().getLocales().getFirstMatch(v0_1);
            if(v5 == null) {
                return v2;
            }

            return arg6.getNameForLocale(v5);
        }
    }

    private MbmsHelper() {
        super();
    }

    public static CharSequence getBestNameForService(Context arg2, ServiceInfo arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getBestNameForService(arg2, arg3);
        }

        return null;
    }
}

