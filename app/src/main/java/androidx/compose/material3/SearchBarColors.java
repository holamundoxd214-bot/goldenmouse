package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0015"}, d2={"Landroidx/compose/material3/SearchBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "<init>", "(JJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getDividerColor-0d7_KjU", "getInputFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SearchBarColors {
    public static final int $stable;
    private final long containerColor;
    private final long dividerColor;
    private final TextFieldColors inputFieldColors;

    static {
    }

    private SearchBarColors(long arg8, long arg10) {
        this(arg8, arg10, SearchBarKt.access$getUnspecifiedTextFieldColors$p(), null);
    }

    public SearchBarColors(long arg1, long arg3, TextFieldColors arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg5);
    }

    private SearchBarColors(long arg1, long arg3, TextFieldColors arg5) {
        super();
        this.containerColor = arg1;
        this.dividerColor = arg3;
        this.inputFieldColors = arg5;
    }

    @Deprecated(message="Use overload that takes `inputFieldColors", replaceWith="<_subannotation>") public SearchBarColors(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((SearchBarColors)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof SearchBarColors)) {
            return 0;
        }

        if(!Color.equals-impl0(this.containerColor, ((SearchBarColors)arg8).containerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.dividerColor, ((SearchBarColors)arg8).dividerColor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.inputFieldColors, ((SearchBarColors)arg8).inputFieldColors)) {
            return 0;
        }

        return 1;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getDividerColor-0d7_KjU() {
        return this.dividerColor;
    }

    public final TextFieldColors getInputFieldColors() {
        return this.inputFieldColors;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.dividerColor)) * 0x1F + this.inputFieldColors.hashCode();
    }
}

