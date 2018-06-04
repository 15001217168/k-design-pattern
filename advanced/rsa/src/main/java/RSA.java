import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSA {
    /// <summary>
    /// RSA产生密钥
    /// </summary>
    /// <param name="xmlKeys">私钥</param>
    /// <param name="xmlPublicKey">公钥</param>
    public Map<String, String> RSAKey(String xmlKeys, String xmlPublicKey) {
        Map<String, String> key = new HashMap<String, String>();
        try {

            //生成公私钥对
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            key.put(publicKey.toString(), privateKey.toString());

        } catch (Exception ex) {
        }
        return key;
    }

    private PublicKey ConvertPublicKey(String key) throws Exception {

        Document document = DocumentHelper.parseText(key);
        String mudulus = (String) document.getRootElement().element("Modulus").getData();
        String exponent = (String) document.getRootElement().element("Exponent").getData();

        try {
            byte[] m = (new BASE64Decoder()).decodeBuffer(mudulus);
            byte[] e = (new BASE64Decoder()).decodeBuffer(exponent);
            ;
            BigInteger b1 = new BigInteger(1, m);
            BigInteger b2 = new BigInteger(1, e);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private PublicKey ConvertPublicKeyJava(String key) throws Exception {

        X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(key));
        // RSA对称加密算法
        java.security.KeyFactory keyFactory;
        keyFactory = java.security.KeyFactory.getInstance("RSA");
        // 取公钥匙对象
        return keyFactory.generatePublic(bobPubKeySpec);
    }

    private PrivateKey ConvertPrivateKey(String key) throws Exception {

        Document document = DocumentHelper.parseText(key);
        String mudulus = (String) document.getRootElement().element("Modulus").getData();
        String exponent = (String) document.getRootElement().element("Exponent").getData();
        try {
            byte[] m = (new BASE64Decoder()).decodeBuffer(mudulus);
            byte[] e = (new BASE64Decoder()).decodeBuffer(exponent);

            BigInteger b1 = new BigInteger(1, m);
            BigInteger b2 = new BigInteger(1, e);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private PrivateKey ConvertPrivateKeyJava(String key) throws Exception {

        PKCS8EncodedKeySpec priPKCS8;
        priPKCS8 = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(key));
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        return keyf.generatePrivate(priPKCS8);
    }

    /// <summary>
    /// RSA的加密函数
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="encryptString">待加密的字符串</param>
    /// <returns></returns>
    public String RSAEncrypt(String xmlPublicKey, String encryptString) {
        String Result = "";
        try {
            PublicKey publicKey = ConvertPublicKeyJava(xmlPublicKey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] enBytes = cipher.doFinal(encryptString.getBytes("utf-8"));
            Result = Bytes2Hex(enBytes);

        } catch (Exception ex) {

        }
        return Result;
    }

    /// <summary>
    /// RSA的解密函数
    /// </summary>
    /// <param name="xmlPrivateKey">私钥</param>
    /// <param name="decryptString">待解密的字符串</param>
    /// <returns></returns>
    public String RSADecrypt(String xmlPrivateKey, String decryptString) throws Exception {
        String Result = "";

        PrivateKey privateKey = ConvertPrivateKeyJava(xmlPrivateKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] source = Hex2Bytes(decryptString);
        byte[] bt_original = cipher.doFinal(source);
        Result = new String(bt_original, "utf-8");

        return Result;
    }

    /// <summary>
    /// RSA的签名函数
    /// </summary>
    /// <param name="xmlprivateKey">私钥</param>
    /// <param name="signText">待签名的字符串</param>
    /// <returns></returns>
    public String RSASign(String xmlprivateKey, String signText) throws Exception {
        PrivateKey priK = ConvertPrivateKeyJava(xmlprivateKey);
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(priK);
        byte[] bytes = signText.getBytes("utf-8");
        sig.update(bytes);
        return Bytes2Hex(sig.sign());
    }

    /// <summary>
    /// RSA的签名验证函数
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="mySign">我的签名</param>
    /// <param name="sign">签名</param>
    /// <returns></returns>
    public boolean RSAVerify(String xmlPublicKey, String mySign, String sign) throws Exception {
        PublicKey pubK = ConvertPublicKeyJava(xmlPublicKey);
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(pubK);
        byte[] un = mySign.getBytes("utf-8");
        sig.update(un);
        return sig.verify(Hex2Bytes(sign));
    }

    /// <summary>
    /// 转换byte
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="mySign">我的签名</param>
    /// <param name="sign">签名</param>
    /// <returns></returns>

    public byte[] Hex2Bytes(String hexStr) {
        byte[] b = hexStr.getBytes();
        if (b.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        } else {
            byte[] b2 = new byte[b.length / 2];

            for (int n = 0; n < b.length; n += 2) {
                String item = new String(b, n, 2);
                b2[n / 2] = (byte) Integer.parseInt(item, 16);
            }

            return b2;
        }
    }
    /// <summary>
    /// 字符串
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="mySign">我的签名</param>
    /// <param name="sign">签名</param>
    /// <returns></returns>

    public String Bytes2Hex(byte[] bytes) {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < bytes.length; ++n) {
            stmp = Integer.toHexString(bytes[n] & 255);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
