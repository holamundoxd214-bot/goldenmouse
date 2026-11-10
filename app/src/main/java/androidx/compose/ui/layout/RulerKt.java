package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A1\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u000E\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"mergeRulerValues", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "useGreater", "", "rulers", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Z[Landroidx/compose/ui/layout/Ruler;F)F", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RulerKt {
    public static final float access$mergeRulerValues(PlacementScope arg0, boolean arg1, Ruler[] arg2, float arg3) {
        return RulerKt.mergeRulerValues(arg0, arg1, arg2, arg3);
    }

    private static final float mergeRulerValues(PlacementScope arg7, boolean arg8, Ruler[] arg9, float arg10) {
        int v0 = arg9.length;
        float v1 = NaNf;
        float v4 = v1;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            float v5 = arg7.current(arg9[v3], v1);
            if(!Float.isNaN(v4)) {
                boolean v6 = v5 > v4 ? true : false;
                if(arg8 != v6) {
                    goto label_16;
                }

                goto label_15;
            }
            else {
            label_15:
                v4 = v5;
            }

        label_16:
        }

        if(Float.isNaN(v4)) {
            return arg10;
        }

        return v4;
    }
}

