package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0016J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001A\u00020\tHÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/text/input/internal/MaskCodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "character", "", "<init>", "(C)V", "getCharacter", "()C", "transform", "", "codepointIndex", "codepoint", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MaskCodepointTransformation implements CodepointTransformation {
    private final char character;

    public MaskCodepointTransformation(char arg1) {
        super();
        this.character = arg1;
    }

    public final char component1() {
        return this.character;
    }

    public final MaskCodepointTransformation copy(char arg1) {
        return new MaskCodepointTransformation(arg1);
    }

    public static MaskCodepointTransformation copy$default(MaskCodepointTransformation arg0, char arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.character;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((MaskCodepointTransformation)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof MaskCodepointTransformation)) {
            return 0;
        }

        if(this.character != ((MaskCodepointTransformation)arg4).character) {
            return 0;
        }

        return 1;
    }

    public final char getCharacter() {
        return this.character;
    }

    public int hashCode() {
        return Character.hashCode(this.character);
    }

    public String toString() {
        return "MaskCodepointTransformation(character=" + this.character + ')';
    }

    public int transform(int arg1, int arg2) {
        return this.character;
    }
}

