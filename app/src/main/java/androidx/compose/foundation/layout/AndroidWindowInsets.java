package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u0010\u0010 \u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0018\u0010!\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u0010\u0010\"\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u001D\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\u0003H\u0000¢\u0006\u0002\b(J\u0013\u0010)\u001A\u00020\u00152\b\u0010*\u001A\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001A\u00020\u0003H\u0016J\b\u0010-\u001A\u00020\u0005H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u000E\u001A\u00070\u000B¢\u0006\u0002\b\f2\u0010\u0010\n\u001A\f0\u000B¢\u0006\u0002\b\f¢\u0006\u0002\b\r8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\n\u001A\u00020\u00158F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001A\u0010\u0014\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006."}, d2={"Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "type", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getType$foundation_layout", "()I", "<set-?>", "Landroidx/core/graphics/Insets;", "Lorg/jspecify/annotations/NonNull;", "Lkotlin/jvm/internal/EnhancedNullability;", "insets", "getInsets$foundation_layout", "()Landroidx/core/graphics/Insets;", "setInsets$foundation_layout", "(Landroidx/core/graphics/Insets;)V", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "getLeft", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "update", "", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "typeMask", "update$foundation_layout", "equals", "other", "", "hashCode", "toString", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidWindowInsets implements WindowInsets {
    public static final int $stable;
    private final MutableState insets$delegate;
    private final MutableState isVisible$delegate;
    private final String name;
    private final int type;

    static {
    }

    public AndroidWindowInsets(int arg2, String arg3) {
        super();
        this.type = arg2;
        this.name = arg3;
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(Insets.NONE, null, 2, null);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
    }

    public boolean equals(Object arg4) {
        if(this == (((AndroidWindowInsets)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AndroidWindowInsets)) {
            return 0;
        }

        if(this.type == ((AndroidWindowInsets)arg4).type) {
            return 1;
        }

        return 0;
    }

    public int getBottom(Density arg1) {
        return this.getInsets$foundation_layout().bottom;
    }

    public final Insets getInsets$foundation_layout() {
        return this.insets$delegate.getValue();
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return this.getInsets$foundation_layout().left;
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return this.getInsets$foundation_layout().right;
    }

    public int getTop(Density arg1) {
        return this.getInsets$foundation_layout().top;
    }

    public final int getType$foundation_layout() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    public final boolean isVisible() {
        return this.isVisible$delegate.getValue().booleanValue();
    }

    public final void setInsets$foundation_layout(Insets arg1) {
        this.insets$delegate.setValue(arg1);
    }

    public final void setVisible(boolean arg1) {
        this.isVisible$delegate.setValue(Boolean.valueOf(arg1));
    }

    public String toString() {
        return this.name + '(' + this.getInsets$foundation_layout().left + ", " + this.getInsets$foundation_layout().top + ", " + this.getInsets$foundation_layout().right + ", " + this.getInsets$foundation_layout().bottom + ')';
    }

    public final void update$foundation_layout(WindowInsetsCompat arg2, int arg3) {
        if(arg3 != 0) {
            if((arg3 & this.type) != 0) {
            }
            else {
                return;
            }
        }

        this.setInsets$foundation_layout(arg2.getInsets(this.type));
        this.setVisible(arg2.isVisible(this.type));
    }
}

