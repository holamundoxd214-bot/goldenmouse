package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry$Entry;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000E\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004BI\b\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00028\u0000\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013BK\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0015\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0016J\b\u00100\u001A\u00020$H\u0002J\b\u00101\u001A\u00020$H\u0002R\u0010\u0010\t\u001A\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010!\u001A\u0004\u0018\u00010 2\b\u0010\u001F\u001A\u0004\u0018\u00010 @BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\"\u0010#R<\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u0015@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R<\u0010*\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u0015@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010\'\"\u0004\b,\u0010)R<\u0010-\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0\u0015@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010\'\"\u0004\b/\u0010)¨\u00062"}, d2={"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "typedView", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "saveStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "compositeKeyHash", "", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroid/view/View;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "factory", "Lkotlin/Function1;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "Landroid/view/View;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "viewRoot", "getViewRoot", "()Landroid/view/View;", "saveStateKey", "", "value", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "savableRegistryEntry", "setSavableRegistryEntry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;)V", "", "updateBlock", "getUpdateBlock", "()Lkotlin/jvm/functions/Function1;", "setUpdateBlock", "(Lkotlin/jvm/functions/Function1;)V", "resetBlock", "getResetBlock", "setResetBlock", "releaseBlock", "getReleaseBlock", "setReleaseBlock", "registerSaveStateProvider", "unregisterSaveStateProvider", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ViewFactoryHolder extends AndroidViewHolder implements ViewRootForInspector {
    public static final int $stable = 8;
    private final int compositeKeyHash;
    private final NestedScrollDispatcher dispatcher;
    private Function1 releaseBlock;
    private Function1 resetBlock;
    private Entry savableRegistryEntry;
    private final String saveStateKey;
    private final SaveableStateRegistry saveStateRegistry;
    private final View typedView;
    private Function1 updateBlock;

    static {
    }

    private ViewFactoryHolder(Context arg8, CompositionContext arg9, View arg10, NestedScrollDispatcher arg11, SaveableStateRegistry arg12, int arg13, Owner arg14) {
        ViewFactoryHolder v0 = this;
        View v5 = arg10;
        super(arg8, arg9, arg13, arg11, v5, arg14);
        v0.typedView = v5;
        v0.dispatcher = arg11;
        v0.saveStateRegistry = arg12;
        v0.compositeKeyHash = arg13;
        v0.setClipChildren(false);
        String v7 = String.valueOf(arg13);
        v0.saveStateKey = v7;
        Object v8 = null;
        Object v7_1 = arg12 != null ? arg12.consumeRestored(v7) : v8;
        if((v7_1 instanceof SparseArray)) {
            v8 = v7_1;
        }

        if(v8 != null) {
            v5.restoreHierarchyState(((SparseArray)v8));
        }

        v0.registerSaveStateProvider();
        v0.updateBlock = AndroidView_androidKt.getNoOpUpdate();
        v0.resetBlock = AndroidView_androidKt.getNoOpUpdate();
        v0.releaseBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    ViewFactoryHolder(Context arg9, CompositionContext arg10, View arg11, NestedScrollDispatcher arg12, SaveableStateRegistry arg13, int arg14, Owner arg15, int arg16, DefaultConstructorMarker arg17) {
        if((arg16 & 2) != 0) {
            arg10 = null;
        }

        CompositionContext v2 = arg10;
        if((arg16 & 8) != 0) {
            arg12 = new NestedScrollDispatcher();
        }

        this(arg9, v2, arg11, arg12, arg13, arg14, arg15);
    }

    public ViewFactoryHolder(Context arg11, Function1 arg12, CompositionContext arg13, SaveableStateRegistry arg14, int arg15, Owner arg16) {
        this(arg11, arg13, arg12.invoke(arg11), null, arg14, arg15, arg16, 8, null);
    }

    public ViewFactoryHolder(Context arg8, Function1 arg9, CompositionContext arg10, SaveableStateRegistry arg11, int arg12, Owner arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 4) != 0) {
            arg10 = null;
        }

        this(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static final View access$getTypedView$p(ViewFactoryHolder arg0) {
        return arg0.typedView;
    }

    public static final void access$unregisterSaveStateProvider(ViewFactoryHolder arg0) {
        arg0.unregisterSaveStateProvider();
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Function1 getReleaseBlock() {
        return this.releaseBlock;
    }

    public final Function1 getResetBlock() {
        return this.resetBlock;
    }

    public final Function1 getUpdateBlock() {
        return this.updateBlock;
    }

    public View getViewRoot() {
        return this;
    }

    private final void registerSaveStateProvider() {
        SaveableStateRegistry v0 = this.saveStateRegistry;
        if(v0 != null) {
            this.setSavableRegistryEntry(v0.registerProvider(this.saveStateKey, new ViewFactoryHolder$registerSaveStateProvider$1(this)));
        }
    }

    public final void setReleaseBlock(Function1 arg1) {
        this.releaseBlock = arg1;
        this.setRelease(new ViewFactoryHolder$releaseBlock$1(this));
    }

    public final void setResetBlock(Function1 arg1) {
        this.resetBlock = arg1;
        this.setReset(new ViewFactoryHolder$resetBlock$1(this));
    }

    private final void setSavableRegistryEntry(Entry arg2) {
        Entry v0 = this.savableRegistryEntry;
        if(v0 != null) {
            v0.unregister();
        }

        this.savableRegistryEntry = arg2;
    }

    public final void setUpdateBlock(Function1 arg1) {
        this.updateBlock = arg1;
        this.setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    private final void unregisterSaveStateProvider() {
        this.setSavableRegistryEntry(null);
    }
}

