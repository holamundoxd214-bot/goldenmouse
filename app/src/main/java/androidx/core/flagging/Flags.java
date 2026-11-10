package androidx.core.flagging;

import android.os.Build$VERSION;
import android.os.flagging.AconfigPackage;
import android.os.flagging.AconfigStorageReadException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/core/flagging/Flags;", "", "<init>", "()V", "Companion", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Flags {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00062\b\b\u0002\u0010\u000E\u001A\u00020\u000BH\u0007R\u001E\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/core/flagging/Flags$Companion;", "", "<init>", "()V", "aconfigCache", "", "", "Landroid/os/flagging/AconfigPackage;", "missingPackageCache", "", "getBooleanFlagValue", "", "packageName", "flagName", "defaultValue", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final boolean getBooleanFlagValue(String arg8, String arg9) {
            Intrinsics.checkNotNullParameter(arg8, "packageName");
            Intrinsics.checkNotNullParameter(arg9, "flagName");
            return Companion.getBooleanFlagValue$default(this, arg8, arg9, false, 4, null);
        }

        @JvmStatic public final boolean getBooleanFlagValue(String arg4, String arg5, boolean arg6) {
            Object v3_1;
            Intrinsics.checkNotNullParameter(arg4, "packageName");
            Intrinsics.checkNotNullParameter(arg5, "flagName");
            if(Build$VERSION.SDK_INT < 36) {
                return arg6;
            }

            Map v3 = Flags.aconfigCache;
            Intrinsics.checkNotNull(v3);
            Set v0 = Flags.missingPackageCache;
            Intrinsics.checkNotNull(v0);
            if(v3.containsKey(arg4)) {
                v3_1 = v3.get(arg4);
                goto label_29;
            }

            Object v2 = null;
            if(!v0.contains(arg4)) {
                try {
                    AconfigPackage v1 = AconfigPackage.load(arg4);
                    v3.put(arg4, v1);
                    AconfigPackage v3_2 = v1;
                    goto label_29;
                }
                catch(AconfigStorageReadException ) {
                    Boolean.valueOf(v0.add(arg4));
                }
            }

            v3_1 = v2;
        label_29:
            if(v3_1 != null) {
                arg6 = ((AconfigPackage)v3_1).getBooleanFlagValue(arg5, arg6);
            }

            return arg6;
        }

        public static boolean getBooleanFlagValue$default(Companion arg0, String arg1, String arg2, boolean arg3, int arg4, Object arg5) {
            return arg0.getBooleanFlagValue(arg1, arg2, false);
        }
    }

    public static final Companion Companion;
    private static final Map aconfigCache;
    private static final Set missingPackageCache;

    static {
        Map v0_1;
        DefaultConstructorMarker v1 = null;
        Flags.Companion = new Companion(v1);
        int v2 = 36;
        if(Build$VERSION.SDK_INT >= v2) {
            ConcurrentHashMap v0 = new ConcurrentHashMap();
        }
        else {
            v0_1 = ((Map)v1);
        }

        Flags.aconfigCache = v0_1;
        if(Build$VERSION.SDK_INT >= v2) {
            CopyOnWriteArraySet v1_1 = new CopyOnWriteArraySet();
        }

        Flags.missingPackageCache = ((Set)v1);
    }

    public Flags() {
        super();
    }

    public static final Map access$getAconfigCache$cp() {
        return Flags.aconfigCache;
    }

    public static final Set access$getMissingPackageCache$cp() {
        return Flags.missingPackageCache;
    }

    @JvmStatic public static final boolean getBooleanFlagValue(String arg1, String arg2) {
        return Flags.Companion.getBooleanFlagValue(arg1, arg2);
    }

    @JvmStatic public static final boolean getBooleanFlagValue(String arg1, String arg2, boolean arg3) {
        return Flags.Companion.getBooleanFlagValue(arg1, arg2, arg3);
    }
}

