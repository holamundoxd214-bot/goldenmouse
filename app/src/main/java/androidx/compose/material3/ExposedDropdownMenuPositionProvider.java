package androidx.compose.material3;

import androidx.compose.material3.internal.MenuPosition$Horizontal;
import androidx.compose.material3.internal.MenuPosition$Vertical;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005\u00128\b\u0002\u0010\n\u001A2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000B¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010&\u001A\u00020\'2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020)H\u0016¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016RA\u0010\n\u001A2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "density", "Landroidx/compose/ui/unit/Density;", "topWindowInsets", "", "keyboardSignalState", "Landroidx/compose/runtime/State;", "", "verticalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "<init>", "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILkotlin/jvm/functions/Function2;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTopWindowInsets", "()I", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "getVerticalMargin", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable;
    private final Vertical bottomToAnchorTop;
    private final Vertical bottomToWindowBottom;
    private final Density density;
    private final Horizontal endToAnchorEnd;
    private final State keyboardSignalState;
    private final Horizontal leftToWindowLeft;
    private final Function2 onPositionCalculated;
    private final Horizontal rightToWindowRight;
    private final Horizontal startToAnchorStart;
    private final Vertical topToAnchorBottom;
    private final Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;

    static {
    }

    public ExposedDropdownMenuPositionProvider(Density arg7, int arg8, State arg9, int arg10, Function2 arg11, int arg12, DefaultConstructorMarker arg13) {
        ExposedDropdownMenuPositionProvider$$ExternalSyntheticLambda0 v11;
        if((arg12 & 4) != 0) {
            arg9 = null;
        }

        State v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = arg7.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        }

        int v4 = arg10;
        if((arg12 & 16) != 0) {
            v11 = new ExposedDropdownMenuPositionProvider$$ExternalSyntheticLambda0();
        }

        this(arg7, arg8, v3, v4, ((Function2)v11));
    }

    public ExposedDropdownMenuPositionProvider(Density arg1, int arg2, State arg3, int arg4, Function2 arg5) {
        super();
        this.density = arg1;
        this.topWindowInsets = arg2;
        this.keyboardSignalState = arg3;
        this.verticalMargin = arg4;
        this.onPositionCalculated = arg5;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(MenuPosition.INSTANCE, 0, 1, null);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(MenuPosition.INSTANCE, 0, 1, null);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(MenuPosition.INSTANCE, 0, 1, null);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(MenuPosition.INSTANCE, 0, 1, null);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(MenuPosition.INSTANCE, 0, 1, null);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(MenuPosition.INSTANCE, 0, 1, null);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(arg4);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(arg4);
    }

    static final Unit _init_$lambda$1(IntRect arg0, IntRect arg1) {
        return Unit.INSTANCE;
    }

    public long calculatePosition-llwVHH4(IntRect arg21, long arg22, LayoutDirection arg24, long arg25) {
        int v1_3;
        IntRect v2_2;
        int v11;
        int v10_1;
        long v18;
        int v17;
        ExposedDropdownMenuPositionProvider v0 = this;
        long v7 = arg25;
        State v1 = v0.keyboardSignalState;
        if(v1 != null) {
            v1.getValue();
        }

        int v9 = 0x20;
        long v10 = 0xFFFFFFFFL;
        long v3 = IntSize.constructor-impl((((long)((((int)(arg22 & v10))) + v0.topWindowInsets))) & v10 | (((long)(((int)(arg22 >> v9))))) << v9);
        int v12 = 3;
        Horizontal[] v1_1 = new Horizontal[v12];
        int v13 = 0;
        v1_1[0] = v0.startToAnchorStart;
        v1_1[1] = v0.endToAnchorEnd;
        int v15 = ((int)(v3 >> v9));
        Horizontal v2 = IntOffset.getX-impl(arg21.getCenter-nOcc-ac()) < v15 / 2 ? v0.leftToWindowLeft : v0.rightToWindowRight;
        int v16 = 2;
        v1_1[v16] = v2;
        List v1_2 = CollectionsKt.listOf(((Object[])v1_1));
        int v2_1 = v1_2.size();
        int v5 = 0;
        while(true) {
            if(v5 < v2_1) {
                Object v6 = v1_2.get(v5);
                v17 = v9;
                v18 = v10;
                v10_1 = v2_1;
                v11 = v5;
                v5 = ((int)(v7 >> v17));
                v2_2 = arg21;
                List v9_1 = v1_2;
                v1_3 = v6.position-95KtPRI(v2_2, v3, v5, arg24);
                if(v11 != CollectionsKt.getLastIndex(v9_1)) {
                    if(v1_3 >= 0 && v5 + v1_3 <= v15) {
                        goto label_72;
                    }

                    v5 = v11 + 1;
                    v1_2 = v9_1;
                    v2_1 = v10_1;
                    v9 = v17;
                    v10 = v18;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_72;
        }

        v2_2 = arg21;
        v17 = v9;
        v18 = v10;
        v1_3 = 0;
    label_72:
        Vertical[] v5_1 = new Vertical[v12];
        v5_1[0] = v0.topToAnchorBottom;
        v5_1[1] = v0.bottomToAnchorTop;
        v9 = ((int)(v3 & v18));
        Vertical v6_1 = IntOffset.getY-impl(v2_2.getCenter-nOcc-ac()) < v9 / 2 ? v0.topToWindowTop : v0.bottomToWindowBottom;
        v5_1[v16] = v6_1;
        List v5_2 = CollectionsKt.listOf(((Object[])v5_1));
        int v6_2 = v5_2.size();
        v10_1 = 0;
        while(true) {
            if(v10_1 < v6_2) {
                v12 = ((int)(v7 & v18));
                v11 = v5_2.get(v10_1).position-JVtK1S4(v2_2, v3, v12);
                if(v10_1 != CollectionsKt.getLastIndex(v5_2)) {
                    if(v11 >= 0 && v12 + v11 <= v9) {
                        break;
                    }

                    ++v10_1;
                    continue;
                }

                break;
            }

            goto label_105;
        }

        v13 = v11;
    label_105:
        v3 = IntOffset.constructor-impl((((long)v1_3)) << v17 | (((long)v13)) & v18);
        v0.onPositionCalculated.invoke(v2_2, IntRectKt.IntRect-VbeCjmY(v3, v7));
        return v3;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final State getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    public final Function2 getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }
}

