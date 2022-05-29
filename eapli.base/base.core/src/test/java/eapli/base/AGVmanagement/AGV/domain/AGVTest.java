package eapli.base.AGVmanagement.AGV.domain;

import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AGVTest {

    @Test
    void numberoftasks() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        assertNotEquals(2, agv.numberoftasks());
        assertEquals(1,agv.numberoftasks());
    }

    @Test
    void getagvtasks() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        agv.addTask("123456789");
        Set<String> arrayList=new HashSet();
        Set<String> emptyList=new HashSet<>();
        arrayList.add("null");
        arrayList.add("123456789");
        assertEquals(arrayList,agv.getagvtasks());
        assertNotEquals(emptyList,agv.getagvtasks());
    }

    @Test
    void hasOrder() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        agv.addTask("123456789");
        assertTrue(agv.hasOrder("123456789"));
        assertFalse(agv.hasOrder("987654321"));
    }

    @Test
    void addTask() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        agv.addTask("123456789");
        assertNotEquals(1, agv.numberoftasks());
        assertEquals(2,agv.numberoftasks());
    }

    @Test
    void removeTask() {
        AGV agv=new AGV(1,"base location","very good agv", new Model("best model","ever"),new Status(2,"null"));
        agv.addTask("123456789");
        agv.removeTask("123456789");
        assertNotEquals(2, agv.numberoftasks());
        assertEquals(1,agv.numberoftasks());
    }

    @Test
    void randomiselocation() {
        assertNotEquals(41,AGV.randomiselocation());
    }
}