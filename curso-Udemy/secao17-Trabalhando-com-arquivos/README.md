# Seção 17: Trabalhando com arquivos:

## Aula 01 - Visão geral do capítulo Trabalhando com Arquivos e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Trabalhando com arquivos!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    11-arquivos(espaco-para-anotacoes).pdf
    11-arquivos.pdf

## Aula 03 - Lendo arquivo texto com classes File e Scanner:
Classes

- File - Representação abstrata de um arquivo e seu caminho
    
    https://docs.oracle.com/javase/10/docs/api/java/io/File.html

- Scanner - Leitor de texto
    
    https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html

- IOException (Exception)
    
    https://docs.oracle.com/javase/10/docs/api/java/io/IOException.html

Vamos começar por criar um novo projeto chamado work_files. Dentro dela, vamos criar um diretório chamado application e dentro criar um arquivo Program.java

    package application;

    import java.io.File;
    import java.io.IOException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            File file = new File("c:\\temp\\int.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                if(sc != null) {
                    sc.close();
                }
            }
        }

    }

Bom, aí o ambiente está pronto.

## Aula 04 - FileReader e BufferedReader:
Vamos ver sobre FileReader e BufferedReader.

Classes
- FileReader (stream de leitura de caracteres a partir de arquivos)

    https://docs.oracle.com/javase/10/docs/api/java/io/FileReader.html

- BufferedReader (mais rápido)

    https://docs.oracle.com/javase/10/docs/api/java/io/BufferedReader.html

    https://stackoverflow.com/questions/9648811/specific-difference-between-bufferedreader-and-filereader

Vamos ter que criar um novo projeto chamado work_files_readers.

Bom, agora, vamos realizar a devida leitura dos arquivos

    package application;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            String path = "c:\\temp\\in.txt";
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                fr = new FileReader(path);
                br = new BufferedReader(fr);
                
                String line = br.readLine();
                
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

## Aula 05 - Bloco try-with-resources:
Bloco try-with-resources

- É um bloco try que declara um ou mais recursos, e garante que esses recursos serão fechados ao final do bloco

- Disponível no Java 7 em diante

- https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

No caso, no projeto work_files_readers o que foi colocado no arquivo Program.java vamos colocar o seguinte

    package application;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            String path = "c:\\temp\\in.txt";
            
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                
                String line = br.readLine();
                
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        }

    }

Essa seria a forma mais enxuta de conseguirmos realizar a leitura necessária dos arquivos.

## Aula 06 - FileWriter e BufferedWriter:
Da mesma forma que tínhamos FileReader e BufferedReader para ler, temos o FileWriter e BufferedWriter, para escrever.

Classes

- FileWriter (stream de escrita de caracteres em de arquivos)

    https://docs.oracle.com/javase/10/docs/api/java/io/FileWriter.html

    -  Cria/recria o arquivo: new FileWriter(path)

    -  Acrescenta ao arquivo existente: new FileWriter(path, true)

- BufferedWriter (mais rápido)

    https://docs.oracle.com/javase/10/docs/api/java/io/BufferedWriter.html


Daí, vamos criar um novo projeto, work_files_writers e dentro dela criar o diretório application com arquivo Program.java.

    package application;

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;

    public class Program {

        public static void main(String[] args) {
            
            String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good night" };
            
            String path = "c:\\temp\\out.txt";
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

Essa estrutura acima, já cria o arquivo e escreve o que foi pedido para escrever.

Caso, vc não queira recriar o arquivo já criado e simplesmente escrever adiante bastaria colocar true no FileWriter

    package application;

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;

    public class Program {

        public static void main(String[] args) {
            
            String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good night" };
            
            String path = "c:\\temp\\out.txt";
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

## Aula 07 - Manipulando pastas com File:

## Aula 08 - Informações do caminho do arquivo:

## Aula 09 - Exercício proposto:

## Aula 10 - Correção em vídeo do exercício proposto:
