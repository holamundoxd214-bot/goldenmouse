package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000F\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0014\u001A\u00020\u0015H\u0086\bJ:\u0010\u0014\u001A\u00020\u00152!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J$\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u0003H\u0007J\u0011\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0018H\u0086\u0002J\u000E\u0010 \u001A\u00020\u00152\u0006\u0010!\u001A\u00020\u0000J\t\u0010\"\u001A\u00020\u0003H\u0086\bJ:\u0010\"\u001A\u00020\u00032!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010#\u001A\u00020\u00182\b\b\u0001\u0010$\u001A\u00020\u0003J9\u0010%\u001A\u00020\u00182\b\b\u0001\u0010$\u001A\u00020\u00032!\u0010&\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180\u0017H\u0086\bø\u0001\u0000J\u0013\u0010\'\u001A\u00020\u00152\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010)\u001A\u00020\u0018J:\u0010)\u001A\u00020\u00182!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001Jb\u0010*\u001A\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001A\u0002H+26\u0010-\u001A2\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002H+0.H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100Jw\u00101\u001A\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001A\u0002H+2K\u0010-\u001AG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002H+02H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00103Jb\u00104\u001A\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001A\u0002H+26\u0010-\u001A2\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H+0.H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100Jw\u00105\u001A\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001A\u0002H+2K\u0010-\u001AG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H+02H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00103J:\u00106\u001A\u0002072!\u00108\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002070\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00109\u001A\u00020726\u00108\u001A2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002070.H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010:\u001A\u0002072!\u00108\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002070\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010;\u001A\u00020726\u00108\u001A2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002070.H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010<\u001A\u00020\u00182\b\b\u0001\u0010$\u001A\u00020\u0003H\u0086\u0002J\b\u0010=\u001A\u00020\u0003H\u0016J\u000E\u0010>\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u0018J:\u0010?\u001A\u00020\u00032!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010@\u001A\u00020\u00032!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\t\u0010A\u001A\u00020\u0015H\u0086\bJ\t\u0010B\u001A\u00020\u0015H\u0086\bJ:\u0010C\u001A\u00020D2\b\b\u0002\u0010E\u001A\u00020F2\b\b\u0002\u0010G\u001A\u00020F2\b\b\u0002\u0010H\u001A\u00020F2\b\b\u0002\u0010I\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020FH\u0007JT\u0010C\u001A\u00020D2\b\b\u0002\u0010E\u001A\u00020F2\b\b\u0002\u0010G\u001A\u00020F2\b\b\u0002\u0010H\u001A\u00020F2\b\b\u0002\u0010I\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020F2\u0014\b\u0004\u0010K\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020F0\u0017H\u0087\bø\u0001\u0000J\u0006\u0010L\u001A\u00020\u0018J:\u0010L\u001A\u00020\u00182!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000E\u0010M\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u0018J\t\u0010N\u001A\u00020\u0015H\u0086\bJ:\u0010O\u001A\u00020\u00152!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010P\u001A\u00020DH\u0016R\u0018\u0010\u0005\u001A\u00020\u00038\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\t8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0007R\u0012\u0010\u000B\u001A\u00020\f8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0012\u0010\u000F\u001A\u00020\u00038Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001A\u00020\u00038Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011\u0082\u0001\u0001Q\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, d2={"Landroidx/collection/LongList;", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "binarySearch", "fromIndex", "toIndex", "contains", "containsAll", "elements", "count", "elementAt", "index", "elementAtOrElse", "defaultValue", "equals", "other", "first", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "none", "reversedAny", "toString", "Landroidx/collection/MutableLongList;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public abstract class LongList {
    public int _size;
    public long[] content;

    private LongList(int arg1) {
        super();
        long[] v1 = arg1 == 0 ? LongSetKt.getEmptyLongArray() : new long[arg1];
        this.content = v1;
    }

    public LongList(int arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final boolean any() {
        if(this._size != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean any(Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "predicate");
        long[] v0 = this.content;
        int v5 = this._size;
        int v2;
        for(v2 = 0; v2 < v5; ++v2) {
            if(arg6.invoke(Long.valueOf(v0[v2])).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public final int binarySearch(int arg7, int arg8, int arg9) {
        int v0;
        if(arg8 < 0 || arg8 >= arg9 || arg9 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }

        --arg9;
        while(true) {
            if(arg8 > arg9) {
                goto label_21;
            }

            v0 = arg8 + arg9 >>> 1;
            int v1 = Long.compare(this.content[v0], ((long)arg7));
            if(v1 < 0) {
                arg8 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg9 = v0 - 1;
        }

        return v0;
    label_21:
        return -(arg8 + 1);
    }

    public final int binarySearch(int arg7) {
        return LongList.binarySearch$default(this, arg7, 0, 0, 6, null);
    }

    public final int binarySearch(int arg7, int arg8) {
        return LongList.binarySearch$default(this, arg7, arg8, 0, 4, null);
    }

    public static int binarySearch$default(LongList arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg0._size;
            }

            return arg0.binarySearch(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
    }

    public final boolean contains(long arg6) {
        long[] v0 = this.content;
        int v5 = this._size;
        int v2;
        for(v2 = 0; v2 < v5; ++v2) {
            if(v0[v2] == arg6) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean containsAll(LongList arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        IntRange v0 = RangesKt.until(0, arg6._size);
        int v2 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v2 <= v0_1) {
            while(true) {
                if(!this.contains(arg6.get(v2))) {
                    return 0;
                }
                else if(v2 != v0_1) {
                    ++v2;
                    continue;
                }

                return 1;
            }

            return 0;
        }

        return 1;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "predicate");
        long[] v0 = this.content;
        int v5 = this._size;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            if(arg6.invoke(Long.valueOf(v0[v1])).booleanValue()) {
                ++v2;
            }

            ++v1;
        }

        return v2;
    }

    public final long elementAt(int arg3) {
        if(arg3 < 0 || arg3 >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        return this.content[arg3];
    }

    public final long elementAtOrElse(int arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        if(arg2 >= 0 && arg2 < this._size) {
            return this.content[arg2];
        }

        return arg3.invoke(Integer.valueOf(arg2)).longValue();
    }

    public boolean equals(Object arg8) {
        if((arg8 instanceof LongList)) {
            int v0 = ((LongList)arg8)._size;
            int v2 = this._size;
            if(v0 != v2) {
            }
            else {
                long[] v7 = this.content;
                long[] v8 = ((LongList)arg8).content;
                IntRange v0_1 = RangesKt.until(0, v2);
                v2 = v0_1.getFirst();
                v0 = v0_1.getLast();
                if(v2 <= v0) {
                    while(true) {
                        if(v7[v2] != v8[v2]) {
                            return 0;
                        }
                        else if(v2 != v0) {
                            ++v2;
                            continue;
                        }

                        return 1;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final long first() {
        if(this._size == 0) {
            RuntimeHelpersKt.throwNoSuchElementException("LongList is empty.");
        }

        return this.content[0];
    }

    public final long first(Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "predicate");
        long[] v0 = this.content;
        int v5 = this._size;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            long v2 = v0[v1];
            if(arg6.invoke(Long.valueOf(v2)).booleanValue()) {
                return v2;
            }
        }

        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final Object fold(Object arg5, Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "operation");
        long[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5 = arg6.invoke(arg5, Long.valueOf(v0[v1]));
        }

        return arg5;
    }

    public final Object foldIndexed(Object arg6, Function3 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "operation");
        long[] v0 = this.content;
        int v5 = this._size;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            arg6 = arg7.invoke(Integer.valueOf(v1), arg6, Long.valueOf(v0[v1]));
        }

        return arg6;
    }

    public final Object foldRight(Object arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "operation");
        long[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            arg4 = arg5.invoke(Long.valueOf(v0[v3]), arg4);
        }

        return arg4;
    }

    public final Object foldRightIndexed(Object arg5, Function3 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "operation");
        long[] v0 = this.content;
        int v4;
        for(v4 = this._size - 1; -1 < v4; --v4) {
            arg5 = arg6.invoke(Integer.valueOf(v4), Long.valueOf(v0[v4]), arg5);
        }

        return arg5;
    }

    public final void forEach(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "block");
        long[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            arg5.invoke(Long.valueOf(v0[v1]));
        }
    }

    public final void forEachIndexed(Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "block");
        long[] v0 = this.content;
        int v5 = this._size;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            arg6.invoke(Integer.valueOf(v1), Long.valueOf(v0[v1]));
        }
    }

    public final void forEachReversed(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        long[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; -1 < v3; --v3) {
            arg4.invoke(Long.valueOf(v0[v3]));
        }
    }

    public final void forEachReversedIndexed(Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "block");
        long[] v0 = this.content;
        int v4;
        for(v4 = this._size - 1; -1 < v4; --v4) {
            arg5.invoke(Integer.valueOf(v4), Long.valueOf(v0[v4]));
        }
    }

    public final long get(int arg3) {
        if(arg3 < 0 || arg3 >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        return this.content[arg3];
    }

    public static void getContent$annotations() {
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public final int getSize() {
        return this._size;
    }

    public static void get_size$annotations() {
    }

    public int hashCode() {
        long[] v0 = this.content;
        int v5 = this._size;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            v2 += Long.hashCode(v0[v1]) * 0x1F;
            ++v1;
        }

        return v2;
    }

    public final int indexOf(long arg5) {
        long[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            if(arg5 == v0[v1]) {
                return v1;
            }
        }

        return -1;
    }

    public final int indexOfFirst(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        long[] v0 = this.content;
        int v4 = this._size;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            if(arg5.invoke(Long.valueOf(v0[v1])).booleanValue()) {
                return v1;
            }
        }

        return -1;
    }

    public final int indexOfLast(Function1 arg4) {
        int v1;
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        long[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; true; --v3) {
            v1 = -1;
            if(v1 >= v3) {
                return v1;
            }

            if(arg4.invoke(Long.valueOf(v0[v3])).booleanValue()) {
                return v3;
            }
        }

        return v1;
    }

    public final boolean isEmpty() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this._size != 0) {
            return 1;
        }

        return 0;
    }

    public final String joinToString(CharSequence arg5, CharSequence arg6, CharSequence arg7, int arg8, CharSequence arg9) {
        Intrinsics.checkNotNullParameter(arg5, "separator");
        Intrinsics.checkNotNullParameter(arg6, "prefix");
        Intrinsics.checkNotNullParameter(arg7, "postfix");
        Intrinsics.checkNotNullParameter(arg9, "truncated");
        StringBuilder v0 = new StringBuilder();
        v0.append(arg6);
        long[] v6 = this.content;
        int v4 = this._size;
        int v1 = 0;
        while(true) {
            if(v1 < v4) {
                long v2 = v6[v1];
                if(v1 == arg8) {
                    v0.append(arg9);
                }
                else {
                    if(v1 != 0) {
                        v0.append(arg5);
                    }

                    v0.append(v2);
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_25;
        }

        v0.append(arg7);
    label_25:
        String v4_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v4_1, "toString(...)");
        return v4_1;
    }

    public final String joinToString() {
        return LongList.joinToString$default(this, null, null, null, 0, null, 0x1F, null);
    }

    public final String joinToString(CharSequence arg10) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        return LongList.joinToString$default(this, arg10, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        return LongList.joinToString$default(this, arg10, arg11, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return LongList.joinToString$default(this, arg10, arg11, arg12, 0, null, 24, null);
    }

    public final String joinToString(CharSequence arg10, CharSequence arg11, CharSequence arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg10, "separator");
        Intrinsics.checkNotNullParameter(arg11, "prefix");
        Intrinsics.checkNotNullParameter(arg12, "postfix");
        return LongList.joinToString$default(this, arg10, arg11, arg12, arg13, null, 16, null);
    }

    public final String joinToString(CharSequence arg5, CharSequence arg6, CharSequence arg7, int arg8, CharSequence arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg5, "separator");
        Intrinsics.checkNotNullParameter(arg6, "prefix");
        Intrinsics.checkNotNullParameter(arg7, "postfix");
        Intrinsics.checkNotNullParameter(arg9, "truncated");
        Intrinsics.checkNotNullParameter(arg10, "transform");
        StringBuilder v0 = new StringBuilder();
        v0.append(arg6);
        long[] v6 = this.content;
        int v4 = this._size;
        int v1 = 0;
        while(true) {
            if(v1 < v4) {
                long v2 = v6[v1];
                if(v1 == arg8) {
                    v0.append(arg9);
                }
                else {
                    if(v1 != 0) {
                        v0.append(arg5);
                    }

                    v0.append(arg10.invoke(Long.valueOf(v2)));
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_29;
        }

        v0.append(arg7);
    label_29:
        String v4_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v4_1, "toString(...)");
        return v4_1;
    }

    public final String joinToString(CharSequence arg6, CharSequence arg7, CharSequence arg8, int arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg6, "separator");
        Intrinsics.checkNotNullParameter(arg7, "prefix");
        Intrinsics.checkNotNullParameter(arg8, "postfix");
        Intrinsics.checkNotNullParameter(arg10, "transform");
        String v0 = "...";
        StringBuilder v1 = new StringBuilder();
        v1.append(arg7);
        long[] v7 = this.content;
        int v5 = this._size;
        int v2 = 0;
        while(true) {
            if(v2 < v5) {
                long v3 = v7[v2];
                if(v2 == arg9) {
                    v1.append(((CharSequence)v0));
                }
                else {
                    if(v2 != 0) {
                        v1.append(arg6);
                    }

                    v1.append(arg10.invoke(Long.valueOf(v3)));
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_28;
        }

        v1.append(arg8);
    label_28:
        String v5_1 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v5_1, "toString(...)");
        return v5_1;
    }

    public final String joinToString(CharSequence arg7, CharSequence arg8, CharSequence arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg7, "separator");
        Intrinsics.checkNotNullParameter(arg8, "prefix");
        Intrinsics.checkNotNullParameter(arg9, "postfix");
        Intrinsics.checkNotNullParameter(arg10, "transform");
        String v0 = "...";
        StringBuilder v1 = new StringBuilder();
        v1.append(arg8);
        long[] v8 = this.content;
        int v6 = this._size;
        int v2 = 0;
        while(true) {
            if(v2 < v6) {
                long v3 = v8[v2];
                if(v2 == -1) {
                    v1.append(((CharSequence)v0));
                }
                else {
                    if(v2 != 0) {
                        v1.append(arg7);
                    }

                    v1.append(arg10.invoke(Long.valueOf(v3)));
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_29;
        }

        v1.append(arg9);
    label_29:
        String v6_1 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v6_1, "toString(...)");
        return v6_1;
    }

    public final String joinToString(CharSequence arg8, CharSequence arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg8, "separator");
        Intrinsics.checkNotNullParameter(arg9, "prefix");
        Intrinsics.checkNotNullParameter(arg10, "transform");
        String v0 = "";
        String v1 = "...";
        StringBuilder v2 = new StringBuilder();
        v2.append(arg9);
        long[] v9 = this.content;
        int v7 = this._size;
        int v3 = 0;
        while(true) {
            if(v3 < v7) {
                long v4 = v9[v3];
                if(v3 == -1) {
                    v2.append(((CharSequence)v1));
                }
                else {
                    if(v3 != 0) {
                        v2.append(arg8);
                    }

                    v2.append(arg10.invoke(Long.valueOf(v4)));
                    ++v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_28;
        }

        v2.append(((CharSequence)v0));
    label_28:
        String v7_1 = v2.toString();
        Intrinsics.checkNotNullExpressionValue(v7_1, "toString(...)");
        return v7_1;
    }

    public final String joinToString(CharSequence arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg9, "separator");
        Intrinsics.checkNotNullParameter(arg10, "transform");
        String v0 = "";
        String v2 = "...";
        StringBuilder v3 = new StringBuilder();
        v3.append(v0);
        long[] v1 = this.content;
        int v8 = this._size;
        int v4 = 0;
        while(true) {
            if(v4 < v8) {
                long v5 = v1[v4];
                if(v4 == -1) {
                    v3.append(((CharSequence)v2));
                }
                else {
                    if(v4 != 0) {
                        v3.append(arg9);
                    }

                    v3.append(arg10.invoke(Long.valueOf(v5)));
                    ++v4;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_27;
        }

        v3.append(((CharSequence)v0));
    label_27:
        String v8_1 = v3.toString();
        Intrinsics.checkNotNullExpressionValue(v8_1, "toString(...)");
        return v8_1;
    }

    public final String joinToString(Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg10, "transform");
        String v0 = ", ";
        String v1 = "";
        String v3 = "...";
        StringBuilder v4 = new StringBuilder();
        v4.append(v1);
        long[] v2 = this.content;
        int v9 = this._size;
        int v5 = 0;
        while(true) {
            if(v5 < v9) {
                long v6 = v2[v5];
                if(v5 == -1) {
                    v4.append(((CharSequence)v3));
                }
                else {
                    if(v5 != 0) {
                        v4.append(((CharSequence)v0));
                    }

                    v4.append(arg10.invoke(Long.valueOf(v6)));
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_26;
        }

        v4.append(((CharSequence)v1));
    label_26:
        String v9_1 = v4.toString();
        Intrinsics.checkNotNullExpressionValue(v9_1, "toString(...)");
        return v9_1;
    }

    public static String joinToString$default(LongList arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, int arg7, Object arg8) {
        String v6;
        String v4;
        String v3;
        String v2;
        if(arg8 == null) {
            if((arg7 & 1) != 0) {
                v2 = ", ";
            }

            String v0 = "";
            if((arg7 & 2) != 0) {
                v3 = v0;
            }

            if((arg7 & 4) != 0) {
                v4 = v0;
            }

            if((arg7 & 8) != 0) {
                arg5 = -1;
            }

            if((arg7 & 16) != 0) {
                v6 = "...";
            }

            return arg1.joinToString(((CharSequence)v2), ((CharSequence)v3), ((CharSequence)v4), arg5, ((CharSequence)v6));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static String joinToString$default(LongList arg2, CharSequence arg3, CharSequence arg4, CharSequence arg5, int arg6, CharSequence arg7, Function1 arg8, int arg9, Object arg10) {
        String v7;
        String v5;
        String v4;
        String v3;
        if(arg10 == null) {
            if((arg9 & 1) != 0) {
                v3 = ", ";
            }

            String v0 = "";
            if((arg9 & 2) != 0) {
                v4 = v0;
            }

            if((arg9 & 4) != 0) {
                v5 = v0;
            }

            if((arg9 & 8) != 0) {
                arg6 = -1;
            }

            if((arg9 & 16) != 0) {
                v7 = "...";
            }

            Intrinsics.checkNotNullParameter(v3, "separator");
            Intrinsics.checkNotNullParameter(v4, "prefix");
            Intrinsics.checkNotNullParameter(v5, "postfix");
            Intrinsics.checkNotNullParameter(v7, "truncated");
            Intrinsics.checkNotNullParameter(arg8, "transform");
            StringBuilder v9 = new StringBuilder();
            v9.append(((CharSequence)v4));
            long[] v4_1 = arg2.content;
            int v2 = arg2._size;
            int v10 = 0;
            while(true) {
                if(v10 < v2) {
                    long v0_1 = v4_1[v10];
                    if(v10 == arg6) {
                        v9.append(((CharSequence)v7));
                    }
                    else {
                        if(v10 != 0) {
                            v9.append(((CharSequence)v3));
                        }

                        v9.append(arg8.invoke(Long.valueOf(v0_1)));
                        ++v10;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_46;
            }

            v9.append(((CharSequence)v5));
        label_46:
            String v2_1 = v9.toString();
            Intrinsics.checkNotNullExpressionValue(v2_1, "toString(...)");
            return v2_1;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final long last() {
        if(this._size == 0) {
            RuntimeHelpersKt.throwNoSuchElementException("LongList is empty.");
        }

        return this.content[this._size - 1];
    }

    public final long last(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        long[] v0 = this.content;
        int v4;
        for(v4 = this._size - 1; -1 < v4; --v4) {
            long v1 = v0[v4];
            if(arg5.invoke(Long.valueOf(v1)).booleanValue()) {
                return v1;
            }
        }

        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final int lastIndexOf(long arg4) {
        int v1;
        long[] v0 = this.content;
        int v3;
        for(v3 = this._size - 1; true; --v3) {
            v1 = -1;
            if(v1 >= v3) {
                return v1;
            }

            if(v0[v3] == arg4) {
                return v3;
            }
        }

        return v1;
    }

    public final boolean none() {
        if(this._size == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean reversedAny(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "predicate");
        long[] v0 = this.content;
        int v4;
        for(v4 = this._size - 1; -1 < v4; --v4) {
            if(arg5.invoke(Long.valueOf(v0[v4])).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public String toString() {
        return LongList.joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }
}

