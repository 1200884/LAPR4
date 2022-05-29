# US1501
=======================================


# 1. Requirements

**3001** As Sales Manager, I want to create a new questionnaire to be further answered by customers meeting the specified criteria.

- 1. Main goal: Create a questionnaire

- 2. Functionalities: The questionnaire has multiple types of questions and sections.

- 3. Dependencies: This user story depends on US3000.

# 2. Analysis

- 1. **Concepts**: The most important concepts are related to ANTLR.

- 2. **Organization**: Following the ANTLR tutorial, it was generated ANTLR recognizer, a java class called calc and onr called EvalVisitor.

- 3. **Code**: After having it all running, the US was integrated with the main menu of the project.

# 3. Design

## 3.1. Functionalities (SSD)

![US3001_SSD.svg](US3001_SSD.svg)

## 3.2. Class Diagram

![US3001_CD.svg](US3001_CD.svg)

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

