package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000EJ\u001F\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010\b\u001A\u00028\u0001H¦\u0080\u0004¢\u0006\u0002\u0010\tR\u001F\u0010\n\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000BX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2={"Lkotlin/reflect/KMutableProperty1;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/KMutableProperty;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "setter", "Lkotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "Setter", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface KMutableProperty1 extends KMutableProperty, KProperty1 {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2={"Lkotlin/reflect/KMutableProperty1$Setter;", "T", "V", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function2;", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface Setter extends Function2, kotlin.reflect.KMutableProperty$Setter {
    }

    Setter getSetter();

    void set(Object arg1, Object arg2);
}

