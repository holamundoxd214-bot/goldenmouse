package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.TYPE}) @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0016\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0098\u0001\bF\u0012\u000E\b\u0002\u0010\u0002\u001A\u00020\u0003B\u0004\b\u0003\u0010\u0002\u0012\f\b\u0002\u0010\u0004\u001A\u00020\u0005B\u0002\b\f\u0012\u001E\b\u0002\u0010\u0006\u001A\u00020\u0005B\u0014\b\fJ\u0004\b\u0003\u0010\u0002J\u0004\b\u0003\u0010\u0000J\u0004\b\u0003\u0010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u0012\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u000E\b\u0002\u0010\u000B\u001A\u00020\tB\u0004\b\b(\f\u0012\u000E\b\u0002\u0010\r\u001A\u00020\tB\u0004\b\b(\f\u0012\u000E\b\u0002\u0010\u000E\u001A\u00020\u0003B\u0004\b\u0003\u0010\u0000R\u0015\u0010\u0002\u001A\u00020\u00038\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\u0004\u001A\u00020\u00058\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001A\u00020\u0005X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0012R\u001B\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001B\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0017R\u0015\u0010\u000B\u001A\u00020\t8\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0019\u0010\r\u001A\u00020\tX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001B\u0010\u0014\u001A\u0004\b\u001C\u0010\u001AR\u0019\u0010\u000E\u001A\u00020\u0003X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001D\u0010\u0014\u001A\u0004\b\u001E\u0010\u0010¨\u0006\u001F"}, d2={"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "", "packageName", "extraInt", "k", "()I", "mv", "()[I", "bv$annotations", "()V", "bv", "d1", "()[Ljava/lang/String;", "d2", "xs", "()Ljava/lang/String;", "pn$annotations", "pn", "xi$annotations", "xi", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.RUNTIME) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS}) @public interface Metadata {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.WARNING, message="Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.") public static void bv$annotations() {
        }

        public static void pn$annotations() {
        }

        public static void xi$annotations() {
        }
    }

    int[] bv();

    String[] d1();

    String[] d2();

    int k();

    int[] mv();

    String pn();

    int xi();

    String xs();
}

