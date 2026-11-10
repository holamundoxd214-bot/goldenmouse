package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002By\b\u0000\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006\u0012\b\b\u0002\u0010\n\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0006\u0012\b\b\u0002\u0010\f\u001A\u00020\u0006\u0012\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E\u0012\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00010\u000E¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010#\u001A\u00020\u00012\u0006\u0010$\u001A\u00020 H\u0086\u0002J\u000F\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00010&H\u0096\u0002J\u0013\u0010\'\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001A\u00020 H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0016R\u0011\u0010\u000B\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0016R\u0011\u0010\f\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0016R\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00010\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001F\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006,"}, d2={"Landroidx/compose/ui/graphics/vector/VectorGroup;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "<init>", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getRotation", "()F", "getPivotX", "getPivotY", "getScaleX", "getScaleY", "getTranslationX", "getTranslationY", "getClipPathData", "()Ljava/util/List;", "size", "", "getSize", "()I", "get", "index", "iterator", "", "equals", "", "other", "", "hashCode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorGroup extends VectorNode implements Iterable, KMappedMarker {
    public static final int $stable;
    private final List children;
    private final List clipPathData;
    private final String name;
    private final float pivotX;
    private final float pivotY;
    private final float rotation;
    private final float scaleX;
    private final float scaleY;
    private final float translationX;
    private final float translationY;

    static {
    }

    public VectorGroup(String arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, List arg10, List arg11) {
        super(null);
        this.name = arg2;
        this.rotation = arg3;
        this.pivotX = arg4;
        this.pivotY = arg5;
        this.scaleX = arg6;
        this.scaleY = arg7;
        this.translationX = arg8;
        this.translationY = arg9;
        this.clipPathData = arg10;
        this.children = arg11;
    }

    public VectorGroup() {
        this(null, 0f, 0f, 0f, 0f, 0f, 0f, 0f, null, null, 0x3FF, null);
    }

    public VectorGroup(String arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, List arg11, List arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 1) != 0) {
            arg3 = "";
        }

        float v1 = 1f;
        if((arg13 & 16) != 0) {
            arg7 = v1;
        }

        if((arg13 & 0x20) != 0) {
            arg8 = v1;
        }

        if((arg13 & 0x100) != 0) {
            arg11 = VectorKt.getEmptyPath();
        }

        if((arg13 & 0x200) != 0) {
            arg12 = CollectionsKt.emptyList();
        }

        this(arg3, 0f, 0f, 0f, arg7, arg8, 0f, 0f, arg11, arg12);
    }

    public static final List access$getChildren$p(VectorGroup arg0) {
        return arg0.children;
    }

    public boolean equals(Object arg5) {
        if(this == (((VectorGroup)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(!(arg5 instanceof VectorGroup)) {
            }
            else if(!Intrinsics.areEqual(this.name, ((VectorGroup)arg5).name)) {
                return 0;
            }
            else if(this.rotation == ((VectorGroup)arg5).rotation && this.pivotX == ((VectorGroup)arg5).pivotX && this.pivotY == ((VectorGroup)arg5).pivotY && this.scaleX == ((VectorGroup)arg5).scaleX && this.scaleY == ((VectorGroup)arg5).scaleY && this.translationX == ((VectorGroup)arg5).translationX && this.translationY == ((VectorGroup)arg5).translationY) {
                if(!Intrinsics.areEqual(this.clipPathData, ((VectorGroup)arg5).clipPathData)) {
                    return 0;
                }
                else if(!Intrinsics.areEqual(this.children, ((VectorGroup)arg5).children)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final VectorNode get(int arg1) {
        return this.children.get(arg1);
    }

    public final List getClipPathData() {
        return this.clipPathData;
    }

    public final String getName() {
        return this.name;
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

    public final int getSize() {
        return this.children.size();
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public int hashCode() {
        return ((((((((this.name.hashCode() * 0x1F + Float.hashCode(this.rotation)) * 0x1F + Float.hashCode(this.pivotX)) * 0x1F + Float.hashCode(this.pivotY)) * 0x1F + Float.hashCode(this.scaleX)) * 0x1F + Float.hashCode(this.scaleY)) * 0x1F + Float.hashCode(this.translationX)) * 0x1F + Float.hashCode(this.translationY)) * 0x1F + this.clipPathData.hashCode()) * 0x1F + this.children.hashCode();
    }

    public Iterator iterator() {
        return new VectorGroup$iterator$1(this);
    }
}

