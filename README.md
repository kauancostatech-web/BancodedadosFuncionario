# Banco de Horas CLT

Sistema em Java, via linha de comando, para registro de ponto e controle de banco de horas de um funcionário CLT. O programa calcula automaticamente as horas trabalhadas no dia (descontando 1h de intervalo de almoço), compara com a jornada diária exigida e atualiza o saldo (crédito ou débito) do banco de horas.

## ✨ Funcionalidades

- Cadastro rápido do funcionário (CPF, nome, cargo e jornada diária)
- Aceita a jornada diária tanto em formato decimal (`8.5`) quanto em `HH:MM` (`8:30`)
- Registro de ponto diário com hora de entrada e saída
- Desconto automático de 1 hora de intervalo de almoço (regra CLT)
- Cálculo do saldo do banco de horas (positivo = horas extras, negativo = horas devidas)
- Resumo detalhado do ponto no console
- Exibição da situação atual do banco de horas em horas e minutos

## 🗂 Estrutura do projeto

```
Sistema/
 ├── SystemBanco.java      # Classe principal (main) — interação via Scanner
 └── BancoDeHoras.java      # Lógica de cálculo e exibição do banco de horas

CadastroFuncionario/
 └── Funcionario.java       # Dados do funcionário e saldo do banco de horas

Entrada.Saida/
 └── RegistroPonto.java     # Dados do registro de ponto do dia
```

> **Observação:** as classes `Funcionario` e `RegistroPonto` fazem parte do projeto mas não estão neste repositório/README — inclua-as nos pacotes `CadastroFuncionario` e `Entrada.Saida`, respectivamente, com os métodos utilizados por `SystemBanco` e `BancoDeHoras` (getters de CPF, nome, jornada diária, saldo do banco, horas trabalhadas etc.).

## ▶️ Como executar

1. Certifique-se de ter o **JDK** instalado (Java 8+).
2. Compile os arquivos respeitando a estrutura de pacotes:
   ```bash
   javac Sistema/SystemBanco.java Sistema/BancoDeHoras.java CadastroFuncionario/Funcionario.java "Entrada/Saida/RegistroPonto.java"
   ```
3. Execute o programa:
   ```bash
   java Sistema.SystemBanco
   ```
4. Siga as instruções no terminal: informe CPF, nome, cargo, jornada diária, data e horários de entrada/saída.

## 🧮 Exemplo de uso

```
=== CADASTRO DO FUNCIONÁRIO (CLT) ===
Digite seu CPF: 123.456.789-00
Digite seu nome: Maria Silva
Digite seu cargo: Analista
Digite sua jornada diária padrão :8

=== REGISTRO DE PONTO DIÁRIO ===
Digite a data : 23/09/2026
Digite a hora de entrada : 08:00
Digite a hora de saída : 18:00

--------------------------------------------------
RESUMO DETALHADO DO PONTO:
Funcionário: Maria Silva | CPF: 123.456.789-00
Horários: 08:00 até 18:00
Tempo total na empresa (Bruto): 10.00 horas
Intervalo de Almoço CLT: -1.00 hora (descontado)
Total Efetivo Trabalhado: 9.00 horas
Sua Jornada Exigida: 8.00 horas
--------------------------------------------------
Funcionário: Maria Silva (CPF: 123.456.789-00)
Situação: Você possui 1 hora(s) e 0 minuto(s) de crédito (extras).
```

## 🚧 Possíveis melhorias futuras

- Persistência dos dados em arquivo ou banco de dados (hoje o saldo é perdido ao fechar o programa)
- Validação de formato de CPF, datas e horários
- Suporte a múltiplos registros de ponto por funcionário (histórico)
- Interface gráfica ou API REST
- Testes unitários para `BancoDeHoras`

## 🛠 Tecnologias

- Java (uso de `Scanner` para entrada via console)

## 📄 Licença

Defina aqui a licença do projeto (ex: MIT).
