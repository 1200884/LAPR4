# US2002
=======================================


# 1. Requirements

*Nesta secção a equipa deve indicar a funcionalidade desenvolvida bem como descrever a sua interpretação sobre a mesma e sua correlação e/ou dependência de/com outros requisitos.*

**2002** As Warehouse Employee, I want to configure the AGVs available on the warehouse.

- 2002.1. Main goal: The main goal of this US was to create an AGV as an warehouse employee

- 2002.2. Functionalities: The AGV is available to be configured by choosing one of the available models

- 2002.3. Dependencies: It doesn't depend on any other US

# 2. Analysis

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

*Recomenda-se que organize este conteúdo por subsecções.*

- 1. Concepts: There was a need to use UIs, Controllers, Services, Persist, Repositories and the class of the AGV itself

- 2. Organization: The UI was responsible to gather and display information from/to the user, the Controller was an intermediary between the UI and the Service classes, the latest was responsible for the creation of the AGV and the Persist class was made for saving the AGV in the database using the repository

- 3. Code: The code was made in the simplest way possible for the exception of some methods to display the available categories and brands that were needed to be made with some duplications

# 3. Design

## 3.1. Functionalities (SSD)

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

## 3.2. Class Diagram

*Nesta secção deve apresentar e descrever as principais classes envolvidas na realização da funcionalidade.*

## 3.3. Applied standards

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Tests 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementation

- The code was made according to the SSD and according to the Domain Model
- The most relevant commit were done by 1200876


# 5. Integration/ Documentation

- There was integration with the Model class for the AGV to be created

# 6. Observations

- The US was made according to the examples of the eCafeteria project and help was used from the TP slides
