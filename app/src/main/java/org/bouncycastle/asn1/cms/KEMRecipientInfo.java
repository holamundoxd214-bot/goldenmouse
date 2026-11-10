package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KEMRecipientInfo extends ASN1Object {
    private final ASN1Integer cmsVersion;
    private final ASN1OctetString encryptedKey;
    private final AlgorithmIdentifier kdf;
    private final ASN1Integer kekLength;
    private final AlgorithmIdentifier kem;
    private final ASN1OctetString kemct;
    private final RecipientIdentifier rid;
    private final ASN1OctetString ukm;
    private final AlgorithmIdentifier wrap;

    private KEMRecipientInfo(ASN1Sequence arg4) {
        super();
        if(arg4.size() >= 8 && arg4.size() <= 9) {
            this.cmsVersion = ASN1Integer.getInstance(arg4.getObjectAt(0));
            this.rid = RecipientIdentifier.getInstance(arg4.getObjectAt(1));
            this.kem = AlgorithmIdentifier.getInstance(arg4.getObjectAt(2));
            this.kemct = ASN1OctetString.getInstance(arg4.getObjectAt(3));
            this.kdf = AlgorithmIdentifier.getInstance(arg4.getObjectAt(4));
            ASN1Integer v1 = ASN1Integer.getInstance(arg4.getObjectAt(5));
            this.kekLength = v1;
            if(v1.intValueExact() <= 0xFFFF) {
                int v1_1 = 6;
                if((arg4.getObjectAt(v1_1) instanceof ASN1TaggedObject)) {
                    this.ukm = ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(arg4.getObjectAt(v1_1)), true);
                    v1_1 = 7;
                }
                else {
                    this.ukm = null;
                }

                this.wrap = AlgorithmIdentifier.getInstance(arg4.getObjectAt(v1_1));
                this.encryptedKey = ASN1OctetString.getInstance(arg4.getObjectAt(v1_1 + 1));
                return;
            }
            else {
                throw new IllegalArgumentException("kekLength must be <= 65535");
            }
        }

        throw new IllegalArgumentException("bad sequence size: " + arg4.size());
    }

    public KEMRecipientInfo(RecipientIdentifier arg4, AlgorithmIdentifier arg5, ASN1OctetString arg6, AlgorithmIdentifier arg7, ASN1Integer arg8, ASN1OctetString arg9, AlgorithmIdentifier arg10, ASN1OctetString arg11) {
        super();
        if(arg5 != null) {
            if(arg10 != null) {
                if(arg8.intValueExact() <= 0xFFFF) {
                    this.cmsVersion = new ASN1Integer(0);
                    this.rid = arg4;
                    this.kem = arg5;
                    this.kemct = arg6;
                    this.kdf = arg7;
                    this.kekLength = arg8;
                    this.ukm = arg9;
                    this.wrap = arg10;
                    this.encryptedKey = arg11;
                    return;
                }

                throw new IllegalArgumentException("kekLength must be <= 65535");
            }

            throw new NullPointerException("wrap cannot be null");
        }

        throw new NullPointerException("kem cannot be null");
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public static KEMRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof KEMRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KEMRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getKdf() {
        return this.kdf;
    }

    public AlgorithmIdentifier getKem() {
        return this.kem;
    }

    public ASN1OctetString getKemct() {
        return this.kemct;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.rid;
    }

    public byte[] getUkm() {
        ASN1OctetString v0 = this.ukm;
        if(v0 == null) {
            return null;
        }

        return v0.getOctets();
    }

    public AlgorithmIdentifier getWrap() {
        return this.wrap;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector();
        v0.add(this.cmsVersion);
        v0.add(this.rid);
        v0.add(this.kem);
        v0.add(this.kemct);
        v0.add(this.kdf);
        v0.add(this.kekLength);
        if(this.ukm != null) {
            v0.add(new DERTaggedObject(true, 0, this.ukm));
        }

        v0.add(this.wrap);
        v0.add(this.encryptedKey);
        return new DERSequence(v0);
    }
}

