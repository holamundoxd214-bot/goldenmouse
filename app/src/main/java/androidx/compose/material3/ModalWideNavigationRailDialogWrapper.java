package androidx.compose.material3;

import android.os.Build$VERSION;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011\u0012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010#\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0002J&\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020&2\u0011\u0010\'\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b(¢\u0006\u0002\u0010)J\u0010\u0010*\u001A\u00020\u00052\u0006\u0010+\u001A\u00020,H\u0002J$\u0010-\u001A\u00020\u00052\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ\u0006\u0010.\u001A\u00020\u0005J\u0010\u0010/\u001A\u00020\u00172\u0006\u00100\u001A\u000201H\u0016J\b\u00102\u001A\u00020\u0005H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001ER\u0014\u0010\u001F\u001A\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u00063"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailDialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "darkThemeEnabled", "", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Z)V", "dialogLayout", "Landroidx/compose/material3/ModalWideNavigationRailDialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "disposeComposition", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "cancel", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ModalWideNavigationRailDialogWrapper extends ComponentDialog implements ViewRootForInspector {
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
    private final ModalWideNavigationRailDialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0 onDismissRequest;
    private ModalWideNavigationRailProperties properties;

    public ModalWideNavigationRailDialogWrapper(Function0 arg14, ModalWideNavigationRailProperties arg15, View arg16, LayoutDirection arg17, Density arg18, UUID arg19, Function1 arg20, Function0 arg21, RailPredictiveBackState arg22, boolean arg23) {
        super(new ContextThemeWrapper(arg16.getContext(), style.EdgeToEdgeFloatingDialogWindowTheme), 0, 2, null);
        this.onDismissRequest = arg14;
        this.properties = arg15;
        View v14 = arg16;
        this.composeView = v14;
        float v0 = Dp.constructor-impl(8f);
        this.maxSupportedElevation = v0;
        Window v6 = this.getWindow();
        if(v6 != null) {
            v6.requestFeature(1);
            v6.setBackgroundDrawableResource(0x106000D);
            WindowCompat.setDecorFitsSystemWindows(v6, false);
            ModalWideNavigationRailDialogLayout v4 = new ModalWideNavigationRailDialogLayout(this.getContext(), v6, this.properties.getShouldDismissOnBackPress(), this.onDismissRequest, arg20, arg21, arg22, arg17);
            v4.setTag(id.compose_view_saveable_id_tag, "Dialog:" + arg19);
            v4.setClipChildren(false);
            v4.setElevation(arg18.toPx-0680j_4(v0));
            v4.setOutlineProvider(new ModalWideNavigationRailDialogWrapper$1$2());
            this.dialogLayout = v4;
            this.setContentView(v4);
            ViewTreeLifecycleOwner.set(v4, ViewTreeLifecycleOwner.get(v14));
            ViewTreeViewModelStoreOwner.set(v4, ViewTreeViewModelStoreOwner.get(v14));
            ViewTreeSavedStateRegistryOwner.set(((View)v4), ViewTreeSavedStateRegistryOwner.get(v14));
            this.updateParameters(this.onDismissRequest, this.properties, arg17);
            WindowInsetsControllerCompat v14_1 = WindowCompat.getInsetsController(v6, v6.getDecorView());
            v14_1.setAppearanceLightStatusBars((((int)arg23)) ^ 1);
            v14_1.setAppearanceLightNavigationBars((((int)arg23)) ^ 1);
            OnBackPressedDispatcherKt.addCallback$default(this.getOnBackPressedDispatcher(), this, false, new ModalWideNavigationRailDialogWrapper$$ExternalSyntheticLambda0(this), 2, null);
            return;
        }

        throw new IllegalStateException("Dialog has no window".toString());
    }

    static final Unit _init_$lambda$3(ModalWideNavigationRailDialogWrapper arg0, OnBackPressedCallback arg1) {
        if(arg0.properties.getShouldDismissOnBackPress()) {
            arg0.onDismissRequest.invoke();
        }

        return Unit.INSTANCE;
    }

    public void cancel() {
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
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
        ModalWideNavigationRailDialogLayout v2 = this.dialogLayout;
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

    public final void updateParameters(Function0 arg1, ModalWideNavigationRailProperties arg2, LayoutDirection arg3) {
        this.onDismissRequest = arg1;
        this.properties = arg2;
        this.setSecurePolicy(arg2.getSecurePolicy());
        this.setLayoutDirection(arg3);
        Window v1 = this.getWindow();
        if(v1 != null) {
            v1.setLayout(-1, -1);
        }

        Window v0 = this.getWindow();
        if(v0 != null) {
            int v1_1 = Build$VERSION.SDK_INT >= 30 ? 0x30 : 16;
            v0.setSoftInputMode(v1_1);
        }
    }
}

