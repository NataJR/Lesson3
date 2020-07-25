package com.example.geekbrainsdb.repository;

import com.example.geekbrainsdb.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserRepo {
    public void printAllInformation(JdbcTemplate jdbcTemplate) {
        List<User> users = jdbcTemplate.query(
                "SELECT * FROM Users",
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));

        System.out.println("PRINT ALL INFORMATION");
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    public void printInformationByAge(JdbcTemplate jdbcTemplate, int min, int max) {
        List<User> users = jdbcTemplate.query(
                "SELECT * FROM Users WHERE age > ? AND age < ?",
                new Object[] { min, max },
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));

        System.out.println("PRINT ALL BETWEEN " + min + " AND " + max);
        for (User user: users) {
            System.out.println(user.toString());
        }

    }

    public void printMinMaxAge(JdbcTemplate jdbcTemplate) {
        List<Integer> min = jdbcTemplate.query(
                "SELECT MIN(age) as minimumAge FROM Users",
                (rs, rowNum) -> rs.getInt("minimumAge")
        );

        System.out.println("Minimum Age" + min.get(0));

        String sql = "SELECT MAX(age) as maximumAge FROM Users";
        List<Integer> max = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getInt("maximumAge")
        );

        System.out.println("Maximum Age" + max.get(0));
    }

    public void deleteUser(JdbcTemplate jdbcTemplate, String name) {
        String sql = "DELETE FROM Users WHERE name = ?";
        Object[] args = new Object[] { name };

        jdbcTemplate.update(sql, args);
    }

    public void addUSer(JdbcTemplate jdbcTemplate, String line) {
        String[] splitted = line.split(" ");
        String name = splitted[0];
        int age = Integer.parseInt(splitted[1]);
        String email = splitted[2];

        String sql = "INSERT INTO Users (name, age, email) VALUES (?,?,?)";
        Object[] args = new Object[] { name, age, email };
        jdbcTemplate.update(sql, args);
    }
}
