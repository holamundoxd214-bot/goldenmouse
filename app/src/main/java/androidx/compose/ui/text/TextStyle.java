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
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b]\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¤\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nB×\u0001\b\u0017\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+¢\u0006\u0004\b\b\u0010,Bï\u0001\b\u0017\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.¢\u0006\u0004\b\b\u0010/B\u0087\u0002\b\u0017\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001A\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001A\u0004\u0018\u000103¢\u0006\u0004\b\b\u00104B\u009F\u0002\b\u0017\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001A\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001A\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001A\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\b\b\u00109B\u0097\u0002\b\u0016\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001A\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001A\u00020&\u0012\b\b\u0002\u0010\'\u001A\u00020(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001A\u000201\u0012\b\b\u0002\u00102\u001A\u000203\u0012\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010:B¡\u0002\b\u0016\u0012\b\u0010;\u001A\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001A\u00020>\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001A\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001A\u00020&\u0012\b\b\u0002\u0010\'\u001A\u00020(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001A\u000201\u0012\b\b\u0002\u00102\u001A\u000203\u0012\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010?B©\u0002\b\u0017\u0012\b\u0010;\u001A\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001A\u00020>\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\b\b\u0002\u0010 \u001A\u00020\f\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001A\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001A\u00020\u000E\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001A\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001A\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010@J\b\u0010G\u001A\u00020\u0003H\u0007J\b\u0010H\u001A\u00020\u0005H\u0007J\u0014\u0010I\u001A\u00020\u00002\n\b\u0002\u0010J\u001A\u0004\u0018\u00010\u0000H\u0007J\u009D\u0002\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001A\u0004\u0018\u000108H\u0007¢\u0006\u0004\bK\u0010LJ¥\u0002\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\n\b\u0002\u00100\u001A\u0004\u0018\u0001012\n\b\u0002\u00102\u001A\u0004\u0018\u0001032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001A\u0004\u0018\u000108H\u0007¢\u0006\u0004\bM\u0010NJ\u0010\u0010I\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\u0003H\u0007J\u0010\u0010I\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\u0005H\u0007J\u0011\u0010O\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\u0000H\u0087\u0002J\u0011\u0010O\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\u0005H\u0087\u0002J\u0011\u0010O\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\u0003H\u0087\u0002JÝ\u0001\u0010P\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+H\u0007¢\u0006\u0004\bQ\u0010RJõ\u0001\u0010P\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.H\u0007¢\u0006\u0004\bS\u0010TJ\u008D\u0002\u0010P\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\n\b\u0002\u00100\u001A\u0004\u0018\u0001012\n\b\u0002\u00102\u001A\u0004\u0018\u000103H\u0007¢\u0006\u0004\bU\u0010VJ¥\u0002\u0010P\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\n\b\u0002\u00100\u001A\u0004\u0018\u0001012\n\b\u0002\u00102\u001A\u0004\u0018\u0001032\n\b\u0002\u00107\u001A\u0004\u0018\u000108H\u0007¢\u0006\u0004\bW\u0010XJ\u009B\u0002\u0010P\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002032\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\bY\u0010ZJ¯\u0002\u0010P\u001A\u00020\u00002\b\u0010;\u001A\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001A\u00020>2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\n\b\u0002\u00100\u001A\u0004\u0018\u0001012\n\b\u0002\u00102\u001A\u0004\u0018\u0001032\n\b\u0002\u00107\u001A\u0004\u0018\u000108H\u0007¢\u0006\u0004\b[\u0010\\J¥\u0002\u0010P\u001A\u00020\u00002\b\u0010;\u001A\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001A\u00020>2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020\f2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u00105\u001A\u0004\u0018\u0001062\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020\u000E2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002032\n\b\u0002\u00107\u001A\u0004\u0018\u000108¢\u0006\u0004\b]\u0010^J\u0015\u0010\u009B\u0001\u001A\u00030\u009C\u00012\b\u0010J\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u009D\u0001\u001A\u00030\u009C\u00012\u0006\u0010J\u001A\u00020\u0000J\u0010\u0010\u009E\u0001\u001A\u00030\u009C\u00012\u0006\u0010J\u001A\u00020\u0000J\n\u0010\u009F\u0001\u001A\u00030 \u0001H\u0016J\u0010\u0010¡\u0001\u001A\u00030 \u0001H\u0000¢\u0006\u0003\b¢\u0001J\t\u0010£\u0001\u001A\u00020\u0018H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bC\u0010DR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\bE\u0010FR\u0013\u0010;\u001A\u0004\u0018\u00010<8F¢\u0006\u0006\u001A\u0004\b_\u0010`R\u0011\u0010\u000B\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\ba\u0010bR\u0011\u0010=\u001A\u00020>8F¢\u0006\u0006\u001A\u0004\bc\u0010dR\u0011\u0010\r\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\be\u0010bR\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001A\u0004\bf\u0010gR\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001A\u0004\bh\u0010iR\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001A\u0004\bj\u0010kR\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001A\u0004\bl\u0010mR\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001A\u0004\bn\u0010oR\u0011\u0010\u0019\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\bp\u0010bR\u0013\u0010\u001A\u001A\u0004\u0018\u00010\u001B8F¢\u0006\u0006\u001A\u0004\bq\u0010rR\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u001D8F¢\u0006\u0006\u001A\u0004\bs\u0010tR\u0013\u0010\u001E\u001A\u0004\u0018\u00010\u001F8F¢\u0006\u0006\u001A\u0004\bu\u0010vR\u0011\u0010 \u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\bw\u0010bR\u0013\u0010!\u001A\u0004\u0018\u00010\"8F¢\u0006\u0006\u001A\u0004\bx\u0010yR\u0013\u0010#\u001A\u0004\u0018\u00010$8F¢\u0006\u0006\u001A\u0004\bz\u0010{R\u0013\u00105\u001A\u0004\u0018\u0001068F¢\u0006\u0006\u001A\u0004\b|\u0010}R\u0011\u0010%\u001A\u00020&8F¢\u0006\u0006\u001A\u0004\b~\u0010\u007FR!\u0010\u0080\u0001\u001A\u0004\u0018\u00010&8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0012\u0010\'\u001A\u00020(8F¢\u0006\u0007\u001A\u0005\b\u0085\u0001\u0010\u007FR!\u0010\u0086\u0001\u001A\u0004\u0018\u00010(8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0087\u0001\u0010\u0082\u0001\u001A\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0012\u0010)\u001A\u00020\u000E8F¢\u0006\u0007\u001A\u0005\b\u008A\u0001\u0010bR\u0015\u0010*\u001A\u0004\u0018\u00010+8F¢\u0006\b\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001R\u0015\u0010-\u001A\u0004\u0018\u00010.8F¢\u0006\b\u001A\u0006\b\u008D\u0001\u0010\u008E\u0001R\u0012\u00102\u001A\u0002038F¢\u0006\u0007\u001A\u0005\b\u008F\u0001\u0010\u007FR!\u0010\u0090\u0001\u001A\u0004\u0018\u0001038GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0091\u0001\u0010\u0082\u0001\u001A\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0012\u00100\u001A\u0002018F¢\u0006\u0007\u001A\u0005\b\u0094\u0001\u0010\u007FR!\u0010\u0095\u0001\u001A\u0004\u0018\u0001018GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0096\u0001\u0010\u0082\u0001\u001A\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0015\u00107\u001A\u0004\u0018\u0001088F¢\u0006\b\u001A\u0006\b\u0099\u0001\u0010\u009A\u0001¨\u0006¥\u0001"}, d2={"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "<init>", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpanStyle$ui_text", "()Landroidx/compose/ui/text/SpanStyle;", "getParagraphStyle$ui_text", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "toSpanStyle", "toParagraphStyle", "merge", "other", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "copy", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "()J", "getAlpha", "()F", "getFontSize-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getTextAlign-e0LSkKk", "()I", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "()V", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-s_7X-co", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getLineHeight-XSAIIZE", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getHyphens-vmbZdU8", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "getLineBreak-rAG3T2k", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "equals", "", "hasSameLayoutAffectingAttributes", "hasSameDrawAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextStyle {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/TextStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }

        public static void getDefault$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextStyle Default;
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    static {
        TextStyle.Companion = new Companion(null);
        TextStyle.Default = new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFF, null);
    }

    public TextStyle(long arg31, long arg33, FontWeight arg35, FontStyle arg36, FontSynthesis arg37, FontFamily arg38, String arg39, long arg40, BaselineShift arg42, TextGeometricTransform arg43, LocaleList arg44, long arg45, TextDecoration arg47, Shadow arg48, DrawStyle arg49, int arg50, int arg51, long arg52, TextIndent arg54, PlatformTextStyle arg55, LineHeightStyle arg56, int arg57, int arg58, TextMotion arg59, int arg60, DefaultConstructorMarker arg61) {
        int v0 = arg60;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg33;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg35;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg36;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg37;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg38;
        String v10 = (v0 & 0x40) != 0 ? null : arg39;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg40;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg42;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg43;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg44;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg45;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg47;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg48;
        DrawStyle v2 = (v0 & 0x4000) != 0 ? null : arg49;
        int v20 = (v0 & 0x8000) != 0 ? TextAlign.Companion.getUnspecified-e0LSkKk() : arg50;
        int v21 = (v0 & 0x10000) != 0 ? TextDirection.Companion.getUnspecified-s_7X-co() : arg51;
        long v22 = (v0 & 0x20000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
        TextIndent v24 = (v0 & 0x40000) != 0 ? null : arg54;
        PlatformTextStyle v25 = (v0 & 0x80000) != 0 ? null : arg55;
        LineHeightStyle v26 = (v0 & 0x100000) != 0 ? null : arg56;
        int v27 = (v0 & 0x200000) != 0 ? LineBreak.Companion.getUnspecified-rAG3T2k() : arg57;
        int v28 = (v0 & 0x400000) != 0 ? Hyphens.Companion.getUnspecified-vmbZdU8() : arg58;
        TextMotion v0_1 = (v0 & 0x800000) != 0 ? null : arg59;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v22, v24, v25, v26, v27, v28, v0_1, null);
    }

    private TextStyle(long arg25, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, DrawStyle arg43, int arg44, int arg45, long arg46, TextIndent arg48, PlatformTextStyle arg49, LineHeightStyle arg50, int arg51, int arg52, TextMotion arg53) {
        PlatformTextStyle v0 = arg49;
        PlatformParagraphStyle v23 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v23);
        SpanStyle v1 = new SpanStyle(arg25, arg27, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg39, arg41, arg42, v20, arg43, null);
        ParagraphStyle v2 = null;
        if(v0 != null) {
            v23 = v0.getParagraphStyle();
        }

        super(arg44, arg45, arg46, arg48, v23, arg50, arg51, arg52, arg53, null);
        this(v1, v2, v0);
    }

    public TextStyle(SpanStyle arg1, ParagraphStyle arg2, PlatformTextStyle arg3) {
        super();
        this.spanStyle = arg1;
        this.paragraphStyle = arg2;
        this.platformStyle = arg3;
    }

    public TextStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DrawStyle arg19, int arg20, int arg21, long arg22, TextIndent arg24, PlatformTextStyle arg25, LineHeightStyle arg26, int arg27, int arg28, TextMotion arg29, DefaultConstructorMarker arg30) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg25, arg26, arg27, arg28, arg29);
    }

    private TextStyle(long arg25, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, DrawStyle arg43, TextAlign arg44, TextDirection arg45, long arg46, TextIndent arg48, PlatformTextStyle arg49, LineHeightStyle arg50, LineBreak arg51, Hyphens arg52, TextMotion arg53) {
        PlatformTextStyle v0 = arg49;
        PlatformParagraphStyle v23 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v23);
        SpanStyle v1 = new SpanStyle(arg25, arg27, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg39, arg41, arg42, v20, arg43, null);
        ParagraphStyle v2 = null;
        int v3 = arg44 != null ? arg44.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v4 = arg45 != null ? arg45.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v0 != null) {
            v23 = v0.getParagraphStyle();
        }

        int v5 = arg51 != null ? arg51.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v6 = arg52 != null ? arg52.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v3, v4, arg46, arg48, v23, arg50, v5, v6, arg53, null);
        this(v1, v2, v0);
    }

    public TextStyle(long arg31, long arg33, FontWeight arg35, FontStyle arg36, FontSynthesis arg37, FontFamily arg38, String arg39, long arg40, BaselineShift arg42, TextGeometricTransform arg43, LocaleList arg44, long arg45, TextDecoration arg47, Shadow arg48, DrawStyle arg49, TextAlign arg50, TextDirection arg51, long arg52, TextIndent arg54, PlatformTextStyle arg55, LineHeightStyle arg56, LineBreak arg57, Hyphens arg58, TextMotion arg59, int arg60, DefaultConstructorMarker arg61) {
        int v0 = arg60;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg33;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg35;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg36;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg37;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg38;
        String v10 = (v0 & 0x40) != 0 ? null : arg39;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg40;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg42;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg43;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg44;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg45;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg47;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg48;
        DrawStyle v2 = (v0 & 0x4000) != 0 ? null : arg49;
        TextAlign v20 = (v0 & 0x8000) != 0 ? null : arg50;
        TextDirection v21 = (v0 & 0x10000) != 0 ? null : arg51;
        long v22 = (v0 & 0x20000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
        TextIndent v24 = (v0 & 0x40000) != 0 ? null : arg54;
        PlatformTextStyle v25 = (v0 & 0x80000) != 0 ? null : arg55;
        LineHeightStyle v26 = (v0 & 0x100000) != 0 ? null : arg56;
        LineBreak v27 = (v0 & 0x200000) != 0 ? null : arg57;
        Hyphens v28 = (v0 & 0x400000) != 0 ? null : arg58;
        TextMotion v0_1 = (v0 & 0x800000) != 0 ? null : arg59;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v22, v24, v25, v26, v27, v28, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public TextStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DrawStyle arg19, TextAlign arg20, TextDirection arg21, long arg22, TextIndent arg24, PlatformTextStyle arg25, LineHeightStyle arg26, LineBreak arg27, Hyphens arg28, TextMotion arg29, DefaultConstructorMarker arg30) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg25, arg26, arg27, arg28, arg29);
    }

    private TextStyle(long arg23, long arg25, FontWeight arg27, FontStyle arg28, FontSynthesis arg29, FontFamily arg30, String arg31, long arg32, BaselineShift arg34, TextGeometricTransform arg35, LocaleList arg36, long arg37, TextDecoration arg39, Shadow arg40, TextAlign arg41, TextDirection arg42, long arg43, TextIndent arg45) {
        SpanStyle v0 = new SpanStyle(arg23, arg25, arg27, arg28, arg29, arg30, arg31, arg32, arg34, arg35, arg36, arg37, arg39, arg40, null, null, null);
        ParagraphStyle v1 = null;
        int v2 = arg41 != null ? arg41.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v3 = arg42 != null ? arg42.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        super(v2, v3, arg43, arg45, null, null, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), null, null);
        this(v0, v1, null);
    }

    public TextStyle(long arg25, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, TextAlign arg43, TextDirection arg44, long arg45, TextIndent arg47, int arg48, DefaultConstructorMarker arg49) {
        int v0 = arg48;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg27;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg29;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg30;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg31;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg32;
        String v10 = (v0 & 0x40) != 0 ? null : arg33;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg34;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg36;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg37;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg38;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg39;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg41;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg42;
        TextAlign v2 = (v0 & 0x4000) != 0 ? null : arg43;
        TextDirection v20 = (v0 & 0x8000) != 0 ? null : arg44;
        long v21 = (v0 & 0x10000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg45;
        TextIndent v0_1 = (v0 & 0x20000) != 0 ? null : arg47;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.") public TextStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, TextAlign arg19, TextDirection arg20, long arg21, TextIndent arg23, DefaultConstructorMarker arg24) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg23);
    }

    private TextStyle(long arg25, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, TextAlign arg43, TextDirection arg44, long arg45, TextIndent arg47, PlatformTextStyle arg48, LineHeightStyle arg49) {
        PlatformTextStyle v0 = arg48;
        PlatformParagraphStyle v23 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v23);
        SpanStyle v1 = new SpanStyle(arg25, arg27, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg39, arg41, arg42, v20, null, null);
        ParagraphStyle v2 = null;
        int v3 = arg43 != null ? arg43.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v4 = arg44 != null ? arg44.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v0 != null) {
            v23 = v0.getParagraphStyle();
        }

        super(v3, v4, arg45, arg47, v23, arg49, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), null, null);
        this(v1, v2, v0);
    }

    public TextStyle(long arg27, long arg29, FontWeight arg31, FontStyle arg32, FontSynthesis arg33, FontFamily arg34, String arg35, long arg36, BaselineShift arg38, TextGeometricTransform arg39, LocaleList arg40, long arg41, TextDecoration arg43, Shadow arg44, TextAlign arg45, TextDirection arg46, long arg47, TextIndent arg49, PlatformTextStyle arg50, LineHeightStyle arg51, int arg52, DefaultConstructorMarker arg53) {
        int v0 = arg52;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg29;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg31;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg32;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg33;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg34;
        String v10 = (v0 & 0x40) != 0 ? null : arg35;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg36;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg38;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg39;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg40;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg41;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg43;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg44;
        TextAlign v2 = (v0 & 0x4000) != 0 ? null : arg45;
        TextDirection v20 = (v0 & 0x8000) != 0 ? null : arg46;
        long v21 = (v0 & 0x10000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg47;
        TextIndent v23 = (v0 & 0x20000) != 0 ? null : arg49;
        PlatformTextStyle v24 = (v0 & 0x40000) != 0 ? null : arg50;
        LineHeightStyle v0_1 = (v0 & 0x80000) != 0 ? null : arg51;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v23, v24, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.") public TextStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, TextAlign arg19, TextDirection arg20, long arg21, TextIndent arg23, PlatformTextStyle arg24, LineHeightStyle arg25, DefaultConstructorMarker arg26) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg23, arg24, arg25);
    }

    private TextStyle(long arg26, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, TextAlign arg44, TextDirection arg45, long arg46, TextIndent arg48, PlatformTextStyle arg49, LineHeightStyle arg50, LineBreak arg51, Hyphens arg52) {
        PlatformTextStyle v0 = arg49;
        PlatformParagraphStyle v24 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v24);
        SpanStyle v1 = new SpanStyle(arg26, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v20, null, 0x8000, null);
        ParagraphStyle v2 = null;
        int v3 = arg44 != null ? arg44.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v4 = arg45 != null ? arg45.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v0 != null) {
            v24 = v0.getParagraphStyle();
        }

        int v5 = arg51 != null ? arg51.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v6 = arg52 != null ? arg52.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v3, v4, arg46, arg48, v24, arg50, v5, v6, null, 0x100, null);
        this(v1, v2, v0);
    }

    public TextStyle(long arg29, long arg31, FontWeight arg33, FontStyle arg34, FontSynthesis arg35, FontFamily arg36, String arg37, long arg38, BaselineShift arg40, TextGeometricTransform arg41, LocaleList arg42, long arg43, TextDecoration arg45, Shadow arg46, TextAlign arg47, TextDirection arg48, long arg49, TextIndent arg51, PlatformTextStyle arg52, LineHeightStyle arg53, LineBreak arg54, Hyphens arg55, int arg56, DefaultConstructorMarker arg57) {
        int v0 = arg56;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg31;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg33;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg34;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg35;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg36;
        String v10 = (v0 & 0x40) != 0 ? null : arg37;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg38;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg40;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg41;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg42;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg43;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg45;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg46;
        TextAlign v2 = (v0 & 0x4000) != 0 ? null : arg47;
        TextDirection v20 = (v0 & 0x8000) != 0 ? null : arg48;
        long v21 = (v0 & 0x10000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg49;
        TextIndent v23 = (v0 & 0x20000) != 0 ? null : arg51;
        PlatformTextStyle v24 = (v0 & 0x40000) != 0 ? null : arg52;
        LineHeightStyle v25 = (v0 & 0x80000) != 0 ? null : arg53;
        LineBreak v26 = (v0 & 0x100000) != 0 ? null : arg54;
        Hyphens v0_1 = (v0 & 0x200000) != 0 ? null : arg55;
        this(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v23, v24, v25, v26, v0_1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.") public TextStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, TextAlign arg19, TextDirection arg20, long arg21, TextIndent arg23, PlatformTextStyle arg24, LineHeightStyle arg25, LineBreak arg26, Hyphens arg27, DefaultConstructorMarker arg28) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg23, arg24, arg25, arg26, arg27);
    }

    private TextStyle(Brush arg25, float arg26, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, DrawStyle arg43, int arg44, int arg45, long arg46, TextIndent arg48, PlatformTextStyle arg49, LineHeightStyle arg50, int arg51, int arg52, TextMotion arg53) {
        PlatformTextStyle v0 = arg49;
        PlatformParagraphStyle v23 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v23);
        SpanStyle v1 = new SpanStyle(arg25, arg26, arg27, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg39, arg41, arg42, v20, arg43, null);
        ParagraphStyle v2 = null;
        if(v0 != null) {
            v23 = v0.getParagraphStyle();
        }

        super(arg44, arg45, arg46, arg48, v23, arg50, arg51, arg52, arg53, null);
        this(v1, v2, v0);
    }

    public TextStyle(Brush arg34, float arg35, long arg36, FontWeight arg38, FontStyle arg39, FontSynthesis arg40, FontFamily arg41, String arg42, long arg43, BaselineShift arg45, TextGeometricTransform arg46, LocaleList arg47, long arg48, TextDecoration arg50, Shadow arg51, DrawStyle arg52, int arg53, int arg54, long arg55, TextIndent arg57, PlatformTextStyle arg58, LineHeightStyle arg59, int arg60, int arg61, TextMotion arg62, int arg63, DefaultConstructorMarker arg64) {
        int v0 = arg63;
        float v4 = (v0 & 2) != 0 ? NaNf : arg35;
        long v5 = (v0 & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg36;
        FontWeight v2 = null;
        FontWeight v7 = (v0 & 8) != 0 ? v2 : arg38;
        FontStyle v8 = (v0 & 16) != 0 ? ((FontStyle)v2) : arg39;
        FontSynthesis v9 = (v0 & 0x20) != 0 ? ((FontSynthesis)v2) : arg40;
        FontFamily v10 = (v0 & 0x40) != 0 ? ((FontFamily)v2) : arg41;
        String v11 = (v0 & 0x80) != 0 ? ((String)v2) : arg42;
        long v12 = (v0 & 0x100) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg43;
        BaselineShift v14 = (v0 & 0x200) != 0 ? ((BaselineShift)v2) : arg45;
        TextGeometricTransform v15 = (v0 & 0x400) != 0 ? ((TextGeometricTransform)v2) : arg46;
        LocaleList v16 = (v0 & 0x800) != 0 ? ((LocaleList)v2) : arg47;
        long v17 = (v0 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        TextDecoration v19 = (v0 & 0x2000) != 0 ? ((TextDecoration)v2) : arg50;
        Shadow v20 = (v0 & 0x4000) != 0 ? ((Shadow)v2) : arg51;
        DrawStyle v21 = (0x8000 & v0) != 0 ? ((DrawStyle)v2) : arg52;
        int v22 = (0x10000 & v0) != 0 ? TextAlign.Companion.getUnspecified-e0LSkKk() : arg53;
        int v23 = (0x20000 & v0) != 0 ? TextDirection.Companion.getUnspecified-s_7X-co() : arg54;
        long v24 = (0x40000 & v0) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg55;
        TextIndent v26 = (0x80000 & v0) != 0 ? ((TextIndent)v2) : arg57;
        PlatformTextStyle v27 = (0x100000 & v0) != 0 ? ((PlatformTextStyle)v2) : arg58;
        LineHeightStyle v28 = (0x200000 & v0) != 0 ? ((LineHeightStyle)v2) : arg59;
        int v29 = (0x400000 & v0) != 0 ? LineBreak.Companion.getUnspecified-rAG3T2k() : arg60;
        int v30 = (0x800000 & v0) != 0 ? Hyphens.Companion.getUnspecified-vmbZdU8() : arg61;
        TextMotion v31 = (v0 & 0x1000000) != 0 ? ((TextMotion)v2) : arg62;
        this(arg34, v4, v5, v7, v8, v9, v10, v11, v12, v14, v15, v16, v17, v19, v20, v21, v22, v23, v24, v26, v27, v28, v29, v30, v31, null);
    }

    public TextStyle(Brush arg1, float arg2, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DrawStyle arg19, int arg20, int arg21, long arg22, TextIndent arg24, PlatformTextStyle arg25, LineHeightStyle arg26, int arg27, int arg28, TextMotion arg29, DefaultConstructorMarker arg30) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg25, arg26, arg27, arg28, arg29);
    }

    private TextStyle(Brush arg25, float arg26, long arg27, FontWeight arg29, FontStyle arg30, FontSynthesis arg31, FontFamily arg32, String arg33, long arg34, BaselineShift arg36, TextGeometricTransform arg37, LocaleList arg38, long arg39, TextDecoration arg41, Shadow arg42, DrawStyle arg43, TextAlign arg44, TextDirection arg45, long arg46, TextIndent arg48, PlatformTextStyle arg49, LineHeightStyle arg50, LineBreak arg51, Hyphens arg52, TextMotion arg53) {
        PlatformTextStyle v0 = arg49;
        PlatformParagraphStyle v23 = null;
        PlatformSpanStyle v20 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v23);
        SpanStyle v1 = new SpanStyle(arg25, arg26, arg27, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg39, arg41, arg42, v20, arg43, null);
        ParagraphStyle v2 = null;
        int v3 = arg44 != null ? arg44.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v4 = arg45 != null ? arg45.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v0 != null) {
            v23 = v0.getParagraphStyle();
        }

        int v5 = arg51 != null ? arg51.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v6 = arg52 != null ? arg52.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v3, v4, arg46, arg48, v23, arg50, v5, v6, arg53, null);
        this(v1, v2, v0);
    }

    public TextStyle(Brush arg34, float arg35, long arg36, FontWeight arg38, FontStyle arg39, FontSynthesis arg40, FontFamily arg41, String arg42, long arg43, BaselineShift arg45, TextGeometricTransform arg46, LocaleList arg47, long arg48, TextDecoration arg50, Shadow arg51, DrawStyle arg52, TextAlign arg53, TextDirection arg54, long arg55, TextIndent arg57, PlatformTextStyle arg58, LineHeightStyle arg59, LineBreak arg60, Hyphens arg61, TextMotion arg62, int arg63, DefaultConstructorMarker arg64) {
        int v0 = arg63;
        float v4 = (v0 & 2) != 0 ? NaNf : arg35;
        long v5 = (v0 & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg36;
        FontWeight v2 = null;
        FontWeight v7 = (v0 & 8) != 0 ? v2 : arg38;
        FontStyle v8 = (v0 & 16) != 0 ? ((FontStyle)v2) : arg39;
        FontSynthesis v9 = (v0 & 0x20) != 0 ? ((FontSynthesis)v2) : arg40;
        FontFamily v10 = (v0 & 0x40) != 0 ? ((FontFamily)v2) : arg41;
        String v11 = (v0 & 0x80) != 0 ? ((String)v2) : arg42;
        long v12 = (v0 & 0x100) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg43;
        BaselineShift v14 = (v0 & 0x200) != 0 ? ((BaselineShift)v2) : arg45;
        TextGeometricTransform v15 = (v0 & 0x400) != 0 ? ((TextGeometricTransform)v2) : arg46;
        LocaleList v16 = (v0 & 0x800) != 0 ? ((LocaleList)v2) : arg47;
        long v17 = (v0 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        TextDecoration v19 = (v0 & 0x2000) != 0 ? ((TextDecoration)v2) : arg50;
        Shadow v20 = (v0 & 0x4000) != 0 ? ((Shadow)v2) : arg51;
        DrawStyle v21 = (0x8000 & v0) != 0 ? ((DrawStyle)v2) : arg52;
        TextAlign v22 = (0x10000 & v0) != 0 ? ((TextAlign)v2) : arg53;
        TextDirection v23 = (0x20000 & v0) != 0 ? ((TextDirection)v2) : arg54;
        long v24 = (0x40000 & v0) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg55;
        TextIndent v26 = (0x80000 & v0) != 0 ? ((TextIndent)v2) : arg57;
        PlatformTextStyle v27 = (0x100000 & v0) != 0 ? ((PlatformTextStyle)v2) : arg58;
        LineHeightStyle v28 = (0x200000 & v0) != 0 ? ((LineHeightStyle)v2) : arg59;
        LineBreak v29 = (0x400000 & v0) != 0 ? ((LineBreak)v2) : arg60;
        Hyphens v30 = (0x800000 & v0) != 0 ? ((Hyphens)v2) : arg61;
        TextMotion v31 = (v0 & 0x1000000) != 0 ? ((TextMotion)v2) : arg62;
        this(arg34, v4, v5, v7, v8, v9, v10, v11, v12, v14, v15, v16, v17, v19, v20, v21, v22, v23, v24, v26, v27, v28, v29, v30, v31, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public TextStyle(Brush arg1, float arg2, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DrawStyle arg19, TextAlign arg20, TextDirection arg21, long arg22, TextIndent arg24, PlatformTextStyle arg25, LineHeightStyle arg26, LineBreak arg27, Hyphens arg28, TextMotion arg29, DefaultConstructorMarker arg30) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg25, arg26, arg27, arg28, arg29);
    }

    public TextStyle(SpanStyle arg3, ParagraphStyle arg4) {
        this(arg3, arg4, TextStyleKt.access$createPlatformTextStyleInternal(arg3.getPlatformStyle(), arg4.getPlatformStyle()));
    }

    public TextStyle(SpanStyle arg1, ParagraphStyle arg2, PlatformTextStyle arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public static final TextStyle access$getDefault$cp() {
        return TextStyle.Default;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.") public final TextStyle copy-CXVQc50(long arg27, long arg29, FontWeight arg31, FontStyle arg32, FontSynthesis arg33, FontFamily arg34, String arg35, long arg36, BaselineShift arg38, TextGeometricTransform arg39, LocaleList arg40, long arg41, TextDecoration arg43, Shadow arg44, TextAlign arg45, TextDirection arg46, long arg47, TextIndent arg49, PlatformTextStyle arg50, LineHeightStyle arg51, LineBreak arg52, Hyphens arg53) {
        TextStyle v0 = this;
        long v1 = arg27;
        PlatformTextStyle v3 = arg50;
        TextForegroundStyle v1_1 = Color.equals-impl0(v1, v0.spanStyle.getColor-0d7_KjU()) ? v0.spanStyle.getTextForegroundStyle$ui_text() : TextForegroundStyle.Companion.from-8_81llA(v1);
        TextForegroundStyle v6 = v1_1;
        PlatformParagraphStyle v1_2 = null;
        PlatformSpanStyle v23 = v3 != null ? v3.getSpanStyle() : ((PlatformSpanStyle)v1_2);
        SpanStyle v5 = new SpanStyle(v6, arg29, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, arg43, arg44, v23, v0.getDrawStyle(), null);
        ParagraphStyle v2 = null;
        int v6_1 = arg45 != null ? arg45.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v7 = arg46 != null ? arg46.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v3 != null) {
            v1_2 = v3.getParagraphStyle();
        }

        int v8 = arg52 != null ? arg52.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v9 = arg53 != null ? arg53.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v6_1, v7, arg47, arg49, v1_2, arg51, v8, v9, v0.getTextMotion(), null);
        return new TextStyle(v5, v2, v3);
    }

    public static TextStyle copy-CXVQc50$default(TextStyle arg21, long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, TextAlign arg40, TextDirection arg41, long arg42, TextIndent arg44, PlatformTextStyle arg45, LineHeightStyle arg46, LineBreak arg47, Hyphens arg48, int arg49, Object arg50) {
        Hyphens v49;
        LineBreak v48;
        TextStyle v0 = arg21;
        int v1 = arg49;
        long v2 = (v1 & 1) != 0 ? v0.spanStyle.getColor-0d7_KjU() : arg22;
        long v4 = (v1 & 2) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg24;
        FontWeight v6 = (v1 & 4) != 0 ? v0.spanStyle.getFontWeight() : arg26;
        FontStyle v7 = (v1 & 8) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg27;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg28;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontFamily() : arg29;
        String v10 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg30;
        long v11 = (v1 & 0x80) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg31;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg33;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg34;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.spanStyle.getLocaleList() : arg35;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg36;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.spanStyle.getTextDecoration() : arg38;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.spanStyle.getShadow() : arg39;
        TextDecoration v24 = v2_1;
        TextAlign v2_2 = (v1 & 0x4000) != 0 ? TextAlign.box-impl(v0.paragraphStyle.getTextAlign-e0LSkKk()) : arg40;
        TextDirection v1_1 = (v1 & 0x8000) != 0 ? TextDirection.box-impl(v0.paragraphStyle.getTextDirection-s_7X-co()) : arg41;
        TextDirection v25 = v1_1;
        long v18 = (arg49 & 0x10000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg42;
        TextIndent v1_2 = (arg49 & 0x20000) != 0 ? v0.paragraphStyle.getTextIndent() : arg44;
        TextIndent v26 = v1_2;
        PlatformTextStyle v1_3 = (arg49 & 0x40000) != 0 ? v0.platformStyle : arg45;
        PlatformTextStyle v27 = v1_3;
        LineHeightStyle v1_4 = (arg49 & 0x80000) != 0 ? v0.paragraphStyle.getLineHeightStyle() : arg46;
        LineHeightStyle v28 = v1_4;
        LineBreak v1_5 = (arg49 & 0x100000) != 0 ? LineBreak.box-impl(v0.paragraphStyle.getLineBreak-rAG3T2k()) : arg47;
        if((arg49 & 0x200000) != 0) {
            v48 = v1_5;
            v49 = Hyphens.box-impl(v0.paragraphStyle.getHyphens-vmbZdU8());
        }
        else {
            v49 = arg48;
            v48 = v1_5;
        }

        return v0.copy-CXVQc50(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg22, v24, v3, v2_2, v25, v18, v26, v27, v28, v48, v49);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.") public final TextStyle copy-HL5avdY(long arg26, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, TextAlign arg44, TextDirection arg45, long arg46, TextIndent arg48) {
        TextStyle v0 = this;
        long v1 = arg26;
        TextForegroundStyle v1_1 = Color.equals-impl0(v1, v0.spanStyle.getColor-0d7_KjU()) ? v0.spanStyle.getTextForegroundStyle$ui_text() : TextForegroundStyle.Companion.from-8_81llA(v1);
        SpanStyle v4 = new SpanStyle(v1_1, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v0.spanStyle.getPlatformStyle(), v0.spanStyle.getDrawStyle(), null);
        ParagraphStyle v1_2 = null;
        int v2 = arg44 != null ? arg44.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v5 = arg45 != null ? arg45.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        super(v2, v5, arg46, arg48, v0.paragraphStyle.getPlatformStyle(), v0.getLineHeightStyle(), v0.getLineBreak-rAG3T2k(), v0.getHyphens-vmbZdU8(), v0.getTextMotion(), null);
        return new TextStyle(v4, v1_2, v0.platformStyle);
    }

    public static TextStyle copy-HL5avdY$default(TextStyle arg20, long arg21, long arg23, FontWeight arg25, FontStyle arg26, FontSynthesis arg27, FontFamily arg28, String arg29, long arg30, BaselineShift arg32, TextGeometricTransform arg33, LocaleList arg34, long arg35, TextDecoration arg37, Shadow arg38, TextAlign arg39, TextDirection arg40, long arg41, TextIndent arg43, int arg44, Object arg45) {
        TextStyle v0 = arg20;
        int v1 = arg44;
        long v2 = (v1 & 1) != 0 ? v0.spanStyle.getColor-0d7_KjU() : arg21;
        long v4 = (v1 & 2) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg23;
        FontWeight v6 = (v1 & 4) != 0 ? v0.spanStyle.getFontWeight() : arg25;
        FontStyle v7 = (v1 & 8) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg26;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg27;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontFamily() : arg28;
        String v10 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg29;
        long v11 = (v1 & 0x80) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg30;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg32;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg33;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.spanStyle.getLocaleList() : arg34;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg35;
        arg21 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.spanStyle.getTextDecoration() : arg37;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.spanStyle.getShadow() : arg38;
        TextDecoration v23 = v2_1;
        TextAlign v2_2 = (v1 & 0x4000) != 0 ? TextAlign.box-impl(v0.paragraphStyle.getTextAlign-e0LSkKk()) : arg39;
        TextDirection v1_1 = (v1 & 0x8000) != 0 ? TextDirection.box-impl(v0.paragraphStyle.getTextDirection-s_7X-co()) : arg40;
        TextDirection v24 = v1_1;
        long v18 = (arg44 & 0x10000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg41;
        TextIndent v44 = (arg44 & 0x20000) != 0 ? v0.paragraphStyle.getTextIndent() : arg43;
        return v0.copy-HL5avdY(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg21, v23, v3, v2_2, v24, v18, v44);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.") public final TextStyle copy-NOaFTUo(long arg27, long arg29, FontWeight arg31, FontStyle arg32, FontSynthesis arg33, FontFamily arg34, String arg35, long arg36, BaselineShift arg38, TextGeometricTransform arg39, LocaleList arg40, long arg41, TextDecoration arg43, Shadow arg44, TextAlign arg45, TextDirection arg46, long arg47, TextIndent arg49, PlatformTextStyle arg50, LineHeightStyle arg51) {
        TextStyle v0 = this;
        long v1 = arg27;
        PlatformTextStyle v3 = arg50;
        TextForegroundStyle v1_1 = Color.equals-impl0(v1, v0.spanStyle.getColor-0d7_KjU()) ? v0.spanStyle.getTextForegroundStyle$ui_text() : TextForegroundStyle.Companion.from-8_81llA(v1);
        TextForegroundStyle v6 = v1_1;
        PlatformParagraphStyle v1_2 = null;
        PlatformSpanStyle v23 = v3 != null ? v3.getSpanStyle() : ((PlatformSpanStyle)v1_2);
        SpanStyle v5 = new SpanStyle(v6, arg29, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, arg43, arg44, v23, v0.spanStyle.getDrawStyle(), null);
        ParagraphStyle v2 = null;
        int v6_1 = arg45 != null ? arg45.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v7 = arg46 != null ? arg46.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v3 != null) {
            v1_2 = v3.getParagraphStyle();
        }

        super(v6_1, v7, arg47, arg49, v1_2, arg51, v0.getLineBreak-rAG3T2k(), v0.getHyphens-vmbZdU8(), v0.getTextMotion(), null);
        return new TextStyle(v5, v2, v3);
    }

    public static TextStyle copy-NOaFTUo$default(TextStyle arg21, long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, TextAlign arg40, TextDirection arg41, long arg42, TextIndent arg44, PlatformTextStyle arg45, LineHeightStyle arg46, int arg47, Object arg48) {
        LineHeightStyle v47;
        PlatformTextStyle v46;
        TextStyle v0 = arg21;
        int v1 = arg47;
        long v2 = (v1 & 1) != 0 ? v0.spanStyle.getColor-0d7_KjU() : arg22;
        long v4 = (v1 & 2) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg24;
        FontWeight v6 = (v1 & 4) != 0 ? v0.spanStyle.getFontWeight() : arg26;
        FontStyle v7 = (v1 & 8) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg27;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg28;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontFamily() : arg29;
        String v10 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg30;
        long v11 = (v1 & 0x80) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg31;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg33;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg34;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.spanStyle.getLocaleList() : arg35;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg36;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.spanStyle.getTextDecoration() : arg38;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.spanStyle.getShadow() : arg39;
        TextDecoration v24 = v2_1;
        TextAlign v2_2 = (v1 & 0x4000) != 0 ? TextAlign.box-impl(v0.paragraphStyle.getTextAlign-e0LSkKk()) : arg40;
        TextDirection v1_1 = (v1 & 0x8000) != 0 ? TextDirection.box-impl(v0.paragraphStyle.getTextDirection-s_7X-co()) : arg41;
        TextDirection v25 = v1_1;
        long v18 = (arg47 & 0x10000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg42;
        TextIndent v1_2 = (arg47 & 0x20000) != 0 ? v0.paragraphStyle.getTextIndent() : arg44;
        TextIndent v26 = v1_2;
        PlatformTextStyle v1_3 = (arg47 & 0x40000) != 0 ? v0.platformStyle : arg45;
        if((arg47 & 0x80000) != 0) {
            v46 = v1_3;
            v47 = v0.paragraphStyle.getLineHeightStyle();
        }
        else {
            v47 = arg46;
            v46 = v1_3;
        }

        return v0.copy-NOaFTUo(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg22, v24, v3, v2_2, v25, v18, v26, v46, v47);
    }

    public final TextStyle copy-Ns73l9s(Brush arg26, float arg27, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, DrawStyle arg44, int arg45, int arg46, long arg47, TextIndent arg49, PlatformTextStyle arg50, LineHeightStyle arg51, int arg52, int arg53, TextMotion arg54) {
        PlatformTextStyle v0 = arg50;
        PlatformParagraphStyle v24 = null;
        PlatformSpanStyle v21 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v24);
        SpanStyle v2 = new SpanStyle(arg26, arg27, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v21, arg44, null);
        ParagraphStyle v3 = null;
        if(v0 != null) {
            v24 = v0.getParagraphStyle();
        }

        super(arg45, arg46, arg47, arg49, v24, arg51, arg52, arg53, arg54, null);
        return new TextStyle(v2, v3, v0);
    }

    public static TextStyle copy-Ns73l9s$default(TextStyle arg20, Brush arg21, float arg22, long arg23, FontWeight arg25, FontStyle arg26, FontSynthesis arg27, FontFamily arg28, String arg29, long arg30, BaselineShift arg32, TextGeometricTransform arg33, LocaleList arg34, long arg35, TextDecoration arg37, Shadow arg38, DrawStyle arg39, int arg40, int arg41, long arg42, TextIndent arg44, PlatformTextStyle arg45, LineHeightStyle arg46, int arg47, int arg48, TextMotion arg49, int arg50, Object arg51) {
        TextStyle v22;
        float v24_1;
        Brush v23_1;
        long v44;
        long v37;
        LocaleList v36;
        TextGeometricTransform v35;
        BaselineShift v34;
        long v32;
        String v31;
        FontFamily v30_1;
        FontSynthesis v29_1;
        FontStyle v28_1;
        FontWeight v27_1;
        long v25_1;
        Shadow v40;
        int v49;
        LineHeightStyle v48;
        PlatformTextStyle v47;
        TextIndent v46;
        int v43;
        int v42;
        DrawStyle v41;
        TextDecoration v39;
        TextMotion v51;
        TextStyle v0 = arg20;
        int v1 = arg50;
        float v2 = (v1 & 2) != 0 ? v0.spanStyle.getAlpha() : arg22;
        long v3 = (v1 & 4) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg23;
        FontWeight v5 = (v1 & 8) != 0 ? v0.spanStyle.getFontWeight() : arg25;
        FontStyle v6 = (v1 & 16) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg26;
        FontSynthesis v7 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg27;
        FontFamily v8 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFamily() : arg28;
        String v9 = (v1 & 0x80) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg29;
        long v10 = (v1 & 0x100) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg30;
        BaselineShift v12 = (v1 & 0x200) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg32;
        TextGeometricTransform v13 = (v1 & 0x400) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg33;
        LocaleList v14 = (v1 & 0x800) != 0 ? v0.spanStyle.getLocaleList() : arg34;
        long v15 = (v1 & 0x1000) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg35;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x2000) != 0 ? v0.spanStyle.getTextDecoration() : arg37;
        TextDecoration v23 = v2_1;
        Shadow v2_2 = (v1 & 0x4000) != 0 ? v0.spanStyle.getShadow() : arg38;
        DrawStyle v1_1 = (v1 & 0x8000) != 0 ? v0.spanStyle.getDrawStyle() : arg39;
        DrawStyle v24 = v1_1;
        v1 = (arg50 & 0x10000) != 0 ? v0.paragraphStyle.getTextAlign-e0LSkKk() : arg40;
        int v25 = v1;
        v1 = (arg50 & 0x20000) != 0 ? v0.paragraphStyle.getTextDirection-s_7X-co() : arg41;
        int v26 = v1;
        long v17 = (arg50 & 0x40000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg42;
        TextIndent v1_2 = (arg50 & 0x80000) != 0 ? v0.paragraphStyle.getTextIndent() : arg44;
        TextIndent v27 = v1_2;
        PlatformTextStyle v1_3 = (arg50 & 0x100000) != 0 ? v0.platformStyle : arg45;
        PlatformTextStyle v28 = v1_3;
        LineHeightStyle v1_4 = (arg50 & 0x200000) != 0 ? v0.paragraphStyle.getLineHeightStyle() : arg46;
        LineHeightStyle v29 = v1_4;
        v1 = (arg50 & 0x400000) != 0 ? v0.paragraphStyle.getLineBreak-rAG3T2k() : arg47;
        int v30 = v1;
        v1 = (arg50 & 0x800000) != 0 ? v0.paragraphStyle.getHyphens-vmbZdU8() : arg48;
        if((arg50 & 0x1000000) != 0) {
            arg50 = v1;
            v51 = v0.paragraphStyle.getTextMotion();
            v39 = v23;
            v41 = v24;
            v42 = v25;
            v43 = v26;
            v46 = v27;
            v47 = v28;
            v48 = v29;
            v49 = v30;
            v40 = v2_2;
            v25_1 = v3;
            v27_1 = v5;
            v28_1 = v6;
            v29_1 = v7;
            v30_1 = v8;
            v31 = v9;
            v32 = v10;
            v34 = v12;
            v35 = v13;
            v36 = v14;
            v37 = v15;
            v44 = v17;
            v23_1 = arg21;
            v24_1 = arg22;
            v22 = v0;
        }
        else {
            v51 = arg49;
            arg50 = v1;
            v39 = v23;
            v41 = v24;
            v42 = v25;
            v43 = v26;
            v46 = v27;
            v47 = v28;
            v48 = v29;
            v40 = v2_2;
            v25_1 = v3;
            v27_1 = v5;
            v28_1 = v6;
            v29_1 = v7;
            v31 = v9;
            v32 = v10;
            v34 = v12;
            v35 = v13;
            v36 = v14;
            v37 = v15;
            v44 = v17;
            v23_1 = arg21;
            v24_1 = arg22;
            v49 = v30;
            v22 = v0;
            v30_1 = v8;
        }

        return v22.copy-Ns73l9s(v23_1, v24_1, v25_1, v27_1, v28_1, v29_1, v30_1, v31, v32, v34, v35, v36, v37, v39, v40, v41, v42, v43, v44, v46, v47, v48, v49, arg50, v51);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public final TextStyle copy-aIRg9q4(Brush arg26, float arg27, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, DrawStyle arg44, TextAlign arg45, TextDirection arg46, long arg47, TextIndent arg49, PlatformTextStyle arg50, LineHeightStyle arg51, LineBreak arg52, Hyphens arg53, TextMotion arg54) {
        PlatformTextStyle v0 = arg50;
        PlatformParagraphStyle v24 = null;
        PlatformSpanStyle v21 = v0 != null ? v0.getSpanStyle() : ((PlatformSpanStyle)v24);
        SpanStyle v2 = new SpanStyle(arg26, arg27, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v21, arg44, null);
        ParagraphStyle v3 = null;
        int v4 = arg45 != null ? arg45.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v5 = arg46 != null ? arg46.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v0 != null) {
            v24 = v0.getParagraphStyle();
        }

        int v6 = arg52 != null ? arg52.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v7 = arg53 != null ? arg53.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v4, v5, arg47, arg49, v24, arg51, v6, v7, arg54, null);
        return new TextStyle(v2, v3, v0);
    }

    public static TextStyle copy-aIRg9q4$default(TextStyle arg20, Brush arg21, float arg22, long arg23, FontWeight arg25, FontStyle arg26, FontSynthesis arg27, FontFamily arg28, String arg29, long arg30, BaselineShift arg32, TextGeometricTransform arg33, LocaleList arg34, long arg35, TextDecoration arg37, Shadow arg38, DrawStyle arg39, TextAlign arg40, TextDirection arg41, long arg42, TextIndent arg44, PlatformTextStyle arg45, LineHeightStyle arg46, LineBreak arg47, Hyphens arg48, TextMotion arg49, int arg50, Object arg51) {
        TextStyle v22;
        float v24_1;
        Brush v23_1;
        long v44;
        long v37;
        LocaleList v36;
        TextGeometricTransform v35;
        BaselineShift v34;
        long v32;
        String v31;
        FontFamily v30_1;
        FontSynthesis v29_1;
        FontStyle v28_1;
        FontWeight v27_1;
        long v25_1;
        Shadow v40;
        LineBreak v49;
        LineHeightStyle v48;
        PlatformTextStyle v47;
        TextIndent v46;
        TextDirection v43;
        TextAlign v42;
        DrawStyle v41;
        TextDecoration v39;
        TextMotion v51;
        Hyphens v50;
        TextStyle v0 = arg20;
        int v1 = arg50;
        float v2 = (v1 & 2) != 0 ? v0.spanStyle.getAlpha() : arg22;
        long v3 = (v1 & 4) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg23;
        FontWeight v5 = (v1 & 8) != 0 ? v0.spanStyle.getFontWeight() : arg25;
        FontStyle v6 = (v1 & 16) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg26;
        FontSynthesis v7 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg27;
        FontFamily v8 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFamily() : arg28;
        String v9 = (v1 & 0x80) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg29;
        long v10 = (v1 & 0x100) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg30;
        BaselineShift v12 = (v1 & 0x200) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg32;
        TextGeometricTransform v13 = (v1 & 0x400) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg33;
        LocaleList v14 = (v1 & 0x800) != 0 ? v0.spanStyle.getLocaleList() : arg34;
        long v15 = (v1 & 0x1000) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg35;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x2000) != 0 ? v0.spanStyle.getTextDecoration() : arg37;
        TextDecoration v23 = v2_1;
        Shadow v2_2 = (v1 & 0x4000) != 0 ? v0.spanStyle.getShadow() : arg38;
        DrawStyle v1_1 = (v1 & 0x8000) != 0 ? v0.spanStyle.getDrawStyle() : arg39;
        DrawStyle v24 = v1_1;
        TextAlign v1_2 = (arg50 & 0x10000) != 0 ? TextAlign.box-impl(v0.paragraphStyle.getTextAlign-e0LSkKk()) : arg40;
        TextAlign v25 = v1_2;
        TextDirection v1_3 = (arg50 & 0x20000) != 0 ? TextDirection.box-impl(v0.paragraphStyle.getTextDirection-s_7X-co()) : arg41;
        TextDirection v26 = v1_3;
        long v17 = (arg50 & 0x40000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg42;
        TextIndent v1_4 = (arg50 & 0x80000) != 0 ? v0.paragraphStyle.getTextIndent() : arg44;
        TextIndent v27 = v1_4;
        PlatformTextStyle v1_5 = (arg50 & 0x100000) != 0 ? v0.platformStyle : arg45;
        PlatformTextStyle v28 = v1_5;
        LineHeightStyle v1_6 = (arg50 & 0x200000) != 0 ? v0.paragraphStyle.getLineHeightStyle() : arg46;
        LineHeightStyle v29 = v1_6;
        LineBreak v1_7 = (arg50 & 0x400000) != 0 ? LineBreak.box-impl(v0.paragraphStyle.getLineBreak-rAG3T2k()) : arg47;
        LineBreak v30 = v1_7;
        Hyphens v1_8 = (arg50 & 0x800000) != 0 ? Hyphens.box-impl(v0.paragraphStyle.getHyphens-vmbZdU8()) : arg48;
        if((arg50 & 0x1000000) != 0) {
            v50 = v1_8;
            v51 = v0.paragraphStyle.getTextMotion();
            v39 = v23;
            v41 = v24;
            v42 = v25;
            v43 = v26;
            v46 = v27;
            v47 = v28;
            v48 = v29;
            v49 = v30;
            v40 = v2_2;
            v25_1 = v3;
            v27_1 = v5;
            v28_1 = v6;
            v29_1 = v7;
            v30_1 = v8;
            v31 = v9;
            v32 = v10;
            v34 = v12;
            v35 = v13;
            v36 = v14;
            v37 = v15;
            v44 = v17;
            v23_1 = arg21;
            v24_1 = arg22;
            v22 = v0;
        }
        else {
            v51 = arg49;
            v50 = v1_8;
            v39 = v23;
            v41 = v24;
            v42 = v25;
            v43 = v26;
            v46 = v27;
            v47 = v28;
            v48 = v29;
            v40 = v2_2;
            v25_1 = v3;
            v27_1 = v5;
            v28_1 = v6;
            v29_1 = v7;
            v31 = v9;
            v32 = v10;
            v34 = v12;
            v35 = v13;
            v36 = v14;
            v37 = v15;
            v44 = v17;
            v23_1 = arg21;
            v24_1 = arg22;
            v49 = v30;
            v22 = v0;
            v30_1 = v8;
        }

        return v22.copy-aIRg9q4(v23_1, v24_1, v25_1, v27_1, v28_1, v29_1, v30_1, v31, v32, v34, v35, v36, v37, v39, v40, v41, v42, v43, v44, v46, v47, v48, v49, v50, v51);
    }

    public final TextStyle copy-p1EtxEg(long arg27, long arg29, FontWeight arg31, FontStyle arg32, FontSynthesis arg33, FontFamily arg34, String arg35, long arg36, BaselineShift arg38, TextGeometricTransform arg39, LocaleList arg40, long arg41, TextDecoration arg43, Shadow arg44, DrawStyle arg45, int arg46, int arg47, long arg48, TextIndent arg50, PlatformTextStyle arg51, LineHeightStyle arg52, int arg53, int arg54, TextMotion arg55) {
        TextStyle v0 = this;
        long v1 = arg27;
        PlatformTextStyle v3 = arg51;
        TextForegroundStyle v0_1 = Color.equals-impl0(v1, v0.spanStyle.getColor-0d7_KjU()) ? v0.spanStyle.getTextForegroundStyle$ui_text() : TextForegroundStyle.Companion.from-8_81llA(v1);
        TextForegroundStyle v6 = v0_1;
        PlatformParagraphStyle v0_2 = null;
        PlatformSpanStyle v23 = v3 != null ? v3.getSpanStyle() : ((PlatformSpanStyle)v0_2);
        SpanStyle v5 = new SpanStyle(v6, arg29, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, arg43, arg44, v23, arg45, null);
        ParagraphStyle v1_1 = null;
        if(v3 != null) {
            v0_2 = v3.getParagraphStyle();
        }

        super(arg46, arg47, arg48, arg50, v0_2, arg52, arg53, arg54, arg55, null);
        return new TextStyle(v5, v1_1, v3);
    }

    public static TextStyle copy-p1EtxEg$default(TextStyle arg21, long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, DrawStyle arg40, int arg41, int arg42, long arg43, TextIndent arg45, PlatformTextStyle arg46, LineHeightStyle arg47, int arg48, int arg49, TextMotion arg50, int arg51, Object arg52) {
        TextMotion v51;
        int v50;
        TextStyle v0 = arg21;
        int v1 = arg51;
        long v2 = (v1 & 1) != 0 ? v0.spanStyle.getColor-0d7_KjU() : arg22;
        long v4 = (v1 & 2) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg24;
        FontWeight v6 = (v1 & 4) != 0 ? v0.spanStyle.getFontWeight() : arg26;
        FontStyle v7 = (v1 & 8) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg27;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg28;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontFamily() : arg29;
        String v10 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg30;
        long v11 = (v1 & 0x80) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg31;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg33;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg34;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.spanStyle.getLocaleList() : arg35;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg36;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.spanStyle.getTextDecoration() : arg38;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.spanStyle.getShadow() : arg39;
        TextDecoration v24 = v2_1;
        DrawStyle v2_2 = (v1 & 0x4000) != 0 ? v0.spanStyle.getDrawStyle() : arg40;
        v1 = (v1 & 0x8000) != 0 ? v0.paragraphStyle.getTextAlign-e0LSkKk() : arg41;
        int v25 = v1;
        v1 = (arg51 & 0x10000) != 0 ? v0.paragraphStyle.getTextDirection-s_7X-co() : arg42;
        int v26 = v1;
        long v18 = (arg51 & 0x20000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg43;
        TextIndent v1_1 = (arg51 & 0x40000) != 0 ? v0.paragraphStyle.getTextIndent() : arg45;
        TextIndent v27 = v1_1;
        PlatformTextStyle v1_2 = (arg51 & 0x80000) != 0 ? v0.platformStyle : arg46;
        PlatformTextStyle v28 = v1_2;
        LineHeightStyle v1_3 = (arg51 & 0x100000) != 0 ? v0.paragraphStyle.getLineHeightStyle() : arg47;
        LineHeightStyle v29 = v1_3;
        v1 = (arg51 & 0x200000) != 0 ? v0.paragraphStyle.getLineBreak-rAG3T2k() : arg48;
        int v30 = v1;
        v1 = (arg51 & 0x400000) != 0 ? v0.paragraphStyle.getHyphens-vmbZdU8() : arg49;
        if((arg51 & 0x800000) != 0) {
            v50 = v1;
            v51 = v0.paragraphStyle.getTextMotion();
        }
        else {
            v51 = arg50;
            v50 = v1;
        }

        return v0.copy-p1EtxEg(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg22, v24, v3, v2_2, v25, v26, v18, v27, v28, v29, v30, v50, v51);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public final TextStyle copy-v2rsoow(long arg27, long arg29, FontWeight arg31, FontStyle arg32, FontSynthesis arg33, FontFamily arg34, String arg35, long arg36, BaselineShift arg38, TextGeometricTransform arg39, LocaleList arg40, long arg41, TextDecoration arg43, Shadow arg44, DrawStyle arg45, TextAlign arg46, TextDirection arg47, long arg48, TextIndent arg50, PlatformTextStyle arg51, LineHeightStyle arg52, LineBreak arg53, Hyphens arg54, TextMotion arg55) {
        TextStyle v0 = this;
        long v1 = arg27;
        PlatformTextStyle v3 = arg51;
        TextForegroundStyle v0_1 = Color.equals-impl0(v1, v0.spanStyle.getColor-0d7_KjU()) ? v0.spanStyle.getTextForegroundStyle$ui_text() : TextForegroundStyle.Companion.from-8_81llA(v1);
        TextForegroundStyle v6 = v0_1;
        PlatformParagraphStyle v0_2 = null;
        PlatformSpanStyle v23 = v3 != null ? v3.getSpanStyle() : ((PlatformSpanStyle)v0_2);
        SpanStyle v5 = new SpanStyle(v6, arg29, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, arg43, arg44, v23, arg45, null);
        ParagraphStyle v1_1 = null;
        int v2 = arg46 != null ? arg46.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v6_1 = arg47 != null ? arg47.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(v3 != null) {
            v0_2 = v3.getParagraphStyle();
        }

        int v7 = arg53 != null ? arg53.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v8 = arg54 != null ? arg54.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        super(v2, v6_1, arg48, arg50, v0_2, arg52, v7, v8, arg55, null);
        return new TextStyle(v5, v1_1, v3);
    }

    public static TextStyle copy-v2rsoow$default(TextStyle arg21, long arg22, long arg24, FontWeight arg26, FontStyle arg27, FontSynthesis arg28, FontFamily arg29, String arg30, long arg31, BaselineShift arg33, TextGeometricTransform arg34, LocaleList arg35, long arg36, TextDecoration arg38, Shadow arg39, DrawStyle arg40, TextAlign arg41, TextDirection arg42, long arg43, TextIndent arg45, PlatformTextStyle arg46, LineHeightStyle arg47, LineBreak arg48, Hyphens arg49, TextMotion arg50, int arg51, Object arg52) {
        TextMotion v51;
        Hyphens v50;
        TextStyle v0 = arg21;
        int v1 = arg51;
        long v2 = (v1 & 1) != 0 ? v0.spanStyle.getColor-0d7_KjU() : arg22;
        long v4 = (v1 & 2) != 0 ? v0.spanStyle.getFontSize-XSAIIZE() : arg24;
        FontWeight v6 = (v1 & 4) != 0 ? v0.spanStyle.getFontWeight() : arg26;
        FontStyle v7 = (v1 & 8) != 0 ? v0.spanStyle.getFontStyle-4Lr2A7w() : arg27;
        FontSynthesis v8 = (v1 & 16) != 0 ? v0.spanStyle.getFontSynthesis-ZQGJjVo() : arg28;
        FontFamily v9 = (v1 & 0x20) != 0 ? v0.spanStyle.getFontFamily() : arg29;
        String v10 = (v1 & 0x40) != 0 ? v0.spanStyle.getFontFeatureSettings() : arg30;
        long v11 = (v1 & 0x80) != 0 ? v0.spanStyle.getLetterSpacing-XSAIIZE() : arg31;
        BaselineShift v13 = (v1 & 0x100) != 0 ? v0.spanStyle.getBaselineShift-5SSeXJ0() : arg33;
        TextGeometricTransform v14 = (v1 & 0x200) != 0 ? v0.spanStyle.getTextGeometricTransform() : arg34;
        LocaleList v15 = (v1 & 0x400) != 0 ? v0.spanStyle.getLocaleList() : arg35;
        long v16 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.spanStyle.getBackground-0d7_KjU() : arg36;
        arg22 = v2;
        TextDecoration v2_1 = (v1 & 0x1000) != 0 ? v0.spanStyle.getTextDecoration() : arg38;
        Shadow v3 = (v1 & 0x2000) != 0 ? v0.spanStyle.getShadow() : arg39;
        TextDecoration v24 = v2_1;
        DrawStyle v2_2 = (v1 & 0x4000) != 0 ? v0.spanStyle.getDrawStyle() : arg40;
        TextAlign v1_1 = (v1 & 0x8000) != 0 ? TextAlign.box-impl(v0.paragraphStyle.getTextAlign-e0LSkKk()) : arg41;
        TextAlign v25 = v1_1;
        TextDirection v1_2 = (arg51 & 0x10000) != 0 ? TextDirection.box-impl(v0.paragraphStyle.getTextDirection-s_7X-co()) : arg42;
        TextDirection v26 = v1_2;
        long v18 = (arg51 & 0x20000) != 0 ? v0.paragraphStyle.getLineHeight-XSAIIZE() : arg43;
        TextIndent v1_3 = (arg51 & 0x40000) != 0 ? v0.paragraphStyle.getTextIndent() : arg45;
        TextIndent v27 = v1_3;
        PlatformTextStyle v1_4 = (arg51 & 0x80000) != 0 ? v0.platformStyle : arg46;
        PlatformTextStyle v28 = v1_4;
        LineHeightStyle v1_5 = (arg51 & 0x100000) != 0 ? v0.paragraphStyle.getLineHeightStyle() : arg47;
        LineHeightStyle v29 = v1_5;
        LineBreak v1_6 = (arg51 & 0x200000) != 0 ? LineBreak.box-impl(v0.paragraphStyle.getLineBreak-rAG3T2k()) : arg48;
        LineBreak v30 = v1_6;
        Hyphens v1_7 = (arg51 & 0x400000) != 0 ? Hyphens.box-impl(v0.paragraphStyle.getHyphens-vmbZdU8()) : arg49;
        if((arg51 & 0x800000) != 0) {
            v50 = v1_7;
            v51 = v0.paragraphStyle.getTextMotion();
        }
        else {
            v51 = arg50;
            v50 = v1_7;
        }

        return v0.copy-v2rsoow(v16, v4, v6, v7, v8, v9, v10, v11, v13, v14, v15, arg22, v24, v3, v2_2, v25, v26, v18, v27, v28, v29, v30, v50, v51);
    }

    public boolean equals(Object arg5) {
        if(this == (((TextStyle)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.spanStyle, ((TextStyle)arg5).spanStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.paragraphStyle, ((TextStyle)arg5).paragraphStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformStyle, ((TextStyle)arg5).platformStyle)) {
            return 0;
        }

        return 1;
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    public final long getBackground-0d7_KjU() {
        return this.spanStyle.getBackground-0d7_KjU();
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.spanStyle.getBaselineShift-5SSeXJ0();
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    public final long getColor-0d7_KjU() {
        return this.spanStyle.getColor-0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    public final long getFontSize-XSAIIZE() {
        return this.spanStyle.getFontSize-XSAIIZE();
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.spanStyle.getFontStyle-4Lr2A7w();
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.spanStyle.getFontSynthesis-ZQGJjVo();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    public final Hyphens getHyphens-EaSxIns() {
        return Hyphens.box-impl(this.getHyphens-vmbZdU8());
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getHyphens-EaSxIns$annotations() {
    }

    public final int getHyphens-vmbZdU8() {
        return this.paragraphStyle.getHyphens-vmbZdU8();
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.spanStyle.getLetterSpacing-XSAIIZE();
    }

    public final LineBreak getLineBreak-LgCVezo() {
        return LineBreak.box-impl(this.getLineBreak-rAG3T2k());
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getLineBreak-LgCVezo$annotations() {
    }

    public final int getLineBreak-rAG3T2k() {
        return this.paragraphStyle.getLineBreak-rAG3T2k();
    }

    public final long getLineHeight-XSAIIZE() {
        return this.paragraphStyle.getLineHeight-XSAIIZE();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    public final ParagraphStyle getParagraphStyle$ui_text() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final SpanStyle getSpanStyle$ui_text() {
        return this.spanStyle;
    }

    public final TextAlign getTextAlign-buA522U() {
        return TextAlign.box-impl(this.getTextAlign-e0LSkKk());
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getTextAlign-buA522U$annotations() {
    }

    public final int getTextAlign-e0LSkKk() {
        return this.paragraphStyle.getTextAlign-e0LSkKk();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final TextDirection getTextDirection-mmuk1to() {
        return TextDirection.box-impl(this.getTextDirection-s_7X-co());
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getTextDirection-mmuk1to$annotations() {
    }

    public final int getTextDirection-s_7X-co() {
        return this.paragraphStyle.getTextDirection-s_7X-co();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle arg1) {
        if(this != arg1) {
            if(this.spanStyle.hasSameNonLayoutAttributes$ui_text(arg1.spanStyle)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle arg3) {
        if(this != arg3 && (!Intrinsics.areEqual(this.paragraphStyle, arg3.paragraphStyle) || !this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(arg3.spanStyle))) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = (this.spanStyle.hashCode() * 0x1F + this.paragraphStyle.hashCode()) * 0x1F;
        PlatformTextStyle v2 = this.platformStyle;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int v0 = (this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text() * 0x1F + this.paragraphStyle.hashCode()) * 0x1F;
        PlatformTextStyle v2 = this.platformStyle;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public final TextStyle merge(TextStyle arg4) {
        if(arg4 != null) {
            if(Intrinsics.areEqual(arg4, TextStyle.Default)) {
            }
            else {
                return new TextStyle(this.toSpanStyle().merge(arg4.toSpanStyle()), this.toParagraphStyle().merge(arg4.toParagraphStyle()));
            }
        }

        return this;
    }

    public final TextStyle merge(ParagraphStyle arg3) {
        return new TextStyle(this.toSpanStyle(), this.toParagraphStyle().merge(arg3));
    }

    public final TextStyle merge(SpanStyle arg3) {
        return new TextStyle(this.toSpanStyle().merge(arg3), this.toParagraphStyle());
    }

    public static TextStyle merge$default(TextStyle arg0, TextStyle arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return arg0.merge(arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public final TextStyle merge-Z1GrekI(long arg26, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, DrawStyle arg44, TextAlign arg45, TextDirection arg46, long arg47, TextIndent arg49, LineHeightStyle arg50, LineBreak arg51, Hyphens arg52, PlatformTextStyle arg53, TextMotion arg54) {
        TextStyle v0 = this;
        SpanStyle v1 = v0.spanStyle;
        PlatformParagraphStyle v24 = null;
        PlatformSpanStyle v22 = arg53 != null ? arg53.getSpanStyle() : ((PlatformSpanStyle)v24);
        v1 = SpanStyleKt.fastMerge-dSHsh3o(v1, arg26, null, NaNf, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v22, arg44);
        ParagraphStyle v2 = v0.paragraphStyle;
        int v3 = arg45 != null ? arg45.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v4 = arg46 != null ? arg46.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        if(arg53 != null) {
            v24 = arg53.getParagraphStyle();
        }

        int v5 = arg51 != null ? arg51.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v6 = arg52 != null ? arg52.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        v2 = ParagraphStyleKt.fastMerge-j5T8yCg(v2, v3, v4, arg47, arg49, v24, arg50, v5, v6, arg54);
        if(v0.spanStyle == v1 && v0.paragraphStyle == v2) {
            return v0;
        }

        return new TextStyle(v1, v2);
    }

    public static TextStyle merge-Z1GrekI$default(TextStyle arg30, long arg31, long arg33, FontWeight arg35, FontStyle arg36, FontSynthesis arg37, FontFamily arg38, String arg39, long arg40, BaselineShift arg42, TextGeometricTransform arg43, LocaleList arg44, long arg45, TextDecoration arg47, Shadow arg48, DrawStyle arg49, TextAlign arg50, TextDirection arg51, long arg52, TextIndent arg54, LineHeightStyle arg55, LineBreak arg56, Hyphens arg57, PlatformTextStyle arg58, TextMotion arg59, int arg60, Object arg61) {
        int v0 = arg60;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg33;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg35;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg36;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg37;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg38;
        String v10 = (v0 & 0x40) != 0 ? null : arg39;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg40;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg42;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg43;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg44;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg45;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg47;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg48;
        DrawStyle v2 = (v0 & 0x4000) != 0 ? null : arg49;
        TextAlign v20 = (v0 & 0x8000) != 0 ? null : arg50;
        TextDirection v21 = (v0 & 0x10000) != 0 ? null : arg51;
        long v22 = (v0 & 0x20000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
        TextIndent v24 = (v0 & 0x40000) != 0 ? null : arg54;
        LineHeightStyle v25 = (v0 & 0x80000) != 0 ? null : arg55;
        LineBreak v26 = (v0 & 0x100000) != 0 ? null : arg56;
        Hyphens v27 = (v0 & 0x200000) != 0 ? null : arg57;
        PlatformTextStyle v28 = (v0 & 0x400000) != 0 ? null : arg58;
        TextMotion v60 = (v0 & 0x800000) != 0 ? null : arg59;
        return arg30.merge-Z1GrekI(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v22, v24, v25, v26, v27, v28, v60);
    }

    public final TextStyle merge-dA7vx0o(long arg26, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, DrawStyle arg44, int arg45, int arg46, long arg47, TextIndent arg49, LineHeightStyle arg50, int arg51, int arg52, PlatformTextStyle arg53, TextMotion arg54) {
        TextStyle v0 = this;
        SpanStyle v1 = v0.spanStyle;
        PlatformParagraphStyle v24 = null;
        PlatformSpanStyle v22 = arg53 != null ? arg53.getSpanStyle() : ((PlatformSpanStyle)v24);
        v1 = SpanStyleKt.fastMerge-dSHsh3o(v1, arg26, null, NaNf, arg28, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43, v22, arg44);
        ParagraphStyle v2 = v0.paragraphStyle;
        if(arg53 != null) {
            v24 = arg53.getParagraphStyle();
        }

        v2 = ParagraphStyleKt.fastMerge-j5T8yCg(v2, arg45, arg46, arg47, arg49, v24, arg50, arg51, arg52, arg54);
        if(v0.spanStyle == v1 && v0.paragraphStyle == v2) {
            return v0;
        }

        return new TextStyle(v1, v2);
    }

    public static TextStyle merge-dA7vx0o$default(TextStyle arg30, long arg31, long arg33, FontWeight arg35, FontStyle arg36, FontSynthesis arg37, FontFamily arg38, String arg39, long arg40, BaselineShift arg42, TextGeometricTransform arg43, LocaleList arg44, long arg45, TextDecoration arg47, Shadow arg48, DrawStyle arg49, int arg50, int arg51, long arg52, TextIndent arg54, LineHeightStyle arg55, int arg56, int arg57, PlatformTextStyle arg58, TextMotion arg59, int arg60, Object arg61) {
        int v0 = arg60;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg33;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg35;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg36;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg37;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg38;
        String v10 = (v0 & 0x40) != 0 ? null : arg39;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg40;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg42;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg43;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg44;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg45;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg47;
        long v18 = v1;
        Shadow v1_1 = (v0 & 0x2000) != 0 ? null : arg48;
        DrawStyle v2 = (v0 & 0x4000) != 0 ? null : arg49;
        int v20 = (v0 & 0x8000) != 0 ? TextAlign.Companion.getUnspecified-e0LSkKk() : arg50;
        int v21 = (v0 & 0x10000) != 0 ? TextDirection.Companion.getUnspecified-s_7X-co() : arg51;
        long v22 = (v0 & 0x20000) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
        TextIndent v24 = (v0 & 0x40000) != 0 ? null : arg54;
        LineHeightStyle v25 = (v0 & 0x80000) != 0 ? null : arg55;
        int v26 = (v0 & 0x100000) != 0 ? LineBreak.Companion.getUnspecified-rAG3T2k() : arg56;
        int v27 = (v0 & 0x200000) != 0 ? Hyphens.Companion.getUnspecified-vmbZdU8() : arg57;
        PlatformTextStyle v28 = (v0 & 0x400000) != 0 ? null : arg58;
        TextMotion v60 = (v0 & 0x800000) != 0 ? null : arg59;
        return arg30.merge-dA7vx0o(v18, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v1_1, v2, v20, v21, v22, v24, v25, v26, v27, v28, v60);
    }

    public final TextStyle plus(ParagraphStyle arg1) {
        return this.merge(arg1);
    }

    public final TextStyle plus(SpanStyle arg1) {
        return this.merge(arg1);
    }

    public final TextStyle plus(TextStyle arg1) {
        return this.merge(arg1);
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("TextStyle(color=");
        v0.append(Color.toString-impl(this.getColor-0d7_KjU())).append(", brush=").append(this.getBrush()).append(", alpha=").append(this.getAlpha()).append(", fontSize=").append(TextUnit.toString-impl(this.getFontSize-XSAIIZE())).append(", fontWeight=").append(this.getFontWeight()).append(", fontStyle=").append(this.getFontStyle-4Lr2A7w()).append(", fontSynthesis=").append(this.getFontSynthesis-ZQGJjVo()).append(", fontFamily=").append(this.getFontFamily()).append(", fontFeatureSettings=").append(this.getFontFeatureSettings()).append(", letterSpacing=").append(TextUnit.toString-impl(this.getLetterSpacing-XSAIIZE())).append(", baselineShift=").append(this.getBaselineShift-5SSeXJ0()).append(", textGeometricTransform=");
        v0.append(this.getTextGeometricTransform()).append(", localeList=").append(this.getLocaleList()).append(", background=").append(Color.toString-impl(this.getBackground-0d7_KjU())).append(", textDecoration=").append(this.getTextDecoration()).append(", shadow=").append(this.getShadow()).append(", drawStyle=").append(this.getDrawStyle()).append(", textAlign=").append(TextAlign.toString-impl(this.getTextAlign-e0LSkKk())).append(", textDirection=").append(TextDirection.toString-impl(this.getTextDirection-s_7X-co())).append(", lineHeight=").append(TextUnit.toString-impl(this.getLineHeight-XSAIIZE())).append(", textIndent=").append(this.getTextIndent()).append(", platformStyle=").append(this.platformStyle).append(", lineHeightStyle=").append(this.getLineHeightStyle());
        v0.append(", lineBreak=").append(LineBreak.toString-impl(this.getLineBreak-rAG3T2k())).append(", hyphens=").append(Hyphens.toString-impl(this.getHyphens-vmbZdU8())).append(", textMotion=").append(this.getTextMotion()).append(')');
        return v0.toString();
    }
}

