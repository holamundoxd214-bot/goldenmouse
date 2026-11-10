package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR$\u0010\f\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "K", "V", "", "keys", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "getKeys", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "entries", "", "getEntries", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ImmutableMap extends Map, KMappedMarker {
    ImmutableSet getEntries();

    ImmutableSet getKeys();

    ImmutableCollection getValues();
}

