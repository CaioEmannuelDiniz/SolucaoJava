package com.caiodiniz.estagio.target;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
                null,
                "ESTAGIO TARGET\n Candidato:Caio Emannuel Anizio Diniz",
                "Apresentação", JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            boolean sucesso;

            Object escolhaMenu = JOptionPane.showInputDialog(
                    null,
                    "Qual questão gostaria de ver?",
                    "Menu Principal", JOptionPane.PLAIN_MESSAGE,
                    null, MenuPrincipal.values(),
                    0
            );

            switch (escolhaMenu) {
                case MenuPrincipal.QUESTAO_01:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "informe um número:",
                            "Questão de Fibonacci", JOptionPane.INFORMATION_MESSAGE
                    ));

                    sucesso = taskFibonacci(numero);

                    JOptionPane.showMessageDialog(
                            null,
                            sucesso ? "Pertence a sequência de fibonacci" : "Não Pertence a sequência de fibonacci",
                            "Resposta questão 01",
                            sucesso ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                            null
                    );

                    break;

                case MenuPrincipal.QUESTAO_02:

                    String frase = (JOptionPane.showInputDialog(
                            null,
                            "informe uma frase:",
                            "Questão da letra 'A'", JOptionPane.INFORMATION_MESSAGE
                    ));

                    sucesso = taskString(frase);

                    JOptionPane.showMessageDialog(
                            null,
                            sucesso ? "Possui a letra a, que se repetiu " + countChar(frase) + " vezes" : "Não possui a letra a",
                            "Resposta questão 02",
                            sucesso ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                            null
                    );

                    break;

                case MenuPrincipal.QUESTAO_03:
                    int indice = 12;
                    int soma = 0;
                    int k = 1;

                    while (k < indice) {
                        k = k + 1;
                        soma = soma + k;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "O valor da variável soma é igual a:" + soma,
                            "Resultado da questão 3", JOptionPane.INFORMATION_MESSAGE
                    );


                    break;

                case MenuPrincipal.QUESTAO_04:

                    String a = "a)1,3,5,7,9  aumenta de 2 em 2";
                    String b = "b)2,4,8,16,32,64,128 potencia de 2¹...2^7";
                    String c = "c)0,1,4,9,16,25,36,49 esta seguindo uma sequencia 0² a 7²";
                    String d = "d)4,16,36,64,100 esta seguindo uma sequencia de numeros pares elevado ao ² 2² a 10²";
                    String e = "e)1,1,2,3,5,8,13 esta seguindo a sequencia de fibonacci a soma do anterior com o proximo gera o novo valor ";
                    String f = "f)2,10,12,16,17,18,19,200 esta sequencia segue um padrão dos numero iniciar com a letra d";

                    JOptionPane.showMessageDialog(
                            null,
                            a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n",
                            "Questão 04", JOptionPane.INFORMATION_MESSAGE
                    );

                    break;
                case MenuPrincipal.QUESTAO_05:
                    JOptionPane.showMessageDialog(
                            null,
                            """
                                    Ligue o primeiro interruptor (1) e deixe-o ligado por cerca de 10 minutos. Isso permitirá que a lâmpada esquente.
                                    
                                    Após 10 minutos, desligue o primeiro interruptor (1) e ligue o segundo interruptor (2).
                                    
                                    Agora, vá até as salas das lâmpadas:
                                    
                                    A lâmpada que estiver acesa é a que é controlada pelo interruptor 2 (o que você acabou de ligar).
                                    
                                    Toque na lâmpada que estiver apagada:
                                    
                                    Se a lâmpada estiver quente, ela é controlada pelo interruptor 1 (o que estava ligado antes).
                                    Se a lâmpada estiver fria, ela é controlada pelo interruptor 3 (que nunca foi ligado).""",
                            "Questão 05", JOptionPane.INFORMATION_MESSAGE
                    );
                    JOptionPane.showMessageDialog(
                            null,
                            """
                                    Lâmpada acesa: Interruptor 2
                                    Lâmpada apagada e quente: Interruptor 1
                                    Lâmpada apagada e fria: Interruptor 3
                                    """,
                            "Questão 05", JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                case MenuPrincipal.SAIR:
                case null:
                    return;
                default:
                    break;
            }
        }

    }

    public static boolean taskFibonacci(int n) {
        int numeroAnterior = 0;
        int numeroProximo = 1;

        if (n < 0) {
            return false; // Números negativos não estão na sequência de Fibonacci
        }

        if (n == numeroAnterior || n == numeroProximo) {
            return true;
        }

        while (n > numeroProximo) {


            int numeroAux = numeroProximo;
            numeroProximo = numeroAnterior + numeroAux;
            numeroAnterior = numeroAux;


            if (numeroProximo == n) {

                return true;
            }


        }

        return false;
    }

    public static boolean taskString(String f) {
        String letraA = "a";
        return f.toLowerCase().contains(letraA);
    }

    public static int countChar(String f) {
        int count = 0;
        for (char a : f.toLowerCase().toCharArray()) {
            if (a == 'a') count++;
        }
        return count;
    }
}
