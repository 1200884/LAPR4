# US1006
=======================================


# 1. Requirements

*In this US we developed the option to change the status of a order from dispatched do customer delivery to delivered.*

**1001** As Sales Clerk, I want to access a list of orders that had been dispatched for customer delivery and be able to update some of those orders to as being delivered. .

- 1001.1. Main goal: Update the Status of a order

- 1001.2. Functionalities: Update

- 1001.3. Dependencies: It depends of the Order Status that was defined previously as "Unassigned, Assigned, Dispached, Delivered" and could be accessed in the state machine.
# 2. Analysis

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

*Recomenda-se que organize este conteúdo por subsecções.*

- 1. Concepts: There was a need to use UIs, Controllers, Services, Persist, Repositories and the class of the Order itself

- 2. Organization: The UI was responsible to gather and display information from/to the user, the Controller was an intermediary between the UI and the Service classes, the latest was responsible for the creation of the Product and the Persist class was made for saving the Product in the database using the repository

- 3. Code: The code was made in the simplest way possible for the exception of some methods to display the available status.

# 3. Design

## 3.1. Functionalities (SSD)

*Nesta secção deve apresentar e descrever o fluxo/sequência que permite realizar a funcionalidade.*

## 3.2. Class Diagram

*Nesta secção deve apresentar e descrever as principais classes envolvidas na realização da funcionalidade.*

## 3.3. Applied standards

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Tests 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*


    @Test
    void updateOrderToDelivered() {
        Orders orders=new Orders("Rua 5 de outubro",new Shopping_Cart(1234568789),new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS),new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        orders.setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orders.setOrderLevel(new OrderLevel(OrderLevel.Level.DELIVERED));
        assertEquals(orders.getOrderLevel().getLevel(),OrderLevel.Level.DELIVERED);
        assertNotEquals(orders.getOrderLevel().getLevel(), OrderLevel.Level.DISPATCHED);
    }

# 4. Implementation

- The code was made according to Order Status
- The most relevant commit were done by 1200884


# 5. Integration/ Documentation

- There was integration with the Category and Order classes

# 6. Observations

- No relevant observations
