package androidx.compose.ui.spatial;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u000FH\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016R\u0012\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2={"Landroidx/compose/ui/spatial/RectListDebuggerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "token", "", "getToken", "()Ljava/lang/Object;", "setToken", "(Ljava/lang/Object;)V", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RectListDebuggerModifierNode extends Node implements DrawModifierNode {
    private Paint paint;
    private Object token;

    public RectListDebuggerModifierNode() {
        super();
        androidx.compose.ui.graphics.Paint v0 = AndroidPaint_androidKt.Paint();
        v0.setColor-8_81llA(Color.Companion.getRed-0d7_KjU());
        v0.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        this.paint = v0.asFrameworkPaint();
    }

    public void draw(ContentDrawScope arg13) {
        RectList v0 = DelegatableNodeKt.requireOwner(this).getRectManager().getRects();
        Canvas v1 = AndroidCanvas_androidKt.getNativeCanvas(arg13.getDrawContext().getCanvas());
        Paint v6 = this.paint;
        long[] v12 = v0.items;
        int v13 = v0.itemsSize;
        int v0_1;
        for(v0_1 = 0; v0_1 < v12.length - 2; v0_1 += 3) {
            if(v0_1 >= v13) {
                return;
            }

            v1.drawRect(((float)(((int)(v12[v0_1] >> 0x20)))), ((float)(((int)v12[v0_1]))), ((float)(((int)(v12[v0_1 + 1] >> 0x20)))), ((float)(((int)v12[v0_1 + 1]))), v6);
        }
    }

    public final Object getToken() {
        return this.token;
    }

    public void onAttach() {
        this.token = DelegatableNodeKt.requireOwner(this).getRectManager().registerOnChangedCallback(new RectListDebuggerModifierNode$onAttach$1(this));
    }

    public void onDetach() {
        DelegatableNodeKt.requireOwner(this).getRectManager().unregisterOnChangedCallback(this.token);
    }

    public final void setToken(Object arg1) {
        this.token = arg1;
    }
}

