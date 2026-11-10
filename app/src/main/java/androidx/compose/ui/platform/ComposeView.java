package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0016\u001A\u00020\rH\u0017¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u001E\u0010\u001A\u001A\u00020\r2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E¢\u0006\u0002\u0010\u001BR!\u0010\n\u001A\u0015\u0012\u0011\u0012\u000F\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\b\u000E0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010@RX\u0094\u000E¢\u0006\u000E\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001C"}, d2={"Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "value", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "getAccessibilityClassName", "", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ComposeView extends AbstractComposeView {
    public static final int $stable = 8;
    private final MutableState content;
    private boolean shouldCreateCompositionOnAttachedToWindow;

    static {
    }

    public ComposeView(Context arg1, AttributeSet arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, 0);
    }

    public ComposeView(Context arg7) {
        this(arg7, null, 0, 6, null);
    }

    public ComposeView(Context arg7, AttributeSet arg8) {
        this(arg7, arg8, 0, 4, null);
    }

    public ComposeView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.content = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public void Content(Composer arg6, int arg7) {
        int v1;
        int v0 = 0x190BF45A;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(Content):ComposeView.android.kt#itgzvw");
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:444)");
            }

            Object v0_1 = this.content.getValue();
            if(v0_1 == null) {
                arg6.startReplaceGroup(0xB6290D7F);
            }
            else {
                arg6.startReplaceGroup(0x5E04AC2);
                ComposerKt.sourceInformation(arg6, "445@18661L8");
                ((Function2)v0_1).invoke(arg6, Integer.valueOf(0));
            }

            arg6.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_47;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_47:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new ComposeView$Content$1(this, arg7));
        }
    }

    public CharSequence getAccessibilityClassName() {
        return this.getClass().getName();
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    protected static void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    public final void setContent(Function2 arg2) {
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.content.setValue(arg2);
        if(this.isAttachedToWindow()) {
            this.createComposition();
        }
    }
}

