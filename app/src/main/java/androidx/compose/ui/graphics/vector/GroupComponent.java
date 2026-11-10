package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0002J\u0017\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u001B\u001A\u00020\u0001H\u0002J\b\u0010\u001C\u001A\u00020\u0013H\u0002J\b\u00100\u001A\u00020\u0013H\u0002J\b\u0010T\u001A\u00020\u0013H\u0002J\u0016\u0010U\u001A\u00020\u00132\u0006\u0010V\u001A\u00020P2\u0006\u0010W\u001A\u00020\u0001J\u001E\u0010X\u001A\u00020\u00132\u0006\u0010Y\u001A\u00020P2\u0006\u0010Z\u001A\u00020P2\u0006\u0010[\u001A\u00020PJ\u0016\u0010\\\u001A\u00020\u00132\u0006\u0010V\u001A\u00020P2\u0006\u0010[\u001A\u00020PJ\f\u0010]\u001A\u00020\u0013*\u00020^H\u0016J\b\u0010_\u001A\u000201H\u0016R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR \u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\r@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R0\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\fR\u000E\u0010&\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\'\u001A\u0004\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010)\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0013\u0018\u00010*X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001A\u0010/\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130*X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00102\u001A\u0002012\u0006\u0010\t\u001A\u000201@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b>\u0010:\"\u0004\b?\u0010<R$\u0010@\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bA\u0010:\"\u0004\bB\u0010<R$\u0010C\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bD\u0010:\"\u0004\bE\u0010<R$\u0010F\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bG\u0010:\"\u0004\bH\u0010<R$\u0010I\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010:\"\u0004\bK\u0010<R$\u0010L\u001A\u0002072\u0006\u0010\t\u001A\u000207@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bM\u0010:\"\u0004\bN\u0010<R\u0011\u0010O\u001A\u00020P8F¢\u0006\u0006\u001A\u0004\bQ\u0010RR\u000E\u0010S\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006`"}, d2={"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "<init>", "()V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "children", "", "value", "", "isTintable", "()Z", "Landroidx/compose/ui/graphics/Color;", "tintColor", "getTintColor-0d7_KjU", "()J", "J", "markTintForBrush", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "markTintForColor", "color", "markTintForColor-8_81llA", "(J)V", "markTintForVNode", "node", "markNotTintable", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "willClipPath", "getWillClipPath", "isClipPathDirty", "clipPath", "Landroidx/compose/ui/graphics/Path;", "invalidateListener", "Lkotlin/Function1;", "getInvalidateListener$ui", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui", "(Lkotlin/jvm/functions/Function1;)V", "wrappedListener", "updateClipPath", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "rotation", "getRotation", "()F", "setRotation", "(F)V", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "numChildren", "", "getNumChildren", "()I", "isMatrixDirty", "updateMatrix", "insertAt", "index", "instance", "move", "from", "to", "count", "remove", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GroupComponent extends VNode {
    public static final int $stable = 8;
    private final List children;
    private Path clipPath;
    private List clipPathData;
    private float[] groupMatrix;
    private Function1 invalidateListener;
    private boolean isClipPathDirty;
    private boolean isMatrixDirty;
    private boolean isTintable;
    private String name;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private long tintColor;
    private float translationX;
    private float translationY;
    private final Function1 wrappedListener;

    static {
    }

    public GroupComponent() {
        super(null);
        this.children = new ArrayList();
        this.isTintable = true;
        this.tintColor = Color.Companion.getUnspecified-0d7_KjU();
        this.clipPathData = VectorKt.getEmptyPath();
        this.isClipPathDirty = true;
        this.wrappedListener = new GroupComponent$wrappedListener$1(this);
        this.name = "";
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.isMatrixDirty = true;
    }

    public static final void access$markTintForVNode(GroupComponent arg0, VNode arg1) {
        arg0.markTintForVNode(arg1);
    }

    public void draw(DrawScope arg9) {
        int v1 = 0;
        if(this.isMatrixDirty) {
            this.updateMatrix();
            this.isMatrixDirty = false;
        }

        if(this.isClipPathDirty) {
            this.updateClipPath();
            this.isClipPathDirty = false;
        }

        DrawContext v0 = arg9.getDrawContext();
        long v2 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            DrawTransform v4 = v0.getTransform();
            float[] v5 = this.groupMatrix;
            Object v6 = null;
            if(v5 != null) {
                Matrix v5_1 = v5 != null ? Matrix.box-impl(v5) : ((Matrix)v6);
                v4.transform-58bKbWc(v5_1.unbox-impl());
            }

            Path v5_2 = this.clipPath;
            if((this.getWillClipPath()) && v5_2 != null) {
                DrawTransform.clipPath-mtrdD-E$default(v4, v5_2, 0, 2, v6);
            }

            List v8_1 = this.children;
            int v4_1 = v8_1.size();
            while(v1 < v4_1) {
                v8_1.get(v1).draw(arg9);
                ++v1;
            }
        }
        catch(Throwable v8) {
            goto label_43;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v2);
        return;
    label_43:
        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v2);
        throw v8;
    }

    public final List getClipPathData() {
        return this.clipPathData;
    }

    public Function1 getInvalidateListener$ui() {
        return this.invalidateListener;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final long getTintColor-0d7_KjU() {
        return this.tintColor;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    private final boolean getWillClipPath() {
        return this.clipPathData.isEmpty() ^ 1;
    }

    public final void insertAt(int arg3, VNode arg4) {
        int v0 = this.getNumChildren();
        List v1 = this.children;
        if(arg3 < v0) {
            v1.set(arg3, arg4);
        }
        else {
            v1.add(arg4);
        }

        this.markTintForVNode(arg4);
        arg4.setInvalidateListener$ui(this.wrappedListener);
        this.invalidate();
    }

    public final boolean isTintable() {
        return this.isTintable;
    }

    private final void markNotTintable() {
        this.isTintable = false;
        this.tintColor = Color.Companion.getUnspecified-0d7_KjU();
    }

    private final void markTintForBrush(Brush arg3) {
        if(!this.isTintable) {
        }
        else if(arg3 != null) {
            if((arg3 instanceof SolidColor)) {
                this.markTintForColor-8_81llA(((SolidColor)arg3).getValue-0d7_KjU());
                return;
            }
            else {
                this.markNotTintable();
            }
        }
    }

    private final void markTintForColor-8_81llA(long arg5) {
        if(!this.isTintable) {
        }
        else {
            long v0 = 16;
            if(arg5 != v0) {
                long v2 = this.tintColor;
                if(v2 == v0) {
                    this.tintColor = arg5;
                    return;
                }
                else if(!VectorKt.rgbEqual--OWjLjI(v2, arg5)) {
                    this.markNotTintable();
                }
            }
        }
    }

    private final void markTintForVNode(VNode arg3) {
        if((arg3 instanceof PathComponent)) {
            this.markTintForBrush(((PathComponent)arg3).getFill());
            this.markTintForBrush(((PathComponent)arg3).getStroke());
            return;
        }

        if((arg3 instanceof GroupComponent)) {
            if((((GroupComponent)arg3).isTintable) && (this.isTintable)) {
                this.markTintForColor-8_81llA(((GroupComponent)arg3).tintColor);
                return;
            }

            this.markNotTintable();
        }
    }

    public final void move(int arg5, int arg6, int arg7) {
        Object v1;
        int v0 = 0;
        if(arg5 > arg6) {
            while(v0 < arg7) {
                v1 = this.children.get(arg5);
                this.children.remove(arg5);
                this.children.add(arg6, v1);
                ++arg6;
                ++v0;
            }
        }
        else {
            while(v0 < arg7) {
                v1 = this.children.get(arg5);
                this.children.remove(arg5);
                this.children.add(arg6 - 1, v1);
                ++v0;
            }
        }

        this.invalidate();
    }

    public final void remove(int arg4, int arg5) {
        int v0;
        for(v0 = 0; v0 < arg5; ++v0) {
            if(arg4 < this.children.size()) {
                this.children.get(arg4).setInvalidateListener$ui(null);
                this.children.remove(arg4);
            }
        }

        this.invalidate();
    }

    public final void setClipPathData(List arg1) {
        this.clipPathData = arg1;
        this.isClipPathDirty = true;
        this.invalidate();
    }

    public void setInvalidateListener$ui(Function1 arg1) {
        this.invalidateListener = arg1;
    }

    public final void setName(String arg1) {
        this.name = arg1;
        this.invalidate();
    }

    public final void setPivotX(float arg1) {
        this.pivotX = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setPivotY(float arg1) {
        this.pivotY = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setRotation(float arg1) {
        this.rotation = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setScaleX(float arg1) {
        this.scaleX = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setScaleY(float arg1) {
        this.scaleY = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setTranslationX(float arg1) {
        this.translationX = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public final void setTranslationY(float arg1) {
        this.translationY = arg1;
        this.isMatrixDirty = true;
        this.invalidate();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("VGroup: ").append(this.name);
        List v5 = this.children;
        int v1 = v5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.append("\t").append(v5.get(v2).toString()).append("\n");
        }

        return v0.toString();
    }

    private final void updateClipPath() {
        if(this.getWillClipPath()) {
            Path v0 = this.clipPath;
            if(v0 == null) {
                v0 = AndroidPath_androidKt.Path();
                this.clipPath = v0;
            }

            PathParserKt.toPath(this.clipPathData, v0);
        }
    }

    private final void updateMatrix() {
        float[] v0 = this.groupMatrix;
        if(v0 == null) {
            v0 = Matrix.constructor-impl$default(null, 1, null);
            this.groupMatrix = v0;
        }
        else {
            Matrix.reset-impl(v0);
        }

        Matrix.translate-impl$default(v0, this.pivotX + this.translationX, this.pivotY + this.translationY, 0f, 4, null);
        Matrix.rotateZ-impl(v0, this.rotation);
        Matrix.scale-impl(v0, this.scaleX, this.scaleY, 1f);
        Matrix.translate-impl$default(v0, -this.pivotX, -this.pivotY, 0f, 4, null);
    }
}

