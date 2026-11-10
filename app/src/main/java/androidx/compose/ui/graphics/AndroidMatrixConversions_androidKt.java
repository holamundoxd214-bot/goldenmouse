package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0019\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u0019\u0010\u0000\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"setFrom", "", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "Landroid/graphics/Matrix;", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidMatrixConversions_androidKt {
    public static final void setFrom-EL8BTi8(Matrix arg21, float[] arg22) {
        float v1 = arg22[0];
        float v3 = arg22[1];
        float v5 = arg22[2];
        float v7 = arg22[3];
        float v9 = arg22[4];
        float v11 = arg22[5];
        float v13 = arg22[6];
        float v15 = arg22[7];
        float v17 = arg22[8];
        float v18 = arg22[12];
        float v19 = arg22[13];
        float v20 = arg22[15];
        arg22[0] = v1;
        arg22[1] = v9;
        arg22[2] = v18;
        arg22[3] = v3;
        arg22[4] = v11;
        arg22[5] = v19;
        arg22[6] = v7;
        arg22[7] = v15;
        arg22[8] = v20;
        arg21.setValues(arg22);
        arg22[0] = v1;
        arg22[1] = v3;
        arg22[2] = v5;
        arg22[3] = v7;
        arg22[4] = v9;
        arg22[5] = v11;
        arg22[6] = v13;
        arg22[7] = v15;
        arg22[8] = v17;
    }

    public static final void setFrom-tU-YjHk(float[] arg19, Matrix arg20) {
        arg20.getValues(arg19);
        float v2 = arg19[0];
        float v4 = arg19[1];
        float v6 = arg19[2];
        float v8 = arg19[3];
        float v10 = arg19[4];
        float v12 = arg19[5];
        float v14 = arg19[6];
        float v16 = arg19[7];
        float v18 = arg19[8];
        arg19[0] = v2;
        arg19[1] = v8;
        arg19[2] = 0f;
        arg19[3] = v14;
        arg19[4] = v4;
        arg19[5] = v10;
        arg19[6] = 0f;
        arg19[7] = v16;
        arg19[8] = 0f;
        arg19[9] = 0f;
        arg19[10] = 1f;
        arg19[11] = 0f;
        arg19[12] = v6;
        arg19[13] = v12;
        arg19[14] = 0f;
        arg19[15] = v18;
    }
}

