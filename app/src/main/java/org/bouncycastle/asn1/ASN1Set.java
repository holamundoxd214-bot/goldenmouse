package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Set extends ASN1Primitive implements Iterable {
    class org.bouncycastle.asn1.ASN1Set$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Set$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
            return arg1.toASN1Set();
        }
    }

    static final ASN1UniversalType TYPE;
    protected final ASN1Encodable[] elements;
    protected ASN1Encodable[] sortedElements;

    static {
        ASN1Set.TYPE = new org.bouncycastle.asn1.ASN1Set$1(ASN1Set.class, 17);
    }

    protected ASN1Set() {
        super();
        ASN1Encodable[] v0 = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.elements = v0;
        this.sortedElements = v0;
    }

    protected ASN1Set(ASN1Encodable arg3) {
        super();
        if(arg3 != null) {
            ASN1Encodable[] v0 = new ASN1Encodable[]{arg3};
            this.elements = v0;
            this.sortedElements = v0;
            return;
        }

        throw new NullPointerException("\'element\' cannot be null");
    }

    protected ASN1Set(ASN1EncodableVector arg3, boolean arg4) {
        ASN1Encodable[] v3;
        super();
        if(arg3 != null) {
            int v0 = 2;
            if(!arg4 || arg3.size() < v0) {
                v3 = arg3.takeElements();
            }
            else {
                v3 = arg3.copyElements();
                ASN1Set.sort(v3);
            }

            this.elements = v3;
            if(!arg4) {
                if(v3.length < v0) {
                }
                else {
                    v3 = null;
                }
            }

            this.sortedElements = v3;
            return;
        }

        throw new NullPointerException("\'elementVector\' cannot be null");
    }

    ASN1Set(boolean arg2, ASN1Encodable[] arg3) {
        super();
        this.elements = arg3;
        if(!arg2) {
            if(arg3.length < 2) {
            }
            else {
                arg3 = null;
            }
        }

        this.sortedElements = arg3;
    }

    protected ASN1Set(ASN1Encodable[] arg4, boolean arg5) {
        super();
        if(!Arrays.isNullOrContainsNull(((Object[])arg4))) {
            ASN1Encodable[] v0 = ASN1EncodableVector.cloneElements(arg4);
            int v1 = 2;
            if((arg5) && v0.length >= v1) {
                ASN1Set.sort(v0);
            }

            this.elements = v0;
            if(!arg5) {
                if(v0.length < v1) {
                }
                else {
                    arg4 = null;
                }
            }

            this.sortedElements = arg4;
            return;
        }

        throw new NullPointerException("\'elements\' cannot be null, or contain null");
    }

    ASN1Set(ASN1Encodable[] arg1, ASN1Encodable[] arg2) {
        super();
        this.elements = arg1;
        this.sortedElements = arg2;
    }

    boolean asn1Equals(ASN1Primitive arg6) {
        if(!(arg6 instanceof ASN1Set)) {
            return 0;
        }

        int v0 = this.size();
        if(((ASN1Set)arg6).size() != v0) {
            return 0;
        }

        ASN1Primitive v5 = this.toDERObject();
        arg6 = ((ASN1Set)arg6).toDERObject();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ASN1Primitive v3 = ((DERSet)v5).elements[v2].toASN1Primitive();
            ASN1Primitive v4 = ((DERSet)arg6).elements[v2].toASN1Primitive();
            if(v3 != v4 && !v3.asn1Equals(v4)) {
                return 0;
            }
        }

        return 1;
    }

    boolean encodeConstructed() {
        return 1;
    }

    private static byte[] getDEREncoded(ASN1Encodable arg1) {
        try {
            return arg1.toASN1Primitive().getEncoded("DER");
        }
        catch(IOException ) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static ASN1Set getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1Set)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1Set)) {
                        return ((ASN1Set)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1Set.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct set from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("unknown object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1Set getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Set.TYPE.getContextTagged(arg1, arg2);
    }

    public ASN1Encodable getObjectAt(int arg1) {
        return this.elements[arg1];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos;

            public boolean hasMoreElements() {
                if(this.pos < ASN1Set.this.elements.length) {
                    return 1;
                }

                return 0;
            }

            public Object nextElement() {
                if(this.pos < ASN1Set.this.elements.length) {
                    ASN1Encodable[] v0 = ASN1Set.this.elements;
                    int v1 = this.pos;
                    this.pos = v1 + 1;
                    return v0[v1];
                }

                throw new NoSuchElementException();
            }
        };
    }

    public static ASN1Set getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Set.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        int v0 = this.elements.length;
        int v1;
        for(v1 = v0 + 1; true; v1 += this.elements[v0].toASN1Primitive().hashCode()) {
            --v0;
            if(v0 < 0) {
                return v1;
            }
        }

        return v1;
    }

    public Iterator iterator() {
        return new org.bouncycastle.util.Arrays$Iterator(this.toArray());
    }

    private static boolean lessThanOrEqual(byte[] arg6, byte[] arg7) {
        int v1 = arg6[0] & 0xDF;
        int v2 = arg7[0] & 0xDF;
        if(v1 != v2) {
            if(v1 < v2) {
                return 1;
            }

            return 0;
        }

        v1 = Math.min(arg6.length, arg7.length) - 1;
        for(v2 = 1; v2 < v1; ++v2) {
            int v4 = arg6[v2];
            int v5 = arg7[v2];
            if(v4 != v5) {
                if((v4 & 0xFF) < (v5 & 0xFF)) {
                    return 1;
                }

                return 0;
            }
        }

        if((arg6[v1] & 0xFF) <= (arg7[v1] & 0xFF)) {
            return 1;
        }

        return 0;
    }

    public ASN1SetParser parser() {
        return new ASN1SetParser(this.size()) {
            private int pos;

            public ASN1Primitive getLoadedObject() {
                return ASN1Set.this;
            }

            public ASN1Encodable readObject() throws IOException {
                ASN1SetParser v3_1;
                if(this.val$count == this.pos) {
                    return null;
                }

                ASN1Encodable[] v0 = ASN1Set.this.elements;
                int v1 = this.pos;
                this.pos = v1 + 1;
                ASN1Encodable v3 = v0[v1];
                if((v3 instanceof ASN1Sequence)) {
                    return ((ASN1Sequence)v3).parser();
                }

                if((v3 instanceof ASN1Set)) {
                    v3_1 = ((ASN1Set)v3).parser();
                }

                return ((ASN1Encodable)v3_1);
            }

            public ASN1Primitive toASN1Primitive() {
                return ASN1Set.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    private static void sort(ASN1Encodable[] arg13) {
        int v10;
        int v0 = arg13.length;
        int v1 = 2;
        if(v0 < v1) {
            return;
        }

        ASN1Encodable v2 = arg13[0];
        ASN1Encodable v4 = arg13[1];
        byte[] v5 = ASN1Set.getDEREncoded(v2);
        byte[] v6 = ASN1Set.getDEREncoded(v4);
        if(ASN1Set.lessThanOrEqual(v6, v5)) {
            ASN1Encodable v12 = v4;
            v4 = v2;
            v2 = v12;
            byte[] v12_1 = v6;
            v6 = v5;
            v5 = v12_1;
        }

        while(v1 < v0) {
            ASN1Encodable v7 = arg13[v1];
            byte[] v8 = ASN1Set.getDEREncoded(v7);
            if(ASN1Set.lessThanOrEqual(v6, v8)) {
                arg13[v1 - 2] = v2;
                v2 = v4;
                v5 = v6;
                v4 = v7;
                v6 = v8;
            }
            else if(ASN1Set.lessThanOrEqual(v5, v8)) {
                arg13[v1 - 2] = v2;
                v2 = v7;
                v5 = v8;
            }
            else {
                int v9 = v1 - 1;
                while(true) {
                    v10 = v9 - 1;
                    if(v10 > 0) {
                        ASN1Encodable v9_1 = arg13[v9 - 2];
                        if(ASN1Set.lessThanOrEqual(ASN1Set.getDEREncoded(v9_1), v8)) {
                        }
                        else {
                            arg13[v10] = v9_1;
                            v9 = v10;
                            continue;
                        }
                    }

                    break;
                }

                arg13[v10] = v7;
            }

            ++v1;
        }

        arg13[v0 - 2] = v2;
        arg13[v0 - 1] = v4;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    ASN1Primitive toDERObject() {
        if(this.sortedElements == null) {
            Object v0 = this.elements.clone();
            this.sortedElements = ((ASN1Encodable[])v0);
            ASN1Set.sort(((ASN1Encodable[])v0));
        }

        return new DERSet(true, this.sortedElements);
    }

    ASN1Primitive toDLObject() {
        return new DLSet(this.elements, this.sortedElements);
    }

    public String toString() {
        int v0 = this.size();
        if(v0 == 0) {
            return "[]";
        }

        StringBuilder v1 = new StringBuilder("[");
        int v2 = 0;
        while(true) {
            v1.append(this.elements[v2]);
            ++v2;
            if(v2 >= v0) {
                break;
            }

            v1.append(", ");
        }

        v1.append(']');
        return v1.toString();
    }
}

