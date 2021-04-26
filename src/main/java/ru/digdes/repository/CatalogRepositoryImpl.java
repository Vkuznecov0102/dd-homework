package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class CatalogRepositoryImpl implements CatalogRepository{

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Catalog getCatalogById(long id) {
        String getByIdQuery="select id,name,typeofview from catalog where id=:id";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id),new CatalogMapper());
    }

    @Override
    public void insertCatalog(Catalog catalog) {
        String insertQuery="insert into catalog(name,typeofview) values (?,?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,catalog.getName(),catalog.getTypeOfView());
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        String updateQuery="update catalog set name= :name where id=:id";
        SqlParameterSource params=new MapSqlParameterSource().addValue("name",catalog.getName()).addValue("id",catalog.getId());
        namedParameterJdbcOperations.update(updateQuery, params);
    }

    @Override
    public void deleteCatalog(long id) {
        String deleteQuery="delete from catalog where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class CatalogMapper implements RowMapper<Catalog> {

        @Override
        public Catalog mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Catalog(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getString("typeOfView"));
        }
    }
}
