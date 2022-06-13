# US2003
=======================================


# 1. Requirements

**2003** Assign tasks to agvs

- 2003.1 Main goal: Give tasks to the agvs

- 1004.2. Functionalities: The User can choose which tasks he wants to assign, he can only choose unassigned tasks.

- 1004.3. Dependencies: This Us has no dependencies.

# 2. Analysis


- 1. **Concepts**:In the beginning the user sees which tasks are unassigned and chooses which ones he wants to assign.

- 2. **Organization**:The code has a UI that allows the user to choose and have presented the id of the order that allows him to choose

- 3. **Code**:This US has methods to choose the agv (to assign the task) with the criteria of being the one with less tasks, so that every agv available has more or less the same tasks.
# 3. Design

## 3.1. Functionalities (SSD)
In documents folder

## 3.3. Applied standards

The agv chosen to be the one with the tasks is the agv with less tasks

## 3.4. Tests
 @Test
    void hasOrder() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        agv.addTask("123456789");
        assertTrue(agv.hasOrder("123456789"));
        assertFalse(agv.hasOrder("987654321"));
    }
# 4. Implementation

In order to check if this works, its necessary to run the project source code, and log in as warehouse employee. Then choose a id from the unassigned orders and assign it. Then, check the unassigned orders id again and it will not be there as it is not unassigned anymore.

# 5. Integration/ Documentation

This US is divided in 2 options in the UI as it makes it easier to know if it works or not (option 4 and 5 of the warehouse employee menu).

# 6. Observations

This US is functional, although when the agvs are with many tasks, the tasks can be presented with the order swaped

