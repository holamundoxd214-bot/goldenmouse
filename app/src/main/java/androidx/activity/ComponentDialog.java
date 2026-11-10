package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.ViewTreeNavigationEventDispatcherOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001B\b\u0007\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0003\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010!\u001A\u00020\"H\u0016J\u0012\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010\"H\u0015J\b\u0010&\u001A\u00020$H\u0015J\b\u0010\'\u001A\u00020$H\u0015J\b\u00103\u001A\u00020$H\u0017J\u0010\u00104\u001A\u00020$2\u0006\u00105\u001A\u00020\tH\u0016J\u0010\u00104\u001A\u00020$2\u0006\u00106\u001A\u000207H\u0016J\u001A\u00104\u001A\u00020$2\u0006\u00106\u001A\u0002072\b\u00108\u001A\u0004\u0018\u000109H\u0016J\u001A\u0010:\u001A\u00020$2\u0006\u00106\u001A\u0002072\b\u00108\u001A\u0004\u0018\u000109H\u0016J\b\u0010;\u001A\u00020$H\u0017R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u001B\u0010\u001B\u001A\u00020\u001C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b\u001D\u0010\u001ER!\u0010(\u001A\u00020)8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b.\u0010 \u0012\u0004\b*\u0010+\u001A\u0004\b,\u0010-R\u0014\u0010/\u001A\u0002008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u00102¨\u0006<"}, d2={"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onBackPressedInput", "Landroidx/navigationevent/DirectNavigationEventInput;", "getOnBackPressedInput", "()Landroidx/navigationevent/DirectNavigationEventInput;", "onBackPressedInput$delegate", "Lkotlin/Lazy;", "onSaveInstanceState", "Landroid/os/Bundle;", "onCreate", "", "savedInstanceState", "onStart", "onStop", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "()V", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher$delegate", "navigationEventDispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getNavigationEventDispatcher", "()Landroidx/navigationevent/NavigationEventDispatcher;", "onBackPressed", "setContentView", "layoutResID", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "addContentView", "initializeViewTreeOwners", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class ComponentDialog extends Dialog implements OnBackPressedDispatcherOwner, LifecycleOwner, NavigationEventDispatcherOwner, SavedStateRegistryOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final Lazy onBackPressedDispatcher$delegate;
    private final Lazy onBackPressedInput$delegate;
    private final SavedStateRegistryController savedStateRegistryController;

    public static void $r8$lambda$XxpmZzi8FNPM2sJJA30VCt2mBcQ(ComponentDialog arg0) {
        ComponentDialog.onBackPressedDispatcher_delegate$lambda$0$0(arg0);
    }

    public ComponentDialog(Context arg4) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        this(arg4, 0, 2, null);
    }

    public ComponentDialog(Context arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, 0);
    }

    public ComponentDialog(Context arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.onBackPressedInput$delegate = LazyKt.lazy(new ComponentDialog$$ExternalSyntheticLambda1(this));
        this.onBackPressedDispatcher$delegate = LazyKt.lazy(new ComponentDialog$$ExternalSyntheticLambda2(this));
    }

    public void addContentView(View arg2, ViewGroup$LayoutParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.initializeViewTreeOwners();
        super.addContentView(arg2, arg3);
    }

    public Lifecycle getLifecycle() {
        return this.getLifecycleRegistry();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry v0 = this._lifecycleRegistry;
        if(v0 == null) {
            v0 = new LifecycleRegistry(this);
            this._lifecycleRegistry = v0;
        }

        return v0;
    }

    public NavigationEventDispatcher getNavigationEventDispatcher() {
        return this.getOnBackPressedDispatcher().getEventDispatcher$activity();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher$delegate.getValue();
    }

    public static void getOnBackPressedDispatcher$annotations() {
    }

    private final DirectNavigationEventInput getOnBackPressedInput() {
        return this.onBackPressedInput$delegate.getValue();
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    public void initializeViewTreeOwners() {
        Window v0 = this.getWindow();
        Intrinsics.checkNotNull(v0);
        View v0_1 = v0.getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getDecorView(...)");
        ViewTreeLifecycleOwner.set(v0_1, this);
        v0 = this.getWindow();
        Intrinsics.checkNotNull(v0);
        v0_1 = v0.getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getDecorView(...)");
        ViewTreeOnBackPressedDispatcherOwner.set(v0_1, this);
        v0 = this.getWindow();
        Intrinsics.checkNotNull(v0);
        v0_1 = v0.getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getDecorView(...)");
        ViewTreeSavedStateRegistryOwner.set(v0_1, this);
        v0 = this.getWindow();
        Intrinsics.checkNotNull(v0);
        v0_1 = v0.getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getDecorView(...)");
        ViewTreeNavigationEventDispatcherOwner.set(v0_1, ((NavigationEventDispatcherOwner)this));
    }

    @Deprecated(message="This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.") public void onBackPressed() {
        this.getOnBackPressedInput().backCompleted();
    }

    static final OnBackPressedDispatcher onBackPressedDispatcher_delegate$lambda$0(ComponentDialog arg2) {
        return new OnBackPressedDispatcher(new ComponentDialog$$ExternalSyntheticLambda0(arg2));
    }

    private static final void onBackPressedDispatcher_delegate$lambda$0$0(ComponentDialog arg0) {
        super.onBackPressed();
    }

    static final DirectNavigationEventInput onBackPressedInput_delegate$lambda$0(ComponentDialog arg2) {
        DirectNavigationEventInput v0 = new DirectNavigationEventInput();
        arg2.getNavigationEventDispatcher().addInput(v0);
        return v0;
    }

    protected void onCreate(Bundle arg4) {
        super.onCreate(arg4);
        if(Build$VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher v0 = this.getOnBackPressedDispatcher();
            OnBackInvokedDispatcher v1 = this.getOnBackInvokedDispatcher();
            Intrinsics.checkNotNullExpressionValue(v1, "getOnBackInvokedDispatcher(...)");
            v0.setOnBackInvokedDispatcher(v1);
        }

        this.savedStateRegistryController.performRestore(arg4);
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_CREATE);
    }

    public Bundle onSaveInstanceState() {
        Bundle v0 = super.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(v0, "onSaveInstanceState(...)");
        this.savedStateRegistryController.performSave(v0);
        return v0;
    }

    protected void onStart() {
        super.onStart();
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_RESUME);
    }

    protected void onStop() {
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int arg1) {
        this.initializeViewTreeOwners();
        super.setContentView(arg1);
    }

    public void setContentView(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.initializeViewTreeOwners();
        super.setContentView(arg2);
    }

    public void setContentView(View arg2, ViewGroup$LayoutParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.initializeViewTreeOwners();
        super.setContentView(arg2, arg3);
    }
}

