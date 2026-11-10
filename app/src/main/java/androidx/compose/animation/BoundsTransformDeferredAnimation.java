package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001E\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001D\u0010\u001F\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\t¢\u0006\u0004\b!\u0010\"J6\u00102\u001A\u00020\u00102\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u0002082\u0006\u00109\u001A\u00020\u000E2\u0006\u0010:\u001A\u00020\u000E2\u0006\u0010;\u001A\u00020<J\u0018\u0010=\u001A\u00020\u00062\u0006\u00107\u001A\u0002082\u0006\u0010;\u001A\u00020<H\u0002R\u001C\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u00020\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\u001C\u0010\u0018\u001A\u00020\tX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\n\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u0013R\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010#\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b#\u0010$R/\u0010&\u001A\u0004\u0018\u00010\u00062\b\u0010%\u001A\u0004\u0018\u00010\u00068B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b\'\u0010\u001E\"\u0004\b(\u0010)R\u0013\u0010,\u001A\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001A\u0004\b-\u0010\u001ER\u0016\u0010.\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00101\u001A\u00020\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\n¨\u0006>"}, d2={"Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "", "<init>", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "targetSize", "Landroidx/compose/ui/geometry/Size;", "J", "targetOffset", "Landroidx/compose/ui/geometry/Offset;", "isPending", "", "updateTargetSize", "", "size", "updateTargetSize-uvyYCjk", "(J)V", "updateTargetOffset", "offset", "updateTargetOffset-k-4lQ0M", "currentPosition", "currentSize", "getCurrentSize-NH-jbRc", "()J", "setCurrentSize-uvyYCjk", "currentBounds", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "updateCurrentBounds", "position", "updateCurrentBounds-tz77jQw", "(JJ)V", "isIdle", "()Z", "<set-?>", "animatedValue", "getAnimatedValue", "setAnimatedValue", "(Landroidx/compose/ui/geometry/Rect;)V", "animatedValue$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "directManipulationParents", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "additionalOffset", "updateTargetOffsetAndAnimate", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directManipulationParentsDirty", "includeMotionFrameOfReference", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animate", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoundsTransformDeferredAnimation {
    public static final int $stable = 8;
    private long additionalOffset;
    private Animatable animatable;
    private final MutableState animatedValue$delegate;
    private long currentPosition;
    private long currentSize;
    private List directManipulationParents;
    private boolean isPending;
    private long targetOffset;
    private long targetSize;

    static {
    }

    public BoundsTransformDeferredAnimation() {
        super();
        this.targetSize = Size.Companion.getUnspecified-NH-jbRc();
        this.targetOffset = Offset.Companion.getUnspecified-F1C5BW0();
        this.currentPosition = Offset.Companion.getUnspecified-F1C5BW0();
        this.currentSize = Size.Companion.getUnspecified-NH-jbRc();
        this.animatedValue$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.additionalOffset = Offset.Companion.getZero-F1C5BW0();
    }

    private final Rect animate(CoroutineScope arg14, BoundsTransform arg15) {
        long v0 = this.targetOffset;
        long v4 = 0x7FC000007FC00000L;
        if((0x7FFFFFFF7FFFFFFFL & v0) != v4) {
            long v2 = this.targetSize;
            if(v2 != v4) {
                Rect v6 = RectKt.Rect-tz77jQw(v0, v2);
                Animatable v0_1 = this.animatable;
                if(v0_1 == null) {
                    v0_1 = new Animatable(v6, VectorConvertersKt.getVectorConverter(Rect.Companion), null, null, 12, null);
                }

                this.animatable = v0_1;
                if(!this.isPending) {
                    goto label_39;
                }

                this.isPending = false;
                BuildersKt.launch$default(arg14, null, CoroutineStart.UNDISPATCHED, new BoundsTransformDeferredAnimation$animate$1(v0_1, v6, arg15, this, null), 1, null);
            }
        }

    label_39:
        Animatable v13 = this.animatable;
        if(v13 != null) {
            Object v13_1 = v13.getValue();
            if(v13_1 == null) {
            }
            else {
                return ((Rect)v13_1);
            }
        }

        return Rect.Companion.getZero();
    }

    private final Rect getAnimatedValue() {
        return this.animatedValue$delegate.getValue();
    }

    public final Rect getCurrentBounds() {
        long v0 = this.currentSize;
        long v2 = this.currentPosition;
        long v6 = 0x7FC000007FC00000L;
        if((0x7FFFFFFF7FFFFFFFL & v2) != v6 && v0 != v6) {
            return RectKt.Rect-tz77jQw(v2, v0);
        }

        return null;
    }

    public final long getCurrentSize-NH-jbRc() {
        return this.currentSize;
    }

    public final Rect getValue() {
        if(this.isIdle()) {
            return null;
        }

        return this.getAnimatedValue();
    }

    public final boolean isIdle() {
        if(!this.isPending) {
            Animatable v1 = this.animatable;
            if(v1 != null && (v1.isRunning())) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final void setAnimatedValue(Rect arg1) {
        this.animatedValue$delegate.setValue(arg1);
    }

    public final void setCurrentSize-uvyYCjk(long arg1) {
        this.currentSize = arg1;
    }

    public final void updateCurrentBounds-tz77jQw(long arg1, long arg3) {
        this.currentPosition = arg1;
        this.currentSize = arg3;
    }

    private final void updateTargetOffset-k-4lQ0M(long arg9) {
        long v2 = 0x7FFFFFFF7FFFFFFFL;
        long v4 = 0x7FC000007FC00000L;
        if((this.targetOffset & v2) != v4 && !IntOffset.equals-impl0(IntOffsetKt.round-k-4lQ0M(arg9), IntOffsetKt.round-k-4lQ0M(this.targetOffset))) {
            this.isPending = true;
        }

        this.targetOffset = arg9;
        if((this.currentPosition & v2) == v4) {
            this.currentPosition = arg9;
        }
    }

    public final void updateTargetOffsetAndAnimate(LookaheadScope arg9, PlacementScope arg10, CoroutineScope arg11, boolean arg12, boolean arg13, BoundsTransform arg14) {
        LayoutCoordinates v2 = arg10.getCoordinates();
        if(v2 != null) {
            LayoutCoordinates v1 = arg9.getLookaheadScopeCoordinates(arg10);
            long v3 = Offset.Companion.getZero-F1C5BW0();
            if(!arg13 && (arg12)) {
                List v10 = this.directManipulationParents;
                if(v10 == null) {
                    ArrayList v10_1 = new ArrayList();
                }

                int v12 = 0;
                LayoutCoordinates v0 = v2;
                do {
                    if(Intrinsics.areEqual(arg9.toLookaheadCoordinates(v0), v1)) {
                        break;
                    }

                    if(v0.getIntroducesMotionFrameOfReference()) {
                        if(v10.size() == v12) {
                            v10.add(v0);
                            v3 = Offset.plus-MK-Hz9U(v3, LayoutCoordinatesKt.positionInParent(v0));
                        }
                        else if(!Intrinsics.areEqual(v10.get(v12), v0)) {
                            v3 = Offset.minus-MK-Hz9U(v3, LayoutCoordinatesKt.positionInParent(v10.get(v12)));
                            v10.set(v12, v0);
                            v3 = Offset.plus-MK-Hz9U(v3, LayoutCoordinatesKt.positionInParent(v0));
                        }

                        ++v12;
                    }

                    v0 = v0.getParentCoordinates();
                }
                while(v0 != null);

                int v0_1 = v10.size() - 1;
                if(v12 <= v0_1) {
                    while(true) {
                        v3 = Offset.minus-MK-Hz9U(v3, LayoutCoordinatesKt.positionInParent(v10.get(v0_1)));
                        v10.remove(v10.size() - 1);
                        if(v0_1 != v12) {
                            --v0_1;
                            continue;
                        }

                        break;
                    }
                }

                this.directManipulationParents = v10;
            }

            this.additionalOffset = Offset.plus-MK-Hz9U(this.additionalOffset, v3);
            this.updateTargetOffset-k-4lQ0M(Offset.plus-MK-Hz9U(LookaheadScope.localLookaheadPositionOf-au-aQtc$default(arg9, v1, v2, 0, arg13, 2, null), this.additionalOffset));
            this.setAnimatedValue(this.animate(arg11, arg14).translate-k-4lQ0M(Offset.constructor-impl(this.additionalOffset ^ -9223372034707292160L)));
        }
    }

    public final void updateTargetSize-uvyYCjk(long arg7) {
        long v2 = 0x7FC000007FC00000L;
        if(this.targetSize != v2 && !IntSize.equals-impl0(IntSizeKt.roundToIntSize-uvyYCjk(arg7), IntSizeKt.roundToIntSize-uvyYCjk(this.targetSize))) {
            this.isPending = true;
        }

        this.targetSize = arg7;
        if(this.currentSize == v2) {
            this.currentSize = arg7;
        }
    }
}

