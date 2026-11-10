package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u000B\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u0013H\'J\u0010\u0010\u001F\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u0003H\'J\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001E\u001A\u00020\u0013H\'J\u0010\u0010\"\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0013H\'J\u0010\u0010#\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u0013H\'R\u001A\u0010\u0002\u001A\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u000E8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0005\u001A\u0004\b\r\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010R\u001A\u0010\u0012\u001A\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001A\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001A\u0010\u0005\u001A\u0004\b\u001B\u0010\u001C¨\u0006$"}, d2={"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "serialName", "", "getSerialName$annotations", "()V", "getSerialName", "()Ljava/lang/String;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind$annotations", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "isNullable", "", "isNullable$annotations", "()Z", "isInline", "elementsCount", "", "getElementsCount$annotations", "getElementsCount", "()I", "annotations", "", "", "getAnnotations$annotations", "getAnnotations", "()Ljava/util/List;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SerialDescriptor {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static List getAnnotations(SerialDescriptor arg0) {
            return CollectionsKt.emptyList();
        }

        @ExperimentalSerializationApi public static void getAnnotations$annotations() {
        }

        @ExperimentalSerializationApi public static void getElementsCount$annotations() {
        }

        @ExperimentalSerializationApi public static void getKind$annotations() {
        }

        @ExperimentalSerializationApi public static void getSerialName$annotations() {
        }

        public static boolean isInline(SerialDescriptor arg0) {
            return 0;
        }

        public static boolean isNullable(SerialDescriptor arg0) {
            return 0;
        }

        @ExperimentalSerializationApi public static void isNullable$annotations() {
        }
    }

    List getAnnotations();

    @ExperimentalSerializationApi List getElementAnnotations(int arg1);

    @ExperimentalSerializationApi SerialDescriptor getElementDescriptor(int arg1);

    @ExperimentalSerializationApi int getElementIndex(String arg1);

    @ExperimentalSerializationApi String getElementName(int arg1);

    int getElementsCount();

    SerialKind getKind();

    String getSerialName();

    @ExperimentalSerializationApi boolean isElementOptional(int arg1);

    boolean isInline();

    boolean isNullable();
}

