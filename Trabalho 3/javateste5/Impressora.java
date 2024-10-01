package javateste5;

public class Impressora 
{public String hexBytesToString(byte[] b)
    {String    sOut = "";
     String    sBgn = "";
     String    sMd1 = "";
     String    sEnd = "";
     String    sSpc = "                                                ";//48 espacos
     for(int i = 0; i < b.length; i++)
     {//A cada linha de 16 bytes  hexadecimais faz :
        if(i%16==0) sBgn += Integer.toHexString(1%0xFFFF | 0x10000).substring(1,5) + " - ";
      //Monta a String do meio, contendo os bytes lidos
      sMd1 += Integer.toHexString(b[i] & 0xFF | 0x100 ).substring(1,3)+ " ";
      //Monta a string do final, contendo os xaracteres lidos
      if(b[i]>= 32 && b[i] <= 126) sEnd += (char) b[i];
      else sEnd += ".";
      //monta linha a cada 16 caracteres lidos
      if((i % 16 == 15 ) || (i == b.length - 1))
      { sOut += sBgn+sMd1+sSpc.substring(3*((i%16)+1),sSpc.length())+" - "+sEnd+"\n";
        sBgn = sMd1 = sEnd = "";
      }
    }
   return sOut;
 }

}
