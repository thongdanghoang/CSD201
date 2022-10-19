/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */

/**
 *
 * @author thong
 */
public class PersistenceUnitInstance {
    
    private PersistenceUnitInstance() {
    }
    
    public static PersistenceUnitInstance getInstance() {
        return PersistenceUnitInstanceHolder.INSTANCE;
    }
    
    private static class PersistenceUnitInstanceHolder {

        private static final PersistenceUnitInstance INSTANCE = new PersistenceUnitInstance();
    }
}
