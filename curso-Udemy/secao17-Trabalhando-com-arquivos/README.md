# Seção 17: Trabalhando com arquivos - Criação, leitura, remoção de arquivos:

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
Vamos aprender a manipular pastas com File.

Vamos criar um projeto work_files_handling e dentro dela criamos o diretório application e o arquivo Program.java.

Vamos colocar o seguinte

    package application;

    import java.io.File;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter a folder path: ");
            String strPath = sc.nextLine();
            
            File path = new File(strPath);
            
            File[] folders = path.listFiles(File::isDirectory);
            System.out.println("FOLDERS:");
            for (File folder : folders) {
                System.out.println(folder);
            }
            
            sc.close();
        }

    }

O código acima, permite vc dar uma listagem dos diretórios que existem na path que vc colocar, por exemplo, "c:\temp".

Agora, vamos mostrar como fazer a listagem dos arquivos

    package application;

    import java.io.File;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter a folder path: ");
            String strPath = sc.nextLine();
            
            File path = new File(strPath);
            
            File[] folders = path.listFiles(File::isDirectory);
            System.out.println("FOLDERS:");
            for (File folder : folders) {
                System.out.println(folder);
            }
            
            File[] files = path.listFiles(File::isFile);
            System.out.println("FILES:");
            for (File file : files) {
                System.out.println(file);
            }
            
            sc.close();
        }

    }

Agora, vamos colocar o código que permite criar um subdiretório

    package application;

    import java.io.File;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter a folder path: ");
            String strPath = sc.nextLine();
            
            File path = new File(strPath);
            
            File[] folders = path.listFiles(File::isDirectory);
            System.out.println("FOLDERS:");
            for (File folder : folders) {
                System.out.println(folder);
            }
            
            File[] files = path.listFiles(File::isFile);
            System.out.println("FILES:");
            for (File file : files) {
                System.out.println(file);
            }
            
            boolean success = new File(strPath + "\\subdir").mkdir();
            System.out.println("Directory created successfully: " + success);
            
            sc.close();
        }

    }

## Aula 08 - Informações do caminho do arquivo:
Vamos entender melhor sobre as informações de caminho do arquivo.

Vamos criar um projeto work_files_path_information e dentro dele criar o diretório application e dentro dela colocar o arquivo 
Program.java.

Vamos colocar o seguinte

    package application;

    import java.io.File;
    import java.util.Scanner;

    public class Program {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a folder path: ");
            String strPath = sc.nextLine();

            File path = new File(strPath);

            // Pega somente o nome do arquivo desprezando o caminho
            System.out.println("getPath: " + path.getPath());

            // Pega o caminho sem o nome do arquivo
            System.out.println("getParent: " + path.getParent());

            // Pega o caminho e o nome do arquivo
            System.out.println("getName: " + path.getName());

            sc.close();
        }
    }

No caso, o código acima permite vc consultar as informações do caminho. Para testar coloca "c:\temp\in.txt".

## Aula 09 - Exercício proposto:
Seguir o enunciado

    Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de itens vendidos. Cada item possui um nome, preço unitário e quantidade, separados por vírgula. Você deve gerar um novo arquivo chamado "summary.csv", localizado em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas o nome e o valor total para aquele item (preço unitário multiplicado pela quantidade), conforme exemplo.

Exemplo de funcionamento

- Source File:

    TV LED,1290.99,1
    Video Game Chair,350.50,3
    Iphone X,900.00,2
    Samsung Galaxy 9,850.00,2

- Output file (out/summary.csv):

    TV LED,1290.99
    Video Game Chair,1051.50
    Iphone X,1800.00
    Samsung Galaxy 9,1700.00

Seguir a solução do professor

    https://github.com/acenelio/files1-java

## Aula 10 - Correção em vídeo do exercício proposto:
Queridos alunos, nosso instrutor Alexandre Oliveira fez a correção em vídeo do exercício, disponível no nosso Youtube:

    https://youtu.be/bIPd_451uEg

Abraços e bons estudos!
