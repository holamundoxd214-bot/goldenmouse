package org.bouncycastle.asn1.smime;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapabilities extends ASN1Object {
    public static final ASN1ObjectIdentifier aes128_CBC;
    public static final ASN1ObjectIdentifier aes192_CBC;
    public static final ASN1ObjectIdentifier aes256_CBC;
    public static final ASN1ObjectIdentifier canNotDecryptAny;
    private ASN1Sequence capabilities;
    public static final ASN1ObjectIdentifier cast5_CBC;
    public static final ASN1ObjectIdentifier dES_CBC;
    public static final ASN1ObjectIdentifier dES_EDE3_CBC;
    public static final ASN1ObjectIdentifier idea_CBC;
    public static final ASN1ObjectIdentifier preferSignedData;
    public static final ASN1ObjectIdentifier rC2_CBC;
    public static final ASN1ObjectIdentifier sMIMECapabilitesVersions;

    static {
        SMIMECapabilities.preferSignedData = PKCSObjectIdentifiers.preferSignedData;
        SMIMECapabilities.canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
        SMIMECapabilities.sMIMECapabilitesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
        SMIMECapabilities.aes256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
        SMIMECapabilities.aes192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
        SMIMECapabilities.aes128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
        SMIMECapabilities.idea_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
        SMIMECapabilities.cast5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10");
        SMIMECapabilities.dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
        SMIMECapabilities.dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
        SMIMECapabilities.rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
    }

    public SMIMECapabilities(ASN1Sequence arg1) {
        super();
        this.capabilities = arg1;
    }

    public Vector getCapabilities(ASN1ObjectIdentifier arg4) {
        Enumeration v3 = this.capabilities.getObjects();
        Vector v0 = new Vector();
        if(arg4 == null) {
            while(v3.hasMoreElements()) {
                v0.addElement(SMIMECapability.getInstance(v3.nextElement()));
            }
        }
        else {
            while(v3.hasMoreElements()) {
                SMIMECapability v1 = SMIMECapability.getInstance(v3.nextElement());
                if(!arg4.equals(v1.getCapabilityID())) {
                    continue;
                }

                v0.addElement(v1);
            }
        }

        return v0;
    }

    public static SMIMECapabilities getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof SMIMECapabilities)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new SMIMECapabilities(((ASN1Sequence)arg3));
            }
            else if((arg3 instanceof Attribute)) {
                return new SMIMECapabilities(((Attribute)arg3).getAttrValues().getObjectAt(0));
            }
            else {
                throw new IllegalArgumentException("unknown object in factory: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.capabilities;
    }
}

