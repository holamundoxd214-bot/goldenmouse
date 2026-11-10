package androidx.core.os;

import android.os.Environment;
import java.io.File;

public final class EnvironmentCompat {
    @Deprecated public static final String MEDIA_UNKNOWN = "unknown";

    private EnvironmentCompat() {
        super();
    }

    public static String getStorageState(File arg0) {
        return Environment.getExternalStorageState(arg0);
    }
}

