package Sistema;

import CadastroFuncionario.Funcionario;
import Entrada.Saida.RegistroPonto;

public class BancoDeHoras {
    private Funcionario funcionario;

    public BancoDeHoras(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void registrarDia(RegistroPonto registro) {
        double diferenca = registro.getHorasTrabalhadas() - this.funcionario.getJornadaDiariaHoras();
        this.funcionario.adicionarHorasAoBanco(diferenca);
    }

    public void exibirSituacao() {
        System.out.println("Funcionário: " + this.funcionario.getNome() + " (CPF: " + this.funcionario.getCpf() + ")");

        double saldoAtual = this.funcionario.getSaldoBancoHoras();
        double saldoAbs = Math.abs(saldoAtual);
        int horas = (int) saldoAbs;
        int minutos = (int) Math.round((saldoAbs - horas) * 60);

        if (saldoAtual < 0) {
            System.out.printf("Situação: ATENÇÃO! Você deve %d hora(s) e %d minuto(s) para a empresa.%n", horas, minutos);
        } else if (saldoAtual > 0) {
            System.out.printf("Situação: Você possui %d hora(s) e %d minuto(s) de crédito (extras).%n", horas, minutos);
        } else {
            System.out.println("Situação: Seu banco de horas está zerado. Jornada cumprida perfeitamente!");
        }
    }
}