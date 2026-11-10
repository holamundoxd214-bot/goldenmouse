package androidx.compose.foundation;

import android.os.Build$VERSION;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0091\u0001\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000B2\u001B\b\u0002\u0010\f\u001A\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000B2\u0016\b\u0002\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001A©\u0001\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000B2\u001B\b\u0002\u0010\f\u001A\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000B2\u0016\b\u0002\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u001A\u001A\u00020\u00172\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010\u001B\u001A\u00020\u00172\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0000¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u0012\u0010 \u001A\u00020\u00172\b\b\u0002\u0010!\u001A\u00020\"H\u0001\u001A\u0014\u0010#\u001A\u00020\u0017*\u00020\u00112\u0006\u0010$\u001A\u00020\u0011H\u0000\" \u0010\u0000\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005¨\u0006%"}, d2={"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "isPlatformMagnifierSupported", "sdkVersion", "", "equalsIncludingNaN", "other", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey MagnifierPositionInRoot;

    static {
        Magnifier_androidKt.MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot", null, 2, null);
    }

    public static final boolean equalsIncludingNaN(float arg2, float arg3) {
        if((Float.isNaN(arg2)) && (Float.isNaN(arg3))) {
            return 1;
        }

        if(arg2 == arg3) {
            return 1;
        }

        return 0;
    }

    public static final SemanticsPropertyKey getMagnifierPositionInRoot() {
        return Magnifier_androidKt.MagnifierPositionInRoot;
    }

    public static final boolean isPlatformMagnifierSupported(int arg1) {
        if(arg1 >= 28) {
            return 1;
        }

        return 0;
    }

    public static boolean isPlatformMagnifierSupported$default(int arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = Build$VERSION.SDK_INT;
        }

        return Magnifier_androidKt.isPlatformMagnifierSupported(arg0);
    }

    public static final Modifier magnifier-UpNRX3w(Modifier arg14, Function1 arg15, Function1 arg16, Function1 arg17, float arg18, long arg19, float arg21, float arg22, boolean arg23) {
        return Magnifier_androidKt.magnifier-jPUL71Q$default(arg14, arg15, arg16, arg17, arg18, false, arg19, arg21, arg22, arg23, null, 0x200, null);
    }

    public static Modifier magnifier-UpNRX3w$default(Modifier arg1, Function1 arg2, Function1 arg3, Function1 arg4, float arg5, long arg6, float arg8, float arg9, boolean arg10, int arg11, Object arg12) {
        Function1 v0 = null;
        if((arg11 & 2) != 0) {
            arg3 = v0;
        }

        if((arg11 & 4) != 0) {
            arg4 = v0;
        }

        if((arg11 & 8) != 0) {
            arg5 = NaNf;
        }

        if((arg11 & 16) != 0) {
            arg6 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        if((arg11 & 0x20) != 0) {
            arg8 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg11 & 0x40) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return Magnifier_androidKt.magnifier-UpNRX3w(arg1, arg2, arg3, arg4, arg5, arg6, arg8, arg9, true);
    }

    public static final Modifier magnifier-jPUL71Q(Modifier arg14, Function1 arg15, Function1 arg16, Function1 arg17, float arg18, boolean arg19, long arg20, float arg22, float arg23, boolean arg24, PlatformMagnifierFactory arg25) {
        if(Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
            PlatformMagnifierFactory v12 = arg25 == null ? PlatformMagnifierFactory.Companion.getForCurrentPlatform() : arg25;
            arg14 = arg14.then(new MagnifierElement(arg15, arg16, arg17, arg18, arg19, arg20, arg22, arg23, arg24, v12, null));
        }

        return arg14;
    }

    public static Modifier magnifier-jPUL71Q$default(Modifier arg1, Function1 arg2, Function1 arg3, Function1 arg4, float arg5, boolean arg6, long arg7, float arg9, float arg10, boolean arg11, PlatformMagnifierFactory arg12, int arg13, Object arg14) {
        Function1 v0 = null;
        if((arg13 & 2) != 0) {
            arg3 = v0;
        }

        if((arg13 & 4) != 0) {
            arg4 = v0;
        }

        if((arg13 & 8) != 0) {
            arg5 = NaNf;
        }

        if((arg13 & 0x20) != 0) {
            arg7 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        if((arg13 & 0x40) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg13 & 0x80) != 0) {
            arg10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg13 & 0x200) != 0) {
            arg12 = ((PlatformMagnifierFactory)v0);
        }

        return Magnifier_androidKt.magnifier-jPUL71Q(arg1, arg2, arg3, arg4, arg5, false, arg7, arg9, arg10, true, arg12);
    }
}

