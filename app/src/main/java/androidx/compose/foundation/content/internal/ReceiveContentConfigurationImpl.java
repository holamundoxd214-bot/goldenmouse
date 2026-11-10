package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/content/internal/ReceiveContentConfigurationImpl;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "<init>", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ReceiveContentConfigurationImpl extends ReceiveContentConfiguration {
    private final ReceiveContentListener receiveContentListener;

    public ReceiveContentConfigurationImpl(ReceiveContentListener arg1) {
        super();
        this.receiveContentListener = arg1;
    }

    public final ReceiveContentListener component1() {
        return this.receiveContentListener;
    }

    public final ReceiveContentConfigurationImpl copy(ReceiveContentListener arg1) {
        return new ReceiveContentConfigurationImpl(arg1);
    }

    public static ReceiveContentConfigurationImpl copy$default(ReceiveContentConfigurationImpl arg0, ReceiveContentListener arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.receiveContentListener;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((ReceiveContentConfigurationImpl)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ReceiveContentConfigurationImpl)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.receiveContentListener, ((ReceiveContentConfigurationImpl)arg4).receiveContentListener)) {
            return 0;
        }

        return 1;
    }

    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public int hashCode() {
        return this.receiveContentListener.hashCode();
    }

    public String toString() {
        return "ReceiveContentConfigurationImpl(receiveContentListener=" + this.receiveContentListener + ')';
    }
}

