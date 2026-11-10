package androidx.compose.ui.graphics;

import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0013\u001A\u00020\u0007J#\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\b\u0010\u001D\u001A\u00020\u001EH\u0016J\f\u0010\u001F\u001A\u00020\u0007*\u00020 H\u0016R+\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\nR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000FX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011¨\u0006!"}, d2={"Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "setLayerBlock", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "invalidateLayerBlock", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "toString", "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BlockGraphicsLayerModifier extends Node implements LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private final boolean isImportantForBounds;
    private Function1 layerBlock;

    static {
    }

    public BlockGraphicsLayerModifier(Function1 arg1) {
        super();
        this.layerBlock = arg1;
    }

    public void applySemantics(SemanticsPropertyReceiver arg6) {
        boolean v0_2;
        Shape v5_1;
        ReusableGraphicsLayerScope v1;
        if(!ComposeUiFlags.isGraphicsLayerShapeSemanticsEnabled) {
        }
        else {
            NodeCoordinator v0 = DelegatableNodeKt.requireCoordinator-64DMado(this, NodeKind.constructor-impl(2));
            if(!v0.getWasLayerBlockInvoked$ui()) {
                if(GraphicsLayerModifierKt.access$getReusableGraphicsLayerScope$p() == null) {
                    GraphicsLayerModifierKt.access$setReusableGraphicsLayerScope$p(new ReusableGraphicsLayerScope());
                }
                else {
                    v1 = GraphicsLayerModifierKt.access$getReusableGraphicsLayerScope$p();
                    Intrinsics.checkNotNull(v1);
                    v1.reset();
                }

                v1 = GraphicsLayerModifierKt.access$getReusableGraphicsLayerScope$p();
                Intrinsics.checkNotNull(v1);
                v1.setGraphicsDensity$ui(v0.getLayoutNode().getDensity());
                v1.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(v0.getSize-YbymL2g()));
                Companion v0_1 = Snapshot.Companion;
                Snapshot v2 = v0_1.getCurrentThreadSnapshot();
                Function1 v3 = v2 != null ? v2.getReadObserver() : null;
                Snapshot v4 = v0_1.makeCurrentNonObservable(v2);
                try {
                    this.layerBlock.invoke(v1);
                }
                catch(Throwable v5) {
                    v0_1.restoreNonObservable(v2, v4, v3);
                    throw v5;
                }

                v0_1.restoreNonObservable(v2, v4, v3);
                v5_1 = v1.getShape();
                v0_2 = v1.getClip();
            }
            else {
                v5_1 = v0.getLastShape$ui();
                v0_2 = v0.getLastClip$ui();
            }

            if(v0_2) {
                goto label_47;
            }
        }

        return;
    label_47:
        SemanticsPropertiesKt.setShape(arg6, v5_1);
    }

    public final Function1 getLayerBlock() {
        return this.layerBlock;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final void invalidateLayerBlock() {
        LayoutModifierNodeKt.updateLayerBlock(this, this.layerBlock);
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new BlockGraphicsLayerModifier$measure$1(v9, this), 4, null);
    }

    public final void setLayerBlock(Function1 arg1) {
        this.layerBlock = arg1;
    }

    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.layerBlock + ')';
    }
}

