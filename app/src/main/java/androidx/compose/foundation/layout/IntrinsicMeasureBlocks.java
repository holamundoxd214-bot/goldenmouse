package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u000B\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\f\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u000E\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u000F\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u0010\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u0011\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005J$\u0010\u0012\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "<init>", "()V", "HorizontalMinWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableHeight", "mainAxisSpacing", "VerticalMinWidth", "HorizontalMinHeight", "availableWidth", "VerticalMinHeight", "HorizontalMaxWidth", "VerticalMaxWidth", "HorizontalMaxHeight", "VerticalMaxHeight", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IntrinsicMeasureBlocks {
    public static final int $stable;
    public static final IntrinsicMeasureBlocks INSTANCE;

    static {
        IntrinsicMeasureBlocks.INSTANCE = new IntrinsicMeasureBlocks();
    }

    private IntrinsicMeasureBlocks() {
        super();
    }

    public final int HorizontalMaxHeight(List arg11, int arg12, int arg13) {
        int v6;
        int v0 = 0;
        if(arg11.isEmpty()) {
            return 0;
        }

        int v10 = Math.min((arg11.size() - 1) * arg13, arg12);
        List v13 = arg11;
        int v1 = ((Collection)v13).size();
        int v3 = 0;
        int v5 = 0;
        float v4 = 0f;
        while(true) {
            v6 = 0x7FFFFFFF;
            if(v3 >= v1) {
                break;
            }

            Object v7 = arg11.get(v3);
            float v8 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v7)));
            if(v8 == 0f) {
                int v8_1 = arg12 == v6 ? v6 : arg12 - v10;
                v6 = Math.min(((IntrinsicMeasurable)v7).maxIntrinsicWidth(v6), v8_1);
                v10 += v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v7).maxIntrinsicHeight(v6));
            }
            else {
                if(v8 <= 0f) {
                    goto label_32;
                }

                v4 += v8;
            }

        label_32:
            ++v3;
        }

        if(v4 == 0f) {
            v10 = 0;
        }
        else if(arg12 == v6) {
            v10 = v6;
        }
        else {
            v10 = Math.round((((float)Math.max(arg12 - v10, 0))) / v4);
        }

        arg12 = ((Collection)v13).size();
        while(v0 < arg12) {
            Object v13_1 = arg11.get(v0);
            float v1_1 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v13_1)));
            if(v1_1 > 0f) {
                v1 = v10 != v6 ? Math.round((((float)v10)) * v1_1) : v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v13_1).maxIntrinsicHeight(v1));
            }

            ++v0;
        }

        return v5;
    }

    public final int HorizontalMaxWidth(List arg9, int arg10, int arg11) {
        int v0 = 0;
        if(arg9.isEmpty()) {
            return 0;
        }

        int v8 = arg9.size();
        int v2 = 0;
        int v3 = 0;
        float v4 = 0f;
        while(v0 < v8) {
            Object v5 = arg9.get(v0);
            float v6 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v5)));
            int v5_1 = ((IntrinsicMeasurable)v5).maxIntrinsicWidth(arg10);
            if(v6 == 0f) {
                v3 += v5_1;
            }
            else if(v6 > 0f) {
                v4 += v6;
                v2 = Math.max(v2, Math.round((((float)v5_1)) / v6));
            }

            ++v0;
        }

        return Math.round((((float)v2)) * v4) + v3 + (arg9.size() - 1) * arg11;
    }

    public final int HorizontalMinHeight(List arg11, int arg12, int arg13) {
        int v6;
        int v0 = 0;
        if(arg11.isEmpty()) {
            return 0;
        }

        int v10 = Math.min((arg11.size() - 1) * arg13, arg12);
        List v13 = arg11;
        int v1 = ((Collection)v13).size();
        int v3 = 0;
        int v5 = 0;
        float v4 = 0f;
        while(true) {
            v6 = 0x7FFFFFFF;
            if(v3 >= v1) {
                break;
            }

            Object v7 = arg11.get(v3);
            float v8 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v7)));
            if(v8 == 0f) {
                int v8_1 = arg12 == v6 ? v6 : arg12 - v10;
                v6 = Math.min(((IntrinsicMeasurable)v7).maxIntrinsicWidth(v6), v8_1);
                v10 += v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v7).minIntrinsicHeight(v6));
            }
            else {
                if(v8 <= 0f) {
                    goto label_32;
                }

                v4 += v8;
            }

        label_32:
            ++v3;
        }

        if(v4 == 0f) {
            v10 = 0;
        }
        else if(arg12 == v6) {
            v10 = v6;
        }
        else {
            v10 = Math.round((((float)Math.max(arg12 - v10, 0))) / v4);
        }

        arg12 = ((Collection)v13).size();
        while(v0 < arg12) {
            Object v13_1 = arg11.get(v0);
            float v1_1 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v13_1)));
            if(v1_1 > 0f) {
                v1 = v10 != v6 ? Math.round((((float)v10)) * v1_1) : v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v13_1).minIntrinsicHeight(v1));
            }

            ++v0;
        }

        return v5;
    }

    public final int HorizontalMinWidth(List arg9, int arg10, int arg11) {
        int v0 = 0;
        if(arg9.isEmpty()) {
            return 0;
        }

        int v8 = arg9.size();
        int v2 = 0;
        int v3 = 0;
        float v4 = 0f;
        while(v0 < v8) {
            Object v5 = arg9.get(v0);
            float v6 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v5)));
            int v5_1 = ((IntrinsicMeasurable)v5).minIntrinsicWidth(arg10);
            if(v6 == 0f) {
                v3 += v5_1;
            }
            else if(v6 > 0f) {
                v4 += v6;
                v2 = Math.max(v2, Math.round((((float)v5_1)) / v6));
            }

            ++v0;
        }

        return Math.round((((float)v2)) * v4) + v3 + (arg9.size() - 1) * arg11;
    }

    public final int VerticalMaxHeight(List arg9, int arg10, int arg11) {
        int v0 = 0;
        if(arg9.isEmpty()) {
            return 0;
        }

        int v8 = arg9.size();
        int v2 = 0;
        int v3 = 0;
        float v4 = 0f;
        while(v0 < v8) {
            Object v5 = arg9.get(v0);
            float v6 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v5)));
            int v5_1 = ((IntrinsicMeasurable)v5).maxIntrinsicHeight(arg10);
            if(v6 == 0f) {
                v3 += v5_1;
            }
            else if(v6 > 0f) {
                v4 += v6;
                v2 = Math.max(v2, Math.round((((float)v5_1)) / v6));
            }

            ++v0;
        }

        return Math.round((((float)v2)) * v4) + v3 + (arg9.size() - 1) * arg11;
    }

    public final int VerticalMaxWidth(List arg11, int arg12, int arg13) {
        int v6;
        int v0 = 0;
        if(arg11.isEmpty()) {
            return 0;
        }

        int v10 = Math.min((arg11.size() - 1) * arg13, arg12);
        List v13 = arg11;
        int v1 = ((Collection)v13).size();
        int v3 = 0;
        int v5 = 0;
        float v4 = 0f;
        while(true) {
            v6 = 0x7FFFFFFF;
            if(v3 >= v1) {
                break;
            }

            Object v7 = arg11.get(v3);
            float v8 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v7)));
            if(v8 == 0f) {
                int v8_1 = arg12 == v6 ? v6 : arg12 - v10;
                v6 = Math.min(((IntrinsicMeasurable)v7).maxIntrinsicHeight(v6), v8_1);
                v10 += v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v7).maxIntrinsicWidth(v6));
            }
            else {
                if(v8 <= 0f) {
                    goto label_32;
                }

                v4 += v8;
            }

        label_32:
            ++v3;
        }

        if(v4 == 0f) {
            v10 = 0;
        }
        else if(arg12 == v6) {
            v10 = v6;
        }
        else {
            v10 = Math.round((((float)Math.max(arg12 - v10, 0))) / v4);
        }

        arg12 = ((Collection)v13).size();
        while(v0 < arg12) {
            Object v13_1 = arg11.get(v0);
            float v1_1 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v13_1)));
            if(v1_1 > 0f) {
                v1 = v10 != v6 ? Math.round((((float)v10)) * v1_1) : v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v13_1).maxIntrinsicWidth(v1));
            }

            ++v0;
        }

        return v5;
    }

    public final int VerticalMinHeight(List arg9, int arg10, int arg11) {
        int v0 = 0;
        if(arg9.isEmpty()) {
            return 0;
        }

        int v8 = arg9.size();
        int v2 = 0;
        int v3 = 0;
        float v4 = 0f;
        while(v0 < v8) {
            Object v5 = arg9.get(v0);
            float v6 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v5)));
            int v5_1 = ((IntrinsicMeasurable)v5).minIntrinsicHeight(arg10);
            if(v6 == 0f) {
                v3 += v5_1;
            }
            else if(v6 > 0f) {
                v4 += v6;
                v2 = Math.max(v2, Math.round((((float)v5_1)) / v6));
            }

            ++v0;
        }

        return Math.round((((float)v2)) * v4) + v3 + (arg9.size() - 1) * arg11;
    }

    public final int VerticalMinWidth(List arg11, int arg12, int arg13) {
        int v6;
        int v0 = 0;
        if(arg11.isEmpty()) {
            return 0;
        }

        int v10 = Math.min((arg11.size() - 1) * arg13, arg12);
        List v13 = arg11;
        int v1 = ((Collection)v13).size();
        int v3 = 0;
        int v5 = 0;
        float v4 = 0f;
        while(true) {
            v6 = 0x7FFFFFFF;
            if(v3 >= v1) {
                break;
            }

            Object v7 = arg11.get(v3);
            float v8 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v7)));
            if(v8 == 0f) {
                int v8_1 = arg12 == v6 ? v6 : arg12 - v10;
                v6 = Math.min(((IntrinsicMeasurable)v7).maxIntrinsicHeight(v6), v8_1);
                v10 += v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v7).minIntrinsicWidth(v6));
            }
            else {
                if(v8 <= 0f) {
                    goto label_32;
                }

                v4 += v8;
            }

        label_32:
            ++v3;
        }

        if(v4 == 0f) {
            v10 = 0;
        }
        else if(arg12 == v6) {
            v10 = v6;
        }
        else {
            v10 = Math.round((((float)Math.max(arg12 - v10, 0))) / v4);
        }

        arg12 = ((Collection)v13).size();
        while(v0 < arg12) {
            Object v13_1 = arg11.get(v0);
            float v1_1 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v13_1)));
            if(v1_1 > 0f) {
                v1 = v10 != v6 ? Math.round((((float)v10)) * v1_1) : v6;
                v5 = Math.max(v5, ((IntrinsicMeasurable)v13_1).minIntrinsicWidth(v1));
            }

            ++v0;
        }

        return v5;
    }
}

