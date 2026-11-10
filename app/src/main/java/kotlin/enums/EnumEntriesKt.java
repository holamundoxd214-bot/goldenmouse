package kotlin.enums;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000E\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00070\u0006H\u0081\u0080\u0004\u001A3\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000E\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0081\u0080\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"enumEntries", "Lkotlin/enums/EnumEntries;", "T", "", "E", "entriesProvider", "Lkotlin/Function0;", "", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class EnumEntriesKt {
    public static final EnumEntries enumEntries(Enum[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "entries");
        return new EnumEntriesList(arg1);
    }

    public static final EnumEntries enumEntries() {
        throw new NotImplementedError(null, 1, null);
    }

    public static final EnumEntries enumEntries(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "entriesProvider");
        return new EnumEntriesList(arg1.invoke());
    }
}

