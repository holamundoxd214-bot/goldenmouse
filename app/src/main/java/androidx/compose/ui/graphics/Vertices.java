package androidx.compose.ui.graphics;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001B\u001A\u00020\u00152\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010\u001C\u001A\u00020\u00112\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001E"}, d2={"Landroidx/compose/ui/graphics/Vertices;", "", "vertexMode", "Landroidx/compose/ui/graphics/VertexMode;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "textureCoordinates", "colors", "Landroidx/compose/ui/graphics/Color;", "indices", "", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVertexMode-c2xauaI", "()I", "I", "", "getPositions", "()[F", "getTextureCoordinates", "", "getColors", "()[I", "", "getIndices", "()[S", "encodeColorList", "encodePointList", "points", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Vertices {
    public static final int $stable = 8;
    private final int[] colors;
    private final short[] indices;
    private final float[] positions;
    private final float[] textureCoordinates;
    private final int vertexMode;

    static {
    }

    private Vertices(int arg5, List arg6, List arg7, List arg8, List arg9) {
        super();
        this.vertexMode = arg5;
        if(arg7.size() != arg6.size()) {
            InlineClassHelperKt.throwIllegalArgumentException("positions and textureCoordinates lengths must match.");
        }

        if(arg8.size() != arg6.size()) {
            InlineClassHelperKt.throwIllegalArgumentException("positions and colors lengths must match.");
        }

        arg5 = arg9.size();
        int v0 = 0;
        int v1 = 0;
        while(true) {
            if(v1 < arg5) {
                int v2 = arg9.get(v1).intValue();
                if(v2 >= 0) {
                    if(v2 >= arg6.size()) {
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                break;
            }

            goto label_27;
        }

        InlineClassHelperKt.throwIllegalArgumentException("indices values must be valid indices in the positions list.");
    label_27:
        this.positions = this.encodePointList(arg6);
        this.textureCoordinates = this.encodePointList(arg7);
        this.colors = this.encodeColorList(arg8);
        arg5 = arg9.size();
        short[] v6 = new short[arg5];
        while(v0 < arg5) {
            v6[v0] = ((short)arg9.get(v0).intValue());
            ++v0;
        }

        this.indices = v6;
    }

    public Vertices(int arg1, List arg2, List arg3, List arg4, List arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private final int[] encodeColorList(List arg5) {
        int v4 = arg5.size();
        int[] v0 = new int[v4];
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            v0[v1] = ColorKt.toArgb-8_81llA(arg5.get(v1).unbox-impl());
        }

        return v0;
    }

    private final float[] encodePointList(List arg7) {
        int v6 = arg7.size() * 2;
        float[] v0 = new float[v6];
        int v1;
        for(v1 = 0; v1 < v6; ++v1) {
            long v2 = arg7.get(v1 / 2).unbox-impl();
            float v2_1 = v1 % 2 == 0 ? Float.intBitsToFloat(((int)(v2 >> 0x20))) : Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)));
            v0[v1] = v2_1;
        }

        return v0;
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final short[] getIndices() {
        return this.indices;
    }

    public final float[] getPositions() {
        return this.positions;
    }

    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    public final int getVertexMode-c2xauaI() {
        return this.vertexMode;
    }
}

