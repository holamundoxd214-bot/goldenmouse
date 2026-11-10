package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class CVCertificate extends ASN1Object {
    private static int bodyValid = 1;
    private CertificateBody certificateBody;
    private static int signValid = 2;
    private byte[] signature;
    private int valid;

    static {
    }

    public CVCertificate(ASN1InputStream arg1) throws IOException {
        super();
        this.initFrom(arg1);
    }

    private CVCertificate(ASN1TaggedObject arg1) throws IOException {
        super();
        this.setPrivateData(arg1);
    }

    public CVCertificate(CertificateBody arg1, byte[] arg2) throws IOException {
        super();
        this.certificateBody = arg1;
        this.signature = Arrays.clone(arg2);
        this.valid = this.valid | CVCertificate.bodyValid | CVCertificate.signValid;
    }

    public CertificationAuthorityReference getAuthorityReference() throws IOException {
        return this.certificateBody.getCertificationAuthorityReference();
    }

    public CertificateBody getBody() {
        return this.certificateBody;
    }

    public int getCertificateType() {
        return this.certificateBody.getCertificateType();
    }

    public PackedDate getEffectiveDate() throws IOException {
        return this.certificateBody.getCertificateEffectiveDate();
    }

    public PackedDate getExpirationDate() throws IOException {
        return this.certificateBody.getCertificateExpirationDate();
    }

    public ASN1ObjectIdentifier getHolderAuthorization() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getOid();
    }

    public Flags getHolderAuthorizationRights() throws IOException {
        return new Flags(this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 0x1F);
    }

    public int getHolderAuthorizationRole() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 0xC0;
    }

    public CertificateHolderReference getHolderReference() throws IOException {
        return this.certificateBody.getCertificateHolderReference();
    }

    public static CVCertificate getInstance(Object arg3) {
        if((arg3 instanceof CVCertificate)) {
            return arg3;
        }

        if(arg3 != null) {
            try {
                return new CVCertificate(ASN1TaggedObject.getInstance(arg3, 0x40));
            }
            catch(IOException v3) {
                throw new ASN1ParsingException("unable to parse data: " + v3.getMessage(), ((Throwable)v3));
            }
        }

        return null;
    }

    public int getRole() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights();
    }

    public byte[] getSignature() {
        return Arrays.clone(this.signature);
    }

    private void initFrom(ASN1InputStream arg3) throws IOException {
        while(true) {
            ASN1Primitive v0 = arg3.readObject();
            if(v0 == null) {
                return;
            }

            if(!(v0 instanceof ASN1TaggedObject)) {
                break;
            }

            this.setPrivateData(((ASN1TaggedObject)v0));
        }

        throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
    }

    private void setPrivateData(ASN1TaggedObject arg7) throws IOException {
        int v3_2;
        this.valid = 0;
        int v2 = 0x40;
        if(!arg7.hasTag(v2, 33)) {
            goto label_64;
        }

        Enumeration v1 = ASN1Sequence.getInstance(arg7.getBaseUniversal(false, 16)).getObjects();
        while(true) {
            if(!v1.hasMoreElements()) {
                goto label_49;
            }

            Object v3 = v1.nextElement();
            if(!(v3 instanceof ASN1TaggedObject)) {
                break;
            }

            ASN1TaggedObject v3_1 = ASN1TaggedObject.getInstance(v3, v2);
            int v4 = v3_1.getTagNo();
            if(v4 == 55) {
                this.signature = ASN1OctetString.getInstance(v3_1.getBaseUniversal(false, 4)).getOctets();
                v3_2 = this.valid;
                v4 = CVCertificate.signValid;
            }
            else if(v4 == 78) {
                this.certificateBody = CertificateBody.getInstance(v3_1);
                v3_2 = this.valid;
                v4 = CVCertificate.bodyValid;
            }
            else {
                throw new IOException("Invalid tag, not an Iso7816CertificateStructure :" + v3_1.getTagNo());
            }

            this.valid = v3_2 | v4;
        }

        throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
    label_49:
        if(this.valid == (CVCertificate.signValid | CVCertificate.bodyValid)) {
            return;
        }

        throw new IOException("invalid CARDHOLDER_CERTIFICATE :" + arg7.getTagNo());
    label_64:
        throw new IOException("not a CARDHOLDER_CERTIFICATE :" + arg7.getTagNo());
    }

    public ASN1Primitive toASN1Primitive() {
        return EACTagged.create(33, new DERSequence(this.certificateBody, EACTagged.create(55, this.signature)));
    }
}

