package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\b\u001A\u00020\t*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\"\u0010\u0017\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001A\u00020\u0013H\u0016J\"\u0010\u0019\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\"\u0010\u001A\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001A\u00020\u0013H\u0016R\u0015\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl arg1) {
        super();
        this.rootScope = arg1;
    }

    public final AnimatedContentTransitionScopeImpl getRootScope() {
        return this.rootScope;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).maxIntrinsicHeight(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).maxIntrinsicHeight(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).maxIntrinsicWidth(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).maxIntrinsicWidth(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg28, List arg29, long arg30) {
        int v3;
        int v2_1;
        Placeable v1_2;
        int v1_1;
        int v17;
        long v18;
        int v10;
        Object v15;
        AnimatedContentMeasurePolicy v0 = this;
        List v1 = arg29;
        long v2 = arg30;
        int v4 = v1.size();
        Placeable[] v5 = new Placeable[v4];
        long v6 = IntSize.Companion.getZero-YbymL2g();
        List v8 = v1;
        int v9 = ((Collection)v8).size();
        int v11;
        for(v11 = 0; true; ++v11) {
            v15 = null;
            v10 = 1;
            if(v11 >= v9) {
                break;
            }

            v18 = 0xFFFFFFFFL;
            Object v12 = v1.get(v11);
            Object v13 = ((Measurable)v12).getParentData();
            v17 = 0x20;
            if((v13 instanceof ChildData)) {
                v15 = v13;
            }

            if(v15 != null && (((ChildData)v15).isTarget())) {
                Placeable v6_1 = ((Measurable)v12).measure-BRTryo0(v2);
                long v12_1 = IntSize.constructor-impl((((long)v6_1.getWidth())) << v17 | (((long)v6_1.getHeight())) & v18);
                v5[v11] = v6_1;
                v6 = v12_1;
            }
        }

        v17 = 0x20;
        v18 = 0xFFFFFFFFL;
        int v8_1 = ((Collection)v8).size();
        for(v9 = 0; v9 < v8_1; ++v9) {
            Object v11_1 = v1.get(v9);
            if(v5[v9] == null) {
                v5[v9] = ((Measurable)v11_1).measure-BRTryo0(v2);
            }
        }

        if(arg28.isLookingAhead()) {
            v1_1 = ((int)(v6 >> v17));
        }
        else {
            if(v4 == 0) {
                v1_2 = ((Placeable)v15);
            }
            else {
                v1_2 = v5[0];
                v2_1 = ArraysKt.getLastIndex(((Object[])v5));
                if(v2_1 == 0) {
                }
                else {
                    v3 = v1_2 != null ? v1_2.getWidth() : 0;
                    if(1 > v2_1) {
                        goto label_80;
                    }

                    for(v8_1 = 1; true; ++v8_1) {
                        Placeable v9_1 = v5[v8_1];
                        v11 = v9_1 != null ? v9_1.getWidth() : 0;
                        if(v3 < v11) {
                            v1_2 = v9_1;
                            v3 = v11;
                        }

                        if(v8_1 == v2_1) {
                            break;
                        }
                    }
                }
            }

        label_80:
            if(v1_2 != null) {
                v1_1 = v1_2.getWidth();
                goto label_84;
            }

            v1_1 = 0;
        }

    label_84:
        if(arg28.isLookingAhead()) {
            v10 = ((int)(v6 & v18));
        }
        else {
            if(v4 == 0) {
            }
            else {
                Placeable v15_1 = v5[0];
                v2_1 = ArraysKt.getLastIndex(((Object[])v5));
                if(v2_1 == 0) {
                }
                else {
                    v3 = v15_1 != null ? v15_1.getHeight() : 0;
                    if(1 > v2_1) {
                        goto label_111;
                    }

                    while(true) {
                        Placeable v4_1 = v5[v10];
                        int v6_2 = v4_1 != null ? v4_1.getHeight() : 0;
                        if(v3 < v6_2) {
                            v15_1 = v4_1;
                            v3 = v6_2;
                        }

                        if(v10 == v2_1) {
                            break;
                        }

                        ++v10;
                    }
                }
            }

        label_111:
            if((((Placeable)v15)) != null) {
                v10 = ((Placeable)v15).getHeight();
                goto label_115;
            }

            v10 = 0;
        }

    label_115:
        if(!arg28.isLookingAhead()) {
            v0.rootScope.setMeasuredSize-ozmzZPI$animation(IntSize.constructor-impl((((long)v1_1)) << v17 | (((long)v10)) & v18));
        }

        return MeasureScope.layout$default(arg28, v1_1, v10, null, new AnimatedContentMeasurePolicy$measure$3(v5, v0, v1_1, v10), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).minIntrinsicHeight(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).minIntrinsicHeight(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg5, List arg6, int arg7) {
        Integer v4;
        if(arg6.isEmpty()) {
            v4 = null;
        }
        else {
            v4 = Integer.valueOf(arg6.get(0).minIntrinsicWidth(arg7));
            int v0 = CollectionsKt.getLastIndex(arg6);
            int v1 = 1;
            if(1 > v0) {
                goto label_20;
            }

            while(true) {
                Integer v2 = Integer.valueOf(arg6.get(v1).minIntrinsicWidth(arg7));
                if(((Comparable)v2).compareTo(v4) > 0) {
                    v4 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

    label_20:
        if(v4 != null) {
            return v4.intValue();
        }

        return 0;
    }
}

