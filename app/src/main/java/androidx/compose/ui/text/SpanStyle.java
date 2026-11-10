package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b2\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B¿\u0001\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"B©\u0001\b\u0017\u0012\b\b\u0002\u0010#\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C¢\u0006\u0004\b!\u0010$Bµ\u0001\b\u0017\u0012\b\b\u0002\u0010#\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E¢\u0006\u0004\b!\u0010%BÁ\u0001\b\u0016\u0012\b\b\u0002\u0010#\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010&BË\u0001\b\u0016\u0012\b\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020*\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010+J\u0014\u0010P\u001A\u00020\u00002\n\b\u0002\u0010Q\u001A\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010R\u001A\u00020\u00002\u0006\u0010Q\u001A\u00020\u0000H\u0087\u0002J¯\u0001\u0010S\u001A\u00020\u00002\b\b\u0002\u0010#\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00052\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0007¢\u0006\u0004\bT\u0010UJ»\u0001\u0010S\u001A\u00020\u00002\b\b\u0002\u0010#\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00052\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0007¢\u0006\u0004\bV\u0010WJÅ\u0001\u0010S\u001A\u00020\u00002\b\b\u0002\u0010#\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00052\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\bX\u0010YJÏ\u0001\u0010S\u001A\u00020\u00002\b\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020*2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00052\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001A\u00020]2\b\u0010Q\u001A\u0004\u0018\u00010^H\u0096\u0002J\u0015\u0010_\u001A\u00020]2\u0006\u0010Q\u001A\u00020\u0000H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001A\u00020]2\u0006\u0010Q\u001A\u00020\u0000H\u0000¢\u0006\u0002\bbJ\b\u0010c\u001A\u00020dH\u0016J\r\u0010e\u001A\u00020dH\u0000¢\u0006\u0002\bfJ\b\u0010g\u001A\u00020\u000FH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u00100\u001A\u0004\b.\u0010/R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b5\u00106R\u0013\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b7\u00108R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R\u0013\u0010\u0010\u001A\u00020\u0005¢\u0006\n\n\u0002\u00100\u001A\u0004\b;\u0010/R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001A\u0004\b<\u0010=R\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001A\u0004\b>\u0010?R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001A\u0004\b@\u0010AR\u0013\u0010\u0017\u001A\u00020\u0018¢\u0006\n\n\u0002\u00100\u001A\u0004\bB\u0010/R\u0013\u0010\u0019\u001A\u0004\u0018\u00010\u001A¢\u0006\b\n\u0000\u001A\u0004\bC\u0010DR\u0013\u0010\u001B\u001A\u0004\u0018\u00010\u001C¢\u0006\b\n\u0000\u001A\u0004\bE\u0010FR\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001E¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR\u0013\u0010\u001F\u001A\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001A\u0004\bI\u0010JR\u0011\u0010#\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\bK\u0010/R\u0013\u0010\'\u001A\u0004\u0018\u00010(8F¢\u0006\u0006\u001A\u0004\bL\u0010MR\u0011\u0010)\u001A\u00020*8F¢\u0006\u0006\u001A\u0004\bN\u0010O¨\u0006h"}, d2={"Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "textForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "Landroidx/compose/ui/graphics/Color;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "color", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextForegroundStyle$ui_text", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "getFontSize-XSAIIZE", "()J", "J", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getColor-0d7_KjU", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "()F", "merge", "other", "plus", "copy", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "copy-2BkPm_w", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-GSF8kmg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-NcG25M8", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "", "hasSameLayoutAffectingAttributes", "hasSameLayoutAffectingAttributes$ui_text", "hasSameNonLayoutAttributes", "hasSameNonLayoutAttributes$ui_text", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SpanStyle implements Annotation {
    public static final int $stable;
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;

    static {
    }

    public SpanStyle(long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, PlatformSpanStyle arg40, DrawStyle arg41, int arg42, DefaultConstructorMarker arg43) {
        int v0 = arg42;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg24;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg26;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg27;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg28;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg29;
        String v10 = (v0 & 0x40) != 0 ? null : arg30;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg31;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg33;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg34;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg35;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg38;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg39;
        PlatformSpanStyle v2 = (v0 & 0x4000) != 0 ? null : arg40;
        DrawStyle v0_1 = (v0 & 0x8000) != 0 ? null : arg41;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v0_1, null);
    }

    private SpanStyle(long arg24, long arg26, FontWeight arg28, FontStyle arg29, FontSynthesis arg30, FontFamily arg31, String arg32, long arg33, BaselineShift arg35, TextGeometricTransform arg36, LocaleList arg37, long arg38, TextDecoration arg40, Shadow arg41) {
        this(TextForegroundStyle.Companion.from-8_81llA(arg24), arg26, arg28, arg29, arg30, arg31, arg32, arg33, arg35, arg36, arg37, arg38, arg40, arg41, null, null, 0x8000, null);
    }

    public SpanStyle(TextForegroundStyle arg25, long arg26, FontWeight arg28, FontStyle arg29, FontSynthesis arg30, FontFamily arg31, String arg32, long arg33, BaselineShift arg35, TextGeometricTransform arg36, LocaleList arg37, long arg38, TextDecoration arg40, Shadow arg41, PlatformSpanStyle arg42, DrawStyle arg43, int arg44, DefaultConstructorMarker arg45) {
        int v0 = arg44;
        long v5 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg26;
        FontWeight v2 = null;
        FontWeight v7 = (v0 & 4) != 0 ? v2 : arg28;
        FontStyle v8 = (v0 & 8) != 0 ? ((FontStyle)v2) : arg29;
        FontSynthesis v9 = (v0 & 16) != 0 ? ((FontSynthesis)v2) : arg30;
        FontFamily v10 = (v0 & 0x20) != 0 ? ((FontFamily)v2) : arg31;
        String v11 = (v0 & 0x40) != 0 ? ((String)v2) : arg32;
        long v12 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg33;
        BaselineShift v14 = (v0 & 0x100) != 0 ? ((BaselineShift)v2) : arg35;
        TextGeometricTransform v15 = (v0 & 0x200) != 0 ? ((TextGeometricTransform)v2) : arg36;
        LocaleList v16 = (v0 & 0x400) != 0 ? ((LocaleList)v2) : arg37;
        long v17 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        TextDecoration v19 = (v0 & 0x1000) != 0 ? ((TextDecoration)v2) : arg40;
        Shadow v20 = (v0 & 0x2000) != 0 ? ((Shadow)v2) : arg41;
        PlatformSpanStyle v21 = (v0 & 0x4000) != 0 ? ((PlatformSpanStyle)v2) : arg42;
        DrawStyle v22 = (v0 & 0x8000) != 0 ? ((DrawStyle)v2) : arg43;
        this(arg25, v5, v7, v8, v9, v10, v11, v12, v14, v15, v16, v17, v19, v20, v21, v22, null);
    }

    public SpanStyle(long arg20, long arg22, FontWeight arg24, FontStyle arg25, FontSynthesis arg26, FontFamily arg27, String arg28, long arg29, BaselineShift arg31, TextGeometricTransform arg32, LocaleList arg33, long arg34, TextDecoration arg36, Shadow arg37, int arg38, DefaultConstructorMarker arg39) {
        int v0 = arg38;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg22;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg24;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg25;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg26;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg27;
        String v10 = (v0 & 0x40) != 0 ? null : arg28;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg29;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg31;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg32;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg33;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg36;
        Shadow v0_1 = (v0 & 0x2000) != 0 ? null : arg37;
        this(v1, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.") public SpanStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DefaultConstructorMarker arg19) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18);
    }

    private SpanStyle(long arg24, long arg26, FontWeight arg28, FontStyle arg29, FontSynthesis arg30, FontFamily arg31, String arg32, long arg33, BaselineShift arg35, TextGeometricTransform arg36, LocaleList arg37, long arg38, TextDecoration arg40, Shadow arg41, PlatformSpanStyle arg42) {
        this(TextForegroundStyle.Companion.from-8_81llA(arg24), arg26, arg28, arg29, arg30, arg31, arg32, arg33, arg35, arg36, arg37, arg38, arg40, arg41, arg42, null, 0x8000, null);
    }

    public SpanStyle(long arg21, long arg23, FontWeight arg25, FontStyle arg26, FontSynthesis arg27, FontFamily arg28, String arg29, long arg30, BaselineShift arg32, TextGeometricTransform arg33, LocaleList arg34, long arg35, TextDecoration arg37, Shadow arg38, PlatformSpanStyle arg39, int arg40, DefaultConstructorMarker arg41) {
        int v0 = arg40;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg23;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg25;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg26;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg27;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg28;
        String v10 = (v0 & 0x40) != 0 ? null : arg29;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg30;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg32;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg33;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg34;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg35;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg37;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg38;
        PlatformSpanStyle v0_1 = (v0 & 0x4000) != 0 ? null : arg39;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.") public SpanStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, PlatformSpanStyle arg19, DefaultConstructorMarker arg20) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19);
    }

    private SpanStyle(long arg23, long arg25, FontWeight arg27, FontStyle arg28, FontSynthesis arg29, FontFamily arg30, String arg31, long arg32, BaselineShift arg34, TextGeometricTransform arg35, LocaleList arg36, long arg37, TextDecoration arg39, Shadow arg40, PlatformSpanStyle arg41, DrawStyle arg42) {
        this(TextForegroundStyle.Companion.from-8_81llA(arg23), arg25, arg27, arg28, arg29, arg30, arg31, arg32, arg34, arg35, arg36, arg37, arg39, arg40, arg41, arg42, null);
    }

    public SpanStyle(TextForegroundStyle arg1, long arg2, FontWeight arg4, FontStyle arg5, FontSynthesis arg6, FontFamily arg7, String arg8, long arg9, BaselineShift arg11, TextGeometricTransform arg12, LocaleList arg13, long arg14, TextDecoration arg16, Shadow arg17, PlatformSpanStyle arg18, DrawStyle arg19, DefaultConstructorMarker arg20) {
        this(arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9, arg11, arg12, arg13, arg14, arg16, arg17, arg18, arg19);
    }

    public SpanStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, PlatformSpanStyle arg19, DrawStyle arg20, DefaultConstructorMarker arg21) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20);
    }

    private SpanStyle(Brush arg23, float arg24, long arg25, FontWeight arg27, FontStyle arg28, FontSynthesis arg29, FontFamily arg30, String arg31, long arg32, BaselineShift arg34, TextGeometricTransform arg35, LocaleList arg36, long arg37, TextDecoration arg39, Shadow arg40, PlatformSpanStyle arg41, DrawStyle arg42) {
        this(TextForegroundStyle.Companion.from(arg23, arg24), arg25, arg27, arg28, arg29, arg30, arg31, arg32, arg34, arg35, arg36, arg37, arg39, arg40, arg41, arg42, null);
    }

    public SpanStyle(Brush arg25, float arg26, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, PlatformSpanStyle arg43, DrawStyle arg44, int arg45, DefaultConstructorMarker arg46) {
        int v0 = arg45;
        float v4 = (v0 & 2) != 0 ? NaNf : arg26;
        long v5 = (v0 & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg27;
        FontWeight v2 = null;
        FontWeight v7 = (v0 & 8) != 0 ? v2 : arg29;
        FontStyle v8 = (v0 & 16) != 0 ? ((FontStyle)v2) : arg30;
        FontSynthesis v9 = (v0 & 0x20) != 0 ? ((FontSynthesis)v2) : arg31;
        FontFamily v10 = (v0 & 0x40) != 0 ? ((FontFamily)v2) : arg32;
        String v11 = (v0 & 0x80) != 0 ? ((String)v2) : arg33;
        long v12 = (v0 & 0x100) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg34;
        BaselineShift v14 = (v0 & 0x200) != 0 ? ((BaselineShift)v2) : arg36;
        TextGeometricTransform v15 = (v0 & 0x400) != 0 ? ((TextGeometricTransform)v2) : arg37;
        LocaleList v16 = (v0 & 0x800) != 0 ? ((LocaleList)v2) : arg38;
        long v17 = (v0 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg39;
        TextDecoration v19 = (v0 & 0x2000) != 0 ? ((TextDecoration)v2) : arg41;
        Shadow v20 = (v0 & 0x4000) != 0 ? ((Shadow)v2) : arg42;
        PlatformSpanStyle v21 = (0x8000 & v0) != 0 ? ((PlatformSpanStyle)v2) : arg43;
        DrawStyle v22 = (v0 & 0x10000) != 0 ? ((DrawStyle)v2) : arg44;
        this(arg25, v4, v5, v7, v8, v9, v10, v11, v12, v14, v15, v16, v17, v19, v20, v21, v22, null);
    }

    public SpanStyle(Brush arg1, float arg2, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, PlatformSpanStyle arg19, DrawStyle arg20, DefaultConstructorMarker arg21) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20);
    }

    private SpanStyle(TextForegroundStyle arg1, long arg2, FontWeight arg4, FontStyle arg5, FontSynthesis arg6, FontFamily arg7, String arg8, long arg9, BaselineShift arg11, TextGeometricTransform arg12, LocaleList arg13, long arg14, TextDecoration arg16, Shadow arg17, PlatformSpanStyle arg18, DrawStyle arg19) {
        super();
        this.textForegroundStyle = arg1;
        this.fontSize = arg2;
        this.fontWeight = arg4;
        this.fontStyle = arg5;
        this.fontSynthesis = arg6;
        this.fontFamily = arg7;
        this.fontFeatureSettings = arg8;
        this.letterSpacing = arg9;
        this.baselineShift = arg11;
        this.textGeometricTransform = arg12;
        this.localeList = arg13;
        this.background = arg14;
        this.textDecoration = arg16;
        this.shadow = arg17;
        this.platformStyle = arg18;
        this.drawStyle = arg19;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.") public final SpanStyle copy-2BkPm_w(long arg23, long arg25, FontWeight arg27, FontStyle arg28, FontSynthesis arg29, FontFamily arg30, String arg31, long arg32, BaselineShift arg34, TextGeometricTransform arg35, LocaleList arg36, long arg37, TextDecoration arg39, Shadow arg40, PlatformSpanStyle arg41) {
        long v0 = arg23;
        SpanStyle v2 = null;
        TextForegroundStyle v0_1 = Color.equals-impl0(v0, this.getColor-0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(v0);
        this(v0_1, arg25, arg27, arg28, arg29, arg30, arg31, arg32, arg34, arg35, arg36, arg37, arg39, arg40, arg41, null, 0x8000, null);
        return v2;
    }

    public static SpanStyle copy-2BkPm_w$default(SpanStyle arg18, long arg19, long arg21, FontWeight arg23, FontStyle arg24, FontSynthesis arg25, FontFamily arg26, String arg27, long arg28, BaselineShift arg30, TextGeometricTransform arg31, LocaleList arg32, long arg33, TextDecoration arg35, Shadow arg36, PlatformSpanStyle arg37, int arg38, Object arg39) {
        SpanStyle v0 = arg18;
        int v1 = arg38;
        long v2 = (v1 & 1) != 0 ? v0.getColor-0d7_KjU() : arg19;
        long v4 = (v1 & 2) != 0 ? v0.fontSize : arg21;
        FontWeight v6 = (v1 & 4) != 0 ? v0.fontWeight : arg23;
        FontStyle v7 = (v1 & 8) != 0 ? v0.fontStyle : arg24;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.fontSynthesis : arg25;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.fontFamily : arg26;
        String v10 = (v1 & 0x40) != 0 ? v0.fontFeatureSettings : arg27;
        long v11 = (v1 & 0x80) != 0 ? v0.letterSpacing : arg28;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.baselineShift : arg30;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.textGeometricTransform : arg31;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.localeList : arg32;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.background : arg33;
        arg19 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.textDecoration : arg35;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.shadow : arg36;
        PlatformSpanStyle v38 = (v1 & 0x4000) != 0 ? v0.platformStyle : arg37;
        return v0.copy-2BkPm_w(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg19, v2_1, v3, v38);
    }

    public final SpanStyle copy-GSF8kmg(long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, PlatformSpanStyle arg40, DrawStyle arg41) {
        long v0 = arg22;
        SpanStyle v2 = null;
        TextForegroundStyle v0_1 = Color.equals-impl0(v0, this.getColor-0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(v0);
        this(v0_1, arg24, arg26, arg27, arg28, arg29, arg30, arg31, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, null);
        return v2;
    }

    public static SpanStyle copy-GSF8kmg$default(SpanStyle arg19, long arg20, long arg22, FontWeight arg24, FontStyle arg25, FontSynthesis arg26, FontFamily arg27, String arg28, long arg29, BaselineShift arg31, TextGeometricTransform arg32, LocaleList arg33, long arg34, TextDecoration arg36, Shadow arg37, PlatformSpanStyle arg38, DrawStyle arg39, int arg40, Object arg41) {
        SpanStyle v0 = arg19;
        int v1 = arg40;
        long v2 = (v1 & 1) != 0 ? v0.getColor-0d7_KjU() : arg20;
        long v4 = (v1 & 2) != 0 ? v0.fontSize : arg22;
        FontWeight v6 = (v1 & 4) != 0 ? v0.fontWeight : arg24;
        FontStyle v7 = (v1 & 8) != 0 ? v0.fontStyle : arg25;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.fontSynthesis : arg26;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.fontFamily : arg27;
        String v10 = (v1 & 0x40) != 0 ? v0.fontFeatureSettings : arg28;
        long v11 = (v1 & 0x80) != 0 ? v0.letterSpacing : arg29;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.baselineShift : arg31;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.textGeometricTransform : arg32;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.localeList : arg33;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.background : arg34;
        arg20 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.textDecoration : arg36;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.shadow : arg37;
        TextDecoration v22 = v2_1;
        PlatformSpanStyle v2_2 = (v1 & 0x4000) != 0 ? v0.platformStyle : arg38;
        DrawStyle v40 = (v1 & 0x8000) != 0 ? v0.drawStyle : arg39;
        return v0.copy-GSF8kmg(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg20, v22, v3, v2_2, v40);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.") public final SpanStyle copy-IuqyXdg(long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39) {
        SpanStyle v0 = this;
        long v1 = arg22;
        SpanStyle v3 = null;
        TextForegroundStyle v1_1 = Color.equals-impl0(v1, v0.getColor-0d7_KjU()) ? v0.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(v1);
        this(v1_1, arg24, arg26, arg27, arg28, arg29, arg30, arg31, arg33, arg34, arg35, arg36, arg38, arg39, v0.platformStyle, v0.drawStyle, null);
        return v3;
    }

    public static SpanStyle copy-IuqyXdg$default(SpanStyle arg18, long arg19, long arg21, FontWeight arg23, FontStyle arg24, FontSynthesis arg25, FontFamily arg26, String arg27, long arg28, BaselineShift arg30, TextGeometricTransform arg31, LocaleList arg32, long arg33, TextDecoration arg35, Shadow arg36, int arg37, Object arg38) {
        SpanStyle v0 = arg18;
        int v1 = arg37;
        long v2 = (v1 & 1) != 0 ? v0.getColor-0d7_KjU() : arg19;
        long v4 = (v1 & 2) != 0 ? v0.fontSize : arg21;
        FontWeight v6 = (v1 & 4) != 0 ? v0.fontWeight : arg23;
        FontStyle v7 = (v1 & 8) != 0 ? v0.fontStyle : arg24;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.fontSynthesis : arg25;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.fontFamily : arg26;
        String v10 = (v1 & 0x40) != 0 ? v0.fontFeatureSettings : arg27;
        long v11 = (v1 & 0x80) != 0 ? v0.letterSpacing : arg28;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.baselineShift : arg30;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.textGeometricTransform : arg31;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.localeList : arg32;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.background : arg33;
        arg19 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.textDecoration : arg35;
        Shadow v37 = (v1 & 0x2000) != 0 ? v0.shadow : arg36;
        return v0.copy-IuqyXdg(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg19, v2_1, v37);
    }

    public final SpanStyle copy-NcG25M8(Brush arg22, float arg23, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, PlatformSpanStyle arg40, DrawStyle arg41) {
        return new SpanStyle(TextForegroundStyle.Companion.from(arg22, arg23), arg24, arg26, arg27, arg28, arg29, arg30, arg31, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, null);
    }

    public static SpanStyle copy-NcG25M8$default(SpanStyle arg17, Brush arg18, float arg19, long arg20, FontWeight arg22, FontStyle arg23, FontSynthesis arg24, FontFamily arg25, String arg26, long arg27, BaselineShift arg29, TextGeometricTransform arg30, LocaleList arg31, long arg32, TextDecoration arg34, Shadow arg35, PlatformSpanStyle arg36, DrawStyle arg37, int arg38, Object arg39) {
        long v22;
        Shadow v37;
        LocaleList v33;
        TextGeometricTransform v32;
        BaselineShift v31;
        long v29;
        String v28;
        FontFamily v27;
        FontSynthesis v26;
        FontStyle v25;
        FontWeight v24;
        TextDecoration v36;
        long v34;
        DrawStyle v39;
        PlatformSpanStyle v38;
        SpanStyle v0 = arg17;
        int v1 = arg38;
        float v2 = (v1 & 2) != 0 ? v0.getAlpha() : arg19;
        long v3 = (v1 & 4) != 0 ? v0.fontSize : arg20;
        FontWeight v5 = (v1 & 8) != 0 ? v0.fontWeight : arg22;
        FontStyle v6 = (v1 & 16) != 0 ? v0.fontStyle : arg23;
        FontSynthesis v7 = (v1 & 0x20) != 0 ? v0.fontSynthesis : arg24;
        FontFamily v8 = (v1 & 0x40) != 0 ? v0.fontFamily : arg25;
        String v9 = (v1 & 0x80) != 0 ? v0.fontFeatureSettings : arg26;
        long v10 = (v1 & 0x100) != 0 ? v0.letterSpacing : arg27;
        BaselineShift v12 = (v1 & 0x200) != 0 ? v0.baselineShift : arg29;
        TextGeometricTransform v13 = (v1 & 0x400) != 0 ? v0.textGeometricTransform : arg30;
        LocaleList v14 = (v1 & 0x800) != 0 ? v0.localeList : arg31;
        arg19 = v2;
        arg20 = v3;
        long v2_1 = (v1 & 0x1000) != 0 ? v0.background : arg32;
        TextDecoration v4 = (v1 & 0x2000) != 0 ? v0.textDecoration : arg34;
        Shadow v15 = (v1 & 0x4000) != 0 ? v0.shadow : arg35;
        PlatformSpanStyle v1_1 = (v1 & 0x8000) != 0 ? v0.platformStyle : arg36;
        if((arg38 & 0x10000) != 0) {
            v38 = v1_1;
            v39 = v0.drawStyle;
            v34 = v2_1;
            v36 = v4;
            v24 = v5;
            v25 = v6;
            v26 = v7;
            v27 = v8;
            v28 = v9;
            v29 = v10;
            v31 = v12;
            v32 = v13;
            v33 = v14;
            v37 = v15;
            v22 = arg20;
        }
        else {
            v39 = arg37;
            v38 = v1_1;
            v22 = arg20;
            v34 = v2_1;
            v36 = v4;
            v24 = v5;
            v25 = v6;
            v26 = v7;
            v27 = v8;
            v28 = v9;
            v29 = v10;
            v31 = v12;
            v32 = v13;
            v33 = v14;
            v37 = v15;
        }

        return v0.copy-NcG25M8(arg18, arg19, v22, v24, v25, v26, v27, v28, v29, v31, v32, v33, v34, v36, v37, v38, v39);
    }

    public boolean equals(Object arg4) {
        if(this == (((SpanStyle)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SpanStyle)) {
            return 0;
        }

        if((this.hasSameLayoutAffectingAttributes$ui_text(((SpanStyle)arg4))) && (this.hasSameNonLayoutAttributes$ui_text(((SpanStyle)arg4)))) {
            return 1;
        }

        return 0;
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.baselineShift;
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    public final long getColor-0d7_KjU() {
        return this.textForegroundStyle.getColor-0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final long getFontSize-XSAIIZE() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.fontStyle;
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final TextForegroundStyle getTextForegroundStyle$ui_text() {
        return this.textForegroundStyle;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text(SpanStyle arg8) {
        if(this == arg8) {
            return 1;
        }

        if(!TextUnit.equals-impl0(this.fontSize, arg8.fontSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontWeight, arg8.fontWeight)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontStyle, arg8.fontStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontSynthesis, arg8.fontSynthesis)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamily, arg8.fontFamily)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFeatureSettings, arg8.fontFeatureSettings)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.letterSpacing, arg8.letterSpacing)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.baselineShift, arg8.baselineShift)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textGeometricTransform, arg8.textGeometricTransform)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.localeList, arg8.localeList)) {
            return 0;
        }

        if(!Color.equals-impl0(this.background, arg8.background)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformStyle, arg8.platformStyle)) {
            return 0;
        }

        return 1;
    }

    public final boolean hasSameNonLayoutAttributes$ui_text(SpanStyle arg4) {
        if(!Intrinsics.areEqual(this.textForegroundStyle, arg4.textForegroundStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textDecoration, arg4.textDecoration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shadow, arg4.shadow)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.drawStyle, arg4.drawStyle)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = Color.hashCode-impl(this.getColor-0d7_KjU()) * 0x1F;
        Brush v1 = this.getBrush();
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (((v0 + v1_1) * 0x1F + Float.hashCode(this.getAlpha())) * 0x1F + TextUnit.hashCode-impl(this.fontSize)) * 0x1F;
        FontWeight v1_2 = this.fontWeight;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontStyle v1_3 = this.fontStyle;
        v1_1 = v1_3 != null ? FontStyle.hashCode-impl(v1_3.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontSynthesis v1_4 = this.fontSynthesis;
        v1_1 = v1_4 != null ? FontSynthesis.hashCode-impl(v1_4.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontFamily v1_5 = this.fontFamily;
        v1_1 = v1_5 != null ? v1_5.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        String v1_6 = this.fontFeatureSettings;
        v1_1 = v1_6 != null ? v1_6.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + TextUnit.hashCode-impl(this.letterSpacing)) * 0x1F;
        BaselineShift v1_7 = this.baselineShift;
        v1_1 = v1_7 != null ? BaselineShift.hashCode-impl(v1_7.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        TextGeometricTransform v1_8 = this.textGeometricTransform;
        v1_1 = v1_8 != null ? v1_8.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        LocaleList v1_9 = this.localeList;
        v1_1 = v1_9 != null ? v1_9.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + Color.hashCode-impl(this.background)) * 0x1F;
        TextDecoration v1_10 = this.textDecoration;
        v1_1 = v1_10 != null ? v1_10.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        Shadow v1_11 = this.shadow;
        v1_1 = v1_11 != null ? v1_11.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        PlatformSpanStyle v1_12 = this.platformStyle;
        v1_1 = v1_12 != null ? v1_12.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        DrawStyle v5 = this.drawStyle;
        if(v5 != null) {
            v2 = v5.hashCode();
        }

        return v0 + v2;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int v0 = TextUnit.hashCode-impl(this.fontSize) * 0x1F;
        FontWeight v1 = this.fontWeight;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontStyle v1_2 = this.fontStyle;
        v1_1 = v1_2 != null ? FontStyle.hashCode-impl(v1_2.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontSynthesis v1_3 = this.fontSynthesis;
        v1_1 = v1_3 != null ? FontSynthesis.hashCode-impl(v1_3.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FontFamily v1_4 = this.fontFamily;
        v1_1 = v1_4 != null ? v1_4.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        String v1_5 = this.fontFeatureSettings;
        v1_1 = v1_5 != null ? v1_5.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + TextUnit.hashCode-impl(this.letterSpacing)) * 0x1F;
        BaselineShift v1_6 = this.baselineShift;
        v1_1 = v1_6 != null ? BaselineShift.hashCode-impl(v1_6.unbox-impl()) : 0;
        v0 = (v0 + v1_1) * 0x1F;
        TextGeometricTransform v1_7 = this.textGeometricTransform;
        v1_1 = v1_7 != null ? v1_7.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        LocaleList v1_8 = this.localeList;
        v1_1 = v1_8 != null ? v1_8.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + Color.hashCode-impl(this.background)) * 0x1F;
        PlatformSpanStyle v5 = this.platformStyle;
        if(v5 != null) {
            v2 = v5.hashCode();
        }

        return v0 + v2;
    }

    public final SpanStyle merge(SpanStyle arg26) {
        SpanStyle v0 = arg26;
        if(v0 == null) {
            return this;
        }

        return SpanStyleKt.fastMerge-dSHsh3o(this, v0.textForegroundStyle.getColor-0d7_KjU(), v0.textForegroundStyle.getBrush(), v0.textForegroundStyle.getAlpha(), v0.fontSize, v0.fontWeight, v0.fontStyle, v0.fontSynthesis, v0.fontFamily, v0.fontFeatureSettings, v0.letterSpacing, v0.baselineShift, v0.textGeometricTransform, v0.localeList, v0.background, v0.textDecoration, v0.shadow, v0.platformStyle, v0.drawStyle);
    }

    public static SpanStyle merge$default(SpanStyle arg0, SpanStyle arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return arg0.merge(arg1);
    }

    public final SpanStyle plus(SpanStyle arg1) {
        return this.merge(arg1);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("SpanStyle(color=");
        v0.append(Color.toString-impl(this.getColor-0d7_KjU())).append(", brush=").append(this.getBrush()).append(", alpha=").append(this.getAlpha()).append(", fontSize=").append(TextUnit.toString-impl(this.fontSize)).append(", fontWeight=").append(this.fontWeight).append(", fontStyle=").append(this.fontStyle).append(", fontSynthesis=").append(this.fontSynthesis).append(", fontFamily=").append(this.fontFamily).append(", fontFeatureSettings=").append(this.fontFeatureSettings).append(", letterSpacing=").append(TextUnit.toString-impl(this.letterSpacing)).append(", baselineShift=").append(this.baselineShift).append(", textGeometricTransform=");
        v0.append(this.textGeometricTransform).append(", localeList=").append(this.localeList).append(", background=").append(Color.toString-impl(this.background)).append(", textDecoration=").append(this.textDecoration).append(", shadow=").append(this.shadow).append(", platformStyle=").append(this.platformStyle).append(", drawStyle=").append(this.drawStyle).append(')');
        return v0.toString();
    }
}

