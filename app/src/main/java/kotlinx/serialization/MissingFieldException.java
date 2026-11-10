package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001F\b\u0016\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\n\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\u000BB\u0019\b\u0016\u0012\u0006\u0010\f\u001A\u00020\u0004\u0012\u0006\u0010\n\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\rB\u0011\b\u0011\u0012\u0006\u0010\f\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\u000ER\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "missingFields", "", "", "message", "cause", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Throwable;)V", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "missingField", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "getMissingFields", "()Ljava/util/List;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public final class MissingFieldException extends SerializationException {
    private final List missingFields;

    public MissingFieldException(String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "missingField");
        this(CollectionsKt.listOf(arg4), "Field \'" + arg4 + "\' is required, but it was missing", null);
    }

    public MissingFieldException(List arg2, String arg3, Throwable arg4) {
        Intrinsics.checkNotNullParameter(arg2, "missingFields");
        super(arg3, arg4);
        this.missingFields = arg2;
    }

    public MissingFieldException(String arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "missingField");
        Intrinsics.checkNotNullParameter(arg5, "serialName");
        this(CollectionsKt.listOf(arg4), "Field \'" + arg4 + "\' is required for type with serial name \'" + arg5 + "\', but it was missing", null);
    }

    public MissingFieldException(List arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "missingFields");
        Intrinsics.checkNotNullParameter(arg4, "serialName");
        arg4 = arg3.size() == 1 ? "Field \'" + arg3.get(0) + "\' is required for type with serial name \'" + arg4 + "\', but it was missing" : "Fields " + arg3 + " are required for type with serial name \'" + arg4 + "\', but they were missing";
        this(arg3, arg4, null);
    }

    public final List getMissingFields() {
        return this.missingFields;
    }
}

