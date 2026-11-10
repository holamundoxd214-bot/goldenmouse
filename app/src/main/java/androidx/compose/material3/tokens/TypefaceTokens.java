package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0010\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2={"Landroidx/compose/material3/tokens/TypefaceTokens;", "", "<init>", "()V", "Brand", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBrand", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Plain", "getPlain", "WeightBold", "Landroidx/compose/ui/text/font/FontWeight;", "getWeightBold", "()Landroidx/compose/ui/text/font/FontWeight;", "WeightMedium", "getWeightMedium", "WeightRegular", "getWeightRegular", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TypefaceTokens {
    public static final int $stable;
    private static final GenericFontFamily Brand;
    public static final TypefaceTokens INSTANCE;
    private static final GenericFontFamily Plain;
    private static final FontWeight WeightBold;
    private static final FontWeight WeightMedium;
    private static final FontWeight WeightRegular;

    static {
        TypefaceTokens.INSTANCE = new TypefaceTokens();
        TypefaceTokens.Brand = FontFamily.Companion.getSansSerif();
        TypefaceTokens.Plain = FontFamily.Companion.getSansSerif();
        TypefaceTokens.WeightBold = FontWeight.Companion.getBold();
        TypefaceTokens.WeightMedium = FontWeight.Companion.getMedium();
        TypefaceTokens.WeightRegular = FontWeight.Companion.getNormal();
    }

    private TypefaceTokens() {
        super();
    }

    public final GenericFontFamily getBrand() {
        return TypefaceTokens.Brand;
    }

    public final GenericFontFamily getPlain() {
        return TypefaceTokens.Plain;
    }

    public final FontWeight getWeightBold() {
        return TypefaceTokens.WeightBold;
    }

    public final FontWeight getWeightMedium() {
        return TypefaceTokens.WeightMedium;
    }

    public final FontWeight getWeightRegular() {
        return TypefaceTokens.WeightRegular;
    }
}

