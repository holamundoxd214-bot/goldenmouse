package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001A\u00020\u0010J5\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001A\u00020\u0010J\u000E\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u0012J\u0006\u0010(\u001A\u00020\u0010J\u0016\u0010)\u001A\u0004\u0018\u00010\u00012\f\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FJ:\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020!2\u0006\u0010.\u001A\u00020\u00172\u0006\u0010/\u001A\u00020\u00172\u0006\u00100\u001A\u0002012\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J:\u00104\u001A\u00020,2\u0006\u0010-\u001A\u00020!2\u0006\u0010.\u001A\u00020\u00172\u0006\u0010/\u001A\u00020\u00172\u0006\u00100\u001A\u0002012\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J\u0010\u00105\u001A\u00020\u00102\b\u00106\u001A\u0004\u0018\u00010\u0001J\u000E\u00107\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004J\u001E\u00109\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u00042\u0006\u0010:\u001A\u00020\u00122\u0006\u0010;\u001A\u00020\u0012J\u000E\u0010<\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004J\u0018\u0010=\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u00042\b\b\u0002\u0010>\u001A\u00020\u0012J\u0015\u0010?\u001A\u00020\u001C2\u0006\u00108\u001A\u00020\u0004¢\u0006\u0004\b@\u0010AJ\f\u0010B\u001A\u00020\u0010*\u00020\u0004H\u0002J\u0010\u0010C\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004H\u0002J\u0010\u0010F\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004H\u0002J\u0014\u0010G\u001A\u00020\u0010*\u00020H2\u0006\u0010I\u001A\u00020EH\u0002J\f\u0010J\u001A\u00020\u0012*\u00020HH\u0002J\u0013\u0010K\u001A\u00020\u001C*\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010AJ\u000E\u0010M\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004J\u001D\u0010N\u001A\u00020\u00122\u0006\u0010O\u001A\u00020!2\u0006\u0010P\u001A\u00020!H\u0000¢\u0006\u0002\bQJ7\u0010R\u001A\u0004\u0018\u00010S2\u0006\u0010T\u001A\u00020!2\u0006\u0010U\u001A\u00020!2\u0006\u0010V\u001A\u00020!2\u0006\u0010W\u001A\u00020!2\u0006\u0010X\u001A\u00020!H\u0000¢\u0006\u0002\bYJ1\u0010Z\u001A\u00020\u0012*\u0002012\u0006\u0010T\u001A\u00020!2\u0006\u0010U\u001A\u00020!2\u0006\u0010V\u001A\u00020!2\u0006\u0010W\u001A\u00020!H\u0000¢\u0006\u0002\b[J\u0019\u0010\\\u001A\u00020\u0012*\u00020\u00042\u0006\u0010]\u001A\u00020\u0004H\u0000¢\u0006\u0002\b^J\u000E\u0010_\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u0004R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2={"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "removeScheduledCallback", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "forceUpdate", "getOffsetFromRectListFor", "getOffsetFromRectListFor-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "resetHasPositionalLayerTransformationsForSubtreeIfNeeded", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "hasPositionalLayerTransformations", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui", "findFocusableNodeFromRect", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "left", "top", "right", "bottom", "containerId", "findFocusableNodeFromRect$ui", "intersects", "intersects$ui", "isDescendantOf", "container", "isDescendantOf$ui", "unsetHasCallbacksFor", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList callbacks;
    private final Function0 dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    static {
    }

    public RectManager(IntObjectMap arg4) {
        super();
        this.layoutNodes = arg4;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList(0, 1, null);
        this.scheduledDispatchDeadline = -1;
        this.dispatchLambda = new RectManager$dispatchLambda$1(this);
        this.cachedRect = new MutableRect(0f, 0f, 0f, 0f);
    }

    public RectManager() {
        this(null, 1, null);
    }

    public RectManager(IntObjectMap arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = IntObjectMapKt.intObjectMapOf();
        }

        this(arg1);
    }

    public static final void access$setDispatchToken$p(RectManager arg0, Object arg1) {
        arg0.dispatchToken = arg1;
    }

    private final void boundingRectInRoot(NodeCoordinator arg8, MutableRect arg9) {
        long v0_1;
        while(arg8 != null) {
            LayoutNode v0 = arg8.getLayoutNode();
            long v2 = 0xFFFFFFFFL;
            int v4 = 0x20;
            if(arg8 == v0.getOuterCoordinator$ui() && !v0.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                v0_1 = this.getOffsetFromRectListFor-Bjo55l4(v0);
                if(!IntOffset.equals-impl0(v0_1, IntOffset.Companion.getMax-nOcc-ac())) {
                    arg9.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v0_1))))) & v2 | (((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v0_1))))) << v4));
                    return;
                }
            }

            OwnedLayer v0_2 = arg8.getLayer();
            if(v0_2 != null) {
                float[] v0_3 = v0_2.getUnderlyingMatrix-sQKQjiQ();
                if(!MatrixKt.isIdentity-58bKbWc(v0_3)) {
                    Matrix.map-impl(v0_3, arg9);
                }
            }

            v0_1 = arg8.getPosition-nOcc-ac();
            arg9.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v0_1))))) & v2 | (((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v0_1))))) << v4));
            arg8 = arg8.getWrappedBy$ui();
        }
    }

    public final void dispatchCallbacks() {
        this.removeScheduledCallback();
        long v6 = Actual_androidKt.currentTimeMillis();
        boolean v0 = this.isDirty;
        int v10 = (v0) || (this.isScreenOrWindowDirty) ? 1 : 0;
        if(v0) {
            this.isDirty = false;
            MutableObjectList v0_1 = this.callbacks;
            Object[] v1 = ((ObjectList)v0_1).content;
            int v0_2 = ((ObjectList)v0_1)._size;
            int v2;
            for(v2 = 0; v2 < v0_2; ++v2) {
                v1[v2].invoke();
            }

            RectList v0_3 = this.rects;
            long[] v11 = v0_3.items;
            int v12 = v0_3.itemsSize;
            int v13;
            for(v13 = 0; v13 < v11.length - 2; v13 += 3) {
                if(v13 >= v12) {
                    break;
                }

                long v0_4 = v11[v13 + 2];
                if(((((int)(v0_4 >> 60))) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(0x1FFFFFF & (((int)v0_4)), v11[v13], v11[v13 + 1], v6);
                }
            }

            this.rects.clearUpdated();
        }

        if(this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(v6);
        }

        if(v10 != 0) {
            this.throttledCallbacks.fireGlobalChangeEntries(v6);
        }

        if(this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }

        this.throttledCallbacks.triggerDebounced(v6);
        if(this.throttledCallbacks.getMinDebounceDeadline() > 0) {
            this.scheduleDebounceCallback(true);
        }
    }

    public final FocusTargetModifierNode findFocusableNodeFromRect$ui(int arg27, int arg28, int arg29, int arg30, int arg31) {
        Node v16_1;
        MutableVector v1_4;
        int v23;
        Object v24;
        int v22;
        Node v2_2;
        int v9;
        RectManager v0 = this;
        Object v6 = v0.layoutNodes.get(arg31);
        FocusTargetModifierNode v7 = null;
        if(v6 == null) {
            return v7;
        }

        FocusTargetNode v1 = LayoutNodeKt.requireOwner(((LayoutNode)v6)).getFocusOwner().getActiveFocusTargetNode();
        if(v1 != null) {
            SemanticsInfo v1_1 = DelegatableNodeKt.requireSemanticsInfo(((DelegatableNode)v1));
            if(v1_1 != null) {
                v9 = v1_1.getSemanticsId();
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            v9 = -1;
        }

        RectList v1_2 = v0.rects;
        int v10 = arg28;
        long v11 = (((long)v10)) & 0xFFFFFFFFL | (((long)arg27)) << 0x20;
        FocusTargetModifierNode v31 = v7;
        long v7_1 = (((long)arg30)) & 0xFFFFFFFFL | (((long)arg29)) << 0x20;
        long[] v13 = v1_2.items;
        int v14 = v1_2.itemsSize;
        int v1_3 = 0x7FFFFFFF;
        FocusTargetModifierNode v16 = v31;
        int v3 = 0;
        while(v3 < v13.length - 2) {
            if(v3 >= v14) {
                break;
            }

            int v19 = v3;
            long v2 = v13[v3 + 2];
            int v5 = 1;
            if(((((int)(v2 >> 61))) & 1) == 0 || ((v7_1 - v13[v19] - 0x100000001L | v13[v19 + 1] - v11 - 0x100000001L) & -9223372034707292160L) != 0) {
                v22 = v1_3;
                v24 = v6;
            label_212:
                v1_3 = v22;
            }
            else {
                int v2_1 = (((int)v2)) & 0x1FFFFFF;
                Object v15 = v0.layoutNodes.get(v2_1);
                if(v15 != null) {
                    if(v9 == v2_1 && v9 != -1) {
                        return v31;
                    }

                    if(((LayoutNode)v15).getDepth$ui() < v1_3 && (v0.isDescendantOf$ui(((LayoutNode)v15), ((LayoutNode)v6)))) {
                        NodeChain v3_1 = ((LayoutNode)v15).getNodes$ui();
                        int v4 = NodeKind.constructor-impl(0x400);
                        if((v3_1.getAggregateChildKindSet() & v4) != 0) {
                            Node v3_2 = v3_1.getHead$ui();
                            while(true) {
                                if(v3_2 != null) {
                                    if((v3_2.getKindSet$ui() & v4) != 0) {
                                        MutableVector v20 = ((MutableVector)v31);
                                        v2_2 = v3_2;
                                        while(v2_2 != null) {
                                            if((v2_2 instanceof FocusTargetNode)) {
                                                v22 = v1_3;
                                                v24 = v6;
                                                goto label_185;
                                            }
                                            else {
                                                if((v2_2.getKindSet$ui() & v4) == 0 || !(v2_2 instanceof DelegatingNode)) {
                                                    v22 = v1_3;
                                                    v24 = v6;
                                                    v1_3 = 1;
                                                label_161:
                                                    v2_2 = DelegatableNodeKt.pop(v20);
                                                }
                                                else {
                                                    Node v5_1 = v2_2.getDelegate$ui();
                                                    int v0_1 = 0;
                                                    while(v5_1 != null) {
                                                        if((v5_1.getKindSet$ui() & v4) != 0) {
                                                            ++v0_1;
                                                            v22 = v1_3;
                                                            if(v0_1 == 1) {
                                                                v2_2 = v5_1;
                                                                goto label_145;
                                                            }
                                                            else {
                                                                if(v20 == null) {
                                                                    v23 = v0_1;
                                                                    v24 = v6;
                                                                    v1_4 = new MutableVector(new Node[16], 0);
                                                                }
                                                                else {
                                                                    v23 = v0_1;
                                                                    v24 = v6;
                                                                    v1_4 = v20;
                                                                }

                                                                if(v2_2 != null) {
                                                                    if(v1_4 != null) {
                                                                        v1_4.add(v2_2);
                                                                    }

                                                                    v2_2 = ((Node)v31);
                                                                }

                                                                if(v1_4 != null) {
                                                                    v1_4.add(v5_1);
                                                                }

                                                                v20 = v1_4;
                                                                v0_1 = v23;
                                                            }
                                                        }
                                                        else {
                                                            v22 = v1_3;
                                                        label_145:
                                                            v24 = v6;
                                                        }

                                                        v5_1 = v5_1.getChild$ui();
                                                        v1_3 = v22;
                                                        v6 = v24;
                                                    }

                                                    v22 = v1_3;
                                                    v24 = v6;
                                                    v1_3 = 1;
                                                    if(v0_1 != 1) {
                                                        goto label_161;
                                                    }
                                                }

                                                v5 = v1_3;
                                                v1_3 = v22;
                                                v6 = v24;
                                                continue;
                                            }
                                        }
                                    }

                                    v22 = v1_3;
                                    v1_3 = v5;
                                    v24 = v6;
                                    if((v3_2.getAggregateChildKindSet$ui() & v4) == 0) {
                                        goto label_184;
                                    }

                                    v3_2 = v3_2.getChild$ui();
                                    v5 = v1_3;
                                    v1_3 = v22;
                                    v6 = v24;
                                    continue;
                                }
                                else {
                                    goto label_181;
                                }
                            }
                        }
                        else {
                        label_181:
                            v22 = v1_3;
                            v24 = v6;
                        label_184:
                            v2_2 = ((Node)v31);
                        }

                    label_185:
                        Node v18 = v2_2;
                        if(v18 == null) {
                            goto label_212;
                        }

                        if(!this.intersects$ui(v18, arg27, v10, arg29, arg30)) {
                            goto label_212;
                        }

                        v1_3 = ((LayoutNode)v15).getDepth$ui();
                        v16_1 = v18;
                        goto label_213;
                    }

                    v22 = v1_3;
                    v24 = v6;
                }
                else {
                    v22 = v1_3;
                    v24 = v6;
                }

                goto label_212;
            }

        label_213:
            v3 = v19 + 3;
            v0 = this;
            v10 = arg28;
            v6 = v24;
        }

        return ((FocusTargetModifierNode)v16_1);
    }

    public final long getOffsetFromRectListFor-Bjo55l4(LayoutNode arg5) {
        long v4 = this.rects.getTopLeft(arg5.getSemanticsId());
        if(v4 == 0x7FFFFFFFFFFFFFFFL) {
            return IntOffset.Companion.getMax-nOcc-ac();
        }

        return IntOffset.constructor-impl((((long)(((int)v4)))) & 0xFFFFFFFFL | (((long)(((int)(v4 >> 0x20))))) << 0x20);
    }

    public final RectList getRects() {
        return this.rects;
    }

    private final boolean hasPositionalLayerTransformations(NodeCoordinator arg1) {
        OwnedLayer v0 = arg1.getLayer();
        if(v0 != null && !MatrixKt.isIdentity-58bKbWc(v0.getUnderlyingMatrix-sQKQjiQ())) {
            return 1;
        }

        return 0;
    }

    private final void insertOrUpdateTransformedNode(LayoutNode arg21) {
        RectManager v0 = this;
        LayoutNode v1 = arg21;
        v1.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(true);
        v1.setLastOffsetFromParent--gyyYBs$ui(IntOffset.Companion.getMax-nOcc-ac());
        NodeCoordinator v3 = v1.getOuterCoordinator$ui();
        MeasurePassDelegate v4 = v1.getMeasurePassDelegate$ui();
        int v5 = v4.getMeasuredWidth();
        int v4_1 = v4.getMeasuredHeight();
        MutableRect v6 = v0.cachedRect;
        v6.set(0f, 0f, ((float)v5), ((float)v4_1));
        v0.boundingRectInRoot(v3, v6);
        int v9 = ((int)v6.getLeft());
        int v10 = ((int)v6.getTop());
        int v11 = ((int)v6.getRight());
        int v12 = ((int)v6.getBottom());
        int v8 = v1.getSemanticsId();
        boolean v3_1 = v1.getAddedToRectList$ui();
        v1.setAddedToRectList$ui(true);
        if(!v3_1 || !v0.rects.update(v8, v9, v10, v11, v12)) {
            LayoutNode v2 = v1.getParent$ui();
            int v2_1 = v2 != null ? v2.getSemanticsId() : -1;
            RectList.insert$default(v0.rects, v8, v9, v10, v11, v12, v2_1, v1.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(0x400)), v1.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(16)), v0.throttledCallbacks.getRectChangedMap().containsKey(v8), 0, 0x200, null);
        }

        v0.invalidate();
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode arg5) {
        this.insertOrUpdateTransformedNode(arg5);
        MutableVector v5 = arg5.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            Object v2 = v0[v1];
            if(((LayoutNode)v2).isPlaced()) {
                this.insertOrUpdateTransformedNodeSubhierarchy(((LayoutNode)v2));
            }
        }
    }

    public final boolean intersects$ui(DelegatableNode arg10, int arg11, int arg12, int arg13, int arg14) {
        NodeCoordinator v9 = DelegatableNodeKt.requireCoordinator-64DMado(arg10, NodeKind.constructor-impl(0x400));
        LayoutNode v10 = v9.getLayoutNode();
        if(Intrinsics.areEqual(v9, v10.getOuterCoordinator$ui())) {
            return 1;
        }

        long v2 = v10.getOuterCoordinator$ui().localToRoot-MK-Hz9U(LayoutCoordinates.localPositionOf-S_NoaFU$default(v10.getOuterCoordinator$ui(), v9, 0, false, 6, null));
        long v9_1 = v9.getSize-YbymL2g();
        int v4 = Math.round(Float.intBitsToFloat(((int)(v2 >> 0x20))));
        int v0 = (((int)(v9_1 >> 0x20))) + v4;
        int v2_1 = Math.round(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))));
        int v9_2 = (((int)(v9_1 & 0xFFFFFFFFL))) + v2_1;
        if(arg11 < v0 && arg13 > v4 && arg12 < v9_2 && arg14 > v2_1) {
            return 1;
        }

        return 0;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    public final void invalidateCallbacksFor(LayoutNode arg3) {
        if(arg3.getAddedToRectList$ui()) {
            this.isDirty = true;
            this.rects.markUpdated(arg3.getSemanticsId());
        }

        this.scheduleDebounceCallback(true);
    }

    public final boolean isDescendantOf$ui(LayoutNode arg3, LayoutNode arg4) {
        int v2 = arg3.getDepth$ui() - arg4.getDepth$ui();
        if(v2 <= 0) {
            return 0;
        }

        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            arg3 = arg3.getParent$ui();
            if(arg3 == null) {
                return 0;
            }
        }

        if(arg3 == arg4) {
            return 1;
        }

        return 0;
    }

    public final boolean isTargetDrawnFirst$ui(int arg4, int arg5) {
        LayoutNode v3_1;
        LayoutNode v4_1;
        Object v4 = this.layoutNodes.get(arg4);
        if(v4 == null) {
            return 0;
        }

        Object v3 = this.layoutNodes.get(arg5);
        if(v3 == null) {
            return 0;
        }

        if(((LayoutNode)v4).getDepth$ui() != 0 && ((LayoutNode)v3).getDepth$ui() != 0) {
            do {
                if(((LayoutNode)v4).getDepth$ui() <= ((LayoutNode)v3).getDepth$ui()) {
                    goto label_20;
                }

                v4_1 = ((LayoutNode)v4).getParent$ui();
            }
            while(v4_1 != null);

            return 0;
        label_20:
            if(v4 == v3) {
                return 0;
            }

            do {
                if(((LayoutNode)v3).getDepth$ui() <= ((LayoutNode)v4).getDepth$ui()) {
                    goto label_28;
                }

                v3_1 = v3_1.getParent$ui();
            }
            while(v3_1 != null);

            return 0;
        label_28:
            if(v4 == v3_1) {
                return 0;
            }

            Object v5 = v4;
            Object v1 = v5;
            v4 = v3_1;
            while(v5 != v3_1) {
                v4_1 = ((LayoutNode)v5).getParent$ui();
                if(v4_1 == null) {
                    return 0;
                }

                LayoutNode v1_1 = v3_1.getParent$ui();
                if(v1_1 == null) {
                    return 0;
                }

                LayoutNode v2 = v4_1;
                v4 = v3_1;
                v3_1 = v1_1;
                v1 = v5;
                LayoutNode v5_1 = v2;
            }

            if(Float.compare(((LayoutNode)v1).getMeasurePassDelegate$ui().getZIndex$ui(), ((LayoutNode)v4).getMeasurePassDelegate$ui().getZIndex$ui()) == 0) {
                if(((LayoutNode)v1).getPlaceOrder$ui() < ((LayoutNode)v4).getPlaceOrder$ui()) {
                    return 1;
                }

                return 0;
            }

            if(((LayoutNode)v1).getMeasurePassDelegate$ui().getZIndex$ui() >= ((LayoutNode)v4).getMeasurePassDelegate$ui().getZIndex$ui()) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode arg8) {
        if(!arg8.isPlaced()) {
            return;
        }

        long v0 = this.outerToInnerOffset-Bjo55l4(arg8);
        if(RectManagerKt.access$isSet--gyyYBs(v0)) {
            arg8.setOuterToInnerOffset--gyyYBs$ui(v0);
            arg8.setOuterToInnerOffsetDirty$ui(false);
            MutableVector v1 = arg8.get_children$ui();
            Object[] v2 = v1.content;
            int v1_1 = v1.getSize();
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                RectManager.onLayoutPositionChanged$default(this, v2[v3], false, 2, null);
            }

            this.invalidateCallbacksFor(arg8);
            return;
        }

        this.insertOrUpdateTransformedNodeSubhierarchy(arg8);
    }

    public final void onLayoutPositionChanged(LayoutNode arg31, boolean arg32) {
        long v2_1;
        long v28;
        long v3;
        RectManager v0 = this;
        LayoutNode v1 = arg31;
        if(!v1.isPlaced()) {
            return;
        }

        LayoutNode v2 = v1.getParent$ui();
        if(v2 == null || (v2.getHasPositionalLayerTransformationsInOffsetFromRoot$ui())) {
            if(v2 == null) {
                v3 = IntOffset.Companion.getZero-nOcc-ac();
                goto label_23;
            }

            v3 = IntOffset.Companion.getMax-nOcc-ac();
        }
        else {
            if(v2.getOuterToInnerOffsetDirty$ui()) {
                v2.setOuterToInnerOffsetDirty$ui(false);
                v2.setOuterToInnerOffset--gyyYBs$ui(v0.outerToInnerOffset-Bjo55l4(v2));
            }

            v3 = v2.getOuterToInnerOffset-nOcc-ac$ui();
        }

    label_23:
        NodeCoordinator v5 = v1.getOuterCoordinator$ui();
        if((RectManagerKt.access$isSet--gyyYBs(v3)) && !v0.hasPositionalLayerTransformations(v5)) {
            if(!v1.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                v3 = IntOffset.plus-qkQi6aY(v3, v5.getPosition-nOcc-ac());
                MeasurePassDelegate v5_1 = v1.getMeasurePassDelegate$ui();
                int v11 = v5_1.getMeasuredWidth();
                int v12 = v5_1.getMeasuredHeight();
                long v13 = IntSize.constructor-impl((((long)v11)) << 0x20 | (((long)v12)) & 0xFFFFFFFFL);
                int v7 = v1.getSemanticsId();
                if(v1.getAddedToRectList$ui()) {
                    if((arg32) || !IntOffset.equals-impl0(v3, v1.getLastOffsetFromParent-nOcc-ac$ui()) || !IntSize.equals-impl0(v13, v1.getLastSize-YbymL2g$ui())) {
                        RectList v5_2 = v0.rects;
                        if(v2 != null) {
                            v5_2.moveBasedOnParentOffset(v7, v2.getSemanticsId(), IntOffset.getX-impl(v3), IntOffset.getY-impl(v3), v11, v12);
                        }
                        else {
                            v5_2.move(v7, IntOffset.getX-impl(v3), IntOffset.getY-impl(v3), IntOffset.getX-impl(v3) + v11, IntOffset.getY-impl(v3) + v12);
                        }

                        v0.invalidate();
                    }

                    v28 = v3;
                    v2_1 = v13;
                }
                else {
                    v1.setAddedToRectList$ui(true);
                    boolean v22 = v1.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(0x400));
                    boolean v23 = v1.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(16));
                    boolean v15 = v0.throttledCallbacks.getRectChangedMap().containsKey(v7);
                    RectList v6 = v0.rects;
                    if(v2 != null) {
                        int v8 = v2.getSemanticsId();
                        int v9 = IntOffset.getX-impl(v3);
                        int v10 = IntOffset.getY-impl(v3);
                        v28 = v3;
                        v2_1 = v13;
                        v6.insertBasedOnParentOffset(v7, v8, v9, v10, v11, v12, v22, v23, v15);
                    }
                    else {
                        v28 = v3;
                        v2_1 = v13;
                        RectList.insert$default(v6, v7, IntOffset.getX-impl(v28), IntOffset.getY-impl(v28), IntOffset.getX-impl(v28) + v11, IntOffset.getY-impl(v28) + v12, 0, v22, v23, v15, 0, 0x220, null);
                    }

                    v0.invalidate();
                }

                v1.setLastSize-ozmzZPI$ui(v2_1);
                v1.setLastOffsetFromParent--gyyYBs$ui(v28);
                return;
            }
            else {
                this.insertOrUpdateTransformedNodeSubhierarchy(arg31);
                this.resetHasPositionalLayerTransformationsForSubtreeIfNeeded(arg31);
                return;
            }
        }

        this.insertOrUpdateTransformedNodeSubhierarchy(arg31);
    }

    public static void onLayoutPositionChanged$default(RectManager arg0, LayoutNode arg1, boolean arg2, int arg3, Object arg4) {
        arg0.onLayoutPositionChanged(arg1, false);
    }

    private final long outerToInnerOffset-Bjo55l4(LayoutNode arg6) {
        NodeCoordinator v0 = arg6.getOuterCoordinator$ui();
        long v1 = IntOffset.Companion.getZero-nOcc-ac();
        NodeCoordinator v6 = arg6.getInnerCoordinator$ui();
        while(v6 != null) {
            if(v6 == v0) {
                return v1;
            }

            if(this.hasPositionalLayerTransformations(v6)) {
                return IntOffset.Companion.getMax-nOcc-ac();
            }
            else {
                v1 = IntOffset.plus-qkQi6aY(v1, v6.getPosition-nOcc-ac());
                v6 = v6.getWrappedBy$ui();
                continue;
            }

            return v1;
        }

        return v1;
    }

    public final Object registerOnChangedCallback(Function0 arg1) {
        this.callbacks.add(arg1);
        return arg1;
    }

    public final RegistrationHandle registerOnGlobalLayoutCallback(int arg1, long arg2, long arg4, DelegatableNode arg6, Function1 arg7) {
        return this.throttledCallbacks.registerOnGlobalChange(arg1, arg2, arg4, arg6, arg7);
    }

    public final RegistrationHandle registerOnRectChangedCallback(int arg9, long arg10, long arg12, DelegatableNode arg14, Function1 arg15) {
        int v1 = arg9;
        RegistrationHandle v9 = this.throttledCallbacks.registerOnRectChanged(v1, arg10, arg12, arg14, arg15);
        if(DelegatableNodeKt.requireLayoutNode(arg14.getNode()).getAddedToRectList$ui()) {
            this.rects.updateHasCallbacks(v1, true);
        }

        this.invalidate();
        this.scheduleDebounceCallback(true);
        return v9;
    }

    public final void remove(LayoutNode arg3) {
        if(arg3.getAddedToRectList$ui()) {
            this.rects.remove(arg3.getSemanticsId());
            arg3.setAddedToRectList$ui(false);
            this.invalidate();
            this.isFragmented = true;
        }
    }

    public final void removeScheduledCallback() {
        Object v0 = this.dispatchToken;
        if(v0 != null) {
            Actual_androidKt.removePost(v0);
            this.dispatchToken = null;
        }
    }

    private final void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode arg6) {
        if((arg6.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) && !this.hasPositionalLayerTransformations(arg6.getOuterCoordinator$ui())) {
            int v0 = 0;
            arg6.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(false);
            if(arg6.getOuterToInnerOffsetDirty$ui()) {
                arg6.setOuterToInnerOffset--gyyYBs$ui(this.outerToInnerOffset-Bjo55l4(arg6));
                arg6.setOuterToInnerOffsetDirty$ui(false);
            }

            if(IntOffset.equals-impl0(arg6.getOuterToInnerOffset-nOcc-ac$ui(), IntOffset.Companion.getMax-nOcc-ac())) {
                return;
            }

            MutableVector v6 = arg6.get_children$ui();
            Object[] v1 = v6.content;
            int v6_1 = v6.getSize();
            while(v0 < v6_1) {
                this.resetHasPositionalLayerTransformationsForSubtreeIfNeeded(v1[v0]);
                ++v0;
            }
        }
    }

    public final void scheduleDebounceCallback(boolean arg7) {
        int v7 = !arg7 || this.dispatchToken != null ? 1 : 0;
        long v0 = this.throttledCallbacks.getMinDebounceDeadline();
        if(v0 >= 0 || v7 == 0) {
            if(this.scheduledDispatchDeadline == v0 && v7 != 0) {
                return;
            }

            goto label_17;
        }
        else {
        }

        return;
    label_17:
        Object v7_1 = this.dispatchToken;
        if(v7_1 != null) {
            Actual_androidKt.removePost(v7_1);
        }

        long v2 = Actual_androidKt.currentTimeMillis();
        v0 = Math.max(v0, 16 + v2);
        this.scheduledDispatchDeadline = v0;
        this.dispatchToken = Actual_androidKt.postDelayed(v0 - v2, this.dispatchLambda);
    }

    public final void unregisterOnChangedCallback(Object arg2) {
        Object v0 = TypeIntrinsics.isFunctionOfArity(arg2, 0) ? arg2 : null;
        if(v0 == null) {
            return;
        }

        this.callbacks.remove(arg2);
    }

    public final void unsetHasCallbacksFor(LayoutNode arg2) {
        this.rects.updateHasCallbacks(arg2.getSemanticsId(), false);
    }

    public final void updateFlagsFor(LayoutNode arg2, boolean arg3, boolean arg4) {
        if(arg2.isAttached()) {
            this.rects.updateFlagsFor(arg2.getSemanticsId(), arg3, arg4);
        }
    }

    public final void updateOffsets-gTq6Wqs(long arg10, long arg12, float[] arg14, int arg15, int arg16) {
        int v0 = RectManagerKt.access$analyzeComponents-58bKbWc(arg14);
        ThrottledCallbacks v1 = this.throttledCallbacks;
        if((v0 & 2) == 0) {
        }
        else {
            arg14 = null;
        }

        boolean v10 = (v1.updateOffsets-LDcG7Xg(arg10, arg12, arg14, arg15, arg16)) || (this.isScreenOrWindowDirty) ? true : false;
        this.isScreenOrWindowDirty = v10;
    }
}

