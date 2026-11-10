package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0016B!\b\u0002\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0011H\u0096\u0002R\u001E\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0007\u001A\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2={"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "<init>", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "getTrie$okio", "()[I", "size", "", "getSize", "()I", "get", "index", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Options extends AbstractList implements RandomAccess {
    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\tJT\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00112\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u0018\u0010\u0016\u001A\u00020\r*\u00020\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"Lokio/Options$Companion;", "", "<init>", "()V", "of", "Lokio/Options;", "byteStrings", "", "Lokio/ByteString;", "([Lokio/ByteString;)Lokio/Options;", "buildTrieRecursive", "", "nodeOffset", "", "node", "Lokio/Buffer;", "byteStringOffset", "", "", "fromIndex", "toIndex", "indexes", "intCount", "getIntCount", "(Lokio/Buffer;)J", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final void buildTrieRecursive(long arg22, Buffer arg24, int arg25, List arg26, int arg27, int arg28, List arg29) {
            long v1_1;
            long v17;
            int v6;
            int v2_2;
            Companion v0 = this;
            Buffer v9 = arg24;
            int v10 = arg25;
            List v5 = arg26;
            int v1 = arg27;
            int v11 = arg28;
            List v8 = arg29;
            String v2 = "Failed requirement.";
            if(v1 >= v11) {
                goto label_175;
            }

            int v3;
            for(v3 = v1; true; ++v3) {
                if(v3 >= v11) {
                    goto label_20;
                }

                if(v5.get(v3).size() < v10) {
                    break;
                }
            }

            throw new IllegalArgumentException(v2.toString());
        label_20:
            Object v2_1 = arg26.get(arg27);
            Object v3_1 = v5.get(v11 - 1);
            int v12 = -1;
            if(v10 == ((ByteString)v2_1).size()) {
                v2_2 = v8.get(v1).intValue();
                ++v1;
                Object v4 = v5.get(v1);
                v6 = v1;
                v1 = v2_2;
                v2_1 = v4;
            }
            else {
                v6 = v1;
                v1 = v12;
            }

            long v13 = 2;
            if(((ByteString)v2_1).getByte(v10) != ((ByteString)v3_1).getByte(v10)) {
                v2_2 = v6 + 1;
                v3 = 1;
                goto label_42;
            }

            int v4_1 = Math.min(((ByteString)v2_1).size(), ((ByteString)v3_1).size());
            int v7 = 0;
            int v15 = v10;
            while(true) {
                int v16 = v12;
                if(v15 < v4_1) {
                    v17 = v13;
                    if(((ByteString)v2_1).getByte(v15) == ((ByteString)v3_1).getByte(v15)) {
                        ++v7;
                        ++v15;
                        v12 = v16;
                        v13 = v17;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_130;
            }

            v17 = v13;
        label_130:
            long v3_2 = arg22 + v0.getIntCount(v9) + v17 + (((long)v7)) + 1;
            v9.writeInt(-v7);
            v9.writeInt(v1);
            v1 = v10 + v7;
            while(v10 < v1) {
                v9.writeInt(((ByteString)v2_1).getByte(v10) & 0xFF);
                ++v10;
            }

            if(v6 + 1 == v11) {
                if(v1 == v5.get(v6).size()) {
                    v9.writeInt(v8.get(v6).intValue());
                    return;
                }

                throw new IllegalStateException("Check failed.");
            }

            long v19 = v3_2;
            Buffer v3_3 = new Buffer();
            v9.writeInt((((int)(v0.getIntCount(v3_3) + v19))) * -1);
            v0.buildTrieRecursive(v19, v3_3, v1, v5, v6, v11, v8);
            Long.valueOf(v9.writeAll(((Source)v3_3)));
            return;
        label_42:
            while(v2_2 < v11) {
                if(v5.get(v2_2 - 1).getByte(v10) != v5.get(v2_2).getByte(v10)) {
                    ++v3;
                }

                ++v2_2;
            }

            long v15_1 = arg22 + v0.getIntCount(v9) + v13 + (((long)(v3 * 2)));
            v9.writeInt(v3);
            v9.writeInt(v1);
            for(v1 = v6; v1 < v11; ++v1) {
                v2_2 = v5.get(v1).getByte(v10);
                if(v1 == v6 || v2_2 != v5.get(v1 - 1).getByte(v10)) {
                    v9.writeInt(v2_2 & 0xFF);
                }
            }

            v3_3 = new Buffer();
            while(v6 < v11) {
                v1 = v5.get(v6).getByte(v10);
                v2_2 = v6 + 1;
                v4_1 = v2_2;
                while(true) {
                    if(v4_1 >= v11) {
                        break;
                    }
                    else if(v1 != v5.get(v4_1).getByte(v10)) {
                        v7 = v4_1;
                    }
                    else {
                        ++v4_1;
                        continue;
                    }

                    goto label_89;
                }

                v7 = v11;
            label_89:
                if(v2_2 != v7 || v10 + 1 != v5.get(v6).size()) {
                    v9.writeInt((((int)(v0.getIntCount(v3_3) + v15_1))) * v12);
                    v1_1 = v15_1;
                    v0.buildTrieRecursive(v1_1, v3_3, v10 + 1, v5, v6, v7, v8);
                }
                else {
                    v9.writeInt(v8.get(v6).intValue());
                    v1_1 = v15_1;
                }

                v15_1 = v1_1;
                v6 = v7;
            }

            Long.valueOf(v9.writeAll(((Source)v3_3)));
            return;
        label_175:
            throw new IllegalArgumentException(v2.toString());
        }

        static void buildTrieRecursive$default(Companion arg9, long arg10, Buffer arg12, int arg13, List arg14, int arg15, int arg16, List arg17, int arg18, Object arg19) {
            if((arg18 & 1) != 0) {
                arg10 = 0;
            }

            long v1 = arg10;
            int v4 = (arg18 & 4) != 0 ? 0 : arg13;
            int v6 = (arg18 & 16) != 0 ? 0 : arg15;
            int v7 = (arg18 & 0x20) != 0 ? arg14.size() : arg16;
            arg9.buildTrieRecursive(v1, arg12, v4, arg14, v6, v7, arg17);
        }

        private final long getIntCount(Buffer arg3) {
            return arg3.size() / 4;
        }

        @JvmStatic public final Options of(ByteString[] arg17) {
            Object v8;
            ByteString[] v0 = arg17;
            Intrinsics.checkNotNullParameter(v0, "byteStrings");
            DefaultConstructorMarker v2 = null;
            int v3 = -1;
            int v4 = 0;
            if(v0.length == 0) {
                return new Options(new ByteString[0], new int[]{0, v3}, v2);
            }

            List v5 = ArraysKt.toMutableList(((Object[])v0));
            CollectionsKt.sort(v5);
            int v1 = v5.size();
            ArrayList v6 = new ArrayList(v1);
            int v7;
            for(v7 = 0; v7 < v1; ++v7) {
                v6.add(Integer.valueOf(v3));
            }

            ArrayList v13 = v6;
            v1 = v0.length;
            v3 = 0;
            int v11;
            for(v11 = 0; v3 < v1; ++v11) {
                ((List)v13).set(CollectionsKt.binarySearch$default(v5, v0[v3], 0, 0, 6, null), Integer.valueOf(v11));
                ++v3;
            }

            if(v5.get(0).size() > 0) {
                v1 = 0;
            }
            else {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }

            while(v1 < v5.size()) {
                Object v3_1 = v5.get(v1);
                int v6_1 = v1 + 1;
                v7 = v6_1;
                while(true) {
                    if(v7 < v5.size()) {
                        v8 = v5.get(v7);
                        if(((ByteString)v8).startsWith(((ByteString)v3_1))) {
                            if(((ByteString)v8).size() != ((ByteString)v3_1).size()) {
                                if(((List)v13).get(v7).intValue() > ((List)v13).get(v1).intValue()) {
                                    v5.remove(v7);
                                    ((List)v13).remove(v7).intValue();
                                }
                                else {
                                    ++v7;
                                }

                                continue;
                            }
                            else {
                                break;
                            }
                        }
                    }

                    goto label_78;
                }

                throw new IllegalArgumentException("duplicate option: " + v8.toString());
            label_78:
                v1 = v6_1;
            }

            Buffer v8_1 = new Buffer();
            Companion.buildTrieRecursive$default(this, 0, v8_1, 0, v5, 0, 0, ((List)v13), 53, null);
            v1 = ((int)this.getIntCount(v8_1));
            int[] v3_2 = new int[v1];
            while(v4 < v1) {
                v3_2[v4] = v8_1.readInt();
                ++v4;
            }

            Object[] v0_1 = Arrays.copyOf(((Object[])v0), v0.length);
            Intrinsics.checkNotNullExpressionValue(v0_1, "copyOf(...)");
            return new Options(((ByteString[])v0_1), v3_2, v2);
        }
    }

    public static final Companion Companion;
    private final ByteString[] byteStrings;
    private final int[] trie;

    static {
        Options.Companion = new Companion(null);
    }

    private Options(ByteString[] arg1, int[] arg2) {
        super();
        this.byteStrings = arg1;
        this.trie = arg2;
    }

    public Options(ByteString[] arg1, int[] arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof ByteString)) {
            return 0;
        }

        return this.contains(((ByteString)arg2));
    }

    public boolean contains(ByteString arg1) {
        return super.contains(arg1);
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public ByteString get(int arg1) {
        return this.byteStrings[arg1];
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof ByteString)) {
            return -1;
        }

        return this.indexOf(((ByteString)arg2));
    }

    public int indexOf(ByteString arg1) {
        return super.indexOf(arg1);
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof ByteString)) {
            return -1;
        }

        return this.lastIndexOf(((ByteString)arg2));
    }

    public int lastIndexOf(ByteString arg1) {
        return super.lastIndexOf(arg1);
    }

    @JvmStatic public static final Options of(ByteString[] arg1) {
        return Options.Companion.of(arg1);
    }
}

