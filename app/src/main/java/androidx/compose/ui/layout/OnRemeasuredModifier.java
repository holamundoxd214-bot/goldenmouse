package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/Modifier$Element;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface OnRemeasuredModifier extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean all(OnRemeasuredModifier arg0, Function1 arg1) {
            return arg0.all(arg1);
        }

        @Deprecated public static boolean any(OnRemeasuredModifier arg0, Function1 arg1) {
            return arg0.any(arg1);
        }

        @Deprecated public static Object foldIn(OnRemeasuredModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldIn(arg1, arg2);
        }

        @Deprecated public static Object foldOut(OnRemeasuredModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldOut(arg1, arg2);
        }

        @Deprecated public static Modifier then(OnRemeasuredModifier arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    static boolean access$all$jd(OnRemeasuredModifier arg0, Function1 arg1) {
        return super.all(arg1);
    }

    static boolean access$any$jd(OnRemeasuredModifier arg0, Function1 arg1) {
        return super.any(arg1);
    }

    static Object access$foldIn$jd(OnRemeasuredModifier arg0, Object arg1, Function2 arg2) {
        return super.foldIn(arg1, arg2);
    }

    static Object access$foldOut$jd(OnRemeasuredModifier arg0, Object arg1, Function2 arg2) {
        return super.foldOut(arg1, arg2);
    }

    static Modifier access$then$jd(OnRemeasuredModifier arg0, Modifier arg1) {
        return super.then(arg1);
    }

    void onRemeasured-ozmzZPI(long arg1);
}

