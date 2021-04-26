package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Administrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class AdministratorRepositoryImpl implements AdministratorRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;


    @Override
    public Administrator getAdministratorById(long id) {
        String getByIdQuery= "select id, user_id,moderator_id where id= :id";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id), new AdministratorMapper());
    }

    @Override
    public void insertAdministrator(Administrator administrator) {
        String insertQuery="insert into administrator(user_id,moderator_id) values(?,?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,administrator.getUser_id(),administrator.getModerator_id());
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        String updateQuery = "update administrator set user_id=:user_id where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("user_id",administrator.getUser_id()).addValue("id",administrator.getId());
        namedParameterJdbcOperations.update(updateQuery,params);
    }

    @Override
    public void deleteAdministrator(long id) {
        String deleteQuery="delete from administrator where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class AdministratorMapper implements RowMapper<Administrator> {

        @Override
        public Administrator mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Administrator(resultSet.getLong("id"),resultSet.getLong("user_id"),
                    resultSet.getLong("moderator_id"));
        }
    }
}
