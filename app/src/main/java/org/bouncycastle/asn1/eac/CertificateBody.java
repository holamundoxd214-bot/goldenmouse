package org.bouncycastle.asn1.eac;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CertificateBody extends ASN1Object {
    private static final int CAR = 2;
    private static final int CEfD = 0x20;
    private static final int CExD = 0x40;
    private static final int CHA = 16;
    private static final int CHR = 8;
    private static final int CPI = 1;
    private static final int PK = 4;
    private ASN1TaggedObject certificateEffectiveDate;
    private ASN1TaggedObject certificateExpirationDate;
    private CertificateHolderAuthorization certificateHolderAuthorization;
    private ASN1TaggedObject certificateHolderReference;
    private ASN1TaggedObject certificateProfileIdentifier;
    private int certificateType;
    private ASN1TaggedObject certificationAuthorityReference;
    public static final int profileType = 0x7F;
    private static final int profileType_m = 0x7F;
    private static final int profileType_r = 0;
    private PublicKeyDataObject publicKey;
    public static final int requestType = 13;
    private static final int requestType_m = 13;
    private static final int requestType_r = 2;
    ASN1InputStream seq;

    private CertificateBody(ASN1TaggedObject arg2) throws IOException {
        super();
        this.certificateType = 0;
        this.setIso7816CertificateBody(arg2);
    }

    public CertificateBody(ASN1TaggedObject arg2, CertificationAuthorityReference arg3, PublicKeyDataObject arg4, CertificateHolderReference arg5, CertificateHolderAuthorization arg6, PackedDate arg7, PackedDate arg8) {
        super();
        this.certificateType = 0;
        this.setCertificateProfileIdentifier(arg2);
        this.setCertificationAuthorityReference(EACTagged.create(2, arg3.getEncoded()));
        this.setPublicKey(arg4);
        this.setCertificateHolderReference(EACTagged.create(0x20, arg5.getEncoded()));
        this.setCertificateHolderAuthorization(arg6);
        this.setCertificateEffectiveDate(EACTagged.create(37, arg7.getEncoding()));
        this.setCertificateExpirationDate(EACTagged.create(36, arg8.getEncoding()));
    }

    public PackedDate getCertificateEffectiveDate() {
        if((this.certificateType & 0x20) == 0x20) {
            return new PackedDate(ASN1OctetString.getInstance(this.certificateEffectiveDate.getBaseUniversal(false, 4)).getOctets());
        }

        return null;
    }

    public PackedDate getCertificateExpirationDate() throws IOException {
        if((this.certificateType & 0x40) == 0x40) {
            return new PackedDate(ASN1OctetString.getInstance(this.certificateExpirationDate.getBaseUniversal(false, 4)).getOctets());
        }

        throw new IOException("certificate Expiration Date not set");
    }

    public CertificateHolderAuthorization getCertificateHolderAuthorization() throws IOException {
        if((this.certificateType & 16) == 16) {
            return this.certificateHolderAuthorization;
        }

        throw new IOException("Certificate Holder Authorisation not set");
    }

    public CertificateHolderReference getCertificateHolderReference() {
        return new CertificateHolderReference(ASN1OctetString.getInstance(this.certificateHolderReference.getBaseUniversal(false, 4)).getOctets());
    }

    public ASN1TaggedObject getCertificateProfileIdentifier() {
        return this.certificateProfileIdentifier;
    }

    public int getCertificateType() {
        return this.certificateType;
    }

    public CertificationAuthorityReference getCertificationAuthorityReference() throws IOException {
        if((this.certificateType & 2) == 2) {
            return new CertificationAuthorityReference(ASN1OctetString.getInstance(this.certificationAuthorityReference.getBaseUniversal(false, 4)).getOctets());
        }

        throw new IOException("Certification authority reference not set");
    }

    public static CertificateBody getInstance(Object arg2) throws IOException {
        if((arg2 instanceof CertificateBody)) {
            return arg2;
        }

        if(arg2 != null) {
            return new CertificateBody(ASN1TaggedObject.getInstance(arg2, 0x40));
        }

        return null;
    }

    public PublicKeyDataObject getPublicKey() {
        return this.publicKey;
    }

    private ASN1Primitive profileToASN1Object() throws IOException {
        ASN1EncodableVector v0 = new ASN1EncodableVector(7);
        v0.add(this.certificateProfileIdentifier);
        v0.add(this.certificationAuthorityReference);
        v0.add(EACTagged.create(73, this.publicKey));
        v0.add(this.certificateHolderReference);
        v0.add(this.certificateHolderAuthorization);
        v0.add(this.certificateEffectiveDate);
        v0.add(this.certificateExpirationDate);
        return EACTagged.create(78, new DERSequence(v0));
    }

    private ASN1Primitive requestToASN1Object() throws IOException {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.certificateProfileIdentifier);
        ASN1TaggedObject v1 = this.certificationAuthorityReference;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        v0.add(EACTagged.create(73, this.publicKey));
        v0.add(this.certificateHolderReference);
        return EACTagged.create(78, new DERSequence(v0));
    }

    private void setCertificateEffectiveDate(ASN1TaggedObject arg3) throws IllegalArgumentException {
        if(arg3.hasTag(0x40, 37)) {
            this.certificateEffectiveDate = arg3;
            this.certificateType |= 0x20;
            return;
        }

        throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :" + arg3.getTagNo());
    }

    private void setCertificateExpirationDate(ASN1TaggedObject arg3) throws IllegalArgumentException {
        int v1 = 0x40;
        if(arg3.hasTag(v1, 36)) {
            this.certificateExpirationDate = arg3;
            this.certificateType |= v1;
            return;
        }

        throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
    }

    private void setCertificateHolderAuthorization(CertificateHolderAuthorization arg1) {
        this.certificateHolderAuthorization = arg1;
        this.certificateType |= 16;
    }

    private void setCertificateHolderReference(ASN1TaggedObject arg3) throws IllegalArgumentException {
        if(arg3.hasTag(0x40, 0x20)) {
            this.certificateHolderReference = arg3;
            this.certificateType |= 8;
            return;
        }

        throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
    }

    private void setCertificateProfileIdentifier(ASN1TaggedObject arg3) throws IllegalArgumentException {
        if(arg3.hasTag(0x40, 41)) {
            this.certificateProfileIdentifier = arg3;
            this.certificateType |= 1;
            return;
        }

        throw new IllegalArgumentException("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :" + arg3.getTagNo());
    }

    private void setCertificationAuthorityReference(ASN1TaggedObject arg3) throws IllegalArgumentException {
        int v1 = 2;
        if(arg3.hasTag(0x40, v1)) {
            this.certificationAuthorityReference = arg3;
            this.certificateType |= v1;
            return;
        }

        throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
    }

    private void setIso7816CertificateBody(ASN1TaggedObject arg9) throws IOException {
        int v1 = 0x40;
        if(arg9.hasTag(v1, 78)) {
            int v2 = 16;
            ASN1Sequence v9 = ASN1Sequence.getInstance(arg9.getBaseUniversal(false, v2));
            int v3 = v9.size();
            int v4;
            for(v4 = 0; v4 < v3; ++v4) {
                ASN1TaggedObject v5 = ASN1TaggedObject.getInstance(v9.getObjectAt(v4), v1);
                int v6 = v5.getTagNo();
                if(v6 == 2) {
                    this.setCertificationAuthorityReference(v5);
                }
                else if(v6 == 0x20) {
                    this.setCertificateHolderReference(v5);
                }
                else if(v6 == 41) {
                    this.setCertificateProfileIdentifier(v5);
                }
                else if(v6 == 73) {
                    this.setPublicKey(PublicKeyDataObject.getInstance(v5.getBaseUniversal(false, v2)));
                }
                else if(v6 == 76) {
                    this.setCertificateHolderAuthorization(new CertificateHolderAuthorization(v5));
                }
                else if(v6 == 36) {
                    this.setCertificateExpirationDate(v5);
                }
                else if(v6 == 37) {
                    this.setCertificateEffectiveDate(v5);
                }
                else {
                    this.certificateType = 0;
                    throw new IOException("Not a valid iso7816 ASN1TaggedObject tag " + v5.getTagNo());
                }
            }

            return;
        }

        throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
    }

    private void setPublicKey(PublicKeyDataObject arg1) {
        this.publicKey = PublicKeyDataObject.getInstance(arg1);
        this.certificateType |= 4;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            int v0 = this.certificateType;
            if(v0 == 0x7F) {
                return this.profileToASN1Object();
            }

            if((v0 & -3) != 13) {
                return null;
            }

            return this.requestToASN1Object();
        }
        catch(IOException ) {
            return null;
        }
    }
}

