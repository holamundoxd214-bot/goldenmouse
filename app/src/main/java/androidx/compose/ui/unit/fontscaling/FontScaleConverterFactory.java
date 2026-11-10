package androidx.compose.ui.unit.fontscaling;

import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.unit.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0005H\u0007J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001A\u00020\u0005H\u0007J \u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\u001B\u001A\u00020\u0005H\u0002J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0005H\u0002J\u0010\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u001DH\u0002J\u0018\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\nH\u0002J&\u0010$\u001A\u00020!2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\nH\u0002J\u0013\u0010&\u001A\u0004\u0018\u00010\n2\u0006\u0010\"\u001A\u00020\u0005H\u0082\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000E\u0010\u0013\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory;", "", "<init>", "()V", "ScaleKeyMultiplier", "", "CommonFontSizes", "", "sLookupTables", "Landroidx/collection/SparseArrayCompat;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "getSLookupTables$annotations", "getSLookupTables", "()Landroidx/collection/SparseArrayCompat;", "setSLookupTables", "(Landroidx/collection/SparseArrayCompat;)V", "LookupTablesWriteLock", "", "[Ljava/lang/Object;", "MinScaleForNonLinear", "isNonLinearFontScalingActive", "", "fontScale", "forScale", "createInterpolatedTableBetween", "start", "end", "interpolationPoint", "getKey", "", "getScaleFromKey", "key", "put", "", "scaleKey", "fontScaleConverter", "putInto", "table", "get", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontScaleConverterFactory {
    public static final int $stable = 0;
    private static final float[] CommonFontSizes = null;
    public static final FontScaleConverterFactory INSTANCE = null;
    private static final Object[] LookupTablesWriteLock = null;
    private static final float MinScaleForNonLinear = 1.03f;
    private static final float ScaleKeyMultiplier = 100f;
    private static volatile SparseArrayCompat sLookupTables;

    static {
        FontScaleConverterFactory v0 = new FontScaleConverterFactory();
        FontScaleConverterFactory.INSTANCE = v0;
        int v1 = 9;
        FontScaleConverterFactory.CommonFontSizes = new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f};
        int v4 = 0;
        FontScaleConverterFactory.sLookupTables = new SparseArrayCompat(0, 1, null);
        Object[] v2 = new Object[0];
        FontScaleConverterFactory.LookupTablesWriteLock = v2;
        __monitor_enter(v2);
        try {
            v0.putInto(FontScaleConverterFactory.sLookupTables, 1.15f, new FontScaleConverterTable(new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.799999f, 21.799999f, 25.200001f, 30f, 100f}));
            v0.putInto(FontScaleConverterFactory.sLookupTables, 1.3f, new FontScaleConverterTable(new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f}, new float[]{10.4f, 13f, 15.6f, 18.799999f, 21.6f, 23.6f, 26.4f, 30f, 100f}));
            v0.putInto(FontScaleConverterFactory.sLookupTables, 1.5f, new FontScaleConverterTable(new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f}, new float[]{12f, 15f, 18f, 22f, 24f, 26f, 28f, 30f, 100f}));
            v0.putInto(FontScaleConverterFactory.sLookupTables, 1.8f, new FontScaleConverterTable(new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f}, new float[]{14.4f, 18f, 21.6f, 24.4f, 27.6f, 30.799999f, 32.799999f, 34.799999f, 100f}));
            v0.putInto(FontScaleConverterFactory.sLookupTables, 2f, new FontScaleConverterTable(new float[]{8f, 10f, 12f, 14f, 18f, 20f, 24f, 30f, 100f}, new float[]{16f, 20f, 24f, 26f, 30f, 34f, 36f, 38f, 100f}));
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2);
            throw v0_1;
        }

        __monitor_exit(v2);
        if(v0.getScaleFromKey(FontScaleConverterFactory.sLookupTables.keyAt(0)) - 0.01f > 1.03f) {
            v4 = 1;
        }

        if(v4 == 0) {
            InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
        }

        FontScaleConverterFactory.$stable = 8;
    }

    private FontScaleConverterFactory() {
        super();
    }

    private final FontScaleConverter createInterpolatedTableBetween(FontScaleConverter arg6, FontScaleConverter arg7, float arg8) {
        float[] v5 = FontScaleConverterFactory.CommonFontSizes;
        float[] v0 = new float[v5.length];
        int v5_1 = v5.length;
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            v0[v1] = MathUtils.INSTANCE.lerp(arg6.convertSpToDp(FontScaleConverterFactory.CommonFontSizes[v1]), arg7.convertSpToDp(FontScaleConverterFactory.CommonFontSizes[v1]), arg8);
        }

        return new FontScaleConverterTable(FontScaleConverterFactory.CommonFontSizes, v0);
    }

    public final FontScaleConverter forScale(float arg9) {
        Object v1_1;
        if(!this.isNonLinearFontScalingActive(arg9)) {
            return null;
        }

        FontScaleConverter v0 = FontScaleConverterFactory.INSTANCE.get(arg9);
        if(v0 != null) {
            return v0;
        }

        int v0_1 = FontScaleConverterFactory.sLookupTables.indexOfKey(this.getKey(arg9));
        if(v0_1 >= 0) {
            return FontScaleConverterFactory.sLookupTables.valueAt(v0_1);
        }

        v0_1 = -(v0_1 + 1);
        int v2 = v0_1 - 1;
        float v4 = 1f;
        if(v0_1 >= FontScaleConverterFactory.sLookupTables.size()) {
            FontScaleConverterTable v0_2 = new FontScaleConverterTable(new float[]{v4}, new float[]{arg9});
            this.put(arg9, ((FontScaleConverter)v0_2));
            return ((FontScaleConverter)v0_2);
        }

        if(v2 < 0) {
            FontScaleConverterTable v1 = new FontScaleConverterTable(FontScaleConverterFactory.CommonFontSizes, FontScaleConverterFactory.CommonFontSizes);
        }
        else {
            v4 = this.getScaleFromKey(FontScaleConverterFactory.sLookupTables.keyAt(v2));
            v1_1 = FontScaleConverterFactory.sLookupTables.valueAt(v2);
        }

        float v7 = arg9;
        FontScaleConverter v9 = this.createInterpolatedTableBetween(((FontScaleConverter)v1_1), FontScaleConverterFactory.sLookupTables.valueAt(v0_1), MathUtils.INSTANCE.constrainedMap(0f, 1f, v4, this.getScaleFromKey(FontScaleConverterFactory.sLookupTables.keyAt(v0_1)), v7));
        this.put(v7, v9);
        return v9;
    }

    private final FontScaleConverter get(float arg2) {
        return FontScaleConverterFactory.sLookupTables.get(this.getKey(arg2));
    }

    private final int getKey(float arg1) {
        return ((int)(arg1 * 100f));
    }

    public final SparseArrayCompat getSLookupTables() {
        return FontScaleConverterFactory.sLookupTables;
    }

    public static void getSLookupTables$annotations() {
    }

    private final float getScaleFromKey(int arg1) {
        return (((float)arg1)) / 100f;
    }

    public final boolean isNonLinearFontScalingActive(float arg1) {
        if(arg1 >= 1.03f) {
            return 1;
        }

        return 0;
    }

    private final void put(float arg3, FontScaleConverter arg4) {
        Object[] v2 = FontScaleConverterFactory.LookupTablesWriteLock;
        __monitor_enter(v2);
        try {
            FontScaleConverterFactory v0 = FontScaleConverterFactory.INSTANCE;
            SparseArrayCompat v1 = FontScaleConverterFactory.sLookupTables.clone();
            v0.putInto(v1, arg3, arg4);
            FontScaleConverterFactory.sLookupTables = v1;
        }
        catch(Throwable v3) {
            __monitor_exit(v2);
            throw v3;
        }

        __monitor_exit(v2);
    }

    private final void putInto(SparseArrayCompat arg1, float arg2, FontScaleConverter arg3) {
        arg1.put(this.getKey(arg2), arg3);
    }

    public final void setSLookupTables(SparseArrayCompat arg1) {
        FontScaleConverterFactory.sLookupTables = arg1;
    }
}

