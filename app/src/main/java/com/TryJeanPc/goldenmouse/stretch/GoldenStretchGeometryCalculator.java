package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0018\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u000FH\u0002J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000FH\u0002¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/GoldenStretchGeometryCalculator;", "", "<init>", "()V", "calculate", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;", "factorHundredths", "", "validateRectangle", "Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "rect", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "bounds", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "projection", "Lcom/TryJeanPc/goldenmouse/stretch/StretchProjection;", "target", "positive", "", "size", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchGeometryCalculator {
    public static final int $stable;

    static {
    }

    public GoldenStretchGeometryCalculator() {
        super();
    }

    public final StretchCalculation calculate(StretchDisplaySnapshot arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg12, "snapshot");
        int v0 = 100;
        if(v0 <= arg13 && arg13 < 200) {
            StretchDisplayIdentity v3 = arg12.getIdentity();
            if(v3 == null) {
                return new Insufficient(StretchIssue.MISSING_IDENTITY);
            }
            else if(v3.getLogicalId() < 0) {
                return new Invalid(StretchIssue.INVALID_IDENTITY);
            }
            else {
                StretchSize v4 = arg12.getLogicalSize();
                if(v4 == null) {
                    return new Insufficient(StretchIssue.MISSING_LOGICAL_SIZE);
                }
                else {
                    if(this.positive(v4)) {
                        StretchSize v1 = arg12.getModeReference();
                        if(v1 != null && (this.positive(v1) ^ 1) == 1) {
                            goto label_95;
                        }

                        if(arg12.getRotation() != null && !new IntRange(0, 3).contains(arg12.getRotation().intValue())) {
                            return new Invalid(StretchIssue.INVALID_ROTATION);
                        }

                        int v1_1 = Math.max(v4.getWidth(), v4.getHeight());
                        int v2 = Math.min(v4.getWidth(), v4.getHeight());
                        long v5 = ((long)v1_1);
                        long v7 = (100 * v5 + (((long)(arg13 / 2)))) / (((long)arg13));
                        if(1 <= v7 && v7 <= v5) {
                            if(arg13 > v0 && v7 <= (((long)v2))) {
                                return new Unsupported(StretchIssue.LONG_AXIS_COLLAPSED);
                            }

                            StretchSize v0_1 = v4.getWidth() >= v4.getHeight() ? new StretchSize(((int)v7), v2) : new StretchSize(v2, ((int)v7));
                            return new Valid(new StretchGeometryPlan(v3, v4, arg12.getModeReference(), arg12.getRotation(), arg13, v0_1, this.projection(arg12, v0_1)));
                        }

                        return new Invalid(StretchIssue.ARITHMETIC_OUT_OF_RANGE);
                    }

                label_95:
                    return new Invalid(StretchIssue.INVALID_DIMENSIONS);
                }
            }
        }

        return new Invalid(StretchIssue.INVALID_FACTOR);
    }

    private final boolean positive(StretchSize arg1) {
        if(arg1.getWidth() > 0 && arg1.getHeight() > 0) {
            return 1;
        }

        return 0;
    }

    private final StretchProjection projection(StretchDisplaySnapshot arg7, StretchSize arg8) {
        Integer v0 = arg7.getRotation();
        if(v0 != null) {
            int v0_1 = v0.intValue();
            if(CollectionsKt.listOf(new Integer[]{Integer.valueOf(1), Integer.valueOf(3)}).contains(Integer.valueOf(v0_1))) {
                if(arg8.getWidth() <= arg8.getHeight()) {
                }
                else {
                    StretchSize v7 = arg7.getModeReference();
                    if(v7 == null) {
                        return new com.TryJeanPc.goldenmouse.stretch.StretchProjection$Insufficient(StretchIssue.MISSING_MODE_REFERENCE);
                    }
                    else if(v7.getWidth() == v7.getHeight()) {
                        return new com.TryJeanPc.goldenmouse.stretch.StretchProjection$Unsupported(StretchIssue.MODE_REFERENCE_ASPECT);
                    }
                    else {
                        StretchSize v1 = new StretchSize(Math.max(v7.getWidth(), v7.getHeight()), Math.min(v7.getWidth(), v7.getHeight()));
                        StretchRect v7_1 = new StretchRect(0, 0, arg8.getWidth(), arg8.getHeight());
                        StretchRect v2 = new StretchRect(0, 0, v1.getWidth(), v1.getHeight());
                        if(this.validateRectangle(v7_1, arg8) == null && this.validateRectangle(v2, v1) == null) {
                            return new Defined(new StretchFullProjection(v7_1, v2, v0_1));
                        }

                        throw new IllegalStateException("Check failed.");
                    }
                }
            }

            return new com.TryJeanPc.goldenmouse.stretch.StretchProjection$Unsupported(StretchIssue.PROJECTION_ORIENTATION);
        }

        return new com.TryJeanPc.goldenmouse.stretch.StretchProjection$Insufficient(StretchIssue.MISSING_ROTATION);
    }

    public final StretchIssue validateRectangle(StretchRect arg2, StretchSize arg3) {
        Intrinsics.checkNotNullParameter(arg2, "rect");
        Intrinsics.checkNotNullParameter(arg3, "bounds");
        if(!this.positive(arg3)) {
            return StretchIssue.INVALID_DIMENSIONS;
        }

        if(arg2.getLeft() >= 0 && arg2.getTop() >= 0 && arg2.getRight() > arg2.getLeft() && arg2.getBottom() > arg2.getTop() && arg2.getRight() <= arg3.getWidth()) {
            if(arg2.getBottom() > arg3.getHeight()) {
            }
            else {
                return null;
            }
        }

        return StretchIssue.INVALID_RECTANGLE;
    }
}

