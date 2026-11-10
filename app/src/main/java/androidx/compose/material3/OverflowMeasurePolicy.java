package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001A\u00020\r*\u00020\u000E2\u0012\u0010\u000F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/material3/OverflowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/AppBarOverflowState;", "maxItemCount", "", "isVertical", "", "<init>", "(Landroidx/compose/material3/AppBarOverflowState;IZ)V", "getMaxItemCount", "()I", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverflowMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable;
    private final boolean isVertical;
    private final int maxItemCount;
    private final AppBarOverflowState overflowState;

    static {
    }

    public OverflowMeasurePolicy(AppBarOverflowState arg1, int arg2, boolean arg3) {
        super();
        this.overflowState = arg1;
        this.maxItemCount = arg2;
        this.isVertical = arg3;
    }

    public OverflowMeasurePolicy(AppBarOverflowState arg1, int arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, false);
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg21, List arg22, long arg23) {
        Integer v11;
        Integer v10_2;
        Integer v6_2;
        int v1_2;
        Integer v9_1;
        Integer v1_1;
        int v10_1;
        ArrayList v8_1;
        long v6_1;
        ArrayList v5_1;
        int v19;
        int v7_1;
        Integer v13;
        int v9;
        Integer v7;
        OverflowMeasurePolicy v0 = this;
        int v4 = 0;
        long v2 = arg23;
        long v10 = Constraints.copy-Zbe2FdA$default(v2, 0, 0, 0, 0, 10, null);
        Object v5 = arg22.get(0);
        int v6 = 1;
        Object v1 = arg22.get(1);
        v0.overflowState.setTotalItemCount(((List)v5).size());
        if(v0.isVertical) {
            if(((List)v1).isEmpty()) {
                v7 = null;
            }
            else {
                v7 = Integer.valueOf(((List)v1).get(0).maxIntrinsicHeight(Constraints.getMaxWidth-impl(v2)));
                v9 = CollectionsKt.getLastIndex(((List)v1));
                if(1 <= v9) {
                    int v12;
                    for(v12 = 1; true; ++v12) {
                        v13 = Integer.valueOf(((List)v1).get(v12).maxIntrinsicHeight(Constraints.getMaxWidth-impl(v2)));
                        if(((Comparable)v13).compareTo(v7) > 0) {
                            v7 = v13;
                        }

                        if(v12 == v9) {
                            break;
                        }
                    }
                }
            }

            if(v7 == null) {
                goto label_66;
            }

            v7_1 = v7.intValue();
        }
        else {
            if(((List)v1).isEmpty()) {
                v7 = null;
            }
            else {
                v7 = Integer.valueOf(((List)v1).get(0).maxIntrinsicWidth(Constraints.getMaxHeight-impl(v2)));
                v9 = CollectionsKt.getLastIndex(((List)v1));
                if(1 <= v9) {
                    for(v12 = 1; true; ++v12) {
                        v13 = Integer.valueOf(((List)v1).get(v12).maxIntrinsicWidth(Constraints.getMaxHeight-impl(v2)));
                        if(((Comparable)v13).compareTo(v7) > 0) {
                            v7 = v13;
                        }

                        if(v12 == v9) {
                            break;
                        }
                    }
                }
            }

            if(v7 != null) {
                v7_1 = v7.intValue();
                goto label_67;
            }

        label_66:
            v7_1 = 0;
        }

    label_67:
        v9 = v0.isVertical ? Constraints.getMaxHeight-impl(v2) : Constraints.getMaxWidth-impl(v2);
        v9 = LayoutUtilKt.subtractConstraintSafely(v9, v7_1);
        ArrayList v12_1 = new ArrayList();
        int v13_1 = v5.size();
        int v14 = 0;
        int v18 = 0;
        while(v14 < v13_1) {
            Placeable v15 = ((List)v5).get(v14).measure-BRTryo0(v10);
            int v8 = v14 == CollectionsKt.getLastIndex(((List)v5)) ? v6 : 0;
            v19 = v6;
            if(v8 == 0 && v14 == v0.maxItemCount - 1) {
                goto label_109;
            }

            v6 = v0.isVertical ? v15.getHeight() : v15.getWidth();
            if(v6 > v9) {
                if(v8 == 0) {
                }
                else if(v6 <= v9 + v7_1) {
                    goto label_102;
                }

                goto label_109;
            }

        label_102:
            ((List)v12_1).add(v15);
            v18 += v6;
            v9 = LayoutUtilKt.subtractConstraintSafely(v9, v6);
            ++v14;
            v6 = v19;
        }

        v19 = v6;
    label_109:
        v0.overflowState.setVisibleItemCount(((List)v12_1).size());
        if(((List)v12_1).size() != ((List)v5).size()) {
            if(v0.isVertical) {
                v5_1 = v12_1;
                v6_1 = Constraints.copy-Zbe2FdA$default(v10, 0, 0, 0, v9 + v7_1, 7, null);
            }
            else {
                v5_1 = v12_1;
                v6_1 = Constraints.copy-Zbe2FdA$default(v10, 0, v9 + v7_1, 0, 0, 13, null);
            }

            v8_1 = new ArrayList(((List)v1).size());
            v9 = v1.size();
            v10_1 = 0;
            goto label_140;
        }
        else {
            v5_1 = v12_1;
            v8_1 = null;
            goto label_150;
        label_140:
            while(v10_1 < v9) {
                v8_1.add(((List)v1).get(v10_1).measure-BRTryo0(v6_1));
                ++v10_1;
            }
        }

    label_150:
        if(!v0.isVertical) {
            if(v8_1 != null) {
                if(((List)v8_1).isEmpty()) {
                    v1_1 = null;
                }
                else {
                    v1_1 = Integer.valueOf(((List)v8_1).get(0).getWidth());
                    v6 = CollectionsKt.getLastIndex(((List)v8_1));
                    if(1 <= v6) {
                        for(v7_1 = 1; true; ++v7_1) {
                            v9_1 = Integer.valueOf(((List)v8_1).get(v7_1).getWidth());
                            if(((Comparable)v9_1).compareTo(v1_1) > 0) {
                                v1_1 = v9_1;
                            }

                            if(v7_1 == v6) {
                                break;
                            }
                        }
                    }
                }

                if(v1_1 == null) {
                    goto label_200;
                }

                v1_2 = v1_1.intValue();
                goto label_201;
            }

        label_200:
            v1_2 = 0;
        }
        else if(v8_1 != null) {
            if(((List)v8_1).isEmpty()) {
                v1_1 = null;
            }
            else {
                v1_1 = Integer.valueOf(((List)v8_1).get(0).getHeight());
                v6 = CollectionsKt.getLastIndex(((List)v8_1));
                if(v19 <= v6) {
                    for(v7_1 = 1; true; ++v7_1) {
                        v9_1 = Integer.valueOf(((List)v8_1).get(v7_1).getHeight());
                        if(((Comparable)v9_1).compareTo(v1_1) > 0) {
                            v1_1 = v9_1;
                        }

                        if(v7_1 == v6) {
                            break;
                        }
                    }
                }
            }

            if(v1_1 == null) {
                goto label_200;
            }

            v1_2 = v1_1.intValue();
        }
        else {
            goto label_200;
        }

    label_201:
        v1_2 = v18 + v1_2;
        if(v0.isVertical) {
            if(((List)v5_1).isEmpty()) {
                v6_2 = null;
            }
            else {
                v6_2 = Integer.valueOf(((List)v5_1).get(0).getWidth());
                v7_1 = CollectionsKt.getLastIndex(((List)v5_1));
                if(1 <= v7_1) {
                    for(v9 = 1; true; ++v9) {
                        v10_2 = Integer.valueOf(((List)v5_1).get(v9).getWidth());
                        if(((Comparable)v10_2).compareTo(v6_2) > 0) {
                            v6_2 = v10_2;
                        }

                        if(v9 == v7_1) {
                            break;
                        }
                    }
                }
            }

            v6 = v6_2 != null ? v6_2.intValue() : 0;
            if(v8_1 != null) {
                if(((List)v8_1).isEmpty()) {
                    v7 = null;
                }
                else {
                    v7 = Integer.valueOf(((List)v8_1).get(0).getWidth());
                    v9 = CollectionsKt.getLastIndex(((List)v8_1));
                    if(1 <= v9) {
                        v10_2 = v7;
                        for(v7_1 = 1; true; ++v7_1) {
                            v11 = Integer.valueOf(((List)v8_1).get(v7_1).getWidth());
                            if(((Comparable)v11).compareTo(v10_2) > 0) {
                                v10_2 = v11;
                            }

                            if(v7_1 == v9) {
                                break;
                            }
                        }

                        v7 = v10_2;
                    }
                }

                if(v7 == null) {
                    goto label_253;
                }

                v4 = v7.intValue();
            }

        label_253:
            v4 = Math.max(v6, v4);
        }
        else {
            if(((List)v5_1).isEmpty()) {
                v6_2 = null;
            }
            else {
                v6_2 = Integer.valueOf(((List)v5_1).get(0).getHeight());
                v7_1 = CollectionsKt.getLastIndex(((List)v5_1));
                if(1 <= v7_1) {
                    for(v9 = 1; true; ++v9) {
                        v10_2 = Integer.valueOf(((List)v5_1).get(v9).getHeight());
                        if(((Comparable)v10_2).compareTo(v6_2) > 0) {
                            v6_2 = v10_2;
                        }

                        if(v9 == v7_1) {
                            break;
                        }
                    }
                }
            }

            v6 = v6_2 != null ? v6_2.intValue() : 0;
            if(v8_1 != null) {
                if(((List)v8_1).isEmpty()) {
                    v7 = null;
                }
                else {
                    v7 = Integer.valueOf(((List)v8_1).get(0).getHeight());
                    v9 = CollectionsKt.getLastIndex(((List)v8_1));
                    v10_1 = 1;
                    if(1 > v9) {
                        goto label_299;
                    }

                    while(true) {
                        v11 = Integer.valueOf(((List)v8_1).get(v10_1).getHeight());
                        if(((Comparable)v11).compareTo(v7) > 0) {
                            v7 = v11;
                        }

                        if(v10_1 == v9) {
                            break;
                        }

                        ++v10_1;
                    }
                }

            label_299:
                if(v7 == null) {
                    goto label_301;
                }

                v4 = v7.intValue();
            }

        label_301:
            v4 = Math.max(v6, v4);
        }

        if(v0.isVertical) {
            return MeasureScope.layout$default(arg21, ConstraintsKt.constrainWidth-K40F9xA(v2, v4), ConstraintsKt.constrainHeight-K40F9xA(v2, v1_2), null, new OverflowMeasurePolicy$$ExternalSyntheticLambda0(((List)v5_1), ((List)v8_1)), 4, null);
        }

        return MeasureScope.layout$default(arg21, ConstraintsKt.constrainWidth-K40F9xA(v2, v1_2), ConstraintsKt.constrainHeight-K40F9xA(v2, v4), null, new OverflowMeasurePolicy$$ExternalSyntheticLambda1(((List)v5_1), ((List)v8_1)), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$11(List arg10, List arg11, PlacementScope arg12) {
        int v0 = arg10.size();
        int v1 = 0;
        int v2 = 0;
        int v6 = 0;
        while(v2 < v0) {
            Object v4 = arg10.get(v2);
            PlacementScope.placeRelative$default(arg12, ((Placeable)v4), 0, v6, 0f, 4, null);
            v6 += ((Placeable)v4).getHeight();
            ++v2;
            arg12 = arg12;
        }

        PlacementScope v3 = arg12;
        if(arg11 != null) {
            int v10 = arg11.size();
            while(v1 < v10) {
                PlacementScope.placeRelative$default(v3, arg11.get(v1), 0, v6, 0f, 4, null);
                ++v1;
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$14(List arg10, List arg11, PlacementScope arg12) {
        int v0 = arg10.size();
        int v1 = 0;
        int v2 = 0;
        int v5 = 0;
        while(v2 < v0) {
            Object v4 = arg10.get(v2);
            PlacementScope.placeRelative$default(arg12, ((Placeable)v4), v5, 0, 0f, 4, null);
            v5 += ((Placeable)v4).getWidth();
            ++v2;
            arg12 = arg12;
        }

        PlacementScope v3 = arg12;
        if(arg11 != null) {
            int v10 = arg11.size();
            while(v1 < v10) {
                PlacementScope.placeRelative$default(v3, arg11.get(v1), v5, 0, 0f, 4, null);
                ++v1;
            }
        }

        return Unit.INSTANCE;
    }
}

