package androidx.compose.ui.window;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018J\u001D\u0010 \u001A\u00020\u000E2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\"H\u0010¢\u0006\u0002\b$J\u0018\u0010%\u001A\u00020\"2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\"H\u0002J5\u0010\'\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\"2\u0006\u0010*\u001A\u00020\"2\u0006\u0010+\u001A\u00020\"2\u0006\u0010,\u001A\u00020\"H\u0010¢\u0006\u0002\b-J&\u0010\u0013\u001A\u00020\u000E2\u0006\u0010.\u001A\u00020/2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F¢\u0006\u0002\u00100J\u0018\u00101\u001A\u0002022\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u000202H\u0016J~\u00106\u001A\u0002H7\"\u0004\b\u0000\u001072\u0006\u00108\u001A\u0002H72`\u00109\u001A\\\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H70:H\u0082\b¢\u0006\u0002\u0010=J\u000E\u0010>\u001A\u00020\u00182\u0006\u0010?\u001A\u00020@J\r\u0010A\u001A\u00020\u000EH\u0017¢\u0006\u0002\u0010BR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BRA\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F2\u0011\u0010\f\u001A\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0018@RX\u0094\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006C"}, d2={"Landroidx/compose/ui/window/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "<init>", "(Landroid/content/Context;Landroid/view/Window;)V", "getWindow", "()Landroid/view/Window;", "<set-?>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "usePlatformDefaultWidth", "", "decorFitsSystemWindows", "hasCalledSetLayout", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "updateProperties", "internalOnMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "internalOnMeasure$ui", "getMaxDialogHeightExcludingInsets", "height", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "Landroid/view/View;", "insets", "insetValue", "T", "unchangedValue", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "isInsideContent", "event", "Landroid/view/MotionEvent;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DialogLayout extends AbstractComposeView implements DialogWindowProvider, OnApplyWindowInsetsListener {
    private final MutableState content$delegate;
    private boolean decorFitsSystemWindows;
    private boolean hasCalledSetLayout;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private boolean usePlatformDefaultWidth;
    private final Window window;

    public DialogLayout(Context arg7, Window arg8) {
        super(arg7, null, 0, 6, null);
        this.window = arg8;
        this.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidDialog_androidKt.INSTANCE.getLambda$210148896$ui(), null, 2, null);
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
        ViewCompat.setWindowInsetsAnimationCallback(this, new Callback() {
            public WindowInsetsCompat onProgress(WindowInsetsCompat arg6, List arg7) {
                int v5_1;
                int v3;
                int v2;
                int v1;
                DialogLayout v5 = DialogLayout.this;
                if(DialogLayout.access$getDecorFitsSystemWindows$p(v5)) {
                }
                else {
                    View v0 = v5.getChildAt(0);
                    v1 = Math.max(0, v0.getLeft());
                    v2 = Math.max(0, v0.getTop());
                    v3 = Math.max(0, v5.getWidth() - v0.getRight());
                    v5_1 = Math.max(0, v5.getHeight() - v0.getBottom());
                    if(v1 == 0 && v2 == 0 && v3 == 0 && v5_1 == 0) {
                        return arg6;
                    }

                    goto label_23;
                }

                return arg6;
            label_23:
                return arg6.inset(v1, v2, v3, v5_1);
            }

            public BoundsCompat onStart(WindowInsetsAnimationCompat arg6, BoundsCompat arg7) {
                int v5_1;
                int v3;
                int v2;
                int v1;
                DialogLayout v5 = DialogLayout.this;
                if(DialogLayout.access$getDecorFitsSystemWindows$p(v5)) {
                }
                else {
                    View v0 = v5.getChildAt(0);
                    v1 = Math.max(0, v0.getLeft());
                    v2 = Math.max(0, v0.getTop());
                    v3 = Math.max(0, v5.getWidth() - v0.getRight());
                    v5_1 = Math.max(0, v5.getHeight() - v0.getBottom());
                    if(v1 == 0 && v2 == 0 && v3 == 0 && v5_1 == 0) {
                        return arg7;
                    }

                    goto label_23;
                }

                return arg7;
            label_23:
                return arg7.inset(Insets.of(v1, v2, v3, v5_1));
            }
        });
    }

    public void Content(Composer arg6, int arg7) {
        int v1;
        int v0 = 0x6770D814;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(Content)455@18976L9:AndroidDialog.android.kt#2oxthz");
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:454)");
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
            v6.updateScope(new DialogLayout$Content$4(this, arg7));
        }
    }

    public static final boolean access$getDecorFitsSystemWindows$p(DialogLayout arg0) {
        return arg0.decorFitsSystemWindows;
    }

    private final Function2 getContent() {
        return this.content$delegate.getValue();
    }

    private final int getMaxDialogHeightExcludingInsets(Window arg2, int arg3) {
        if(Build$VERSION.SDK_INT < 30) {
            return Api21Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(arg2);
        }

        if(Build$VERSION.SDK_INT < 0x20) {
            return Api30Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(arg2);
        }

        return arg3;
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public Window getWindow() {
        return this.window;
    }

    private final Object insetValue(Object arg7, Function4 arg8) {
        int v6;
        int v4;
        int v3;
        int v2;
        if(this.decorFitsSystemWindows) {
        }
        else {
            View v1 = this.getChildAt(0);
            v2 = Math.max(0, v1.getLeft());
            v3 = Math.max(0, v1.getTop());
            v4 = Math.max(0, this.getWidth() - v1.getRight());
            v6 = Math.max(0, this.getHeight() - v1.getBottom());
            if(v2 == 0 && v3 == 0 && v4 == 0 && v6 == 0) {
                return arg7;
            }

            goto label_22;
        }

        return arg7;
    label_22:
        return arg8.invoke(Integer.valueOf(v2), Integer.valueOf(v3), Integer.valueOf(v4), Integer.valueOf(v6));
    }

    public void internalOnLayout$ui(boolean arg4, int arg5, int arg6, int arg7, int arg8) {
        View v4 = this.getChildAt(0);
        if(v4 == null) {
            return;
        }

        int v0 = this.getPaddingLeft() + this.getPaddingRight();
        int v1 = this.getPaddingTop() + this.getPaddingBottom();
        arg7 -= arg5;
        arg8 -= arg6;
        arg5 = v4.getMeasuredWidth();
        arg6 = v4.getMeasuredHeight();
        v0 = this.getPaddingLeft() + (arg7 - arg5 - v0) / 2;
        int v3 = this.getPaddingTop() + (arg8 - arg6 - v1) / 2;
        v4.layout(v0, v3, arg5 + v0, arg6 + v3);
    }

    public void internalOnMeasure$ui(int arg12, int arg13) {
        int v7;
        int v0 = 0;
        View v1 = this.getChildAt(0);
        if(v1 == null) {
            super.internalOnMeasure$ui(arg12, arg13);
            return;
        }

        int v2 = View$MeasureSpec.getSize(arg12);
        int v3 = View$MeasureSpec.getSize(arg13);
        int v4 = View$MeasureSpec.getMode(arg13);
        int v5 = -2;
        int v6 = 0x80000000;
        if(v4 != v6 || (this.usePlatformDefaultWidth) || this.getWindow().getAttributes().height != v5) {
            v7 = v3;
        }
        else if(this.decorFitsSystemWindows) {
            v7 = this.getMaxDialogHeightExcludingInsets(this.getWindow(), v3);
        }
        else {
            v7 = v3 + 1;
        }

        int v8 = this.getPaddingLeft() + this.getPaddingRight();
        int v9 = this.getPaddingTop() + this.getPaddingBottom();
        int v10 = v2 - v8;
        if(v10 < 0) {
            v10 = 0;
        }

        v7 -= v9;
        if(v7 < 0) {
        }
        else {
            v0 = v7;
        }

        v7 = View$MeasureSpec.getMode(arg12);
        if(v7 == 0) {
        }
        else {
            arg12 = View$MeasureSpec.makeMeasureSpec(v10, v6);
        }

        if(v4 == 0) {
        }
        else {
            arg13 = View$MeasureSpec.makeMeasureSpec(v0, v6);
        }

        v1.measure(arg12, arg13);
        arg12 = 0x40000000;
        if(v7 == v6) {
            v2 = Math.min(v2, v1.getMeasuredWidth() + v8);
        }
        else if(v7 != arg12) {
            v2 = v1.getMeasuredWidth() + v8;
        }

        if(v4 == v6) {
            arg12 = Math.min(v3, v1.getMeasuredHeight() + v9);
        }
        else if(v4 != arg12) {
            arg12 = v1.getMeasuredHeight() + v9;
        }
        else {
            arg12 = v3;
        }

        this.setMeasuredDimension(v2, arg12);
        if(!this.decorFitsSystemWindows && v1.getMeasuredHeight() + v9 > v3 && this.getWindow().getAttributes().height == v5) {
            this.getWindow().addFlags(v6);
            if(!this.usePlatformDefaultWidth) {
                this.getWindow().setLayout(-1, -1);
            }
        }
    }

    public final boolean isInsideContent(MotionEvent arg6) {
        float v0 = arg6.getX();
        if(!Float.isInfinite(v0) && !Float.isNaN(v0)) {
            v0 = arg6.getY();
            if(!Float.isInfinite(v0) && !Float.isNaN(v0)) {
                View v0_1 = this.getChildAt(0);
                if(v0_1 == null) {
                    return 0;
                }
                else {
                    int v1 = this.getLeft() + v0_1.getLeft();
                    int v3 = v0_1.getWidth() + v1;
                    int v5 = this.getTop() + v0_1.getTop();
                    int v0_2 = v0_1.getHeight() + v5;
                    int v4 = MathKt.roundToInt(arg6.getX());
                    if(v1 <= v4 && v4 <= v3) {
                        int v6 = MathKt.roundToInt(arg6.getY());
                        if(v5 <= v6 && v6 <= v0_2) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public WindowInsetsCompat onApplyWindowInsets(View arg6, WindowInsetsCompat arg7) {
        int v5;
        int v3;
        int v2;
        int v1;
        if(this.decorFitsSystemWindows) {
        }
        else {
            View v0 = this.getChildAt(0);
            v1 = Math.max(0, v0.getLeft());
            v2 = Math.max(0, v0.getTop());
            v3 = Math.max(0, this.getWidth() - v0.getRight());
            v5 = Math.max(0, this.getHeight() - v0.getBottom());
            if(v1 == 0 && v2 == 0 && v3 == 0 && v5 == 0) {
                return arg7;
            }

            goto label_22;
        }

        return arg7;
    label_22:
        return arg7.inset(v1, v2, v3, v5);
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

    public final void updateProperties(boolean arg3, boolean arg4) {
        int v0 = !this.hasCalledSetLayout || arg3 != this.usePlatformDefaultWidth || arg4 != this.decorFitsSystemWindows ? 1 : 0;
        this.usePlatformDefaultWidth = arg3;
        this.decorFitsSystemWindows = arg4;
        if(v0 != 0) {
            WindowManager$LayoutParams v4 = this.getWindow().getAttributes();
            v0 = -2;
            int v3 = arg3 ? v0 : -1;
            if(v3 == v4.width && (this.hasCalledSetLayout)) {
                return;
            }

            this.getWindow().setLayout(v3, v0);
            this.hasCalledSetLayout = true;
        }
    }
}

