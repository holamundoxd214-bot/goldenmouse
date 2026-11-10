package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0010H\u0016J\u001A\u0010\u0012\u001A\u00020\u00102\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001F\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/layout/SystemInsetsPaddingModifierNode;", "Landroidx/compose/foundation/layout/InsetsPaddingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insetsGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "windowInsetsHolder", "getWindowInsetsHolder", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "setWindowInsetsHolder", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "onAttach", "", "onDetach", "update", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SystemInsetsPaddingModifierNode extends InsetsPaddingModifierNode implements LayoutModifierNode {
    private Function1 insetsGetter;
    private WindowInsetsHolder windowInsetsHolder;

    public SystemInsetsPaddingModifierNode(Function1 arg2) {
        super(WindowInsetsKt.WindowInsets());
        this.insetsGetter = arg2;
    }

    public final WindowInsetsHolder getWindowInsetsHolder() {
        return this.windowInsetsHolder;
    }

    public void onAttach() {
        View v0 = DelegatableNode_androidKt.requireView(this);
        WindowInsetsHolder v1 = WindowInsetsHolder.Companion.getOrCreateFor(v0);
        v1.incrementAccessors(v0);
        this.update(this.insetsGetter.invoke(v1));
        this.windowInsetsHolder = v1;
        super.onAttach();
    }

    public void onDetach() {
        View v0 = DelegatableNode_androidKt.requireView(this);
        WindowInsetsHolder v1 = this.windowInsetsHolder;
        if(v1 != null) {
            v1.decrementAccessors(v0);
        }

        super.onDetach();
    }

    public final void setWindowInsetsHolder(WindowInsetsHolder arg1) {
        this.windowInsetsHolder = arg1;
    }

    public final void update(Function1 arg2) {
        if(this.insetsGetter != arg2) {
            this.insetsGetter = arg2;
            WindowInsetsHolder v0 = this.windowInsetsHolder;
            if(v0 != null) {
                this.update(arg2.invoke(v0));
            }
        }
    }
}

