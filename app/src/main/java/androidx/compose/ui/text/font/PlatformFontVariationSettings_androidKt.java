package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.fonts.FontVariationAxis;
import android.os.Build$VERSION;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0001\u001A\'\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001A\u0012\u0010\u000B\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001A\u00020\rH\u0000\u001A\f\u0010\u000E\u001A\u00020\u000F*\u00020\u000FH\u0002¨\u0006\u0010"}, d2={"toAndroidString", "", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "density", "Landroidx/compose/ui/unit/Density;", "weightAdjustment", "", "toAndroidArray", "", "Landroid/graphics/fonts/FontVariationAxis;", "(Landroidx/compose/ui/text/font/FontVariation$Settings;Landroidx/compose/ui/unit/Density;I)[Landroid/graphics/fonts/FontVariationAxis;", "getFontWeightAdjustment", "context", "Landroid/content/Context;", "coerceInWeight", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformFontVariationSettings_androidKt {
    private static final float coerceInWeight(float arg2) {
        return RangesKt.coerceIn(arg2, 1f, 1000f);
    }

    public static final int getFontWeightAdjustment(Context arg3) {
        if(arg3 != null && Build$VERSION.SDK_INT >= 0x1F) {
            if(arg3.getResources().getConfiguration().fontWeightAdjustment == 0x7FFFFFFF) {
                return 0;
            }
            else {
                return arg3.getResources().getConfiguration().fontWeightAdjustment;
            }
        }

        return 0;
    }

    public static final FontVariationAxis[] toAndroidArray(Settings arg7, Density arg8, int arg9) {
        FontVariationAxis v4;
        String v3;
        int v0 = 0;
        if(arg9 == 0) {
            arg9 = arg7.getSettings().size();
            FontVariationAxis[] v1 = new FontVariationAxis[arg9];
            while(v0 < arg9) {
                v1[v0] = new FontVariationAxis(arg7.getSettings().get(v0).getAxisName(), arg7.getSettings().get(v0).toVariationValue(arg8));
                ++v0;
            }

            return v1;
        }

        int v1_1 = arg7.getSettings().size();
        int v2 = 0;
        while(true) {
            v3 = "wght";
            if(v2 >= v1_1) {
                break;
            }
            else if(Intrinsics.areEqual(arg7.getSettings().get(v2).getAxisName(), v3)) {
                v1_1 = arg7.getSettings().size();
            }
            else {
                ++v2;
                continue;
            }

            goto label_36;
        }

        v1_1 = arg7.getSettings().size() + 1;
    label_36:
        FontVariationAxis[] v2_1 = new FontVariationAxis[v1_1];
        while(v0 < v1_1) {
            if(v0 == arg7.getSettings().size()) {
                v4 = new FontVariationAxis(v3, PlatformFontVariationSettings_androidKt.coerceInWeight((((float)arg9)) + 400f));
            }
            else if(Intrinsics.areEqual(arg7.getSettings().get(v0).getAxisName(), v3)) {
                v4 = new FontVariationAxis(v3, PlatformFontVariationSettings_androidKt.coerceInWeight(arg7.getSettings().get(v0).toVariationValue(arg8) + (((float)arg9))));
            }
            else {
                v4 = new FontVariationAxis(arg7.getSettings().get(v0).getAxisName(), arg7.getSettings().get(v0).toVariationValue(arg8));
            }

            v2_1[v0] = v4;
            ++v0;
        }

        return v2_1;
    }

    public static final String toAndroidString(Settings arg1, Context arg2) {
        return PlatformFontVariationSettings_androidKt.toAndroidString(arg1, AndroidDensity_androidKt.Density(arg2), PlatformFontVariationSettings_androidKt.getFontWeightAdjustment(arg2));
    }

    public static final String toAndroidString(Settings arg10, Density arg11, int arg12) {
        int v7;
        float v3_1;
        char v5;
        if(arg12 == 0) {
            return ListUtilsKt.fastJoinToString$default(arg10.getSettings(), null, null, null, 0, null, new PlatformFontVariationSettings_androidKt$$ExternalSyntheticLambda0(arg11), 0x1F, null);
        }

        List v0 = arg10.getSettings();
        int v1 = v0.size();
        int v2 = 0;
        String v4 = "";
        int v3;
        for(v3 = 0; true; v3 = v7) {
            v5 = ',';
            if(v2 >= v1) {
                break;
            }

            Object v6 = v0.get(v2);
            if(Intrinsics.areEqual(((Setting)v6).getAxisName(), "wght")) {
                v3_1 = PlatformFontVariationSettings_androidKt.coerceInWeight(((Setting)v6).toVariationValue(arg11) + (((float)arg12)));
                v7 = 1;
            }
            else {
                v7 = v3;
                v3_1 = ((Setting)v6).toVariationValue(arg11);
            }

            if(v2 != 0) {
                v4 = v4 + v5;
            }

            v4 = v4 + '\'' + ((Setting)v6).getAxisName() + "\' " + v3_1;
            ++v2;
        }

        if(v3 == 0) {
            float v11 = PlatformFontVariationSettings_androidKt.coerceInWeight((((float)arg12)) + 400f);
            if(!arg10.getSettings().isEmpty()) {
                v4 = v4 + v5;
            }

            return v4 + "\'wght\' " + v11;
        }

        return v4;
    }

    static final CharSequence toAndroidString$lambda$0(Density arg2, Setting arg3) {
        return "\'" + arg3.getAxisName() + "\' " + arg3.toVariationValue(arg2);
    }
}

