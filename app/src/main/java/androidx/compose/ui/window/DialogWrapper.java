package androidx.compose.ui.window;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$style;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0016J\u0010\u0010\"\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0002J&\u0010#\u001A\u00020\u00052\u0006\u0010$\u001A\u00020%2\u0011\u0010&\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\'¢\u0006\u0002\u0010(J\u0010\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020+H\u0002J$\u0010,\u001A\u00020\u00052\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ\u0006\u0010-\u001A\u00020\u0005J\u0010\u0010.\u001A\u00020\u00182\u0006\u0010 \u001A\u00020/H\u0016J\b\u00100\u001A\u00020\u0005H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u00020\u001A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u00061"}, d2={"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "isPressOutside", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "onKeyUp", "keyCode", "", "event", "Landroid/view/KeyEvent;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "disposeComposition", "onTouchEvent", "Landroid/view/MotionEvent;", "cancel", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
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
    private boolean isPressOutside;
    private final float maxSupportedElevation;
    private Function0 onDismissRequest;
    private DialogProperties properties;

    public DialogWrapper(Function0 arg7, DialogProperties arg8, View arg9, LayoutDirection arg10, Density arg11, UUID arg12) {
        View v3_1;
        Context v1 = arg9.getContext();
        int v2 = arg8.getDecorFitsSystemWindows() ? style.DialogWindowTheme : style.FloatingDialogWindowTheme;
        DefaultConstructorMarker v3 = null;
        super(new ContextThemeWrapper(v1, v2), 0, 2, v3);
        this.onDismissRequest = arg7;
        this.properties = arg8;
        this.composeView = arg9;
        float v7 = Dp.constructor-impl(8f);
        this.maxSupportedElevation = v7;
        Window v8 = this.getWindow();
        if(v8 != null) {
            v8.requestFeature(1);
            v8.setBackgroundDrawableResource(0x106000D);
            WindowCompat.setDecorFitsSystemWindows(v8, this.properties.getDecorFitsSystemWindows());
            v8.setGravity(17);
            if(!this.properties.getDecorFitsSystemWindows()) {
                v8.addFlags(0x10100);
                WindowManager$LayoutParams v0 = v8.getAttributes();
                if(Build$VERSION.SDK_INT >= 28) {
                    Api28Impl.INSTANCE.setLayoutInDisplayCutout(v0);
                }

                if(Build$VERSION.SDK_INT >= 30) {
                    Api30Impl.INSTANCE.setFitInsetsSides(v0, 0);
                    Api30Impl.INSTANCE.setFitInsetsTypes(v0, 0);
                }

                v8.setAttributes(v0);
            }

            DialogLayout v0_1 = new DialogLayout(this.getContext(), v8);
            this.setTitle(this.properties.getWindowTitle());
            v0_1.setTag(id.compose_view_saveable_id_tag, "Dialog:" + arg12);
            v0_1.setClipChildren(false);
            v0_1.setElevation(arg11.toPx-0680j_4(v7));
            v0_1.setOutlineProvider(new DialogWrapper$1$2());
            this.dialogLayout = v0_1;
            View v7_1 = v8.getDecorView();
            if((v7_1 instanceof ViewGroup)) {
                v3_1 = v7_1;
            }

            if(v3_1 != null) {
                DialogWrapper._init_$disableClipping(((ViewGroup)v3_1));
            }

            this.setContentView(v0_1);
            ViewTreeLifecycleOwner.set(v0_1, ViewTreeLifecycleOwner.get(arg9));
            ViewTreeViewModelStoreOwner.set(v0_1, ViewTreeViewModelStoreOwner.get(arg9));
            ViewTreeSavedStateRegistryOwner.set(((View)v0_1), ViewTreeSavedStateRegistryOwner.get(arg9));
            this.updateParameters(this.onDismissRequest, this.properties, arg10);
            OnBackPressedDispatcherKt.addCallback$default(this.getOnBackPressedDispatcher(), this, false, new Function1() {
                public Object invoke(Object arg1) {
                    this.invoke(((OnBackPressedCallback)arg1));
                    return Unit.INSTANCE;
                }

                public final void invoke(OnBackPressedCallback arg1) {
                    if(DialogWrapper.access$getProperties$p(DialogWrapper.this).getDismissOnBackPress()) {
                        DialogWrapper.access$getOnDismissRequest$p(DialogWrapper.this).invoke();
                    }
                }
            }, 2, null);
            return;
        }

        throw new IllegalStateException("Dialog has no window".toString());
    }

    private static final void _init_$disableClipping(ViewGroup arg4) {
        int v0 = 0;
        arg4.setClipChildren(false);
        if((arg4 instanceof DialogLayout)) {
        }
        else {
            int v1 = arg4.getChildCount();
            while(v0 < v1) {
                View v2 = arg4.getChildAt(v0);
                if((v2 instanceof ViewGroup)) {
                }
                else {
                    v2 = null;
                }

                if(v2 != null) {
                    DialogWrapper._init_$disableClipping(((ViewGroup)v2));
                }

                ++v0;
            }
        }
    }

    public static final Function0 access$getOnDismissRequest$p(DialogWrapper arg0) {
        return arg0.onDismissRequest;
    }

    public static final DialogProperties access$getProperties$p(DialogWrapper arg0) {
        return arg0.properties;
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

    public boolean onTouchEvent(MotionEvent arg6) {
        int v6;
        boolean v0 = super.onTouchEvent(arg6);
        int v2 = 3;
        if(!this.properties.getDismissOnClickOutside() || (this.dialogLayout.isInsideContent(arg6))) {
            v6 = arg6.getActionMasked();
            if(v6 != 0 && v6 != 1 && v6 != v2) {
                return v0;
            }

            goto label_30;
        }
        else {
            v6 = arg6.getActionMasked();
            if(v6 == 0) {
                this.isPressOutside = true;
                return 1;
            }
            else if(v6 != 1) {
                if(v6 != v2) {
                }
                else {
                    this.isPressOutside = false;
                    return v0;
                }
            }
            else if(this.isPressOutside) {
                this.onDismissRequest.invoke();
                this.isPressOutside = false;
                return 1;
            }
        }

        return v0;
    label_30:
        this.isPressOutside = false;
        return v0;
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
        boolean v2 = SecureFlagPolicy_androidKt.shouldApplySecureFlag(arg2, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window v1 = this.getWindow();
        Intrinsics.checkNotNull(v1);
        int v0 = 0x2000;
        int v2_1 = v2 ? v0 : 0xFFFFDFFF;
        v1.setFlags(v2_1, v0);
    }

    public final void updateParameters(Function0 arg2, DialogProperties arg3, LayoutDirection arg4) {
        int v2_1;
        this.onDismissRequest = arg2;
        this.properties = arg3;
        this.setSecurePolicy(arg3.getSecurePolicy());
        this.setLayoutDirection(arg4);
        boolean v2 = arg3.getDecorFitsSystemWindows();
        this.dialogLayout.updateProperties(arg3.getUsePlatformDefaultWidth(), v2);
        this.setCanceledOnTouchOutside(arg3.getDismissOnClickOutside());
        Window v1 = this.getWindow();
        if(v1 != null) {
            if(v2) {
                v2_1 = 0;
            }
            else if(Build$VERSION.SDK_INT < 0x1F) {
                v2_1 = 16;
            }
            else {
                v2_1 = 0x30;
            }

            v1.setSoftInputMode(v2_1);
        }
    }
}

