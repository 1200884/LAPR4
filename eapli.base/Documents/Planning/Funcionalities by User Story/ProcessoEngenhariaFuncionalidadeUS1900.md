# US1900
=======================================


# 1. Requirements

**1900** As Project Manager, I intend that, for demonstration purposes, the system has the possibility of being initialized (bootstrap) with some information related to the product catalog and auxiliary information.

- 1900.1. Main goal: Have a system that always has information to show. 

- 1900.2. Functionalities: For example created products, categories and brands should persist in the system.

- 1900.3. Dependencies: More than what this part of the project is dependent on, it is more relavant to highlight how much the project is dependent on it. This US allows us to have information on the catalog each time the system is initialized.

# 2. Analysis
- 1. Concepts: 

- 2. Organization: There was some confusion on how to integrate everythng needed with the base project, in terms of which packages to use for certain parts. 

- 3. Code: 

# 3. Design

## 3.1. Applied standards

*This US does not have diagrams.*

## 3.2. Tests 

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

