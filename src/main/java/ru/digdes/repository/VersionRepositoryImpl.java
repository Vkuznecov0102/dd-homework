package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Version;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class VersionRepositoryImpl implements VersionRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Version getVersionById(long id) {
        String getByIdQuery="select id,document_id from version where id=:id";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id),new VersionMapper());
    }

    @Override
    public void insertVersion(Version version) {
        String insertQuery="insert into version(document_id) values(?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,version.getDocument_id());
    }

    @Override
    public void updateVersion(Version version) {
        String updateQuery="update version set document_id=:document_id where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("document_id",version.getDocument_id()).
                addValue("id",version.getId());
        namedParameterJdbcOperations.getJdbcOperations().update(updateQuery,params);
    }

    @Override
    public void deleteVersion(long id) {
        String deleteQuery="delete from version where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class VersionMapper implements RowMapper<Version> {

        @Override
        public Version mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Version(resultSet.getLong("id"),resultSet.getLong("document_id"));
        }
    }
}
