package androidx.compose.runtime.retain;

import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\bH\u0016R\u001C\u0010\u0002\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0015\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/retain/RetainKeys;", "", "keys", "", "positionalKey", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "typeHash", "", "<init>", "([Ljava/lang/Object;JI)V", "[Ljava/lang/Object;", "getPositionalKey", "()J", "getTypeHash", "()I", "equals", "", "other", "hashCode", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) final class RetainKeys {
    private final Object[] keys;
    private final long positionalKey;
    private final int typeHash;

    public RetainKeys(Object[] arg1, long arg2, int arg4) {
        super();
        this.keys = arg1;
        this.positionalKey = arg2;
        this.typeHash = arg4;
    }

    public boolean equals(Object arg5) {
        if(((arg5 instanceof RetainKeys)) && ((RetainKeys)arg5).positionalKey == this.positionalKey && ((RetainKeys)arg5).typeHash == this.typeHash && (Arrays.equals(((RetainKeys)arg5).keys, this.keys))) {
            return 1;
        }

        return 0;
    }

    public final long getPositionalKey() {
        return this.positionalKey;
    }

    public final int getTypeHash() {
        return this.typeHash;
    }

    public int hashCode() {
        Object[] v0 = this.keys;
        int v0_1 = v0 != null ? Arrays.hashCode(v0) : 0;
        return (v0_1 * 0x1F + Long.hashCode(this.positionalKey)) * 0x1F + Integer.hashCode(this.typeHash);
    }
}

