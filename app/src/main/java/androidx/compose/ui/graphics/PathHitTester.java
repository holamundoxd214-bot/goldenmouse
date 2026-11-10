package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u0007J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/ui/graphics/PathHitTester;", "", "<init>", "()V", "path", "Landroidx/compose/ui/graphics/Path;", "tolerance", "", "bounds", "Landroidx/compose/ui/geometry/Rect;", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "curves", "", "roots", "updatePath", "", "contains", "", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathHitTester {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Type.values().length];
            try {
                v0[Type.Line.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Type.Quadratic.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Type.Cubic.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Type.Done.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private Rect bounds;
    private final float[] curves;
    private final IntervalTree intervals;
    private Path path;
    private final float[] roots;
    private float tolerance;

    static {
    }

    public PathHitTester() {
        super();
        this.path = PathHitTesterKt.access$getEmptyPath$p();
        this.tolerance = 0.5f;
        this.bounds = Rect.Companion.getZero();
        this.intervals = new IntervalTree();
        this.curves = new float[20];
        this.roots = new float[2];
    }

    public final boolean contains-k-4lQ0M(long arg12) {
        int v5;
        if(!this.path.isEmpty()) {
            if(!this.bounds.contains-k-4lQ0M(arg12)) {
            }
            else {
                float v0 = Float.intBitsToFloat(((int)(arg12 >> 0x20)));
                float v12 = Float.intBitsToFloat(((int)(arg12 & 0xFFFFFFFFL)));
                float[] v13 = this.curves;
                float[] v2 = this.roots;
                IntervalTree v3 = this.intervals;
                if(v3.root != v3.terminator) {
                    ArrayList v4 = v3.stack;
                    v4.add(v3.root);
                    v5 = 0;
                    while(v4.size() > 0) {
                        Object v7 = v4.remove(v4.size() - 1);
                        if(((Node)v7).overlaps(v12, v12)) {
                            Object v8 = v7.getData();
                            Intrinsics.checkNotNull(v8);
                            float[] v9 = ((PathSegment)v8).getPoints();
                            int v8_1 = WhenMappings.$EnumSwitchMapping$0[((PathSegment)v8).getType().ordinal()];
                            if(v8_1 == 1) {
                                v8_1 = BezierKt.lineWinding(v9, v0, v12);
                            }
                            else if(v8_1 == 2) {
                                v8_1 = BezierKt.quadraticWinding(v9, v0, v12, v13, v2);
                            }
                            else if(v8_1 != 3) {
                                goto label_55;
                            }
                            else {
                                v8_1 = BezierKt.cubicWinding(v9, v0, v12, v13, v2);
                            }

                            v5 += v8_1;
                        }

                    label_55:
                        if(((Node)v7).getLeft() != v3.terminator && ((Node)v7).getLeft().getMax() >= v12) {
                            v4.add(((Node)v7).getLeft());
                        }

                        if(((Node)v7).getRight() == v3.terminator) {
                            continue;
                        }

                        if(((Node)v7).getRight().getMin() > v12) {
                            continue;
                        }

                        v4.add(((Node)v7).getRight());
                    }

                    v4.clear();
                }
                else {
                    v5 = 0;
                }

                if(PathFillType.equals-impl0(this.path.getFillType-Rg-k1Os(), PathFillType.Companion.getEvenOdd-Rg-k1Os())) {
                    v5 &= 1;
                }

                if(v5 == 0) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final void updatePath(Path arg6, float arg7) {
        this.path = arg6;
        this.tolerance = arg7;
        this.bounds = arg6.getBounds();
        this.intervals.clear();
        PathIterator v6 = arg6.iterator(ConicEvaluation.AsQuadratics, arg7);
        while(v6.hasNext()) {
            PathSegment v7 = v6.next();
            int v0 = WhenMappings.$EnumSwitchMapping$0[v7.getType().ordinal()];
            int v2 = 4;
            if(v0 != 1 && v0 != 2 && v0 != 3) {
                if(v0 != v2) {
                    continue;
                }
                else {
                    return;
                }
            }

            long v0_1 = BezierKt.computeVerticalBounds$default(v7, this.curves, 0, v2, null);
            this.intervals.addInterval(Float.intBitsToFloat(((int)(v0_1 >> 0x20))), Float.intBitsToFloat(((int)(v0_1 & 0xFFFFFFFFL))), v7);
        }
    }

    public static void updatePath$default(PathHitTester arg0, Path arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 0.5f;
        }

        arg0.updatePath(arg1, arg2);
    }
}

