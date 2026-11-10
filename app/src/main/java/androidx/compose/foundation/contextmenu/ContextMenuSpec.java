package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u00101\u001A\u0002022\u0006\u00103\u001A\u000204¢\u0006\u0004\b5\u00106R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001A\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001A\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001B\u0010\u0007R\u0013\u0010\u001C\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001D\u0010\u0007R\u0013\u0010\u001E\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001F\u0010\u0007R\u0013\u0010 \u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b!\u0010\u0007R\u0013\u0010\"\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b#\u0010\u0007R\u0013\u0010$\u001A\u00020%¢\u0006\n\n\u0002\u0010(\u001A\u0004\b&\u0010\'R\u0011\u0010)\u001A\u00020*¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u0013\u0010-\u001A\u00020%¢\u0006\n\n\u0002\u0010(\u001A\u0004\b.\u0010\'R\u0013\u0010/\u001A\u00020%¢\u0006\n\n\u0002\u0010(\u001A\u0004\b0\u0010\'¨\u00067"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", "", "<init>", "()V", "ContainerWidthMin", "Landroidx/compose/ui/unit/Dp;", "getContainerWidthMin-D9Ej5fM", "()F", "F", "ContainerWidthMax", "getContainerWidthMax-D9Ej5fM", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "LabelHorizontalTextAlignment", "Landroidx/compose/ui/text/style/TextAlign;", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "I", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "DividerHeight", "getDividerHeight-D9Ej5fM", "DividerVerticalPadding", "getDividerVerticalPadding-D9Ej5fM", "FontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE", "()J", "J", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "LineHeight", "getLineHeight-XSAIIZE", "LetterSpacing", "getLetterSpacing-XSAIIZE", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextMenuSpec {
    public static final int $stable;
    private static final float ContainerWidthMax;
    private static final float ContainerWidthMin;
    private static final float CornerRadius;
    private static final float DividerHeight;
    private static final float DividerVerticalPadding;
    private static final long FontSize;
    private static final FontWeight FontWeight;
    private static final float HorizontalPadding;
    public static final ContextMenuSpec INSTANCE;
    private static final float IconSize;
    private static final int LabelHorizontalTextAlignment;
    private static final Vertical LabelVerticalTextAlignment;
    private static final long LetterSpacing;
    private static final long LineHeight;
    private static final float ListItemHeight;
    private static final float MenuContainerElevation;
    private static final float VerticalPadding;

    static {
        ContextMenuSpec.INSTANCE = new ContextMenuSpec();
        ContextMenuSpec.ContainerWidthMin = Dp.constructor-impl(112f);
        ContextMenuSpec.ContainerWidthMax = Dp.constructor-impl(280f);
        ContextMenuSpec.ListItemHeight = Dp.constructor-impl(48f);
        ContextMenuSpec.MenuContainerElevation = Dp.constructor-impl(3f);
        ContextMenuSpec.CornerRadius = Dp.constructor-impl(4f);
        ContextMenuSpec.LabelVerticalTextAlignment = Alignment.Companion.getCenterVertically();
        ContextMenuSpec.LabelHorizontalTextAlignment = TextAlign.Companion.getStart-e0LSkKk();
        ContextMenuSpec.HorizontalPadding = Dp.constructor-impl(12f);
        ContextMenuSpec.VerticalPadding = Dp.constructor-impl(8f);
        ContextMenuSpec.IconSize = Dp.constructor-impl(24f);
        ContextMenuSpec.DividerHeight = Dp.constructor-impl(1f);
        ContextMenuSpec.DividerVerticalPadding = Dp.constructor-impl(8f);
        ContextMenuSpec.FontSize = TextUnitKt.getSp(14);
        ContextMenuSpec.FontWeight = FontWeight.Companion.getMedium();
        ContextMenuSpec.LineHeight = TextUnitKt.getSp(20);
        ContextMenuSpec.LetterSpacing = TextUnitKt.getSp(0.1f);
    }

    private ContextMenuSpec() {
        super();
    }

    public final float getContainerWidthMax-D9Ej5fM() {
        return ContextMenuSpec.ContainerWidthMax;
    }

    public final float getContainerWidthMin-D9Ej5fM() {
        return ContextMenuSpec.ContainerWidthMin;
    }

    public final float getCornerRadius-D9Ej5fM() {
        return ContextMenuSpec.CornerRadius;
    }

    public final float getDividerHeight-D9Ej5fM() {
        return ContextMenuSpec.DividerHeight;
    }

    public final float getDividerVerticalPadding-D9Ej5fM() {
        return ContextMenuSpec.DividerVerticalPadding;
    }

    public final long getFontSize-XSAIIZE() {
        return ContextMenuSpec.FontSize;
    }

    public final FontWeight getFontWeight() {
        return ContextMenuSpec.FontWeight;
    }

    public final float getHorizontalPadding-D9Ej5fM() {
        return ContextMenuSpec.HorizontalPadding;
    }

    public final float getIconSize-D9Ej5fM() {
        return ContextMenuSpec.IconSize;
    }

    public final int getLabelHorizontalTextAlignment-e0LSkKk() {
        return ContextMenuSpec.LabelHorizontalTextAlignment;
    }

    public final Vertical getLabelVerticalTextAlignment() {
        return ContextMenuSpec.LabelVerticalTextAlignment;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return ContextMenuSpec.LetterSpacing;
    }

    public final long getLineHeight-XSAIIZE() {
        return ContextMenuSpec.LineHeight;
    }

    public final float getListItemHeight-D9Ej5fM() {
        return ContextMenuSpec.ListItemHeight;
    }

    public final float getMenuContainerElevation-D9Ej5fM() {
        return ContextMenuSpec.MenuContainerElevation;
    }

    public final float getVerticalPadding-D9Ej5fM() {
        return ContextMenuSpec.VerticalPadding;
    }

    public final TextStyle textStyle-8_81llA(long arg33) {
        return new TextStyle(arg33, ContextMenuSpec.FontSize, ContextMenuSpec.FontWeight, null, null, null, null, ContextMenuSpec.LetterSpacing, null, null, null, 0, null, null, null, ContextMenuSpec.LabelHorizontalTextAlignment, 0, ContextMenuSpec.LineHeight, null, null, null, 0, 0, null, 0xFD7F78, null);
    }
}

