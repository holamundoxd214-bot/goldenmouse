package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0003"}, d2={"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DrawModifier extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean all(DrawModifier arg0, Function1 arg1) {
            return arg0.all(arg1);
        }

        @Deprecated public static boolean any(DrawModifier arg0, Function1 arg1) {
            return arg0.any(arg1);
        }

        @Deprecated public static Object foldIn(DrawModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldIn(arg1, arg2);
        }

        @Deprecated public static Object foldOut(DrawModifier arg0, Object arg1, Function2 arg2) {
            return arg0.foldOut(arg1, arg2);
        }

        @Deprecated public static Modifier then(DrawModifier arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    static boolean access$all$jd(DrawModifier arg0, Function1 arg1) {
        return super.all(arg1);
    }

    static boolean access$any$jd(DrawModifier arg0, Function1 arg1) {
        return super.any(arg1);
    }

    static Object access$foldIn$jd(DrawModifier arg0, Object arg1, Function2 arg2) {
        return super.foldIn(arg1, arg2);
    }

    static Object access$foldOut$jd(DrawModifier arg0, Object arg1, Function2 arg2) {
        return super.foldOut(arg1, arg2);
    }

    static Modifier access$then$jd(DrawModifier arg0, Modifier arg1) {
        return super.then(arg1);
    }

    void draw(ContentDrawScope arg1);
}

