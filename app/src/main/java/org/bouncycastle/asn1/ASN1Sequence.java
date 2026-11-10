package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Sequence extends ASN1Primitive implements Iterable {
    class org.bouncycastle.asn1.ASN1Sequence$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Sequence$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
            return arg1;
        }
    }

    static final ASN1UniversalType TYPE;
    ASN1Encodable[] elements;

    static {
        ASN1Sequence.TYPE = new org.bouncycastle.asn1.ASN1Sequence$1(ASN1Sequence.class, 16);
    }

    protected ASN1Sequence() {
        super();
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    protected ASN1Sequence(ASN1Encodable arg3) {
        super();
        if(arg3 != null) {
            this.elements = new ASN1Encodable[]{arg3};
            return;
        }

        throw new NullPointerException("\'element\' cannot be null");
    }

    protected ASN1Sequence(ASN1Encodable arg3, ASN1Encodable arg4) {
        super();
        if(arg3 != null) {
            if(arg4 != null) {
                this.elements = new ASN1Encodable[]{arg3, arg4};
                return;
            }

            throw new NullPointerException("\'element2\' cannot be null");
        }

        throw new NullPointerException("\'element1\' cannot be null");
    }

    protected ASN1Sequence(ASN1EncodableVector arg1) {
        super();
        if(arg1 != null) {
            this.elements = arg1.takeElements();
            return;
        }

        throw new NullPointerException("\'elementVector\' cannot be null");
    }

    protected ASN1Sequence(ASN1Encodable[] arg2) {
        super();
        if(!Arrays.isNullOrContainsNull(((Object[])arg2))) {
            this.elements = ASN1EncodableVector.cloneElements(arg2);
            return;
        }

        throw new NullPointerException("\'elements\' cannot be null, or contain null");
    }

    ASN1Sequence(ASN1Encodable[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = ASN1EncodableVector.cloneElements(arg1);
        }

        this.elements = arg1;
    }

    boolean asn1Equals(ASN1Primitive arg6) {
        if(!(arg6 instanceof ASN1Sequence)) {
            return 0;
        }

        int v0 = this.size();
        if(((ASN1Sequence)arg6).size() != v0) {
            return 0;
        }

        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ASN1Primitive v3 = this.elements[v2].toASN1Primitive();
            ASN1Primitive v4 = ((ASN1Sequence)arg6).elements[v2].toASN1Primitive();
            if(v3 != v4 && !v3.asn1Equals(v4)) {
                return 0;
            }
        }

        return 1;
    }

    boolean encodeConstructed() {
        return 1;
    }

    ASN1BitString[] getConstructedBitStrings() {
        int v0 = this.size();
        ASN1BitString[] v1 = new ASN1BitString[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = ASN1BitString.getInstance(this.elements[v2]);
        }

        return v1;
    }

    ASN1OctetString[] getConstructedOctetStrings() {
        int v0 = this.size();
        ASN1OctetString[] v1 = new ASN1OctetString[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = ASN1OctetString.getInstance(this.elements[v2]);
        }

        return v1;
    }

    public static ASN1Sequence getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1Sequence)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1Sequence)) {
                        return ((ASN1Sequence)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1Sequence.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct sequence from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("unknown object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Sequence.TYPE.getContextTagged(arg1, arg2);
    }

    public ASN1Encodable getObjectAt(int arg1) {
        return this.elements[arg1];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos;

            public boolean hasMoreElements() {
                if(this.pos < ASN1Sequence.this.elements.length) {
                    return 1;
                }

                return 0;
            }

            public Object nextElement() {
                if(this.pos < ASN1Sequence.this.elements.length) {
                    ASN1Encodable[] v0 = ASN1Sequence.this.elements;
                    int v1 = this.pos;
                    this.pos = v1 + 1;
                    return v0[v1];
                }

                throw new NoSuchElementException();
            }
        };
    }

    public static ASN1Sequence getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Sequence.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        int v0 = this.elements.length;
        int v1;
        for(v1 = v0 + 1; true; v1 = v1 * 0x101 ^ this.elements[v0].toASN1Primitive().hashCode()) {
            --v0;
            if(v0 < 0) {
                return v1;
            }
        }

        return v1;
    }

    public Iterator iterator() {
        return new org.bouncycastle.util.Arrays$Iterator(this.elements);
    }

    public ASN1SequenceParser parser() {
        return new ASN1SequenceParser(this.size()) {
            private int pos;

            public ASN1Primitive getLoadedObject() {
                return ASN1Sequence.this;
            }

            public ASN1Encodable readObject() throws IOException {
                ASN1SetParser v3_1;
                if(this.val$count == this.pos) {
                    return null;
                }

                ASN1Encodable[] v0 = ASN1Sequence.this.elements;
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
                return ASN1Sequence.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    abstract ASN1BitString toASN1BitString();

    abstract ASN1External toASN1External();

    abstract ASN1OctetString toASN1OctetString();

    abstract ASN1Set toASN1Set();

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
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

