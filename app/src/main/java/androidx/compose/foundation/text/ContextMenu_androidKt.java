package androidx.compose.foundation.text;

import android.content.res.Resources;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\f\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\r2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000E\u001A=\u0010\u000F\u001A\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\u000B2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0000¨\u0006\u0019"}, d2={"ContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textItem", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "resources", "Landroid/content/res/Resources;", "item", "Landroidx/compose/foundation/text/TextContextMenuItems;", "onClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenu_androidKt {
    public static final void ContextMenuArea(TextFieldSelectionState arg4, boolean arg5, Function2 arg6, Composer arg7, int arg8) {
        int v2;
        int v1;
        int v0 = -579239002;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(ContextMenuArea)N(selectionState,enabled,content)44@1686L55:ContextMenu.android.kt#423gt5");
        if((arg8 & 6) == 0) {
            v1 = arg7.changedInstance(arg4) ? 4 : 2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            v2 = arg7.changed(arg5) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg8 & 0x180) == 0) {
            v2 = arg7.changedInstance(arg6) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg7.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:43)");
            }

            CommonContextMenuAreaKt.CommonContextMenuArea(arg4, arg5, arg6, arg7, v1 & 0x3FE);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_51;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_51:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new ContextMenu_androidKt$$ExternalSyntheticLambda0(arg4, arg5, arg6, arg8));
        }
    }

    public static final void ContextMenuArea(SelectionManager arg4, Function2 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 0xC714FA4F;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(ContextMenuArea)N(manager,content)50@1900L39:ContextMenu.android.kt#423gt5");
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg4) ? 4 : 2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            int v2 = arg6.changedInstance(arg5) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:49)");
            }

            CommonContextMenuAreaKt.CommonContextMenuArea(arg4, arg5, arg6, v1 & 0x7E);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_43;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_43:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new ContextMenu_androidKt$$ExternalSyntheticLambda1(arg4, arg5, arg7));
        }
    }

    public static final void ContextMenuArea(TextFieldSelectionManager arg4, Function2 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 2080741862;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(ContextMenuArea)N(manager,content)34@1441L39:ContextMenu.android.kt#423gt5");
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg4) ? 4 : 2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            int v2 = arg6.changedInstance(arg5) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:33)");
            }

            CommonContextMenuAreaKt.CommonContextMenuArea(arg4, arg5, arg6, v1 & 0x7E);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_43;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_43:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new ContextMenu_androidKt$$ExternalSyntheticLambda2(arg4, arg5, arg7));
        }
    }

    static final Unit ContextMenuArea$lambda$0(TextFieldSelectionManager arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        ContextMenu_androidKt.ContextMenuArea(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuArea$lambda$1(TextFieldSelectionState arg0, boolean arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        ContextMenu_androidKt.ContextMenuArea(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuArea$lambda$2(SelectionManager arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        ContextMenu_androidKt.ContextMenuArea(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void textItem(TextContextMenuBuilderScope arg1, Resources arg2, TextContextMenuItems arg3, boolean arg4, Function1 arg5) {
        if(arg4) {
            TextContextMenuBuilderScope_androidKt.item(arg1, arg3.getKey(), arg2.getString(arg3.getStringId-9Hzcbyc()), arg3.getDrawableId-3I4p1mQ(), arg5);
        }
    }
}

