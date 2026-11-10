package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0000\u001Ai\u0010\u000B\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n28\b\u0004\u0010\u000E\u001A2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u000FH\u0082\b\u001A&\u0010\u0014\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002\u001A&\u0010\u0015\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002\"\u000E\u0010\u0016\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0018\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0019\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001B\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001F\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010 \u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010!\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010%\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010&\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\'\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010(\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010)\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010*\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010+\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010,\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010-\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010.\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010/\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00100\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00102\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2={"addPathNodes", "", "", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "args", "", "count", "", "pathNodesFromArgs", "", "numArgs", "nodeFor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subArray", "start", "pathMoveNodeFromArgs", "pathRelativeMoveNodeFromArgs", "RelativeCloseKey", "CloseKey", "RelativeMoveToKey", "MoveToKey", "RelativeLineToKey", "LineToKey", "RelativeHorizontalToKey", "HorizontalToKey", "RelativeVerticalToKey", "VerticalToKey", "RelativeCurveToKey", "CurveToKey", "RelativeReflectiveCurveToKey", "ReflectiveCurveToKey", "RelativeQuadToKey", "QuadToKey", "RelativeReflectiveQuadToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "ArcToKey", "NUM_MOVE_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "NUM_CURVE_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_ARC_TO_ARGS", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char arg11, ArrayList arg12, float[] arg13, int arg14) {
        boolean v8;
        boolean v7;
        float v6;
        float v5;
        float v4;
        int v2 = 0;
        switch(arg11) {
            case 65: {
                goto label_214;
            }
            case 67: {
                goto label_196;
            }
            case 72: {
                goto label_188;
            }
            case 76: {
                goto label_178;
            }
            case 77: {
                goto label_176;
            }
            case 81: {
                goto label_162;
            }
            case 83: {
                goto label_148;
            }
            case 84: {
                goto label_138;
            }
            case 86: {
                goto label_130;
            }
            case 97: {
                goto label_96;
            }
            case 99: {
                goto label_78;
            }
            case 104: {
                goto label_70;
            }
            case 108: {
                goto label_60;
            }
            case 109: {
                goto label_58;
            }
            case 113: {
                goto label_44;
            }
            case 115: {
                goto label_30;
            }
            case 116: {
                goto label_20;
            }
            case 118: {
                goto label_12;
            }
            case 90: 
            case 122: {
                goto label_127;
            }
        }

        throw new IllegalArgumentException("Unknown command for: " + arg11);
    label_162:
        arg14 += -4;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new QuadTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3]));
            v2 += 4;
        }

    label_130:
        --arg14;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new VerticalTo(arg13[v2]));
            ++v2;
        }

    label_196:
        arg14 += -6;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new CurveTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3], arg13[v2 + 4], arg13[v2 + 5]));
            v2 += 6;
        }

    label_70:
        --arg14;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeHorizontalTo(arg13[v2]));
            ++v2;
        }

    label_138:
        arg14 += -2;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new ReflectiveQuadTo(arg13[v2], arg13[v2 + 1]));
            v2 += 2;
        }

    label_44:
        arg14 += -4;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeQuadTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3]));
            v2 += 4;
        }

    label_12:
        --arg14;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeVerticalTo(arg13[v2]));
            ++v2;
        }

    label_78:
        arg14 += -6;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeCurveTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3], arg13[v2 + 4], arg13[v2 + 5]));
            v2 += 6;
        }

    label_176:
        PathNodeKt.pathMoveNodeFromArgs(((List)arg12), arg13, arg14);
        return;
    label_178:
        arg14 += -2;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new LineTo(arg13[v2], arg13[v2 + 1]));
            v2 += 2;
        }

    label_148:
        arg14 += -4;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new ReflectiveCurveTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3]));
            v2 += 4;
        }

    label_20:
        arg14 += -2;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeReflectiveQuadTo(arg13[v2], arg13[v2 + 1]));
            v2 += 2;
        }

    label_214:
        arg14 += -7;
        int v11;
        for(v11 = 0; true; v11 += 7) {
            if(v11 > arg14) {
                return;
            }

            v4 = arg13[v11];
            v5 = arg13[v11 + 1];
            v6 = arg13[v11 + 2];
            v7 = Float.compare(arg13[v11 + 3], 0f) != 0 ? true : false;
            v8 = Float.compare(arg13[v11 + 4], 0f) != 0 ? true : false;
            ((List)arg12).add(new ArcTo(v4, v5, v6, v7, v8, arg13[v11 + 5], arg13[v11 + 6]));
        }

    label_58:
        PathNodeKt.pathRelativeMoveNodeFromArgs(((List)arg12), arg13, arg14);
        return;
    label_188:
        --arg14;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new HorizontalTo(arg13[v2]));
            ++v2;
        }

    label_60:
        arg14 += -2;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeLineTo(arg13[v2], arg13[v2 + 1]));
            v2 += 2;
        }

    label_30:
        arg14 += -4;
        while(true) {
            if(v2 > arg14) {
                return;
            }

            ((List)arg12).add(new RelativeReflectiveCurveTo(arg13[v2], arg13[v2 + 1], arg13[v2 + 2], arg13[v2 + 3]));
            v2 += 4;
        }

    label_127:
        arg12.add(Close.INSTANCE);
        return;
    label_96:
        arg14 += -7;
        for(v11 = 0; v11 <= arg14; v11 += 7) {
            v4 = arg13[v11];
            v5 = arg13[v11 + 1];
            v6 = arg13[v11 + 2];
            v7 = Float.compare(arg13[v11 + 3], 0f) != 0 ? true : false;
            v8 = Float.compare(arg13[v11 + 4], 0f) != 0 ? true : false;
            ((List)arg12).add(new RelativeArcTo(v4, v5, v6, v7, v8, arg13[v11 + 5], arg13[v11 + 6]));
        }
    }

    private static final void pathMoveNodeFromArgs(List arg4, float[] arg5, int arg6) {
        int v0 = 2;
        arg6 -= v0;
        if(arg6 >= 0) {
            arg4.add(new MoveTo(arg5[0], arg5[1]));
            while(v0 <= arg6) {
                arg4.add(new LineTo(arg5[v0], arg5[v0 + 1]));
                v0 += 2;
            }
        }
    }

    private static final void pathNodesFromArgs(List arg2, float[] arg3, int arg4, int arg5, Function2 arg6) {
        arg4 -= arg5;
        int v0;
        for(v0 = 0; v0 <= arg4; v0 += arg5) {
            arg2.add(arg6.invoke(arg3, Integer.valueOf(v0)));
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List arg4, float[] arg5, int arg6) {
        int v0 = 2;
        arg6 -= v0;
        if(arg6 >= 0) {
            arg4.add(new RelativeMoveTo(arg5[0], arg5[1]));
            while(v0 <= arg6) {
                arg4.add(new RelativeLineTo(arg5[v0], arg5[v0 + 1]));
                v0 += 2;
            }
        }
    }
}

