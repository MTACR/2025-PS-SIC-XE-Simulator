# SIC/XE Simulator

This project is an academic simulator of the SIC/XE architecture (Simplified Instructional Computer with Extra Equipment), developed with Java and JavaFX. The program allows users to write SIC/XE assembly code, assemble symbolic programs, link multiple modules, and load them into virtual memory, simulating their execution.

The simulator features a graphical interface that enables users to:
- Edit, assemble, and view assembly source code;
- View and edit generated object files (`.obj`);
- Link multiple object modules with support for absolute or relocatable relocation;
- Load generated programs into the simulated SIC/XE virtual machine;
- Monitor register states, memory, and step-by-step execution.

## Pré-requisitos

- Java 17 or higher;
- Gradle (wrapper included in the project.

## How to use?

### 1. Cloning the Repository

Clone the repository and navigate to the project folder:

```bash
git clone https://github.com/pinhorenan/Simulador_SIC-XE.git
cd Simulador_SIC-XE
```

### 2. Compiling and running with Gradle Wrapper

Use the included Gradle Wrapper to compile and run the simulator:

- **Linux/Mac:**

```bash
./gradlew run
```

- **Windows:**

```cmd
gradlew.bat run
```

## Generating and Running the JAR

To generate an executable JAR:

```bash
./gradlew jar
```

The generated JAR will be located in `build/libs`. To run it, use:

```bash
java -jar build/libs/sicxesimulator.jar
```

## Supported Features

- Macro Processor:
  - Pre-processes code before assembly, expanding any defined macros;
  - Supports nested macros.
- Full SIC/XE Assembler:
  - Supports standard directives: `START`, `END`, `WORD`, `BYTE`, `RESB`, `RESW`, `EXTDEF`, `EXTREF`;
  - Generates SIC/XE-style object files (`.obj`) with `H/D/R/T/M/E` records;
  - Generates a serialized binary file (`.meta`) to retain metadata.
- Multi-Module Linker:
  - Performs absolute or relocatable linking between multiple modules;
  - Generates object and binary files following the same structure as the assembler.
- Loader with Optional Final Relocation:
  - Loads object programs into virtual memory;
  - Applies pending relocation (when required).

## SIC/XE Instruction Set

This simulator partially implements the SIC/XE instruction set according to the official specification, with some educational scope limitations:

### Implemented Instructions

- **Format 2 (register-based):**  
  `ADDR`, `CLEAR`, `COMPR`, `DIVR`, `MULR`, `RMO`, `SHIFTL`, `SHIFTR`, `SUBR`, `TIXR`

- **Format 3/4 (memory and immediate):**  
  `ADD`, `AND`, `COMP`, `DIV`, `J`, `JEQ`, `JGT`, `JLT`, `JSUB`, `LDA`, `LDB`, `LDCH`, `LDL`, `LDS`, `LDT`, `LDX`, `MUL`, `OR`, `RSUB`, `STA`, `STB`, `STCH`, `STL`, `STS`, `STT`, `STX`, `SUB`, `TIX`

### NOT Implemented Instructions (Present as STUB)

Due to project constraints, the following are not supported:

- **Format 1 and Special Instructions:**  
  `FIX`, `FLOAT`, `NORM`, `HIO`, `SIO`, `TIO`

- **Floating-Point Instructions:**  
  `ADDF`, `COMPF`, `DIVF`, `LDF`, `MULF`, `STF`, `SUBF`

- **System Control and I/O Operations:**  
  `LPS`, `RD`, `SSK`, `STI`, `STSW`, `SVC`, `TD`, `WD`

These instructions have placeholders (stubs) that generate informative logs indicating their lack of implementation.

## Documentation of Main Classes

| Class                                                                                       | Description                                      |
|----------------------------------------------------------------------------------------------|------------------------------------------------|
| [`ControlUnit`](src/main/java/sicxesimulator/hardware/cpu/ControlUnit.java)                  | Fetches, decodes, and dispatches instructions.       |
| [`InstructionDecoder`](src/main/java/sicxesimulator/hardware/cpu/InstructionDecoder.java)    | Decodes SIC/XE instructions.                  |
| [`ExecutionUnit`](src/main/java/sicxesimulator/hardware/cpu/ExecutionUnit.java)              | Executes SIC/XE instruction set.         |
| [`MacroProcessor`](src/main/java/sicxesimulator/software/macroprocessor/MacroProcessor.java) | Expands macros defined in the source code.      |
| [`Assembler`](src/main/java/sicxesimulator/software/assembler/Assembler.java)                | Coordinates program assembly phases.     |
| [`Linker`](src/main/java/sicxesimulator/software/linker/Linker.java)                         | Links object modules.           |
| [`Loader`](src/main/java/sicxesimulator/software/loader/Loader.java)                         | Loads `.obj` files into memory. |

## License

This project is licensed under the [MIT License](LICENSE).

# [PT-BR] Simulador SIC/XE

Este projeto é um simulador acadêmico da arquitetura SIC/XE (Simplified Instructional Computer with Extra Equipment), desenvolvido com Java e JavaFX. O programa permite escrever código assembly SIC/XE, montar programas em linguagem simbólica, realizar ligação de múltiplos módulos e carregá-los na memória virtual, simulando sua execução.

O simulador conta com uma interface gráfica que permite ao usuário:
- Editar, montar e visualizar o código-fonte assembly;
- Visualizar e editar arquivos objeto gerados (`.obj`);
- Realizar a ligação entre múltiplos módulos objeto, com suporte à relocação absoluta ou relocável;
- Carregar programas gerados na máquina virtual SIC/XE simulada;
- Acompanhar o estado dos registradores, memória e execução passo-a-passo.

## Pré-requisitos

- Java 17 ou superior;
- Gradle (wrapper incluso no projeto).

## Como usar?

### 1. Clonando o Repositório

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/pinhorenan/Simulador_SIC-XE.git
cd Simulador_SIC-XE
```

### 2. Compilando e Executando com Gradle Wrapper

Utilize o Gradle Wrapper incluso no projeto para compilar e executar o simulador:

- **Linux/Mac:**

```bash
./gradlew run
```

- **Windows:**

```cmd
gradlew.bat run
```

## Gerando e Executando o JAR

Se preferir gerar um JAR executável:

```bash
./gradlew jar
```

O JAR gerado estará localizado em `build/libs`. Para executá-lo, utilize:

```bash
java -jar build/libs/sicxesimulator.jar
```

## Funcionalidades Suportadas

- Processador de Macros:
  - Realiza um pre-processamento do código antes da montagem, expandindo qualquer macro definida;
  - Suporte à macros aninhadas.
- Montador SIC/XE completo:
  - Suporte às diretivas padrão: `START`, `END`, `WORD`, `BYTE`, `RESB`, `RESW`, `EXTDEF`, `EXTREF`;
  - Geração de arquivos objeto (`.obj`) estilo SIC/XE com registros `H/D/R/T/M/E`;
  - Geração de arquivo binário serializado (`.meta`) para retenção de metadados.
- Ligador (Linker) multi-módulo:
  - Realiza linkagem absoluta ou relocável entre múltiplos módulos;
  - Geração de arquivo objeto e binário na mesma estrutura do montador.
- Carregador com relocação final opcional:
  - Carrega programas objeto para memória virtual;
  - Aplica realocação pendente (quando necessária).

## Conjunto de Instruções do SIC/XE

Este simulador implementa parcialmente o conjunto de instruções SIC/XE conforme a especificação oficial, com algumas limitações de escopo educacional:

### Instruções Implementadas

- **Formato 2 (registradores):**  
  `ADDR`, `CLEAR`, `COMPR`, `DIVR`, `MULR`, `RMO`, `SHIFTL`, `SHIFTR`, `SUBR`, `TIXR`

- **Formato 3/4 (memória e imediato):**  
  `ADD`, `AND`, `COMP`, `DIV`, `J`, `JEQ`, `JGT`, `JLT`, `JSUB`, `LDA`, `LDB`, `LDCH`, `LDL`, `LDS`, `LDT`, `LDX`, `MUL`, `OR`, `RSUB`, `STA`, `STB`, `STCH`, `STL`, `STS`, `STT`, `STX`, `SUB`, `TIX`

### Instruções NÃO Implementadas (Presentes como STUB)

Por restrições do projeto, não há suporte para:

- **Formato 1 e Instruções especiais:**  
  `FIX`, `FLOAT`, `NORM`, `HIO`, `SIO`, `TIO`

- **Instruções de ponto flutuante:**  
  `ADDF`, `COMPF`, `DIVF`, `LDF`, `MULF`, `STF`, `SUBF`

- **Controle do sistema e operações I/O:**  
  `LPS`, `RD`, `SSK`, `STI`, `STSW`, `SVC`, `TD`, `WD`

Essas instruções possuem placeholders (stubs) que geram logs informativos indicando sua ausência de implementação.

## Documentação das Principais Classes

| Classe                                                                                       | Descrição                                      |
|----------------------------------------------------------------------------------------------|------------------------------------------------|
| [`ControlUnit`](src/main/java/sicxesimulator/hardware/cpu/ControlUnit.java)                  | Busca, decodifica e despacha instruções.       |
| [`InstructionDecoder`](src/main/java/sicxesimulator/hardware/cpu/InstructionDecoder.java)    | Decodifica instruções SIC/XE.                  |
| [`ExecutionUnit`](src/main/java/sicxesimulator/hardware/cpu/ExecutionUnit.java)              | Executa instruções do conjunto SIC/XE.         |
| [`MacroProcessor`](src/main/java/sicxesimulator/software/macroprocessor/MacroProcessor.java) | Expande macros definidas no código fonte.      |
| [`Assembler`](src/main/java/sicxesimulator/software/assembler/Assembler.java)                | Coordena as fases da montagem do programa.     |
| [`Linker`](src/main/java/sicxesimulator/software/linker/Linker.java)                         | Realiza a ligação de módulos objeto.           |
| [`Loader`](src/main/java/sicxesimulator/software/loader/Loader.java)                         | Realiza a carga de arquivos `.obj` na memória. |

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
