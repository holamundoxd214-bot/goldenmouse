package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 ~*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B1\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fB)\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0004\b\u000B\u0010\rJ\u0014\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000FH\u0002J\u0014\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000FH\u0002J\r\u0010\u0015\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u001AJ\u0010\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0005H\u0002J\u0015\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u001DJ\u0015\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u001FJ\u0015\u0010 \u001A\u00028\u00002\u0006\u0010!\u001A\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001A\u00028\u00012\u0006\u0010!\u001A\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J!\u0010$\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u0005H\u0000¢\u0006\u0002\b%J1\u0010&\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0002¢\u0006\u0002\u0010(J9\u0010)\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0006\u0010*\u001A\u00020\nH\u0002¢\u0006\u0002\u0010+J)\u0010,\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00028\u0001H\u0002¢\u0006\u0002\u0010-J=\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00028\u00012\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u00101J8\u00102\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J8\u00104\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010*\u001A\u00020\nH\u0002J&\u00105\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0002J.\u00106\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\nH\u0002JO\u00107\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u00108\u001A\u00020\u00052\u0006\u00109\u001A\u00028\u00002\u0006\u0010:\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u00052\b\u0010*\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010<JI\u0010=\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u00108\u001A\u00020\u00052\u0006\u00109\u001A\u00028\u00002\u0006\u0010:\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u0005H\u0002¢\u0006\u0002\u0010>JQ\u0010?\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u00108\u001A\u00020\u00052\u0006\u00109\u001A\u00028\u00002\u0006\u0010:\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\nH\u0002¢\u0006\u0002\u0010@J[\u0010A\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010B\u001A\u00020\u00052\u0006\u0010C\u001A\u00028\u00002\u0006\u0010D\u001A\u00028\u00012\u0006\u0010E\u001A\u00020\u00052\u0006\u0010F\u001A\u00028\u00002\u0006\u0010G\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u00052\b\u0010*\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0002J:\u0010J\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u001E\u0010K\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010L\u001A\u00020\u0005H\u0002J2\u0010M\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010L\u001A\u00020\u00052\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u0015\u0010N\u001A\u00020\u00182\u0006\u0010\'\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010OJ\u0017\u0010P\u001A\u0004\u0018\u00018\u00012\u0006\u0010\'\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010QJ+\u0010R\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000F2\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0002¢\u0006\u0002\u0010SJ=\u0010T\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ#\u0010V\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\'\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010WJ7\u0010X\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\'\u001A\u00028\u00002\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010YJ+\u0010V\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0002¢\u0006\u0002\u0010ZJ?\u0010X\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ8\u0010[\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010]\u001A\u00020^2\u0006\u0010*\u001A\u00020\nH\u0002JT\u0010_\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u00052\u0006\u0010]\u001A\u00020^2\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\b\u0010`\u001A\u00020\u0005H\u0002J\u001C\u0010a\u001A\u00020\u00182\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J#\u0010b\u001A\u00020\u00182\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010;\u001A\u00020\u0005¢\u0006\u0002\u0010dJ%\u0010e\u001A\u0004\u0018\u00018\u00012\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010;\u001A\u00020\u0005¢\u0006\u0002\u0010fJJ\u0010g\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010;\u001A\u00020\u00052\u0006\u0010]\u001A\u00020^2\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100J9\u0010h\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000F2\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u0005¢\u0006\u0002\u0010iJK\u0010j\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u00052\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJ1\u0010l\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010;\u001A\u00020\u0005¢\u0006\u0002\u0010mJP\u0010n\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010o\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u00103\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u0005H\u0002JE\u0010p\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010;\u001A\u00020\u00052\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010qJX\u0010r\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010o\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u00103\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\nH\u0002J9\u0010l\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u0005¢\u0006\u0002\u0010sJM\u0010p\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001A\u00020\u00052\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u00012\u0006\u0010;\u001A\u00020\u00052\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJ\u0091\u0001\u0010t\u001A\u00020u2\u0081\u0001\u0010v\u001A}\u0012\u001F\u0012\u001D\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b({\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020u0wH\u0000¢\u0006\u0002\b|J\u009C\u0001\u0010t\u001A\u00020u2\u0081\u0001\u0010v\u001A}\u0012\u001F\u0012\u001D\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b({\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020u0w2\u0006\u0010{\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000E\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u0080\u000E¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u007F"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(II[Ljava/lang/Object;)V", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "value", "getBuffer$runtime", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "entryCount", "entryCount$runtime", "hasEntryAt", "", "positionMask", "hasEntryAt$runtime", "hasNodeAt", "entryKeyIndex", "entryKeyIndex$runtime", "nodeIndex", "nodeIndex$runtime", "keyAtIndex", "keyIndex", "(I)Ljava/lang/Object;", "valueAtKeyIndex", "nodeAtIndex", "nodeAtIndex$runtime", "insertEntryAt", "key", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableInsertEntryAt", "owner", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableUpdateValueAtIndex", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateNodeAtIndex", "newNode", "mutableUpdateNodeAtIndex", "removeNodeAtIndex", "mutableRemoveNodeAtIndex", "bufferMoveEntryToNode", "newKeyHash", "newKey", "newValue", "shift", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "mutableRemoveEntryAtIndex", "collisionRemoveEntryAtIndex", "i", "mutableCollisionRemoveEntryAtIndex", "collisionContainsKey", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutableCollisionPut", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "otherNode", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutablePutAllFromOtherNodeCell", "calculateSize", "elementsIdentityEquals", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "mutablePutAll", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "remove", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "replaceNode", "targetNode", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableReplaceNode", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "hash", "accept$runtime", "ModificationResult", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TrieNode {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TrieNode getEMPTY$runtime() {
            return TrieNode.EMPTY;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJA\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0011\u001A&\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0012H\u0086\bR&\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ModificationResult {
        public static final int $stable = 8;
        private TrieNode node;
        private final int sizeDelta;

        static {
        }

        public ModificationResult(TrieNode arg1, int arg2) {
            super();
            this.node = arg1;
            this.sizeDelta = arg2;
        }

        public final TrieNode getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final ModificationResult replaceNode(Function1 arg2) {
            this.setNode(arg2.invoke(this.getNode()));
            return this;
        }

        public final void setNode(TrieNode arg1) {
            this.node = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TrieNode EMPTY;
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    static {
        TrieNode.Companion = new Companion(null);
        TrieNode.$stable = 8;
        TrieNode.EMPTY = new TrieNode(0, 0, new Object[0]);
    }

    public TrieNode(int arg2, int arg3, Object[] arg4) {
        this(arg2, arg3, arg4, null);
    }

    public TrieNode(int arg1, int arg2, Object[] arg3, MutabilityOwnership arg4) {
        super();
        this.dataMap = arg1;
        this.nodeMap = arg2;
        this.ownedBy = arg4;
        this.buffer = arg3;
    }

    private final void accept(Function5 arg7, int arg8, int arg9) {
        TrieNode v1 = this;
        Function5 v0 = arg7;
        v0.invoke(v1, Integer.valueOf(arg9), Integer.valueOf(arg8), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int v6;
        for(v6 = v1.nodeMap; v6 != 0; v6 -= v7) {
            int v7 = Integer.lowestOneBit(v6);
            v1.nodeAtIndex$runtime(v1.nodeIndex$runtime(v7)).accept(v0, (Integer.numberOfTrailingZeros(v7) << arg9) + arg8, arg9 + 5);
        }
    }

    public final void accept$runtime(Function5 arg2) {
        this.accept(arg2, 0, 0);
    }

    public static final TrieNode access$getEMPTY$cp() {
        return TrieNode.EMPTY;
    }

    private final ModificationResult asInsertResult() {
        return new ModificationResult(this, 1);
    }

    private final ModificationResult asUpdateResult() {
        return new ModificationResult(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int arg10, int arg11, int arg12, Object arg13, Object arg14, int arg15, MutabilityOwnership arg16) {
        Object v2 = this.keyAtIndex(arg10);
        int v0 = v2 != null ? v2.hashCode() : 0;
        return TrieNodeKt.access$replaceEntryWithNode(this.buffer, arg10, this.nodeIndex$runtime(arg11) + 1, this.makeNode(v0, v2, this.valueAtKeyIndex(arg10), arg12, arg13, arg14, arg15 + 5, arg16));
    }

    private final int calculateSize() {
        if(this.nodeMap == 0) {
            return this.buffer.length / 2;
        }

        int v0 = Integer.bitCount(this.dataMap);
        int v1 = v0 * 2;
        int v2 = this.buffer.length;
        while(v1 < v2) {
            v0 += this.nodeAtIndex$runtime(v1).calculateSize();
            ++v1;
        }

        return v0;
    }

    private final boolean collisionContainsKey(Object arg6) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v2 = v0.getFirst();
        int v3 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v2 <= v3) {
            goto label_13;
        }
        else if(v0_1 < 0 && v3 <= v2) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg6, this.buffer[v2])) {
                    return 1;
                }
                else if(v2 != v3) {
                    v2 += v0_1;
                    continue;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final Object collisionGet(Object arg5) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v1 = v0.getFirst();
        int v2 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v1 <= v2) {
            goto label_13;
        }
        else if(v0_1 < 0 && v2 <= v1) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg5, this.keyAtIndex(v1))) {
                    break;
                }
                else if(v1 != v2) {
                    v1 += v0_1;
                    continue;
                }

                return null;
            }

            return this.valueAtKeyIndex(v1);
        }

        return null;
    }

    private final ModificationResult collisionPut(Object arg6, Object arg7) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v2 = v0.getFirst();
        int v3 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v2 <= v3) {
            goto label_13;
        }
        else if(v0_1 < 0 && v3 <= v2) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg6, this.keyAtIndex(v2))) {
                    break;
                }
                else if(v2 != v3) {
                    v2 += v0_1;
                    continue;
                }

                goto label_34;
            }

            if(arg7 == this.valueAtKeyIndex(v2)) {
                return null;
            }
            else {
                Object[] v5 = Arrays.copyOf(this.buffer, this.buffer.length);
                Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                v5[v2 + 1] = arg7;
                return new TrieNode(0, 0, v5).asUpdateResult();
            }
        }

    label_34:
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, arg6, arg7)).asInsertResult();
    }

    private final TrieNode collisionRemove(Object arg5) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v1 = v0.getFirst();
        int v2 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v1 <= v2) {
            goto label_13;
        }
        else if(v0_1 < 0 && v2 <= v1) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg5, this.keyAtIndex(v1))) {
                    break;
                }
                else if(v1 != v2) {
                    v1 += v0_1;
                    continue;
                }

                return this;
            }

            return this.collisionRemoveEntryAtIndex(v1);
        }

        return this;
    }

    private final TrieNode collisionRemove(Object arg5, Object arg6) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v1 = v0.getFirst();
        int v2 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v1 <= v2) {
            goto label_13;
        }
        else if(v0_1 < 0 && v2 <= v1) {
            while(true) {
            label_13:
                if((Intrinsics.areEqual(arg5, this.keyAtIndex(v1))) && (Intrinsics.areEqual(arg6, this.valueAtKeyIndex(v1)))) {
                    return this.collisionRemoveEntryAtIndex(v1);
                }

                if(v1 == v2) {
                    return this;
                }

                v1 += v0_1;
            }
        }

        return this;
    }

    private final TrieNode collisionRemoveEntryAtIndex(int arg3) {
        Object[] v2 = this.buffer;
        if(v2.length == 2) {
            return null;
        }

        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(v2, arg3));
    }

    public final boolean containsKey(int arg3, Object arg4, int arg5) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg3, arg5);
        if(this.hasEntryAt$runtime(v0)) {
            return Intrinsics.areEqual(arg4, this.keyAtIndex(this.entryKeyIndex$runtime(v0)));
        }

        if(this.hasNodeAt(v0)) {
            this = this.nodeAtIndex$runtime(this.nodeIndex$runtime(v0));
            if(arg5 == 30) {
                return this.collisionContainsKey(arg4);
            }

            return this.containsKey(arg3, arg4, arg5 + 5);
        }

        return 0;
    }

    private final boolean elementsIdentityEquals(TrieNode arg7) {
        if(this == arg7) {
            return 1;
        }

        if(this.nodeMap != arg7.nodeMap) {
            return 0;
        }

        if(this.dataMap != arg7.dataMap) {
            return 0;
        }

        int v1 = this.buffer.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(this.buffer[v2] != arg7.buffer[v2]) {
                return 0;
            }
        }

        return 1;
    }

    public final int entryCount$runtime() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime(int arg1) {
        return Integer.bitCount(this.dataMap & arg1 - 1) * 2;
    }

    public final Object get(int arg4, Object arg5, int arg6) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg4, arg6);
        Object v2 = null;
        if(this.hasEntryAt$runtime(v0)) {
            arg4 = this.entryKeyIndex$runtime(v0);
            if(Intrinsics.areEqual(arg5, this.keyAtIndex(arg4))) {
                return this.valueAtKeyIndex(arg4);
            }

            return v2;
        }

        if(this.hasNodeAt(v0)) {
            this = this.nodeAtIndex$runtime(this.nodeIndex$runtime(v0));
            if(arg6 == 30) {
                return this.collisionGet(arg5);
            }

            return this.get(arg4, arg5, arg6 + 5);
        }

        return v2;
    }

    public final Object[] getBuffer$runtime() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime(int arg1) {
        if((this.dataMap & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    private final boolean hasNodeAt(int arg1) {
        if((this.nodeMap & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    private final TrieNode insertEntryAt(int arg3, Object arg4, Object arg5) {
        return new TrieNode(arg3 | this.dataMap, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(this.buffer, this.entryKeyIndex$runtime(arg3), arg4, arg5));
    }

    private final Object keyAtIndex(int arg1) {
        return this.buffer[arg1];
    }

    private final TrieNode makeNode(int arg13, Object arg14, Object arg15, int arg16, Object arg17, Object arg18, int arg19, MutabilityOwnership arg20) {
        Object[] v0_1;
        Object v5 = arg17;
        Object v6 = arg18;
        int v0 = arg19;
        MutabilityOwnership v8 = arg20;
        if(v0 > 30) {
            return new TrieNode(0, 0, new Object[]{arg14, arg15, v5, v6}, v8);
        }

        int v10 = TrieNodeKt.indexSegment(arg13, v0);
        int v4 = arg16;
        int v1 = TrieNodeKt.indexSegment(v4, v0);
        if(v10 != v1) {
            int v12 = 3;
            arg13 = 2;
            v0 = 4;
            if(v10 < v1) {
                v0_1 = new Object[v0];
                v0_1[0] = arg14;
                v0_1[1] = arg15;
                v0_1[arg13] = v5;
                v0_1[v12] = v6;
            }
            else {
                v0_1 = new Object[v0];
                v0_1[0] = v5;
                v0_1[1] = v6;
                v0_1[arg13] = arg14;
                v0_1[v12] = arg15;
            }

            return new TrieNode(1 << v10 | 1 << v1, 0, v0_1, v8);
        }

        return new TrieNode(0, 1 << v10, new Object[]{this.makeNode(arg13, arg14, arg15, v4, v5, v6, v0 + 5, v8)}, v8);
    }

    private final TrieNode moveEntryToNode(int arg9, int arg10, int arg11, Object arg12, Object arg13, int arg14) {
        return new TrieNode(this.dataMap ^ arg10, this.nodeMap | arg10, this.bufferMoveEntryToNode(arg9, arg10, arg11, arg12, arg13, arg14, null));
    }

    private final TrieNode mutableCollisionPut(Object arg6, Object arg7, PersistentHashMapBuilder arg8) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v2 = v0.getFirst();
        int v3 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v2 <= v3) {
            goto label_13;
        }
        else if(v0_1 < 0 && v3 <= v2) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg6, this.keyAtIndex(v2))) {
                    break;
                }
                else if(v2 != v3) {
                    v2 += v0_1;
                    continue;
                }

                goto label_42;
            }

            arg8.setOperationResult$runtime(this.valueAtKeyIndex(v2));
            if(this.ownedBy == arg8.getOwnership()) {
                this.buffer[v2 + 1] = arg7;
                return this;
            }
            else {
                arg8.setModCount$runtime(arg8.getModCount$runtime() + 1);
                Object[] v5 = Arrays.copyOf(this.buffer, this.buffer.length);
                Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                v5[v2 + 1] = arg7;
                return new TrieNode(0, 0, v5, arg8.getOwnership());
            }
        }

    label_42:
        arg8.setSize(arg8.size() + 1);
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, arg6, arg7), arg8.getOwnership());
    }

    private final TrieNode mutableCollisionPutAll(TrieNode arg12, DeltaCounter arg13, MutabilityOwnership arg14) {
        boolean v0 = this.nodeMap == 0 ? true : false;
        CommonFunctionsKt.assert(v0);
        v0 = this.dataMap == 0 ? true : false;
        CommonFunctionsKt.assert(v0);
        v0 = arg12.nodeMap == 0 ? true : false;
        CommonFunctionsKt.assert(v0);
        v0 = arg12.dataMap == 0 ? true : false;
        CommonFunctionsKt.assert(v0);
        Object[] v0_1 = Arrays.copyOf(this.buffer, this.buffer.length + arg12.buffer.length);
        String v3 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(v0_1, v3);
        int v4 = this.buffer.length;
        IntProgression v5 = RangesKt.step(RangesKt.until(0, arg12.buffer.length), 2);
        int v6 = v5.getFirst();
        int v7 = v5.getLast();
        int v5_1 = v5.getStep();
        if(v5_1 > 0 && v6 <= v7) {
            goto label_48;
        }
        else if(v5_1 < 0 && v7 <= v6) {
            while(true) {
            label_48:
                if(!this.collisionContainsKey(arg12.buffer[v6])) {
                    Object[] v8 = arg12.buffer;
                    v0_1[v4] = v8[v6];
                    v0_1[v4 + 1] = v8[v6 + 1];
                    v4 += 2;
                }
                else {
                    arg13.setCount(arg13.getCount() + 1);
                }

                if(v6 == v7) {
                    break;
                }

                v6 += v5_1;
            }
        }

        if(v4 == this.buffer.length) {
            return this;
        }

        if(v4 == arg12.buffer.length) {
            return arg12;
        }

        if(v4 == v0_1.length) {
            return new TrieNode(0, 0, v0_1, arg14);
        }

        Object[] v12 = Arrays.copyOf(v0_1, v4);
        Intrinsics.checkNotNullExpressionValue(v12, v3);
        return new TrieNode(0, 0, v12, arg14);
    }

    private final TrieNode mutableCollisionRemove(Object arg5, PersistentHashMapBuilder arg6) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v1 = v0.getFirst();
        int v2 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v1 <= v2) {
            goto label_13;
        }
        else if(v0_1 < 0 && v2 <= v1) {
            while(true) {
            label_13:
                if(Intrinsics.areEqual(arg5, this.keyAtIndex(v1))) {
                    break;
                }
                else if(v1 != v2) {
                    v1 += v0_1;
                    continue;
                }

                return this;
            }

            return this.mutableCollisionRemoveEntryAtIndex(v1, arg6);
        }

        return this;
    }

    private final TrieNode mutableCollisionRemove(Object arg5, Object arg6, PersistentHashMapBuilder arg7) {
        IntProgression v0 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int v1 = v0.getFirst();
        int v2 = v0.getLast();
        int v0_1 = v0.getStep();
        if(v0_1 > 0 && v1 <= v2) {
            goto label_13;
        }
        else if(v0_1 < 0 && v2 <= v1) {
            while(true) {
            label_13:
                if((Intrinsics.areEqual(arg5, this.keyAtIndex(v1))) && (Intrinsics.areEqual(arg6, this.valueAtKeyIndex(v1)))) {
                    return this.mutableCollisionRemoveEntryAtIndex(v1, arg7);
                }

                if(v1 == v2) {
                    return this;
                }

                v1 += v0_1;
            }
        }

        return this;
    }

    private final TrieNode mutableCollisionRemoveEntryAtIndex(int arg4, PersistentHashMapBuilder arg5) {
        arg5.setSize(arg5.size() - 1);
        arg5.setOperationResult$runtime(this.valueAtKeyIndex(arg4));
        if(this.buffer.length == 2) {
            return null;
        }

        MutabilityOwnership v0 = this.ownedBy;
        MutabilityOwnership v1 = arg5.getOwnership();
        Object[] v2 = this.buffer;
        if(v0 == v1) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(v2, arg4);
            return this;
        }

        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(v2, arg4), arg5.getOwnership());
    }

    private final TrieNode mutableInsertEntryAt(int arg4, Object arg5, Object arg6, MutabilityOwnership arg7) {
        int v0 = this.entryKeyIndex$runtime(arg4);
        MutabilityOwnership v1 = this.ownedBy;
        Object[] v2 = this.buffer;
        if(v1 == arg7) {
            this.buffer = TrieNodeKt.access$insertEntryAtIndex(v2, v0, arg5, arg6);
            this.dataMap |= arg4;
            return this;
        }

        return new TrieNode(arg4 | this.dataMap, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(v2, v0, arg5, arg6), arg7);
    }

    private final TrieNode mutableMoveEntryToNode(int arg2, int arg3, int arg4, Object arg5, Object arg6, int arg7, MutabilityOwnership arg8) {
        if(this.ownedBy == arg8) {
            this.buffer = this.bufferMoveEntryToNode(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            this.dataMap ^= arg3;
            this.nodeMap |= arg3;
            return this;
        }

        return new TrieNode(this.dataMap ^ arg3, this.nodeMap | arg3, this.bufferMoveEntryToNode(arg2, arg3, arg4, arg5, arg6, arg7, arg8), arg8);
    }

    public final TrieNode mutablePut(int arg11, Object arg12, Object arg13, int arg14, PersistentHashMapBuilder arg15) {
        TrieNode v11;
        int v0;
        TrieNode v2;
        int v4 = 1 << TrieNodeKt.indexSegment(arg11, arg14);
        if(this.hasEntryAt$runtime(v4)) {
            int v3 = this.entryKeyIndex$runtime(v4);
            if(Intrinsics.areEqual(arg12, this.keyAtIndex(v3))) {
                arg15.setOperationResult$runtime(this.valueAtKeyIndex(v3));
                if(this.valueAtKeyIndex(v3) == arg13) {
                    v2 = this;
                }
                else {
                    return this.mutableUpdateValueAtIndex(v3, arg13, arg15);
                }
            }
            else {
                arg15.setSize(arg15.size() + 1);
                return this.mutableMoveEntryToNode(v3, v4, arg11, arg12, arg13, arg14, arg15.getOwnership());
            }
        }
        else {
            v2 = this;
            int v8 = arg14;
            if(v2.hasNodeAt(v4)) {
                v0 = v2.nodeIndex$runtime(v4);
                this = v2.nodeAtIndex$runtime(v0);
                v11 = v8 == 30 ? this.mutableCollisionPut(arg12, arg13, arg15) : this.mutablePut(arg11, arg12, arg13, v8 + 5, arg15);
                if(this != v11) {
                    goto label_42;
                }
            }
            else {
                goto label_45;
            }
        }

        return v2;
    label_42:
        return v2.mutableUpdateNodeAtIndex(v0, v11, arg15.getOwnership());
    label_45:
        arg15.setSize(arg15.size() + 1);
        return v2.mutableInsertEntryAt(v4, arg12, arg13, arg15.getOwnership());
    }

    public final TrieNode mutablePutAll(TrieNode arg16, int arg17, DeltaCounter arg18, PersistentHashMapBuilder arg19) {
        int v5;
        TrieNode v1 = arg16;
        DeltaCounter v4 = arg18;
        if(this == v1) {
            v4.plusAssign(this.calculateSize());
            return this;
        }

        int v3 = arg17;
        if(v3 > 30) {
            return this.mutableCollisionPutAll(v1, v4, arg19.getOwnership());
        }

        int v0 = this.nodeMap | v1.nodeMap;
        int v2 = this.dataMap;
        int v6 = (v2 ^ v1.dataMap) & ~v0;
        v2 &= v1.dataMap;
        while(v2 != 0) {
            v5 = Integer.lowestOneBit(v2);
            if(Intrinsics.areEqual(this.keyAtIndex(this.entryKeyIndex$runtime(v5)), v1.keyAtIndex(v1.entryKeyIndex$runtime(v5)))) {
                v6 |= v5;
            }
            else {
                v0 |= v5;
            }

            v2 ^= v5;
        }

        int v7 = 0;
        v2 = (v0 & v6) == 0 ? 1 : 0;
        if(v2 == 0) {
            PreconditionsKt.throwIllegalStateException("Check failed.");
        }

        TrieNode v9 = !Intrinsics.areEqual(this.ownedBy, arg19.getOwnership()) || this.dataMap != v6 || this.nodeMap != v0 ? new TrieNode(v6, v0, new Object[Integer.bitCount(v6) * 2 + Integer.bitCount(v0)]) : this;
        int v10 = v0;
        int v11 = 0;
        while(v10 != 0) {
            v2 = Integer.lowestOneBit(v10);
            v9.buffer[v9.buffer.length - 1 - v11] = this.mutablePutAllFromOtherNodeCell(v1, v2, v3, v4, arg19);
            ++v11;
            v10 ^= v2;
            v3 = arg17;
        }

        while(v6 != 0) {
            v2 = Integer.lowestOneBit(v6);
            v3 = v7 * 2;
            if(!v1.hasEntryAt$runtime(v2)) {
                v5 = this.entryKeyIndex$runtime(v2);
                v9.buffer[v3] = this.keyAtIndex(v5);
                v9.buffer[v3 + 1] = this.valueAtKeyIndex(v5);
            }
            else {
                v5 = v1.entryKeyIndex$runtime(v2);
                v9.buffer[v3] = v1.keyAtIndex(v5);
                v9.buffer[v3 + 1] = v1.valueAtKeyIndex(v5);
                if(this.hasEntryAt$runtime(v2)) {
                    v4.setCount(v4.getCount() + 1);
                }
            }

            ++v7;
            v6 ^= v2;
        }

        if(this.elementsIdentityEquals(v9)) {
            return this;
        }

        if(v1.elementsIdentityEquals(v9)) {
            return v1;
        }

        return v9;
    }

    private final TrieNode mutablePutAllFromOtherNodeCell(TrieNode arg13, int arg14, int arg15, DeltaCounter arg16, PersistentHashMapBuilder arg17) {
        Object v6;
        Object v5;
        DeltaCounter v0 = arg16;
        int v2 = 0;
        if(this.hasNodeAt(arg14)) {
            TrieNode v3 = this.nodeAtIndex$runtime(this.nodeIndex$runtime(arg14));
            if(arg13.hasNodeAt(arg14)) {
                return v3.mutablePutAll(arg13.nodeAtIndex$runtime(arg13.nodeIndex$runtime(arg14)), arg15 + 5, v0, arg17);
            }

            PersistentHashMapBuilder v8 = arg17;
            if(arg13.hasEntryAt$runtime(arg14)) {
                int v12 = arg13.entryKeyIndex$runtime(arg14);
                v5 = arg13.keyAtIndex(v12);
                v6 = arg13.valueAtKeyIndex(v12);
                v12 = v8.size();
                if(v5 != null) {
                    v2 = v5.hashCode();
                }

                arg13 = v3.mutablePut(v2, v5, v6, arg15 + 5, v8);
                if(arg17.size() == v12) {
                    v0.setCount(v0.getCount() + 1);
                }

                return arg13;
            }

            return v3;
        }

        if(arg13.hasNodeAt(arg14)) {
            TrieNode v4 = arg13.nodeAtIndex$runtime(arg13.nodeIndex$runtime(arg14));
            if(this.hasEntryAt$runtime(arg14)) {
                int v13 = this.entryKeyIndex$runtime(arg14);
                v6 = this.keyAtIndex(v13);
                arg14 = v6 != null ? v6.hashCode() : 0;
                int v8_1 = arg15 + 5;
                if(v4.containsKey(arg14, v6, v8_1)) {
                    v0.setCount(v0.getCount() + 1);
                    return v4;
                }

                Object v7 = this.valueAtKeyIndex(v13);
                if(v6 != null) {
                    v2 = v6.hashCode();
                }

                return v4.mutablePut(v2, v6, v7, v8_1, arg17);
            }

            return v4;
        }

        int v0_1 = this.entryKeyIndex$runtime(arg14);
        v5 = this.keyAtIndex(v0_1);
        v6 = this.valueAtKeyIndex(v0_1);
        arg14 = arg13.entryKeyIndex$runtime(arg14);
        Object v8_2 = arg13.keyAtIndex(arg14);
        Object v9 = arg13.valueAtKeyIndex(arg14);
        int v4_1 = v5 != null ? v5.hashCode() : 0;
        if(v8_2 != null) {
            v2 = v8_2.hashCode();
        }

        return this.makeNode(v4_1, v5, v6, v2, v8_2, v9, arg15 + 5, arg17.getOwnership());
    }

    public final TrieNode mutableRemove(int arg9, Object arg10, int arg11, PersistentHashMapBuilder arg12) {
        int v6 = 1 << TrieNodeKt.indexSegment(arg9, arg11);
        if(this.hasEntryAt$runtime(v6)) {
            arg9 = this.entryKeyIndex$runtime(v6);
            if(Intrinsics.areEqual(arg10, this.keyAtIndex(arg9))) {
                return this.mutableRemoveEntryAtIndex(arg9, v6, arg12);
            }
        }
        else if(this.hasNodeAt(v6)) {
            int v5 = this.nodeIndex$runtime(v6);
            TrieNode v3 = this.nodeAtIndex$runtime(v5);
            TrieNode v9 = arg11 == 30 ? v3.mutableCollisionRemove(arg10, arg12) : v3.mutableRemove(arg9, arg10, arg11 + 5, arg12);
            return this.mutableReplaceNode(v3, v9, v5, v6, arg12.getOwnership());
        }

        return this;
    }

    public final TrieNode mutableRemove(int arg8, Object arg9, Object arg10, int arg11, PersistentHashMapBuilder arg12) {
        PersistentHashMapBuilder v6;
        TrieNode v8;
        int v0 = 1 << TrieNodeKt.indexSegment(arg8, arg11);
        if(this.hasEntryAt$runtime(v0)) {
            arg8 = this.entryKeyIndex$runtime(v0);
            if((Intrinsics.areEqual(arg9, this.keyAtIndex(arg8))) && (Intrinsics.areEqual(arg10, this.valueAtKeyIndex(arg8)))) {
                return this.mutableRemoveEntryAtIndex(arg8, v0, arg12);
            }
        }
        else if(this.hasNodeAt(v0)) {
            Object v4 = arg10;
            int v10 = this.nodeIndex$runtime(v0);
            TrieNode v1 = this.nodeAtIndex$runtime(v10);
            if(arg11 == 30) {
                v8 = v1.mutableCollisionRemove(arg9, v4, arg12);
                v6 = arg12;
            }
            else {
                v6 = arg12;
                v8 = v1.mutableRemove(arg8, arg9, v4, arg11 + 5, v6);
            }

            this = this.mutableReplaceNode(v1, v8, v10, v0, v6.getOwnership());
        }

        return this;
    }

    private final TrieNode mutableRemoveEntryAtIndex(int arg4, int arg5, PersistentHashMapBuilder arg6) {
        arg6.setSize(arg6.size() - 1);
        arg6.setOperationResult$runtime(this.valueAtKeyIndex(arg4));
        if(this.buffer.length == 2) {
            return null;
        }

        MutabilityOwnership v0 = this.ownedBy;
        MutabilityOwnership v1 = arg6.getOwnership();
        Object[] v2 = this.buffer;
        if(v0 == v1) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(v2, arg4);
            this.dataMap ^= arg5;
            return this;
        }

        return new TrieNode(arg5 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(v2, arg4), arg6.getOwnership());
    }

    private final TrieNode mutableRemoveNodeAtIndex(int arg4, int arg5, MutabilityOwnership arg6) {
        Object[] v0 = this.buffer;
        if(v0.length == 1) {
            return null;
        }

        if(this.ownedBy == arg6) {
            this.buffer = TrieNodeKt.access$removeNodeAtIndex(v0, arg4);
            this.nodeMap ^= arg5;
            return this;
        }

        return new TrieNode(this.dataMap, this.nodeMap ^ arg5, TrieNodeKt.access$removeNodeAtIndex(v0, arg4), arg6);
    }

    private final TrieNode mutableReplaceNode(TrieNode arg1, TrieNode arg2, int arg3, int arg4, MutabilityOwnership arg5) {
        if(arg2 == null) {
            return this.mutableRemoveNodeAtIndex(arg3, arg4, arg5);
        }

        if(this.ownedBy != arg5) {
            if(arg1 != arg2) {
            }
            else {
                return this;
            }
        }

        return this.mutableUpdateNodeAtIndex(arg3, arg2, arg5);
    }

    private final TrieNode mutableUpdateNodeAtIndex(int arg4, TrieNode arg5, MutabilityOwnership arg6) {
        Object[] v0 = this.buffer;
        if(v0.length == 1 && arg5.buffer.length == 2 && arg5.nodeMap == 0) {
            arg5.dataMap = this.nodeMap;
            return arg5;
        }

        if(this.ownedBy == arg6) {
            v0[arg4] = arg5;
            return this;
        }

        v0 = Arrays.copyOf(v0, v0.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg4] = arg5;
        return new TrieNode(this.dataMap, this.nodeMap, v0, arg6);
    }

    private final TrieNode mutableUpdateValueAtIndex(int arg3, Object arg4, PersistentHashMapBuilder arg5) {
        if(this.ownedBy == arg5.getOwnership()) {
            this.buffer[arg3 + 1] = arg4;
            return this;
        }

        arg5.setModCount$runtime(arg5.getModCount$runtime() + 1);
        Object[] v0 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg3 + 1] = arg4;
        return new TrieNode(this.dataMap, this.nodeMap, v0, arg5.getOwnership());
    }

    public final TrieNode nodeAtIndex$runtime(int arg1) {
        Object v0 = this.buffer[arg1];
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return ((TrieNode)v0);
    }

    public final int nodeIndex$runtime(int arg2) {
        return this.buffer.length - 1 - Integer.bitCount(this.nodeMap & arg2 - 1);
    }

    public final ModificationResult put(int arg10, Object arg11, Object arg12, int arg13) {
        ModificationResult v10_1;
        int v4 = 1 << TrieNodeKt.indexSegment(arg10, arg13);
        ModificationResult v1 = null;
        if(this.hasEntryAt$runtime(v4)) {
            int v3 = this.entryKeyIndex$runtime(v4);
            if(Intrinsics.areEqual(arg11, this.keyAtIndex(v3))) {
                if(this.valueAtKeyIndex(v3) == arg12) {
                    return v1;
                }

                return this.updateValueAtIndex(v3, arg12).asUpdateResult();
            }

            return this.moveEntryToNode(v3, v4, arg10, arg11, arg12, arg13).asInsertResult();
        }

        TrieNode v2 = this;
        int v5 = arg10;
        Object v6 = arg11;
        Object v7 = arg12;
        int v8 = arg13;
        if(v2.hasNodeAt(v4)) {
            int v9 = v2.nodeIndex$runtime(v4);
            TrieNode v10 = v2.nodeAtIndex$runtime(v9);
            if(v8 == 30) {
                v10_1 = v10.collisionPut(v6, v7);
                if(v10_1 == null) {
                    return v1;
                }
            }
            else {
                v10_1 = v10.put(v5, v6, v7, v8 + 5);
                if(v10_1 == null) {
                    return v1;
                }
            }

            v10_1.setNode(v2.updateNodeAtIndex(v9, v4, v10_1.getNode()));
            return v10_1;
        }

        return v2.insertEntryAt(v4, v6, v7).asInsertResult();
    }

    public final TrieNode remove(int arg5, Object arg6, int arg7) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg5, arg7);
        if(this.hasEntryAt$runtime(v0)) {
            arg5 = this.entryKeyIndex$runtime(v0);
            if(Intrinsics.areEqual(arg6, this.keyAtIndex(arg5))) {
                return this.removeEntryAtIndex(arg5, v0);
            }
        }
        else if(this.hasNodeAt(v0)) {
            int v1 = this.nodeIndex$runtime(v0);
            TrieNode v2 = this.nodeAtIndex$runtime(v1);
            TrieNode v5 = arg7 == 30 ? v2.collisionRemove(arg6) : v2.remove(arg5, arg6, arg7 + 5);
            this = this.replaceNode(v2, v5, v1, v0);
        }

        return this;
    }

    public final TrieNode remove(int arg5, Object arg6, Object arg7, int arg8) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg5, arg8);
        if(this.hasEntryAt$runtime(v0)) {
            arg5 = this.entryKeyIndex$runtime(v0);
            if((Intrinsics.areEqual(arg6, this.keyAtIndex(arg5))) && (Intrinsics.areEqual(arg7, this.valueAtKeyIndex(arg5)))) {
                return this.removeEntryAtIndex(arg5, v0);
            }
        }
        else if(this.hasNodeAt(v0)) {
            int v1 = this.nodeIndex$runtime(v0);
            TrieNode v2 = this.nodeAtIndex$runtime(v1);
            TrieNode v5 = arg8 == 30 ? v2.collisionRemove(arg6, arg7) : v2.remove(arg5, arg6, arg7, arg8 + 5);
            this = this.replaceNode(v2, v5, v1, v0);
        }

        return this;
    }

    private final TrieNode removeEntryAtIndex(int arg4, int arg5) {
        Object[] v0 = this.buffer;
        if(v0.length == 2) {
            return null;
        }

        return new TrieNode(arg5 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(v0, arg4));
    }

    private final TrieNode removeNodeAtIndex(int arg4, int arg5) {
        Object[] v0 = this.buffer;
        if(v0.length == 1) {
            return null;
        }

        return new TrieNode(this.dataMap, this.nodeMap ^ arg5, TrieNodeKt.access$removeNodeAtIndex(v0, arg4));
    }

    private final TrieNode replaceNode(TrieNode arg1, TrieNode arg2, int arg3, int arg4) {
        if(arg2 == null) {
            return this.removeNodeAtIndex(arg3, arg4);
        }

        if(arg1 != arg2) {
            this = this.updateNodeAtIndex(arg3, arg4, arg2);
        }

        return this;
    }

    private final TrieNode updateNodeAtIndex(int arg5, int arg6, TrieNode arg7) {
        Object[] v0 = arg7.buffer;
        if(v0.length == 2 && arg7.nodeMap == 0) {
            if(this.buffer.length == 1) {
                arg7.dataMap = this.nodeMap;
                return arg7;
            }
            else {
                return new TrieNode(this.dataMap ^ arg6, this.nodeMap ^ arg6, TrieNodeKt.access$replaceNodeWithEntry(this.buffer, arg5, this.entryKeyIndex$runtime(arg6), v0[0], v0[1]));
            }
        }

        Object[] v6 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v6, "copyOf(...)");
        v6[arg5] = arg7;
        return new TrieNode(this.dataMap, this.nodeMap, v6);
    }

    private final TrieNode updateValueAtIndex(int arg3, Object arg4) {
        Object[] v0 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg3 + 1] = arg4;
        return new TrieNode(this.dataMap, this.nodeMap, v0);
    }

    private final Object valueAtKeyIndex(int arg1) {
        return this.buffer[arg1 + 1];
    }
}

