package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0003)*+B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001A\u00020\u000BH\u0002J\u000E\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u000BJ\u000E\u0010#\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000BJ\u0016\u0010%\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020\u000BJ\b\u0010\'\u001A\u00020(H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0006\u001A\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\rR$\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u000B@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\r\"\u0004\b\u001E\u0010\u001F¨\u0006,"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "bucketSize", "", "getBucketSize", "()I", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "cachedBucketIndex", "cachedBucket", "", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "getDefaultSpans", "currentSlotsPerLine", "totalSize", "getTotalSize", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "spanOf", "maxSpan", "invalidateCache", "", "LineConfiguration", "Bucket", "LazyGridItemSpanScopeImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridSpanLayoutProvider {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "<init>", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
            this(arg1, 0);
        }

        public Bucket(int arg1, int arg2) {
            super();
            this.firstItemIndex = arg1;
            this.firstItemKnownSpan = arg2;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "<init>", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE;
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        static {
            LazyGridItemSpanScopeImpl.INSTANCE = new LazyGridItemSpanScopeImpl();
        }

        private LazyGridItemSpanScopeImpl() {
            super();
        }

        public int getMaxCurrentLineSpan() {
            return LazyGridItemSpanScopeImpl.maxCurrentLineSpan;
        }

        public int getMaxLineSpan() {
            return LazyGridItemSpanScopeImpl.maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int arg1) {
            LazyGridItemSpanScopeImpl.maxCurrentLineSpan = arg1;
        }

        public void setMaxLineSpan(int arg1) {
            LazyGridItemSpanScopeImpl.maxLineSpan = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "<init>", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List spans;

        static {
        }

        public LineConfiguration(int arg1, List arg2) {
            super();
            this.firstItemIndex = arg1;
            this.spans = arg2;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List getSpans() {
            return this.spans;
        }
    }

    public static final int $stable = 8;
    private final ArrayList buckets;
    private final List cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List previousDefaultSpans;
    private int slotsPerLine;

    static {
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent arg5) {
        super();
        this.gridContent = arg5;
        ArrayList v5 = new ArrayList();
        v5.add(new Bucket(0, 0, 2, null));
        this.buckets = v5;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final int getBucketSize() {
        return (((int)Math.sqrt((((double)this.getTotalSize())) * 1 / (((double)this.slotsPerLine))))) + 1;
    }

    private final List getDefaultSpans(int arg5) {
        if(arg5 == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }

        ArrayList v0 = new ArrayList(arg5);
        int v1;
        for(v1 = 0; v1 < arg5; ++v1) {
            v0.add(GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(1)));
        }

        this.previousDefaultSpans = ((List)v0);
        return ((List)v0);
    }

    public final LineConfiguration getLineConfiguration(int arg11) {
        int v3;
        int v7;
        if(!this.gridContent.getHasCustomSpans$foundation()) {
            arg11 *= this.slotsPerLine;
            return new LineConfiguration(arg11, this.getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.slotsPerLine, this.getTotalSize() - arg11), 0)));
        }

        int v0 = Math.min(arg11 / this.getBucketSize(), this.buckets.size() - 1);
        int v2 = this.getBucketSize() * v0;
        int v4 = this.buckets.get(v0).getFirstItemIndex();
        int v5 = this.buckets.get(v0).getFirstItemKnownSpan();
        int v6 = this.lastLineIndex;
        if(v2 <= v6 && v6 <= arg11) {
            v4 = this.lastLineStartItemIndex;
            v5 = this.lastLineStartKnownSpan;
            v2 = v6;
        }
        else if(v0 == this.cachedBucketIndex) {
            v6 = arg11 - v2;
            if(v6 < this.cachedBucket.size()) {
                v4 = this.cachedBucket.get(v6).intValue();
                v2 = arg11;
                v5 = 0;
            }
        }

        if(v2 % this.getBucketSize() == 0) {
            v6 = this.getBucketSize();
            v7 = arg11 - v2;
            if(2 > v7) {
                goto label_58;
            }
            else if(v7 < v6) {
                v6 = 1;
            }
            else {
                goto label_58;
            }
        }
        else {
        label_58:
            v6 = 0;
        }

        if(v6 != 0) {
            this.cachedBucketIndex = v0;
            this.cachedBucket.clear();
        }

        v0 = v2 <= arg11 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("currentLine (" + v2 + ") > lineIndex (" + arg11 + ')');
        }

        while(v2 < arg11) {
            if(v4 >= this.getTotalSize()) {
                break;
            }

            if(v6 != 0) {
                this.cachedBucket.add(Integer.valueOf(v4));
            }

            v0 = 0;
            while(v0 < this.slotsPerLine) {
                if(v4 >= this.getTotalSize()) {
                    break;
                }

                if(v5 == 0) {
                    v7 = v5;
                    v5 = this.spanOf(v4, this.slotsPerLine - v0);
                }
                else {
                    v7 = 0;
                }

                v0 += v5;
                if(v0 > this.slotsPerLine) {
                    break;
                }

                ++v4;
                v5 = v7;
            }

            ++v2;
            if(v2 % this.getBucketSize() != 0) {
                continue;
            }

            if(v4 >= this.getTotalSize()) {
                continue;
            }

            v0 = this.buckets.size() == v2 / this.getBucketSize() ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("invalid starting point");
            }

            this.buckets.add(new Bucket(v4, v5));
        }

        this.lastLineIndex = arg11;
        this.lastLineStartItemIndex = v4;
        this.lastLineStartKnownSpan = v5;
        ArrayList v11 = new ArrayList();
        v0 = 0;
        v2 = v4;
        while(v0 < this.slotsPerLine) {
            if(v2 >= this.getTotalSize()) {
                break;
            }

            if(v5 == 0) {
                int v9 = v5;
                v5 = this.spanOf(v2, this.slotsPerLine - v0);
                v3 = v9;
            }
            else {
                v3 = 0;
            }

            v0 += v5;
            if(v0 > this.slotsPerLine) {
                break;
            }

            ++v2;
            ((List)v11).add(GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(v5)));
            v5 = v3;
        }

        return new LineConfiguration(v4, ((List)v11));
    }

    public final int getLineIndexOfItem(int arg11) {
        if(this.getTotalSize() <= 0) {
            return 0;
        }

        int v0 = arg11 < this.getTotalSize() ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("ItemIndex > total count");
        }

        if(!this.gridContent.getHasCustomSpans$foundation()) {
            return arg11 / this.slotsPerLine;
        }

        v0 = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new LazyGridSpanLayoutProvider$$ExternalSyntheticLambda0(arg11), 3, null);
        int v3 = 2;
        if(v0 >= 0) {
        }
        else {
            v0 = -v0 - v3;
        }

        int v4 = this.getBucketSize() * v0;
        v0 = this.buckets.get(v0).getFirstItemIndex();
        int v5 = v0 <= arg11 ? 1 : 0;
        if(v5 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("currentItemIndex > itemIndex");
        }

        v5 = 0;
        while(true) {
            int v6 = this.slotsPerLine;
            if(v0 >= arg11) {
                break;
            }

            int v7 = v0 + 1;
            v0 = this.spanOf(v0, v6 - v5);
            v5 += v0;
            v6 = this.slotsPerLine;
            if(v5 < v6) {
            }
            else if(v5 == v6) {
                ++v4;
                v5 = 0;
            }
            else {
                ++v4;
                v5 = v0;
            }

            if(v4 % this.getBucketSize() == 0 && v4 / this.getBucketSize() >= this.buckets.size()) {
                ArrayList v0_1 = this.buckets;
                int v8 = v5 > 0 ? 1 : 0;
                v0_1.add(new Bucket(v7 - v8, 0, v3, null));
            }

            v0 = v7;
        }

        if(v5 + this.spanOf(arg11, v6 - v5) > this.slotsPerLine) {
            ++v4;
        }

        return v4;
    }

    static final int getLineIndexOfItem$lambda$1(int arg0, Bucket arg1) {
        return arg1.getFirstItemIndex() - arg0;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    private final void invalidateCache() {
        this.buckets.clear();
        this.buckets.add(new Bucket(0, 0, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    public final void setSlotsPerLine(int arg2) {
        if(arg2 != this.slotsPerLine) {
            this.slotsPerLine = arg2;
            this.invalidateCache();
        }
    }

    public final int spanOf(int arg2, int arg3) {
        LazyGridItemSpanScopeImpl v0 = LazyGridItemSpanScopeImpl.INSTANCE;
        v0.setMaxCurrentLineSpan(arg3);
        v0.setMaxLineSpan(this.slotsPerLine);
        Interval v1 = this.gridContent.getIntervals().get(arg2);
        return GridItemSpan.getCurrentLineSpan-impl(v1.getValue().getSpan().invoke(v0, Integer.valueOf(arg2 - v1.getStartIndex())).unbox-impl());
    }
}

