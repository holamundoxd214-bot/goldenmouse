package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KemOtherInfo extends ASN1Object {
    private static final PKIFreeText DEFAULT_staticString;
    private final ASN1OctetString ct;
    private final ASN1Integer len;
    private final AlgorithmIdentifier mac;
    private final ASN1OctetString recipNonce;
    private final ASN1OctetString senderNonce;
    private final PKIFreeText staticString;
    private final ASN1OctetString transactionID;

    static {
        KemOtherInfo.DEFAULT_staticString = new PKIFreeText("CMP-KEM");
    }

    public KemOtherInfo(ASN1OctetString arg3, ASN1OctetString arg4, ASN1OctetString arg5, long arg6, AlgorithmIdentifier arg8, ASN1OctetString arg9) {
        this(arg3, arg4, arg5, new ASN1Integer(arg6), arg8, arg9);
    }

    public KemOtherInfo(ASN1OctetString arg2, ASN1OctetString arg3, ASN1OctetString arg4, ASN1Integer arg5, AlgorithmIdentifier arg6, ASN1OctetString arg7) {
        super();
        this.staticString = KemOtherInfo.DEFAULT_staticString;
        this.transactionID = arg2;
        this.senderNonce = arg3;
        this.recipNonce = arg4;
        this.len = arg5;
        this.mac = arg6;
        this.ct = arg7;
    }

    private KemOtherInfo(ASN1Sequence arg9) {
        ASN1Primitive v5_1;
        ASN1OctetString v7_1;
        ASN1OctetString v0_1;
        int v6;
        super();
        int v1 = 4;
        if(arg9.size() >= v1 && arg9.size() <= 7) {
            PKIFreeText v2 = PKIFreeText.getInstance(arg9.getObjectAt(0));
            this.staticString = v2;
            PKIFreeText v3 = KemOtherInfo.DEFAULT_staticString;
            if(v3.equals(v2)) {
                ASN1TaggedObject v3_1 = KemOtherInfo.tryGetTagged(arg9, 1);
                int v4 = 2;
                ASN1OctetString v5 = null;
                if(v3_1 != null) {
                    ASN1Primitive v0 = ASN1Util.tryGetContextBaseUniversal(v3_1, 0, true, v1);
                    if(v0 != null) {
                        v3_1 = KemOtherInfo.tryGetTagged(arg9, v4);
                        v6 = v4;
                    }
                    else {
                        goto label_24;
                    }
                }
                else {
                label_24:
                    v6 = 1;
                    v0_1 = v5;
                }

                if(v3_1 != null) {
                    ASN1Primitive v7 = ASN1Util.tryGetContextBaseUniversal(v3_1, 1, true, v1);
                    if(v7 != null) {
                        ++v6;
                        v3_1 = KemOtherInfo.tryGetTagged(arg9, v6);
                    }
                    else {
                        goto label_32;
                    }
                }
                else {
                label_32:
                    v7_1 = v5;
                }

                if(v3_1 != null) {
                    ASN1Primitive v1_1 = ASN1Util.tryGetContextBaseUniversal(v3_1, v4, true, v1);
                    if(v1_1 != null) {
                        v5_1 = v1_1;
                        ++v6;
                        v3_1 = KemOtherInfo.tryGetTagged(arg9, v6);
                    }
                }

                if(v3_1 == null) {
                    this.transactionID = v0_1;
                    this.senderNonce = v7_1;
                    this.recipNonce = ((ASN1OctetString)v5_1);
                    this.len = ASN1Integer.getInstance(arg9.getObjectAt(v6));
                    this.mac = AlgorithmIdentifier.getInstance(arg9.getObjectAt(v6 + 1));
                    this.ct = ASN1OctetString.getInstance(arg9.getObjectAt(v6 + 2));
                    if(v6 + 3 == arg9.size()) {
                        return;
                    }

                    throw new IllegalArgumentException("unexpected data at end of sequence");
                }

                throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(v3_1));
            }
            else {
                throw new IllegalArgumentException("staticString field should be " + v3);
            }
        }

        throw new IllegalArgumentException("sequence size should be between 4 and 7 inclusive");
    }

    private static void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public ASN1OctetString getCt() {
        return this.ct;
    }

    public static KemOtherInfo getInstance(Object arg1) {
        if((arg1 instanceof KemOtherInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KemOtherInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Integer getLen() {
        return this.len;
    }

    public AlgorithmIdentifier getMac() {
        return this.mac;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(7);
        v0.add(this.staticString);
        KemOtherInfo.addOptional(v0, 0, this.transactionID);
        KemOtherInfo.addOptional(v0, 1, this.senderNonce);
        KemOtherInfo.addOptional(v0, 2, this.recipNonce);
        v0.add(this.len);
        v0.add(this.mac);
        v0.add(this.ct);
        return new DERSequence(v0);
    }

    private static ASN1TaggedObject tryGetTagged(ASN1Sequence arg0, int arg1) {
        ASN1Encodable v0 = arg0.getObjectAt(arg1);
        if((v0 instanceof ASN1TaggedObject)) {
            return ((ASN1TaggedObject)v0);
        }

        return null;
    }
}

