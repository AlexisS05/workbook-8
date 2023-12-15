package org.sakila.data;

import org.sakila.model.Actor;
import org.sakila.model.Film;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.sakila.Main.getSakilaDataSource;

public class SakilaDAOMySQLImpl {
    private DataSource dataSource;
    private Connection connection;

//    public SakilaDAOMySQLImpl(DataSource dataSource){
//        this.dataSource = dataSource;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Actor> getFirstNameActors(String firstName){
        List<Actor> actors = new ArrayList<>();

        String sql = """ 
                SELECT * FROM actor AS a
                WHERE a.first_name = ?;
                """;
        try (
                Connection connection = getSakilaDataSource().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, firstName);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    actors.add(new Actor(
                            resultSet.getInt("actor_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }


    public void insertActorToDB(String firstName, String lastName){
        String sql = """
                INSERT INTO actor (first_name, last_name) values (?, ?);
                """;
        try(Connection connection = getSakilaDataSource().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);)
        {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            new Actor(1, firstName, lastName);
            int row = ps.executeUpdate();
            System.out.printf("Row updated %s \n", row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
