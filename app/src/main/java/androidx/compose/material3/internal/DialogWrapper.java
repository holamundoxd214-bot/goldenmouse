package androidx.compose.material3.internal;

import android.os.Build$VERSION;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.material3.ModalBottomSheet_androidKt;
import androidx.compose.material3.R$style;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"H\u0016J\u0010\u0010#\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0002J&\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020&2\u0011\u0010\'\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b(¢\u0006\u0002\u0010)J\u0010\u0010*\u001A\u00020\u00052\u0006\u0010+\u001A\u00020,H\u0002J4\u0010-\u001A\u00020\u00052\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011J\u0006\u0010.\u001A\u00020\u0005J\u0010\u0010/\u001A\u00020\u00112\u0006\u0010!\u001A\u000200H\u0016J\b\u00101\u001A\u00020\u0005H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u00062"}, d2={"Landroidx/compose/material3/internal/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "lightStatusBars", "", "lightNavigationBars", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;ZZ)V", "dialogLayout", "Landroidx/compose/material3/internal/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "onKeyUp", "keyCode", "", "event", "Landroid/view/KeyEvent;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "disposeComposition", "onTouchEvent", "Landroid/view/MotionEvent;", "cancel", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutDirection.Rtl.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    private final View composeView;
    private final DialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0 onDismissRequest;
    private DialogProperties properties;

    public DialogWrapper(Function0 arg5, DialogProperties arg6, View arg7, LayoutDirection arg8, Density arg9, UUID arg10, boolean arg11, boolean arg12) {
        super(new ContextThemeWrapper(arg7.getContext(), style.EdgeToEdgeFloatingDialogWindowTheme), 0, 2, null);
        this.onDismissRequest = arg5;
        this.properties = arg6;
        this.composeView = arg7;
        float v5 = Dp.constructor-impl(8f);
        this.maxSupportedElevation = v5;
        Window v6 = this.getWindow();
        if(v6 != null) {
            WindowCompat.setDecorFitsSystemWindows(v6, false);
            DialogLayout v0 = new DialogLayout(this.getContext(), v6);
            v0.setTag(id.compose_view_saveable_id_tag, "Dialog:" + arg10);
            v0.setClipChildren(false);
            v0.setElevation(arg9.toPx-0680j_4(v5));
            v0.setOutlineProvider(new DialogWrapper$1$2());
            this.dialogLayout = v0;
            this.setContentView(v0);
            ViewTreeLifecycleOwner.set(v0, ViewTreeLifecycleOwner.get(arg7));
            ViewTreeViewModelStoreOwner.set(v0, ViewTreeViewModelStoreOwner.get(arg7));
            ViewTreeSavedStateRegistryOwner.set(((View)v0), ViewTreeSavedStateRegistryOwner.get(arg7));
            this.updateParameters(this.onDismissRequest, this.properties, arg8, arg11, arg12);
            return;
        }

        throw new IllegalStateException("Dialog has no window".toString());
    }

    public void cancel() {
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    public boolean onKeyUp(int arg2, KeyEvent arg3) {
        if((this.properties.getDismissOnBackPress()) && (arg3.isTracking()) && !arg3.isCanceled() && arg2 == 0x6F) {
            this.onDismissRequest.invoke();
            return 1;
        }

        return super.onKeyUp(arg2, arg3);
    }

    public boolean onTouchEvent(MotionEvent arg1) {
        boolean v1 = super.onTouchEvent(arg1);
        if(v1) {
            this.onDismissRequest.invoke();
        }

        return v1;
    }

    public final void setContent(CompositionContext arg1, Function2 arg2) {
        this.dialogLayout.setContent(arg1, arg2);
    }

    private final void setLayoutDirection(LayoutDirection arg3) {
        DialogLayout v2 = this.dialogLayout;
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        int v0 = 1;
        if(v3 == 1) {
            v0 = 0;
        }
        else if(v3 == 2) {
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        v2.setLayoutDirection(v0);
    }

    private final void setSecurePolicy(SecureFlagPolicy arg2) {
        boolean v2 = BasicEdgeToEdgeDialog_androidKt.shouldApplySecureFlag(arg2, ModalBottomSheet_androidKt.isFlagSecureEnabled(this.composeView));
        Window v1 = this.getWindow();
        Intrinsics.checkNotNull(v1);
        int v0 = 0x2000;
        int v2_1 = v2 ? v0 : 0xFFFFDFFF;
        v1.setFlags(v2_1, v0);
    }

    public final void updateParameters(Function0 arg1, DialogProperties arg2, LayoutDirection arg3, boolean arg4, boolean arg5) {
        this.onDismissRequest = arg1;
        this.properties = arg2;
        this.setSecurePolicy(arg2.getSecurePolicy());
        this.setLayoutDirection(arg3);
        Window v0 = this.getWindow();
        if(v0 != null) {
            WindowInsetsControllerCompat v1 = WindowCompat.getInsetsController(v0, v0.getDecorView());
            v1.setAppearanceLightStatusBars(arg4);
            v1.setAppearanceLightNavigationBars(arg5);
            v0.setLayout(-1, -1);
            int v1_1 = Build$VERSION.SDK_INT >= 30 ? 0x30 : 16;
            v0.setSoftInputMode(v1_1);
        }
    }
}

