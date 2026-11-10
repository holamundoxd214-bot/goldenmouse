package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class CVCertificateRequest extends ASN1Object {
    private static final int bodyValid = 1;
    private CertificateBody certificateBody;
    private byte[] innerSignature;
    private final ASN1TaggedObject original;
    private byte[] outerSignature;
    private static final int signValid = 2;

    private CVCertificateRequest(ASN1TaggedObject arg4) throws IOException {
        super();
        this.innerSignature = null;
        this.outerSignature = null;
        this.original = arg4;
        int v1 = 0x40;
        if(arg4.hasTag(v1, 7)) {
            ASN1Sequence v4 = ASN1Sequence.getInstance(arg4.getBaseUniversal(false, 16));
            this.initCertBody(ASN1TaggedObject.getInstance(v4.getObjectAt(0), v1));
            this.outerSignature = ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(v4.getObjectAt(v4.size() - 1)).getBaseUniversal(false, 4)).getOctets();
            return;
        }

        this.initCertBody(arg4);
    }

    public CertificateBody getCertificateBody() {
        return this.certificateBody;
    }

    public byte[] getInnerSignature() {
        return Arrays.clone(this.innerSignature);
    }

    public static CVCertificateRequest getInstance(Object arg3) {
        if((arg3 instanceof CVCertificateRequest)) {
            return arg3;
        }

        if(arg3 != null) {
            try {
                return new CVCertificateRequest(ASN1TaggedObject.getInstance(arg3, 0x40));
            }
            catch(IOException v3) {
                throw new ASN1ParsingException("unable to parse data: " + v3.getMessage(), ((Throwable)v3));
            }
        }

        return null;
    }

    public byte[] getOuterSignature() {
        return Arrays.clone(this.outerSignature);
    }

    public PublicKeyDataObject getPublicKey() {
        return this.certificateBody.getPublicKey();
    }

    public boolean hasOuterSignature() {
        if(this.outerSignature != null) {
            return 1;
        }

        return 0;
    }

    private void initCertBody(ASN1TaggedObject arg8) throws IOException {
        int v1 = 0x40;
        if(arg8.hasTag(v1, 33)) {
            Enumeration v0 = ASN1Sequence.getInstance(arg8.getBaseUniversal(false, 16)).getObjects();
            int v3;
            for(v3 = 0; v0.hasMoreElements(); v3 |= 2) {
                ASN1TaggedObject v4 = ASN1TaggedObject.getInstance(v0.nextElement(), v1);
                int v5 = v4.getTagNo();
                if(v5 != 55) {
                    if(v5 == 78) {
                        this.certificateBody = CertificateBody.getInstance(v4);
                        v3 |= 1;
                        continue;
                    }

                    throw new IOException("Invalid tag, not an CV Certificate Request element:" + v4.getTagNo());
                }

                this.innerSignature = ASN1OctetString.getInstance(v4.getBaseUniversal(false, 4)).getOctets();
            }

            if((v3 & 3) != 0) {
                return;
            }

            throw new IOException("Invalid CARDHOLDER_CERTIFICATE in request:" + arg8.getTagNo());
        }

        throw new IOException("not a CARDHOLDER_CERTIFICATE in request:" + arg8.getTagNo());
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1TaggedObject v0 = this.original;
        if(v0 != null) {
            return ((ASN1Primitive)v0);
        }

        return EACTagged.create(33, new DERSequence(this.certificateBody, EACTagged.create(55, this.innerSignature)));
    }
}

