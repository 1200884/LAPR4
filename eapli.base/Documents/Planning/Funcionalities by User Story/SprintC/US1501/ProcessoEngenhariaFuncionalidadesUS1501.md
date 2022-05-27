# US1501
=======================================


# 1. Requirements

**1501** As Customer, I want to view/search the product catalog and be able to add a product to the shopping cart.

- 1004.1. Main goal: Save the items in the shopping cart until it turns to an order 

- 1004.2. Functionalities: The Customer can choose if the catalog is alphabetically organized by brand or by category.
The Customer can choose the product by its name and can choose the amount to add to the shopping cart.

- 1004.3. Dependencies: This Us has a dependencies in US1001 and mainly in the US1002.

# 2. Analysis


- 1. **Concepts**:In the beginning, when the customer chooses the option of adding products to shopping cart we ask for his VAT number for authentication purposes.Then we ask the customer if he wants the catalog to be organized by brand or category so that he can add products to the shopping Cart.

- 2. **Organization**:The code has a UI that comunicates with the User and then sents the data received for a Controller. This Controller authenticates the User and sends the data to a Service that makes the connection to our DataBase.

- 3. **Code**:In terms of optimizing the code I opted to do a loop where the customer can add multiple products without having to repeat his VAT number.I also added a functionality that searches for the product to add to the shopping Cart and if this product has already been added in the pas then iIonly add the quantity to the past quantity of this product, avoiding duplicate products in the same Shopping Cart.

# 3. Design

## 3.1. Functionalities (SSD)

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

## 3.2. Class Diagram

- This diagram can be found under Documents> Engineering Process> SprintC> US1501

## 3.3. Applied standards

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Tests
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Order com valores nulos.

	@Test
    void ensureMustHaveAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Orders(null, new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD)));
    }

    @Test
    void ensureMustHaveShoppingCart() {
        assertThrows(IllegalArgumentException.class, () -> new Orders("Rua das Flores", null, new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD)));
    }

**Teste 2:** Verificar que o Id é sempre gerado com 9 digitos.

    @Test
    void ensureIdHas9Letters() {
        Orders order = new Orders("Rua das Flores", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        Assert.assertTrue(order.getId().length()==9);
    }

# 4. Implementation

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

- When analysing the code it is possible to see how it is in accordance with the diagrams done for this US.

- Relevant commits:
  cc5e40b, a9572d8


# 5. Integration/ Documentation

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*

