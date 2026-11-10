package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b#\b!\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001F\u001A\u00020 *\u00020!2\u0006\u0010\"\u001A\u00020\u0011J\b\u0010#\u001A\u00020 H\u0002J\n\u0010$\u001A\u00020 *\u00020!J\u0006\u0010%\u001A\u00020\u0005J\u0014\u0010&\u001A\u00020 *\u00020!2\u0006\u0010\"\u001A\u00020\u0011H\u0002J\u0014\u0010\'\u001A\u00020 *\u00020!2\u0006\u0010\"\u001A\u00020\u0011H\u0002J\u0014\u0010(\u001A\u00020 *\u00020!2\u0006\u0010)\u001A\u00020\u0005H\u0002J\f\u0010*\u001A\u00020 *\u00020!H\u0002J\u0006\u0010+\u001A\u00020 JD\u0010,\u001A\u00020 *\u00020!2\u0006\u0010-\u001A\u00020\u00132\u0006\u0010.\u001A\u00020\u00132\u0006\u0010/\u001A\u00020\u00132\u0006\u00100\u001A\u00020\u00132\u0006\u00101\u001A\u00020\u00132\u0006\u00102\u001A\u00020\u00112\u0006\u00103\u001A\u00020\u0005H\u0002J@\u00104\u001A\u00020 2\u0006\u0010-\u001A\u00020\u00132\u0006\u0010.\u001A\u00020\u00132\u0006\u00100\u001A\u00020\u00132\u0006\u00101\u001A\u00020\u00132\u0006\u00105\u001A\u00020\u00132\u0006\u00102\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u0013H\u0002J\u001C\u00106\u001A\u00020\u0013*\u00020!2\u0006\u00107\u001A\u00020\u00132\u0006\u00108\u001A\u00020\u0005H\u0002J\u0018\u00109\u001A\u00020 2\u0006\u00107\u001A\u00020\u00132\u0006\u0010:\u001A\u00020\u0013H\u0002J \u0010;\u001A\u00020\u000F2\u0006\u00107\u001A\u00020\u00132\u0006\u0010:\u001A\u00020\u00132\u0006\u0010<\u001A\u00020\u0001H\u0002J \u0010=\u001A\u00020 2\u0006\u00107\u001A\u00020\u00132\u0006\u0010<\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u0013H\u0002J\u0018\u0010>\u001A\u00020 2\u0006\u0010?\u001A\u00020\u00132\u0006\u0010@\u001A\u00020\u0013H\u0002J\u001C\u0010A\u001A\u00020 *\u00020!2\u0006\u00107\u001A\u00020\u00132\u0006\u0010B\u001A\u00020\u0013H\u0002J\f\u0010C\u001A\u00020 *\u00020!H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u001E\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u000E\u0010\u001B\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006D"}, d2={"Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "enableInitialPrefetch", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;Z)V", "prefetchWindowHandles", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indicesToRemove", "Landroidx/collection/MutableIntSet;", "windowCache", "Landroidx/compose/foundation/lazy/layout/CachedItem;", "previousPassDelta", "", "previousPassItemCount", "", "hasUpdatedVisibleItemsOnce", "value", "prefetchWindowStartLine", "getPrefetchWindowStartLine$foundation", "()I", "prefetchWindowEndLine", "getPrefetchWindowEndLine$foundation", "prefetchWindowStartExtraSpace", "prefetchWindowEndExtraSpace", "shouldRefillWindow", "itemsCount", "onScroll", "", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "delta", "traceWindowInfo", "onVisibleItemsUpdated", "hasValidBounds", "fillCacheWindowBackward", "fillCacheWindowForward", "refillWindow", "refillForward", "onDatasetChangedSize", "resetStrategy", "onPrefetchForward", "visibleWindowStart", "visibleWindowEnd", "prefetchForwardWindow", "mainAxisExtraSpaceEnd", "mainAxisExtraSpaceStart", "scrollDelta", "applyForwardPrefetch", "onKeepAround", "keepAroundWindow", "getItemSizeOrPrefetch", "index", "isUrgent", "cachePrefetchedItem", "size", "updateOrCreateCachedItem", "key", "cacheVisibleItemsInfo", "removeOutOfBoundsItems", "startLine", "endLine", "onItemPrefetched", "itemSize", "scheduleNextItemIfNeeded", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class CacheWindowLogic {
    public static final int $stable = 8;
    private final LazyLayoutCacheWindow cacheWindow;
    private final boolean enableInitialPrefetch;
    private boolean hasUpdatedVisibleItemsOnce;
    private final MutableIntSet indicesToRemove;
    private int itemsCount;
    private int prefetchWindowEndExtraSpace;
    private int prefetchWindowEndLine;
    private final MutableIntObjectMap prefetchWindowHandles;
    private int prefetchWindowStartExtraSpace;
    private int prefetchWindowStartLine;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean shouldRefillWindow;
    private final MutableIntObjectMap windowCache;

    static {
    }

    public CacheWindowLogic(LazyLayoutCacheWindow arg1, boolean arg2) {
        super();
        this.cacheWindow = arg1;
        this.enableInitialPrefetch = arg2;
        this.prefetchWindowHandles = IntObjectMapKt.mutableIntObjectMapOf();
        this.indicesToRemove = IntSetKt.mutableIntSetOf();
        this.windowCache = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousPassItemCount = -1;
        this.prefetchWindowStartLine = 0x7FFFFFFF;
        this.prefetchWindowEndLine = 0x80000000;
    }

    public CacheWindowLogic(LazyLayoutCacheWindow arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, true);
    }

    private final void cachePrefetchedItem(int arg3, int arg4) {
        this.windowCache.set(arg3, this.updateOrCreateCachedItem(arg3, arg4, CachedItem.NoKey));
        if(arg3 > this.prefetchWindowEndLine) {
            this.prefetchWindowEndLine = arg3;
            this.prefetchWindowEndExtraSpace -= arg4;
            return;
        }

        if(arg3 < this.prefetchWindowStartLine) {
            this.prefetchWindowStartLine = arg3;
            this.prefetchWindowStartExtraSpace -= arg4;
        }
    }

    private final void cacheVisibleItemsInfo(int arg3, Object arg4, int arg5) {
        if(this.windowCache.containsKey(arg3)) {
            Object v0 = this.windowCache.get(arg3);
            Intrinsics.checkNotNull(v0);
            int v0_1 = ((CachedItem)v0).getMainAxisSize();
            Object v1 = this.windowCache.get(arg3);
            Intrinsics.checkNotNull(v1);
            v1 = ((CachedItem)v1).getKey();
            if(v0_1 == arg5 && (Intrinsics.areEqual(v1, arg4))) {
                goto label_16;
            }

            this.shouldRefillWindow = true;
        }

    label_16:
        this.windowCache.set(arg3, this.updateOrCreateCachedItem(arg3, arg5, arg4));
        this.prefetchWindowStartLine = Math.min(this.prefetchWindowStartLine, arg3);
        this.prefetchWindowEndLine = Math.max(this.prefetchWindowEndLine, arg3);
        Object v2 = this.prefetchWindowHandles.remove(arg3);
        if(v2 != null) {
            arg3 = v2.size();
            int v4;
            for(v4 = 0; v4 < arg3; ++v4) {
                ((List)v2).get(v4).cancel();
            }
        }
    }

    private final void fillCacheWindowBackward(CacheWindowScope arg10, float arg11) {
        if(arg10.getHasVisibleItems()) {
            int v0 = arg10.getMainAxisViewportSize();
            LazyLayoutCacheWindow v1 = this.cacheWindow;
            Density v2 = arg10.getDensity();
            v0 = v2 != null ? v1.calculateBehindWindow(v2, v0) : 0;
            this.itemsCount = arg10.getTotalItemsCount();
            this.onKeepAround(arg10.getFirstVisibleLineIndex(), arg10.getLastVisibleLineIndex(), arg10.getMainAxisExtraSpaceEnd(), arg10.getMainAxisExtraSpaceStart(), v0, arg11, arg10.getTotalItemsCount());
        }
    }

    private final void fillCacheWindowForward(CacheWindowScope arg14, float arg15) {
        if(arg14.getHasVisibleItems()) {
            int v0 = arg14.getMainAxisViewportSize();
            LazyLayoutCacheWindow v1 = this.cacheWindow;
            Density v2 = arg14.getDensity();
            boolean v3 = false;
            int v8 = v2 != null ? v1.calculateAheadWindow(v2, v0) : 0;
            int v6 = arg14.getFirstVisibleLineIndex();
            int v7 = arg14.getLastVisibleLineIndex();
            int v10 = arg14.getMainAxisExtraSpaceStart();
            int v9 = arg14.getMainAxisExtraSpaceEnd();
            if(arg15 <= 0f) {
                v3 = true;
            }

            this.onPrefetchForward(arg14, v6, v7, v8, v9, v10, arg15, v3);
        }
    }

    private final int getItemSizeOrPrefetch(CacheWindowScope arg5, int arg6, boolean arg7) {
        int v5;
        Object v4;
        if(this.windowCache.containsKey(arg6)) {
            v4 = this.windowCache.get(arg6);
            Intrinsics.checkNotNull(v4);
            return ((CachedItem)v4).getMainAxisSize();
        }

        int v1 = 0;
        int v2 = -1;
        if(this.prefetchWindowHandles.containsKey(arg6)) {
            if(arg7) {
                v4 = this.prefetchWindowHandles.get(arg6);
                if(v4 != null) {
                    v5 = v4.size();
                    while(v1 < v5) {
                        ((List)v4).get(v1).markAsUrgent();
                        ++v1;
                    }
                }
            }

            return v2;
        }

        this.prefetchWindowHandles.set(arg6, arg5.schedulePrefetch(arg6, new CacheWindowLogic$$ExternalSyntheticLambda0(this, arg5)));
        if(arg7) {
            v4 = this.prefetchWindowHandles.get(arg6);
            if(v4 != null) {
                v5 = v4.size();
                while(v1 < v5) {
                    ((List)v4).get(v1).markAsUrgent();
                    ++v1;
                }
            }
        }

        return v2;
    }

    static final Unit getItemSizeOrPrefetch$lambda$4(CacheWindowLogic arg0, CacheWindowScope arg1, int arg2, int arg3) {
        arg0.onItemPrefetched(arg1, arg2, arg3);
        return Unit.INSTANCE;
    }

    public final int getPrefetchWindowEndLine$foundation() {
        return this.prefetchWindowEndLine;
    }

    public final int getPrefetchWindowStartLine$foundation() {
        return this.prefetchWindowStartLine;
    }

    public final boolean hasValidBounds() {
        if(this.prefetchWindowStartLine != 0x7FFFFFFF && this.prefetchWindowEndLine != 0x80000000) {
            return 1;
        }

        return 0;
    }

    private final void onDatasetChangedSize(CacheWindowScope arg5) {
        this.shouldRefillWindow = true;
        this.prefetchWindowStartLine = RangesKt.coerceAtLeast(this.prefetchWindowStartLine, 0);
        int v1 = arg5.getLastLineIndex();
        if(v1 != -1) {
            this.prefetchWindowEndLine = RangesKt.coerceAtMost(this.prefetchWindowEndLine, v1);
        }

        if(this.previousPassDelta <= 0f) {
            this.removeOutOfBoundsItems(arg5.getLastVisibleLineIndex(), this.itemsCount - 1);
            return;
        }

        this.removeOutOfBoundsItems(0, arg5.getFirstVisibleLineIndex());
    }

    private final void onItemPrefetched(CacheWindowScope arg1, int arg2, int arg3) {
        this.cachePrefetchedItem(arg2, arg3);
        this.scheduleNextItemIfNeeded(arg1);
        this.traceWindowInfo();
    }

    private final void onKeepAround(int arg2, int arg3, int arg4, int arg5, int arg6, float arg7, int arg8) {
        Object v2;
        if(arg7 <= 0f) {
            this.prefetchWindowStartExtraSpace = arg6 - arg5;
            this.prefetchWindowStartLine = arg2;
            while(this.prefetchWindowStartExtraSpace > 0) {
                arg2 = this.prefetchWindowStartLine;
                if(arg2 <= 0) {
                    break;
                }

                if(!this.windowCache.containsKey(arg2 - 1)) {
                    break;
                }

                v2 = this.windowCache.get(this.prefetchWindowStartLine - 1);
                Intrinsics.checkNotNull(v2);
                arg2 = ((CachedItem)v2).getMainAxisSize();
                --this.prefetchWindowStartLine;
                this.prefetchWindowStartExtraSpace -= arg2;
            }

            this.removeOutOfBoundsItems(0, this.prefetchWindowStartLine - 1);
            return;
        }

        this.prefetchWindowEndExtraSpace = arg6 - arg4;
        this.prefetchWindowEndLine = arg3;
        while(this.prefetchWindowEndExtraSpace > 0) {
            arg2 = this.prefetchWindowEndLine;
            if(arg2 >= arg8 - 1) {
                break;
            }

            if(!this.windowCache.containsKey(arg2 + 1)) {
                break;
            }

            v2 = this.windowCache.get(this.prefetchWindowEndLine + 1);
            Intrinsics.checkNotNull(v2);
            arg2 = ((CachedItem)v2).getMainAxisSize();
            ++this.prefetchWindowEndLine;
            this.prefetchWindowEndExtraSpace -= arg2;
        }

        this.removeOutOfBoundsItems(this.prefetchWindowEndLine + 1, arg8 - 1);
    }

    private final void onPrefetchForward(CacheWindowScope arg6, int arg7, int arg8, int arg9, int arg10, int arg11, float arg12, boolean arg13) {
        int v0 = Float.compare(Math.signum(arg12), Math.signum(this.previousPassDelta)) == 0 ? 1 : 0;
        int v4 = -1;
        if(arg13) {
            if(v0 == 0 || (this.shouldRefillWindow)) {
                this.prefetchWindowEndExtraSpace = arg9 - arg10;
                this.prefetchWindowEndLine = arg8;
            }
            else {
                this.prefetchWindowEndExtraSpace = RangesKt.coerceAtMost(this.prefetchWindowEndExtraSpace + MathKt.roundToInt(Math.abs(arg12)), arg9 - arg10);
            }

            while(this.prefetchWindowEndExtraSpace > 0) {
                if(arg6.getLastIndexInLine(this.prefetchWindowEndLine) == v4) {
                    return;
                }

                if(arg6.getLastIndexInLine(this.prefetchWindowEndLine) >= this.itemsCount - 1) {
                    return;
                }

                boolean v7 = this.prefetchWindowEndLine + 1 != arg8 + 1 || arg12 == 0f || Math.abs(arg12) < (((float)arg10)) ? false : true;
                arg7 = this.getItemSizeOrPrefetch(arg6, this.prefetchWindowEndLine + 1, v7);
                if(arg7 == v4) {
                    return;
                }

                ++this.prefetchWindowEndLine;
                this.prefetchWindowEndExtraSpace -= arg7;
            }
        }
        else {
            if(v0 == 0 || (this.shouldRefillWindow)) {
                this.prefetchWindowStartExtraSpace = arg9 - arg11;
                this.prefetchWindowStartLine = arg7;
            }
            else {
                this.prefetchWindowStartExtraSpace = RangesKt.coerceAtMost(this.prefetchWindowStartExtraSpace + MathKt.roundToInt(Math.abs(arg12)), arg9 - arg11);
            }

            while(this.prefetchWindowStartExtraSpace > 0) {
                arg8 = this.prefetchWindowStartLine;
                if(arg8 <= 0) {
                    return;
                }

                boolean v8 = arg8 - 1 != arg7 - 1 || arg12 == 0f || Math.abs(arg12) < (((float)arg11)) ? false : true;
                arg8 = this.getItemSizeOrPrefetch(arg6, this.prefetchWindowStartLine - 1, v8);
                if(arg8 == v4) {
                    return;
                }

                this.prefetchWindowStartLine += v4;
                this.prefetchWindowStartExtraSpace -= arg8;
            }
        }
    }

    public final void onScroll(CacheWindowScope arg1, float arg2) {
        this.traceWindowInfo();
        this.fillCacheWindowBackward(arg1, arg2);
        this.fillCacheWindowForward(arg1, arg2);
        this.previousPassDelta = arg2;
        this.traceWindowInfo();
    }

    public final void onVisibleItemsUpdated(CacheWindowScope arg9) {
        int v0_1;
        boolean v1 = true;
        if(!this.hasUpdatedVisibleItemsOnce && (this.enableInitialPrefetch)) {
            LazyLayoutCacheWindow v0 = this.cacheWindow;
            Density v3 = arg9.getDensity();
            v0_1 = v3 != null ? v0.calculateAheadWindow(v3, arg9.getMainAxisViewportSize()) : 0;
            if(v0_1 != 0) {
                this.shouldRefillWindow = true;
            }

            this.hasUpdatedVisibleItemsOnce = true;
        }

        v0_1 = this.previousPassItemCount;
        int v3_1 = -1;
        if(v0_1 != v3_1 && v0_1 != arg9.getTotalItemsCount()) {
            this.onDatasetChangedSize(arg9);
        }

        this.itemsCount = arg9.getTotalItemsCount();
        if(arg9.getHasVisibleItems()) {
            v0_1 = arg9.getVisibleLineCount();
            int v4;
            for(v4 = 0; v4 < v0_1; ++v4) {
                int v5 = arg9.getVisibleItemLine(v4);
                Object v6 = arg9.getVisibleLineKey(v4);
                int v7 = arg9.getVisibleItemSize(v4);
                if(v5 != v3_1) {
                    this.cacheVisibleItemsInfo(v5, v6, v7);
                }
            }

            if(!this.shouldRefillWindow) {
                goto label_47;
            }

            if(this.previousPassDelta <= 0f) {
            }
            else {
                v1 = false;
            }

            this.refillWindow(arg9, v1);
            this.shouldRefillWindow = false;
        }
        else {
            this.resetStrategy();
        }

    label_47:
        this.previousPassItemCount = arg9.getTotalItemsCount();
    }

    private final void refillWindow(CacheWindowScope arg11, boolean arg12) {
        if(arg11.getHasVisibleItems()) {
            int v0 = arg11.getMainAxisViewportSize();
            LazyLayoutCacheWindow v1 = this.cacheWindow;
            Density v2 = arg11.getDensity();
            v0 = v2 != null ? v1.calculateAheadWindow(v2, v0) : 0;
            this.onPrefetchForward(arg11, arg11.getFirstVisibleLineIndex(), arg11.getLastVisibleLineIndex(), v0, arg11.getMainAxisExtraSpaceEnd(), arg11.getMainAxisExtraSpaceStart(), 0f, arg12);
        }
    }

    private final void removeOutOfBoundsItems(int arg25, int arg26) {
        int v11_1;
        long v22;
        int v21;
        int v9;
        int v8;
        long v18;
        long v16;
        CacheWindowLogic v0 = this;
        int v1 = arg25;
        int v2 = arg26;
        v0.indicesToRemove.clear();
        MutableIntObjectMap v3 = v0.prefetchWindowHandles;
        int[] v4 = ((IntObjectMap)v3).keys;
        long[] v3_1 = ((IntObjectMap)v3).metadata;
        int v5 = v3_1.length - 2;
        int v10 = 7;
        long v11 = -9187201950435737472L;
        int v13 = 8;
        if(v5 >= 0) {
            int v15 = 0;
            v16 = 0x80;
            while(true) {
                long v6 = v3_1[v15];
                v18 = 0xFF;
                if((~v6 << v10 & v6 & v11) != v11) {
                    v8 = 8 - (~(v15 - v5) >>> 0x1F);
                    v9 = 0;
                    while(v9 < v8) {
                        if((v6 & v18) < v16) {
                            v21 = v10;
                            v10 = v4[(v15 << 3) + v9];
                            if(v1 > v10) {
                                goto label_43;
                            }
                            else if(v10 <= v2) {
                                v22 = v11;
                                v0.indicesToRemove.add(v10);
                            }
                            else {
                                goto label_43;
                            }
                        }
                        else {
                            v21 = v10;
                        label_43:
                            v22 = v11;
                        }

                        v6 >>= v13;
                        ++v9;
                        v10 = v21;
                        v11 = v22;
                    }

                    v21 = v10;
                    v22 = v11;
                    if(v8 != v13) {
                        break;
                    }
                }
                else {
                    v21 = v10;
                    v22 = v11;
                }

                if(v15 == v5) {
                    break;
                }

                ++v15;
                v10 = v21;
                v11 = v22;
            }
        }
        else {
            v21 = v10;
            v22 = v11;
            v16 = 0x80;
            v18 = 0xFF;
        }

        v3 = v0.windowCache;
        v4 = ((IntObjectMap)v3).keys;
        v3_1 = ((IntObjectMap)v3).metadata;
        v5 = v3_1.length - 2;
        if(v5 >= 0) {
            int v6_1;
            for(v6_1 = 0; true; ++v6_1) {
                long v7 = v3_1[v6_1];
                if((~v7 << v21 & v7 & v22) != v22) {
                    v9 = 8 - (~(v6_1 - v5) >>> 0x1F);
                    for(v10 = 0; v10 < v9; ++v10) {
                        if((v7 & v18) < v16) {
                            v11_1 = v4[(v6_1 << 3) + v10];
                            if(v1 <= v11_1 && v11_1 <= v2) {
                                v0.indicesToRemove.add(v11_1);
                            }
                        }

                        v7 >>= v13;
                    }

                    if(v9 != v13) {
                        break;
                    }
                }

                if(v6_1 == v5) {
                    break;
                }
            }
        }

        MutableIntSet v1_1 = v0.indicesToRemove;
        int[] v2_1 = ((IntSet)v1_1).elements;
        long[] v1_2 = ((IntSet)v1_1).metadata;
        int v3_2 = v1_2.length - 2;
        if(v3_2 >= 0) {
            int v4_1;
            for(v4_1 = 0; true; ++v4_1) {
                long v5_1 = v1_2[v4_1];
                if((~v5_1 << v21 & v5_1 & v22) != v22) {
                    int v7_1 = 8 - (~(v4_1 - v3_2) >>> 0x1F);
                    for(v8 = 0; v8 < v7_1; ++v8) {
                        if((v5_1 & v18) < v16) {
                            v9 = v2_1[(v4_1 << 3) + v8];
                            Object v10_1 = v0.prefetchWindowHandles.remove(v9);
                            if(v10_1 != null) {
                                v11_1 = v10_1.size();
                                int v12;
                                for(v12 = 0; v12 < v11_1; ++v12) {
                                    ((List)v10_1).get(v12).cancel();
                                }
                            }

                            v0.windowCache.remove(v9);
                        }

                        v5_1 >>= v13;
                    }

                    if(v7_1 != v13) {
                        return;
                    }
                }

                if(v4_1 == v3_2) {
                    return;
                }
            }
        }
    }

    public final void resetStrategy() {
        this.prefetchWindowStartLine = 0x7FFFFFFF;
        this.prefetchWindowEndLine = 0x80000000;
        this.prefetchWindowStartExtraSpace = 0;
        this.prefetchWindowEndExtraSpace = 0;
        this.shouldRefillWindow = false;
        this.windowCache.clear();
        MutableIntObjectMap v14 = this.prefetchWindowHandles;
        long[] v1 = v14.metadata;
        int v2 = v1.length - 2;
        if(v2 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v1[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v2) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            int v9 = (v3 << 3) + v8;
                            Object v10 = v14.values[v9];
                            int v11 = v10.size();
                            int v12;
                            for(v12 = 0; v12 < v11; ++v12) {
                                ((List)v10).get(v12).cancel();
                            }

                            v14.removeValueAt(v9);
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v2) {
                    return;
                }
            }
        }
    }

    private final void scheduleNextItemIfNeeded(CacheWindowScope arg4) {
        int v0;
        int v2 = -1;
        if(Float.compare(Math.signum(this.previousPassDelta), 0f) <= 0) {
            if(this.prefetchWindowEndExtraSpace > 0) {
                v0 = this.prefetchWindowEndLine + 1;
            }
            else {
                goto label_19;
            }
        }
        else if(Math.signum(this.previousPassDelta) <= 0f) {
        label_19:
            v0 = v2;
        }
        else if(this.prefetchWindowStartExtraSpace > 0) {
            v0 = this.prefetchWindowStartLine - 1;
        }
        else {
            goto label_19;
        }

        if(v0 > 0 && arg4.getLastIndexInLine(v0) != v2 && arg4.getLastIndexInLine(v0) < this.itemsCount) {
            this.prefetchWindowHandles.set(v0, arg4.schedulePrefetch(v0, new CacheWindowLogic$$ExternalSyntheticLambda1(this, arg4)));
        }
    }

    static final Unit scheduleNextItemIfNeeded$lambda$1(CacheWindowLogic arg0, CacheWindowScope arg1, int arg2, int arg3) {
        arg0.onItemPrefetched(arg1, arg2, arg3);
        return Unit.INSTANCE;
    }

    private final void traceWindowInfo() {
        AndroidTrace_androidKt.traceValue("prefetchWindowStartExtraSpace", ((long)this.prefetchWindowStartExtraSpace));
        AndroidTrace_androidKt.traceValue("prefetchWindowEndExtraSpace", ((long)this.prefetchWindowEndExtraSpace));
        AndroidTrace_androidKt.traceValue("prefetchWindowStartIndex", ((long)this.prefetchWindowStartLine));
        AndroidTrace_androidKt.traceValue("prefetchWindowEndIndex", ((long)this.prefetchWindowEndLine));
    }

    private final CachedItem updateOrCreateCachedItem(int arg1, int arg2, Object arg3) {
        Object v0 = this.windowCache.get(arg1);
        if(v0 != null) {
            ((CachedItem)v0).setMainAxisSize(arg2);
            ((CachedItem)v0).setKey(arg3);
            return ((CachedItem)v0);
        }

        return new CachedItem(CachedItem.NoKey, arg2);
    }
}

