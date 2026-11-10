package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!H\u0001¢\u0006\u0004\b&\u0010\'J3\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0002\u0010+J3\u0010(\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0002\u0010,J\u0093\u0001\u0010(\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052!\b\u0002\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00106\u001A\u000205H\u0007¢\u0006\u0004\b7\u00108J\u009B\u0001\u0010(\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%2\u0006\u00109\u001A\u0002052\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052!\b\u0002\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00106\u001A\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u009D\u0001\u0010<\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052!\b\u0002\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00106\u001A\u0002052\b\b\u0002\u00109\u001A\u000205H\u0001¢\u0006\u0004\b=\u0010>J\u009D\u0001\u0010?\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%2\u0006\u00109\u001A\u0002052\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0004\u001A\u00020\u00052\u001F\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u0002052\u0006\u0010@\u001A\u00020\u001F2\u0006\u0010A\u001A\u00020\u001FH\u0003¢\u0006\u0004\bB\u0010CJ3\u0010(\u001A\u00020\u00192\u0006\u0010D\u001A\u00020E2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0002\u0010FJ\u0093\u0001\u0010(\u001A\u00020\u00192\u0006\u0010D\u001A\u00020E2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052!\b\u0002\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00106\u001A\u000205H\u0007¢\u0006\u0004\b7\u0010GJ\u009B\u0001\u0010(\u001A\u00020\u00192\u0006\u0010D\u001A\u00020E2\u0006\u00109\u001A\u0002052\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052!\b\u0002\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00106\u001A\u000205H\u0001¢\u0006\u0004\b:\u0010HJ\u008D\u0001\u0010?\u001A\u00020\u00192\u0006\u0010D\u001A\u00020E2\u0006\u00109\u001A\u0002052\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0004\u001A\u00020\u00052\u001F\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u000205H\u0003¢\u0006\u0004\bI\u0010JJï\u0001\u0010K\u001A\u00020\u0019*\u00020/2\u0006\u0010L\u001A\u00020M2\u0006\u0010N\u001A\u00020O2\u0006\u0010P\u001A\u00020O2\u0006\u0010\u000B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010Q\u001A\u0002052\u0006\u0010R\u001A\u0002052\u0006\u0010S\u001A\u0002052\u0006\u0010T\u001A\u0002052\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u0002052\u0006\u00109\u001A\u0002052\u001F\u0010-\u001A\u001B\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001A\u001F\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u0010U\u001A\u00020\u001F2\b\b\u0002\u0010@\u001A\u00020\u001F2\b\b\u0002\u0010V\u001A\u00020W2\b\b\u0002\u0010A\u001A\u00020\u001FH\u0002¢\u0006\u0004\bX\u0010YJC\u0010Z\u001A\u00020\u0019*\u00020/2\u0006\u0010V\u001A\u00020W2\u0006\u0010[\u001A\u0002002\u0006\u0010\\\u001A\u00020]2\u0006\u0010^\u001A\u00020\b2\u0006\u0010_\u001A\u00020O2\u0006\u0010`\u001A\u00020OH\u0002¢\u0006\u0004\ba\u0010bJ)\u0010-\u001A\u00020\u0019*\u00020/2\u0006\u0010[\u001A\u0002002\u0006\u0010\\\u001A\u0002052\u0006\u0010^\u001A\u00020\b¢\u0006\u0004\bc\u0010dR\u0018\u0010\u0014\u001A\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010e\u001A\u000205¢\u0006\n\n\u0002\u0010h\u001A\u0004\bf\u0010gR\u0013\u0010i\u001A\u000205¢\u0006\n\n\u0002\u0010h\u001A\u0004\bj\u0010gR\u000E\u0010k\u001A\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2={"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A$material3", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4$material3", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0$material3", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SliderDefaults {
    public static final int $stable;
    public static final SliderDefaults INSTANCE;
    private static final float TickSize;
    private static final float TrackStopIndicatorSize;
    private static final Path trackPath;

    static {
        SliderDefaults.INSTANCE = new SliderDefaults();
        SliderDefaults.TrackStopIndicatorSize = SliderTokens.INSTANCE.getStopIndicatorSize-D9Ej5fM();
        SliderDefaults.TickSize = SliderTokens.INSTANCE.getStopIndicatorSize-D9Ej5fM();
        SliderDefaults.trackPath = AndroidPath_androidKt.Path();
    }

    private SliderDefaults() {
        super();
    }

    public final void CenteredTrack-7LSsfP0$material3(SliderState arg24, Modifier arg25, boolean arg26, SliderColors arg27, Function2 arg28, Function3 arg29, float arg30, float arg31, float arg32, Composer arg33, int arg34, int arg35) {
        float v10_2;
        Function2 v6_2;
        Modifier v3;
        float v9_1;
        SliderColors v5_1;
        boolean v4_1;
        Function3 v7_1;
        Object v7_2;
        SliderDefaults$CenteredTrack$2$1 v1_4;
        Object v13_2;
        SliderDefaults$$ExternalSyntheticLambda14 v2_4;
        Companion v6_1;
        int v20;
        float v2_1;
        float v8;
        int v17;
        int v14;
        Function2 v13_1;
        int v13;
        SliderColors v10_1;
        boolean v9;
        int v7;
        Modifier v6;
        int v4;
        SliderDefaults v0 = this;
        int v15 = arg34;
        int v1 = arg35;
        Composer v12 = arg33.startRestartGroup(0x477E04AF);
        ComposerKt.sourceInformation(v12, "C(CenteredTrack)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,trackCornerSize:c#ui.unit.Dp)1558@69596L466:Slider.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v4 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v4 = v12.changedInstance(arg24) ? 4 : 2;
            v4 |= v15;
        }
        else {
            v4 = v15;
        }

        int v5 = v1 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_40;
        }
        else if((v15 & 0x30) == 0) {
            v6 = arg25;
            v7 = v12.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_40:
            v6 = arg25;
        }

        v7 = v1 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_55;
        }
        else if((v15 & 0x180) == 0) {
            v9 = arg26;
            int v10 = v12.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_55:
            v9 = arg26;
        }

        if((v15 & 0xC00) == 0) {
            if((v1 & 8) == 0) {
                v10_1 = arg27;
                if(v12.changed(v10_1)) {
                    v13 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v10_1 = arg27;
            label_66:
                v13 = 0x400;
            }

            v4 |= v13;
        }
        else {
            v10_1 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 16) == 0) {
                v13_1 = arg28;
                if(v12.changedInstance(v13_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v13_1 = arg28;
            label_80:
                v14 = 0x2000;
            }

            v4 |= v14;
        }
        else {
            v13_1 = arg28;
        }

        v14 = v1 & 0x20;
        int v16 = 0x30000;
        if(v14 != 0) {
            v4 |= v16;
        }
        else {
            Function3 v2 = arg29;
            if((v15 & v16) == 0) {
                v17 = v12.changedInstance(v2) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = v1 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v4 |= v18;
            v8 = arg30;
        }
        else {
            v8 = arg30;
            if((v15 & v18) == 0) {
                v18 = v12.changed(v8) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        int v11 = v1 & 0x80;
        int v19 = 0xC00000;
        if(v11 != 0) {
            v4 |= v19;
        }
        else {
            v2_1 = arg31;
            if((v15 & v19) == 0) {
                v19 = v12.changed(v2_1) ? 0x800000 : 0x400000;
                v4 |= v19;
            }
        }

        int v2_2 = v1 & 0x100;
        v19 = 0x6000000;
        if(v2_2 != 0) {
            v4 |= v19;
            goto label_145;
        }
        else if((v15 & v19) == 0) {
            v19 = v2_2;
            v20 = v12.changed(arg32) ? 0x4000000 : 0x2000000;
            v4 |= v20;
        }
        else {
        label_145:
            v19 = v2_2;
        }

        v20 = 0x30000000;
        if((v1 & 0x200) != 0) {
            v4 |= v20;
        }
        else if((v15 & v20) == 0) {
            v2_2 = v12.changed(v0) ? 0x20000000 : 0x10000000;
            v4 |= v2_2;
        }

        int v21 = 0;
        boolean v1_1 = (306783379 & v4) != 306783378 ? true : false;
        if(v12.shouldExecute(v1_1, v4 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "1543@68991L8,1544@69060L199,1551@69315L107");
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v9 = true;
                }

                if((arg35 & 8) != 0) {
                    SliderColors v1_2 = v0.colors(v12, v4 >> 27 & 14);
                    v4 &= 0xFFFFE3FF;
                    v10_1 = v1_2;
                }

                if((arg35 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 0x600FBA76, "CC(remember):Slider.kt#9igjgp");
                    v2_2 = 0x800;
                    v1 = (v4 & 0x1C00 ^ 0xC00) > v2_2 && (v12.changed(v10_1)) || (v4 & 0xC00) == v2_2 ? 1 : 0;
                    if((v4 & 0x380) == 0x100) {
                        v21 = 1;
                    }

                    Object v2_3 = v12.rememberedValue();
                    if((v1 | v21) != 0 || v2_3 == Composer.Companion.getEmpty()) {
                        v2_4 = new SliderDefaults$$ExternalSyntheticLambda14(v10_1, v9);
                        v12.updateRememberedValue(v2_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                    v13_2 = v2_4;
                    v4 &= 0xFFFF1FFF;
                }

                if(v14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 0x600FD9FA, "CC(remember):Slider.kt#9igjgp");
                    Object v1_3 = v12.rememberedValue();
                    if(v1_3 == Composer.Companion.getEmpty()) {
                        v1_4 = SliderDefaults$CenteredTrack$2$1.INSTANCE;
                        v12.updateRememberedValue(v1_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                }
                else {
                    Function3 v1_5 = arg29;
                }

                if(v17 != 0) {
                    v8 = SliderKt.access$getThumbTrackGapSize$p();
                }

                v2_1 = v11 != 0 ? SliderKt.access$getTrackInsideCornerSize$p() : arg31;
                if(v19 != 0) {
                    v7_2 = v1_4;
                    v1 = v4;
                    v4_1 = v9;
                    v9_1 = v2_1;
                    v2_1 = Dp.Companion.getUnspecified-D9Ej5fM();
                    v5_1 = v10_1;
                    goto label_278;
                }

                v7_2 = v1_4;
                v1 = v4;
                v4_1 = v9;
                v5_1 = v10_1;
                v9_1 = v2_1;
                v2_1 = arg32;
            }
            else {
                v12.skipToGroupEnd();
                if((arg35 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg35 & 16) != 0) {
                    v4 &= 0xFFFF1FFF;
                }

                v7_1 = arg29;
                v2_1 = arg32;
                v1 = v4;
                v4_1 = v9;
                v5_1 = v10_1;
                v9_1 = arg31;
            }

        label_278:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x477E04AF, v1, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1557)");
            }

            v11 = v1 << 3;
            v3 = ((Modifier)v6_1);
            v6_2 = ((Function2)v13_2);
            v0.TrackImpl-VvwgllI(arg24, v2_1, v3, v4_1, v5_1, v6_2, v7_1, v8, v9_1, true, true, v12, v1 & 14 | v20 | v1 >> 21 & 0x70 | v11 & 0x380 | v11 & 0x1C00 | 0xE000 & v11 | 0x70000 & v11 | 0x380000 & v11 | 0x1C00000 & v11 | v11 & 0xE000000, v1 >> 24 & 0x70 | 6);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_2 = v2_1;
        }
        else {
            v12.skipToGroupEnd();
            v7_1 = arg29;
            v3 = v6;
            v4_1 = v9;
            v5_1 = v10_1;
            v6_2 = v13_1;
            v9_1 = arg31;
            v10_2 = arg32;
        }

        ScopeUpdateScope v13_3 = v12.endRestartGroup();
        if(v13_3 != null) {
            v13_3.updateScope(new SliderDefaults$$ExternalSyntheticLambda15(this, arg24, v3, v4_1, v5_1, v6_2, v7_1, v8, v9_1, v10_2, v15, arg35));
        }
    }

    static final Unit CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors arg7, boolean arg8, DrawScope arg9, Offset arg10) {
        SliderDefaults.INSTANCE.drawStopIndicator-x3O1jOs(arg9, arg10.unbox-impl(), SliderDefaults.TrackStopIndicatorSize, arg7.trackColor-WaAFU9c$material3(arg8, true));
        return Unit.INSTANCE;
    }

    static final Unit CenteredTrack_7LSsfP0$lambda$25(SliderDefaults arg14, SliderState arg15, Modifier arg16, boolean arg17, SliderColors arg18, Function2 arg19, Function3 arg20, float arg21, float arg22, float arg23, int arg24, int arg25, Composer arg26, int arg27) {
        arg14.CenteredTrack-7LSsfP0$material3(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public final void Thumb-9LiSoMs(MutableInteractionSource arg26, Modifier arg27, SliderColors arg28, boolean arg29, long arg30, Composer arg32, int arg33, int arg34) {
        long v6_3;
        SliderDefaults$Thumb$1$1 v6_2;
        long v19;
        Companion v9_1;
        int v16;
        long v14;
        int v13;
        boolean v12;
        int v11;
        SliderColors v10_1;
        Modifier v9;
        int v4;
        SliderDefaults v1 = this;
        MutableInteractionSource v2 = arg26;
        int v8 = arg33;
        Composer v3 = arg32.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(v3, "C(Thumb)N(interactionSource,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1213@54450L46,1214@54539L658,1214@54505L692,1237@55596L5,1233@55392L220:Slider.kt#uh7d8r");
        if((arg34 & 1) != 0) {
            v4 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v4 = v3.changed(v2) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v4 = v8;
        }

        int v7 = arg34 & 2;
        if(v7 != 0) {
            v4 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v9 = arg27;
            int v10 = v3.changed(v9) ? 0x20 : 16;
            v4 |= v10;
        }
        else {
        label_36:
            v9 = arg27;
        }

        if((v8 & 0x180) == 0) {
            if((arg34 & 4) == 0) {
                v10_1 = arg28;
                if(v3.changed(v10_1)) {
                    v11 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v10_1 = arg28;
            label_47:
                v11 = 0x80;
            }

            v4 |= v11;
        }
        else {
            v10_1 = arg28;
        }

        v11 = arg34 & 8;
        if(v11 != 0) {
            v4 |= 0xC00;
            goto label_65;
        }
        else if((v8 & 0xC00) == 0) {
            v12 = arg29;
            v13 = v3.changed(v12) ? 0x800 : 0x400;
            v4 |= v13;
        }
        else {
        label_65:
            v12 = arg29;
        }

        v13 = arg34 & 16;
        if(v13 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v8 & 0x6000) == 0) {
            v14 = arg30;
            v16 = v3.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
        label_80:
            v14 = arg30;
        }

        int v17 = 0x30000;
        if((arg34 & 0x20) != 0) {
            v4 |= v17;
        }
        else if((v8 & v17) == 0) {
            v16 = v3.changed(v1) ? 0x20000 : 0x10000;
            v4 |= v16;
        }

        int v18 = 1;
        boolean v5 = (v4 & 74899) != 74898 ? true : false;
        if(v3.shouldExecute(v5, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "1209@54333L8");
            if((v8 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v9_1 = Modifier.Companion;
                }

                if((arg34 & 4) != 0) {
                    SliderColors v5_1 = v1.colors(v3, v4 >> 15 & 14);
                    v4 &= -897;
                    v10_1 = v5_1;
                }

                if(v11 != 0) {
                    v12 = true;
                }

                if(v13 != 0) {
                    v19 = SliderKt.access$getThumbSize$p();
                    goto label_135;
                }

            label_118:
                v19 = v14;
            }
            else {
                v3.skipToGroupEnd();
                if((arg34 & 4) != 0) {
                    v4 &= -897;
                }
                else {
                }

                goto label_118;
            }

        label_135:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, v4, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1212)");
            }

            String v6 = "CC(remember):Slider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, 0xCE45DAD, v6);
            Object v5_2 = v3.rememberedValue();
            if(v5_2 == Composer.Companion.getEmpty()) {
                SnapshotStateList v5_3 = SnapshotStateKt.mutableStateListOf();
                v3.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerStart(v3, 0xCE46B31, v6);
            v4 &= 14;
            if(v4 == 4) {
            }
            else {
                v18 = 0;
            }

            Object v6_1 = v3.rememberedValue();
            Continuation v7_1 = null;
            if(v18 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = new SliderDefaults$Thumb$1$1(v2, ((SnapshotStateList)v5_2), v7_1);
                v3.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            EffectsKt.LaunchedEffect(v2, ((Function2)v6_2), v3, v4);
            long v4_1 = !((Collection)v5_2).isEmpty() ? DpSize.copy-DwJknco$default(v19, Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(v19) / 2f), 0f, 2, null) : v19;
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(HoverableKt.hoverable$default(SizeKt.size-6HolHcs(((Modifier)v9_1), v4_1), v2, false, 2, v7_1), v10_1.thumbColor-vNxB06k$material3(v12), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), v3, 6)), v3, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_3 = v19;
        }
        else {
            v3.skipToGroupEnd();
            v6_3 = v14;
        }

        SliderColors v4_2 = v10_1;
        v5 = v12;
        ScopeUpdateScope v10_2 = v3.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new SliderDefaults$$ExternalSyntheticLambda4(v1, v2, ((Modifier)v9_1), v4_2, v5, v6_3, v8, arg34));
        }
    }

    public final void Thumb-HwbPF3A$material3(MutableInteractionSource arg25, SliderState arg26, Modifier arg27, SliderColors arg28, boolean arg29, long arg30, Composer arg32, int arg33, int arg34) {
        long v7_4;
        SliderColors v5_3;
        Modifier v4_1;
        SliderDefaults$Thumb$3$1 v7_2;
        SliderColors v8_1;
        Modifier v5_1;
        long v18;
        long v6;
        int v14;
        boolean v13;
        int v12;
        SliderColors v11_1;
        Modifier v10;
        int v8;
        int v4;
        SliderDefaults v1 = this;
        MutableInteractionSource v2 = arg25;
        int v9 = arg33;
        Composer v3 = arg32.startRestartGroup(0xCAF8087B);
        ComposerKt.sourceInformation(v3, "C(Thumb)N(interactionSource,sliderState,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1266@56862L46,1267@56951L658,1267@56917L692,1294@58180L5,1290@57976L220:Slider.kt#uh7d8r");
        if((arg34 & 1) != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v3.changed(v2) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        if((arg34 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v9 & 0x30) == 0) {
            v8 = v3.changedInstance(arg26) ? 0x20 : 16;
            v4 |= v8;
        }

        v8 = arg34 & 4;
        if(v8 != 0) {
            v4 |= 0x180;
            goto label_51;
        }
        else if((v9 & 0x180) == 0) {
            v10 = arg27;
            int v11 = v3.changed(v10) ? 0x100 : 0x80;
            v4 |= v11;
        }
        else {
        label_51:
            v10 = arg27;
        }

        if((v9 & 0xC00) == 0) {
            if((arg34 & 8) == 0) {
                v11_1 = arg28;
                if(v3.changed(v11_1)) {
                    v12 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v11_1 = arg28;
            label_62:
                v12 = 0x400;
            }

            v4 |= v12;
        }
        else {
            v11_1 = arg28;
        }

        v12 = arg34 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg29;
            v14 = v3.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_80:
            v13 = arg29;
        }

        v14 = arg34 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v4 |= v15;
            v6 = arg30;
        }
        else {
            v6 = arg30;
            if((v15 & v9) == 0) {
                v15 = v3.changed(v6) ? 0x20000 : 0x10000;
                v4 |= v15;
            }
        }

        int v16 = 0x180000;
        if((arg34 & 0x40) != 0) {
            v4 |= v16;
        }
        else if((v9 & v16) == 0) {
            v15 = v3.changed(v1) ? 0x100000 : 0x80000;
            v4 |= v15;
        }

        int v17 = 1;
        boolean v5 = (0x92493 & v4) != 0x92492 ? true : false;
        if(v3.shouldExecute(v5, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "1262@56745L8");
            if((v9 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v5_2 = Modifier.Companion;
                }
                else {
                    v5_1 = v10;
                }

                if((arg34 & 8) != 0) {
                    v8_1 = v1.colors(v3, v4 >> 18 & 14);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v8_1 = v11_1;
                }

                if(v12 != 0) {
                    v13 = true;
                }

                if(v14 != 0) {
                    v6 = SliderKt.access$getThumbSize$p();
                }

                v18 = v6;
            }
            else {
                v3.skipToGroupEnd();
                if((arg34 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v18 = v6;
                v5_1 = v10;
                v8_1 = v11_1;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCAF8087B, v4, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1265)");
            }

            String v7 = "CC(remember):Slider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, 0xED180229, v7);
            Object v6_1 = v3.rememberedValue();
            if(v6_1 == Composer.Companion.getEmpty()) {
                SnapshotStateList v6_2 = SnapshotStateKt.mutableStateListOf();
                v3.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerStart(v3, 0xED180FAD, v7);
            v4 &= 14;
            if(v4 == 4) {
            }
            else {
                v17 = 0;
            }

            Object v7_1 = v3.rememberedValue();
            Continuation v10_1 = null;
            if(v17 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                v7_2 = new SliderDefaults$Thumb$3$1(v2, ((SnapshotStateList)v6_1), v10_1);
                v3.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            EffectsKt.LaunchedEffect(v2, ((Function2)v7_2), v3, v4);
            if(!((Collection)v6_1).isEmpty()) {
                float v7_3 = 2f;
                v6 = arg26.getOrientation$material3() == Orientation.Vertical ? DpSize.copy-DwJknco$default(v18, 0f, Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(v18) / v7_3), 1, null) : DpSize.copy-DwJknco$default(v18, Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(v18) / v7_3), 0f, 2, null);
            }
            else {
                v6 = v18;
            }

            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(HoverableKt.hoverable$default(SizeKt.size-6HolHcs(v5_1, v6), v2, false, 2, v10_1), v8_1.thumbColor-vNxB06k$material3(v13), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), v3, 6)), v3, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v5_1;
            v5_3 = v8_1;
            v7_4 = v18;
        }
        else {
            v3.skipToGroupEnd();
            v7_4 = v6;
            v4_1 = v10;
            v5_3 = v11_1;
        }

        boolean v6_3 = v13;
        ScopeUpdateScope v11_2 = v3.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new SliderDefaults$$ExternalSyntheticLambda3(v1, v2, arg26, v4_1, v5_3, v6_3, v7_4, v9, arg34));
        }
    }

    static final Unit Thumb_9LiSoMs$lambda$3(SliderDefaults arg11, MutableInteractionSource arg12, Modifier arg13, SliderColors arg14, boolean arg15, long arg16, int arg18, int arg19, Composer arg20, int arg21) {
        arg11.Thumb-9LiSoMs(arg12, arg13, arg14, arg15, arg16, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit Thumb_HwbPF3A$lambda$6(SliderDefaults arg12, MutableInteractionSource arg13, SliderState arg14, Modifier arg15, SliderColors arg16, boolean arg17, long arg18, int arg20, int arg21, Composer arg22, int arg23) {
        arg12.Thumb-HwbPF3A$material3(arg13, arg14, arg15, arg16, arg17, arg18, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    @Deprecated(message="Use version that supports slider state") public final void Track(SliderPositions arg18, Modifier arg19, SliderColors arg20, boolean arg21, Composer arg22, int arg23, int arg24) {
        boolean v5_4;
        SliderColors v4_2;
        int v4_1;
        boolean v1_2;
        Modifier v3_2;
        Modifier v5_2;
        SliderColors v3_1;
        boolean v7_2;
        SliderColors v7_1;
        int v12;
        boolean v11;
        int v9;
        SliderColors v8_1;
        int v8;
        Modifier v7;
        SliderPositions v10;
        int v3;
        SliderDefaults v1 = this;
        int v6 = arg23;
        int v0 = 0xA3CF0637;
        Composer v2 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(Track)N(sliderPositions,modifier,colors,enabled)1323@59516L1838,1323@59464L1890:Slider.kt#uh7d8r");
        if((arg24 & 1) != 0) {
            v3 = v6 | 6;
            v10 = arg18;
        }
        else {
            v10 = arg18;
            if((v6 & 6) == 0) {
                v3 = v2.changed(v10) ? 4 : 2;
                v3 |= v6;
            }
            else {
                v3 = v6;
            }
        }

        int v5 = arg24 & 2;
        if(v5 != 0) {
            v3 |= 0x30;
            goto label_37;
        }
        else if((v6 & 0x30) == 0) {
            v7 = arg19;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_37:
            v7 = arg19;
        }

        if((v6 & 0x180) == 0) {
            if((arg24 & 4) == 0) {
                v8_1 = arg20;
                if(v2.changed(v8_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v8_1 = arg20;
            label_48:
                v9 = 0x80;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg20;
        }

        v9 = arg24 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_66;
        }
        else if((v6 & 0xC00) == 0) {
            v11 = arg21;
            v12 = v2.changed(v11) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_66:
            v11 = arg21;
        }

        if((arg24 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v6 & 0x6000) == 0) {
            v12 = v2.changed(v1) ? 0x4000 : 0x2000;
            v3 |= v12;
        }

        boolean v12_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v12_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "1316@59111L8");
            if((v6 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v5_3 = Modifier.Companion;
                }
                else {
                    v5_2 = v7;
                }

                if((arg24 & 4) != 0) {
                    v7_1 = v1.colors(v2, v3 >> 12 & 14);
                    v3 &= -897;
                    v8_1 = v7_1;
                }

                v7_1 = v8_1;
                v8 = v3;
                v3_1 = v7_1;
                if(v9 != 0) {
                    v7_2 = true;
                    goto label_124;
                }

            label_106:
                v7_2 = v11;
            }
            else {
                v2.skipToGroupEnd();
                if((arg24 & 4) != 0) {
                    v3 &= -897;
                }

                SliderColors v5_1 = v8_1;
                v8 = v3;
                v3_1 = v5_1;
                v5_2 = v7;
                goto label_106;
            }

        label_124:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v8, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1318)");
            }

            v0 = v8;
            long v8_2 = v3_1.trackColor-WaAFU9c$material3(v7_2, false);
            long v11_1 = v3_1.trackColor-WaAFU9c$material3(v7_2, true);
            long v13 = v3_1.tickColor-WaAFU9c$material3(v7_2, false);
            arg19 = v5_2;
            long v4 = v3_1.tickColor-WaAFU9c$material3(v7_2, true);
            int v20 = v0;
            SliderColors v21 = v3_1;
            v3_2 = arg19;
            Modifier v0_1 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(v3_2, 0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(v2, -333010299, "CC(remember):Slider.kt#9igjgp");
            boolean v19 = v2.changed(v8_2);
            int v15 = (v20 & 14) == 4 ? 1 : 0;
            int v1_1 = (((int)v19)) | v15 | v2.changed(v11_1) | v2.changed(v13) | v2.changed(v4);
            Object v15_1 = v2.rememberedValue();
            if(v1_1 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v1_2 = v7_2;
                long v15_2 = v4;
                v4_1 = 0;
                SliderDefaults$$ExternalSyntheticLambda23 v7_3 = new SliderDefaults$$ExternalSyntheticLambda23(v8_2, v10, v11_1, v13, v15_2);
                v2.updateRememberedValue(v7_3);
                SliderDefaults$$ExternalSyntheticLambda23 v15_3 = v7_3;
            }
            else {
                v1_2 = v7_2;
                v4_1 = 0;
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            CanvasKt.Canvas(v0_1, ((Function1)v15_1), v2, v4_1);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_2 = v21;
            v5_4 = v1_2;
        }
        else {
            v2.skipToGroupEnd();
            v3_2 = v7;
            v4_2 = v8_1;
            v5_4 = v11;
        }

        ScopeUpdateScope v8_3 = v2.endRestartGroup();
        if(v8_3 != null) {
            v8_3.updateScope(new SliderDefaults$$ExternalSyntheticLambda1(this, arg18, v3_2, v4_2, v5_4, v6, arg24));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith="<_subannotation>") public final void Track(SliderState arg15, Modifier arg16, SliderColors arg17, boolean arg18, Composer arg19, int arg20, int arg21) {
        Modifier v3_2;
        boolean v5_2;
        SliderColors v4_3;
        SliderColors v5_1;
        Modifier v4_1;
        boolean v3_1;
        Companion v4_2;
        int v10;
        boolean v8;
        int v7;
        SliderColors v6_1;
        int v6;
        Modifier v5;
        int v3;
        int v12 = arg20;
        int v1 = 0x2360EB1E;
        Composer v9 = arg19.startRestartGroup(v1);
        ComposerKt.sourceInformation(v9, "C(Track)N(sliderState,modifier,colors,enabled)1401@62715L214:Slider.kt#uh7d8r");
        if((arg21 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v9.changedInstance(arg15) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v4 = arg21 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v12 & 0x30) == 0) {
            v5 = arg16;
            v6 = v9.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_35:
            v5 = arg16;
        }

        if((v12 & 0x180) == 0) {
            if((arg21 & 4) == 0) {
                v6_1 = arg17;
                if(v9.changed(v6_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v6_1 = arg17;
            label_46:
                v7 = 0x80;
            }

            v3 |= v7;
        }
        else {
            v6_1 = arg17;
        }

        v7 = arg21 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_64;
        }
        else if((v12 & 0xC00) == 0) {
            v8 = arg18;
            v10 = v9.changed(v8) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_64:
            v8 = arg18;
        }

        if((arg21 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = v9.changed(this) ? 0x4000 : 0x2000;
            v3 |= v10;
        }

        boolean v10_1 = (v3 & 9363) != 9362 ? true : false;
        if(v9.shouldExecute(v10_1, v3 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "1398@62656L8");
            if((v12 & 1) == 0 || (v9.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_1 = v5;
                }

                if((arg21 & 4) != 0) {
                    v5_1 = this.colors(v9, v3 >> 12 & 14);
                    v3 &= -897;
                }
                else {
                    v5_1 = v6_1;
                }

                v6 = v3;
                if(v7 != 0) {
                    v3_1 = true;
                    goto label_119;
                }

            label_102:
                v3_1 = v8;
            }
            else {
                v9.skipToGroupEnd();
                if((arg21 & 4) != 0) {
                    v3 &= -897;
                }

                v4_1 = v5;
                v5_1 = v6_1;
                v6 = v3;
                goto label_102;
            }

        label_119:
            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1400)");
            }

            Modifier v2 = ((Modifier)v4_2);
            v4_3 = v5_1;
            this.Track-4EFweAY(arg15, v2, v3_1, v4_3, null, null, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), v9, v6 & 14 | 0xD80000 | v6 & 0x70 | v6 >> 3 & 0x380 | v6 << 3 & 0x1C00 | v6 << 12 & 0xE000000, 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v3_1;
            v3_2 = v2;
        }
        else {
            v9.skipToGroupEnd();
            v3_2 = v5;
            v4_3 = v6_1;
            v5_2 = v8;
        }

        ScopeUpdateScope v8_1 = v9.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new SliderDefaults$$ExternalSyntheticLambda0(this, arg15, v3_2, v4_3, v5_2, v12, arg21));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith="<_subannotation>") public final void Track(RangeSliderState arg15, Modifier arg16, SliderColors arg17, boolean arg18, Composer arg19, int arg20, int arg21) {
        Modifier v3_2;
        boolean v5_2;
        SliderColors v4_3;
        SliderColors v5_1;
        Modifier v4_1;
        boolean v3_1;
        Companion v4_2;
        int v10;
        boolean v8;
        int v7;
        SliderColors v6_1;
        int v6;
        Modifier v5;
        int v3;
        int v12 = arg20;
        int v1 = 0x9F9146D7;
        Composer v9 = arg19.startRestartGroup(v1);
        ComposerKt.sourceInformation(v9, "C(Track)N(rangeSliderState,modifier,colors,enabled)1689@75190L219:Slider.kt#uh7d8r");
        if((arg21 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v9.changedInstance(arg15) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v4 = arg21 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v12 & 0x30) == 0) {
            v5 = arg16;
            v6 = v9.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_35:
            v5 = arg16;
        }

        if((v12 & 0x180) == 0) {
            if((arg21 & 4) == 0) {
                v6_1 = arg17;
                if(v9.changed(v6_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v6_1 = arg17;
            label_46:
                v7 = 0x80;
            }

            v3 |= v7;
        }
        else {
            v6_1 = arg17;
        }

        v7 = arg21 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_64;
        }
        else if((v12 & 0xC00) == 0) {
            v8 = arg18;
            v10 = v9.changed(v8) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_64:
            v8 = arg18;
        }

        if((arg21 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = v9.changed(this) ? 0x4000 : 0x2000;
            v3 |= v10;
        }

        boolean v10_1 = (v3 & 9363) != 9362 ? true : false;
        if(v9.shouldExecute(v10_1, v3 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "1686@75131L8");
            if((v12 & 1) == 0 || (v9.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_1 = v5;
                }

                if((arg21 & 4) != 0) {
                    v5_1 = this.colors(v9, v3 >> 12 & 14);
                    v3 &= -897;
                }
                else {
                    v5_1 = v6_1;
                }

                v6 = v3;
                if(v7 != 0) {
                    v3_1 = true;
                    goto label_119;
                }

            label_102:
                v3_1 = v8;
            }
            else {
                v9.skipToGroupEnd();
                if((arg21 & 4) != 0) {
                    v3 &= -897;
                }

                v4_1 = v5;
                v5_1 = v6_1;
                v6 = v3;
                goto label_102;
            }

        label_119:
            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1688)");
            }

            Modifier v2 = ((Modifier)v4_2);
            v4_3 = v5_1;
            this.Track-4EFweAY(arg15, v2, v3_1, v4_3, null, null, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), v9, v6 & 14 | 0xD80000 | v6 & 0x70 | v6 >> 3 & 0x380 | v6 << 3 & 0x1C00 | v6 << 12 & 0xE000000, 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v3_1;
            v3_2 = v2;
        }
        else {
            v9.skipToGroupEnd();
            v3_2 = v5;
            v4_3 = v6_1;
            v5_2 = v8;
        }

        ScopeUpdateScope v8_1 = v9.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new SliderDefaults$$ExternalSyntheticLambda11(this, arg15, v3_2, v4_3, v5_2, v12, arg21));
        }
    }

    static final Unit Track$lambda$11$lambda$10(long arg27, SliderPositions arg29, long arg30, long arg32, long arg34, DrawScope arg36) {
        DrawScope v0 = arg36;
        int v1 = v0.getLayoutDirection() == LayoutDirection.Rtl ? 1 : 0;
        long v17 = 0xFFFFFFFFL;
        int v19 = 0x20;
        long v2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v19 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.getCenter-F1C5BW0() & v17)))))) & v17);
        long v7 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.getCenter-F1C5BW0() & v17)))))) & v17 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v19)))))) << v19);
        long v5 = v2;
        long v3 = v1 != 0 ? v7 : v5;
        if(v1 != 0) {
        }
        else {
            v5 = v7;
        }

        float v20 = v0.toPx-0680j_4(SliderDefaults.TickSize);
        float v7_1 = v0.toPx-0680j_4(SliderKt.getTrackHeight());
        DrawScope.drawLine-NGM6Ib0$default(v0, arg27, v3, v5, v7_1, StrokeCap.Companion.getRound-KaPHkGw(), null, 0f, null, 0, 480, null);
        int v0_1 = ((int)(v3 >> v19));
        int v2_1 = ((int)(v5 >> v19));
        long v23 = v3;
        long v25 = v5;
        DrawScope.drawLine-NGM6Ib0$default(arg36, arg30, Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(v0_1) + (Float.intBitsToFloat(v2_1) - Float.intBitsToFloat(v0_1)) * arg29.getActiveRange().getStart().floatValue()))) << v19 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg36.getCenter-F1C5BW0() & v17)))))) & v17), Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(v0_1) + (Float.intBitsToFloat(v2_1) - Float.intBitsToFloat(v0_1)) * arg29.getActiveRange().getEndInclusive().floatValue()))) << v19 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg36.getCenter-F1C5BW0() & v17)))))) & v17), v7_1, StrokeCap.Companion.getRound-KaPHkGw(), null, 0f, null, 0, 480, null);
        float[] v0_2 = arg29.getTickFractions();
        LinkedHashMap v1_1 = new LinkedHashMap();
        v2_1 = v0_2.length;
        int v3_1;
        for(v3_1 = 0; v3_1 < v2_1; ++v3_1) {
            float v4 = v0_2[v3_1];
            boolean v5_1 = v4 > arg29.getActiveRange().getEndInclusive().floatValue() || v4 < arg29.getActiveRange().getStart().floatValue() ? true : false;
            Boolean v5_2 = Boolean.valueOf(v5_1);
            Object v6 = ((Map)v1_1).get(v5_2);
            if(v6 == null) {
                ArrayList v6_1 = new ArrayList();
                ((Map)v1_1).put(v5_2, v6_1);
            }

            ((List)v6).add(Float.valueOf(v4));
        }

        Iterator v13 = ((Map)v1_1).entrySet().iterator();
        while(v13.hasNext()) {
            Object v0_3 = v13.next();
            boolean v1_2 = ((Map$Entry)v0_3).getKey().booleanValue();
            v0_3 = ((Map$Entry)v0_3).getValue();
            ArrayList v2_2 = new ArrayList(((List)v0_3).size());
            v3_1 = v0_3.size();
            int v4_1 = 0;
            while(v4_1 < v3_1) {
                v2_2.add(Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg36.getCenter-F1C5BW0() & v17)))))) & v17 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(OffsetKt.lerp-Wko1d7g(v23, v25, ((List)v0_3).get(v4_1).floatValue()) >> v19)))))) << v19)));
                ++v4_1;
                v1_2 = v1_2;
                v0_3 = v0_3;
            }

            boolean v27 = v1_2;
            long v14 = v23;
            v7 = v25;
            ArrayList v1_3 = v2_2;
            v2_1 = PointMode.Companion.getPoints-r_lszbg();
            v3 = v27 ? arg32 : arg34;
            v25 = v7;
            DrawScope.drawPoints-F8ZwMP8$default(arg36, ((List)v1_3), v2_1, v3, v20, StrokeCap.Companion.getRound-KaPHkGw(), null, 0f, null, 0, 480, null);
            v23 = v14;
        }

        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$12(SliderDefaults arg8, SliderPositions arg9, Modifier arg10, SliderColors arg11, boolean arg12, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.Track(arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$13(SliderDefaults arg8, SliderState arg9, Modifier arg10, SliderColors arg11, boolean arg12, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.Track(arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit Track$lambda$33(SliderDefaults arg8, RangeSliderState arg9, Modifier arg10, SliderColors arg11, boolean arg12, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.Track(arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public final void Track-4EFweAY(SliderState arg22, Modifier arg23, boolean arg24, SliderColors arg25, Function2 arg26, Function3 arg27, float arg28, float arg29, Composer arg30, int arg31, int arg32) {
        Function2 v6_2;
        Modifier v3;
        Function3 v7_1;
        float v9_1;
        SliderColors v5_3;
        boolean v4_1;
        Object v7_2;
        SliderDefaults$Track$5$1 v1_4;
        Object v13_2;
        SliderDefaults$$ExternalSyntheticLambda16 v5_2;
        int v2_2;
        float v8;
        int v17;
        int v14;
        Function2 v13_1;
        int v13;
        SliderColors v10_1;
        boolean v9;
        int v7;
        Modifier v6;
        int v4;
        SliderDefaults v0 = this;
        int v15 = arg31;
        int v1 = arg32;
        Composer v12 = arg30.startRestartGroup(0x2FAB503);
        ComposerKt.sourceInformation(v12, "C(Track)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1447@64678L467:Slider.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v4 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v4 = v12.changedInstance(arg22) ? 4 : 2;
            v4 |= v15;
        }
        else {
            v4 = v15;
        }

        int v5 = v1 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_40;
        }
        else if((v15 & 0x30) == 0) {
            v6 = arg23;
            v7 = v12.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_40:
            v6 = arg23;
        }

        v7 = v1 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_55;
        }
        else if((v15 & 0x180) == 0) {
            v9 = arg24;
            int v10 = v12.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_55:
            v9 = arg24;
        }

        if((v15 & 0xC00) == 0) {
            if((v1 & 8) == 0) {
                v10_1 = arg25;
                if(v12.changed(v10_1)) {
                    v13 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v10_1 = arg25;
            label_66:
                v13 = 0x400;
            }

            v4 |= v13;
        }
        else {
            v10_1 = arg25;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 16) == 0) {
                v13_1 = arg26;
                if(v12.changedInstance(v13_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v13_1 = arg26;
            label_80:
                v14 = 0x2000;
            }

            v4 |= v14;
        }
        else {
            v13_1 = arg26;
        }

        v14 = v1 & 0x20;
        int v16 = 0x30000;
        if(v14 != 0) {
            v4 |= v16;
        }
        else {
            Function3 v2 = arg27;
            if((v15 & v16) == 0) {
                v17 = v12.changedInstance(v2) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = v1 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v4 |= v18;
            v8 = arg28;
        }
        else {
            v8 = arg28;
            if((v15 & v18) == 0) {
                v18 = v12.changed(v8) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        int v11 = v1 & 0x80;
        int v19 = 0xC00000;
        if(v11 != 0) {
            v4 |= v19;
        }
        else {
            float v2_1 = arg29;
            if((v15 & v19) == 0) {
                v19 = v12.changed(v2_1) ? 0x800000 : 0x400000;
                v4 |= v19;
            }
        }

        v19 = 0x6000000;
        if((v1 & 0x100) != 0) {
            v4 |= v19;
        }
        else if((v15 & v19) == 0) {
            v2_2 = v12.changed(v0) ? 0x4000000 : 0x2000000;
            v4 |= v2_2;
        }

        v19 = 0;
        boolean v1_1 = (0x2492493 & v4) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v1_1, v4 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "1433@64119L8,1434@64188L199,1441@64443L107");
            v2_2 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v9 = true;
                }

                if((arg32 & 8) != 0) {
                    SliderColors v1_2 = v0.colors(v12, v4 >> 24 & 14);
                    v4 &= 0xFFFFE3FF;
                    v10_1 = v1_2;
                }

                if((arg32 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 790733290, "CC(remember):Slider.kt#9igjgp");
                    v5 = 0x800;
                    v1 = (v4 & 0x1C00 ^ 0xC00) > v5 && (v12.changed(v10_1)) || (v4 & 0xC00) == v5 ? 1 : 0;
                    if((v4 & 0x380) == 0x100) {
                        v19 = 1;
                    }

                    Object v5_1 = v12.rememberedValue();
                    if((v1 | v19) != 0 || v5_1 == Composer.Companion.getEmpty()) {
                        v5_2 = new SliderDefaults$$ExternalSyntheticLambda16(v10_1, v9);
                        v12.updateRememberedValue(v5_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                    v13_2 = v5_2;
                    v4 &= v2_2;
                }

                if(v14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 0x2F21C16E, "CC(remember):Slider.kt#9igjgp");
                    Object v1_3 = v12.rememberedValue();
                    if(v1_3 == Composer.Companion.getEmpty()) {
                        v1_4 = SliderDefaults$Track$5$1.INSTANCE;
                        v12.updateRememberedValue(v1_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                }
                else {
                    Function3 v1_5 = arg27;
                }

                if(v17 != 0) {
                    v8 = SliderKt.access$getThumbTrackGapSize$p();
                }

                if(v11 != 0) {
                    v7_2 = v1_4;
                    v1 = v4;
                    v4_1 = v9;
                    v5_3 = v10_1;
                    v9_1 = SliderKt.access$getTrackInsideCornerSize$p();
                    goto label_248;
                }

                v7_2 = v1_4;
            label_171:
                v1 = v4;
                v4_1 = v9;
                v5_3 = v10_1;
                v9_1 = arg29;
            }
            else {
                v12.skipToGroupEnd();
                if((arg32 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg32 & 16) != 0) {
                    v4 &= v2_2;
                }

                v7_1 = arg27;
                goto label_171;
            }

        label_248:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2FAB503, v1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1446)");
            }

            v11 = v1 << 3;
            v3 = v6;
            v6_2 = ((Function2)v13_2);
            v0.TrackImpl-VvwgllI(arg22, Dp.Companion.getUnspecified-D9Ej5fM(), v3, v4_1, v5_3, v6_2, v7_1, v8, v9_1, false, false, v12, v1 & 14 | 0x30000030 | v11 & 0x380 | v11 & 0x1C00 | 0xE000 & v11 | 0x70000 & v11 | 0x380000 & v11 | 0x1C00000 & v11 | v11 & 0xE000000, v1 >> 21 & 0x70 | 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_301;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
            v7_1 = arg27;
            v3 = v6;
            v4_1 = v9;
            v5_3 = v10_1;
            v6_2 = v13_1;
            v9_1 = arg29;
        }

    label_301:
        ScopeUpdateScope v12_1 = v12.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new SliderDefaults$$ExternalSyntheticLambda17(this, arg22, v3, v4_1, v5_3, v6_2, v7_1, v8, v9_1, v15, arg32));
        }
    }

    public final void Track-4EFweAY(RangeSliderState arg22, Modifier arg23, boolean arg24, SliderColors arg25, Function2 arg26, Function3 arg27, float arg28, float arg29, Composer arg30, int arg31, int arg32) {
        Function3 v7_1;
        float v8_1;
        float v9_2;
        Function2 v6_1;
        SliderColors v5_1;
        boolean v4_1;
        Modifier v3_1;
        Object v7_2;
        SliderDefaults$Track$12$1 v1_6;
        int v1_2;
        float v7;
        int v17;
        Function3 v1;
        int v15;
        Function2 v14_1;
        int v14;
        SliderColors v9_1;
        boolean v8;
        int v6;
        Modifier v5;
        int v3;
        SliderDefaults v0 = this;
        int v12 = arg31;
        int v13 = arg32;
        Composer v10 = arg30.startRestartGroup(0xDFB46B7C);
        ComposerKt.sourceInformation(v10, "C(Track)N(rangeSliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1735@77205L402:Slider.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v10.changedInstance(arg22) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v4 = v13 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_40;
        }
        else if((v12 & 0x30) == 0) {
            v5 = arg23;
            v6 = v10.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_40:
            v5 = arg23;
        }

        v6 = v13 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_55;
        }
        else if((v12 & 0x180) == 0) {
            v8 = arg24;
            int v9 = v10.changed(v8) ? 0x100 : 0x80;
            v3 |= v9;
        }
        else {
        label_55:
            v8 = arg24;
        }

        if((v12 & 0xC00) == 0) {
            if((v13 & 8) == 0) {
                v9_1 = arg25;
                if(v10.changed(v9_1)) {
                    v14 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v9_1 = arg25;
            label_66:
                v14 = 0x400;
            }

            v3 |= v14;
        }
        else {
            v9_1 = arg25;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v14_1 = arg26;
                if(v10.changedInstance(v14_1)) {
                    v15 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v14_1 = arg26;
            label_80:
                v15 = 0x2000;
            }

            v3 |= v15;
        }
        else {
            v14_1 = arg26;
        }

        v15 = v13 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            v1 = arg27;
            if((v12 & v16) == 0) {
                v17 = v10.changedInstance(v1) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        v17 = v13 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v3 |= v18;
            v7 = arg28;
        }
        else {
            v7 = arg28;
            if((v12 & v18) == 0) {
                v18 = v10.changed(v7) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        int v11 = v13 & 0x80;
        int v19 = 0xC00000;
        if(v11 != 0) {
            v3 |= v19;
        }
        else {
            float v1_1 = arg29;
            if((v12 & v19) == 0) {
                v19 = v10.changed(v1_1) ? 0x800000 : 0x400000;
                v3 |= v19;
            }
        }

        v19 = 0x6000000;
        if((v13 & 0x100) != 0) {
            v3 |= v19;
        }
        else if((v12 & v19) == 0) {
            v1_2 = v10.changed(v0) ? 0x4000000 : 0x2000000;
            v3 |= v1_2;
        }

        v19 = 0;
        boolean v1_3 = (0x2492493 & v3) != 0x2492492 ? true : false;
        if(v10.shouldExecute(v1_3, v3 & 1)) {
            v10.startDefaults();
            ComposerKt.sourceInformation(v10, "1721@76646L8,1722@76715L199,1729@76970L107");
            int v2 = 0xFFFF1FFF;
            if((v12 & 1) == 0 || (v10.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v5_2 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v8 = true;
                }

                if((v13 & 8) != 0) {
                    SliderColors v1_4 = v0.colors(v10, v3 >> 24 & 14);
                    v3 &= 0xFFFFE3FF;
                    v9_1 = v1_4;
                }

                if((v13 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v10, -1001938653, "CC(remember):Slider.kt#9igjgp");
                    v4 = 0x800;
                    v1_2 = (v3 & 0x1C00 ^ 0xC00) > v4 && (v10.changed(v9_1)) || (v3 & 0xC00) == v4 ? 1 : 0;
                    if((v3 & 0x380) == 0x100) {
                        v19 = 1;
                    }

                    Object v4_2 = v10.rememberedValue();
                    if((v1_2 | v19) != 0 || v4_2 == Composer.Companion.getEmpty()) {
                        SliderDefaults$$ExternalSyntheticLambda7 v4_3 = new SliderDefaults$$ExternalSyntheticLambda7(v9_1, v8);
                        v10.updateRememberedValue(v4_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v10);
                    Object v14_2 = v4_2;
                    v3 &= v2;
                }

                if(v15 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v10, -1001930585, "CC(remember):Slider.kt#9igjgp");
                    Object v1_5 = v10.rememberedValue();
                    if(v1_5 == Composer.Companion.getEmpty()) {
                        v1_6 = SliderDefaults$Track$12$1.INSTANCE;
                        v10.updateRememberedValue(v1_6);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v10);
                }
                else {
                    v1 = arg27;
                }

                if(v17 != 0) {
                    v7 = SliderKt.access$getThumbTrackGapSize$p();
                }

                if(v11 != 0) {
                    v4_1 = v8;
                    v6_1 = v14_1;
                    v8_1 = v7;
                    v7_2 = v1_6;
                    v1_2 = v3;
                    v3_1 = v5;
                    v5_1 = v9_1;
                    v9_2 = SliderKt.access$getTrackInsideCornerSize$p();
                    goto label_260;
                }

                v4_1 = v8;
                v6_1 = v14_1;
                v8_1 = v7;
                v7_2 = v1_6;
                v1_2 = v3;
                v3_1 = v5;
                v5_1 = v9_1;
                v9_2 = arg29;
            }
            else {
                v10.skipToGroupEnd();
                if((v13 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v3 &= v2;
                }

                v1_2 = v3;
                v3_1 = v5;
                v4_1 = v8;
                v5_1 = v9_1;
                v6_1 = v14_1;
                v9_2 = arg29;
                v8_1 = v7;
                v7_1 = arg27;
            }

        label_260:
            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xDFB46B7C, v1_2, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1734)");
            }

            v11 = v1_2 & 14 | 0x30;
            v1_2 <<= 3;
            v0.TrackImpl-xlyIBlM(arg22, Dp.Companion.getUnspecified-D9Ej5fM(), v3_1, v4_1, v5_1, v6_1, v7_1, v8_1, v9_2, v10, v11 | v1_2 & 0x380 | v1_2 & 0x1C00 | 0xE000 & v1_2 | 0x70000 & v1_2 | 0x380000 & v1_2 | 0x1C00000 & v1_2 | 0xE000000 & v1_2 | v1_2 & 0x70000000);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_308;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10.skipToGroupEnd();
            v3_1 = v5;
            v4_1 = v8;
            v5_1 = v9_1;
            v6_1 = v14_1;
            v9_2 = arg29;
            v8_1 = v7;
            v7_1 = arg27;
        }

    label_308:
        ScopeUpdateScope v14_3 = v10.endRestartGroup();
        if(v14_3 != null) {
            v14_3.updateScope(new SliderDefaults$$ExternalSyntheticLambda8(this, arg22, v3_1, v4_1, v5_1, v6_1, v7_1, v8_1, v9_2, v12, v13));
        }
    }

    public final void Track-mnvyFg4$material3(SliderState arg24, float arg25, Modifier arg26, boolean arg27, SliderColors arg28, Function2 arg29, Function3 arg30, float arg31, float arg32, Composer arg33, int arg34, int arg35) {
        Modifier v4_2;
        boolean v5_1;
        SliderColors v6_2;
        Function2 v7_3;
        Function3 v8_2;
        float v10_1;
        Function3 v1_2;
        float v9_1;
        SliderDefaults$$ExternalSyntheticLambda5 v2_3;
        Companion v7_1;
        int v20;
        int v19;
        float v13;
        int v18;
        int v16;
        Function2 v14_1;
        int v14;
        SliderColors v11_1;
        boolean v10;
        int v8;
        Modifier v7;
        int v6;
        SliderState v3;
        int v4;
        SliderDefaults v0 = this;
        int v15 = arg34;
        int v1 = arg35;
        Composer v12 = arg33.startRestartGroup(0x64CE0B31);
        ComposerKt.sourceInformation(v12, "C(Track)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1503@67150L467:Slider.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v4 = v15 | 6;
            v3 = arg24;
        }
        else if((v15 & 6) == 0) {
            v3 = arg24;
            v4 = v12.changedInstance(v3) ? 4 : 2;
            v4 |= v15;
        }
        else {
            v3 = arg24;
            v4 = v15;
        }

        if((v1 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v15 & 0x30) == 0) {
            v6 = v12.changed(arg25) ? 0x20 : 16;
            v4 |= v6;
        }

        v6 = v1 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_55;
        }
        else if((v15 & 0x180) == 0) {
            v7 = arg26;
            v8 = v12.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_55:
            v7 = arg26;
        }

        v8 = v1 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_70;
        }
        else if((v15 & 0xC00) == 0) {
            v10 = arg27;
            int v11 = v12.changed(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_70:
            v10 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 16) == 0) {
                v11_1 = arg28;
                if(v12.changed(v11_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v11_1 = arg28;
            label_81:
                v14 = 0x2000;
            }

            v4 |= v14;
        }
        else {
            v11_1 = arg28;
        }

        if((0x30000 & v15) == 0) {
            if((v1 & 0x20) == 0) {
                v14_1 = arg29;
                if(v12.changedInstance(v14_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_96;
                }
            }
            else {
                v14_1 = arg29;
            label_96:
                v16 = 0x10000;
            }

            v4 |= v16;
        }
        else {
            v14_1 = arg29;
        }

        v16 = v1 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v4 |= v17;
        }
        else {
            Function3 v2 = arg30;
            if((v15 & v17) == 0) {
                v18 = v12.changedInstance(v2) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        int v9 = v1 & 0x80;
        v18 = 0xC00000;
        if(v9 != 0) {
            v4 |= v18;
            v13 = arg31;
        }
        else {
            v13 = arg31;
            if((v15 & v18) == 0) {
                v19 = v12.changed(v13) ? 0x800000 : 0x400000;
                v4 |= v19;
            }
        }

        int v2_1 = v1 & 0x100;
        v19 = 0x6000000;
        if(v2_1 != 0) {
            v4 |= v19;
            goto label_146;
        }
        else if((v15 & v19) == 0) {
            v19 = v2_1;
            v20 = v12.changed(arg32) ? 0x4000000 : 0x2000000;
            v4 |= v20;
        }
        else {
        label_146:
            v19 = v2_1;
        }

        v20 = 0x30000000;
        if((v1 & 0x200) != 0) {
            v4 |= v20;
        }
        else if((v15 & v20) == 0) {
            v2_1 = v12.changed(v0) ? 0x20000000 : 0x10000000;
            v4 |= v2_1;
        }

        int v21 = 0;
        boolean v1_1 = (306783379 & v4) != 306783378 ? true : false;
        if(v12.shouldExecute(v1_1, v4 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "1489@66591L8,1490@66660L199,1497@66915L107");
            v2_1 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v7_1 = Modifier.Companion;
                }

                if(v8 != 0) {
                    v10 = true;
                }

                if((arg35 & 16) != 0) {
                    SliderColors v1_3 = v0.colors(v12, v4 >> 27 & 14);
                    v4 &= v2_1;
                    v11_1 = v1_3;
                }

                if((arg35 & 0x20) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 1769483032, "CC(remember):Slider.kt#9igjgp");
                    v2_1 = 0x4000;
                    v1 = (0xE000 & v4 ^ 0x6000) > v2_1 && (v12.changed(v11_1)) || (v4 & 0x6000) == v2_1 ? 1 : 0;
                    if((v4 & 0x1C00) == 0x800) {
                        v21 = 1;
                    }

                    Object v2_2 = v12.rememberedValue();
                    if((v1 | v21) != 0 || v2_2 == Composer.Companion.getEmpty()) {
                        v2_3 = new SliderDefaults$$ExternalSyntheticLambda5(v11_1, v10);
                        v12.updateRememberedValue(v2_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                    Object v14_2 = v2_3;
                    v4 &= 0xFFF8FFFF;
                }

                if(v16 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v12, 1769491100, "CC(remember):Slider.kt#9igjgp");
                    Object v1_4 = v12.rememberedValue();
                    if(v1_4 == Composer.Companion.getEmpty()) {
                        SliderDefaults$Track$8$1 v1_5 = SliderDefaults$Track$8$1.INSTANCE;
                        v12.updateRememberedValue(v1_5);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                }
                else {
                    v1_2 = arg30;
                }

                if(v9 != 0) {
                    v13 = SliderKt.access$getThumbTrackGapSize$p();
                }

                if(v19 != 0) {
                    v9_1 = SliderKt.access$getTrackInsideCornerSize$p();
                    goto label_192;
                }

            label_191:
                v9_1 = arg32;
            }
            else {
                v12.skipToGroupEnd();
                if((arg35 & 16) != 0) {
                    v4 &= v2_1;
                }

                if((arg35 & 0x20) != 0) {
                    v4 &= 0xFFF8FFFF;
                }

                v1_2 = arg30;
                goto label_191;
            }

        label_192:
            v2_1 = v4;
            boolean v4_1 = v10;
            SliderColors v5 = v11_1;
            float v8_1 = v13;
            Function2 v6_1 = v14_1;
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x64CE0B31, v2_1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1502)");
            }

            int v13_1 = v2_1 & 14 | v20 | v2_1 & 0x70 | v2_1 & 0x380 | v2_1 & 0x1C00 | 0xE000 & v2_1 | 0x70000 & v2_1 | 0x380000 & v2_1 | 0x1C00000 & v2_1 | 0xE000000 & v2_1;
            v14 = v2_1 >> 24 & 0x70 | 6;
            Modifier v2_4 = ((Modifier)v7_1);
            Function3 v7_2 = v1_2;
            SliderState v1_6 = v3;
            Modifier v3_1 = v2_4;
            v0.TrackImpl-VvwgllI(v1_6, arg25, v3_1, v4_1, v5, v6_1, v7_2, v8_1, v9_1, true, false, v12, v13_1, v14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v9_1;
            v9_1 = v8_1;
            v8_2 = v7_2;
            v7_3 = v6_1;
            v6_2 = v5;
            v5_1 = v4_1;
            v4_2 = v3_1;
        }
        else {
            v12.skipToGroupEnd();
            v8_2 = arg30;
            v4_2 = v7;
            v5_1 = v10;
            v6_2 = v11_1;
            v9_1 = v13;
            v7_3 = v14_1;
            v10_1 = arg32;
        }

        ScopeUpdateScope v13_2 = v12.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new SliderDefaults$$ExternalSyntheticLambda6(this, arg24, arg25, v4_2, v5_1, v6_2, v7_3, v8_2, v9_1, v10_1, v15, arg35));
        }
    }

    public final void Track-mnvyFg4$material3(RangeSliderState arg24, float arg25, Modifier arg26, boolean arg27, SliderColors arg28, Function2 arg29, Function3 arg30, float arg31, float arg32, Composer arg33, int arg34, int arg35) {
        Modifier v4_1;
        boolean v5_4;
        SliderColors v6_3;
        Function2 v7_3;
        Function3 v8_2;
        float v10_1;
        Composer v0_1;
        float v9_1;
        Function2 v6_2;
        float v8_1;
        SliderColors v5_3;
        boolean v4;
        Modifier v3_1;
        Object v7_2;
        SliderDefaults$Track$15$1 v1_5;
        int v20;
        int v19;
        float v14;
        int v18;
        Function3 v1;
        int v16;
        Function2 v15_1;
        int v15;
        SliderColors v11_1;
        boolean v9;
        int v7;
        Modifier v6;
        int v5;
        int v3;
        SliderDefaults v0 = this;
        int v12 = arg34;
        int v13 = arg35;
        Composer v10 = arg33.startRestartGroup(0x74679618);
        ComposerKt.sourceInformation(v10, "C(Track)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1786@79501L403:Slider.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v10.changedInstance(arg24) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        if((v13 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v5 = v10.changed(arg25) ? 0x20 : 16;
            v3 |= v5;
        }

        v5 = v13 & 4;
        if(v5 != 0) {
            v3 |= 0x180;
            goto label_55;
        }
        else if((v12 & 0x180) == 0) {
            v6 = arg26;
            v7 = v10.changed(v6) ? 0x100 : 0x80;
            v3 |= v7;
        }
        else {
        label_55:
            v6 = arg26;
        }

        v7 = v13 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_70;
        }
        else if((v12 & 0xC00) == 0) {
            v9 = arg27;
            int v11 = v10.changed(v9) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_70:
            v9 = arg27;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v11_1 = arg28;
                if(v10.changed(v11_1)) {
                    v15 = 0x4000;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v11_1 = arg28;
            label_81:
                v15 = 0x2000;
            }

            v3 |= v15;
        }
        else {
            v11_1 = arg28;
        }

        if((0x30000 & v12) == 0) {
            if((v13 & 0x20) == 0) {
                v15_1 = arg29;
                if(v10.changedInstance(v15_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_96;
                }
            }
            else {
                v15_1 = arg29;
            label_96:
                v16 = 0x10000;
            }

            v3 |= v16;
        }
        else {
            v15_1 = arg29;
        }

        v16 = v13 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            v1 = arg30;
            if((v12 & v17) == 0) {
                v18 = v10.changedInstance(v1) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        int v8 = v13 & 0x80;
        v18 = 0xC00000;
        if(v8 != 0) {
            v3 |= v18;
            v14 = arg31;
        }
        else {
            v14 = arg31;
            if((v12 & v18) == 0) {
                v19 = v10.changed(v14) ? 0x800000 : 0x400000;
                v3 |= v19;
            }
        }

        int v1_1 = v13 & 0x100;
        v19 = 0x6000000;
        if(v1_1 != 0) {
            v3 |= v19;
            goto label_146;
        }
        else if((v12 & v19) == 0) {
            v19 = v1_1;
            v20 = v10.changed(arg32) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_146:
            v19 = v1_1;
        }

        v20 = 0x30000000;
        if((v13 & 0x200) != 0) {
            v3 |= v20;
        }
        else if((v12 & v20) == 0) {
            v1_1 = v10.changed(v0) ? 0x20000000 : 0x10000000;
            v3 |= v1_1;
        }

        v20 = 0;
        boolean v1_2 = (306783379 & v3) != 306783378 ? true : false;
        if(v10.shouldExecute(v1_2, v3 & 1)) {
            v10.startDefaults();
            ComposerKt.sourceInformation(v10, "1772@78942L8,1773@79011L199,1780@79266L107");
            int v2 = 0xFFF8FFFF;
            int v22 = 0xFFFF1FFF;
            if((v12 & 1) == 0 || (v10.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v9 = true;
                }

                if((v13 & 16) != 0) {
                    SliderColors v1_3 = v0.colors(v10, v3 >> 27 & 14);
                    v3 &= v22;
                    v11_1 = v1_3;
                }

                if((v13 & 0x20) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v10, 0xF8DA997F, "CC(remember):Slider.kt#9igjgp");
                    v5 = 0x4000;
                    v1_1 = (0xE000 & v3 ^ 0x6000) > v5 && (v10.changed(v11_1)) || (v3 & 0x6000) == v5 ? 1 : 0;
                    if((v3 & 0x1C00) == 0x800) {
                        v20 = 1;
                    }

                    Object v5_1 = v10.rememberedValue();
                    if((v1_1 | v20) != 0 || v5_1 == Composer.Companion.getEmpty()) {
                        SliderDefaults$$ExternalSyntheticLambda18 v5_2 = new SliderDefaults$$ExternalSyntheticLambda18(v11_1, v9);
                        v10.updateRememberedValue(v5_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v10);
                    Object v15_2 = v5_1;
                    v3 &= v2;
                }

                if(v16 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v10, 0xF8DAB903, "CC(remember):Slider.kt#9igjgp");
                    Object v1_4 = v10.rememberedValue();
                    if(v1_4 == Composer.Companion.getEmpty()) {
                        v1_5 = SliderDefaults$Track$15$1.INSTANCE;
                        v10.updateRememberedValue(v1_5);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v10);
                }
                else {
                    v1 = arg30;
                }

                if(v8 != 0) {
                    v14 = SliderKt.access$getThumbTrackGapSize$p();
                }

                if(v19 != 0) {
                    v7_2 = v1_5;
                    v1_1 = v3;
                    v3_1 = v6;
                    v4 = v9;
                    v5_3 = v11_1;
                    v8_1 = v14;
                    v6_2 = v15_1;
                    v9_1 = SliderKt.access$getTrackInsideCornerSize$p();
                    goto label_275;
                }

                v7_2 = v1_5;
            label_191:
                v1_1 = v3;
                v3_1 = v6;
                v4 = v9;
                v5_3 = v11_1;
                v8_1 = v14;
                v6_2 = v15_1;
                v9_1 = arg32;
            }
            else {
                v10.skipToGroupEnd();
                if((v13 & 16) != 0) {
                    v3 &= v22;
                }

                if((v13 & 0x20) != 0) {
                    v3 &= v2;
                }

                Function3 v7_1 = arg30;
                goto label_191;
            }

        label_275:
            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x74679618, v1_1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1785)");
            }

            v0.TrackImpl-xlyIBlM(arg24, arg25, v3_1, v4, v5_3, v6_2, ((Function3)v7_2), v8_1, v9_1, v10, v1_1 & 0x7FFFFFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_1 = v10;
            v10_1 = v9_1;
            v9_1 = v8_1;
            v8_2 = ((Function3)v7_2);
            v7_3 = v6_2;
            v6_3 = v5_3;
            v5_4 = v4;
            v4_1 = v3_1;
        }
        else {
            v10.skipToGroupEnd();
            v8_2 = arg30;
            v4_1 = v6;
            v5_4 = v9;
            v0_1 = v10;
            v6_3 = v11_1;
            v9_1 = v14;
            v7_3 = v15_1;
            v10_1 = arg32;
        }

        ScopeUpdateScope v14_1 = v0_1.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new SliderDefaults$$ExternalSyntheticLambda19(this, arg24, arg25, v4_1, v5_4, v6_3, v7_3, v8_2, v9_1, v10_1, v12, v13));
        }
    }

    private final void TrackImpl-VvwgllI(SliderState arg33, float arg34, Modifier arg35, boolean arg36, SliderColors arg37, Function2 arg38, Function3 arg39, float arg40, float arg41, boolean arg42, boolean arg43, Composer arg44, int arg45, int arg46) {
        Composer v1_1;
        Modifier v27;
        long v24;
        Modifier v3_1;
        int v22;
        int v6;
        int v20;
        int v11;
        int v8;
        SliderState v2 = arg33;
        float v1 = arg34;
        Modifier v0 = arg35;
        boolean v3 = arg36;
        SliderColors v4 = arg37;
        int v5 = arg45;
        Composer v7 = arg44.startRestartGroup(0x7F37829);
        ComposerKt.sourceInformation(v7, "C(TrackImpl)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,enableCornerShrinking,isCentered)1601@71313L957,1622@72299L1481,1592@70900L2880:Slider.kt#uh7d8r");
        if((v5 & 6) == 0) {
            v8 = v7.changedInstance(v2) ? 4 : 2;
            v8 |= v5;
        }
        else {
            v8 = v5;
        }

        if((v5 & 0x30) == 0) {
            v11 = v7.changed(v1) ? 0x20 : 16;
            v8 |= v11;
        }

        if((v5 & 0x180) == 0) {
            v11 = v7.changed(v0) ? 0x100 : 0x80;
            v8 |= v11;
        }

        if((v5 & 0xC00) == 0) {
            v11 = v7.changed(v3) ? 0x800 : 0x400;
            v8 |= v11;
        }

        if((v5 & 0x6000) == 0) {
            v11 = v7.changed(v4) ? 0x4000 : 0x2000;
            v8 |= v11;
        }

        if((0x30000 & v5) == 0) {
            int v14 = v7.changedInstance(arg38) ? 0x20000 : 0x10000;
            v8 |= v14;
        }

        if((0x180000 & v5) == 0) {
            int v16 = v7.changedInstance(arg39) ? 0x100000 : 0x80000;
            v8 |= v16;
        }

        float v15 = arg40;
        if((v5 & 0xC00000) == 0) {
            int v17 = v7.changed(v15) ? 0x800000 : 0x400000;
            v8 |= v17;
        }

        float v13 = arg41;
        if((v5 & 0x6000000) == 0) {
            int v18 = v7.changed(v13) ? 0x4000000 : 0x2000000;
            v8 |= v18;
        }

        boolean v9 = arg42;
        if((v5 & 0x30000000) == 0) {
            int v19 = v7.changed(v9) ? 0x20000000 : 0x10000000;
            v8 |= v19;
        }

        boolean v12 = arg43;
        if((arg46 & 6) == 0) {
            v20 = v7.changed(v12) ? 4 : 2;
            v6 = arg46 | v20;
        }
        else {
            v6 = arg46;
        }

        boolean v5_1 = (v8 & 306783379) != 306783378 || (v6 & 3) != 2 ? true : false;
        if(v7.shouldExecute(v5_1, v8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7F37829, v8, v6, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1587)");
            }

            long v10 = v4.trackColor-WaAFU9c$material3(v3, false);
            long v12_1 = v4.trackColor-WaAFU9c$material3(v3, true);
            long v14_1 = v4.tickColor-WaAFU9c$material3(v3, false);
            v20 = v6;
            long v5_2 = v4.tickColor-WaAFU9c$material3(v3, true);
            if(v2.getOrientation$material3() == Orientation.Vertical) {
                v22 = v8;
                v3_1 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(v0, SliderKt.getTrackHeight()), 0f, 1, null);
                if(v2.getReverseVerticalDirection$material3()) {
                    v3_1 = ScaleKt.scale(v3_1, 1f, -1f);
                }
            }
            else {
                v22 = v8;
                v3_1 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(v0, 0f, 1, null), SliderKt.getTrackHeight());
            }

            Companion v4_1 = Modifier.Companion;
            String v8_1 = "CC(remember):Slider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v7, 0xD8F6B086, v8_1);
            int v9_1 = v22 & 0x70;
            int v0_1 = v9_1 == 0x20 ? 1 : 0;
            int v23 = v0_1 | v7.changedInstance(v2);
            Object v0_2 = v7.rememberedValue();
            if(v23 == 0) {
                v24 = v5_2;
                if(v0_2 == Composer.Companion.getEmpty()) {
                    goto label_188;
                }
            }
            else {
                v24 = v5_2;
            label_188:
                SliderDefaults$$ExternalSyntheticLambda10 v0_3 = new SliderDefaults$$ExternalSyntheticLambda10(v1, v2);
                v7.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v7);
            v0 = v3_1.then(LayoutModifierKt.layout(((Modifier)v4_1), ((Function3)v0_2)));
            ComposerKt.sourceInformationMarkerStart(v7, 0xD8F72DD2, v8_1);
            int v3_2 = v9_1 == 0x20 ? 1 : 0;
            long v4_2 = v24;
            v3_2 = v3_2 | v7.changedInstance(v2) | v7.changed(v10) | v7.changed(v12_1) | v7.changed(v14_1) | v7.changed(v4_2);
            v6 = (v22 & 0x1C00000) == 0x800000 ? 1 : 0;
            v3_2 |= v6;
            v6 = (v22 & 0xE000000) == 0x4000000 ? 1 : 0;
            v3_2 |= v6;
            v6 = (v22 & 0x70000) == 0x20000 ? 1 : 0;
            v3_2 |= v6;
            v6 = (v22 & 0x380000) == 0x100000 ? 1 : 0;
            v3_2 |= v6;
            v6 = (v22 & 0x70000000) == 0x20000000 ? 1 : 0;
            v3_2 |= v6;
            v9_1 = (v20 & 14) == 4 ? 1 : 0;
            Object v6_1 = v7.rememberedValue();
            if((v3_2 | v9_1) != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v27 = v0;
                SliderDefaults$$ExternalSyntheticLambda12 v0_4 = new SliderDefaults$$ExternalSyntheticLambda12(v1, v2, v10, v12_1, v14_1, v4_2, arg40, arg41, arg38, arg39, arg42, arg43);
                v1_1 = v7;
                v1_1.updateRememberedValue(v0_4);
                SliderDefaults$$ExternalSyntheticLambda12 v6_2 = v0_4;
            }
            else {
                v27 = v0;
                v1_1 = v7;
            }

            ComposerKt.sourceInformationMarkerEnd(v1_1);
            CanvasKt.Canvas(v27, ((Function1)v6_1), v1_1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_298;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_1 = v7;
            v1_1.skipToGroupEnd();
        }

    label_298:
        ScopeUpdateScope v15_1 = v1_1.endRestartGroup();
        if(v15_1 != null) {
            v15_1.updateScope(new SliderDefaults$$ExternalSyntheticLambda13(this, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg45, arg46));
        }
    }

    private final void TrackImpl-xlyIBlM(RangeSliderState arg24, float arg25, Modifier arg26, boolean arg27, SliderColors arg28, Function2 arg29, Function3 arg30, float arg31, float arg32, Composer arg33, int arg34) {
        Composer v15_1;
        Modifier v20;
        SliderDefaults$$ExternalSyntheticLambda21 v8_3;
        SliderDefaults$$ExternalSyntheticLambda20 v1_2;
        int v9;
        int v6;
        RangeSliderState v2 = arg24;
        Modifier v15 = arg26;
        boolean v0 = arg27;
        SliderColors v1 = arg28;
        int v3 = arg34;
        int v4 = -1719396904;
        Composer v5 = arg33.startRestartGroup(v4);
        ComposerKt.sourceInformation(v5, "C(TrackImpl)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1817@80714L449,1828@81174L1310,1816@80643L1841:Slider.kt#uh7d8r");
        if((v3 & 6) == 0) {
            v6 = v5.changedInstance(v2) ? 4 : 2;
            v6 |= v3;
        }
        else {
            v6 = v3;
        }

        if((v3 & 0x30) == 0) {
            v9 = v5.changed(arg25) ? 0x20 : 16;
            v6 |= v9;
        }

        if((v3 & 0x180) == 0) {
            v9 = v5.changed(v15) ? 0x100 : 0x80;
            v6 |= v9;
        }

        if((v3 & 0xC00) == 0) {
            v9 = v5.changed(v0) ? 0x800 : 0x400;
            v6 |= v9;
        }

        if((v3 & 0x6000) == 0) {
            v9 = v5.changed(v1) ? 0x4000 : 0x2000;
            v6 |= v9;
        }

        Function2 v13 = arg29;
        if((0x30000 & v3) == 0) {
            v9 = v5.changedInstance(v13) ? 0x20000 : 0x10000;
            v6 |= v9;
        }

        Function3 v14 = arg30;
        if((0x180000 & v3) == 0) {
            v9 = v5.changedInstance(v14) ? 0x100000 : 0x80000;
            v6 |= v9;
        }

        if((0xC00000 & v3) == 0) {
            int v16 = v5.changed(arg31) ? 0x800000 : 0x400000;
            v6 |= v16;
        }

        float v10 = arg32;
        if((v3 & 0x6000000) == 0) {
            int v17 = v5.changed(v10) ? 0x4000000 : 0x2000000;
            v6 |= v17;
        }

        boolean v11 = (v6 & 0x2492493) != 0x2492492 ? true : false;
        if(v5.shouldExecute(v11, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v6, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1811)");
            }

            long v11_1 = v1.trackColor-WaAFU9c$material3(v0, false);
            int v18 = v6;
            long v6_1 = v1.trackColor-WaAFU9c$material3(v0, true);
            long v9_1 = v1.tickColor-WaAFU9c$material3(v0, false);
            Composer v19 = v5;
            long v4_1 = v1.tickColor-WaAFU9c$material3(v0, true);
            Modifier v0_1 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(v15, 0f, 1, null), SliderKt.getTrackHeight());
            String v8 = "CC(remember):Slider.kt#9igjgp";
            Composer v3_1 = v19;
            ComposerKt.sourceInformationMarkerStart(v3_1, 1222010201, v8);
            Object v1_1 = v3_1.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = new SliderDefaults$$ExternalSyntheticLambda20();
                v3_1.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3_1);
            v0_1 = LayoutModifierKt.layout(v0_1, ((Function3)v1_2));
            ComposerKt.sourceInformationMarkerStart(v3_1, 1222025782, v8);
            int v1_3 = (v18 & 0x70) == 0x20 ? 1 : 0;
            v1_3 = v1_3 | v3_1.changedInstance(v2) | v3_1.changed(v11_1) | v3_1.changed(v6_1) | v3_1.changed(v9_1) | v3_1.changed(v4_1);
            int v8_1 = (v18 & 0x1C00000) == 0x800000 ? 1 : 0;
            v1_3 |= v8_1;
            v8_1 = (v18 & 0xE000000) == 0x4000000 ? 1 : 0;
            v1_3 |= v8_1;
            v8_1 = (v18 & 0x70000) == 0x20000 ? 1 : 0;
            v1_3 |= v8_1;
            v8_1 = (v18 & 0x380000) == 0x100000 ? 1 : 0;
            v1_3 |= v8_1;
            Object v8_2 = v3_1.rememberedValue();
            if(v1_3 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                v20 = v0_1;
                v15_1 = v3_1;
                SliderDefaults$$ExternalSyntheticLambda21 v0_2 = new SliderDefaults$$ExternalSyntheticLambda21(arg25, v2, v11_1, v6_1, v9_1, v4_1, arg31, arg32, arg29, v14);
                v15_1.updateRememberedValue(v0_2);
                v8_3 = v0_2;
            }
            else {
                v20 = v0_1;
                v15_1 = v3_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            CanvasKt.Canvas(v20, ((Function1)v8_3), v15_1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_223;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v15_1 = v5;
            v15_1.skipToGroupEnd();
        }

    label_223:
        ScopeUpdateScope v12 = v15_1.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new SliderDefaults$$ExternalSyntheticLambda22(this, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg34));
        }
    }

    static final MeasureResult TrackImpl_VvwgllI$lambda$29$lambda$28(float arg2, SliderState arg3, MeasureScope arg4, Measurable arg5, Constraints arg6) {
        int v2;
        Placeable v5 = arg5.measure-BRTryo0(arg6.unbox-impl());
        if(!Dp.equals-impl0(arg2, Dp.Companion.getUnspecified-D9Ej5fM())) {
            v2 = arg4.roundToPx-0680j_4(arg2);
        }
        else if(arg3.getOrientation$material3() == Orientation.Vertical) {
            v2 = v5.getWidth() / 2;
        }
        else {
            v2 = v5.getHeight() / 2;
        }

        return arg4.layout(v5.getWidth(), v5.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(v2))), new SliderDefaults$$ExternalSyntheticLambda9(v5));
    }

    static final Unit TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_VvwgllI$lambda$31$lambda$30(float arg26, SliderState arg27, long arg28, long arg30, long arg32, long arg34, float arg36, float arg37, Function2 arg38, Function3 arg39, boolean arg40, boolean arg41, DrawScope arg42) {
        float v0 = arg26;
        DrawScope v1 = arg42;
        if(Dp.equals-impl0(v0, Dp.Companion.getUnspecified-D9Ej5fM())) {
            float v3 = 2f;
            v0 = arg27.getOrientation$material3() == Orientation.Vertical ? Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> 0x20))) : Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & 0xFFFFFFFFL)));
            v0 /= v3;
        }
        else {
            v0 = v1.toPx-0680j_4(v0);
        }

        SliderDefaults.INSTANCE.drawTrack-GVD57ws(v1, arg27.getTickFractions$material3(), 0f, arg27.getCoercedValueAsFraction(), arg28, arg30, arg32, arg34, v1.toDp-u2uoSUM(0), v1.toDp-u2uoSUM(0), v1.toDp-u2uoSUM(arg27.getThumbWidth$material3()), v1.toDp-u2uoSUM(arg27.getThumbHeight$material3()), arg36, arg37, v1.toDp-u2uoSUM(v0), arg38, arg39, false, arg40, arg27.getOrientation$material3(), arg41);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_VvwgllI$lambda$32(SliderDefaults arg16, SliderState arg17, float arg18, Modifier arg19, boolean arg20, SliderColors arg21, Function2 arg22, Function3 arg23, float arg24, float arg25, boolean arg26, boolean arg27, int arg28, int arg29, Composer arg30, int arg31) {
        arg16.TrackImpl-VvwgllI(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), RecomposeScopeImplKt.updateChangedFlags(arg29));
        return Unit.INSTANCE;
    }

    static final MeasureResult TrackImpl_xlyIBlM$lambda$44$lambda$43(MeasureScope arg3, Measurable arg4, Constraints arg5) {
        Placeable v4 = arg4.measure-BRTryo0(arg5.unbox-impl());
        return arg3.layout(v4.getWidth(), v4.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(v4.getHeight() / 2))), new SliderDefaults$$ExternalSyntheticLambda2(v4));
    }

    static final Unit TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_xlyIBlM$lambda$46$lambda$45(float arg28, RangeSliderState arg29, long arg30, long arg32, long arg34, long arg36, float arg38, float arg39, Function2 arg40, Function3 arg41, DrawScope arg42) {
        float v0 = arg28;
        DrawScope v1 = arg42;
        v0 = Dp.equals-impl0(v0, Dp.Companion.getUnspecified-D9Ej5fM()) ? Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & 0xFFFFFFFFL))) / 2f : v1.toPx-0680j_4(v0);
        SliderDefaults.drawTrack-GVD57ws$default(SliderDefaults.INSTANCE, v1, arg29.getTickFractions$material3(), arg29.getCoercedActiveRangeStartAsFraction$material3(), arg29.getCoercedActiveRangeEndAsFraction$material3(), arg30, arg32, arg34, arg36, v1.toDp-u2uoSUM(arg29.getStartThumbWidth$material3()), v1.toDp-u2uoSUM(arg29.getStartThumbHeight$material3()), v1.toDp-u2uoSUM(arg29.getEndThumbWidth$material3()), v1.toDp-u2uoSUM(arg29.getEndThumbHeight$material3()), arg38, arg39, v1.toDp-u2uoSUM(v0), arg40, arg41, true, false, null, false, 0xE0000, null);
        return Unit.INSTANCE;
    }

    static final Unit TrackImpl_xlyIBlM$lambda$47(SliderDefaults arg13, RangeSliderState arg14, float arg15, Modifier arg16, boolean arg17, SliderColors arg18, Function2 arg19, Function3 arg20, float arg21, float arg22, int arg23, Composer arg24, int arg25) {
        arg13.TrackImpl-xlyIBlM(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$15$lambda$14(SliderColors arg7, boolean arg8, DrawScope arg9, Offset arg10) {
        SliderDefaults.INSTANCE.drawStopIndicator-x3O1jOs(arg9, arg10.unbox-impl(), SliderDefaults.TrackStopIndicatorSize, arg7.trackColor-WaAFU9c$material3(arg8, true));
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$17(SliderDefaults arg13, SliderState arg14, Modifier arg15, boolean arg16, SliderColors arg17, Function2 arg18, Function3 arg19, float arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        arg13.Track-4EFweAY(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$35$lambda$34(SliderColors arg7, boolean arg8, DrawScope arg9, Offset arg10) {
        SliderDefaults.INSTANCE.drawStopIndicator-x3O1jOs(arg9, arg10.unbox-impl(), SliderDefaults.TrackStopIndicatorSize, arg7.trackColor-WaAFU9c$material3(arg8, true));
        return Unit.INSTANCE;
    }

    static final Unit Track_4EFweAY$lambda$37(SliderDefaults arg13, RangeSliderState arg14, Modifier arg15, boolean arg16, SliderColors arg17, Function2 arg18, Function3 arg19, float arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        arg13.Track-4EFweAY(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$19$lambda$18(SliderColors arg7, boolean arg8, DrawScope arg9, Offset arg10) {
        SliderDefaults.INSTANCE.drawStopIndicator-x3O1jOs(arg9, arg10.unbox-impl(), SliderDefaults.TrackStopIndicatorSize, arg7.trackColor-WaAFU9c$material3(arg8, true));
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$21(SliderDefaults arg14, SliderState arg15, float arg16, Modifier arg17, boolean arg18, SliderColors arg19, Function2 arg20, Function3 arg21, float arg22, float arg23, int arg24, int arg25, Composer arg26, int arg27) {
        arg14.Track-mnvyFg4$material3(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$39$lambda$38(SliderColors arg7, boolean arg8, DrawScope arg9, Offset arg10) {
        SliderDefaults.INSTANCE.drawStopIndicator-x3O1jOs(arg9, arg10.unbox-impl(), SliderDefaults.TrackStopIndicatorSize, arg7.trackColor-WaAFU9c$material3(arg8, true));
        return Unit.INSTANCE;
    }

    static final Unit Track_mnvyFg4$lambda$41(SliderDefaults arg14, RangeSliderState arg15, float arg16, Modifier arg17, boolean arg18, SliderColors arg19, Function2 arg20, Function3 arg21, float arg22, float arg23, int arg24, int arg25, Composer arg26, int arg27) {
        arg14.Track-mnvyFg4$material3(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public final SliderColors colors(Composer arg4, int arg5) {
        int v1 = 0x52089C20;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)1107@48675L11:Slider.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1107)");
        }

        SliderColors v3 = this.getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SliderColors colors-q0g_0yA(long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, Composer arg44, int arg45, int arg46, int arg47) {
        Composer v0 = arg44;
        int v1 = arg47;
        int v3 = 0x34C9025E;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(thumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)1149@50999L11:Slider.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v20 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v1_1 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        arg42 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg24 = v4;
            ComposerKt.traceEventStart(v3, arg45, arg46, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1149)");
        }
        else {
            arg24 = v4;
        }

        SliderColors v1_2 = this.getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy--K518z4(arg24, v6, v8, v10, v12, v14, v16, v18, v20, arg42);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final void drawStopIndicator-x3O1jOs(DrawScope arg13, long arg14, float arg16, long arg17) {
        DrawScope.drawCircle-VaOC9Bg$default(arg13, arg17, arg13.toPx-0680j_4(arg16) / 2f, arg14, 0f, null, null, 0, 120, null);
    }

    private final void drawTrack-GVD57ws(DrawScope arg34, float[] arg35, float arg36, float arg37, long arg38, long arg40, long arg42, long arg44, float arg46, float arg47, float arg48, float arg49, float arg50, float arg51, float arg52, Function2 arg53, Function3 arg54, boolean arg55, boolean arg56, Orientation arg57, boolean arg58) {
        long v4_3;
        ClosedFloatingPointRange v36;
        ClosedFloatingPointRange v33;
        float v12_1;
        float v17_1;
        Orientation v2_3;
        long v7_1;
        SliderDefaults v0_1;
        long v5_1;
        int v2_2;
        long v2_1;
        float v13;
        float v14;
        int v29;
        float v10;
        float v9;
        float v27;
        float v26;
        DrawScope v1 = arg34;
        float[] v11 = arg35;
        float v0 = arg36;
        float v2 = arg37;
        float v3 = arg50;
        Function2 v12 = arg53;
        Orientation v5 = arg57;
        int v15 = v5 == Orientation.Vertical ? 1 : 0;
        int v16 = v1.getLayoutDirection() == LayoutDirection.Rtl ? 1 : 0;
        int v17 = v16 == 0 || v15 != 0 ? 0 : 1;
        float v18 = v1.toPx-0680j_4(arg52);
        long v19 = 0xFFFFFFFFL;
        int v21 = 0x20;
        long v6 = v1.getSize-NH-jbRc();
        if(v15 != 0) {
            v6 &= v19;
        }
        else {
            v6 >>= v21;
        }

        float v22 = Float.intBitsToFloat(((int)v6));
        int v4 = (Intrinsics.areEqual(v0, ArraysKt.firstOrNull(v11))) || (Intrinsics.areEqual(v0, ArraysKt.lastOrNull(v11))) ? 1 : 0;
        int v6_1 = (Intrinsics.areEqual(v2, ArraysKt.firstOrNull(v11))) || (Intrinsics.areEqual(v2, ArraysKt.lastOrNull(v11))) ? 1 : 0;
        int v7 = v11.length == 0 ? 1 : 0;
        float v8 = 2f;
        float v6_2 = v7 != 0 || v6_1 != 0 ? 0f + (v22 - 0f) * v2 : (v22 - 0f - v18 * v8) * v2 + 0f + v18;
        v2 = v6_2;
        v6_1 = v11.length == 0 ? 1 : 0;
        float v4_1 = v6_1 != 0 || v4 != 0 ? 0f + (v22 - 0f) * v0 : (v22 - 0f - v18 * v8) * v0 + 0f + v18;
        float v24 = v4_1;
        float v25 = v1.toPx-0680j_4(arg51);
        if(Dp.compareTo-0680j_4(v3, Dp.constructor-impl(0f)) > 0) {
            if(v15 != 0) {
                v0 = v1.toPx-0680j_4(arg47) / v8 + v1.toPx-0680j_4(v3);
                v4_1 = v1.toPx-0680j_4(arg49) / v8;
                v3 = v1.toPx-0680j_4(v3);
            }
            else {
                v0 = v1.toPx-0680j_4(arg46) / v8 + v1.toPx-0680j_4(v3);
                v4_1 = v1.toPx-0680j_4(arg48) / v8;
                v3 = v1.toPx-0680j_4(v3);
            }

            v26 = v0;
            v27 = v4_1 + v3;
        }
        else {
            v26 = 0f;
            v27 = 0f;
        }

        long v3_1 = v1.getCenter-F1C5BW0();
        if(v15 != 0) {
            v3_1 &= v19;
        }
        else {
            v3_1 >>= v21;
        }

        v0 = Float.intBitsToFloat(((int)v3_1));
        v3 = v26 + 0f;
        if(arg56) {
            v4 = v11.length == 0 ? 1 : 0;
            if(v4 != 0) {
                goto label_140;
            }

            goto label_139;
        }
        else {
        label_139:
            v3 += v18;
        }

    label_140:
        float v28 = arg58 ? Math.min(v2, v0) : v24;
        if(!arg58 && !arg55) {
            goto label_272;
        }
        else if(v28 > v3) {
            v9 = v17 != 0 ? v25 : v18;
            v10 = v17 != 0 ? v18 : v25;
            v3 = v28 - v26;
            if(v17 != 0) {
                v29 = 1;
                v6 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21))) - v3))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }
            else {
                v29 = 1;
                v6 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }

            v3_1 = v15 != 0 ? Size.constructor-impl((((long)Float.floatToRawIntBits(v3 - 0f))) & v19 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21)))))) << v21) : Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v19)))))) & v19 | (((long)Float.floatToRawIntBits(v3 - 0f))) << v21);
            v14 = v0;
            v13 = v2;
            this.drawTrackPath-zXTsYAs(v1, v5, v6, v3_1, arg38, v9, v10);
            if(v15 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() >> v21)))))) << v21 | (((long)Float.floatToRawIntBits(v18 + 0f))) & v19);
            }
            else if(v16 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21))) - 0f - v18))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19);
            }
            else {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v18 + 0f))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19);
            }

            if(v12 == null) {
                goto label_275;
            }

            v12.invoke(v1, Offset.box-impl(v2_1));
        }
        else {
        label_272:
            v14 = v0;
            v13 = v2;
            v29 = 1;
        }

    label_275:
        v0 = v22 - v27;
        if(arg56) {
            v2_2 = v11.length == 0 ? v29 : 0;
            if(v2_2 != 0) {
                goto label_284;
            }

            goto label_283;
        }
        else {
        label_283:
            v0 -= v18;
        }

    label_284:
        float v30 = arg58 ? Math.max(v13, v14) : v13;
        if(v30 < v0) {
            v9 = v17 != 0 ? v18 : v25;
            v10 = v17 != 0 ? v25 : v18;
            v0 = v30 + v27;
            v2 = v22 - v0;
            if(v15 != 0) {
                v3_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v21 | (((long)Float.floatToRawIntBits(v0))) & v19);
            }
            else if(v16 != 0) {
                v3_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }
            else {
                v3_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }

            if(v15 != 0) {
                v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21)))))) << v21 | (((long)Float.floatToRawIntBits(v2))) & v19);
            }
            else {
                if(v16 != 0 && !arg55) {
                    v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21))) - v0))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v19)))))) & v19);
                    goto label_341;
                }

                v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(v2))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v19)))))) & v19);
            }

        label_341:
            v0_1 = this;
            v7_1 = arg38;
            v2_3 = arg57;
            v0_1.drawTrackPath-zXTsYAs(v1, v2_3, v3_1, v5_1, v7_1, v9, v10);
            if(v15 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() >> v21)))))) << v21 | (((long)Float.floatToRawIntBits(v22 - v18))) & v19);
            }
            else if(v16 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v18))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19);
            }
            else {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v22 - v18))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19);
            }

            if(v12 == null) {
                goto label_425;
            }

            v12.invoke(v1, Offset.box-impl(v2_1));
        }

    label_425:
        if(arg58) {
            v0 = v28 < v14 ? v26 : 0f;
            v28 += v0;
        }
        else {
            if(arg55) {
                v28 = v24 + v26;
                goto label_436;
            }

            v28 = 0f;
        }

    label_436:
        if(arg58) {
            v0 = v30 > v14 ? v27 : 0f;
            v30 -= v0;
        }
        else {
            v30 = v13 - v27;
        }

        v9 = v17 != 0 || (arg58) || (arg55) ? v25 : v18;
        v10 = v17 == 0 || (arg58) || (arg55) ? v25 : v18;
        v0 = v17 == 0 || (arg58) || (arg55) ? v30 - v28 : v30;
        if(arg56) {
            v2_2 = v11.length == 0 ? v29 : 0;
            if(v2_2 == 0) {
                goto label_473;
            }

            v2 = 0f;
        }
        else {
        label_473:
            v2 = v9;
        }

        if(v0 > v2) {
            if(v15 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v21 | (((long)Float.floatToRawIntBits(v28))) & v19);
            }
            else if(v16 != 0) {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21))) - v30))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }
            else {
                v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v28))) << v21 | (((long)Float.floatToRawIntBits(0f))) & v19);
            }

            v3_1 = v2_1;
            if(v15 != 0) {
                v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21)))))) << v21 | (((long)Float.floatToRawIntBits(v0))) & v19);
            }
            else {
                if(v16 != 0 && !arg58 && !arg55) {
                    v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(v30))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v19)))))) & v19);
                    goto label_523;
                }

                v5_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v19)))))) & v19);
            }

        label_523:
            v0_1 = this;
            v7_1 = arg40;
            v2_3 = arg57;
            v17_1 = v13;
            v12_1 = v28;
            v13 = v30;
            v0_1.drawTrackPath-zXTsYAs(v1, v2_3, v3_1, v5_1, v7_1, v9, v10);
        }
        else {
            v17_1 = v13;
            v12_1 = v28;
            v13 = v30;
        }

        v0 = 0f + v18;
        v2 = v22 - v18;
        ClosedFloatingPointRange v3_2 = RangesKt.rangeTo(v12_1, v13);
        ClosedFloatingPointRange v4_2 = RangesKt.rangeTo(v14 - v27, v14 + v27);
        ClosedFloatingPointRange v5_2 = RangesKt.rangeTo(v24 - v26, v24 + v26);
        ClosedFloatingPointRange v6_3 = RangesKt.rangeTo(v17_1 - v27, v17_1 + v27);
        v7 = v11.length;
        int v8_1 = 0;
        int v13_1 = 0;
        while(v13_1 < v7) {
            v9 = v11[v13_1];
            int v10_1 = v8_1 + 1;
            if(arg53 != null) {
                if(((arg58) || (arg55)) && v8_1 == 0) {
                    goto label_603;
                }

                if(v8_1 != v11.length - 1) {
                    goto label_591;
                }

                goto label_603;
            }
            else {
            label_591:
                v8 = MathHelpersKt.lerp(v0, v2, v9);
                if((arg58) && (v4_2.contains(Float.valueOf(v8)))) {
                    goto label_603;
                }

                if((arg55) && (v5_2.contains(Float.valueOf(v8)))) {
                    goto label_603;
                }

                if(v6_3.contains(Float.valueOf(v8))) {
                label_603:
                    v33 = v4_2;
                    v36 = v5_2;
                    goto label_672;
                }

                if(v15 != 0) {
                    v33 = v4_2;
                    v36 = v5_2;
                    v4_3 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() >> v21)))))) << v21 | (((long)Float.floatToRawIntBits(v8))) & v19);
                }
                else {
                    v33 = v4_2;
                    v36 = v5_2;
                    v4_3 = v16 != 0 ? Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v21))) - v8))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19) : Offset.constructor-impl((((long)Float.floatToRawIntBits(v8))) << v21 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getCenter-F1C5BW0() & v19)))))) & v19);
                }

                Offset v4_4 = Offset.box-impl(v4_3);
                long v8_2 = v3_2.contains(Float.valueOf(v8)) ? arg44 : arg42;
                arg54.invoke(v1, v4_4, Color.box-impl(v8_2));
            }

        label_672:
            ++v13_1;
            v4_2 = v33;
            v5_2 = v36;
            v8_1 = v10_1;
        }
    }

    static void drawTrack-GVD57ws$default(SliderDefaults arg28, DrawScope arg29, float[] arg30, float arg31, float arg32, long arg33, long arg35, long arg37, long arg39, float arg41, float arg42, float arg43, float arg44, float arg45, float arg46, float arg47, Function2 arg48, Function3 arg49, boolean arg50, boolean arg51, Orientation arg52, boolean arg53, int arg54, Object arg55) {
        boolean v25 = (arg54 & 0x20000) != 0 ? false : arg51;
        Orientation v26 = (arg54 & 0x40000) != 0 ? Orientation.Horizontal : arg52;
        boolean v27 = (arg54 & 0x80000) != 0 ? false : arg53;
        arg28.drawTrack-GVD57ws(arg29, arg30, arg31, arg32, arg33, arg35, arg37, arg39, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, v25, v26, v27);
    }

    private final void drawTrackPath-zXTsYAs(DrawScope arg19, Orientation arg20, long arg21, long arg23, long arg25, float arg27, float arg28) {
        long v0 = arg21;
        int v6 = 0x20;
        long v7 = 0xFFFFFFFFL;
        long v10 = CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg27))) << v6 | (((long)Float.floatToRawIntBits(arg27))) & v7);
        long v12 = CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg28))) << v6 | (((long)Float.floatToRawIntBits(arg28))) & v7);
        RoundRect v0_1 = arg20 == Orientation.Vertical ? RoundRectKt.RoundRect-ZAM2FJo(RectKt.Rect-tz77jQw(v0, Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg23 & v7)))))) & v7 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg23 >> v6)))))) << v6)), v10, v10, v12, v12) : RoundRectKt.RoundRect-ZAM2FJo(RectKt.Rect-tz77jQw(v0, Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg23 & v7)))))) & v7 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg23 >> v6)))))) << v6)), v10, v12, v12, v10);
        Path v2 = SliderDefaults.trackPath;
        Path.addRoundRect$default(v2, v0_1, null, 2, null);
        DrawScope.drawPath-LG529CI$default(arg19, v2, arg25, 0f, null, null, 0, 60, null);
        v2.rewind();
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme arg30) {
        ColorScheme v0 = arg30;
        SliderColors v1 = v0.getDefaultSliderColorsCached$material3();
        if(v1 == null) {
            SliderColors v2 = new SliderColors(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultSliderColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getTickSize-D9Ej5fM() {
        return SliderDefaults.TickSize;
    }

    public final float getTrackStopIndicatorSize-D9Ej5fM() {
        return SliderDefaults.TrackStopIndicatorSize;
    }
}

