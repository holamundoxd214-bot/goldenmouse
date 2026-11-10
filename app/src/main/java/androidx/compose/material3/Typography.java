package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bµ\u0002\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u0012\b\b\u0002\u0010\r\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001C\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001D\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001E\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001F\u001A\u00020\u0003\u0012\b\b\u0002\u0010 \u001A\u00020\u0003¢\u0006\u0004\b!\u0010\"B\u009F\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u0012\b\b\u0002\u0010\r\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0003¢\u0006\u0004\b!\u0010#J¹\u0002\u0010C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u0003H\u0000¢\u0006\u0002\bDJ\u009C\u0001\u0010C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u0003J\u0013\u0010E\u001A\u00020F2\b\u0010G\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010H\u001A\u00020IH\u0016J\b\u0010J\u001A\u00020KH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b&\u0010%R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010%R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b(\u0010%R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b)\u0010%R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b*\u0010%R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b+\u0010%R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b,\u0010%R\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b-\u0010%R\u0011\u0010\f\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b.\u0010%R\u0011\u0010\r\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b/\u0010%R\u0011\u0010\u000E\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b0\u0010%R\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b1\u0010%R\u0011\u0010\u0010\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b2\u0010%R\u0011\u0010\u0011\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b3\u0010%R\u0014\u0010\u0012\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b4\u0010%R\u0014\u0010\u0013\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b5\u0010%R\u0014\u0010\u0014\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b6\u0010%R\u0014\u0010\u0015\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b7\u0010%R\u0014\u0010\u0016\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b8\u0010%R\u0014\u0010\u0017\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b9\u0010%R\u0014\u0010\u0018\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b:\u0010%R\u0014\u0010\u0019\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b;\u0010%R\u0014\u0010\u001A\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b<\u0010%R\u0014\u0010\u001B\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b=\u0010%R\u0014\u0010\u001C\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b>\u0010%R\u0014\u0010\u001D\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b?\u0010%R\u0014\u0010\u001E\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b@\u0010%R\u0014\u0010\u001F\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010%R\u0014\u0010 \u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bB\u0010%¨\u0006L"}, d2={"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "displayLargeEmphasized", "displayMediumEmphasized", "displaySmallEmphasized", "headlineLargeEmphasized", "headlineMediumEmphasized", "headlineSmallEmphasized", "titleLargeEmphasized", "titleMediumEmphasized", "titleSmallEmphasized", "bodyLargeEmphasized", "bodyMediumEmphasized", "bodySmallEmphasized", "labelLargeEmphasized", "labelMediumEmphasized", "labelSmallEmphasized", "<init>", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getDisplayLarge", "()Landroidx/compose/ui/text/TextStyle;", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "getBodyLarge", "getBodyMedium", "getBodySmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getDisplayLargeEmphasized$material3", "getDisplayMediumEmphasized$material3", "getDisplaySmallEmphasized$material3", "getHeadlineLargeEmphasized$material3", "getHeadlineMediumEmphasized$material3", "getHeadlineSmallEmphasized$material3", "getTitleLargeEmphasized$material3", "getTitleMediumEmphasized$material3", "getTitleSmallEmphasized$material3", "getBodyLargeEmphasized$material3", "getBodyMediumEmphasized$material3", "getBodySmallEmphasized$material3", "getLabelLargeEmphasized$material3", "getLabelMediumEmphasized$material3", "getLabelSmallEmphasized$material3", "copy", "copy$material3", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Typography {
    public static final int $stable;
    private final TextStyle bodyLarge;
    private final TextStyle bodyLargeEmphasized;
    private final TextStyle bodyMedium;
    private final TextStyle bodyMediumEmphasized;
    private final TextStyle bodySmall;
    private final TextStyle bodySmallEmphasized;
    private final TextStyle displayLarge;
    private final TextStyle displayLargeEmphasized;
    private final TextStyle displayMedium;
    private final TextStyle displayMediumEmphasized;
    private final TextStyle displaySmall;
    private final TextStyle displaySmallEmphasized;
    private final TextStyle headlineLarge;
    private final TextStyle headlineLargeEmphasized;
    private final TextStyle headlineMedium;
    private final TextStyle headlineMediumEmphasized;
    private final TextStyle headlineSmall;
    private final TextStyle headlineSmallEmphasized;
    private final TextStyle labelLarge;
    private final TextStyle labelLargeEmphasized;
    private final TextStyle labelMedium;
    private final TextStyle labelMediumEmphasized;
    private final TextStyle labelSmall;
    private final TextStyle labelSmallEmphasized;
    private final TextStyle titleLarge;
    private final TextStyle titleLargeEmphasized;
    private final TextStyle titleMedium;
    private final TextStyle titleMediumEmphasized;
    private final TextStyle titleSmall;
    private final TextStyle titleSmallEmphasized;

    static {
    }

    public Typography() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0x3FFFFFFF, null);
    }

    public Typography(TextStyle arg32, TextStyle arg33, TextStyle arg34, TextStyle arg35, TextStyle arg36, TextStyle arg37, TextStyle arg38, TextStyle arg39, TextStyle arg40, TextStyle arg41, TextStyle arg42, TextStyle arg43, TextStyle arg44, TextStyle arg45, TextStyle arg46, TextStyle arg47, TextStyle arg48, TextStyle arg49, TextStyle arg50, TextStyle arg51, TextStyle arg52, TextStyle arg53, TextStyle arg54, TextStyle arg55, TextStyle arg56, TextStyle arg57, TextStyle arg58, TextStyle arg59, TextStyle arg60, TextStyle arg61, int arg62, DefaultConstructorMarker arg63) {
        int v0 = arg62;
        TextStyle v1 = (v0 & 1) != 0 ? TypographyTokens.INSTANCE.getDisplayLarge() : arg32;
        TextStyle v2 = (v0 & 2) != 0 ? TypographyTokens.INSTANCE.getDisplayMedium() : arg33;
        TextStyle v3 = (v0 & 4) != 0 ? TypographyTokens.INSTANCE.getDisplaySmall() : arg34;
        TextStyle v4 = (v0 & 8) != 0 ? TypographyTokens.INSTANCE.getHeadlineLarge() : arg35;
        TextStyle v5 = (v0 & 16) != 0 ? TypographyTokens.INSTANCE.getHeadlineMedium() : arg36;
        TextStyle v6 = (v0 & 0x20) != 0 ? TypographyTokens.INSTANCE.getHeadlineSmall() : arg37;
        TextStyle v7 = (v0 & 0x40) != 0 ? TypographyTokens.INSTANCE.getTitleLarge() : arg38;
        TextStyle v8 = (v0 & 0x80) != 0 ? TypographyTokens.INSTANCE.getTitleMedium() : arg39;
        TextStyle v9 = (v0 & 0x100) != 0 ? TypographyTokens.INSTANCE.getTitleSmall() : arg40;
        TextStyle v10 = (v0 & 0x200) != 0 ? TypographyTokens.INSTANCE.getBodyLarge() : arg41;
        TextStyle v11 = (v0 & 0x400) != 0 ? TypographyTokens.INSTANCE.getBodyMedium() : arg42;
        TextStyle v12 = (v0 & 0x800) != 0 ? TypographyTokens.INSTANCE.getBodySmall() : arg43;
        TextStyle v13 = (v0 & 0x1000) != 0 ? TypographyTokens.INSTANCE.getLabelLarge() : arg44;
        TextStyle v14 = (v0 & 0x2000) != 0 ? TypographyTokens.INSTANCE.getLabelMedium() : arg45;
        TextStyle v15 = (v0 & 0x4000) != 0 ? TypographyTokens.INSTANCE.getLabelSmall() : arg46;
        TextStyle v16 = (v0 & 0x8000) != 0 ? TypographyTokens.INSTANCE.getDisplayLargeEmphasized() : arg47;
        TextStyle v17 = (v0 & 0x10000) != 0 ? TypographyTokens.INSTANCE.getDisplayMediumEmphasized() : arg48;
        TextStyle v18 = (v0 & 0x20000) != 0 ? TypographyTokens.INSTANCE.getDisplaySmallEmphasized() : arg49;
        TextStyle v19 = (v0 & 0x40000) != 0 ? TypographyTokens.INSTANCE.getHeadlineLargeEmphasized() : arg50;
        TextStyle v20 = (v0 & 0x80000) != 0 ? TypographyTokens.INSTANCE.getHeadlineMediumEmphasized() : arg51;
        TextStyle v21 = (v0 & 0x100000) != 0 ? TypographyTokens.INSTANCE.getHeadlineSmallEmphasized() : arg52;
        TextStyle v22 = (v0 & 0x200000) != 0 ? TypographyTokens.INSTANCE.getTitleLargeEmphasized() : arg53;
        TextStyle v23 = (v0 & 0x400000) != 0 ? TypographyTokens.INSTANCE.getTitleMediumEmphasized() : arg54;
        TextStyle v24 = (v0 & 0x800000) != 0 ? TypographyTokens.INSTANCE.getTitleSmallEmphasized() : arg55;
        TextStyle v25 = (v0 & 0x1000000) != 0 ? TypographyTokens.INSTANCE.getBodyLargeEmphasized() : arg56;
        TextStyle v26 = (v0 & 0x2000000) != 0 ? TypographyTokens.INSTANCE.getBodyMediumEmphasized() : arg57;
        TextStyle v27 = (v0 & 0x4000000) != 0 ? TypographyTokens.INSTANCE.getBodySmallEmphasized() : arg58;
        TextStyle v28 = (v0 & 0x8000000) != 0 ? TypographyTokens.INSTANCE.getLabelLargeEmphasized() : arg59;
        TextStyle v29 = (v0 & 0x10000000) != 0 ? TypographyTokens.INSTANCE.getLabelMediumEmphasized() : arg60;
        TextStyle v62 = (v0 & 0x20000000) != 0 ? TypographyTokens.INSTANCE.getLabelSmallEmphasized() : arg61;
        this(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v62);
    }

    public Typography(TextStyle arg32, TextStyle arg33, TextStyle arg34, TextStyle arg35, TextStyle arg36, TextStyle arg37, TextStyle arg38, TextStyle arg39, TextStyle arg40, TextStyle arg41, TextStyle arg42, TextStyle arg43, TextStyle arg44, TextStyle arg45, TextStyle arg46) {
        this(arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46);
    }

    public Typography(TextStyle arg1, TextStyle arg2, TextStyle arg3, TextStyle arg4, TextStyle arg5, TextStyle arg6, TextStyle arg7, TextStyle arg8, TextStyle arg9, TextStyle arg10, TextStyle arg11, TextStyle arg12, TextStyle arg13, TextStyle arg14, TextStyle arg15, TextStyle arg16, TextStyle arg17, TextStyle arg18, TextStyle arg19, TextStyle arg20, TextStyle arg21, TextStyle arg22, TextStyle arg23, TextStyle arg24, TextStyle arg25, TextStyle arg26, TextStyle arg27, TextStyle arg28, TextStyle arg29, TextStyle arg30) {
        super();
        this.displayLarge = arg1;
        this.displayMedium = arg2;
        this.displaySmall = arg3;
        this.headlineLarge = arg4;
        this.headlineMedium = arg5;
        this.headlineSmall = arg6;
        this.titleLarge = arg7;
        this.titleMedium = arg8;
        this.titleSmall = arg9;
        this.bodyLarge = arg10;
        this.bodyMedium = arg11;
        this.bodySmall = arg12;
        this.labelLarge = arg13;
        this.labelMedium = arg14;
        this.labelSmall = arg15;
        this.displayLargeEmphasized = arg16;
        this.displayMediumEmphasized = arg17;
        this.displaySmallEmphasized = arg18;
        this.headlineLargeEmphasized = arg19;
        this.headlineMediumEmphasized = arg20;
        this.headlineSmallEmphasized = arg21;
        this.titleLargeEmphasized = arg22;
        this.titleMediumEmphasized = arg23;
        this.titleSmallEmphasized = arg24;
        this.bodyLargeEmphasized = arg25;
        this.bodyMediumEmphasized = arg26;
        this.bodySmallEmphasized = arg27;
        this.labelLargeEmphasized = arg28;
        this.labelMediumEmphasized = arg29;
        this.labelSmallEmphasized = arg30;
    }

    public Typography(TextStyle arg16, TextStyle arg17, TextStyle arg18, TextStyle arg19, TextStyle arg20, TextStyle arg21, TextStyle arg22, TextStyle arg23, TextStyle arg24, TextStyle arg25, TextStyle arg26, TextStyle arg27, TextStyle arg28, TextStyle arg29, TextStyle arg30, int arg31, DefaultConstructorMarker arg32) {
        int v0 = arg31;
        TextStyle v1 = (v0 & 1) != 0 ? TypographyTokens.INSTANCE.getDisplayLarge() : arg16;
        TextStyle v2 = (v0 & 2) != 0 ? TypographyTokens.INSTANCE.getDisplayMedium() : arg17;
        TextStyle v3 = (v0 & 4) != 0 ? TypographyTokens.INSTANCE.getDisplaySmall() : arg18;
        TextStyle v4 = (v0 & 8) != 0 ? TypographyTokens.INSTANCE.getHeadlineLarge() : arg19;
        TextStyle v5 = (v0 & 16) != 0 ? TypographyTokens.INSTANCE.getHeadlineMedium() : arg20;
        TextStyle v6 = (v0 & 0x20) != 0 ? TypographyTokens.INSTANCE.getHeadlineSmall() : arg21;
        TextStyle v7 = (v0 & 0x40) != 0 ? TypographyTokens.INSTANCE.getTitleLarge() : arg22;
        TextStyle v8 = (v0 & 0x80) != 0 ? TypographyTokens.INSTANCE.getTitleMedium() : arg23;
        TextStyle v9 = (v0 & 0x100) != 0 ? TypographyTokens.INSTANCE.getTitleSmall() : arg24;
        TextStyle v10 = (v0 & 0x200) != 0 ? TypographyTokens.INSTANCE.getBodyLarge() : arg25;
        TextStyle v11 = (v0 & 0x400) != 0 ? TypographyTokens.INSTANCE.getBodyMedium() : arg26;
        TextStyle v12 = (v0 & 0x800) != 0 ? TypographyTokens.INSTANCE.getBodySmall() : arg27;
        TextStyle v13 = (v0 & 0x1000) != 0 ? TypographyTokens.INSTANCE.getLabelLarge() : arg28;
        TextStyle v14 = (v0 & 0x2000) != 0 ? TypographyTokens.INSTANCE.getLabelMedium() : arg29;
        TextStyle v31 = (v0 & 0x4000) != 0 ? TypographyTokens.INSTANCE.getLabelSmall() : arg30;
        this(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v31);
    }

    public final Typography copy(TextStyle arg33, TextStyle arg34, TextStyle arg35, TextStyle arg36, TextStyle arg37, TextStyle arg38, TextStyle arg39, TextStyle arg40, TextStyle arg41, TextStyle arg42, TextStyle arg43, TextStyle arg44, TextStyle arg45, TextStyle arg46, TextStyle arg47) {
        return this.copy$material3(arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, this.displayLargeEmphasized, this.displayMediumEmphasized, this.displaySmallEmphasized, this.headlineLargeEmphasized, this.headlineMediumEmphasized, this.headlineSmallEmphasized, this.titleLargeEmphasized, this.titleMediumEmphasized, this.titleSmallEmphasized, this.bodyLargeEmphasized, this.bodyMediumEmphasized, this.bodySmallEmphasized, this.labelLargeEmphasized, this.labelMediumEmphasized, this.labelSmallEmphasized);
    }

    public static Typography copy$default(Typography arg16, TextStyle arg17, TextStyle arg18, TextStyle arg19, TextStyle arg20, TextStyle arg21, TextStyle arg22, TextStyle arg23, TextStyle arg24, TextStyle arg25, TextStyle arg26, TextStyle arg27, TextStyle arg28, TextStyle arg29, TextStyle arg30, TextStyle arg31, int arg32, Object arg33) {
        Typography v0 = arg16;
        int v1 = arg32;
        TextStyle v2 = (v1 & 1) != 0 ? v0.displayLarge : arg17;
        TextStyle v3 = (v1 & 2) != 0 ? v0.displayMedium : arg18;
        TextStyle v4 = (v1 & 4) != 0 ? v0.displaySmall : arg19;
        TextStyle v5 = (v1 & 8) != 0 ? v0.headlineLarge : arg20;
        TextStyle v6 = (v1 & 16) != 0 ? v0.headlineMedium : arg21;
        TextStyle v7 = (v1 & 0x20) != 0 ? v0.headlineSmall : arg22;
        TextStyle v8 = (v1 & 0x40) != 0 ? v0.titleLarge : arg23;
        TextStyle v9 = (v1 & 0x80) != 0 ? v0.titleMedium : arg24;
        TextStyle v10 = (v1 & 0x100) != 0 ? v0.titleSmall : arg25;
        TextStyle v11 = (v1 & 0x200) != 0 ? v0.bodyLarge : arg26;
        TextStyle v12 = (v1 & 0x400) != 0 ? v0.bodyMedium : arg27;
        TextStyle v13 = (v1 & 0x800) != 0 ? v0.bodySmall : arg28;
        TextStyle v14 = (v1 & 0x1000) != 0 ? v0.labelLarge : arg29;
        TextStyle v15 = (v1 & 0x2000) != 0 ? v0.labelMedium : arg30;
        TextStyle v32 = (v1 & 0x4000) != 0 ? v0.labelSmall : arg31;
        return v0.copy(v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v32);
    }

    public final Typography copy$material3(TextStyle arg32, TextStyle arg33, TextStyle arg34, TextStyle arg35, TextStyle arg36, TextStyle arg37, TextStyle arg38, TextStyle arg39, TextStyle arg40, TextStyle arg41, TextStyle arg42, TextStyle arg43, TextStyle arg44, TextStyle arg45, TextStyle arg46, TextStyle arg47, TextStyle arg48, TextStyle arg49, TextStyle arg50, TextStyle arg51, TextStyle arg52, TextStyle arg53, TextStyle arg54, TextStyle arg55, TextStyle arg56, TextStyle arg57, TextStyle arg58, TextStyle arg59, TextStyle arg60, TextStyle arg61) {
        return new Typography(arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, arg54, arg55, arg56, arg57, arg58, arg59, arg60, arg61);
    }

    public static Typography copy$material3$default(Typography arg17, TextStyle arg18, TextStyle arg19, TextStyle arg20, TextStyle arg21, TextStyle arg22, TextStyle arg23, TextStyle arg24, TextStyle arg25, TextStyle arg26, TextStyle arg27, TextStyle arg28, TextStyle arg29, TextStyle arg30, TextStyle arg31, TextStyle arg32, TextStyle arg33, TextStyle arg34, TextStyle arg35, TextStyle arg36, TextStyle arg37, TextStyle arg38, TextStyle arg39, TextStyle arg40, TextStyle arg41, TextStyle arg42, TextStyle arg43, TextStyle arg44, TextStyle arg45, TextStyle arg46, TextStyle arg47, int arg48, Object arg49) {
        TextStyle v48;
        Typography v0 = arg17;
        int v1 = arg48;
        TextStyle v2 = (v1 & 1) != 0 ? v0.displayLarge : arg18;
        TextStyle v3 = (v1 & 2) != 0 ? v0.displayMedium : arg19;
        TextStyle v4 = (v1 & 4) != 0 ? v0.displaySmall : arg20;
        TextStyle v5 = (v1 & 8) != 0 ? v0.headlineLarge : arg21;
        TextStyle v6 = (v1 & 16) != 0 ? v0.headlineMedium : arg22;
        TextStyle v7 = (v1 & 0x20) != 0 ? v0.headlineSmall : arg23;
        TextStyle v8 = (v1 & 0x40) != 0 ? v0.titleLarge : arg24;
        TextStyle v9 = (v1 & 0x80) != 0 ? v0.titleMedium : arg25;
        TextStyle v10 = (v1 & 0x100) != 0 ? v0.titleSmall : arg26;
        TextStyle v11 = (v1 & 0x200) != 0 ? v0.bodyLarge : arg27;
        TextStyle v12 = (v1 & 0x400) != 0 ? v0.bodyMedium : arg28;
        TextStyle v13 = (v1 & 0x800) != 0 ? v0.bodySmall : arg29;
        TextStyle v14 = (v1 & 0x1000) != 0 ? v0.labelLarge : arg30;
        TextStyle v15 = (v1 & 0x2000) != 0 ? v0.labelMedium : arg31;
        arg18 = v2;
        v2 = (v1 & 0x4000) != 0 ? v0.labelSmall : arg32;
        TextStyle v1_1 = (v1 & 0x8000) != 0 ? v0.displayLargeEmphasized : arg33;
        arg19 = v1_1;
        v1_1 = (arg48 & 0x10000) != 0 ? v0.displayMediumEmphasized : arg34;
        arg20 = v1_1;
        v1_1 = (arg48 & 0x20000) != 0 ? v0.displaySmallEmphasized : arg35;
        arg21 = v1_1;
        v1_1 = (arg48 & 0x40000) != 0 ? v0.headlineLargeEmphasized : arg36;
        arg22 = v1_1;
        v1_1 = (arg48 & 0x80000) != 0 ? v0.headlineMediumEmphasized : arg37;
        arg23 = v1_1;
        v1_1 = (arg48 & 0x100000) != 0 ? v0.headlineSmallEmphasized : arg38;
        arg24 = v1_1;
        v1_1 = (arg48 & 0x200000) != 0 ? v0.titleLargeEmphasized : arg39;
        arg25 = v1_1;
        v1_1 = (arg48 & 0x400000) != 0 ? v0.titleMediumEmphasized : arg40;
        arg26 = v1_1;
        v1_1 = (arg48 & 0x800000) != 0 ? v0.titleSmallEmphasized : arg41;
        arg27 = v1_1;
        v1_1 = (arg48 & 0x1000000) != 0 ? v0.bodyLargeEmphasized : arg42;
        arg28 = v1_1;
        v1_1 = (arg48 & 0x2000000) != 0 ? v0.bodyMediumEmphasized : arg43;
        arg29 = v1_1;
        v1_1 = (arg48 & 0x4000000) != 0 ? v0.bodySmallEmphasized : arg44;
        arg30 = v1_1;
        v1_1 = (arg48 & 0x8000000) != 0 ? v0.labelLargeEmphasized : arg45;
        arg31 = v1_1;
        v1_1 = (arg48 & 0x10000000) != 0 ? v0.labelMediumEmphasized : arg46;
        if((arg48 & 0x20000000) != 0) {
            arg47 = v1_1;
            v48 = v0.labelSmallEmphasized;
        }
        else {
            v48 = arg47;
            arg47 = v1_1;
        }

        return v0.copy$material3(arg18, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v2, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg47, v48);
    }

    public boolean equals(Object arg5) {
        if(this == (((Typography)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Typography)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displayLarge, ((Typography)arg5).displayLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displayMedium, ((Typography)arg5).displayMedium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displaySmall, ((Typography)arg5).displaySmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineLarge, ((Typography)arg5).headlineLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineMedium, ((Typography)arg5).headlineMedium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineSmall, ((Typography)arg5).headlineSmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleLarge, ((Typography)arg5).titleLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleMedium, ((Typography)arg5).titleMedium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleSmall, ((Typography)arg5).titleSmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodyLarge, ((Typography)arg5).bodyLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodyMedium, ((Typography)arg5).bodyMedium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodySmall, ((Typography)arg5).bodySmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelLarge, ((Typography)arg5).labelLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelMedium, ((Typography)arg5).labelMedium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelSmall, ((Typography)arg5).labelSmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displayLargeEmphasized, ((Typography)arg5).displayLargeEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displayMediumEmphasized, ((Typography)arg5).displayMediumEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displaySmallEmphasized, ((Typography)arg5).displaySmallEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineLargeEmphasized, ((Typography)arg5).headlineLargeEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineMediumEmphasized, ((Typography)arg5).headlineMediumEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.headlineSmallEmphasized, ((Typography)arg5).headlineSmallEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleLargeEmphasized, ((Typography)arg5).titleLargeEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleMediumEmphasized, ((Typography)arg5).titleMediumEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.titleSmallEmphasized, ((Typography)arg5).titleSmallEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodyLargeEmphasized, ((Typography)arg5).bodyLargeEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodyMediumEmphasized, ((Typography)arg5).bodyMediumEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bodySmallEmphasized, ((Typography)arg5).bodySmallEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelLargeEmphasized, ((Typography)arg5).labelLargeEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelMediumEmphasized, ((Typography)arg5).labelMediumEmphasized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.labelSmallEmphasized, ((Typography)arg5).labelSmallEmphasized)) {
            return 0;
        }

        return 1;
    }

    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    public final TextStyle getBodyLargeEmphasized$material3() {
        return this.bodyLargeEmphasized;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getBodyMediumEmphasized$material3() {
        return this.bodyMediumEmphasized;
    }

    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    public final TextStyle getBodySmallEmphasized$material3() {
        return this.bodySmallEmphasized;
    }

    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    public final TextStyle getDisplayLargeEmphasized$material3() {
        return this.displayLargeEmphasized;
    }

    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    public final TextStyle getDisplayMediumEmphasized$material3() {
        return this.displayMediumEmphasized;
    }

    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    public final TextStyle getDisplaySmallEmphasized$material3() {
        return this.displaySmallEmphasized;
    }

    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    public final TextStyle getHeadlineLargeEmphasized$material3() {
        return this.headlineLargeEmphasized;
    }

    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    public final TextStyle getHeadlineMediumEmphasized$material3() {
        return this.headlineMediumEmphasized;
    }

    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    public final TextStyle getHeadlineSmallEmphasized$material3() {
        return this.headlineSmallEmphasized;
    }

    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    public final TextStyle getLabelLargeEmphasized$material3() {
        return this.labelLargeEmphasized;
    }

    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    public final TextStyle getLabelMediumEmphasized$material3() {
        return this.labelMediumEmphasized;
    }

    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    public final TextStyle getLabelSmallEmphasized$material3() {
        return this.labelSmallEmphasized;
    }

    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    public final TextStyle getTitleLargeEmphasized$material3() {
        return this.titleLargeEmphasized;
    }

    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    public final TextStyle getTitleMediumEmphasized$material3() {
        return this.titleMediumEmphasized;
    }

    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public final TextStyle getTitleSmallEmphasized$material3() {
        return this.titleSmallEmphasized;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.displayLarge.hashCode() * 0x1F + this.displayMedium.hashCode()) * 0x1F + this.displaySmall.hashCode()) * 0x1F + this.headlineLarge.hashCode()) * 0x1F + this.headlineMedium.hashCode()) * 0x1F + this.headlineSmall.hashCode()) * 0x1F + this.titleLarge.hashCode()) * 0x1F + this.titleMedium.hashCode()) * 0x1F + this.titleSmall.hashCode()) * 0x1F + this.bodyLarge.hashCode()) * 0x1F + this.bodyMedium.hashCode()) * 0x1F + this.bodySmall.hashCode()) * 0x1F + this.labelLarge.hashCode()) * 0x1F + this.labelMedium.hashCode()) * 0x1F + this.labelSmall.hashCode()) * 0x1F + this.displayLargeEmphasized.hashCode()) * 0x1F + this.displayMediumEmphasized.hashCode()) * 0x1F + this.displaySmallEmphasized.hashCode()) * 0x1F + this.headlineLargeEmphasized.hashCode()) * 0x1F + this.headlineMediumEmphasized.hashCode()) * 0x1F + this.headlineSmallEmphasized.hashCode()) * 0x1F + this.titleLargeEmphasized.hashCode()) * 0x1F + this.titleMediumEmphasized.hashCode()) * 0x1F + this.titleSmallEmphasized.hashCode()) * 0x1F + this.bodyLargeEmphasized.hashCode()) * 0x1F + this.bodyMediumEmphasized.hashCode()) * 0x1F + this.bodySmallEmphasized.hashCode()) * 0x1F + this.labelLargeEmphasized.hashCode()) * 0x1F + this.labelMediumEmphasized.hashCode()) * 0x1F + this.labelSmallEmphasized.hashCode();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("Typography(displayLarge=");
        v0.append(this.displayLarge).append(", displayMedium=").append(this.displayMedium).append(",displaySmall=").append(this.displaySmall).append(", headlineLarge=").append(this.headlineLarge).append(", headlineMedium=").append(this.headlineMedium).append(", headlineSmall=").append(this.headlineSmall).append(", titleLarge=").append(this.titleLarge).append(", titleMedium=").append(this.titleMedium).append(", titleSmall=").append(this.titleSmall).append(", bodyLarge=").append(this.bodyLarge).append(", bodyMedium=").append(this.bodyMedium).append(", bodySmall=");
        v0.append(this.bodySmall).append(", labelLarge=").append(this.labelLarge).append(", labelMedium=").append(this.labelMedium).append(", labelSmall=").append(this.labelSmall).append(", displayLargeEmphasized=").append(this.displayLargeEmphasized).append(", displayMediumEmphasized=").append(this.displayMediumEmphasized).append(", displaySmallEmphasized=").append(this.displaySmallEmphasized).append(", headlineLargeEmphasized=").append(this.headlineLargeEmphasized).append(", headlineMediumEmphasized=").append(this.headlineMediumEmphasized).append(", headlineSmallEmphasized=").append(this.headlineSmallEmphasized).append(", titleLargeEmphasized=").append(this.titleLargeEmphasized).append(", titleMediumEmphasized=").append(this.titleMediumEmphasized);
        v0.append(", titleSmallEmphasized=").append(this.titleSmallEmphasized).append(", bodyLargeEmphasized=").append(this.bodyLargeEmphasized).append(", bodyMediumEmphasized=").append(this.bodyMediumEmphasized).append(", bodySmallEmphasized=").append(this.bodySmallEmphasized).append(", labelLargeEmphasized=").append(this.labelLargeEmphasized).append(", labelMediumEmphasized=").append(this.labelMediumEmphasized).append(", labelSmallEmphasized=").append(this.labelSmallEmphasized).append(')');
        return v0.toString();
    }
}

