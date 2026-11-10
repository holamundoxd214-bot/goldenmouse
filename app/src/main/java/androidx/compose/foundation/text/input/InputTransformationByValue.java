package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u00126\u0010\u0002\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001A\u00020\u000E*\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J9\u0010\u0012\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JC\u0010\u0013\u001A\u00020\u000028\b\u0002\u0010\u0002\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001RA\u0010\u0002\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getTransformation", "()Lkotlin/jvm/functions/Function2;", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class InputTransformationByValue implements InputTransformation {
    private final Function2 transformation;

    public InputTransformationByValue(Function2 arg1) {
        super();
        this.transformation = arg1;
    }

    public final Function2 component1() {
        return this.transformation;
    }

    public final InputTransformationByValue copy(Function2 arg1) {
        return new InputTransformationByValue(arg1);
    }

    public static InputTransformationByValue copy$default(InputTransformationByValue arg0, Function2 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.transformation;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((InputTransformationByValue)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof InputTransformationByValue)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.transformation, ((InputTransformationByValue)arg4).transformation)) {
            return 0;
        }

        return 1;
    }

    public final Function2 getTransformation() {
        return this.transformation;
    }

    public int hashCode() {
        return this.transformation.hashCode();
    }

    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.transformation + ')';
    }

    public void transformInput(TextFieldBuffer arg9) {
        TextFieldBuffer v0 = arg9;
        TextFieldCharSequence v9 = TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(v0, 0, null, null, null, 15, null);
        Object v8 = this.transformation.invoke(v0.getOriginalValue$foundation(), v9);
        if((((TextFieldCharSequence)v8)) == v9) {
            return;
        }

        if(v8 == v0.getOriginalValue$foundation()) {
            v0.revertAllChanges();
            return;
        }

        v0.setTextIfChanged$foundation(((CharSequence)v8));
    }
}

