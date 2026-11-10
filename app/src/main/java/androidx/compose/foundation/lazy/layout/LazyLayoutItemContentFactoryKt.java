package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001A;\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0005H\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"SkippableItem", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "saveableStateHolder", "Landroidx/compose/foundation/lazy/layout/StableValue;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "index", "", "key", "", "SkippableItem-JVlU9Rs", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Ljava/lang/Object;ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemContentFactoryKt {
    private static final void SkippableItem-JVlU9Rs(LazyLayoutItemProvider arg6, Object arg7, int arg8, Object arg9, Composer arg10, int arg11) {
        int v2;
        int v1;
        int v0 = 0x55D242FD;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(SkippableItem)N(itemProvider,saveableStateHolder:c#foundation.lazy.layout.StableValue,index,key:c#foundation.lazy.layout.StableValue)125@4709L51,125@4676L84:LazyLayoutItemContentFactory.kt#wow0x6");
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg6) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(arg7) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changed(arg8) ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((arg11 & 0xC00) == 0) {
            v2 = arg10.changed(arg9) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:124)");
            }

            arg7.SaveableStateProvider(arg9, ComposableLambdaKt.rememberComposableLambda(980966366, true, new LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda0(arg6, arg8, arg9), arg10, 54), arg10, 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_66;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_66:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda1(arg6, arg7, arg8, arg9, arg11));
        }
    }

    static final Unit SkippableItem_JVlU9Rs$lambda$0(LazyLayoutItemProvider arg4, int arg5, Object arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformation(arg7, "C126@4732L22:LazyLayoutItemContentFactory.kt#wow0x6");
        boolean v0 = (arg8 & 3) != 2 ? true : false;
        if(arg7.shouldExecute(v0, arg8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980966366, arg8, -1, "androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:126)");
            }

            arg4.Item(arg5, arg6, arg7, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_24;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_24:
        return Unit.INSTANCE;
    }

    static final Unit SkippableItem_JVlU9Rs$lambda$1(LazyLayoutItemProvider arg6, Object arg7, int arg8, Object arg9, int arg10, Composer arg11, int arg12) {
        LazyLayoutItemContentFactoryKt.SkippableItem-JVlU9Rs(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$SkippableItem-JVlU9Rs(LazyLayoutItemProvider arg0, Object arg1, int arg2, Object arg3, Composer arg4, int arg5) {
        LazyLayoutItemContentFactoryKt.SkippableItem-JVlU9Rs(arg0, arg1, arg2, arg3, arg4, arg5);
    }
}

