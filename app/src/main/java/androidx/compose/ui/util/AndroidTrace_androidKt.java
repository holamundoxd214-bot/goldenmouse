package androidx.compose.ui.util;

import android.os.Build$VERSION;
import android.os.Trace;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001A*\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001A\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B¨\u0006\f"}, d2={"trace", "T", "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "traceValue", "", "tag", "value", "", "ui-util"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTrace_androidKt {
    public static final Object trace(String arg0, Function0 arg1) {
        Object v0_1;
        Trace.beginSection(arg0);
        try {
            v0_1 = arg1.invoke();
        }
        catch(Throwable v0) {
            Trace.endSection();
            throw v0;
        }

        Trace.endSection();
        return v0_1;
    }

    public static final void traceValue(String arg2, long arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Trace.setCounter(arg2, arg3);
        }
    }
}

