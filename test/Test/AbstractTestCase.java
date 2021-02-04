/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author The Crush
 */
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

public class AbstractTestCase {

    public void execute(Operation operation) {
        try {
            DbSetup dbSetup = new DbSetup(
                    new DriverManagerDestination(
                            "jdbc:postgresql://localhost:5432/RegistrationManagement",
                            "postgres", "12"), operation);
            dbSetup.launch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
