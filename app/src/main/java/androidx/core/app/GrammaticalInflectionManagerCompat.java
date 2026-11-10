package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build$VERSION;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class GrammaticalInflectionManagerCompat {
    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static int getApplicationGrammaticalGender(Context arg0) {
            return Api34Impl.getGrammaticalInflectionManager(arg0).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager getGrammaticalInflectionManager(Context arg1) {
            return arg1.getSystemService(GrammaticalInflectionManager.class);
        }

        static void setRequestedApplicationGrammaticalGender(Context arg0, int arg1) {
            Api34Impl.getGrammaticalInflectionManager(arg0).setRequestedApplicationGrammaticalGender(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface GrammaticalGender {
    }

    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED;

    private GrammaticalInflectionManagerCompat() {
        super();
    }

    public static int getApplicationGrammaticalGender(Context arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getApplicationGrammaticalGender(arg2);
        }

        return 0;
    }

    public static void setRequestedApplicationGrammaticalGender(Context arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setRequestedApplicationGrammaticalGender(arg2, arg3);
        }
    }
}

