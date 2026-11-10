package org.bouncycastle.asn1.nist;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class KMACwithSHAKE128_params extends ASN1Object {
    private static final int DEF_LENGTH = 0x100;
    private static final byte[] EMPTY_STRING;
    private final byte[] customizationString;
    private final int outputLength;

    static {
        KMACwithSHAKE128_params.EMPTY_STRING = new byte[0];
    }

    public KMACwithSHAKE128_params(int arg1) {
        super();
        this.outputLength = arg1;
        this.customizationString = KMACwithSHAKE128_params.EMPTY_STRING;
    }

    public KMACwithSHAKE128_params(int arg1, byte[] arg2) {
        super();
        this.outputLength = arg1;
        this.customizationString = Arrays.clone(arg2);
    }

    private KMACwithSHAKE128_params(ASN1Sequence arg5) {
        super();
        int v1 = 2;
        if(arg5.size() <= v1) {
            if(arg5.size() == v1) {
                this.outputLength = ASN1Integer.getInstance(arg5.getObjectAt(0)).intValueExact();
                this.customizationString = Arrays.clone(ASN1OctetString.getInstance(arg5.getObjectAt(1)).getOctets());
                return;
            }

            v1 = 0x100;
            if(arg5.size() == 1) {
                if((arg5.getObjectAt(0) instanceof ASN1Integer)) {
                    this.outputLength = ASN1Integer.getInstance(arg5.getObjectAt(0)).intValueExact();
                    this.customizationString = KMACwithSHAKE128_params.EMPTY_STRING;
                    return;
                }

                this.outputLength = v1;
                this.customizationString = Arrays.clone(ASN1OctetString.getInstance(arg5.getObjectAt(0)).getOctets());
                return;
            }

            this.outputLength = v1;
            this.customizationString = KMACwithSHAKE128_params.EMPTY_STRING;
            return;
        }

        throw new IllegalArgumentException("sequence size greater than 2");
    }

    public byte[] getCustomizationString() {
        return Arrays.clone(this.customizationString);
    }

    public static KMACwithSHAKE128_params getInstance(Object arg1) {
        if((arg1 instanceof KMACwithSHAKE128_params)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KMACwithSHAKE128_params(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public int getOutputLength() {
        return this.outputLength;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector();
        if(this.outputLength != 0x100) {
            v0.add(new ASN1Integer(((long)this.outputLength)));
        }

        if(this.customizationString.length != 0) {
            v0.add(new DEROctetString(this.getCustomizationString()));
        }

        return new DERSequence(v0);
    }
}

