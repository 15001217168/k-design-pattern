import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Test {


    public static String SignPublicKey = "<RSAKeyValue><Modulus>vKxo5yBrwEWLvMi2XDDD8KkwR44A9+o47Fuopczj+/5VNBJ5mcwch4obPcxx7RNmhKHQ7VWeooCF72yX5Jmd/HV14kpf6ahBLPOkyXm1mhui4m5OAceIypz1kQtKcZE9rYhY+cKbS4Qpao3tD4o88yMZCaHCzpgIA9bHHr+Saas=</Modulus><Exponent>AQAB</Exponent></RSAKeyValue>";
    public static String SignPrivateKey = "<RSAKeyValue><Modulus>vKxo5yBrwEWLvMi2XDDD8KkwR44A9+o47Fuopczj+/5VNBJ5mcwch4obPcxx7RNmhKHQ7VWeooCF72yX5Jmd/HV14kpf6ahBLPOkyXm1mhui4m5OAceIypz1kQtKcZE9rYhY+cKbS4Qpao3tD4o88yMZCaHCzpgIA9bHHr+Saas=</Modulus><Exponent>AQAB</Exponent><P>1sP5ZMpE6BRuckLSllA5/6jDHYnANffsEophkKVIfrHN+NPXDYLAJU0++lJ4MTqX9p7Geki3wUCqDKurJu1LdQ==</P><Q>4OX5lBS+tx3aVPVat2Jua/auSl566AlQZrAgXDbzdDvHTBpr1oavFU37wBysrAGgAX6TzAnlLceZlpCU3Pjcnw==</Q><DP>tkEZI6+DSnAMSmrqyyTKE2vkKOz9cM80R4enxFh/bQT3BnK/zXdoGD+1cjkKRryyuVeEl8GeLyHxLU+Br0cxAQ==</DP><DQ>E4sIgBy5YfI/KcjUZEEydUFPbfj91zIQAYxmk3zW9Q/Ixs0498BmcISBTvVu79eITvjv4PgvKSZCK3pO5VDe4w==</DQ><InverseQ>fQujIjtGZAYhhzdb3yBi7Wau+8nLyGagjbGezJhrn/B5kiYdZOPaNM7+sEJz6piSmjsDtZXq1NxocHnZGKFJDA==</InverseQ><D>FLsY97RfQowhs4eWSgDttqbQcDxRLOxmfsn/eOBPeKPUdtlE1TpRNC9fmOW66uLD0/T3wOw0dwSKMumKswqSCjgKjWw2LpB2O2oKMQrA9A90AVpDmpWMGHkil6GvWGLhyBi4RAmmmz7VybmCT2Pc/bPWXck9RaedGmBPdPPIFJk=</D></RSAKeyValue>";


    public static String PublicKey = "<RSAKeyValue><Modulus>utQiEubBvPw9FEhbnKQXUCC5Au8cIGYohxMnsgUXo3woWdzy/mjANKd2e+S2oXCY9AatNoyT467X9kNxzl0jbuiO+vqAlWY4voHm9j+aeK2l4FTIp5I7nN4Mz3ECf9LyJfDpEIhzw4FhDEzPG6w63d2C3tZ9/NNrNHooYNDXk1k=</Modulus><Exponent>AQAB</Exponent></RSAKeyValue>";
    public static String PrivateKey = "<RSAKeyValue><Modulus>utQiEubBvPw9FEhbnKQXUCC5Au8cIGYohxMnsgUXo3woWdzy/mjANKd2e+S2oXCY9AatNoyT467X9kNxzl0jbuiO+vqAlWY4voHm9j+aeK2l4FTIp5I7nN4Mz3ECf9LyJfDpEIhzw4FhDEzPG6w63d2C3tZ9/NNrNHooYNDXk1k=</Modulus><Exponent>AQAB</Exponent><P>vV/uxZg9VMREeQjoALI6fOlWaTtf+nDdo9s0ypgEvZUtbzzS4ux9AbjMIrrviyuYxt98kAYRPkIgcMC6rOTFmQ==</P><Q>/I7i3LKFRDTi5qjzRoIYzetz7qwaV+qV0luZnG7TBlzX0T2AD5kkWA5KjA7+kjoZnc8gnhjiRYJcVoc2Q35TwQ==</Q><DP>HsSvbrtFe7hHx8KCr1pF1nWy7HYRKgecezrqYOBCJOtP7nrbaLMzvEviHuJweRQkRmuZOW1C7/KegrNNoTmqQQ==</DP><DQ>8Tl4rdtFNnRdFHrigcHY9zWgsaJoNvi0yQr8mVGw9S7QY+Yd3sgi0ogz47qepAQiW3xuZxLVbBarI2paBfUvAQ==</DQ><InverseQ>latwhpxFkCoYaxlGPC6H9XVrJKCUQJ8o7go+E1+l7lQUZUn6kuPhYFdUIWj0cXqLcQuUMBzwICvEFI14ofb8xg==</InverseQ><D>D5U0f1uYYrUuOgQcAglsuV31WIGNmMU0kamfGLnUgioPqokjimU9zNZ/6y8FLZt44nexGFjq1+WENVHkSuhZVVi7ep9VI+9DI82yXLzFtk4S7vDP7kiC36k9wAnvX9Haep+EqRL5kQc5D/O9blKYxJ64I37R6HKoju9gSWyRAoE=</D></RSAKeyValue>";
    public static void main(String[] args) {



        String OrgCode ="kDO/bU8ieiljCt8AzL3UuhizkRcCAVPAsz9vRed+ap7325QHgzG1tsgmCZLGcOXcQ/A1IwlNANLi9bmDFU7naDbdWI2adtQkmh6wDuTrF1H8jkLXui7WN4YzXyDVY7C1LpXjZJy4+KZMXuFzF12YQF+4+2lvzwo3D6BkmtvGQJs=";
        String sourceSign = "qn6FiobfNOih9zh5rAEIk3+u1pgSxLrbxlnhes5Ft9BfCy6dbduBZYZ/nxC6s/Ur5WS+Xvoo1UX2Vl50j664/Bv7ek06fp/EvnVEO+XmWWBmNgKSb90XH7uyzPArlC4QGWohPQDh5PbfdFAJOgeECnkxCVpXY3j2VEuIGKlxeHw=";
        String Sign = "abcdefg";
        String org="1234";

        RSA rsa = new RSA();
        //先验证签名
        //使用公钥验签
        try {


            OrgCode=rsa.RSAEncrypt(PublicKey,org);
             org = rsa.RSADecrypt(PrivateKey, OrgCode);
            boolean succ = rsa.RSAVerify(SignPublicKey, Sign, sourceSign);
            if (succ) {
                //使用私钥解密获取企业编码
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
