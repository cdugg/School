import java.io.File;
import java.math.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Assignment2
{
    public static BigInteger zero = new BigInteger("0");
    public static BigInteger one = new BigInteger("1");
    public static BigInteger cTest = new BigInteger("ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb", 16);
    public static void main(String [] args)
    {
        //Create values for p and q using seeds to keep consistent for testing
        long seed_p = 0x48e;
        Random rp = new Random(seed_p);
        BigInteger p = BigInteger.probablePrime(512, rp);
        long seed_q = 0x48f;
        Random rq = new Random(seed_q);
        BigInteger q = BigInteger.probablePrime(512, rq);
        //assert gcd(p,q).equals(one) : "p and q are not co-prime pick new p/q";

        //Create n and find Phi(n) = (p-1)*(q-1) if gcd(p,q)=1
        BigInteger n = p.multiply(q);
        BigInteger x = p.subtract(one);
        BigInteger y = q.subtract(one);
        BigInteger phi_n = x.multiply(y);

        //ensure phi_n and e are co-primes
        BigInteger e = new BigInteger("65537", 10);
        //assert gcd(e, phi_n).equals(one) : "e and phi_n are not co-primes pick new p/q";

        //compute decryption exponent d = Multiplicative Inverse(e mod phi_n)
        BigInteger d = multiplicativeInverse(e, phi_n);
        //BigInteger encryptedHash = encryptRSA(cTest, e, p, q, n);
        //BigInteger decryptedHash = decryptRSA(encryptedHash, d, p, q, n);
        //System.out.println("Encrypt: " + encryptedHash.toString(16) + "\nDecrypt: " + decryptedHash.toString(16));

        //Read class file and hash byte array
        File clFile = new File(args[0]);
        byte [] classF = {};
        try
        {
            classF = Files.readAllBytes(clFile.toPath());
        }
        catch (Exception except)
        {
            System.out.println("Couldn't convert file to bytes");
        }
        //System.out.println(Arrays.toString(classF) + classF.length);
        MessageDigest sha256 = null;
        try
        {
            sha256 = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException except)
        {
            System.out.println("Error in hashing.");
        }
        byte[] hash = sha256.digest(classF);

        //Convert file hash to BigInteger
        StringBuilder hashString = new StringBuilder();
        for (byte b : hash)
        {
            String hex = String.format("%02X", b);
            hashString.append(hex);
        }
        BigInteger hashS = new BigInteger(hashString.toString(), 16);
        //System.out.println(hashS.toString(16));

        //Apply digital signature to hash and write to signature.txt
        BigInteger signature = decryptRSA(hashS,d,p,q,n);
        System.out.print(signature.toString(16));
    }

    public static BigInteger gcd(BigInteger a, BigInteger b)
    {
        int compareVal = a.compareTo(b);
        while(compareVal != 0 && ! a.equals(zero) && ! b.equals(zero)) {
            if (compareVal == 1)
            {
                a = a.mod(b);
            }
            else
            {
                b = b.mod(a);
            }
            compareVal = a.compareTo(b);
        }
        BigInteger gcd = null;
        if(a.compareTo(b) == 1)
            gcd = a;
        else
            gcd = b;
        return gcd;
    }

    public static BigInteger multiplicativeInverse(BigInteger a, BigInteger b)
    {
        BigInteger a0 = a;
        BigInteger b0 = b;
        BigInteger y = new BigInteger("0");
        BigInteger x = new BigInteger("1");
        if(b.equals(x))
        {
            return zero;
        }
        while(a.compareTo(one) != -1 && a.compareTo(one) != 0)
        {
            BigInteger q = a.divide(b);
            BigInteger t = b;

            b = a.mod(b);
            a = t;
            t = y;

            y = q.multiply(y);
            y = x.subtract(y);
            x = t;
        }
        if(x.compareTo(zero) == -1)
        {
            x = x.add(b0);
        }
        //assert x.equals(a0.modInverse(b0));
        return x;
    }

    public static BigInteger modularExponentiation(BigInteger a, BigInteger b, BigInteger c)
    {
        BigInteger y = new BigInteger("1", 10);
        String binary = b.toString(2);
        for(int i = 0; i < binary.length(); i ++)
        {
            y = y.multiply(y).mod(c);
            if(binary.charAt(i) == '1')
            {
                y = y.multiply(a).mod(c);
            }
        }
        return y;
    }

    public static BigInteger crt(BigInteger c, BigInteger d, BigInteger p, BigInteger q, BigInteger n)
    {
        //Simplify crt
        BigInteger m, m1, m2, x1, x2, cp, cq, dp, dq;
        cp = c.mod(p);
        cq = c.mod(q);
        dp = d;
        dq = d;
        if(gcd(d, p.subtract(one)).equals(one))
        {
            dp = p.subtract(one);
            dp = d.mod(dp);
        }
        if(gcd(d, q.subtract(one)).equals(one))
        {
            dq = q.subtract(one);
            dq = d.mod(dq);
        }
        m1 = modularExponentiation(cp, dp, p);
        m2 = modularExponentiation(cq, dq, q);

        //do crt
        x1 = multiplicativeInverse(p, q);
        x1 = m2.multiply(x1);
        x1 = p.multiply(x1);
        x2 = multiplicativeInverse(q, p);
        x2 = m1.multiply(x2);
        x2 = q.multiply(x2);

        m = x1.add(x2);
        return m.mod(n);
    }
    public static BigInteger decryptRSA(BigInteger c, BigInteger d, BigInteger p, BigInteger q, BigInteger n)
    {
        return crt(c, d, p, q, n);
    }
    public static BigInteger encryptRSA(BigInteger c, BigInteger e, BigInteger p, BigInteger q, BigInteger n)
    {
        return crt(c, e, p, q, n);
    }
}
