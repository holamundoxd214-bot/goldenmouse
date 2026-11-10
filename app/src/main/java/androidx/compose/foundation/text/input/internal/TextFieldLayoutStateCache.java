package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0003JKLB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020#J-\u0010$\u001A\u00020\u00022\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u000FH\u0002J\"\u00100\u001A\u00020\u001A2\u0017\u00101\u001A\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001A02¢\u0006\u0002\b4H\u0082\bJ\u0010\u00107\u001A\u0002062\u0006\u0010\u0010\u001A\u00020\u000FH\u0002J:\u00108\u001A\u00020\u00022\u0006\u00109\u001A\u00020:2\u0018\u0010;\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020>0=j\u0002`?\u0018\u00010<2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u000FH\u0002J\u0010\u0010E\u001A\u00020\u001A2\u0006\u0010\u0016\u001A\u00020BH\u0016J \u0010F\u001A\u00020B2\u0006\u0010G\u001A\u00020B2\u0006\u0010H\u001A\u00020B2\u0006\u0010I\u001A\u00020BH\u0016R/\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u00078B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR/\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0006\u001A\u0004\u0018\u00010\u000F8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001A\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0010\u00105\u001A\u0004\u0018\u000106X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u000203X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010A\u001A\u00020B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bC\u0010D¨\u0006M"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/runtime/snapshots/StateObject;", "<init>", "()V", "<set-?>", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "nonMeasureInputs", "getNonMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "setNonMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;)V", "nonMeasureInputs$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "measureInputs", "getMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "setMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;)V", "measureInputs$delegate", "value", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "layoutWithNewMeasureInputs", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "getOrComputeLayout", "updateCacheIfWritable", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Lkotlin/ExtensionFunctionType;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "obtainTextMeasurer", "computeLayout", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "record", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "mergeRecords", "previous", "current", "applied", "CacheRecord", "NonMeasureInputs", "MeasureInputs", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldLayoutStateCache implements State, StateObject {
    @Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010J\u001A\u00020\u0001H\u0016J\u0010\u0010K\u001A\u00020L2\u0006\u0010M\u001A\u00020\u0001H\u0016J\b\u0010N\u001A\u00020OH\u0016R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000E\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001A\u0010\u001F\u001A\u00020 X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001A\u0010%\u001A\u00020 X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\"\"\u0004\b\'\u0010$R\u001A\u0010(\u001A\u00020)X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001A\u0010.\u001A\u00020)X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001C\u00101\u001A\u0004\u0018\u000102X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\u001C\u00107\u001A\u0004\u0018\u000108X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001C\u0010=\u001A\u00020>X\u0086\u000E¢\u0006\u0010\n\u0002\u0010C\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001C\u0010D\u001A\u0004\u0018\u00010EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006P"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "<init>", "()V", "visualText", "", "getVisualText", "()Ljava/lang/CharSequence;", "setVisualText", "(Ljava/lang/CharSequence;)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "composition", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "setTextStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "singleLine", "", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "softWrap", "getSoftWrap", "setSoftWrap", "densityValue", "", "getDensityValue", "()F", "setDensityValue", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "setConstraints-BRTryo0", "(J)V", "J", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "create", "assign", "", "value", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class CacheRecord extends StateRecord {
        private List annotations;
        private TextRange composition;
        private long constraints;
        private float densityValue;
        private Resolver fontFamilyResolver;
        private float fontScale;
        private LayoutDirection layoutDirection;
        private TextLayoutResult layoutResult;
        private boolean singleLine;
        private boolean softWrap;
        private TextStyle textStyle;
        private CharSequence visualText;

        public CacheRecord() {
            super();
            this.densityValue = NaNf;
            this.fontScale = NaNf;
            this.constraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        }

        public void assign(StateRecord arg3) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
            this.visualText = ((CacheRecord)arg3).visualText;
            this.annotations = ((CacheRecord)arg3).annotations;
            this.composition = ((CacheRecord)arg3).composition;
            this.textStyle = ((CacheRecord)arg3).textStyle;
            this.singleLine = ((CacheRecord)arg3).singleLine;
            this.softWrap = ((CacheRecord)arg3).softWrap;
            this.densityValue = ((CacheRecord)arg3).densityValue;
            this.fontScale = ((CacheRecord)arg3).fontScale;
            this.layoutDirection = ((CacheRecord)arg3).layoutDirection;
            this.fontFamilyResolver = ((CacheRecord)arg3).fontFamilyResolver;
            this.constraints = ((CacheRecord)arg3).constraints;
            this.layoutResult = ((CacheRecord)arg3).layoutResult;
        }

        public StateRecord create() {
            return new CacheRecord();
        }

        public final List getAnnotations() {
            return this.annotations;
        }

        public final TextRange getComposition-MzsxiRA() {
            return this.composition;
        }

        public final long getConstraints-msEJaDk() {
            return this.constraints;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final TextLayoutResult getLayoutResult() {
            return this.layoutResult;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final CharSequence getVisualText() {
            return this.visualText;
        }

        public final void setAnnotations(List arg1) {
            this.annotations = arg1;
        }

        public final void setComposition-OEnZFl4(TextRange arg1) {
            this.composition = arg1;
        }

        public final void setConstraints-BRTryo0(long arg1) {
            this.constraints = arg1;
        }

        public final void setDensityValue(float arg1) {
            this.densityValue = arg1;
        }

        public final void setFontFamilyResolver(Resolver arg1) {
            this.fontFamilyResolver = arg1;
        }

        public final void setFontScale(float arg1) {
            this.fontScale = arg1;
        }

        public final void setLayoutDirection(LayoutDirection arg1) {
            this.layoutDirection = arg1;
        }

        public final void setLayoutResult(TextLayoutResult arg1) {
            this.layoutResult = arg1;
        }

        public final void setSingleLine(boolean arg1) {
            this.singleLine = arg1;
        }

        public final void setSoftWrap(boolean arg1) {
            this.softWrap = arg1;
        }

        public final void setTextStyle(TextStyle arg1) {
            this.textStyle = arg1;
        }

        public final void setVisualText(CharSequence arg1) {
            this.visualText = arg1;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("CacheRecord(visualText=");
            v0.append(this.visualText).append(", annotations=").append(this.annotations).append(", composition=").append(this.composition).append(", textStyle=").append(this.textStyle).append(", singleLine=").append(this.singleLine).append(", softWrap=").append(this.softWrap).append(", densityValue=").append(this.densityValue).append(", fontScale=").append(this.fontScale).append(", layoutDirection=").append(this.layoutDirection).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", constraints=").append(Constraints.toString-impl(this.constraints)).append(", layoutResult=");
            v0.append(this.layoutResult).append(')');
            return v0.toString();
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getConstraints-msEJaDk", "()J", "J", "densityValue", "", "getDensityValue", "()F", "fontScale", "getFontScale", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MeasureInputs {
        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs$Companion;", "", "<init>", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final SnapshotMutationPolicy getMutationPolicy() {
                return MeasureInputs.mutationPolicy;
            }
        }

        public static final Companion Companion;
        private final long constraints;
        private final Density density;
        private final float densityValue;
        private final Resolver fontFamilyResolver;
        private final float fontScale;
        private final LayoutDirection layoutDirection;
        private static final SnapshotMutationPolicy mutationPolicy;

        static {
            MeasureInputs.Companion = new Companion(null);
            MeasureInputs.mutationPolicy = new TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1();
        }

        public MeasureInputs(Density arg1, LayoutDirection arg2, Resolver arg3, long arg4, DefaultConstructorMarker arg6) {
            this(arg1, arg2, arg3, arg4);
        }

        private MeasureInputs(Density arg1, LayoutDirection arg2, Resolver arg3, long arg4) {
            super();
            this.density = arg1;
            this.layoutDirection = arg2;
            this.fontFamilyResolver = arg3;
            this.constraints = arg4;
            this.densityValue = arg1.getDensity();
            this.fontScale = arg1.getFontScale();
        }

        public static final SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return MeasureInputs.mutationPolicy;
        }

        public final long getConstraints-msEJaDk() {
            return this.constraints;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public String toString() {
            return "MeasureInputs(density=" + this.density + ", densityValue=" + this.densityValue + ", fontScale=" + this.fontScale + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.toString-impl(this.constraints) + ')';
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0011¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "isKeyboardTypePhone", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZZZ)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getSingleLine", "()Z", "getSoftWrap", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class NonMeasureInputs {
        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs$Companion;", "", "<init>", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion {
            public androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion() {
                super();
            }

            public final SnapshotMutationPolicy getMutationPolicy() {
                return NonMeasureInputs.mutationPolicy;
            }
        }

        public static final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion Companion;
        private final boolean isKeyboardTypePhone;
        private static final SnapshotMutationPolicy mutationPolicy;
        private final boolean singleLine;
        private final boolean softWrap;
        private final TransformedTextFieldState textFieldState;
        private final TextStyle textStyle;

        static {
            NonMeasureInputs.Companion = new androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion(null);
            NonMeasureInputs.mutationPolicy = new TextFieldLayoutStateCache$NonMeasureInputs$Companion$mutationPolicy$1();
        }

        public NonMeasureInputs(TransformedTextFieldState arg1, TextStyle arg2, boolean arg3, boolean arg4, boolean arg5) {
            super();
            this.textFieldState = arg1;
            this.textStyle = arg2;
            this.singleLine = arg3;
            this.softWrap = arg4;
            this.isKeyboardTypePhone = arg5;
        }

        public static final SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return NonMeasureInputs.mutationPolicy;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final TransformedTextFieldState getTextFieldState() {
            return this.textFieldState;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final boolean isKeyboardTypePhone() {
            return this.isKeyboardTypePhone;
        }

        public String toString() {
            return "NonMeasureInputs(textFieldState=" + this.textFieldState + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", softWrap=" + this.softWrap + ", isKeyboardTypePhone=" + this.isKeyboardTypePhone + ')';
        }
    }

    public static final int $stable;
    private final MutableState measureInputs$delegate;
    private final MutableState nonMeasureInputs$delegate;
    private CacheRecord record;
    private TextMeasurer textMeasurer;

    static {
    }

    public TextFieldLayoutStateCache() {
        super();
        this.nonMeasureInputs$delegate = SnapshotStateKt.mutableStateOf(null, NonMeasureInputs.Companion.getMutationPolicy());
        this.measureInputs$delegate = SnapshotStateKt.mutableStateOf(null, MeasureInputs.Companion.getMutationPolicy());
        this.record = new CacheRecord();
    }

    private final TextLayoutResult computeLayout(TextFieldCharSequence arg36, List arg37, NonMeasureInputs arg38, MeasureInputs arg39) {
        TextStyle v2_2;
        Locale v2_1;
        TextMeasurer v0 = this.obtainTextMeasurer(arg39);
        if(arg38.isKeyboardTypePhone()) {
            LocaleList v2 = arg38.getTextStyle().getLocaleList();
            if(v2 != null) {
                v2_1 = v2.get(0);
                if(v2_1 == null) {
                    goto label_11;
                }
            }
            else {
            label_11:
                v2_1 = Locale.Companion.getCurrent();
            }

            v2_2 = arg38.getTextStyle().merge(new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, TextFieldLayoutStateCache_androidKt.resolveTextDirectionForKeyboardTypePhone(v2_1.getPlatformLocale()), 0, null, null, null, 0, 0, null, 0xFEFFFF, null));
        }
        else {
            v2_2 = arg38.getTextStyle();
        }

        String v3 = arg36.toString();
        List v4 = arg37 == null ? CollectionsKt.emptyList() : arg37;
        AnnotatedString v1 = new AnnotatedString(v3, v4);
        boolean v4_1 = arg38.getSoftWrap();
        int v3_1 = arg38.getSingleLine() ? 1 : 0x7FFFFFFF;
        return TextMeasurer.measure-xDpz5zY$default(v0, v1, v2_2, 0, v4_1, v3_1, null, arg39.getConstraints-msEJaDk(), arg39.getLayoutDirection(), arg39.getDensity(), arg39.getFontFamilyResolver(), false, 1060, null);
    }

    public StateRecord getFirstStateRecord() {
        return this.record;
    }

    private final MeasureInputs getMeasureInputs() {
        return this.measureInputs$delegate.getValue();
    }

    private final NonMeasureInputs getNonMeasureInputs() {
        return this.nonMeasureInputs$delegate.getValue();
    }

    private final TextLayoutResult getOrComputeLayout(NonMeasureInputs arg21, MeasureInputs arg22) {
        TextFieldLayoutStateCache v0 = this;
        TextFieldCharSequence v1 = arg21.getTextFieldState().getVisualText();
        List v2 = TextFieldLayoutStateCacheKt.access$mergeNullableLists(v1.getComposingAnnotations(), v1.getOutputAnnotations());
        StateRecord v3 = SnapshotKt.current(v0.record);
        TextLayoutResult v4 = ((CacheRecord)v3).getLayoutResult();
        if(v4 != null) {
            CharSequence v5 = ((CacheRecord)v3).getVisualText();
            if(v5 != null && (StringsKt.contentEquals(v5, v1)) && (Intrinsics.areEqual(((CacheRecord)v3).getAnnotations(), v2)) && (Intrinsics.areEqual(((CacheRecord)v3).getComposition-MzsxiRA(), v1.getComposition-MzsxiRA())) && ((CacheRecord)v3).getSingleLine() == arg21.getSingleLine() && ((CacheRecord)v3).getSoftWrap() == arg21.getSoftWrap() && ((CacheRecord)v3).getLayoutDirection() == arg22.getLayoutDirection() && ((CacheRecord)v3).getDensityValue() == arg22.getDensity().getDensity() && ((CacheRecord)v3).getFontScale() == arg22.getDensity().getFontScale() && (Constraints.equals-impl0(((CacheRecord)v3).getConstraints-msEJaDk(), arg22.getConstraints-msEJaDk())) && (Intrinsics.areEqual(((CacheRecord)v3).getFontFamilyResolver(), arg22.getFontFamilyResolver())) && !v4.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
                TextStyle v5_1 = ((CacheRecord)v3).getTextStyle();
                boolean v6 = false;
                boolean v5_2 = v5_1 != null ? v5_1.hasSameLayoutAffectingAttributes(arg21.getTextStyle()) : false;
                TextStyle v3_1 = ((CacheRecord)v3).getTextStyle();
                if(v3_1 != null) {
                    v6 = v3_1.hasSameDrawAffectingAttributes(arg21.getTextStyle());
                }

                if((v5_2) && (v6)) {
                    return v4;
                }

                if(!v5_2) {
                    goto label_96;
                }

                return TextLayoutResult.copy-O0kMr_c$default(v4, new TextLayoutInput(v4.getLayoutInput().getText(), arg21.getTextStyle(), v4.getLayoutInput().getPlaceholders(), v4.getLayoutInput().getMaxLines(), v4.getLayoutInput().getSoftWrap(), v4.getLayoutInput().getOverflow-gIe3tQ8(), v4.getLayoutInput().getDensity(), v4.getLayoutInput().getLayoutDirection(), v4.getLayoutInput().getFontFamilyResolver(), v4.getLayoutInput().getConstraints-msEJaDk(), null), 0, 2, null);
            }
        }

    label_96:
        NonMeasureInputs v3_2 = arg21;
        MeasureInputs v5_3 = arg22;
        TextLayoutResult v6_1 = v0.computeLayout(v1, v2, v3_2, v5_3);
        if(!Intrinsics.areEqual(v6_1, v4)) {
            Snapshot v4_1 = Snapshot.Companion.getCurrent();
            if(!v4_1.getReadOnly()) {
                CacheRecord v7 = v0.record;
                Object v8 = SnapshotKt.getLock();
                __monitor_enter(v8);
                try {
                    StateRecord v7_1 = SnapshotKt.writableRecord(((StateRecord)v7), ((StateObject)v0), v4_1);
                    ((CacheRecord)v7_1).setVisualText(v1);
                    ((CacheRecord)v7_1).setAnnotations(v2);
                    ((CacheRecord)v7_1).setComposition-OEnZFl4(v1.getComposition-MzsxiRA());
                    ((CacheRecord)v7_1).setSingleLine(v3_2.getSingleLine());
                    ((CacheRecord)v7_1).setSoftWrap(v3_2.getSoftWrap());
                    ((CacheRecord)v7_1).setTextStyle(v3_2.getTextStyle());
                    ((CacheRecord)v7_1).setLayoutDirection(v5_3.getLayoutDirection());
                    ((CacheRecord)v7_1).setDensityValue(v5_3.getDensityValue());
                    ((CacheRecord)v7_1).setFontScale(v5_3.getFontScale());
                    ((CacheRecord)v7_1).setConstraints-BRTryo0(v5_3.getConstraints-msEJaDk());
                    ((CacheRecord)v7_1).setFontFamilyResolver(v5_3.getFontFamilyResolver());
                    ((CacheRecord)v7_1).setLayoutResult(v6_1);
                }
                catch(Throwable v0_1) {
                    __monitor_exit(v8);
                    throw v0_1;
                }

                __monitor_exit(v8);
                SnapshotKt.notifyWrite(v4_1, ((StateObject)v0));
                return v6_1;
            }
        }

        return v6_1;
    }

    public TextLayoutResult getValue() {
        NonMeasureInputs v0 = this.getNonMeasureInputs();
        TextLayoutResult v1 = null;
        if(v0 == null) {
            return v1;
        }

        MeasureInputs v2 = this.getMeasureInputs();
        if(v2 == null) {
            return v1;
        }

        return this.getOrComputeLayout(v0, v2);
    }

    public Object getValue() {
        return this.getValue();
    }

    public final TextLayoutResult layoutWithNewMeasureInputs--hBUhpc(Density arg8, LayoutDirection arg9, Resolver arg10, long arg11) {
        MeasureInputs v0 = new MeasureInputs(arg8, arg9, arg10, arg11, null);
        this.setMeasureInputs(v0);
        NonMeasureInputs v8 = this.getNonMeasureInputs();
        if(v8 != null) {
            return this.getOrComputeLayout(v8, v0);
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Called layoutWithNewMeasureInputs before updateNonMeasureInputs");
        throw new KotlinNothingValueException();
    }

    public StateRecord mergeRecords(StateRecord arg1, StateRecord arg2, StateRecord arg3) {
        return arg3;
    }

    private final TextMeasurer obtainTextMeasurer(MeasureInputs arg5) {
        TextMeasurer v0 = this.textMeasurer;
        if(v0 == null) {
            v0 = new TextMeasurer(arg5.getFontFamilyResolver(), arg5.getDensity(), arg5.getLayoutDirection(), 1);
            this.textMeasurer = v0;
        }

        return v0;
    }

    public void prependStateRecord(StateRecord arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
        this.record = ((CacheRecord)arg2);
    }

    private final void setMeasureInputs(MeasureInputs arg1) {
        this.measureInputs$delegate.setValue(arg1);
    }

    private final void setNonMeasureInputs(NonMeasureInputs arg1) {
        this.nonMeasureInputs$delegate.setValue(arg1);
    }

    private final void updateCacheIfWritable(Function1 arg4) {
        Snapshot v0 = Snapshot.Companion.getCurrent();
        if(!v0.getReadOnly()) {
            CacheRecord v1 = this.record;
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                arg4.invoke(SnapshotKt.writableRecord(((StateRecord)v1), ((StateObject)this), v0));
            }
            catch(Throwable v3) {
                __monitor_exit(v2);
                throw v3;
            }

            __monitor_exit(v2);
            SnapshotKt.notifyWrite(v0, ((StateObject)this));
            return;
        }
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState arg7, TextStyle arg8, boolean arg9, boolean arg10, KeyboardOptions arg11) {
        this.setNonMeasureInputs(new NonMeasureInputs(arg7, arg8, arg9, arg10, KeyboardType.equals-impl0(arg11.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPhone-PjHm6EE())));
    }
}

