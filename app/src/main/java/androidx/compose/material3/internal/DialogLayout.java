package androidx.compose.material3.internal;

import android.content.Context;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0012\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\u001C2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E¢\u0006\u0002\u0010\u001DJ\r\u0010\u001E\u001A\u00020\rH\u0017¢\u0006\u0002\u0010\u001FR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nRA\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E2\u0011\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001E\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0017@RX\u0094\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006 "}, d2={"Landroidx/compose/material3/internal/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "<init>", "(Landroid/content/Context;Landroid/view/Window;)V", "getWindow", "()Landroid/view/Window;", "<set-?>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "value", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DialogLayout extends AbstractComposeView implements DialogWindowProvider {
    private final MutableState content$delegate;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final Window window;

    public DialogLayout(Context arg7, Window arg8) {
        super(arg7, null, 0, 6, null);
        this.window = arg8;
        this.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$BasicEdgeToEdgeDialog_androidKt.INSTANCE.getLambda$453789431$material3(), null, 2, null);
    }

    public void Content(Composer arg6, int arg7) {
        int v1;
        int v0 = -2017021053;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(Content)330@12553L9:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(this) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.DialogLayout.Content (BasicEdgeToEdgeDialog.android.kt:329)");
            }

            this.getContent().invoke(arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_37;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_37:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new DialogLayout$$ExternalSyntheticLambda0(this, arg7));
        }
    }

    static final Unit Content$lambda$0(DialogLayout arg0, int arg1, Composer arg2, int arg3) {
        arg0.Content(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private final Function2 getContent() {
        return this.content$delegate.getValue();
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public Window getWindow() {
        return this.window;
    }

    private final void setContent(Function2 arg1) {
        this.content$delegate.setValue(arg1);
    }

    public final void setContent(CompositionContext arg1, Function2 arg2) {
        this.setParentCompositionContext(arg1);
        this.setContent(arg2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.createComposition();
    }
}

