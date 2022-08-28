package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class NewTableApp {

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";

        // SQL statement for creating a new table
        /*
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        */

        /*
        String sql = "CREATE TABLE IF NOT EXISTS materials (\n"
                + " id integer PRIMARY KEY,\n"
                + " description text NOT NULL\n"
                + ");";
        */

        // String sql = "ALTER TABLE materials ADD COLUMN picture blob;\n";


        String sql = "CREATE TABLE IF NOT EXISTS inventory (\n"
                + " warehouse_id integer,\n"
                + " material_id integer,\n"
                + " qty real,\n"
                + " PRIMARY KEY (warehouse_id, material_id),\n"
                + " FOREIGN KEY (warehouse_id) REFERENCES warehouses (id),\n"
                + " FOREIGN KEY (material_id) REFERENCES materials (id)\n"
                + ");";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}