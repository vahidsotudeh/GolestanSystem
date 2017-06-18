//package ir.sbu.golestan.db.migration;
//
//import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
//import org.jooq.DSLContext;
//import org.jooq.SQLDialect;
//import org.jooq.impl.DSL;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// * Created by Ali Asghar on 15/06/2017.
// */
//public class V1__initPermissions implements SpringJdbcMigration {
//    @Override
//    public void migrate(JdbcTemplate jdbc) throws Exception {
//        DSLContext create = DSL.using(jdbc.getDataSource(), SQLDialect.H2);
//        create.select().from()
//    }
//}
