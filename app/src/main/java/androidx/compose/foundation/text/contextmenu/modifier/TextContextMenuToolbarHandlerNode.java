package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Be\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u001E\u0010\u0006\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u001E\u0010\u000B\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u0014\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u000E\u0010\'\u001A\u00020\t2\u0006\u0010(\u001A\u00020\u0005J\b\u0010)\u001A\u00020\tH\u0016J\b\u0010*\u001A\u00020\tH\u0016J\u0006\u0010+\u001A\u00020\tJ\u0006\u0010,\u001A\u00020\tJ\u0017\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020\rH\u0016¢\u0006\u0004\b0\u00101J\u0010\u00102\u001A\u00020\u000E2\u0006\u0010/\u001A\u00020\rH\u0016J\b\u00103\u001A\u00020!H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R4\u0010\u0006\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0019\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u000B\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0019\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u0018R(\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0016\"\u0004\b\u001D\u0010\u0018R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010 \u001A\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001A\u0004\b\"\u0010#R\u000E\u0010&\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u00064"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "onShow", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRequester", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setRequester", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "getOnShow", "()Lkotlin/jvm/functions/Function1;", "setOnShow", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "getOnHide", "setOnHide", "getComputeContentBounds", "setComputeContentBounds", "textToolbarJob", "Lkotlinx/coroutines/Job;", "derivedData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "getDerivedData", "()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "derivedData$delegate", "Landroidx/compose/runtime/State;", "previousContentBounds", "update", "toolbarRequester", "onAttach", "onDetach", "show", "hide", "position", "Landroidx/compose/ui/geometry/Offset;", "destinationCoordinates", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", "data", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements TextContextMenuDataProvider, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private Function1 computeContentBounds;
    private final State derivedData$delegate;
    private Function1 onHide;
    private Function1 onShow;
    private Rect previousContentBounds;
    private ToolbarRequester requester;
    private Job textToolbarJob;

    static {
    }

    public TextContextMenuToolbarHandlerNode(ToolbarRequester arg1, Function1 arg2, Function1 arg3, Function1 arg4) {
        super();
        this.requester = arg1;
        this.onShow = arg2;
        this.onHide = arg3;
        this.computeContentBounds = arg4;
        this.derivedData$delegate = SnapshotStateKt.derivedStateOf(new TextContextMenuToolbarHandlerNode$$ExternalSyntheticLambda0(this));
        this.previousContentBounds = Rect.Companion.getZero();
    }

    public Rect contentBounds(LayoutCoordinates arg2) {
        if(!this.isAttached()) {
            return this.previousContentBounds;
        }

        Object v2 = this.computeContentBounds.invoke(arg2);
        if(v2 == null) {
            return this.previousContentBounds;
        }

        this.previousContentBounds = ((Rect)v2);
        return ((Rect)v2);
    }

    public TextContextMenuData data() {
        return this.getDerivedData();
    }

    static final TextContextMenuData derivedData_delegate$lambda$0(TextContextMenuToolbarHandlerNode arg1) {
        if(arg1.isAttached()) {
            return TextContextMenuModifierKt.collectTextContextMenuData(((DelegatableNode)arg1));
        }

        return TextContextMenuData.Companion.getEmpty();
    }

    public final Function1 getComputeContentBounds() {
        return this.computeContentBounds;
    }

    private final TextContextMenuData getDerivedData() {
        return this.derivedData$delegate.getValue();
    }

    public final Function1 getOnHide() {
        return this.onHide;
    }

    public final Function1 getOnShow() {
        return this.onShow;
    }

    public final ToolbarRequester getRequester() {
        return this.requester;
    }

    public final void hide() {
        Job v0 = this.textToolbarJob;
        if(v0 == null) {
            return;
        }

        DefaultImpls.cancel$default(v0, null, 1, null);
        this.textToolbarJob = null;
    }

    public void onAttach() {
        super.onAttach();
        this.requester.setToolbarHandlerState$foundation(ToolbarHandlerState.Attached);
        this.requester.setToolbarHandlerNode$foundation(this);
    }

    public void onDetach() {
        this.requester.setToolbarHandlerState$foundation(ToolbarHandlerState.Detached);
        this.requester.setToolbarHandlerNode$foundation(null);
        super.onDetach();
    }

    public long position-tuRUvjQ(LayoutCoordinates arg1) {
        return this.contentBounds(arg1).getTopLeft-F1C5BW0();
    }

    public final void setComputeContentBounds(Function1 arg1) {
        this.computeContentBounds = arg1;
    }

    public final void setOnHide(Function1 arg1) {
        this.onHide = arg1;
    }

    public final void setOnShow(Function1 arg1) {
        this.onShow = arg1;
    }

    public final void setRequester(ToolbarRequester arg1) {
        this.requester = arg1;
    }

    public final void show() {
        if(this.isAttached()) {
            Job v0 = this.textToolbarJob;
            if(v0 != null && (v0.isActive())) {
                return;
            }

            Object v0_1 = CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider());
            if(v0_1 == null) {
                return;
            }

            this.textToolbarJob = BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextContextMenuToolbarHandlerNode$show$1(this, ((TextContextMenuProvider)v0_1), null), 1, null);
        }
    }

    public final void update(ToolbarRequester arg3) {
        this.requester.setToolbarHandlerNode$foundation(null);
        this.requester = arg3;
        arg3.setToolbarHandlerNode$foundation(this);
        arg3 = this.requester;
        ToolbarHandlerState v2 = this.isAttached() ? ToolbarHandlerState.Attached : ToolbarHandlerState.Detached;
        arg3.setToolbarHandlerState$foundation(v2);
    }
}

