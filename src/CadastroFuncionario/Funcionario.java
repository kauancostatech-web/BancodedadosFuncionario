package CadastroFuncionario;

public class Funcionario {

    private final String cpf;

    private String nome;

    private String cargo;

    private double jornadaDiariaHoras;

    private double saldoBancoHoras;

    public Funcionario(String cpf, String nome, String cargo, double jornadaDiariaHoras) {

        if (cpf == null || cpf.trim().isEmpty() || nome == null || nome.trim().isEmpty()) {

            throw new IllegalArgumentException("Nome e CPF são de preenchimento obrigatório e não podem ser vazios.");

        }

        if (jornadaDiariaHoras < 0) {

            throw new IllegalArgumentException("A carga horária diária não pode ser negativa.");

        }

        this.cpf = cpf;

        this.nome = nome;

        this.cargo = cargo;

        this.jornadaDiariaHoras = jornadaDiariaHoras;

        this.saldoBancoHoras = 0.0;

    }

    public String getCpf() {

        return cpf;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {

            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");

        }

        this.nome = nome;

    }

    public String getCargo() {

        return cargo;

    }

    public void setCargo(String cargo) {

        if (cargo == null || cargo.trim().isEmpty()) {

            throw new IllegalArgumentException("O cargo não pode ser nulo ou vazio.");

        }

        this.cargo = cargo;

    }

    public double getJornadaDiariaHoras() {

        return jornadaDiariaHoras;

    }

    public void setJornadaDiariaHoras(double jornadaDiariaHoras) {

        if (jornadaDiariaHoras < 0) {

            throw new IllegalArgumentException("A jornada diária não pode ser negativa.");

        }

        this.jornadaDiariaHoras = jornadaDiariaHoras;

    }

    public double getSaldoBancoHoras() {

        return saldoBancoHoras;

    }

    public void adicionarHorasAoBanco(double horas) {

        this.saldoBancoHoras += horas;

    }

}
