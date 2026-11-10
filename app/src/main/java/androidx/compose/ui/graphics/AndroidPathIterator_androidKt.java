package androidx.compose.ui.graphics;

import androidx.graphics.path.PathSegment$Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\"\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u001A\f\u0010\b\u001A\u00020\t*\u00020\nH\u0002¨\u0006\u000B"}, d2={"PathIterator", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "toPathSegmentType", "Landroidx/compose/ui/graphics/PathSegment$Type;", "Landroidx/graphics/path/PathSegment$Type;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidPathIterator_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Type.values().length];
            try {
                v0[Type.Move.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Type.Line.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Type.Quadratic.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Type.Conic.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[Type.Cubic.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[Type.Close.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[Type.Done.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final PathIterator PathIterator(Path arg1, ConicEvaluation arg2, float arg3) {
        return new AndroidPathIterator(arg1, arg2, arg3);
    }

    public static PathIterator PathIterator$default(Path arg0, ConicEvaluation arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = ConicEvaluation.AsQuadratics;
        }

        if((arg3 & 4) != 0) {
            arg2 = 0.25f;
        }

        return AndroidPathIterator_androidKt.PathIterator(arg0, arg1, arg2);
    }

    public static final androidx.compose.ui.graphics.PathSegment$Type access$toPathSegmentType(Type arg0) {
        return AndroidPathIterator_androidKt.toPathSegmentType(arg0);
    }

    private static final androidx.compose.ui.graphics.PathSegment$Type toPathSegmentType(Type arg1) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()]) {
            case 1: {
                goto label_19;
            }
            case 2: {
                goto label_17;
            }
            case 3: {
                goto label_15;
            }
            case 4: {
                goto label_13;
            }
            case 5: {
                goto label_11;
            }
            case 6: {
                goto label_9;
            }
            case 7: {
                goto label_7;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_17:
        return androidx.compose.ui.graphics.PathSegment$Type.Line;
    label_19:
        return androidx.compose.ui.graphics.PathSegment$Type.Move;
    label_7:
        return androidx.compose.ui.graphics.PathSegment$Type.Done;
    label_9:
        return androidx.compose.ui.graphics.PathSegment$Type.Close;
    label_11:
        return androidx.compose.ui.graphics.PathSegment$Type.Cubic;
    label_13:
        return androidx.compose.ui.graphics.PathSegment$Type.Conic;
    label_15:
        return androidx.compose.ui.graphics.PathSegment$Type.Quadratic;
    }
}

