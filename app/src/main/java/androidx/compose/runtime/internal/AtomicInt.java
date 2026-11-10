package androidx.compose.runtime.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0017¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/internal/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "value", "", "<init>", "(I)V", "add", "amount", "toByte", "", "toShort", "", "toChar", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AtomicInt extends AtomicInteger {
    public static final int $stable = 8;

    static {
    }

    public AtomicInt(int arg1) {
        super(arg1);
    }

    public final int add(int arg1) {
        return this.addAndGet(arg1);
    }

    public final byte byteValue() {
        return this.toByte();
    }

    public final double doubleValue() {
        return this.toDouble();
    }

    public final float floatValue() {
        return this.toFloat();
    }

    public final int intValue() {
        return this.toInt();
    }

    public final long longValue() {
        return this.toLong();
    }

    public final short shortValue() {
        return this.toShort();
    }

    public byte toByte() {
        return ((byte)this.intValue());
    }

    @Deprecated(message="Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it\'s recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith="<_subannotation>") public char toChar() {
        return ((char)this.intValue());
    }

    public double toDouble() {
        return super.doubleValue();
    }

    public float toFloat() {
        return super.floatValue();
    }

    public int toInt() {
        return super.intValue();
    }

    public long toLong() {
        return super.longValue();
    }

    public short toShort() {
        return ((short)this.intValue());
    }
}

