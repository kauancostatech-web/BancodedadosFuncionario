package Sistema;

import CadastroFuncionario.Funcionario;
import Entrada.Saida.RegistroPonto;

import java.util.Scanner;

public class SystemBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO DO FUNCIONÁRIO (CLT) ===");
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite sua jornada diária padrão :");
        String jornadaStr = scanner.nextLine().replace(",", ".");
        double jornada;

        if (jornadaStr.contains(":")) {
            String[] partesJornada = jornadaStr.split(":");
            jornada = Integer.parseInt(partesJornada[0]) + (Integer.parseInt(partesJornada[1]) / 60.0);
        } else {
            jornada = Double.parseDouble(jornadaStr);
        }

        Funcionario funcionario = new Funcionario(cpf, nome, cargo, jornada);
        BancoDeHoras banco = new BancoDeHoras(funcionario);

        System.out.println("\n=== REGISTRO DE PONTO DIÁRIO ===");
        System.out.print("Digite a data : ");
        String data = scanner.nextLine();

        System.out.print("Digite a hora de entrada : ");
        String entradaStr = scanner.nextLine();
        String[] partesEntrada = entradaStr.split(":");
        int totalMinutosEntrada = (Integer.parseInt(partesEntrada[0]) * 60) + Integer.parseInt(partesEntrada[1]);

        System.out.print("Digite a hora de saída : ");
        String saidaStr = scanner.nextLine();
        String[] partesSaida = saidaStr.split(":");
        int totalMinutosSaida = (Integer.parseInt(partesSaida[0]) * 60) + Integer.parseInt(partesSaida[1]);

        int diferencaMinutosBruta = totalMinutosSaida - totalMinutosEntrada;
        int diferencaMinutosLiquida = diferencaMinutosBruta - 60;
        double horasTrabalhadas = diferencaMinutosLiquida / 60.0;

        RegistroPonto registro = new RegistroPonto(funcionario.getCpf(), funcionario.getNome(), data, entradaStr, horasTrabalhadas);

        System.out.println("\n--------------------------------------------------");
        System.out.println("RESUMO DETALHADO DO PONTO:");
        System.out.println("Funcionário: " + registro.getNomeFuncionario() + " | CPF: " + registro.getCpfFuncionario());
        System.out.println("Horários: " + entradaStr + " até " + saidaStr);
        System.out.printf("Tempo total na empresa (Bruto): %.2f horas\n", (diferencaMinutosBruta / 60.0));
        System.out.println("Intervalo de Almoço CLT: -1.00 hora (descontado)");
        System.out.printf("Total Efetivo Trabalhado: %.2f horas\n", horasTrabalhadas);
        System.out.printf("Sua Jornada Exigida: %.2f horas\n", jornada);
        System.out.println("--------------------------------------------------");

        banco.registrarDia(registro);
        banco.exibirSituacao();

        scanner.close();
    }
}