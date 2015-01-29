package com.zanclus.lombok.test;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import lombok.val;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:aname", "sa", "");
        DSLContext create = DSL.using(conn, SQLDialect.HSQLDB);
        val result = create.select(
                                DSL.val("one"), 
                                DSL.val("two"), 
                                DSL.val("three"), 
                                DSL.val("four"), 
                                DSL.val("five"), 
                                DSL.val("six"), 
                                DSL.val(7), 
                                DSL.val(8L), 
                                DSL.val("nine"), 
                                DSL.val("ten"), 
                                DSL.val("eleven"), 
                                DSL.val("twelve"), 
                                DSL.val("thirteen"), 
                                DSL.val("fourteen"), 
                                DSL.val("fifteen"))
                            .from("INFORMATION_SCHEMA.TABLES")
                            .limit(1)
                            .fetch();
        System.out.println("Done: "+result.getClass().getCanonicalName());        
    }
}
