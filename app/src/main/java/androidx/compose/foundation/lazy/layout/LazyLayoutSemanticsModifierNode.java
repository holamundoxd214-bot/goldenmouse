package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ4\u0010\u001E\u001A\u00020\u001F2\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BJ\f\u0010 \u001A\u00020\u001F*\u00020!H\u0016J\b\u0010\"\u001A\u00020\u001FH\u0002R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001A\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "isVertical", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "scrollToIndexAction", "update", "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCachedSemanticsValues", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyLayoutSemanticsModifierNode extends Node implements SemanticsModifierNode {
    private final Function1 indexForKeyMapping;
    private Function0 itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private Function1 scrollToIndexAction;
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    public LazyLayoutSemanticsModifierNode(Function0 arg1, LazyLayoutSemanticState arg2, Orientation arg3, boolean arg4, boolean arg5) {
        super();
        this.itemProviderLambda = arg1;
        this.state = arg2;
        this.orientation = arg3;
        this.userScrollEnabled = arg4;
        this.reverseScrolling = arg5;
        this.indexForKeyMapping = new LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda0(this);
        this.updateCachedSemanticsValues();
    }

    public static final LazyLayoutSemanticState access$getState$p(LazyLayoutSemanticsModifierNode arg0) {
        return arg0.state;
    }

    public void applySemantics(SemanticsPropertyReceiver arg6) {
        SemanticsPropertiesKt.setTraversalGroup(arg6, true);
        SemanticsPropertiesKt.indexForKey(arg6, this.indexForKeyMapping);
        boolean v1 = this.isVertical();
        ScrollAxisRange v2 = this.scrollAxisRange;
        String v3 = "scrollAxisRange";
        String v4 = null;
        if(v1) {
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((ScrollAxisRange)v4);
            }

            SemanticsPropertiesKt.setVerticalScrollAxisRange(arg6, v2);
        }
        else {
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((ScrollAxisRange)v4);
            }

            SemanticsPropertiesKt.setHorizontalScrollAxisRange(arg6, v2);
        }

        Function1 v1_1 = this.scrollToIndexAction;
        if(v1_1 != null) {
            SemanticsPropertiesKt.scrollToIndex$default(arg6, v4, v1_1, 1, v4);
        }

        SemanticsPropertiesKt.getScrollViewportLength$default(arg6, v4, new LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda4(this), 1, v4);
        SemanticsPropertiesKt.setCollectionInfo(arg6, this.getCollectionInfo());
    }

    static final Float applySemantics$lambda$1(LazyLayoutSemanticsModifierNode arg1) {
        return Float.valueOf(((float)(arg1.state.getViewport() - arg1.state.getContentPadding())));
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    static final int indexForKeyMapping$lambda$0(LazyLayoutSemanticsModifierNode arg3, Object arg4) {
        Object v3 = arg3.itemProviderLambda.invoke();
        int v0 = ((LazyLayoutItemProvider)v3).getItemCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(Intrinsics.areEqual(((LazyLayoutItemProvider)v3).getKey(v1), arg4)) {
                return v1;
            }
        }

        return -1;
    }

    private final boolean isVertical() {
        if(this.orientation == Orientation.Vertical) {
            return 1;
        }

        return 0;
    }

    public final void update(Function0 arg1, LazyLayoutSemanticState arg2, Orientation arg3, boolean arg4, boolean arg5) {
        this.itemProviderLambda = arg1;
        this.state = arg2;
        if(this.orientation != arg3) {
            this.orientation = arg3;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        if(this.userScrollEnabled == arg4) {
            if(this.reverseScrolling != arg5) {
            }
            else {
                return;
            }
        }

        this.userScrollEnabled = arg4;
        this.reverseScrolling = arg5;
        this.updateCachedSemanticsValues();
        SemanticsModifierNodeKt.invalidateSemantics(((SemanticsModifierNode)this));
    }

    private final void updateCachedSemanticsValues() {
        LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda3 v0;
        this.scrollAxisRange = new ScrollAxisRange(new LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1(this), new LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda2(this), this.reverseScrolling);
        if(this.userScrollEnabled) {
            v0 = new LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda3(this);
        }
        else {
            Function1 v0_1 = null;
        }

        this.scrollToIndexAction = ((Function1)v0);
    }

    static final float updateCachedSemanticsValues$lambda$0(LazyLayoutSemanticsModifierNode arg0) {
        return arg0.state.getScrollOffset();
    }

    static final float updateCachedSemanticsValues$lambda$1(LazyLayoutSemanticsModifierNode arg0) {
        return arg0.state.getMaxScrollOffset();
    }

    static final boolean updateCachedSemanticsValues$lambda$2(LazyLayoutSemanticsModifierNode arg8, int arg9) {
        Object v0 = arg8.itemProviderLambda.invoke();
        int v2 = arg9 < 0 || arg9 >= ((LazyLayoutItemProvider)v0).getItemCount() ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Can\'t scroll to index " + arg9 + ", it is out of bounds [0, " + ((LazyLayoutItemProvider)v0).getItemCount() + ')');
        }

        BuildersKt.launch$default(arg8.getCoroutineScope(), null, null, new LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(arg8, arg9, null), 3, null);
        return 1;
    }
}

