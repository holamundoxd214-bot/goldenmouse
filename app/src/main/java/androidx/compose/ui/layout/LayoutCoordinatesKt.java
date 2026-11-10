package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u000F\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001A\u000F\u0010\u0004\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001A\u000F\u0010\u0005\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001A\n\u0010\u0006\u001A\u00020\u0007*\u00020\u0002\u001A\f\u0010\b\u001A\u00020\u0007*\u00020\u0002H\u0007\u001A\u0014\u0010\b\u001A\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\n\u001A\u000F\u0010\u000B\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001A\n\u0010\f\u001A\u00020\u0007*\u00020\u0002\u001A\n\u0010\r\u001A\u00020\u0002*\u00020\u0002¨\u0006\u000E"}, d2={"positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInWindow", "positionOnScreen", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "clipBounds", "", "positionInParent", "boundsInParent", "findRootCoordinates", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutCoordinatesKt {
    public static final Rect boundsInParent(LayoutCoordinates arg6) {
        LayoutCoordinates v0 = arg6.getParentLayoutCoordinates();
        if(v0 != null) {
            Rect v0_1 = LayoutCoordinates.localBoundingBoxOf$default(v0, arg6, false, 2, null);
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return new Rect(0f, 0f, ((float)(((int)(arg6.getSize-YbymL2g() >> 0x20)))), ((float)(((int)(arg6.getSize-YbymL2g() & 0xFFFFFFFFL)))));
    }

    public static final Rect boundsInRoot(LayoutCoordinates arg4) {
        return LayoutCoordinates.localBoundingBoxOf$default(LayoutCoordinatesKt.findRootCoordinates(arg4), arg4, false, 2, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of boundsInWindow with clipBounds parameter") public static final Rect boundsInWindow(LayoutCoordinates arg1) {
        return LayoutCoordinatesKt.boundsInWindow(arg1, true);
    }

    public static final Rect boundsInWindow(LayoutCoordinates arg14, boolean arg15) {
        float v14_1;
        LayoutCoordinates v0 = LayoutCoordinatesKt.findRootCoordinates(arg14);
        int v3 = 0x20;
        float v1 = ((float)(((int)(v0.getSize-YbymL2g() >> v3))));
        long v6 = 0xFFFFFFFFL;
        float v2 = ((float)(((int)(v0.getSize-YbymL2g() & v6))));
        Rect v14 = v0.localBoundingBoxOf(arg14, arg15);
        float v4 = 0f;
        float v5 = v14.getLeft();
        if(arg15) {
            if(v5 < 0f) {
                v5 = 0f;
            }

            if(v5 <= v1) {
                goto label_19;
            }

            v5 = v1;
        }

    label_19:
        float v8 = v14.getTop();
        if(arg15) {
            if(v8 < 0f) {
                v8 = 0f;
            }

            if(v8 <= v2) {
                goto label_25;
            }

            v8 = v2;
        }

    label_25:
        if(arg15) {
            float v9 = v14.getRight();
            if(v9 < 0f) {
                v9 = 0f;
            }

            if(v9 > v1) {
                goto label_34;
            }

            v1 = v9;
        }
        else {
            v1 = v14.getRight();
        }

    label_34:
        if(arg15) {
            v14_1 = v14.getBottom();
            if(v14_1 < 0f) {
            }
            else {
                v4 = v14_1;
            }

            if(v4 > v2) {
                goto label_44;
            }

            v2 = v4;
        }
        else {
            v2 = v14.getBottom();
        }

    label_44:
        if(v5 == v1) {
        }
        else {
            if(v8 == v2) {
                goto label_47;
            }

            goto label_50;
        }

    label_47:
        return Rect.Companion.getZero();
    label_50:
        long v14_2 = v0.localToWindow-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v5))) << v3 | (((long)Float.floatToRawIntBits(v8))) & v6));
        long v8_1 = v0.localToWindow-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) << v3 | (((long)Float.floatToRawIntBits(v8))) & v6));
        long v10 = v0.localToWindow-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) << v3 | (((long)Float.floatToRawIntBits(v2))) & v6));
        long v0_1 = v0.localToWindow-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v2))) & v6 | (((long)Float.floatToRawIntBits(v5))) << v3));
        v2 = Float.intBitsToFloat(((int)(v14_2 >> v3)));
        v4 = Float.intBitsToFloat(((int)(v8_1 >> v3)));
        v5 = Float.intBitsToFloat(((int)(v0_1 >> v3)));
        float v3_1 = Float.intBitsToFloat(((int)(v10 >> v3)));
        float v12 = Math.min(v2, Math.min(v4, Math.min(v5, v3_1)));
        v2 = Math.max(v2, Math.max(v4, Math.max(v5, v3_1)));
        v14_1 = Float.intBitsToFloat(((int)(v14_2 & v6)));
        float v15 = Float.intBitsToFloat(((int)(v8_1 & v6)));
        float v0_2 = Float.intBitsToFloat(((int)(v0_1 & v6)));
        v1 = Float.intBitsToFloat(((int)(v10 & v6)));
        return new Rect(v12, Math.min(v14_1, Math.min(v15, Math.min(v0_2, v1))), v2, Math.max(v14_1, Math.max(v15, Math.max(v0_2, v1))));
    }

    public static Rect boundsInWindow$default(LayoutCoordinates arg0, boolean arg1, int arg2, Object arg3) {
        return LayoutCoordinatesKt.boundsInWindow(arg0, true);
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates arg2) {
        LayoutCoordinates v0;
        for(v0 = arg2.getParentLayoutCoordinates(); true; v0 = arg2.getParentLayoutCoordinates()) {
            LayoutCoordinates v1 = v0;
            v0 = arg2;
            arg2 = v1;
            if(arg2 == null) {
                break;
            }
        }

        arg2 = (v0 instanceof NodeCoordinator) ? v0 : null;
        if(arg2 == null) {
            return v0;
        }

        NodeCoordinator v0_1;
        for(v0_1 = ((NodeCoordinator)arg2).getWrappedBy$ui(); true; v0_1 = v2.getWrappedBy$ui()) {
            NodeCoordinator v1_1 = v0_1;
            v0 = arg2;
            NodeCoordinator v2 = v1_1;
            if(v2 == null) {
                return v0;
            }
        }

        return v0;
    }

    public static final long positionInParent(LayoutCoordinates arg3) {
        LayoutCoordinates v0 = arg3.getParentLayoutCoordinates();
        if(v0 != null) {
            return v0.localPositionOf-R5De75A(arg3, Offset.Companion.getZero-F1C5BW0());
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public static final long positionInRoot(LayoutCoordinates arg2) {
        return arg2.localToRoot-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates arg2) {
        return arg2.localToWindow-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates arg2) {
        return arg2.localToScreen-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }
}

