package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010*\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u001D\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\u001EJ\u000E\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010 \u001A\u00020\u000BH\u0002J\u0010\u0010!\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u000BH\u0002J\b\u0010!\u001A\u00020\u000BH\u0002J\u001D\u0010\"\u001A\u00020#2\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010%J\'\u0010&\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010$\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\'J-\u0010(\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010)\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010*J\u001F\u0010+\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010,\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010-J\u0015\u0010.\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010/\u001A\u00020#2\u0006\u0010,\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00100J?\u00101\u001A\u0002022\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000E\u00103\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u00105J?\u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000E\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001A\u00020\u000BH\u0002¢\u0006\u0002\u00108J\u0016\u00109\u001A\u00020#2\f\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;H\u0016J=\u0010<\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010=\u001A\u00020\u000B2\u000E\u0010>\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0?H\u0002¢\u0006\u0002\u0010@JE\u0010A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001A\u00020\u000B2\u0014\u0010B\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010CJM\u0010D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000B2\u0014\u0010E\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070?H\u0002¢\u0006\u0002\u0010FJ\u001D\u0010/\u001A\u0002022\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010,\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ/\u0010I\u001A\u0002022\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010,\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010JJG\u0010K\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001A\u00020\u000B2\u0006\u0010G\u001A\u00020\u000B2\b\u0010,\u001A\u0004\u0018\u00010\b2\u0006\u0010L\u001A\u00020MH\u0002¢\u0006\u0002\u0010NJ\u001E\u00109\u001A\u00020#2\u0006\u0010G\u001A\u00020\u000B2\f\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;H\u0016J[\u0010K\u001A\u0002022\f\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010O\u001A\u00020\u000B2\u0016\u0010B\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001A\u00020\u000B2\u000E\u0010Q\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010RJU\u0010S\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010T\u001A\u00020\u000B2\u0006\u0010O\u001A\u00020\u000B2\u0016\u0010B\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001A\u00020\u000B2\u000E\u0010Q\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010UJk\u0010V\u001A\u0002022\f\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u0010G\u001A\u00020\u000B2\u000E\u0010W\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010X\u001A\u00020\u000B2\u0016\u0010B\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010P\u001A\u00020\u000B2\u000E\u0010Q\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001A\u00028\u00002\u0006\u0010G\u001A\u00020\u000BH\u0096\u0002¢\u0006\u0002\u0010[J\u001D\u0010\\\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010G\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010]J\u0015\u0010^\u001A\u00028\u00002\u0006\u0010G\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010[J9\u0010_\u001A\u0004\u0018\u00010\b2\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000B2\u0006\u0010G\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010`J=\u0010a\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001A\u00020\u000B2\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010b\u001A\u00020MH\u0002¢\u0006\u0002\u0010cJ/\u0010d\u001A\u0002022\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010 \u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010eJ?\u0010f\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010b\u001A\u00020MH\u0002¢\u0006\u0002\u0010cJ\u0016\u0010g\u001A\u00020#2\f\u0010:\u001A\b\u0012\u0004\u0012\u00028\u00000;H\u0016J\u001A\u0010h\u001A\u00020#2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0jJ\u001C\u0010g\u001A\u00020#2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0jH\u0002J/\u0010k\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u001B\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010*J5\u0010l\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010G\u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010mJ,\u0010n\u001A\u00020\u000B2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u0006\u0010!\u001A\u00020\u000B2\u0006\u0010o\u001A\u00020MH\u0002JA\u0010g\u001A\u00020\u000B2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010p\u001A\u00020\u000B2\u0006\u0010o\u001A\u00020MH\u0002¢\u0006\u0002\u0010qJu\u0010r\u001A\u00020\u000B2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0j2\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010p\u001A\u00020\u000B2\u0006\u0010s\u001A\u00020\u000B2\u0006\u0010o\u001A\u00020M2\u0014\u0010t\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070u2\u0014\u0010B\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070uH\u0002¢\u0006\u0002\u0010vJ\u001E\u0010w\u001A\u00028\u00002\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010,\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010xJE\u0010y\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00107\u001A\u00020\u000B2\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010z\u001A\u00028\u00002\u0006\u0010{\u001A\u00020MH\u0002¢\u0006\u0002\u0010NJ\u000F\u0010|\u001A\b\u0012\u0004\u0012\u00028\u00000}H\u0096\u0002J\u000E\u0010~\u001A\b\u0012\u0004\u0012\u00028\u00000\u007FH\u0016J\u0016\u0010~\u001A\b\u0012\u0004\u0012\u00028\u00000\u007F2\u0006\u0010G\u001A\u00020\u000BH\u0016J \u0010\u0080\u0001\u001A\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0081\u00012\u0006\u0010G\u001A\u00020\u000BH\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0018\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u001A\u0010\n\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R4\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u0015\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000E¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000E\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000E¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u001A\u0010\u0018R\u001E\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u000B@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0010¨\u0006\u0082\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "getRootShift$runtime", "()I", "setRootShift$runtime", "(I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "root", "getRoot$runtime", "()[Ljava/lang/Object;", "tail", "getTail$runtime", "size", "getSize", "getModCount", "getModCount$runtime", "build", "rootSize", "tailSize", "isMutable", "", "buffer", "([Ljava/lang/Object;)Z", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBufferWith", "element", "(Ljava/lang/Object;)[Ljava/lang/Object;", "mutableBuffer", "add", "(Ljava/lang/Object;)Z", "pushFilledTail", "", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "shift", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "addAll", "elements", "", "copyToBuffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "buffers", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "index", "(ILjava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "insertIntoRoot", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "get", "(I)Ljava/lang/Object;", "bufferFor", "(I)[Ljava/lang/Object;", "removeAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "removeFromRootAt", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pullLastBuffer", "removeAll", "removeAllWithPredicate", "predicate", "Lkotlin/Function1;", "retainFirst", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "removeAllFromTail", "bufferRef", "bufferSize", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "recyclableRemoveAll", "toBufferSize", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "iterator", "", "listIterator", "", "leafBufferIterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentVectorBuilder extends AbstractMutableList implements Builder {
    public static final int $stable = 8;
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    static {
    }

    public PersistentVectorBuilder(PersistentList arg1, Object[] arg2, Object[] arg3, int arg4) {
        super();
        this.vector = arg1;
        this.vectorRoot = arg2;
        this.vectorTail = arg3;
        this.rootShift = arg4;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    public void add(int arg9, Object arg10) {
        ListImplementation.checkPositionIndex$runtime(arg9, this.size());
        if(arg9 == this.size()) {
            this.add(arg10);
            return;
        }

        ++this.modCount;
        int v0 = this.rootSize();
        if(arg9 >= v0) {
            this.insertIntoTail(this.root, arg9 - v0, arg10);
            return;
        }

        ObjectRef v7 = new ObjectRef(null);
        Object[] v3 = this.root;
        Intrinsics.checkNotNull(v3);
        this.insertIntoTail(this.insertIntoRoot(v3, this.rootShift, arg9, arg10, v7), 0, v7.getValue());
    }

    public boolean add(Object arg4) {
        ++this.modCount;
        int v0 = this.tailSize();
        if(v0 < 0x20) {
            Object[] v2 = this.makeMutable(this.tail);
            v2[v0] = arg4;
            this.tail = v2;
            this.size = this.size() + 1;
        }
        else {
            this.pushFilledTail(this.root, this.tail, this.mutableBufferWith(arg4));
        }

        return 1;
    }

    public boolean addAll(int arg13, Collection arg14) {
        Collection v5;
        PersistentVectorBuilder v4;
        Object[][] v9_1;
        int v10;
        Object[] v11;
        Object[] v13;
        ListImplementation.checkPositionIndex$runtime(arg13, this.size());
        if(arg13 == this.size()) {
            return this.addAll(arg14);
        }

        boolean v1 = false;
        if(arg14.isEmpty()) {
            return 0;
        }

        ++this.modCount;
        int v0 = arg13 >> 5 << 5;
        int v9 = (this.size() - v0 + arg14.size() - 1) / 0x20;
        if(v9 == 0) {
            if(arg13 >= this.rootSize()) {
                v1 = true;
            }

            CommonFunctionsKt.assert(v1);
            v0 = arg13 & 0x1F;
            v13 = ArraysKt.copyInto(this.tail, this.makeMutable(this.tail), (arg13 + arg14.size() - 1 & 0x1F) + 1, v0, this.tailSize());
            this.copyToBuffer(v13, v0, arg14.iterator());
            this.tail = v13;
            this.size = this.size() + arg14.size();
            return 1;
        }

        Object[][] v7 = new Object[v9][];
        int v8 = this.tailSize();
        int v3 = this.tailSize(this.size() + arg14.size());
        if(arg13 >= this.rootSize()) {
            v11 = this.mutableBuffer();
            v10 = v9;
            v9_1 = v7;
            v4 = this;
            v5 = arg14;
            v4.splitToBuffers(v5, arg13, this.tail, v8, v9_1, v10, v11);
        }
        else {
            v4 = this;
            int v6 = arg13;
            v5 = arg14;
            v10 = v9;
            v9_1 = v7;
            Object[] v12 = v4.tail;
            if(v3 > v8) {
                int v7_1 = v3 - v8;
                v3 = v10;
                Object[] v10_1 = v4.makeMutableShiftingRight(v12, v7_1);
                v4.insertIntoRoot(v5, v6, v7_1, v9_1, v3, v10_1);
                v9_1 = v9_1;
                v11 = v10_1;
            }
            else {
                int v14 = v8 - v3;
                v11 = ArraysKt.copyInto(v12, v4.mutableBuffer(), 0, v14, v8);
                int v12_1 = 0x20 - v14;
                v13 = v4.makeMutableShiftingRight(v4.tail, v12_1);
                v8 = v10 - 1;
                v9_1[v8] = v13;
                v4.insertIntoRoot(v5, v6, v12_1, v9_1, v8, v13);
                v5 = v5;
                v9_1 = v9_1;
                v4 = v4;
            }
        }

        v4.root = v4.pushBuffersIncreasingHeightIfNeeded(v4.root, v0, v9_1);
        v4.tail = v11;
        v4.size = v4.size() + v5.size();
        return 1;
    }

    public boolean addAll(Collection arg8) {
        if(arg8.isEmpty()) {
            return 0;
        }

        ++this.modCount;
        int v0 = this.tailSize();
        Iterator v3 = arg8.iterator();
        if(0x20 - v0 >= arg8.size()) {
            this.tail = this.copyToBuffer(this.makeMutable(this.tail), v0, v3);
            this.size = this.size() + arg8.size();
        }
        else {
            int v4 = (arg8.size() + v0 - 1) / 0x20;
            Object[][] v5 = new Object[v4][];
            v5[0] = this.copyToBuffer(this.makeMutable(this.tail), v0, v3);
            for(v0 = 1; v0 < v4; ++v0) {
                v5[v0] = this.copyToBuffer(this.mutableBuffer(), 0, v3);
            }

            this.root = this.pushBuffersIncreasingHeightIfNeeded(this.root, this.rootSize(), v5);
            this.tail = this.copyToBuffer(this.mutableBuffer(), 0, v3);
            this.size = this.size() + arg8.size();
        }

        return 1;
    }

    private final Object[] bufferFor(int arg3) {
        Object v0_1;
        if(this.rootSize() <= arg3) {
            return this.tail;
        }

        Object[] v0 = this.root;
        Intrinsics.checkNotNull(v0);
        int v2;
        for(v2 = this.rootShift; v2 > 0; v2 += -5) {
            v0_1 = ((Object[])v0_1)[UtilsKt.indexSegment(arg3, v2)];
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }

        return ((Object[])v0_1);
    }

    public PersistentList build() {
        PersistentList v0;
        if(this.root != this.vectorRoot || this.tail != this.vectorTail) {
            this.ownership = new MutabilityOwnership();
            Object[] v0_1 = this.root;
            this.vectorRoot = v0_1;
            Object[] v1 = this.tail;
            this.vectorTail = v1;
            if(v0_1 != null) {
                v1 = this.root;
                Intrinsics.checkNotNull(v1);
                PersistentVector v0_3 = new PersistentVector(v1, this.tail, this.size(), this.rootShift);
            }
            else if(v1.length == 0) {
                v0 = UtilsKt.persistentVectorOf();
            }
            else {
                v1 = Arrays.copyOf(this.tail, this.size());
                Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
                SmallPersistentVector v0_2 = new SmallPersistentVector(v1);
            }
        }
        else {
            v0 = this.vector;
        }

        this.vector = v0;
        return v0;
    }

    public PersistentCollection build() {
        return this.build();
    }

    private final Object[] copyToBuffer(Object[] arg2, int arg3, Iterator arg4) {
        while(arg3 < 0x20) {
            if(!arg4.hasNext()) {
                return arg2;
            }

            arg2[arg3] = arg4.next();
            ++arg3;
        }

        return arg2;
    }

    public Object get(int arg2) {
        ListImplementation.checkElementIndex$runtime(arg2, this.size());
        return this.bufferFor(arg2)[arg2 & 0x1F];
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    public final Object[] getRoot$runtime() {
        return this.root;
    }

    public final int getRootShift$runtime() {
        return this.rootShift;
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getTail$runtime() {
        return this.tail;
    }

    private final void insertIntoRoot(Collection arg9, int arg10, int arg11, Object[][] arg12, int arg13, Object[] arg14) {
        Object[] v7;
        if(this.root != null) {
            int v1 = arg10 >> 5;
            Object[] v2 = this.shiftLeafBuffers(v1, arg11, arg12, arg13, arg14);
            int v6 = arg13 - ((this.rootSize() >> 5) - 1 - v1);
            if(v6 < arg13) {
                Object[] v0 = arg12[v6];
                Intrinsics.checkNotNull(v0);
                v7 = v0;
            }
            else {
                v7 = arg14;
            }

            this.splitToBuffers(arg9, arg10, v2, 0x20, arg12, v6, v7);
            return;
        }

        throw new IllegalStateException("root is null".toString());
    }

    private final Object[] insertIntoRoot(Object[] arg9, int arg10, int arg11, Object arg12, ObjectRef arg13) {
        int v0 = UtilsKt.indexSegment(arg11, arg10);
        if(arg10 == 0) {
            arg13.setValue(arg9[0x1F]);
            Object[] v8 = ArraysKt.copyInto(arg9, this.makeMutable(arg9), v0 + 1, v0, 0x1F);
            v8[v0] = arg12;
            return v8;
        }

        arg9 = this.makeMutable(arg9);
        int v3 = arg10 - 5;
        Object v10 = arg9[v0];
        String v7 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(v10, v7);
        PersistentVectorBuilder v1 = this;
        ObjectRef v6 = arg13;
        arg9[v0] = v1.insertIntoRoot(v10, v3, arg11, arg12, v6);
        while(true) {
            ++v0;
            if(v0 < 0x20) {
                Object v8_1 = arg9[v0];
                if(v8_1 != null) {
                    Intrinsics.checkNotNull(v8_1, v7);
                    arg9[v0] = v1.insertIntoRoot(v8_1, v3, 0, v6.getValue(), v6);
                    continue;
                }
            }

            return arg9;
        }

        return arg9;
    }

    private final void insertIntoTail(Object[] arg6, int arg7, Object arg8) {
        int v0 = this.tailSize();
        Object[] v1 = this.makeMutable(this.tail);
        Object[] v2 = this.tail;
        if(v0 < 0x20) {
            ArraysKt.copyInto(v2, v1, arg7 + 1, arg7, v0);
            v1[arg7] = arg8;
            this.root = arg6;
            this.tail = v1;
            this.size = this.size() + 1;
            return;
        }

        Object v3 = v2[0x1F];
        ArraysKt.copyInto(v2, v1, arg7 + 1, arg7, 0x1F);
        v1[arg7] = arg8;
        this.pushFilledTail(arg6, v1, this.mutableBufferWith(v3));
    }

    private final boolean isMutable(Object[] arg3) {
        if(arg3.length == 33 && arg3[0x20] == this.ownership) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    private final ListIterator leafBufferIterator(int arg4) {
        Object[] v0 = this.root;
        if(v0 != null) {
            int v1 = this.rootSize() >> 5;
            ListImplementation.checkPositionIndex$runtime(arg4, v1);
            int v3 = this.rootShift;
            if(v3 == 0) {
                return new SingleElementListIterator(v0, arg4);
            }

            return new TrieIterator(v0, arg4, v1, v3 / 5);
        }

        throw new IllegalStateException("Invalid root".toString());
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    public ListIterator listIterator(int arg2) {
        ListImplementation.checkPositionIndex$runtime(arg2, this.size());
        return new PersistentVectorMutableIterator(this, arg2);
    }

    private final Object[] makeMutable(Object[] arg9) {
        if(arg9 == null) {
            return this.mutableBuffer();
        }

        if(this.isMutable(arg9)) {
            return arg9;
        }

        return ArraysKt.copyInto$default(arg9, this.mutableBuffer(), 0, 0, RangesKt.coerceAtMost(arg9.length, 0x20), 6, null);
    }

    private final Object[] makeMutableShiftingRight(Object[] arg3, int arg4) {
        if(this.isMutable(arg3)) {
            return ArraysKt.copyInto(arg3, arg3, arg4, 0, 0x20 - arg4);
        }

        return ArraysKt.copyInto(arg3, this.mutableBuffer(), arg4, 0, 0x20 - arg4);
    }

    private final Object[] mutableBuffer() {
        Object[] v0 = new Object[33];
        v0[0x20] = this.ownership;
        return v0;
    }

    private final Object[] mutableBufferWith(Object arg3) {
        Object[] v0 = new Object[33];
        v0[0] = arg3;
        v0[0x20] = this.ownership;
        return v0;
    }

    private final Object[] nullifyAfter(Object[] arg5, int arg6, int arg7) {
        int v1 = arg7 >= 0 ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalArgumentException("shift should be positive");
        }

        if(arg7 == 0) {
            return arg5;
        }

        v1 = UtilsKt.indexSegment(arg6, arg7);
        Object v2 = arg5[v1];
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] v6 = this.nullifyAfter(((Object[])v2), arg6, arg7 - 5);
        if(v1 < 0x1F) {
            arg7 = v1 + 1;
            if(arg5[arg7] != null) {
                if(this.isMutable(arg5)) {
                    ArraysKt.fill(arg5, null, arg7, 0x20);
                }

                arg5 = ArraysKt.copyInto(arg5, this.mutableBuffer(), 0, 0, arg7);
            }
        }

        if(v6 != arg5[v1]) {
            Object[] v4 = this.makeMutable(arg5);
            v4[v1] = v6;
            return v4;
        }

        return arg5;
    }

    private final Object[] pullLastBuffer(Object[] arg6, int arg7, int arg8, ObjectRef arg9) {
        Object[] v7;
        int v0 = UtilsKt.indexSegment(arg8 - 1, arg7);
        Object[] v1 = null;
        int v2 = 5;
        if(arg7 == v2) {
            arg9.setValue(arg6[v0]);
            v7 = v1;
        }
        else {
            Object v3 = arg6[v0];
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            v7 = this.pullLastBuffer(((Object[])v3), arg7 - v2, arg8, arg9);
        }

        if(v7 == null && v0 == 0) {
            return v1;
        }

        Object[] v5 = this.makeMutable(arg6);
        v5[v0] = v7;
        return v5;
    }

    private final void pullLastBufferFromRoot(Object[] arg4, int arg5, int arg6) {
        Object[] v1 = null;
        if(arg6 == 0) {
            this.root = v1;
            if(arg4 == null) {
                arg4 = new Object[0];
            }

            this.tail = arg4;
            this.size = arg5;
            this.rootShift = arg6;
            return;
        }

        ObjectRef v2 = new ObjectRef(v1);
        Intrinsics.checkNotNull(arg4);
        arg4 = this.pullLastBuffer(arg4, arg6, arg5, v2);
        Intrinsics.checkNotNull(arg4);
        Object v1_1 = v2.getValue();
        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = ((Object[])v1_1);
        this.size = arg5;
        if(arg4[1] == null) {
            this.root = arg4[0];
            this.rootShift = arg6 - 5;
            return;
        }

        this.root = arg4;
        this.rootShift = arg6;
    }

    private final Object[] pushBuffers(Object[] arg5, int arg6, int arg7, Iterator arg8) {
        if(!arg8.hasNext()) {
            PreconditionsKt.throwIllegalArgumentException("invalid buffersIterator");
        }

        int v2 = arg7 >= 0 ? 1 : 0;
        if(v2 == 0) {
            PreconditionsKt.throwIllegalArgumentException("negative shift");
        }

        if(arg7 == 0) {
            return arg8.next();
        }

        arg5 = this.makeMutable(arg5);
        v2 = UtilsKt.indexSegment(arg6, arg7);
        arg7 += -5;
        arg5[v2] = this.pushBuffers(arg5[v2], arg6, arg7, arg8);
        while(true) {
            ++v2;
            if(v2 < 0x20 && (arg8.hasNext())) {
                arg5[v2] = this.pushBuffers(arg5[v2], 0, arg7, arg8);
                continue;
            }

            return arg5;
        }

        return arg5;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] arg5, int arg6, Object[][] arg7) {
        Iterator v7 = ArrayIteratorKt.iterator(((Object[])arg7));
        int v1 = this.rootShift;
        arg5 = arg6 >> 5 < 1 << v1 ? this.pushBuffers(arg5, arg6, v1, v7) : this.makeMutable(arg5);
        while(v7.hasNext()) {
            this.rootShift += 5;
            arg5 = this.mutableBufferWith(arg5);
            this.pushBuffers(arg5, 1 << this.rootShift, this.rootShift, v7);
        }

        return arg5;
    }

    private final void pushFilledTail(Object[] arg5, Object[] arg6, Object[] arg7) {
        int v0 = this.size() >> 5;
        int v1 = this.rootShift;
        if(v0 > 1 << v1) {
            this.root = this.pushTail(this.mutableBufferWith(arg5), arg6, this.rootShift + 5);
            this.tail = arg7;
            this.rootShift += 5;
            this.size = this.size() + 1;
            return;
        }

        if(arg5 == null) {
            this.root = arg6;
            this.tail = arg7;
            this.size = this.size() + 1;
            return;
        }

        this.root = this.pushTail(arg5, arg6, v1);
        this.tail = arg7;
        this.size = this.size() + 1;
    }

    private final Object[] pushTail(Object[] arg4, Object[] arg5, int arg6) {
        int v0 = UtilsKt.indexSegment(this.size() - 1, arg6);
        arg4 = this.makeMutable(arg4);
        int v1 = 5;
        if(arg6 == v1) {
            arg4[v0] = arg5;
            return arg4;
        }

        arg4[v0] = this.pushTail(arg4[v0], arg5, arg6 - v1);
        return arg4;
    }

    private final int recyclableRemoveAll(Function1 arg7, Object[] arg8, int arg9, int arg10, ObjectRef arg11, List arg12, List arg13) {
        Object[] v10_1;
        if(this.isMutable(arg8)) {
            arg12.add(arg8);
        }

        Object v0 = arg11.getValue();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object v3 = v0;
        int v2;
        for(v2 = 0; v2 < arg9; ++v2) {
            Object v4 = arg8[v2];
            if(!arg7.invoke(v4).booleanValue()) {
                if(arg10 == 0x20) {
                    if(!arg12.isEmpty()) {
                        Object v10 = arg12.remove(arg12.size() - 1);
                    }
                    else {
                        v10_1 = this.mutableBuffer();
                    }

                    v3 = v10_1;
                    arg10 = 0;
                }

                v3[arg10] = v4;
                ++arg10;
            }
        }

        arg11.setValue(v3);
        if(v0 != arg11.getValue()) {
            arg13.add(v0);
        }

        return arg10;
    }

    private final int removeAll(Function1 arg7, Object[] arg8, int arg9, ObjectRef arg10) {
        int v0 = 0;
        Object[] v2 = arg8;
        int v3 = arg9;
        int v1 = 0;
        while(v0 < arg9) {
            Object v4 = arg8[v0];
            if(arg7.invoke(v4).booleanValue()) {
                if(v1 == 0) {
                    v2 = this.makeMutable(arg8);
                    v1 = 1;
                    v3 = v0;
                }
            }
            else if(v1 != 0) {
                v2[v3] = v4;
                ++v3;
            }

            ++v0;
        }

        arg10.setValue(v2);
        return v3;
    }

    private final boolean removeAll(Function1 arg15) {
        int v1;
        int v8 = this.tailSize();
        Object v9 = null;
        ObjectRef v5 = new ObjectRef(v9);
        if(this.root == null) {
            if(this.removeAllFromTail(arg15, v8, v5) != v8) {
                return 1;
            }

            return 0;
        }

        ListIterator v11 = this.leafBufferIterator(0);
        int v12 = 0x20;
        int v2;
        for(v2 = v12; v2 == v12; v2 = this.removeAll(arg15, v11.next(), v12, v5)) {
            if(!v11.hasNext()) {
                break;
            }
        }

        if(v2 == v12) {
            CommonFunctionsKt.assert(v11.hasNext() ^ 1);
            v1 = this.removeAllFromTail(arg15, v8, v5);
            if(v1 == 0) {
                this.pullLastBufferFromRoot(this.root, this.size(), this.rootShift);
            }

            if(v1 != v8) {
                return 1;
            }

            return 0;
        }

        int v13 = v11.previousIndex() << 5;
        ArrayList v7 = new ArrayList();
        ArrayList v6 = new ArrayList();
        int v4;
        for(v4 = v2; v11.hasNext(); v4 = this.recyclableRemoveAll(arg15, v11.next(), 0x20, v4, v5, ((List)v6), ((List)v7))) {
        }

        v1 = this.recyclableRemoveAll(arg15, this.tail, v8, v4, v5, ((List)v6), ((List)v7));
        Object v2_1 = v5.getValue();
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt.fill(((Object[])v2_1), v9, v1, v12);
        boolean v3 = ((List)v7).isEmpty();
        Object[] v4_1 = this.root;
        if(v3) {
            Intrinsics.checkNotNull(v4_1);
        }
        else {
            v4_1 = this.pushBuffers(v4_1, v13, this.rootShift, ((List)v7).iterator());
        }

        v13 += ((List)v7).size() << 5;
        this.root = this.retainFirst(v4_1, v13);
        this.tail = ((Object[])v2_1);
        this.size = v13 + v1;
        return 1;
    }

    public boolean removeAll(Collection arg2) {
        return this.removeAllWithPredicate(new PersistentVectorBuilder$$ExternalSyntheticLambda0(arg2));
    }

    static final boolean removeAll$lambda$0(Collection arg0, Object arg1) {
        return arg0.contains(arg1);
    }

    private final int removeAllFromTail(Function1 arg2, int arg3, ObjectRef arg4) {
        int v2 = this.removeAll(arg2, this.tail, arg3, arg4);
        if(v2 == arg3) {
            boolean v1 = arg4.getValue() == this.tail ? true : false;
            CommonFunctionsKt.assert(v1);
            return arg3;
        }

        Object v4 = arg4.getValue();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt.fill(((Object[])v4), null, v2, arg3);
        this.tail = ((Object[])v4);
        this.size = this.size() - (arg3 - v2);
        return v2;
    }

    public final boolean removeAllWithPredicate(Function1 arg2) {
        boolean v2 = this.removeAll(arg2);
        if(v2) {
            ++this.modCount;
        }

        return v2;
    }

    public Object removeAt(int arg6) {
        ListImplementation.checkElementIndex$runtime(arg6, this.size());
        ++this.modCount;
        int v0 = this.rootSize();
        if(arg6 >= v0) {
            return this.removeFromTailAt(this.root, v0, this.rootShift, arg6 - v0);
        }

        ObjectRef v1 = new ObjectRef(this.tail[0]);
        Object[] v2 = this.root;
        Intrinsics.checkNotNull(v2);
        this.removeFromTailAt(this.removeFromRootAt(v2, this.rootShift, arg6, v1), v0, this.rootShift, 0);
        return v1.getValue();
    }

    private final Object[] removeFromRootAt(Object[] arg7, int arg8, int arg9, ObjectRef arg10) {
        int v0 = UtilsKt.indexSegment(arg9, arg8);
        int v1 = 0x1F;
        if(arg8 == 0) {
            Object v8 = arg7[v0];
            Object[] v6 = ArraysKt.copyInto(arg7, this.makeMutable(arg7), v0, v0 + 1, 0x20);
            v6[v1] = arg10.getValue();
            arg10.setValue(v8);
            return v6;
        }

        if(arg7[v1] == null) {
            v1 = UtilsKt.indexSegment(this.rootSize() - 1, arg8);
        }

        arg7 = this.makeMutable(arg7);
        arg8 += -5;
        int v2 = v0 + 1;
        String v3 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if(v2 <= v1) {
            while(true) {
                Object v4 = arg7[v1];
                Intrinsics.checkNotNull(v4, v3);
                arg7[v1] = this.removeFromRootAt(((Object[])v4), arg8, 0, arg10);
                if(v1 != v2) {
                    --v1;
                    continue;
                }

                break;
            }
        }

        Object v1_1 = arg7[v0];
        Intrinsics.checkNotNull(v1_1, v3);
        arg7[v0] = this.removeFromRootAt(((Object[])v1_1), arg8, arg9, arg10);
        return arg7;
    }

    private final Object removeFromTailAt(Object[] arg7, int arg8, int arg9, int arg10) {
        int v0 = this.size() - arg8;
        boolean v3 = arg10 < v0 ? true : false;
        CommonFunctionsKt.assert(v3);
        Object[] v3_1 = this.tail;
        if(v0 == 1) {
            Object v10 = v3_1[0];
            this.pullLastBufferFromRoot(arg7, arg8, arg9);
            return v10;
        }

        Object v1 = v3_1[arg10];
        Object[] v10_1 = ArraysKt.copyInto(v3_1, this.makeMutable(v3_1), arg10, arg10 + 1, v0);
        v10_1[v0 - 1] = null;
        this.root = arg7;
        this.tail = v10_1;
        this.size = arg8 + v0 - 1;
        this.rootShift = arg9;
        return v1;
    }

    private final Object[] retainFirst(Object[] arg4, int arg5) {
        Object v4;
        int v0 = (arg5 & 0x1F) == 0 ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("invalid size");
        }

        if(arg5 == 0) {
            this.rootShift = 0;
            return null;
        }

        --arg5;
        while(true) {
            v0 = this.rootShift;
            if(arg5 >> v0 != 0) {
                break;
            }

            this.rootShift = v0 - 5;
            v4 = ((Object[])v4)[0];
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }

        return this.nullifyAfter(((Object[])v4), arg5, v0);
    }

    private final int rootSize() {
        if(this.size() <= 0x20) {
            return 0;
        }

        return UtilsKt.rootSize(this.size());
    }

    public Object set(int arg9, Object arg10) {
        ListImplementation.checkElementIndex$runtime(arg9, this.size());
        if(this.rootSize() <= arg9) {
            Object[] v0 = this.makeMutable(this.tail);
            if(v0 != this.tail) {
                ++this.modCount;
            }

            arg9 &= 0x1F;
            Object v1 = v0[arg9];
            v0[arg9] = arg10;
            this.tail = v0;
            return v1;
        }

        ObjectRef v7 = new ObjectRef(null);
        Object[] v3 = this.root;
        Intrinsics.checkNotNull(v3);
        this.root = this.setInRoot(v3, this.rootShift, arg9, arg10, v7);
        return v7.getValue();
    }

    private final Object[] setInRoot(Object[] arg10, int arg11, int arg12, Object arg13, ObjectRef arg14) {
        int v0 = UtilsKt.indexSegment(arg12, arg11);
        Object[] v1 = this.makeMutable(arg10);
        if(arg11 == 0) {
            if(v1 != arg10) {
                ++this.modCount;
            }

            arg14.setValue(v1[v0]);
            v1[v0] = arg13;
            return v1;
        }

        Object v10 = v1[v0];
        Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        v1[v0] = this.setInRoot(v10, arg11 - 5, arg12, arg13, arg14);
        return v1;
    }

    public final void setRootShift$runtime(int arg1) {
        this.rootShift = arg1;
    }

    private final Object[] shiftLeafBuffers(int arg6, int arg7, Object[][] arg8, int arg9, Object[] arg10) {
        if(this.root != null) {
            ListIterator v0 = this.leafBufferIterator(this.rootSize() >> 5);
            while(v0.previousIndex() != arg6) {
                Object v1 = v0.previous();
                ArraysKt.copyInto(((Object[])v1), arg10, 0, 0x20 - arg7, 0x20);
                arg10 = this.makeMutableShiftingRight(((Object[])v1), arg7);
                --arg9;
                arg8[arg9] = arg10;
            }

            return v0.previous();
        }

        throw new IllegalStateException("root is null".toString());
    }

    private final void splitToBuffers(Collection arg6, int arg7, Object[] arg8, int arg9, Object[][] arg10, int arg11, Object[] arg12) {
        Object[] v4;
        int v1 = 1;
        int v2 = arg11 >= 1 ? 1 : 0;
        if(v2 == 0) {
            PreconditionsKt.throwIllegalArgumentException("requires at least one nullBuffer");
        }

        arg8 = this.makeMutable(arg8);
        arg10[0] = arg8;
        v2 = arg7 & 0x1F;
        arg7 = arg7 + arg6.size() - 1 & 0x1F;
        int v3 = arg9 - v2 + arg7;
        if(v3 < 0x20) {
            ArraysKt.copyInto(arg8, arg12, arg7 + 1, v2, arg9);
        }
        else {
            v3 += 0xFFFFFFE1;
            if(arg11 == 1) {
                v4 = arg8;
            }
            else {
                v4 = this.mutableBuffer();
                --arg11;
                arg10[arg11] = v4;
            }

            v3 = arg9 - v3;
            ArraysKt.copyInto(arg8, arg12, 0, v3, arg9);
            ArraysKt.copyInto(arg8, v4, arg7 + 1, v2, v3);
            arg12 = v4;
        }

        Iterator v6 = arg6.iterator();
        this.copyToBuffer(arg8, v2, v6);
        while(v1 < arg11) {
            arg10[v1] = this.copyToBuffer(this.mutableBuffer(), 0, v6);
            ++v1;
        }

        this.copyToBuffer(arg12, 0, v6);
    }

    private final int tailSize() {
        return this.tailSize(this.size());
    }

    private final int tailSize(int arg1) {
        if(arg1 <= 0x20) {
            return arg1;
        }

        return arg1 - UtilsKt.rootSize(arg1);
    }
}

