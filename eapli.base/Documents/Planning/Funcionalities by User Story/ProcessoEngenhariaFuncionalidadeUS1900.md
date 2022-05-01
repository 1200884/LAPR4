# US1900
=======================================


# 1. Requirements

*Nesta secção a equipa deve indicar a funcionalidade desenvolvida bem como descrever a sua interpretação sobre a mesma e sua correlação e/ou dependência de/com outros requisitos.*

**1900** As Project Manager, I intend that, for demonstration purposes, the system has the possibility of being initialized (bootstrap) with some information related to the product catalog and auxiliary information.

- 1900.1. Main goal: Have a system that always has information to show. 

- 1900.2. Functionalities: For example created products, categories and brands should persist in the system.

- 1900.3. Dependencies: More than what this part of the project is dependent on, it is more relavant to highlight how much the project is dependent on it. This US allows us to have information on the catalog each time the system is initialized.

# 2. Analysis

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

*Recomenda-se que organize este conteúdo por subsecções.*

- 1. Concepts: 

- 2. Organization: There was some confusion on how to integrate everythng needed with the base project, in terms of which packages to use for certain parts. 

- 3. Code: 

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

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

- When analysing the code it is possible to see how it is in accordance with the diagrams done for this US.

- Other files worth mentioning: files related with persistance

- Relevant commits:


# 5. Integration/ Documentation

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*

