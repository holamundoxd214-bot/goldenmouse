package org.bouncycastle.asn1;

abstract class ASN1Type {
    final Class javaClass;

    ASN1Type(Class arg1) {
        super();
        this.javaClass = arg1;
    }

    public final boolean equals(Object arg1) {
        if(this == (((ASN1Type)arg1))) {
            return 1;
        }

        return 0;
    }

    final Class getJavaClass() {
        return this.javaClass;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}

