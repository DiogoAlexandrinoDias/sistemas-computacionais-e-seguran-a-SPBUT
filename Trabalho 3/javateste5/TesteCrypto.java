package javateste5;
import java.io.File;

public class TesteCrypto 
{ public static void main (String[] args) throws Exception
  { String  sMsgClara = "oi, alunos do USJT !";
    String  sMsgCifrada = null;
    String  sMsgDecifrada = null;
    byte[]  bMsgClara = null;
    byte[]  bMsgCifrada = null; 
    byte[]  bMsgDecifrada = null;
// instancia objeto da Classe improssra
Impressora prn = new Impressora();
// Imprime marcador de bloco
System.out.println("----------------------------------------------------------------");
// Imprime Texto
System.out.println(">>> imprimindo mensagem original...");
System.out.println(""); 
// Converte o texto de String dado no equivalante byte []
bMsgClara = sMsgClara.getBytes("ISO-8859-1");
// impreme cabecalho da mensagem
System.out.println("Mensagem Clara (Hexadecimal):");
//Imprime o texto original em Hexadecimal 
System.out.print(prn.hexBytesToString(bMsgClara));
System.out.println("");
// Imprime cabecalho da mensagem 
System.out.println("Mensagem Clara (String)");
// Imprime o texto original em String
System.out.println(sMsgCifrada);
System.out.println("");
/*
 * Criptografia Dummy ----------------------------------------------------------------
 */
// Imprime  Texto
System.out.println(">>> Cifrando com algoritmo Dummy");
System.out.println("");
// instancia um onjeto da classe CryptoDummy
CryptoDummy cdummy = new CryptoDummy();
// Gera a chave criptografia  Dummy simetrica e nome do onde sera armazenada
cdummy.gerarChave(new File ("chave.dummy"));
// Gera a cifra Dummy da mensagem  dada, com a chave dummy simetrica dada
cdummy.gerarCifra(bMsgClara, new File ("chave.dummy"));
// Recebe o texto cifrado
bMsgCifrada = cdummy.getTextoCifrado();
/// Converte o texto byte[] no e quivalente String
sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
// Imprime cabecalho da mensagem
System.out.println("Mensagem Cifrada (Hexadecimal):");
// Imprime o texto cifrado em Hexadecimal
System.out.print(prn.hexBytesToString(bMsgCifrada));
System.out.println("");
// Imprime cebecalho da mensagem 
System.out.println("Mensagem Cifrada (String):");
// Imprime o textp cifrado em Strinng 
System.out.println(sMsgCifrada);
System.out.println("");
// Imprime texto
System.out.println(">>> Decifrado com algoritmo Dummy...");
System.out.println("");
// Gera a decifra Dummy da mensagem desa, segundo a chave Dummy simetrica gerada 
cdummy.geraDecifrado(bMsgCifrada, new File ("chave.dummy"));
// Recebe o texto decifrado 
bMsgDecifrada = cdummy.getTextoDecifrado();
// Converte o texto byte[] no equicalente String
sMsgCifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
// Imprime cabeÃ§alho da mesanegem
System.out.println("Mensagem Decifrado (Hexadecimal):");
// Imprime o texto decifrado em Hexadecimal
System.out.println(prn.hexBytesToString(bMsgDecifrada));
System.out.println();
// Imprime cabecalho da mensagem
System.out.println("Mensagem Decifrada (String):");
// Imprime o texto decifraddo  em String
System.out.println(sMsgDecifrada);
System.out.println("");
/* 
 * Criptografia AES ----------------------------------------------------------------
*/
// Imprime Texto
System.out.println(">>> Cifrado com algoritmo AES...");
System.out.println("");
// instancia um objeto da classe CryptoAES
CryptoAES caes = new CryptoAES();
// Gera a Chave criptografia AES simetrica e o nome do arquivo onde será armazenamento
caes.gerarChave (new File ("chave.simetrica"));
// Gera a cifra AEs da mensagem dada, com a chave simetrica dada
caes.geraCifra(bMsgClara, new File ("chave.simetrica"));
// Recebe o texto cifrado
bMsgCifrada = caes.getTextoCifrado();
// Converte o testo byte[] no equivalente String 
sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
// Imprime cabecalho da mensagem
System.out.println("Mensagem Cifrada (Hexadecimal):");
// Imprime o texto  cifrado em Hexadecimal
System.out.print(prn.hexBytesToString(bMsgCifrada));
System.out.println("");
// Imprime cabecalho da mensagem 
System.out.println("Mensagem Cifrada (String):");
// Imprime o texto  Cifrado em String 
System.out.println(sMsgCifrada);
System.out.println();
//imprime texto
System.out.println(">>> Decifrado com o algoritmo AES...");
System.out.println("");
// Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
caes.gerarDecifrado(bMsgCifrada, new File ("chave.simetrica"));
// Recebe o texto decifrado
bMsgDecifrada = caes.getTextoDecifrado();
// Converte o texto byte[] no equivalente String 
sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
// Imprime cabecalho da mensagem 
System.out.println("Mensagem Decifrada (Hexadecimal) :" );
// Imprime o texto  decifrado em Hexadecimal
System.out.print(prn.hexBytesToString(bMsgDecifrada));
System.out.println();
// Imprime  o texto decifrado em string 
System.out.println(sMsgDecifrada);
System.out.println("");
/*
 * Criptografia RSA ----------------------------------------------------------------
*/
 // Imprime Texto
 System.out.println(">>>Cifrado com o algoritmo RSA...");
 System.out.println("");
 // Instancia um objeto da classe CryptoRSA
 CryptoRSA crsa = new CryptoRSA();
 // Gera as Chaves criptografia RSA publica e privada e os arquivos onde armazenas
 crsa.gerarParDeChaves (new File ("chave.publica"), new File ("chave.privada"));
 // Gera a cifra RSA da mensagem dada, segundo a chave publica
 crsa.gerarCifra(bMsgClara, new File ("chave.publica"));
 // Recebe o texto cifrado
 bMsgCifrada = crsa.gerarTextoCifrado();
 // Converte  o texto byte[] no equivalente String
 sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
// Imprime cabecalho da mensagem
System.out.print(prn.hexBytesToString(bMsgCifrada));
System.out.println("");
//Imprime cabecalho da mensagem
System.out.println("Mensagem Cifrada (String):");
//Imprime o texto cifrado em String
System.out.println(sMsgCifrada);
System.out.println("");
// Imprime texto
System.out.println(">>> Decifraando com algoritmo RSA...");
System.out.println("");
// Gera a decifra RSA da mensagem dada, segundo a chave privada gerada 
crsa.gerarDecifrado(bMsgCifrada, new File ("chave.privada"));
// Recebe o texto decifrado 
bMsgDecifrada = crsa.getTextoDecifrado();
// Converte o texto byte[] no equivalente String
sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
// imprime cabecalho da mensagem
System.out.println("Mensagem Decifrada (Hexadecimal):");
// Imprime o texto decifrado em Hexadecimal
System.out.print(prn.hexBytesToString(bMsgDecifrada));
System.out.println();
// Imprime cabecalho da mensagem
System.out.println("Mensagem Decifrada (String):");
// Imprime o texto decifrado em String
System.out.println(sMsgDecifrada);
System.out.println("");
}
}
