package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007\u001A\f\u0010\u0002\u001A\u00020\u0001*\u00020\u0001H\u0007\u001A\u0014\u0010\u0003\u001A\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001\u001A\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0007\"\u0019\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"withoutVisualEffect", "Landroidx/compose/foundation/OverscrollEffect;", "withoutEventHandling", "overscroll", "Landroidx/compose/ui/Modifier;", "overscrollEffect", "rememberOverscrollEffect", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "LocalOverscrollFactory", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/OverscrollFactory;", "getLocalOverscrollFactory", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OverscrollKt {
    private static final ProvidableCompositionLocal LocalOverscrollFactory;

    static {
        OverscrollKt.LocalOverscrollFactory = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new OverscrollKt$$ExternalSyntheticLambda0());
    }

    static final OverscrollFactory LocalOverscrollFactory$lambda$0(CompositionLocalAccessorScope arg0) {
        return AndroidOverscroll_androidKt.defaultOverscrollFactory(arg0);
    }

    public static final ProvidableCompositionLocal getLocalOverscrollFactory() {
        return OverscrollKt.LocalOverscrollFactory;
    }

    public static final Modifier overscroll(Modifier arg2, OverscrollEffect arg3) {
        Modifier v0;
        if(arg3 != null) {
            v0 = arg3.getEffectModifier();
            if(v0 == null) {
                goto label_3;
            }
        }
        else {
        label_3:
            Companion v0_1 = Modifier.Companion;
        }

        if(v0 != Modifier.Companion) {
        }
        else {
            OverscrollModifierElement v0_2 = new OverscrollModifierElement(arg3);
        }

        return arg2.then(v0);
    }

    public static final OverscrollEffect rememberOverscrollEffect(Composer arg3, int arg4) {
        OverscrollEffect v1_1;
        int v0 = 0x10DD5AB0;
        arg3.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg3, "C(rememberOverscrollEffect)344@15316L7,345@15350L74:Overscroll.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.rememberOverscrollEffect (Overscroll.kt:343)");
        }

        ProvidableCompositionLocal v4 = OverscrollKt.LocalOverscrollFactory;
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(v4_1 == null) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg3.endReplaceGroup();
            return null;
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0x4EF1801A, "CC(remember):Overscroll.kt#9igjgp");
        boolean v0_1 = arg3.changed(v4_1);
        Object v1 = arg3.rememberedValue();
        if((v0_1) || v1 == Composer.Companion.getEmpty()) {
            v1_1 = ((OverscrollFactory)v4_1).createOverscrollEffect();
            arg3.updateRememberedValue(v1_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg3.endReplaceGroup();
        return v1_1;
    }

    public static final OverscrollEffect withoutEventHandling(OverscrollEffect arg3) {
        return new WrappedOverscrollEffect(true, false, arg3);
    }

    public static final OverscrollEffect withoutVisualEffect(OverscrollEffect arg3) {
        return new WrappedOverscrollEffect(false, true, arg3);
    }
}

