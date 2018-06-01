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

    private PrivateKey ConvertPrivateKey(String key) throws Exception {

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
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
            PublicKey publicKey = ConvertPublicKey(xmlPublicKey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] enBytes = cipher.doFinal(encryptString.getBytes("utf-8"));
            Result = (new BASE64Encoder()).encodeBuffer(enBytes);

        } catch (Exception ex) {

        }
        return Result;
    }

    /// <summary>
    /// RSA的加密函数
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="EncryptString">待加密的字节数组</param>
    /// <returns></returns>
    public String RSAEncrypt(String xmlPublicKey, byte[] EncryptString) {
        String Result = "";
        try {
            PublicKey publicKey = ConvertPublicKey(xmlPublicKey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] enBytes = cipher.doFinal(EncryptString);
            Result = (new BASE64Encoder()).encodeBuffer(enBytes);

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

        PrivateKey privateKey = ConvertPrivateKey(xmlPrivateKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] source = (new BASE64Decoder()).decodeBuffer(decryptString);
        byte[] bt_original = cipher.doFinal(source);
        Result = new String(bt_original, "utf-8");

        return Result;
    }

    /// <summary>
    /// RSA的解密函数
    /// </summary>
    /// <param name="xmlPrivateKey">私钥</param>
    /// <param name="DecryptString">待解密的字节数组</param>
    /// <returns></returns>
    public String RSADecrypt(String xmlPrivateKey, byte[] DecryptString) {
        String Result = "";
        try {

            PrivateKey privateKey = ConvertPrivateKey(xmlPrivateKey);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bt_original = cipher.doFinal((new BASE64Decoder()).decodeBuffer(new String(DecryptString, "utf-8")));
            Result = new String(bt_original, "utf-8");

        } catch (Exception ex) {
        }
        return Result;
    }

    /// <summary>
    /// RSA的签名函数
    /// </summary>
    /// <param name="xmlprivateKey">私钥</param>
    /// <param name="signText">待签名的字符串</param>
    /// <returns></returns>
    public String RSASign(String xmlprivateKey, String signText) throws Exception {
        PrivateKey priK = ConvertPrivateKey(xmlprivateKey);
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initSign(priK);
        byte[] bytes = signText.getBytes("utf-8");
        sig.update(bytes);
        return new String((new BASE64Encoder()).encode(sig.sign()));
    }

    /// <summary>
    /// RSA的签名验证函数
    /// </summary>
    /// <param name="xmlPublicKey">公钥</param>
    /// <param name="mySign">我的签名</param>
    /// <param name="sign">签名</param>
    /// <returns></returns>
    public boolean RSAVerify(String xmlPublicKey, String mySign, String sign) throws Exception {
        PublicKey pubK = ConvertPublicKey(xmlPublicKey);
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(pubK);
        byte[] un = mySign.getBytes("utf-8");
        sig.update((new BASE64Encoder()).encode(un).getBytes());
        return sig.verify(sign.getBytes());
    }
}
