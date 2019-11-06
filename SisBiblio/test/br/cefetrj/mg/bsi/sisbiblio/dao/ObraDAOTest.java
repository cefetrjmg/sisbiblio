/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristian
 */
public class ObraDAOTest {
    
    public ObraDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class ObraDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Object o = null;
        ObraDAO instance = new ObraDAO();
        boolean expResult = false;
        boolean result = instance.inserir(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class ObraDAO.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Object o = null;
        ObraDAO instance = new ObraDAO();
        boolean expResult = false;
        boolean result = instance.atualizar(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ObraDAO.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Object o = null;
        ObraDAO instance = new ObraDAO();
        boolean expResult = false;
        boolean result = instance.excluir(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ObraDAO.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object o = null;
        ObraDAO instance = new ObraDAO();
        Object expResult = null;
        Object result = instance.buscar(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ObraDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ObraDAO instance = new ObraDAO();
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPos method, of class ObraDAO.
     */
    @Test
    public void testGetPos() {
        System.out.println("getPos");
        Object o = null;
        ObraDAO instance = new ObraDAO();
        int expResult = 0;
        int result = instance.getPos(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastId method, of class ObraDAO.
     */
    @Test
    public void testGetLastId() {
        System.out.println("getLastId");
        ObraDAO instance = new ObraDAO();
        int expResult = 0;
        int result = instance.getLastId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
