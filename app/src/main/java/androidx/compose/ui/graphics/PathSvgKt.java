package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\u0005\u001A\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u001A\u0018\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0002¨\u0006\f"}, d2={"addSvg", "", "Landroidx/compose/ui/graphics/Path;", "pathData", "", "toSvg", "asDocument", "", "command", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "lastType", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathSvgKt {
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

    public static final void addSvg(Path arg1, String arg2) {
        new PathParser().parsePathString(arg2).toPath(arg1);
    }

    private static final String command(Type arg0, Type arg1) {
        if(arg0 != arg1) {
            int v0 = WhenMappings.$EnumSwitchMapping$0[arg0.ordinal()];
            if(v0 != 1) {
                if(v0 != 2) {
                    if(v0 != 3) {
                        if(v0 != 5) {
                            if(v0 != 6) {
                                return "";
                            }

                            return "Z";
                        }

                        return "C";
                    }

                    return "Q";
                }

                return "L";
            }

            return "M";
        }

        return " ";
    }

    public static final String toSvg(Path arg13, boolean arg14) {
        StringBuilder v13_1;
        StringBuilder v0 = new StringBuilder();
        Rect v1 = arg13.getBounds();
        char v2 = '\n';
        String v3 = "append(...)";
        char v4 = ' ';
        if(arg14) {
            v0.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
            StringBuilder v1_1 = v0.append("viewBox=\"" + v1.getLeft() + v4 + v1.getTop() + v4 + (v1.getRight() - v1.getLeft()) + v4 + (v1.getBottom() - v1.getTop()) + "\">");
            Intrinsics.checkNotNullExpressionValue(v1_1, v3);
            Intrinsics.checkNotNullExpressionValue(v1_1.append(v2), v3);
        }

        PathIterator v1_2 = arg13.iterator();
        float[] v5 = new float[8];
        Type v6 = Type.Done;
        if(v1_2.hasNext()) {
            if(arg14) {
                if(PathFillType.equals-impl0(arg13.getFillType-Rg-k1Os(), PathFillType.Companion.getEvenOdd-Rg-k1Os())) {
                    v0.append("  <path fill-rule=\"evenodd\" d=\"");
                }
                else {
                    v0.append("  <path d=\"");
                }
            }

        label_51:
            while(v1_2.hasNext()) {
                int v8 = 2;
                Type v13 = PathIterator.next$default(v1_2, v5, 0, v8, null);
                int v10 = 5;
                int v11 = 4;
                int v12 = 3;
                switch(WhenMappings.$EnumSwitchMapping$0[v13.ordinal()]) {
                    case 1: {
                        goto label_138;
                    }
                    case 2: {
                        goto label_125;
                    }
                    case 3: {
                        goto label_106;
                    }
                    case 5: {
                        goto label_71;
                    }
                    case 6: {
                        goto label_67;
                    }
                    case 4: 
                    case 7: {
                        goto label_51;
                    }
                }

                throw new NoWhenBranchMatchedException();
            label_67:
                v0.append(PathSvgKt.command(Type.Close, v6));
                goto label_151;
            label_71:
                v0.append(PathSvgKt.command(Type.Cubic, v6));
                v0.append(v5[v8] + v4 + v5[v12] + v4);
                v0.append(v5[v11] + v4 + v5[v10] + v4);
                v0.append(v5[6] + v4 + v5[7]);
                goto label_151;
            label_138:
                v0.append(PathSvgKt.command(Type.Move, v6) + v5[0] + v4 + v5[1]);
                goto label_151;
            label_106:
                v0.append(PathSvgKt.command(Type.Quadratic, v6));
                v0.append(v5[v8] + v4 + v5[v12] + v4 + v5[v11] + v4 + v5[v10]);
                goto label_151;
            label_125:
                v0.append(PathSvgKt.command(Type.Line, v6) + v5[v8] + v4 + v5[v12]);
            label_151:
                v6 = v13;
            }

            if(!arg14) {
                goto label_159;
            }

            v13_1 = v0.append("\"/>");
            Intrinsics.checkNotNullExpressionValue(v13_1, v3);
            Intrinsics.checkNotNullExpressionValue(v13_1.append(v2), v3);
        }

    label_159:
        if(arg14) {
            v13_1 = v0.append("</svg>");
            Intrinsics.checkNotNullExpressionValue(v13_1, v3);
            Intrinsics.checkNotNullExpressionValue(v13_1.append(v2), v3);
        }

        String v13_2 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v13_2, "toString(...)");
        return v13_2;
    }

    public static String toSvg$default(Path arg0, boolean arg1, int arg2, Object arg3) {
        return PathSvgKt.toSvg(arg0, false);
    }
}

