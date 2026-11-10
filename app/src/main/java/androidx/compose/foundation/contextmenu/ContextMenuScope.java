package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001BÄ\u0001\b\u0000\u0012¸\u0001\u0010\u0002\u001A³\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u00125\u00123\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000E¢\u0006\u0002\b\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\b\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001B\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\fH\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001E\u001A\u00020\u0011H\u0000¢\u0006\u0002\b\u001FJl\u0010 \u001A\u00020\u00112\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\n2*\b\u0002\u0010\u0013\u001A$\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000E¢\u0006\u0002\b\u00122\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0002\u0010!J\u0006\u0010\"\u001A\u00020\u0011RÂ\u0001\u0010\u0002\u001A³\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u00125\u00123\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000E¢\u0006\u0002\b\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R4\u0010\u0019\u001A(\u0012$\u0012\"\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00110\u000E¢\u0006\u0002\b\u00120\u001AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "itemUi", "Lkotlin/Function6;", "Landroidx/compose/ui/Modifier;", "Lkotlin/ParameterName;", "name", "modifier", "", "label", "", "enabled", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "colors", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Color;", "iconColor", "", "Landroidx/compose/runtime/Composable;", "leadingIcon", "Lkotlin/Function0;", "onClick", "<init>", "(Lkotlin/jvm/functions/Function8;)V", "Lkotlin/jvm/functions/Function8;", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Content", "Content$foundation", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "clear", "clear$foundation", "item", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "separator", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextMenuScope {
    public static final int $stable;
    private final SnapshotStateList composables;
    private final Function8 itemUi;

    static {
    }

    public ContextMenuScope(Function8 arg1) {
        super();
        this.itemUi = arg1;
        this.composables = SnapshotStateKt.mutableStateListOf();
    }

    public final void Content$foundation(ContextMenuColors arg7, Composer arg8, int arg9) {
        int v2;
        int v1;
        int v0 = -798501095;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(Content)N(colors)*256@9261L18:ContextMenuUi.kt#3xeu6s");
        if((arg9 & 6) == 0) {
            v1 = arg8.changed(arg7) ? 4 : 2;
            v1 |= arg9;
        }
        else {
            v1 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            v2 = arg8.changed(this) ? 0x20 : 16;
            v1 |= v2;
        }

        int v4 = 0;
        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg8.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.kt:255)");
            }

            SnapshotStateList v0_1 = this.composables;
            v2 = v0_1.size();
            while(v4 < v2) {
                ((List)v0_1).get(v4).invoke(arg7, arg8, Integer.valueOf(v1 & 14));
                ++v4;
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_52;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_52:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new ContextMenuScope$$ExternalSyntheticLambda1(this, arg7, arg9));
        }
    }

    static final Unit Content$lambda$1(ContextMenuScope arg0, ContextMenuColors arg1, int arg2, Composer arg3, int arg4) {
        arg0.Content$foundation(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public final void clear$foundation() {
        this.composables.clear();
    }

    public final void item(Function2 arg9, Modifier arg10, boolean arg11, Function3 arg12, Function0 arg13) {
        this.composables.add(ComposableLambdaKt.composableLambdaInstance(0x9559B1CD, true, new ContextMenuScope$$ExternalSyntheticLambda0(arg9, this, arg10, arg11, arg12, arg13)));
    }

    public static void item$default(ContextMenuScope arg6, Function2 arg7, Modifier arg8, boolean arg9, Function3 arg10, Function0 arg11, int arg12, Object arg13) {
        Companion v8;
        if((arg12 & 2) != 0) {
            v8 = Modifier.Companion;
        }

        Modifier v2 = ((Modifier)v8);
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        arg6.item(arg7, v2, true, arg10, arg11);
    }

    static final Unit item$lambda$0(Function2 arg9, ContextMenuScope arg10, Modifier arg11, boolean arg12, Function3 arg13, Function0 arg14, ContextMenuColors arg15, Composer arg16, int arg17) {
        int v0;
        Composer v7 = arg16;
        ComposerKt.sourceInformation(v7, "CN(colors)297@11061L7,299@11169L70:ContextMenuUi.kt#3xeu6s");
        if((arg17 & 6) == 0) {
            v0 = v7.changed(arg15) ? 4 : 2;
            v0 |= arg17;
        }
        else {
            v0 = arg17;
        }

        boolean v1 = (v0 & 19) != 18 ? true : false;
        if(v7.shouldExecute(v1, v0 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x9559B1CD, v0, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.kt:297)");
            }

            Object v2 = arg9.invoke(v7, Integer.valueOf(0));
            if(StringsKt.isBlank(v2)) {
                InlineClassHelperKt.throwIllegalStateException("Label must not be blank");
            }

            arg10.itemUi.invoke(arg11, v2, Boolean.valueOf(arg12), arg15, arg13, arg14, v7, Integer.valueOf(v0 << 9 & 0x1C00));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_53;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg16.skipToGroupEnd();
        }

    label_53:
        return Unit.INSTANCE;
    }

    public final void separator() {
        this.composables.add(ComposableSingletons$ContextMenuUiKt.INSTANCE.getLambda$-1455401925$foundation());
    }
}

