import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.*;

public class Assignment1
{
    public static void main(String [] args)
    {
        BigInteger p = new BigInteger("b59dd79568817b4b9f6789822d22594f376e6a9abc0241846de426e5dd8f6eddef00b465f38f509b2b18351064704fe75f012fa346c5e2c442d7c99eac79b2bc8a202c98327b96816cb8042698ed3734643c4c05164e739cb72fba24f6156b6f47a7300ef778c378ea301e1141a6b25d48f1924268c62ee8dd3134745cdf7323", 16);
        //BigInteger g = new BigInteger("44ec9d52c8f9189e49cd7c70253c2eb3154dd4f08467a64a0267c9defe4119f2e373388cfa350a4e66e432d638ccdc58eb703e31d4c84e50398f9f91677e88641a2d2f6157e2f4ec538088dcf5940b053c622e53bab0b4e84b1465f5738f549664bd7430961d3e5a2e7bceb62418db747386a58ff267a9939833beefb7a6fd68", 16);
        BigInteger A = new BigInteger("5af3e806e0fa466dc75de60186760516792b70fdcd72a5b6238e6f6b76ece1f1b38ba4e210f61a2b84ef1b5dc4151e799485b2171fcf318f86d42616b8fd8111d59552e4b5f228ee838d535b4b987f1eaf3e5de3ea0c403a6c38002b49eade15171cb861b367732460e3a9842b532761c16218c4fea51be8ea0248385f6bac0d", 16);
        BigInteger b = new BigInteger("77d435a231a463b510127f271c43f81bd0bfde6803b7f9bb6379b716158256efd92e535af7153e6b4b8cdec887a915d563999462010322a88783140d8a4f053fc4c11c0eac32bce3bac020b62fd41b1d3b3075022c93dc98be1600020761a5ffcc003f45e5f7b86c81c6fc96baac85918efd5070ba7b4f61f48ef1eb59dd9e76", 16);
        byte [] IV = new byte [] {(byte) 0x29, (byte) 0x48, (byte) 0x15, (byte) 0x09, (byte) 0xfe, (byte) 0xf3, (byte) 0x25, (byte) 0xe3, (byte) 0xdb, (byte) 0xe0, (byte) 0x57, (byte) 0xb3, (byte) 0x56, (byte) 0x10, (byte) 0xa9, (byte) 0x4d,};

        //Modular Exponentiation to find B where B = g^b(mod p) using left to right algorithm
        /*BigInteger y = new BigInteger("1", 10);
        String binary = b.toString(2);
        for(int i = 0; i < binary.length(); i ++)
        {
            y = y.multiply(y).mod(p);
            if(binary.charAt(i) == '1')
            {
                y = y.multiply(g).mod(p);
            }
        }
        BigInteger B = new BigInteger(y.toString(16), 16);
        System.out.println(B.toString(16));*/

        //Modular Exponentiation to find s where s = A^b(mod p) using left to right algorithm
        BigInteger y = new BigInteger("1", 10);
        String binary = b.toString(2);
        for(int i = 0; i < binary.length(); i ++)
        {
            y = y.multiply(y).mod(p);
            if(binary.charAt(i) == '1')
            {
                y = y.multiply(A).mod(p);
            }
        }
        BigInteger s = new BigInteger(y.toString(16), 16);


        //Acquire key k using SHA-256 Hash on binary representation of s (don't use sting as it results in different values)
        //Create byte array from s to be hashed
        String bytes = s.toString(2);
        byte [] binary_s = new byte[128];

        binary_s[0] = (byte) Integer.parseInt("01100011", 2);
        for(int i = 7; i < 1023; i = i + 8)
            binary_s[(i + 1)/8] = (byte) Integer.parseInt(bytes.substring(i, i + 8), 2);


        //Hash s byte array
        MessageDigest sha256 = null;
        try
        {
            sha256 = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("Error in hashing.");
        }
        byte[] hash = sha256.digest(binary_s);
        //BigInteger k = new BigInteger(1, hash);


        //Read contents of .class file to byte array to be encrypted
        File clFile = new File(args[0]);
        byte [] classF = {};
        try
        {
            classF = Files.readAllBytes(clFile.toPath());
        }
        catch (Exception e)
        {
            System.out.println("Couldn't convert file to bytes");
        }


        //File content padding
        int bytesToAdd = (128 - (classF.length * 8)%128)/8;
        byte [] classF2 = new byte [classF.length + bytesToAdd];
        for(int q = 0; q < classF2.length; q ++)
        {
            if(q < classF.length)
                classF2[q] = classF[q];
            else if(q == classF.length)
                classF2[q] = (byte) 128;
            else
                classF2[q] = (byte) 0;
        }
        //System.out.println("Byte length of content: " + classF2.length + " % 16 = " + classF2.length % 16 + "\nByte length of content: " + classF2.length + " % 32 = " + classF2.length % 32 + "\nBit length of content with padding: " + classF2.length * 8 + " % 128 = " + (classF2.length * 8) % 128);


        //AES encryption using key k, initial value IV, and data classF2
        SecretKeySpec aesKey = new SecretKeySpec(hash, "AES");
        IvParameterSpec iv = new IvParameterSpec(IV);
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey, iv);
            byte [] encrypted = cipher.doFinal(classF2);
            for(byte b1 : encrypted)
            {
                String hex = String.format("%02X", b1);
                System.out.print(hex);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in Encryption padding handling. " + e);
        }
    }
}