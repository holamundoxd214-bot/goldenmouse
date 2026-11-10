package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001C\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A9\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0080\b\u001A9\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0018\u0010\u0003\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004H\u0080\b\u001AS\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u001E\u0010\u0003\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\f\u0012\u0004\u0012\u00020\u00060\u0004H\u0080\b\u001A,\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u0011\u001A,\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u0011\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u0016\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u0016\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A,\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u0018\u001A,\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u0018\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u0019\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u0019\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A,\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u001A\u001A,\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\u0006\u0010\u0010\u001A\u0002H\u000FH\u0080\n¢\u0006\u0002\u0010\u001A\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u001B\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0002\u001A4\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\u000E\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015H\u0080\u0002¢\u0006\u0002\u0010\u001B\u001A-\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0017H\u0080\u0002\u001A-\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0004\u001A-\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u000E2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0014H\u0080\u0004\u001AG\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001EH\u0080\n\u001AM\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0018\u0010\u001F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0014H\u0080\n\u001AT\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u001A\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015H\u0080\n¢\u0006\u0002\u0010 \u001AM\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0018\u0010\u001F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0017H\u0080\n\u001AI\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0014\u0010!\u001A\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\"H\u0080\n\u001AH\u0010#\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0014\u0010!\u001A\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\"H\u0000\u001AL\u0010#\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0018\u0010\u001F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0014H\u0000\u001AS\u0010#\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u001A\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015H\u0000¢\u0006\u0002\u0010 \u001AL\u0010#\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0018\u0010\u001F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0017H\u0000\u001A@\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u0006\u0010$\u001A\u0002H\nH\u0080\u0002¢\u0006\u0002\u0010%\u001AA\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u0002H\n0\u0014H\u0080\u0002\u001AH\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\u000E\u0010&\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0015H\u0080\u0002¢\u0006\u0002\u0010\'\u001AA\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t2\f\u0010&\u001A\b\u0012\u0004\u0012\u0002H\n0\u0017H\u0080\u0002\u001A-\u0010(\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0000¢\u0006\u0002\u0010)\u001A\u0014\u0010(\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000FH\u0000\u001A-\u0010*\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0000¢\u0006\u0002\u0010+\u001A\u0014\u0010*\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000FH\u0000\u001A-\u0010,\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0000¢\u0006\u0002\u0010+\u001A\u0014\u0010,\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000FH\u0000\u001AQ\u0010-\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2*\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015\"\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001EH\u0000¢\u0006\u0002\u0010.\u001A \u0010-\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000BH\u0000\u001AQ\u0010/\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2*\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015\"\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001EH\u0000¢\u0006\u0002\u0010.\u001A \u0010/\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000BH\u0000\u001A-\u00100\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0001¢\u0006\u0002\u0010)\u001A\u0014\u00100\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000FH\u0001\u001A-\u00101\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0001¢\u0006\u0002\u0010+\u001A\u0014\u00101\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000FH\u0001\u001A-\u00102\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0001\"\u0004\b\u0000\u0010\u000F2\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0001¢\u0006\u0002\u0010+\u001AQ\u00103\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2*\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015\"\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001EH\u0001¢\u0006\u0002\u0010.\u001AQ\u00104\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2*\u0010\u001F\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001E0\u0015\"\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\u001EH\u0001¢\u0006\u0002\u0010.\u001A\u001E\u00105\u001A\b\u0012\u0004\u0012\u0002H\u000206\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0000\u001A\u001E\u00105\u001A\b\u0012\u0004\u0012\u0002H\u000206\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0000\u001A\u0012\u00105\u001A\b\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001A\u001E\u00109\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0000\u001A\u001E\u00109\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0000\u001A\u0012\u00109\u001A\b\u0012\u0004\u0012\u0002070\u0007*\u000208H\u0000\u001A\u001E\u0010:\u001A\b\u0012\u0004\u0012\u0002H\u00020;\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0000\u001A\u001E\u0010:\u001A\b\u0012\u0004\u0012\u0002H\u00020;\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0000\u001A\u0012\u0010:\u001A\b\u0012\u0004\u0012\u0002070\u0001*\u000208H\u0000\u001A\u001E\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0000\u001A\u001E\u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0000\u001A\u0012\u0010<\u001A\b\u0012\u0004\u0012\u0002070\u0001*\u000208H\u0000\u001A\u001E\u0010=\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0000\u001A\u001E\u0010=\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0000\u001A\u0012\u0010=\u001A\b\u0012\u0004\u0012\u0002070\u0001*\u000208H\u0000\u001A0\u0010>\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0?\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\"H\u0000\u001A0\u0010@\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\"H\u0000\u001A0\u0010A\u001A\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B*\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B0\"H\u0000¨\u0006B"}, d2={"mutate", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "T", "mutator", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", "", "plus", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "E", "element", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "minus", "elements", "", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Lkotlin/sequences/Sequence;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "intersect", "pair", "Lkotlin/Pair;", "pairs", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "map", "", "putAll", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "persistentListOf", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "persistentSetOf", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "persistentHashSetOf", "persistentMapOf", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "persistentHashMapOf", "immutableListOf", "immutableSetOf", "immutableHashSetOf", "immutableMapOf", "immutableHashMapOf", "toImmutableList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "toPersistentList", "toImmutableSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toPersistentSet", "toPersistentHashSet", "toImmutableMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toPersistentMap", "toPersistentHashMap", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ExtensionsKt {
    @Deprecated(message="Use persistentHashMapOf instead.", replaceWith="<_subannotation>") public static final PersistentMap immutableHashMapOf(Pair[] arg1) {
        return ExtensionsKt.persistentHashMapOf(Arrays.copyOf(((Object[])arg1), arg1.length));
    }

    @Deprecated(message="Use persistentHashSetOf instead.", replaceWith="<_subannotation>") public static final PersistentSet immutableHashSetOf(Object[] arg1) {
        return ExtensionsKt.persistentHashSetOf(Arrays.copyOf(arg1, arg1.length));
    }

    @Deprecated(message="Use persistentListOf instead.", replaceWith="<_subannotation>") public static final PersistentList immutableListOf() {
        return ExtensionsKt.persistentListOf();
    }

    @Deprecated(message="Use persistentListOf instead.", replaceWith="<_subannotation>") public static final PersistentList immutableListOf(Object[] arg1) {
        return ExtensionsKt.persistentListOf(Arrays.copyOf(arg1, arg1.length));
    }

    @Deprecated(message="Use persistentMapOf instead.", replaceWith="<_subannotation>") public static final PersistentMap immutableMapOf(Pair[] arg1) {
        return ExtensionsKt.persistentMapOf(Arrays.copyOf(((Object[])arg1), arg1.length));
    }

    @Deprecated(message="Use persistentSetOf instead.", replaceWith="<_subannotation>") public static final PersistentSet immutableSetOf() {
        return ExtensionsKt.persistentSetOf();
    }

    @Deprecated(message="Use persistentSetOf instead.", replaceWith="<_subannotation>") public static final PersistentSet immutableSetOf(Object[] arg1) {
        return ExtensionsKt.persistentSetOf(Arrays.copyOf(arg1, arg1.length));
    }

    public static final PersistentSet intersect(PersistentCollection arg0, Iterable arg1) {
        return ExtensionsKt.intersect(ExtensionsKt.toPersistentSet(((Iterable)arg0)), arg1);
    }

    public static final PersistentSet intersect(PersistentSet arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.retainAll(((Collection)arg2));
        }

        Builder v1 = arg1.builder();
        CollectionsKt.retainAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentCollection minus(PersistentCollection arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.removeAll(((Collection)arg2));
        }

        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentCollection minus(PersistentCollection arg0, Object arg1) {
        return arg0.remove(arg1);
    }

    public static final PersistentCollection minus(PersistentCollection arg1, Sequence arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentCollection minus(PersistentCollection arg1, Object[] arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList minus(PersistentList arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.removeAll(((Collection)arg2));
        }

        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList minus(PersistentList arg0, Object arg1) {
        return arg0.remove(arg1);
    }

    public static final PersistentList minus(PersistentList arg1, Sequence arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList minus(PersistentList arg1, Object[] arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentMap minus(PersistentMap arg1, Iterable arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1.keySet(), arg2);
        return v1.build();
    }

    public static final PersistentMap minus(PersistentMap arg1, Object arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus>");
        return arg1.remove(arg2);
    }

    public static final PersistentMap minus(PersistentMap arg1, Sequence arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1.keySet(), arg2);
        return v1.build();
    }

    public static final PersistentMap minus(PersistentMap arg1, Object[] arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1.keySet(), arg2);
        return v1.build();
    }

    public static final PersistentSet minus(PersistentSet arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.removeAll(((Collection)arg2));
        }

        Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentSet minus(PersistentSet arg0, Object arg1) {
        return arg0.remove(arg1);
    }

    public static final PersistentSet minus(PersistentSet arg1, Sequence arg2) {
        Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentSet minus(PersistentSet arg1, Object[] arg2) {
        Builder v1 = arg1.builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList mutate(PersistentList arg0, Function1 arg1) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v0 = arg0.builder();
        arg1.invoke(v0);
        return v0.build();
    }

    public static final PersistentMap mutate(PersistentMap arg1, Function1 arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        arg2.invoke(v1);
        return v1.build();
    }

    public static final PersistentSet mutate(PersistentSet arg0, Function1 arg1) {
        Builder v0 = arg0.builder();
        arg1.invoke(v0);
        return v0.build();
    }

    public static final PersistentMap persistentHashMapOf(Pair[] arg2) {
        PersistentHashMap v0 = PersistentHashMap.Companion.emptyOf$runtime();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v0_1 = ((PersistentMap)v0).builder();
        MapsKt.putAll(v0_1, arg2);
        return v0_1.build();
    }

    public static final PersistentMap persistentHashMapOf() {
        return PersistentHashMap.Companion.emptyOf$runtime();
    }

    public static final PersistentSet persistentHashSetOf(Object[] arg1) {
        return PersistentHashSet.Companion.emptyOf$runtime().addAll(ArraysKt.asList(arg1));
    }

    public static final PersistentSet persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime();
    }

    public static final PersistentList persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final PersistentList persistentListOf(Object[] arg1) {
        return UtilsKt.persistentVectorOf().addAll(ArraysKt.asList(arg1));
    }

    public static final PersistentMap persistentMapOf(Pair[] arg2) {
        PersistentOrderedMap v0 = PersistentOrderedMap.Companion.emptyOf$runtime();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v0_1 = ((PersistentMap)v0).builder();
        MapsKt.putAll(v0_1, arg2);
        return v0_1.build();
    }

    public static final PersistentMap persistentMapOf() {
        return PersistentOrderedMap.Companion.emptyOf$runtime();
    }

    public static final PersistentSet persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime();
    }

    public static final PersistentSet persistentSetOf(Object[] arg1) {
        return PersistentOrderedSet.Companion.emptyOf$runtime().addAll(ArraysKt.asList(arg1));
    }

    public static final PersistentCollection plus(PersistentCollection arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.addAll(((Collection)arg2));
        }

        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentCollection plus(PersistentCollection arg0, Object arg1) {
        return arg0.add(arg1);
    }

    public static final PersistentCollection plus(PersistentCollection arg1, Sequence arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentCollection plus(PersistentCollection arg1, Object[] arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList plus(PersistentList arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.addAll(((Collection)arg2));
        }

        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList plus(PersistentList arg0, Object arg1) {
        return arg0.add(arg1);
    }

    public static final PersistentList plus(PersistentList arg1, Sequence arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentList plus(PersistentList arg1, Object[] arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentMap plus(PersistentMap arg0, Iterable arg1) {
        return ExtensionsKt.putAll(arg0, arg1);
    }

    public static final PersistentMap plus(PersistentMap arg0, Map arg1) {
        return ExtensionsKt.putAll(arg0, arg1);
    }

    public static final PersistentMap plus(PersistentMap arg1, Pair arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus>");
        return arg1.put(arg2.getFirst(), arg2.getSecond());
    }

    public static final PersistentMap plus(PersistentMap arg0, Sequence arg1) {
        return ExtensionsKt.putAll(arg0, arg1);
    }

    public static final PersistentMap plus(PersistentMap arg0, Pair[] arg1) {
        return ExtensionsKt.putAll(arg0, arg1);
    }

    public static final PersistentSet plus(PersistentSet arg1, Iterable arg2) {
        if((arg2 instanceof Collection)) {
            return arg1.addAll(((Collection)arg2));
        }

        Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentSet plus(PersistentSet arg0, Object arg1) {
        return arg0.add(arg1);
    }

    public static final PersistentSet plus(PersistentSet arg1, Sequence arg2) {
        Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentSet plus(PersistentSet arg1, Object[] arg2) {
        Builder v1 = arg1.builder();
        CollectionsKt.addAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentMap putAll(PersistentMap arg1, Iterable arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        MapsKt.putAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentMap putAll(PersistentMap arg1, Map arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll>");
        return arg1.putAll(arg2);
    }

    public static final PersistentMap putAll(PersistentMap arg1, Sequence arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        MapsKt.putAll(v1, arg2);
        return v1.build();
    }

    public static final PersistentMap putAll(PersistentMap arg1, Pair[] arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder v1 = arg1.builder();
        MapsKt.putAll(v1, arg2);
        return v1.build();
    }

    public static final ImmutableList toImmutableList(CharSequence arg0) {
        return ExtensionsKt.toPersistentList(arg0);
    }

    public static final ImmutableList toImmutableList(Iterable arg1) {
        Iterable v0 = (arg1 instanceof ImmutableList) ? arg1 : null;
        if(v0 == null) {
            return ExtensionsKt.toPersistentList(arg1);
        }

        return ((ImmutableList)v0);
    }

    public static final ImmutableList toImmutableList(Sequence arg0) {
        return ExtensionsKt.toPersistentList(arg0);
    }

    public static final ImmutableMap toImmutableMap(Map arg2) {
        PersistentMap v1 = null;
        Map v0 = (arg2 instanceof ImmutableMap) ? arg2 : ((Map)v1);
        if(v0 == null) {
            v0 = (arg2 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder) ? arg2 : ((Map)v1);
            if(v0 != null) {
                v1 = ((androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder)v0).build();
            }

            if(v1 != null) {
                return ((ImmutableMap)v1);
            }

            return ExtensionsKt.persistentMapOf().putAll(arg2);
        }

        return ((ImmutableMap)v0);
    }

    public static final ImmutableSet toImmutableSet(Iterable arg2) {
        PersistentSet v1 = null;
        Iterable v0 = (arg2 instanceof ImmutableSet) ? arg2 : ((Iterable)v1);
        if(v0 == null) {
            v0 = (arg2 instanceof Builder) ? arg2 : ((Iterable)v1);
            if(v0 != null) {
                v1 = ((Builder)v0).build();
            }

            if(v1 != null) {
                return ((ImmutableSet)v1);
            }

            return ExtensionsKt.plus(ExtensionsKt.persistentSetOf(), arg2);
        }

        return ((ImmutableSet)v0);
    }

    public static final ImmutableSet toImmutableSet(Sequence arg0) {
        return ExtensionsKt.toPersistentSet(arg0);
    }

    public static final PersistentSet toImmutableSet(CharSequence arg0) {
        return ExtensionsKt.toPersistentSet(arg0);
    }

    public static final PersistentMap toPersistentHashMap(Map arg2) {
        PersistentHashMap v1 = null;
        Map v0 = (arg2 instanceof PersistentHashMap) ? arg2 : ((Map)v1);
        if(v0 != null) {
            return ((PersistentMap)v0);
        }

        v0 = (arg2 instanceof PersistentHashMapBuilder) ? arg2 : ((Map)v1);
        if(v0 != null) {
            v1 = ((PersistentHashMapBuilder)v0).build();
        }

        if(v1 != null) {
            return ((PersistentMap)v1);
        }

        return PersistentHashMap.Companion.emptyOf$runtime().putAll(arg2);
    }

    public static final PersistentSet toPersistentHashSet(CharSequence arg2) {
        Builder v0 = ExtensionsKt.persistentHashSetOf().builder();
        StringsKt.toCollection(arg2, v0);
        return v0.build();
    }

    public static final PersistentSet toPersistentHashSet(Iterable arg2) {
        PersistentHashSet v1 = null;
        Iterable v0 = (arg2 instanceof PersistentHashSet) ? arg2 : ((Iterable)v1);
        if(v0 != null) {
            return ((PersistentSet)v0);
        }

        v0 = (arg2 instanceof PersistentHashSetBuilder) ? arg2 : ((Iterable)v1);
        if(v0 != null) {
            v1 = ((PersistentHashSetBuilder)v0).build();
        }

        if(v1 != null) {
            return ((PersistentSet)v1);
        }

        return ExtensionsKt.plus(PersistentHashSet.Companion.emptyOf$runtime(), arg2);
    }

    public static final PersistentSet toPersistentHashSet(Sequence arg1) {
        return ExtensionsKt.plus(ExtensionsKt.persistentHashSetOf(), arg1);
    }

    public static final PersistentList toPersistentList(CharSequence arg2) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder v0 = ExtensionsKt.persistentListOf().builder();
        StringsKt.toCollection(arg2, v0);
        return v0.build();
    }

    public static final PersistentList toPersistentList(Iterable arg2) {
        PersistentList v1 = null;
        Iterable v0 = (arg2 instanceof PersistentList) ? arg2 : ((Iterable)v1);
        if(v0 == null) {
            v0 = (arg2 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder) ? arg2 : ((Iterable)v1);
            if(v0 != null) {
                v1 = ((androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder)v0).build();
            }

            if(v1 == null) {
                return ExtensionsKt.plus(ExtensionsKt.persistentListOf(), arg2);
            }

            return v1;
        }

        return ((PersistentList)v0);
    }

    public static final PersistentList toPersistentList(Sequence arg1) {
        return ExtensionsKt.plus(ExtensionsKt.persistentListOf(), arg1);
    }

    public static final PersistentMap toPersistentMap(Map arg2) {
        PersistentMap v1 = null;
        Map v0 = (arg2 instanceof PersistentOrderedMap) ? arg2 : ((Map)v1);
        if(v0 != null) {
            return ((PersistentMap)v0);
        }

        v0 = (arg2 instanceof PersistentOrderedMapBuilder) ? arg2 : ((Map)v1);
        if(v0 != null) {
            v1 = ((PersistentOrderedMapBuilder)v0).build();
        }

        if(v1 == null) {
            return PersistentOrderedMap.Companion.emptyOf$runtime().putAll(arg2);
        }

        return v1;
    }

    public static final PersistentSet toPersistentSet(Iterable arg2) {
        PersistentSet v1 = null;
        Iterable v0 = (arg2 instanceof PersistentOrderedSet) ? arg2 : ((Iterable)v1);
        if(v0 != null) {
            return ((PersistentSet)v0);
        }

        v0 = (arg2 instanceof PersistentOrderedSetBuilder) ? arg2 : ((Iterable)v1);
        if(v0 != null) {
            v1 = ((PersistentOrderedSetBuilder)v0).build();
        }

        if(v1 == null) {
            return ExtensionsKt.plus(PersistentOrderedSet.Companion.emptyOf$runtime(), arg2);
        }

        return v1;
    }

    public static final PersistentSet toPersistentSet(Sequence arg1) {
        return ExtensionsKt.plus(ExtensionsKt.persistentSetOf(), arg1);
    }

    public static final PersistentSet toPersistentSet(CharSequence arg2) {
        Builder v0 = ExtensionsKt.persistentSetOf().builder();
        StringsKt.toCollection(arg2, v0);
        return v0.build();
    }
}

