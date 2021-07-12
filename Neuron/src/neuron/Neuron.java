/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuron;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author
 */
public class Neuron {

    static int[][] arrayTable;
    static double[] inputNeuron;

    static int width = 15;
    static int heigth = 25;

    static double[][] hiddenLayerWeigth;
    static double[][] outputLayerWeigth;

    static double[][] deltaHiddenLayerWeigth;
    static double[][] deltaOutputLayerWeigth;

    static int hiddenNeuronNum = 33;
    static int outputNeuronNum = 33;

    static double[][] standard = new double[33][33];

    static double[] outputLayerNeuron;
    static double[] hiddenLayerNeuron;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 33; j++) {
                if (i == j) {
                    standard[i][j] = 1;
                } else {
                    standard[i][j] = 0;
                }
            }
        }

        hiddenLayerWeigth = new double[heigth * width][hiddenNeuronNum];
        outputLayerWeigth = new double[hiddenNeuronNum][outputNeuronNum];
//        
        deltaHiddenLayerWeigth = new double[heigth * width][hiddenNeuronNum];
        deltaOutputLayerWeigth = new double[hiddenNeuronNum][outputNeuronNum];
       
        
        
        
        /**
         * ******************ЧТЕНИЕ ИЗ ФАЙЛА*****************************
         */
        

        

          
        //learning();
        readSymbol("TEST3.png");
        Path filePath1 = new File("randWeigthHidden.txt").toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList1 = Files.readAllLines(filePath1, charset);
        for (int i = 0; i < heigth * width; i++) {
            //System.out.println();
            for (int j = 0; j < hiddenNeuronNum; j++) {
                String a = stringList1.get(j + hiddenNeuronNum * i);
                hiddenLayerWeigth[i][j] = Double.parseDouble(a);
                //System.out.print(String.format("%.2f", hiddenLayerWeigth[i][j]) + " ");
            }
        }
        System.out.println();
        Path filePath2 = new File("randWeigthOutput.txt").toPath();
        List<String> stringList2 = Files.readAllLines(filePath2, charset);
        for (int i = 0; i < hiddenNeuronNum; i++) {
            //System.out.println();
            for (int j = 0; j < hiddenNeuronNum; j++) {
                String a = stringList2.get(j + hiddenNeuronNum * i);
                outputLayerWeigth[i][j] = Double.parseDouble(a);
                //System.out.print(String.format("%.2f", outputLayerWeigth[i][j]) + " ");
            }
        } 
        countNeuron();

        //System.out.println();

       
    }

    public static void countNeuron() throws IOException {

        
        
        hiddenLayerNeuron = new double[hiddenNeuronNum];
        //System.out.println();
        for (int i = 0; i < hiddenNeuronNum; i++) {
            for (int j = 0; j < heigth * width; j++) {
                hiddenLayerNeuron[i] = hiddenLayerNeuron[i] + inputNeuron[j] * hiddenLayerWeigth[j][i];
            }
            hiddenLayerNeuron[i] = 1 / (1 + Math.exp(-hiddenLayerNeuron[i]));
        }
        //System.out.println();

        outputLayerNeuron = new double[outputNeuronNum];

        for (int i = 0; i < outputNeuronNum; i++) {
            for (int j = 0; j < hiddenNeuronNum; j++) {
                outputLayerNeuron[i] = outputLayerNeuron[i] + hiddenLayerNeuron[j] * outputLayerWeigth[j][i];
            }
            outputLayerNeuron[i] = 1 / (1 + Math.exp(-outputLayerNeuron[i]));
            System.out.println(String.format("%.10f", outputLayerNeuron[i])+" "+i);
        }

        double max = -100;
        int maxInd = -100;
        for (int j = 0; j < hiddenNeuronNum; j++) {
            if (outputLayerNeuron[j] > max) {
                max = outputLayerNeuron[j];
                maxInd = j;
            }
        }
        switch (maxInd) {
            case 0:
                System.out.println("Буква А");
                break;
            case 1:
                System.out.println("Буква Б");
                break;
            case 2:
                System.out.println("Буква В");
                break;
            case 3:
                System.out.println("Буква Г");
                break;
            case 4:
                System.out.println("Буква Д");
                break;
            case 5:
                System.out.println("Буква Е");
                break;
            case 6:
                System.out.println("Буква Ё");
                break;
            case 7:
                System.out.println("Буква Ж");
                break;
            case 8:
                System.out.println("Буква З");
                break;
            case 9:
                System.out.println("Буква И");
                break;
            case 10:
                System.out.println("Буква Й");
                break;
            case 11:
                System.out.println("Буква К");
                break;
            case 12:
                System.out.println("Буква Л");
                break;
            case 13:
                System.out.println("Буква М");
                break;
            case 14:
                System.out.println("Буква Н");
                break;
            case 15:
                System.out.println("Буква О");
                break;
            case 16:
                System.out.println("Буква П");
                break;
            case 17:
                System.out.println("Буква Р");
                break;
            case 18:
                System.out.println("Буква С");
                break;
            case 19:
                System.out.println("Буква Т");
                break;
            case 20:
                System.out.println("Буква У");
                break;
            case 21:
                System.out.println("Буква Ф");
                break;
            case 22:
                System.out.println("Буква Х");
                break;
            case 23:
                System.out.println("Буква Ц");
                break;
            case 24:
                System.out.println("Буква Ч");
                break;
            case 25:
                System.out.println("Буква Ш");
                break;
            case 26:
                System.out.println("Буква Щ");
                break;
            case 27:
                System.out.println("Буква Ъ");
                break;
            case 28:
                System.out.println("Буква Ы");
                break;
            case 29:
                System.out.println("Буква Ь");
                break;
            case 30:
                System.out.println("Буква Э");
                break;
            case 31:
                System.out.println("Буква Ю");
                break;
            case 32:
                System.out.println("Буква Я");
                break;

        }

    }

    public static void learning() throws IOException {
        randWeigth(); 
        double h = 0.1;
        double a = 0.5;
        double error = 1000;

        double GRADoutput[][] = new double[hiddenNeuronNum][outputNeuronNum];
        double GRADhidden[][] = new double[heigth * width][hiddenNeuronNum];

        for (int y = 0; y < 500; y++) {
            //while (error > 0.01) {

            for (int k = 0; k < 99; k++) {
                readSymbol(k + ".png");

                countNeuron();
                System.out.println(k % 33);

                error = 0;

                for (int i = 0; i < outputNeuronNum; i++) {
                    error = error + Math.pow(outputLayerNeuron[i] - standard[i][k % 33], 2);
                }

                double deltaOutput[] = new double[outputNeuronNum];
                for (int i = 0; i < outputNeuronNum; i++) {
                    deltaOutput[i] = (standard[i][k % 33] - outputLayerNeuron[i]) * (1 - outputLayerNeuron[i]) * outputLayerNeuron[i];
                }

                double deltaHidden[] = new double[hiddenNeuronNum];
                for (int j = 0; j < hiddenNeuronNum; j++) {
                    for (int i = 0; i < outputNeuronNum; i++) {
                        deltaHidden[j] = deltaHidden[j] + outputLayerWeigth[j][i] * deltaOutput[i];
                    }
                    deltaHidden[j] = (1 - hiddenLayerNeuron[j]) * hiddenLayerNeuron[j] * deltaHidden[j];
                }

                for (int j = 0; j < hiddenNeuronNum; j++) {
                    for (int i = 0; i < outputNeuronNum; i++) {
                        GRADoutput[j][i] = hiddenLayerNeuron[j] * deltaOutput[i];
                    }
                }

                for (int j = 0; j < hiddenNeuronNum; j++) {
                    for (int i = 0; i < outputNeuronNum; i++) {
                        deltaOutputLayerWeigth[j][i] = h * GRADoutput[j][i];// + a*deltaOutputLayerWeigth[j][i];//a*outputLayerNeuron[i];
                        outputLayerWeigth[j][i] = outputLayerWeigth[j][i] + deltaOutputLayerWeigth[j][i];//a*outputLayerNeuron[i];
                    }
                }

                for (int j = 0; j < heigth * width; j++) {
                    for (int i = 0; i < hiddenNeuronNum; i++) {
                        GRADhidden[j][i] = inputNeuron[j] * deltaHidden[i];
                    }
                }

                for (int j = 0; j < heigth * width; j++) {
                    for (int i = 0; i < hiddenNeuronNum; i++) {
                        deltaHiddenLayerWeigth[j][i] = h * GRADhidden[j][i]; //+ a*deltaHiddenLayerWeigth[j][i];//a*outputLayerNeuron[i];
                        hiddenLayerWeigth[j][i] = hiddenLayerWeigth[j][i] + deltaHiddenLayerWeigth[j][i];//a*outputLayerNeuron[i];
                    }
                }

            }

            writeWeigth();
        }
    }

    public static void readSymbol(String path) throws IOException {
        /**
         * *********************СЧИТЫВАНИЕ ИЗ ФАЙЛА**************************
         */
        BufferedImage image = ImageIO.read(new File(path));
        arrayTable = new int[image.getHeight()][image.getWidth()];

        width = image.getWidth();
        heigth = image.getHeight();

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int rgb = image.getRGB(j, i);
                Color color = new Color((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                if (r < 150 && g < 150 && b < 150) {
                    arrayTable[i][j] = 1;
                } else {
                    arrayTable[i][j] = 0;
                }
            }
        }
        /**
         * ******************ПРЕОБРАЗОВАНИЕ В
         * ВЕКТОР*****************************
         */
        inputNeuron = new double[image.getWidth() * image.getHeight()];
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                inputNeuron[i * image.getWidth() + j] = arrayTable[i][j];
                //System.out.println(arrRow[i * image.getWidth() + j]);
            }
        }
    }

    public static void randWeigth() throws FileNotFoundException, IOException {

        for (int learn = 0; learn < 1; learn++) {

            for (int i = 0; i < heigth * width; i++) {
                System.out.println();
                for (int j = 0; j < hiddenNeuronNum; j++) {
                    hiddenLayerWeigth[i][j] = Math.random() * (1 - (-1)) - 1;
                    System.out.print(String.format("%.2f", hiddenLayerWeigth[i][j]) + " ");
                }
            }

            BufferedWriter writerHidden = new BufferedWriter(new FileWriter(new File("randWeigthHidden.txt")));
            for (int i = 0; i < heigth * width; i++) {
                for (int j = 0; j < hiddenNeuronNum; j++) {
                    writerHidden.write(Double.toString(hiddenLayerWeigth[i][j]));
                    writerHidden.write("\r\n");
                }
            }
            writerHidden.flush();

            System.out.println();
            for (int i = 0; i < hiddenNeuronNum; i++) {
                System.out.println();
                for (int j = 0; j < outputNeuronNum; j++) {
                    outputLayerWeigth[i][j] = Math.random() * (1 - (-1)) - 1;
                    System.out.print(String.format("%.2f", outputLayerWeigth[i][j]) + " ");
                }
            }

            BufferedWriter writerOutput = new BufferedWriter(new FileWriter(new File("randWeigthOutput.txt")));
            for (int i = 0; i < hiddenNeuronNum; i++) {
                for (int j = 0; j < outputNeuronNum; j++) {
                    writerOutput.write(Double.toString(outputLayerWeigth[i][j]));
                    writerOutput.write("\r\n");
                }
            }
            writerOutput.flush();

        }
    }

    public static void writeWeigth() throws IOException {
        BufferedWriter writerHidden = new BufferedWriter(new FileWriter(new File("randWeigthHidden.txt")));
        for (int i = 0; i < heigth * width; i++) {
            for (int j = 0; j < hiddenNeuronNum; j++) {
                writerHidden.write(Double.toString(hiddenLayerWeigth[i][j]));
                writerHidden.write("\r\n");;
            }
        }
        writerHidden.flush();

        BufferedWriter writerOutput = new BufferedWriter(new FileWriter(new File("randWeigthOutput.txt")));
        for (int i = 0; i < hiddenNeuronNum; i++) {
            for (int j = 0; j < outputNeuronNum; j++) {
                writerOutput.write(Double.toString(outputLayerWeigth[i][j]));
                writerOutput.write("\r\n");;
            }
        }
        writerOutput.flush();
    }

}
