package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\f\u0010&\u001A\b\u0012\u0004\u0012\u00020\u001F0\'J\u000E\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\u0000J&\u0010+\u001A\u00020)2\u0006\u0010,\u001A\u00020\u00192\u0006\u0010-\u001A\u00020\u00192\u0006\u0010.\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u0019J\u0006\u00100\u001A\u00020)J\u001D\u00101\u001A\u00020)2\u0006\u00102\u001A\u00020\u00062\u0006\u00103\u001A\u00020\u0006¢\u0006\u0004\b4\u00105J\u0013\u00106\u001A\u0002072\b\u00108\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001A\u00020\u0019H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u0010\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u000E\u0010\b\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u001C\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001BR\u0011\u0010\u001E\u001A\u00020\u001F8F¢\u0006\u0006\u001A\u0004\b \u0010!R\u0011\u0010\"\u001A\u00020\u001F8F¢\u0006\u0006\u001A\u0004\b#\u0010!R\u0011\u0010$\u001A\u00020\u001F8F¢\u0006\u0006\u001A\u0004\b%\u0010!¨\u0006:"}, d2={"Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(JJJJJ[FLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "[F", "positionInRoot", "getPositionInRoot-nOcc-ac", "()J", "positionInWindow", "getPositionInWindow-nOcc-ac", "positionInScreen", "getPositionInScreen-nOcc-ac", "width", "", "getWidth", "()I", "height", "getHeight", "boundsInRoot", "Landroidx/compose/ui/unit/IntRect;", "getBoundsInRoot", "()Landroidx/compose/ui/unit/IntRect;", "boundsInWindow", "getBoundsInWindow", "boundsInScreen", "getBoundsInScreen", "calculateOcclusions", "", "fractionVisibleIn", "", "viewport", "fractionVisibleInRect", "left", "top", "right", "bottom", "fractionVisibleInWindow", "fractionVisibleInWindowWithInsets", "topLeftInset", "bottomRightInset", "fractionVisibleInWindowWithInsets-E1MhUcY", "(JJ)F", "equals", "", "other", "hashCode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeLayoutBounds {
    public static final int $stable = 8;
    private final long bottomRight;
    private final DelegatableNode node;
    private final long screenOffset;
    private final long topLeft;
    private final float[] viewToWindowMatrix;
    private final long windowOffset;
    private final long windowSize;

    static {
    }

    private RelativeLayoutBounds(long arg1, long arg3, long arg5, long arg7, long arg9, float[] arg11, DelegatableNode arg12) {
        super();
        this.topLeft = arg1;
        this.bottomRight = arg3;
        this.windowOffset = arg5;
        this.screenOffset = arg7;
        this.windowSize = arg9;
        this.viewToWindowMatrix = arg11;
        this.node = arg12;
    }

    public RelativeLayoutBounds(long arg1, long arg3, long arg5, long arg7, long arg9, float[] arg11, DelegatableNode arg12, DefaultConstructorMarker arg13) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg12);
    }

    public final List calculateOcclusions() {
        int v21;
        int v16;
        RectManager v1 = DelegatableNodeKt.requireOwner(this.node).getRectManager();
        int v0 = DelegatableNodeKt.requireLayoutNode(this.node).getSemanticsId();
        RectList v2 = v1.getRects();
        int v3 = v2.indexOf(v0);
        if(v3 < 0) {
            return CollectionsKt.emptyList();
        }

        List v4 = CollectionsKt.createListBuilder();
        long[] v5 = v2.items;
        int v2_1 = v2.itemsSize;
        long v6 = v5[v3];
        long v8 = v5[v3 + 1];
        int v10 = 0;
        while(v10 < v5.length - 2) {
            if(v10 >= v2_1) {
                break;
            }

            if(v10 == v3) {
                v10 += 3;
            }
            else {
                long v11 = v5[v10];
                long v13 = v5[v10 + 1];
                if(((v8 - v11 - 0x100000001L | v13 - v6 - 0x100000001L) & -9223372034707292160L) == 0) {
                    v16 = v2_1;
                    v21 = v3;
                    v2_1 = ((int)(v11 >> 0x20));
                    v3 = ((int)v11);
                    int v11_1 = ((int)(v13 >> 0x20));
                    int v12 = ((int)v13);
                    if(v1.isTargetDrawnFirst$ui(v0, (((int)v5[v10 + 2])) & 0x1FFFFFF)) {
                        v4.add(new IntRect(v2_1, v3, v11_1, v12));
                    }
                }
                else {
                    v16 = v2_1;
                    v21 = v3;
                }

                v10 += 3;
                v3 = v21;
                v2_1 = v16;
            }
        }

        return CollectionsKt.build(v4);
    }

    public boolean equals(Object arg7) {
        boolean v2_1;
        if(this == (((RelativeLayoutBounds)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(this.getClass() != arg7.getClass()) {
            }
            else if(this.topLeft != ((RelativeLayoutBounds)arg7).topLeft) {
                return 0;
            }
            else if(this.bottomRight != ((RelativeLayoutBounds)arg7).bottomRight) {
                return 0;
            }
            else if(this.windowSize != ((RelativeLayoutBounds)arg7).windowSize) {
                return 0;
            }
            else if(!IntOffset.equals-impl0(this.windowOffset, ((RelativeLayoutBounds)arg7).windowOffset)) {
                return 0;
            }
            else if(!IntOffset.equals-impl0(this.screenOffset, ((RelativeLayoutBounds)arg7).screenOffset)) {
                return 0;
            }
            else {
                float[] v2 = this.viewToWindowMatrix;
                float[] v3 = ((RelativeLayoutBounds)arg7).viewToWindowMatrix;
                if(v2 == null) {
                    if(v3 == null) {
                        v2_1 = true;
                    }
                    else {
                        goto label_38;
                    }
                }
                else if(v3 == null) {
                label_38:
                    v2_1 = false;
                }
                else {
                    v2_1 = Matrix.equals-impl0(v2, v3);
                }

                if(!v2_1) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.node, ((RelativeLayoutBounds)arg7).node)) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final float fractionVisibleIn(RelativeLayoutBounds arg8) {
        return this.fractionVisibleInRect(((int)(arg8.topLeft >> 0x20)), ((int)arg8.topLeft), ((int)(arg8.bottomRight >> 0x20)), ((int)arg8.bottomRight));
    }

    public final float fractionVisibleInRect(int arg9, int arg10, int arg11, int arg12) {
        int v0 = ((int)(this.topLeft >> 0x20));
        int v1 = Math.min(Math.max(v0, arg9), arg11);
        int v3 = ((int)this.topLeft);
        int v4 = Math.min(Math.max(v3, arg10), arg12);
        int v2 = ((int)(this.bottomRight >> 0x20));
        int v5 = Math.max(Math.min(v2, arg11), arg9);
        int v8 = ((int)this.bottomRight);
        return (((float)Math.max((v5 - v1) * (Math.max(Math.min(v8, arg12), arg10) - v4), 0))) / (((float)Math.min((arg11 - arg9) * (arg12 - arg10), (v2 - v0) * (v8 - v3))));
    }

    public final float fractionVisibleInWindow() {
        return this.fractionVisibleInRect(0, 0, ((int)(this.windowSize >> 0x20)), ((int)this.windowSize));
    }

    public final float fractionVisibleInWindowWithInsets-E1MhUcY(long arg8, long arg10) {
        long v0 = this.windowSize;
        int v2 = IntOffset.getX-impl(this.windowOffset);
        int v3 = IntOffset.getY-impl(this.windowOffset);
        return this.fractionVisibleInRect(IntOffset.getX-impl(arg8) + v2, IntOffset.getY-impl(arg8) + v3, v2 + (((int)(v0 >> 0x20))) - IntOffset.getX-impl(arg10), v3 + (((int)v0)) - IntOffset.getY-impl(arg10));
    }

    public final IntRect getBoundsInRoot() {
        return new IntRect(((int)(this.topLeft >> 0x20)), ((int)this.topLeft), ((int)(this.bottomRight >> 0x20)), ((int)this.bottomRight));
    }

    public final IntRect getBoundsInScreen() {
        if(this.viewToWindowMatrix != null) {
            IntRect v0 = this.getBoundsInWindow();
            return new IntRect(v0.getLeft() + IntOffset.getX-impl(this.windowOffset), v0.getTop() + IntOffset.getY-impl(this.windowOffset), v0.getRight() + IntOffset.getX-impl(this.windowOffset), v0.getBottom() + IntOffset.getY-impl(this.windowOffset));
        }

        int v3 = ((int)(this.topLeft >> 0x20));
        int v0_1 = ((int)this.topLeft);
        int v1 = ((int)(this.bottomRight >> 0x20));
        int v2 = ((int)this.bottomRight);
        int v4 = IntOffset.getX-impl(this.screenOffset);
        int v7 = IntOffset.getY-impl(this.screenOffset);
        return new IntRect(v3 + v4, v0_1 + v7, v1 + v4, v2 + v7);
    }

    public final IntRect getBoundsInWindow() {
        int v3 = ((int)(this.topLeft >> 0x20));
        int v0 = ((int)this.topLeft);
        int v1 = ((int)(this.bottomRight >> 0x20));
        int v2 = ((int)this.bottomRight);
        float[] v4 = this.viewToWindowMatrix;
        if(v4 != null) {
            return IntRectKt.roundToIntRect(Matrix.map-impl(v4, new Rect(((float)v3), ((float)v0), ((float)v1), ((float)v2))));
        }

        int v4_1 = IntOffset.getX-impl(this.screenOffset) - IntOffset.getX-impl(this.windowOffset);
        int v5 = IntOffset.getY-impl(this.screenOffset) - IntOffset.getY-impl(this.windowOffset);
        return new IntRect(v3 + v4_1, v0 + v5, v1 + v4_1, v2 + v5);
    }

    public final int getHeight() {
        return (((int)this.bottomRight)) - (((int)this.topLeft));
    }

    public final long getPositionInRoot-nOcc-ac() {
        return IntOffset.constructor-impl(this.topLeft);
    }

    public final long getPositionInScreen-nOcc-ac() {
        return IntOffset.constructor-impl((((long)((((int)(this.topLeft >> 0x20))) + IntOffset.getX-impl(this.screenOffset)))) << 0x20 | (((long)((((int)this.topLeft)) + IntOffset.getY-impl(this.screenOffset)))) & 0xFFFFFFFFL);
    }

    public final long getPositionInWindow-nOcc-ac() {
        return IntOffset.constructor-impl((((long)((((int)(this.topLeft >> 0x20))) + (IntOffset.getX-impl(this.screenOffset) - IntOffset.getX-impl(this.windowOffset))))) << 0x20 | (((long)((((int)this.topLeft)) + (IntOffset.getY-impl(this.screenOffset) - IntOffset.getY-impl(this.windowOffset))))) & 0xFFFFFFFFL);
    }

    public final int getWidth() {
        return (((int)(this.bottomRight >> 0x20))) - (((int)(this.topLeft >> 0x20)));
    }

    public int hashCode() {
        int v0 = ((((Long.hashCode(this.topLeft) * 0x1F + Long.hashCode(this.bottomRight)) * 0x1F + Long.hashCode(this.windowSize)) * 0x1F + IntOffset.hashCode-impl(this.windowOffset)) * 0x1F + IntOffset.hashCode-impl(this.screenOffset)) * 0x1F;
        float[] v1 = this.viewToWindowMatrix;
        int v1_1 = v1 != null ? Matrix.hashCode-impl(v1) : 0;
        return (v0 + v1_1) * 0x1F + this.node.hashCode();
    }
}

