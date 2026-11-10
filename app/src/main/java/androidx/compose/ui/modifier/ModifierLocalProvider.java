package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00028\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/modifier/ModifierLocalProvider;", "T", "Landroidx/compose/ui/Modifier$Element;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ModifierLocalProvider extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean all(ModifierLocalProvider arg0, Function1 arg1) {
            return arg0.all(arg1);
        }

        @Deprecated public static boolean any(ModifierLocalProvider arg0, Function1 arg1) {
            return arg0.any(arg1);
        }

        @Deprecated public static Object foldIn(ModifierLocalProvider arg0, Object arg1, Function2 arg2) {
            return arg0.foldIn(arg1, arg2);
        }

        @Deprecated public static Object foldOut(ModifierLocalProvider arg0, Object arg1, Function2 arg2) {
            return arg0.foldOut(arg1, arg2);
        }

        @Deprecated public static Modifier then(ModifierLocalProvider arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    static boolean access$all$jd(ModifierLocalProvider arg0, Function1 arg1) {
        return super.all(arg1);
    }

    static boolean access$any$jd(ModifierLocalProvider arg0, Function1 arg1) {
        return super.any(arg1);
    }

    static Object access$foldIn$jd(ModifierLocalProvider arg0, Object arg1, Function2 arg2) {
        return super.foldIn(arg1, arg2);
    }

    static Object access$foldOut$jd(ModifierLocalProvider arg0, Object arg1, Function2 arg2) {
        return super.foldOut(arg1, arg2);
    }

    static Modifier access$then$jd(ModifierLocalProvider arg0, Modifier arg1) {
        return super.then(arg1);
    }

    ProvidableModifierLocal getKey();

    Object getValue();
}

