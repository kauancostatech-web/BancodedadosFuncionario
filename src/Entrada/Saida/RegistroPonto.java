package Entrada.Saida;

public class RegistroPonto {
    private String cpfFuncionario;
    private String nomeFuncionario;
    private String data;
    private String horaEntrada;
    private double horasTrabalhadas;

    public RegistroPonto(String cpfFuncionario, String nomeFuncionario, String data, String horaEntrada, double horasTrabalhadas) {
        this.cpfFuncionario = cpfFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getData() {
        return data;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
}