package androidx.core.flagging;

import android.os.Build$VERSION;
import android.os.flagging.AconfigPackage;
import android.os.flagging.AconfigStorageReadException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/core/flagging/AconfigPackageCompat;", "", "getBooleanFlagValue", "", "flagName", "", "defaultValue", "Companion", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface AconfigPackageCompat {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/core/flagging/AconfigPackageCompat$Companion;", "", "<init>", "()V", "load", "Landroidx/core/flagging/AconfigPackageCompat;", "packageName", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final AconfigPackageCompat load(String arg2) throws AconfigStorageReadException {
            AconfigPackageCompatApi36Impl v1_1;
            Intrinsics.checkNotNullParameter(arg2, "packageName");
            if(Build$VERSION.SDK_INT >= 36) {
                try {
                    AconfigPackage v2 = AconfigPackage.load(arg2);
                    Intrinsics.checkNotNullExpressionValue(v2, "load(...)");
                    v1_1 = new AconfigPackageCompatApi36Impl(v2);
                }
                catch(AconfigStorageReadException v1) {
                    if(v1.getErrorCode() == 2) {
                        AconfigPackageCompatNoopImpl v1_2 = new AconfigPackageCompatNoopImpl();
                        goto label_17;
                    }

                    throw v1;
                }

            label_17:
                return ((AconfigPackageCompat)v1_1);
            }

            return new AconfigPackageCompatNoopImpl();
        }
    }

    public static final Companion Companion;

    static {
        AconfigPackageCompat.Companion = Companion.$$INSTANCE;
    }

    boolean getBooleanFlagValue(String arg1, boolean arg2);

    @JvmStatic static AconfigPackageCompat load(String arg1) throws AconfigStorageReadException {
        return AconfigPackageCompat.Companion.load(arg1);
    }
}

