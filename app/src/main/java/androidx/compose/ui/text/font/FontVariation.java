package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0015\u0004\u001E\u001F B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tJ\u0015\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u000E\u0010\u0010\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\u0011\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0013J\u000E\u0010\u0014\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0013J1\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0012\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0012\u0010\u001A\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001B\"\u00020\u0005¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006!"}, d2={"Landroidx/compose/ui/text/font/FontVariation;", "", "<init>", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", "width", "weight", "", "grade", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "settings", "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "SettingFloat", "SettingTextUnit", "SettingInt", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontVariation {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0082\u0001\u0003\u000E\u000F\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "axisName", "", "getAxisName", "()Ljava/lang/String;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Setting {
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(Density arg1);
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001A\u00020\u00052\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016J\u0013\u0010\u0013\u001A\u00020\u00102\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2={"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()F", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class SettingFloat implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(String arg1, float arg2) {
            super();
            this.axisName = arg1;
            this.value = arg2;
        }

        public boolean equals(Object arg5) {
            if(this == (((SettingFloat)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof SettingFloat)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getAxisName(), ((SettingFloat)arg5).getAxisName())) {
                return 0;
            }

            if(this.value == ((SettingFloat)arg5).value) {
                return 1;
            }

            return 0;
        }

        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.getAxisName().hashCode() * 0x1F + Float.hashCode(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName=\'" + this.getAxisName() + "\', value=" + this.value + ')';
        }

        public float toVariationValue(Density arg1) {
            return this.value;
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0016J\u0013\u0010\u0014\u001A\u00020\u00112\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0005H\u0016J\b\u0010\u0018\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2={"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()I", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class SettingInt implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(String arg1, int arg2) {
            super();
            this.axisName = arg1;
            this.value = arg2;
        }

        public boolean equals(Object arg5) {
            if(this == (((SettingInt)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof SettingInt)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getAxisName(), ((SettingInt)arg5).getAxisName())) {
                return 0;
            }

            if(this.value != ((SettingInt)arg5).value) {
                return 0;
            }

            return 1;
        }

        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.getAxisName().hashCode() * 0x1F + this.value;
        }

        public String toString() {
            return "FontVariation.Setting(axisName=\'" + this.getAxisName() + "\', value=" + this.value + ')';
        }

        public float toVariationValue(Density arg1) {
            return ((float)this.value);
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010\u0015\u001A\u00020\u00122\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0011\u001A\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "<init>", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "getValue-XSAIIZE", "()J", "J", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class SettingTextUnit implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        public SettingTextUnit(String arg1, long arg2, DefaultConstructorMarker arg4) {
            this(arg1, arg2);
        }

        private SettingTextUnit(String arg1, long arg2) {
            super();
            this.axisName = arg1;
            this.value = arg2;
            this.needsDensity = true;
        }

        public boolean equals(Object arg6) {
            if(this == (((SettingTextUnit)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof SettingTextUnit)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getAxisName(), ((SettingTextUnit)arg6).getAxisName())) {
                return 0;
            }

            if(!TextUnit.equals-impl0(this.value, ((SettingTextUnit)arg6).value)) {
                return 0;
            }

            return 1;
        }

        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final long getValue-XSAIIZE() {
            return this.value;
        }

        public int hashCode() {
            return this.getAxisName().hashCode() * 0x1F + TextUnit.hashCode-impl(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName=\'" + this.getAxisName() + "\', value=" + TextUnit.toString-impl(this.value) + ')';
        }

        public float toVariationValue(Density arg3) {
            if(arg3 != null) {
                return TextUnit.getValue-impl(this.value) * arg3.getFontScale();
            }

            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("density must not be null");
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000E\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", "settings", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "<init>", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "", "getSettings", "()Ljava/util/List;", "needsDensity", "", "getNeedsDensity$ui_text", "()Z", "equals", "other", "hashCode", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Settings {
        public static final int $stable;
        private final boolean needsDensity;
        private final List settings;

        static {
        }

        public Settings(Setting[] arg12) {
            Object v4_1;
            Object v1_1;
            ArrayList v6_1;
            super();
            LinkedHashMap v0 = new LinkedHashMap();
            int v1 = arg12.length;
            boolean v2 = false;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Setting v4 = arg12[v3];
                String v5 = v4.getAxisName();
                Object v6 = ((Map)v0).get(v5);
                if(v6 == null) {
                    v6_1 = new ArrayList();
                    ((Map)v0).put(v5, v6_1);
                }

                ((List)v6_1).add(v4);
            }

            ArrayList v12 = new ArrayList();
            Iterator v0_1 = ((Map)v0).entrySet().iterator();
            while(true) {
                if(!v0_1.hasNext()) {
                    goto label_55;
                }

                v1_1 = v0_1.next();
                v4_1 = ((Map$Entry)v1_1).getKey();
                v1_1 = ((Map$Entry)v1_1).getValue();
                if(((List)v1_1).size() != 1) {
                    break;
                }

                CollectionsKt.addAll(((Collection)v12), ((Iterable)v1_1));
            }

            throw new IllegalArgumentException("\'" + (((String)v4_1)) + "\' must be unique. Actual [ [" + CollectionsKt.joinToString$default(v1_1, null, null, null, 0, null, null, 0x3F, null) + ']'.toString());
        label_55:
            ArrayList v0_2 = new ArrayList(((Collection)v12));
            this.settings = ((List)v0_2);
            int v12_1 = v0_2.size();
            v1 = 0;
            while(v1 < v12_1) {
                if(((List)v0_2).get(v1).getNeedsDensity()) {
                    v2 = true;
                }
                else {
                    ++v1;
                    continue;
                }

                break;
            }

            this.needsDensity = v2;
        }

        public boolean equals(Object arg4) {
            if(this == (((Settings)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Settings)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.settings, ((Settings)arg4).settings)) {
                return 0;
            }

            return 1;
        }

        public final boolean getNeedsDensity$ui_text() {
            return this.needsDensity;
        }

        public final List getSettings() {
            return this.settings;
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    public static final int $stable;
    public static final FontVariation INSTANCE;

    static {
        FontVariation.INSTANCE = new FontVariation();
    }

    private FontVariation() {
        super();
    }

    public final Setting Setting(String arg2, float arg3) {
        int v1 = arg2.length() == 4 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Name must be exactly four characters. Actual: \'" + arg2 + '\'');
        }

        return new SettingFloat(arg2, arg3);
    }

    public final Settings Settings-6EWAqTQ(FontWeight arg4, int arg5, Setting[] arg6) {
        SpreadBuilder v1 = new SpreadBuilder(3);
        v1.add(this.weight(arg4.getWeight()));
        v1.add(this.italic(((float)arg5)));
        v1.addSpread(arg6);
        return new Settings(v1.toArray(new Setting[v1.size()]));
    }

    public final Setting grade(int arg2) {
        int v0 = 0;
        if(-1000 <= arg2 && arg2 < 1001) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("\'GRAD\' must be in -1000..1000");
        }

        return new SettingInt("GRAD", arg2);
    }

    public final Setting italic(float arg2) {
        int v0 = 0;
        if(Float.compare(0f, arg2) <= 0 && arg2 <= 1f) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("\'ital\' must be in 0.0f..1.0f. Actual: " + arg2);
        }

        return new SettingFloat("ital", arg2);
    }

    public final Setting opticalSizing--R2X_6o(long arg3) {
        if(!TextUnit.isSp-impl(arg3)) {
            InlineClassHelperKt.throwIllegalArgumentException("\'opsz\' must be provided in sp units");
        }

        return new SettingTextUnit("opsz", arg3, null);
    }

    public final Setting slant(float arg2) {
        int v0 = 0;
        if(Float.compare(-90f, arg2) <= 0 && arg2 <= 90f) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("\'slnt\' must be in -90f..90f. Actual: " + arg2);
        }

        return new SettingFloat("slnt", arg2);
    }

    public final Setting weight(int arg3) {
        int v2 = 0;
        if(1 <= arg3 && arg3 < 1001) {
            v2 = 1;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("\'wght\' value must be in [1, 1000]. Actual: " + arg3);
        }

        return new SettingInt("wght", arg3);
    }

    public final Setting width(float arg2) {
        int v1 = arg2 > 0f ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("\'wdth\' must be strictly > 0.0f. Actual: " + arg2);
        }

        return new SettingFloat("wdth", arg2);
    }
}

