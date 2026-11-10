package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u000B\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, d2={"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "<init>", "(Landroidx/compose/material3/internal/DateInputFormat;)V", "firstDelimiterOffset", "", "secondDelimiterOffset", "dateFormatLength", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DateVisualTransformation implements VisualTransformation {
    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator;
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;

    public DateVisualTransformation(DateInputFormat arg8) {
        super();
        this.dateInputFormat = arg8;
        this.firstDelimiterOffset = StringsKt.indexOf$default(arg8.getPatternWithDelimiters(), arg8.getDelimiter(), 0, false, 6, null);
        this.secondDelimiterOffset = StringsKt.lastIndexOf$default(arg8.getPatternWithDelimiters(), arg8.getDelimiter(), 0, false, 6, null);
        this.dateFormatLength = arg8.getPatternWithoutDelimiters().length();
        this.dateOffsetTranslator = new DateVisualTransformation$dateOffsetTranslator$1(this);
    }

    public static final int access$getDateFormatLength$p(DateVisualTransformation arg0) {
        return arg0.dateFormatLength;
    }

    public static final int access$getFirstDelimiterOffset$p(DateVisualTransformation arg0) {
        return arg0.firstDelimiterOffset;
    }

    public static final int access$getSecondDelimiterOffset$p(DateVisualTransformation arg0) {
        return arg0.secondDelimiterOffset;
    }

    public TransformedText filter(AnnotatedString arg7) {
        int v2 = 0;
        String v7 = arg7.getText().length() > this.dateFormatLength ? StringsKt.substring(arg7.getText(), RangesKt.until(0, this.dateFormatLength)) : arg7.getText();
        String v0 = "";
        int v1;
        for(v1 = 0; v2 < ((CharSequence)v7).length(); v1 = v4) {
            int v4 = v1 + 1;
            v0 = v0 + ((CharSequence)v7).charAt(v2);
            if(v4 == this.firstDelimiterOffset || v1 + 2 == this.secondDelimiterOffset) {
                v0 = v0 + this.dateInputFormat.getDelimiter();
            }

            ++v2;
        }

        return new TransformedText(new AnnotatedString(v0, null, 2, null), this.dateOffsetTranslator);
    }
}

