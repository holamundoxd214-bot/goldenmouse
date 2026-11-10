package androidx.compose.material3;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.View;
import android.view.Window;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u000212B_\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u001F\u001A\u00020\u000B2\u0006\u0010(\u001A\u00020)2\u0011\u0010\u001C\u001A\r\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\u001B¢\u0006\u0002\u0010*J\r\u0010+\u001A\u00020\u000BH\u0017¢\u0006\u0002\u0010,J\b\u0010-\u001A\u00020\u000BH\u0014J\b\u0010.\u001A\u00020\u000BH\u0014J\b\u0010/\u001A\u00020\u000BH\u0002J\b\u00100\u001A\u00020\u000BH\u0002R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u001C\u001A\r\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\u001B2\u0011\u0010\u001A\u001A\r\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\u001B8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010&\u001A\u00020\b2\u0006\u0010%\u001A\u00020\b@RX\u0094\u000E¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u0019¨\u00063"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailDialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "shouldDismissOnBackPress", "", "onDismissRequest", "Lkotlin/Function0;", "", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(Landroid/content/Context;Landroid/view/Window;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Landroidx/compose/ui/unit/LayoutDirection;)V", "getWindow", "()Landroid/view/Window;", "getShouldDismissOnBackPress", "()Z", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "backCallback", "", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "onAttachedToWindow", "onDetachedFromWindow", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "Api34Impl", "Api33Impl", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ModalWideNavigationRailDialogLayout extends AbstractComposeView implements DialogWindowProvider {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001A\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0007J\u001A\u0010\r\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailDialogLayout$Api33Impl;", "", "<init>", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api33Impl {
        public static final Api33Impl INSTANCE;

        static {
            Api33Impl.INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
            super();
        }

        @JvmStatic public static final OnBackInvokedCallback createBackCallback(Function0 arg1) {
            return new ModalWideNavigationRailDialogLayout$Api33Impl$$ExternalSyntheticLambda0(arg1);
        }

        static final void createBackCallback$lambda$0(Function0 arg0) {
            arg0.invoke();
        }

        @JvmStatic public static final void maybeRegisterBackCallback(View arg1, Object arg2) {
            if((arg2 instanceof OnBackInvokedCallback)) {
                OnBackInvokedDispatcher v1 = arg1.findOnBackInvokedDispatcher();
                if(v1 != null) {
                    v1.registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)arg2));
                }
            }
        }

        @JvmStatic public static final void maybeUnregisterBackCallback(View arg1, Object arg2) {
            if((arg2 instanceof OnBackInvokedCallback)) {
                OnBackInvokedDispatcher v1 = arg1.findOnBackInvokedDispatcher();
                if(v1 != null) {
                    v1.unregisterOnBackInvokedCallback(((OnBackInvokedCallback)arg2));
                }
            }
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\b0\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailDialogLayout$Api34Impl;", "", "<init>", "()V", "createBackCallback", "Landroid/window/OnBackAnimationCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api34Impl {
        public static final Api34Impl INSTANCE;

        static {
            Api34Impl.INSTANCE = new Api34Impl();
        }

        private Api34Impl() {
            super();
        }

        @JvmStatic public static final OnBackAnimationCallback createBackCallback(Function0 arg6, Function1 arg7, Function0 arg8, RailPredictiveBackState arg9, LayoutDirection arg10) {
            return new ModalWideNavigationRailDialogLayout$Api34Impl$createBackCallback$1(arg9, arg10, arg7, arg6, arg8);
        }
    }

    private Object backCallback;
    private final MutableState content$delegate;
    private final LayoutDirection layoutDirection;
    private final Function0 onDismissRequest;
    private final Function1 onPredictiveBack;
    private final Function0 onPredictiveBackCancelled;
    private final RailPredictiveBackState predictiveBackState;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final boolean shouldDismissOnBackPress;
    private final Window window;

    public ModalWideNavigationRailDialogLayout(Context arg7, Window arg8, boolean arg9, Function0 arg10, Function1 arg11, Function0 arg12, RailPredictiveBackState arg13, LayoutDirection arg14) {
        super(arg7, null, 0, 6, null);
        this.window = arg8;
        this.shouldDismissOnBackPress = arg9;
        this.onDismissRequest = arg10;
        this.onPredictiveBack = arg11;
        this.onPredictiveBackCancelled = arg12;
        this.predictiveBackState = arg13;
        this.layoutDirection = arg14;
        this.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$WideNavigationRail_androidKt.INSTANCE.getLambda$2011757776$material3(), null, 2, null);
    }

    public void Content(Composer arg6, int arg7) {
        int v1;
        int v0 = -640057148;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(Content)203@7731L9:WideNavigationRail.android.kt#uh7d8r");
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.ModalWideNavigationRailDialogLayout.Content (WideNavigationRail.android.kt:202)");
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
            v6.updateScope(new ModalWideNavigationRailDialogLayout$$ExternalSyntheticLambda0(this, arg7));
        }
    }

    static final Unit Content$lambda$0(ModalWideNavigationRailDialogLayout arg0, int arg1, Composer arg2, int arg3) {
        arg0.Content(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private final Function2 getContent() {
        return this.content$delegate.getValue();
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public Window getWindow() {
        return this.window;
    }

    private final void maybeRegisterBackCallback() {
        OnBackInvokedCallback v0_3;
        if(this.shouldDismissOnBackPress) {
            if(Build$VERSION.SDK_INT < 33) {
            }
            else {
                Object v0 = this.backCallback;
                if(v0 == null) {
                    int v0_1 = Build$VERSION.SDK_INT;
                    Function0 v1 = this.onDismissRequest;
                    if(v0_1 >= 34) {
                        OnBackAnimationCallback v0_2 = Api34Impl.createBackCallback(v1, this.onPredictiveBack, this.onPredictiveBackCancelled, this.predictiveBackState, this.layoutDirection);
                    }
                    else {
                        v0_3 = Api33Impl.createBackCallback(v1);
                    }

                    this.backCallback = v0_3;
                }

                Api33Impl.maybeRegisterBackCallback(((View)this), v0_3);
            }
        }
    }

    private final void maybeUnregisterBackCallback() {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }

        this.backCallback = null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.maybeRegisterBackCallback();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.maybeUnregisterBackCallback();
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

