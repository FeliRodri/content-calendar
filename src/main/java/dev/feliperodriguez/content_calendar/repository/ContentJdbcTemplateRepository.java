package dev.feliperodriguez.content_calendar.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
    // return new Content(rs.getInt(columnLabel:"id"),
    // rs.getString(columnLabel:"title"),
    // rs.getString(columnLabel:"desc"),
    // rs.getString(columnLabel:"status"),
    // rs.get
    // );
}
