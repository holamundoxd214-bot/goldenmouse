package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/DefaultBasicAlertDialogOverride;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "<init>", "()V", "BasicAlertDialog", "", "Landroidx/compose/material3/BasicAlertDialogOverrideScope;", "(Landroidx/compose/material3/BasicAlertDialogOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultBasicAlertDialogOverride implements BasicAlertDialogOverride {
    public static final int $stable;
    public static final DefaultBasicAlertDialogOverride INSTANCE;

    static {
        DefaultBasicAlertDialogOverride.INSTANCE = new DefaultBasicAlertDialogOverride();
    }

    private DefaultBasicAlertDialogOverride() {
        super();
    }

    public void BasicAlertDialog(BasicAlertDialogOverrideScope arg8, Composer arg9, int arg10) {
        int v9;
        int v0 = 0x5D549E6C;
        Composer v4 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(BasicAlertDialog)164@7594L429,164@7525L498:AlertDialog.kt#uh7d8r");
        int v1 = 2;
        if((arg10 & 6) == 0) {
            v9 = v4.changed(arg8) ? 4 : v1;
            v9 |= arg10;
        }
        else {
            v9 = arg10;
        }

        boolean v1_1 = (v9 & 3) != v1 ? true : false;
        if(v4.shouldExecute(v1_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.material3.DefaultBasicAlertDialogOverride.BasicAlertDialog (AlertDialog.kt:163)");
            }

            AndroidDialog_androidKt.Dialog(arg8.getOnDismissRequest(), arg8.getProperties(), ComposableLambdaKt.rememberComposableLambda(0x455A0383, true, new DefaultBasicAlertDialogOverride$BasicAlertDialog$1(arg8), v4, 54), v4, 0x180, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_45;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_45:
        ScopeUpdateScope v9_1 = v4.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new DefaultBasicAlertDialogOverride$$ExternalSyntheticLambda0(this, arg8, arg10));
        }
    }

    static final Unit BasicAlertDialog$lambda$0(DefaultBasicAlertDialogOverride arg0, BasicAlertDialogOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.BasicAlertDialog(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }
}

