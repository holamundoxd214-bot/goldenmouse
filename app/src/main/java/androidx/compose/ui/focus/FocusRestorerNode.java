package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\bR\u001F\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fallback", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFallback", "()Landroidx/compose/ui/focus/FocusRequester;", "setFallback", "onExit", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "onEnter", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusRestorerNode extends Node implements FocusPropertiesModifierNode, FocusRequesterModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private FocusRequester fallback;
    private final Function1 onEnter;
    private final Function1 onExit;

    static {
    }

    public FocusRestorerNode(FocusRequester arg1) {
        super();
        this.fallback = arg1;
        this.onExit = new FocusRestorerNode$onExit$1(this);
        this.onEnter = new FocusRestorerNode$onEnter$1(this);
    }

    public void applyFocusProperties(FocusProperties arg2) {
        arg2.setOnEnter(this.onEnter);
        arg2.setOnExit(this.onExit);
    }

    public final FocusRequester getFallback() {
        return this.fallback;
    }

    public final void setFallback(FocusRequester arg1) {
        this.fallback = arg1;
    }
}

