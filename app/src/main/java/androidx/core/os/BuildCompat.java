package androidx.core.os;

import android.os.Build$VERSION;
import android.os.ext.SdkExtensions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001C\u001DB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0007J\b\u0010\t\u001A\u00020\u0005H\u0007J\b\u0010\n\u001A\u00020\u0005H\u0007J\b\u0010\u000B\u001A\u00020\u0005H\u0007J\b\u0010\f\u001A\u00020\u0005H\u0007J\b\u0010\r\u001A\u00020\u0005H\u0007J\b\u0010\u000E\u001A\u00020\u0005H\u0007J\b\u0010\u000F\u001A\u00020\u0005H\u0007J\b\u0010\u0010\u001A\u00020\u0005H\u0007J\b\u0010\u0011\u001A\u00020\u0005H\u0007J\b\u0010\u0012\u001A\u00020\u0005H\u0007J\b\u0010\u0013\u001A\u00020\u0005H\u0007J\b\u0010\u0014\u001A\u00020\u0005H\u0007J\b\u0010\u0015\u001A\u00020\u0005H\u0007J\b\u0010\u0016\u001A\u00020\u0005H\u0007R\u0010\u0010\u0017\u001A\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/core/os/BuildCompat;", "", "<init>", "()V", "isAtLeastPreReleaseCodename", "", "codename", "", "buildCodename", "isAtLeastN", "isAtLeastNMR1", "isAtLeastO", "isAtLeastOMR1", "isAtLeastP", "isAtLeastQ", "isAtLeastR", "isAtLeastS", "isAtLeastSv2", "isAtLeastT", "isAtLeastU", "isAtLeastV", "isAtLeastB", "isAtLeastB_1", "R_EXTENSION_INT", "", "S_EXTENSION_INT", "T_EXTENSION_INT", "AD_SERVICES_EXTENSION_INT", "PrereleaseSdkCheck", "Api30Impl", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BuildCompat {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005¨\u0006\u0007"}, d2={"Landroidx/core/os/BuildCompat$Api30Impl;", "", "<init>", "()V", "getExtensionVersion", "", "extension", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Api30Impl {
        public static final Api30Impl INSTANCE;

        static {
            Api30Impl.INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
            super();
        }

        public final int getExtensionVersion(int arg1) {
            return SdkExtensions.getExtensionVersion(arg1);
        }
    }

    @Retention(value=RetentionPolicy.CLASS) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/core/os/BuildCompat$PrereleaseSdkCheck;", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @public interface PrereleaseSdkCheck {
    }

    public static final int AD_SERVICES_EXTENSION_INT;
    public static final BuildCompat INSTANCE;
    public static final int R_EXTENSION_INT;
    public static final int S_EXTENSION_INT;
    public static final int T_EXTENSION_INT;

    static {
        BuildCompat.INSTANCE = new BuildCompat();
        int v1 = 0;
        int v2 = 30;
        int v0 = Build$VERSION.SDK_INT >= v2 ? Api30Impl.INSTANCE.getExtensionVersion(v2) : 0;
        BuildCompat.R_EXTENSION_INT = v0;
        v0 = Build$VERSION.SDK_INT >= v2 ? Api30Impl.INSTANCE.getExtensionVersion(0x1F) : 0;
        BuildCompat.S_EXTENSION_INT = v0;
        v0 = Build$VERSION.SDK_INT >= v2 ? Api30Impl.INSTANCE.getExtensionVersion(33) : 0;
        BuildCompat.T_EXTENSION_INT = v0;
        if(Build$VERSION.SDK_INT >= v2) {
            v1 = Api30Impl.INSTANCE.getExtensionVersion(1000000);
        }

        BuildCompat.AD_SERVICES_EXTENSION_INT = v1;
    }

    private BuildCompat() {
        super();
    }

    @Deprecated(message="Android Baklava is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 36`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastB() {
        if(Build$VERSION.SDK_INT < 36) {
            if(Build$VERSION.SDK_INT >= 35) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("Baklava", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    @Deprecated(message="Android Baklava minor release 1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT_FULL >= Build.VERSION_CODES_FULL.BAKLAVA_1`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastB_1() {
        if(Build$VERSION.SDK_INT >= 36 && BuildCompat$$ExternalSyntheticBackportWithForwarding0.m() >= 3600001) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Android N is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 24`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastN() {
        return 1;
    }

    @Deprecated(message="Android N MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 25`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastNMR1() {
        return 1;
    }

    @Deprecated(message="Android O is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead use `Build.VERSION.SDK_INT >= 26`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastO() {
        return 1;
    }

    @Deprecated(message="Android O MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 27`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastOMR1() {
        if(Build$VERSION.SDK_INT >= 27) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Android P is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 28`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastP() {
        if(Build$VERSION.SDK_INT >= 28) {
            return 1;
        }

        return 0;
    }

    @JvmStatic public static final boolean isAtLeastPreReleaseCodename(String arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "codename");
        Intrinsics.checkNotNullParameter(arg5, "buildCodename");
        if(Intrinsics.areEqual("REL", arg5)) {
            return 0;
        }

        Integer v0 = BuildCompat.isAtLeastPreReleaseCodename$codenameToInt(arg5);
        Integer v2 = BuildCompat.isAtLeastPreReleaseCodename$codenameToInt(arg4);
        if(v0 != null && v2 != null) {
            if(v0.intValue() >= v2.intValue()) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(v0 == null && v2 == null) {
            arg5 = arg5.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(arg5, "toUpperCase(...)");
            arg4 = arg4.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(arg4, "toUpperCase(...)");
            if(arg5.compareTo(arg4) >= 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(v0 != null) {
            return 1;
        }

        return 0;
    }

    private static final Integer isAtLeastPreReleaseCodename$codenameToInt(String arg1) {
        arg1 = arg1.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
        if(Intrinsics.areEqual(arg1, "BAKLAVA")) {
            return Integer.valueOf(0);
        }

        return null;
    }

    @Deprecated(message="Android Q is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 29`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastQ() {
        if(Build$VERSION.SDK_INT >= 29) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Android R is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 30`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastR() {
        if(Build$VERSION.SDK_INT >= 30) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Android S is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 31`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastS() {
        if(Build$VERSION.SDK_INT < 0x1F) {
            if(Build$VERSION.SDK_INT >= 30) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("S", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    @Deprecated(message="Android Sv2 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 32`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastSv2() {
        if(Build$VERSION.SDK_INT < 0x20) {
            if(Build$VERSION.SDK_INT >= 0x1F) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("Sv2", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    @Deprecated(message="Android Tiramisu is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 33`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastT() {
        if(Build$VERSION.SDK_INT < 33) {
            if(Build$VERSION.SDK_INT >= 0x20) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    @Deprecated(message="Android UpsideDownCase is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 34`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastU() {
        if(Build$VERSION.SDK_INT < 34) {
            if(Build$VERSION.SDK_INT >= 33) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("UpsideDownCake", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    @Deprecated(message="Android VanillaIceCream is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 35`.", replaceWith="<_subannotation>") @JvmStatic public static final boolean isAtLeastV() {
        if(Build$VERSION.SDK_INT < 35) {
            if(Build$VERSION.SDK_INT >= 34) {
                String v0 = Build$VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(v0, "CODENAME");
                if(BuildCompat.isAtLeastPreReleaseCodename("VanillaIceCream", v0)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }
}

