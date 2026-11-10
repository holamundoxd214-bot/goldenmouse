package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0016\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u0000\u001A,\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\r\u001A0\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0007\u001A\u00020\b2\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\b\fH\u0002¢\u0006\u0002\u0010\u0011\"\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"createApplier", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "container", "setContent", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/ui/platform/AbstractComposeView;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "doSetContent", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Wrapper_androidKt {
    private static final ViewGroup$LayoutParams DefaultLayoutParams;

    static {
        Wrapper_androidKt.DefaultLayoutParams = new ViewGroup$LayoutParams(-2, -2);
    }

    public static final AbstractApplier createApplier(LayoutNode arg1) {
        return new UiApplier(arg1);
    }

    private static final Composition doSetContent(AndroidComposeView arg3, CompositionContext arg4, Function2 arg5) {
        if((InspectableValueKt.isDebugInspectorInfoEnabled()) && arg3.getTag(id.inspection_slot_table_set) == null) {
            arg3.setTag(id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }

        Object v0 = arg3.getView().getTag(id.wrapped_composition_tag);
        if((v0 instanceof WrappedComposition)) {
        }
        else {
            v0 = null;
        }

        if(v0 == null) {
            WrappedComposition v0_1 = new WrappedComposition(arg3, CompositionKt.Composition(new UiApplier(arg3.getRoot()), arg4));
            arg3.getView().setTag(id.wrapped_composition_tag, v0_1);
        }

        ((WrappedComposition)v0).setContent(arg5);
        if(!Intrinsics.areEqual(arg3.getCoroutineContext(), arg4.getEffectCoroutineContext())) {
            arg3.setCoroutineContext(arg4.getEffectCoroutineContext());
        }

        arg3.setFrameEndScheduler$ui(new Wrapper_androidKt$doSetContent$1(arg4));
        return ((Composition)v0);
    }

    public static final Composition setContent(AbstractComposeView arg3, CompositionContext arg4, Function2 arg5) {
        AndroidComposeView v1_1;
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        View v1 = null;
        if(arg3.getChildCount() > 0) {
            View v0 = arg3.getChildAt(0);
            if((v0 instanceof AndroidComposeView)) {
                v1 = v0;
            }
        }
        else {
            arg3.removeAllViews();
        }

        if(v1 == null) {
            v1_1 = new AndroidComposeView(arg3.getContext(), arg4.getEffectCoroutineContext());
            arg3.addView(v1_1.getView(), Wrapper_androidKt.DefaultLayoutParams);
        }

        return Wrapper_androidKt.doSetContent(v1_1, arg4, arg5);
    }
}

