package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AD\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005H\u0000\u001A(\u0010\f\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005H\u0000\u001AU\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0012\u001A0\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0017H\u0000\u001A0\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0017H\u0000\u001A \u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u0005H\u0002¨\u0006\u001D"}, d2={"multiBrowseKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "density", "Landroidx/compose/ui/unit/Density;", "carouselMainAxisSize", "", "preferredItemSize", "itemSpacing", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "heroKeylineList", "maxItemSize", "isCentered", "", "(Landroidx/compose/ui/unit/Density;FLjava/lang/Float;FIZFF)Landroidx/compose/material3/carousel/KeylineList;", "createLeftAlignedKeylineList", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "createCenterAlignedKeylineList", "calculateMediumChildSize", "minimumMediumSize", "largeItemSize", "remainingSpace", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeylinesKt {
    private static final float calculateMediumChildSize(float arg2, float arg3, float arg4) {
        arg2 = Math.max(1.5f * arg4, arg2);
        float v0 = 0.85f * arg3;
        if(arg2 > v0) {
            arg2 = Math.min(Math.max(v0, arg4 * 1.2f), arg3);
        }

        return arg2;
    }

    public static final KeylineList createCenterAlignedKeylineList(float arg2, float arg3, float arg4, float arg5, Arrangement arg6) {
        return KeylineListKt.keylineListOf-WNYm7Xg(arg2, arg3, CarouselAlignment.Companion.getCenter-NUL3oTo(), new KeylinesKt$$ExternalSyntheticLambda1(arg4, arg6, arg5));
    }

    static final Unit createCenterAlignedKeylineList$lambda$16(float arg6, Arrangement arg7, float arg8, KeylineListScope arg9) {
        Object v4;
        arg9.add(arg6, true);
        int v1 = 2;
        int v6 = arg7.getSmallCount() / v1;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = null;
            if(v3 >= v6) {
                break;
            }

            KeylineListScope.add$default(arg9, arg7.getSmallSize(), false, v1, v4);
        }

        v6 = arg7.getMediumCount() / v1;
        for(v3 = 0; v3 < v6; ++v3) {
            KeylineListScope.add$default(arg9, arg7.getMediumSize(), false, v1, v4);
        }

        v6 = arg7.getLargeCount();
        for(v3 = 0; v3 < v6; ++v3) {
            KeylineListScope.add$default(arg9, arg7.getLargeSize(), false, v1, v4);
        }

        v6 = arg7.getMediumCount() / v1;
        for(v3 = 0; v3 < v6; ++v3) {
            KeylineListScope.add$default(arg9, arg7.getMediumSize(), false, v1, v4);
        }

        v6 = arg7.getSmallCount() / v1;
        for(v3 = 0; v3 < v6; ++v3) {
            KeylineListScope.add$default(arg9, arg7.getSmallSize(), false, v1, v4);
        }

        arg9.add(arg8, true);
        return Unit.INSTANCE;
    }

    public static final KeylineList createLeftAlignedKeylineList(float arg2, float arg3, float arg4, float arg5, Arrangement arg6) {
        return KeylineListKt.keylineListOf-WNYm7Xg(arg2, arg3, CarouselAlignment.Companion.getStart-NUL3oTo(), new KeylinesKt$$ExternalSyntheticLambda0(arg4, arg6, arg5));
    }

    static final Unit createLeftAlignedKeylineList$lambda$10(float arg6, Arrangement arg7, float arg8, KeylineListScope arg9) {
        int v4;
        Object v3;
        arg9.add(arg6, true);
        int v6 = arg7.getLargeCount();
        int v2;
        for(v2 = 0; true; ++v2) {
            v3 = null;
            v4 = 2;
            if(v2 >= v6) {
                break;
            }

            KeylineListScope.add$default(arg9, arg7.getLargeSize(), false, v4, v3);
        }

        v6 = arg7.getMediumCount();
        for(v2 = 0; v2 < v6; ++v2) {
            KeylineListScope.add$default(arg9, arg7.getMediumSize(), false, v4, v3);
        }

        v6 = arg7.getSmallCount();
        for(v2 = 0; v2 < v6; ++v2) {
            KeylineListScope.add$default(arg9, arg7.getSmallSize(), false, v4, v3);
        }

        arg9.add(arg8, true);
        return Unit.INSTANCE;
    }

    public static final KeylineList heroKeylineList(Density arg15, float arg16, Float arg17, float arg18, int arg19, boolean arg20, float arg21, float arg22) {
        float v1 = arg16;
        int v11 = arg19;
        float v4 = arg21;
        if(v1 == 0f) {
            return KeylineListKt.emptyKeylineList();
        }

        int v12 = !arg20 || v11 < 3 ? 0 : 1;
        int[] v3 = new int[1];
        v3[0] = v12 != 0 ? 2 : 1;
        float v5 = arg17 != null ? arg17.floatValue() : v1;
        float v9 = Math.min(v5, v1);
        float v6 = arg22;
        v5 = RangesKt.coerceIn(v9 / 3f, v4, v6);
        if(v1 < (((float)ArraysKt.maxOrThrow(v3))) * v4 + 1.25f * v4) {
            v3 = new int[]{0};
        }

        int v7 = Math.max(1, ((int)(((float)Math.floor(((double)((v1 - (((float)ArraysKt.maxOrThrow(v3))) * v4) / v9)))))));
        int v8 = ((int)(((float)Math.ceil(((double)(v1 / v9))))));
        v7 = v8 - v7 + 1;
        int[] v10 = new int[v7];
        int v2;
        for(v2 = 0; v2 < v7; ++v2) {
            v10[v2] = v8 - v2;
        }

        float v15 = arg15.toPx-0680j_4(CarouselDefaults.INSTANCE.getAnchorSize-D9Ej5fM$material3());
        float v2_1 = v6;
        int[] v6_1 = v3;
        float v3_1 = v5;
        v5 = v2_1;
        v2_1 = arg18;
        Arrangement v0 = Arrangement.Companion.findLowestCostArrangement(v1, v2_1, v3_1, v4, v5, v6_1, 0f, new int[]{0}, v9, v10);
        if(v0 == null) {
            return KeylineListKt.emptyKeylineList();
        }

        if(v12 != 0 && v11 >= v0.itemCount()) {
            return KeylinesKt.createCenterAlignedKeylineList(v1, v2_1, v15, v15, v0);
        }

        return KeylinesKt.createLeftAlignedKeylineList(v1, v2_1, v15, v15, v0);
    }

    public static KeylineList heroKeylineList$default(Density arg8, float arg9, Float arg10, float arg11, int arg12, boolean arg13, float arg14, float arg15, int arg16, Object arg17) {
        int v0 = arg16;
        if((v0 & 0x40) != 0) {
            arg14 = arg8.toPx-0680j_4(CarouselDefaults.INSTANCE.getMinSmallItemSize-D9Ej5fM());
        }

        float v6 = arg14;
        if((v0 & 0x80) != 0) {
            arg15 = arg8.toPx-0680j_4(CarouselDefaults.INSTANCE.getMaxSmallItemSize-D9Ej5fM());
        }

        return KeylinesKt.heroKeylineList(arg8, arg9, arg10, arg11, arg12, false, v6, arg15);
    }

    public static final KeylineList multiBrowseKeylineList(Density arg15, float arg16, float arg17, float arg18, int arg19, float arg20, float arg21) {
        int v0_2;
        int v2_1;
        int v1_1;
        float v1 = arg16;
        float v0 = arg17;
        int v11 = arg19;
        float v4 = arg20;
        float v5 = arg21;
        if(v1 == 0f) {
        }
        else {
            if(v0 == 0f) {
                goto label_9;
            }

            goto label_11;
        }

    label_9:
        return KeylineListKt.emptyKeylineList();
    label_11:
        int[] v2 = new int[1];
        int v3 = 0;
        v2[0] = 1;
        int[] v8 = new int[]{1, 0};
        float v9 = Math.min(v0, v1);
        v0 = RangesKt.coerceIn(v9 / 3f, v4, v5);
        float v6 = (v9 + v0) / 2f;
        if(v1 < 2f * v4) {
            v2 = new int[]{0};
        }

        int v7 = Math.max(1, ((int)(((float)Math.floor(((double)((v1 - (((float)ArraysKt.maxOrThrow(v8))) * v6 - (((float)ArraysKt.maxOrThrow(v2))) * v5) / v9)))))));
        int v10 = ((int)(((float)Math.ceil(((double)(v1 / v9))))));
        v7 = v10 - v7 + 1;
        int v13 = v10;
        int[] v10_1 = new int[v7];
        while(v3 < v7) {
            v10_1[v3] = v13 - v3;
            ++v3;
        }

        float v15 = arg15.toPx-0680j_4(CarouselDefaults.INSTANCE.getAnchorSize-D9Ej5fM$material3());
        float v3_1 = v0;
        float v7_1 = v6;
        Arrangement v0_1 = Arrangement.Companion.findLowestCostArrangement(v1, arg18, v3_1, v4, v5, v2, v7_1, v8, v9, v10_1);
        if(v0_1 == null || v0_1.itemCount() <= v11) {
            v1 = arg16;
            goto label_90;
        label_71:
            while(v1_1 > 0) {
                if(v2_1 > 0) {
                    --v2_1;
                }
                else if(v0_2 > 1) {
                    --v0_2;
                }

                --v1_1;
            }

            Companion v1_2 = Arrangement.Companion;
            int[] v6_1 = new int[]{v2_1};
            v8 = new int[]{v0_2};
            Companion v0_3 = v1_2;
            v1 = arg16;
            v0_1 = v0_3.findLowestCostArrangement(v1, arg18, v3_1, arg20, arg21, v6_1, v7_1, v8, v9, v10_1);
        }
        else {
            v1_1 = v0_1.itemCount() - v11;
            v2_1 = v0_1.getSmallCount();
            v0_2 = v0_1.getMediumCount();
            goto label_71;
        }

    label_90:
        if(v0_1 == null) {
            return KeylineListKt.emptyKeylineList();
        }

        return KeylinesKt.createLeftAlignedKeylineList(v1, arg18, v15, v15, v0_1);
    }

    public static KeylineList multiBrowseKeylineList$default(Density arg7, float arg8, float arg9, float arg10, int arg11, float arg12, float arg13, int arg14, Object arg15) {
        if((arg14 & 0x20) != 0) {
            arg12 = arg7.toPx-0680j_4(CarouselDefaults.INSTANCE.getMinSmallItemSize-D9Ej5fM());
        }

        float v5 = arg12;
        if((arg14 & 0x40) != 0) {
            arg13 = arg7.toPx-0680j_4(CarouselDefaults.INSTANCE.getMaxSmallItemSize-D9Ej5fM());
        }

        return KeylinesKt.multiBrowseKeylineList(arg7, arg8, arg9, arg10, arg11, v5, arg13);
    }

    public static final KeylineList uncontainedKeylineList(Density arg10, float arg11, float arg12, float arg13) {
        if(arg11 == 0f) {
        }
        else {
            if(arg12 == 0f) {
                goto label_4;
            }

            goto label_6;
        }

    label_4:
        return KeylineListKt.emptyKeylineList();
    label_6:
        float v8 = Math.min(arg12 + arg13, arg11);
        int v2 = 1;
        int v9 = Math.max(1, ((int)(((float)Math.floor(((double)(arg11 / v8)))))));
        float v1 = arg11 - (((float)v9)) * v8;
        if(v1 > 0f) {
        }
        else {
            v2 = 0;
        }

        float v10 = arg10.toPx-0680j_4(CarouselDefaults.INSTANCE.getAnchorSize-D9Ej5fM$material3());
        float v6 = KeylinesKt.calculateMediumChildSize(v10, v8, v1);
        return KeylinesKt.createLeftAlignedKeylineList(arg11, arg13, Math.max(Math.min(v10, arg12), v6 * 0.5f), v10, new Arrangement(0, 0f, 0, v6, v2, v8, v9));
    }
}

