package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class InitializationProvider extends ContentProvider {
    public InitializationProvider() {
        super();
    }

    public final int delete(Uri arg1, String arg2, String[] arg3) {
        throw new IllegalStateException("Not allowed.");
    }

    public final String getType(Uri arg1) {
        throw new IllegalStateException("Not allowed.");
    }

    public final Uri insert(Uri arg1, ContentValues arg2) {
        throw new IllegalStateException("Not allowed.");
    }

    public final boolean onCreate() {
        Context v1 = this.getContext();
        if(v1 != null) {
            if(v1.getApplicationContext() != null) {
                AppInitializer.getInstance(v1).discoverAndInitialize();
            }
            else {
                StartupLogger.w("Deferring initialization because `applicationContext` is null.");
            }

            return 1;
        }

        throw new StartupException("Context cannot be null");
    }

    public final Cursor query(Uri arg1, String[] arg2, String arg3, String[] arg4, String arg5) {
        throw new IllegalStateException("Not allowed.");
    }

    public final int update(Uri arg1, ContentValues arg2, String arg3, String[] arg4) {
        throw new IllegalStateException("Not allowed.");
    }
}

