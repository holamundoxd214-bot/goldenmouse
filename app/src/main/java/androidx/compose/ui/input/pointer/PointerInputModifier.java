package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/Modifier$Element;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PointerInputModifier extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean all(PointerInputModifier arg0, Function1 arg1) {
            return arg0.all(arg1);
        }

        @Deprecated public static boolean any(PointerInputModifier arg0, Function1 arg1) {
            return arg0.any(arg1);
        }

        @Deprecated public static Object foldIn(PointerInputModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldIn(arg1, arg2);
        }

        @Deprecated public static Object foldOut(PointerInputModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldOut(arg1, arg2);
        }

        @Deprecated public static Modifier then(PointerInputModifier arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    static boolean access$all$jd(PointerInputModifier arg0, Function1 arg1) {
        return super.all(arg1);
    }

    static boolean access$any$jd(PointerInputModifier arg0, Function1 arg1) {
        return super.any(arg1);
    }

    static Object access$foldIn$jd(PointerInputModifier arg0, Object arg1, Function2 arg2) {
        return super.foldIn(arg1, arg2);
    }

    static Object access$foldOut$jd(PointerInputModifier arg0, Object arg1, Function2 arg2) {
        return super.foldOut(arg1, arg2);
    }

    static Modifier access$then$jd(PointerInputModifier arg0, Modifier arg1) {
        return super.then(arg1);
    }

    PointerInputFilter getPointerInputFilter();
}

