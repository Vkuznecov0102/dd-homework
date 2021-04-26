package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class DocumentRepositoryImpl implements DocumentRepository{

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Document getDocumentById(long id) {
        String getByIdQuery="select id,name,priority,version_id,catalog_id from document where id=:id";
        return namedParameterJdbcOperations.queryForObject(getByIdQuery, Map.of("id",id), new DocumentMapper());
    }

    @Override
    public void insertDocument(Document document) {
        String insertQuery="insert into document(name,priority,version_id,catalog_id) values(?,?,?,?)";
        namedParameterJdbcOperations.getJdbcOperations().update(insertQuery,document.getName(),document.getPriority(),
                document.getVersion_id(),document.getCatalog_id());

    }

    @Override
    public void updateDocument(Document document) {
        String updateQuery="update document set name=:name where id=:id";
        SqlParameterSource params= new MapSqlParameterSource().addValue("name",document.getName()).addValue("id",document.getId());
        namedParameterJdbcOperations.update(updateQuery, params);
    }

    @Override
    public void deleteDocument(long id) {
        String deleteQuery="delete from document where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        namedParameterJdbcOperations.update(deleteQuery,namedParameters);
    }

    private static class DocumentMapper implements RowMapper<Document> {

        @Override
        public Document mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Document(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getString("priority"), resultSet.getLong("version_id"),
                    resultSet.getLong("catalog_id"));
        }
    }
}
