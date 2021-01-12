package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvUtils {
    private static final CsvMapper mapper = new CsvMapper();
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {

//    	CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
    	CsvSchema schema = mapper
    			.schemaFor(clazz)
    			.withHeader()
    			.sortedBy("c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "c11", "c12", "c13", "c14", "c15", "c16", "c17", "c18", "c19", "c20", "c21", "c22", "c23", "c24", "c25", "c26", "c27", "c28", "c29", "c30", "c31", "c32", "c33", "c34", "c35", "c36", "c37", "c38", "c39", "c40", "c41", "c42", "c43", "c44", "c45", "c46", "c47", "c48", "c49", "c50", "c51", "c52", "c53", "c54", "c55", "c56", "c57", "c58")
    			.withColumnSeparator(',');
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(new InputStreamReader(stream, "Shift_JIS")).readAll();
    }
}