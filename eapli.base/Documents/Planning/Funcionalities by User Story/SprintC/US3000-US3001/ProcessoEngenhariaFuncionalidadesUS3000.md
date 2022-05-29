# US1501
=======================================


# 1. Requirements

**3000** As Project Manager, I want the team to specify a grammar allowing to express several kinds of questionnaires.

- 1. Main goal: Create a grammar for a questionnaire

- 2. Functionalities: The questionnaire has multiple sections each one with multiple questions.

- 3. Dependencies: This user story has no dependencies.

# 2. Analysis

- 1. **Concepts**: The concepts related to this US are from LPROG, including concepts such as tokens, grammar etc.

- 2. **Organization**: Following the ANTLR tutorial, at this time it was only required to have a .g4 file.

- 3. **Code**: When doing the grammar it was prioritized its reusability/applicability on other application domains than the one of this project.

# 3. Design

## 3.1. Functionalities (SSD)

![US3000_SSD.svg](US3000_SSD.svg)

## 3.2. Class Diagram

![US3000_CD.svg](US3000_CD.svg)

## 3.3. Applied standards

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design 
aplicados e as melhores práticas.*

## 3.4. Tests
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*
- The grammar was tested with a txt. file, following the structure of the questionnaire.

# 4. Implementation

- The txt. file called "teste" is a important file as it is the questionnaire in accordance with the grammar.
- Relevant commit: 6465dd6

# 5. Integration/ Documentation

- It was created a sales clerk and the ui was integrated with the main ui.

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*

