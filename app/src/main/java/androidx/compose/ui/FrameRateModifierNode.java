package androidx.compose.ui;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0016H\u0016J\f\u0010\u0018\u001A\u00020\u0016*\u00020\u0019H\u0016J\u0018\u0010\u001A\u001A\u00020\u00162\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u0004\u001A\u00020\u0005R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u001D"}, d2={"Landroidx/compose/ui/FrameRateModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "frameRate", "", "<init>", "(F)V", "getFrameRate", "()F", "setFrameRate", "shouldUpdateFrameRates", "", "getShouldUpdateFrameRates", "()Z", "setShouldUpdateFrameRates", "(Z)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setChildrenLayerFrameRate", "nodeCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FrameRateModifierNode extends Node implements DrawModifierNode, TraversableNode {
    public static final int $stable = 8;
    private float frameRate;
    private boolean shouldUpdateFrameRates;
    private final String traverseKey;

    static {
    }

    public FrameRateModifierNode(float arg1) {
        super();
        this.frameRate = arg1;
        this.shouldUpdateFrameRates = true;
        this.traverseKey = "TRAVERSAL_NODE_KEY_FRAME_RATE_MODIFIER_NODE";
    }

    public void draw(ContentDrawScope arg3) {
        if(this.shouldUpdateFrameRates) {
            NodeCoordinator v0 = this.getCoordinator$ui();
            if(v0 != null) {
                OwnedLayer v0_1 = v0.getLayer();
                if(v0_1 != null) {
                    v0_1.setFrameRate(this.frameRate);
                }
            }

            v0 = this.getCoordinator$ui();
            v0 = v0 != null ? v0.getWrapped$ui() : null;
            this.setChildrenLayerFrameRate(v0, this.frameRate);
            this.shouldUpdateFrameRates = false;
        }

        arg3.drawContent();
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final boolean getShouldUpdateFrameRates() {
        return this.shouldUpdateFrameRates;
    }

    public Object getTraverseKey() {
        return this.getTraverseKey();
    }

    public String getTraverseKey() {
        return this.traverseKey;
    }

    public void onAttach() {
        this.shouldUpdateFrameRates = true;
    }

    public void onDetach() {
        TraversableNode v0 = TraversableNodeKt.findNearestAncestor(this);
        NodeCoordinator v1 = null;
        if(v0 != null) {
            NodeCoordinator v2 = this.getCoordinator$ui();
            if(v2 != null) {
                v1 = v2.getWrapped$ui();
            }

            this.setChildrenLayerFrameRate(v1, ((FrameRateModifierNode)v0).frameRate);
            return;
        }

        NodeCoordinator v0_1 = this.getCoordinator$ui();
        if(v0_1 != null) {
            v1 = v0_1.getWrapped$ui();
        }

        this.setChildrenLayerFrameRate(v1, 0f);
    }

    public final void setChildrenLayerFrameRate(NodeCoordinator arg6, float arg7) {
        int v1;
        NodeCoordinator v0;
        for(v0 = arg6; true; v0 = v0.getWrapped$ui()) {
            v1 = 0;
            if(v0 == null) {
                break;
            }

            if(arg6 != null) {
                OwnedLayer v2 = arg6.getLayer();
                if(v2 != null) {
                    if(v2.getFrameRate() == 0f) {
                    }
                    else {
                        if(v2.isFrameRateFromParent()) {
                            goto label_12;
                        }

                        return;
                    }

                label_12:
                    v2.setFrameRate(arg7);
                    if(Float.compare(arg7, 0f) == 0) {
                        v1 = 1;
                    }

                    v2.setFrameRateFromParent(v1 ^ 1);
                }
            }
        }

        if(arg6 == null) {
            arg6 = this.getCoordinator$ui();
        }

        if(arg6 != null) {
            LayoutNode v6 = arg6.getLayoutNode();
            if(v6 == null) {
                return;
            }

            List v6_1 = v6.getChildren$ui();
            if(v6_1 == null) {
                return;
            }

            int v0_1 = v6_1.size();
            while(v1 < v0_1) {
                this.setChildrenLayerFrameRate(v6_1.get(v1).getOuterCoordinator$ui(), arg7);
                ++v1;
            }
        }
    }

    public final void setFrameRate(float arg1) {
        this.frameRate = arg1;
    }

    public final void setShouldUpdateFrameRates(boolean arg1) {
        this.shouldUpdateFrameRates = arg1;
    }
}

