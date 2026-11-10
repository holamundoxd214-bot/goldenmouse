package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer$State;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.node.Owner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\'\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\fJ\u000E\u0010\u001E\u001A\u00020\u00182\u0006\u0010\u001F\u001A\u00020 J\r\u00100\u001A\u00020\u0018H\'¢\u0006\u0002\u00101J\u0006\u00102\u001A\u00020\u0018J\b\u00104\u001A\u00020\u0018H\u0002J\f\u00107\u001A\u00020\f*\u00020\fH\u0002J\b\u00108\u001A\u00020\fH\u0002J\b\u00109\u001A\u00020\u0018H\u0002J\u0006\u0010:\u001A\u00020\u0018J\b\u0010=\u001A\u00020\u0018H\u0014J\u0018\u0010>\u001A\u00020\u00182\u0006\u0010?\u001A\u00020\u00072\u0006\u0010@\u001A\u00020\u0007H\u0004J\u001D\u0010A\u001A\u00020\u00182\u0006\u0010?\u001A\u00020\u00072\u0006\u0010@\u001A\u00020\u0007H\u0010¢\u0006\u0002\bBJ0\u0010C\u001A\u00020\u00182\u0006\u0010D\u001A\u00020\"2\u0006\u0010E\u001A\u00020\u00072\u0006\u0010F\u001A\u00020\u00072\u0006\u0010G\u001A\u00020\u00072\u0006\u0010H\u001A\u00020\u0007H\u0004J5\u0010I\u001A\u00020\u00182\u0006\u0010D\u001A\u00020\"2\u0006\u0010E\u001A\u00020\u00072\u0006\u0010F\u001A\u00020\u00072\u0006\u0010G\u001A\u00020\u00072\u0006\u0010H\u001A\u00020\u0007H\u0010¢\u0006\u0002\bJJ\u0010\u0010K\u001A\u00020\u00182\u0006\u0010L\u001A\u00020\u0007H\u0016J\b\u0010N\u001A\u00020\"H\u0016J\u0010\u0010O\u001A\u00020\u00182\u0006\u0010N\u001A\u00020\"H\u0016J\u0012\u0010P\u001A\u00020\u00182\b\u0010Q\u001A\u0004\u0018\u00010RH\u0016J\u001A\u0010P\u001A\u00020\u00182\b\u0010Q\u001A\u0004\u0018\u00010R2\u0006\u0010S\u001A\u00020\u0007H\u0016J\"\u0010P\u001A\u00020\u00182\b\u0010Q\u001A\u0004\u0018\u00010R2\u0006\u0010T\u001A\u00020\u00072\u0006\u0010U\u001A\u00020\u0007H\u0016J\u001C\u0010P\u001A\u00020\u00182\b\u0010Q\u001A\u0004\u0018\u00010R2\b\u0010V\u001A\u0004\u0018\u00010WH\u0016J$\u0010P\u001A\u00020\u00182\b\u0010Q\u001A\u0004\u0018\u00010R2\u0006\u0010S\u001A\u00020\u00072\b\u0010V\u001A\u0004\u0018\u00010WH\u0016J$\u0010X\u001A\u00020\"2\b\u0010Q\u001A\u0004\u0018\u00010R2\u0006\u0010S\u001A\u00020\u00072\b\u0010V\u001A\u0004\u0018\u00010WH\u0014J,\u0010X\u001A\u00020\"2\b\u0010Q\u001A\u0004\u0018\u00010R2\u0006\u0010S\u001A\u00020\u00072\b\u0010V\u001A\u0004\u0018\u00010W2\u0006\u0010Y\u001A\u00020\"H\u0014J\b\u0010Z\u001A\u00020\"H\u0016R\u0016\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\u000E@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001A\u0004\u0018\u00010\f2\b\u0010\r\u001A\u0004\u0018\u00010\f@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R\u001C\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001BX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u001C\u0010\u001DR\u0014\u0010!\u001A\u00020\"8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R,\u0010%\u001A\u00020\"2\u0006\u0010\r\u001A\u00020\"8\u0006@FX\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u001D\u001A\u0004\b\'\u0010$\"\u0004\b(\u0010)R$\u0010+\u001A\u00020*2\u0006\u0010\r\u001A\u00020*8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000E\u00103\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u00105\u001A\u00020\"*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b5\u00106R\u0011\u0010;\u001A\u00020\"8F¢\u0006\u0006\u001A\u0004\b<\u0010$R\u000E\u0010M\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006["}, d2={"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "value", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "composition", "Landroidx/compose/runtime/Composition;", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "setParentCompositionContext", "", "parent", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "getDisposeViewCompositionStrategy$annotations", "()V", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "autoClearFocusBehavior", "getAutoClearFocusBehavior-4UtRPd4", "()I", "setAutoClearFocusBehavior-17tfJxM", "(I)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createComposition", "creatingComposition", "checkAddView", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "cacheIfAlive", "resolveParentCompositionContext", "ensureCompositionCreated", "disposeComposition", "hasComposition", "getHasComposition", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure", "internalOnMeasure$ui", "onLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout", "internalOnLayout$ui", "onRtlPropertiesChanged", "layoutDirection", "isTransitionGroupSet", "isTransitionGroup", "setTransitionGroup", "addView", "child", "Landroid/view/View;", "index", "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addViewInLayout", "preventRequestLayout", "shouldDelayChildPressedState", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0 disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    static {
    }

    public AbstractComposeView(Context arg7) {
        this(arg7, null, 0, 6, null);
    }

    public AbstractComposeView(Context arg1, AttributeSet arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, 0);
    }

    public AbstractComposeView(Context arg7, AttributeSet arg8) {
        this(arg7, arg8, 0, 4, null);
    }

    public AbstractComposeView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.setClipChildren(false);
        this.setClipToPadding(false);
        this.setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    public abstract void Content(Composer arg1, int arg2);

    public void addView(View arg1) {
        this.checkAddView();
        super.addView(arg1);
    }

    public void addView(View arg1, int arg2) {
        this.checkAddView();
        super.addView(arg1, arg2);
    }

    public void addView(View arg1, int arg2, int arg3) {
        this.checkAddView();
        super.addView(arg1, arg2, arg3);
    }

    public void addView(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        this.checkAddView();
        super.addView(arg1, arg2, arg3);
    }

    public void addView(View arg1, ViewGroup$LayoutParams arg2) {
        this.checkAddView();
        super.addView(arg1, arg2);
    }

    protected boolean addViewInLayout(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        this.checkAddView();
        return super.addViewInLayout(arg1, arg2, arg3);
    }

    protected boolean addViewInLayout(View arg1, int arg2, ViewGroup$LayoutParams arg3, boolean arg4) {
        this.checkAddView();
        return super.addViewInLayout(arg1, arg2, arg3, arg4);
    }

    private final CompositionContext cacheIfAlive(CompositionContext arg3) {
        CompositionContext v0 = this.isAlive(arg3) ? arg3 : null;
        if(v0 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference(v0);
        }

        return arg3;
    }

    private final void checkAddView() {
        if(this.creatingComposition) {
            return;
        }

        throw new UnsupportedOperationException("Cannot add views to " + this.getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void createComposition() {
        if(this.parentContext == null) {
            if(this.isAttachedToWindow()) {
            }
            else {
                throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
            }
        }

        this.ensureCompositionCreated();
    }

    public final void disposeComposition() {
        Composition v0 = this.composition;
        if(v0 != null) {
            v0.dispose();
        }

        this.composition = null;
        this.requestLayout();
    }

    private final void ensureCompositionCreated() {
        if(this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, this.resolveParentCompositionContext(), ComposableLambdaKt.composableLambdaInstance(0xD8E40040, true, new AbstractComposeView$ensureCompositionCreated$1(this)));
            }
            catch(Throwable v1) {
                this.creatingComposition = false;
                throw v1;
            }

            this.creatingComposition = false;
            return;
        }
    }

    public final int getAutoClearFocusBehavior-4UtRPd4() {
        Object v1 = this.getTag(id.auto_clear_focus_behavior_tag);
        if((v1 instanceof AutoClearFocusBehavior)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((AutoClearFocusBehavior)v1).unbox-impl();
        }

        return AutoClearFocusBehavior.Companion.getDefault-4UtRPd4();
    }

    private static void getDisposeViewCompositionStrategy$annotations() {
    }

    public final boolean getHasComposition() {
        if(this.composition != null) {
            return 1;
        }

        return 0;
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return 1;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public static void getShowLayoutBounds$annotations() {
    }

    public void internalOnLayout$ui(boolean arg3, int arg4, int arg5, int arg6, int arg7) {
        View v3 = this.getChildAt(0);
        if(v3 != null) {
            v3.layout(this.getPaddingLeft(), this.getPaddingTop(), arg6 - arg4 - this.getPaddingRight(), arg7 - arg5 - this.getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui(int arg6, int arg7) {
        View v1 = this.getChildAt(0);
        if(v1 == null) {
            super.onMeasure(arg6, arg7);
            return;
        }

        v1.measure(View$MeasureSpec.makeMeasureSpec(Math.max(0, View$MeasureSpec.getSize(arg6) - this.getPaddingLeft() - this.getPaddingRight()), View$MeasureSpec.getMode(arg6)), View$MeasureSpec.makeMeasureSpec(Math.max(0, View$MeasureSpec.getSize(arg7) - this.getPaddingTop() - this.getPaddingBottom()), View$MeasureSpec.getMode(arg7)));
        this.setMeasuredDimension(v1.getMeasuredWidth() + this.getPaddingLeft() + this.getPaddingRight(), v1.getMeasuredHeight() + this.getPaddingTop() + this.getPaddingBottom());
    }

    private final boolean isAlive(CompositionContext arg1) {
        if((arg1 instanceof Recomposer)) {
            if(((Recomposer)arg1).getCurrentState().getValue().compareTo(State.ShuttingDown) > 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isTransitionGroup() {
        if(this.isTransitionGroupSet) {
            if(super.isTransitionGroup()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setPreviousAttachedWindowToken(this.getWindowToken());
        if(this.getShouldCreateCompositionOnAttachedToWindow()) {
            this.ensureCompositionCreated();
        }
    }

    protected final void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        this.internalOnLayout$ui(arg1, arg2, arg3, arg4, arg5);
    }

    protected final void onMeasure(int arg1, int arg2) {
        this.ensureCompositionCreated();
        this.internalOnMeasure$ui(arg1, arg2);
    }

    public void onRtlPropertiesChanged(int arg2) {
        View v1 = this.getChildAt(0);
        if(v1 != null) {
            v1.setLayoutDirection(arg2);
        }
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext v0 = this.parentContext;
        if(v0 == null) {
            AbstractComposeView v0_1 = this;
            CompositionContext v1 = WindowRecomposer_androidKt.findViewTreeCompositionContext(((View)v0_1));
            Object v2 = null;
            v1 = v1 != null ? this.cacheIfAlive(v1) : ((CompositionContext)v2);
            if(v1 == null) {
                WeakReference v1_1 = this.cachedViewTreeCompositionContext;
                if(v1_1 != null) {
                    Object v1_2 = v1_1.get();
                    if(v1_2 != null && (this.isAlive(((CompositionContext)v1_2)))) {
                        v2 = v1_2;
                    }
                }

                if(v2 == null) {
                    return this.cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(((View)v0_1)));
                }

                return ((CompositionContext)v2);
            }

            return v1;
        }

        return v0;
    }

    public final void setAutoClearFocusBehavior-17tfJxM(int arg2) {
        this.setTag(id.auto_clear_focus_behavior_tag, AutoClearFocusBehavior.box-impl(arg2));
    }

    public final void setParentCompositionContext(CompositionContext arg1) {
        this.setParentContext(arg1);
    }

    private final void setParentContext(CompositionContext arg2) {
        if(this.parentContext != arg2) {
            this.parentContext = arg2;
            WeakReference v0 = null;
            if(arg2 != null) {
                this.cachedViewTreeCompositionContext = v0;
            }

            Composition v2 = this.composition;
            if(v2 == null) {
                return;
            }

            v2.dispose();
            this.composition = ((Composition)v0);
            if(!this.isAttachedToWindow()) {
                return;
            }

            this.ensureCompositionCreated();
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder arg2) {
        if(this.previousAttachedWindowToken != arg2) {
            this.previousAttachedWindowToken = arg2;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    public final void setShowLayoutBounds(boolean arg2) {
        this.showLayoutBounds = arg2;
        View v1 = this.getChildAt(0);
        if(v1 != null) {
            ((Owner)v1).setShowLayoutBounds(arg2);
        }
    }

    public void setTransitionGroup(boolean arg1) {
        super.setTransitionGroup(arg1);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy arg2) {
        Function0 v0 = this.disposeViewCompositionStrategy;
        if(v0 != null) {
            v0.invoke();
        }

        this.disposeViewCompositionStrategy = arg2.installFor(this);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

