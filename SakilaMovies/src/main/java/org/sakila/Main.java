package org.sakila;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name of an actor: ");
        String firstname = scanner.nextLine();

//        getFirstName(firstname);

        System.out.println("Please enter the last name of an actor:" );
        String lastname = scanner.nextLine();

        getActorFilms(firstname, lastname);

    }

    private static void getFirstName(String firstname) {
        String sql = """ 
                SELECT * FROM actor AS a
                WHERE a.first_name = ?;
                """;
        try (
                Connection connection = getSakilaDataSource().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, firstname);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                System.out.printf(
                        "first_name = %s, last_name= %s \n",
                        res.getString("first_name"),
                        res.getString("last_name")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getActorFilms(String firstname, String lastname) {
        String sql = """
                 SELECT title, first_name, last_name
                 FROM film AS f
                 JOIN film_actor AS fa ON f.film_id = fa.film_id
                 JOIN actor AS a ON fa.actor_id = a.actor_id
                 WHERE first_name = ? AND last_name = ?;
                """;
        try (Connection connection = getSakilaDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){
                System.out.printf(
                        "title = %s, first_name = %s, last_name = %s; \n",
                        res.getString(1),
                        res.getString(2),
                        res.getString(3)
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static BasicDataSource getSakilaDataSource() {
        BasicDataSource dataSource;
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("passwordlucky");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
}