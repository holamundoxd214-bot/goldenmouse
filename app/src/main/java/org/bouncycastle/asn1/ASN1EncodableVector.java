package org.bouncycastle.asn1;

public class ASN1EncodableVector {
    private static final int DEFAULT_CAPACITY = 10;
    static final ASN1Encodable[] EMPTY_ELEMENTS;
    private boolean copyOnWrite;
    private int elementCount;
    private ASN1Encodable[] elements;

    static {
        ASN1EncodableVector.EMPTY_ELEMENTS = new ASN1Encodable[0];
    }

    public ASN1EncodableVector() {
        this(10);
    }

    public ASN1EncodableVector(int arg1) {
        super();
        if(arg1 >= 0) {
            ASN1Encodable[] v1 = arg1 == 0 ? ASN1EncodableVector.EMPTY_ELEMENTS : new ASN1Encodable[arg1];
            this.elements = v1;
            this.elementCount = 0;
            this.copyOnWrite = false;
            return;
        }

        throw new IllegalArgumentException("\'initialCapacity\' must not be negative");
    }

    public void add(ASN1Encodable arg4) {
        if(arg4 != null) {
            int v0 = this.elements.length;
            int v2 = 1;
            int v1 = this.elementCount + 1;
            if(v1 > v0) {
            }
            else {
                v2 = 0;
            }

            if((this.copyOnWrite | v2) != 0) {
                this.reallocate(v1);
            }

            this.elements[this.elementCount] = arg4;
            this.elementCount = v1;
            return;
        }

        throw new NullPointerException("\'element\' cannot be null");
    }

    public void addAll(ASN1EncodableVector arg2) {
        if(arg2 != null) {
            this.doAddAll(arg2.elements, "\'other\' elements cannot be null");
            return;
        }

        throw new NullPointerException("\'other\' cannot be null");
    }

    public void addAll(ASN1Encodable[] arg2) {
        if(arg2 != null) {
            this.doAddAll(arg2, "\'others\' elements cannot be null");
            return;
        }

        throw new NullPointerException("\'others\' cannot be null");
    }

    public void addOptional(ASN1Encodable arg1) {
        if(arg1 != null) {
            this.add(arg1);
        }
    }

    static ASN1Encodable[] cloneElements(ASN1Encodable[] arg2) {
        if(arg2.length < 1) {
            return ASN1EncodableVector.EMPTY_ELEMENTS;
        }

        return arg2.clone();
    }

    ASN1Encodable[] copyElements() {
        int v0 = this.elementCount;
        if(v0 == 0) {
            return ASN1EncodableVector.EMPTY_ELEMENTS;
        }

        ASN1Encodable[] v1 = new ASN1Encodable[v0];
        System.arraycopy(this.elements, 0, v1, 0, v0);
        return v1;
    }

    private void doAddAll(ASN1Encodable[] arg7, String arg8) {
        int v0 = arg7.length;
        int v1 = 1;
        if(v0 < 1) {
            return;
        }

        int v2 = this.elements.length;
        int v3 = this.elementCount + v0;
        int v4 = 0;
        if(v3 > v2) {
        }
        else {
            v1 = 0;
        }

        if((v1 | this.copyOnWrite) != 0) {
            this.reallocate(v3);
        }

        do {
            ASN1Encodable v1_1 = arg7[v4];
            if(v1_1 == null) {
                goto label_26;
            }

            this.elements[this.elementCount + v4] = v1_1;
            ++v4;
        }
        while(v4 < v0);

        this.elementCount = v3;
        return;
    label_26:
        throw new NullPointerException(arg8);
    }

    public ASN1Encodable get(int arg3) {
        if(arg3 < this.elementCount) {
            return this.elements[arg3];
        }

        throw new ArrayIndexOutOfBoundsException(arg3 + " >= " + this.elementCount);
    }

    private void reallocate(int arg4) {
        ASN1Encodable[] v4 = new ASN1Encodable[Math.max(this.elements.length, arg4 + (arg4 >> 1))];
        System.arraycopy(this.elements, 0, v4, 0, this.elementCount);
        this.elements = v4;
        this.copyOnWrite = false;
    }

    public int size() {
        return this.elementCount;
    }

    ASN1Encodable[] takeElements() {
        int v0 = this.elementCount;
        if(v0 == 0) {
            return ASN1EncodableVector.EMPTY_ELEMENTS;
        }

        ASN1Encodable[] v1 = this.elements;
        if(v1.length == v0) {
            this.copyOnWrite = true;
            return v1;
        }

        ASN1Encodable[] v3 = new ASN1Encodable[v0];
        System.arraycopy(v1, 0, v3, 0, v0);
        return v3;
    }
}

