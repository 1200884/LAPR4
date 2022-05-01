# US1002
=======================================


# 1. requirements

*Nesta secção a equipa deve indicar a funcionalidade desenvolvida bem como descrever a sua interpretação sobre a mesma e sua correlação e/ou dependência de/com outros requisitos.*

**1002** As Sales Clerk, I want to view/search the products catalog.

- 1002.1. As with any catalog the main goal was to present a list witth all products

- 1002.2. There is an added functionality which is a filter of whether the user wants it organized by brand or category

- 1002.3. This US is closely related with US1001 as they are both using the product

# 2. Analysis

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

*Recomenda-se que organize este conteúdo por subsecções.*

- 1. Concepts: The first thing was understanding the structure of the code, so it was needed a study of DTOs, Iterables and much more concepts related to this ones

- 2. Organization: There were some especially helpful documents in moodle regarding the organization 

- 3. Code: The parallel example of Dishes in the eCafetaria combined with already aquired knowlegde was key.

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

# 5. Integration/ Documentation

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

- There were efforts to integrate into the main ui, and there was some connections to other objects, such as Category and Brand.

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*

- In this US there was some thought put in on whether or not it shoulfd be used DTOs, whoever with further study on the example Ecafetaria we opted against the use of them.

- When refering to the filters available as it was a catalog there is no constraint filter but organizational ones, this way all products are always shown.


