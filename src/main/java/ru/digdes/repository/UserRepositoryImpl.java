package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public User getUserById(long id) {
        String getByIdQuery="select id,login,password,document_id from user where id=:id";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id), new UserMapper());
    }

    @Override
    public void insertUser(User user) {
        String insertQuery="insert into user(login,password,document_id) values(?,?,?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,user.getLogin(),user.getPassword(),user.getDocument_id());
    }

    @Override
    public void updateUserByPassword(User user) {
        String updateQuery="update user set password=:password where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("password",user.getPassword()).addValue("id",user.getId());
        namedParameterJdbcOperations.update(updateQuery,params);
    }

    @Override
    public void updateUserByLogin(User user) {
        String updateQuery="update user set login=:login where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("password",user.getLogin()).addValue("id",user.getId());
        namedParameterJdbcOperations.update(updateQuery,params);
    }

    @Override
    public void deleteUser(long id) {
        String deleteQuery="delete from user where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("id"),resultSet.getString("login"),
                    resultSet.getString("password"),resultSet.getLong("document_id"));
        }
    }
}
