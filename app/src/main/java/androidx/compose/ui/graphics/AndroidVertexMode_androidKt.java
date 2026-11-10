package androidx.compose.ui.graphics;

import android.graphics.Canvas$VertexMode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0011\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidVertexMode_androidKt {
    public static final Canvas$VertexMode toAndroidVertexMode-JOOmi9M(int arg1) {
        if(VertexMode.equals-impl0(arg1, VertexMode.Companion.getTriangles-c2xauaI())) {
            return Canvas$VertexMode.TRIANGLES;
        }

        if(VertexMode.equals-impl0(arg1, VertexMode.Companion.getTriangleStrip-c2xauaI())) {
            return Canvas$VertexMode.TRIANGLE_STRIP;
        }

        if(VertexMode.equals-impl0(arg1, VertexMode.Companion.getTriangleFan-c2xauaI())) {
            return Canvas$VertexMode.TRIANGLE_FAN;
        }

        return Canvas$VertexMode.TRIANGLES;
    }
}

