package javateste5;

import java.io.*;

public class CryptoDummy 
{
    private  byte[] textoCifrado;
    private  byte[] textoDecifrado; 
    public  CryptoDummy()
    {textoCifrado = null;
     textoDecifrado = null;
    }
    public void gerarChave(File Fdummy) throws IOException
    {//Gera uma chave Dummy simetrica (dk: 0 a 100)
        int dk = (int) (Math.random ()*100);
        //Grava a chave Dummy simtrica em formato serializado
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Fdummy));
        oos.writeObject(dk);
        oos.close();
    }
    public void gerarCifra(byte[] texto, File Fdummy)
        throws IOException, ClassNotFoundException
    {  ObjectInputStream ois = new ObjectInputStream (new FileInputStream (Fdummy));
    int Idummy = (Integer) ois.readObject();
     ois.close();
     textoCifrado = texto;
     for(int i = 0; i < texto.length; i++)
     { textoCifrado[i]  = (byte) (textoCifrado[i] + i + Idummy);
    } 
 }    
public byte [] getTextoCifrado()  throws  ClassNotFoundException
{ return textoCifrado;
}
public void geraDecifrado(byte[] texto, File Fdummy)
throws IOException, ClassNotFoundException
{ ObjectInputStream ois = new ObjectInputStream (new FileInputStream (Fdummy));
int Idummy = (Integer) ois.readObject();
ois.close();
textoDecifrado = texto;
for(int i = 0; i < texto.length; i++)
{ textoDecifrado[i] = (byte) (textoDecifrado[i] - i - Idummy);
}
}
public byte[]  getTextoDecifrado() throws  ClassNotFoundException
{return   textoDecifrado;
}
}

