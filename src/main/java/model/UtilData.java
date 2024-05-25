package model;

import com.google.protobuf.TextFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class UtilData {

    public static Date dataAtual() {
        LocalDate hoje = LocalDate.now();
        return Date.valueOf(hoje);
    }

    public static Date stringParaDateSQL(String dataString) throws TextFormat.ParseException, java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataUtil = formato.parse(dataString);
        return new Date(dataUtil.getTime());
    }

}