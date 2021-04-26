package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Moderator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ModeratorRepositoryImpl implements ModeratorRepository{

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Moderator getModeratorById(long id) {
        String getByIdQuery="select id,administrator_id from moderator";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id), new ModeratorMapper());
    }

    @Override
    public void insertModerator(Moderator moderator) {
        String insertQuery="insert into moderator(administrator_id) values(?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,moderator.getAdministrator_id());
    }

    @Override
    public void updateModerator(Moderator moderator) {
        String updateQuery="update moderator set administrator_id=:administrator_id where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("administrator_id",moderator.getAdministrator_id()).
                addValue("id",moderator.getId());
        namedParameterJdbcOperations.update(updateQuery,params);
    }

    @Override
    public void deleteModerator(long id) {
        String deleteQuery="delete from moderator where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class ModeratorMapper implements RowMapper<Moderator> {

        @Override
        public Moderator mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Moderator(resultSet.getLong("id"), resultSet.getLong("administrator_id"));
        }
    }
}
