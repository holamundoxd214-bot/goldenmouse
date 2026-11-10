package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003KLMB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\f2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\t\u001A\u00020\n2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020!2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020!2\u0006\u0010%\u001A\u00020\f2\u0006\u0010&\u001A\u00020\f2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*J\u0010\u0010+\u001A\u00020\u00192\u0006\u0010,\u001A\u00020\u0003H\u0002J\u0006\u0010-\u001A\u00020\u0019J\b\u0010.\u001A\u00020\u0019H\u0002J1\u0010/\u001A\u00020\u00192\u0006\u00100\u001A\u00028\u00002\u0006\u00101\u001A\u00020\f2\u0012\b\u0002\u00102\u001A\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u00103J\u001F\u00104\u001A\u00020\u00192\u0006\u00100\u001A\u00028\u00002\b\b\u0002\u00105\u001A\u00020!H\u0002¢\u0006\u0002\u00106J\u0018\u00107\u001A\u0004\u0018\u00010\u00152\u0006\u0010,\u001A\u00020\u00032\u0006\u00108\u001A\u00020\fJ\u0019\u00109\u001A\u00020\f*\u00020:2\u0006\u00100\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010;R$\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000E\u0012\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010<\u001A\u00020=8F¢\u0006\u0006\u001A\u0004\b>\u0010?R\u0011\u0010@\u001A\u00020A¢\u0006\b\n\u0000\u001A\u0004\bB\u0010CR\u0018\u0010D\u001A\u00020!*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bE\u0010FR\u0018\u00101\u001A\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bG\u0010HR\u0018\u0010I\u001A\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bJ\u0010H¨\u0006N"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "<init>", "()V", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "firstVisibleIndex", "", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingInFromStartBound", "", "movingInFromEndBound", "movingAwayToStartBound", "movingAwayToEndBound", "disappearingItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "key", "reset", "releaseAnimations", "initializeAnimation", "item", "mainAxisOffset", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "getAnimation", "placeableIndex", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "hasAnimations", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "crossAxisOffset", "getCrossAxisOffset", "ItemInfo", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemAnimator {
    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\f\u0010\u000B\u001A\u00020\t*\u00020\fH\u0016J\r\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000E\u001A\u00020\u00002\f\b\u0002\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DisplayingDisappearingItemsElement extends ModifierNodeElement {
        private final LazyLayoutItemAnimator animator;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator arg1) {
            super();
            this.animator = arg1;
        }

        private final LazyLayoutItemAnimator component1() {
            return this.animator;
        }

        public final DisplayingDisappearingItemsElement copy(LazyLayoutItemAnimator arg1) {
            return new DisplayingDisappearingItemsElement(arg1);
        }

        public static DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement arg0, LazyLayoutItemAnimator arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.animator;
            }

            return arg0.copy(arg1);
        }

        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        public Node create() {
            return this.create();
        }

        public boolean equals(Object arg4) {
            if(this == (((DisplayingDisappearingItemsElement)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof DisplayingDisappearingItemsElement)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement)arg4).animator)) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public void inspectableProperties(InspectorInfo arg1) {
            arg1.setName("DisplayingDisappearingItemsElement");
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public void update(DisplayingDisappearingItemsNode arg1) {
            arg1.setAnimator(this.animator);
        }

        public void update(Node arg1) {
            this.update(((DisplayingDisappearingItemsNode)arg1));
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0007\u001A\u00020\b*\u00020\tH\u0016J\b\u0010\n\u001A\u00020\bH\u0016J\b\u0010\u000B\u001A\u00020\bH\u0016J\u0012\u0010\f\u001A\u00020\b2\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004J\r\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000E\u001A\u00020\u00002\f\b\u0002\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onAttach", "onDetach", "setAnimator", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DisplayingDisappearingItemsNode extends Node implements DrawModifierNode {
        private LazyLayoutItemAnimator animator;

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator arg1) {
            super();
            this.animator = arg1;
        }

        private final LazyLayoutItemAnimator component1() {
            return this.animator;
        }

        public final DisplayingDisappearingItemsNode copy(LazyLayoutItemAnimator arg1) {
            return new DisplayingDisappearingItemsNode(arg1);
        }

        public static DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode arg0, LazyLayoutItemAnimator arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.animator;
            }

            return arg0.copy(arg1);
        }

        public void draw(ContentDrawScope arg9) {
            List v8 = this.animator.disappearingItems;
            int v0 = v8.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = v8.get(v1);
                GraphicsLayer v3 = ((LazyLayoutItemAnimation)v2).getLayer();
                if(v3 == null) {
                }
                else {
                    float v4 = ((float)IntOffset.getX-impl(((LazyLayoutItemAnimation)v2).getFinalOffset-nOcc-ac()));
                    float v2_1 = ((float)IntOffset.getY-impl(((LazyLayoutItemAnimation)v2).getFinalOffset-nOcc-ac()));
                    ContentDrawScope v5 = arg9;
                    v4 -= ((float)IntOffset.getX-impl(v3.getTopLeft-nOcc-ac()));
                    v2_1 -= ((float)IntOffset.getY-impl(v3.getTopLeft-nOcc-ac()));
                    ((DrawScope)v5).getDrawContext().getTransform().translate(v4, v2_1);
                    try {
                        GraphicsLayerKt.drawLayer(((DrawScope)v5), v3);
                    }
                    catch(Throwable v8_1) {
                        ((DrawScope)v5).getDrawContext().getTransform().translate(-v4, -v2_1);
                        throw v8_1;
                    }

                    ((DrawScope)v5).getDrawContext().getTransform().translate(-v4, -v2_1);
                }
            }

            arg9.drawContent();
        }

        public boolean equals(Object arg4) {
            if(this == (((DisplayingDisappearingItemsNode)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof DisplayingDisappearingItemsNode)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode)arg4).animator)) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public void onAttach() {
            this.animator.displayingNode = ((DrawModifierNode)this);
        }

        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyLayoutItemAnimator arg2) {
            if(!Intrinsics.areEqual(this.animator, arg2) && (this.getNode().isAttached())) {
                this.animator.reset();
                arg2.displayingNode = this;
                this.animator = arg2;
            }
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }
    }

    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010 \u001A\u00020\u00122\u0006\u0010\"\u001A\u00020\u00122\b\b\u0002\u0010\u0011\u001A\u00020\u0012¢\u0006\u0002\u0010+R0\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001A\u0010\u001A\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0014\"\u0004\b\u001C\u0010\u0016R\u0014\u0010\u001D\u001A\u00020\u001E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001FR\u001E\u0010 \u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u0012@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0014R\u001E\u0010\"\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u0012@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0014¨\u0006,"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "value", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "lane", "getLane", "setLane", "span", "getSpan", "setSpan", "isRunningPlacement", "", "()Z", "layoutMinOffset", "getLayoutMinOffset", "layoutMaxOffset", "getLayoutMaxOffset", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ItemInfo {
        private LazyLayoutItemAnimation[] animations;
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private int span;

        public static Unit $r8$lambda$07nuV023FHUGc-O5negint6mmOA(LazyLayoutItemAnimator arg0) {
            return ItemInfo.updateAnimation$lambda$0$0(arg0);
        }

        public ItemInfo(LazyLayoutItemAnimator arg1) {
            LazyLayoutItemAnimator.this = arg1;
            super();
            this.animations = LazyLayoutItemAnimatorKt.access$getEmptyArray$p();
            this.span = 1;
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        public final Constraints getConstraints-DWUhwKw() {
            return this.constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final int getLane() {
            return this.lane;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getSpan() {
            return this.span;
        }

        private final boolean isRunningPlacement() {
            LazyLayoutItemAnimation[] v5 = this.animations;
            int v0 = v5.length;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                LazyLayoutItemAnimation v3 = v5[v2];
                if(v3 != null && (v3.isRunningMovingAwayAnimation())) {
                    return 1;
                }
            }

            return 0;
        }

        public final void setConstraints-_Sx5XlM(Constraints arg1) {
            this.constraints = arg1;
        }

        public final void setCrossAxisOffset(int arg1) {
            this.crossAxisOffset = arg1;
        }

        public final void setLane(int arg1) {
            this.lane = arg1;
        }

        public final void setSpan(int arg1) {
            this.span = arg1;
        }

        public final void updateAnimation(LazyLayoutMeasuredItem arg4, CoroutineScope arg5, GraphicsContext arg6, int arg7, int arg8, int arg9) {
            LazyLayoutItemAnimation v0_1;
            if(!this.isRunningPlacement()) {
                this.layoutMinOffset = arg7;
                this.layoutMaxOffset = arg8;
            }

            arg7 = arg4.getPlaceablesCount();
            arg8 = this.animations.length;
            while(true) {
                LazyLayoutItemAnimation[] v0 = this.animations;
                if(arg7 >= arg8) {
                    break;
                }

                v0_1 = v0[arg7];
                if(v0_1 != null) {
                    v0_1.release();
                }

                ++arg7;
            }

            if(v0.length != arg4.getPlaceablesCount()) {
                Object[] v7 = Arrays.copyOf(this.animations, arg4.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(v7, "copyOf(...)");
                this.animations = ((LazyLayoutItemAnimation[])v7);
            }

            this.constraints = Constraints.box-impl(arg4.getConstraints-msEJaDk());
            this.crossAxisOffset = arg9;
            this.lane = arg4.getLane();
            this.span = arg4.getSpan();
            arg7 = arg4.getPlaceablesCount();
            LazyLayoutItemAnimator v8 = LazyLayoutItemAnimator.this;
            for(arg9 = 0; arg9 < arg7; ++arg9) {
                LazyLayoutAnimationSpecsNode v0_2 = LazyLayoutItemAnimatorKt.access$getSpecs(arg4.getParentData(arg9));
                LazyLayoutItemAnimation[] v1 = this.animations;
                if(v0_2 == null) {
                    v0_1 = v1[arg9];
                    if(v0_1 != null) {
                        v0_1.release();
                    }

                    this.animations[arg9] = null;
                }
                else {
                    LazyLayoutItemAnimation v1_1 = v1[arg9];
                    if(v1_1 == null) {
                        v1_1 = new LazyLayoutItemAnimation(arg5, arg6, new LazyLayoutItemAnimator$ItemInfo$$ExternalSyntheticLambda0(v8));
                        this.animations[arg9] = v1_1;
                    }

                    v1_1.setFadeInSpec(v0_2.getFadeInSpec());
                    v1_1.setPlacementSpec(v0_2.getPlacementSpec());
                    v1_1.setFadeOutSpec(v0_2.getFadeOutSpec());
                }
            }
        }

        public static void updateAnimation$default(ItemInfo arg7, LazyLayoutMeasuredItem arg8, CoroutineScope arg9, GraphicsContext arg10, int arg11, int arg12, int arg13, int arg14, Object arg15) {
            if((arg14 & 0x20) != 0) {
                arg13 = arg7.this$0.getCrossAxisOffset(arg8);
            }

            arg7.updateAnimation(arg8, arg9, arg10, arg11, arg12, arg13);
        }

        private static final Unit updateAnimation$lambda$0$0(LazyLayoutItemAnimator arg0) {
            DrawModifierNode v0 = arg0.displayingNode;
            if(v0 != null) {
                DrawModifierNodeKt.invalidateDraw(v0);
            }

            return Unit.INSTANCE;
        }
    }

    public static final int $stable = 8;
    private final List disappearingItems;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap keyToItemInfoMap;
    private final Modifier modifier;
    private final MutableScatterSet movingAwayKeys;
    private final List movingAwayToEndBound;
    private final List movingAwayToStartBound;
    private final List movingInFromEndBound;
    private final List movingInFromStartBound;

    static {
    }

    public LazyLayoutItemAnimator() {
        super();
        this.keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
        this.movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
        this.disappearingItems = new ArrayList();
        this.modifier = new DisplayingDisappearingItemsElement(this);
    }

    public static final int access$getCrossAxisOffset(LazyLayoutItemAnimator arg0, LazyLayoutMeasuredItem arg1) {
        return arg0.getCrossAxisOffset(arg1);
    }

    public static final List access$getDisappearingItems$p(LazyLayoutItemAnimator arg0) {
        return arg0.disappearingItems;
    }

    public static final DrawModifierNode access$getDisplayingNode$p(LazyLayoutItemAnimator arg0) {
        return arg0.displayingNode;
    }

    public static final void access$setDisplayingNode$p(LazyLayoutItemAnimator arg0, DrawModifierNode arg1) {
        arg0.displayingNode = arg1;
    }

    public final LazyLayoutItemAnimation getAnimation(Object arg1, int arg2) {
        Object v0 = this.keyToItemInfoMap.get(arg1);
        if(v0 != null) {
            LazyLayoutItemAnimation[] v0_1 = ((ItemInfo)v0).getAnimations();
            if(v0_1 != null) {
                return v0_1[arg2];
            }
        }

        return null;
    }

    private final int getCrossAxisOffset(LazyLayoutMeasuredItem arg3) {
        long v0 = arg3.getOffset-Bjo55l4(0);
        if(!arg3.isVertical()) {
            return IntOffset.getY-impl(v0);
        }

        return IntOffset.getX-impl(v0);
    }

    private final boolean getHasAnimations(LazyLayoutMeasuredItem arg4) {
        int v3 = arg4.getPlaceablesCount();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(LazyLayoutItemAnimatorKt.access$getSpecs(arg4.getParentData(v1)) != null) {
                return 1;
            }
        }

        return 0;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem arg3) {
        long v0 = arg3.getOffset-Bjo55l4(0);
        if(arg3.isVertical()) {
            return IntOffset.getY-impl(v0);
        }

        return IntOffset.getX-impl(v0);
    }

    public final long getMinSizeToFitDisappearingItems-YbymL2g() {
        long v0 = IntSize.Companion.getZero-YbymL2g();
        List v12 = this.disappearingItems;
        int v2 = v12.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = v12.get(v3);
            GraphicsLayer v5 = ((LazyLayoutItemAnimation)v4).getLayer();
            if(v5 != null) {
                v0 = IntSize.constructor-impl((((long)Math.max(((int)(v0 & 0xFFFFFFFFL)), IntOffset.getY-impl(((LazyLayoutItemAnimation)v4).getRawOffset-nOcc-ac()) + (((int)(v5.getSize-YbymL2g() & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Math.max(((int)(v0 >> 0x20)), IntOffset.getX-impl(((LazyLayoutItemAnimation)v4).getRawOffset-nOcc-ac()) + (((int)(v5.getSize-YbymL2g() >> 0x20)))))) << 0x20);
            }
        }

        return v0;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private final void initializeAnimation(LazyLayoutMeasuredItem arg10, int arg11, ItemInfo arg12) {
        int v9 = 0;
        long v0 = arg10.getOffset-Bjo55l4(0);
        long v2 = arg10.isVertical() ? IntOffset.copy-iSbpLlY$default(v0, 0, arg11, 1, null) : IntOffset.copy-iSbpLlY$default(v0, arg11, 0, 2, null);
        LazyLayoutItemAnimation[] v11 = arg12.getAnimations();
        int v12 = v11.length;
        int v4;
        for(v4 = 0; v9 < v12; v4 = v6) {
            LazyLayoutItemAnimation v5 = v11[v9];
            int v6 = v4 + 1;
            if(v5 != null) {
                v5.setRawOffset--gyyYBs(IntOffset.plus-qkQi6aY(v2, IntOffset.minus-qkQi6aY(arg10.getOffset-Bjo55l4(v4), v0)));
            }

            ++v9;
        }
    }

    static void initializeAnimation$default(LazyLayoutItemAnimator arg0, LazyLayoutMeasuredItem arg1, int arg2, ItemInfo arg3, int arg4, Object arg5) {
        Object v3;
        if((arg4 & 4) != 0) {
            v3 = arg0.keyToItemInfoMap.get(arg1.getKey());
            Intrinsics.checkNotNull(v3);
        }

        arg0.initializeAnimation(arg1, arg2, ((ItemInfo)v3));
    }

    public final void onMeasured(int arg42, int arg43, int arg44, List arg45, LazyLayoutKeyIndexMap arg46, LazyLayoutMeasuredItemProvider arg47, boolean arg48, boolean arg49, int arg50, boolean arg51, int arg52, int arg53, CoroutineScope arg54, GraphicsContext arg55) {
        int v11_1;
        Object v5_1;
        DrawModifierNode v1_9;
        int v27;
        LazyLayoutItemAnimation[] v48;
        int v24_3;
        int v32;
        Object[] v31;
        long[] v30;
        int v7_2;
        Object v1_6;
        List v7_1;
        List v1_5;
        int v26_1;
        LazyLayoutItemAnimation v13_1;
        LazyLayoutItemAnimation[] v1_4;
        boolean v1_3;
        int v35;
        int v34;
        Object v14_2;
        long v29;
        int v28;
        List v25;
        int v12;
        Object[] v24;
        int v23;
        LazyLayoutItemAnimator v0 = this;
        int v1 = arg42;
        List v8 = arg45;
        LazyLayoutKeyIndexMap v9 = arg46;
        int v10 = arg50;
        LazyLayoutKeyIndexMap v11 = v0.keyIndexMap;
        v0.keyIndexMap = v9;
        List v2 = v8;
        int v3 = ((Collection)v2).size();
        int v4 = 0;
        while(true) {
            if(v4 >= v3) {
                break;
            }
            else if(v0.getHasAnimations(v8.get(v4))) {
            }
            else {
                ++v4;
                continue;
            }

            goto label_22;
        }

        if(v0.keyToItemInfoMap.isEmpty()) {
            v0.releaseAnimations();
            return;
        }

    label_22:
        v3 = v0.firstVisibleIndex;
        Object v4_1 = CollectionsKt.firstOrNull(v8);
        v4 = v4_1 != null ? ((LazyLayoutMeasuredItem)v4_1).getIndex() : 0;
        v0.firstVisibleIndex = v4;
        long v4_2 = arg48 ? IntOffset.constructor-impl((((long)v1)) & 0xFFFFFFFFL) : IntOffset.constructor-impl((((long)v1)) << 0x20);
        int v14 = (arg49) || !arg51 ? 1 : 0;
        MutableScatterMap v1_1 = v0.keyToItemInfoMap;
        Object[] v15 = ((ScatterMap)v1_1).keys;
        long[] v1_2 = ((ScatterMap)v1_1).metadata;
        int v13 = v1_2.length - 2;
        long v16 = 0x80;
        long v18 = 0xFF;
        int v20 = 7;
        long v21 = -9187201950435737472L;
        if(v13 >= 0) {
            v23 = v14;
            v24 = v15;
            v12 = 0;
            goto label_59;
        }
        else {
            v25 = v2;
            v23 = v14;
            goto label_98;
            while(true) {
            label_59:
                int v51 = 8;
                long v14_1 = v1_2[v12];
                long[] v26 = v1_2;
                v25 = v2;
                if((~v14_1 << v20 & v14_1 & v21) != v21) {
                    v1 = 8 - (~(v12 - v13) >>> 0x1F);
                    int v2_1;
                    for(v2_1 = 0; v2_1 < v1; v2_1 = v28 + 1) {
                        if((v14_1 & v18) < v16) {
                            v28 = v2_1;
                            v29 = v14_1;
                            v0.movingAwayKeys.add(v24[(v12 << 3) + v2_1]);
                        }
                        else {
                            v28 = v2_1;
                            v29 = v14_1;
                        }

                        v14_1 = v29 >> v51;
                    }

                    if(v1 != v51) {
                        break;
                    }
                }

                if(v12 == v13) {
                    break;
                }

                ++v12;
                v2 = v25;
                v1_2 = v26;
            }
        }

    label_98:
        v1 = ((Collection)v25).size();
        v2_1 = 0;
        while(true) {
            v12 = -1;
            if(v2_1 >= v1) {
                break;
            }

            v14_2 = v8.get(v2_1);
            v0.movingAwayKeys.remove(((LazyLayoutMeasuredItem)v14_2).getKey());
            if(v0.getHasAnimations(((LazyLayoutMeasuredItem)v14_2))) {
                Object v24_1 = v0.keyToItemInfoMap.get(((LazyLayoutMeasuredItem)v14_2).getKey());
                v13 = v11 != null ? v11.getIndex(((LazyLayoutMeasuredItem)v14_2).getKey()) : v12;
                int v15_1 = v13 != v12 || v11 == null ? 0 : 1;
                if(v24_1 == null) {
                    ItemInfo v12_1 = new ItemInfo(v0);
                    ItemInfo.updateAnimation$default(v12_1, v14_2, arg54, arg55, arg52, arg53, 0, 0x20, null);
                    v34 = v1;
                    v35 = v2_1;
                    v0.keyToItemInfoMap.set(((LazyLayoutMeasuredItem)v14_2).getKey(), v12_1);
                    if(((LazyLayoutMeasuredItem)v14_2).getIndex() != v13 && v13 != -1) {
                        v1_3 = v13 < v3 ? v0.movingInFromStartBound.add(v14_2) : v0.movingInFromEndBound.add(v14_2);
                        Boolean.valueOf(v1_3);
                        goto label_234;
                    }

                    long v24_2 = ((LazyLayoutMeasuredItem)v14_2).getOffset-Bjo55l4(0);
                    v1 = ((LazyLayoutMeasuredItem)v14_2).isVertical() ? IntOffset.getY-impl(v24_2) : IntOffset.getX-impl(v24_2);
                    v0.initializeAnimation(((LazyLayoutMeasuredItem)v14_2), v1, v12_1);
                    if(v15_1 == 0) {
                        goto label_234;
                    }

                    v1_4 = v12_1.getAnimations();
                    v2_1 = v1_4.length;
                    for(v12 = 0; true; ++v12) {
                        if(v12 >= v2_1) {
                            goto label_234;
                        }

                        v13_1 = v1_4[v12];
                        if(v13_1 != null) {
                            v13_1.animateAppearance();
                        }
                    }
                }

                v34 = v1;
                v35 = v2_1;
                if(v23 == 0) {
                    goto label_234;
                }

                ItemInfo.updateAnimation$default(((ItemInfo)v24_1), v14_2, arg54, arg55, arg52, arg53, 0, 0x20, null);
                v1_4 = ((ItemInfo)v24_1).getAnimations();
                v2_1 = v1_4.length;
                v12 = 0;
                while(v12 < v2_1) {
                    v13_1 = v1_4[v12];
                    LazyLayoutItemAnimation[] v25_1 = v1_4;
                    v26_1 = v2_1;
                    if(v13_1 != null && !IntOffset.equals-impl0(v13_1.getRawOffset-nOcc-ac(), LazyLayoutItemAnimation.Companion.getNotInitialized-nOcc-ac())) {
                        v13_1.setRawOffset--gyyYBs(IntOffset.plus-qkQi6aY(v13_1.getRawOffset-nOcc-ac(), v4_2));
                    }

                    ++v12;
                    v1_4 = v25_1;
                    v2_1 = v26_1;
                }

                if(v15_1 != 0) {
                    v1_4 = ((ItemInfo)v24_1).getAnimations();
                    v2_1 = v1_4.length;
                    int v6;
                    for(v6 = 0; v6 < v2_1; ++v6) {
                        LazyLayoutItemAnimation v7 = v1_4[v6];
                        if(v7 != null) {
                            if(v7.isDisappearanceAnimationInProgress()) {
                                v0.disappearingItems.remove(v7);
                                DrawModifierNode v12_2 = v0.displayingNode;
                                if(v12_2 != null) {
                                    DrawModifierNodeKt.invalidateDraw(v12_2);
                                }
                            }

                            v7.animateAppearance();
                        }
                    }
                }

                LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(v0, ((LazyLayoutMeasuredItem)v14_2), false, 2, null);
            }
            else {
                v34 = v1;
                v35 = v2_1;
                v0.removeInfoForKey(((LazyLayoutMeasuredItem)v14_2).getKey());
            }

        label_234:
            v2_1 = v35 + 1;
            v1 = v34;
        }

        int[] v6_1 = new int[v10];
        if(v23 != 0 && v11 != null) {
            if(!v0.movingInFromStartBound.isEmpty()) {
                v1_5 = v0.movingInFromStartBound;
                if(v1_5.size() > 1) {
                    CollectionsKt.sortWith(v1_5, new LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(v11));
                }

                v7_1 = v0.movingInFromStartBound;
                v12 = v7_1.size();
                for(v13 = 0; v13 < v12; ++v13) {
                    v1_6 = v7_1.get(v13);
                    LazyLayoutItemAnimator.initializeAnimation$default(v0, ((LazyLayoutMeasuredItem)v1_6), arg52 - v0.updateAndReturnOffsetFor(v6_1, ((LazyLayoutMeasuredItem)v1_6)), null, 4, null);
                    LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(v0, ((LazyLayoutMeasuredItem)v1_6), false, 2, null);
                }

                ArraysKt.fill$default(v6_1, 0, 0, 0, 6, null);
            }

            if(v0.movingInFromEndBound.isEmpty()) {
                goto label_312;
            }

            v1_5 = v0.movingInFromEndBound;
            if(v1_5.size() > 1) {
                CollectionsKt.sortWith(v1_5, new LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(v11));
            }

            v7_1 = v0.movingInFromEndBound;
            v12 = v7_1.size();
            for(v13 = 0; v13 < v12; ++v13) {
                v1_6 = v7_1.get(v13);
                LazyLayoutItemAnimator.initializeAnimation$default(v0, ((LazyLayoutMeasuredItem)v1_6), arg53 + v0.updateAndReturnOffsetFor(v6_1, ((LazyLayoutMeasuredItem)v1_6)) - ((LazyLayoutMeasuredItem)v1_6).getMainAxisSizeWithSpacings(), null, 4, null);
                LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(v0, ((LazyLayoutMeasuredItem)v1_6), false, 2, null);
            }

            ArraysKt.fill$default(v6_1, 0, 0, 0, 6, null);
        }

    label_312:
        MutableScatterSet v1_7 = v0.movingAwayKeys;
        Object[] v2_2 = ((ScatterSet)v1_7).elements;
        v1_2 = ((ScatterSet)v1_7).metadata;
        v3 = v1_2.length - 2;
        if(v3 >= 0) {
            v4 = 0;
            while(true) {
                long v12_3 = v1_2[v4];
                if((~v12_3 << v20 & v12_3 & v21) != v21) {
                    int v5 = 8 - (~(v4 - v3) >>> 0x1F);
                    v7_2 = 0;
                    while(v7_2 < v5) {
                        if((v12_3 & v18) < v16) {
                            v14_2 = v2_2[(v4 << 3) + v7_2];
                            Object v15_2 = v0.keyToItemInfoMap.get(v14_2);
                            if(v15_2 == null) {
                                goto label_471;
                            }
                            else {
                                v30 = v1_2;
                                v1 = v9.getIndex(v14_2);
                                v31 = v2_2;
                                ((ItemInfo)v15_2).setSpan(Math.min(v10, ((ItemInfo)v15_2).getSpan()));
                                v32 = v7_2;
                                ((ItemInfo)v15_2).setLane(Math.min(v10 - ((ItemInfo)v15_2).getSpan(), ((ItemInfo)v15_2).getLane()));
                                if(v1 == -1) {
                                    v1_4 = ((ItemInfo)v15_2).getAnimations();
                                    v7_2 = v1_4.length;
                                    v2_1 = 0;
                                    v24_3 = 0;
                                    int v25_2;
                                    for(v25_2 = 0; v2_1 < v7_2; v25_2 = v26_1) {
                                        v48 = v1_4;
                                        LazyLayoutItemAnimation v1_8 = v48[v2_1];
                                        v26_1 = v25_2 + 1;
                                        if(v1_8 == null) {
                                            v27 = v2_1;
                                        }
                                        else if(v1_8.isDisappearanceAnimationInProgress()) {
                                            v27 = v2_1;
                                            v24_3 = 1;
                                        }
                                        else if(v1_8.isDisappearanceAnimationFinished()) {
                                            v1_8.release();
                                            ((ItemInfo)v15_2).getAnimations()[v25_2] = null;
                                            v27 = v2_1;
                                            v0.disappearingItems.remove(v1_8);
                                            v1_9 = v0.displayingNode;
                                            if(v1_9 != null) {
                                                DrawModifierNodeKt.invalidateDraw(v1_9);
                                            }
                                        }
                                        else {
                                            v27 = v2_1;
                                            if(v1_8.getLayer() != null) {
                                                v1_8.animateDisappearance();
                                            }

                                            if(v1_8.isDisappearanceAnimationInProgress()) {
                                                v0.disappearingItems.add(v1_8);
                                                v1_9 = v0.displayingNode;
                                                if(v1_9 != null) {
                                                    DrawModifierNodeKt.invalidateDraw(v1_9);
                                                }

                                                v24_3 = 1;
                                                goto label_409;
                                            }

                                            v1_8.release();
                                            ((ItemInfo)v15_2).getAnimations()[v25_2] = null;
                                        }

                                    label_409:
                                        v2_1 = v27 + 1;
                                        v1_4 = v48;
                                    }

                                    if(v24_3 != 0) {
                                        goto label_475;
                                    }

                                    v0.removeInfoForKey(v14_2);
                                }
                                else {
                                    Constraints v2_3 = ((ItemInfo)v15_2).getConstraints-DWUhwKw();
                                    Intrinsics.checkNotNull(v2_3);
                                    v25_2 = v1;
                                    LazyLayoutMeasuredItem v1_10 = arg47.getAndMeasure--hBUhpc(v25_2, ((ItemInfo)v15_2).getLane(), ((ItemInfo)v15_2).getSpan(), v2_3.unbox-impl());
                                    v2_1 = v25_2;
                                    v1_10.setNonScrollableItem(true);
                                    LazyLayoutItemAnimation[] v7_3 = ((ItemInfo)v15_2).getAnimations();
                                    LazyLayoutMeasuredItem v35_1 = v1_10;
                                    v1 = v7_3.length;
                                    v48 = v7_3;
                                    v7_2 = 0;
                                    while(v7_2 < v1) {
                                        LazyLayoutItemAnimation v24_4 = v48[v7_2];
                                        v25_2 = v1;
                                        if(v24_4 != null) {
                                            v1_3 = v24_4.isPlacementAnimationInProgress();
                                            v24_3 = v7_2;
                                            if(v1_3) {
                                                goto label_454;
                                            }
                                        }
                                        else {
                                            v24_3 = v7_2;
                                        }

                                        v7_2 = v24_3 + 1;
                                        v1 = v25_2;
                                    }

                                    if(v11 != null && v2_1 == v11.getIndex(v14_2)) {
                                        v0.removeInfoForKey(v14_2);
                                        goto label_475;
                                    }

                                label_454:
                                    v15_2.updateAnimation(v35_1, arg54, arg55, arg52, arg53, ((ItemInfo)v15_2).getCrossAxisOffset());
                                    v1_10 = v35_1;
                                    v1_3 = v2_1 < v0.firstVisibleIndex ? v0.movingAwayToStartBound.add(v1_10) : v0.movingAwayToEndBound.add(v1_10);
                                    Boolean.valueOf(v1_3);
                                }
                            }
                        }
                        else {
                        label_471:
                            v30 = v1_2;
                            v31 = v2_2;
                            v32 = v7_2;
                        }

                    label_475:
                        v12_3 >>= 8;
                        v7_2 = v32 + 1;
                        v1_2 = v30;
                        v2_2 = v31;
                    }

                    v30 = v1_2;
                    v31 = v2_2;
                    if(v5 != 8) {
                        break;
                    }
                }
                else {
                    v30 = v1_2;
                    v31 = v2_2;
                }

                if(v4 == v3) {
                    break;
                }

                ++v4;
                v1_2 = v30;
                v2_2 = v31;
            }
        }

        if(!v0.movingAwayToStartBound.isEmpty()) {
            v1_5 = v0.movingAwayToStartBound;
            if(v1_5.size() > 1) {
                CollectionsKt.sortWith(v1_5, new LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(v9));
            }

            v1_5 = v0.movingAwayToStartBound;
            v2_1 = v1_5.size();
            for(v3 = 0; v3 < v2_1; ++v3) {
                v4_1 = v1_5.get(v3);
                v5_1 = v0.keyToItemInfoMap.get(((LazyLayoutMeasuredItem)v4_1).getKey());
                Intrinsics.checkNotNull(v5_1);
                v7_2 = v0.updateAndReturnOffsetFor(v6_1, ((LazyLayoutMeasuredItem)v4_1));
                v10 = arg49 ? v0.getMainAxisOffset(CollectionsKt.first(v8)) : ((ItemInfo)v5_1).getLayoutMinOffset();
                ((LazyLayoutMeasuredItem)v4_1).position(v10 - v7_2, ((ItemInfo)v5_1).getCrossAxisOffset(), arg43, arg44);
                if(v23 != 0) {
                    v0.startPlacementAnimationsIfNeeded(((LazyLayoutMeasuredItem)v4_1), true);
                }
            }

            v7_2 = arg43;
            v11_1 = arg44;
            ArraysKt.fill$default(v6_1, 0, 0, 0, 6, null);
        }
        else {
            v7_2 = arg43;
            v11_1 = arg44;
        }

        if(!v0.movingAwayToEndBound.isEmpty()) {
            v1_5 = v0.movingAwayToEndBound;
            if(v1_5.size() > 1) {
                CollectionsKt.sortWith(v1_5, new LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(v9));
            }

            v1_5 = v0.movingAwayToEndBound;
            v2_1 = v1_5.size();
            for(v3 = 0; v3 < v2_1; ++v3) {
                v4_1 = v1_5.get(v3);
                v5_1 = v0.keyToItemInfoMap.get(((LazyLayoutMeasuredItem)v4_1).getKey());
                Intrinsics.checkNotNull(v5_1);
                ((LazyLayoutMeasuredItem)v4_1).position(((ItemInfo)v5_1).getLayoutMaxOffset() - ((LazyLayoutMeasuredItem)v4_1).getMainAxisSizeWithSpacings() + v0.updateAndReturnOffsetFor(v6_1, ((LazyLayoutMeasuredItem)v4_1)), ((ItemInfo)v5_1).getCrossAxisOffset(), v7_2, v11_1);
                if(v23 != 0) {
                    v0.startPlacementAnimationsIfNeeded(((LazyLayoutMeasuredItem)v4_1), true);
                }
            }
        }

        v1_5 = v0.movingAwayToStartBound;
        CollectionsKt.reverse(v1_5);
        v8.addAll(0, ((Collection)v1_5));
        v8.addAll(v0.movingAwayToEndBound);
        v0.movingInFromStartBound.clear();
        v0.movingInFromEndBound.clear();
        v0.movingAwayToStartBound.clear();
        v0.movingAwayToEndBound.clear();
        v0.movingAwayKeys.clear();
    }

    private final void releaseAnimations() {
        if(this.keyToItemInfoMap.isNotEmpty()) {
            MutableScatterMap v0 = this.keyToItemInfoMap;
            Object[] v1 = ((ScatterMap)v0).values;
            long[] v0_1 = ((ScatterMap)v0).metadata;
            int v2 = v0_1.length - 2;
            if(v2 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v0_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80) {
                                LazyLayoutItemAnimation[] v10 = v1[(v4 << 3) + v9].getAnimations();
                                int v11 = v10.length;
                                int v12;
                                for(v12 = 0; v12 < v11; ++v12) {
                                    LazyLayoutItemAnimation v13 = v10[v12];
                                    if(v13 != null) {
                                        v13.release();
                                    }
                                }
                            }

                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            break;
                        }
                    }

                    if(v4 == v2) {
                        break;
                    }
                }
            }

            this.keyToItemInfoMap.clear();
        }
    }

    private final void removeInfoForKey(Object arg3) {
        Object v2 = this.keyToItemInfoMap.remove(arg3);
        if(v2 != null) {
            LazyLayoutItemAnimation[] v2_1 = ((ItemInfo)v2).getAnimations();
            if(v2_1 != null) {
                int v3 = v2_1.length;
                int v0;
                for(v0 = 0; v0 < v3; ++v0) {
                    LazyLayoutItemAnimation v1 = v2_1[v0];
                    if(v1 != null) {
                        v1.release();
                    }
                }
            }
        }
    }

    public final void reset() {
        this.releaseAnimations();
        this.keyIndexMap = null;
        this.firstVisibleIndex = -1;
    }

    private final void startPlacementAnimationsIfNeeded(LazyLayoutMeasuredItem arg12, boolean arg13) {
        Object v11 = this.keyToItemInfoMap.get(arg12.getKey());
        Intrinsics.checkNotNull(v11);
        LazyLayoutItemAnimation[] v11_1 = ((ItemInfo)v11).getAnimations();
        int v0 = v11_1.length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v4) {
            LazyLayoutItemAnimation v3 = v11_1[v1];
            int v4 = v2 + 1;
            if(v3 != null) {
                long v5 = arg12.getOffset-Bjo55l4(v2);
                long v7 = v3.getRawOffset-nOcc-ac();
                if(!IntOffset.equals-impl0(v7, LazyLayoutItemAnimation.Companion.getNotInitialized-nOcc-ac()) && !IntOffset.equals-impl0(v7, v5)) {
                    v3.animatePlacementDelta-ar5cAso(IntOffset.minus-qkQi6aY(v5, v7), arg13);
                }

                v3.setRawOffset--gyyYBs(v5);
            }

            ++v1;
        }
    }

    static void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator arg0, LazyLayoutMeasuredItem arg1, boolean arg2, int arg3, Object arg4) {
        arg0.startPlacementAnimationsIfNeeded(arg1, false);
    }

    private final int updateAndReturnOffsetFor(int[] arg5, LazyLayoutMeasuredItem arg6) {
        int v4 = arg6.getLane();
        int v0 = arg6.getSpan() + v4;
        int v1 = 0;
        while(v4 < v0) {
            int v2 = arg5[v4] + arg6.getMainAxisSizeWithSpacings();
            arg5[v4] = v2;
            v1 = Math.max(v1, v2);
            ++v4;
        }

        return v1;
    }
}

