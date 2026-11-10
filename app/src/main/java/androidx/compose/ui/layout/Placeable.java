package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001A\u00020\u0017H\u0002J:\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0019\u0010\u001D\u001A\u0015\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001E¢\u0006\u0002\b H$¢\u0006\u0004\b!\u0010\"J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010#\u001A\u00020$H\u0014¢\u0006\u0004\b!\u0010%R\u001E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\t\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\bR\u0014\u0010\u000B\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\bR\u0014\u0010\r\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\bR&\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0004\u001A\u00020\u000F@DX\u0084\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\'\u001A\u00020&2\u0006\u0010\u0004\u001A\u00020&@DX\u0084\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R \u0010*\u001A\u00020\u001A2\u0006\u0010\u0004\u001A\u00020\u001A@BX\u0084\u000E¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b+\u0010\u0012¨\u0006-"}, d2={"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "<init>", "()V", "value", "", "width", "getWidth", "()I", "height", "getHeight", "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "J", "onMeasuredSizeChanged", "", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "PlacementScope", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Placeable implements Measured {
    @PlacementScopeMarker @Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001A\u00020\u0005*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0005H\u0016J#\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u0005¢\u0006\u0004\b\u001F\u0010 J$\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\b\b\u0002\u0010\u001E\u001A\u00020\u0005J$\u0010#\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\b\b\u0002\u0010\u001E\u001A\u00020\u0005J#\u0010#\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u0005¢\u0006\u0004\b$\u0010 J>\u0010%\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u00052\u0019\b\u0002\u0010&\u001A\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A0\'¢\u0006\u0002\b)¢\u0006\u0004\b*\u0010+J?\u0010%\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\b\b\u0002\u0010\u001E\u001A\u00020\u00052\u0019\b\u0002\u0010&\u001A\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A0\'¢\u0006\u0002\b)J?\u0010,\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\b\b\u0002\u0010\u001E\u001A\u00020\u00052\u0019\b\u0002\u0010&\u001A\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A0\'¢\u0006\u0002\b)J>\u0010,\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u00052\u0019\b\u0002\u0010&\u001A\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A0\'¢\u0006\u0002\b)¢\u0006\u0004\b-\u0010+J,\u0010,\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\u0006\u0010.\u001A\u00020/2\b\b\u0002\u0010\u001E\u001A\u00020\u0005J+\u0010,\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010.\u001A\u00020/2\b\b\u0002\u0010\u001E\u001A\u00020\u0005¢\u0006\u0004\b-\u00100J,\u0010%\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u000B2\u0006\u0010.\u001A\u00020/2\b\b\u0002\u0010\u001E\u001A\u00020\u0005J+\u0010%\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010.\u001A\u00020/2\b\b\u0002\u0010\u001E\u001A\u00020\u0005¢\u0006\u0004\b*\u00100JA\u00101\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u00052\u001B\b\b\u0010&\u001A\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A\u0018\u00010\'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b2\u0010+J,\u00101\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010.\u001A\u00020/H\u0080\b¢\u0006\u0004\b2\u00103JA\u00104\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u00052\u001B\b\b\u0010&\u001A\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A\u0018\u00010\'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b5\u0010+J,\u00104\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010.\u001A\u00020/H\u0080\b¢\u0006\u0004\b5\u00103J\u001F\u00108\u001A\u00020\u001A2\u0017\u00109\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001A0\'¢\u0006\u0002\b)J\f\u0010:\u001A\u00020\u001A*\u00020\u001BH\u0002R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001A\u00020\u000BX¤\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000FX¤\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001A\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u000E\u00106\u001A\u000207X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006;"}, d2={"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/unit/Density;", "<init>", "()V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parentWidth", "", "getParentWidth", "()I", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "current", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "placeRelative", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "place", "place-70tqf50", "placeRelativeWithLayer", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeApparentToRealOffset", "placeApparentToRealOffset-aW-9-wM$ui", "motionFrameOfReferencePlacement", "", "withMotionFrameOfReferencePlacement", "block", "handleMotionFrameOfReferencePlacement", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PlacementScope implements Density {
        public static final int $stable;
        private boolean motionFrameOfReferencePlacement;

        static {
        }

        public PlacementScope() {
            super();
        }

        public static final LayoutDirection access$getParentLayoutDirection(PlacementScope arg0) {
            return arg0.getParentLayoutDirection();
        }

        public static final int access$getParentWidth(PlacementScope arg0) {
            return arg0.getParentWidth();
        }

        public static final void access$handleMotionFrameOfReferencePlacement(PlacementScope arg0, Placeable arg1) {
            arg0.handleMotionFrameOfReferencePlacement(arg1);
        }

        public float current(Ruler arg1, float arg2) {
            return arg2;
        }

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        public float getDensity() {
            return 1f;
        }

        public float getFontScale() {
            return 1f;
        }

        protected abstract LayoutDirection getParentLayoutDirection();

        protected abstract int getParentWidth();

        private final void handleMotionFrameOfReferencePlacement(Placeable arg2) {
            if((arg2 instanceof MotionReferencePlacementDelegate)) {
                ((MotionReferencePlacementDelegate)arg2).updatePlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public final void place(Placeable arg5, int arg6, int arg7, float arg8) {
            long v6 = IntOffset.constructor-impl((((long)arg7)) & 0xFFFFFFFFL | (((long)arg6)) << 0x20);
            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v6, arg5.apparentToRealOffset), arg8, null);
        }

        public static void place$default(PlacementScope arg0, Placeable arg1, int arg2, int arg3, float arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                arg0.place(arg1, arg2, arg3, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public final void place-70tqf50(Placeable arg3, long arg4, float arg6) {
            this.handleMotionFrameOfReferencePlacement(arg3);
            arg3.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg4, arg3.apparentToRealOffset), arg6, null);
        }

        public static void place-70tqf50$default(PlacementScope arg0, Placeable arg1, long arg2, float arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                arg0.place-70tqf50(arg1, arg2, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        public final void placeApparentToRealOffset-aW-9-wM$ui(Placeable arg3, long arg4, float arg6, GraphicsLayer arg7) {
            this.handleMotionFrameOfReferencePlacement(arg3);
            arg3.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg4, arg3.apparentToRealOffset), arg6, arg7);
        }

        public final void placeApparentToRealOffset-aW-9-wM$ui(Placeable arg3, long arg4, float arg6, Function1 arg7) {
            this.handleMotionFrameOfReferencePlacement(arg3);
            arg3.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg4, arg3.apparentToRealOffset), arg6, arg7);
        }

        public final void placeAutoMirrored-aW-9-wM$ui(Placeable arg5, long arg6, float arg8, GraphicsLayer arg9) {
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    arg6 = IntOffset.constructor-impl((((long)IntOffset.getY-impl(arg6))) & 0xFFFFFFFFL | (((long)(this.getParentWidth() - arg5.getWidth() - IntOffset.getX-impl(arg6)))) << 0x20);
                    this.handleMotionFrameOfReferencePlacement(arg5);
                    arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
        }

        public final void placeAutoMirrored-aW-9-wM$ui(Placeable arg5, long arg6, float arg8, Function1 arg9) {
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    arg6 = IntOffset.constructor-impl((((long)IntOffset.getY-impl(arg6))) & 0xFFFFFFFFL | (((long)(this.getParentWidth() - arg5.getWidth() - IntOffset.getX-impl(arg6)))) << 0x20);
                    this.handleMotionFrameOfReferencePlacement(arg5);
                    arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
        }

        public final void placeRelative(Placeable arg7, int arg8, int arg9, float arg10) {
            long v0 = ((long)arg8);
            arg8 = 0x20;
            long v4 = 0xFFFFFFFFL;
            v0 = IntOffset.constructor-impl(v0 << arg8 | (((long)arg9)) & v4);
            Function1 v3 = null;
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    long v8 = IntOffset.constructor-impl((((long)(this.getParentWidth() - arg7.getWidth() - IntOffset.getX-impl(v0)))) << arg8 | (((long)IntOffset.getY-impl(v0))) & v4);
                    this.handleMotionFrameOfReferencePlacement(arg7);
                    arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v8, arg7.apparentToRealOffset), arg10, v3);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg7);
            arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v0, arg7.apparentToRealOffset), arg10, v3);
        }

        public static void placeRelative$default(PlacementScope arg0, Placeable arg1, int arg2, int arg3, float arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                arg0.placeRelative(arg1, arg2, arg3, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        public final void placeRelative-70tqf50(Placeable arg6, long arg7, float arg9) {
            Function1 v2 = null;
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    arg7 = IntOffset.constructor-impl((((long)IntOffset.getY-impl(arg7))) & 0xFFFFFFFFL | (((long)(this.getParentWidth() - arg6.getWidth() - IntOffset.getX-impl(arg7)))) << 0x20);
                    this.handleMotionFrameOfReferencePlacement(arg6);
                    arg6.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg7, arg6.apparentToRealOffset), arg9, v2);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg6);
            arg6.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg7, arg6.apparentToRealOffset), arg9, v2);
        }

        public static void placeRelative-70tqf50$default(PlacementScope arg0, Placeable arg1, long arg2, float arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                arg0.placeRelative-70tqf50(arg1, arg2, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public final void placeRelativeWithLayer(Placeable arg7, int arg8, int arg9, float arg10, Function1 arg11) {
            long v0 = ((long)arg8);
            arg8 = 0x20;
            long v4 = 0xFFFFFFFFL;
            v0 = IntOffset.constructor-impl(v0 << arg8 | (((long)arg9)) & v4);
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    long v8 = IntOffset.constructor-impl((((long)(this.getParentWidth() - arg7.getWidth() - IntOffset.getX-impl(v0)))) << arg8 | (((long)IntOffset.getY-impl(v0))) & v4);
                    this.handleMotionFrameOfReferencePlacement(arg7);
                    arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v8, arg7.apparentToRealOffset), arg10, arg11);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg7);
            arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v0, arg7.apparentToRealOffset), arg10, arg11);
        }

        public final void placeRelativeWithLayer(Placeable arg7, int arg8, int arg9, GraphicsLayer arg10, float arg11) {
            long v0 = ((long)arg8);
            arg8 = 0x20;
            long v4 = 0xFFFFFFFFL;
            v0 = IntOffset.constructor-impl(v0 << arg8 | (((long)arg9)) & v4);
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    long v8 = IntOffset.constructor-impl((((long)(this.getParentWidth() - arg7.getWidth() - IntOffset.getX-impl(v0)))) << arg8 | (((long)IntOffset.getY-impl(v0))) & v4);
                    this.handleMotionFrameOfReferencePlacement(arg7);
                    arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v8, arg7.apparentToRealOffset), arg11, arg10);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg7);
            arg7.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v0, arg7.apparentToRealOffset), arg11, arg10);
        }

        public static void placeRelativeWithLayer$default(PlacementScope arg6, Placeable arg7, int arg8, int arg9, float arg10, Function1 arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                if((arg12 & 8) != 0) {
                    arg11 = PlaceableKt.access$getDefaultLayerBlock$p();
                }

                arg6.placeRelativeWithLayer(arg7, arg8, arg9, 0f, arg11);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public static void placeRelativeWithLayer$default(PlacementScope arg6, Placeable arg7, int arg8, int arg9, GraphicsLayer arg10, float arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                arg6.placeRelativeWithLayer(arg7, arg8, arg9, arg10, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer-aW-9-wM(Placeable arg5, long arg6, float arg8, Function1 arg9) {
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    arg6 = IntOffset.constructor-impl((((long)IntOffset.getY-impl(arg6))) & 0xFFFFFFFFL | (((long)(this.getParentWidth() - arg5.getWidth() - IntOffset.getX-impl(arg6)))) << 0x20);
                    this.handleMotionFrameOfReferencePlacement(arg5);
                    arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg8, arg9);
        }

        public final void placeRelativeWithLayer-aW-9-wM(Placeable arg5, long arg6, GraphicsLayer arg8, float arg9) {
            if(this.getParentLayoutDirection() != LayoutDirection.Ltr) {
                if(this.getParentWidth() == 0) {
                }
                else {
                    arg6 = IntOffset.constructor-impl((((long)IntOffset.getY-impl(arg6))) & 0xFFFFFFFFL | (((long)(this.getParentWidth() - arg5.getWidth() - IntOffset.getX-impl(arg6)))) << 0x20);
                    this.handleMotionFrameOfReferencePlacement(arg5);
                    arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg9, arg8);
                    return;
                }
            }

            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg6, arg5.apparentToRealOffset), arg9, arg8);
        }

        public static void placeRelativeWithLayer-aW-9-wM$default(PlacementScope arg6, Placeable arg7, long arg8, GraphicsLayer arg10, float arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                arg6.placeRelativeWithLayer-aW-9-wM(arg7, arg8, arg10, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public static void placeRelativeWithLayer-aW-9-wM$default(PlacementScope arg6, Placeable arg7, long arg8, float arg10, Function1 arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                if((arg12 & 4) != 0) {
                    arg11 = PlaceableKt.access$getDefaultLayerBlock$p();
                }

                arg6.placeRelativeWithLayer-aW-9-wM(arg7, arg8, 0f, arg11);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public final void placeWithLayer(Placeable arg5, int arg6, int arg7, float arg8, Function1 arg9) {
            long v6 = IntOffset.constructor-impl((((long)arg7)) & 0xFFFFFFFFL | (((long)arg6)) << 0x20);
            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v6, arg5.apparentToRealOffset), arg8, arg9);
        }

        public final void placeWithLayer(Placeable arg5, int arg6, int arg7, GraphicsLayer arg8, float arg9) {
            long v6 = IntOffset.constructor-impl((((long)arg7)) & 0xFFFFFFFFL | (((long)arg6)) << 0x20);
            this.handleMotionFrameOfReferencePlacement(arg5);
            arg5.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(v6, arg5.apparentToRealOffset), arg9, arg8);
        }

        public static void placeWithLayer$default(PlacementScope arg6, Placeable arg7, int arg8, int arg9, float arg10, Function1 arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                if((arg12 & 8) != 0) {
                    arg11 = PlaceableKt.access$getDefaultLayerBlock$p();
                }

                arg6.placeWithLayer(arg7, arg8, arg9, 0f, arg11);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public static void placeWithLayer$default(PlacementScope arg6, Placeable arg7, int arg8, int arg9, GraphicsLayer arg10, float arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                arg6.placeWithLayer(arg7, arg8, arg9, arg10, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer-aW-9-wM(Placeable arg3, long arg4, float arg6, Function1 arg7) {
            this.handleMotionFrameOfReferencePlacement(arg3);
            arg3.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg4, arg3.apparentToRealOffset), arg6, arg7);
        }

        public final void placeWithLayer-aW-9-wM(Placeable arg3, long arg4, GraphicsLayer arg6, float arg7) {
            this.handleMotionFrameOfReferencePlacement(arg3);
            arg3.placeAt-f8xVGno(IntOffset.plus-qkQi6aY(arg4, arg3.apparentToRealOffset), arg7, arg6);
        }

        public static void placeWithLayer-aW-9-wM$default(PlacementScope arg6, Placeable arg7, long arg8, GraphicsLayer arg10, float arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                arg6.placeWithLayer-aW-9-wM(arg7, arg8, arg10, 0f);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        public static void placeWithLayer-aW-9-wM$default(PlacementScope arg6, Placeable arg7, long arg8, float arg10, Function1 arg11, int arg12, Object arg13) {
            if(arg13 == null) {
                if((arg12 & 4) != 0) {
                    arg11 = PlaceableKt.access$getDefaultLayerBlock$p();
                }

                arg6.placeWithLayer-aW-9-wM(arg7, arg8, 0f, arg11);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        public final void withMotionFrameOfReferencePlacement(Function1 arg2) {
            this.motionFrameOfReferencePlacement = true;
            arg2.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }
    }

    public static final int $stable = 8;
    private long apparentToRealOffset;
    private int height;
    private long measuredSize;
    private long measurementConstraints;
    private int width;

    static {
    }

    public Placeable() {
        super();
        this.measuredSize = IntSize.constructor-impl(0);
        this.measurementConstraints = PlaceableKt.access$getDefaultConstraints$p();
        this.apparentToRealOffset = IntOffset.Companion.getZero-nOcc-ac();
    }

    public static final long access$getApparentToRealOffset-nOcc-ac(Placeable arg2) {
        return arg2.apparentToRealOffset;
    }

    public static final void access$placeAt-f8xVGno(Placeable arg0, long arg1, float arg3, GraphicsLayer arg4) {
        arg0.placeAt-f8xVGno(arg1, arg3, arg4);
    }

    public static final void access$placeAt-f8xVGno(Placeable arg0, long arg1, float arg3, Function1 arg4) {
        arg0.placeAt-f8xVGno(arg1, arg3, arg4);
    }

    protected final long getApparentToRealOffset-nOcc-ac() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredHeight() {
        return ((int)(this.measuredSize & 0xFFFFFFFFL));
    }

    protected final long getMeasuredSize-YbymL2g() {
        return this.measuredSize;
    }

    public int getMeasuredWidth() {
        return ((int)(this.measuredSize >> 0x20));
    }

    protected final long getMeasurementConstraints-msEJaDk() {
        return this.measurementConstraints;
    }

    public final int getWidth() {
        return this.width;
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(((int)(this.measuredSize >> 0x20)), Constraints.getMinWidth-impl(this.measurementConstraints), Constraints.getMaxWidth-impl(this.measurementConstraints));
        int v0 = RangesKt.coerceIn(((int)(this.measuredSize & 0xFFFFFFFFL)), Constraints.getMinHeight-impl(this.measurementConstraints), Constraints.getMaxHeight-impl(this.measurementConstraints));
        this.height = v0;
        this.apparentToRealOffset = IntOffset.constructor-impl((((long)((this.width - (((int)(this.measuredSize >> 0x20)))) / 2))) << 0x20 | 0xFFFFFFFFL & (((long)((v0 - (((int)(this.measuredSize & 0xFFFFFFFFL)))) / 2))));
    }

    protected void placeAt-f8xVGno(long arg1, float arg3, GraphicsLayer arg4) {
        this.placeAt-f8xVGno(arg1, arg3, null);
    }

    protected abstract void placeAt-f8xVGno(long arg1, float arg2, Function1 arg3);

    protected final void setMeasuredSize-ozmzZPI(long arg3) {
        if(!IntSize.equals-impl0(this.measuredSize, arg3)) {
            this.measuredSize = arg3;
            this.onMeasuredSizeChanged();
        }
    }

    protected final void setMeasurementConstraints-BRTryo0(long arg3) {
        if(!Constraints.equals-impl0(this.measurementConstraints, arg3)) {
            this.measurementConstraints = arg3;
            this.onMeasuredSizeChanged();
        }
    }
}

