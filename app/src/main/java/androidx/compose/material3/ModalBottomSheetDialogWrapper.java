package androidx.compose.material3;

import android.os.Build$VERSION;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.BackEventCompat;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.animation.core.Animatable;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u00017Ba\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u0012\u0006\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010$\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0002J&\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\'2\u0011\u0010(\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b)¢\u0006\u0002\u0010*J\u0010\u0010+\u001A\u00020\u00052\u0006\u0010,\u001A\u00020-H\u0002J3\u0010.\u001A\u00020\u00052\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b/\u00100J\u0006\u00101\u001A\u00020\u0005J\u0010\u00102\u001A\u0002032\u0006\u00104\u001A\u000205H\u0016J\b\u00106\u001A\u00020\u0005H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001AR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u00020\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001FR\u0014\u0010 \u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u00068"}, d2={"Landroidx/compose/material3/ModalBottomSheetDialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;JLandroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "dialogLayout", "Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "updateParameters-9LQNqLg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;JLandroidx/compose/ui/unit/LayoutDirection;)V", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "cancel", "PredictiveBackOnBackPressedCallback", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ModalBottomSheetDialogWrapper extends ComponentDialog implements ViewRootForInspector {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001B\u001A\u00020\fH\u0016J\b\u0010\u001C\u001A\u00020\fH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R \u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001D"}, d2={"Landroidx/compose/material3/ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "isEnabled", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "onDismissRequest", "Lkotlin/Function0;", "", "<init>", "(ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function0;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getPredictiveBackProgress", "()Landroidx/compose/animation/core/Animatable;", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "setOnDismissRequest", "(Lkotlin/jvm/functions/Function0;)V", "handleOnBackStarted", "backEvent", "Landroidx/activity/BackEventCompat;", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class PredictiveBackOnBackPressedCallback extends OnBackPressedCallback {
        private Function0 onDismissRequest;
        private final Animatable predictiveBackProgress;
        private final CoroutineScope scope;

        public PredictiveBackOnBackPressedCallback(boolean arg1, CoroutineScope arg2, Animatable arg3, Function0 arg4) {
            super(arg1);
            this.scope = arg2;
            this.predictiveBackProgress = arg3;
            this.onDismissRequest = arg4;
        }

        public final Function0 getOnDismissRequest() {
            return this.onDismissRequest;
        }

        public final Animatable getPredictiveBackProgress() {
            return this.predictiveBackProgress;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        public void handleOnBackCancelled() {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackCancelled$1(this, null), 3, null);
        }

        public void handleOnBackPressed() {
            this.onDismissRequest.invoke();
        }

        public void handleOnBackProgressed(BackEventCompat arg7) {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackProgressed$1(this, arg7, null), 3, null);
        }

        public void handleOnBackStarted(BackEventCompat arg7) {
            BuildersKt.launch$default(this.scope, null, null, new ModalBottomSheetDialogWrapper$PredictiveBackOnBackPressedCallback$handleOnBackStarted$1(this, arg7, null), 3, null);
        }

        public final void setOnDismissRequest(Function0 arg1) {
            this.onDismissRequest = arg1;
        }
    }

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
    private long contentColor;
    private final ModalBottomSheetDialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0 onDismissRequest;
    private ModalBottomSheetProperties properties;

    private ModalBottomSheetDialogWrapper(Function0 arg7, ModalBottomSheetProperties arg8, long arg9, View arg11, LayoutDirection arg12, Density arg13, UUID arg14, Animatable arg15, CoroutineScope arg16) {
        super(new ContextThemeWrapper(arg11.getContext(), style.EdgeToEdgeFloatingDialogWindowTheme), 0, 2, null);
        this.onDismissRequest = arg7;
        this.properties = arg8;
        this.contentColor = arg9;
        this.composeView = arg11;
        float v7 = Dp.constructor-impl(8f);
        this.maxSupportedElevation = v7;
        Window v8 = this.getWindow();
        if(v8 != null) {
            v8.requestFeature(1);
            v8.setBackgroundDrawableResource(0x106000D);
            WindowCompat.setDecorFitsSystemWindows(v8, false);
            ModalBottomSheetDialogLayout v9 = new ModalBottomSheetDialogLayout(this.getContext(), v8);
            v9.setTag(id.compose_view_saveable_id_tag, "Dialog:" + arg14);
            v9.setClipChildren(false);
            v9.setElevation(arg13.toPx-0680j_4(v7));
            v9.setOutlineProvider(new ModalBottomSheetDialogWrapper$1$2());
            this.dialogLayout = v9;
            this.setContentView(v9);
            ViewTreeLifecycleOwner.set(v9, ViewTreeLifecycleOwner.get(arg11));
            ViewTreeViewModelStoreOwner.set(v9, ViewTreeViewModelStoreOwner.get(arg11));
            ViewTreeSavedStateRegistryOwner.set(((View)v9), ViewTreeSavedStateRegistryOwner.get(arg11));
            this.updateParameters-9LQNqLg(this.onDismissRequest, this.properties, this.contentColor, arg12);
            WindowInsetsControllerCompat v7_1 = WindowCompat.getInsetsController(v8, v8.getDecorView());
            Boolean v8_1 = this.properties.isAppearanceLightStatusBars$material3();
            boolean v8_2 = v8_1 != null ? v8_1.booleanValue() : ModalBottomSheet_androidKt.isDark-8_81llA(this.contentColor);
            v7_1.setAppearanceLightStatusBars(v8_2);
            v8_1 = this.properties.isAppearanceLightNavigationBars$material3();
            v8_2 = v8_1 != null ? v8_1.booleanValue() : ModalBottomSheet_androidKt.isDark-8_81llA(this.contentColor);
            v7_1.setAppearanceLightNavigationBars(v8_2);
            this.getOnBackPressedDispatcher().addCallback(this, new PredictiveBackOnBackPressedCallback(this.properties.getShouldDismissOnBackPress(), arg16, arg15, new ModalBottomSheetDialogWrapper$$ExternalSyntheticLambda0(this)));
            return;
        }

        throw new IllegalStateException("Dialog has no window".toString());
    }

    public ModalBottomSheetDialogWrapper(Function0 arg1, ModalBottomSheetProperties arg2, long arg3, View arg5, LayoutDirection arg6, Density arg7, UUID arg8, Animatable arg9, CoroutineScope arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    static final Unit _init_$lambda$3(ModalBottomSheetDialogWrapper arg0) {
        arg0.onDismissRequest.invoke();
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
        ModalBottomSheetDialogLayout v2 = this.dialogLayout;
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

    public final void updateParameters-9LQNqLg(Function0 arg1, ModalBottomSheetProperties arg2, long arg3, LayoutDirection arg5) {
        this.onDismissRequest = arg1;
        this.properties = arg2;
        this.contentColor = arg3;
        this.setSecurePolicy(arg2.getSecurePolicy());
        this.setLayoutDirection(arg5);
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

