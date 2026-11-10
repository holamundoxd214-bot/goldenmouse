package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001D\u0010\u0002\u001A\u0004\u0018\u00010\u00038&X§\u0084\b¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007R!\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8&X§\u0084\b¢\u0006\f\u0012\u0004\b\u000B\u0010\u0005\u001A\u0004\b\f\u0010\rR\u0013\u0010\u000E\u001A\u00020\u000FX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0010¨\u0006\u0011"}, d2={"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "()V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments$annotations", "getArguments", "()Ljava/util/List;", "isMarkedNullable", "", "()Z", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface KType extends KAnnotatedElement {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static void getArguments$annotations() {
        }

        public static void getClassifier$annotations() {
        }
    }

    List getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}

