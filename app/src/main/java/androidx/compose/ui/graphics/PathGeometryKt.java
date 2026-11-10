package androidx.compose.ui.graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A \u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00022\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004\u001A\u0014\u0010\u0006\u001A\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u0002\u001A\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002¨\u0006\f"}, d2={"computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", "destination", "floatCountForType", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathGeometryKt {
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

    public static final Direction computeDirection(Path arg32) {
        PathIterator v0 = arg32.iterator();
        float[] v1 = new float[8];
        int v3 = 2;
        Object v4 = null;
        Type v5 = PathIterator.next$default(v0, v1, 0, v3, v4);
        int v8 = 1;
        float v9 = 0f;
        float v10 = 0f;
        float v11 = 0f;
        float v14 = 0f;
        float v15 = 0f;
    label_15:
        while(v5 != Type.Done) {
            int v13 = 5;
            int v16 = 4;
            int v17 = 3;
            switch(WhenMappings.$EnumSwitchMapping$0[v5.ordinal()]) {
                case 1: {
                    goto label_103;
                }
                case 2: {
                    goto label_89;
                }
                case 3: {
                    goto label_63;
                }
                case 4: {
                    goto label_15;
                }
                case 5: {
                    goto label_44;
                }
                case 6: {
                    goto label_27;
                }
                case 7: {
                    goto label_112;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_103:
            if(v8 == 0) {
            }
            else {
                v14 = v1[0];
                v15 = v1[1];
                v8 = 0;
                goto label_110;
            label_89:
                float v24 = v1[0];
                float v25 = v1[1];
                float v28 = v1[v3];
                float v29 = v1[v17];
                v9 += BezierKt.cubicArea(v24, v25, v24, v25, v28, v29, v28, v29);
                v10 = v28;
                v11 = v29;
                goto label_110;
            label_27:
                float v12 = 0.000001f;
                if(Math.abs(v10 - v14) < v12 && Math.abs(v11 - v15) < v12) {
                }
                else {
                    v9 += BezierKt.cubicArea(v10, v11, v10, v11, v14, v15, v14, v15);
                    v10 = v14;
                    v11 = v15;
                    goto label_110;
                label_44:
                    v9 += BezierKt.cubicArea(v1[0], v1[1], v1[v3], v1[v17], v1[v16], v1[v13], v1[6], v1[7]);
                    float v5_1 = v1[6];
                    v11 = v1[7];
                    v10 = v5_1;
                    goto label_110;
                label_63:
                    int v5_2 = v16;
                    int v10_1 = v17;
                    float v16_1 = v1[0];
                    float v17_1 = v1[1];
                    v11 = v1[v3];
                    v10 = v1[v10_1];
                    float v22 = v1[v5_2];
                    float v23 = v1[v13];
                    v9 += BezierKt.cubicArea(v16_1, v17_1, v16_1 + (v11 - v16_1) * 0.666667f, v17_1 + (v10 - v17_1) * 0.666667f, v22 + (v11 - v22) * 0.666667f, v23 + (v10 - v23) * 0.666667f, v22, v23);
                    v10 = v22;
                    v11 = v23;
                }

            label_110:
                v5 = PathIterator.next$default(v0, v1, 0, v3, v4);
                continue;
            }

            break;
        }

    label_112:
        if(v9 >= 0f) {
            return Direction.Clockwise;
        }

        return Direction.CounterClockwise;
    }

    public static final List divide(Path arg14, List arg15) {
        Path v0 = AndroidPath_androidKt.Path();
        PathIterator v14 = arg14.iterator();
        float[] v1 = new float[8];
        int v3 = 2;
        Object v4 = null;
        Type v5 = PathIterator.next$default(v14, v1, 0, v3, v4);
        Path v7 = v0;
        int v0_1 = 1;
        int v8 = 1;
    label_12:
        while(v5 != Type.Done) {
            int v10 = 5;
            int v11 = 4;
            int v12 = 3;
            switch(WhenMappings.$EnumSwitchMapping$0[v5.ordinal()]) {
                case 1: {
                    goto label_49;
                }
                case 2: {
                    goto label_44;
                }
                case 3: {
                    goto label_37;
                }
                case 5: {
                    goto label_26;
                }
                case 6: {
                    goto label_24;
                }
                case 4: 
                case 7: {
                    goto label_12;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_49:
            if(v0_1 == 0 && v8 == 0) {
                arg15.add(v7);
                v7 = AndroidPath_androidKt.Path();
            }

            v7.moveTo(v1[0], v1[1]);
            v0_1 = 0;
            v8 = 1;
            goto label_58;
        label_37:
            v7.quadraticTo(v1[v3], v1[v12], v1[v11], v1[v10]);
            goto label_47;
        label_24:
            v7.close();
            goto label_58;
        label_26:
            v7.cubicTo(v1[v3], v1[v12], v1[v11], v1[v10], v1[6], v1[7]);
            goto label_47;
        label_44:
            v7.lineTo(v1[v3], v1[v12]);
        label_47:
            v8 = 0;
        label_58:
            v5 = PathIterator.next$default(v14, v1, 0, v3, v4);
        }

        if(v0_1 == 0 && v8 == 0) {
            arg15.add(v7);
        }

        return arg15;
    }

    public static List divide$default(Path arg0, List arg1, int arg2, Object arg3) {
        ArrayList v1;
        if((arg2 & 1) != 0) {
            v1 = new ArrayList();
        }

        return PathGeometryKt.divide(arg0, ((List)v1));
    }

    private static final int floatCountForType(Type arg2) {
        int v1 = 8;
        switch(WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()]) {
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 6;
            }
            case 4: 
            case 5: {
                return v1;
            }
            case 6: 
            case 7: {
                return 0;
            }
        }

        throw new NoWhenBranchMatchedException();
        return 0;
    }

    public static final Path reverse(Path arg16, Path arg17) {
        int v15;
        int v3_1;
        Object v2_2;
        Path v0 = arg17;
        PathIterator v1 = arg16.iterator();
        int v2 = v1.calculateSize(false);
        ArrayList v8 = new ArrayList(v2);
        ArrayList v9 = new ArrayList(v2);
        float[] v2_1 = new float[8];
        int v10 = 2;
        Object v3 = null;
        Type v4;
        for(v4 = PathIterator.next$default(v1, v2_1, 0, v10, v3); v4 != Type.Done; v4 = PathIterator.next$default(v1, v2_1, 0, v10, v3)) {
            v8.add(v4);
            if(v4 != Type.Close) {
                float[] v4_1 = Arrays.copyOf(v2_1, PathGeometryKt.floatCountForType(v4));
                Intrinsics.checkNotNullExpressionValue(v4_1, "copyOf(...)");
                v9.add(v4_1);
            }
        }

        int v1_1 = v9.size();
        int v12 = v8.size() - 1;
        int v13 = 0;
        v2 = 1;
        while(-1 < v12) {
            if(v2 != 0) {
                --v1_1;
                v2_2 = v9.get(v1_1);
                v3_1 = ArraysKt.getLastIndex(((float[])v2_2));
                v0.moveTo(v2_2[v3_1 - 1], v2_2[v3_1]);
                v15 = 0;
            }
            else {
                v15 = v2;
                v2_2 = v9.get(v1_1);
            }

            int v14 = v1_1;
            v3_1 = 3;
            switch(WhenMappings.$EnumSwitchMapping$0[v8.get(v12).ordinal()]) {
                case 1: {
                    goto label_88;
                }
                case 2: {
                    goto label_80;
                }
                case 3: {
                    goto label_72;
                }
                case 5: {
                    goto label_59;
                }
                case 6: {
                    goto label_57;
                }
                case 4: 
                case 7: {
                    goto label_85;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_88:
            if(v13 != 0) {
                v0.close();
                v13 = 0;
            }

            v2 = 1;
            v1_1 = v14;
            goto label_93;
        label_72:
            v0.quadraticTo(v2_2[v10], v2_2[v3_1], v2_2[0], v2_2[1]);
            goto label_84;
        label_57:
            v13 = 1;
            goto label_85;
        label_59:
            v0.cubicTo(v2_2[4], v2_2[5], v2_2[v10], v2_2[v3_1], v2_2[0], v2_2[1]);
            goto label_84;
        label_80:
            v0.lineTo(v2_2[0], v2_2[1]);
        label_84:
            --v14;
        label_85:
            v1_1 = v14;
            v2 = v15;
        label_93:
            --v12;
        }

        if(v13 != 0) {
            v0.close();
        }

        return v0;
    }

    public static Path reverse$default(Path arg0, Path arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = AndroidPath_androidKt.Path();
        }

        return PathGeometryKt.reverse(arg0, arg1);
    }
}

