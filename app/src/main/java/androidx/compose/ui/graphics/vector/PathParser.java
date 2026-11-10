package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EJ8\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\r\u001A\u00020\u000E2\u0018\b\u0002\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0011\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u0012H\u0082\bJ\u0014\u0010\u0013\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0014J\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0010\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0017R\"\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/ui/graphics/vector/PathParser;", "", "<init>", "()V", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodeData", "", "clear", "", "parsePathString", "pathData", "", "pathStringToNodes", "resizeNodeData", "dataCount", "", "addPathNodes", "", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", "target", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathParser {
    public static final int $stable = 8;
    private float[] nodeData;
    private ArrayList nodes;

    static {
    }

    public PathParser() {
        super();
        this.nodeData = new float[0x40];
    }

    public final PathParser addPathNodes(List arg2) {
        ArrayList v0 = this.nodes;
        if(v0 == null) {
            v0 = new ArrayList();
            this.nodes = v0;
        }

        v0.addAll(((Collection)arg2));
        return this;
    }

    public final void clear() {
        ArrayList v0 = this.nodes;
        if(v0 != null) {
            v0.clear();
        }
    }

    public final PathParser parsePathString(String arg2) {
        ArrayList v0 = this.nodes;
        if(v0 == null) {
            v0 = new ArrayList();
            this.nodes = v0;
        }
        else {
            v0.clear();
        }

        this.pathStringToNodes(arg2, v0);
        return this;
    }

    public final ArrayList pathStringToNodes(String arg12, ArrayList arg13) {
        int v6;
        char v2_1;
        int v5;
        int v3;
        int v0 = arg12.length();
        int v2 = 0;
        while(true) {
            v3 = 0x20;
            if(v2 < v0 && Intrinsics.compare(arg12.charAt(v2), v3) <= 0) {
                ++v2;
                continue;
            }

            break;
        }

        while(v0 > v2) {
            if(Intrinsics.compare(arg12.charAt(v0 - 1), v3) > 0) {
                break;
            }

            --v0;
        }

        int v4 = 0;
        while(v2 < v0) {
            while(true) {
                v5 = v2 + 1;
                v2_1 = arg12.charAt(v2);
                v6 = v2_1 | 0x20;
                if((v6 - 97) * (v6 - 0x7A) <= 0 && v6 != 101) {
                }
                else if(v5 >= v0) {
                    v2_1 = '\u0000';
                }
                else {
                    goto label_93;
                }

                if(v2_1 != 0) {
                    v6 = v2_1 | 0x20;
                    if(v6 == 0x7A) {
                        goto label_89;
                    }

                    break;
                label_93:
                    v2 = v5;
                    continue;
                }

                goto label_91;
            }

            while(v5 < v0) {
                if(Intrinsics.compare(arg12.charAt(v5), v3) > 0) {
                    break;
                }

                ++v5;
            }

            v4 = v6 == 97 ? 1 : 0;
            v6 = 0;
            do {
                long v7 = v4 == 0 || 3 > v6 || v6 >= 5 ? FastFloatParserKt.nextFloat(arg12, v5, v0) : FastFloatParserKt.nextFloat(arg12, v5, Math.min(v5 + 1, v0));
                v5 = ((int)(v7 >>> v3));
                float v7_1 = Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL)));
                if(!Float.isNaN(v7_1)) {
                    float[] v8 = this.nodeData;
                    int v9 = v6 + 1;
                    v8[v6] = v7_1;
                    if(v9 >= v8.length) {
                        float[] v6_1 = new float[v9 * 2];
                        this.nodeData = v6_1;
                        ArraysKt.copyInto(v8, v6_1, 0, 0, v8.length);
                    }

                    v6 = v9;
                }

                while(v5 < v0) {
                    if(Intrinsics.compare(arg12.charAt(v5), v3) > 0 && arg12.charAt(v5) != 44) {
                        break;
                    }

                    ++v5;
                }

                if(v5 >= v0) {
                    break;
                }
            }
            while(!Float.isNaN(v7_1));

            v4 = v6;
        label_89:
            PathNodeKt.addPathNodes(v2_1, arg13, this.nodeData, v4);
        label_91:
            v2 = v5;
        }

        return arg13;
    }

    public static ArrayList pathStringToNodes$default(PathParser arg0, String arg1, ArrayList arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = new ArrayList();
        }

        return arg0.pathStringToNodes(arg1, arg2);
    }

    private final void resizeNodeData(int arg3) {
        float[] v0 = this.nodeData;
        if(arg3 >= v0.length) {
            float[] v3 = new float[arg3 * 2];
            this.nodeData = v3;
            ArraysKt.copyInto(v0, v3, 0, 0, v0.length);
        }
    }

    public final List toNodes() {
        ArrayList v0 = this.nodes;
        if(v0 != null) {
            return ((List)v0);
        }

        return CollectionsKt.emptyList();
    }

    public final Path toPath(Path arg1) {
        ArrayList v0 = this.nodes;
        if(v0 != null) {
            Path v0_1 = PathParserKt.toPath(((List)v0), arg1);
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return AndroidPath_androidKt.Path();
    }

    public static Path toPath$default(PathParser arg0, Path arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = AndroidPath_androidKt.Path();
        }

        return arg0.toPath(arg1);
    }
}

