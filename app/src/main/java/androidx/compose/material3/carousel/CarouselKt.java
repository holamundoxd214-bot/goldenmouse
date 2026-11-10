package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0098\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u00052\b\b\u0002\u0010\u000E\u001A\u00020\u00052\b\b\u0002\u0010\u000F\u001A\u00020\u001021\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u008E\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\u00052\b\b\u0002\u0010\u000E\u001A\u00020\u00052\b\b\u0002\u0010\u000F\u001A\u00020\u001021\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u0084\u0001\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\u001021\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b \u0010!\u001Az\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000F\u001A\u00020\u001021\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\"\u0010#\u001A\u009A\u0001\u0010$\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010%\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u00052\b\b\u0002\u0010\u000E\u001A\u00020\u00052\b\b\u0002\u0010\u000F\u001A\u00020\u001021\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b&\u0010\'\u001AÂ\u0001\u0010(\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010)\u001A\u00020*26\u0010+\u001A2\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020.0\u00122\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010/\u001A\u00020\u00142\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f21\u0010\u0011\u001A-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b0\u00101\u001A\u0019\u00102\u001A\u00020,*\u00020\u00102\u0006\u0010)\u001A\u00020*H\u0003¢\u0006\u0002\u00103\u001A\u0019\u00104\u001A\u00020,*\u00020\u00102\u0006\u0010)\u001A\u00020*H\u0003¢\u0006\u0002\u00103\u001A:\u00105\u001A\u00020\u0007*\u00020\u00072\u0006\u00106\u001A\u00020\u00142\u0006\u0010\u0002\u001A\u00020\u00032\f\u00107\u001A\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020=H\u0000\u001A7\u0010>\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010?\u001A\u00020@2\b\b\u0002\u0010A\u001A\u00020B2\b\b\u0002\u0010C\u001A\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010E\u001A\u0018\u0010F\u001A\u00020,2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u00107\u001A\u000209H\u0000\u001A\u0018\u0010G\u001A\u00020,2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u00107\u001A\u000209H\u0001\u001A \u0010H\u001A\u00020,2\u0006\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020J2\u0006\u0010L\u001A\u00020,H\u0002¨\u0006M"}, d2={"HorizontalMultiBrowseCarousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "preferredItemWidth", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "itemSpacing", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "minSmallItemWidth", "maxSmallItemWidth", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function2;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "", "Lkotlin/ParameterName;", "name", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalMultiBrowseCarousel-3tcCNu0", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-VUP9l70", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalCenteredHeroCarousel", "maxItemWidth", "HorizontalCenteredHeroCarousel-p2lB3Bg", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/ui/Modifier;FFLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Carousel", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "", "availableSpace", "Landroidx/compose/material3/carousel/KeylineList;", "maxNonFocalVisibleItemCount", "Carousel-cJHQLPU", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateBeforeContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateAfterContentPadding", "carouselItem", "index", "strategy", "Lkotlin/Function0;", "Landroidx/compose/material3/carousel/Strategy;", "carouselItemDrawInfo", "Landroidx/compose/material3/carousel/CarouselItemDrawInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "drawDebugLines", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "drawDebugLines-1Yev-eo", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/material3/carousel/CarouselPageSize;JF)Landroidx/compose/ui/Modifier;", "calculateCurrentScrollOffset", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CarouselKt {
    public static final void Carousel-cJHQLPU(CarouselState arg32, Orientation arg33, Function2 arg34, PaddingValues arg35, int arg36, Modifier arg37, float arg38, TargetedFlingBehavior arg39, boolean arg40, Function4 arg41, Composer arg42, int arg43, int arg44) {
        boolean v9_3;
        TargetedFlingBehavior v8_1;
        float v7_1;
        CarouselKt$$ExternalSyntheticLambda4 v0_6;
        Object v0_4;
        CarouselPagerState v2_2;
        CarouselPageSize v15_3;
        TargetedFlingBehavior v20_1;
        boolean v21;
        Companion v4_2;
        Companion v17_1;
        int v18;
        TargetedFlingBehavior v13;
        int v16;
        float v15_1;
        int v5;
        Modifier v4_1;
        int v14;
        int v2;
        int v0;
        CarouselState v1 = arg32;
        Orientation v6 = arg33;
        Function2 v7 = arg34;
        PaddingValues v8 = arg35;
        Function4 v10 = arg41;
        int v11 = arg43;
        int v12 = arg44;
        Composer v3 = arg42.startRestartGroup(-2077912500);
        ComposerKt.sourceInformation(v3, "C(Carousel)N(state,orientation,keylineList,contentPadding,maxNonFocalVisibleItemCount,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,content)375@17497L42,376@17585L41,378@17654L118:Carousel.kt#dcf9yb");
        if((v12 & 1) != 0) {
            v0 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v0 = v3.changedInstance(v1) ? 4 : 2;
            v0 |= v11;
        }
        else {
            v0 = v11;
        }

        if((v12 & 2) != 0) {
            v0 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v2 = v3.changed(v6.ordinal()) ? 0x20 : 16;
            v0 |= v2;
        }

        if((v12 & 4) != 0) {
            v0 |= 0x180;
        }
        else if((v11 & 0x180) == 0) {
            v2 = v3.changedInstance(v7) ? 0x100 : 0x80;
            v0 |= v2;
        }

        if((v12 & 8) != 0) {
            v0 |= 0xC00;
        }
        else if((v11 & 0xC00) == 0) {
            v2 = v3.changed(v8) ? 0x800 : 0x400;
            v0 |= v2;
        }

        if((v12 & 16) != 0) {
            v0 |= 0x6000;
            v14 = arg36;
        }
        else {
            v14 = arg36;
            if((v11 & 0x6000) == 0) {
                v2 = v3.changed(v14) ? 0x4000 : 0x2000;
                v0 |= v2;
            }
        }

        v2 = v12 & 0x20;
        int v4 = 0x30000;
        if(v2 != 0) {
            v0 |= v4;
            goto label_93;
        }
        else if((v4 & v11) == 0) {
            v4_1 = arg37;
            v5 = v3.changed(v4_1) ? 0x20000 : 0x10000;
            v0 |= v5;
        }
        else {
        label_93:
            v4_1 = arg37;
        }

        v5 = v12 & 0x40;
        int v15 = 0x180000;
        if(v5 != 0) {
            v0 |= v15;
            goto label_109;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg38;
            v16 = v3.changed(v15_1) ? 0x100000 : 0x80000;
            v0 |= v16;
        }
        else {
        label_109:
            v15_1 = arg38;
        }

        if((v11 & 0xC00000) == 0) {
            if((v12 & 0x80) == 0) {
                v13 = arg39;
                if(v3.changed(v13)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_121;
                }
            }
            else {
                v13 = arg39;
            label_121:
                v16 = 0x400000;
            }

            v0 |= v16;
        }
        else {
            v13 = arg39;
        }

        int v9 = v12 & 0x100;
        int v17 = 0x6000000;
        if(v9 != 0) {
            v0 |= v17;
            goto label_141;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v3.changed(arg40) ? 0x4000000 : 0x2000000;
            v0 |= v18;
        }
        else {
        label_141:
            v17 = v2;
        }

        v18 = v0;
        int v19 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v0 = v18 | v19;
            goto label_148;
        }
        else if((v11 & v19) == 0) {
            v0 = v3.changedInstance(v10) ? 0x20000000 : 0x10000000;
            v0 |= v18;
        label_148:
            v18 = v0;
        }

        boolean v2_1 = true;
        boolean v0_1 = (v18 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v0_1, v18 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "371@17296L41");
            int v20 = 0xFE3FFFFF;
            if((v11 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v17 != 0) {
                    v17_1 = Modifier.Companion;
                }
                else {
                    Modifier v17_2 = v4_1;
                }

                if(v5 != 0) {
                    v15_1 = Dp.constructor-impl(0f);
                }

                if((v12 & 0x80) != 0) {
                    v1 = arg32;
                    TargetedFlingBehavior v0_2 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(v1, null, v3, v18 & 14 | 0x180, 2);
                    v18 &= v20;
                    v2_1 = true;
                    v13 = v0_2;
                }
                else {
                    v1 = arg32;
                }

                v21 = v9 != 0 ? v2_1 : arg40;
                v20_1 = v13;
                v4_2 = v17_1;
            }
            else {
                v3.skipToGroupEnd();
                if((v12 & 0x80) != 0) {
                    v18 &= v20;
                }

                v1 = arg32;
                v21 = arg40;
                v20_1 = v13;
            }

            v5 = v18;
            float v18_1 = v15_1;
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2077912500, v5, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:374)");
            }

            v9 = v5 >> 9 & 14 | v5 & 0x70;
            float v13_1 = CarouselKt.calculateBeforeContentPadding(v8, v6, v3, v9);
            float v9_1 = CarouselKt.calculateAfterContentPadding(v8, v6, v3, v9);
            String v0_3 = "CC(remember):Carousel.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, 0x110A9002, v0_3);
            v2 = (v5 & 0x380) == 0x100 ? 1 : 0;
            Object v15_2 = v3.rememberedValue();
            if(v2 != 0 || v15_2 == Composer.Companion.getEmpty()) {
                v15_3 = new CarouselPageSize(v7, v13_1, v9_1);
                v3.updateRememberedValue(v15_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            SnapPosition v25 = KeylineSnapPositionKt.KeylineSnapPosition(v15_3);
            if(v6 == Orientation.Horizontal) {
                v3.startReplaceGroup(0x104B8F19);
                ComposerKt.sourceInformation(v3, "399@18566L24,400@18602L1024,385@17885L1741");
                v2_2 = v1.getPagerState$material3();
                PaddingValues v9_2 = PaddingKt.PaddingValues-a9UjIt4$default(0f, v8.calculateTopPadding-D9Ej5fM(), 0f, v8.calculateBottomPadding-D9Ej5fM(), 5, null);
                ComposerKt.sourceInformationMarkerStart(v3, 0x110B01A4, v0_3);
                v0_4 = v3.rememberedValue();
                if(v0_4 == Composer.Companion.getEmpty()) {
                    CarouselKt$$ExternalSyntheticLambda3 v0_5 = new CarouselKt$$ExternalSyntheticLambda3();
                    v3.updateRememberedValue(v0_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                PagerKt.HorizontalPager--8jOkeI(v2_2, SemanticsModifierKt.semantics$default(((Modifier)v4_2), false, ((Function1)v0_4), 1, null), v9_2, v15_3, v14, v18_1, null, v20_1, v21, false, null, null, v25, null, ComposableLambdaKt.rememberComposableLambda(0x93B0FFB0, true, new CarouselKt$Carousel$2(v1, v15_3, v10), v3, 54), v3, v5 & 0xE000 | v5 >> 3 & 0x70000 | v5 & 0x1C00000 | v5 & 0xE000000, 0x6000, 0x2E40);
                v3.endReplaceGroup();
            }
            else {
                v17 = v5;
                if(v6 == Orientation.Vertical) {
                    v3.startReplaceGroup(0x1066E3E5);
                    ComposerKt.sourceInformation(v3, "434@19985L7,435@20077L7,443@20422L24,444@20458L1024,429@19689L1793");
                    v2_2 = v1.getPagerState$material3();
                    ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v5_2 = v3.consume(((CompositionLocal)v5_1));
                    ComposerKt.sourceInformationMarkerEnd(v3);
                    float v26 = PaddingKt.calculateStartPadding(v8, ((LayoutDirection)v5_2));
                    v5_1 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v5_2 = v3.consume(((CompositionLocal)v5_1));
                    ComposerKt.sourceInformationMarkerEnd(v3);
                    PaddingValues v5_3 = PaddingKt.PaddingValues-a9UjIt4$default(v26, 0f, PaddingKt.calculateEndPadding(v8, ((LayoutDirection)v5_2)), 0f, 10, null);
                    ComposerKt.sourceInformationMarkerStart(v3, 0x110BE9A4, v0_3);
                    v0_4 = v3.rememberedValue();
                    if(v0_4 == Composer.Companion.getEmpty()) {
                        v0_6 = new CarouselKt$$ExternalSyntheticLambda4();
                        v3.updateRememberedValue(v0_6);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    PagerKt.VerticalPager--8jOkeI(v2_2, SemanticsModifierKt.semantics$default(((Modifier)v4_2), false, ((Function1)v0_6), 1, null), v5_3, v15_3, arg36, v18_1, null, v20_1, v21, false, null, null, v25, null, ComposableLambdaKt.rememberComposableLambda(0xC1DBAFF9, true, new CarouselKt$Carousel$4(v1, v15_3, v10), v3, 54), v3, v17 & 0xE000 | v17 >> 3 & 0x70000 | v17 & 0x1C00000 | v17 & 0xE000000, 0x6000, 0x2E40);
                    v3.endReplaceGroup();
                    goto label_399;
                }

                v3.startReplaceGroup(0x10816AB6);
                v3.endReplaceGroup();
            }

        label_399:
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v18_1;
            v8_1 = v20_1;
            v9_3 = v21;
        }
        else {
            v1 = arg32;
            v3.skipToGroupEnd();
            v9_3 = arg40;
            v8_1 = v13;
            v7_1 = v15_1;
        }

        ScopeUpdateScope v13_2 = v3.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new CarouselKt$$ExternalSyntheticLambda5(v1, v6, arg34, arg35, arg36, ((Modifier)v4_2), v7_1, v8_1, v9_3, v10, v11, v12));
        }
    }

    static final Unit Carousel_cJHQLPU$lambda$16$lambda$15(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getCarousel-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Carousel_cJHQLPU$lambda$18$lambda$17(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getCarousel-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Carousel_cJHQLPU$lambda$19(CarouselState arg14, Orientation arg15, Function2 arg16, PaddingValues arg17, int arg18, Modifier arg19, float arg20, TargetedFlingBehavior arg21, boolean arg22, Function4 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        CarouselKt.Carousel-cJHQLPU(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void HorizontalCenteredHeroCarousel-p2lB3Bg(CarouselState arg27, Modifier arg28, float arg29, float arg30, TargetedFlingBehavior arg31, boolean arg32, float arg33, float arg34, PaddingValues arg35, Function4 arg36, Composer arg37, int arg38, int arg39) {
        float v3_1;
        boolean v6_2;
        TargetedFlingBehavior v5_3;
        float v4_2;
        Modifier v2_3;
        Composer v10_2;
        PaddingValues v9_3;
        float v16_1;
        float v18_1;
        float v17_1;
        PaddingValues v4_1;
        int v10_1;
        TargetedFlingBehavior v7_1;
        float v6_1;
        float v0_2;
        Modifier v5_1;
        Companion v5_2;
        Companion v19_1;
        int v22;
        PaddingValues v2_2;
        int v21;
        float v2_1;
        float v7;
        int v16;
        boolean v15_1;
        int v12;
        TargetedFlingBehavior v11_1;
        float v10;
        int v9;
        float v8;
        int v5;
        Modifier v4;
        int v0;
        CarouselState v1 = arg27;
        int v13 = arg38;
        int v14 = arg39;
        Composer v3 = arg37.startRestartGroup(0x58FDD965);
        ComposerKt.sourceInformation(v3, "C(HorizontalCenteredHeroCarousel)N(state,modifier,maxItemWidth:c#ui.unit.Dp,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,minSmallItemWidth:c#ui.unit.Dp,maxSmallItemWidth:c#ui.unit.Dp,contentPadding,content)305@14133L7,309@14246L625,306@14145L1168:Carousel.kt#dcf9yb");
        if((v14 & 1) != 0) {
            v0 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v0 = v3.changedInstance(v1) ? 4 : 2;
            v0 |= v13;
        }
        else {
            v0 = v13;
        }

        int v2 = v14 & 2;
        if(v2 != 0) {
            v0 |= 0x30;
            goto label_36;
        }
        else if((v13 & 0x30) == 0) {
            v4 = arg28;
            v5 = v3.changed(v4) ? 0x20 : 16;
            v0 |= v5;
        }
        else {
        label_36:
            v4 = arg28;
        }

        v5 = v14 & 4;
        if(v5 != 0) {
            v0 |= 0x180;
            goto label_51;
        }
        else if((v13 & 0x180) == 0) {
            v8 = arg29;
            v9 = v3.changed(v8) ? 0x100 : 0x80;
            v0 |= v9;
        }
        else {
        label_51:
            v8 = arg29;
        }

        v9 = v14 & 8;
        if(v9 != 0) {
            v0 |= 0xC00;
            goto label_66;
        }
        else if((v13 & 0xC00) == 0) {
            v10 = arg30;
            int v11 = v3.changed(v10) ? 0x800 : 0x400;
            v0 |= v11;
        }
        else {
        label_66:
            v10 = arg30;
        }

        if((v13 & 0x6000) == 0) {
            if((v14 & 16) == 0) {
                v11_1 = arg31;
                if(v3.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v11_1 = arg31;
            label_77:
                v12 = 0x2000;
            }

            v0 |= v12;
        }
        else {
            v11_1 = arg31;
        }

        v12 = v14 & 0x20;
        int v15 = 0x30000;
        if(v12 != 0) {
            v0 |= v15;
            goto label_96;
        }
        else if((v15 & v13) == 0) {
            v15_1 = arg32;
            v16 = v3.changed(v15_1) ? 0x20000 : 0x10000;
            v0 |= v16;
        }
        else {
        label_96:
            v15_1 = arg32;
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v0 |= v17;
            v7 = arg33;
        }
        else {
            v7 = arg33;
            if((v13 & v17) == 0) {
                int v18 = v3.changed(v7) ? 0x100000 : 0x80000;
                v0 |= v18;
            }
        }

        int v6 = v14 & 0x80;
        int v19 = v2;
        int v20 = 0xC00000;
        if(v6 != 0) {
            v0 |= v20;
        }
        else {
            v2_1 = arg34;
            if((v13 & v20) == 0) {
                v21 = v3.changed(v2_1) ? 0x800000 : 0x400000;
                v0 |= v21;
            }
        }

        v2 = v14 & 0x100;
        v21 = 0x6000000;
        if(v2 != 0) {
            v0 |= v21;
            goto label_144;
        }
        else if((v13 & v21) == 0) {
            v21 = v2;
            v2_2 = arg35;
            v22 = v3.changed(v2_2) ? 0x4000000 : 0x2000000;
            v0 |= v22;
        }
        else {
        label_144:
            v21 = v2;
            v2_2 = arg35;
        }

        v22 = v0;
        int v23 = 0x30000000;
        if((v14 & 0x200) != 0) {
            v22 |= v23;
        }
        else if((v13 & v23) == 0) {
            v23 = v3.changedInstance(arg36) ? 0x20000000 : 0x10000000;
            v22 |= v23;
        }

        v23 = 0;
        boolean v0_1 = (v22 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v0_1, v22 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "298@13764L41");
            int v25 = 0xFFFF1FFF;
            if((v13 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v19 != 0) {
                    v19_1 = Modifier.Companion;
                }
                else {
                    Modifier v19_2 = v4;
                }

                if(v5 != 0) {
                    v8 = Dp.Companion.getUnspecified-D9Ej5fM();
                }

                if(v9 != 0) {
                    v10 = Dp.constructor-impl(0f);
                }

                if((v14 & 16) != 0) {
                    v1 = arg27;
                    TargetedFlingBehavior v0_3 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(v1, null, v3, v22 & 14 | 0x180, 2);
                    v22 &= v25;
                    v11_1 = v0_3;
                }
                else {
                    v1 = arg27;
                }

                if(v12 != 0) {
                    v15_1 = true;
                }

                if(v16 != 0) {
                    v7 = CarouselDefaults.INSTANCE.getMinSmallItemSize-D9Ej5fM();
                }

                v0_2 = v6 != 0 ? CarouselDefaults.INSTANCE.getMaxSmallItemSize-D9Ej5fM() : arg34;
                if(v21 != 0) {
                    v4_1 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                    v6_1 = v10;
                    v5_2 = v19_1;
                    v10_1 = v22;
                    v2_1 = v0_2;
                    v0_2 = v7;
                    v7_1 = v11_1;
                    goto label_256;
                }

                v4_1 = arg35;
                v2_1 = v0_2;
                v0_2 = v7;
                v6_1 = v10;
                v7_1 = v11_1;
                v5_2 = v19_1;
                v10_1 = v22;
            }
            else {
                v3.skipToGroupEnd();
                if((v14 & 16) != 0) {
                    v22 &= v25;
                }

                v1 = arg27;
                v5_1 = v4;
                v0_2 = v7;
                v6_1 = v10;
                v7_1 = v11_1;
                v10_1 = v22;
                v4_1 = v2_2;
                v2_1 = arg34;
            }

        label_256:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x58FDD965, v10_1, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:304)");
            }

            ProvidableCompositionLocal v9_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v9_2 = v3.consume(((CompositionLocal)v9_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            Orientation v11_2 = Orientation.Horizontal;
            float v32 = v0_2;
            ComposerKt.sourceInformationMarkerStart(v3, 0x10ED7496, "CC(remember):Carousel.kt#9igjgp");
            boolean v28 = v3.changed(v9_2);
            v0 = (v10_1 & 0x380) == 0x100 ? 1 : 0;
            int v28_1 = (((int)v28)) | v0 | v3.changedInstance(v1);
            v0 = (0x380000 & v10_1) == 0x100000 ? 1 : 0;
            v28_1 |= v0;
            if((0x1C00000 & v10_1) == 0x800000) {
                v23 = 1;
            }

            Object v12_1 = v3.rememberedValue();
            if((v28_1 | v23) != 0 || v12_1 == Composer.Companion.getEmpty()) {
                CarouselKt$$ExternalSyntheticLambda11 v12_2 = new CarouselKt$$ExternalSyntheticLambda11(v9_2, v8, v1, v32, v2_1);
                v16_1 = v8;
                v17_1 = v32;
                v18_1 = v2_1;
                v3.updateRememberedValue(v12_2);
            }
            else {
                v17_1 = v32;
                v18_1 = v2_1;
                v16_1 = v8;
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            int v1_1 = v10_1 << 9;
            boolean v8_1 = v15_1;
            CarouselKt.Carousel-cJHQLPU(arg27, v11_2, v12_1, v4_1, 2, v5_1, v6_1, v7_1, v8_1, arg36, v3, v10_1 & 14 | 0x6030 | v10_1 >> 15 & 0x1C00 | v10_1 << 12 & 0x70000 | 0x380000 & v1_1 | 0x1C00000 & v1_1 | v1_1 & 0xE000000 | 0x70000000 & v10_1, 0);
            v2_2 = v4_1;
            v3 = v3;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_3 = v2_2;
            v10_2 = v3;
            v2_3 = v5_1;
            v4_2 = v6_1;
            v5_3 = v7_1;
            v6_2 = v8_1;
            v3_1 = v16_1;
            v7 = v17_1;
            v8 = v18_1;
        }
        else {
            v3.skipToGroupEnd();
            v9_3 = arg35;
            v2_3 = v4;
            v4_2 = v10;
            v5_3 = v11_1;
            v6_2 = v15_1;
            v10_2 = v3;
            v3_1 = v8;
            v8 = arg34;
        }

        ScopeUpdateScope v15_2 = v10_2.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new CarouselKt$$ExternalSyntheticLambda12(arg27, v2_3, v3_1, v4_2, v5_3, v6_2, v7, v8, v9_3, arg36, v13, v14));
        }
    }

    static final KeylineList HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$12$lambda$11(Density arg8, float arg9, CarouselState arg10, float arg11, float arg12, float arg13, float arg14) {
        Float v9 = !Float.isNaN(arg9) ? Float.valueOf(arg8.toPx-0680j_4(arg9)) : null;
        return KeylinesKt.heroKeylineList(arg8, arg13, v9, arg14, arg10.getPagerState$material3().getPageCountState().getValue().invoke().intValue(), true, arg8.toPx-0680j_4(arg11), arg8.toPx-0680j_4(arg12));
    }

    static final Unit HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$13(CarouselState arg14, Modifier arg15, float arg16, float arg17, TargetedFlingBehavior arg18, boolean arg19, float arg20, float arg21, PaddingValues arg22, Function4 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        CarouselKt.HorizontalCenteredHeroCarousel-p2lB3Bg(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void HorizontalMultiBrowseCarousel-3tcCNu0(CarouselState arg26, float arg27, Modifier arg28, float arg29, TargetedFlingBehavior arg30, boolean arg31, float arg32, float arg33, PaddingValues arg34, Function4 arg35, Composer arg36, int arg37, int arg38) {
        TargetedFlingBehavior v5_3;
        float v17_1;
        float v16_1;
        CarouselKt$$ExternalSyntheticLambda15 v15_2;
        PaddingValues v9_1;
        float v4_1;
        boolean v8_1;
        float v6_1;
        Modifier v5_1;
        TargetedFlingBehavior v7_1;
        Companion v5_2;
        Companion v18_1;
        int v21;
        PaddingValues v2_2;
        int v20;
        float v2_1;
        float v7;
        int v15;
        boolean v12_1;
        int v11;
        TargetedFlingBehavior v10_1;
        int v10;
        float v9;
        int v5;
        Modifier v4;
        int v2;
        int v0;
        CarouselState v1 = arg26;
        int v13 = arg37;
        int v14 = arg38;
        Composer v3 = arg36.startRestartGroup(-221490402);
        ComposerKt.sourceInformation(v3, "C(HorizontalMultiBrowseCarousel)N(state,preferredItemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,minSmallItemWidth:c#ui.unit.Dp,maxSmallItemWidth:c#ui.unit.Dp,contentPadding,content)121@6176L7,125@6289L565,122@6188L1107:Carousel.kt#dcf9yb");
        if((v14 & 1) != 0) {
            v0 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v0 = v3.changedInstance(v1) ? 4 : 2;
            v0 |= v13;
        }
        else {
            v0 = v13;
        }

        if((v14 & 2) != 0) {
            v0 |= 0x30;
        }
        else {
            float v8 = arg27;
            if((v13 & 0x30) == 0) {
                v2 = v3.changed(v8) ? 0x20 : 16;
                v0 |= v2;
            }
        }

        v2 = v14 & 4;
        if(v2 != 0) {
            v0 |= 0x180;
            goto label_50;
        }
        else if((v13 & 0x180) == 0) {
            v4 = arg28;
            v5 = v3.changed(v4) ? 0x100 : 0x80;
            v0 |= v5;
        }
        else {
        label_50:
            v4 = arg28;
        }

        v5 = v14 & 8;
        if(v5 != 0) {
            v0 |= 0xC00;
            goto label_65;
        }
        else if((v13 & 0xC00) == 0) {
            v9 = arg29;
            v10 = v3.changed(v9) ? 0x800 : 0x400;
            v0 |= v10;
        }
        else {
        label_65:
            v9 = arg29;
        }

        if((v13 & 0x6000) == 0) {
            if((v14 & 16) == 0) {
                v10_1 = arg30;
                if(v3.changed(v10_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v10_1 = arg30;
            label_76:
                v11 = 0x2000;
            }

            v0 |= v11;
        }
        else {
            v10_1 = arg30;
        }

        v11 = v14 & 0x20;
        int v12 = 0x30000;
        if(v11 != 0) {
            v0 |= v12;
            goto label_95;
        }
        else if((v12 & v13) == 0) {
            v12_1 = arg31;
            v15 = v3.changed(v12_1) ? 0x20000 : 0x10000;
            v0 |= v15;
        }
        else {
        label_95:
            v12_1 = arg31;
        }

        v15 = v14 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v0 |= v16;
            v7 = arg32;
        }
        else {
            v7 = arg32;
            if((v13 & v16) == 0) {
                int v17 = v3.changed(v7) ? 0x100000 : 0x80000;
                v0 |= v17;
            }
        }

        int v6 = v14 & 0x80;
        int v18 = v2;
        int v19 = 0xC00000;
        if(v6 != 0) {
            v0 |= v19;
        }
        else {
            v2_1 = arg33;
            if((v13 & v19) == 0) {
                v20 = v3.changed(v2_1) ? 0x800000 : 0x400000;
                v0 |= v20;
            }
        }

        v2 = v14 & 0x100;
        v20 = 0x6000000;
        if(v2 != 0) {
            v0 |= v20;
            goto label_143;
        }
        else if((v13 & v20) == 0) {
            v20 = v2;
            v2_2 = arg34;
            v21 = v3.changed(v2_2) ? 0x4000000 : 0x2000000;
            v0 |= v21;
        }
        else {
        label_143:
            v20 = v2;
            v2_2 = arg34;
        }

        v21 = v0;
        int v22 = 0x30000000;
        if((v14 & 0x200) != 0) {
            v21 |= v22;
        }
        else if((v13 & v22) == 0) {
            v22 = v3.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v21 |= v22;
        }

        v22 = 0;
        boolean v0_1 = (v21 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v0_1, v21 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "114@5807L41");
            int v24 = 0xFFFF1FFF;
            if((v13 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v18 != 0) {
                    v18_1 = Modifier.Companion;
                }
                else {
                    Modifier v18_2 = v4;
                }

                if(v5 != 0) {
                    v9 = Dp.constructor-impl(0f);
                }

                if((v14 & 16) != 0) {
                    v1 = arg26;
                    TargetedFlingBehavior v0_2 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(v1, null, v3, v21 & 14 | 0x180, 2);
                    v21 &= v24;
                    v10_1 = v0_2;
                }
                else {
                    v1 = arg26;
                }

                if(v11 != 0) {
                    v12_1 = true;
                }

                if(v15 != 0) {
                    v7 = CarouselDefaults.INSTANCE.getMinSmallItemSize-D9Ej5fM();
                }

                v2_1 = v6 != 0 ? CarouselDefaults.INSTANCE.getMaxSmallItemSize-D9Ej5fM() : arg33;
                if(v20 != 0) {
                    v6_1 = v9;
                    v8_1 = v12_1;
                    v5_2 = v18_1;
                    v9_1 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                    v4_1 = v2_1;
                label_195:
                    v2_1 = v7;
                    v7_1 = v10_1;
                    v10 = v21;
                    goto label_252;
                }

                v4_1 = v2_1;
                v2_1 = v7;
                v6_1 = v9;
                v7_1 = v10_1;
                v8_1 = v12_1;
                v5_2 = v18_1;
                v10 = v21;
                v9_1 = arg34;
            }
            else {
                v3.skipToGroupEnd();
                if((v14 & 16) != 0) {
                    v21 &= v24;
                }

                v1 = arg26;
                v5_1 = v4;
                v6_1 = v9;
                v8_1 = v12_1;
                v4_1 = arg33;
                v9_1 = v2_2;
                goto label_195;
            }

        label_252:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-221490402, v10, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
            }

            ProvidableCompositionLocal v11_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v11_2 = v3.consume(((CompositionLocal)v11_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            Orientation v12_2 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(v3, 0x71046253, "CC(remember):Carousel.kt#9igjgp");
            boolean v28 = v3.changed(v11_2);
            v0 = (v10 & 0x70) == 0x20 ? 1 : 0;
            int v28_1 = (((int)v28)) | v0 | v3.changedInstance(v1);
            v0 = (0x380000 & v10) == 0x100000 ? 1 : 0;
            v28_1 |= v0;
            if((0x1C00000 & v10) == 0x800000) {
                v22 = 1;
            }

            Object v15_1 = v3.rememberedValue();
            if((v28_1 | v22) != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new CarouselKt$$ExternalSyntheticLambda15(v11_2, arg27, v1, v2_1, v4_1);
                v16_1 = v2_1;
                v17_1 = v4_1;
                v3.updateRememberedValue(v15_2);
            }
            else {
                v16_1 = v2_1;
                v17_1 = v4_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            int v1_1 = v10 << 9;
            CarouselKt.Carousel-cJHQLPU(arg26, v12_2, v15_2, v9_1, 2, v5_1, v6_1, v7_1, v8_1, arg35, v3, v10 & 14 | 0x6030 | v10 >> 15 & 0x1C00 | 0x70000 & v1_1 | 0x380000 & v1_1 | 0x1C00000 & v1_1 | v1_1 & 0xE000000 | 0x70000000 & v10, 0);
            v2_2 = v9_1;
            v3 = v3;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v2_2;
            v4 = v5_1;
            v5_3 = v7_1;
            v7 = v16_1;
        }
        else {
            v3.skipToGroupEnd();
            v17_1 = arg33;
            v6_1 = v9;
            v5_3 = v10_1;
            v8_1 = v12_1;
            v9_1 = arg34;
        }

        ScopeUpdateScope v15_3 = v3.endRestartGroup();
        if(v15_3 != null) {
            v15_3.updateScope(new CarouselKt$$ExternalSyntheticLambda1(arg26, arg27, v4, v6_1, v5_3, v8_1, v7, v17_1, v9_1, arg35, v13, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Kept for binary compatibility") public static final void HorizontalMultiBrowseCarousel-zCIJ0Nk(CarouselState arg25, float arg26, Modifier arg27, float arg28, TargetedFlingBehavior arg29, float arg30, float arg31, PaddingValues arg32, Function4 arg33, Composer arg34, int arg35, int arg36) {
        PaddingValues v8_1;
        float v7_2;
        TargetedFlingBehavior v5_1;
        float v4_1;
        Modifier v3_1;
        Composer v22;
        Modifier v14_1;
        float v18_1;
        float v19_1;
        TargetedFlingBehavior v16_1;
        float v15_1;
        PaddingValues v20;
        Companion v14_2;
        Modifier v0_3;
        PaddingValues v3;
        float v9_1;
        int v34;
        int v15;
        float v14;
        int v8;
        TargetedFlingBehavior v7_1;
        float v6;
        int v5;
        int v2;
        float v13;
        CarouselState v12;
        int v1;
        int v10 = arg35;
        int v11 = arg36;
        Composer v4 = arg34.startRestartGroup(0xF8EE52C2);
        ComposerKt.sourceInformation(v4, "C(HorizontalMultiBrowseCarousel)N(state,preferredItemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,minSmallItemWidth:c#ui.unit.Dp,maxSmallItemWidth:c#ui.unit.Dp,contentPadding,content)165@7948L407:Carousel.kt#dcf9yb");
        if((v11 & 1) != 0) {
            v1 = v10 | 6;
            v12 = arg25;
        }
        else {
            v12 = arg25;
            if((v10 & 6) == 0) {
                v1 = v4.changedInstance(v12) ? 4 : 2;
                v1 |= v10;
            }
            else {
                v1 = v10;
            }
        }

        if((v11 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v10 & 0x30) == 0) {
                v2 = v4.changed(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v11 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v5 = v4.changed(arg27) ? 0x100 : 0x80;
            v1 |= v5;
        }

        v5 = v11 & 8;
        if(v5 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v10 & 0xC00) == 0) {
            v6 = arg28;
            int v7 = v4.changed(v6) ? 0x800 : 0x400;
            v1 |= v7;
        }
        else {
        label_66:
            v6 = arg28;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v7_1 = arg29;
                if(v4.changed(v7_1)) {
                    v8 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v7_1 = arg29;
            label_77:
                v8 = 0x2000;
            }

            v1 |= v8;
        }
        else {
            v7_1 = arg29;
        }

        v8 = v11 & 0x20;
        int v9 = 0x30000;
        if(v8 != 0) {
            v1 |= v9;
            goto label_96;
        }
        else if((v10 & v9) == 0) {
            v14 = arg30;
            v15 = v4.changed(v14) ? 0x20000 : 0x10000;
            v1 |= v15;
        }
        else {
        label_96:
            v14 = arg30;
        }

        v15 = v11 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v1 |= v16;
            v34 = v9;
            v9_1 = arg31;
        }
        else {
            v34 = v9;
            v9_1 = arg31;
            if((v10 & v16) == 0) {
                v16 = v4.changed(v9_1) ? 0x100000 : 0x80000;
                v1 |= v16;
            }
        }

        int v0 = v11 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v1 |= v17;
            v3 = arg32;
        }
        else {
            v3 = arg32;
            if((v10 & v17) == 0) {
                v17 = v4.changed(v3) ? 0x800000 : 0x400000;
                v1 |= v17;
            }
        }

        v17 = v0;
        int v18 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v1 |= v18;
        }
        else if((v10 & v18) == 0) {
            v18 = v4.changedInstance(arg33) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }

        v18 = v1;
        boolean v0_1 = (v18 & 0x2492493) != 0x2492492 ? true : false;
        if(v4.shouldExecute(v0_1, v18 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "159@7645L41");
            int v19 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v2 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = arg27;
                }

                float v21 = v5 != 0 ? Dp.constructor-impl(0f) : v6;
                if((v11 & 16) != 0) {
                    TargetedFlingBehavior v1_1 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(v12, null, v4, v18 & 14 | 0x180, 2);
                    v18 &= v19;
                    v7_1 = v1_1;
                }

                if(v8 != 0) {
                    v14 = CarouselDefaults.INSTANCE.getMinSmallItemSize-D9Ej5fM();
                }

                if(v15 != 0) {
                    v9_1 = CarouselDefaults.INSTANCE.getMaxSmallItemSize-D9Ej5fM();
                }

                if(v17 != 0) {
                    v15_1 = v14;
                    v14_2 = ((Companion)v0_3);
                    v0 = v18;
                    v18_1 = v15_1;
                    v20 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                }
                else {
                    float v1_2 = v14;
                    v14_2 = ((Companion)v0_3);
                    v0 = v18;
                    v18_1 = v1_2;
                    v20 = arg32;
                }

                v16_1 = v7_1;
                v19_1 = v9_1;
                v15_1 = v21;
                v1 = 0xF8EE52C2;
            }
            else {
                v4.skipToGroupEnd();
                if((v11 & 16) != 0) {
                    v18 &= v19;
                }

                v20 = v3;
                v15_1 = v6;
                v16_1 = v7_1;
                v19_1 = v9_1;
                v0 = v18;
                v1 = 0xF8EE52C2;
                v18_1 = v14;
                v14_1 = arg27;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v0, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:165)");
            }

            v1 = v0 & 14 | v34 | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0;
            v0 <<= 3;
            CarouselKt.HorizontalMultiBrowseCarousel-3tcCNu0(arg25, v13, v14_1, v15_1, v16_1, true, v18_1, v19_1, v20, arg33, v4, v1 | 0x380000 & v0 | 0x1C00000 & v0 | 0xE000000 & v0 | v0 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v22 = v4;
            v3_1 = v14_1;
            v4_1 = v15_1;
            v5_1 = v16_1;
            v6 = v18_1;
            v7_2 = v19_1;
            v8_1 = v20;
        }
        else {
            v4.skipToGroupEnd();
            v3_1 = arg27;
            v8_1 = arg32;
            v22 = v4;
            v4_1 = v6;
            v5_1 = v7_1;
            v7_2 = v9_1;
            v6 = v14;
        }

        ScopeUpdateScope v12_1 = v22.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new CarouselKt$$ExternalSyntheticLambda6(arg25, arg26, v3_1, v4_1, v5_1, v6, v7_2, v8_1, arg33, v10, v11));
        }
    }

    static final KeylineList HorizontalMultiBrowseCarousel_3tcCNu0$lambda$2$lambda$1(Density arg1, float arg2, CarouselState arg3, float arg4, float arg5, float arg6, float arg7) {
        return KeylinesKt.multiBrowseKeylineList(arg1, arg6, arg1.toPx-0680j_4(arg2), arg7, arg3.getPagerState$material3().getPageCountState().getValue().invoke().intValue(), arg1.toPx-0680j_4(arg4), arg1.toPx-0680j_4(arg5));
    }

    static final Unit HorizontalMultiBrowseCarousel_3tcCNu0$lambda$3(CarouselState arg14, float arg15, Modifier arg16, float arg17, TargetedFlingBehavior arg18, boolean arg19, float arg20, float arg21, PaddingValues arg22, Function4 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        CarouselKt.HorizontalMultiBrowseCarousel-3tcCNu0(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalMultiBrowseCarousel_zCIJ0Nk$lambda$4(CarouselState arg13, float arg14, Modifier arg15, float arg16, TargetedFlingBehavior arg17, float arg18, float arg19, PaddingValues arg20, Function4 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        CarouselKt.HorizontalMultiBrowseCarousel-zCIJ0Nk(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Kept for binary compatibility") public static final void HorizontalUncontainedCarousel-9QcgTRs(CarouselState arg20, float arg21, Modifier arg22, float arg23, TargetedFlingBehavior arg24, PaddingValues arg25, Function4 arg26, Composer arg27, int arg28, int arg29) {
        PaddingValues v6_1;
        TargetedFlingBehavior v5_1;
        float v4_1;
        Composer v17;
        Modifier v11_1;
        float v12_2;
        PaddingValues v15_1;
        Companion v11_2;
        Modifier v3_2;
        PaddingValues v13;
        int v11;
        TargetedFlingBehavior v7_1;
        float v6;
        int v5;
        Modifier v4;
        int v3;
        float v10;
        CarouselState v9;
        int v2;
        int v8 = arg28;
        int v0 = 0x87F6124B;
        Composer v1 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(HorizontalUncontainedCarousel)N(state,itemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,contentPadding,content)256@11720L295:Carousel.kt#dcf9yb");
        if((arg29 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg20;
        }
        else {
            v9 = arg20;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        if((arg29 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg21;
        }
        else {
            v10 = arg21;
            if((v8 & 0x30) == 0) {
                v3 = v1.changed(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg29 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg22;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_50:
            v4 = arg22;
        }

        v5 = arg29 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_65;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg23;
            int v7 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_65:
            v6 = arg23;
        }

        if((v8 & 0x6000) == 0) {
            if((arg29 & 16) == 0) {
                v7_1 = arg24;
                if(v1.changed(v7_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v7_1 = arg24;
            label_76:
                v11 = 0x2000;
            }

            v2 |= v11;
        }
        else {
            v7_1 = arg24;
        }

        v11 = arg29 & 0x20;
        int v12 = 0x30000;
        if(v11 != 0) {
            v2 |= v12;
            goto label_95;
        }
        else if((v8 & v12) == 0) {
            v13 = arg25;
            int v14 = v1.changed(v13) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_95:
            v13 = arg25;
        }

        int v15 = 0x180000;
        if((arg29 & 0x40) != 0) {
            v2 |= v15;
        }
        else if((v8 & v15) == 0) {
            v15 = v1.changedInstance(arg26) ? 0x100000 : 0x80000;
            v2 |= v15;
        }

        int v27 = v12;
        boolean v12_1 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v12_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "252@11563L21");
            v15 = 0xFFFF1FFF;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v4;
                }

                if(v5 != 0) {
                    v6 = Dp.constructor-impl(0f);
                }

                if((arg29 & 16) != 0) {
                    v2 &= v15;
                    v7_1 = CarouselDefaults.INSTANCE.noSnapFlingBehavior(v1, 6);
                }

                if(v11 != 0) {
                    v11_2 = ((Companion)v3_2);
                    v15_1 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                    v12_2 = v6;
                    goto label_139;
                }

                v11_2 = ((Companion)v3_2);
            label_137:
                v12_2 = v6;
                v15_1 = v13;
            }
            else {
                v1.skipToGroupEnd();
                if((arg29 & 16) != 0) {
                    v2 &= v15;
                }

                v11_1 = v4;
                goto label_137;
            }

        label_139:
            TargetedFlingBehavior v13_1 = v7_1;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:256)");
            }

            v0 = v2 & 14 | v27 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2;
            v2 <<= 3;
            v17 = v1;
            CarouselKt.HorizontalUncontainedCarousel-VUP9l70(v9, v10, v11_1, v12_2, v13_1, true, v15_1, arg26, v17, v0 | 0x380000 & v2 | v2 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v11_1;
            v4_1 = v12_2;
            v5_1 = v13_1;
            v6_1 = v15_1;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v3_2 = v4;
            v4_1 = v6;
            v5_1 = v7_1;
            v6_1 = v13;
        }

        ScopeUpdateScope v10_1 = v17.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new CarouselKt$$ExternalSyntheticLambda7(arg20, arg21, v3_2, v4_1, v5_1, v6_1, arg26, v8, arg29));
        }
    }

    public static final void HorizontalUncontainedCarousel-VUP9l70(CarouselState arg24, float arg25, Modifier arg26, float arg27, TargetedFlingBehavior arg28, boolean arg29, PaddingValues arg30, Function4 arg31, Composer arg32, int arg33, int arg34) {
        boolean v6_2;
        TargetedFlingBehavior v5_3;
        float v4_3;
        Modifier v3_1;
        PaddingValues v7_1;
        Composer v21;
        float v17_1;
        int v0_1;
        TargetedFlingBehavior v18;
        PaddingValues v14_2;
        boolean v19;
        PaddingValues v5;
        int v15;
        boolean v14_1;
        int v13;
        TargetedFlingBehavior v12_1;
        float v8;
        int v7;
        Modifier v6;
        int v4;
        CarouselState v11;
        int v3;
        float v2 = arg25;
        int v9 = arg33;
        int v10 = arg34;
        Composer v1 = arg32.startRestartGroup(0x1FDDAEA7);
        ComposerKt.sourceInformation(v1, "C(HorizontalUncontainedCarousel)N(state,itemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,contentPadding,content)218@10352L7,222@10465L337,219@10364L866:Carousel.kt#dcf9yb");
        if((v10 & 1) != 0) {
            v3 = v9 | 6;
            v11 = arg24;
        }
        else {
            v11 = arg24;
            if((v9 & 6) == 0) {
                v3 = v1.changedInstance(v11) ? 4 : 2;
                v3 |= v9;
            }
            else {
                v3 = v9;
            }
        }

        if((v10 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v9 & 0x30) == 0) {
            v4 = v1.changed(v2) ? 0x20 : 16;
            v3 |= v4;
        }

        v4 = v10 & 4;
        if(v4 != 0) {
            v3 |= 0x180;
            goto label_50;
        }
        else if((v9 & 0x180) == 0) {
            v6 = arg26;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v3 |= v7;
        }
        else {
        label_50:
            v6 = arg26;
        }

        v7 = v10 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_65;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg27;
            int v12 = v1.changed(v8) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_65:
            v8 = arg27;
        }

        if((v9 & 0x6000) == 0) {
            if((v10 & 16) == 0) {
                v12_1 = arg28;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v12_1 = arg28;
            label_76:
                v13 = 0x2000;
            }

            v3 |= v13;
        }
        else {
            v12_1 = arg28;
        }

        v13 = v10 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v3 |= v14;
            goto label_95;
        }
        else if((v14 & v9) == 0) {
            v14_1 = arg29;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_95:
            v14_1 = arg29;
        }

        v15 = v10 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v3 |= v16;
            v5 = arg30;
        }
        else {
            v5 = arg30;
            if((v9 & v16) == 0) {
                v16 = v1.changed(v5) ? 0x100000 : 0x80000;
                v3 |= v16;
            }
        }

        int v17 = 0xC00000;
        if((v10 & 0x80) != 0) {
            v3 |= v17;
        }
        else if((v9 & v17) == 0) {
            v17 = v1.changedInstance(arg31) ? 0x800000 : 0x400000;
            v3 |= v17;
        }

        v17 = v3;
        boolean v0 = (v3 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v17 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "213@10129L21");
            int v20 = 0xFFFF1FFF;
            v3 = 6;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v8 = Dp.constructor-impl(0f);
                }

                if((v10 & 16) != 0) {
                    v7 = v17 & v20;
                    v12_1 = CarouselDefaults.INSTANCE.noSnapFlingBehavior(v1, v3);
                }
                else {
                    v7 = v17;
                }

                if(v13 != 0) {
                    v14_1 = true;
                }

                if(v15 != 0) {
                    v17_1 = v8;
                    v4 = 1;
                    v19 = v14_1;
                    v14_2 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                    v0_1 = 0;
                    v18 = v12_1;
                    goto label_193;
                }

            label_155:
                v17_1 = v8;
                v0_1 = 0;
                v4 = 1;
            label_163:
                v18 = v12_1;
                v19 = v14_1;
                v14_2 = v5;
            }
            else {
                v1.skipToGroupEnd();
                if((v10 & 16) != 0) {
                    v7 = v17 & v20;
                    goto label_155;
                }
                else {
                    v7 = v17;
                    v0_1 = 0;
                    v4 = 1;
                    v17_1 = v8;
                    goto label_163;
                }
            }

        label_193:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1FDDAEA7, v7, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:217)");
            }

            ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_2 = v1.consume(((CompositionLocal)v5_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            Orientation v12_2 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(v1, 0x9F2CEA58, "CC(remember):Carousel.kt#9igjgp");
            boolean v8_1 = v1.changed(v5_2);
            if((v7 & 0x70) == 0x20) {
                v0_1 = v4;
            }

            Object v4_1 = v1.rememberedValue();
            if((v0_1 | (((int)v8_1))) != 0 || v4_1 == Composer.Companion.getEmpty()) {
                CarouselKt$$ExternalSyntheticLambda8 v4_2 = new CarouselKt$$ExternalSyntheticLambda8(((Density)v5_2), v2);
                v1.updateRememberedValue(v4_2);
            }

            Object v13_1 = v4_1;
            ComposerKt.sourceInformationMarkerEnd(v1);
            v4 = v7 << 9;
            v21 = v1;
            Modifier v16_1 = v6;
            CarouselKt.Carousel-cJHQLPU(v11, v12_2, ((Function2)v13_1), v14_2, 0, v16_1, v17_1, v18, v19, arg31, v21, v7 & 14 | 0x6030 | v7 >> 9 & 0x1C00 | 0x70000 & v4 | 0x380000 & v4 | 0x1C00000 & v4 | v4 & 0xE000000 | v7 << 6 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v14_2;
            v3_1 = v16_1;
            v4_3 = v17_1;
            v5_3 = v18;
            v6_2 = v19;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v7_1 = v5;
            v3_1 = v6;
            v4_3 = v8;
            v5_3 = v12_1;
            v6_2 = v14_1;
        }

        ScopeUpdateScope v11_1 = v21.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new CarouselKt$$ExternalSyntheticLambda9(arg24, v2, v3_1, v4_3, v5_3, v6_2, v7_1, arg31, v9, v10));
        }
    }

    static final Unit HorizontalUncontainedCarousel_9QcgTRs$lambda$9(CarouselState arg11, float arg12, Modifier arg13, float arg14, TargetedFlingBehavior arg15, PaddingValues arg16, Function4 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        CarouselKt.HorizontalUncontainedCarousel-9QcgTRs(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final KeylineList HorizontalUncontainedCarousel_VUP9l70$lambda$7$lambda$6(Density arg0, float arg1, float arg2, float arg3) {
        return KeylinesKt.uncontainedKeylineList(arg0, arg2, arg0.toPx-0680j_4(arg1), arg3);
    }

    static final Unit HorizontalUncontainedCarousel_VUP9l70$lambda$8(CarouselState arg12, float arg13, Modifier arg14, float arg15, TargetedFlingBehavior arg16, boolean arg17, PaddingValues arg18, Function4 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        CarouselKt.HorizontalUncontainedCarousel-VUP9l70(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final float calculateAfterContentPadding(PaddingValues arg3, Orientation arg4, Composer arg5, int arg6) {
        Object v4_1;
        ProvidableCompositionLocal v4;
        float v3;
        int v1 = 0x3CB506D0;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(calculateAfterContentPadding)N(orientation)496@22177L7:Carousel.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:488)");
        }

        String v0 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        v1 = 0x789C5F52;
        if(arg4 == Orientation.Vertical) {
            arg5.startReplaceGroup(-1907991582);
            arg5.endReplaceGroup();
            v3 = arg3.calculateBottomPadding-D9Ej5fM();
        }
        else {
            arg5.startReplaceGroup(0x8E473029);
            ComposerKt.sourceInformation(arg5, "493@22128L7");
            v4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(arg5, v1, v0);
            v4_1 = arg5.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg5);
            v3 = PaddingKt.calculateEndPadding(arg3, ((LayoutDirection)v4_1));
            arg5.endReplaceGroup();
        }

        v4 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg5, v1, v0);
        v4_1 = arg5.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        v3 = ((Density)v4_1).toPx-0680j_4(v3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    private static final float calculateBeforeContentPadding(PaddingValues arg3, Orientation arg4, Composer arg5, int arg6) {
        Object v4_1;
        ProvidableCompositionLocal v4;
        float v3;
        int v1 = 0x710F78B3;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(calculateBeforeContentPadding)N(orientation)484@21819L7:Carousel.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:476)");
        }

        String v0 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        v1 = 0x789C5F52;
        if(arg4 == Orientation.Vertical) {
            arg5.startReplaceGroup(0xF7717EA2);
            arg5.endReplaceGroup();
            v3 = arg3.calculateTopPadding-D9Ej5fM();
        }
        else {
            arg5.startReplaceGroup(-143505436);
            ComposerKt.sourceInformation(arg5, "481@21770L7");
            v4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(arg5, v1, v0);
            v4_1 = arg5.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg5);
            v3 = PaddingKt.calculateStartPadding(arg3, ((LayoutDirection)v4_1));
            arg5.endReplaceGroup();
        }

        v4 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg5, v1, v0);
        v4_1 = arg5.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        v3 = ((Density)v4_1).toPx-0680j_4(v3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    public static final float calculateCurrentScrollOffset(CarouselState arg3, Strategy arg4) {
        float v0 = arg4.getItemMainAxisSize() + arg4.getItemSpacing();
        return (((float)arg3.getPagerState$material3().getCurrentPage())) * v0 + arg3.getPagerState$material3().getCurrentPageOffsetFraction() * v0 - (((float)KeylineSnapPositionKt.getSnapPositionOffset(arg4, arg3.getPagerState$material3().getCurrentPage(), arg3.getPagerState$material3().getPageCount())));
    }

    public static final float calculateMaxScrollOffset(CarouselState arg3, Strategy arg4) {
        float v3 = ((float)arg3.getPagerState$material3().getPageCount());
        return RangesKt.coerceAtLeast(arg4.getItemMainAxisSize() * v3 + arg4.getItemSpacing() * (v3 - 1f) - arg4.getAvailableSpace(), 0f);
    }

    public static final Modifier carouselItem(Modifier arg6, int arg7, CarouselState arg8, Function0 arg9, CarouselItemDrawInfoImpl arg10, Shape arg11) {
        return LayoutModifierKt.layout(arg6, new CarouselKt$$ExternalSyntheticLambda10(arg9, arg8, arg7, arg10, arg11));
    }

    static final MeasureResult carouselItem$lambda$26(Function0 arg16, CarouselState arg17, int arg18, CarouselItemDrawInfoImpl arg19, Shape arg20, MeasureScope arg21, Measurable arg22, Constraints arg23) {
        int v5 = arg18;
        Object v4 = arg16.invoke();
        if(!((Strategy)v4).isValid()) {
            return MeasureScope.layout$default(arg21, 0, 0, null, new CarouselKt$$ExternalSyntheticLambda13(), 4, null);
        }

        boolean v6 = arg17.getPagerState$material3().getLayoutInfo().getOrientation() == Orientation.Vertical ? true : false;
        boolean v9 = arg21.getLayoutDirection() == LayoutDirection.Rtl ? true : false;
        float v0 = ((Strategy)v4).getItemMainAxisSize();
        long v0_1 = v6 ? Constraints.copy-Zbe2FdA(arg23.unbox-impl(), Constraints.getMinWidth-impl(arg23.unbox-impl()), Constraints.getMaxWidth-impl(arg23.unbox-impl()), MathKt.roundToInt(v0), MathKt.roundToInt(v0)) : Constraints.copy-Zbe2FdA(arg23.unbox-impl(), MathKt.roundToInt(v0), MathKt.roundToInt(v0), Constraints.getMinHeight-impl(arg23.unbox-impl()), Constraints.getMaxHeight-impl(arg23.unbox-impl()));
        Placeable v1 = arg22.measure-BRTryo0(v0_1);
        float v2 = 1f;
        if(v5 == arg17.getPagerState$material3().getCurrentPage()) {
        }
        else if(v5 == 0) {
            v2 = 0f;
        }
        else {
            v2 /= ((float)v5);
        }

        return MeasureScope.layout$default(arg21, v1.getWidth(), v1.getHeight(), null, new CarouselKt$$ExternalSyntheticLambda14(v1, v2, arg17, ((Strategy)v4), v5, v6, arg19, arg20, v9), 4, null);
    }

    static final Unit carouselItem$lambda$26$lambda$22(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit carouselItem$lambda$26$lambda$25(Placeable arg8, float arg9, CarouselState arg10, Strategy arg11, int arg12, boolean arg13, CarouselItemDrawInfoImpl arg14, Shape arg15, boolean arg16, PlacementScope arg17) {
        arg17.placeWithLayer(arg8, 0, 0, arg9, new CarouselKt$$ExternalSyntheticLambda0(arg10, arg11, arg12, arg13, arg14, arg15, arg16));
        return Unit.INSTANCE;
    }

    static final Unit carouselItem$lambda$26$lambda$25$lambda$24(CarouselState arg16, Strategy arg17, int arg18, boolean arg19, CarouselItemDrawInfoImpl arg20, Shape arg21, boolean arg22, GraphicsLayerScope arg23) {
        CarouselItemDrawInfoImpl v0 = arg20;
        GraphicsLayerScope v1 = arg23;
        float v3 = CarouselKt.calculateCurrentScrollOffset(arg16, arg17);
        float v4 = CarouselKt.calculateMaxScrollOffset(arg16, arg17);
        KeylineList v5 = Strategy.getKeylineListForScrollOffset$material3$default(arg17, v3, v4, false, 4, null);
        Strategy v6 = arg17;
        KeylineList v4_1 = v6.getKeylineListForScrollOffset$material3(v3, v4, true);
        float v9 = 2f;
        float v8 = (((float)arg18)) * (v6.getItemMainAxisSize() + v6.getItemSpacing()) + v6.getItemMainAxisSize() / v9 - v3;
        Keyline v3_1 = v5.getKeylineBefore(v8);
        Keyline v5_1 = v5.getKeylineAfter(v8);
        Keyline v7 = KeylineListKt.lerp(v3_1, v5_1, CarouselKt.getProgress(v3_1, v5_1, v8));
        boolean v3_2 = Intrinsics.areEqual(v3_1, v5_1);
        long v10 = 0xFFFFFFFFL;
        float v5_2 = arg19 ? Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v10))) : v6.getItemMainAxisSize();
        v5_2 /= v9;
        float v6_1 = arg19 ? v6.getItemMainAxisSize() : Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v10)));
        v6_1 /= v9;
        int v12 = 0x20;
        float v13 = arg19 ? Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v12))) : v7.getSize();
        v13 /= v9;
        float v14 = arg19 ? v7.getSize() : Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v10)));
        v14 /= v9;
        Rect v9_1 = new Rect(v5_2 - v13, v6_1 - v14, v5_2 + v13, v6_1 + v14);
        v0.setSizeState(v7.getSize());
        Iterator v2 = v4_1.iterator();
        if(v2.hasNext()) {
            Object v5_3 = v2.next();
            if(!v2.hasNext()) {
            }
            else {
                v6_1 = v5_3.getSize();
                do {
                    Object v13_1 = v2.next();
                    v14 = v13_1.getSize();
                    if(Float.compare(v6_1, v14) > 0) {
                        v5_3 = v13_1;
                        v6_1 = v14;
                    }

                    if(v2.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }

            v0.setMinSizeState(((Keyline)v5_3).getSize());
            v0.setMaxSizeState(v4_1.getFirstFocal().getSize());
            v0.setMaskRectState(v9_1);
            v1.setClip(Intrinsics.areEqual(v9_1, new Rect(0f, 0f, Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v12))), Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v10))))) ^ 1);
            v1.setShape(arg21);
            float v0_1 = v7.getOffset() - v8;
            if(v3_2) {
                v0_1 += (v8 - v7.getUnadjustedOffset()) / v7.getSize();
            }

            if(arg19) {
                v1.setTranslationY(v0_1);
            }
            else {
                if(arg22) {
                    v0_1 = -v0_1;
                }

                v1.setTranslationX(v0_1);
            }

            return Unit.INSTANCE;
        }

        throw new NoSuchElementException();
    }

    private static final Modifier drawDebugLines-1Yev-eo(Modifier arg6, CarouselState arg7, CarouselPageSize arg8, long arg9, float arg11) {
        return DrawModifierKt.drawWithContent(arg6, new CarouselKt$$ExternalSyntheticLambda2(arg8, arg7, arg11, arg9));
    }

    static Modifier drawDebugLines-1Yev-eo$default(Modifier arg6, CarouselState arg7, CarouselPageSize arg8, long arg9, float arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg9 = Color.Companion.getMagenta-0d7_KjU();
        }

        long v3 = arg9;
        if((arg12 & 8) != 0) {
            arg11 = Dp.constructor-impl(4f);
        }

        return CarouselKt.drawDebugLines-1Yev-eo(arg6, arg7, arg8, v3, arg11);
    }

    static final Unit drawDebugLines_1Yev_eo$lambda$28(CarouselPageSize arg17, CarouselState arg18, float arg19, long arg20, ContentDrawScope arg22) {
        ContentDrawScope v1 = arg22;
        v1.drawContent();
        Strategy v2 = arg17.getStrategy();
        KeylineList v0 = Strategy.getKeylineListForScrollOffset$material3$default(v2, CarouselKt.calculateCurrentScrollOffset(arg18, v2), CarouselKt.calculateMaxScrollOffset(arg18, v2), false, 4, null);
        float v9 = v1.toPx-0680j_4(arg19);
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v3 = v0_1.next();
            DrawScope.drawLine-NGM6Ib0$default(v1, arg20, Offset.constructor-impl((((long)Float.floatToRawIntBits(((Keyline)v3).getOffset()))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(((Keyline)v3).getOffset()))) << 0x20 | (((long)Float.floatToRawIntBits(100f))) & 0xFFFFFFFFL), v9, 0, null, 0f, null, 0, 0x1F0, null);
        }

        return Unit.INSTANCE;
    }

    private static final float getProgress(Keyline arg1, Keyline arg2, float arg3) {
        if(Intrinsics.areEqual(arg1, arg2)) {
            return 1f;
        }

        return (arg3 - arg1.getUnadjustedOffset()) / (arg2.getUnadjustedOffset() - arg1.getUnadjustedOffset());
    }
}

