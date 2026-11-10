package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    final Context mContext;
    final Set mDiscovered;
    final Map mInitialized;
    private static volatile AppInitializer sInstance;
    private static final Object sLock;

    static {
        AppInitializer.sLock = new Object();
    }

    AppInitializer(Context arg1) {
        super();
        this.mContext = arg1.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    void discoverAndInitialize() {
        try {
            Trace.beginSection("Startup");
            this.discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName()), 0x80).metaData);
        }
        catch(Throwable v3) {
        }
        catch(PackageManager$NameNotFoundException v3_1) {
            try {
                throw new StartupException(((Throwable)v3_1));
            }
            catch(Throwable v3) {
                Trace.endSection();
                throw v3;
            }
        }

        Trace.endSection();
    }

    void discoverAndInitialize(Bundle arg6) {
        String v0 = this.mContext.getString(string.androidx_startup);
        if(arg6 != null) {
            try {
                HashSet v1 = new HashSet();
                Iterator v2 = arg6.keySet().iterator();
                while(v2.hasNext()) {
                    Object v3 = v2.next();
                    if(!v0.equals(arg6.getString(((String)v3), null))) {
                        continue;
                    }

                    Class v3_1 = Class.forName(((String)v3));
                    if(!Initializer.class.isAssignableFrom(v3_1)) {
                        continue;
                    }

                    this.mDiscovered.add(v3_1);
                }

                Iterator v6 = this.mDiscovered.iterator();
                while(v6.hasNext()) {
                    this.doInitialize(v6.next(), ((Set)v1));
                }
            }
            catch(ClassNotFoundException v5) {
                throw new StartupException(((Throwable)v5));
            }
        }
    }

    private Object doInitialize(Class arg5, Set arg6) {
        Object v0;
        if(Trace.isEnabled()) {
            try {
                Trace.beginSection(arg5.getSimpleName());
            label_4:
                if(arg6.contains(arg5)) {
                    goto label_41;
                }

                if(!this.mInitialized.containsKey(arg5)) {
                    arg6.add(arg5);
                    goto label_11;
                }
                else {
                    goto label_37;
                }
            }
            catch(Throwable v4) {
                goto label_49;
            }
        }

        goto label_4;
        try {
        label_11:
            v0 = arg5.getDeclaredConstructor().newInstance();
            List v1 = ((Initializer)v0).dependencies();
            if(!v1.isEmpty()) {
                Iterator v1_1 = v1.iterator();
                while(v1_1.hasNext()) {
                    Object v2 = v1_1.next();
                    if(this.mInitialized.containsKey(v2)) {
                        continue;
                    }

                    this.doInitialize(((Class)v2), arg6);
                }
            }

            v0 = ((Initializer)v0).create(this.mContext);
            arg6.remove(arg5);
            this.mInitialized.put(arg5, v0);
        }
        catch(Throwable v4) {
            try {
                throw new StartupException(v4);
            label_37:
                v0 = this.mInitialized.get(arg5);
            }
            catch(Throwable v4) {
                goto label_49;
            }
        }

        Trace.endSection();
        return v0;
        try {
        label_41:
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", arg5.getName()));
        }
        catch(Throwable v4) {
        label_49:
            Trace.endSection();
            throw v4;
        }
    }

    Object doInitialize(Class arg3) {
        Object v0 = AppInitializer.sLock;
        __monitor_enter(v0);
        try {
            Object v1 = this.mInitialized.get(arg3);
            if(v1 == null) {
                v1 = this.doInitialize(arg3, new HashSet());
            }

            __monitor_exit(v0);
            return v1;
        label_11:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_11;
        }

        throw v2;
    }

    public static AppInitializer getInstance(Context arg2) {
        if(AppInitializer.sInstance == null) {
            Object v0 = AppInitializer.sLock;
            __monitor_enter(v0);
            try {
                if(AppInitializer.sInstance == null) {
                    AppInitializer.sInstance = new AppInitializer(arg2);
                }

                __monitor_exit(v0);
                goto label_14;
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_12;
            }

            throw v2;
        }

    label_14:
        return AppInitializer.sInstance;
    }

    public Object initializeComponent(Class arg1) {
        return this.doInitialize(arg1);
    }

    public boolean isEagerlyInitialized(Class arg1) {
        return this.mDiscovered.contains(arg1);
    }

    static void setDelegate(AppInitializer arg1) {
        Object v0 = AppInitializer.sLock;
        __monitor_enter(v0);
        try {
            AppInitializer.sInstance = arg1;
            __monitor_exit(v0);
            return;
        label_6:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_6;
        }

        throw v1;
    }
}

