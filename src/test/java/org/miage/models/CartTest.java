package org.miage.models;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        product1 = new Product("Produit 1", 10.0, 2);
        product2 = new Product("Produit 2", 20.0, 2);
    }

    @Test
    public void testGetCartMap() {
        assertNotNull(cart.getCartMap());
        assertTrue(cart.getCartMap().isEmpty());
    }

    @Test
    public void testAdd() {
        cart.add(product1, 2);
        assertEquals(1, cart.size());
        assertTrue(cart.getCartMap().containsKey(product1));
        assertEquals(Integer.valueOf(2), cart.getCartMap().get(product1));

        cart.add(product1, 3);
        assertEquals(Integer.valueOf(5), cart.getCartMap().get(product1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidProduct() {
        cart.add(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidQuantity() {
        cart.add(product1, -1);
    }

    @Test
    public void testRemove() {
        cart.add(product1, 5);
        cart.add(product2, 3);

        cart.remove(product1, 2);
        assertEquals(Integer.valueOf(3), cart.getCartMap().get(product1));

        cart.remove(product1, 3);
        assertFalse(cart.getCartMap().containsKey(product1));

        cart.remove(product1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveInvalidProduct() {
        cart.remove(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveInvalidQuantity() {
        cart.remove(product1, -1);
    }

    @Test
    public void testSize() {
        // Test de la taille du panier
        assertEquals(0, cart.size());

        cart.add(product1, 1);
        assertEquals(1, cart.size());

        cart.add(product2, 2);
        assertEquals(2, cart.size());
    }

    @Test
    public void testToString() {
        assertEquals("Contenu du panier :\n-- Vide --\n", cart.toString());

        cart.add(product1, 1);
        String expected = "Contenu du panier :\nProduit (0) : Produit 1, Quantité : 1\n";
        assertEquals(expected, cart.toString());

        cart.add(product2, 2);
        expected = "Contenu du panier :\nProduit (0) : Produit 1, Quantité : 1\nProduit (1) : Produit 2, Quantité : 2\n";
        assertEquals(expected, cart.toString());
    }

    @Test
    public void testClear() {
        cart.add(product1, 1);
        cart.add(product2, 2);

        assertEquals(2, cart.size());
        cart.clear();
        assertEquals(0, cart.size());
        assertTrue(cart.getCartMap().isEmpty());
    }

    @Test
    public void testGetProductByIndex() {
        cart.add(product1, 1);
        cart.add(product2, 2);

        assertEquals(product1, cart.getProductByIndex(0));
        assertEquals(product2, cart.getProductByIndex(1));

        assertNull(cart.getProductByIndex(2));
    }
}
