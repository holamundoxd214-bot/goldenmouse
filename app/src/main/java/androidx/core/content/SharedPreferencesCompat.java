package androidx.core.content;

import android.content.SharedPreferences$Editor;

@Deprecated public final class SharedPreferencesCompat {
    @Deprecated public final class EditorCompat {
        class Helper {
            Helper() {
                super();
            }

            public void apply(SharedPreferences$Editor arg1) {
                try {
                    arg1.apply();
                    return;
                }
                catch(AbstractMethodError ) {
                    arg1.commit();
                    return;
                }
            }
        }

        private final Helper mHelper;
        private static EditorCompat sInstance;

        private EditorCompat() {
            super();
            this.mHelper = new Helper();
        }

        @Deprecated public void apply(SharedPreferences$Editor arg1) {
            this.mHelper.apply(arg1);
        }

        @Deprecated public static EditorCompat getInstance() {
            EditorCompat v0 = EditorCompat.sInstance;
            if(v0 == null) {
                v0 = new EditorCompat();
                EditorCompat.sInstance = v0;
            }

            return v0;
        }
    }

    private SharedPreferencesCompat() {
        super();
    }
}

