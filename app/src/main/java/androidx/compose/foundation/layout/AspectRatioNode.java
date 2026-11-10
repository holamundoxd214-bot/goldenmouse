package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001C\u0010\u001A\u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u0014\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001BH\u0016J\u001C\u0010\u001F\u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u0014\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001BH\u0016J\u001C\u0010 \u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u0014\u001A\u00020\u001D2\u0006\u0010!\u001A\u00020\u001BH\u0016J\u001C\u0010\"\u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u0014\u001A\u00020\u001D2\u0006\u0010!\u001A\u00020\u001BH\u0016J\u0013\u0010#\u001A\u00020$*\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001B\u0010\'\u001A\u00020$*\u00020\u00172\u0006\u0010(\u001A\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u001B\u0010+\u001A\u00020$*\u00020\u00172\u0006\u0010(\u001A\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001B\u0010-\u001A\u00020$*\u00020\u00172\u0006\u0010(\u001A\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010*J\u001B\u0010/\u001A\u00020$*\u00020\u00172\u0006\u0010(\u001A\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010*R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u00061"}, d2={"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "<init>", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "findSize", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "tryMaxWidth", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxHeight", "tryMaxHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AspectRatioNode extends Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float arg1, boolean arg2) {
        super();
        this.aspectRatio = arg1;
        this.matchHeightConstraintsFirst = arg2;
    }

    private final long findSize-ToXhtMw(long arg8) {
        long v7;
        long v2;
        long v3;
        if(!this.matchHeightConstraintsFirst) {
            v3 = this.tryMaxWidth-JN-0ABg(arg8, true);
            if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                return v3;
            }
            else {
                v3 = this.tryMaxHeight-JN-0ABg(arg8, true);
                if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                    return v3;
                }
                else {
                    v3 = this.tryMinWidth-JN-0ABg(arg8, true);
                    if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                        return v3;
                    }
                    else {
                        v2 = this.tryMinHeight-JN-0ABg(arg8, true);
                        if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                            return v2;
                        }
                        else {
                            v2 = this.tryMaxWidth-JN-0ABg(arg8, false);
                            if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                return v2;
                            }
                            else {
                                v2 = this.tryMaxHeight-JN-0ABg(arg8, false);
                                if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                    return v2;
                                }
                                else {
                                    v2 = this.tryMinWidth-JN-0ABg(arg8, false);
                                    if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                        return v2;
                                    }
                                    else {
                                        v7 = this.tryMinHeight-JN-0ABg(arg8, false);
                                        if(!IntSize.equals-impl0(v7, IntSize.Companion.getZero-YbymL2g())) {
                                            return v7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            v3 = this.tryMaxHeight-JN-0ABg(arg8, true);
            if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                return v3;
            }
            else {
                v3 = this.tryMaxWidth-JN-0ABg(arg8, true);
                if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                    return v3;
                }
                else {
                    v3 = this.tryMinHeight-JN-0ABg(arg8, true);
                    if(!IntSize.equals-impl0(v3, IntSize.Companion.getZero-YbymL2g())) {
                        return v3;
                    }
                    else {
                        v2 = this.tryMinWidth-JN-0ABg(arg8, true);
                        if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                            return v2;
                        }
                        else {
                            v2 = this.tryMaxHeight-JN-0ABg(arg8, false);
                            if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                return v2;
                            }
                            else {
                                v2 = this.tryMaxWidth-JN-0ABg(arg8, false);
                                if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                    return v2;
                                }
                                else {
                                    v2 = this.tryMinHeight-JN-0ABg(arg8, false);
                                    if(!IntSize.equals-impl0(v2, IntSize.Companion.getZero-YbymL2g())) {
                                        return v2;
                                    }
                                    else {
                                        v7 = this.tryMinWidth-JN-0ABg(arg8, false);
                                        if(!IntSize.equals-impl0(v7, IntSize.Companion.getZero-YbymL2g())) {
                                            return v7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return IntSize.Companion.getZero-YbymL2g();
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(arg3 != 0x7FFFFFFF) {
            return Math.round((((float)arg3)) / this.aspectRatio);
        }

        return arg2.maxIntrinsicHeight(arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(arg3 != 0x7FFFFFFF) {
            return Math.round((((float)arg3)) * this.aspectRatio);
        }

        return arg2.maxIntrinsicWidth(arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        long v0 = this.findSize-ToXhtMw(arg10);
        if(!IntSize.equals-impl0(v0, IntSize.Companion.getZero-YbymL2g())) {
            arg10 = Constraints.Companion.fixed-JhjzzOo(((int)(v0 >> 0x20)), ((int)(v0 & 0xFFFFFFFFL)));
        }

        Placeable v7 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v7.getWidth(), v7.getHeight(), null, new AspectRatioNode$$ExternalSyntheticLambda0(v7), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(arg3 != 0x7FFFFFFF) {
            return Math.round((((float)arg3)) / this.aspectRatio);
        }

        return arg2.minIntrinsicHeight(arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(arg3 != 0x7FFFFFFF) {
            return Math.round((((float)arg3)) * this.aspectRatio);
        }

        return arg2.minIntrinsicWidth(arg3);
    }

    public final void setAspectRatio(float arg1) {
        this.aspectRatio = arg1;
    }

    public final void setMatchHeightConstraintsFirst(boolean arg1) {
        this.matchHeightConstraintsFirst = arg1;
    }

    private final long tryMaxHeight-JN-0ABg(long arg3, boolean arg5) {
        int v0 = Constraints.getMaxHeight-impl(arg3);
        if(v0 != 0x7FFFFFFF) {
            int v2 = Math.round((((float)v0)) * this.aspectRatio);
            if(v2 > 0) {
                if((arg5) && !AspectRatioKt.isSatisfiedBy-NN6Ew-U(arg3, v2, v0)) {
                    goto label_20;
                }

                return IntSize.constructor-impl((((long)v2)) << 0x20 | (((long)v0)) & 0xFFFFFFFFL);
            }
        }

    label_20:
        return IntSize.Companion.getZero-YbymL2g();
    }

    private final long tryMaxWidth-JN-0ABg(long arg5, boolean arg7) {
        int v0 = Constraints.getMaxWidth-impl(arg5);
        if(v0 != 0x7FFFFFFF) {
            int v4 = Math.round((((float)v0)) / this.aspectRatio);
            if(v4 > 0) {
                if((arg7) && !AspectRatioKt.isSatisfiedBy-NN6Ew-U(arg5, v0, v4)) {
                    goto label_20;
                }

                return IntSize.constructor-impl((((long)v0)) << 0x20 | (((long)v4)) & 0xFFFFFFFFL);
            }
        }

    label_20:
        return IntSize.Companion.getZero-YbymL2g();
    }

    private final long tryMinHeight-JN-0ABg(long arg3, boolean arg5) {
        int v0 = Constraints.getMinHeight-impl(arg3);
        int v2 = Math.round((((float)v0)) * this.aspectRatio);
        if(v2 > 0 && (!arg5 || (AspectRatioKt.isSatisfiedBy-NN6Ew-U(arg3, v2, v0)))) {
            return IntSize.constructor-impl((((long)v2)) << 0x20 | (((long)v0)) & 0xFFFFFFFFL);
        }

        return IntSize.Companion.getZero-YbymL2g();
    }

    private final long tryMinWidth-JN-0ABg(long arg5, boolean arg7) {
        int v0 = Constraints.getMinWidth-impl(arg5);
        int v4 = Math.round((((float)v0)) / this.aspectRatio);
        if(v4 > 0 && (!arg7 || (AspectRatioKt.isSatisfiedBy-NN6Ew-U(arg5, v0, v4)))) {
            return IntSize.constructor-impl((((long)v0)) << 0x20 | (((long)v4)) & 0xFFFFFFFFL);
        }

        return IntSize.Companion.getZero-YbymL2g();
    }
}

